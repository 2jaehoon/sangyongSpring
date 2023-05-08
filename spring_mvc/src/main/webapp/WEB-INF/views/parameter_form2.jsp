<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    info="사용자가 입력한 값을 받아서 back-end로 전송하기 위한 페이지 " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"  href="http://localhost/spring_mvc/common/main_v20230217.css"/>
<style type="text/css">
#wrap{ width: 1000px; height: 1200px;margin: 0px auto; }
#header{  height: 200px; position: relative;
	background: #FFFFFF url(http://localhost/spring_mvc/common/images/header_bg.png)  repeat-x;}

#logo{ position:absolute;top: 40px;left:100px; width: 150px; font-weight: bold; font-size: 40px;
	font-family: 고딕 ;}	
#naviBar{ position:absolute;top:140px;left:0px;height: 60px }	 
#container{ height: 900px;position: relative; }	 

#footer{ height: 100px;position: relative;  }	 
#flogo{ position:absolute;top:20px;left:100px;height: 60px;font-weight: bold; font-size: 20px;
	font-family: 고딕 ; color:#d7d7d7; text-align: right; width:100%;  }	 
div {line-height: 24px; }
</style>
<!-- jQuery CDN 시작 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- jQuery CDN 끝 -->
<script type="text/javascript">
function sendData(){
	var obj=document.getFrm;
	
	//유효성검증
	if(obj.domain.selectedIndex == 0){
		alert("도메인을 반드시 선택해 주세요.");
		return;
	}//end if
	
	//유효성 검증이 완료되면 값을 받야할 페이지로 값들을 전송한다.
	obj.submit();
}//sendData

$(function(){
	$("#postBtn").click(function(){
		$("[name='postFrm']").submit();
	});//click
});//ready
</script>

</head>
<body>
<div id="wrap"> 
<div id="header">  
	<div id="logo">Class 4.</div>
	<div id="naviBar">navi ( 1000 x 60)</div>
</div>
<div id="container">

<div>
<span style="font-weight: bold; font-size:25">단일형으로 된 POST방식의 요청 처리 폼</span><br>
HTML Form Control의 name속성이 유일한 경우의 처리.<br/>
<form action="parameter_form_process2.do" method="post" name="postFrm" >
<label>이름</label> <input type="text" name="name" class="inputBox" /><br/>
<label>나이</label> <input type="password" name="age" class="inputBox" /><br/>
<label>주소</label> <input type="hidden" name="addr" value="서울시 강남구 역삼동" /><br/>
<label>도메인</label>
<select name="domain">
<option value="none">--도메인 선택--</option>
<option value="daum.net">다음메일</option>
<option value="naver.com">네이버메일</option>
<option value="nate.com">네이트메일</option>
<option value="gmail.com">구글메일</option>
<option value="hotmail.com">핫메일</option>
</select>
<br/>
<label>취미</label>
<input type="checkbox" name="hobby" value="독서"/>독서
<input type="checkbox" name="hobby" value="음악감상"/>음악감상
<input type="checkbox" name="hobby" value="유툽"/>유튜브
<input type="checkbox" name="hobby" value="운동"/>운동
<input type="checkbox" name="hobby" value="등산"/>등산
<br/>
<label>설명</label>
<textarea rows="5" cols="40" name="info"></textarea>
<br/>
<input type="button" value="POST방식전송" class="btnBorder" id="postBtn"/> 
</form>
</div>
</div>
<div id="footer">footer ( 1000 x 100)
	<div id="flogo"> Copyright &copy; Class 4. All rights reserved.</div>
</div>
</div>
</body>
</html>



    