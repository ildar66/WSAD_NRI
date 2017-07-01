<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.inventory.*,com.hps.july.inventory.valueobject.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:browseform action="/PrintInternalR.do">

<table class="main">
<tr class="title" style="media:screen;">
	<td>&nbsp;<input type="image" name="submit" src="/images/print.gif" alt="Печатать"><a href='javascript:window.close();' title="Закрыть окно"><img src="/images/cancel.gif" alt="Закрыть окно" border="0"></a></td>
</tr>

<tr>
	<td>
		<!-- Table header -->
		<table class="main" border="1">
		<tr>
			<td colspan="2" align="center"><bean:message key="label.print.internalr.inwaybill"/> <bean:write name="document" property="blankindex" filter="true"/>&nbsp;<bean:write name="document" property="blanknumber" filter="true"/> <bean:message key="label.from"/> <july:datewrite name="document" property="blankdate" /></td>
		</tr>
		<tr>
			<td><bean:message key="label.print.internalr.whom"/>: <logic:present name="expedition"><logic:present name="expedition" property="expeditor"><bean:write name="expedition" property="expeditor.man.fullName" filter="true"/></logic:present><logic:present name="expedition" property="organization"><bean:write name="expedition" property="organization.name" filter="true" /></logic:present></logic:present></td>
		</tr>
		<tr>
			<td><bean:message key="label.print.internalr.position"/>: <logic:present name="document" property="position"><bean:write name="document" property="position.name" filter="true" /></logic:present></td>
			<td align="right"><bean:message key="label.print.internalr.agree"/></td>
		</tr>
		<tr>
			<td><bean:message key="label.print.internalr.fromwho"/>: <bean:write name="document" property="owner.name" filter="true"/>, <bean:write name="document" property="from.name" filter="true"/></td>
			<td align="right"><bean:message key="label.print.internalr.boss"/></td>
		</tr>
		<tr>
			<td><bean:message key="label.print.internalr.documents"/>: </td>
		</tr>
		</table>
		<br>
		<table class="main" border="1">
		<tr>
			<td><bean:message key="label.print.internalr.numpp"/></td>
			<td><bean:message key="label.print.internalr.name"/></td>
			<td><bean:message key="label.print.internalr.qty"/></td>
			<td><bean:message key="label.print.internalr.serialnum"/></td>
			<td><bean:message key="label.print.internalr.price"/></td>
			<td><bean:message key="label.print.internalr.sum"/></td>
		</tr>
<!-- Table body -->
<logic:present name="positionList">
<logic:iterate id="row" name="positionList">
	<logic:present name="row">
		<tr>
			<td><bean:write name="row" property="order" filter="true"/></td>
			<td><bean:write name="row" property="resource.name" filter="true"/><logic:present name="row" property="resource.model">;<br><bean:write name="row" property="resource.model" filter="true"/></logic:present><logic:present name="row" property="configuration">;<br><bean:write name="row" property="configuration" filter="true"/></logic:present></td>
			<td><bean:write name="row" property="qty" filter="true"/></td>
			<td><logic:present name="row" property="serialnumber"><bean:write name="row" property="serialnumber"/></logic:present><logic:notPresent name="row" property="serialnumber">&nbsp;</logic:notPresent></td>
			<td><july:numberwrite name="row" property="price"/></td>
			<td><july:numberwrite name="row" property="sum"/></td>
		</tr>
	</logic:present>
</logic:iterate>
</logic:present>
<logic:notPresent name="positionList">
		<tr>
			<td rowspan="6"><bean:message key="error.rows"/></td>
		</tr>
</logic:notPresent>
		</table>
		<br>
		<table class="main" border="0">
		<tr>
			<td width="50%">
				<span><bean:message key="label.print.internalr.sdal"/></span>
				<span style="text-decoration:underline;"><logic:present name="document"><bean:write name="document" property="storageManager.man.fullName" filter="true"/></logic:present>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			</td>
			<td width="50%">
				<span><bean:message key="label.print.internalr.prinyal"/></span>
				<span style="text-decoration:underline;"><logic:present name="expedition"><logic:present name="expedition" property="expeditor"><bean:write name="expedition" property="expeditor.man.fullName" filter="true"/></logic:present><logic:present name="expedition" property="organization"><bean:write name="document" property="insuranseMan" filter="true"/></logic:present></logic:present>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			</td>
		</tr>
		</table>
	</td>
</tr>

<tr class="title" style="media:screen;">
	<td>&nbsp;<input type="image" name="submit" src="/images/print.gif" alt="Печатать"><a href='javascript:window.close();' title="Закрыть окно"><img src="/images/cancel.gif" alt="Закрыть окно" border="0"></a></td>
</tr>
</table>

</july:browseform>
