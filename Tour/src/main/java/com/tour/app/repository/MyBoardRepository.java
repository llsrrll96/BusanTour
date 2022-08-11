package com.tour.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tour.app.domain.Member;
import com.tour.app.domain.MyBoard;
import com.tour.app.service.MyBoardService;



public interface MyBoardRepository 
	extends JpaRepository<MyBoard, Long>{
	
	//해당 userId의 게시물만 출력
//	@Query(value = "select * from review_board where userId = ? ", 
//			  nativeQuery=true)
	
	
}
