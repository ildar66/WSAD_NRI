<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "12"; %>

<july:browseform action="/ShowInvPosList.do">

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowPositionInventoryList.do" styleClass="navigator"><bean:message key="label.inventorypositions"/></html:link>
       <july:sepmark/> 
       <july:currmark><bean:message key="label.invpos"/></july:currmark>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<html:hidden property="readonly"/>

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.invpos.act"/>:</td>
	   <td class="title"><bean:message key="label.num"/>&nbsp;<bean:write name="InvPosListForm" property="blankindex" />&nbsp;<bean:write name="InvPosListForm" property="blanknumber" />&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="InvPosListForm" property="blankdatestr" /></td>
     </tr>        
    <TR>
       <td class="title"><bean:message key="label.invpos.org"/>:</td>
       <td class="title"><bean:write name="InvPosListForm" property="ownername" /></td>
     </tr>        
    <TR>
       <td class="title"><bean:message key="label.inventory.position"/>:</td>
       <td class="title"><bean:write name="InvPosListForm" property="positionname" /></td>
     </tr>        
    <tr>
		<td class="title"><bean:message key="label.inventory.complect"/>:</td>
		<td class="title"><bean:write name="InvPosListForm" property="complectname" /></td>
	</tr>        
	<tr>
		<td class="title"><bean:message key="label.invpos.type"/>:</td>
		<td class="title">
			<logic:equal name="InvPosListForm" property="type" value="F"><bean:message key="label.inventory.type.full"/></logic:equal>
			<logic:equal name="InvPosListForm" property="type" value="A"><bean:message key="label.inventory.type.byunit"/></logic:equal>
			<logic:equal name="InvPosListForm" property="type" value="P"><bean:message key="label.inventory.type.byselect"/></logic:equal>
		</td>
	</tr>
	<logic:equal name="InvPosListForm" property="type" value="A">
	<tr>
		<td class="title"><bean:message key="label.invpos.agregate"/>:</td>
		<td class="text">
			<bean:write name="InvPosListForm" property="agregatemodel"/>,&nbsp;<bean:write name="InvPosListForm" property="agregatename"/>
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
				<logic:equal name="InvPosListForm" property="readonly" value="false"><july:addbutton page="/EditInvPos.do?action=Add" alttext="label.invpos.add"/></logic:equal>
				<logic:equal name="InvPosListForm" property="readonly" value="false"><html:link page="/InvLoadExcel.do?action=Add" paramId="doc" paramName="InvPosListForm" paramProperty="document" paramScope="session"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link></logic:equal><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'>
				<logic:equal name="InvPosListForm" property="readonly" value="false"><html:link page="/InvFillFromDB.do?action=Add" paramId="doc" paramName="InvPosListForm" paramProperty="document" paramScope="session"><img src="/images/loaddb.gif" border="0" alt="Создать позиции по состоянию базы данных"></html:link><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'></logic:equal>
				<logic:equal name="InvPosListForm" property="readonly" value="false"><logic:equal name="InvPosListForm" property="type" value="A"><html:link page="/InvLoadInv.do?action=Add" paramId="doc" paramName="InvPosListForm" paramProperty="document" paramScope="session"><img src="/images/loadinv.gif" border="0" alt="Создать позиции из INV файла"></html:link><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'></logic:equal></logic:equal>
				<july:backbutton page="/ShowPositionInventoryList.do"/>
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
	<logic:equal name="InvPosListForm" property="readonly" value="false"><td class="title">&nbsp;</td></logic:equal>
	<july:headercolumn key="label.name" colType="string"/>
	<july:headercolumn key="label.invpos.serialnum" colType="string"/>
	<july:headercolumn key="label.invpos.qty" colType="string"/>
	<july:headercolumn key="label.invpos.unit" colType="string"/>
	<july:headercolumn key="label.invpos.price" colType="number"/>
	<july:headercolumn key="label.invpos.sum" colType="number"/>
	<july:headercolumn key="label.invpos.xplace" colType="number"/>
<%--
	<july:headercolumn key="label.invpos.app" colType="string"/>
	<july:headercolumn key="label.invpos.appserialnum" colType="number"/>
--%>
	<logic:equal name="InvPosListForm" property="readonly" value="false"><TD class="title">&nbsp;</TD></logic:equal>
</tr>

<july:separator colspan="<%= gColSpan %>" />
    
<!-- Table body -->
<logic:iterate id="it" name="browseList">
	<logic:present name="it">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="link">
				<logic:equal name="InvPosListForm" property="readonly" value="false">
					<july:editbutton page="/EditInvPos.do" action="Edit" paramId="docposition" paramName="it" paramProperty="o.docposition" paramScope="page" alttext="label.invpos.edit"/>
				</logic:equal>
				<logic:equal name="InvPosListForm" property="readonly" value="true">
					<july:editbutton page="/EditInvPos.do" action="View" paramId="docposition" paramName="it" paramProperty="o.docposition" paramScope="page" alttext="label.invpos.view"/>
				</logic:equal>
			</td>
			<td class="number">
				<bean:write name="it" property="o.order" filter="true"/>
			</td>
			<logic:equal name="InvPosListForm" property="readonly" value="false">
			<td class="link">
				<html:link page="/EditInvPos.do?action=Add" paramId="copydocpos" paramName="it" paramProperty="o.docposition" paramScope="page">
				<bean:message key="label.invpos.copy"/>
				</html:link>
			</td>
			</logic:equal>
			<td class="text">
				<logic:present name="it" property="o.resource">
					<bean:write name="it" property="o.resource.name" filter="true"/><logic:present name="it" property="o.resource.model">,<br><bean:write name="it" property="o.resource.model" filter="true"/></logic:present><logic:present name="it" property="o.configuration">,<br><bean:write name="it" property="o.configuration" filter="true"/></logic:present>
				</logic:present>
			</td>
			<td class="text">
				<bean:write name="it" property="serialnumber" filter="true"/>
			</td>
			<td class="text">
				<july:numberwrite name="it" property="o.qty"/>
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
			<td class="text">
				<logic:present name="it" property="newplace">
					<bean:write name="it" property="newplace" filter="true"/>
				</logic:present>
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
				<logic:equal name="InvPosListForm" property="readonly" value="false">
                <td class="link">
                    <july:delbutton page="/EditInvPos.do?action=Delete" paramId="docposition" paramName="it" paramProperty="o.docposition" paramScope="page" />
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
				<logic:equal name="InvPosListForm" property="readonly" value="false"><july:addbutton page="/EditInvPos.do?action=Add" alttext="label.invpos.add"/></logic:equal>
				<logic:equal name="InvPosListForm" property="readonly" value="false"><html:link page="/InvLoadExcel.do?action=Add" paramId="doc" paramName="InvPosListForm" paramProperty="document" paramScope="session"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link></logic:equal><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'>
				<logic:equal name="InvPosListForm" property="readonly" value="false"><html:link page="/InvFillFromDB.do?action=Add" paramId="doc" paramName="InvPosListForm" paramProperty="document" paramScope="session"><img src="/images/loaddb.gif" border="0" alt="Создать позиции по состоянию базы данных"></html:link><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'></logic:equal>
				<logic:equal name="InvPosListForm" property="readonly" value="false"><logic:equal name="InvPosListForm" property="type" value="A"><html:link page="/InvLoadInv.do?action=Add" paramId="doc" paramName="InvPosListForm" paramProperty="document" paramScope="session"><img src="/images/loadinv.gif" border="0" alt="Создать позиции из INV файла"></html:link><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'></logic:equal></logic:equal>
				<july:backbutton page="/ShowPositionInventoryList.do"/>
			</td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowInvList.do" styleClass="navigator"><bean:message key="label.inventorypositions"/></html:link>
		<july:sepmark/> 
		<july:currmark><bean:message key="label.invpos"/></july:currmark>
	</td>
</tr>
		
    </table>

</july:browseform>
