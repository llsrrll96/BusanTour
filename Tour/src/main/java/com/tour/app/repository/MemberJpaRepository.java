package com.tour.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tour.app.domain.Member;
import com.tour.app.dto.MemberDTO;

public interface MemberJpaRepository extends JpaRepository<Member, Integer>{

	Member findByName(String name);

	@Query(value="select * from member" , nativeQuery=true)
	List<MemberDTO> findAllMemberDTO();

}
