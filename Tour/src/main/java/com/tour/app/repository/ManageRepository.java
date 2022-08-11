package com.tour.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tour.app.domain.RecommendedService;

public interface ManageRepository  extends JpaRepository<RecommendedService, String>
{
	
}
