<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.cdbc.lib.*"%>

<% java.lang.String gColSpan = "11"; %>


<july:browseform action="/ShowContractorInventoryList.do" styleId="invlistformpos">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		document.all[itemname].className = 'editkoddisabled';
		document.all[itemname].disabled = true;
		document.all[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		document.all[itemname].className = 'editkodsearch';
		document.all[itemname].disabled = false;
		document.all[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchOwner() {
	if(document.all.showallowner[0].checked) {
		document.all.owner.className='editdisabled';
	} else {
		document.all.owner.className='editsearch';
	}
	document.all.owner.disabled=document.all.showallowner[0].checked;
}

function switchPosition() {
	switchLookup('position','pos',document.all.showallstorage[0].checked);
	if(document.all.showallstorage[0].checked) {
		document.all['lookupimg_posl'].src='/images/lookup_disabled.gif';
		document.all['lookupbtn_posl'].disabled = true;
	} else {
		document.all['lookupimg_posl'].src='/images/lookup.gif';
		document.all['lookupbtn_posl'].disabled = false;
	}
}

function switchFilter() {
	if(ContractorInventoryList.type[0].checked) {
		switchLookup('contractorcode','rent',true);
		ContractorInventoryList['contractorname'].disabled = true;
	} else if(ContractorInventoryList.type[1].checked) {
		switchLookup('contractorcode','rent',false);
		ContractorInventoryList['contractorname'].disabled = false;
	}  else {
		switchLookup('contractorcode','rent',false);
		ContractorInventoryList['contractorname'].disabled = false;
	}
}


</script>

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
    <table class="find">
	<tr>
		<td class="title"><bean:message key="label.inventory.org"/></td>
		<td class="title"><july:checkbox property="showallowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td class="title"><july:select collection="organizations" property="owner" insertable="true" updatable="true" styleClass="editsearch">
				<html:options collection="organizations" property="organization" labelProperty="name"/><july:searchbutton />
			</july:select><script language="javascript">switchOwner();</script>
		</td>
    </tr>        
    <tr>
       <td class="title"><bean:message key="label.inventory.date"/></td>
       <td class="title" colspan="2">
			<bean:message key="label.datefrom"/> &nbsp;&nbsp;&nbsp; <july:date property="datefromstr" size="25" insertable="true" updatable="true"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:message key="label.dateto"/> &nbsp;&nbsp;&nbsp; <july:date property="datetostr" size="25" insertable="true" updatable="true"/>
	   </td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.assemblingp.type"/></td>
		<td class="title" colspan="2">
			<july:radio insertable="true" updatable="true" property="type" value="A" onclick="switchFilter();"/><bean:message key="label.all"/>
			<july:radio insertable="true" updatable="true" property="type" value="P" onclick="switchFilter();"/><bean:message key="label.acttype.forp"/>
		</td>
	</tr>
	<tr>
		<td class="title">Подрядчик</td>
		<td class="title" colspan="2">
			<july:string property="contractorcode" styleId="contractorcode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="rentl" fieldNames="contractorcode;contractorname" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_rentl('?selisprovider=true&selisrenter=false&selissupplier=false');"/>
			<july:string size="35" property="contractorname" styleId="contractorname" insertable="false" updatable="false" />
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.inventory.position"/></td>
		<td class="title"><july:checkbox property="showallstorage" insertable="true" updatable="true" value="true" onclick="switchPosition();" /><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td class="title"><july:string property="position" styleId="position" size="10" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="position;positionid;positionname;dummy1;dummy1" insertable="true" updatable="true"/>
			<july:string size="10" property="positionid" styleId="positioid" insertable="false" updatable="false" />
			<july:string size="35" property="positionname" styleId="positionname" insertable="false" updatable="false" />
		</td>
    </tr>       
    
<script language="javascript">
switchPosition();
switchFilter();
</script>
    </table>
  </td>
</tr>


<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons"><july:addbutton page="/EditContractorInventory.do?action=Add" alttext="label.inventory.add"/><A HREF="ContractorLoadExcel.do?action=Add"><img src="/images/loadexcel.gif" border="0"></A>
			<july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
		
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.void" colType="number"/>
	<july:sortcolumn key="label.internal.date" colType="string" ascFinder="3" descFinder="4"/>
	<july:sortcolumn key="label.num" colType="number" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.external.owner" colType="string"/>
	<july:headercolumn key="label.inventory.placename" colType="string"/>
	<july:headercolumn key="label.internal.state" colType="string"/>
	<july:headercolumn key="label.void" colType="string"/>
	<july:headercolumn key="label.void" colType="string"/>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
	<logic:present name="it">
<%
      boolean isAutoDoc = "Y".equals(it.getColumn("isautodoc").asString());
      String docState = it.getColumn("docstate").asString();
%>
		<tr selectableID='<july:stringwrite name="it" property="act"/>' classReal='<%=(isAutoDoc?"autodoc":"normal")%>' class='<%=(isAutoDoc?"autodoc":"normal")%>' id='selID<july:stringwrite name="it" property="act"/>' onMouseOver='className="select"' onMouseOut="className='<%=(isAutoDoc?"autodoc":"normal")%>'">
			<td class="text">
			<% if ("1".equals(docState) && !isAutoDoc) { %>
			<july:editbutton page="/EditContractorInventory.do" action="Edit" paramId="act" paramName="it" paramProperty="act" paramScope="page" alttext="label.internal.edit"/>
			<% } else { %>
			<july:editbutton page="/EditContractorInventory.do" action="View" paramId="act" paramName="it" paramProperty="act" paramScope="page" alttext="label.internal.view"/>
			<% } %>
			<a name="selID<july:stringwrite name="it" property="act"/>"></a>
			</td>
			<td class="text">
				<july:datewrite name="it" property="date"/>
			</td>
			<td class="text">
				<%-- <july:stringwrite name="it" property="orderindex"/>&nbsp; --%>
				<july:stringwrite name="it" property="ordernumber"/>
			</td>
			<td class="text">
				<july:stringwrite name="it" property="contractorname"/>
			</td>
			<td class="text">
				<july:stringwrite name="it" property="posname"/>
			</td>
			<td class="text">
				<% if ("1".equals(docState)) { %><bean:message key="label.state.entering"/><% } else { %><bean:message key="label.state.calculated"/><% } %>
			</td>
			<td class="text">
				&nbsp;
			</td>
			<td class="link">
				<% if ("1".equals(docState) && !isAutoDoc) { %>
					<july:delbutton page="/ProcessContractorInventory.do?action=Delete" paramId="act" paramName="it" paramProperty="act" paramScope="page"/>
			        <% } %>
			</td>
		</tr>

		<july:separator colspan="<%= gColSpan %>" />

	</logic:present>
</logic:iterate>




<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons"><july:addbutton page="/EditContractorInventory.do?action=Add" alttext="label.inventory.add"/><A HREF="ContractorLoadExcel.do?action=Add"><img src="/images/loadexcel.gif" border="0"></A>
			<july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
		
</july:selectableTable>

</july:browseform>
