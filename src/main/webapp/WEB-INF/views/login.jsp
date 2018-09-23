<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Skad1
  Date: 2018-07-18
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form">
    <c:if test="${not empty msg}">
        <p style="color:red; font-size:14px;">${msg}</p>
    </c:if>
    <form action="login" method="post">
        <label><spring:message code="login.email" text="Email"/></label>
        <input type="email" placeholder="Enter Email" name="email" required="required">
        <label><spring:message code="login.password" text="Password"/></label>
        <input type="password" placeholder="Password" name="password" required="required">

        <div class="check">
            <input type="checkbox" id="checking" name="checking" value="Check">
            Check
        </div>
        <input type="submit" value="Submit">
        <a href="register" class="registerCss" role="button">Register</a>
        <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
    </form>
</div>