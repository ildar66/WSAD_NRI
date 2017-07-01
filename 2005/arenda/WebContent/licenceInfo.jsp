<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.arenda.valueobject.*, java.sql.*, java.text.*" %>

<%!
final String [] typeInfo =
{"ФАС", "РУЦР", "Аэро-граж", "Аэро-воен", "ГПС", "ГАСН", "СЭС", "в\\ч", "ТУ", "Акт Земл.", "Кадастр", "Дог имущ.", "Коммент."};
//форматируем дату:
java.text.SimpleDateFormat formaterTS = new java.text.SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat("dd.MM.yyyy");
private String dateTSStr(java.sql.Timestamp ts) {
	if(ts==null) 
		return ("&nbsp;");
	else
		return	formaterTS.format (new java.util.Date(ts.getTime()));
}
private String dateStr(java.sql.Date date) {
	if(date==null) 
		return ("&nbsp;");
	else
		return	formater.format (date);
}
%>

<html:html>
<HEAD>
<TITLE>Информация о позиции</TITLE>
<link rel="stylesheet" type="text/css" href="/main.css">
</HEAD>
 
<BODY>
<html:errors />

<table class="main">
    <tr class="title">
        <td class="title">
          <july:closebutton page="/"/>
          <july:printerbutton/>
        </td>
    </tr>

	<july:separator/>

	    <TR class="printable">
	    <TD class="printable">
	        <TABLE class="print" style="border-color: black; border-width: 2; border-collapse:collapse;" border="1">
		        <tr>
					<th rowspan="2">тип</th>
					<th rowspan="2" title="Комментарий">&nbsp;!&nbsp;</th>
					<th rowspan="2">дата</th>
					<th colspan="2">создал</th>
					<th colspan="2">изменил</th>	
				</tr>
		        <tr>	<th>кто</th><th>когда</th><th>кто</th><th>когда</th></tr>
			<!-- Table body -->
			<logic:iterate id="it" name="reportPage" property="list" scope="request">
				<%LicenciesOnPos_VO vo = (LicenciesOnPos_VO) it; String isNoteFlag = vo.getNoteLicence().equals("")?"" : "+";%>
		        <tr>
					<td style="font-size: 8pt"><I><B><%= typeInfo[vo.getTypeLicence().intValue() -1] %></B></I></td>
					<td style="font-size: 8pt" title="<%=vo.getNoteLicence() %>" align="middle"><B><%=isNoteFlag%></B></td>
					<td style="font-size: 8pt"><%= dateStr(vo.getDateLicence()) %>		</td>
			        <td style="font-size: 8pt"><%= vo.getCreatedName() %>		</td>
					<td style="font-size: 8pt"><%= dateTSStr(vo.getCreated()) %>	</td>
					<td style="font-size: 8pt"><%= vo.getModifiedName() %>		</td>
					<td style="font-size: 8pt"><%= dateTSStr(vo.getModified()) %></td>
				</tr>
			</logic:iterate>
			</TABLE>
		</TD>
	</TR>

	<july:separator/>

	<tr class="title">
    	<td class="title">
          <july:closebutton page="/"/>
          <july:printerbutton/> 
        </td>
    </tr>

</table>

</BODY>
</html:html>