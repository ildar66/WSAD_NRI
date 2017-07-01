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
<title>Список найденных позиций</title>
<meta http-equiv="content-type" content="text/html;  charset=windows-1251" />
<meta http-equiv="content-script-type" content="text/javascript" />
<meta http-equiv="content-style-type" content="text/css" />
<link rel="stylesheet" type="text/css" href="/main.css" />
<link rel="stylesheet" type="text/css" href="/main1.css" />
</head>
<script language="JavaScript">
<!--
    var retVal = new Object();
    function getResult() {
        var list = document.getElementsByTagName('INPUT');
        var v = '';
        for(var i = 0; i < list.length; i++) {
            if(list[i].type=='checkbox' && list[i].checked) {
                v = v + list[i].value + ',';
            }
        }
        //retVal.choosed = v;
        //window.returnValue = retVal;
        return v;
    }

    window.onload = function () {
        var list = document.getElementById('list');
        var title = document.getElementById('title2');
        if(list && title) {
            title.style.width = list.clientWidth;
        }
    };
-->
</script>
<style><!--
    .title1 {
        font-weight: bold;
        text-align : center;
        vertical-align : middle;
    }
--></style>
<body style="width : 100%">
    <button class="" name="closeButton" value="Close" onclick="var res = getResult(); window.opener.setSearchResult(res);">Показать на карте</button >
    <table style="width : 100%">
    <tr>
        <td>
            <div id="title2" style="width:100%;overflow:hidden;">
                <table style="width : 100%; table-layout: fixed">
                    <tr class="title">
                        <td class="title1" style="width: 15%;">Имя позиции</td>
                        <td class="title1" style="width: 5%">Номер GSM</td>
                        <td class="title1" style="width: 5%">Номер DAMPS</td>
                        <td class="title1" style="width: 7%">Долгота</td>
                        <td class="title1" style="width: 7%">Широта</td>
                        <td class="title1" style="width: 30%">Адрес</td>
                        <td class="title1" style="width: 15%">Номер beenet</td>
                        <td class="title1" style="width: 6%">Выбор</td>
                    </tr>
                </table>
            </div>
        </td>
    </tr>
    <tr>
        <td>
            <div id="list" style="width:100%;height:600;position:relative;overflow-y:scroll;">
                <table style="width : 100%;table-layout: fixed">
                <%
                    Collection c = (Collection)request.getAttribute("list");
                    if(c != null) {
                    for (Iterator iterator = c.iterator(); iterator.hasNext();) {
                        %>    <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">  <%

                        ValueObject vo = (ValueObject)iterator.next();
                        %>
                            <td align="left" valign="top" style="width: 15%">
                                <%=vo.getAttribute("positionName")%>
                            </td>
                            <td align="left" valign="top" style="width: 5%">
                                <%=vo.getAttribute("gsmNumber")%>
                            </td>
                            <td align="left" valign="top" style="width: 5%">
                                <%=vo.getAttribute("dampsNumber")%>
                            </td>
                            <td align="left" valign="top" style="width: 7%">
                                <%=vo.getAttribute("latitude")%>
                            </td>
                            <td align="left" valign="top" style="width: 7%">
                                <%=vo.getAttribute("longitude")%>
                            </td>
                            <td align="left" valign="top" style="width: 30%">
                                <%=vo.getAttribute("address")%>
                            </td>
                            <td align="left" valign="top" style="width: 15%">
                                <%=vo.getAttribute("beenetNumber")%>
                            </td>
                            <td align="left" valign="top" style="width: 6%">
                                <% if(!((Boolean)vo.getAttribute("isEmpty")).booleanValue()) { %>
                                    <input type="checkbox" name="choosed" value="<%=vo.getAttribute("positionId")%>"/>
                                <% } %>
                            </td>
                        </tr>
                <%    } }   %>
                </table>
            </div>
        </td>
    </tr>
</table>
</body>
</html>
