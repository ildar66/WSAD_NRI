<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "7"; %>

<july:browseform action="/ShowReqPositionList.do" styleId="ReqPositionListForm">

<bean:define id="docCode" name="ReqPositionListForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowReqList.do" styleClass="navigator"><bean:message key="label.req"/></html:link>
		<july:sepmark/> 
		<july:currmark><bean:message key="label.reqpos"/></july:currmark>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
    <table class="find">
	<tr>
		<td class="title"><bean:message key="label.reqpos.document"/></td>
		<td class="title">
			<bean:message key="label.num"/>&nbsp;<bean:write name="ReqPositionListForm" property="blankindex"/>&nbsp;<bean:write name="ReqPositionListForm" property="blanknumber"/>&nbsp;<bean:message key="label.from"/>&nbsp;<july:datewrite name="ReqPositionListForm" property="blankdate"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.reqpos.owner"/></td>
		<td class="title">
			<bean:write name="ReqPositionListForm" property="ownername"/>
		</td>
	</tr>
<logic:equal name="ReqPositionListForm" property="type" value="P">
	<tr>
		<td class="title"><bean:message key="label.reqpos.organization"/></td>
		<td class="title">
			<bean:write name="ReqPositionListForm" property="organizationname"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.reqpos.insurance"/></td>
		<td class="title">
			<bean:write name="ReqPositionListForm" property="insuranseMan"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.reqpos.nauto"/></td>
		<td class="title">
			<bean:write name="ReqPositionListForm" property="NAvto"/>
		</td>
	</tr>
</logic:equal>
<logic:equal name="ReqPositionListForm" property="type" value="W">
	<tr>
		<td class="title"><bean:message key="label.reqpos.worker"/></td>
		<td class="title">
			<bean:write name="ReqPositionListForm" property="workername"/>
		</td>
	</tr>
</logic:equal>
	<tr>
		<td class="title"><bean:message key="label.reqpos.position"/></td>
		<td class="title">
			<%--<bean:write name="ReqPositionListForm" property="positionid"/>&nbsp;--%><bean:write name="ReqPositionListForm" property="positionname"/>
		</td>
	</tr>
    </table>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons">
				<logic:equal name="ReqPositionListForm" property="readonly" value="false"><july:addbutton page="/EditReqPosition.do?action=Add" alttext="label.reqpos.add"/></logic:equal>
				<logic:equal name="ReqPositionListForm" property="readonly" value="true">&nbsp;</logic:equal>
				<july:backbutton page="/ShowReqList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<td class="title" rowspan="2"><bean:message key="label.void"/></td>
	<td class="title" rowspan="2"><bean:message key="label.num"/></td>
	<td class="title" rowspan="2"><bean:message key="label.reqpos.resource"/></td>
	<td class="title" colspan="2"><bean:message key="label.reqpos.qtytitle"/></td>
	<td class="title" rowspan="2"><bean:message key="label.reqpos.note"/></td>
	<td class="title" rowspan="2"><bean:message key="label.void"/></td>
</tr>
<tr class="title">
	<td class="title"><bean:message key="label.reqpos.req"/></td>
	<td class="title"><bean:message key="label.reqpos.send"/></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="it" name="browseList">
	<logic:present name="it">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="string">
				<logic:equal name="ReqPositionListForm" property="readonly" value="false">
					<july:editbutton page="/EditReqPosition.do" action="Edit" paramId="docposition" paramName="it" paramProperty="so.docposition" paramScope="page" alttext="label.reqpos.edit"/>
				</logic:equal>
<%--
				<logic:equal name="ReqPositionListForm" property="readonly" value="true">
					<july:editbutton page="/EditReqPosition.do" action="View" paramId="docposition" paramName="it" paramProperty="so.docposition" paramScope="page" alttext="label.reqpos.view"/>
				</logic:equal>
--%>
			</td>
			<td class="text">
				<bean:write name="it" property="so.order" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="so.resource.name" filter="true"/><logic:present name="it" property="so.resource.model">,<br><bean:write name="it" property="so.resource.model" filter="true"/></logic:present>
			</td>
			<td class="text">
				<july:numberwrite name="it" property="so.qty" />
			</td>
			<td class="text">
				<logic:present name="it" property="sendqty">
				<july:numberwrite name="it" property="sendqty" />
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="so.notes">
				<bean:write name="it" property="so.notes" filter="true"/>
				</logic:present>
			</td>
			<td class="link">
				<logic:equal name="ReqPositionListForm" property="readonly" value="false">
					<july:delbutton page="/EditReqPosition.do?action=Delete" paramId="docposition" paramName="it" paramProperty="so.docposition" paramScope="page" />
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
				<logic:equal name="ReqPositionListForm" property="readonly" value="false"><july:addbutton page="/EditReqPosition.do?action=Add" alttext="label.reqpos.add"/></logic:equal>
				<logic:equal name="ReqPositionListForm" property="readonly" value="true">&nbsp;</logic:equal>
				<july:backbutton page="/ShowReqList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />
      
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowReqList.do" styleClass="navigator"><bean:message key="label.req"/></html:link>
		<july:sepmark/> 
		<july:currmark><bean:message key="label.reqpos"/></july:currmark>
	</td>
</tr>

</table>

</july:browseform>
