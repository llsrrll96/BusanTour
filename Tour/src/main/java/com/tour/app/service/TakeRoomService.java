package com.tour.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tour.app.domain.Member;
import com.tour.app.domain.TakeRoom;
import com.tour.app.repository.TakeRoomRepository;

@Transactional(readOnly=true)
@Service
public class TakeRoomService {
	@Autowired
	private TakeRoomRepository takeroomRepository;
	@Autowired
	private  BCryptPasswordEncoder encoder;
	
	@Transactional
	public void insert(TakeRoom takeroom, Member member) {
		takeroom.setMember(member);
		System.out.print(takeroom.getEndDate());
		takeroomRepository.save(takeroom);		
	}
	//전체보기(페이징 아님)
//	public List<TakeRoom> findAll() {	
//			return takeroomRepository.findAll();
//	}
    //참여하기 오픈방 리스트 전체조회(페이징, 검색)
	public Page<TakeRoom> findAll(String field, String word, Pageable pageable) {
		if(field.equals("title"))
			return takeroomRepository.findByTitleContaining(word, pageable);
		
		if(field.equals("nickname"))
			return takeroomRepository.findByNicknameContaining(word, pageable);
		return takeroomRepository.findAll(pageable);
	}
    //참여하기 오픈방 전체 개수(검색)
	public Long count(String field, String word) {
		if(field.equals("title"))
			  return takeroomRepository.cntTitleSearch(word);
		if(field.equals("nickname"))
			  return takeroomRepository.cntNicknameSearch(word);
	    return takeroomRepository.count();
     }
    //상세조회
	public TakeRoom findById(Long num) {
//	public List<TakeRoom> findById(Long num) {
		TakeRoom takeroom = takeroomRepository.findById(num).get();
		System.out.println("데이터 확인용 디버깅2:" + takeroom.getTakemembers());
		return takeroom;
	}
    //삭제작업
	@Transactional
	public void delete(Long num) {
		takeroomRepository.deleteByNum(num);
	}
    //수정작업
	@Transactional
	public void update(TakeRoom takeroom) {
		TakeRoom t =
			takeroomRepository.findById(takeroom.getNum()).get();
		           t.setTitle(takeroom.getTitle());
			       t.setContent(takeroom.getContent());
//			       t.setEndDate(takeroom.getEndDate());	
			       t.setOpenyn(takeroom.getOpenyn());	
			       t.setRegdate(new Date());
	}

}
