package com.tour.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tour.app.domain.MyBoard;

public interface MyBoardRepository 
	extends JpaRepository<MyBoard, Long>{
	
	
}
