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
<title>Leaderboard</title>
</head>
<body>
<H1>Leaderboard</H1>
	<div class="container">
		<div class="devBox">
			<h2>Last Hour</h2>
			<table>
				<tr>
					<th>Mac Address</th>
					<th>Minutes</th>
				</tr>
				<c:forEach items="${top10LastHour}" var="device">
					<tr>
						<td><a href="/devices/${device[0]}"><c:out value="${device[0]}" /></a></td>
						<td><c:out value="${device[1]}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="devBox">	
			<h2>Last Day</h2>
			<table>
				<tr>
					<th>Mac Address</th>
					<th>Hours</th>
				</tr>
				<c:forEach items="${top10LastDay}" var="device">
					<tr>
						<td><a href="/devices/${device[0]}"><c:out value="${device[0]}" /></a></td>
						<td><c:out value="${device[1] / 60}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="devBox">			
			<h2>Last Week</h2>
			<table>
				<tr>
					<th>Mac Address</th>
					<th>Hours</th>
				</tr>
				<c:forEach items="${top10LastWeek}" var="device">
					<tr>
						<td><a href="/devices/${device[0]}"><c:out value="${device[0]}" /></a></td>
						<td><c:out value="${device[1] / 60}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="devBox">			
			<h2>Last Month</h2>
			<table>
				<tr>
					<th>Mac Address</th>
					<th>Hours</th>
				</tr>
				<c:forEach items="${top10LastMonth}" var="device">
					<tr>
						<td><a href="/devices/${device[0]}"><c:out value="${device[0]}" /></a></td>
						<td><c:out value="${device[1] / 60}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="devBox">			
			<h2>All Time</h2>
			<table>
				<tr>
					<th>Mac Address</th>
					<th>Hours</th>
				</tr>
				<c:forEach items="${top10AllTime}" var="device">
					<tr>
						<td><a href="/devices/${device[0]}"><c:out value="${device[0]}" /></a></td>
						<td><c:out value="${device[1] / 60}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>