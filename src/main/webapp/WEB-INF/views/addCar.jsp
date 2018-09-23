<%--
  Created by IntelliJ IDEA.
  User: Skad1
  Date: 2018-07-17
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
    <a href="/">Home</a>
    <div class="jumbotron">
        <div class="container">
            <h1>Valued Cars</h1>
            <p>Add a new one<p>
        </div>
    </div>
</section>
<section class="container">
    <form:form  modelAttribute="newCar" class="form-horizontal" method="post" enctype="multipart/form-data"  >
        <fieldset>
            <legend>New car</legend>

            <form:errors path="*" cssClass="alert alert-danger" element="div"/>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="carNumber"> Car Number</label>
                <div class="col-lg-10">
                    <form:input id="carNumber" path="carNumber" type="number" class="form:input-large"/>
                    <form:errors path="carNumber" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="name">Car Name</label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text" class="form:input-large"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="name">Car Price</label>
                <div class="col-lg-10">
                    <form:input id="price" path="price" type="number" class="form:input-large"/>
                    <form:errors path="price" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="name">Car MileAge</label>
                <div class="col-lg-10">
                    <form:input id="mileAge" path="mileAge" type="number" class="form:input-large"/>
                    <form:errors path="mileAge" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="name">ExpireDate</label>
                <div class="col-lg-10">
                    <form:input id="expireDate" path="expireDate" placeholder="MM/dd/yyyy" class="form:input-large"/>
                    <form:errors path="expireDate" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="name">Car Transmission</label>
                <div class="col-lg-10">
                    <form:input id="transmisson" path="transmisson" type="text" class="form:input-large"/>
                    <form:errors path="transmisson" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="name">Car Color</label>
                <div class="col-lg-10">
                    <form:input id="color" path="color" type="text" class="form:input-large"/>
                    <form:errors path="color" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="name">Car Description</label>
                <div class="col-lg-10">
                    <form:textarea rows="6" class="form-control" placeholder="Car detail" path="description" required="required"></form:textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="name">Car Engine</label>
                <div class="col-lg-10">
                    <form:input id="engine" path="engine" type="text" class="form:input-large"/>
                    <form:errors path="engine" cssClass="text-danger"/>
                </div>
            </div>
            <div  class="form-group">
                <label class="control-label col-lg-2" for="name">Image</label>
                <div class="col-lg-10" id="addImg">
                        <form:input id="addImg" path="inputImages" type="file" multiple="multiple" required="required"/>
                </div>
            </div>


            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
                </div>
            </div>

        </fieldset>
    </form:form>
</section>
</body>
</html>
