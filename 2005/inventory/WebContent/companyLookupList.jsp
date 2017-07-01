<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<july:browseform action="/ShowCompanyLookupList.do">

<july:lookupresult tableId="brtable" resultCols="0;1"/>

<table class="main">
<TR class="title">
 <TD class="title">
    <bean:message key="label.choose.company"/>
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
            <july:headercolumn key="label.name" colType="string"/>
        </tr>

        <!-- Table body -->
        <logic:iterate id="comp" name="browseList" indexId="index">
			<logic:present name="comp">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><july:lookupreturn><bean:write name="comp" property="company" filter="true"/></july:lookupreturn></td>
                <td class="text">
                    <bean:write name="comp" property="name" filter="true"/>
                </td>
            </tr>
			</logic:present>

			<logic:notPresent name="comp">
            <tr class="normal">
                <td class="text" colspan="<%= gColSpan %>">
                   <bean:message key="label.norecords"/>
                </td>
            </tr>
			</logic:notPresent>

			<july:separator colspan="<%= gColSpan %>" />
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>">&nbsp;</td>
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

</TABLE>

</july:browseform>
