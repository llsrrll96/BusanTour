package com.tour.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tour.app.domain.ReviewBoard;
import com.tour.app.dto.TourReviewDTO;
import com.tour.app.dto.TourReviewDTOInterface;

@Repository
public interface TourReviewJpaRepository extends JpaRepository<ReviewBoard, Integer>
{
	
	@Query(value="SELECT r.num, r.title, m.nick_name, r.regdate, r.hitcount "
			+ "FROM review_board r "
			+ "inner join member m ON r.user_id = m.user_id "
			+ "WHERE contentsid= :contentsid "	, nativeQuery=true)
	List<TourReviewDTOInterface> findReviewBoardList(int contentsid);

	ReviewBoard findByNum(Integer num);

	void deleteByNum(Integer num);
	

}
