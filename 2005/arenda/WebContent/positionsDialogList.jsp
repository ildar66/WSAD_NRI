<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
<script language="javascript">
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
function addPositionFromLookup(leaseDoc){
	location.href =  '/arenda/ProcessArendaPositionDialog.do?action=Add&returnForm=PositionsDialogListForm&leaseDocument=' + leaseDoc + '&lookupCode=' + document.all.lookupCode.value;
}
</script>
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
	String form = "PositionsDialogListForm";
	String className = "select";
	String src = "";
	PositionsDialogListForm listForm = (PositionsDialogListForm)session.getAttribute(form);
	String sortBy = listForm.getSortBy();
%>
<%--script language='javascript'>
	function addPositionFromLookup(){
		location.href =  '/arenda/ProcessArendaPositionDialog.do?action=Add&returnForm=<%=form%>&leaseDocument=<%= leaseDoc%>&lookupCode=' + document.all.lookupCode.value;
	}
</script--%>
<july:browseform action="/PositionsDialogList.do" styleId="listForm">
<html:hidden property="sortBy"/>
<html:hidden property="lookupCode" value=""/>

	<table class="main"  style="font-size:8pt;">
    	<july:separator colspan="<%= gColSpan %>" />
	  	<tr class="title">
	      <td colspan="<%= gColSpan %>">
		      <TABLE class="buttons">
		        <TR class="title">
		          <TD><B style="font-size: 10pt; color: red">все Позиции по договору:</B></TD>              
				  <TD align="center">отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
		          <TD class="navigator" nowrap="nowrap"><july:navigator/></TD>
		        </TR>
		       </TABLE>
	       </TD>
	  	</tr>
    	<july:separator colspan="<%= gColSpan %>" />	
		<!-- Table header -->
		<tr class="title" style="background-color: 'D6EBFF'">
			<td class="title">&nbsp;</td>
			<td class="title">
				<A title="Сортировать по полю 'docNumber'" href="javascript:SortBy('docNumber')">№ <%=isUp(sortBy, "docNumber")%><br>доп.согл.</A>
			</td>
			<td class="title">
				<A title="Сортировать по полю 'name'" href="javascript:SortBy('name')">Наименование позиции <%=isUp(sortBy, "name")%></A>
			</td>
			<td class="title">
				<A title="Сортировать по полю 'dampsid'" href="javascript:SortBy('dampsid')">Номер DAMPS <%=isUp(sortBy, "dampsid")%></A>
			</td>
			<td class="title">
				<A title="Сортировать по полю 'gsmid'" href="javascript:SortBy('gsmid')">Номер GSM <%=isUp(sortBy, "gsmid")%></A>
			</td>
			<td class="title">
				<A title="Сортировать по полю 'address'" href="javascript:SortBy('address')">Адрес <%=isUp(sortBy, "address")%></A>
			</td>
			<td class="title">
				<A title="Сортировать по полю 'nameOtvPos'" href="javascript:SortBy('nameOtvPos')">Ответственный менеджер <%=isUp(sortBy, "nameOtvPos")%></A>
			</td>															
			<td class="title">&nbsp;</td>
		</tr>

		<july:separator colspan="<%= gColSpan %>"/>

		<!-- Table body -->
		<logic:iterate id="pos" name="browseList" indexId="indexId">
			<logic:present name="pos">
		<%
		    com.hps.july.arenda.valueobject.Position_TO to = (com.hps.july.arenda.valueobject.Position_TO)pos;
			//boolean idDelete = vendorVO.getRecordStatus().equals("D");
			//boolean noUseNri = vendorVO.getUseInNri().equals("N");
			//String editAction = (isEdit)?"Edit":"View";
			Integer leaseDoc = to.getLeaseDocument();
			Integer mainPosition = to.getMainPosition();
		%>			
			<logic:equal name="pos" property="vo.storageplace" value='<%=String.valueOf(mainPosition)%>'>
				<%className = "expired"; src = "/images/check_on.gif";%>
			</logic:equal>
			<logic:notEqual name="pos" property="vo.storageplace" value='<%=String.valueOf(mainPosition)%>'>
				<%className = "normal"; src="/images/check_off.gif";%>
			</logic:notEqual>
				<tr class="<%=className%>" onMouseOver="className='select'" onMouseOut="className='<%=className%>'">
					<td class="title">
						<july:canedit rolesProperty="editRoles">
							<A href='ProcessArendaPositionDialog.do?action=Edit&returnForm=<%=form%>&leaseDocument=<%=leaseDoc%>&lookupCode=<bean:write name="pos" property="vo.storageplace"/>'>
								<IMG SRC="<%=src%>" BORDER='0' ALT='<bean:message key="label.positionMain"/>'></A>
						</july:canedit>
					</td>
	            	<td class="text" nowrap="nowrap">
						<july:canedit rolesProperty="editRoles">
							<%
								String onSelectStr = "addPositionFromLookup(" + leaseDoc + ");";
								String styleIdStr = "posl_" + indexId;
							 %>
							<july:lookupbutton  action="/../basestation/ShowPositionLookupList.do?planstate=2" styleId="<%= styleIdStr%>"  formname="<%= form %>" fieldNames="lookupCode;dummy1;dummy1" insertable="true" updatable="true" onselect="<%= onSelectStr %>"/>
						</july:canedit>
         	        	<bean:write name="pos" property="docNumber" filter="true"/>						        	        	
	                </td>					
	            	<td class="text">
         	        	<bean:write name="pos" property="vo.name" filter="true"/>
	                </td>
    	            <td class="text">
						<%--bean:write name="pos" property="vo.dampsid" filter="true"/--%>
						<bean:write name="pos" property="dampsIDs" filter="true"/>
            	    </td>
                	<td class="text">
						<%--bean:write name="pos" property="vo.gsmid" filter="true"/--%>
						<bean:write name="pos" property="gsmIDs" filter="true"/>
						<logic:present name="pos" property="vo.dcsid">/<bean:write name="pos" property="vo.dcsid" filter="true"/></logic:present>
	                </td>
    	            <td class="text">
        	            <bean:write name="pos" property="vo.address" filter="true"/>
            	    </td>
                	<td class="text">
                    	<bean:write name="pos" property="nameOtvPos" filter="true"/>
	                </td>
					<td class="text">
						<july:canedit rolesProperty="editRoles">
							<A href='ProcessArendaPositionDialog.do?action=Delete&returnForm=<%=form%>&leaseDocument=<%=leaseDoc%>&lookupCode=<bean:write name="pos" property="vo.storageplace"/>' onclick='if(confirm("удалить Позицию <bean:write name="pos" property="vo.name"/> из договора?" )) return true; else return false;'>
								<IMG SRC="/images/iskl.gif" BORDER='0' ALT='Исключить позицию БС'></A>
						</july:canedit>
					</td>
					<july:separator colspan="<%= gColSpan %>"/>
				</tr>
			</logic:present>
		</logic:iterate>
		
	  	<tr class="title">
	      <td colspan="<%= gColSpan %>">
		      <TABLE class="buttons">
		        <TR class="title">
		          <TD><B style="font-size: 10pt; color: red">все Позиции по договору:</B></TD>              
				  <TD align="center">отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
		          <TD class="navigator" nowrap="nowrap"><july:navigator/></TD>
		        </TR>
		       </TABLE>
	       </TD>
	  	</tr>
    	<july:separator colspan="<%= gColSpan %>" />	
	</table>

</july:browseform>
