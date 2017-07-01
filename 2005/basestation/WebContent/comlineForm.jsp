<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.basestation.formbean.ComlineRForm" %>

<%
	request.setAttribute("colspan","2");//для использования во включенных jsp
	ComlineRForm dForm=(ComlineRForm)pageContext.findAttribute("ComlineRForm");
	request.setAttribute("EquipmentPForm",dForm);
%>
<july:editform styleId="ComlineRForm" action="/ProcessComlineR.do">
<html:hidden property="hopsid"/>
<html:hidden property="showType"/>
<html:hidden property="old_file_number"/>
<table class="main">
<july:separator/>

<july:formbuttons/>
<july:separator/>

<tr>
	<td class="title" colspan="2">
		<july:actionalert/>
<%if("D".equals(dForm.getShowType())) {%>
<FONT class="attention"><B>(Параметры по разрешению)</B></FONT>
<%} else {%>
<FONT class="attention"><B>(Фактические параметры)</B></FONT>
<%}%>
	</td>
</tr>
<july:separator/>
<%--доп. меню--%>
<%
if(dForm.getAction().equals("Edit")||dForm.getAction().equals("View")) {
%>
<jsp:include page="/comlineForm/nestedLines.jsp" flush="true"/>
<july:separator/>
<jsp:include page="/comlineForm/actionsMenu.jsp" flush="true"/>
<july:separator/>
<%
}
%>
<%--поля формы--%>
<%if("D".equals(dForm.getShowType())) {%>
<jsp:include page="/comlineForm/fieldsdoc.jsp" flush="true" />
<%} else {%>
<jsp:include page="/comlineForm/fields.jsp" flush="true" />
<%}%>
<%
if("Edit".equals(dForm.getAction()) || "View".equals(dForm.getAction())) {
%>
<july:separator/>
<jsp:include page="/comlineForm/documents.jsp" flush="true"/>
<%
}
%>
<july:separator/>
			<tr class="title">
				<td class="title" colspan="2">
					<bean:message key="ComlineForm.modinf"/>
				</td>
			</tr>			
			<tr>
				<td class="text" width="25%"><bean:message key="ComlineForm.create"/></td>
				<td class="text" colspan="3">
					<july:string property="created" size="15" insertable="false" updatable="false" />					
					<july:string property="createdBy"  size="15" insertable="false" updatable="false" />	
				</td>
			</tr>
			<tr>
				<td class="text" width="25%"><bean:message key="ComlineForm.modif"/></td>
				<td class="text" colspan="3">
					<july:string property="modified" size="15" insertable="false" updatable="false" />					
					<july:string property="modifiedBy"  size="15" insertable="false" updatable="false" />	
				</td>
			</tr>
<july:separator/>
<july:formbuttons/>
<july:separator/>
</table>
</july:editform>

