<%@ page language = "java" %>
<%@ page import="com.hps.july.basestation.valueobject.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "9"; %>

<july:browseform action="/ShowControllerLookupList.do" styleId="contLook">
<%--
0: Controller number
1: Controller name
2: Controller position name
3: Controller state
4: Controller code
5: Switch code
6: Switch number
7: Switch name
8: Switch position name
--%>
<july:lookupresult tableId="brtable" resultCols="0;1;2;4;5;6;8"/>

<table class="main">
<TR class="title">
 <TD class="title">
    <bean:message key="label.choose.controller"/>
 </TD>
</TR>
<TR class="normal">
 <TD>
    <table class="find">
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
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
		<july:headercolumn key="label.controller.number" colType="number"/>
		<july:headercolumn key="label.name" colType="string"/>
		<july:headercolumn key="label.equipment.posname" colType="string"/>
		<july:headercolumn key="label.switch.constructionstate" colType="string"/>
		<td style="visibility:hidden;display:none;"></td>
		<%-- Switch fields --%>
		<td style="visibility:hidden;display:none;">code</td>
		<td style="visibility:hidden;display:none;">number</td>
		<td style="visibility:hidden;display:none;">name</td>
		<td style="visibility:hidden;display:none;">posname</td>
        </tr>
        <!-- Table body -->
        <logic:iterate id="cont" name="browseList" indexId="index" type="com.hps.july.cdbc.lib.CDBCRowObject">
	<logic:present name="cont">
	<%
		String equstate = cont.getColumn("equstate").asString();
		if(equstate != null && !"".equals(equstate)) {
			equstate = equstate.toLowerCase();
		} else {
			equstate = "unknown";
		}
		boolean hasSwitch = cont.getColumn("swcode").asObject() != null;
	%>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="number"><july:stringwrite name="cont" property="contrnumber"/></td>
		<td class="text"><july:lookupreturn><july:stringwrite name="cont" property="contrname"/></july:lookupreturn></td>
		<td class="text"><july:stringwrite name="cont" property="contrposname"/></td>
		<td class="text"><bean:message key='<%="label.equipment.state"+equstate%>'/></td>
		<td style="visibility:hidden;display:none;"><july:stringwrite name="cont" property="contrcode"/></td>
		<%-- Switch fields --%>
		<td style="visibility:hidden;display:none;"><july:stringwrite name="cont" property="swcode"/></td>
		<td style="visibility:hidden;display:none;"><july:stringwrite name="cont" property="swnumber"/></td>
		<td style="visibility:hidden;display:none;"><july:stringwrite name="cont" property="swname"/></td>
		<td style="visibility:hidden;display:none;"><july:stringwrite name="cont" property="swposname"/></td>
	</tr>
	</logic:present>
	<logic:notPresent name="cont">
	<tr class="normal">
		<td class="text" colspan="<%= gColSpan %>"><bean:message key="label.norecords"/></td>
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

