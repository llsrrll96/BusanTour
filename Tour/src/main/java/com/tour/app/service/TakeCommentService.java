package com.tour.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.tour.app.domain.TakeComment;
import com.tour.app.repository.TakeCommentRepository;

@Transactional(readOnly=true)
@Service
public class TakeCommentService {
	@Autowired
	private TakeCommentRepository takecommentRepository;

	
	@Transactional
	public void save(TakeComment takecomment) {
		//SQL 이용추가
		takecommentRepository.commentInsert(
				takecomment.getContent(),
				takecomment.getTakeroom().getNum(),
				takecomment.getMember().getNickName(),
				takecomment.getMember().getUserid()
		);
		
	}

	public List<TakeComment> list(Long num) {
		return takecommentRepository.findByRnum(num);
	}
	@Transactional
	public void delete(Long cnum) {
		takecommentRepository.deleteById(cnum);
		
	}

}
