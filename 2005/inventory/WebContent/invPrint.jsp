<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.inventory.*,com.hps.july.inventory.valueobject.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:browseform action="/PrintInv.do">

<table class="main">
<tr class="title" style="media:screen;">
	<td>&nbsp;<input type="image" name="submit" src="/images/print.gif" alt="Печатать"><a href='javascript:window.close();' title="Закрыть окно"><img src="/images/cancel.gif" alt="Закрыть окно" border="0"></a></td>
</tr>

<tr>
	<td>
		<!-- Table header -->
		<span><bean:message key="label.inv.print.act"/> <bean:write name="i13n" property="blankindex" filter="true"/>&nbsp;<bean:write name="i13n" property="blanknumber" filter="true"/> <bean:message key="label.from"/> <july:datewrite name="i13n" property="blankdate"/></span>
		<span><bean:message key="label.inv.print.bs"/></span>
		<span style="text-decoration:underline;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<span>&quot;</span>
		<span style="text-decoration:underline;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<span>&quot;</span>
		<br>
		<div><bean:message key="label.inv.print.hint1"/>
			<span style="text-decoration:underline;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<span>&quot;</span>
			<span style="text-decoration:underline;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<span>&quot;</span><bean:message key="label.inv.print.hint2"/>
		</div><br>
		<table class="main" border="1">
		<tr>
			<td><bean:message key="label.inv.print.numpp"/></td>
			<td><bean:message key="label.inv.print.name"/></td>
			<td><bean:message key="label.inv.print.serpartnum"/></td>
			<td><bean:message key="label.inv.print.qty"/></td>
			<td><bean:message key="label.inv.print.price"/></td>
			<td><bean:message key="label.inv.print.sum"/></td>
			<td><bean:message key="label.inv.print.agr"/></td>
			<td><bean:message key="label.inv.print.agrser"/></td>
			<td><bean:message key="label.inv.print.note"/></td>
		</tr>
<!-- Table body -->
<logic:present name="positionList">
<logic:iterate id="row" name="positionList">
	<logic:present name="row">
		<tr>
			<td><bean:write name="row" property="order" filter="true"/></td>
			<td><bean:write name="row" property="resource.name" filter="true"/><logic:present name="row" property="resource.model">;<br><bean:write name="row" property="resource.model" filter="true"/></logic:present><logic:present name="row" property="configuration">;<br><bean:write name="row" property="configuration" filter="true"/></logic:present></td>
			<td><logic:present name="row" property="seialnumber"/><bean:write name="row" property="serialnumber" filter="true"/></logic:present><logic:present name="row" property="party"><bean:write name="row" property="party" filter="true"/></logic:present></td>
			<td><bean:write name="row" property="qty" filter="true"/></td>
			<td><bean:write name="row" property="price" filter="true"/></td>
			<td>&nbsp;</td>
			<td><logic:present name="row" property="agregate"><bean:write name="row" property="agregate.name" filter="true"/><logic:present name="row" property="agregate.model">;<br><bean:write name="row" property="agregate.model" filter="true"/></logic:present></logic:present></td>
			<td><logic:present name="row" property="agregate"><bean:write name="row" property="agregateSerial" filter="true"/></logic:present></td>
			<td><bean:write name="row" property="note" filter="true"/></td>
		</tr>
	</logic:present>
</logic:iterate>
</logic:present>
<logic:notPresent name="positionList">
		<tr>
			<td rowspan="9"><bean:message key="error.rows"/></td>
		</tr>
</logic:notPresent>
		</table>
		<br>
		<table class="main" border="0">
		<tr>
			<td rowspan="5" valign="top"><bean:message key="label.inv.print.who"/>:</td>
		</tr>
		<tr>
			<td><bean:write name="i13n" property="storagemanager.man.fullName" filter="true"/></td>
			<td><span style="text-decoration:underline;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
		</tr>
		<tr>
			<td><bean:message key="label.inv.print.fio"/></td>
			<td><bean:message key="label.inv.print.sign"/></td>
		</tr>
		<tr>
			<td><bean:write name="i13n" property="techstuff.man.fullName" filter="true"/></td>
			<td><span style="text-decoration:underline;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
		</tr>
		<tr>
			<td><bean:message key="label.inv.print.fio"/></td>
			<td><bean:message key="label.inv.print.sign"/></td>
		</tr>
		</table>

<tr class="title" style="media:screen;">
	<td>&nbsp;<input type="image" name="submit" src="/images/print.gif" alt="Печатать"><a href='javascript:window.close();' title="Закрыть окно"><img src="/images/cancel.gif" alt="Закрыть окно" border="0"></a></td>
</tr>
</table>

</july:browseform>
