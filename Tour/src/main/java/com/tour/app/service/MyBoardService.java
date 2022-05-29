package com.tour.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tour.app.domain.Member;
import com.tour.app.domain.MyBoard;
import com.tour.app.domain.ReviewBoard;
import com.tour.app.repository.MemberJpaRepository;
import com.tour.app.repository.MyBoardRepository;


@Transactional(readOnly = true)
@Service
public class MyBoardService {
	@Autowired
	private MyBoardRepository myBoardRepository;

	@Transactional
	public void insert(MyBoard myBoard, Member member) {
		myBoard.setMember(member);
		myBoardRepository.save(myBoard);
	}
	//전체보기
	public List<MyBoard> findAll() {
		return myBoardRepository.findAll();
	}
	//전체보기 페이징
	//repository의 findAll()메서드를 Page형으로 반환
	public Page<MyBoard> findAll(Pageable pageable){
		return myBoardRepository.findAll(pageable);
	}
	
	//카운트
	public int count() {
		return (int)myBoardRepository.count();
	}
	//해당 user_id의 게시물만 출력
	 

	
	
}