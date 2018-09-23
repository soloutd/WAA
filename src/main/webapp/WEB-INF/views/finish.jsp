<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../../resource/js/bid.js"></script>
<script src="../../resource/js/sockjs.min.js"></script>
<script src="../../resource/js/stomp.min.js"></script>
</head>
<body>
	<h1>Car auction</h1>

	<table>
		<tr>
			<td>Car ID:</td>
			<td><div id="carid">${car.id}</div></td>
		</tr>
		<tr>
			<td>Car name:</td>
			<td>${car.name}</td>
		</tr>
		<tr>
			<td>High price:</td>
			<td><div id="highprice" style="color: red; font-weight: bold;">${highprice}</div></td>
		</tr>
	</table>

	<form>
		<button id="finishbid">Finish</button>
	</form>

	<c:url value="/" var="url" />
	<a id="bataa" href='${url}'></a>
	<div id="msg"></div>
</body>
</html>
