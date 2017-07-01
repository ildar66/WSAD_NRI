<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "9"; %>
<%
	com.hps.july.jdbcpersistence.lib.TimeCounter ts = new com.hps.july.jdbcpersistence.lib.TimeCounter("PERF.INVENTORY.AssemblingPPositionList");
	ts.start();
%>

<july:browseform action="/ShowAssemblingPPositionList.do" styleId="AssemblingPPositionListForm">

<table class="main">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
    <table class="find">
	<tr>
		<td class="title"><bean:message key="label.assemblingp.document"/>:</td>
		<td class="title">
			<bean:message key="label.num"/>&nbsp;<bean:write name="AssemblingPPositionListForm" property="blankindex"/>&nbsp;<bean:write name="AssemblingPPositionListForm" property="blanknumber"/>&nbsp;<bean:message key="label.from"/>&nbsp;<bean:write name="AssemblingPPositionListForm" property="blankdatestr"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.assemblingp.owner"/>:</td>
		<td class="title">
			<bean:write name="AssemblingPPositionListForm" property="ownername"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.assemblingp.position"/>:</td>
		<td class="title">
			<bean:write name="AssemblingPPositionListForm" property="positionname"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.assemblingp.complect"/>:</td>
		<td class="title">
			<bean:write name="AssemblingPPositionListForm" property="complectname"/>
		</td>
	</tr>
<logic:present name="AssemblingPPositionListForm" property="type">
<logic:equal name="AssemblingPPositionListForm" property="type" value="P">
	<tr>
		<td class="title"><bean:message key="label.assemblingp.provider"/>:</td>
		<td class="title">
			<bean:write name="AssemblingPPositionListForm" property="providername"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.assemblingp.insuranceman"/>:</td>
		<td class="title">
			<bean:write name="AssemblingPPositionListForm" property="insuranseMan"/>
		</td>
	</tr>
</logic:equal>
<logic:equal name="AssemblingPPositionListForm" property="type" value="W">
	<tr>
		<td class="title"><bean:message key="label.assemblingp.worker"/>:</td>
		<td class="title">
			<bean:write name="AssemblingPPositionListForm" property="workername"/>
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
				<logic:equal name="AssemblingPPositionListForm" property="readonly" value="false"><july:addbutton page="/EditAssemblingPPosition.do?action=Add" alttext="label.assactpos.add"/></logic:equal>
				<july:backbutton page="/ShowAssemblingPList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<td class="title">&nbsp;</td>
	<july:headercolumn key="label.assemblingp.numpp" colType="number"/>
	<july:headercolumn key="label.assemblingp.name" colType="string"/>
	<july:headercolumn key="label.assemblingp.qty.short" colType="string"/>
	<july:headercolumn key="label.assemblingp.unit.short" colType="string"/>
	<july:headercolumn key="label.assemblingp.price" colType="string"/>
	<july:headercolumn key="label.assemblingp.sum" colType="string"/>
	<july:headercolumn key="label.assemblingp.policynum" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="it" name="browseList">
	<logic:present name="it">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="string">
				<logic:equal name="AssemblingPPositionListForm" property="readonly" value="false">
		                    <logic:notPresent name="it" property="agregate">
					<july:editbutton page="/EditAssemblingPPosition.do" action="Edit" paramId="docpos" paramName="it" paramProperty="docposition" paramScope="page" alttext="label.assactpos.edit"/>
				    </logic:notPresent>
				</logic:equal>
				<logic:equal name="AssemblingPPositionListForm" property="readonly" value="true">
					<july:editbutton page="/EditAssemblingPPosition.do" action="View" paramId="docpos" paramName="it" paramProperty="docposition" paramScope="page" alttext="label.assactpos.view"/>
				</logic:equal>
			</td>
			<td class="number">
				<bean:write name="it" property="order" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="resource.name" filter="true"/><logic:present name="it" property="resource.model">,<br><bean:write name="it" property="resource.model" filter="true"/></logic:present><logic:present name="it" property="configuration">,<br><bean:write name="it" property="configuration" filter="true"/></logic:present>
			</td>
			<td class="text">
				<july:numberwrite name="it" property="qty" />
			</td>
			<td class="text">
				<logic:present name="it" property="resource.unit">
					<bean:write name="it" property="resource.unit.shortname" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<bean:write name="it" property="price" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="sum" filter="true"/>
			</td>
			<td class="text">
				<logic:equal name="it" property="resource.countpolicy" value="S">
					<bean:write name="it" property="serialnumber" filter="true"/>
					<logic:present name="it" property="manufserial">
					<july:notEqual nameleft="it" propertyleft="serialnumber" nameright="it" propertyright="manufserial">
						&nbsp;(<bean:write name="it" property="manufserial" filter="true"/>)
					</july:notEqual>
					</logic:present>
				</logic:equal>
				<logic:equal name="it" property="resource.countpolicy" value="P">
					<bean:write name="it" property="party" filter="true"/>
				</logic:equal>
			</td>
			<td class="link">
				<logic:equal name="AssemblingPPositionListForm" property="readonly" value="false">
		                    <logic:notPresent name="it" property="agregate">
					<july:delbutton page="/EditAssemblingPPosition.do?action=Delete" paramId="docpos" paramName="it" paramProperty="docposition" paramScope="page" />
				    </logic:notPresent>
				</logic:equal>
			</td>
		</tr>

		<july:separator colspan="<%= gColSpan %>" />

	</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons">
				<logic:equal name="AssemblingPPositionListForm" property="readonly" value="false"><july:addbutton page="/EditAssemblingPPosition.do?action=Add" alttext="label.assactpos.add"/></logic:equal>
				<july:backbutton page="/ShowAssemblingPList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />
 
</table>

</july:browseform>
<%
	ts.finish("JSP");
%>
