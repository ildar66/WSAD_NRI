<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "12"; %>

<july:browseform action="/ShowInvActPosList.do">

<bean:define id="docCode" name="InvActPosListForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowInvActList.do" styleClass="navigator"><bean:message key="label.inventoryacts"/></html:link>
       <july:sepmark/> 
       <july:currmark><bean:message key="label.invpos"/></july:currmark></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="normal">
 <td colspan="<%= gColSpan %>">
 
    <table class="find">
    <tr>
       <td class="title"><bean:message key="label.invpos.act"/>:</td>
	   <td class="text"><bean:message key="label.num"/>&nbsp;<bean:write name="InvActPosListForm" property="blankindex"/>&nbsp;<bean:write name="InvActPosListForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="InvActPosListForm" property="blankdatestr" /></td>
    </tr>
    <tr>
       <td class="title"><bean:message key="label.invpos.org"/>:</td>
       <td class="text"><bean:write name="InvActPosListForm" property="ownername" /></td>
    </tr>
    <TR>
       <td class="title"><bean:message key="label.invpos.storage"/>:</td>
       <td class="text"><bean:write name="InvActPosListForm" property="storagename" /></td>
    </tr>
    <TR>
       <td class="title"><bean:message key="label.invpos.type"/>:</td>
       <td class="text">
			<logic:equal name="InvActPosListForm" property="type" value="F"><bean:message key="label.inventory.type.full"/></logic:equal>
			<logic:equal name="InvActPosListForm" property="type" value="A"><bean:message key="label.inventory.type.byunit"/></logic:equal>
			<logic:equal name="InvActPosListForm" property="type" value="P"><bean:message key="label.inventory.type.byselect"/></logic:equal>
       </td>
     </tr>
	<logic:equal name="InvActPosListForm" property="type" value="A">
	<tr>
		<td class="title"><bean:message key="label.invpos.agregate"/>:</td>
		<td class="text">
			<bean:write name="InvActPosListForm" property="agregatemodel"/>,&nbsp;<bean:write name="InvActPosListForm" property="agregatename"/>
		</td>
	</tr>
	</logic:equal>
     </table>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons">
				<logic:equal name="InvActPosListForm" property="readonly" value="false"><july:addbutton page="/EditInvActPos.do?action=Add"  alttext="label.invpos.add"/></logic:equal>
				<logic:equal name="InvActPosListForm" property="readonly" value="false"><html:link page="/InvActLoadExcel.do?action=Add" paramId="doc" paramName="InvActPosListForm" paramProperty="document" paramScope="session"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link></logic:equal><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'>
				<logic:equal name="InvActPosListForm" property="readonly" value="false"><html:link page="/InvActFillFromDB.do?action=Add" paramId="doc" paramName="InvActPosListForm" paramProperty="document" paramScope="session"><img src="/images/loaddb.gif" border="0" alt="Создать позиции по состоянию базы данных"></html:link><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'></logic:equal>
				<july:backbutton page="/ShowInvActList.do"/>
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
            <july:headercolumn key="label.invpos.num" colType="number"/>
			<logic:equal name="InvActPosListForm" property="readonly" value="false"><td class="title">&nbsp;</td></logic:equal>
            <july:headercolumn key="label.name" colType="string"/>
            <july:headercolumn key="label.invpos.serialnum" colType="string"/>
            <july:headercolumn key="label.invpos.qty" colType="string"/>
            <july:headercolumn key="label.invpos.unit" colType="string"/>
            <july:headercolumn key="label.invpos.price" colType="number"/>
            <july:headercolumn key="label.invpos.sum" colType="number"/>
<%--
            <july:headercolumn key="label.invpos.app" colType="string"/>
            <july:headercolumn key="label.invpos.appserialnum" colType="number"/>
--%>
            <logic:equal name="InvActPosListForm" property="readonly" value="false"><TD class="title">&nbsp;</TD></logic:equal>
        </tr>

		<july:separator colspan="<%= gColSpan %>" />
    
        <!-- Table body -->
        <logic:iterate id="it" name="browseList">
	      <logic:present name="it">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="link">
                    <logic:equal name="InvActPosListForm" property="readonly" value="false">
						<july:editbutton page="/EditInvActPos.do" action="Edit" paramId="docposition" paramName="it" paramProperty="o.docposition" paramScope="page" alttext="label.invpos.edit"/>
					</logic:equal>
                    <logic:equal name="InvActPosListForm" property="readonly" value="true">
						<july:editbutton page="/EditInvActPos.do" action="View" paramId="docposition" paramName="it" paramProperty="o.docposition" paramScope="page" alttext="label.invpos.view"/>
					</logic:equal>
				</td>
                <td class="number">
                      <bean:write name="it" property="o.order" filter="true"/>
                </td>
				<logic:equal name="InvActPosListForm" property="readonly" value="false">
				<td class="link">
					<html:link page="/EditInvActPos.do?action=Add" paramId="copydocpos" paramName="it" paramProperty="o.docposition" paramScope="page">
						<bean:message key="label.invpos.copy"/>
					</html:link>
				</td>
				</logic:equal>
                <td class="text">
					<bean:write name="it" property="o.resource.name" filter="true"/><logic:present name="it" property="o.resource.model">,<br><bean:write name="it" property="o.resource.model" filter="true"/></logic:present><logic:present name="it" property="o.configuration">,<br><bean:write name="it" property="o.configuration" filter="true"/></logic:present>
                </td>
                <td class="text">
                    <bean:write name="it" property="serialnumber" filter="true"/>
                </td>
                <td class="text">
                    <july:numberwrite name="it" property="o.qty" />
                </td>
                <td class="text">
					<logic:present name="it" property="o.resource.unit">
	                    <bean:write name="it" property="o.resource.unit.shortname" filter="true"/>
					</logic:present>
                </td>
                <td class="text">
                    <bean:write name="it" property="o.price" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="it" property="o.sum" filter="true"/>
                </td>
<%--
                <td class="text">
					<logic:present name="it" property="o.agregate">
	                    <bean:write name="it" property="o.agregate.resource.name" filter="true"/>
					</logic:present>
                </td>
                <td class="text">
					<logic:present name="it" property="o.agregate">
	                    <bean:write name="it" property="o.agregate.serialnumber" filter="true"/>
					</logic:present>
                </td>
--%>
			<logic:equal name="InvActPosListForm" property="readonly" value="false">
            <td class="link">
				<july:delbutton page="/EditInvActPos.do?action=Delete" paramId="docposition" paramName="it" paramProperty="o.docposition" paramScope="page" />
			</td>
			</logic:equal>
		</tr>

		<july:separator colspan="<%= gColSpan %>" />

		</logic:present>
	</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons">
				<logic:equal name="InvActPosListForm" property="readonly" value="false"><july:addbutton page="/EditInvActPos.do?action=Add" alttext="label.invpos.add"/></logic:equal>
				<logic:equal name="InvActPosListForm" property="readonly" value="false"><html:link page="/InvActLoadExcel.do?action=Add" paramId="doc" paramName="InvActPosListForm" paramProperty="document" paramScope="session"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link></logic:equal><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'>
				<logic:equal name="InvActPosListForm" property="readonly" value="false"><html:link page="/InvActFillFromDB.do?action=Add" paramId="doc" paramName="InvActPosListForm" paramProperty="document" paramScope="session"><img src="/images/loaddb.gif" border="0" alt="Создать позиции по состоянию базы данных"></html:link><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'></logic:equal>
				<july:backbutton page="/ShowInvActList.do"/>
			</td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
      
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowInvActList.do" styleClass="navigator"><bean:message key="label.inventoryacts"/></html:link>
	   	<july:sepmark/> 
		<july:currmark><bean:message key="label.invpos"/></july:currmark>
	</td>
</tr>
	
</table>

</july:browseform>
