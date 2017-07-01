<!-- ����������:  Go( idVendorSite|vendorSiteCode|name|kpp|address|vendor_VO.inn||||||vendor_VO.vendorCode|vendor_VO.name|idVendorSiteNfs ) -->
<%@ page language = "java" %>
<%@ page import = "com.hps.july.util.*"%>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.dictionary.formbean.*"%>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  

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
	java.lang.String gColSpan = "11"; 
	VendorSiteLookupListForm listForm = (VendorSiteLookupListForm)session.getAttribute("VendorSiteLookupListForm");
	String sortBy = listForm.getSortBy();
	boolean isEdit = request.isUserInRole("administrator") || request.isUserInRole("developer") || request.isUserInRole("ArendaMainEconomist") || request.isUserInRole("ArendaEconomist");
%>

<july:browseform action="/VendorSiteLookupList.do" styleId="listForm">
<html:hidden property="sortBy"/>
<html:hidden property="selectedID" value="0"/>
<html:hidden property="formname"/>
<html:hidden property="fieldnames"/>
<html:hidden property="onMySelect"/>

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
//	��������� selectedID:
	var startLoc = cookies.indexOf(listForm.name+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
    document.all.selectedID.value = cookies.substring(sepLoc+1, endLoc);
//	������������ ������ � �������:
	if( document.all.tableID.rows(document.all.selectedID.value) != null ) {
 		document.all.tableID.rows(document.all.selectedID.value,0).className="selected";
	}
}
function toggleLetter(letter){
	document.body.style.cursor="wait";
	listForm.searchString.disabled = false;
	listForm.searchString.className = 'editsearch';
	if(listForm.filter.value == 0){
		listForm.filter.value = 1;
	}
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
function Go(strval) {
	var thisform = document.forms[0];
	var outform = window.opener.document.forms[thisform.formname.value];
	
	if(outform != null)
	{
		var names = thisform.fieldnames.value.split('|'), values = strval.split('|');
		for(var i in names) {
			if(names[i].length > 0)
				outform[names[i]].value = unescape(values[i]);
		}
	}
	Close();
	onMySelect();
}
function Close()
{
	var thisform = document.forms[0];
	var outform = window.opener.document.forms[thisform.formname.value];
	if(outform != null) {
		document.body.style.cursor="wait";
		window.opener.focus();
	}
	window.close();
}
function onMySelect(){
	if(document.all.onMySelect.value != null && document.all.onMySelect.value != ""){
		opener.execScript(document.all.onMySelect.value);
	}
}
</script>

<table class="main" id="tableID">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD COLSPAN="<%= gColSpan %>">
   <table class="find" style="font-size:9pt;">
<%--    
 	<logic:present name="VendorSiteLookupListForm" property="vendor_VO">   
    <TR>
        <td class="title">
         	<I style="font-size: 8pt;">������������: </I><bean:write name="VendorSiteLookupListForm" property="vendor_VO.name" />
        </td>
        <td class="title">
        	<I style="font-size: 8pt;">���: </I><bean:write name="VendorSiteLookupListForm" property="vendor_VO.inn" />
        </td>
	</TR>
	</logic:present>   
--%>  
    <TR>
        <td class="title">����� ��:</td>
        <td class="title">
			<july:select styleClass="seach" onchange="switchFilter()" property="filter" insertable="true" updatable="true">
				<html:option value="0">���</html:option>
				<html:option value="1">������������ ���������</html:option>
				<html:option value="2">��� ���������</html:option>
				<html:option value="3">������������ ����������</html:option>
				<html:option value="4"><bean:write name="VendorSiteLookupListForm" property="vendorFormView.nameInn"/> ����������</html:option>
				<html:option value="5">���� ����������</html:option>				
		   	</july:select>
		</td>
		<td class="text" nowrap>
			<july:string property="searchString" styleId="searchString" styleClass="search" size="25" insertable="true" updatable="true"/>
		</td>
		<td class="text" nowrap>
			<july:searchbutton/>
		</td>		   	        
    </TR>
	<TR>
		<td class="title">&nbsp;</td>
        <td class="title"><july:checkbox property="isUseInNri" insertable="true" updatable="true" />&nbsp;<A href="javascript:switchUseInNri()">������ c ��������� NRI</A></td>
        <td class="title"><july:checkbox property="isRecordStatus" insertable="true" updatable="true" />&nbsp;<A href="javascript:switchRecordStatus()">������ ��������</A></td>
		<td class="title" nowrap>
		<%
			String[] a = { "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�" };
			for (int i = 0; i < a.length; i++) {%>
				<A href="javascript:toggleLetter('<%= a[i]%>')"><%= a[i]%></A>
				<%if(a[i].equals("�")){%><BR><%}%>
		<%}%>
		</td>
 	</TR>
 	            
   </table>
  
  </TD>
</TR>

    <july:separator colspan="<%= gColSpan %>" />
      <tr class="title">
          <td colspan="<%= gColSpan %>">
          <TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
<% if(isEdit) { %>              
				<A href='VendorSiteDialog.do?action=Add&idVendor=<bean:write name="VendorSiteLookupListForm" property="idVendor" filter="true"/>' onclick='return openDialog(this.href, "VendorSiteDialog", "top=300, left=300, width=600, height=350, scrollbars=yes, resizable=yes");'>
					<IMG SRC="/images/plus.gif" BORDER='0' ALT='�������� ���������'></A>              	
<% } %>					
              	<%--july:backbutton/--%>
              </TD>
              <TD><B style="font-size: 10pt; color: red">���������:</B></TD>
			  <TD align="right">	�������� �������:<%= request.getAttribute("numberOfLines") %></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE>
           </TD>
      </tr>
    <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
        <TD class="title">&nbsp;</TD>
        <TD class="title">&nbsp;</TD>
		<TD class="title">&nbsp;</TD>
		<%--TD class="title">
			<A title="����������� �� ���� 'idVendorSite'" href="javascript:SortBy('idVendorSite')"><bean:message key="label.code"/></A>
			<%=isUp(sortBy, "idVendorSite")%>
		</TD--%>
		<TD class="title">
			<A title="����������� �� ���� 'vendorSiteCode'" href="javascript:SortBy('vendorSiteCode')">��� ���.</A>
			<%=isUp(sortBy, "vendorSiteCode")%>
		</TD>
		<TD class="title">
			<A title="����������� �� ���� 'v.vendorCode'" href="javascript:SortBy('v.vendorCode')">��� ����.</A>
			<%=isUp(sortBy, "v.vendorCode")%>
		</TD>		
		<TD class="title">
			<A title="����������� �� ���� 'v.name'" href="javascript:SortBy('v.name')">���������</A>
			<%=isUp(sortBy, "v.name")%>
		</TD>		
		<TD class="title">
			<A title="����������� �� ���� 'vs.name'" href="javascript:SortBy('vs.name')">���������</A>
			<%=isUp(sortBy, "vs.name")%>
		</TD>
		<TD class="title">
			<A title="����������� �� ���� 'kpp'" href="javascript:SortBy('kpp')">��� ���.</A>
			<%=isUp(sortBy, "kpp")%>
		</TD>
		<TD class="title">
			<A title="����������� �� ���� 'address'" href="javascript:SortBy('address')">�����</A>
			<%=isUp(sortBy, "address")%>
		</TD>
		<TD class="title">
			<A title="����������� �� ���� 'nameOwnerNfs'" href="javascript:SortBy('nameOwnerNfs')">��������</A>
			<%=isUp(sortBy, "nameOwnerNfs")%>
		</TD>				
<% if(isEdit) { %>
        <TD class="title">&nbsp;</TD>
<% } %>
    </tr>
    
    <july:separator colspan="<%= gColSpan %>" />

        <!-- Table body -->
    <logic:iterate id="org" name="browseList">
        <logic:present name="org">
		<%
			com.hps.july.valueobject.VendorSite_TO to = (com.hps.july.valueobject.VendorSite_TO)org;
		    com.hps.july.valueobject.VendorSite_VO siteVO = to.getVo();
			boolean idDelete = siteVO.getRecordStatus().equals("D");
			boolean noUseNri = siteVO.getUseInNri().equals("N");
			//��������:
			boolean isChange = false;
			String siteName = siteVO.getName();
			String vendorName = to.getVendor_VO().getName();
			if(siteName.indexOf('\'') != -1 || vendorName.indexOf('\'') != -1){
				siteName = siteName.replace('\'',' ').replace('\"',' ');
				vendorName = vendorName.replace('\'',' ').replace('\"',' ');
				isChange = true;
			}
			//String editAction = (isEdit && (siteVO.getSource().intValue() == 2))?"Edit":"View";
			String editAction = (isEdit)?"Edit":"View";
		%> 	
		<%if( idDelete || noUseNri ) {%>       
        	<tr class="gray"  id='<bean:write name="org" property="vo.idVendorSite" filter="true"/>' onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id, 'gray');" style="font-size:8pt;">
        <%}else{%>
            <tr class="normal"  id='<bean:write name="org" property="vo.idVendorSite" filter="true"/>' onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id, 'normal');" onclick='onClickRow(this.id);' style="font-size:8pt;">        
        <%}%>
                <td class="text">
	                <%if(!(idDelete || noUseNri)){%>
						<A href='VendorSiteDialog.do?action=<%=editAction%>&id=<bean:write name="org" property="vo.idVendorSite" filter="true"/>' onclick='return openDialog(this.href, "VendorSiteDialog", "top=300, left=300, width=600, height=350, scrollbars=yes, resizable=yes");'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='�������� ���������'></A>
					<%}else{%>
						<A href='VendorSiteDialog.do?action=View&id=<bean:write name="org" property="vo.idVendorSite" filter="true"/>' onclick='return openDialog(this.href, "VendorSiteDialog", "top=300, left=300, width=600, height=350, scrollbars=yes, resizable=yes");'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='�������� ������'></A>
					<%}%>
				</td>
				<td class="text">
                	<%if(!(idDelete || noUseNri)){%>
                		<%if(isChange){%>
                			<A href="javascript:Go('<bean:write name="org" property="vo.idVendorSite" filter="true"/>|<bean:write name="org" property="vo.vendorSiteCode" filter="true"/>|<%=siteName%>|<bean:write name="org" property="vo.kpp" filter="true"/>|<bean:write name="org" property="vo.address" filter="true"/>|<bean:write name="org" property="vendor_VO.inn" filter="true"/>||||||<bean:write name="org" property="vendor_VO.vendorCode" filter="true"/>|<%= vendorName%>|<bean:write name="org" property="vo.idVendorSiteNFS" filter="true"/>')" title="�������� ���������">�������</A>
                		<%}else{%>
                			<A href="javascript:Go('<bean:write name="org" property="vo.idVendorSite" filter="true"/>|<bean:write name="org" property="vo.vendorSiteCode" filter="true"/>|<bean:write name="org" property="vo.name" filter="true"/>|<bean:write name="org" property="vo.kpp" filter="true"/>|<bean:write name="org" property="vo.address" filter="true"/>|<bean:write name="org" property="vendor_VO.inn" filter="true"/>||||||<bean:write name="org" property="vendor_VO.vendorCode" filter="true"/>|<bean:write name="org" property="vendor_VO.name" filter="true"/>|<bean:write name="org" property="vo.idVendorSiteNFS" filter="true"/>')" title="�������� ���������">�������</A>
                		<%}%>
                    <%}else{%>
                    		&nbsp;
                    <%}%>				
				</td>
				<td class="link">
                    <A href='AccountsLookupList.do?idVendorSite=<bean:write name="org" property="vo.idVendorSite" filter="true"/>' onclick="return openDialog(this.href, 'AccountsLookupList', 'top=250, left=300, width=600, height=300, scrollbars=yes, resizable=yes');">�.�����</A>
                </td>								
                <%--td class="number">
                      <bean:write name="org" property="vo.idVendorSite" filter="true"/>
                </td--%>
                <td class="text">
                    <bean:write name="org" property="vo.vendorSiteCode" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="org" property="vendor_VO.vendorCode" filter="true"/>
                </td>
                
                <td class="text">
                    <bean:write name="org" property="vendor_VO.name" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="org" property="vo.name" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="org" property="vo.kpp" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="org" property="vo.address" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="org" property="ownerName" filter="true"/>
                </td>
                                               
<% if(isEdit) { %>
				<td class="link">
					<%if( !idDelete && isEdit && (siteVO.getSource().intValue() == 2) ){%>
                    	<A href='VendorSiteDialog.do?action=Delete&id=<bean:write name="org" property="vo.idVendorSite" filter="true"/>' onclick='return openDialog(this.href, "VendorSiteDialog", "top=300, left=300, width=600, height=350, scrollbars=yes, resizable=yes");'><IMG SRC="/images/del.gif" BORDER='0' ALT='������� ���������'></A>
                    <%}%>
                </td>
<% } %>
            </tr>
            
            <july:separator colspan="<%= gColSpan %>" />
            
	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>">
          <TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
<% if(isEdit) { %>              
				<A href='VendorSiteDialog.do?action=Add&idVendor=<bean:write name="VendorSiteLookupListForm" property="idVendor" filter="true"/>' onclick='return openDialog(this.href, "VendorSiteDialog", "top=300, left=300, width=600, height=350, scrollbars=yes, resizable=yes");'>
					<IMG SRC="/images/plus.gif" BORDER='0' ALT='�������� ���������'></A>              	
<% } %>				
              	<%--july:backbutton/--%>
              </TD>
			  <TD align="right">�������� �������:<%= request.getAttribute("numberOfLines") %></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
           </TABLE>
           </TD>
      </tr>
      
<july:separator colspan="<%= gColSpan %>" />

</table>

</july:browseform>

<script language="javascript">
	//switchFilter();
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>