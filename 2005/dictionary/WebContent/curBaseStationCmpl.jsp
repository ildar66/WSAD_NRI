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
	<title>“екущие комплекты базовой станции (тело)</title> 
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

<july:editform action="/ShowConfBaseStation.do" styleId="ShowConfBaseStationForm">

	<table class="find" style='width:715px; table-layout: fixed;' id="curComplectTableId"> 

	<% String fixWidth = "24"; %>
	
   	<logic:iterate id="curBaseStationComplect" property="curBaseStationComplectList" name="ShowConfBaseStationForm" 
    		type="com.hps.july.dictionary.valueobject.CurBaseStationComplect_VO">
	
	<tr class="normal"
		id='<bean:write name="curBaseStationComplect" property="id" filter="true"/>' onclick='onClickRow(this.id, false);'>
		<td style='width:<%=fixWidth%>px' align="center" class="title">
		<logic:equal name="ShowConfBaseStationForm" property="isAdminRole" value="<%=ShowConfBaseStationForm.TRUE_STR%>">
		<A HREF="#"><IMG BORDER="0" SRC="/images/izmena.gif" 
			onclick="editBaseStationConf( '<bean:write name="curBaseStationComplect" 
											property="id" filter="true"/>'); return false;"
			ALT='<bean:message key="button.edit"/>'>
		</A>
		</logic:equal>

		</td>

		<td style='width:<%=fixWidth%>px' align="center" class="title"><bean:write name="curBaseStationComplect" property="conftype" filter="true"/></td>

		<td style='width:<%=fixWidth%>px' align="center" class="title"><bean:write name="curBaseStationComplect" property="sect_a" filter="true"/></td>
		<td style='width:<%=fixWidth%>px' align="center" class="title"><bean:write name="curBaseStationComplect" property="sect_b" filter="true"/></td>
		<td style='width:<%=fixWidth%>px' align="center" class="title"><bean:write name="curBaseStationComplect" property="sect_c" filter="true"/></td>
		<td style='width:<%=fixWidth%>px' align="center" class="title"><bean:write name="curBaseStationComplect" property="sect_d" filter="true"/></td>
		<td style='width:55px' align="center" class="title"><bean:write name="curBaseStationComplect" property="sect_o1800" filter="true"/></td>

		<td style='width:<%=fixWidth%>px' align="center" class="title"><bean:write name="curBaseStationComplect" property="sect_e" filter="true"/></td>
		<td style='width:<%=fixWidth%>px' align="center" class="title"><bean:write name="curBaseStationComplect" property="sect_f" filter="true"/></td>
		<td style='width:<%=fixWidth%>px' align="center" class="title"><bean:write name="curBaseStationComplect" property="sect_g" filter="true"/></td>
		<td style='width:<%=fixWidth%>px' align="center" class="title"><bean:write name="curBaseStationComplect" property="sect_h" filter="true"/></td>
		<td style='width:55px' align="center" class="title"><bean:write name="curBaseStationComplect" property="sect_o900" filter="true"/></td>

		<td style='width:50px' align="center" class="title"><bean:write name="curBaseStationComplect" property="voltage" filter="true"/></td>
		<td style='width:100px' class="title"><bean:write name="curBaseStationComplect" property="nfsitem_id" filter="true"/></td>
		<td style='width:268px' class="title"><bean:write name="curBaseStationComplect" property="nfsitem_Name" filter="true"/></td>

		<td style='width:<%=fixWidth%>px' align="center" class="title">
		<logic:equal name="ShowConfBaseStationForm" property="isAdminRole" value="<%=ShowConfBaseStationForm.TRUE_STR%>">
		<A HREF="#"><IMG BORDER="0" SRC="/images/delconf.gif" 
			onclick="deleteBaseStationConf( '<bean:write name="curBaseStationComplect" 
											property="id" filter="true"/>'); return false;"
			ALT='<bean:message key="button.delete"/>'>
		</A>
		</logic:equal>
		
		</td>
	</tr>

    </logic:iterate>
   
	</table>

<html:hidden property="curComplectSelectedID"/>
<html:hidden property="curComplectOldRowClassName"/>
 
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
		if (isScroll) {
			document.all['curComplectTableId'].rows(selectedID,0).scrollIntoView(true);
		}
		// откорректировать значение текущей строки и класса отображени€ в родителе дл€ сохранени€ в бине при сабмите
		if (parent.document.all['curComplectSelectedID'] && 
			parent.document.all['curComplectOldRowClassName']) {
				parent.document.all['curComplectSelectedID'].value = 
						document.all['curComplectSelectedID'].value;
				parent.document.all['curComplectOldRowClassName'].value = 
						document.all['curComplectOldRowClassName'].value; 
		}
	}
}

function editBaseStationConf(id) {
	openDialog("EditBaseStationConf.do?action=<%=EditForm.ACTION_EDIT%>&id="+id+
		"&isLoadFromDB="+<%=ShowConfBaseStationForm.TRUE_STR%>, 
				"editConfPowerForm", "top=160, left=220, width=784, height=550, scrollbars=auto, resizable=yes");
}

function deleteBaseStationConf(id) {
	openDialog("EditBaseStationConf.do?action=<%=EditForm.ACTION_DELETE%>&id="+id+
		"&isLoadFromDB="+<%=ShowConfBaseStationForm.TRUE_STR%>,
				"editConfPowerForm", "top=160, left=220, width=784, height=550, scrollbars=auto, resizable=yes");
}

// начальные установки
onClickRow(document.all['curComplectSelectedID'].value, true);

</script>

</BODY>

</HTML>
