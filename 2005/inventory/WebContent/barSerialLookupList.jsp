<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<july:browseform action="/ShowBarSerialLookupList.do" styleId="BarSerialLookupListForm">

<july:lookupresult tableId="brtable" resultCols="0;1"/>

<table class="main">
<TR class="title">
 <TD class="title">
    <bean:message key="label.choose.barserial"/>
 </TD>
</TR>
<TR class="normal">
 <TD>
 	<table class="find">
	<tr>
        <td><bean:message key="label.barserial.type"/>&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td><july:radio styleClass="editcheckbox" property="serparty" value="S" onclick="setFinder('findBySerialMaskOrderBySerialAsc');"
		   insertable="true" updatable="true" /><bean:message key="label.barserial.types"/></td>
        <td><july:radio styleClass="editcheckbox" property="serparty" value="P" onclick="setFinder('findByPartyMaskOrderByPartyAsc');"
		   insertable="true" updatable="true"/><bean:message key="label.barserial.typep"/></td>
	</tr>
	<tr>
        <td><bean:message key="label.barserial.serial"/></td>
        <td COLSPAN="2"><html:text styleClass="search" property="serial" size="15" /><july:searchbutton /></td>
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
            <july:headercolumn key="label.barserial.code" colType="string"/>
            <july:headercolumn key="label.barserial.name" colType="string"/>
        </tr>

        <!-- Table body -->
        <logic:iterate id="crd" name="browseList" indexId="index">
			<logic:present name="crd">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><july:lookupreturn><bean:write name="crd" property="serialnumber" filter="true"
				  /><bean:write name="crd" property="party" filter="true"/></july:lookupreturn></td>
                <td class="text">
                    <bean:write name="crd" property="resource.name" filter="true"/>&nbsp;
					<bean:write name="crd" property="resource.model" filter="true"/>&nbsp;
					<bean:write name="crd" property="configuration" filter="true"/>
                </td>
            </tr>
			</logic:present>

			<logic:notPresent name="crd">
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
