<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.inventory.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "11"; %>

<%
	int state = ParamsParser.getState( pageContext );
	String action = null;
	String formName = null;
	String backName = null;
	String backTitle = null;
	String editForm = null;
	switch( state )
	{
	case APPStates.IRSLIST:
		action = "/ShowI13nRessetList.do";
		formName = "I13nRessetListForm";
		backName = "/ShowInvList.do";
		backTitle = "label.inventorypositions";
		editForm = "/EditI13nResset.do";
		break;
	case APPStates.IRASLIST:
		action = "/ShowI13nActRessetList.do";
		formName = "I13nActRessetListForm";
		backName = "/ShowInvActList.do";
		backTitle = "label.inventoryacts";
		editForm = "/EditI13nActResset.do";
		break;
	}
%>

<july:browseform action="<%=action%>">

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="<%=backName%>" styleClass="navigator"><bean:message key="<%=backTitle%>"/></html:link>
		<july:sepmark/> 
		<july:currmark><bean:message key="label.resset"/></july:currmark>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
	<tr>
		<td class="title"><bean:message key="label.resset.act"/>:</td>
		<td class="title"><bean:message key="label.num"/>&nbsp;<bean:write name="<%=formName%>" property="blankindex" />&nbsp;<bean:write name="<%=formName%>" property="blanknumber" />&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="<%=formName%>" property="blankdatestr" /></td>
	</tr>        
	<tr>
		<td class="title"><bean:message key="label.resset.org"/>:</td>
		<td class="title"><bean:write name="<%=formName%>" property="ownername" /></td>
	</tr>
<%--
	<tr>
		<td class="title"><bean:message key="label.resset.position"/>:</td>
		<td class="title"><bean:write name="<%=formName%>" property="positionname" /></td>
	</tr>
--%>
	<tr>
		<td class="title"><bean:message key="label.resset.complect"/>:</td>
		<td class="title"><bean:write name="<%=formName%>" property="complectname" /></td>
	</tr>        
	<tr>
		<td class="title"><bean:message key="label.resset.type"/>:</td>
		<td class="title">
			<logic:equal name="<%=formName%>" property="type" value="F"><bean:message key="label.inventory.type.full"/></logic:equal>
			<logic:equal name="<%=formName%>" property="type" value="A"><bean:message key="label.inventory.type.byunit"/></logic:equal>
			<logic:equal name="<%=formName%>" property="type" value="P"><bean:message key="label.inventory.type.byselect"/></logic:equal>
		</td>
	</tr>        
	</table>
  </td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons">
				<logic:equal name="<%=formName%>" property="readonly" value="false"><july:addbutton page='<%=editForm+"?action=Add"%>' /></logic:equal>
				<logic:equal name="<%=formName%>" property="readonly" value="true">&nbsp;</logic:equal>
				<july:backbutton page="<%=backName%>"/>
			</td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
      
<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.void" colType="string"/>
	<july:headercolumn key="label.resset.name" colType="string"/>
	<july:headercolumn key="label.resset.model" colType="string"/>
	<july:headercolumn key="label.resset.unit" colType="string"/>
	<july:headercolumn key="label.resset.policy" colType="string"/>
	<logic:equal name="<%=formName%>" property="readonly" value="false"><td class="title">&nbsp;</td></logic:equal>
</tr>

<july:separator colspan="<%= gColSpan %>" />
    
<!-- Table body -->
<logic:iterate id="it" name="browseList">
<logic:present name="it">
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="text">
			<logic:equal name="<%=formName%>" property="readonly" value="false">
				<july:editbutton page="<%=editForm%>" action="Edit" paramId="resourcecode" paramName="it" paramProperty="resource.resource" paramScope="page" />
			</logic:equal>
			<logic:equal name="<%=formName%>" property="readonly" value="true">
				<july:editbutton page="<%=editForm%>" action="View" paramId="resourcecode" paramName="it" paramProperty="resource.resource" paramScope="page" />
			</logic:equal>
		</td>
		<td class="text">
			<bean:write name="it" property="resource.name" filter="true"/>
		</td>
		<td class="text">
			<logic:present name="it" property="resource.model"><bean:write name="it" property="resource.model" filter="true"/></logic:present>
		</td>
		<td class="text">
			<bean:write name="it" property="resource.unit.shortname" filter="true"/>
		</td>
		<td class="text">
			<logic:equal name="it" property="resource.countpolicy" value="S"><bean:message key="label.resource.countpolicys"/></logic:equal>
			<logic:equal name="it" property="resource.countpolicy" value="P"><bean:message key="label.resource.countpolicyp"/></logic:equal>
			<logic:equal name="it" property="resource.countpolicy" value="B"><bean:message key="label.resource.countpolicyb"/></logic:equal>
		</td>
		<td class="link">
			<logic:equal name="<%=formName%>" property="readonly" value="false">
				<july:delbutton page='<%=editForm+"?action=Delete"%>' paramId="resourcecode" paramName="it" paramProperty="resource.resource" paramScope="page" />
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
			<td class="buttons">
				<logic:equal name="<%=formName%>" property="readonly" value="false"><july:addbutton page='<%=editForm+"?action=Add"%>'  /></logic:equal>
				<logic:equal name="<%=formName%>" property="readonly" value="true">&nbsp;</logic:equal>
				<july:backbutton page="<%=backName%>"/>
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
      
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="<%=backName%>" styleClass="navigator"><bean:message key="<%=backTitle%>"/></html:link>
		<july:sepmark/> 
		<july:currmark><bean:message key="label.resset"/></july:currmark>
	</td>
</tr>
		
</table>

</july:browseform>
