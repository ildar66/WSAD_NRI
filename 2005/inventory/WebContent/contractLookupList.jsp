<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "8"; %>

<july:browseform action="/ShowContractLookupList.do" styleId="contractLookupListForm">

<july:lookupresult tableId="brtable" resultCols="0;1;2"/>

<script language="javascript">
function switchSupplytype() {
	if(ContractLookupListForm.alltypes[0].checked) {
		ContractLookupListForm.supplytype.className='editdisabled';
	} else {
		ContractLookupListForm.supplytype.className='editsearch';
	}
	ContractLookupListForm.supplytype.disabled=ContractLookupListForm.alltypes[0].checked;
}
</script>

<table class="main">
<TR class="title">
 <TD class="title">
    <bean:message key="label.choose.contract"/>
 </TD>
</TR>
<TR class="normal">
 <TD>
 
    <table class="find">
    <TR>
        <td class="title"><bean:message key="label.contract.supplytype"/></td>
        <td class="title" colspan="2" nowrap>
			<july:checkbox property="alltypes" insertable="true" updatable="true" value="true" onclick="switchSupplytype();"/><html:hidden property="alltypes" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:select collection="supplytypes" property="supplytype" insertable="true" updatable="false" style="width:350;" styleClass="editsearch">
				<html:options collection="supplytypes" property="supplyType" labelProperty="name"/>
			</july:select>
<script language="javascript">switchSupplytype();</script>
			<july:searchbutton />
		  </td>
     </tr>
<logic:equal name="ContractLookupListForm" property="allowner" value="false">
    <TR>
        <td class="title"><bean:message key="label.contract.organization"/></td>
        <td class="title" colspan="2" nowrap>
		<bean:write name="ContractLookupListForm" property="ownername" filter="true"/>
	  </td>
     </tr>        
</logic:equal>
<logic:equal name="ContractLookupListForm" property="allcontragent" value="false">
    <TR>
        <td class="title"><bean:message key="label.contract.contragent"/></td>
        <td class="title" colspan="2" nowrap>
		<bean:write name="ContractLookupListForm" property="contragentname" filter="true"/>
     </tr>
</logic:equal>
    <TR>
        <td class="title"><bean:message key="label.contract.contractname"/></td>
        <td class="title" colspan="2" nowrap>
			<july:string size="15" property="name" insertable="true" updatable="true" styleClass="editsearch"/>
	    </td>
     </tr>        
    </table>
    
  </TD>
</TR>

<tr class="title">
  <td><TABLE class="buttons">
    <TR class="title">
      <TD class="buttons"><july:closebutton page="/"/></TD>
      <TD class="navigator"><july:navigator/></TD>
    </TR>
    </TABLE></TD>
</tr>

<TR>
  <TD>

    <table class="main" id="brtable">

        <!-- Table header -->
        <tr class="title">
            <july:headercolumn key="label.code" colType="number"/>
<%--            <july:headercolumn key="label.num" colType="number"/> --%>
            <july:headercolumn key="label.contract.contractname" colType="string"/>
            <july:headercolumn key="label.contract.startdate" colType="string"/>
            <july:headercolumn key="label.contract.finishdate" colType="string"/>
            <july:headercolumn key="label.contract.base" colType="string"/>
            <july:headercolumn key="label.contract.contragent" colType="string"/>
            <july:headercolumn key="label.contract.state" colType="string"/>
        </tr>

        <!-- Table body -->
        <logic:iterate id="rtl" name="browseList" indexId="index">
	      <logic:present name="rtl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><bean:write name="rtl" property="document" filter="true"/></td>
                <td class="text">
                    <july:lookupreturn><bean:write name="rtl" property="name" filter="true"/> <bean:write name="rtl" property="blanknumber" filter="true"/></july:lookupreturn>
                </td>
                <td class="text">
                    <july:datewrite name="rtl" property="startDate" />
                </td>
                <td class="text">
                    <july:datewrite name="rtl" property="finishDate" />
                </td>
                <td class="text">
					<logic:present name="rtl" property="baseAgreement">
	                    <bean:write name="rtl" property="baseAgreement.name" filter="true"/>
					</logic:present>
                </td>
                <td class="text">
					<logic:present name="rtl" property="contragent">
	                    <bean:write name="rtl" property="contragent.name" filter="true"/>
					</logic:present>
                </td>
                <td class="text">
					<logic:equal name="rtl" property="contractState" value="E">
						<bean:message key="label.contract.state.executing" />
					</logic:equal>
					<logic:equal name="rtl" property="contractState" value="F">
						<bean:message key="label.contract.state.finished" />
					</logic:equal>
                </td>
            </tr>
			</logic:present>

			<logic:notPresent name="rtl">
            <tr class="normal">
                <td class="text" colspan="<%= gColSpan %>">
                   <bean:message key="label.norecords"/>
                </td>
            </tr>
			</logic:notPresent>
         
			<july:separator colspan="<%= gColSpan %>" />
        </logic:iterate>

    </table>
</TD>
</TR>

<tr class="title">
  <td><TABLE class="buttons">
    <TR class="title">
      <TD class="buttons"><july:closebutton page="/"/></TD>
      <TD class="navigator"><july:navigator/></TD>
    </TR>
    </TABLE></TD>
</tr>

</TABLE>

</july:browseform>
