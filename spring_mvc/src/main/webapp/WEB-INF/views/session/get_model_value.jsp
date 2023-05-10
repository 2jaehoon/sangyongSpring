<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap 시작-->
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous"/>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
      <!-- bootstrap 끝-->
      <!-- jQuery CDN 시작 -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
     <!-- jQuery CDN 끝 -->
      <script type="text/javascript">
      $(function(){
     
      });
      </script>
</head>
<body>
<c:if test="${ empty mId  }">
<c:redirect url="index.html" />
</c:if>
Model을 사용한 세션 값 설정 후 값 사용 페이지<br>

requestScope에 설정된 값 : <c:out value="${  requestScope.mId }"/>( <c:out value="${  requestScope.mName }"/> )님 안녕하세요?<br>
sessionScope에 설정된 값 : <c:out value="${  sessionScope.mId }"/>( <c:out value="${  sessionScope.mName }"/> )님 안녕하세요?<br>
DataDomain의 값 사용<br>
<c:if test="${  not empty mObj }">
이름 <c:out value="${  mObj.name }"/>/ 이메일 <c:out value="${  mObj.email }"/> 
</c:if>


</body>
</html>