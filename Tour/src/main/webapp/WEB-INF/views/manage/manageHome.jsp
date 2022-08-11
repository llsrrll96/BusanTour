<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/boardHeader.jsp" %>

<head>
<meta charset="UTF-8">
<title>관리자 홈</title>
</head>
<body>

			
			

<div class="container mt-5">
  <section>
    <div class="row">
      <div class="col-12 mt-3 mb-1">
        <h5 class="text-uppercase">관리 페이지</h5>
        <p>관리 계정 : 
        <strong><sec:authentication property="principal.member.name"/></strong>
        </p>
      </div>
    </div>
    <div class="row">
      <div class="col-xl-3 col-sm-6 col-12 mb-4">
        <div class="card">
          <div class="card-body">
            <div class="d-flex justify-content-between px-md-1">
              <div class="align-self-center">
                <i class="fas fa-pencil-alt text-info fa-3x"></i>
              </div>
              <div class="text-end">
                <h3>멤버수 ${memberCount }</h3>
                <a href="/manage/manageMember"  class="btn btn-light stretched-link" >멤버 관리</a>
              </div>
            </div>
          </div>
        </div>
      </div>
      
      <div class="col-xl-3 col-sm-6 col-12 mb-4">
        <div class="card">
          <div class="card-body">
            <div class="d-flex justify-content-between px-md-1">
              <div class="align-self-center">
                <i class="far fa-comment-alt text-warning fa-3x"></i>
              </div>
              <div class="text-end">
                <h3>전체 글 수156</h3>
                <a href="/manage/manageBoard"  class="btn btn-light stretched-link" >전체 글 관리</a>
              </div>
            </div>
          </div>
        </div>
      </div>
      
            <div class="col-xl-3 col-sm-6 col-12 mb-4">
        <div class="card">
          <div class="card-body">
            <div class="d-flex justify-content-between px-md-1">
              <div class="align-self-center">
                <i class="far fa-comment-alt text-warning fa-3x"></i>
              </div>
              <div class="text-end">
                <h3>API 관리</h3>
                <a href="/manage/manageAPI"  class="btn btn-light stretched-link" >API 관리</a>
              </div>
            </div>
          </div>
        </div>
      </div>
  </section>
</div>

<style>

.body {
	  background-color: #f5f7fa;
	}
</style>



</body>
</html>