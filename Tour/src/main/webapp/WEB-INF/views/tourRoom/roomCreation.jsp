<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/boardHeader.jsp" %>

<section class="container get-in-touch">
   <h1 class="title">모임 생성</h1>
   
   <form class="contact-form row"  action="createRoom" method="post" enctype="multipart/form-data">
      <div class="form-field col-lg-12">
         <input name="title" id="title" class="input-text js-input" type="text" required>
         <label class="label" for="title">모임명</label>
      </div>
      </div>
      <div class="form-field col-lg-12">
         <input name="introduce" id="introduce" class="input-text js-input" type="text" required>
         <label class="label" for="introduce">모임 소개</label>
      </div>
      <div class="form-field col-lg-12">
         <input name="thema" id="thema" class="input-text js-input" type="text" required>
         <label class="label" for="thema">테마</label>
      </div>
      
      <div class="form-filed">
        <label class="bannerMultiFile" for="bannerMultiFile">배너 이미지 (5MB 이하)</label>
		<input name="bannerMultiFile" id="bannerMultiFile" class="input-text js-input" 
		type="file" onchange="preview(this)">
        
      	<img src="/resources/img/basis.jpg" alt="-" id="frame" width="720px" class="img-responsive img-rounded">
     
      </div>
      
      
      <div class="form-field col-lg-12">
         <input class="submit-btn btn btn-outline-primary" type="submit" value="Submit">
      </div>

   </form>
</section>

<script>
const maxSize = 5 * 1024 *1024;
const regex =  /(.*?)\.(jpg|jpeg|png|bmp)$/;

function preview(input) { 

	if(input.files && input.files[0].size > maxSize){
		alert("파일 사이즈가 5MB를 넘습니다.")
		input.value = null;
		return;
	}
	if(!regex.exec(input.files[0].name)){
		alert("해당 종류의 파일은 업로드할 수 없습니다.");
		input.value = null;
		return;
	}
	frame.src=URL.createObjectURL(event.target.files[0]); 
}



</script>

</body>
</html>