<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/main-style.css'/>">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<c:import url="/common/nav-bar.jsp"/>
		<section id="main-section">
			<form:form commandName="newExercise" action="save.html">
				<table>
					<tr>
						<th>Name</th>
						<th>Description</th>
					</tr>
					<tr>
						<td><form:input path="name" /></td>
						<td><form:textarea path="description" /></td>
					</tr>
				</table>
				<input type="submit" value="Add">
			</form:form>
		</section>
	</div>
</body>
</html>