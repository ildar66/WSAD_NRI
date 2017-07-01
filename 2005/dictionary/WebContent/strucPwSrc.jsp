<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.dictionary.formbean.*, com.hps.july.web.util.* "%>

<head>
	<META HTTP-EQUIV = "Pragma" CONTENT="no-cache"> 
	<title>Состав комплекта источника питания (тело)</title> 
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

<body>

<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
<SCRIPT language=javascript src="/common/exitFromNRI.js" type="text/javascript"></SCRIPT>  

<%
	// проверяем в каком режиме вызвана страница
	String action = ConfPowerSourcesForm.getActionString(session);
	String form = ConfPowerSourcesForm.getFormString(session); 
	boolean isElAp = ConfPowerSourcesForm.getIsElAp(session); 
	boolean isUzo = ConfPowerSourcesForm.getIsUzo(session); 
	boolean isIKBS = ConfPowerSourcesForm.getIsIkBs(session); 
	int nameWd = 256;
	if (isIKBS) {
		nameWd = nameWd + 64;
	}
%> 
<july:editform action="<%=action%>" styleId="<%=form%>">

	<html:hidden property="curComplectSelectedID"/>
	
	<table class="find" width="715" style='table-layout: fixed;' id="structResouceTableId"> 
	
   	<logic:iterate id="cmplStruct" property="cmplStructList" name="<%=form%>" 
    		type="com.hps.july.dictionary.valueobject.CmplStruct_VO">
	 
	<tr class="normal" id='<bean:write name="cmplStruct" property="nriCode" filter="true"/>' onclick='onClickRow(this.id, false);'>
	<%-- <tr class="title"> --%>
		<td width = "27" align="center" class="title">
		<logic:equal name="<%=form%>" property="isAdminRole" value="<%=ConfPowerSourcesForm.TRUE_STR%>">
		<A HREF="#"><IMG BORDER="0" SRC="/images/izmena.gif" onclick="editResource('<bean:write name="cmplStruct" 
											property="nriCode" filter="true"/>'); return false;"
											ALT='<bean:message key="button.edit"/>'>
		</A>
		</logic:equal>

		</td>
		<td width = "72" align="right" class="title"><bean:write name="cmplStruct" 
											property="nriCode" filter="true"/></td>
		<td width = "<%=nameWd%>" align="left" class="title"><bean:write name="cmplStruct" 
											property="resourceName" filter="true"/></td>
		<% if (isElAp || isUzo) { %>
			<td width = "251" align="left" class="title"><bean:write name="cmplStruct" 
												property="model" filter="true"/></td>
		<% } %>
		<td width = "67" align="right" class="title"><bean:write name="cmplStruct" 
											property="quantity" filter="true"/></td>
		<% if (isIKBS) { %>
			<td width = "72" align="left" class="title"><bean:write name="cmplStruct" 
											property="unit_name" filter="true"/></td>
			<td width = "115" align="left" class="title">
				<logic:equal name="cmplStruct" property="enablednfs" value="true">
				<A HREF="#" 
					onclick="showAllNfsCode('<bean:write name="cmplStruct" property="nriCode" filter="true"/>'); return false;">
					<bean:write name="cmplStruct" property="nfsid" filter="true"/>
					<logic:greaterThan name="cmplStruct" property="count_nfs" value="1">
					...
					</logic:greaterThan>
				</A>
				</logic:equal>
			</td>
		<% } %> 
		<td width = "27" align="left" class="title">
		
		<logic:equal name="<%=form%>" property="isAdminRole" value="<%=ConfPowerSourcesForm.TRUE_STR%>">
		<A HREF="#"><IMG BORDER="0" 
			SRC="/images/delconf.gif" onclick="delResource('<bean:write name="cmplStruct" 
			property="nriCode" filter="true"/>'); return false;"
			ALT="<bean:message key='button.delete'/>">
		</A>
		</logic:equal>
											
		</td>
	</tr>
	
    </logic:iterate>
   
	</table>

</july:editform>

<html:hidden property="curResourceSelectedID"/>
<html:hidden property="curResourceOldRowClassName"/>

<script language="javascript">

function onClickRow(selectedID, isScroll) {
	if(document.all['structResouceTableId'].rows(document.all['curResourceSelectedID'].value) != null) {
		if ((document.all['curResourceOldRowClassName'].value != null) && (document.all['curResourceOldRowClassName'].value != '')) {
	 		document.all['structResouceTableId'].rows(document.all['curResourceSelectedID'].value,0).className=
				document.all['curResourceOldRowClassName'].value;
		}	
	}
	if (document.all['structResouceTableId'].rows(selectedID,0)) {
		document.all['curResourceSelectedID'].value=selectedID;
		document.all['curResourceOldRowClassName'].value=document.all['structResouceTableId'].rows(selectedID,0).className;
		document.all['structResouceTableId'].rows(selectedID,0).className="selectedrow";
		// откорректировать текущее в родителе и в списке комплектов
		if (parent.document.all['curResourceSelectedID']) {
				parent.document.all['curResourceSelectedID'].value = selectedID;
		}
		if (parent.document.frames['curCmplIFrame'] && 
			parent.document.frames['curCmplIFrame'].document.all['curResourceSelectedID']) {
				parent.document.frames['curCmplIFrame'].document.all['curResourceSelectedID'].value=
					selectedID;
		}
		if (isScroll) {
			document.all['structResouceTableId'].rows(selectedID,0).scrollIntoView(true);
		}
	}
}

function editResource(nriCode) {
	var resourceSet = document.all['curComplectSelectedID'].value;
	openDialog("EditPowerResource.do?action=<%=EditForm.ACTION_EDIT%>&nriCode="+nriCode+
		"&isLoadFromDB="+<%=ConfPowerSourcesForm.TRUE_STR%>+
		"&resourceSet="+resourceSet+"&unitInt="+<%=(isElAp || isUzo)%>,
	"editPowerResourceForm", "top=0, left=0, width=1000, height=350, scrollbars=auto, resizable=yes");
}											

function delResource(nriCode) {
	var resourceSet = document.all['curComplectSelectedID'].value;
	openDialog("EditPowerResource.do?action=<%=EditForm.ACTION_DELETE%>&nriCode="+nriCode+
		"&isLoadFromDB="+<%=ConfPowerSourcesForm.TRUE_STR%>+
		"&resourceSet="+resourceSet+"&unitInt="+<%=(isElAp || isUzo)%>,
	"deletePowerResourceForm", "top=0, left=0, width=1000, height=350, scrollbars=auto, resizable=yes");
}											

function showAllNfsCode(id) {
    openDialog("ShowAllNfsCodes.do?resource="+id+ "&action=View", 
				"editConfPowerForm", "top=0, left=0, width=1000, height=350, scrollbars=auto, resizable=yes");
}				

// начальные установки
onClickRow(document.all['curResourceSelectedID'].value, true);

</script>
</body>

											