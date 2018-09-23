<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="../../resource/js/bid.js"></script>
	<script src="../../resource/js/sockjs.min.js"></script>
	<script src="../../resource/js/stomp.min.js"></script>
</head>
<style >
div{
	backgroundcolor= "blue";
}
</style>
<body>
	<h1>Car auction</h1>

	<table>
		<tr>
			<td>Car ID:</td>
			<td><div id="carid">${car.id}</div></td>
		</tr>
		
			<img style=width:50%; src="<c:url value="/uploadimage/${car.mainPicturePath}"/>" >
		
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
		<label for="name">Your price:</label> <input type="text" id="bidprice"
			value="0">
		<button id="sendbid">Bid</button>
	</form>

	<c:url value="/" var="url" />
	<a id="bataa" href='${url}'></a>

	<table>
		<thead>
			<tr>
				<th><h2>Bids</h2></th>
			</tr>
		</thead>
		<tbody id="bids">
		</tbody>
	</table>
</body>
</html>
