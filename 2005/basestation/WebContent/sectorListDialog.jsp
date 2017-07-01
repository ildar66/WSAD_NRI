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
		return (" <img src='/images/up.gif'  border='0' alt='по возрастанию'> ");
	 else
		return (" <img src='/images/down.gif'  border='0' alt='по убыванию'> "); 
 }
 else return ("");      
}
%>
<%	
	String gColSpan = "5" ;
	SectorListDialogForm aForm = (SectorListDialogForm)request.getAttribute("SectorListDialogForm");
	String sortBy = aForm.getSectorSortBy();
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>
<july:editform action="/SectorListDialog.do" styleId="SectorListDialog">
<!-- hidden fields -->
<html:hidden property="equipment"/>
<html:hidden property="sectorSortBy"/>
<html:hidden property="selectedIDsectorsID" value="0"/>

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
	//считываем selectedID:
	var startLoc = cookies.indexOf("listPosID"+tabid+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
	document.all['selectedID'+tabid].value = cookies.substring(sepLoc+1, endLoc);
	//подчеркиваем строку в таблице:
	if( document.all[tabid].rows(document.all['selectedID'+tabid].value) != null ) {
 		document.all[tabid].rows(document.all['selectedID'+tabid].value,0).className="selectedrow";
	}
}
function SortBy(e, field) 
{
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	SectorListDialog.submit();
	return false;
}
</script>
<!-- Стили -->
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
	<!-- List Sectors BS table -->
		<table width="100%" cellspacing="0" border="0">
			<tr>
					<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:bold;padding:4px;">
							Сектора БС:
					</td>
			</tr>
			<tr>
				<td valign="top">
					<!-- Сектора БС: -->
					<table id="sectorsID" width="100%" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;">
						<tr bgcolor="#CCCCCC">
							<th>
								<A href='SectorDialog.do?action=Add&equipment=<bean:write name="SectorListDialogForm" property="equipment" filter="true"/>' onclick='window.open(this.href, "sectorDialog", "top=200, left=200, width=650, height=600, scrollbars=yes, resizable=yes").focus(); return false;'>
									<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить сектор'>
								</A>
							</th>

							<th><a title="Сортровать по полю 'num_sect'" href="javascript:SortBy(document.all.sectorSortBy,'num_sect')">
							CellID</a><%=isUp(sortBy, "num_sect")%></th>

							<th><a title="Сортровать по полю 'lac'" href="javascript:SortBy(document.all.sectorSortBy, 'lac')">
							LAC</a><%=isUp(sortBy, "lac")%></th>

							<th><a title="Сортровать по полю 'cellname'" href="javascript:SortBy(document.all.sectorSortBy, 'cellname')">
							CellName</a><%=isUp(sortBy, "cellname")%></th>

							<th><a title="Сортровать по полю 'name_sect'" href="javascript:SortBy(document.all.sectorSortBy,'name_sect')">
							Наименование</a><%=isUp(sortBy, "name_sect")%></th>

							<th><a title="Сортровать по полю 'band'" href="javascript:SortBy(document.all.sectorSortBy,'band')">
							Диапазон</a><%=isUp(sortBy, "band")%></th>

							<th><a title="Сортровать по полю 'trxstring'" href="javascript:SortBy(document.all.sectorSortBy,'trxstring')">
							Кол. трансиверов</a><%=isUp(sortBy, "trxstring")%></th>

							<th><a title="Сортровать по полю 'bts_number'" href="javascript:SortBy(document.all.sectorSortBy,'bts_number')">
							Номер BTS</a><%=isUp(sortBy, "bts_number")%></th>

							<th>&nbsp;</th>
						</tr>
						<logic:iterate id="it" name="SectorListDialogForm" property="sectorList" type="com.hps.july.basestation.valueobject.Sector_TO">
							<logic:present name="it">
								<tr id='<bean:write name="it" property="vo.id_sect" filter="true"/>' class="normalrow" style="font-size:8pt;" onMouseOver="onMouseOverRow('sectorsID', this.id);" onMouseOut="onMouseOutRow('sectorsID', this.id);"  onclick='onClickRow("sectorsID", this.id);'>
									<td align="middle">
										<A href='SectorDialog.do?action=Edit&id_sect=<bean:write name="it" property="vo.id_sect" filter="true"/>' onclick='window.open(this.href, "sectorDialog", "top=200, left=200, width=650, height=600, scrollbars=yes, resizable=yes").focus(); return false;'>
											<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить сектор'>
										</A>
									</td>
									<td align="middle"><bean:write name="it" property="vo.num_sect" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="vo.lac" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="vo.cellname" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="vo.name_sect" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="vo.band" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="trxstring" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="vo.bts_number" filter="true"/></td>
									<td align="middle">
										<A href='SectorDialog.do?action=Delete&id_sect=<bean:write name="it" property="vo.id_sect" filter="true"/>' onclick='window.open(this.href, "sectorDialog", "top=200, left=200, width=650, height=600, scrollbars=yes, resizable=yes").focus(); return false;'>
											<IMG SRC="/images/del.gif" BORDER='0' ALT='Удалить сектор'>
										</A>
									</td>
								<tr>
							</logic:present>
						</logic:iterate>
					</table>
					<!-- end Оборудование(БС, репитеры, контроллеры) -->
				</td>
			</tr>
		</table>
		<!-- end List EquipDetList table -->
	</td>
</tr>
</table>

<!-- Подчеркивание строк таблиц -->
<script language="javascript">
	loadSelectedRow('sectorsID');
</script>

</july:editform>