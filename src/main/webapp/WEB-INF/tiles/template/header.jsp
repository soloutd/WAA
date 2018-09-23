<%--
  Created by IntelliJ IDEA.
  User: Skad1
  Date: 2018-07-17
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true" %>
<header>
    <ul>
        <li style="float: right"><a href="?language=mn_MN">Mongolia</a></li>
        <li style="float: right"><a  href="?language=en_US">English</a></li>
        <li><a href="<c:url value="/"/>"><spring:message code="menu.home" text="Home"/></a></li>
        <c:choose>
            <c:when test="${sessionScope.currentUser != null}">
                <li><a> <span> Welcome ${sessionScope.currentUser.firstName}</span></a></li>
                <li><a href="<c:url value="/cars/add"/>"><spring:message code="car.add" text="Add car"/></a></li>
                <li><a href="<c:url value="/cars/"/>"><spring:message code="car.list" text="Car list"/></a></li>

                <c:if test="${not empty sessionScope.currentUser}">
                    <c:if test="${sessionScope.currentUser.role.id == 2}">
                        <li><a href="<c:url value="/register"/>"><spring:message code="menu.register" text="Register"/></a></li>
                    </c:if>
                </c:if>
                <li>
                    <form method="get" action="<c:url value="/logout"/>">
                        <button id="logout" style="height: 46px; border: 1px solid #ccc;
    box-sizing: border-box;background: red; font-weight: bold; color:#fff;"><spring:message code="menu.logout" text="Log Out"/></button>
                    </form>
                </li>
            </c:when>
            <c:otherwise>
                <li><a href="<c:url value="/cars/"/>"><spring:message code="car.list" text="Car list"/></a></li>
                <li><a href="login"><spring:message code="menu.login" text="Log In"/></a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</header>