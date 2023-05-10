<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info = "file upload form"
    %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="http://localhost/spring_mvc/common/main_v20230217.css"/> 
<style type="text/css">

#wrap{
width:1000px; height:1200px; margin:0px auto; /* background-color:#FF0000; */
}

#header{
height:200px; /* background-color:#00FF00; */
position:relative;
background:#FFF url(http://localhost/spring_mvc/common/images/header_bg.png) repeat-x;
}

#logo{
position:absolute; top:40px; left:100px; 
width:150px; font-weight:bold; font-size:40px; font-family:고딕; 
}

#naviBar{
position:absolute; top:140px; left:0px;
height:60px;
}

#container{
height:900px; /* background-color:#23A9FF; */
position:relative;
}

#footer{
height:100px; position:relative; /* background-color:#0766E6; */
}

#flogo{
position:absolute; left:600px; 
height:60px; font-weight:bold; font-size:20px; font-family:"맑은 고딕";
color:#d7d7d7;
} 


</style>
<!-- jQuery CDN 시작 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- jQuery CDN 끝 -->
<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		
		//이미지 파일( gif. png.jpg.bmp] )만 업로드 할 수 있도록 유효성 검증
		var blockExt = [ "gif", "png", "bmp", "jpg" ];
		var blockFlag = false;
		var fileName = $("#file").val();
		var ext = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
		
		for(var i=0; i<blockExt.length; i++){
			if( blockExt[i] == ext ){
				blockFlag = true;
				break;
			}//end if
		}//end for
		
			if( !blockFlag ){
				alert("이미지 파일만 업로드 가능합니다.\n 이미지를 선택해주세요.");
				return;
			}//end if
	
		
		
		alert(ext);			
		$("#frm").submit();
		
	});//click
	
});//ready
</script>
</head>
<body>


<div id="wrap"> <!-- wrap(w:1000 h:1200) -->


<div id="header"><!-- header(w:1000 h:200) -->
	<div id="logo">Class 4</div>
	<div id="naviBar">naviBar(w:1000 h:60)</div>
</div>


<div id="container">container(w:1000 h:900)
<!-- enctype이 파라메터 전송방식일 떄에는 back-end 페이지에서
request.getParameter()를 사용하여 입력값을 받을 수 있다.

enctype = "multipart/form-data"인 경우에는 파라메터 전송방식에
binary 전송방식으로 변경되기 때문에 request.getParameter로 입력값을 받을 수 없다.

   -->

<form action="upload_process.do" method="post" enctype="multipart/form-data" id="frm" name="frm"> 
<label>업로더</label>
<input type = "text" name="uploader"  id="uploader" class="inputBox"  style="width: 200px;" />
<br>
<br>
<label>나이</label>
<select name="age" class="inputBox">
<c:forEach var="i" begin="10" end="80" step="10" >
<option value="${ i  }" > <c:out value="${ i  }"/>대 </option>
</c:forEach>
</select>
<br>
<br>
<label>파일</label>
<input type="file" name="file" class="inputBox"  id="file" />
<br>
<br>
<input type="button" value="업로드" class="btnBorder"  id="btn" />
</form>


</div>


<div id="footer">footer(w:1000 h:100)
	<div id="flogo">Copyright &copy; Class 4. All rights reserved.</div>
</div>


</div>

</body>
</html>