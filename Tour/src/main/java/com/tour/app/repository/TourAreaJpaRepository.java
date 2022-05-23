package com.tour.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tour.app.domain.TourArea;

public interface TourAreaJpaRepository  
     extends JpaRepository<TourArea, Long>{

}

