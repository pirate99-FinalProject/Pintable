package com.example.pirate99_final.review.entity;

import com.example.pirate99_final.review.dto.ReviewRequestDto;
import com.example.pirate99_final.review.dto.ReviewResponseDto;
import com.example.pirate99_final.store.entity.Store;
import com.example.pirate99_final.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private double starScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeid", nullable = false)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    private User user;


    public Review(ReviewRequestDto requestDto, Store store, User user){
        this.content    =   requestDto.getContent();
        this.starScore  =   requestDto.getStarScore();
        this.store      =   store;
        this.user       =   user;
    }

    public void update(ReviewRequestDto requestDto){
        this.content = requestDto.getContent();
        this.starScore = requestDto.getStarScore();
    }

    public static Review of(ReviewRequestDto requestDto, Store store, User user){
        return Review.builder()
                .content(requestDto.getContent())
                .starScore(requestDto.getStarScore())
                .store(store)
                .user(user)
                .build();
    }
}
