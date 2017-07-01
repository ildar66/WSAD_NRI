<HTML>
<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.web.util.*, com.hps.july.basestation.formbean.*"%>
<BODY>
<style>
TD.tableCell {
	text-align: center;
}
TABLE.construct {
	border-style: solid; 
	border-color: red; 
	border-width: 0;
}
</style>
<table  width="458" cellspacing="0" cellpadding="0" style="font-family:tahoma,arial;font-size:8pt;">
	<tr>
		<th colspan="4" align="center">Подключенные дочерние репитеры</th> 
	</tr>	
	<tr>
		<th width="80">№ репитера</th> 
		<th width="120">Донорный сектор</th> 
		<th width="120">Тип подключения</th> 
		<th width="120">Статус</th> 
		<th width="18">&nbsp;</th> 
	</tr>	
</table>				
</BODY>
</HTML>
