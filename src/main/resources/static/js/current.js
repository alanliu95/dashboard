var devs;
var myChart;
var myChart2;
var currDevName;
var timerId;

option = {
    tooltip: {
        formatter: "{a} <br/>{b} : {c}%"
    },
    toolbox: {
        feature: {
            restore: {},
            saveAsImage: {}
        }
    },
    series: [
        {
            name: 'cpu',
            type: 'gauge',
            detail: {formatter: '{value}%'},
            data: [{value: 0, name: 'cpu'}]
        }
    ]
};
option2 = {
    tooltip: {
        formatter: "{a} <br/>{b} : {c}%"
    },
    toolbox: {
        feature: {
            restore: {},
            saveAsImage: {}
        }
    },
    series: [
        {
            name: 'mem',
            type: 'gauge',
            detail: {formatter: '{value}%'},
            data: [{value: 0, name: 'mem'}]
        }
    ]
};
console.debug("i am from current.js");
init();
window.onload = function () {
    console.debug("dom加载完成，开始获取dev")
    var httpReq = new XMLHttpRequest();
    httpReq.onreadystatechange =
        function () {
            if (httpReq.readyState == 4 && httpReq.status == 200) {
                var slt = document.getElementById("site");
                //document.getElementById("debug").innerHTML=httpReq.responseText;
                devs = JSON.parse(httpReq.responseText);
                for (var k in devs) {
                    var objOption = document.createElement("OPTION");
                    objOption.text = k;
                    objOption.value = k;
                    slt.add(objOption);
                }
                setDev();
            }
        };
    httpReq.open("get", "/data/devices", true);
    httpReq.send();


    myChart = echarts.init(document.getElementById('main'));
    myChart.setOption(option);

    myChart2 = echarts.init(document.getElementById('main2'));
    myChart2.setOption(option2);
    timerId = setInterval(function () {
    }, 4000);
}

function init() {
    console.debug("dom加载完成，开始获取dev")
    var httpReq = new XMLHttpRequest();
    httpReq.onreadystatechange =
        function () {
            if (httpReq.readyState == 4 && httpReq.status == 200) {
                var slt = document.getElementById("site");
                //document.getElementById("debug").innerHTML=httpReq.responseText;
                devs = JSON.parse(httpReq.responseText);
                for (var k in devs) {
                    var objOption = document.createElement("OPTION");
                    objOption.text = k;
                    objOption.value = k;
                    slt.add(objOption);
                }
                setDev();
            }
        };
    httpReq.open("get", "/data/devices", true);
    httpReq.send();


    myChart = echarts.init(document.getElementById('main'));
    myChart.setOption(option);

    myChart2 = echarts.init(document.getElementById('main2'));
    myChart2.setOption(option2);
    timerId = setInterval(function () {
    }, 4000);
}

function recordHandler() {
    var httpReq = new XMLHttpRequest();
    httpReq.onreadystatechange =
        function () {
            if (httpReq.readyState == 4 && httpReq.status == 200) {
                var text = httpReq.responseText;
                //console.debug(text);
                if (text == "no") return;
                var recJson = JSON.parse(text);
                option.series[0].data[0].value = recJson.cpu.toFixed(2);
                option2.series[0].data[0].value = recJson.mem.toFixed(2);
                myChart.setOption(option, true);
                myChart2.setOption(option2, true);
            }
        };
    httpReq.open("get", "http://localhost:9090/devices/" + currDevName, true);
    httpReq.send();

}

function getOneRecord() {
    clearInterval(timerId);
    //将表格数值清零
    currDevName = document.getElementById("device").value;
    //recordHandler();
    timerId = setInterval(recordHandler, 4000);
}

function setDev() {
    var siteSlt = document.getElementById("site");
    var index = siteSlt.selectedIndex;
    //if(index==0) return;
    var siteVal = siteSlt.options[index].text;
    var slt = document.getElementById("device");
    //console.debug(siteVal);
    slt.length = 0;
    //sltCity[i+1]=new Option(provinceCity[i],provinceCity[i]);
    var arrDev = devs[siteVal];
    //console.debug(devs[siteVal][0]);
    for (var i = 0; i < arrDev.length; i++) {
        //console.debug(k);
        slt[i] = new Option(arrDev[i], arrDev[i]);
    }
}