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
		<c:import url="/common/nav-bar.jsp" />
		<section id="main-section">
			<form:form commandName="newAgenda" action="save.html">
				<table>
					<tr>
						<th>DayOfWeek</th>
					</tr>
					<tr>
						<td><form:select id="daysOfWeek" path="dayOfWeek">
							</form:select></td>
					</tr>
				</table>
				<input type="submit" value="newAgenda">
			</form:form>
			<pre id="pre"></pre>
		</section>
	</div>
</body>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">

$(document).ready(
	function() {
		$.getJSON('daysOfWeek.json', {
			ajax : 'true'
		}, function(data){
			var html = '';
			var len = data.length;
			for (var i = 0; i < len; i++) {
				html += '<option value="' + data[i] + '">'
						+ data[i] + '</option>';
			}
			html += '</option>';
			$('#daysOfWeek').html(html);
			$('#pre').text(exercises[0].description);
		});
	});

var exercises = $.getJSON("../exercise/getAllExercises.json", function(data) {
	exercises = data;
});
</script>
</html>