<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*" %>
<%@ page import="com.hps.july.arenda.*, com.hps.july.arenda.valueobject.*, com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="java.text.*, com.hps.july.jdbcpersistence.lib.*"%>

<%!
//форматируем дату:
SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
private String dateStr(java.sql.Date date) {
	if(date==null) 
		return ("&nbsp;");
	else
		return	format.format (date);
}
//определ€ем цвет клетки:
final String colorRED = "background: red;";
final String colorYELLOW = "background: yellow;";
final String colorGREEN = "background: green;";
final String colorNULL = "";
private String getColorBG(String flag){
	if("R".equals(flag))
		return colorRED;
	else if("Y".equals(flag))
		return colorYELLOW;
	else if("G".equals(flag))
		return colorGREEN;				
	else
		return colorNULL;
}
%>

<%
    //TimeCounter counter = new TimeCounter("PERF.scroll_right");//temp
	FactsLeasePageForm listForm = (FactsLeasePageForm)session.getAttribute("FactsLeasePageForm");
%>

<HTML>
<HEAD>
<TITLE>factsLeasePageScroll_right.jsp</TITLE>
</HEAD>

<BODY onscroll="return scroll_right();">
<!-- Opera 7.0 has a z-index bug that prevents the calendar panel from floating above the centerIframe.
A workaround is to move the <iframe> calendar tag from the page bottom to page top.
-->
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="ipopeng.jsp" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;">
</iframe>

<script>
function scroll_right() {
	var xscroll;
	var yscroll;
	if (xscroll!=document.body.scrollLeft)
		top.frames["headers_right"].document.body.scrollLeft=document.body.scrollLeft;
	if (yscroll!=document.body.scrollTop)
		top.frames["scroll_left"].document.body.scrollTop=document.body.scrollTop;
	xscroll = document.body.scrollLeft;
	yscroll=document.body.scrollTop;	
	return true;
}
</script>

<TABLE border="1" style="border-collapse:collapse; border-color:  black; font-size:9pt;">
	<TBODY>
			<!-- Table body -->
			<logic:iterate id="it" name="FactsLeasePageForm" property="page.list" scope="session"> 
				<%
					FactsLeaseTO to = (FactsLeaseTO) it;
					Integer pos = to.getDocID();
					String docNumber = to.getDocNumber();
					java.util.ArrayList statusList = to.getStatuses();
				%>
				<tr>
				<%
					if(statusList != null){
						for (java.util.Iterator iter = statusList.iterator(); iter.hasNext();) {
							FactsLeaseColStatusDogOnDate status = (FactsLeaseColStatusDogOnDate) iter.next();
				%>
							<td nowrap title="по договору: <%= docNumber + status.getHintCharge()%>" align="middle" style="width: 5pt;<%= getColorBG(status.getColorCharge())%>">нч</td>
							<td nowrap title="по договору: <%= docNumber + status.getHintSF()%>" align="middle" style="width: 5pt;<%= getColorBG(status.getColorSF())%>">сф</td>
							<td nowrap title="по договору: <%= docNumber + status.getHintCWA()%>" align="middle" style="width: 5pt;<%= getColorBG(status.getColorCWA())%>">ав</td>
							<td nowrap title="по договору: <%= docNumber + status.getHintPay()%>" align="middle" style="width:5pt; border-right-width:1.5pt; border-right-color:black;<%= getColorBG(status.getColorPay())%>">пл</td>
					<%  }  %>
				<%  }  %>			 	
				</tr>
			</logic:iterate>

	</TBODY>
</TABLE>
</BODY>

</HTML>
<% //counter.finish("PERF.scroll_right"); %>