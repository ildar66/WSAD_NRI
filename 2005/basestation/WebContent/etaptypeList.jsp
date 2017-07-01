<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.valueobject.BaseStationObject"%>
<%@ page import="com.hps.july.basestation.formbean.*"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.SearchConstants"%>
<%@ page import="com.hps.july.siteinfo.valueobject.Regions"%>

<%String gColSpan = "6";%>
<july:browseform action="/ShowEtapTypeList.do" styleId="EtapTypeListForm">
<table class="main">
<july:separator colspan="<%= gColSpan %>"/>
<script language="javascript">
function allClicked() {
	var disabledstate = document.all.isAll.checked;
	document.all.etapname.disabled = disabledstate;
	document.all.etapname.className = (disabledstate?'editdisabled':'editsearch');
	
}
</script>
<tr class="normal">
<td colspan="<%=gColSpan %>">
	<table class="find">
	<tr>
		<td class="title"><bean:message key="label.etaptype.filter.name"/>:</td>
		<td class="title">
			<july:checkbox property="all" styleId="isAll" insertable="true" updatable="true" onclick="allClicked();"/>
			<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;
			<july:string property="etapname" styleId="etapname" size="25" insertable="true" updatable="true" styleClass="editsearch"/>
		</td>
		<td class="title" align='right'><july:searchbutton/></td>
	</tr>
	</table>
	<script language="javascript"></script>
</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<html:link page='/EditEtapType.do?action=Add'><img alt='<bean:message key="label.etaptype.add"/>' src="/images/plus.gif" border=0></html:link>
        			<img alt="" src="/images/empty.gif" width=3 border=0>
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
	<july:sortcolumn key="label.etaptype.table.ettypename" colType="string" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.etaptype.table.endtime" colType="string"/>
	<july:headercolumn key="label.etaptype.table.hopslink" colType="string"/>
	<july:headercolumn key="label.etap.form.havepaycheck" colType="string"/>
	<td></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<%-- Table body --%>
<logic:iterate id="et" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="et">
<%
	pageContext.setAttribute("etaptypeid",et.getColumn("etaptypeid").asString());
	String haveendtime = et.getColumn("haveendtime").asString();
	String havehopslink = et.getColumn("havehopslink").asString();
	String havepaycheck = et.getColumn("havepaycheck").asString();
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td>
		<july:editbutton page="/EditEtapType.do" action="Edit" paramId="etaptypeid" paramName="etaptypeid" alttext="label.etaptype.button.edit"/>
	</td>
	<td class="text"><july:stringwrite name="et" property="ettypename"/></td>
	<td class="text"><%if("Y".equals(haveendtime)) {%><img src="/images/yes.gif" border="0"><%}%></td>
	<td class="text"><%if("Y".equals(havehopslink)) {%><img src="/images/yes.gif" border="0"><%}%></td>
	<td class="text"><%if("Y".equals(havepaycheck)) {%><img src="/images/yes.gif" border="0"><%}%></td>
	<td class="link"><july:delbutton page="/EditEtapType.do?action=Delete" paramId="etaptypeid" paramName="etaptypeid" paramScope="page"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>
<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<html:link page='/EditEtapType.do?action=Add'><img alt='<bean:message key="label.etaptype.add"/>' src="/images/plus.gif" border=0></html:link>
        			<img alt="" src="/images/empty.gif" width=3 border=0>
				<july:backbutton/>
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
</table>
<script language="javascript">
allClicked();
</script>
</july:browseform>
