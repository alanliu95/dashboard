function currentPage() {
    $('#home-container').empty();
    $('#home-container').load('/current.html');
}

function historyPage() {
    $('#home-container').empty();
    $('#home-container').load('/lab.html');
}