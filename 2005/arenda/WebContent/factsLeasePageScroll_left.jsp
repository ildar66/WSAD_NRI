<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.arenda.*,com.hps.july.arenda.valueobject.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="java.text.*"%>
<%!
//форматируем дату:
SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
private String dateStr(java.sql.Date date) {
	if(date==null) 
		return ("&nbsp;");
	else
		return	format.format (date);
}
//определяем цвет клетки:
final String colorBG = "background: silver;";
final String colorNULL = "";
private String getColorBG(String flag){
	if("Y".equals(flag))
		return colorBG;
	else
		return colorNULL;
}
%>

<HTML>
<HEAD>
<TITLE>factsLeasePageScroll_left.jsp</TITLE>
</HEAD>

<BODY onscroll="return scroll_left();">
<script>
function scroll_left() {
	var xscroll;
	var yscroll;
	if (xscroll!=document.body.scrollLeft)
		top.frames["headers_left"].document.body.scrollLeft=document.body.scrollLeft;
	if (yscroll!=document.body.scrollTop)
		top.frames["scroll_right"].document.body.scrollTop=document.body.scrollTop;
	xscroll = document.body.scrollLeft;
	yscroll=document.body.scrollTop;	
	return true;
}
</script>
<TABLE border="1" width="100%" style="border-collapse:collapse; border-color:  black; font-size:9pt;"	>
	<TBODY>
			<!-- Table body -->
			<logic:iterate id="it" name="FactsLeasePageForm" property="page.list" scope="session">
				<%
					FactsLeaseTO to = (FactsLeaseTO) it; 
					//Integer docID = to.getDocID();
				%>
				<tr>
						<td nowrap style="width: 20px;" align="center">
							<%--a href="/arenda/ShowDogHistoryList.do?contract=<%= docID%>" title="История договора" target="_top">
								<img src="/images/obchet1.gif" border=0 alt='История договора' height="12pt" width="15pt"></a--%>
							<july:link page="/ShowDogHistoryList.do" paramId="contract" paramName="it" paramProperty="docID" target="_top">
								<img src="/images/obchet1.gif" border=0 alt='История договора' height="12pt" width="15pt"></july:link>
						</td>
						<td nowrap="nowrap" style="width: 120px;"><%=to.getDocNumber()%></td>
						<td nowrap="nowrap" style="width: 60px;"><%=dateStr(to.getDocDate())%></td>
						<%--td nowrap style="width: 70px;"><%=to.getGsmId()%> </td>
						<td nowrap style="width: 70px;"><%=to.getDampsId()%>  </td--%>
						<td nowrap style="width: 400px;"><%=to.getName()%></td> 
				</tr>
			</logic:iterate>
	</TBODY>
</TABLE>
</BODY>

</HTML>
