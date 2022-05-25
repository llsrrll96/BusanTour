package com.tour.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tour.app.domain.Member;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Integer>{

	Member findByName(String name);

}
