<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav id="nav-pannel">
	<a href="<c:url value='/'/>"><div class="nav-div">Home</div>
	</a> <a	href="<c:url value='/exercise/view.html'/>"><div class="nav-div">View Exercises</div>
	</a> <a href="<c:url value='/exercise/new.html'/>"><div	class="nav-div">New Exercise</div>
	</a> <a	href="<c:url value='/agenda/view.html'/>"><div class="nav-div">View	Agenda</div>
	</a> <a	href="<c:url value='/agenda/viewAll.html'/>"><div class="nav-div">View	All Agendas</div>
	</a> <a href="<c:url value='/agenda/new.html'/>"><div class="nav-div">New Agenda</div></a>
</nav>