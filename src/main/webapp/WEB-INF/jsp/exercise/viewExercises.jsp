<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table id="exercisesTable">
	</table>
	<a href="new.html"><button>New Exercise</button></a>
	<a href="../index.jsp"><button>Home</button></a>
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