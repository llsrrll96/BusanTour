package com.tour.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tour.app.domain.Member;
import com.tour.app.domain.MyBoard;
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
}