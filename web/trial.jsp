<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    if (request.getSession().getAttribute("validTech") == null) {
        String errorMsg = "You are not logged in. Please login first!!";
        request.setAttribute("ErrorMsg", errorMsg);
        request.getRequestDispatcher("techLogin.jsp").forward(request, response);
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:set var="current" scope = "request" value = "${sessionScope.validTech.getTechName()}"/>
        <c:set var="existing" scope = "request" value = "${requestScope.Tech.getTechName()}"/>
        <c:if test="${current == existing}">
            <c:out value="${sessionScope.validTech.getTechName()}"> </c:out>
        </c:if>
    </body>
</html>
