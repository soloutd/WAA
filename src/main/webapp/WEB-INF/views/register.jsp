<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Skad1
  Date: 2018-07-18
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form" style="margin-top:50px!important; margin-bottom : 100px;">
    <form:form modelAttribute="user" method="post">
        <div class="form-group">
            <div class="col-lg-6">
                <spring:message code="user.firstName"   text="Username:" var="username"/>
                <form:input class="form-control" path="firstName"  placeholder="${username}"/>
                <form:errors path="firstName" class="error"/>
            </div>
            <div class="col-lg-6">
                <spring:message code="user.lastName"  text="Lastname:" var="lastname"/>
                <form:input class="form-control" path="lastName"  placeholder="${lastname}" />
                <form:errors path="lastName" class="error"/>
            </div>
        </div>
        <div class="form-group">
            <form:select  class="form-control" items="${roles}" path="role.id" itemLabel="roleName" itemValue="id"/>
        </div>

        <div class="form-group">
            <spring:message code="user.email" text="Email:" var="email"/>
            <form:input  class="form-control" placeholder="${email}"  path="email" />
            <form:errors path="email" class="error"/>
        </div>

        <div class="form-group">
            <spring:message code="user.password" text="Password:" var="password"/>
            <form:input type="password"  class="form-control" placeholder="${password}" path="password"/>
            <form:errors path="password" class="error"/>
        </div>

        <div class="form-group">
            <spring:message code="user.mobile" text="Mobile:" var="mobile"/>
            <form:input class="form-control" placeholder="${mobile}" path="mobile" />
            <form:errors path="mobile" class="error"/>
        </div>

        <div class="form-group">
            <spring:message code="address.street" text="Street:" var="street"/>
            <form:input class="form-control"  placeholder="${street}" path="address.street"/>
            <form:errors path="address.street" class="error"/>
        </div>
        <div class="form-group">
            <spring:message code="address.city" text="City:" var="city"/>
            <form:input  class="form-control"  placeholder="${city}" path="address.city"/>
            <form:errors path="address.city" class="error"/>
        </div>
        <div class="form-group">
            <spring:message code="address.state" text="State:" var="state"/>
            <form:input  class="form-control" placeholder="${state}" path="address.state"/>
            <form:errors path="address.state" class="error"/>
        </div>
        <div class="form-group">
            <spring:message code="address.zipcode" text="Zipcode:" var="zipcode"/>
            <form:input class="form-control"  placeholder="${zipcode}" path="address.zipcode"/>
            <form:errors path="address.zipcode" class="error"/>
        </div>
        <button style="width: 100%; padding: 10px 0;background: tomato;border: none; color: #fff;" type="submit" class="btn btn-success" name="Submit"><spring:message code="register" text="Register"/></button>
    </form:form>
</div>
