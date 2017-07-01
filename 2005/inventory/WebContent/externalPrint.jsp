<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.inventory.*,com.hps.july.inventory.valueobject.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:browseform action="/PrintExternal.do">

<table class="main">
<tr class="title" style="media:screen;">
	<td>&nbsp;<input type="image" name="submit" src="/images/print.gif" alt="Печатать"><a href='javascript:window.close();' title="Закрыть окно"><img src="/images/cancel.gif" alt="Закрыть окно" border="0"></a></td>
</tr>

<tr>
	<td>
		<!-- Table header -->
		<table class="main" border="1">
		<tr>
			<td colspan="5"><bean:message key="label.external.print.title"/></td>
			<td colspan="3"><bean:message key="label.external.print.storage"/> <bean:write name="document" property="to.name" /></td>
		</tr>
		<tr>
			<td><bean:message key="label.external.print.documentnum"/></td>
			<td><bean:write name="document" property="blankindex" filter="true"/>&nbsp;<bean:write name="document" property="blanknumber" filter="true"/></td>
			<td><bean:message key="label.external.print.documentdate"/></td>
			<td><july:datewrite name="document" property="blankdate" /></td>
			<td><bean:message key="label.external.print.cordocnum"/></td>
			<td><bean:write name="document" property="blankindex" filter="true"/>&nbsp;<bean:write name="document" property="blanknumber" filter="true"/></td>
			<td><bean:message key="label.external.print.cordocdate"/></td>
			<td><july:datewrite name="document" property="cordocdate"/></td>
		</tr>
		<tr>
			<td><bean:message key="label.external.print.gtdnum"/></td>
			<td colspan="2"><bean:write name="document" property="gtdnumber" filter="true"/></td>
			<td><bean:message key="label.external.print.currency"/></td>
			<td><bean:write name="document" property="currency.shortname" filter="true"/></td>
			<td><bean:message key="label.external.print.regnum"/></td>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td><bean:message key="label.external.print.contragent"/></td>
			<td colspan="4">
<logic:present name="document" property="contragent">
<bean:write name="document" property="contragent.name" filter="true" />
</logic:present>
			</td>
			<td><bean:message key="label.external.print.contract"/></td>
			<td colspan="3">
<logic:present name="contract">
<bean:message key="label.num"/> <bean:write name="contract" property="blanknumber" filter="true" /> <bean:message key="label.from"/> <bean:write name="contract" property="blankdate" filter="true"/> <bean:write name="contract" property="name" filter="true"/>, <bean:write name="contract" property="baseAgreement.name" filter="true"/>
</logic:present>
			</td>
		</tr>
		</table>
		<br>
		<table class="main" border="1">
		<tr>
			<td rowspan="2"><bean:message key="label.external.print.num"/></td>
			<td rowspan="2"><bean:message key="label.external.print.name"/></td>
			<td rowspan="2"><bean:message key="label.external.print.unit"/></td>
			<td colspan="2"><bean:message key="label.external.print.qty"/></td>
			<td colspan="2"><bean:message key="label.external.print.price"/></td>
			<td colspan="2"><bean:message key="label.external.print.sum"/></td>
			<td rowspan="2"><bean:message key="label.external.print.serial"/></td>
		</tr>
		<tr>
			<td><bean:message key="label.external.print.bydoc"/></td>
			<td><bean:message key="label.external.print.byfact"/></td>
			<td><bean:message key="label.external.print.bydoc"/></td>
			<td><bean:message key="label.external.print.counted"/></td>
			<td><bean:message key="label.external.print.bydoc"/></td>
			<td><bean:message key="label.external.print.counted"/></td>
		</tr>
<!-- Table body -->
<logic:present name="positionList">
<logic:iterate id="row" name="positionList">
	<logic:present name="row">
		<tr>
			<td><bean:write name="row" property="order" filter="true"/></td>
			<td><bean:write name="row" property="resource.name" filter="true"/><logic:present name="row" property="resource.model">;<br><bean:write name="row" property="resource.model" filter="true"/></logic:present><logic:present name="row" property="configuration">;<br><bean:write name="row" property="configuration" filter="true"/></logic:present></td>
			<td><bean:write name="row" property="resource.unit.shortname" filter="true"/></td>
			<td>&nbsp;</td>
			<td><bean:write name="row" property="qty" filter="true"/></td>
			<td>&nbsp;</td>
			<td><july:numberwrite name="row" property="price"/></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td><logic:present name="row" property="serialnumber"><bean:write name="row" property="serialnumber"/></logic:present><logic:notPresent name="row" property="serialnumber">&nbsp;</logic:notPresent></td>
		</tr>
	</logic:present>
</logic:iterate>
</logic:present>
<logic:notPresent name="positionList">
		<tr class="normal">
			<td class="link" rowspan="10"><bean:message key="error.rows"/></td>
		</tr>
</logic:notPresent>
		</table>
		<br>
		<span><bean:message key="label.external.print.from"/></span>
		<span style="text-decoration:underline;"><logic:present name="expedition"><bean:write name="expedition" property="expeditor.man.fullName" filter="true"/></logic:present>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<span><bean:message key="label.external.print.fiosign"/></span>
		<span>/</span>
		<span><bean:message key="label.external.print.to"/></span>
		<span style="text-decoration:underline;"><logic:present name="document"><bean:write name="document" property="storageManager.man.fullName" filter="true"/></logic:present>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<span><bean:message key="label.external.print.fiosign"/></span>
	</td>
</tr>

<tr class="title" style="media:screen;">
	<td>&nbsp;<input type="image" name="submit" src="/images/print.gif" alt="Печатать"><a href='javascript:window.close();' title="Закрыть окно"><img src="/images/cancel.gif" alt="Закрыть окно" border="0"></a></td>
</tr>
</table>

</july:browseform>
