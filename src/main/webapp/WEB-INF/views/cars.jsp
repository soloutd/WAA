<%--
  Created by IntelliJ IDEA.
  User: Skad1
  Date: 2018-07-17
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section>
    <div class="jumbotron">
        <a href="<c:url value="/cars/add" />" class="btn btn-danger btn-mini pull-right">Add a new one</a>
    </div>
</section>
<div class="cars">
    <ul>
        <c:forEach items="${cars}" var="car">
        <li>
            <img  src="<c:url value="/uploadimage/${car.mainPicturePath}"/>" >
            <h3> Insert user:${car.user.firstName} </h3>
            <h3> Car Name : ${car.name}</h3>
            <p>${car.description}</p>
            <a href="bid/${car.id}">Bid</a>
            <a href="finish/${car.id}">Finish</a>
        </li>
        </c:forEach>
    </ul>
</div>