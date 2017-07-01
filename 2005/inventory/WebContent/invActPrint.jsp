<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.inventory.*,com.hps.july.inventory.valueobject.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:browseform action="/PrintInvAct.do">

<table class="main">
<tr class="title" style="media:screen;">
	<td>&nbsp;<input type="image" name="submit" src="/images/print.gif" alt="Печатать"><a href='javascript:window.close();' title="Закрыть окно"><img src="/images/cancel.gif" alt="Закрыть окно" border="0"></a></td>
</tr>

<tr>
	<td>
<%--
		<!-- Table header -->
		<table class="main" border="1">
		<tr>
			<td colspan="5">Приходный ордер</td>
			<td colspan="3">Склад: <bean:write name="document" property="to.name" /></td>
		</tr>
		<tr>
			<td>Номер документа</td>
			<td><bean:write name="document" property="blankindex" filter="true"/>&nbsp;<bean:write name="document" property="blanknumber" filter="true"/></td>
			<td>Дата</td>
			<td><july:datewrite name="document" property="blankdate" /></td>
			<td>№ сопроводительного документа</td>
			<td><bean:write name="document" property="blanknumber" filter="true"/></td>
			<td>Дата сопроводит. документа</td>
			<td><july:datewrite name="document" property="cordocdate"/></td>
		</tr>
		<tr>
			<td>№ ГТД</td>
			<td colspan="2"><bean:write name="document" property="gtdnumber" filter="true"/></td>
			<td>Валюта</td>
			<td><bean:write name="document" property="currency.name" filter="true"/> (<bean:write name="document" property="currency.shortname" filter="true"/>)</td>
			<td>Рег. номер в бухгалтерии</td>
			<td colspan="2"><bean:write name="document" property="owner.inn" filter="true"/></td>
		</tr>
		<tr>
			<td>Поставщик</td>
			<td colspan="4">
<logic:present name="document" property="contragent">
<bean:write name="document" property="contragent.name" filter="true" />
</logic:present>
			</td>
			<td>Контракт</td>
			<td colspan="3">
<logic:present name="contract">
№ <bean:write name="contract" property="blanknumber" filter="true" /> от <bean:write name="contract" property="blankdate" filter="true"/> <bean:write name="contract" property="name" filter="true"/>, <bean:write name="contract" property="baseAgreement.name" filter="true"/>
</logic:present>
			</td>
		</tr>
		</table>
		<br>
		<table class="main" border="1">
		<tr>
			<td rowspan="2">№</td>
			<td rowspan="2">Наименование</td>
			<td rowspan="2">Ед. Изм</td>
			<td colspan="2">Количество</td>
			<td colspan="2">Цена</td>
			<td colspan="2">Сумма</td>
			<td rowspan="2">Серийный №</td>
		</tr>
		<tr>
			<td>По д-ту</td>
			<td>По факту</td>
			<td>По д-ту</td>
			<td>Учётная</td>
			<td>По д-ту</td>
			<td>Учётная</td>
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
		<span>Сдал</span>
		<span style="text-decoration:underline;"><logic:present name="expedition"><bean:write name="expedition" property="expeditor.man.fullName" filter="true"/></logic:present>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<span>(фамилия, подпись)</span>
		<span>/</span>
		<span>Принял</span>
		<span style="text-decoration:underline;"><logic:present name="document"><bean:write name="document" property="storageManager.man.fullName" filter="true"/></logic:present>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<span>(фамилия, подпись)</span>
	</td>
</tr>
--%>
<tr class="title" style="media:screen;">
	<td>&nbsp;<input type="image" name="submit" src="/images/print.gif" alt="Печатать"><a href='javascript:window.close();' title="Закрыть окно"><img src="/images/cancel.gif" alt="Закрыть окно" border="0"></a></td>
</tr>
</table>

</july:browseform>
