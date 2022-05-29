package com.tour.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;

import com.tour.app.domain.TakeRoom;

public interface TakeRoomRepository extends JpaRepository<TakeRoom, Long> {

	TakeRoom findByTitle(String title);

	Page<TakeRoom> findByTitleContaining(String title, Pageable pageable);
	
	Page<TakeRoom> findByNicknameContaining(String nickname, Pageable pageable);
	
	//추천여행 제목과 내용 검색 개수
	@Query(value="select count(*) from take_room where title like CONCAT('%',:word,'%')", 
			nativeQuery=true)
	public Long cntTitleSearch(@Param("word") String word);

	//추천여행 해당 가이드 검색 개수
	@Query(value="select count(*) from take_room where nickname like CONCAT('%',:word,'%')", 
			nativeQuery=true)
	public Long cntNicknameSearch(@Param("word") String word);

	//참여여행방 삭제작업
	void deleteByNum(Long num);

}
