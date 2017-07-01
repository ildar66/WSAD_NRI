<%@ page language = "java" %>
<%@ page import="com.hps.july.sitedoc.valueobject.SiteDocObject"%>
<%@ page import="com.hps.july.siteinfo.valueobject.Position"%>
<%@ page import="org.apache.struts.util.RequestUtils"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<SCRIPT>
function checkAll(select , objId) {
    for (var i = 0; i < document.forms.length; i++) {
        for (var j = 0; j < document.forms[i].elements.length; j++) {
            if (document.forms[i].elements[j].id == objId) {
                document.forms[i].elements[j].checked = select;
            }
        }
    }
}
</SCRIPT>

<% //String gColSpan = "6";
	String gColSpan = String.valueOf(request.getAttribute("colspan"));
%>
<!-- Table header -->
<tr class="title">
	<july:sortcolumn bundle="siteinfoResources" key="label.position.gsmid" colType="string" ascFinder="5" descFinder="6" />
	<july:sortcolumn bundle="siteinfoResources" key="label.position.dampsid" colType="string" ascFinder="7" descFinder="8" />
	<july:sortcolumn bundle="siteinfoResources" key="label.position.name" colType="string" ascFinder="3" descFinder="4" />
	<july:headercolumn bundle="siteinfoResources" key="label.position.addr" colType="string"/>
	<td class="title"><input type=checkbox class=editcheckbox value='true' name='isAllPosition' id='isAllPositionId' onclick='checkAll(this.checked ,"isPositionId" )' /></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="pos" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="pos">
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="number"><july:stringwrite name="pos" property="gsmid"/></td>
	<td class="number"><july:stringwrite name="pos" property="dampsid"/></td>
	<td class="text"><july:stringwrite name="pos" property="posname"/></td>
	<td class="text"><july:stringwrite name="pos" property="posaddress"/></td>
	<td class="link"><input type=checkbox class=editcheckbox value='<%=pos.getColumn("storageplace").asString()%>' name='check_add' id='isPositionId'></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>

