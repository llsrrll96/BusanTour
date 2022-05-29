<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/boardHeader.jsp"%>
<%@ include file="../includes/boardCategory.jsp"%>

<div class="container">
<h5>추천여행 참여오픈(${count})</h5>
<div class="form-group text-right">
		<a href="/takeroom/insert">
			<button type="button" class="btn btn-outline-primary"  id="insertBtn">함께해요! 여행공지</button>
		</a>
</div>

<table class="table table-hover">
  <thead>
     <tr>
       <th>번호</th>
       <th>참여여행</th>
       <th>테마</th> 
       <th>참여인원</th>
       <th>여행가이드</th>
       <th>마감일자</th>
       <th>마감여부</th>
       <th>작성일자</th>
      </tr>
   </thead>
   <tbody>
     <c:forEach items="${takerooms.content}"  var="takeroom" varStatus="st">
      <tr>
         <td>${takeroom.num}</td>
         <td><a href="view/${takeroom.num }">${takeroom.title }</a></td>
         <td>${takeroom.tourarea.divide}</td>
<%--     <td>${takeroom.tourarea.contentsId}</td> --%>    
         <td>${takeroom.membercnt}</td>
         <td>${takeroom.nickname}</td> 
         <td><fmt:formatDate value="${takeroom.endDate}" pattern="yyyy-MM-dd hh:mm" /></td>
         <td>${takeroom.openyn}</td> 
         <td><fmt:formatDate value="${takeroom.regdate}" pattern="yyyy-MM-dd" /></td>            
      </tr>
     </c:forEach>
   </tbody>   
</table>

<div class="d-flex justify-content-between mt-5  mr-auto">
  <ul class="pagination">
    <c:if test="${takerooms.first==false}">
      <li class="page-item">
        <a class="page-link" href="?page=${takerooms.number-1}">이전</</a> 
      </li>
    </c:if>
    <c:if test="${takerooms.last==false}">
      <li class="page-item">
        <a class="page-link" href="?page=${takerooms.number+1}">다음</</a> 
      </li>
    </c:if>  
  </ul>
  <div>
   <form class="form-inline" action="/takeroom/list" method="get">
      <select name='field' class="form-control mr-sm-1">
       <option value="title">참여여행</option>
       <option value="nickname">여행가이드</option>
      </select>
       <input type='text'  name='word' class="form-control" placeholder="Search">
       <button class='bt btn-secondary'>검색</button>
   </form>
  </div>
</div>

</div>
</body>
</html>