<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.basestation.valueobject.*,com.hps.july.siteinfo.formbean.*"%>

<july:browseform action="/ShowPositionLookupList.do" styleId="PosForm">
<%-- resultCols="6;17;7;8;9;3;10;11;12;13;14;15;16" --%>
<july:lookupresult tableId="brtable" resultCols="7;18;8;9;10;4;11;12;13;14;15;16;17"/>
<table class="main">
<tr class="title"><td class="title"><bean:message key="label.choose.position"/></td></tr>

<script language="javascript">

function switchRenterSearch(state) {
	 if(state) {
	   	PosForm.organization.className = 'editkoddisabled';
		PosForm.organization.disabled = true;
	} else {
		 PosForm.organization.className = 'editkodsearch';
		PosForm.organization.disabled = false;
	 }
}
function switchWorkerSearch(state) {
	if(state) {
		PosForm.worker.className = 'editkoddisabled';
		PosForm.worker.disabled = true;
	} else {
		PosForm.worker.className = 'editkodsearch';
		PosForm.worker.disabled = false;
	}
}
function switchAllSearch() {
	if(PosForm.searchBy.value=="A" ||
	   PosForm.searchBy.value=="F" ||
	   PosForm.searchBy.value=="G" ||
	   PosForm.searchBy.value=="H" ||
	   PosForm.searchBy.value=="K" ||
	   PosForm.searchBy.value=="L" ||
	   PosForm.searchBy.value=="M" 
	) {
		  PosForm.searchString.className = 'editdisabled';
		  PosForm.searchString.disabled = true;
	} else {
		PosForm.searchString.className = 'editsearch';
		PosForm.searchString.disabled = false;
	}
}
</script>

<tr class='normal'><td>
<table class='find' style="font-size: 8pt;">
	<tr>
		<td class="title" colspan="2">
		<table border=0 width="100%" cellpadding=0 cellspacing=0>
		<tr>
			<td><jsp:include page="/common/regionsselect.jsp" flush="true" /></td>
			<td><july:searchbutton/></td>
		</tr>
		</table>
		</td>
	</tr>
	<%--@ include file="/positionLookupList/multipleSelect.jsp"--%>
	<tr>
		<td class="title"><bean:message key="label.position.searchby"/></td>
		<td class="title">
			<july:select property="searchBy" styleClass="editsearch" style="font-size: 8pt;" onchange="switchAllSearch();" insertable="true" updatable="true">
				<html:option value="A"><bean:message key="label.position.search.all"/></html:option>
				<html:option value="F"><bean:message key="label.position.search.bsgsm"/></html:option>
				<html:option value="G"><bean:message key="label.position.search.bsdamps"/></html:option>
				<html:option value="H"><bean:message key="label.position.search.nobs"/></html:option>
				<html:option value="B"><bean:message key="label.position.search.gsmid"/></html:option>
				<html:option value="C"><bean:message key="label.position.search.dampsid"/></html:option>
				<html:option value="D"><bean:message key="label.position.search.name"/></html:option>
				<html:option value="E"><bean:message key="label.position.search.addr"/></html:option>
				<html:option value="I"><bean:message key="label.position.search.trid"/></html:option>
				<html:option value="K"><bean:message key="label.position.search.trall"/></html:option>
				<html:option value="L"><bean:message key="label.position.search.trrrl"/></html:option>
				<html:option value="M"><bean:message key="label.position.search.trvot"/></html:option>
				<html:option value="N"><bean:message key="label.position.search.beenetid"/></html:option>
				<html:option value="O"><bean:message key="label.position.search.contrnum"/></html:option>
				<html:option value="R"><bean:message key="label.position.search.repeaternum"/></html:option>
				<html:option value="W"><bean:message key="label.position.search.wlannum"/></html:option>
			</july:select>&nbsp;&nbsp;
			<bean:message key="label.position.search.text"/>&nbsp;<html:text styleClass="search" style="font-size: 8pt;" property="searchString" styleId="editsearch" size="25" />
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.position.posstate"/></td>
		<td class="title">
			<july:select property="posstate" styleClass="editsearch" style="font-size: 8pt;" insertable="true" updatable="true">
				<html:option value="PE"><bean:message key="posstate.pe"/></html:option>
				<html:option value="P"><bean:message key="posstate.p"/></html:option>
				<html:option value="E"><bean:message key="posstate.e"/></html:option>
				<html:option value="D"><bean:message key="posstate.d"/></html:option>
				<html:option value="*"><bean:message key="posstate.all"/></html:option>
			</july:select>
		</td>
	</tr>
</table>
</td>
</tr>

<script language="javascript">switchAllSearch();</script>
<tr class="title"><td><table class="buttons"><tr class="title">
	<td class="buttons"><july:closebutton page="/"/></td>
	<td class="navigator"><july:navigator/></td>
</tr></table></td></tr>

<% java.lang.String gColSpan = "7"; %>

<tr><td>
<table class="main" id="brtable" style="font-size: 8pt;">

<!-- Table header -->
<tr class="title">
	<july:sortcolumn style="font-size: 8pt;" key="label.position.gsmid" colType="string" ascFinder="5" descFinder="6" />
	<july:sortcolumn style="font-size: 8pt;" key="label.position.dampsid" colType="string" ascFinder="7" descFinder="8" />
	<july:headercolumn key="label.position.repnum" colType="string"/>
	<july:sortcolumn style="font-size: 8pt;" key="label.position.name" colType="string" ascFinder="3" descFinder="4" />
	<july:headercolumn key="label.position.addr" colType="string"/>
	<july:headercolumn key="label.position.netzone" colType="string"/>
	<july:headercolumn key="label.position.inactionh" colType="string"/>
	<%for(int i=7;i<7+8;i++){%><td style='visibility:hidden;display:none'></td><%}%>
</tr>

<!-- Table body -->
<%
	int index = 0;
%>
<logic:iterate id="pos" name="browseList" indexId="idx" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="pos">
<%
	boolean inAction = "Y".equals(pos.getColumn("inaction").asString());
	Object dampsname = pos.getColumn("dampsname").asObject();
	pageContext.setAttribute("index",new Integer(index));
	String posid = "";
	Object did = pos.getColumn("numdamps").asObject();
	Object gid = pos.getColumn("numgsm").asObject();
	if(gid != null) { posid += "D"+gid; }
	if(!"".equals(posid)) { posid += " "; }
	if(did != null) { posid += "A"+did; }
	boolean isDelete = "D".equals(pos.getColumn("posstate").asString());
	String classStyle = "normal";
	if(isDelete){
		classStyle = "gray";
	}
	pageContext.setAttribute("pos_posid",posid);
%>
<tr class="<%=classStyle%>" onMouseOver="className='select'" onMouseOut="className='<%=classStyle%>'">
	<td class="number"><july:stringwrite name="pos" property="numgsm"/></td>
	<td class="number"><july:stringwrite name="pos" property="numdamps"/></td>
	<td class="number"><july:stringwrite name="pos" property="numrep"/></td>
	<td class="text"><july:lookupreturn><july:stringwrite name="pos" property="posname"/><%if(dampsname != null){%> / <july:stringwrite name="pos" property="dampsname"/><%}%></july:lookupreturn></td>
	<td class="text"><july:stringwrite name="pos" property="posaddress"/></td>
	<td class="text"><july:stringwrite name="pos" property="zonecode"/></td>
	<td class="text"><%if(inAction){%><bean:message key="label.position.inactionh"/><%}%></td>
<%--hidden--%>
	<td class="number" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="storageplace"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="supregname"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="regionname"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="zonename"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="latitude"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="longitude"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:datewrite name="pos" property="datebeginbuild"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="numdamps"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="numgsm"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="dampsname"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="posname"/></td>
	<td class="text" style='visibility:hidden;display:none'><%if(posid != null && !"".equals(posid)) {%><bean:write name="pos_posid" filter="true"/>&nbsp;<%}%><july:stringwrite name="pos" property="posname"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<%
	index++;
%>
</logic:present>
<logic:notPresent name="pos">
<tr class="normal">
	<td class="text" colspan="<%= gColSpan %>">
		<bean:message key="label.norecords"/>
	</td>
</tr>
</logic:notPresent>
</logic:iterate>
</table>
</td></tr>

<tr class="title"><td><table class="buttons"><tr class="title">
	<td class="buttons"><july:closebutton page="/"/></td>
	<td class="navigator"><july:navigator/></td>
</tr></table></td></tr>
</table>

</july:browseform>
