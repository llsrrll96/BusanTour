package com.tour.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tour.app.domain.ReviewBoard;

@Repository
public interface TourReviewJpaRepository extends JpaRepository<ReviewBoard, Integer>
{
	

}
