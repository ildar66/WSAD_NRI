<%@ page language = "java" %>
<%@ page import="java.util.*,com.hps.july.siteinfo.actionbean.MapHandlingBean,
                 com.hps.july.siteinfo.valueobject.ValueObject" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<html>
<head>
<title>Список карт</title>
<meta http-equiv="content-type" content="text/html;  charset=windows-1251" />
<meta http-equiv="content-script-type" content="text/javascript" />
<meta http-equiv="content-style-type" content="text/css" />
<link rel="stylesheet" type="text/css" href="http://infserver.informix.ru/main.css" />
<link rel="stylesheet" type="text/css" href="http://infserver.informix.ru/main1.css" />
</head>
<script language="JavaScript">
<!--
    var retVal = new Object();

    function ret(a) {
        if(a) {
            var pos = a.getAttribute('pos');
            var map = a.getAttribute('map');
            var region = a.getAttribute('region');
            if(opener) {
                opener.showMap(map, region, pos);
            }
            return true;
        }
        return false;
    }
-->
</script>
<body>
<%
    ArrayList list = (ArrayList)request.getAttribute("mList");
%>
    <%
        if(list != null && list.size() > 0) {
            if(list.size() == 1) {
                ValueObject vo = (ValueObject)list.get(0);
                if(vo.getAttribute("region") != null && vo.getAttribute("pos") != null) {
                    %>
                        <script language="JavaScript"><!--
                            if(opener) opener.showMap('<%=vo.getAttribute("id")%>', '<%=vo.getAttribute("region")%>', '<%=vo.getAttribute("pos")%>');
                        --></script>
                    <%
                }
            }
        }
    %>

    <button name="closeButton" value="Close" onclick="window.close();">Закрыть</button>
    <%
        String err = (String)request.getAttribute("DPM_ERR");
        if(err != null && err.equals("1")) {
            %>
            <table style="width : 100%">
                <tr class="title">
                    <td align="center" valign="top" style="width: 50%"><b>Модуль карт не запущен</b></td>
                </tr>
                <tr class="title">
                    <td align="center" valign="top" style="width: 50%;font-color : red"><b>Обратитесь к администратору (41-15)</b></td>
                </tr>
            </table>
            <%
        } else {
    %>
    <table style="width : 100%">
    <%
        list = (ArrayList)request.getAttribute("mList");
        if(list != null && list.size() > 0) {
            %>
                <tr class="title">
                    <td align="center" valign="top" style="width: 50%"><b>Имя позиций</b></td>
                    <td align="center" valign="top" style="width: 50%"><b>Карта</b></td>
                </tr>
            <%
            for (int i = 0; i < list.size(); i++) {
                ValueObject vo = (ValueObject)list.get(i);
            %>
                <tr class="title">
                    <td align="center" valign="top" style="width: 50%"><%=vo.getAttribute("name")%></td>
                    <td align="center" valign="top" style="width: 50%"><% 
                    	if(vo.getAttribute("id") != null) { 
                    	%>
                    		<a href="#" onclick="ret(this);" map="<%=vo.getAttribute("id")%>" pos="<%=vo.getAttribute("pos")%>" region="<%=vo.getAttribute("region")%>" ><%=vo.getAttribute("mapName")%></a>
                    	<%
                    	} else { 
                    		out.print("У данного суперрегиона отсутствуют карты");
                    	} %></td>
                </tr>
            <%
            }
        } else {
            %>
                <tr class="title">
                    <td align="center" valign="top"><b>Нет позиций </b></td>
                </tr>
            <%
        }
    }
    %>
    </table>
</body>
</html>
