package com.example.pirate99_final.map.repository;

import com.example.pirate99_final.map.entity.Naver;

import java.util.List;

public interface NaverRepositoryCustom {
    List<Naver> findByStoreName(String storeName);                  // 가게명 일치 여부

    List<Naver> findByStoreNameInclude(String storeName);           // 가게명 포함 여부 (가게명의 일부 일치)

    List<Naver> findByroadAddressInclude(String roadNameAddress);   // 도로명주소 포함 여부 (도로명주소의 일부 일치)

    List<Naver> findByBusiness(String typeOfBusiness);              // 업종별 분류

    List<Naver> OrderByStarScore();                                 // 평점 오름차순

    List<Naver> OrderByStarScoreDESC();                             // 평점 내림차순

    List<Naver> OrderByReview();                                    // 리뷰 갯수 오름차순

    List<Naver> OrderByReviewDESC();                                // 리뷰 갯수 내림차순

    List<Naver> BetweenStarScoreHigh(double score);                 // 평점 4점 이상

    List<Naver> BetweenStarScoreLow(double score);                  // 평점 1점 이하

    List<Naver> BetweenReviewHigh(int review);                      // 리뷰 1000개 이상

    List<Naver> BetweenReviewLow(int review);                       // 리뷰 10개 이하
}
