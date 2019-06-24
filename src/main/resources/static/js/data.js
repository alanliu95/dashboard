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
    var httpReq= new XMLHttpRequest();
    httpReq.onreadystatechange=
        function () {
            if (httpReq.readyState==4 && httpReq.status==200)
            {
                document.getElementById("SIM1").innerHTML=httpReq.responseText;

            }
        };
    httpReq.open("get","/event?id="+id,true);
    httpReq.send();
}

function getRecords() {
    var id =document.getElementById("device").value;
    var httpReq= new XMLHttpRequest();
    httpReq.onreadystatechange=
        function () {
            if (httpReq.readyState==4 && httpReq.status==200)
            {
                document.getElementById("record").innerHTML=httpReq.responseText;

            }
        };
    httpReq.open("get","/data/records?devName="+id,true);
    httpReq.send();
}

function setDev() {

    var siteSlt=document.getElementById("site");
    var index=siteSlt.selectedIndex;
    //if(index==0) return;
    var siteVal=siteSlt.options[index].text;
    var slt=document.getElementById("device");
    //console.debug(siteVal);
    slt.length=0;
    //sltCity[i+1]=new Option(provinceCity[i],provinceCity[i]);
    var arrDev=devs[siteVal];
    //console.debug(devs[siteVal][0]);
    for(var i=0;i<arrDev.length;i++){
        //console.debug(k);
        slt[i]=new Option(arrDev[i],arrDev[i]);
        // var objOption=document.createElement("OPTION");
        // objOption.text=k;
        // objOption.value=k;
        // slt.add(objOption);
    }
}


var devs;
window.onload=function(){
    var httpReq= new XMLHttpRequest();
    httpReq.onreadystatechange=
        function () {
            if (httpReq.readyState==4 && httpReq.status==200)
            {
                var slt=document.getElementById("site");
                //document.getElementById("debug").innerHTML=httpReq.responseText;
                devs=JSON.parse(httpReq.responseText);
                for(var k in devs){
                    var objOption=document.createElement("OPTION");
                    objOption.text=k;
                    objOption.value=k;
                    slt.add(objOption);
                }
                setDev();
            }
        };
    httpReq.open("get","/data/devices",true);
    httpReq.send();
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