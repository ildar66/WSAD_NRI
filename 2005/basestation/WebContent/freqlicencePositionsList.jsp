<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.formbean.*"%>

<%
	java.lang.String gColSpan = "9";
	FrequencyLicencePositionsListForm lForm = (FrequencyLicencePositionsListForm)pageContext.findAttribute("FrequencyLicencePositionsListForm");
	boolean showOL = false;
	if(lForm.getAddaction() != null && "L".equals(lForm.getAddaction())) {
		showOL = true;
		lForm.setAddaction("");
	}
%>

<july:browseform action="/ShowFrequencyLicencePositionsList.do" styleId="FrequncyLicencePositionsListForm">
<input type="hidden" name="addaction" value="">
<input type="hidden" name="orderno_val" value="">
<input type="hidden" name="haveplan_val" value="">

<july:selectableTable styleClass="main" modelName="list" selectable="1" selectedClass="selected" paramName="selID" >
<script language="javascript">
function selectAllClick() {
	var l = 0;
	if(document.all.selectedpos) {
		if(document.all.selectedpos.length) {
			l = document.all.selectedpos.length;
		} else if(document.all.selectedpos.value) {
			l = 1;
		}
	}
	for(var i = 0; i < l; i++) {
		document.all.selectedpos[i].checked = document.all.selectall[0].checked;
	}
}

function isAnySelected() {
	var l = 0;
	var b = false;
	if(document.all.selectedpos) {
		if(document.all.selectedpos.length) {
			l = document.all.selectedpos.length;
		} else if(document.all.selectedpos.value) {
			l = 1;
		}
	}
	for(var i = 0; i < l; i++) {
		if(document.all.selectedpos[i].checked) {
			b = true;
		}
	}
	return b;
}

function combineChecked() {
	var l = 0;
	var b = "?";
	if(document.all.selectedpos) {
		if(document.all.selectedpos.length) {
			l = document.all.selectedpos.length;
		} else if(document.all.selectedpos.value) {
			l = 1;
		}
	}
	var first = true;
	for(var i = 0; i < l; i++) {
		if(document.all.selectedpos[i].checked) {
			if(first == true) { first = false; }
			else { b = b + "&"; }
			b = b + "selectedpos="+document.all.selectedpos[i].value;
		}
	}
	return b;
}

function processOrderno() {
	if(isAnySelected() == false) {
		alert('Для установки номера заказа необходимо отметить хотя бы одну позицию!');
		return;
	}
	var v = window.showModalDialog(
		'/basestation/freqlicencePositionsOrderPrompt.html',
		'',
		'dialogHeight:120px;dialogWidth:500px;scroll:no;status:no;help:no;'
	);
	if(v != null) {
		document.all.addaction.value='O';
		document.all.orderno_val.value=v;
		document.forms[0].submit();
	}
}

function processHaveplan() {
	if(isAnySelected() == false) {
		alert('Для установки признака наличия выкопировки необходимо отметить хотя бы одну позицию!');
		return;
	}
	var v = window.showModalDialog(
		'/basestation/freqlicencePositionsHaveplanPrompt.html',
		'',
		'dialogHeight:120px;dialogWidth:500px;scroll:no;status:no;help:no;'
	);
	if(v != null) {
		document.all.addaction.value='H';
		document.all.haveplan_val.value=v;
		document.forms[0].submit();
	}
}

function canShow() {
	var b = false;
	if(isAnySelected() == false) {
		alert('Необходимо отметить хотя бы одну позицию!');
	} else {
		b = true;
	}
	return true;
}
function processOrderLetter() {
	if(canShow() == true) {
		document.all.addaction.value='L';
		document.forms[0].submit();
	}
	return false;
}
</script>
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
<td colspan="<%=gColSpan %>">
	<table class="find">
	<tr>
		<td class="title"><bean:message key="label.freqpermpos.filenumber"/>:</td>
		<td class="title"><bean:write name="FrequencyLicencePositionsListForm" property="filenumber" filter="true"/></td>
		<td class="title" rowspan="3" valign="top"><july:searchbutton/></td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.freqpermpos.poscount"/>:</td>
		<td class="title"><bean:write name="FrequencyLicencePositionsListForm" property="positioncount" filter="true"/></td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.freqpermpos.filter"/>:</td>
		<td class="title">
			<july:select property="filter" insertable="true" updatable="true" styleClass="search">
				<html:option key="label.freqpermpos.filter.all" value="*"/>
				<html:option key="label.freqpermpos.filter.wowaymap" value="1"/>
				<html:option key="label.freqpermpos.filter.wowaymapnzak" value="2"/>
			</july:select>
		</td>
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
				<july:backbutton/>
				<IMG alt="" src="/images/empty.gif" width=3 border=0>
				<img src="/images/orderno_btn.gif" border=0 style="cursor:hand;" onclick="processOrderno();">
				<IMG alt="" src="/images/empty.gif" width=3 border=0>
				<img src="/images/haveplan_btn.gif" border=0 style="cursor:hand;" onclick="processHaveplan();">
				<IMG alt="" src="/images/empty.gif" width=3 border=0>
<july:wordedit styleId="wordPrintTop" url="GetOrderLetter.do" uploadurl="GetOrderLetter.do" beforeclick="processOrderLetter();" documentid="0" updatable="false">
				<img src="/images/print.gif" border=0>
</july:wordedit>
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />

<%-- Table header --%>
<tr class="title">
	<td class="title"></td>
	<july:sortcolumn key="label.freqpermpos.table.gsmid" colType="string" ascFinder="5" descFinder="6"/>
	<july:sortcolumn key="label.freqpermpos.table.dampsid" colType="string" ascFinder="7" descFinder="8"/>
	<july:sortcolumn key="label.freqpermpos.table.posname" colType="string" ascFinder="3" descFinder="4"/>
	<july:headercolumn key="label.freqpermpos.table.posaddress" colType="string"/>
	<july:headercolumn key="label.freqpermpos.table.haveplan" colType="string"/>
	<july:headercolumn key="label.freqpermpos.table.orderno" colType="string"/>
	<july:headercolumn key="label.freqpermpos.table.waymap" colType="string"/>
	<td class="title"><july:checkbox property="selectall" styleClass="editcheckbox" value="true" insertable="true" updatable="true" onclick="selectAllClick();"/></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="fl" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="fl">
<%
	String id = fl.getColumn("storageplace").asString();
	pageContext.setAttribute("storageplace",id);
	String hp = "label.freqpermpos.haveplan" + fl.getColumn("haveplan").asString();
	Object waymap = fl.getColumn("waymap").asObject();
%>
<july:selectableTR styleId="<%=id%>" paramName="selID" selectable="true" styleClass="normal"  onmouseover="className='select'" onmouseout="className='normal'">
	<td class="link" align="middle">
		<july:editbutton page="/../siteinfo/EditPosition.do" action="Edit" paramId="storageplace" paramName="storageplace"/>
	</td>
	<td class="number" align="right"><july:stringwrite name="fl" property="gsmid"/></td>
	<td class="number" align="right"><july:stringwrite name="fl" property="dampsid"/></td>
	<td class="text"><july:stringwrite name="fl" property="posname"/></td>
	<td class="text"><july:stringwrite name="fl" property="posaddress"/></td>
	<td class="text"><bean:message key="<%=hp%>"/></td>
	<td class="text"><july:stringwrite name="fl" property="orderno"/></td>
	<td class="text">
		<%if(waymap != null) {%>
		<july:wordedit styleId='<%= "wrded1_" + id %>' contextpath="/siteinfo" url='<%= "cardView?namedValue=WayMapDocType&position=" + id %>' uploadurl="CardPassWordUploadAction.do" documentid="<%= id %>" updatable="true">
			<IMG SRC="/images/path.gif" border=0 ALT='<bean:message key="label.freqpermpos.table.waymap"/>'>
		</july:wordedit>
		<%}%>
	</td>
	<td class="text"><july:checkbox insertable="true" updatable="true" property="selectedpos" value="<%=id%>"/></td>
</july:selectableTR>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<july:backbutton/>
				<IMG alt="" src="/images/empty.gif" width=3 border=0>
				<img src="/images/orderno_btn.gif" border=0 style="cursor:hand;" onclick="processOrderno();">
				<IMG alt="" src="/images/empty.gif" width=3 border=0>
				<img src="/images/haveplan_btn.gif" border=0 style="cursor:hand;" onclick="processHaveplan();">
				<IMG alt="" src="/images/empty.gif" width=3 border=0>
<july:wordedit styleId="wordPrintBot" url="GetOrderLetter.do" uploadurl="GetOrderLetter.do" beforeclick="return processOrderLetter();" documentid="0" updatable="false">
				<img src="/images/print.gif" border=0>
</july:wordedit>
<%--
				<html:link target="_blank" page="/GetOrderLetter.do" onclick="if(canShow()) { this.href += combineChecked(); return true; } else { return false; }"></html:link>
--%>
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</july:selectableTable>

<% if(showOL) { %>
<script language="javascript">
wordPrintBot_call();
</script>
<% } %>

</july:browseform>
