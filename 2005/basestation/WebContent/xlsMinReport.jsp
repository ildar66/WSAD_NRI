<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.basestation.*,com.hps.july.persistence.*,com.hps.july.jdbcpersistence.lib.DebugSupport" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
String title;
String returnUrl;
DebugSupport.printlnTest("task="+session.getAttribute("task"));
if(((Integer)session.getAttribute("task")).intValue()==3){
 title="xls.report.bs.title";
 returnUrl="/ProcessXlsBs.do";
}else{
 title="xls.report.title";
 returnUrl="/ProcessXls.do";
}%>


<html:form action="/xlsMinReport.do">
<table class="main">
<%-- DD
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="<%=returnUrl%>" styleClass="navigator"><bean:message key="xls.title"/></html:link>
		   <july:sepmark/>
           <july:currmark><bean:message key="xls.title.view"/></july:currmark></td>
    </tr>    
--%>
    <july:separator/>
	<TR class="title">
		<TD colspan="2">
		<%--<html:link page="<%=returnUrl%>" ><IMG SRC="/images/cancel.gif" ALT="Отказ и возврат" onclick="document.body.style.cursor='wait';" BORDER=0></html:link>--%>
		<july:backbutton/>
		&nbsp;&nbsp;&nbsp;
		<html:link page="/xlsMaxReport.do"><bean:message key="xls.journal.msg"/></html:link>
		</TD>
	</TR>
	<july:separator/>
    <tr>
        <td class="title" colspan="2"><july:currmark>
	
 <bean:message key="<%=title%>"/>

 </july:currmark></td>
    </tr>     
    <july:separator/>
	<tr><%--Файл для загрузки--%>
        <td class="text"><bean:message key="xls.filename"/></td>
        <td><bean:write name="minReportForm" property="filename"/></td>
    </tr>    
    <july:separator/>
	<%--<tr>Дата изменения файла
        <td class="text"><bean:message key="xls.report.datefile"/></td>
		<td class="text"><july:datewrite name="minReportForm" property="filetime" showtime="false"/></td>
    </tr>
    <july:separator/>--%>
	<tr><%--Размер файла (kB):--%>
        <td class="text"><bean:message key="xls.report.sizefile"/></td>
        <td><bean:write name="minReportForm" property="filesize"/></td>
    </tr>    
    <july:separator/>

</table>
<hr>
<table class="main">
	<tr><%--Пользователь оператор загрузки--%>
        <td class="text"><bean:message key="xls.report.operator"/></td>
        <td><bean:write name="minReportForm" property="operator.man.fullName"/></td>
    </tr>    
    <july:separator/>
	<tr><%--Дата загрузки--%>
        <td class="text"><bean:message key="xls.report.loaddate"/></td>
		<td class="text"><july:datewrite name="minReportForm" property="importstart" showtime="false"/></td>
    </tr>    
    <july:separator/>
	<tr><%--Номер сессии загрузки--%>
        <td class="text"><bean:message key="xls.report.sessionnum"/></td>
        <td><bean:write name="minReportForm" property="impsesid"/></td>
    </tr>    
    <july:separator/>
	<tr><%--Количество обработанных записей--%>
        <td class="text"><bean:message key="xls.report.entrycount"/></td>
        <td><bean:write name="minReportForm" property="reccount"/></td>
    </tr>    
    <july:separator/>
	<tr><%--Количество ошибок загрузки--%>
        <td class="text"><bean:message key="xls.report.errorcount"/></td>
        <td><bean:write name="minReportForm" property="errcount"/></td>
    </tr>    
    <july:separator/>
	<tr><%--Время загрузки (сек)--%>
        <td class="text"><bean:message key="xls.report.loadtime"/></td>
        <td><% ImportSessionAccessBean ab = (ImportSessionAccessBean)request.getAttribute("minReportForm");
		out.print( (ab.getImportend().getTime()-ab.getImportstart().getTime())/1000 );%>
		</td>
    </tr>    
    <july:separator/>
	<TR class="title">
		<TD colspan="2">
		<%--<html:link page="<%=returnUrl%>" ><IMG SRC="/images/cancel.gif" ALT="Отказ и возврат" onclick="document.body.style.cursor='wait';" BORDER=0></html:link>--%>
		<july:backbutton/>
		&nbsp;&nbsp;&nbsp;
		<html:link page="/xlsMaxReport.do"><bean:message key="xls.journal.msg"/></html:link>
		</TD>
	</TR>
	<july:separator/>

<%-- DD
	<tr class="title">
    	<td class="title" colspan="2">
           <html:link page="<%=returnUrl%>" styleClass="navigator"><bean:message key="xls.title"/></html:link>
		   <july:sepmark/>
           <july:currmark><bean:message key="xls.title.view"/></july:currmark></td>
    </tr>    
    <july:separator/>
--%>
</table>
</html:form>

