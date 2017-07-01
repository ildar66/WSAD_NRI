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
<%@ page import="com.hps.july.persistence2.RRLDocValueObject"%>

<july:editform action="/ProcessRRLDoc.do" styleId="RRLForm">
<input type="hidden" name="delfiles" value=""/>

<script language="javascript">
var curLine = 2;

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
}

function saveIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curLine=window.event.toElement.parentElement.rowIndex; 
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
		newRow.cells(3).innerHTML = '<input type="image" src="/images/del.gif" onclick="delResource();return false;" name="delR">';
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
	RRLForm dForm = (RRLForm)pageContext.findAttribute("RRLForm");
	boolean changable = "Edit".equals(dForm.getAction()) || "Add".equals(dForm.getAction());
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
	<td class="text"><july:reqmark><bean:message key="label.rrl.form.number"/></july:reqmark>:</td>
	<td class="text">
		<july:string size="20" property="vo.blanknumber" styleId="blnaknumber" insertable="true" updatable="true"/>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.rrl.form.date"/></july:reqmark>:</td>
	<td class="text">
		<july:date property="blankdate.string" styleId="blankdate" insertable="true" updatable="true"/>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.rrl.form.orgname"/></july:reqmark>:</td>
	<td class="text">
		<july:string property="organization.string" styleId="orgcode" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/../inventory/ShowOrganizationLookupList.do" styleId="rentl" fieldNames="orgcode;orgname" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_rentl('?selisprovider=false&selisrenter=false&selissupplier=true');"/>
		<july:string size="35" property="orgname" styleId="orgname" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.rrl.form.expiredate"/></july:reqmark>:</td>
	<td class="text">
		<july:date property="expiredate.string" styleId="expiredate" insertable="true" updatable="true"/>
	</td>
</tr>
<%if(!"Delete".equals(dForm.getAction())) {%>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.rrl.form.resourceslist"/></july:reqmark>:</td>
	<td class="text">
		<table width="100%" border="0" class="main" id="restbl">
		<tr class="title">
			<td colspan="4">
				<input type="hidden" name="resinscode"><input type="hidden" name="resinsname"><input type="hidden" name="resinsmodel">
				<july:lookupbutton action="/../inventory/ShowResourceLookupList.do" image="plus" styleId="resl" fieldNames="resinscode;resinsmodel;resinsname" newWindowName="resourcelookup" insertable="true" updatable="true" onselect="addResource();"/>
			</td>
		</tr>
		<tr class="title">
			<july:headercolumn key="label.rrl.form.resourcename" colType="string"/>
			<july:headercolumn key="label.rrl.form.resourcemodel" colType="string"/>
			<td class="title">Частотный диапазон</td>
			<td class="title">&nbsp;</td>
		</tr>
<logic:iterate id="res" name="RRLForm" property="resourcesList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="res">
		<tr class="normal" onMouseOver="saveIndex();">
			<td class="text"><input type="hidden" name="resources" value='<july:stringwrite name="res" property="resource"/>'><july:stringwrite name="res" property="name"/></td>
			<td class="text"><july:stringwrite name="res" property="model"/></td>
			<td class="text"><input type="text" size="10" name="resfreq[<july:stringwrite name='res' property='resource'/>]" value="<july:stringwrite name='res' property='freq'/>" class="editsearch"></td>
			<td class="text"><%if(changable){%><input type="image" src="/images/del.gif" onclick="delResource();return false;" name="delR"/><%}%></td>
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
				<bean:message key="label.rrl.form.filelist"/>:
				&nbsp;
				<html:link page='<%=editLink+"&action=Add"%>'><IMG alt='Добавить файл' src="/images/plus.gif" border="0"></html:link>
				&nbsp;
				<input type="image" onclick="return delFiles();" src='/images/del_marked.gif' name="submit">
			</td>
		</tr>
		<tr class="title">
			<td class="title">&nbsp;</td>
			<td class="title">N</td>
			<july:headercolumn key="label.rrl.form.filename" colType="string"/>
			<july:headercolumn key="label.rrl.form.note" colType="string"/>
			<td class="title">&nbsp;</td>
			<td class="title">&nbsp;</td>
		</tr>
<%
	int i = 1;
%>
<logic:iterate id="fl" name="RRLForm" property="filesList" type="com.hps.july.cdbc.lib.CDBCRowObject">
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
			<td class="text"><input type="checkbox" class="editcheckbox" value='<%=sitedocfile%>' name='selfiles'/></td>
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
