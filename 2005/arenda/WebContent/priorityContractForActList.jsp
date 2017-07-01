<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>
<%@ page import = "com.hps.july.arenda.valueobject.*"%>

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
	String gColSpan = "8";
	PriorityContractForActListForm listForm = (PriorityContractForActListForm)session.getAttribute("PriorityContractForActListForm");
	//System.out.println("list size=" + listForm.getAktList().size());//temp
	String sortBy = listForm.getSortBy();
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>
<july:editform action="/PriorityContractForActList.do" styleId="listForm">
<html:hidden property="leaseDocument"/>
<html:hidden property="sortBy"/>
<html:hidden property="selectedID" value="0"/>
<html:hidden property="operation" value=""/>

<script language="javascript">
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
function onMouseOutRow(selectedID){
	if(document.all.selectedID.value==selectedID) {
		document.all.tableID.rows(selectedID,0).className="selected";
	}
	else {
		document.all.tableID.rows(selectedID,0).className="normal";
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
function changePriority(priority){
	//alert(priority);
}
function SavePriority(){
	listForm.operation.value="savePriority";
	listForm.submit();
}
</script>
<table class="main" id="tableID">
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<july:closebutton page="/"/>&nbsp;
			<input type="hidden" name="numberAkt" value="<%= request.getParameter("numberAkt")%>">			
			<july:currmark>Приоритеты списания задолженности с договора по акту № <%= request.getParameter("numberAkt")%></july:currmark>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>

    <!-- Table header -->
    <tr class="title">
    	<TD class="title"><%=isUp(sortBy, "5 desc,2")%> </TD>
		<TD class="title">
			Номер договора
		</TD>
		<TD class="title">
			Дата договора
		</TD>
 		<%--TD class="title">
			<A title="Сортировать по полю 'Приоритет'" href="javascript:SortBy('5,2')"><b>Приоритет</b></A>
 		</TD--%>
 		<TD class="title">Приоритет</TD>
    </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
    <logic:iterate id="it" name="PriorityContractForActListForm" property = "list" type="LeasePriorCntForAct_TO">
        <logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'" style="font-size:8pt;">
				<TD class="text">&nbsp;</TD>
                <td class="text">
                     <bean:write name="it" property="docNumber" filter="true"/>
                </td>
                <td class="text">
					<july:datewrite name="it" property="docDate"/>
                </td>
                <%--td class="text">
                    <bean:write name="it" property="vo.priority" filter="true"/>
                </td--%>
                <td class="text">
                	<input type="hidden" name="actState" value="<%= request.getParameter("actState")%>">
                	<%if("O".equals(request.getParameter("actState"))){%>
	        			<html:select name ="it" property="vo.priority" styleId="priority" onchange='changePriority(this.value);'>
	        				<html:option value="">&nbsp;</html:option>
	        				<html:option value="0">0</html:option>
							<html:option value="1">1</html:option>
							<html:option value="2">2</html:option>
							<html:option value="3">3</html:option>
							<html:option value="4">4</html:option>
							<html:option value="5">5</html:option>
							<%--html:option value="999999">999999</html:option--%>
						</html:select>
					<%}else{%>
						<bean:write name="it" property="vo.priority" filter="true"/>
					<%}%>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />
	      </logic:present>
      </logic:iterate>

	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
		<july:closebutton page="/"/>
		<%if("O".equals(request.getParameter("actState"))){%>
			<A title="Сохранить" href="javascript:SavePriority()"><IMG SRC="/images/save.gif" BORDER='0' ALT='Сохранить'></A>		
		<%}%>&nbsp;прим: приоритеты назначаются в порядке возрастания
		</td>
	</tr>
      
</table>

<script language="javascript">
	//loadSelectedRow();
	//window.location.hash=document.all.selectedID.value;
</script>

</july:editform>
