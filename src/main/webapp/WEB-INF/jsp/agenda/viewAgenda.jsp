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
	<h1>${selectedAgenda }</h1>
	<table id="agendaTable">
	</table>
	<a href="new.html"><button>New Agenda</button></a>
	<a href="../index.jsp"><button>Home</button></a>
	<button onclick="showAgendas()">Refresh</button>
	<button id="delete-agenda" onclick="deleteAgenda()">Delete</button>
</body>

</html>