package com.example.pirate99_final.review.service;

import com.example.pirate99_final.global.MsgResponseDto;
import com.example.pirate99_final.global.exception.CustomException;
import com.example.pirate99_final.global.exception.ErrorCode;
import com.example.pirate99_final.review.dto.ReviewRequestDto;
import com.example.pirate99_final.review.dto.ReviewResponseDto;
import com.example.pirate99_final.review.repository.ReviewRepository;
import com.example.pirate99_final.store.entity.Store;
import com.example.pirate99_final.store.repository.StoreRepository;
import com.example.pirate99_final.user.entity.User;
import com.example.pirate99_final.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.example.pirate99_final.global.exception.SuccessCode.CREATE_REVIEW;
import static com.example.pirate99_final.global.exception.SuccessCode.DELETE_REVIEW;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RedisTemplate<String, ReviewRequestDto> redisTemplate;

    // Review Insert (Insert to Redis)
    @Transactional
    public MsgResponseDto createReview(long id, ReviewRequestDto requestDto) {

        SetOperations<String, ReviewRequestDto> setOperations = redisTemplate.opsForSet();

        Store store = storeRepository.findById(id).orElseThrow(()->
        new CustomException(ErrorCode.NOT_FOUND_STORE_ERROR)
        );

        User user = userRepository.findByUsername(requestDto.getUsername()).orElseThrow(()->
                new CustomException(ErrorCode.NOT_FOUND_USER_ERROR)
        );

        ReviewRequestDto savedData = ReviewRequestDto.createReviewMessageSaveDto(requestDto, store, user);

        setOperations.add("reviewIdx",savedData);

        return new MsgResponseDto(CREATE_REVIEW);
    }

    // Get memos from DB (all)
    public List<ReviewResponseDto> getReviews(long id) {

        Store store = storeRepository.findById(id).orElseThrow(()
                -> new CustomException(ErrorCode.NOT_FOUND_STORE_ERROR)
        );

        // 1. Select All Memo
        List<com.example.pirate99_final.review.entity.Review> ListReview = reviewRepository.findTop10ByStoreOrderByIdDesc(store);

        List<ReviewResponseDto> ListResponseDto = new ArrayList<>();

        for(com.example.pirate99_final.review.entity.Review review : ListReview){
            ListResponseDto.add(new ReviewResponseDto(review));
        }
        return ListResponseDto;
    }

    // Get store from DB (one)
    public ReviewResponseDto getReview(long storeId, long reviewId){
        com.example.pirate99_final.review.entity.Review review = reviewRepository.findById(storeId).orElseThrow(()->
                new CustomException(ErrorCode.NOT_FOUND_REVIEW_ERROR)
        );

        ReviewResponseDto responseDto = new ReviewResponseDto(review);
        return responseDto;
    }

    // DB update function
    @Transactional
    public ReviewResponseDto update(Long storeId, Long reviewid, ReviewRequestDto requestDto) {

        Store store = storeRepository.findById(storeId).orElseThrow(()->
                new CustomException(ErrorCode.NOT_FOUND_STORE_ERROR)
        );

        com.example.pirate99_final.review.entity.Review review = reviewRepository.findByStoreAndId(store, reviewid).orElseThrow(                                             // find memo
                () -> new CustomException(ErrorCode.NOT_FOUND_REVIEW_ERROR)
        );

        review.update(requestDto);
        return new ReviewResponseDto(review);
    }


    // DB delete function (data delete)
    public MsgResponseDto deleteReview(Long storeId, Long reviewid) {

        com.example.pirate99_final.review.entity.Review review  = reviewRepository.findById(storeId).orElseThrow(                                             // find memo
                () -> new CustomException(ErrorCode.NOT_FOUND_ID_ERROR)
        );
        reviewRepository.deleteById(storeId);                                                          // 해당 게시물 삭제

        return  new MsgResponseDto(DELETE_REVIEW);
    }
}
