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
<!-- ��������� ��� ������������ -->
<%
	com.hps.july.arenda.formbean.MutactWordPrintForm aform = (com.hps.july.arenda.formbean.MutactWordPrintForm)request.getAttribute("MutactWordPrintForm");
	String purposePayNds = "";
	if(aform.getHeader().getPosition() != null)
		purposePayNds = aform.getHeader().getPurposePayNds();
%>
<B>��������� ��� ������������.</B>
<P>&nbsp;</P> 
	����������: ��� ���������̔<br>
	��� 7713076301<br>
	�������� ������ ���  �.������ ���������� ��� �7970<br>
	�/� 40702810138180121008<br>
	�/� 30101810400000000225<br>
	���  044525225<br>
	��� 997750001<br>
<P>&nbsp;</P>
<B>���������� ������� ����� ��������� ���������:</B><br> 
	<%= purposePayNds%>
</BODY>
</html:html>
