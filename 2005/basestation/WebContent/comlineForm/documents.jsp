<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="java.util.*"%>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.formbean.ComlineRForm"%>
<%@ page import="com.hps.july.web.util.*"%>

<%
	ComlineRForm dForm=(ComlineRForm)request.getAttribute("ComlineRForm");
	Enumeration en = dForm.getDocuments();
	request.setAttribute("ComlineRForm.Documents",en);
	String url;
	String editDoc = "/../sitedoc/EditSiteDoc.do?appHome="+ParamsParser.getRootApp(pageContext)+"&objectType=Comline&objectId="+dForm.getHopsid();
%>

<tr>
	<td colspan="2">
<table class="main" id="brtable">
	<tr class="title">
		<td class="title" colspan="7">
			<july:addbutton page='<%=editDoc+"&action=Add"%>'/>
			<bean:message key="ComlineForm.documents"/>
		</td>
	</tr>
	<tr class="title">
		<td></td>
		<july:headercolumn key="ComlineForm.regdate" colType="string"/>
		<july:headercolumn key="ComlineForm.number" colType="string"/>
		<july:headercolumn key="ComlineForm.type" colType="string"/>
		<july:headercolumn key="ComlineForm.expdate" colType="string"/>
		<july:headercolumn key="ComlineForm.comments" colType="string"/>
		<td></td>
	</tr>
<logic:iterate id="it" name="ComlineRForm.Documents">
<logic:present name="it">
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="link">
			<july:editbutton page="<%=editDoc%>" action="Edit" paramId="sitedoc" paramName="it" paramProperty="docid"/>
		</td>
		<td class="text">
			<july:datewrite name="it" property="regdate"/>
		</td>
		<td class="number">
			<bean:write name="it" property="number" filter="true"/>
		</td>
		<td class="text">
			<bean:write name="it" property="doctype" filter="true"/>
		</td>
		<td class="text">
			<july:datewrite name="it" property="expdate"/>
		</td>
		<td class="text">
			<bean:write name="it" property="comments" filter="true"/>
		</td>
		<td class="link">
			<july:delbutton page='<%=editDoc+"&action=Delete"%>' paramId="sitedoc" paramName="it" paramProperty="docid"/>
		</td>
	</tr>
</logic:present>
<logic:notPresent name="it">
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="link">-</td>
		<td class="text">&nbsp;</td>
		<td class="number">&nbsp;</td>
		<td class="text">&nbsp;</td>
		<td class="text">&nbsp;</td>
		<td class="text">&nbsp;</td>
		<td class="link">-</td>
	</tr>
</logic:notPresent>
</logic:iterate>
</table>
	</td>
</tr>