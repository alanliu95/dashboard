var hello = "hello from main.js"
var timerId;
timerId = setInterval(function () {
}, 4000);
function currentPage() {
    clearInterval(timerId);
    // console.debug("currentPage");
    $('#home-container').empty();
    $('#home-container').load('/current.html');
}

function historyPage() {
    clearInterval(timerId);
    // console.debug("historyPage");
    $('#home-container').empty();
    $('#home-container').load('/history.html');
}