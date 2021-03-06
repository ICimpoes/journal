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
			<div id="dialog-confirm"></div>
			<table id="agendaTable">
			</table>
			<a href="new.html"><button>New Agenda</button></a>
		</section>
	</div>
	
</body>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery-ui-1.11.2.custom/jquery-ui.js"></script>
<script type="text/javascript">

	
	function deleteAgenda(id) {
		$.ajax({
			type : "POST",
			contentType : 'application/json',
			dataType : 'json',
			url : "deleteAgenda.json",
			data : JSON.stringify(id)
			
		}).done(function(result) {
			showAgendas();
		});
	}

	function showAgendas() {
		$.getJSON('getAllAgendas.json', {
			ajax : 'true'
		}, function(data) {
			var html = '<tr><th>Day Of Week</th><th>Exercises</th></tr>';
			var len = data.length;
			for (var i = 0; i < len; i++) {
				html += '<tr><td>' + data[i].dayOfWeek + '</td>';
				html += '<td>';
				var exercisesLen = data[i].exercises.length;
				for (var j = 0; j < exercisesLen; j++) {
					html += "<ul><li>" + exercisesLen.name + "</li></ul>";
				}
				
				html += '</td>'
				html += '<td><button value=' + data[i].id + ' class="delete-agenda">delete</button></td>'
				'</tr>';
			}
			$('#agendaTable').html(html);
			$( ".delete-agenda" ).click(function() {
				var agendaId = $(this).val();
				$("#dialog-confirm").html('<p><span style="float: left; margin: 0 7px 20px 0;"></span>This agenda will be permanently deleted and cannot be recovered. Are you sure?</p>');
				
				$("#dialog-confirm").dialog({
					resizable : false,
					height : 140,
					modal : true,
					buttons : {
						"Delete agenda" : function() {
							deleteAgenda(agendaId);
							$(this).dialog("close");
						},
						Cancel : function() {
							$(this).dialog("close");
						}
					}
				});
				
				
			});
		});
	}
	
	$(document).ready(showAgendas());
</script>
</html>