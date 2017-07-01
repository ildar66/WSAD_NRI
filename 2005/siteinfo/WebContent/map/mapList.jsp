<%@ page language = "java" %>
<%@ page import="java.util.*,com.hps.july.siteinfo.actionbean.MapHandlingBean,
                 com.hps.july.siteinfo.valueobject.ValueObject,
                 com.hps.july.siteinfo.manager.Constants,
                 com.hps.july.web.util.StateNavigator,
                 com.hps.july.web.util.StateNavigatorObject" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<% MapHandlingBean mhb = (MapHandlingBean)session.getAttribute(Constants.MAP_HANDLING_BEAN); %>
<html>
<head>
<title>Модуль "Карты"</title>
<meta http-equiv="content-type" content="text/html;  charset=windows-1251" />
<meta http-equiv="content-script-type" content="text/javascript" />
<meta http-equiv="content-style-type" content="text/css" />
<link rel="stylesheet" type="text/css" href="/main.css" />
<link rel="stylesheet" type="text/css" href="/main1.css" />
</head>
<script language="JavaScript">
<!--
    var posInfo = null;
    function beforeSubmit() {
        document.mapList.supregion.value = document.mapList.supregions.options[document.mapList.supregions.selectedIndex].value;
        document.mapList.map.value = document.mapList.maps.options[document.mapList.maps.selectedIndex].value;
        if(document.mapList.supregion.value == 0 || document.mapList.supregion.value == '') {
            alert('Укажите суперрегион !');
            return false;
        }
        if(document.mapList.map.value == 0 || document.mapList.map.value == '') {
            alert('Укажите карту для суперрегиона  !');
            return false;
        }
        document.mapList.region.value = document.mapList.regions.options[document.mapList.regions.selectedIndex].value;
        document.mapList.clientWidth.value = document.body.clientWidth;
        document.mapList.clientHeight.value = document.body.clientHeight;
        //var wasPosted = document.getElementById('wasposted');
        //if(wasPosted && wasPosted.value && wasPosted.value == '1') {
            //alert('Запрос уже выполняется !');
            //return false;
        //}
        //if(wasPosted) wasPosted.value = '1';
        return true;
    }

    onload = function(e) {

        createSuperRegionSelect();

        document.getElementById('previousImage').src = 'mapViewPrevious';
        with(document.getElementById('previousImage')) {
            onerror = function(e) {
                document.getElementById('wait-box2').style.visibility = 'hidden';
                document.getElementById('wait-box').style.visibility = 'visible';
            }
            onload = function(e) {
                document.getElementById('wait-box2').style.visibility = 'visible';
                document.getElementById('wait-box').style.visibility = 'visible';
            }
        }
        <%
            if(mhb != null && mhb.isMessageReady()) {
	            Object[] messages = mhb.getMessages();
	            for (int i = 0; i < messages.length; i++) {
	                ValueObject message = (ValueObject)messages[i];
	                Object mType = message.getAttribute(Constants.MESSAGE_TYPE);
	                if(mType != null && (mType instanceof java.lang.Integer)) {
	                    switch(((Integer)mType).intValue()) {
	                    	case 1: {
						        %>
						            var url = '';
                                    url = url + "?";
                                    url = url + "clientWidth=" + document.body.clientWidth;
                                    url = url + "&clientHeight=" + document.body.clientHeight;
						            document.getElementById('realImage').src = ('mapViewPrevious' + url);
						        <%
	                    	}
	                    	case 3: {
						        %>
						            var url = '';
                                    url = url + "?";
                                    url = url + "clientWidth=" + document.body.clientWidth;
                                    url = url + "&clientHeight=" + document.body.clientHeight;
						            document.getElementById('realImage').src = ('mapViewPrevious' + url);
						        <%
	                    	}
	                    	case 5: {
						        %>
						            var url = '';
                                    url = url + "?";
                                    url = url + "clientWidth=" + document.body.clientWidth;
                                    url = url + "&clientHeight=" + document.body.clientHeight;
						            document.getElementById('realImage').src = ('mapViewPrevious'  + url);
						        <%
	                    	}
	                    	default: {
						        %>
						            var url = '';
                                    url = url + "?";
                                    url = url + "clientWidth=" + document.body.clientWidth;
                                    url = url + "&clientHeight=" + document.body.clientHeight;
						            document.getElementById('realImage').src = ('mapView' + url);
						        <%
	                    	}
	                    }
	                }
	        	}
            } else {
        %>
                var url = '';
                url = url + "?";
                url = url + "clientWidth=" + document.body.clientWidth;
                url = url + "&clientHeight=" + document.body.clientHeight;
                document.getElementById('realImage').src = ('mapView' + url);
        <%
            }
        %>

        with (document.getElementById('realImage')) {
            onload = function(e) {
                document.getElementById('wait-box').style.visibility = 'hidden';
                document.getElementById('wait-box2').style.visibility = 'hidden';
                document.getElementById('wait-box1').style.visibility = 'visible';
                document.body.style.cursor='default';
                document.getElementById('realZoom').src = 'map/mapZoom.jsp';
            }
            onerror = function(e) {
                if(document.mapList.supregion && (document.mapList.supregion.value == 0 || document.mapList.supregion.value == '')) {
                    document.getElementById('wait-box').style.visibility = 'visible';
                    document.getElementById('wait-box2').style.visibility = 'hidden';
                    document.getElementById('wait-box1').style.visibility = 'hidden';
                } else {
                    document.getElementById('wait-box').style.visibility = 'visible';
                    document.getElementById('wait-box2').style.visibility = 'visible';
                    document.getElementById('wait-box1').style.visibility = 'hidden';
                }
                document.body.style.cursor='default';
                document.getElementById('realZoom').src = 'map/mapZoom.jsp';
            }
        }
        <%
            if(mhb != null) {
                System.out.println("1");
                if(mhb.isMessageReady()) {
                    Object[] messages = mhb.getMessages();
                    for (int i = 0; i < messages.length; i++) {
                        ValueObject message = (ValueObject)messages[i];
                        Object mType = message.getAttribute(Constants.MESSAGE_TYPE);
                        if(mType != null && (mType instanceof java.lang.Integer)) {
                            switch(((Integer)mType).intValue()) {
                                //InfoObjects - информация о содержании объектов в указанной точке
                                case 1: {
                                    Collection c = (Collection)request.getAttribute("InfoObjects");
                                    if(c != null && c.size() == 1) {
                                        Integer id = new Integer(-1);
                                        String type = null;
                                        for (Iterator iterator = c.iterator(); iterator.hasNext();) {
                                            ValueObject vo = (ValueObject)iterator.next();
                                            String s = (String)vo.getAttribute(Constants.TYPE);
                                            if(s != null && s.equals(Constants.H)) {
                                                type = Constants.H;
                                                Integer aId = (Integer)vo.getAttribute("aId");
                                                Integer bId = (Integer)vo.getAttribute("bId");
                                                if(aId != null && aId.intValue() != -1) id = aId;
                                                else if(bId != null && bId.intValue() != -1) id = bId;
                                            } else {
                                                if(s != null && s.equals(Constants.P)) {
                                                    type = Constants.P;
                                                    String pId = (String)vo.getAttribute(Constants.PK);
                                                    if(pId != null) id = new Integer(pId);
                                                }
                                            }

                                        }
                                        if(type == Constants.H) {
                                        %>
                                            document.location.href = '/basestation/ShowComlinePositionList.do?poscode=' +<%=id%>;
                                        <%
                                        } else {
                                        %>
                                            document.location.href = '/siteinfo/EditPosition.do?action=View&storageplace=' +<%=id%>;
                                        <%
                                        }
                                    } else {
                                        %>
                                            var urlShortInfo = 'infoSearchServlet';
                                            posInfo = window.open(urlShortInfo, "PositionInfo", 'top=40,left=100,width=830,height=630,resizable=0,scrollbars = 0,statusbar=0,status=0,toolbar=0');
                                        <%
                                    }
                                    break;
                                }
                                case 5: {
                                    Object vType = message.getAttribute(Constants.MESSAGE_VALUE);
                                        %>
                                            alert('Текущие координаты:  <%=vType%>');
                                        <%
                                    break;
                                }
                            }
                        }
                    }
                    mhb.clearMessage();
                }
            }
        %>
    }

    var sendObject = new Object();
    sendObject.region = '0';
    <% String userName = request.getRemoteUser(); if(userName == null) userName = ""; %>
    sendObject.userName = '<%=userName%>';
    var posSearch = null;
    var zoneId = <%=((mhb.getZone() != null)?mhb.getZone():new Integer(-1))%>;
    var regionId = <%=((mhb.getRegion() != null)?mhb.getRegion():new Integer(-1))%>;

    function showResult() {
        var s = document.getElementById('position').value;
        var url = 'positionSearchServlet?region=' + sendObject.region + '&userName=' + sendObject.userName + '&search=' + s;
        posSearch = window.open(url, "PositionSearch", 'top=40,left=100,width=830,height=630,resizable=0,scrollbars = 0,statusbar=0,status=0,toolbar=0');
        posSearch.focus();
    }

    function setPosInfo(type, id) {
        posInfo.close();
        if(type == 'h')
            document.location.href = '/basestation/ShowComlinePositionList.do?poscode=' + id;
        else
            document.location.href = '/siteinfo/EditPosition.do?action=View&storageplace=' + id;
    }

    function clearFinder() {
        var positionStr = document.getElementById('position');
        if(positionStr) positionStr.value = '';
    }

    function setSearchResult(list) {
        document.getElementById('positionid').value = list;
        posSearch.close();
        clearFinder();
        var pos = document.getElementById('positionid').value;
        if(pos == '') return false;
        var regionS = document.mapList.supregions.options[document.mapList.supregions.selectedIndex].value;
        var mapS = document.mapList.maps.options[document.mapList.maps.selectedIndex].value;
        var url = ('spm?region=' + regionS + '&map=' + mapS + '&positionid=' + pos);
        document.location.href = url;
    }

    document.onkeypress = function() {
        if((event.keyCode == 13)) {
            event.returnValue=false;
            var s = document.getElementById('position').value;
            if(s != '') { setAvailableSearch(); return false; }
            else if(beforeSubmit()) document.forms['mapList'].submit();
        }
    }
-->
</script>
<style>
    <!--
        .title, .title tr, .title td, .title select, .title input {
            font-size : 10px;
            font-weight : none;
        }
        .title1, .title1 span, .title1 hr  {
            font-size:10px;
            font-weight : bold;
            text-decoration : underline;
        }
    -->
</style>
<body>
<script>
    <!--
        document.body.style.cursor='wait';
    -->
</script>
<form name="mapList" id="mapList" method="post" action="mapPrepare" onsubmit="return beforeSubmit();">
<input type='hidden' name='wasposted' id='wasposted' value='0'/>
    <input type="hidden" name="supregion" id="supregion" value="<% if(mhb != null && mhb.getSupregion() != null) out.print(mhb.getSupregion());%>"/>
    <input type="hidden" name="region" id="region" value=""/>
    <input type="hidden" name="zone" id="zone" value=""/>
    <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
<%--
        <tr>
    		<TD class="navigator">
            <%
                StateNavigator nav = (StateNavigator)request.getSession().getAttribute(StateNavigator.NAVIGATOR_PARAM);
                Iterator iter = nav.getNSIterator();
                while (iter.hasNext()) {
                    StateNavigatorObject o = (StateNavigatorObject)iter.next();
                    String s = o.getName();
                    out.print(">");
                    out.print(s);
                }
            %>
            </TD>
        </tr>
--%>
        <tr>
            <td width="75%" align="center" valign="middle">
                <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="100%" height="97%">
                            <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" id="mapper">
                                <tr>
                                    <td align="left" valign="top">
                                        <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
                                            <tr>
                                                <td align="left" valign="middle" width="2%">
                                                    <image src="/images/empty.gif"/>
                                                </td>
                                                <td align="center" valign="bottom" width="96%">
                                                    <table style="width : 100%; height: 100 %">
                                                        <tr>
                                                            <td style="width : 45%; text-align : left; vertical-align : middle">
                                                                <input type="hidden" value="<% if(mhb != null && mhb.getZoom() != null) out.print(mhb.getZoom());%>" name="zoom" id="zoom"/>
                                                                <table class="zoomScale" border="0" style="height : 100%">
                                                                    <tr id="zooms1" style="height : 100%"></tr>
                                                                </table>
                                                                <script>
                                                                    <!--
                                                                        <%  Object [] zooms = (mhb.getZooms() != null)?mhb.getZooms().toArray():null; %>
                                                                            var zooms = new Array(
                                                                        <%
                                                                            if(zooms != null) {
                                                                                for(int i = 0; i < zooms.length; i++) {
                                                                                    Double zoom = (Double)zooms[i];
                                                                                    out.print(zoom); if(i != zooms.length - 1) { %>,<% }
                                                                                }
                                                                            }
                                                                        %>
                                                                        );

                                                                        function setZoom(zoom) {
                                                                            for(i = 0; i < document.mapList.control.length; i++) {
                                                                                document.mapList.control[i].checked = false;
                                                                            }
                                                                            document.mapList.zoom.value = zoom;
                                                                            //alert(document.mapList.zoom.value);
                                                                            if(beforeSubmit()) document.forms['mapList'].submit();
                                                                        }

                                                                        function onImage() {
                                                                            var choosed = -1;
                                                                            for(i = 0; i < document.mapList.control.length; i++) {
                                                                                if(document.mapList.control[i].checked) {
                                                                                    choosed = i;
                                                                                    break;
                                                                                }
                                                                            }
                                                                            if(choosed == -1) {
                                                                                alert('Укажите действие при нажатии на карту !');
                                                                                return false;
                                                                            } else {
                                                                                document.mapList.clickOnImage.value = 1;
                                                                                return true;
                                                                                //document.mapList.submit();
                                                                            }
                                                                        }

                                                                        function move(direction) {
                                                                            if(direction) {
                                                                                for(i = 0; i < document.mapList.control.length; i++) {
                                                                                    document.mapList.control[i].checked = false;
                                                                                }
                                                                                document.mapList.direction.value = direction;
                                                                                beforeSubmit();
                                                                                document.mapList.submit();
                                                                            }
                                                                        }
                                                                        var zoomDiv = document.getElementById('zooms1');
                                                                        function createScroll(zoomValue) {
                                                                            for(i = 0; i < zooms.length; i++) {
                                                                                var td = document.createElement("TD");
                                                                                var onclick = document.createAttribute("class");
                                                                                //onclick.value = 'setZoom(' + zooms[i] + ')';
                                                                                onclick.value = 'selected';
                                                                                if(zooms[i] == zoomValue) {
                                                                                    td.setAttributeNode(onclick);
                                                                                }
                                                                                td.innerHTML = '<span onclick="setZoom('+zooms[i]+')" style="width : 100%; height : 100%"><image src="/images/empty.gif" /></span>';
                                                                                zoomDiv.appendChild(td);
                                                                            }
                                                                            var z = document.getElementById('zoom');
                                                                            if(z) { z.value = zoomValue; }
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
                                                            </td>
                                                            <td style="width : 55%; text-align : left; vertical-align : middle">
                                                                <image src="/images/up_map.gif" onclick="move(4);"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </td>
                                                <td align="left" valign="middle" width="2%"><image src="/images/empty.gif"/></td>
                                            </tr>
                                            <tr>
                                                <td align="right" valign="middle" width="2%"><image src="/images/left_map.gif" onclick="move(3);"/></td>
                                                <td id="mapContainer" align="center" valign="middle" width="96%">
                                                    <div id="wait-box3" style="position : relative;">
                                                        <div id="wait-box2" style="position : absolute; visibility : hidden; top :0px; left : 0px;">
                                                            <image id="previousImage"/>
                                                        </div>
                                                        <div id="wait-box" style="position : absolute; visibility : hidden; top : 0px; left : 0px; background-color : white;">
                                                            <table><tr><td id="mapInfo" align="center" valign="top">Карта загружается ...</td></tr></table>
                                                        </div>
                                                        <div id="wait-box1" style="position : absolute; visibility : hidden;top :0px; left : 0px;">
                                                            <input type="image" id="realImage" name="realImage" onclick="return onImage();" style="" onmouseover="setCursor(1);" onmouseout="setCursor(2);" />
                                                        </div>
                                                    </div>
                                                    <script>
                                                        <!--
                                                            var mapInfo = document.getElementById('mapInfo');
                                                            if(mapInfo) {
                                                                if(document.mapList.supregion.value || document.mapList.supregion.value != 0) {
                                                                    mapInfo.innerHTML = 'Карта загружается ...';
                                                                } else {
                                                                    mapInfo.innerHTML = '  Укажите карту  ';
                                                                }
                                                            }
                                                        // -->
                                                    </script>
                                                </td>
                                                <td align="left" valign="middle" width="2%"><image src="/images/right_map.gif" onclick="move(1);"/></td>
                                            </tr>
                                            <tr>
                                                <td align="left" valign="middle" width="2%"><image src="/images/empty.gif"/></td>
                                                <td align="center" valign="top" width="96%"><image src="/images/down_map.gif" onclick="move(2);"/></td>
                                                <td align="left" valign="middle" width="2%"><image src="/images/empty.gif"/></td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <script>
                                <!--
                                    var w = 700;
                                    var h = 525;
                                    var clientW = document.body.clientWidth;
                                    var clientH = document.body.clientHeight;
                                    if(clientW && clientW > 1250) w = 984;
                                    if(clientH && clientH > 870) h = 748;
                                    with(document.getElementById('wait-box3')) {
                                        style.width = w + 2;
                                        style.height = h + 2;
                                        style.border = '1px solid black';
                                    }
                                    with(document.getElementById('wait-box')) {
                                        style.border = '3px solid black';
                                        style.left = (w / 2) - 60;
                                        style.top = (h / 2) - 20;
                                        style.visibility = 'visible';
                                    }
                                -->
                            </script>
                        </td>
                    </tr>
                    <tr class="title">
                        <td width="100%" height="3%">
                            <%
                                String backUrl = (String)request.getAttribute(Constants.BACK_URL);
                                if(backUrl == null) backUrl = "main.do?navclear=1";

                            %>
                            <span class="title1"><a href="<%=backUrl%>" title="Назад" onclick="document.body.style.cursor='wait';"><img src="/images/cancel.gif" border='0' alt='Назад'></a></span>&nbsp;
                        </td>
                    </tr>
                </table>
            </td>
            <td width="25%" valign="top">
                <table width="100%" height="100%" border="0" cellspacing="0">
                    <tr class="title">
                        <td align="left" valign="top">
                            <table width="100%" border="0" cellspacing="0">
                                <tr class="title">
                                    <td align="left" valign="top" class="title1"><span class="title1"><a href="<%=backUrl%>" title="Назад" onclick="document.body.style.cursor='wait';"><img src="/images/cancel.gif" border='0' alt='Назад'></a></span></td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title1">Суперрегионы :</td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title">
                                        <select id="supregions" onchange="createRegionSelect(this); createMapSelect(this);" style="width : 170px">
                                            <option required="true" value="0">______________________</option>
                                        </select>
                                        &nbsp;&nbsp;<input type="image" src="/images/refresh.gif"  onclick="" border='0' alt='Искать'>

                                    </td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title1">Карты :</td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title">
                                        <select id="maps" style="width : 170px">
                                            <option required="true" value="0">______________________</option>
                                        </select>
                                        <input type="hidden" name="map" id="map" value="<% if(mhb != null && mhb.getMap() != null) out.print(mhb.getMap());%>"/>
                                            <script language="JavaScript">
                                            <!--
                                                function getName() { return this.name; }
                                                function  getId() { return this.id; }
                                                function setName(name) { this.name = name; }
                                                function setId(id) { this.id = id; }
                                                function hasChilds() { return this.childs }
                                                function ValueObject(id, name, childs) {
                                                    this.name = name;
                                                    this.id = id;
                                                    this.childs = (childs == 1)?true:false;

                                                    this.getName = getName;
                                                    this.getId = getId;
                                                    this.setName = setName;
                                                    this.setId= setId;
                                                    this.hasChilds = hasChilds;
                                                }

                                    <%
                                        Collection arrays = (Collection)request.getAttribute(Constants.REGIONS_MAPS_OBJECTS);
                                        if(arrays != null) {
                                            for (Iterator iterator = arrays.iterator(); iterator.hasNext();) {
                                                String array = (String)iterator.next();
                                                %><%=array%><%
                                            }
                                        }
                                    %>
                                            function createSuperRegionSelect() {
                                                var supregionId = document.getElementById('supregion').value;

                                                var supreg = document.getElementById('supregions');
                                                var reg = document.getElementById('regions');
                                                var zone = document.getElementById('zones');
                                                var map = document.getElementById('maps');
                                                removeOptions(reg);
                                                removeOptions(zone);
                                                for(i = 0; i < supregions.length; i++) {
                                                    var option = createOption(supregions[i]);
                                                    if(supregionId && supregionId == supregions[i].getId()) {
                                                        var selected = document.createAttribute('selected');
                                                        selected.value = 'selected';
                                                        option.setAttributeNode(selected);
                                                    }
                                                    supreg.appendChild(option);
                                                }

                                                if(supregionId && supregionId != '') {
                                                    createMapSelect(supreg);
                                                    createRegionSelect(supreg);
                                                    createZoneSelect(reg);
                                                }
                                            }

                                            function createRegionSelect(supreg) {
                                                var reg = document.getElementById('regions');
                                                var zone = document.getElementById('zones');
                                                var map = document.getElementById('maps');
                                                removeOptions(reg); //delete regions
                                                removeOptions(zone); //delete zones
                                                if(supreg.value == 0) return;
                                                var j = supreg.selectedIndex - 1;
                                                var supregId = supreg.options[j].value;
                                                var result = regions[j];
                                                for(i = 0; i < result.length; i++) {
                                                    var option = createOption(result[i]);
                                                    if(regionId && regionId != -1 && option.getAttribute('value') == regionId) {
                                                        document.mapList.regions.selectedIndex = i;
                                                    }
                                                    reg.appendChild(option);
                                                }
                                            }

                                            function createZoneSelect(reg) {
                                                if(reg.value == 0) return;
                                                var zone = document.getElementById('zones');
                                                var map = document.getElementById('maps');
                                                var supreg = document.getElementById('supregions');
                                                var k1 = supreg.selectedIndex - 1;
                                                var j = reg.selectedIndex - 1;
                                                var result = zones[k1][j];
                                                removeOptions(zone);
                                                for(i = 0; i < result.length; i++) {
                                                    var option = createOption(result[i]);
                                                    if(zoneId && zoneId != -1 && option.getAttribute('value') == regionId) {
                                                        document.mapList.regions.selectedIndex = i;
                                                    }
                                                    zone.appendChild(option);
                                                }
                                            }

                                            function createMapSelect(supreg) {
                                                sendObject.region = supreg.options[supreg.selectedIndex].value;
                                                if(supreg.options[supreg.selectedIndex].value == 0) return;
                                                var mapId = document.getElementById('map').value;
                                                var map = document.getElementById('maps');
                                                removeOptions(map);

                                                var k1 = supreg.selectedIndex - 1;
                                                var result = maps[k1];
                                                for(i = 0; i < result.length; i++) {
                                                    var option = createOption(result[i]);
                                                    if(mapId && mapId == result[i].getId()) {
                                                        var selected = document.createAttribute('selected');
                                                        selected.value = 'selected';
                                                        option.setAttributeNode(selected);
                                                    }
                                                    map.appendChild(option);
                                                }
                                                if(result.length == 1) {
                                                    document.mapList.maps.selectedIndex = 1;
                                                }

                                            }

                                            function createOption(result) {
                                                var option = document.createElement("OPTION");
                                                var attr = document.createAttribute("value");
                                                var text = document.createAttribute("text");
                                                attr.value = result.getId();
                                                option.innerHTML = result.getName();
                                                option.setAttributeNode(attr);
                                                option.setAttributeNode(text);
                                                return option;
                                            }

                                            function removeOptions(sel) {
                                                var k = getOptionsCount(sel);
                                                for(i = 0; i < k; i++) {
                                                    var list = sel.childNodes;
                                                    for (var i1 = 0; i1 < list.length; i1++) {
                                                        if(list[i1].nodeName == 'OPTION') {
                                                            var m = list[i1].getAttribute('required');
                                                            if(!m) sel.removeChild(list[i1]);
                                                        }
                                                    }
                                                }
                                            }

                                            function getOptionsCount(sel) {
                                                var list = sel.childNodes;
                                                var count = 0;
                                                for (var i1 = 0; i1 < list.length; i1++) {
                                                    if(list[i1].nodeName == 'OPTION') {
                                                        count++;
                                                    }
                                                }
                                                return count;
                                            }



<%--
                                                function createSelect() {
                                                    var regionId = document.getElementById('region').value;
                                                    var regions1 = document.getElementById('regions');
                                                    for(i = 0; i < regions.length; i+=2) {
                                                            var option1 = document.createElement("OPTION");
                                                            var atr1 = document.createAttribute("value");
                                                            var text1 = document.createAttribute("text");
                                                            atr1.value = regions[i].getId();
                                                            option1.innerHTML = regions[i].getName();
                                                            option1.setAttributeNode(atr1);
                                                            option1.setAttributeNode(text1);
                                                            if(regionId && regionId == regions[i].getId()) {
                                                                var selected = document.createAttribute('selected');
                                                                selected.value = 'selected';
                                                                option1.setAttributeNode(selected);
                                                            }
                                                            regions1.appendChild(option1);
                                                    }
                                                    if(regionId && regionId != '') {
                                                        getMaps(regions1);
                                                    }
                                                }
                                                function getOptionsCount(sel) {
                                                    var list = sel.childNodes;
                                                    var count = 0;
                                                    for (var i1 = 0; i1 < list.length; i1++) {
                                                        if(list[i1].nodeName == 'OPTION') {
                                                            count++;
                                                        }
                                                    }
                                                    return count;
                                                }
--%>
<%--
                                                function getMaps(sel) {
                                                    sendObject.region = sel.value;
                                                    var mapId = document.getElementById('map').value;
                                                    var maps = document.getElementById('maps');
                                                    var list = maps.childNodes;
                                                    var listLength ;
                                                    while((listLength = getOptionsCount(maps)) != 1) {
                                                        var list = maps.childNodes;
                                                        for (var i1 = 0; i1 < list.length; i1++) {
                                                            if(list[i1].nodeName == 'OPTION') {
                                                                var m = list[i1].getAttribute('required');
                                                                if(!m) maps.removeChild(list[i1]);
                                                            }
                                                        }
                                                    }
                                                    var i = (sel.selectedIndex - 1) * 2;
                                                    if(regions[i].hasChilds()) {
                                                        var maps = document.getElementById('maps');
                                                        var array = regions[i + 1];
                                                        for(j = 0; j < array.length; j++) {
                                                            var option = document.createElement("OPTION");
                                                            var atr = document.createAttribute("value");
                                                            var text = document.createAttribute("text");
                                                            atr.value = array[j].getId();
                                                            option.innerHTML = array[j].getName();
                                                            option.setAttributeNode(atr);
                                                            option.setAttributeNode(text);
                                                            if(mapId && mapId == array[j].getId()) {
                                                                var selected = document.createAttribute('selected');
                                                                selected.value = 'selected';
                                                                option.setAttributeNode(selected);
                                                            }
                                                            maps.appendChild(option);
                                                        }
                                                        if(array.length == 1) {
                                                            document.mapList.maps.selectedIndex = 1;
                                                        }
                                                    }
                                                }
                                                createSelect();
--%>

                                                function setAvailableSearch() {
                                                    if(document.mapList.maps.options[document.mapList.maps.selectedIndex].value > 0) {
                                                        if(document.mapList.position.value == '') { alert('Укажите, что будем искать !  '); return false; }
                                                        showResult(); return false;
                                                    } else {
                                                        alert('Укажите регион и карту !  '); return false;
                                                    }
                                                }
                                            -->
                                            </script>
                                    </td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title">
                                        <span class="title1">Поиск позиций :</span>
                                    </td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title">
                                        <input type="hidden" name="positionid" id="positionid" value="<% if(mhb != null && mhb.getPositionId() != null) out.print(mhb.getPositionId());%>"/>
                                        <input type="text" name="position" id="position" size="35" maxlength="20" value=""/>&nbsp;&nbsp;
<%--
                                        <a href="#" name="lookupbtn_posl" id="lookupbtn_posl" onclick="setAvailableSearch(); return false;"><img name="lookupimg_posl" src="/images/lookup.gif" border="0" alt="Поиск"></a>
--%>
                                    </td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title">
                                        <span class="title1">Комплекты оборудования :</span>
                                    </td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title"><image src="/images/_g16.gif">&nbsp;&nbsp;&nbsp;
                                    <input type="checkbox" value="1" name="gsm" id="gsm" <% if(mhb != null && mhb.getGsm() != null) out.print("checked");%> onclick="onChangeBS(this);"/>&nbsp;&nbsp;
                                    БС GSM &nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title"><image src="/images/_g16.gif">&nbsp;&nbsp;&nbsp;
                                    <input type="checkbox" value="1" name="dcs" id="dcs" <% if(mhb != null && mhb.getDcs() != null) out.print("checked");%> onclick="onChangeBS(this);"/>&nbsp;&nbsp;
                                    БС DCS  &nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title"><image src="/images/_d16.gif">&nbsp;&nbsp;&nbsp;
                                    <input type="checkbox" value="1" name="damps" id="damps" <% if(mhb != null && mhb.getDamps() != null) out.print("checked");%> onclick="onChangeBS(this);"/>&nbsp;&nbsp;
                                    БС DAMPS &nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title"><image src="/images/_p16.gif">&nbsp;&nbsp;&nbsp;
                                    <input type="checkbox" value="1" name="woBS" id="woBS" <% if(mhb != null && mhb.getWobs() != null) out.print("checked");%> onclick="onChangeBS(this);"/>&nbsp;&nbsp;
                                    без БС  &nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title"><image src="/images/_c17.gif">&nbsp;&nbsp;&nbsp;
                                    <input type="checkbox" value="1" name="controller" id="controller" <% if(mhb != null && mhb.getController() != null) out.print("checked");%> onclick="onChangeBS(this);"/>&nbsp;&nbsp;
                                    Контроллер/Коммутатор &nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title"><image src="/images/_p16_c.gif">&nbsp;&nbsp;Закрытые станции &nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title"><image src="/images/_p16_p.gif">&nbsp;&nbsp;Планируемые станции &nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title"><image src="/images/blue.gif">&nbsp;
                                    <input type="checkbox" value="1" name="rrl" <% if(mhb != null && mhb.getRrl() != null) out.print("checked");%> />&nbsp;
                                    РРЛ &nbsp;
                                    <image src="/images/cyan.gif">&nbsp;
                                    <input type="checkbox" value="1" name="vols" <% if(mhb != null && mhb.getVols() != null) out.print("checked");%> />&nbsp;
                                    ВОЛС &nbsp;
                                    </td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title">
                                        <span class="title1">Легенда :</span>
                                    </td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title">
                                         <input type="checkbox" value="1" id="marker_name" name="marker_name" onclick="changeMarker(this);" <% if(mhb != null && (mhb.getMarker() != null && (mhb.getMarker().equals("1") || mhb.getMarker().equals("3")))) out.print(" checked='true' ");;%> />&nbsp;&nbsp;&nbsp;Показывать название позиции
                                    </td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title">
                                        <input type="checkbox" value="2" id="marker_num" name="marker_num" onclick="changeMarker(this);" <% if(mhb != null && (mhb.getMarker() != null && (mhb.getMarker().equals("2") || mhb.getMarker().equals("3")))) out.print(" checked='true' "); %> /> &nbsp;&nbsp;&nbsp;Показывать номер позиции
                                    </td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title">
                                        <input type="checkbox" value="3" id="marker_none" name="marker_none" onclick="changeMarker(this);" <% if(mhb != null && (mhb.getMarker() != null && mhb.getMarker().equals("0"))) out.print(" checked='true' "); %> /> &nbsp;&nbsp;&nbsp;Не маркировать
                                        <script>
                                            <!--
                                                function changeMarker(el) {
                                                    if(!el) return;
                                                    var name1 = el.name;
                                                    var none = document.getElementById('marker_none');
                                                    var name = document.getElementById('marker_name');
                                                    var num = document.getElementById('marker_num');
                                                    var noneC = none.getAttribute('checked');
                                                    var nameC = name.getAttribute('checked');
                                                    var numC = num.getAttribute('checked');
                                                    if(name1 == 'marker_name') {
                                                        if(nameC) {
                                                            none.checked = false;
                                                        } else {
                                                            if(!numC) none.checked = true;
                                                        }
                                                    } else {
                                                        if(name1 == 'marker_num') {
                                                            if(numC) {
                                                                none.checked = false;
                                                            } else {
                                                                if(!nameC) none.checked = true;
                                                            }
                                                        } else {
                                                            if(name1 == 'marker_none') {
                                                                if(noneC) {
                                                                    name.checked = false;
                                                                    num.checked = false;
                                                                } else {
                                                                    if(nameC == false && numC == false)
                                                                        none.checked = true;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }

                                                function onChangeBS(el) {
                                                    if(!el) return;
                                                    var name = el.name;
                                                    var gsm = document.getElementById('gsm');
                                                    var damps = document.getElementById('damps');
                                                    var dcs = document.getElementById('dcs');
                                                    var controller = document.getElementById('controller');
                                                    var woBS = document.getElementById('woBS');
                                                    var gsmC = gsm.getAttribute('checked');
                                                    var dampsC = damps.getAttribute('checked');
                                                    var dcsC = dcs.getAttribute('checked');
                                                    var controllerC = controller.getAttribute('checked');
                                                    var woBSC = woBS.getAttribute('checked');
                                                    if(name == 'gsm') {
                                                        if(dampsC == false && dcsC == false && controllerC == false && woBSC == false)
                                                            gsm.checked = true;
                                                    }
                                                    if(name == 'damps') {
                                                        if(gsmC == false && dcsC == false && controllerC == false && woBSC == false)
                                                            damps.checked = true;
                                                    }
                                                    if(name == 'dcs') {
                                                        if(dampsC == false && gsmC == false && controllerC == false && woBSC == false)
                                                            dcs.checked = true;
                                                    }
                                                    if(name == 'controller') {
                                                        if(dampsC == false && dcsC == false && gsmC == false && woBSC == false)
                                                            controller.checked = true;
                                                    }
                                                    if(name == 'woBS') {
                                                        if(dampsC == false && dcsC == false && controllerC == false && woBSC == false)
                                                            woBS.checked = true;
                                                    }
                                                }
                                            -->
                                        </script>
                                    </td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title">
                                        <span class="title1">Управление при клике на карту :</span>
                                    </td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title">
                                        <input type="radio" value="1" name="control" <% if(mhb != null && (mhb.getControl() != null && mhb.getControl().equals("1"))) out.print("checked");%> /> Увеличить &nbsp;<br/>
                                        <input type="radio" value="2" name="control" <% if(mhb != null && (mhb.getControl() != null && mhb.getControl().equals("2"))) out.print("checked");%> /> Уменьшить &nbsp;<br/>
                                        <input type="radio" value="3" name="control" <% if(mhb != null && (mhb.getControl() != null && mhb.getControl().equals("3"))) out.print("checked");%> /> Сдвинуть &nbsp;<br/>
                                        <input type="radio" value="4" name="control" <% if(mhb != null && (mhb.getControl() != null && mhb.getControl().equals("4"))) out.print("checked");%> /> Информация о позиции &nbsp;<br/>
                                        <input type="radio" value="5" name="control" <% if(mhb != null && (mhb.getControl() != null && mhb.getControl().equals("5"))) out.print("checked");%> /> Координаты позиции &nbsp;<br/>
                                        <input type="hidden" value="" name="clickOnImage" />
                                        <input type="hidden" value="" name="direction" />
                                        <input type="hidden" value="" name="clientHeight" />
                                        <input type="hidden" value="" name="clientWidth" />
                                    </td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title">
                                        <span class="title1">Перемещение по карте :</span><br/>
                                    </td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title">
                                        <span class="title1">Регионы :</span>
                                    </td>
                                </tr>
                                <tr class="title">
                                    <td align="left" valign="top" class="title">
                                        <select id="regions" onchange="createZoneSelect(this);" style="width:170px">
                                            <option required="true" value="0">______________________</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr class="title" style="visibility: hidden; display:none">
                                    <td align="left" valign="top" class="title">
                                        <span class="title1">Зоны :</span>
                                    </td>
                                </tr>
                                <tr class="title" style="visibility: hidden; display:none">
                                    <td align="left" valign="top" class="title">
                                        <select id="zones" style="width:170px">
                                            <option required="true" value="0">______________________</option>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>
<iframe id="realZoom" src="" frameborder="0" style="display:none"></iframe>
</body>
</html>
