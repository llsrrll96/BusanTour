package com.tour.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tour.app.domain.TakeComment;

public interface TakeCommentRepository extends JpaRepository<TakeComment, Long>{
    
	//댓글추가
	@Modifying
	@Query(value="insert into take_comment(content,rnum,nickname,userid,regdate) values(?1,?2,?3,?4,now())",
				nativeQuery = true)
	void commentInsert(String content, Long num, String nickName, int userId);

	
	//JPQL 이용
//  @Query("select cnum, content, nickname, rnum, userid, regdate from take_comment  where rnum=?1") //EAGER
	@Query(value="select cnum, content, nickname, rnum, userid, regdate from take_comment  where rnum=?1", nativeQuery=true)  //LAZY를 적용 할 때 적용
	public List<TakeComment> findByRnum(Long num);

}
