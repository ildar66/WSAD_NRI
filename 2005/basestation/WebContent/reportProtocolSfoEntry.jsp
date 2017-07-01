<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.formbean.*"%>
<%@ page import="com.hps.july.web.util.*"%>
<%@ page import="com.hps.july.basestation.*"%>

<july:editform action="/ShowReportProtocolSfo">

<table class="main">
<july:separator/>
<tr>
	<td class="text">Номер заявки на протоколы измерений:</td>
	<td class="text">
		<july:string size="15" property="sfonumber" insertable="true" updatable="true"/>

		&nbsp;&nbsp;&nbsp;

		<a href="#" target="_blank" onclick="this.href='GetReportProtocolSfo.do?sfonumber='+document.all.sfonumber.value;">Получить отчёт</a>
	</td>
</tr>
<july:separator/>
<july:formbuttons showsave="false" showreset="false"/>
<july:separator/>
</table>
</july:editform>
