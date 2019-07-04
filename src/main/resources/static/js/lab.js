var inited=0;
var myChart;
function lineChart(recJson) {
    if(inited==0){
        inited=1;
        myChart = echarts.init(document.getElementById('main'));
    }
    console.debug(recJson["ts"]);

    // 指定图表的配置项和数据
    var option = {
        xAxis: {
            type: 'category',
            data: recJson["ts"],
        },
        yAxis: {
            type: 'value',
            max: 100,
            min: 0
        },
        legend: {
            data:['cpu利用率','mem利用率']
        },
        series: [{
            name: 'cpu利用率',
            data: recJson["cpu"],
            type: 'line'
        },{
            name: 'mem利用率',
            data: recJson["mem"],
            type: 'line'
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}
function getRecords() {
    var id =document.getElementById("device").value;
    var httpReq= new XMLHttpRequest();
    httpReq.onreadystatechange=
        function () {
            if (httpReq.readyState==4 && httpReq.status==200)
            {
                var text=httpReq.responseText;
                document.getElementById("record").innerHTML=httpReq.responseText;
                var recsJson=JSON.parse(text);
                lineChart(recsJson);
            }
        };
    httpReq.open("get","/data/records?currDevName="+id,true);
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
function init(){
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
console.debug('i am from lab.js');
init();