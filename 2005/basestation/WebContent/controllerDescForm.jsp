<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.basestation.formbean.ControllerDescForm" %>
<%@ taglib uri="/WEB-INF/bsapptags.tld" prefix="jbs" %>

<%
	//String colspan = "2";
	String act = "/ProcessFactControllerDesc.do";
%>

<logic:equal name="ControllerDescForm" property="action" value="View">
<% act = "/EditViewFactControllerDesc.do?action=View"; %>
</logic:equal>

<july:editform action="<%= act %>" styleId="ControllerDescForm">

<table class="main">

<july:separator/>

<july:formbuttons/>

<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>

<jsp:include page="controllerDescForm/controllerInfo.jsp" flush="true"/>

<july:separator/>

<jsp:include page="controllerDescForm/fields.jsp" flush="true"/>

<july:separator/>

<july:formbuttons/>

<july:separator/>

</table>

</july:editform>