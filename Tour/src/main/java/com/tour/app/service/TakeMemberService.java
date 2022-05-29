package com.tour.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tour.app.domain.TakeMember;
import com.tour.app.domain.TakeRoom;
import com.tour.app.repository.TakeMemberRepository;
import com.tour.app.repository.TakeRoomRepository;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly=true)
@RequiredArgsConstructor
@Service
public class TakeMemberService {
	@Autowired
	private TakeMemberRepository takememberRepository;
	@Autowired
	private TakeRoomRepository takeroomRepository;
    
	
//	public List<TakeMember> list(Long num) {
//		System.out.println("전달 파라메트:" + num);
//		return takememberRepository.     findById(takeRoomId);   //.findByNum(num);
//	}
	@Transactional
	public void save(TakeMember takemember) {
		//SQL takemember 인원추가
//		takememberRepository.takememberInsert(null, 0, null, null, null);
		takememberRepository.entryInsert(
				takemember.getTakeroom().getNum(),
				takemember.getMember().getUserid(),
				takemember.getMember().getNickName(),
				takemember.getTakeyn(),
				takemember.getRegdate()
	     );
		//takeroom에 참가자 인원수 1증가
		TakeRoom t = takeroomRepository.findById(takemember.getTakeroom().getNum()).get();
		         t.setMembercnt(t.getMembercnt()+1);
	}
	//takemember 참여여행 참가자 전체 조회
	public List<TakeMember> list(Long num) {
		System.out.println("전달 파라메트:" + num);
		return takememberRepository.findByNum(num);
	}
	
	//takemember 참여여행 참가자 탈퇴취소작업(삭제)
    @Transactional
	public void delete(Long rnum, int userid) {
		takememberRepository.deleteEntry(rnum, userid);
		
		TakeMember takemember = takememberRepository.findById(rnum).get();
    	//takeroom에 참가자 인원수 1증가
        TakeRoom t = takeroomRepository.findById(takemember.getTakeroom().getNum()).get();
   			     t.setMembercnt(t.getMembercnt()-1);
		}

}
