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
    	  $("#deptno").change(function(){
    		  let deptno=$("#deptno").val();
    		  
    		  if(deptno != "none"){
    			  var param = { deptno:deptno, name : $("#name").val() };
    			  
    		  $.ajax({
    			  url:"emp_response_ajax.do",
    			  data: param,
    			  dataType : "json",
    			  error : function( xhr ){
    				  alert("문제 발생");
    				  console.log( xhr.status );
    			  },
    			  success: function( jsonObj ){
    				  var output = "<h2>" + deptno + "부서조회 </h2>"
    					  +"<table class='table'>"
    				  +"<tr><th>사원번호</th><th>사원명</th><th>직무</th>"
    				  +"<th>매니저번호</th><th>입사일</th>"
    				  +"<th>연봉</th><th>보너스</th></tr>";
    				  if(!jsonObj.resultFlag){
    					  output+="<tr><td colspan='7'>문제발생</td></tr>";
    				  }else{
    					  if( jsonObj.dataSize == 0 ){
    					  output+="<tr><td colspan='7'>사원이 존재하지 않습니다.</td></tr>";
    					  }//end if
    				  }//end if
    				  
    				 $.each(jsonObj.data, function(idx, ele) {
    					  output+="<tr><td>"+ele.empno
    					  +"</td><td>"+ele.ename+"</td><td>"+ele.job+"</td>"
        				  +"<td>"+ele.mgr+"</td><td>"+ele.hiredate+"</td>"
        				  +"<td>"+ele.sal+"</td><td>"+ele.comm
        				  +"</td></tr>";
    				  });
    				  output+="</table>";
    				  $("#output").html( output );
    			   

    			  }//success
    		  });//ajax
    	  }//end if
    	  
    	  });//change
     
      });//ready
      </script>
</head>
<body>
<div style="width: 300px">
<select class="form-select" id="deptno">
<option value="none">---부서번호---</option>
<c:forEach var="i" begin="10" end="40" step="10">
<option value="${  i }"><c:out value="${  i }"/></option>
</c:forEach>
	</select>
	<br>
	<input type="text" name="name" id="name" value="김경태" />
	</div>
	<div  id="output">
	
	</div>
</body>
</html>