package com.tour.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tour.app.domain.TourArea;
import com.tour.app.dto.TourAreaDTOInterface;

public interface TourAreaJpaRepository  
     extends JpaRepository<TourArea, Long>{

	@Query(value="select contents_id, title,contents_name, thumimagefile from tour_area;" , nativeQuery=true)
	List<TourAreaDTOInterface> findTourAreaList();

	TourArea findByContentsId(Integer valueOf);

	

}

