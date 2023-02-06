
![image](https://user-images.githubusercontent.com/117708164/216932548-af5766aa-a9a5-4d02-ba3f-49467c3fb956.png)

# PIN Table 🍽
### Pin-Table은, 대용량 위치 데이터를 활용한 위치 검색과 스토어 웨이팅 신청을 제공하는 서비스 입니다.

- 위치 데이터를 활용한 장소 위치 검색을 할 수 있어요 🙆🏻
- 가고싶은 식당을 검색하고, 현재 웨이팅 현황 및 웨이팅 신청을 할 수 있어요 ❗️


## 📍 Index

1. [프로젝트 소개](#1-프로젝트-소개-)
2. [기술 스택](#2-기술-스택-)
3. [기능 명세](#3-기능-명세-)
4. [시연 영상](#4-시연영상-)
5. [서비스 아키텍처](#5-서비스-아키텍처-)
6. [ERD](#6-erd-)
7. [API](#7-api-)
#

## 1. 프로젝트 소개 📢
- 설명 : Challenge Team3 | Pin-Table 프로젝트
- 기간 : 2022.12.30 ~ 2022.02.09
- 팀원 : <br>

| - | NAME | GITHUB |
|--|--|--|
| BE | 김규리 | https://github.com/kyuung09 |
| BE | 이상훈 | https://github.com/leemeo3  |
| BE | 신승호 | https://github.com/hongdangmoo49 |
| BE | 황지성 | https://github.com/developjisung |

#

## 2. 기술 스택 🔨
<div align=center> 
<img src="https://img.shields.io/badge/java-02569B?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
<img src="https://img.shields.io/badge/jpa-181717?style=for-the-badge&logo=jpa&logoColor=white">
<img src="https://img.shields.io/badge/amazon aws-F8DC75?style=for-the-badge&logo=amazonaws&logoColor=white">
<img src="https://img.shields.io/badge/amazon rds-61DAFB?style=for-the-badge&logo=amazonrds&logoColor=white"> 
<img src="https://img.shields.io/badge/amazon s3-E34F26?style=for-the-badge&logo=amazons3&logoColor=white"> 
<br>

<img src="https://img.shields.io/badge/axios-61DAFB?style=for-the-badge&logo=axios&logoColor=black">
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
<img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css&logoColor=white"> 
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
<img src="https://img.shields.io/badge/amazon s3-E34F26?style=for-the-badge&logo=amazons3&logoColor=white"> 
<br>
</div>

#

## 3. 기능 명세 🗂
<details>
<summary> 주요 기능 🖋 </summary>
<div markdown="1">       

(1) 장소 검색 

- 장소 검색 기능
- 카테고리 필터 검색 기능 
- 검색어 지정 검색 (가게 이름 / 도로명 주소 / 업종)
- 랭킹 조회(평점 4점 이상 / 평점 높은 순 / 리뷰 1000개 이상 / 리뷰 높은 순)
- Elastic Search + Nori 형태소 분석기를 이용한 빠르고 정확한 검색 기능 제공

(2) 예약(웨이팅) 시스템

- 스토어 웨이팅 신청 기능
- 스토어 현황 조회 기능
- 사용자 유효성(메일) 인증 및 메일 호출 기능

(3) 장소 리뷰 기능

- 장소 리뷰 작성 및 조회 기능
- 리뷰 등록 시 스토어 정보 갱신(별점, 리뷰 갯수) 기능

</div>
</details>

## 4. 시연영상 🎥
[시연영상 바로가기](https://www.youtube.com/watch?v=iY3YxFOawYs)

## 5. 서비스 아키텍처 🎨
![image](https://user-images.githubusercontent.com/117708164/216933029-f5c882eb-daec-4216-a27c-56822226726f.png)

## 6. ERD 👨🏻‍💻
![image](https://user-images.githubusercontent.com/117708164/216933200-78984f6c-6653-46ea-bf1f-ee8900e5c2bf.png)

## 7. API 💬
[API명세서 바로가기 Swagger](https://pintable.co.kr/swagger-ui/index.html?urls.primaryName=store#/store-controller/createStoreUsingPOST)

## 8. 트러블슈팅 🐞

