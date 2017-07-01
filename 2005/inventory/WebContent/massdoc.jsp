<%@ page language = "java" %>
<%@ page import="java.util.*,java.math.*,com.hps.july.inventory.formbean.*,org.apache.struts.util.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "1"; %>

<table class="main">

<tr class="normal">
	<td colspan="<%= gColSpan %>">
		<table class="find">
		<tr>
			<td class="title">&nbsp;</td>
			<td class="title">&nbsp;</td>
		</tr> 
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons"><july:backbutton page="/MassdocParams.do"/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<td>
<%
	java.sql.Date date = new java.sql.Date((new java.util.Date()).getTime());
	MassdocParamsForm rp = (MassdocParamsForm)session.getAttribute("MassdocParamsForm");

	String p = "unprocessed.rpt?dll=pdsunprocessed.dll";
	p += "&prompt0=0";
	p += "&prompt1=";
	p += "&prompt2=false";
	p += "&prompt3="+(!rp.getIsowner().booleanValue()?(""+rp.getOwner()):"0");
	p += "&prompt4=["+rp.getIncDocsString()+"]";
	p += "&prompt5="+rp.getStoragetype();
	p += "&prompt6=";
	if(rp.getDatefrom() != null) {
		date = rp.getDatefrom();
		p += "Date("+(date.getYear()+1900)+","+(date.getMonth()+1)+","+date.getDate()+")";
	}
	p += "&prompt7=";
	if(rp.getDateto() != null) {
		date = rp.getDateto();
		p += "Date("+(date.getYear()+1900)+","+(date.getMonth()+1)+","+date.getDate()+")";
	}
	p += "&prompt8="+java.net.URLEncoder.encode(!rp.getIsowner().booleanValue()?rp.getOwnername():"Все");
	if("1".equals(rp.getStoragetype())) {
		p += "&prompt9="+rp.getPositionFrm();
		p += "&prompt10="+java.net.URLEncoder.encode(rp.getPositionid()+" "+rp.getPositionname());
	} else
	if("2".equals(rp.getStoragetype())) {
		p += "&prompt9="+rp.getStorageFrm();
		p += "&prompt10="+java.net.URLEncoder.encode(rp.getStoragename());
	} else
	if("3".equals(rp.getStoragetype())) {
		p += "&prompt9="+rp.getWorkerFrm();
		p += "&prompt10="+java.net.URLEncoder.encode(rp.getWorkername());
	} else
	if("4".equals(rp.getStoragetype())) {
		p += "&prompt9="+rp.getOrganizationFrm();
		p += "&prompt10="+java.net.URLEncoder.encode(rp.getOrganizationname());
	} else {
		p += "&prompt9=0";
		p += "&prompt10="+java.net.URLEncoder.encode("Все");
	}
	p += "&prompt11="+rp.getDocsize();
	if(rp.getSorttype() != null) {
		p += "&prompt12="+rp.getSorttype();
	} else {
		p += "&prompt12=1";
	}
%>
	<july:report report="<%=p%>"/>
<%--=p--%>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons"><july:backbutton page="/MassdocParams.do"/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />
          
</table>
