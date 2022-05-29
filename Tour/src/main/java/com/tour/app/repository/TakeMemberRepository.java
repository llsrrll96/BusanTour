package com.tour.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tour.app.domain.TakeMember;

public interface TakeMemberRepository extends JpaRepository<TakeMember, Long>{

	
	//JPQL 이용
//	@Query("select rnum, userid, entrant, regdate, takeyn from take_member where rnum=?1")
//	@Query(value="select tm from take_member tm where num=?1", nativeQuery=true)
//	@Query(value="select sc from tbl_comment5 sc join fetch sc.board where bnum=?1", nativeQuery=true)
	@Query(value="select rnum, userid, entrant, regdate, takeyn from take_member  where  rnum=?1", nativeQuery=true)  //LAZY를 적용 할 때 적용
//	@Query(value="select sc from take_member sc join fetch sc.take_room where num=?1", nativeQuery=true) // LAZY인 경우에 사용해야 함 에러발생
//	@Query(value=" select rm.num, mb.userid, mb.entrant, mb.regdate, mb.takeyn "
//			+ " from take_member mb left outer join take_room rm "
//	        + "  on mb.rnum = rm.num where rm.num=?1", nativeQuery=true)  //일반SQL문 //EAGER
//	@Query("select * from take_member sc where sc.num=?1") //EAGER인 경우에 사용
	public List<TakeMember> findByNum(Long num);

	//참가자 takemember추가
	@Modifying
	@Query(value="insert into take_member(rnum, userid, entrant, takeyn,regdate) values(?1,?2,?3,?4,now())",
		    nativeQuery = true)
	public void entryInsert(Long num, int userId, String entrant, String takeyn, Date regdate);

	@Modifying
	@Query(value="delete from take_member where rnum=?1 and userid=?2", nativeQuery = true)
	public void deleteEntry(Long rnum, int userid);


}
