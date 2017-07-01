<%@ page language="java" %>
<%@ page import="com.hps.july.sitedoc.valueobject.SiteDocObject"%>
<%@ page import="com.hps.july.sitedoc.valueobject.ComlineObject"%>
<%@ page import="org.apache.struts.util.RequestUtils"%>
<%@ page import="com.hps.july.sitedoc.valueobject.EquipmentObject"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<script>
function checkAll(select, groupId){
   for(var i=0; i< document.all.item(groupId).length; i++){
              document.all.item(groupId)[i].checked=select;
   }
}
</script>

<%
String gColSpan = request.getAttribute("colspan")+"";
%>
<!-- Table header -->
<tr class="title">
	<july:headercolumn  key="ComlineList.table.code" colType="string"/>
	<july:headercolumn  key="ComlineList.table.number1" colType="string"/>
	<july:headercolumn  key="ComlineList.table.position1" colType="string"/>
	<td></td>
	<july:headercolumn  key="ComlineList.table.number2" colType="string"/>
	<july:headercolumn  key="ComlineList.table.position2" colType="string"/>
	<july:headercolumn  key="ComlineList.table.type" colType="string"/>
	<july:headercolumn  key="ComlineList.table.resource" colType="string"/>
	<july:headercolumn  key="ComlineForm.hopstate.short" colType="string"/>
	<td class="title"><input type=checkbox class=editcheckbox value='true' name='isAllComline' id='isAllComline' onclick='checkAll(this.checked ,"isComlineId" )' /></td>
<%--
	<july:headercolumn key="SiteDocEquipmentList.table.type" colType="string"/>
	<july:sortcolumn key="SiteDocEquipmentList.table.number" colType="string" ascFinder="1" descFinder="2" />
	<july:sortcolumn key="SiteDocEquipmentList.table.name" colType="string" ascFinder="3" descFinder="4" />
	<july:headercolumn key="SiteDocEquipmentList.table.position" colType="string"/>
	<july:headercolumn key="SiteDocEquipmentList.table.address" colType="string"/>
--%>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="obj" name="browseList">
<logic:present name="obj">
<%
	ComlineObject ob=(ComlineObject)obj;
	String state = "ComlineList.state.C";
	if(ob.getHopstate() != null && !"".equals(ob.getHopstate())) {
		state = "ComlineList.state."+ob.getHopstate();
	}
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="text">
		<bean:write name="obj" property="prolet" filter="true"/>
	</td>
	<td class="text">
		<bean:write name="obj" property="number" filter="true"/>
	</td>
	<td class="text">
		<bean:write name="obj" property="name" filter="true"/>
	</td>
	<td class="text">-</td>
	<td class="text">
		<bean:write name="obj" property="number2" filter="true"/>
	</td>
	<td class="text">
		<bean:write name="obj" property="name2" filter="true"/>
	</td>
	<td class="text">
		<%if("R".equals(ob.getComlinetype())){%><bean:message key="ComlineList.table.type.rrl"/><%} else if("O".equals(ob.getComlinetype())){%><bean:message key="ComlineList.table.type.optic"/><%}%>
	</td>
	<td class="text">
		<bean:write name="obj" property="resourceName" filter="true"/>
	</td>
	<td class="text">
		<bean:message key="<%=state%>"/>
	</td>
	<td class="link">
		<input type=checkbox class=editcheckbox value='<%=ob.getId()%>' name='check_add' id='isComlineId'/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>
