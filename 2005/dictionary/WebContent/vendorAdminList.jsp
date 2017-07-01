<%@ page language = "java" %>
<%@ page import = "com.hps.july.util.*"%>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.dictionary.formbean.*,com.hps.july.valueobject.*"%>

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
	java.lang.String gColSpan = "7"; 
	VendorAdminListForm listForm = (VendorAdminListForm)session.getAttribute("VendorAdminListForm");
	String sortBy = listForm.getSortBy();
	boolean isEdit = request.isUserInRole("administrator") || request.isUserInRole("developer") || request.isUserInRole("ArendaMainEconomist") || request.isUserInRole("ArendaEconomist");
%>

<july:browseform action="/VendorAdminList.do" styleId="listForm">
<html:hidden property="sortBy"/>
<html:hidden property="selectedID" value="0"/>
<script language="javascript">
function switchFilter() {
	if(listForm.filter.value == 0 || listForm.filter.value == 8) {
		listForm.searchString.disabled = true;
		listForm.searchString.className = 'editdisabled';
	} else {
		listForm.searchString.disabled = false;
		listForm.searchString.className = 'editsearch';
		listForm.searchString.focus();
	}
}
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
function onMouseOutRow(selectedID, clName){
	if(document.all.selectedID.value==selectedID) {
		document.all.tableID.rows(selectedID,0).className="selected";
	}
	else {
		document.all.tableID.rows(selectedID,0).className=clName;
	}
}
function onClickRow(selectedID) {
	if(document.all.tableID.rows(document.all.selectedID.value) != null){
		document.all.tableID.rows(document.all.selectedID.value,0).className="normal";
	}
	document.all.selectedID.value=selectedID;
	document.all.tableID.rows(selectedID,0).className="selected";
	storeSelectedRow(selectedID);
}
function storeSelectedRow(selectedID) {
	document.cookie = listForm.name+"=" + selectedID;
}
function loadSelectedRow() {
	var cookies = document.cookie;
//	считываем selectedID:
	var startLoc = cookies.indexOf(listForm.name+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
    document.all.selectedID.value = cookies.substring(sepLoc+1, endLoc);
//	подчеркиваем строку в таблице:
	if( document.all.tableID.rows(document.all.selectedID.value) != null ) {
 		document.all.tableID.rows(document.all.selectedID.value,0).className="selected";
	}
}
function toggleLetter(letter){
	document.body.style.cursor="wait";
	listForm.searchString.disabled = false;
	listForm.searchString.className = 'editsearch';
	listForm.filter.value = 1;
	listForm.searchString.value=letter+'*';
	listForm.submit();
}
function switchUseInNri(){
    document.body.style.cursor="wait";
	if(document.all.isUseInNri[0].checked){
		document.all.isUseInNri[0].checked = false;
	}else{
		document.all.isUseInNri[0].checked = true;
	}
	listForm.submit();
}
function switchRecordStatus(){
    document.body.style.cursor="wait";
	if(document.all.isRecordStatus[0].checked){
		document.all.isRecordStatus[0].checked = false;
	}else{
		document.all.isRecordStatus[0].checked = true;
	}
	listForm.submit();
}
</script>

<table class="main"   id="tableID">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD COLSPAN="<%= gColSpan %>">
 
   <table class="find" style="font-size:9pt;">
    <TR>
        <td class="title">поиск по:</td>
        <td class="title">
			<july:select style="font-size: 9pt;" styleClass="seach" onchange="switchFilter()" property="filter" insertable="true" updatable="true">
				<%--html:option value="0">все</html:option--%>
				<html:option value="1">наименование поставщика</html:option>
				<html:option value="2">ИНН поставщика</html:option>
				<html:option value="3">коду поставщика</html:option>
				<html:option value="4">наименование отделения</html:option>
		   	</july:select>
		</td>
		<td class="text" nowrap>
			<july:string style="font-size: 9pt;" property="searchString" styleId="searchString" styleClass="search" size="20" insertable="true" updatable="true"/>
		</td>
		<td class="text" nowrap>
			<july:searchbutton/>
		    Тип: <july:select style="width: 170; font-size: 9pt;" property="typeVendor" insertable="true" updatable="true" styleId="typeVendor" styleClass="seach">
				<html:option value="-1">все</html:option>
				<html:option value="<%=String.valueOf(Vendor_VO.TYPE_VENDOR_JURIDICAL)%>">юридические</html:option>
				<html:option value="<%=String.valueOf(Vendor_VO.TYPE_VENDOR_PHYSICAL)%>">физические</html:option>
				<html:option value="<%=String.valueOf(Vendor_VO.TYPE_VENDOR_OTHER)%>">прочие</html:option>
		   	</july:select>			
		</td>		   	        
    </TR>
	<TR>
		<td class="title">&nbsp;</td>
        <td class="title" nowrap><july:checkbox property="isUseInNri" insertable="true" updatable="true" />&nbsp;<A href="javascript:switchUseInNri()">только c признаком NRI</A></td>
        <td class="title" nowrap><july:checkbox property="isRecordStatus" insertable="true" updatable="true" />&nbsp;<A href="javascript:switchRecordStatus()">только активные</A></td>
		<td class="title" nowrap>
		<%
			String[] a = { "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Э", "Ю", "Я" };
			for (int i = 0; i < a.length; i++) {%>
				<A href="javascript:toggleLetter('<%= a[i]%>')"><%= a[i]%></A>
				<%if(a[i].equals("Н")){%><BR><%}%>
		<%}%>
		</td>
 	</TR>            
   </table>
    
  </TD>
</TR>

    <july:separator colspan="<%= gColSpan %>" />
      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
<% if(isEdit) { %>              
				<A href='VendorAdminDialog.do?action=Add' onclick='return openDialog(this.href, "VendorAdminDialog", "top=300, left=300, width=600, height=350, scrollbars=yes, resizable=yes");'>
					<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>              	
<% } %>					
              	<july:backbutton/>
              </TD>
			  <TD align="right">	отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
    <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
        <TD class="title">&nbsp;</TD>
		<TD class="title">
			<A title="Сортировать по полю 'typeVendor'" href="javascript:SortBy('typeVendor')">Тип</A>
			<%=isUp(sortBy, "typeVendor")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'vendorcode'" href="javascript:SortBy('vendorcode')">Код поставщика</A>
			<%=isUp(sortBy, "vendorcode")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'name'" href="javascript:SortBy('name')">Наименование</A>
			<%=isUp(sortBy, "name")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'inn'" href="javascript:SortBy('inn')">ИНН поставщика</A>
			<%=isUp(sortBy, "inn")%>
		</TD>
		<TD class="title">&nbsp;</TD>
<% if(isEdit) { %>
        <TD class="title">&nbsp;</TD>
<% } %>
    </tr>
    
    <july:separator colspan="<%= gColSpan %>" />

        <!-- Table body -->
    <logic:iterate id="org" name="browseList">
        <logic:present name="org">
		<%
		    com.hps.july.valueobject.Vendor_VO vendorVO = (com.hps.july.valueobject.Vendor_VO)org;
			boolean idDelete = vendorVO.getRecordStatus().equals("D");
			boolean noUseNri = vendorVO.getUseInNri().equals("N");
			//String editAction = (isEdit && (vendorVO.getSource().intValue() == 2))?"Edit":"View";
			String editAction = (isEdit)?"Edit":"View";
		%> 	
		<%if( idDelete || noUseNri ) {%>       
        	<tr class="gray"  id='<bean:write name="org" property="idVendor" filter="true"/>' onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id, 'gray');" style="font-size:8pt;">
        <%}else{%>
            <tr class="normal"  id='<bean:write name="org" property="idVendor" filter="true"/>' onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id, 'normal');" onclick='onClickRow(this.id);' style="font-size:8pt;">        
        <%}%>
                <td class="text">
	                <%if(!(idDelete || noUseNri)){%>
						<A href='VendorAdminDialog.do?action=<%=editAction%>&id=<bean:write name="org" property="idVendor" filter="true"/>' onclick='return openDialog(this.href, "VendorAdminDialog", "top=300, left=300, width=600, height=350, scrollbars=yes, resizable=yes");'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
					<%}else{%>
						<A href='VendorAdminDialog.do?action=View&id=<bean:write name="org" property="idVendor" filter="true"/>' onclick='return openDialog(this.href, "VendorAdminDialog", "top=300, left=300, width=600, height=350, scrollbars=yes, resizable=yes");'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Просмотр запись'></A>					
					<%}%>
				</td>
                <td class="text">
                      <bean:write name="org" property="typeVendorStr" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="org" property="vendorCode" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="org" property="name" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="org" property="inn" filter="true"/>
                </td>
				<td class="link">
                    <A href='VendorSiteAdminList.do?idVendor=<bean:write name="org" property="idVendor" filter="true"/>'>отд.</A>
                </td>                
<% if(isEdit) { %>
				<td class="link">
					<%if( !idDelete && isEdit && (vendorVO.getSource().intValue() == 2) ){%>
                    	<A href='VendorAdminDialog.do?action=Delete&id=<bean:write name="org" property="idVendor" filter="true"/>' onclick='return openDialog(this.href, "VendorAdminDialog", "top=300, left=300, width=600, height=350, scrollbars=yes, resizable=yes");'><IMG SRC="/images/del.gif" BORDER='0' ALT='Удалить запись'></A>
                    <%}%>
                </td>
<% } %>
            </tr>
            
            <july:separator colspan="<%= gColSpan %>" />
            
	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
<% if(isEdit) { %> 
				<A href='VendorAdminDialog.do?action=Add' onclick='return openDialog(this.href, "VendorAdminDialog", "top=300, left=300, width=600, height=350, scrollbars=yes, resizable=yes");'>
					<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>              	
<% } %>					
              	<july:backbutton/>
              </TD>
			  <TD align="right">отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
<july:separator colspan="<%= gColSpan %>" />

</table>

</july:browseform>

<script language="javascript">
	switchFilter();
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>