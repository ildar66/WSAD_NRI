<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.*" %>
<%!
private String addSector(String sectors, String s, com.hps.july.cdbc.lib.CDBCRowObject ro) {
	String r = sectors;
	if(ro.getColumn(s).asObject() != null) {
		if(sectors != null && sectors.length() > 0) { r = sectors + "," + ro.getColumn(s).asString(); }
		else { r = ro.getColumn(s).asString(); }
	}
	return r;
}
%>

<%
	java.lang.String gColSpan = "12";

	AfsPositionListForm lForm = (AfsPositionListForm)request.getSession().getAttribute("AfsPositionListForm");
%>

<july:browseform action="/ShowAfsPositionList.do" styleId="AfsPositionListForm">

<bean:define id="docCode" name="AfsPositionListForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>

<table class="main">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
    <table class="find">
	<tr>
		<td class="title"><bean:message key="label.afs.document"/>:</td>
		<td class="title">
			<bean:message key="label.num"/>&nbsp;<bean:write name="AfsPositionListForm" property="blankindex"/>&nbsp;<bean:write name="AfsPositionListForm" property="blanknumber"/>&nbsp;<bean:message key="label.from"/>&nbsp;<bean:write name="AfsPositionListForm" property="blankdatestr"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.afs.owner"/>:</td>
		<td class="title">
			<bean:write name="AfsPositionListForm" property="ownername"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.afs.position"/>:</td>
		<td class="title">
			<bean:write name="AfsPositionListForm" property="positionid"/> <bean:write name="AfsPositionListForm" property="positionname"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.afs.complect"/>:</td>
		<td class="title">
			<bean:write name="AfsPositionListForm" property="complectname"/>
		</td>
	</tr>
<logic:present name="AfsPositionListForm" property="type">
<logic:equal name="AfsPositionListForm" property="type" value="P">
	<tr>
		<td class="title"><bean:message key="label.afs.provider"/>:</td>
		<td class="title">
			<bean:write name="AfsPositionListForm" property="providername"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.afs.insuranceman"/>:</td>
		<td class="title">
			<bean:write name="AfsPositionListForm" property="insuranseMan"/>
		</td>
	</tr>
</logic:equal>
<logic:equal name="AfsPositionListForm" property="type" value="W">
	<tr>
		<td class="title"><bean:message key="label.afs.worker"/>:</td>
		<td class="title">
			<bean:write name="AfsPositionListForm" property="workername"/>
		</td>
	</tr>
</logic:equal>
</logic:present>
    </table>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons">
				<logic:equal name="AfsPositionListForm" property="readonly" value="false">
					<july:addbutton page="/EditAfsAPosition.do?action=Add" alttext="label.afspos.addant" image="plusantenna.gif"/>
					<july:addbutton page="/EditAfsPosition.do?action=Add" alttext="label.afspos.add"/>
				</logic:equal>
				<july:backbutton page="/ShowAfsList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<td class="title">&nbsp;</td>
	<july:headercolumn key="label.afs.numpp" colType="number"/>
	<july:headercolumn key="label.afsa.sector" colType="string"/>
	<july:headercolumn key="label.afs.antnum" colType="string"/>
	<july:headercolumn key="label.afs.name" colType="string"/>
	<july:headercolumn key="label.afs.qty.short" colType="string"/>
	<july:headercolumn key="label.afs.unit.short" colType="string"/>
	<july:headercolumn key="label.afs.anttype" colType="string"/>
	<july:headercolumn key="label.afs.antaz" colType="string"/>
	<july:headercolumn key="label.afs.antnakl" colType="string"/>
	<july:headercolumn key="label.afs.policynum" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />



<!-- Table body -->
<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	Object o = it.getColumn("docposition").asObject();
	int docpos = 0;
	if(o instanceof Number) { docpos = ((Number)o).intValue(); }
	String docpostype = it.getColumn("docpostype").asString();
	pageContext.setAttribute("docpos",new Integer(docpos));
	String sect = "";
	String sectA = "", sectB = "";
	if("A".equals(docpostype)) {
		sectA = addSector(sectA,"s_a",it);
		sectA = addSector(sectA,"s_b",it);
		sectA = addSector(sectA,"s_c",it);
		sectA = addSector(sectA,"s_d",it);
		sectA = addSector(sectA,"s_od",it);

		sectB = addSector(sectB,"s_e",it);
		sectB = addSector(sectB,"s_f",it);
		sectB = addSector(sectB,"s_g",it);
		sectB = addSector(sectB,"s_h",it);
		sectB = addSector(sectB,"s_o",it);
		if(sectA != null && sectA.length() > 0) {
			if(sectB != null && sectB.length() > 0) {
				sect = sectA+"/"+sectB;
			} else {
				sect = sectA;
			}
		} else {
			sect = sectB;
		}

	} else if("B".equals(docpostype)) {
		sectA = addSector(sectA,"s_a",it);
		sectA = addSector(sectA,"s_b",it);
		sectA = addSector(sectA,"s_c",it);
		sectA = addSector(sectA,"s_d",it);
		sectA = addSector(sectA,"s_e",it);
		sectA = addSector(sectA,"s_o",it);
		sect = sectA;
	}
	pageContext.setAttribute("sect",sect);
	String sn = it.getColumn("serialnumber").asString();
	String mf = it.getColumn("manufserial").asString();
	if(mf != null && mf.length() > 0 && !mf.equals(sn)) {
		sn += " ("+mf+")";
	}
	pageContext.setAttribute("snum",sn);
	java.util.Iterator ii = lForm.listCableItems(new Integer(docpos));
	pageContext.setAttribute("cableitems",ii);
%>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="string">
<%if("A".equals(docpostype) || "B".equals(docpostype)) {%>
		<logic:equal name="AfsPositionListForm" property="readonly" value="true">
			<july:editbutton page="/EditAfsAPosition.do" action="View" paramId="docpos" paramName="docpos" paramScope="page" alttext="label.afspos.view"/>
		</logic:equal>
		<logic:equal name="AfsPositionListForm" property="readonly" value="false">
			<july:editbutton page="/EditAfsAPosition.do" action="Edit" paramId="docpos" paramName="docpos" paramScope="page" alttext="label.afspos.edit"/>
		</logic:equal>
<%} else {%>
		<logic:equal name="AfsPositionListForm" property="readonly" value="true">
			<july:editbutton page="/EditAfsPosition.do" action="View" paramId="docpos" paramName="docpos" paramScope="page" alttext="label.afspos.view"/>
		</logic:equal>
		<logic:equal name="AfsPositionListForm" property="readonly" value="false">
			<july:editbutton page="/EditAfsPosition.do" action="Edit" paramId="docpos" paramName="docpos" paramScope="page" alttext="label.afspos.edit"/>
		</logic:equal>
<%}%>
		</td>
		<td class="number"><july:stringwrite name="it" property="order"/></td>
		<td class="text"><july:stringwrite name="sect"/></td>
		<td class="text"><july:stringwrite name="it" property="num_ant"/></td>
		<td class="text"><july:stringwrite name="it" property="antname"/></td>
		<td class="number" align=right><july:numberwrite name="it" property="qty"/></td>
		<td class="text"><july:stringwrite name="it" property="uname"/></td>
		<td class="text"><july:stringwrite name="it" property="kindant"/></td>
		<td class="number"><july:numberwrite name="it" property="az_ant"/></td>
		<td class="number"><july:numberwrite name="it" property="nakl"/></td>
		<td class="text"><july:stringwrite name="snum"/></td>
		<td class="link">
<%if("A".equals(docpostype) || "B".equals(docpostype)) {%>
			<logic:equal name="AfsPositionListForm" property="readonly" value="false">
				<july:delbutton page="/EditAfsAPosition.do?action=Delete" paramId="docpos" paramName="docpos" paramScope="page" />
			</logic:equal>
<%} else {%>
			<logic:equal name="AfsPositionListForm" property="readonly" value="false">
				<july:delbutton page="/EditAfsPosition.do?action=Delete" paramId="docpos" paramName="docpos" paramScope="page" />
			</logic:equal>
<%}%>
		</td>
	</tr>
	<logic:iterate id="cit" name="cableitems" type="com.hps.july.cdbc.lib.CDBCRowObject">
	<logic:present name="cit">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="string"></td>
			<td class="number"></td>
			<td class="text"></td>
			<td class="text"></td>
			<td class="text"><july:stringwrite name="cit" property="cablename"/></td>
			<td class="number" align=right><july:numberwrite name="cit" property="qty" /></td>
			<td class="text"><july:stringwrite name="it" property="uname"/></td>
			<td class="text"></td>
			<td class="number"></td>
			<td class="number"></td>
			<td class="text"></td>
			<td class="link"></td>
		</tr>
	</logic:present>
	</logic:iterate>
	<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons">
				<logic:equal name="AfsPositionListForm" property="readonly" value="false">
					<july:addbutton page="/EditAfsAPosition.do?action=Add" alttext="label.afspos.addant" image="plusantenna.gif"/>
					<july:addbutton page="/EditAfsPosition.do?action=Add" alttext="label.afspos.add"/>
				</logic:equal>
				<july:backbutton page="/ShowAfsList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

</table>

</july:browseform>
