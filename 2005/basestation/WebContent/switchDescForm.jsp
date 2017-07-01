<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.formbean.SwitchDescForm" %>

<% String processActionURL = "/ProcessSwitchDesc.do"; %>
<logic:equal name="SwitchDescForm" property="action" value="View" scope="session">
<%
	processActionURL = "/EditViewFactSwitchDesc.do?action=View";
%>
</logic:equal>

<july:editform styleId="SwitchDescForm" action="<%=processActionURL%>">

<html:hidden property="equipment"/>

<table class="main">
<july:separator/>
<july:formbuttons/>
<july:separator/>
<tr>
     <td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<%-- информация о позиции и коммутатору --%>
<jsp:include page="/switchDescForm/positionInfo.jsp" flush="true" />
<july:separator/>
<%--поля формы--%>
<jsp:include page="/switchDescForm/descFields.jsp" flush="true" />
<july:separator/>
<july:formbuttons/>
<july:separator/>
</table>
</july:editform>

