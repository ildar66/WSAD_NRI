<HTML>
<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.dictionary.formbean.*, com.hps.july.web.util.* "%>

<head>
	<META HTTP-EQUIV = "Pragma" CONTENT="no-cache"> 
	<title>Текущие комплекты источников питания (тело)</title> 
	<link rel="stylesheet" type="text/css" href="/main.css">

<style>
TR.normalrow {
	background-color:#F0F0F0;
}
TR.selectrow {
	background-color:#FFFFFF;
}
TR.selectedrow {
	background-color:#FFF0D0;
} 
</style>

</head>

<BODY>

	<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
	<SCRIPT language=javascript src="/common/exitFromNRI.js" type="text/javascript"></SCRIPT>  

<%
	// проверяем в каком режиме вызвана страница
	String action = ConfPowerSourcesForm.getActionString(session);
	String form = ConfPowerSourcesForm.getFormString(session); 
	boolean isElAp = ConfPowerSourcesForm.getIsElAp(session); 
	boolean isUzo = ConfPowerSourcesForm.getIsUzo(session); 
	boolean isIKBS = ConfPowerSourcesForm.getIsIkBs(session); 
%> 
<july:editform action="<%=action%>" styleId="<%=form%>" target="strucIFrame">

	<table class="find" width="715" style='table-layout: fixed;' id="curComplectTableId"> 
	
   	<logic:iterate id="curComplect" property="curComplectList" name="<%=form%>" 
    		type="com.hps.july.dictionary.valueobject.CurComplect_VO">
	
	<tr class="normal" id='<bean:write name="curComplect" property="complectCode" filter="true"/>' onclick='onClickRow(this.id, false);'>
		<td width = "27" align="center" class="title">

		<logic:equal name="<%=form%>" property="isAdminRole" value="<%=ConfPowerSourcesForm.TRUE_STR%>">
		<A HREF="#"><IMG BORDER="0" SRC="/images/izmena.gif" onclick='editConfPowerSources("<bean:write name="curComplect" 
											property="complectCode" filter="true"/>"); return false;'
											ALT='<bean:message key="button.edit"/>'>
		</A>
		</logic:equal>

		</td>
		<td width = "93" align="right" class="title"><bean:write name="curComplect" 
											property="complectCode" filter="true"/></td>
		<td width = "115" class="title">
			<bean:write name="curComplect" property="nfsCode" filter="true"/>
			<%--
			<A HREF="#" 
				onclick="showAllNfsCode('<bean:write name="curComplect" property="complectCode" filter="true"/>'); return false;">
				<bean:write name="curComplect" property="nfsCode" filter="true"/> 
			</A>
			--%>
			
		</td>
		<% if (isElAp) { %>
		<td width = "345" class="title"><bean:write name="curComplect" 
											property="complectName" filter="true"/></td>
		<td width = "93" align="right" class="title"><bean:write name="curComplect" 
											property="power" filter="true"/></td>
		<% } else if (isUzo || isIKBS) { %>
		<td width = "438" class="title"><bean:write name="curComplect" 
											property="complectName" filter="true"/></td>
		<% } %>
		<td width = "27" align="center" class="title">

		<logic:equal name="<%=form%>" property="isAdminRole" value="<%=ConfPowerSourcesForm.TRUE_STR%>">
		<A HREF="#"><IMG BORDER="0" SRC="/images/delconf.gif" onclick='deleteConfPowerSources("<bean:write name="curComplect" 
											property="complectCode" filter="true"/>"); return false;'
											ALT='<bean:message key="button.delete"/>'>
		</A>
		</logic:equal>

		</td>
	</tr>

    </logic:iterate>
   
	</table>

<html:hidden property="curComplectSelectedID"/>
<html:hidden property="curComplectOldRowClassName"/>
<html:hidden property="submitMode" value="<%=ConfPowerSourcesForm.CUR_COMPLECT_SUBMIT_MODE%>"/>
<html:hidden property="curResourceSelectedID"/>
 
</july:editform>

<script language="javascript">
function onClickRow(selectedID, isScroll) {
	if(document.all['curComplectTableId'].rows(document.all['curComplectSelectedID'].value) != null) {
		// alert(document.all['curComplectOldRowClassName'].value);
		if ((document.all['curComplectOldRowClassName'].value != null) && (document.all['curComplectOldRowClassName'].value != '')) {
	 		document.all['curComplectTableId'].rows(document.all['curComplectSelectedID'].value,0).className=
				document.all['curComplectOldRowClassName'].value;
		}	
	}
	if (document.all['curComplectTableId'].rows(selectedID,0)) {
		document.all['curComplectSelectedID'].value=selectedID;
		document.all['curComplectOldRowClassName'].value=document.all['curComplectTableId'].rows(selectedID,0).className;
	
		document.all['curComplectTableId'].rows(selectedID,0).className="selectedrow";
		// откорректировать значение в шапке таблицы ресурсов
		if (parent.document.frames['strucTitleIFrame'] && 
			parent.document.frames['strucTitleIFrame'].document.all['curComplectSelectedID']) {
				parent.document.frames['strucTitleIFrame'].document.all['curComplectSelectedID'].value=
					selectedID;
		}
		if (isScroll) {
			document.all['curComplectTableId'].rows(selectedID,0).scrollIntoView(true);
		}
		// <%=form%>.submit();
		setTimeout("<%=form%>.submit()",300);
	}
}

function editConfPowerSources(complectCode) {
	openDialog("EditConfPowerSources.do?action=<%=EditForm.ACTION_EDIT%>&complectCode="+complectCode+
		"&isLoadFromDB="+<%=ConfPowerSourcesForm.TRUE_STR%>+
		"&complectTypeCode="+<bean:write name="<%=form%>" property="complectTypeCode" filter="true"/>,
	 "editConfPowerForm", "top=0, left=0, width=1000, height=350, scrollbars=auto, resizable=yes");
}

function deleteConfPowerSources(complectCode) {
	openDialog("EditConfPowerSources.do?action=<%=EditForm.ACTION_DELETE%>&complectCode="+complectCode+
		"&isLoadFromDB="+<%=ConfPowerSourcesForm.TRUE_STR%>+
		"&complectTypeCode="+<bean:write name="<%=form%>" property="complectTypeCode" filter="true"/>,
	 "deleteConfPowerForm", "top=0, left=0, width=1000, height=350, scrollbars=auto, resizable=yes");
}
 
/* 
function showAllNfsCode(id) {
    openDialog("ShowAllNfsCodes.do?resource="+id+ "&action=View", 
				"editConfPowerForm", "top=0, left=0, width=1000, height=350, scrollbars=auto, resizable=yes");
}				
*/ 
 
// начальные установки
onClickRow(document.all['curComplectSelectedID'].value, true);

</script>

</BODY>

</HTML>
