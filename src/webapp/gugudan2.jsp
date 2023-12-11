<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--Rq사용하기-->
<%@ page import="sbs.jsp.board.Rq" %>


<%
    Rq rq = new Rq(request, response);
    int dan = (int)request.getAttribute("dan");
    int limit = (int)request.getAttribute("limit");
%>


<h1><%=dan%>단</h1>

<% for(int i = 1; i <= limit; i++) { %>
    <div><%=dan%> * <%=i%> = <%=dan*i%></div>
<% } %>
