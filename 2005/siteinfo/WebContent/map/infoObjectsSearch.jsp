<%@ page language = "java" %>
<%@ page import="java.util.*,com.hps.july.siteinfo.actionbean.MapHandlingBean,
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

    function ret(type, id) {
        window.opener.setPosInfo(type, id);
        //retVal.type = type;
        //retVal.id = id;
        //window.returnValue = retVal;
        //window.close();
        return true;
    }
-->
</script>
<style><!--

--></style>
<body>
    <button name="closeButton" value="Close" onclick="window.close();">Закрыть</button >
    <table style="width : 100%;table-layout: fixed">
    <tr>
        <td>
            <div id="list" style="width:100%;height:580;position:relative;overflow-y:scroll;">
                <table style="width : 100%;table-layout: fixed">
                    <tr class="title">
                        <td align="center" valign="top" style="font-size: 14px"><b>Позиции</b></td>
                    </tr>
                    <tr>
                        <td align="left" valign="top">
                            <table class="main" style="width : 100%;table-layout: fixed">
                            <tr class="title">
                                        <td align="center" valign="middle"  style="width:6%"><b>Инфо</b></td>
                                        <td align="left" valign="top"><b>Id</b></td>
                                        <td align="left" valign="top"><b>Имя</b></td>
                                        <td align="left" valign="top"><b>DAMPS</b></td>
                                        <td align="left" valign="top"><b>GSM</b></td>
                            <tr>
                            <%
                                Collection c = (Collection)request.getAttribute("pList");
                                if(c != null) {
                                for (Iterator iterator = c.iterator(); iterator.hasNext();) {
                                    %>    <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">  <%

                                    ValueObject vo = (ValueObject)iterator.next();
                                    %>
                                        <td align="center" valign="middle"  style="width:6%">
                                            <img src="/images/lookup.gif" border="0" alt="Инфо" onclick="ret('p', <%=vo.getAttribute("storagePlace")%>);">
                                        </td>
                                        <td align="left" valign="top">
                                            <%=vo.getAttribute("storagePlace")%>
                                        </td>
                                        <td align="left" valign="top">
                                            <%=vo.getAttribute("name")%>
                                        </td>
                                        <td align="left" valign="top">
                                            <%=vo.getAttribute("dampsId")%>
                                        </td>
                                        <td align="left" valign="top">
                                            <%=vo.getAttribute("gsmId")%>
                                        </td>
                                    </tr>
                            <%    } }   %>
                            </table>
                        </td>
                    <tr>
                    <tr class="title">
                        <td align="center" valign="top" style="font-size: 14px"><b>Пролеты</b></td>
                    </tr>
                    <tr>
                        <td align="left" valign="top">
                            <table class="main" style="width : 100%;table-layout: fixed">
                            <tr class="title">
                                        <td align="center" valign="middle" style="width:6%"><b>Инфо</b></td>
                                        <td align="left" valign="middle"><b>Код пролета</b></td>
                                        <td align="left" valign="middle"><b>№ BeeNet</b></td>
                                        <td align="left" valign="middle"><b>Номер 1</b></td>
                                        <td align="left" valign="middle"><b>Позиция 1</b></td>
                                        <td align="left" valign="middle" style="width:1%"><b>-</b></td>
                                        <td align="left" valign="middle"><b>Номер 2</b></td>
                                        <td align="left" valign="middle"><b>Позиция 2</b></td>
                                        <td align="center" valign="middle" style="width:10%"><b>Тип линии связи</b></td>
                                        <td align="center" valign="middle" style="width:4%"><b>Состояние</b></td>
                            <tr>
                            <%
                                c = (Collection)request.getAttribute("hList");
                                if(c != null) {
                                for (Iterator iterator = c.iterator(); iterator.hasNext();) {
                                    %>    <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">  <%

                                    ValueObject vo = (ValueObject)iterator.next();
                                    %>
                                        <td align="center" valign="middle"  style="width:6%">
                                        <%
                                            Integer hId = (Integer)vo.getAttribute("code1");
                                            if(hId.intValue() == -1) {
                                                hId = (Integer)vo.getAttribute("code2");
                                                if(hId.intValue() == -1) hId = null;
                                            }
                                    if(hId == null) {
                                        %>
                                        X
                                        <%
                                    } else {
                                        %>
                                            <img src="/images/lookup.gif" border="0" alt="Инфо" onclick="ret('h', <%= hId %>);">
                                        <%
                                    }
                                        %>
                                        </td>
                                        <td align="left" valign="middle"><%=vo.getAttribute("hopsName")%></td>
                                        <td align="left" valign="middle"><%=vo.getAttribute("beenetId")%></td>
                                        <td align="left" valign="middle"><%=vo.getAttribute("number1")%></td>
                                        <td align="left" valign="middle"><%=vo.getAttribute("name1")%></td>
                                        <td align="left" valign="middle" style="width:1%">-</td>
                                        <td align="left" valign="middle"><%=vo.getAttribute("number2")%></td>
                                        <td align="left" valign="middle"><%=vo.getAttribute("name2")%></td>
                                        <td align="center" valign="middle" style="width:10%"><%if("R".equals(vo.getAttribute("hopsType"))){%>РРЛ<%} else if("O".equals(vo.getAttribute("hopsType"))){%>ВОЛС<%}%></td>
                                        <td align="center" valign="middle" style="width:4%"><%
                                            String state = (String)vo.getAttribute("hopsState");
                                            if(state != null && !"".equals(state)) {
                                                state = (String)vo.getAttribute("hopsState");
                                            } else state = "C";
                                            if(state.equals("A")) out.print("П");
                                            else if(state.equals("B"))  out.print("Н");
                                            else if(state.equals("C"))  out.print("Э");
                                            else if(state.equals("D"))  out.print("Д");
                                            else out.print("все");

                                        %></td>

                                    </tr>
                            <%    } }   %>
                            </table>
                        </td>
                    <tr>
                </table>
            </div>
        </td>
    </tr>
</table>
</body>
</html>
