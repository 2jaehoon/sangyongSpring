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
<div>
<c:import url="/common/jsp/navibar.jsp"/>
</div>
<div style="width: 500px">
<table class="table">
<tr>
<th style="width: 100px">이름</th>
<th style="width: 400px">이메일</th>
</tr>
<c:if test="${ empty data  }">
<tr>
<td colspan="2">검색된 회원 정보가 존재하지 않습니다.</td>
</tr>
</c:if>
<c:forEach var="member" items="${  data }">
<tr>
<td><c:out value="${ member.name  }"></c:out></td>
<td><c:out value="${ member.email  }"></c:out></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>