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
<link rel="stylesheet" type="text/css" href="../css/homePage.css" />
<title>Who's Here</title>
</head>
<body>
<h1>Devices</h1>
	<div class="container">
		<c:forEach items="${devices}" var="device">
			<div class="devBox">
				<h3><a href="/devices/${device.macAddress}"><c:out value="${device.macAddress}" /></a></h3>
				<h4><fmt:formatDate type = "date" value = "${device.updatedAt}" /></h4>
				<h4><fmt:formatDate type = "time" value = "${device.updatedAt}" /></h4>
				<p><c:out value="${device.nickName} - ${device.ipAddress}" /></p>
				<%-- <c:if test="${!device.nickName}">
					<form action="/device/${device.id}/addnick" method="POST">
						<input type="text" />
						<input type="submit" value="add nickname" />
					</form>
				</c:if> --%>
			</div>
		</c:forEach>
	</div>
</body>
</html>