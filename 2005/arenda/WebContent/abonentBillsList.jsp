<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.valueobject.*"%>

<% String gColSpan = "15"; %> 
<% String emptyString = ""; %>
<% String message = ""; %>
<% String leaseBill = request.getParameter("leaseBill");
   if(leaseBill == null || leaseBill == "") 
      leaseBill = "0";
%>

<july:browseform action="/ShowAbonentBillsList.do" styleId="AbonentBillsListForm">

<script language="javascript">
function switchDate() {
	if (document.all.isDate[0].checked) {
		AbonentBillsListForm.fromDate_dt.enabled = false;
		AbonentBillsListForm.toDate_dt.enabled = false;
	} else {
		AbonentBillsListForm.fromDate_dt.enabled = true;
		AbonentBillsListForm.toDate_dt.enabled = true;
	}
}
// <!-- patch 3 start -->
//считывание "LeaseBill"
function presetLeaseBill() {
    if(document.all.rindex.value != 0 || document.all.leaseBill.value != 0)
       return;
	var cookies = document.cookie;
	//"leaseBill"
	var startLoc = cookies.indexOf("leaseBill=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
    document.all.leaseBill.value = cookies.substring(sepLoc+1, endLoc);
    //"rindex"
    startLoc = cookies.indexOf("rowIndex=");
    if(startLoc == -1)
	  return;
    sepLoc = cookies.indexOf("=", startLoc);
    endLoc = cookies.indexOf(";", startLoc);
    if(endLoc == -1) {
      endLoc = cookies.length;
    }
    document.all.rindex.value = cookies.substring(sepLoc+1, endLoc);
	if( document.all.tableID.rows.item(new Number(document.all.rindex.value)) != null ) {
       document.all.tableID.rows.item(new Number(document.all.rindex.value)).className='selected';
	}
	//<!-- patch 3 end -->
}
//сохранение "LeaseBill"
function storeLeaseBill(leaseBill, rowIndex) {
	document.cookie = "leaseBill=" + leaseBill;
	document.cookie = "rowIndex=" + rowIndex;
}
</script>

<html:hidden property="leaseDocument"/> 
<html:hidden property="rindex" value="0"/>
<html:hidden property="leaseBill" value="<%= leaseBill%>"/>

<table class="main" id="tableID" style="font-size: 8pt">

<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
			<july:sepmark/>
			<july:editlink page="/ViewAbonent.do" action="View" paramId="leaseDocument" paramName="AbonentBillsListForm" paramProperty="leaseDocument" styleClass="navigator">
				<bean:message key="label.view"/>
			</july:editlink>
			<july:sepmark/>
			<july:currmark><bean:message key="label.abonents.paybill"/></july:currmark>
		</td>
	</tr>
--%>

<!-- SI patch 1 start  -->
	<logic:notEqual name="AbonentBillsListForm" property="taskcode" value="0">
	  <july:separator colspan="<%= gColSpan %>"/>
		<tr class="text">
			<td class="text">&nbsp;</td>
			<td class="text" colspan="5">
				<july:link page="/ShowFromBillHandleInNRIJournalBillList.do" paramId="taskStartcode" paramName="AbonentBillsListForm" 
							paramProperty="taskcode" scope="session">
					<bean:message key="label.abonent.journal"/> 
				</july:link>
			</td>
		</tr>
	</logic:notEqual>
<!-- SI patch 1 end -->

<july:separator colspan="<%= gColSpan %>"/>
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text" width="30%"><bean:message key="label.bans.ban"/>:</td>
					<td class="text" nowrap><bean:write name="AbonentBillsListForm" property="ban" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.bans.org.name"/>:</td>
					<td class="text">
						<bean:write name="AbonentBillsListForm" property="customername" filter="true"/>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.bans.org.inn"/>:</td>
					<td class="text" nowrap>
						<bean:write name="AbonentBillsListForm" property="customerinn" filter="true"/>
					</td>
				</tr>
<logic:present name="AbonentBillsListForm" property="customernameBill">
	<logic:notEqual name="AbonentBillsListForm" property="customernameBill" value="<%= emptyString %>">
				<tr>
					<td class="text"><bean:message key="label.bans.name"/>:</td>
					<td class="text">
						<bean:write name="AbonentBillsListForm" property="customernameBill" filter="true"/>
				</tr>
	</logic:notEqual>
</logic:present>
<logic:present name="AbonentBillsListForm" property="customerinnBill">
	<logic:notEqual name="AbonentBillsListForm" property="customerinnBill" value="<%= emptyString %>">
				<tr>
					<td class="text"><bean:message key="label.bans.inn"/>:</td>
					<td class="text" nowrap>
						<bean:write name="AbonentBillsListForm" property="customerinnBill" filter="true"/>
					</td>
				</tr>
	</logic:notEqual>
</logic:present>
				<tr>
					<td class="text"><bean:message key="label.filter.start"/>:</td>
					<td class="text">
						<table class="find" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="text">
									<july:checkbox property="isDate" insertable="true" updatable="true" onclick="switchDate()"/>
									<bean:message key="label.filter.all"/>
								</td>
								<td class="text"><july:date property="fromDateFrm" size="25" insertable="true" updatable="true" styleId="fromDate"/></td>
								<td class="text"><bean:message key="label.filter.stop"/>:</td>
								<td class="text"><july:date property="toDateFrm" size="25" insertable="true" updatable="true" styleId="toDate"/></td>
								<td class="text"><july:searchbutton/></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.bans.bill.ntype"/>:</td>
					<td class="text" nowrap>
				   		<july:radio property="searchState" insertable="true" updatable="true" value="0"/><bean:message key="label.search.all"/>
						<july:radio property="searchState" insertable="true" updatable="true" value="1"/><bean:message key="label.bans.bill.type.service"/>
						<july:radio property="searchState" insertable="true" updatable="true" value="2"/><bean:message key="label.bans.bill.type.equipment"/>
						<july:radio property="searchState" insertable="true" updatable="true" value="3"/><bean:message key="label.bans.bill.type.mix"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.bans.bill.stype"/>:</td>
					<td class="text" nowrap>
				   		<july:radio property="searchUsenri" insertable="true" updatable="true" value="0"/><bean:message key="label.search.all"/>
						<july:radio property="searchUsenri" insertable="true" updatable="true" value="1"/><bean:message key="label.bans.bill.type.usenri"/>
						<july:radio property="searchUsenri" insertable="true" updatable="true" value="2"/><bean:message key="label.bans.bill.type.unusenri"/>
					</td>
				</tr>

				<tr>
					<td class="text"><bean:message key="label.bans.bill.otype"/>:</td>
					<td class="text" nowrap>
				   		<july:radio property="searchPaid" insertable="true" updatable="true" value="0"/><bean:message key="label.search.all"/>
						<july:radio property="searchPaid" insertable="true" updatable="true" value="1"/><bean:message key="label.bans.bill.otype.unpaid"/>
						<july:radio property="searchPaid" insertable="true" updatable="true" value="2"/><bean:message key="label.bans.bill.otype.paid"/>
					</td>
				</tr>

			</table>
<html:hidden property="searchPaid"/>
		</TD>
	</TR>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:backbutton page="/ViewAbonent.do?action=View" paramId="leaseDocument" paramName="AbonentBillsListForm" paramProperty="leaseDocument"/>
						<!-- <july:savebutton/> -->
					    <july:canedit rolesProperty="editRoles">
						   <logic:notEqual name="AbonentForm" property="contractState" value="A">
                              <input type='image' name='submit' src='/images/save.gif' alt='<bean:message key="label.abonent.nrifunc"/>' onclick = "document.all.group.value=true;">
						   </logic:notEqual>
					    </july:canedit>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<!-- Table header  -->
	<tr class="title">
		<td class="title">&nbsp;</td>
<!-- SI patch 2 start -->
<%--
		<td class='title' title='<bean:message key="label.bans.bill.useinnri"/>'>*</td>
		<td class='title' title='<bean:message key="label.bans.bill.flagworknri"/>'>*</td>
--%>
<!-- SI patch 2 end -->
<!-- SI patch 1 start -->
		<td class='title' title='<bean:message key="label.bans.bill.flagworknri"/>'>*</td>
<!-- SI patch 1 end -->
		<july:sortcolumn key="label.bans.bill.date" colType="string" ascFinder="3" descFinder="4"/>
		<july:sortcolumn key="label.bans.bill.number" colType="string" ascFinder="1" descFinder="2"/>
		<july:headercolumn key="label.bans.ben" colType="string"/>
		<td colspan="3" align="center"><b><bean:message key="label.bans.bill.sum"/></b></td>
		<july:headercolumn key="label.bans.bill.sumnds" colType="string"/>
		<%-- <july:headercolumn key="label.bans.bill.sumnsp" colType="string"/> --%>
		<july:headercolumn key="label.bans.bill.startdate" colType="string"/>
		<july:headercolumn key="label.bans.bill.enddate" colType="string"/>
		<td colspan="2" align="center"><b><bean:message key="label.bans.bill.paypart"/></b></td>
		<july:headercolumn key="label.bans.bill.notpaypart" colType="string"/>
		<td colspan="2" align="center"><b>статус</b></td>
<!-- SI patch 2 start -->
<%--
		<td class="title">&nbsp;</td>
--%>
<!-- SI patch 2 end -->
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table  body   -->
<!-- SI patch 2, 3 start -->
	<%
	  java.util.ArrayList list = new java.util.ArrayList();
	  String clazz = "normal";
	  int curRow = 5;
	%>
	<logic:notEqual name="AbonentBillsListForm" property="taskcode" value="0">
	   <%curRow = 7;%>
    </logic:notEqual>
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">

		<%
		    com.hps.july.arenda.valueobject.AbonentBillValueObject abo = (com.hps.july.arenda.valueobject.AbonentBillValueObject)it;
			curRow=curRow+2;
		    if(abo.isFlagworknri())
			  list.add(new Integer(abo.getLeasebill()));
            
            if( leaseBill.equals(String.valueOf(abo.getLeasebill())) ) {
			  clazz = "selected";
            } 
            else {
			  clazz = "normal";
            }
		%>
			<tr class="<%= clazz%>" onMouseOut="if(document.all.rindex.value==this.rowIndex)className='selected'; else className='normal';" onMouseOver="className='select'" onClick="document.all.tableID.rows.item(new Number(document.all.rindex.value)).className='normal'; document.all.rindex.value=this.rowIndex; document.all.leaseBill.value=<%= abo.getLeasebill()%>; document.all.tableID.rows.item(new Number(document.all.rindex.value)).className='selected';storeLeaseBill(<%= abo.getLeasebill()%>, this.rowIndex);">
        <%
		    if( leaseBill.equals(String.valueOf(abo.getLeasebill())) ) {
        %>
    		<SCRIPT LANGUAGE="JavaScript">
	    		document.all.rindex.value = <%=curRow%>;
				storeLeaseBill(<%= abo.getLeasebill()%>, <%=curRow%>);
		    </SCRIPT>
        <%  }  %>
<!-- SI patch 2, 3 end -->
				<td class="text">
					<% String tmp = "View"; %>
					<july:canedit rolesProperty="editRoles">
						<logic:notEqual name="AbonentForm" property="contractState" value="A">
							<logic:notEqual name="it" property="recordstatus" value="D">
								<logic:equal name="it" property="flagworknri" value="false"><% tmp = "Edit"; %></logic:equal>
							</logic:notEqual>
						</logic:notEqual>
					</july:canedit>
					<july:editbutton page="/EditAbonentBill.do" action="<%= tmp %>" paramId="leasebill" paramName="it" paramProperty="leasebill" paramScope="page"/>
				</td>
<!-- SI patch 2 start   -->
<%--
				<logic:present name="it" property="useinnri">
					<logic:equal name="it" property="useinnri" value="true"><% message = "label.bans.bill.useinnri.yes"; %></logic:equal>
					<logic:equal name="it" property="useinnri" value="false"><% message = "label.bans.bill.useinnri.no"; %></logic:equal>
					<td class='text' align='center' title='<bean:message key="<%= message %>"/>'>
						<logic:equal name="it" property="useinnri" value="true">+</logic:equal>
						<logic:equal name="it" property="useinnri" value="false">-</logic:equal>
					</td>
				</logic:present>
				<logic:notPresent name="it" property="useinnri">
					<td class='text'>&nbsp;</td>
				</logic:notPresent>
				
				<logic:equal name="it" property="flagworknri" value="true"><% message = "label.bans.bill.flagworknri.yes"; %></logic:equal>
				<logic:equal name="it" property="flagworknri" value="false"><% message = "label.bans.bill.flagworknri.no"; %></logic:equal>
				<td class='text' align='center' title='<bean:message key="<%= message %>"/>'>
					<logic:equal name="it" property="flagworknri" value="true">+</logic:equal>
					<logic:equal name="it" property="flagworknri" value="false">-</logic:equal>
				</td>
--%>
<!-- SI patch 2 end -->
<!-- SI patch 1 start -->
				
				<july:canedit rolesProperty="editRoles">
				<td>
					<html:checkbox name = "it" property="flagworknri"  value= "<%= String.valueOf(((AbonentBillValueObject)it).getLeasebill()) %>"/>
				</td>
				</july:canedit>
			 	<july:cannotedit rolesProperty="editRoles">
			 	<td>
					<html:checkbox name = "it" property="flagworknri"  value= "<%= String.valueOf(((AbonentBillValueObject)it).getLeasebill()) %>" disabled="true" />
				</td>
				</july:cannotedit>
								
<!-- SI patch 1 end -->				
				<td class="text">
					<july:datewrite name="it" property="billdate"/>
				</td>
				
				<td class="text">
					<bean:write name="it" property="billnumber" filter="true"/>
				</td>
				
				<td class="text">
					<bean:write name="it" property="ben" filter="true"/>
				</td>
				
				<td class="test">
					<logic:equal name="it" property="summsdiffer" value="true">
						<IMG SRC="/images/infohint.gif" BORDER=0 ALT='<bean:message 
							key="label.bans.bill.summsdiffer"/>&#13;<bean:message
							key="label.bans.bill.hsummbill"/>: <july:sumwrite name="it" 
							property="sum"/>&#13;<bean:message
							key="label.bans.bill.hsummnri"/>: <july:sumwrite name="it" 
							property="nrisum"/>&#13;причина: <bean:write name="it" 
							property="sumchangereason"/>'>
					</logic:equal>
				</td>

				<td class="number" align="right">
					<july:sumwrite name="it" property="sum"/>
				</td>
				
				<td class="link" align="center">
					<july:link page="/ShowAbonentBillPosesList.do" paramId="leaseBill" paramName="it" 
							paramProperty="leasebill" scope="page">
						<img src='/images/kontr.gif' border=0 alt='<bean:message key="label.bans.bill.poses"/>'>
					</july:link>
				</td>
				
				<td class="number" align="right">
					<july:sumwrite name="it" property="sumnds"/>
				</td>
				
				<%--
				<td class="number" align="right">
					<july:sumwrite name="it" property="nrisumnsp"/>
				</td>
				--%>
				
				<td class="text">
					<july:datewrite name="it" property="billperiodstart"/>
				</td>
				
				<td class="text">
					<july:datewrite name="it" property="billperiodend"/>
				</td>
				
				<td class="number" align="right" title='<bean:write name="it" property="payednotes" filter="true"/>'>
					<july:sumwrite name="it" property="payed"/>
				</td>
				
				<td class="link" align="center">
					<july:link page="/ShowAbonentBilledList.do" paramId="leaseBill" paramName="it" paramProperty="leasebill" scope="page">
						<img src='/images/kontr.gif' border=0 alt='<bean:message key="label.bans.bill.whatpay"/>'>
					</july:link>
				</td>
				
				<td class="number" align="right">
					<july:sumwrite name="it" property="notpayed"/>
				</td>
<!-- SI patch 2 start -->
<%--
				<td class="link" align="center">
					<july:canedit rolesProperty="editRoles">
						<logic:notEqual name="AbonentForm" property="contractState" value="A">
							<july:link page="/EditBillHandleInNRI.do" paramId="leaseBill" paramName="it" paramProperty="leasebill" scope="page">
								<img src='/images/doc.gif' border=0 alt='<bean:message key="label.abonent.nrifunc"/>'>
							</july:link>
						</logic:notEqual>
					</july:canedit>
				</td>
--%>
<!-- SI patch 2 end -->
				<td>
					<bean:write name="it" property="billstatusTxt" filter="true"/>
				</td>
			</tr>
			<july:separator colspan="<%= gColSpan %>"/>
	      </logic:present>
        </logic:iterate>

		<%
		   com.hps.july.arenda.formbean.AbonentBillsListForm form = (com.hps.july.arenda.formbean.AbonentBillsListForm)session.getAttribute("AbonentBillsListForm");
		   form.setOldFlagworknri(list);
		%>

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:backbutton page="/ViewAbonent.do?action=View" paramId="leaseDocument" paramName="AbonentBillsListForm" paramProperty="leaseDocument"/>
						<!-- <july:savebutton/> -->
					    <july:canedit rolesProperty="editRoles">
						   <logic:notEqual name="AbonentForm" property="contractState" value="A">
                              <input type='image' name='submit' src='/images/save.gif' alt='<bean:message key="label.abonent.nrifunc"/>' onclick = "document.all.group.value=true;">
						   </logic:notEqual>
					    </july:canedit>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	<html:hidden property="group"/>
	<july:separator colspan="<%= gColSpan %>" />

<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
			<july:sepmark/>
			<july:editlink page="/ViewAbonent.do" action="View" paramId="leaseDocument" paramName="AbonentBillsListForm" paramProperty="leaseDocument" styleClass="navigator">
				<bean:message key="label.view"/>
			</july:editlink>
			<july:sepmark/>
			<july:currmark><bean:message key="label.abonents.paybill"/></july:currmark>
		</td>
	</tr>
--%>

</table>

<script language="javascript">
	switchDate();
	presetLeaseBill();
</script>

</july:browseform>
