<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- <%
	String id = (String)session.getAttribute("id");
	if (id==null) { %>
		<a href="./template.jsp?page=login_form">Login</a>
<% 	} else { %>
		<a href="./template.jsp?page=logout_form">Logout</a>
<%	} %> --%>

<c:choose>
	<c:when test="${id == null }">
		<a href="./template.jsp?page=login_form">Login</a>
	</c:when>
	<c:otherwise>
		<a href="./logout">Logout</a>
	</c:otherwise>
</c:choose>
<a href="./template.jsp?page=join_form">Join</a>