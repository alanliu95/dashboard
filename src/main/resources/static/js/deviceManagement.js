var devs;
var currDevName;

$(document).ready(function () {
    //console.debug("init:::::::dom加载完成，开始获取dev");
    //initSiteSlt();
});

function initSiteSlt() {
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
                refreshDevSlt();
            }
        };
    httpReq.open("get", "/data/devices", true);
    httpReq.send();
}

// // 下拉列表“场地”被修改时，触发 设置下拉列表“设备”的选项
// function refreshDevSlt() {
//     var siteSlt = document.getElementById("site");
//     //获取列表当前选中值的索引
//     var index = siteSlt.selectedIndex;
//     //if(index==0) return;
//     var siteVal = siteSlt.options[index].text;
//     var devSlt = document.getElementById("device");
//     //清空devSlt值
//     devSlt.length = 0;
//     //全局变量 devs
//     var arrDev = devs[siteVal];
//     for (var i = 0; i < arrDev.length; i++) {
//         devSlt[i] = new Option(arrDev[i], arrDev[i]);
//     }
// }
function refreshDevList() {
    var siteSlt = document.getElementById("site");
    //获取列表当前选中值的索引
    var index = siteSlt.selectedIndex;
    var siteVal = siteSlt.options[index].value;
    devManageUrlSuffix = '?siteId=' + siteVal;
    $('#home-container').load('/deviceManagement' + devManageUrlSuffix);
}

function getStatus() {
    currDevName = document.getElementById("device").value;
    var httpReq = new XMLHttpRequest();
    httpReq.onreadystatechange =
        function () {
            if (httpReq.readyState == 4 && httpReq.status == 200) {
                var text = httpReq.responseText;
                //console.debug(text);
                // if (text == "no"){
                //
                // }
                // else {
                //     var recJson = JSON.parse(text);
                // }
                var statusDev = document.getElementById("status");
                statusDev.innerHTML = text;

            }
        };
    httpReq.open("get", "http://localhost:9090/online/" + currDevName, true);
    httpReq.send();
}

function recordHandler() {


}