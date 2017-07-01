<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.formbean.*"%>
<%@ page import="com.hps.july.siteinfo.valueobject.Regions"%>

<%
	java.lang.String gColSpan = "8";
	FreqLicenceHistoryListForm lForm = (FreqLicenceHistoryListForm)pageContext.findAttribute("FreqLicenceHistoryListForm");
%>

<july:browseform action="/ShowFreqLicenceHistoryList.do" styleId="FrequncyLicenceHistoryListForm">
<july:selectableTable styleClass="main" modelName="list" selectable="1" selectedClass="selected" paramName="sID" >
<july:separator colspan="<%= gColSpan %>" />
<tr>
<td colspan="<%=gColSpan %>">
	<table class="main">
	<tr>
		<td class="text" width="12%"><bean:message key="label.position.actions"/>:</td>
		<td class="text" width="88%"><html:link page="/EditFrequencyLicence.do?action=Edit" paramId="freqpermid" paramName="FreqLicenceHistoryListForm" paramProperty="freqpermid"><nobr><bean:message key="label.freqlicence.edit"/></nobr></html:link></td>
	</tr>
	</table>
</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
<td colspan="<%=gColSpan %>">
	<table class="find">
	<tr>
		<td class="title"><bean:message key="label.freqhistory.filter.filenumber"/>:</td>
		<td class="title"><bean:write name="FreqLicenceHistoryListForm" property="fileNumber" filter="true"/></td>
		<td class="title"><july:searchbutton/></td>
	</tr>
	</table>
</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<july:addbutton page="/EditEtapDoc.do?action=Add" alttext="label.freqhist.add"/>
				<july:backbutton/>
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />

<%-- Table header --%>
<tr class="title">
	<td></td>
	<july:headercolumn key="label.freqhist.table.docname" colType="string"/>
	<july:headercolumn key="label.freqhist.table.ndoc" colType="string"/>
	<july:headercolumn key="label.freqhist.table.datedoc" colType="string"/>
	<july:headercolumn key="label.freqhist.table.expdate" colType="string"/>
	<july:headercolumn key="label.freqhist.table.comment" colType="string"/>
	<td></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="fl" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="fl">
<%
	pageContext.setAttribute("sitedoc",fl.getColumn("sitedoc").asString());
	String id = fl.getColumn("sitedoc").asString();
//	String resList = lForm.getResources((Integer)doc.getColumn("freqpermid").asObject());
%>
<july:selectableTR styleId="<%=id%>" paramName="sID" selectable="true" styleClass="normal"  onmouseover="className='select'" onmouseout="className='normal'">
<%--tr class="normal" onMouseOver="className='select';" onMouseOut="className='normal';" --%>
	<td class="link" align="middle">
		<july:editbutton page="/EditEtapDoc.do" action="Edit" paramId="sitedoc" paramName="sitedoc" alttext="label.freqhist.editdoc"/>
	</td>
	<td class="text"><july:stringwrite name="fl" property="ettypename"/></td>
	<td class="number"><july:stringwrite name="fl" property="blanknumber"/></td>
	<td class="text"><july:datewrite name="fl" property="blankdate"/></td>
	<td class="text"><july:datewrite name="fl" property="expiredate"/></td>
	<td class="text"><july:stringwrite name="fl" property="comment"/></td>
<%--
	<td class="link" align="middle">
		<july:link page="/ShowEtapDocFiles.do" paramId="sitedoc" paramName="sitedoc" paramScope="page">
			<img src="/images/dochist.gif" border=0 alt='<bean:message key="label.freqhist.docfiles"/>'>
		</july:link>
	</td>
--%>
	<td class="link"><july:delbutton page="/EditEtapDoc.do?action=Delete" paramId="sitedoc" paramName="sitedoc" paramScope="page"/></td>
<%--/tr--%>
</july:selectableTR>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>
<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<july:addbutton page="/EditEtapDoc.do?action=Add" alttext="label.freqhist.add"/>
				<july:backbutton/>
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</july:selectableTable>
</july:browseform>
