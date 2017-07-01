<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.formbean.*"%>
<%@ page import="com.hps.july.web.util.*"%>
<%@ page import="com.hps.july.basestation.*"%>
<%@ page import="com.hps.july.persistence2.GKRCHDocValueObject"%>

<july:editform action="/ProcessGKRCHDoc.do" styleId="GKRCHForm">
<input type="hidden" name="delfiles" value="">
<script language="javascript">
var curLine = 2;
var curRegLine = 2;

function delFiles() {
	var b = false;
	if(confirm('Вы действительно хотите удалить отмеченные файлы?')) {
		b = true;
		document.all.delfiles.value = 'selected';
	}
	return b;
}

function delResource() {
	document.all.restbl.deleteRow(curLine);
	return false;
}

function delRegion() {
	document.all.regtbl.deleteRow(curRegLine);
	return false;
}

function saveIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curLine=window.event.toElement.parentElement.rowIndex; 
	}
}

function saveRegIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curRegLine=window.event.toElement.parentElement.rowIndex; 
	}
}

function addRegion() {
	var rg = document.all.regions;
	var check = true;
	if(rg) {
		for(var i = 0; i < rg.length; i++) {
			if(rg[i].value == document.all.reginscode.value) {
				check = false;
			}
		}
	}

	if(check) {
		var newRow = document.all.regtbl.insertRow();
		newRow.className = "normal";
		newRow.onmouseover = saveRegIndex;
		for (var i=0; i < 3; i++) {
			var newCell = newRow.insertCell();
			newCell.className = "text";
		}
		newRow.cells(0).innerHTML = '<input type="hidden" name="regions" value='+document.all.reginscode.value+'>'+document.all.reginsname.value;
		newRow.cells(1).innerText = document.all.supreginsname.value;
		newRow.cells(2).innerHTML = '<input type="image" src="/images/del.gif" onclick="return delRegion();" name="delG"/>';
		newRow.onmouseover=saveRegIndex;
		
	} else {
		alert("Регион '"+document.all.reginsname.value+"' уже присутствует в списке");
	}
}

function addResource() {
	var ra = document.all.resources;
	var check = true;
	if(ra) {
		for(var i = 0; i < ra.length; i++) {
			if(ra[i].value == document.all.resinscode.value) {
				check = false;
			}
		}
	}
	
	if(check) {
		var newRow = document.all.restbl.insertRow();
		newRow.className = "normal";
		newRow.onmouseover = saveIndex;
		for (var i=0; i < 4; i++) {
			var newCell = newRow.insertCell();
			newCell.className = "text";
		}
		newRow.cells(0).innerHTML = '<input type="hidden" name="resources" value='+document.all.resinscode.value+'>'+document.all.resinsname.value;
		newRow.cells(1).innerText = document.all.resinsmodel.value;
		newRow.cells(2).innerHTML = '<input type="text" size="10" name="resfreq['+document.all.resinscode.value+']" value="" class="editsearch">';
		newRow.cells(3).innerHTML = '<input type="image" src="/images/del.gif" onclick="return delResource();" name="delR"/>';
		newRow.onmouseover=saveIndex;
	} else {
		alert("Оборудование '"+document.all.resinsname.value+", "+document.all.resinsmodel.value+"' уже присутствует в списке");
	}
}

function checkAllResources() {
	var sel = document.all.selRes;
	for(var i = 0; i < sel.length; i++) {
		sel[i].checked = true;
	}
}
</script>

<%
	GKRCHForm dForm = (GKRCHForm)pageContext.findAttribute("GKRCHForm");
	boolean changable = "Edit".equals(dForm.getAction()) || "Add".equals(dForm.getAction());
	System.out.println("Regions:"+dForm.getRegions());
	if(dForm.getRegions() != null) {
		System.out.println("RegionsLen:"+dForm.getRegions().length);
		for(int i = 0; i < dForm.getRegions().length; i++) {
			System.out.println("REG["+i+"]:"+dForm.getRegions()[i]);
		}
	}
%>

<html:hidden property="sitedoc"/>

<table class="main">
<july:separator/>
<july:formbuttons/>
<july:separator/>
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.gkrch.form.number"/></july:reqmark>:</td>
	<td class="text">
		<july:string size="20" property="vo.blanknumber" styleId="blnaknumber" insertable="true" updatable="true"/>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.gkrch.form.date"/></july:reqmark>:</td>
	<td class="text">
		<july:date property="blankdate.string" styleId="blankdate" insertable="true" updatable="true"/>
	</td>
</tr>
<%--
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.gkrch.form.freqrange"/></july:reqmark>:</td>
	<td class="text">
		<july:string size="40" property="vo.freqrange" styleId="freqrange" insertable="true" updatable="true"/>
	</td>
</tr>
--%>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.gkrch.form.expiredate"/></july:reqmark>:</td>
	<td class="text">
		<july:date property="expiredate.string" styleId="expiredate" insertable="true" updatable="true"/>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.gkrch.form.restrictions"/>:</td>
	<td class="text">
		<july:textarea property="vo.restrictions" cols="50" rows="3" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.gkrch.form.comments"/>:</td>
	<td class="text">
		<july:textarea property="vo.comment" cols="50" rows="3" insertable="true" updatable="true" />
	</td>
</tr>
<%if(!"Delete".equals(dForm.getAction())){%>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.gkrch.form.regionslist"/></july:reqmark>:</td>
	<td class="text">
		<table width="100%" border="0" class="main" id="regtbl">
		<tr class="title">
			<td colspan="3">
				<input type="hidden" name="reginscode"><input type="hidden" name="reginsname"><input type="hidden" name="supreginscode"><input type="hidden" name="supreginsname">
				<july:lookupbutton action="/ShowRegionsLookupList.do" image="plus" styleId="regl" fieldNames="reginscode;reginsname;supreginscode;supreginsname" newWindowName="regionslookup" insertable="true" updatable="true" onselect="addRegion();"/>
			</td>
		</tr>
		<tr class="title">
			<july:headercolumn key="label.gkrch.form.regionname" colType="string"/>
			<july:headercolumn key="label.gkrch.form.supregname" colType="string"/>
			<td class="title">&nbsp;</td>
		</tr>
<logic:iterate id="reg" name="GKRCHForm" property="enteredRegionsList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="reg">
		<tr class="normal" onMouseOver="saveRegIndex();">
			<td class="text"><input type="hidden" name="regions" value='<july:stringwrite name="reg" property="regionid"/>'><july:stringwrite name="reg" property="regname"/></td>
			<td class="text"><july:stringwrite name="reg" property="supregname"/></td>
			<td class="text"><%if(changable){%><input type="image" src="/images/del.gif" onclick="return delRegion();" name="delG"/><%}%></td>
		</tr>
</logic:present>
</logic:iterate>
		</table>
	</td>
</tr>
<%--
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.gkrch.form.regionslist"/></july:reqmark>:</td>
	<td class="text">
		<july:select styleId="regioncodes" collection="regionsList" property="regions" insertable="true" updatable="true" multiple="true" size="5" style="width:452px;">
			<html:options collection="regionsList" property="regionid" labelProperty="regname"/>
		</july:select>
	</td>
</tr>
--%>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.gkrch.form.resourceslist"/></july:reqmark>:</td>
	<td class="text">
		<table width="100%" border="0" class="main" id="restbl">
		<tr class="title">
			<td colspan="4">
				<input type="hidden" name="resinscode"><input type="hidden" name="resinsname"><input type="hidden" name="resinsmodel">
				<july:lookupbutton action="/../inventory/ShowResourceLookupList.do" image="plus" styleId="resl" fieldNames="resinscode;resinsmodel;resinsname" newWindowName="resourcelookup" insertable="true" updatable="true" onselect="addResource();"/>
			</td>
		</tr>
		<tr class="title">
			<july:headercolumn key="label.gkrch.form.resourcename" colType="string"/>
			<july:headercolumn key="label.gkrch.form.resourcemodel" colType="string"/>
			<td class="title">Частотный диапазон</td>
			<td class="title">&nbsp;</td>
		</tr>
<logic:iterate id="res" name="GKRCHForm" property="resourcesList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="res">
		<tr class="normal" onMouseOver="saveIndex();">
			<td class="text"><input type="hidden" name="resources" value='<july:stringwrite name="res" property="resource"/>'><july:stringwrite name="res" property="name"/></td>
			<td class="text"><july:stringwrite name="res" property="model"/></td>
			<td class="text"><input type="text" size="10" name="resfreq[<july:stringwrite name='res' property='resource'/>]" value="<july:stringwrite name='res' property='freq'/>" class="editsearch"></td>
			<td class="text"><%if(changable){%><input type="image" src="/images/del.gif" onclick="return delResource();" name="delR"/><%}%></td>
		</tr>
</logic:present>
</logic:iterate>
		</table>
	</td>
</tr>
<%}%>
<july:separator/>
<july:formbuttons/>
<%
if("View".equals(dForm.getAction()) || "Edit".equals(dForm.getAction())) {
	String editLink = "/EditSiteDocFile.do?sitedoc="+dForm.getSitedoc();
%>
<july:separator/>
<tr>
	<td class="text" colspan="2">
		<table width="100%" border="0" class="main" id="filetbl">
		<tr class="title">
			<td colspan="6" class="title">
				<bean:message key="label.gkrch.form.filelist"/>:
				&nbsp;
				<html:link page='<%=editLink+"&action=Add"%>'><IMG alt='Добавить файл' src="/images/plus.gif" border="0"></html:link>
				&nbsp;
				<input type="image" onclick="return delFiles();" src='/images/del_marked.gif' name="submit">
			</td>
		</tr>
		<tr class="title">
			<td class="title">&nbsp;</td>
			<td class="title">N</td>
			<july:headercolumn key="label.gkrch.form.filename" colType="string"/>
			<july:headercolumn key="label.gkrch.form.note" colType="string"/>
			<td class="title">&nbsp;</td>
			<td class="title">&nbsp;</td>
		</tr>
<%
	int i = 1;
%>
<logic:iterate id="fl" name="GKRCHForm" property="filesList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="fl">
<%
	String sitedocfile = fl.getColumn("sitedocfile").asString();
	pageContext.setAttribute("sitedocfile",sitedocfile);
%>
		<tr class="normal">
			<td class="text"><july:editbutton page="<%=editLink%>" action="Edit" paramId="sitedocfile" paramName="sitedocfile"/></td>
			<td class="text"><%=i++%></td>
			<td class="text">
				<html:link page="/../sitedoc/OpenFile.do" target="_blank" paramId="sitedocfile" paramName="sitedocfile">
					<july:stringwrite name="fl" property="sitedocfilename"/>
				</html:link>
			</td>
			<td class="text"><july:stringwrite name="fl" property="note"/></td>
			<td class="text"><input type="checkbox" class="editcheckbox" value='<%=sitedocfile%>' name='selfiles'></td>
			<td class="text"><july:delbutton page='<%=editLink+"&action=Delete"%>' paramId="sitedocfile" paramName="sitedocfile"/></td>
		</tr>
</logic:present>
</logic:iterate>
		</table>
	</td>
</tr>
<%}%>
<july:separator/>
</table>
</july:editform>
