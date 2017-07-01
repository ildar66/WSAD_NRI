<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "11"; %>

<july:browseform action="/ShowInvList.do" styleId="invlistformpos">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		InvListForm[itemname].className = 'editkoddisabled';
		InvListForm[itemname].disabled = true;
		InvListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		InvListForm[itemname].className = 'editkodsearch';
		InvListForm[itemname].disabled = false;
		InvListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchOwner() {
	if(InvListForm.showallowner[0].checked) {
		InvListForm.owner.className='editdisabled';
	} else {
		InvListForm.owner.className='editsearch';
	}
	InvListForm.owner.disabled=InvListForm.showallowner[0].checked;
}

function switchPosition() {
	switchLookup('position','pos',InvListForm.showallstorage[0].checked);
	if(InvListForm.showallstorage[0].checked) {
		document.all['lookupimg_coml'].src='/images/lookup_disabled.gif';
		document.all['lookupbtn_coml'].disabled = true;
		InvListForm.showallcomplect[0].disabled = true;
	} else {
		document.all['lookupimg_coml'].src='/images/lookup.gif';
		document.all['lookupbtn_coml'].disabled = false;
		InvListForm.showallcomplect[0].disabled = false;
	}
/*
//	switchComplect();

//	disable complect checkbox here

//	if(InvListForm.showallstorage[0].checked) {
//		document.all['lookupbtn_coml'].disabled = true;
//		document.all['lookupimg_coml'].src='/images/lookup_disabled.gif';
//	} else {
//		document.all['lookupbtn_coml'].disabled = false;
//		document.all['lookupimg_coml'].src='/images/lookup.gif';
//	}
*/
}

function switchComplect() {
	if(InvListForm.showallcomplect[0].checked) {
		document.all['lookupimg_coml'].src='/images/lookup_disabled.gif';
		document.all['lookupbtn_coml'].disabled = true;
	} else {
		document.all['lookupimg_coml'].src='/images/lookup.gif';
		document.all['lookupbtn_coml'].disabled = false;
	}
}
</script>

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <july:currmark><bean:message key="label.inventorypositions"/></july:currmark>
	</td>
</tr>

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
		<td class="title"><bean:message key="label.inventory.position"/></td>
		<td class="title"><july:checkbox property="showallstorage" insertable="true" updatable="true" value="true" onclick="switchPosition();" /><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td class="title"><july:string property="position" styleId="position" size="10" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="position;positionid;positionname;complect;complectname" insertable="true" updatable="true"/>
			<july:string size="10" property="positionid" styleId="positioid" insertable="false" updatable="false" />
			<july:string size="35" property="positionname" styleId="positionname" insertable="false" updatable="false" />
		</td>
    </tr>        
    <tr>
		<td class="title"><bean:message key="label.inventory.complect"/></td>
		<td class="title"><july:checkbox property="showallcomplect" insertable="true" updatable="true" value="true" onclick="switchComplect();" /><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td class="title">
			<html:hidden property="complect"/>
<!--			<july:string property="complect" styleId="complect" size="10" insertable="true" updatable="true" styleClass="editkodsearch" /> -->
			<july:string size="45" property="complectname" styleId="complectname" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowComplectLookupList.do" styleId="coml" fieldNames="complect;complectname" insertable="true" updatable="true" onclick="set_opt_params_coml('?position='+document.all.position.value)"/>
		</td>
    </tr>
<script language="javascript">
switchPosition();
switchComplect();
</script>
    </table>
  </td>
</tr>


<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons"><july:addbutton page="/EditInv.do?action=Add" alttext="label.inventory.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
		
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<td class="title">&nbsp;</td>
	<july:sortcolumn key="label.inventory.date" colType="string" ascFinder="3" descFinder="4"/>
	<july:sortcolumn key="label.inventory.num" colType="number" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.inv.tech" colType="string"/>
	<july:headercolumn key="label.inventory.placename" colType="string"/>
	<july:headercolumn key="label.inventory.type" colType="string"/>
	<july:headercolumn key="label.inventory.state" colType="string"/>
	<july:headercolumn key="label.void" colType="string"/>
	<july:headercolumn key="label.print" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
    
<!-- Table body -->
<logic:iterate id="it" name="browseList">
	<logic:present name="it">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="link">
				<logic:equal name="it" property="document.documentState" value="1">
					<july:editbutton page="/EditInv.do" action="Edit" paramId="document" paramName="it" paramProperty="document.document" paramScope="page" alttext="label.inventory.edit"/>
				</logic:equal>
				<logic:equal name="it" property="document.documentState" value="2">
					<july:editbutton page="/EditInv.do" action="View" paramId="document" paramName="it" paramProperty="document.document" paramScope="page" alttext="label.inventory.view"/>
				</logic:equal>
			</td>
			<td class="text">
				<july:datewrite name="it" property="document.blankdate"/>
			</td>
			<td class="number">
				<bean:write name="it" property="document.blankindex" filter="true"/>&nbsp;<bean:write name="it" property="document.blanknumber" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="tech" filter="true"/>
			</td>
			<td class="text">
			<logic:present name="it" property="document.from">
				<bean:write name="it" property="positionname" filter="true" />,<br><bean:write name="it" property="equipmentshortname" filter="true"/>
			</logic:present>
			</td>
			<td class="text">
				<logic:equal name="it" property="document.type" value="F"><bean:message key="label.inventory.type.full"/></logic:equal>
				<logic:equal name="it" property="document.type" value="A"><bean:message key="label.inventory.type.byunit"/></logic:equal>
				<logic:equal name="it" property="document.type" value="P"><bean:message key="label.inventory.type.byselect"/></logic:equal>
			</td>
			<td class="link">
				<html:link page="/EditInvState.do?action=Edit" paramId="doc" paramName="it" paramProperty="document.document" paramScope="page">
					<logic:equal name="it" property="document.documentState" value="1"><bean:message key="label.state.entering"/></logic:equal>
					<logic:equal name="it" property="document.documentState" value="2"><bean:message key="label.state.calculated"/></logic:equal>
				</html:link>
			</td>
			<td class="link">
				<html:link page="/ShowInvPosList.do" paramId="document" paramName="it" paramProperty="document.document" paramScope="page">
					<img src="/images/doc.gif" width=22 height=16 border=0>
				</html:link>
			</td>
			<td class="link">
				<logic:equal name="it" property="document.type" value="A">
					<july:docprintbutton docstatebean="it" docstateproperty="document.documentState" href="/crystalclear/invp.rpt?dll=pdsinvents.dll" paramId="prompt0" paramName="it" paramProperty="document.document" paramScope="page" alt="Напечатать акт инвентаризации" />
				</logic:equal>
				<logic:notEqual name="it" property="document.type" value="A">
					<july:docprintbutton docstatebean="it" docstateproperty="document.documentState" href="/crystalclear/inv.rpt?dll=pdsinvents.dll" paramId="prompt0" paramName="it" paramProperty="document.document" paramScope="page" alt="Напечатать акт инвентаризации" />
				</logic:notEqual><br>
				<logic:equal name="it" property="document.documentState" value="2">
					<july:docprintbutton docstatebean="it" docstateproperty="document.documentState" href="/crystalclear/misp.rpt?dll=pdsmis.dll" paramId="prompt0" paramName="it" paramProperty="document.document" paramScope="page" image="print_lose.gif" alt="Напечатать перечень недостач" />
					<july:docprintbutton docstatebean="it" docstateproperty="document.documentState" href="/crystalclear/extrap.rpt?dll=pdsextra.dll" paramId="prompt0" paramName="it" paramProperty="document.document" paramScope="page"image="print_plus.gif" alt="Напечатать перечень излишков" />
				</logic:equal>
			</td>
			<td class="link">
				<logic:equal name="it" property="document.documentState" value="1"><july:delbutton page="/EditInv.do?action=Delete" paramId="document" paramName="it" paramProperty="document.document" paramScope="page"/></logic:equal>
			</td>
		</tr>

		<july:separator colspan="<%= gColSpan %>" />

	</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons"><july:addbutton page="/EditInv.do?action=Add" alttext="label.inventory.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
      
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<july:currmark><bean:message key="label.inventorypositions"/></july:currmark>
	</td>
</tr>
		
</table>

</july:browseform>
