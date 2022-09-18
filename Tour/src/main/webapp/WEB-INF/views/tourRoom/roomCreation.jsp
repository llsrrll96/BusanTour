<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/boardHeader.jsp" %>

<section class="container get-in-touch">
   <h1 class="title">모임 생성</h1>
   
   <form class="contact-form row" method="post" enctype="multipart/form-data">
      <div class="form-field col-lg-12">
         <input id="title" class="input-text js-input" type="text" required>
         <label class="label" for="title">모임명</label>
      </div>
      </div>
      <div class="form-field col-lg-12">
         <input id="introduce" class="input-text js-input" type="text" required>
         <label class="label" for="introduce">모임 소개</label>
      </div>
      <div class="form-field col-lg-12">
         <input id="thema" class="input-text js-input" type="text" required>
         <label class="label" for="thema">테마</label>
      </div>
      
      
      <div class="form-filed">
		<input id="bannerimg_url" class="input-text js-input" type="file"
        
        <lable class="label" for="bannerimg_url">대표 이미지</lable>
      	<img src="/resources/img/basis.jpg" alt="-" class="img-responsive img-rounded">
      </div>
      
      
      <div class="form-field col-lg-12">
         <input class="submit-btn" type="submit" value="Submit">
      </div>

   </form>
</section>

<script>



</script>

</body>
</html>