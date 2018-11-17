function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
}

function connect() {
    window.socket = new WebSocket("ws://localhost:8881/sample/handler");
    setConnected(true);
    clearTable();
    socket.onmessage = function (event) {
        var msg = event.data;
        showResponse(msg);
    }
}

function disconnect() {
    window.socket.close();
    setConnected(false);
    console.log("Disconnected");
}

function showResponse(message) {
    console.log(message)
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendName();
    });
});