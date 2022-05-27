package com.tour.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tour.app.domain.TourArea;
import com.tour.app.dto.TourAreaDTOInterface;

public interface TourAreaJpaRepository  
     extends JpaRepository<TourArea, Long>{

	@Query(value="select contents_id, title,contents_name, thumimagefile from tour_area" , nativeQuery=true)
	List<TourAreaDTOInterface> findTourAreaList();
	
	@Query(value="select contents_id, title,contents_name, thumimagefile from tour_area" , nativeQuery=true)
	Page<TourAreaDTOInterface> findTourAreaList(Pageable pageable);

	
	
	TourArea findByContentsId(Integer valueOf);

	
	@Query(value="select contents_id, title,contents_name, thumimagefile from tour_area where area like CONCAT('%',:area,'%')" ,
				countQuery = "SELECT count(*) FROM tour_area WHERE area like CONCAT('%',:area,'%')"
			, nativeQuery=true)
	Page<TourAreaDTOInterface> findByAreaContaining(String area, Pageable pageable);
	
	@Query(value="select contents_id, title,contents_name, thumimagefile from tour_area where area like CONCAT('%',:area,'%')  and divide like CONCAT('%',:divide,'%') " 
			,countQuery = "SELECT count(*) FROM tour_area WHERE area like CONCAT('%',:area,'%') and divide like CONCAT('%',:divide,'%')"
			, nativeQuery=true)
	Page<TourAreaDTOInterface> findByAreaDivideContaining(String area, String divide, Pageable pageable);


	

}

