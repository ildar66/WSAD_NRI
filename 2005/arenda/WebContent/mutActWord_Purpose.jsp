<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=CP1251"
%>
<META http-equiv="Content-Type" content="text/html; charset=CP1251">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE></TITLE>
</HEAD>

<BODY>
<!-- Реквизиты для перечисления -->
<%
	com.hps.july.arenda.formbean.MutactWordPrintForm aform = (com.hps.july.arenda.formbean.MutactWordPrintForm)request.getAttribute("MutactWordPrintForm");
	String purposePayNds = "";
	if(aform.getHeader().getPosition() != null)
		purposePayNds = aform.getHeader().getPurposePayNds();
%>
<B>Реквизиты для перечисления.</B>
<P>&nbsp;</P> 
	Получатель: ОАО “ВЫМПЕЛКОМ”<br>
	ИНН 7713076301<br>
	Сбербанк России ОАО  г.Москва Вернадское ОСБ №7970<br>
	р/с 40702810138180121008<br>
	к/с 30101810400000000225<br>
	БИК  044525225<br>
	КПП 997750001<br>
<P>&nbsp;</P>
<B>Назначение платежа прошу указывать следующее:</B><br> 
	<%= purposePayNds%>
</BODY>
</html:html>
