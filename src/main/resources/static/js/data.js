//refresh();
function refresh() {
    window.setInterval(getEvent,2000);
}
function query() {
    var id =document.getElementById("recordId").value;
    var xmlhttp= new XMLHttpRequest();
    xmlhttp.onreadystatechange=
        function () {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                //document.getElementById("SIM1").innerHTML=xmlhttp.responseText;
                var record=JSON.parse(xmlhttp.responseText);
                //console.debug("hello");
                document.getElementById("sim1-ts").innerHTML=record.ts;
                document.getElementById("sim1-cpu").innerHTML=record.cpuUsage;
                document.getElementById("sim1-mem").innerHTML=record.memUsage;

//{"deviceId":"1","ts":"2019-03-24 22:38:07","cpuUsage":69.1146,"memUsage":93.8266,"id":1}
            }
        }
    ;
    //console.debug("/event?id="+id);
    xmlhttp.open("get","/event?id="+id,true);
    xmlhttp.send();
}

function query2() {
    var id =document.getElementById("recordId").value;
    var xmlhttp= new XMLHttpRequest();
    xmlhttp.onreadystatechange=
        function () {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("SIM1").innerHTML=xmlhttp.responseText;

            }
        }
    ;
    //console.debug("/event?id="+id);
    xmlhttp.open("get","/event?id="+id,true);
    xmlhttp.send();
}


function getEvent() {
    var xmlhttp= new XMLHttpRequest();
    xmlhttp.onreadystatechange=
        function () {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                //document.getElementById("SIM1").innerHTML=xmlhttp.responseText;
                var record=JSON.parse(xmlhttp.responseText);
                //console.debug("hello");
                document.getElementById("sim1-ts").innerHTML=record.ts;
                document.getElementById("sim1-cpu").innerHTML=record.cpuUsage;
                document.getElementById("sim1-mem").innerHTML=record.memUsage;//{"deviceId":"1","ts":"2019-03-24 22:38:07","cpuUsage":69.1146,"memUsage":93.8266,"id":1}
            }
        }
    ;
    xmlhttp.open("get","/event",true);
    xmlhttp.send();

}