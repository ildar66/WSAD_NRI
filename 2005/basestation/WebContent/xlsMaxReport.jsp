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
    }

	int state = ParamsParser.getState( pageContext );
	String actionStr = state==APPStates.LOADRESULTS ? "/ShowXlsLoadResults.do":"/xlsMaxReport.do";
%>

<july:browseform action="<%= actionStr %>">
<html:hidden property="impsesid"/>

<table class="main">
<%-- DD
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="<%=returnUrl%>" styleClass="navigator"><bean:message key="xls.title"/></html:link>
			<% 
			String returnPath = state==APPStates.LOADRESULTS ? "/xlsJournal.do":returnUrl;
			if(state==APPStates.LOADRESULTS){%>
			   <july:sepmark/>
			   <html:link page="/xlsJournal.do" styleClass="navigator">
			   <bean:message key="xls.journal"/></html:link>
			<%}%>
		   <july:sepmark/>
           <july:currmark><bean:message key="xls.title.view"/></july:currmark></td>
    </tr>    
--%>
    <july:separator/>
	<tr class="title">
          <td colspan="5"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
					<july:backbutton/>
<%--
                 <html:link page="<%=returnPath%>"><IMG SRC="/images/cancel.gif" ALT="Отказ и возврат" onclick="document.body.style.cursor='wait';" BORDER=0></html:link>
 --%>
				 </TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
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
        <td><%
            ImportSessionAccessBean isab = (ImportSessionAccessBean)request.getAttribute("minReportForm");
            long exprTyme=(isab.getImportend().getTime()-isab.getImportstart().getTime())/1000;
		out.print(exprTyme>=0?exprTyme:0 );
            %>
		</td>
    </tr>    
    <july:separator/>
</table>
<hr>
<table class="main">
        <tr class="title">
          <td colspan="5"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
				<july:backbutton/>
<%--                 <html:link page="<%=returnPath%>"><IMG SRC="/images/cancel.gif" ALT="Отказ и возврат" onclick="document.body.style.cursor='wait';" BORDER=0></html:link> --%>
				 </TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
	<july:separator colspan="5"/>
	<tr class="title">
		<july:headercolumn key="xls.report.entrydate" colType="string"/>
		<july:headercolumn key="xls.report.entryPK" colType="string"/>
		<july:headercolumn key="xls.report.entryevent" colType="string"/>
		<july:headercolumn key="xls.report.entryresult" colType="string"/>
		<july:headercolumn key="xls.report.entryerror" colType="string"/>
	</tr>
	<july:separator colspan="5"/>

<logic:iterate id="pos" name="browseList">
<%ImportRecordAccessBean ab = (ImportRecordAccessBean)pos;%>
	<logic:present name="pos">
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="text"><july:datewrite name="pos" property="recendtime" showtime="true"/>
		<td class="text"><bean:write name="pos" property="keyfields" filter="true"/></td>
		<td class="text"><bean:message key="<%=ab.getIaction()%>" /></td>
		<td class="text"><bean:message key="<%=ab.getResult()%>" /></td>
		<td class="text"><bean:message key="<%=ab.getErrlabel()%>" 
									   arg0="<%= ab.getParam1()%>"
									   arg1="<%= ab.getParam2()%>"
									   arg2="<%= ab.getParam3()%>"/></td>
	</tr>
    </logic:present>
</logic:iterate>
    <july:separator colspan="5"/>
		<tr class="title">
          <td colspan="5"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
					<july:backbutton/>
<%--
                 <html:link page="<%=returnPath%>"><IMG SRC="/images/cancel.gif" ALT="Отказ и возврат" onclick="document.body.style.cursor='wait';" BORDER=0></html:link>
 --%>
				 </TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
	<july:separator colspan="5"/>
<%-- DD
	<tr class="title">
    	<td class="title" colspan="5">
           <html:link page="<%=returnUrl%>" styleClass="navigator"><bean:message key="xls.title"/></html:link>
		   <% if(state==com.hps.july.basestation.APPStates.LOADRESULTS){%>
			   <july:sepmark/>
			   <html:link page="/xlsJournal.do" styleClass="navigator">
			   <bean:message key="xls.journal"/></html:link>
			<%}%>
		   <july:sepmark/>
           <july:currmark><bean:message key="xls.title.view"/></july:currmark></td>
    </tr>    
--%>
</table>
</july:browseform>

