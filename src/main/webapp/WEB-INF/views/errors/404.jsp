<%--
  Created by IntelliJ IDEA.
  User: Skad1
  Date: 2018-07-19
  Time: 09:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<% response.setStatus(404); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>404 error</title>
</head>
<body>

<center>

    <img src="<spring:url value="/resource/images/Puppet404.gif"  htmlEscape="true" />" alt="Page not found  JSP!!!"  />

    <H2>${requestScope['javax.servlet.error.message']}</H2>

    <p><button type=button onclick=window.location.href="<spring:url value="/" />">Home</button></p>

</center>
</body>
</html>
