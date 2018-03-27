<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	.devBox{
		border: 1px solid black;
		display: inline-block;
	}
</style>
<title>Who's Here</title>
</head>
<body>
<h1>Devices</h1>
<c:forEach items="${devices}" var="device">
	<div class="devBox">
		<h3><c:out value="${device.macAddress}" /></h3>
		<p><a href="${device.id}"><c:out value="${device.nickName} - ${device.ipAddress}" /></a></p>
		<%-- <c:if test="${!device.nickName}">
			<form action="/device/${device.id}/addnick" method="POST">
				<input type="text" />
				<input type="submit" value="add nickname" />
			</form>
		</c:if> --%>
	</div>
</c:forEach>
</body>
</html>