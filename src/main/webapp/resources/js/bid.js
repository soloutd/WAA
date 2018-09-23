var stompClient = null;

function connect() {
	var socket = new SockJS(window.location.origin + $("#bataa").attr('href')
			+ 'carbid');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/bid', function(bid) {
			console.log('Bid: ' + bid);
			if (parseInt($("#carid").text()) === JSON.parse(bid.body).carid) {
				showBids(JSON.parse(bid.body).newbid);
				$("#highprice").text(JSON.parse(bid.body).highbid);
			}
		});
	});
}

function sendBid() {
	stompClient.send("/app/bid", {}, JSON.stringify({
		'price' : $("#bidprice").val(),
		'id' : $("#carid").text()
	}));
}

function finishBid() {
	$("#msg").html("Finished.");

	var home = window.location.origin + $("#bataa").attr('href')
	console.log("aaaaaaaaaaaa...........");
	$.ajax({
		url : home + "cars/finish/" + $("#carid").text(),
		type : "POST",
		success : function(result) {
			$("#msg").append(" MUM")
			$("#highprice").html(result.highbid);
		},
		error: function(){
			alert("ERRORRRRR");
		}
	});
}

function showBids(message) {
	$("#bids").append("<tr><td>" + message + "</td></tr>");
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	connect();
	$("#sendbid").click(function() {
		sendBid();
	});
	$("#finishbid").click(function() {
		finishBid();
	});
});
