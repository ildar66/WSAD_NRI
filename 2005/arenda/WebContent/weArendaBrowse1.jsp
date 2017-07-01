<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<html:hidden property="posListSortBy"/>
<%	String gColSpan = "2";
	String form = null;
	String action = null;
	int leaseDoc = -1;
	String className = "select";
	String src = "";
	String mainPositionStr = "-1";
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.WE_ARENDA_EDIT:
			form = "WeArendaForm";
			action = "/arenda/ViewWeArenda.do";
			break;
		case APPStates.HISTORY_FORM:
			form = "HistoryForm";
			action = "/arenda/ViewHistory.do";
			break;
	} %>


	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>"  style="font-size:8pt;">
			<%--july:link page="<%= action %>" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument"--%>
				Позиции БС 
			<%--/july:link--%>

<%--july:canedit rolesProperty="editRoles"--%>
<%
	WeArendaForm editForm = (WeArendaForm)session.getAttribute(form);
	String posListSortBy = editForm.getPosListSortBy();
	editForm.setAction("Edit");
	leaseDoc = editForm.getLeaseDocument();
	java.util.List posList = (java.util.List)request.getAttribute("posList");
	int posListSize = posList.size();//кол-во позиций.
	int pageSize = (posListSize > 300)? 20 : 10 ;//кол-во позиций на странице.
	int pages = (posListSize%pageSize == 0) ? (posListSize/pageSize) : (posListSize/pageSize + 1);
	if(editForm.getPosition() != null)
		mainPositionStr = editForm.getPosition().toString();
%>
		<html:hidden property="lookupCode" value=""/>
		<july:lookupbutton action="/../basestation/ShowPositionLookupList.do?planstate=2" styleId="posl"  formname="<%= form %>" fieldNames="lookupCode;dummy1;dummy1" insertable="true" updatable="true" onselect="addPositionFromLookup();"/>&nbsp;
		Всего: <%= posListSize%>.&nbsp;&nbsp; 
		<%if(posListSize > 0){%>
			Страница: <INPUT TYPE="TEXT" NAME="pageNumber" VALUE="" READONLY="readonly" class="editdisabled" style="width: 19pt; font-size: 8pt;">
			<% for(int i = 1; i <= pages; i++){ %>
				<A name="pagePos_<%=i%>" class="button" onmouseover="showPage(<%=i%>);" style="vertical-align: bottom;"><%=i%></A>
			<% } %>
			<A name="pagePos_ALL" class="button" onmouseover="showAllPage();" style="vertical-align: bottom;">все</A>
		<% } %>
<%
	editForm.setAction("View");
%>
	<script language='javascript'>
		//добавление позиций из справочника:
		function addPositionFromLookup(){
			document.body.style.cursor="wait";
			location.href =  '/arenda/ProcessArendaPositionDialog.do?action=Add&returnForm=<%=form%>&leaseDocument=<%= leaseDoc%>&lookupCode=' + document.all.lookupCode.value + "#posListID";
		}
		//отображение страницы позиций:
		function showPage(page) {
			var pageSize = <%= pageSize%>;
			for(var i = 0; i < rowIDs.length; i++){
				if(i >= (page-1)*pageSize && i < page*pageSize){
					rowIDs[i].style.setAttribute("display", "block");			 
			 	}else{
					rowIDs[i].style.setAttribute("display", "none");
				}
			}
			<%=form%>.pageNumber.value = page;
		}
		//отображение всех страниц позиций:
		function showAllPage() {
			for(var i = 0; i < rowIDs.length; i++){
				rowIDs[i].style.setAttribute("display", "block");			 
			}
			<%=form%>.pageNumber.value = "все";
		}		
		//сортировка позиций:
		function SortBy(field) {
			var e = document.all.posListSortBy;
			e.value = (e.value == field)?field + ' desc':field;
		    document.body.style.cursor="wait";
			location.href = '<%=action%>' + "?posListSortBy=" + e.value + "#posListID";
			return false;
		}		
	</script>
	<%!
	private String isUp(String aSort, String name) {
		 if(aSort != null && aSort.startsWith(name)) {
			 if(aSort.endsWith("desc")) 
				return (" <img src='/images/up.gif'  border='0' alt='по возрастанию'> ");
			 else
				return (" <img src='/images/down.gif'  border='0' alt='по убыванию'> "); 
		 }
		 else return ("");      
	}
	%>	
<%--/july:canedit--%>

<logic:present name="posList">
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr><td colspan="<%= gColSpan %>">
	<table class="main" id="posListID" style="font-size:8pt;">
		<!-- Table header -->
		<tr class="title" style="background-color: 'D6EBFF'">
			<td class="title">&nbsp;</td>
			<%--july:headercolumn key="label.table.posname" colType="string"/>
			<july:headercolumn key="label.table.numberdamps" colType="number"/>
			<july:headercolumn key="label.table.numbergsm" colType="number"/>
			<july:headercolumn key="label.table.address" colType="string"/>
			<july:headercolumn key="label.table.mainmanager" colType="string"/--%>
			<td class="title">
				<A title="Сортировать по полю 'name'" href="javascript:SortBy('name')">Наименование позиции <%=isUp(posListSortBy, "name")%></A>
			</td>
			<td class="title">
				<A title="Сортировать по полю 'dampsid'" href="javascript:SortBy('dampsid')">Номер DAMPS <%=isUp(posListSortBy, "dampsid")%></A>
			</td>
			<td class="title">
				<A title="Сортировать по полю 'gsmid'" href="javascript:SortBy('gsmid')">Номер GSM <%=isUp(posListSortBy, "gsmid")%></A>
			</td>
			<td class="title">
				<A title="Сортировать по полю 'address'" href="javascript:SortBy('address')">Адрес <%=isUp(posListSortBy, "address")%></A>
			</td>
			<td class="title">
				<A title="Сортировать по полю 'nameOtvPos'" href="javascript:SortBy('nameOtvPos')">Ответственный менеджер <%=isUp(posListSortBy, "nameOtvPos")%></A>
			</td>															
			
			<td class="title">
				<july:canedit rolesProperty="editRoles">
					<A href='ProcessArendaPositionDialog.do?action=Delete&returnForm=<%=form%>&leaseDocument=<%=leaseDoc%>#posListID' onclick='if(confirm("удалить все Позиции БС из договора?" )) {document.body.style.cursor="wait"; return true;} else {return false;}'>
						<IMG SRC="/images/iskl.gif" BORDER='0' ALT='Исключить все позиции БС' width="14"></A>
				</july:canedit>			
			</td>
		</tr>


		<july:separator colspan="7"/>


		<!-- Table body -->
		<logic:iterate id="pos" name="posList">
			<logic:present name="pos">
			<logic:equal name="pos" property="vo.storageplace" value='<%=mainPositionStr%>'>
				<%className = "expired"; src = "/images/check_on.gif";%>
			</logic:equal>
			<logic:notEqual name="pos" property="vo.storageplace" value='<%=mainPositionStr%>'>
				<%className = "normal"; src="/images/check_off.gif";%>
			</logic:notEqual>
				<tr class="<%=className%>" onMouseOver="className='select'" onMouseOut="className='<%=className%>'" id="rowIDs">
					<td class="title">
						<july:canedit rolesProperty="editRoles">
							<A href='ProcessArendaPositionDialog.do?action=Edit&returnForm=<%=form%>&leaseDocument=<%=leaseDoc%>&lookupCode=<bean:write name="pos" property="vo.storageplace"/>#posListID'>
								<IMG SRC="<%=src%>" BORDER='0' ALT='<bean:message key="label.positionMain"/>'></A>
						</july:canedit>
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
							<A href='ProcessArendaPositionDialog.do?action=Delete&returnForm=<%=form%>&leaseDocument=<%=leaseDoc%>&lookupCode=<bean:write name="pos" property="vo.storageplace"/>#posListID' onclick='if(confirm("удалить Позицию <bean:write name="pos" property="vo.name"/> из договора?" )) {document.body.style.cursor="wait"; return true;} else {return false;}'>
								<IMG SRC="/images/iskl.gif" BORDER='0' ALT='Исключить позицию БС'></A>
						</july:canedit>
					</td>
					<%--july:separator colspan="7"/--%>
				</tr>
			</logic:present>
		</logic:iterate>


	</table>
	</td></tr>
<%if(posListSize > 0){%>
<script language='javascript'>
	showPage(1);
</script>
<%}%>	
</logic:present>
<logic:notPresent name="posList">
		&nbsp;-&nbsp;<bean:message key="label.nodata"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
</logic:notPresent>

