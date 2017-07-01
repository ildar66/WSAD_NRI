<%@ page language = "java" %>
<%@ page import="java.util.*,com.hps.july.siteinfo.actionbean.MapHandlingBean,
                 com.hps.july.siteinfo.valueobject.RegionAndMap,
                 com.hps.july.siteinfo.valueobject.ValueObject" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<html>
<head>
<title></title>
<meta http-equiv="content-type" content="text/html;  charset=windows-1251" />
<meta http-equiv="content-script-type" content="text/javascript" />
<meta http-equiv="content-style-type" content="text/css" />
<link rel="stylesheet" type="text/css" href="/main.css" />
<link rel="stylesheet" type="text/css" href="/main1.css" />
</head>
<script language="JavaScript">
<!--

    function beforeSubmit() {
        return true;
    }

    onload = function(e) {
        document.getElementById('mapContainer').style.textAlign  = 'center';
        document.getElementById('mapContainer').style.verticalAlign  = 'middle';
    }

    function setCursor(number) {
        var element = document.getElementById('realImage');
        var value = -1;
        for(i = 0; i < document.mapList.control.length; i++) {
            if(document.mapList.control[i].checked) {
                value = document.mapList.control[i].value;
                break;
            }
        }
        if(value == 1 || value == 2 || value == 3) {
            element.style.cursor = 'crosshair';
        } else {
            if(value == 4) {
                element.style.cursor = 'help';
            } else {
                element.style.cursor = 'default';
            }
         }
    }
-->
</script>
<style><!--

--></style>
<body>
<form name="mapView" method="post" action="/map/mapPrepareData1" onsubmit="beforeSubmit();">
    <input type="hidden" name="region" id="region" value=""/>
    <input type="hidden" name="map" id="map" value=""/>
    <input type="hidden" name="zoom" id="zoom" value=""/>
    <input type="hidden" name="gsm" id="gsm" value=""/>
    <input type="hidden" name="damps" id="damps" value=""/>
    <input type="hidden" name="dcs" id="dcs" value=""/>
    <input type="hidden" name="controller" id="controller" value=""/>
    <input type="hidden" name="rrl" id="rrl" value=""/>
    <input type="hidden" name="vols" id="vols" value=""/>
    <input type="hidden" name="marker" id="marker" value=""/>
    <input type="hidden" name="control" id="control" value=""/>
    <input type="hidden" name="clickOnImage" id="clickOnImage" value=""/>
    <input type="hidden" name="direction" id="direction" value=""/>
    <input type="hidden" name="clientHeight" id="clientHeight" value=""/>
    <input type="hidden" name="clientWidth" id="clientWidth" value=""/>
    <input type="image" id="realImage" name="realImage" src="mapView" onclick="return onImage();" style="" onmouseover="setCursor(1);" onmouseout="setCursor(2);" />
</form>
</body>
</html>
