<%@ page import="com.hps.july.basestation.formbean.ControllerListForm"%>
<%@ page import="com.hps.july.basestation.formbean.EquipmentListForm"%>
<%@ page import="com.hps.july.basestation.formbean.SwitchControllersListForm"%>
<%@ page import="com.hps.july.basestation.formbean.SwitchForm"%>
<%@ page import="com.hps.july.persistence.SwitchAccessBean"%>
<%@ page import="com.hps.july.siteinfo.valueobject.Position"%>

<%@ page contentType="TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<%
	String gColSpan = request.getAttribute("colspan") + "";
	SwitchForm switchForm = (SwitchForm) pageContext.findAttribute("SwitchForm");
	SwitchAccessBean swch = new SwitchAccessBean();
	swch.setInitKey_storageplace(switchForm.getStorageplace());
	swch.refreshCopyHelper();

	Position position = new Position(swch.getPosition());
%>


<tr class="normal"><td colspan="<%= gColSpan %>">
<table class="find">
<tr>
	<td class="text"><bean:message key="label.swc.positionname"/>:</td>
	<td class="text">
		<%=position.getFullName()%>
	</td>
</tr>
<tr>
       <td class="text" style="padding-left:16px;"><bean:message key="label.swc.regionname"/>:</td>
       <td class="text">
		<%=position.getBean().getRegion().getRegname()%>
       </td>
</tr>
<tr>
       <td class="text" style="padding-left:16px;"><bean:message key="label.swc.zonename"/>:</td>
       <td class="text">
		<%=position.getBean().getNetZone().getName()%>
       </td>
</tr>
<tr>
       <td class="text" style="padding-left:16px;"><bean:message key="label.swc.address"/>:</td>
       <td class="text">
		<%=position.getBean().getAddress()%>
       </td>
</tr>
<tr>
	<td class="text"><bean:message key="label.swc.switchname"/>:</td>
	<td class="text">
		<%=swch.getName() + ", " + swch.getNumber()%>
	</td>
</tr>
</table>
</td></tr>
