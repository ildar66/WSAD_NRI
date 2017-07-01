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

<july:editform action="/ProcessEtapDoc.do" styleId="EtapDocForm">
<%
	EtapDocForm dForm = (EtapDocForm)pageContext.findAttribute("EtapDocForm");
	boolean changable = "Edit".equals(dForm.getAction()) || "Add".equals(dForm.getAction());
%>

<html:hidden property="hasComlinelinks"/>
<html:hidden property="hasExpiredate"/>
<html:hidden property="hasPaycheck"/>
<html:hidden property="sitedoc"/>
<html:hidden property="vo.freqpermid"/>

<input type="hidden" name="delfiles" value="">

<script language="javascript">
<%=dForm.getHasComArr()%>

<%=dForm.getHasExpArr()%>

<%=dForm.getHasPayArr()%>
</script>

<script language="javascript">
function onChangeEtaptype() {
	var v = document.all.etaptypeid.value;
//	alert('Changed type "'+v+'" Need comline:'+comlinks[v]+' Need exp:'+expdate[v]);
	if('Y' == comlinks[v]) {
		hasComlinelinks = "true";
		document.all.equlinktr.style.display = 'block';
		document.all.equlinktr.style.visibility = 'inherit';
		document.all.equlinktr2.style.display = 'block';
		document.all.equlinktr2.style.visibility = 'inherit';
<%if(!"Delete".equals(dForm.getAction())) {%>
    if (document.all.comlinetr) {
  		document.all.comlinetr.style.display = 'block';
  		document.all.comlinetr.style.visibility = 'inherit';
    }
    if (document.all.comlinetr2) {
		  document.all.comlinetr2.style.display = 'block';
		  document.all.comlinetr2.style.visibility = 'inherit';
    }
<% } %>
	} else {
		hasComlinelinks = "false";
		document.all.equlinktr.style.display = 'none';
		document.all.equlinktr.style.visibility = 'hidden';
		document.all.equlinktr2.style.display = 'none';
		document.all.equlinktr2.style.visibility = 'hidden';
<%if(!"Delete".equals(dForm.getAction())) {%>
    if (document.all.comlinetr) {
		  document.all.comlinetr.style.display = 'none';
		  document.all.comlinetr.style.visibility = 'hidden';
    }
    if (document.all.comlinetr2) {
		  document.all.comlinetr2.style.display = 'none';
		  document.all.comlinetr2.style.visibility = 'hidden';
    }
<% } %>
	}

	if('Y' == expdate[v]) {
		hasExpiredate = "true";
//		alert('EXP TR:'+document.all.expiretr.currentStyle.display+','+document.all.expiretr.currentStyle.visibility);
		document.all.expiretr.style.display = 'block';
		document.all.expiretr.style.visibility = 'inherit';
		document.all.expiretr2.style.display = 'block';
		document.all.expiretr2.style.visibility = 'inherit';
	} else {
		hasExpiredate = "false";
		document.all.expiretr.style.display = 'none';
		document.all.expiretr.style.visibility = 'hidden';
		document.all.expiretr2.style.display = 'none';
		document.all.expiretr2.style.visibility = 'hidden';
	}

	if('Y' == paycheck[v]) {
		hasPaycheck = "true";
		document.all.paychtr.style.display = 'block';
		document.all.paychtr.style.visibility = 'inherit';
		document.all.paychtr2.style.display = 'block';
		document.all.paychtr2.style.visibility = 'inherit';
	} else {
		hasPaycheck = "false";
		document.all.paychtr.style.display = 'none';
		document.all.paychtr.style.visibility = 'hidden';
		document.all.paychtr2.style.display = 'none';
		document.all.paychtr2.style.visibility = 'hidden';
	}
}

function delFiles() {
	var b = false;
	if(confirm('Вы действительно хотите удалить отмеченные файлы?')) {
		b = true;
		document.all.delfiles.value = 'selected';
	}
	return b;
}

var comlinesc = false;
var comlineline;

function checkAllComlines() {
	var cb = document.all.comlines;
	comlinesc = !comlinesc;
	if(cb.checked) {
		cb.checked = comlinesc;
	} else {
		for(var i = 0; i < cb.length; i++) {
			cb[i].checked = comlinesc;
			document.all.comlinetbl.rows[i+2].className = comlinesc?'normal':'expired';
		}
	}
}

function changeComlineColor(chk) {
	if(comlineline) {
		document.all.comlinetbl.rows[comlineline].className = chk?'normal':'expired';
	}
} 
</script>

<table class="main">
<july:separator/>
<july:formbuttons/>
<july:separator/>
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.etap.form.number"/></july:reqmark>:</td>
	<td class="text">
		<july:string size="20" property="vo.blanknumber" styleId="blnaknumber" insertable="true" updatable="true"/>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.etap.form.date"/></july:reqmark>:</td>
	<td class="text">
		<july:date property="blankdate.string" styleId="blankdate" insertable="true" updatable="true"/>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.etap.form.etaptype"/></july:reqmark>:</td>
	<td class="text">
		<july:select styleId="etaptypeid" collection="etapTypesList" property="vo.etaptypeid" insertable="true" updatable="true" style="width:452px;" onchange="onChangeEtaptype();">
			<html:options collection="etapTypesList" property="etaptypeid" labelProperty="etaptypename"/>
		</july:select>
	</td>
</tr>
<july:separator/>
<tr id="expiretr">
	<td class="text"><july:reqmark><bean:message key="label.etap.form.expiredate"/></july:reqmark>:</td>
	<td class="text">
		<july:date property="expiredate.string" styleId="expiredate" insertable="true" updatable="true"/>
	</td>
</tr>
<tr id="expiretr2"><td class="probel" colspan="2"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td></tr>
<tr>
	<td class="text"><bean:message key="label.etap.form.comments"/>:</td>
	<td class="text">
		<july:textarea property="vo.comment" cols="50" rows="3" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr id="equlinktr">
	<td class="text"><bean:message key="label.etap.form.equiplink"/>:</td>
	<td class="text">
		<july:radio styleClass="editcheckbox" property="vo.equiplink" value="-" insertable="true" updatable="true" />
		<bean:message key="label.etap.equiplink."/>&nbsp;
		<july:radio styleClass="editcheckbox" property="vo.equiplink" value="A" insertable="true" updatable="true" />
		<bean:message key="label.etap.equiplink.A"/>&nbsp;
		<july:radio styleClass="editcheckbox" property="vo.equiplink" value="B" insertable="true" updatable="true" />
		<bean:message key="label.etap.equiplink.B"/>&nbsp;
	</td>
</tr>
<tr id="equlinktr2"><td class="probel" colspan="2"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td></tr>
<tr id="paychtr">
	<td class="text">&nbsp;</td>
	<td class="text">
		<july:checkbox styleClass="editcheckbox" property="vo.havepay" value="true" insertable="true" updatable="true" />&nbsp;
		<bean:message key="label.etap.form.havepaycheck"/>
	</td>
</tr>
<tr id="paychtr2"><td class="probel" colspan="2"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td></tr>
<%if(!"Delete".equals(dForm.getAction())) {%>
<tr id="comlinetr">
	<td class="text" colspan="2">
		<table width="100%" border="0" class="main" id="comlinetbl">
		<tr class="title">
			<td colspan="9" class="title"><bean:message key="label.freqform.comlines"/></td>
		</tr>
		<tr class="title">
<%if(!"View".equals(dForm.getAction())) {%>
			<td class="title"><a href="#" onclick="checkAllComlines();return false;" alt="Отметить все"><img src="/images/yes.gif" border=0 width=16 height=16></a></td>
<% } %>
			<july:headercolumn key="label.sitedoc.number" colType="string"/>
			<july:headercolumn key="label.freqform.comlinecode" colType="string"/>
			<july:headercolumn key="label.freqform.position_a" colType="string"/>
			<july:headercolumn key="label.freqform.resource_a" colType="string"/>
			<td class="title">&nbsp;</td>
			<july:headercolumn key="label.freqform.position_b" colType="string"/>
			<july:headercolumn key="label.freqform.resource_b" colType="string"/>
			<july:headercolumn key="label.freqform.comlinetype" colType="string"/>
		</tr>
<logic:iterate id="com" name="EtapDocForm" property="comlinesList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="com">
<%
	String type = com.getColumn("comlinetype").asString();
	Object o = com.getColumn("hopsid").asObject();
	int hopsid = 0;
	if(o != null && o instanceof Integer) {
		hopsid = ((Integer)o).intValue();
	}
	String checked = "";
	String cbstyle = "expired";
	if(dForm.isComlineLinked(hopsid)) {
		checked = "checked";
		cbstyle = "normal";
	}
%>
		<tr class="<%=cbstyle%>" onmouseover="comlineline=this.rowIndex;">
<%if(!"View".equals(dForm.getAction())) {%>
			<td class="text"><input type="checkbox" class="editcheckbox" name="comlines" onclick="changeComlineColor(this.checked);" <%=checked%> value='<%=hopsid%>'></td>
<% } %>
			<td class="text"><july:stringwrite name="com" property="numberinfile"/></td>
			<td class="text"><july:stringwrite name="com" property="comlinecode"/></td>
			<td class="text"><july:stringwrite name="com" property="positiona"/></td>
			<td class="text"><july:stringwrite name="com" property="resourcea"/></td>
			<td class="text">-</td>
			<td class="text"><july:stringwrite name="com" property="positionb"/></td>
			<td class="text"><july:stringwrite name="com" property="resourceb"/></td>
			<td class="text"><bean:message key="<%=type%>"/></td>
		</tr>
</logic:present>
</logic:iterate>
		</table>
	</td>
</tr>
<tr id="comlinetr2"><td class="probel" colspan="2"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td></tr>
<%}%>
<july:formbuttons/>
<july:separator/>
<%
if("View".equals(dForm.getAction()) || "Edit".equals(dForm.getAction())) {
	String editLink = "/EditSiteDocFile.do?sitedoc="+dForm.getSitedoc();
%>
<tr>
	<td class="text" colspan="2">
		<table width="100%" border="0" class="main" id="filetbl">
		<tr class="title">
			<td colspan="6" class="title">
				<bean:message key="label.gkrch.form.filelist"/>:
				&nbsp;
    <%if(!"View".equals(dForm.getAction())) {%>
				<html:link page='<%=editLink+"&action=Add"%>'><IMG alt='Добавить файл' src="/images/plus.gif" border="0"></html:link>
				&nbsp;
				<input type="image" onclick="return delFiles();" src='/images/del_marked.gif' name="submit">
    <% } %>
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
<logic:iterate id="fl" name="EtapDocForm" property="filesList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="fl">
<%
	String sitedocfile = fl.getColumn("sitedocfile").asString();
	pageContext.setAttribute("sitedocfile",sitedocfile);
%>
		<tr class="normal">
    <%if(!"View".equals(dForm.getAction())) {%>
			<td class="text"><july:editbutton page="<%=editLink%>" action="Edit" paramId="sitedocfile" paramName="sitedocfile"/></td>
    <% } else { %>
			<td class="text"><july:editbutton page="<%=editLink%>" action="View" paramId="sitedocfile" paramName="sitedocfile"/></td>
    <% } %>
			<td class="text"><%=i++%></td>
			<td class="text">
				<html:link page="/../sitedoc/OpenFile.do" target="_blank" paramId="sitedocfile" paramName="sitedocfile">
					<july:stringwrite name="fl" property="sitedocfilename"/>
				</html:link>
			</td>
			<td class="text"><july:stringwrite name="fl" property="note"/></td>
    <%if(!"View".equals(dForm.getAction())) {%>
			<td class="text"><input type="checkbox" class="editcheckbox" value='<%=sitedocfile%>' name='selfiles'></td>
			<td class="text"><july:delbutton page='<%=editLink+"&action=Delete"%>' paramId="sitedocfile" paramName="sitedocfile"/></td>
    <% } else { %>
      <td class="text">&nbsp;</td>
      <td class="text">&nbsp;</td>
    <% } %>
		</tr>
</logic:present>
</logic:iterate>
		</table>
	</td>
</tr>
<july:separator/>
<%}%>
</table>
<script language="javascript">onChangeEtaptype();</script>
</july:editform>
