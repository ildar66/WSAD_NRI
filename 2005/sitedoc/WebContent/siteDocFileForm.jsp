<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport" %>
<%@ page import="com.hps.july.constants.Applications" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants" %>

<%
request.setAttribute("colspan","2");
//DebugSupport.printlnTest("siteDocFileForm started");
String gColSpan="2";
%>

<july:editform action="/ProcessSiteDocFile.do" enctype="multipart/form-data">

<table class="main">

<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>

<jsp:include page="/tittleObject.jsp" flush="true"/>

<jsp:include page="tittleDocument.jsp" flush="true" />

<july:separator/>

<jsp:include page="/siteDocFileForm/fields.jsp" flush="true" />

<july:separator/>

<july:formbuttons/>

<july:separator/>

</july:editform>

</table>



