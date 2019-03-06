<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register" /></title>
</head>
<body>
<!-- <p><b>${registerRequest.name }</b>님 회원 가입이 완료되었습니다.</p>  -->
<p>
<spring:message code="register.done" arguments="${registerRequest.name },${register.email }"/>
</p>
<p>
<spring:message code="register.done">
	<spring:arguments value="${registerRequest.name }" />
	<spring:arguments value="${registerRequest.email }" />
</spring:message>
</p>
<p><a href="<c:url value='/main'/>">[첫 화면 이동]</a></p>
<p>
<a href="<c:url value='/main' />">
<spring:message code="go.main" />
</a>
</p>
</body>
</html>