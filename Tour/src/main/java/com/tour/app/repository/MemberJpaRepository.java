package com.tour.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tour.app.domain.Member;

public interface MemberJpaRepository extends JpaRepository<Member, Integer>{

	Member findByName(String name);

}
