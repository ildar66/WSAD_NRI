<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.basestation.*" %>
<%@ page import="com.hps.july.basestation.formbean.*,com.hps.july.siteinfo.valueobject.Position" %>
<%@ page import="java.util.Enumeration,com.hps.july.jdbcpersistence.lib.DebugSupport" %>
<%@ page import="com.hps.july.persistence.RegionAccessBean" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.RegionObject" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	LoadXlsBsForm loadForm=(LoadXlsBsForm)pageContext.findAttribute("LoadXlsBsForm");
%>

<form action="Upload" method="POST" enctype="multipart/form-data">
<input type="hidden" name="RETPATH" value="ProcessXlsBs.do">
<table class="main">
<july:separator/>
<tr class=title>
	<td colSpan=2>
		<input type=image alt=Загрузить onclick='document.body.style.cursor="wait"' src="/images/loadexcel.gif" name=submit>&nbsp;
		<july:backbutton/>
<%--
			<A title="Отказ и возврат"
            href="main.do"><IMG
            onclick="document.body.style.cursor='wait';" alt="Отказ и возврат"
            src="/images/cancel.gif" border=0>
            </A>
--%>
	</td>
</tr>
<july:separator/>
<tr>
	<td width="30%" class="text"><july:reqmark><bean:message key="xls.filename"/>:</july:reqmark></td>
	<td width="70%"><INPUT TYPE="FILE" name="file" class="editbig"></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.position.regionname"/>:</july:reqmark></td>
	<td>
		<select name="regionIdFrm" class="editbig">
			<option value="?" ></option>
<%
	Enumeration enum=loadForm.getRegions().elements();
	RegionObject region=null;
	while(enum.hasMoreElements()){
		region=(RegionObject)enum.nextElement();
		%><option value="<%=region.getId()%>"<%=((loadForm.getRegionId()!=null)&& (loadForm.getRegionId().intValue()==region.getId()))?" selected":""%>><%=region.getName()%></option><%
	}
%>
		</select>
	</td>
</tr>
<july:separator/>
<tr>
	<td>
		<nobr><bean:message key="xls.report.msg"/></nobr>
	</td>
	<td>
		<INPUT class="editcheckbox" TYPE="checkbox" name="maxReport" value=on <%=loadForm.isMaxReport()?"CHECKED":""%>>
	</td>
</tr>

<july:separator/>

<%-- july:formbuttons/ --%>
<%--INPUT TYPE="Submit"--%>

<tr>
	<td align=center>
		<INPUT type=image src="/images/loadbtn.jpg" onclick='document.body.style.cursor="wait"' name=submit value="Загрузить">
	</td>
	<td align=center>
		<html:link page="/xlsJournal.do?task=3"><bean:message key="xls.journal"/></html:link>
	</td>
</tr>

<july:separator/>

<tr class=title>
	<td colSpan=2>
		<input type=image alt=Загрузить onclick='document.body.style.cursor="wait"' src="/images/loadexcel.gif" name=submit>&nbsp;
		<july:backbutton/>
<%--
			<A title="Отказ и возврат"
            href="main.do"><IMG
            onclick="document.body.style.cursor='wait';" alt="Отказ и возврат"
            src="/images/cancel.gif" border=0>
            </A>
--%>
	</td>
</tr>

<july:separator/>

</table>

</form>

<%--loadForm.setRequest(null);--%>
<%--/july:editform--%>

