<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Device: <c:out value="${device.macAddress}"/></title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.6/d3.min.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="../css/cal-heatmap.css" />
<script type="text/javascript" src="../js/cal-heatmap.min.js"></script>
</head>
<body>
<h1><c:out value="${device.macAddress}" /></h1>
<div id="cal-heatmap"></div>
<script type="text/javascript">
	var cal = new CalHeatMap();
	cal.init({
		range: 40,		domain: 'day',
		data:
			<json:object>
			<c:forEach items="${scanDates}" var="scan">
				<json:property name="${scan[0]}" value="${scan[1]}" />
			</c:forEach>
			</json:object>,
		colLimit: 1,		
	});
</script>
</body>
</html>