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
			<table id="exercisesTable"></table>
			<a href="new.html"><button>New Exercise</button></a>
			<a href="../index.jsp"><button>Home</button></a>
		</section>
	</div>
</body>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$.getJSON('getAllExercises.json', {
			ajax : 'true'
		}, function(data) {
			var html = '<tr><th>Name</th><th>Description</th></tr>';
			var len = data.length;
			for (var i = 0; i < len; i++) {
				html += '<tr><td>' + data[i].name + '</td>';
				html += '<td>' + data[i].description + '</td></tr>';
			}
			$('#exercisesTable').html(html);
		});
	});
</script>
</html>