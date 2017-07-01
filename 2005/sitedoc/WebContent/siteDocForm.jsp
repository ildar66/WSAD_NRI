<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.sitedoc.formbean.SiteDocForm" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants" %>
<%@ page import="com.hps.july.constants.Applications" %>
<%
	request.setAttribute("colspan","2");
	String gColSpan="2";
	SiteDocForm dForm=(SiteDocForm)pageContext.findAttribute("SiteDocForm");
%>
<table class="main">

<july:editform  styleId="ProcessSiteDoc"  action="/ProcessSiteDoc.do">

<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<logic:equal value="Delete" name="SiteDocForm" property="action"  >
<jsp:include page="/siteDocForm/warning.jsp" flush="true"  />
</logic:equal>
<july:separator/>
<jsp:include page="/tittleObject.jsp" flush="true"/>
<logic:equal name="SiteDocForm" property="action" value="Edit" >
<jsp:include page="tittleMan.jsp" flush="true" />
</logic:equal>

<july:separator/>

<jsp:include page="/siteDocForm/fields.jsp" flush="true" />

<july:separator/>
<july:formbuttons/>
<july:separator/>
</july:editform>

<%if(dForm.getAction().equals("Edit")||dForm.getAction().equals("View")){%>
	<tr><td colspan='2'><jsp:include  page="/siteDocForm/fileList.jsp" flush="true" /></td></tr>
	<july:separator/>
	<tr><td colspan='2'><jsp:include page="/siteDocForm/objectList.jsp" flush="true" /></td></tr>
	<july:separator/>
<%}%>

</table>



