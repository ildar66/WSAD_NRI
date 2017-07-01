<%@ page language = "java" %>
<%@ page import="com.hps.july.persistence.*,com.hps.july.jdbcpersistence.lib.DebugSupport"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.SearchConstants"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.RegionObject"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% 
	java.lang.String gColSpan = "4";
	request.setAttribute("colspan",gColSpan);
%>

<july:browseform action="/ShowRegionList.do" styleId="RegionListForm">
<table class="main">
<july:separator colspan="<%= gColSpan %>" />

<script language="javascript">
function switchInput(itemname,controlname,check_disable) {
            if(!document.all.item(controlname).checked^check_disable) {
                    document.all.item(itemname).className = 'editdisabled';
                    document.all.item(itemname).disabled = true;
            } else {
                    document.all.item(itemname).className = 'editsearch';
                    document.all.item(itemname).disabled = false;
            }
}
</script>

<TR class="normal">
<TD colspan="<%= gColSpan %>">
	<table class="find">
	<tr>
		<td class="title" >
			<bean:message key="label.regionList.search.superRegion"/>
			&nbsp;
			<july:checkbox styleId="isAllSupRegions" property="isAllSuperRegions" insertable="true" updatable="true"  value="true" onclick="switchInput('superRegionCode','isAllSupRegions',true);"/>
			<bean:message key="label.search.all"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:select styleId="superRegionCode" collection="superRegions" property="superRegionCode" insertable="true" updatable="true"  >
				<html:options collection="superRegions" property="supregid" labelProperty="supregname"/>
			</july:select>
			<script language="javascript">switchInput('superRegionCode','isAllSupRegions',true);</script>
			<july:searchbutton/>
		</td>
	</tr>
     <tr>

	<td class="title">
		<bean:message key="label.regionList.search"/>
		<july:radio styleId="isAllNamesTrue" insertable="true" updatable="true" property="searchType" value="<%=SearchConstants.SEARCH_ALL%>" onclick="switchInput('name','isAllNamesTrue',true);"/>
		<bean:message key="label.search.all"/>&nbsp;
		<july:radio styleId="isAllNamesFalse" insertable="true" updatable="true" property="searchType" value="<%=SearchConstants.SEARCHBY_NAME%>" onclick="switchInput('name','isAllNamesTrue',true);"/>
		<bean:message key="label.regionList.search.name"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:string styleClass="editsearch" property="name" styleId="name" insertable="true" updatable="true"/>
		<script language="javascript">switchInput('name','isAllNamesTrue',true);</script>
       </td>
     </tr>

     </table>
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
          <td colspan="<%= gColSpan %>">
          <TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditRegion.do?action=Add"/><july:backbutton page="/main.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
          </TABLE></TD>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<%
RegionObject reg=null;
%>

<tr class="title">
	<td class="title">&nbsp;</td>
	<july:sortcolumn key="label.regionList.superRegion" colType="string" ascFinder='<%=RegionObject.ORDER_BY_SUPREGNAME_ASC+""%>' descFinder='<%=RegionObject.ORDER_BY_SUPREGNAME_DESC+""%>'/>
	<july:sortcolumn key="label.regionList.name" colType="string" ascFinder='<%=RegionObject.ORDER_BY_REGNAME_ASC+""%>' descFinder='<%=RegionObject.ORDER_BY_REGNAME_DESC+""%>'/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
        <!-- Table body -->
<logic:iterate id="sreg" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="sreg">
<%
	String rid = sreg.getColumn("regionid").asString();
	pageContext.setAttribute("regionid",rid);
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="link"><july:editbutton page="/EditRegion.do" action="Edit" paramId="regionid" paramName="regionid" paramScope="page"/></td>
	<td class="text"><july:stringwrite name="sreg" property="supregname"/></td>
        <td class="text"><july:stringwrite name="sreg" property="regname"/></td>
        <td class="link"><july:delbutton page="/EditRegion.do?action=Delete" paramId="regionid" paramName="regionid"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>
<tr class="title">
          <td colspan="<%= gColSpan %>">
          <TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditRegion.do?action=Add"/><july:backbutton page="/main.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
          </TABLE></TD>
</tr>

<july:separator colspan="<%= gColSpan %>" />

</table>

</july:browseform>



