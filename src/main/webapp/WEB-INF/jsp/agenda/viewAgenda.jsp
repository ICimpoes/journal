<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/main-style.css'/>">
<title></title>
</head>
<body>
	<div id="container">
		<c:import url="/common/nav-bar.jsp"/>
		<section id="main-section">
			<h1>${selectedAgenda.dayOfWeek }</h1>
			<c:choose>
				<c:when test="${not empty selectedAgenda.exercises}">
					<table>
						<tr>
							<th>Name</th>
							<th>Description</th>
						</tr>
						<c:forEach items="${selectedAgenda.exercises }" var="exercise">
							<tr>
								<td>${exercise.name }</td>
								<td>${exercise.description }</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<h6>No Exercises!</h6>
				</c:otherwise>
			</c:choose>
		</section>
	</div>
	
</body>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery-ui-1.11.2.custom/jquery-ui.js"></script>
<script type="text/javascript">

</script>
</html>