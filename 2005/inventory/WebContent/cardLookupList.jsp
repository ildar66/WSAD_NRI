<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="java.math.BigDecimal"%>

<%
	com.hps.july.jdbcpersistence.lib.TimeCounter tc = new com.hps.july.jdbcpersistence.lib.TimeCounter("PERF.INVENTORY.CardLookup");
	tc.start();
	String act = (String)request.getAttribute("CRDLOOKUP.action");
	String formname = (String)request.getAttribute("CRDLOOKUP.form");
System.out.println("JSP.INVENTORY.CardLookup: action: "+act+", "+formname);
%>

<july:browseform action="<%=act%>" styleId="cardform">
<%
	boolean inside = false;
%>
<logic:equal name="<%=formname%>" property="isInside" value="true">
<%
	inside = true;
	System.out.println("JSP.INVENTORY.CardLookup: inside");
%>
</logic:equal>

<html:hidden property="pagetype"/>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		cardform[itemname].className = 'editkodsearch';
		cardform[itemname].disabled = false;
		cardform[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	} else {
		cardform[itemname].className = 'editkoddisabled';
		cardform[itemname].disabled = true;
		cardform[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	}
}

function switchItem(itemname,state) {
	if(state) {
		cardform[itemname].disabled = false;
		cardform[itemname].className = 'editsearch';
	} else {
		cardform[itemname].disabled = true;
		cardform[itemname].className = 'editdisabled';
	}
}

function switchResourcetype() {
	switchLookup('resourcetypecode','rt',cardform.isResourcetype[0].checked);
	switchLookup('resourcesubtypecode','rst',cardform.isResourcetype[0].checked);
}
function switchSign() {
	switchItem('sign',cardform.isSign[0].checked);
}
function switchName() {
	switchItem('name',cardform.isName[0].checked);
}
function switchManufacturer() {
	switchLookup('manufacturercode','org',cardform.isManufacturer[0].checked);
}
function switchManucode() {
	switchItem('manucode',cardform.isManucode[0].checked);
}
function switchSer() {
	switchItem('serialnum',cardform.isSer[0].checked);
}
</script>

<% java.lang.String gColSpan = "12"; %>

<%--
Result: 
resourcecode,resourcename,resourcemodel,configuration,serialnumber,party,qty,place,storagecard,manufserial,ownercode,realserial

0 so.resource.resource
1 so.place
2 so.resource.name
3 so.resource.model
4 so.configuration
5 so.serialnumber
6 so.manufserial
7 so.party
8 so.owner.name
9 so.qty
10 so.storagecard
11 so.qtyBroken
12 so.ownercode
13 so.price
14 so.realserial
15 so.isfictserial
--%>
<july:lookupresult tableId="brtable" resultCols="0;2;3;4;14;7;9;1;10;6;12;13;5;15;"/>

<table class="main">
<tr class="title">
	<td class="title">
		<bean:message key="label.choose.card"/>
	</td>
</tr>
<tr class="normal">
	<td>
	<table class="find">
	<logic:present name="<%=formname%>" property="owner">
	<tr>
		<td class="title"><bean:message key="label.internal.owner"/></td>
		<td class="title" colspan="2"><bean:write name="<%=formname%>" property="ownername" filter="true" /></td>
	</tr>
	</logic:present>
	<logic:present name="<%=formname%>" property="storagetype">
	<tr>
		<logic:equal name="<%=formname%>" property="storagetype" value="S">
        	<td class="title"><bean:message key="label.card.storage"/></td>
		</logic:equal>
		<logic:equal name="<%=formname%>" property="storagetype" value="E">
		<td class="title"><bean:message key="label.card.expedition"/></td>
		</logic:equal>
		<logic:equal name="<%=formname%>" property="storagetype" value="P">
		<td class="title"><bean:message key="label.card.position"/></td>
		</logic:equal>
		<logic:equal name="<%=formname%>" property="storagetype" value="Q">
		<td class="title"><bean:message key="label.card.equipment"/></td>
		</logic:equal>
		<td colspan="2" class="title"><bean:write name="<%=formname%>" property="storagename" filter="true" />&nbsp;<july:searchbutton/></td>
	</tr>
	</logic:present>
	<logic:notPresent name="<%=formname%>" property="storagetype">
	<tr>
        	<td class="title"><bean:message key="label.card.place"/></td>
		<td colspan="2" class="title"><bean:write name="<%=formname%>" property="storagename" filter="true" />&nbsp;<july:searchbutton/></td>
	</tr>
	</logic:notPresent>
	<logic:present name="<%=formname%>" property="agregate">
	<tr>
		<td class="title"><bean:message key="label.card.agregate"/></td>
		<td colspan="2" class="title"><bean:write name="<%=formname%>" property="agregatename" filter="true" /></td>
	</tr>
	</logic:present>
	<logic:present name="<%=formname%>" property="resource">
	<tr>
		<td class="title"><bean:message key="label.card.resource"/></td>
		<td colspan="2" class="title"><bean:write name="<%=formname%>" property="resourcename" filter="true" /></td>
	</tr>
	</logic:present>
	<logic:notPresent name="<%=formname%>" property="resource">
	<tr>
		<td class="title" nowrap rowspan="2">
			<july:checkbox property="isResourcetype" insertable="true" updatable="true" value="true" onclick="switchResourcetype();"/><html:hidden property="isResourcetype" value="false"/><bean:message key="label.resource.byclass"/>&nbsp;
		</td>
		<td class="title" nowrap align="right"><bean:message key="label.resource.type"/></td>
		<td class="title" nowrap colspan="1">
			<july:string property="resourcetypecode" styleId="resourcetypecode" size="5" insertable="true" updatable="true"  styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rtl" fieldNames="resourcetypecode;resourcetypename" newWindowName="restypelookup" insertable="true" updatable="true"/>
			<july:string size="25" property="resourcetypename" styleId="resourcetypename" insertable="false" updatable="false" />
		</td>
	</tr>        
	<tr>
		<td class="title" nowrap align="right"><bean:message key="label.resource.subtype"/></td>
		<td class="title" nowrap colspan="1">
			<july:string property="resourcesubtypecode" styleId="resourcesubtypecode" size="5" insertable="true" updatable="true" styleClass="editkodsearch" />
			<july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="rstl" fieldNames="resourcesubtypecode;resourcesubtypename" newWindowName="ressbtypelookup" onclick="set_opt_params_rstl('?resourcetype='+document.all.resourcetypecode.value)" insertable="true" updatable="true"/>
			<july:string size="25" property="resourcesubtypename" styleId="resourcesubtypename" insertable="false" updatable="false" />
		</td>
	</tr>
	<tr>
		<td class="title" nowrap>
			<july:checkbox property="isSign" insertable="true" updatable="true" value="true" onclick="switchSign();"/><html:hidden property="isSign" value="false"/><bean:message key="label.resource.bysign"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td class="title" nowrap colspan="2"><july:string size="40" property="sign" styleId="sign" insertable="true" updatable="true"  styleClass="search"/></td>
	</tr>
	<tr>
		<td class="title" nowrap>
			<july:checkbox property="isName" insertable="true" updatable="true" value="true" onclick="switchName();"/><html:hidden property="isName" value="false"/><bean:message key="label.resource.byname"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td class="title" nowrap colspan="2"><july:string size="40" property="name" styleId="name" insertable="true" updatable="true" styleClass="search" /></td>
	</tr>
	<tr>
		<td class="title" nowrap>
			<july:checkbox property="isManufacturer" insertable="true" updatable="true" value="true" onclick="switchManufacturer();"/><html:hidden property="isManufacturer" value="false"/><bean:message key="label.resource.bymanufacturer"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td class="title" nowrap colspan="2">
			<july:string property="manufacturercode" styleId="manufacturercode" size="5" insertable="true" updatable="true" styleClass="editkodsearch" />
			<%--<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="manufacturercode;manufacturername" newWindowName="orglookup" insertable="true" updatable="true" onclick="set_opt_params_orgl('?selisprovider=false&selisrenter=false&selissupplier=false');"/>--%>
			<july:lookupbutton action="/../dict/ShowEquipmanufLookupList.do" styleId="orgl" fieldNames="manufacturercode;manufacturername" newWindowName="orglookup" insertable="true" updatable="true" onclick="set_opt_params_orgl('?selisprovider=false&selisrenter=false&selissupplier=false');"/>
			<july:string size="25" property="manufacturername" styleId="manufacturername" insertable="false" updatable="false" />
		</td>
	</tr>
	<tr>
		<td class="title" nowrap>
			<july:checkbox property="isManucode" insertable="true" updatable="true" value="true" onclick="switchManucode();"/><html:hidden property="isManucode" value="false"/><bean:message key="label.resource.bymanucode"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td class="title" nowrap colspan="2"><july:string size="40" property="manucode" styleId="manucode" insertable="true" updatable="true" styleClass="search" /></td>
	</tr>
	<tr>
		<td class="title" nowrap>
			<july:checkbox property="isSer" insertable="true" updatable="true" value="true" onclick="switchSer();"/><html:hidden property="isSer" value="false"/><bean:message key="label.resource.byserial"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td class="title" nowrap colspan="2"><july:string size="40" property="serialnum" styleId="serialnum" insertable="true" updatable="true" styleClass="search" />
		</td>
	</tr>
<script language="javascript">
switchResourcetype();
switchName();
switchSign();
switchManufacturer();
switchManucode();
switchSer();
</script>
	</logic:notPresent>
	</table>
	</td>
</tr>

<tr class="title">
	<td>
	<table class="buttons">
	<tr class="title">
		<td class="buttons"><july:closebutton page="/"/></td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>

<tr>
	<td>
	<table class="main" id="brtable">
<%
	int rowindex = 0;
%>
<logic:equal name="<%=formname%>" property="pagetype" value="1">
        <!-- Table header for resources of any policy -->
	<tr class="title">
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.card.code"/></td>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<july:headercolumn key="label.card.name" colType="string"/>
		<july:headercolumn key="label.card.model" colType="string"/>
		<july:headercolumn key="label.card.configuration" colType="string"/>
		<july:headercolumn key="label.card.serial" colType="string"/>
		<july:headercolumn key="label.manufserial" colType="string"/>
		<july:headercolumn key="label.card.party" colType="string"/>
		<july:headercolumn key="label.card.owner" colType="string"/>
		<july:headercolumn key="label.card.qty" colType="number"/>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<july:headercolumn key="label.card.brokenqty" colType="number"/>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<td class="title" style="visibility:hidden;display:none;">serial</td>
		<td class="title" style="visibility:hidden;display:none;">isfictserial</td>
	</tr>
	<!-- Table body -->
	<logic:iterate id="rstl" name="browseList" indexId="index" type="com.hps.july.cdbc.lib.CDBCRowObject">
		<logic:present name="rstl">
<%
		boolean agregated = rstl.getColumn("agregate").asObject() != null;
		boolean canselect = false;
		String policy = rstl.getColumn("policy").asString();
		String serial = rstl.getColumn("serial").asString();

		pageContext.setAttribute("fser",String.valueOf("Y".equals(rstl.getColumn("isfictserial").asString())));

//System.out.println("SERIAL:"+serial+" FICT:"+rstl.getColumn("isfictserial").asString());

		if("S".equals(policy)) {
			if(!agregated) {
				if(serial != null && !"".equals(serial)) {
					canselect = true;
				} else {
					canselect = false;
				}
			} else {
				canselect = inside;
			}
		} else {
			canselect = true;
		} 

		if("Y".equals(rstl.getColumn("isfictserial").asString())) {
			serial = "";
		}
		pageContext.setAttribute("invserial",serial);

		BigDecimal qty  = (BigDecimal)rstl.getColumn("qty").asObject(); if(qty == null) { qty = new BigDecimal("0"); }
		BigDecimal qtya = (BigDecimal)rstl.getColumn("agrqty").asObject();
		BigDecimal qtyd = (BigDecimal)rstl.getColumn("docqty").asObject();
// Calculate appropriate qty here
		if(qtya != null) {
			if(!"S".equals(policy)) {
				if(inside) { qty = qtya; }
				else { qty = qty.subtract(qtya); }
			}
		}
		if(qtyd != null) {
			qty = qty.subtract(qtyd);
		}
		pageContext.setAttribute("rstl_qty",qty);
%>
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="resource"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="place"/></td>
			<td class="text"><july:stringwrite name="rstl" property="resname"/></td>
			<td class="text"><%if(canselect){%><july:lookupreturn><july:stringwrite name="rstl" property="resmodel"/></july:lookupreturn><%} else {%><july:stringwrite name="rstl" property="resmodel"/><%}%></td>
			<td class="text"><july:stringwrite name="rstl" property="resconfig"/></td>
			<td class="text"><pre><july:stringwrite name="rstl" property="invnum"/></pre></td>
			<td class="text"><pre><july:stringwrite name="rstl" property="manuf"/></pre></td>
			<td class="text"><pre><july:stringwrite name="rstl" property="party"/></pre></td>
			<td class="text"><july:stringwrite name="rstl" property="ownername"/></td>
			<td class="text" align="right"><july:numberwrite name="rstl_qty"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="storagecard"/></td>
			<td class="text" align="right"><july:numberwrite name="rstl" property="qty_broken"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="owner"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="price"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="serial"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="fser"/></td>
		</tr>
		</logic:present>
          
		<logic:notPresent name="rstl">
		<tr class="normal">
			<td class="text" colspan="<%= gColSpan %>">
				<bean:message key="label.norecords"/>
			</td>
		</tr>
		</logic:notPresent>
          
		<july:separator colspan="<%= gColSpan %>" />

	</logic:iterate>
</logic:equal>
<logic:equal name="<%=formname%>" property="pagetype" value="2">
        <!-- Table header for serial resource -->
	<tr class="title">
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.card.code"/></td>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<july:headercolumn key="label.card.name" colType="string"/>
		<july:headercolumn key="label.card.model" colType="string"/>
		<july:headercolumn key="label.card.configuration" colType="string"/>
		<july:headercolumn key="label.card.serial" colType="string"/>
		<july:headercolumn key="label.manufserial" colType="string"/>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.card.party"/></td>
		<july:headercolumn key="label.card.owner" colType="string"/>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.card.qty"/></td>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.card.brokenqty"/></td>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<td class="title" style="visibility:hidden;display:none;">serial</td>
		<td class="title" style="visibility:hidden;display:none;">isfictserial</td>
	</tr>
	<!-- Table body -->
	<logic:iterate id="rstl" name="browseList" indexId="index" type="com.hps.july.cdbc.lib.CDBCRowObject">
		<logic:present name="rstl">
<%
		boolean agregated = rstl.getColumn("agregate").asObject() != null;
		boolean canselect = false;
		String policy = rstl.getColumn("policy").asString();
		String serial = rstl.getColumn("serial").asString();
//System.out.println("SERIAL:"+serial+" FICT:"+rstl.getColumn("isfictserial").asString());

		pageContext.setAttribute("fser",String.valueOf("Y".equals(rstl.getColumn("isfictserial").asString())));

		if("S".equals(policy)) {
			if(!agregated) {
				if(serial != null && !"".equals(serial)) {
					canselect = true;
				} else {
					canselect = false;
				}
			} else {
				canselect = inside;
			}
		} else {
			canselect = true;
		} 

		if("Y".equals(rstl.getColumn("isfictserial").asString())) {
			serial = "";
		}
		pageContext.setAttribute("invserial",serial);

		BigDecimal qty  = (BigDecimal)rstl.getColumn("qty").asObject(); if(qty == null) { qty = new BigDecimal("0"); }
		BigDecimal qtya = (BigDecimal)rstl.getColumn("agrqty").asObject();
		BigDecimal qtyd = (BigDecimal)rstl.getColumn("docqty").asObject();
// Calculate appropriate qty here
		if(qtya != null) {
			if(!"S".equals(policy)) {
				if(inside) { qty = qtya; }
				else { qty = qty.subtract(qtya); }
			}
		}
		if(qtyd != null) {
			qty = qty.subtract(qtyd);
		}
		pageContext.setAttribute("rstl_qty",qty);
%>
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="resource"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="place"/></td>
			<td class="text"><july:stringwrite name="rstl" property="resname"/></td>
			<td class="text"><%if(canselect){%><july:lookupreturn><july:stringwrite name="rstl" property="resmodel"/></july:lookupreturn><%} else {%><july:stringwrite name="rstl" property="resmodel"/><%}%></td>
			<td class="text"><july:stringwrite name="rstl" property="resconfig"/></td>
			<td class="text"><pre><july:stringwrite name="rstl" property="invnum"/></pre></td>
			<td class="text"><pre><july:stringwrite name="rstl" property="manuf"/></pre></td>
			<td class="text" style="visibility:hidden;display:none;"><pre><july:stringwrite name="rstl" property="party"/></pre></td>
			<td class="text"><july:stringwrite name="rstl" property="ownername"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:numberwrite name="rstl_qty"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="storagecard"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:numberwrite name="rstl" property="qty_broken"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="owner"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="price"/></td>
			<td class="text" style="visibility:hidden;display:none;"><pre><july:stringwrite name="rstl" property="serial"/></pre></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="fser"/></td>
		</tr>
		</logic:present>
          
		<logic:notPresent name="rstl">
		<tr class="normal">
			<td class="text" colspan="<%= gColSpan %>">
				<bean:message key="label.norecords"/>
			</td>
		</tr>
		</logic:notPresent>
          
		<july:separator colspan="<%= gColSpan %>" />

	</logic:iterate>
</logic:equal>
<logic:equal name="<%=formname%>" property="pagetype" value="3">
        <!-- Table header -->
	<tr class="title">
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.card.code"/></td>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.card.name"/></td>
		<july:headercolumn key="label.card.model" colType="string"/>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.card.configuration"/></td>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.card.serial"/></td>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.manufserial"/></td>
		<july:headercolumn key="label.card.party" colType="string"/>
		<july:headercolumn key="label.card.owner" colType="string"/>
		<july:headercolumn key="label.card.qty" colType="number"/>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<july:headercolumn key="label.card.brokenqty" colType="number"/>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<td class="title" style="visibility:hidden;display:none;">serial</td>
		<td class="title" style="visibility:hidden;display:none;">isfictserial</td>
	</tr>
	<!-- Table body -->
	<logic:iterate id="rstl" name="browseList" indexId="index" type="com.hps.july.cdbc.lib.CDBCRowObject">
		<logic:present name="rstl">
<%
		boolean agregated = rstl.getColumn("agregate").asObject() != null;
		boolean canselect = false;
		String policy = rstl.getColumn("policy").asString();
		String serial = rstl.getColumn("serial").asString();
//System.out.println("SERIAL:"+serial+" FICT:"+rstl.getColumn("isfictserial").asString());

		pageContext.setAttribute("fser",String.valueOf("Y".equals(rstl.getColumn("isfictserial").asString())));

		if("S".equals(policy)) {
			if(!agregated) {
				if(serial != null && !"".equals(serial)) {
					canselect = true;
				} else {
					canselect = false;
				}
			} else {
				canselect = inside;
			}
		} else {
			canselect = true;
		} 

		if("Y".equals(rstl.getColumn("isfictserial").asString())) {
			serial = "";
		}
		pageContext.setAttribute("invserial",serial);

		BigDecimal qty  = (BigDecimal)rstl.getColumn("qty").asObject(); if(qty == null) { qty = new BigDecimal("0"); }
		BigDecimal qtya = (BigDecimal)rstl.getColumn("agrqty").asObject();
		BigDecimal qtyd = (BigDecimal)rstl.getColumn("docqty").asObject();
// Calculate appropriate qty here
		if(qtya != null) {
			if(!"S".equals(policy)) {
				if(inside) { qty = qtya; }
				else { qty = qty.subtract(qtya); }
			}
		}
		if(qtyd != null) {
			qty = qty.subtract(qtyd);
		}
		pageContext.setAttribute("rstl_qty",qty);
%>
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="resource"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="place"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="resname"/></td>
			<td class="text"><%if(canselect){%><july:lookupreturn><july:stringwrite name="rstl" property="resmodel"/></july:lookupreturn><%} else {%><july:stringwrite name="rstl" property="resmodel"/><%}%></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="resconfig"/></td>
			<td class="text" style="visibility:hidden;display:none;"><pre><july:stringwrite name="rstl" property="invnum"/></pre></td>
			<td class="text" style="visibility:hidden;display:none;"><pre><july:stringwrite name="rstl" property="manuf"/></pre></td>
			<td class="text"><pre><july:stringwrite name="rstl" property="party"/></pre></td>
			<td class="text"><july:stringwrite name="rstl" property="ownername"/></td>
			<td class="text"><july:numberwrite name="rstl_qty"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="storagecard"/></td>
			<td class="text"><july:numberwrite name="rstl" property="qty_broken"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="owner"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="price"/></td>
			<td class="text" style="visibility:hidden;display:none;"><pre><july:stringwrite name="rstl" property="serial"/></pre></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="fser"/></td>
		</tr>
		</logic:present>
          
		<logic:notPresent name="rstl">
		<tr class="normal">
			<td class="text" colspan="<%= gColSpan %>">
				<bean:message key="label.norecords"/>
			</td>
		</tr>
		</logic:notPresent>
          
		<july:separator colspan="<%= gColSpan %>" />

	</logic:iterate>
</logic:equal>
<logic:equal name="<%=formname%>" property="pagetype" value="4">
        <!-- Table header for resources of any policy -->
	<tr class="title">
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.card.code"/></td>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<july:headercolumn key="label.card.name" colType="string"/>
		<july:headercolumn key="label.card.model" colType="string"/>
		<july:headercolumn key="label.card.configuration" colType="string"/>
		<july:headercolumn key="label.card.serial" colType="string"/>
		<july:headercolumn key="label.manufserial" colType="string"/>
		<july:headercolumn key="label.card.party" colType="string"/>
		<july:headercolumn key="label.card.owner" colType="string"/>
		<july:headercolumn key="label.card.qty" colType="number"/>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<july:headercolumn key="label.card.brokenqty" colType="number"/>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
		<td class="title" style="visibility:hidden;display:none;">serial</td>
		<td class="title" style="visibility:hidden;display:none;">isfictserial</td>
	</tr>
	<!-- Table body -->
	<logic:iterate id="rstl" name="browseList" indexId="index" type="com.hps.july.cdbc.lib.CDBCRowObject">
		<logic:present name="rstl">
<%
		boolean agregated = rstl.getColumn("agregate").asObject() != null;
		boolean canselect = false;
		String policy = rstl.getColumn("policy").asString();
		String serial = rstl.getColumn("serial").asString();
//System.out.println("SERIAL:"+serial+" FICT:"+rstl.getColumn("isfictserial").asString());

		pageContext.setAttribute("fser",String.valueOf("Y".equals(rstl.getColumn("isfictserial").asString())));

		if("S".equals(policy)) {
			if(!agregated) {
				if(serial != null && !"".equals(serial)) {
					canselect = true;
				} else {
					canselect = false;
				}
			} else {
				canselect = inside;
			}
		} else {
			canselect = true;
		} 

		if("Y".equals(rstl.getColumn("isfictserial").asString())) {
			serial = "";
		}
		pageContext.setAttribute("invserial",serial);

		BigDecimal qty  = (BigDecimal)rstl.getColumn("qty").asObject(); if(qty == null) { qty = new BigDecimal("0"); }
		BigDecimal qtya = (BigDecimal)rstl.getColumn("agrqty").asObject();
		BigDecimal qtyd = (BigDecimal)rstl.getColumn("docqty").asObject();
// Calculate appropriate qty here
		if(qtya != null) {
			if(!"S".equals(policy)) {
				if(inside) { qty = qtya; }
				else { qty = qty.subtract(qtya); }
			}
		}
		if(qtyd != null) {
			qty = qty.subtract(qtyd);
		}
		pageContext.setAttribute("rstl_qty",qty);
%>
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="resource"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="place"/></td>
			<td class="text"><july:stringwrite name="rstl" property="resname"/></td>
			<td class="text"><%if(canselect){%><july:lookupreturn><july:stringwrite name="rstl" property="resmodel"/></july:lookupreturn><%} else {%><july:stringwrite name="rstl" property="resmodel"/><%}%></td>
			<td class="text"><july:stringwrite name="rstl" property="resconfig"/></td>
			<td class="text"><pre><july:stringwrite name="rstl" property="invnum"/></pre></td>
			<td class="text"><pre><july:stringwrite name="rstl" property="manuf"/></pre></td>
			<td class="text"><pre><july:stringwrite name="rstl" property="party"/></pre></td>
			<td class="text"><july:stringwrite name="rstl" property="ownername"/></td>
			<td class="text" align="right"><july:numberwrite name="rstl_qty"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="storagecard"/></td>
			<td class="text" align="right"><july:numberwrite name="rstl" property="qty_broken"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="owner"/></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="price"/></td>
			<td class="text" style="visibility:hidden;display:none;"><pre><july:stringwrite name="rstl" property="serial"/></pre></td>
			<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="fser"/></td>
		</tr>
		</logic:present>
          
		<logic:notPresent name="rstl">
		<tr class="normal">
			<td class="text" colspan="<%= gColSpan %>">
				<bean:message key="label.norecords"/>
			</td>
		</tr>
		</logic:notPresent>
          
		<july:separator colspan="<%= gColSpan %>" />

	</logic:iterate>
</logic:equal>
    
	</table>
</td>
</tr>

<tr class="title">
	<td>
	<table class="buttons">
	<tr class="title">
		<td class="buttons"><july:closebutton page="/"/></td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>

</table>
    
</july:browseform>

<% tc.finish("JSP"); %>

