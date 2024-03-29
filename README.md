# 🌅 함께해요 부산 여행

:pushpin: [발표 PPT](https://www.miricanvas.com/v/1140m3i)

## 1. 제작 기간 & 참여 인원
> 거리두기 해제에 따라 부산 여행에 대한 수요가 회복되고 있고 ‘나홀로’여행 보다 ‘동반’ 여가 활동을 선호하는 경향이 증가하고 있습니다.
함께해요 부산여행은 부산 관광지에 대해 리뷰를 작성하고 여행 모임을 만드는 웹 사이트 입니다.
<br>

기간 <br>
- 2022년 05월 16일 ~ 05월 30일 <Br>

참여 인원 <br>
- 3명

<br>

## 2. 사용 기술
  - Java 11
  - Spring Boot
  - Spring Security
  - Maven
  - JPA
  - MySQL 
  - JSP
  - Ajax
  - JQuery

<br>

## 3. ERD 설계
<img src="https://user-images.githubusercontent.com/58140426/179436972-e8c459de-c858-4762-b889-5eec2a9a4561.png" width="480">

<br>

## 4. 핵심 기능
- 회원 관련 페이지 : 시큐리티 적용한 로그인/로그아웃, 회원가입
- 관리자 페이지 : 회원리스트, 회원강제탈퇴, 회원권한부여
- 메인 홈 게시판 : 관광지 카드형 게시판, 구군별-테마별 찾기
- 여행 리뷰 게시판 : 리뷰 등록/수정/삭제/조회
- 참여방 게시판 : 여행 참여자 모집
- 마이 메뉴 : 내가 쓴 여행리뷰, 내가 쓴 참여 모집 글

<br>

## 5. 기여
- 스프링 시큐리티 적용
  - 회원가입 시 비밀번호 암호화와 권한 부여
  - 시큐리티를 적용하여 로그인한 사용자만 글쓰기 페이지에 접근할 수 있도록 구현
  - 로그인(인증)한 사용자만 '리뷰쓰기' 버튼이 보이도록 security taglib 사용
- 메인 홈
  - Bootstrap 을 사용하여 카드형 UT로 홈 화면을 구현
  - 메인 홈 페이징과 게시글 찾기 기능 구현
- 리뷰 글 
  - 글 쓴 사용자만 리뷰 글 편집기능 활성화
  - Core Tag Library를 이용해 글 쓴 사용자id과 세션id 비교하여 편집 기능 활성화
- 이미지 업로드
- 관리자 페이지
  - 멤버관리
  - 역할 부여와 탈퇴 기능 구현 
  
## 6. 참고
[프로젝트 노션 정리](https://www.notion.so/455502ffcac24d68a1ca5aff1bc6e1bd) <br>
[블로그](https://javapp.tistory.com/category/Dev/Spring%20Boot%20%2B%20JSP)
