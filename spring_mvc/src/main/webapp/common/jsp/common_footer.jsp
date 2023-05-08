<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 공통 디자인만 정의 
끼워지는 jsp에서는 외부 jsp의 js library, CSS library를 사용할 수 있다.
web parameter를 사용할 수 있다.
-->
공통 디자인<br>
<img src="http://localhost/jsp_prj/common/images/daum.png" />
<%
//
String name = "이재훈";
%>
<div>
내부 jsp 이름 : <%= name %>
</div>