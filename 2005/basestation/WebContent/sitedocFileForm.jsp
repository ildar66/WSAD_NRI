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
<%@ page import="com.hps.july.basestation.formbean.*" %>

<july:editform action="/ProcessSiteDocFile.do" enctype="multipart/form-data">
<%
	SitedocFileForm form = (SitedocFileForm)request.getAttribute("SitedocFileForm");
%>
<html:hidden property="sitedoc"/>
<html:hidden property="sitedocfile"/>

<html:hidden property="blanknumber"/>
<html:hidden property="blankdate.string"/>
<html:hidden property="doctype"/>
<html:hidden property="sitedocfilename"/>

<table class="main">
<july:separator/>
<july:formbuttons/>
<july:separator/>
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.sitedoc.title"/>:</td>
	<td>
		<bean:message key="label.sitedoc.number"/>
		<bean:write name="SitedocFileForm" property="blanknumber" filter="true"/>
		<bean:message key="label.sitedoc.from"/>
		<bean:write name="SitedocFileForm" property="blankdate.string" filter="true"/>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.sitedoc.file"/>:</july:reqmark></td>
	<td class="text">
		<%if("Add".equals(form.getAction()) || "Edit".equals(form.getAction())) {%>
		<html:file name="SitedocFileForm" property="sitedocfilebodyFrm" size="35"/>
		<%}%>
		<logic:present name="SitedocFileForm" property="sitedocfilename">&nbsp;
			<html:link page="/../sitedoc/OpenFile.do" target="_blank" paramId="sitedocfile" paramName="SitedocFileForm" paramProperty="sitedocfile"><bean:write name="SitedocFileForm" property="sitedocfilename" filter="true"/></html:link>
		</logic:present>
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="label.sitedoc.comment"/>:</td>
	<td>
		<july:textarea property="note" cols="50" rows="2" insertable='true' updatable='true' />
	</td>
</tr>
<july:separator/>
<july:formbuttons/>
<july:separator/>
</july:editform>
</table>



