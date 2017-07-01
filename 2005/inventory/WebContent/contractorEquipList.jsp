<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.inventory.formbean.*"%>

<july:editform action="/ProcessContractorEquipList.do">
<%	
	String gColSpan = "5";
	ContrEquipListForm aForm = (ContrEquipListForm)request.getAttribute("ContrEquipListForm");
	int listcount = aForm.getListCount();
	String equipDetSortBy = aForm.getEquipDetSortBy();
%>



<html:hidden property="equipDetSortBy"/>
<html:hidden property="storageplace"/>
<html:hidden property="selectedIDequipDetID" value="0"/>
<html:hidden property="isContent"/>
<html:hidden property="act"/>

<script language="javascript">
function SortBy(e, field) 
{
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	EquipsdetListDialogForm.submit();
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
	<!-- List EquipDetList table -->
	
		<table width="100%" cellspacing="0" border="0">
			<tr>					
					<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:bold;padding:4px;">
							<input type="image" name="submit" src="/images/save.gif" onclick="document.body.style.cursor='auto'; if (opener != null) {opener.document.all.refreshFields.value=1; opener.document.forms(0).submit(); opener.focus();} window.close();" title="Закрыть">
							&nbsp;
							Оборудование:
					</td>
			</tr>
			<tr>
				<td valign="top">
					<!-- Оборудование(БС, репитеры, контроллеры): -->
					<table id="equipDetID" width="100%" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;">
						<tr bgcolor="#CCCCCC">
							<th>&nbsp;</th>
							<th><a title="Сортровать по полю 'name'" href="javascript:SortBy(document.all.equipDetSortBy,'name')">
							Название</a></th>

							<th><a title="Сортровать по полю 'model'" href="javascript:SortBy(document.all.equipDetSortBy,'model')">
							manucode - model</a></th>

							<th><a title="Сортровать по полю 'serialnumber'" href="javascript:SortBy(document.all.equipDetSortBy,'serialnumber')">
							серийный номер</a></th>

							<th><a title="Сортровать по полю 'qty'" href="javascript:SortBy(document.all.equipDetSortBy, 'qty')">
							количество</a></th>

							<th><a title="Сортровать по полю 'place'" href="javascript:SortBy(document.all.equipDetSortBy, 'place')">
							посадочное место</a></th>

							<th><a title="Сортровать по полю 'comment'" href="javascript:SortBy(document.all.equipDetSortBy,'comment')">
							Комментарий</a></th>
						</tr>
						

						<% for (int i2=0; i2 < listcount; i2++) {
						%>
						
							<tr class="normalrow" style="font-size:8pt;">
								<html:hidden property='<%= "list["+i2+"].type"%>'/>
								<html:hidden property='<%= "list["+i2+"].storagecard"%>'/>
								<td align="middle">
									<july:checkbox property='<%= "list["+i2+"].loaded"%>' insertable="true" updatable="true" value="true" styleClass="text"/>
								</td>
								<td align="middle">
									<bean:write name="ContrEquipListForm" property='<%= "list["+i2+"].categname"%>' filter="true"/>									
								</td>
								<td align="middle">
									<bean:write name="ContrEquipListForm" property='<%= "list["+i2+"].manucode"%>' filter="true"/> - <bean:write name="ContrEquipListForm" property='<%= "list["+i2+"].typename"%>' filter="true"/>									
								</td>
								<td align="middle">
									<bean:write name="ContrEquipListForm" property='<%= "list["+i2+"].sn"%>' filter="true"/>
									<html:hidden property='<%= "list["+i2+"].sn"%>'/>
								</td>
								<td align="middle">
									<bean:write name="ContrEquipListForm" property='<%= "list["+i2+"].qty"%>' filter="true"/>
									<html:hidden property='<%= "list["+i2+"].qty"%>'/>
								</td>
								<td align="middle">
									<bean:write name="ContrEquipListForm" property='<%= "list["+i2+"].place"%>' filter="true"/>
								</td>
								<td align="middle">
									<bean:write name="ContrEquipListForm" property='<%= "list["+i2+"].note"%>' filter="true"/>
									
								</td>
							<tr>


						<%}%>

					</table>
					<!-- end Оборудование(БС, репитеры, контроллеры) -->
				</td>
			</tr>
			<tr>					
					<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:bold;padding:4px;">
							<input type="image" name="submit" src="/images/save.gif" onclick="document.body.style.cursor='auto'; if (opener != null) {opener.document.all.refreshFields.value=1; opener.document.forms(0).submit(); opener.focus();} window.close();" title="Закрыть">
					</td>
			</tr>
		</table>
		<!-- end List EquipDetList table -->
	</td>
</tr>
</table>
</july:editform>