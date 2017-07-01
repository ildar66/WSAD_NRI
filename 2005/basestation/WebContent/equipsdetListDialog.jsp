<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.basestation.formbean.*"%>
<%!
private String isUp(String aSort, String name) {
 if(aSort.startsWith(name)) {
	 if(aSort.endsWith("desc")) 
		return (" <img src='/images/up.gif'  border='0' alt='�� �����������'> ");
	 else
		return (" <img src='/images/down.gif'  border='0' alt='�� ��������'> "); 
 }
 else return ("");      
}
%>
<%	
	String gColSpan = "5";
	EquipsdetListDialogForm aForm = (EquipsdetListDialogForm)request.getAttribute("EquipsdetListDialogForm");
	String equipDetSortBy = aForm.getEquipDetSortBy();
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>
<july:editform action="/EquipsdetListDialog.do" styleId="EquipsdetListDialogForm">
<!-- hidden fields -->
<html:hidden property="equipment"/>
<html:hidden property="equipDetSortBy"/>
<html:hidden property="selectedIDequipDetID" value="0"/>
<html:hidden property="isContent"/>

<script language="javascript">
function onMouseOutRow(tabid,selectedID){
	if(document.all['selectedID'+tabid].value==selectedID) {
		document.all[tabid].rows(selectedID,0).className="selectedrow";
	}
	else {
		document.all[tabid].rows(selectedID,0).className="normalrow";
	}
}
function onMouseOverRow(tabid,selectedID){
	document.all[tabid].rows(selectedID,0).className="selectrow";
}
function onClickRow(tabid,selectedID) {
	if(document.all[tabid].rows(document.all['selectedID'+tabid].value) != null){
		document.all[tabid].rows(document.all['selectedID'+tabid].value,0).className="normalrow";
	}
	document.all['selectedID'+tabid].value=selectedID;
	document.all[tabid].rows(selectedID,0).className="selectedrow";
	storeSelectedRow(tabid,selectedID);
}
function storeSelectedRow(tabid,selectedID) {
	document.cookie = "listPosID"+tabid+"=" + selectedID;
}
function loadSelectedRow(tabid) {
	var cookies = document.cookie;
	//��������� selectedID:
	var startLoc = cookies.indexOf("listPosID"+tabid+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
	document.all['selectedID'+tabid].value = cookies.substring(sepLoc+1, endLoc);
	//������������ ������ � �������:
	if( document.all[tabid].rows(document.all['selectedID'+tabid].value) != null ) {
 		document.all[tabid].rows(document.all['selectedID'+tabid].value,0).className="selectedrow";
	}
}
function SortBy(e, field) 
{
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	EquipsdetListDialogForm.submit();
	return false;
}
</script>
<!-- ����� -->
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

<table class="main">
<tr class="normal">
	<td colspan="<%= gColSpan %>" bgcolor="#8899FF" style="padding-left:4px;padding-right:4px;">
	<!-- List EquipDetList table -->
		<table width="100%" cellspacing="0" border="0">
			<tr>
					<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:bold;padding:4px;">
							������������:
					</td>
			</tr>
			<tr>
				<td valign="top">
					<!-- ������������(��, ��������, �����������): -->
					<table id="equipDetID" width="100%" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;">
						<tr bgcolor="#CCCCCC">
							<th>&nbsp;</th>

							<th><a title="���������� �� ���� 'name'" href="javascript:SortBy(document.all.equipDetSortBy,'name')">
							��������</a><%=isUp(equipDetSortBy, "name")%></th>

							<th><a title="���������� �� ���� 'model'" href="javascript:SortBy(document.all.equipDetSortBy,'model')">
							manucode - model</a><%=isUp(equipDetSortBy, "model")%></th>

							<th><a title="���������� �� ���� 'serialnumber'" href="javascript:SortBy(document.all.equipDetSortBy,'serialnumber')">
							��������� �����</a><%=isUp(equipDetSortBy, "serialnumber")%></th>

							<th><a title="���������� �� ���� 'qty'" href="javascript:SortBy(document.all.equipDetSortBy, 'qty')">
							����������</a><%=isUp(equipDetSortBy, "qty")%></th>

							<th><a title="���������� �� ���� 'place'" href="javascript:SortBy(document.all.equipDetSortBy, 'place')">
							���������� �����</a><%=isUp(equipDetSortBy, "place")%></th>

							<th><a title="���������� �� ���� 'comment'" href="javascript:SortBy(document.all.equipDetSortBy,'comment')">
							�����������</a><%=isUp(equipDetSortBy, "comment")%></th>
						</tr>
						<logic:iterate id="it" name="EquipsdetListDialogForm" property="equipDetList" type="com.hps.july.basestation.valueobject.Equipdet_TO ">
							<logic:present name="it">
								<tr id='<bean:write name="it" property="scard.storagecard" filter="true"/>' class="normalrow" style="font-size:8pt;" onMouseOver="onMouseOverRow('equipDetID',this.id);" onMouseOut="onMouseOutRow('equipDetID',this.id);"  onclick='onClickRow("equipDetID",this.id);'>
									<td align="middle">
										<logic:present name="it" property="isAgregate">
											<logic:equal name="it" property="isAgregate" value="Y">
												<A href='EquipsdetListDialog.do?action=&equipment=<bean:write name="it" property="scard.storagecard" filter="true"/>&isContent=true' onclick='window.open(this.href, "equipsdetListDialogContent", "top=150, left=150, width=650, height=600, scrollbars=yes, resizable=yes").focus(); return false;'>
													<IMG SRC="/images/details.gif" BORDER='0' ALT='������ ������������'>
												</A>
											</logic:equal>											
										</logic:present>
									</td>
									<td align="middle"><bean:write name="it" property="name" filter="true"/></td>
									<td align="middle">
										<bean:write name="it" property="manucode" filter="true"/> - <bean:write name="it" property="model" filter="true"/>
									</td>
									<td align="middle"><bean:write name="it" property="scard.serialnumber" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="scard.qty" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="scard.place" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="scard.comment" filter="true"/></td>
								<tr>
							</logic:present>
						</logic:iterate>
					</table>
					<!-- end ������������(��, ��������, �����������) -->
				</td>
			</tr>
		</table>
		<!-- end List EquipDetList table -->
	</td>
</tr>
</table>

<!-- ������������� ����� ������ -->
<script language="javascript">
	loadSelectedRow('equipDetID');
</script>

</july:editform>