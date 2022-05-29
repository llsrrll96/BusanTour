package com.tour.app.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tour.app.config.auth.PrincipalDetails;
import com.tour.app.domain.Member;
import com.tour.app.domain.ReviewBoard;
import com.tour.app.domain.TourArea;
import com.tour.app.dto.TourReviewDTO;
import com.tour.app.dto.TourReviewDTOInterface;
import com.tour.app.repository.MemberJpaRepository;
import com.tour.app.repository.TourReviewJpaRepository;

@Service
public class TourReviewService 
{
	@Autowired
	private TourReviewJpaRepository tourReviewJpaRepository;
	@Autowired
	private MemberJpaRepository memberJpaRepository;
	
	public List<ReviewBoard> findAll() {
		return tourReviewJpaRepository.findAll();
	}

	// boardId 게시판고유번호 100
	// num 자동생성
	// userid : 세션의 사용자 이름값
	// contentsId : 해당 게시글의 쿼리 스트링값
	// hitcount, replycnt, regdate 자동생성
	@Transactional
	public void registerReview(ReviewBoard reviewBoard, 
									@AuthenticationPrincipal  PrincipalDetails principal
									,int contentsId) 
	{
		reviewBoard.setBoardId(100);
		
		// db에서 멤버를 조회
		// 트랜잭션 1.
		Member member = memberJpaRepository.findByName(principal.getMember().getName());
		reviewBoard.setMember(member);
		
		
		// 게시글의 Id 는 임시로
		// 트랜잭션 2.
		TourArea tourArea = new TourArea();
		tourArea.setContentsId(contentsId);
		reviewBoard.setTourArea(tourArea);
		
		System.out.println("저장시도중");
		// 트랜잭션 3.
		tourReviewJpaRepository.save(reviewBoard);
	}

	@Transactional
	public List<TourReviewDTOInterface> findReviewBoardList(int contentsid) 
	{
		List<TourReviewDTOInterface> tourReviewDTOs = tourReviewJpaRepository.findReviewBoardList(contentsid);

		return tourReviewDTOs;
	}

	public ReviewBoard findById(int num) {
		return tourReviewJpaRepository.findByNum(Integer.valueOf(num));
	}

	
//	"num"
//	"title"
//	"contents"
//	"area1"
//	"divide"
	@Transactional
	public void updateTourReview(ReviewBoard reviewBoard) 
	{
		ReviewBoard rb = tourReviewJpaRepository.findByNum(reviewBoard.getNum());
		rb.setTitle(reviewBoard.getTitle());
		rb.setContents(reviewBoard.getContents());
		rb.setArea1(reviewBoard.getArea1());
		rb.setDivide(reviewBoard.getDivide());
	}

	@Transactional
	public void deleteTourReview(int num) {
		tourReviewJpaRepository.deleteByNum(Integer.valueOf(num));
	}

}
