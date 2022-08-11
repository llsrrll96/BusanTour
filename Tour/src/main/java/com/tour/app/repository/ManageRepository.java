package com.tour.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tour.app.domain.RecommenedService;

public interface ManageRepository  extends JpaRepository<RecommenedService, String>
{
	
}
