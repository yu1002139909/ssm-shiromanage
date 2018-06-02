<%--
  Created by IntelliJ IDEA.
  User: yuyu
  Date: 2018/2/8
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
        #allmap{height:500px;width:100%;}
        #r-result{width:100%; font-size:14px;}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=HyletaniKAZlSzMhT0bOCZFP1m1K7ZfZ"></script>
    <title>城市名定位</title>
</head>
<body>
<div id="allmap"></div>
<div id="r-result">
    地址: <input id="cityName" type="text" style="width:100px; margin-right:10px;" />
    <input type="button" value="查询" onclick="theLocation()" />
    经度:<input type="text" id="jd"/>纬度<input type="text" id="wd"/>
</div>
</body>
</html>
<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(116.331398,39.897445);
    map.centerAndZoom('广州',11);
    map.addEventListener("click",function(e){
        var input =  document.getElementById('wd');
        var input2 =  document.getElementById('jd');
        input.value = e.point.lng;
        input2.value= e.point.lat;

    });


    map.addControl(new BMap.NavigationControl());


    var local = new BMap.LocalSearch(map, {
        renderOptions:{map: map}
    });
    function theLocation(){
        var city = document.getElementById("cityName").value;
        if(city != ""){
            local.search(city);
        }
    }
</script>
