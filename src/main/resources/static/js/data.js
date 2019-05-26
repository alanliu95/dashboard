refresh();
function refresh() {
    window.setInterval(getEvent,1000);
}

function getEvent() {
    var xmlhttp= new XMLHttpRequest();
    xmlhttp.onreadystatechange=
        function () {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("SIM1").innerHTML=xmlhttp.responseText;
            }
        }
    ;
    xmlhttp.open("get","/event",false);
    xmlhttp.send();

}