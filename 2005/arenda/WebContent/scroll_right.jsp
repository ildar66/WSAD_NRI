<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
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

<%
    TimeCounter counter = new TimeCounter("PERF.scroll_right");//temp
	LicenceListForm listForm = (LicenceListForm)session.getAttribute("LicenceListForm");
	Integer operator = listForm.getOperator();
    boolean isDateModified = listForm.getIsDateModified();
    boolean isDopFilter = listForm.getIsDopFilter();
	boolean isDM_DF = isDopFilter && isDateModified;
	//System.out.println("operator=" + operator);//temp
	final String displayNone = "display: none;";
	String displayFas= "", displayRutsr= "", displayAir_gr= "", displayAir_w= "", displayGps= "", displayGasn= "";
	String displaySes= "", displayVch= "", displayTu= "", displayOtvod= "", displayKadastr= "", displayProperty = "";
	if(!listForm.getShowColumn().getIsFas())
		displayFas=displayNone;
	if(!listForm.getShowColumn().getIsRutsr())
		displayRutsr=displayNone;
	if(!listForm.getShowColumn().getIsAir_gr())
		displayAir_gr=displayNone;
	if(!listForm.getShowColumn().getIsAir_w())
		displayAir_w=displayNone;
	if(!listForm.getShowColumn().getIsGps())
		displayGps=displayNone;
	if(!listForm.getShowColumn().getIsGasn())
		displayGasn=displayNone;
	if(!listForm.getShowColumn().getIsSes())
		displaySes=displayNone;
	if(!listForm.getShowColumn().getIsVch())
		displayVch=displayNone;
	if(!listForm.getShowColumn().getIsTu())
		displayTu=displayNone;
	if(!listForm.getShowColumn().getIsOtvod())
		displayOtvod=displayNone;
	if(!listForm.getShowColumn().getIsKadastr())
		displayKadastr=displayNone;
	if(!listForm.getShowColumn().getIsProperty())
		displayProperty =displayNone;
%>

<HTML>
<HEAD>
<TITLE>scroll_right.jsp</TITLE>
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
function editDate(id, dataStr, positionStr, typeStr){
	hrefStr = "Calendar.jsp?id=" + id + "&operatorStr=<%=operator%>&dataStr="+dataStr + "&positionStr=" + positionStr + "&typeStr=" +  typeStr;
	window.open(hrefStr, "pCalendar", "top=200, left=200, width=220, height=240, scrollbars=no, resizable=no, menubar=no, titlebar=no, toolbar=no, directories=no");
	//alert(id);
	return false;
}
function editNote(id, dataStr, positionStr, typeStr){
	hrefStr = "LicenceDialog.do?action=Edit&id=" + id + "&operator=<%=operator%>&dataStr="+dataStr + "&position=" + positionStr + "&typelicence=" +  typeStr;
	window.open(hrefStr, "licenceNote", "top=200, left=400, width=550, height=470, scrollbars=yes, resizable=yes, menubar=no, titlebar=no, toolbar=no, directories=no").focus();
	//alert(id);
	return false;
}
</script>

<TABLE border="1" style="border-collapse:collapse; border-color:  black; font-size:10pt;">
	<TBODY>
			<!-- Table body -->
<%--
			<logic:iterate id="it" name="LicenceListForm" property="page.list" scope="session" indexId="idx">
				<%Object[] items = (Object[]) it; Integer position = (Integer)items[15];%>
				<tr>
					<%for (int i = 3; i < 15; i++) {%>
						<%
								String colorBG = "";
								int sizeM = items.length;
								if( sizeM > 20) {
									colorBG = (String)items[i + 13];
									if(colorBG.equals("Y"))
										colorBG = "background: silver;";
								}
						%>
						<%if(items[i] == null){
							String nullStr = "...";
						%>
							<td nowrap style="width: 60px; <%= colorBG%>" id="<%=idx%>n<%=i%>" align="right" title="Вызов календаря">
								<A style="text-decoration: none;" href='Calendar.jsp?id=<%=idx%>n<%=i%>&operatorStr=<%=operator%>&dataStr=&positionStr=<%=position%>&typeStr=<%=(i-2)%>' onclick='window.open(this.href, "pCalendar", "top=200, left=200, width=220, height=240, scrollbars=no, resizable=no, menubar=no, titlebar=no, toolbar=no, directories=no"); return false;'>
									<%=nullStr%>
								</A>
							</td>
						<%}else{
							String dataStr = format.format ((java.sql.Date)items[i]);
						%>
							<td nowrap style="width: 60px; <%= colorBG%>" id="<%=idx%>n<%=i%>" align="right" title="Вызов календаря">
								<A style="text-decoration: none;" href='Calendar.jsp?id=<%=idx%>n<%=i%>&operatorStr=<%=operator%>&dataStr=<%=dataStr%>&positionStr=<%=position%>&typeStr=<%=(i-2)%>' onclick='window.open(this.href, "pCalendar", "top=200,left=200,width=220,height=240,resizable=yes,status=no,toolbar=no,menubar=no,location=no,scrollbars=yes,titlebar=no"); return false;'>
									<%=dataStr%>
								</A>
							</td>
						<%}%>
					<%}%>
				</tr>
			</logic:iterate>
--%>

			<!-- Table body -->
			<logic:equal name="LicenceListForm" property="showColumn.isEdit" value="true">
			<logic:iterate id="it" name="LicenceListForm" property="page.list" scope="session"> 
				<%
					LicenciesTO to = (LicenciesTO) it;
					int pos = to.getStoragePlace();
					String colorStr = colorNULL;
					String isNoteFlag = to.getIsNote().equals("Y")?"+" : "&nbsp;";
				%>
				<tr>
						<!--Note -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getNoteM()); 
						%>
						<td nowrap  align="middle" style="width: 60px;<%= colorStr%>" id="<%=pos%>t13" ondblclick="editNote(this.id, this.innerText, <%=pos%>, 13)">
							<%=isNoteFlag%>
						</td>
						<!-- Fas -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getFasM()); 
						%>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayFas%>" id="<%=pos%>t1" ondblclick="editDate(this.id, this.innerText, <%=pos%>, 1)">
							<%=dateStr(to.getFas())%>
						</td>
						<!-- Rutsr -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getRutsrM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayRutsr%>" id="<%=pos%>t2" ondblclick="editDate(this.id, this.innerText, <%=pos%>, 2)">
							<%=dateStr(to.getRutsr())%>
						</td>
						<!-- Air_gr -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getAir_grM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayAir_gr%>" id="<%=pos%>t3" ondblclick="editDate(this.id, this.innerText, <%=pos%>, 3)">
							<%=dateStr(to.getAir_gr())%>
						</td>
						<!-- Air_w -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getAir_wM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayAir_w%>" id="<%=pos%>t4" ondblclick="editDate(this.id, this.innerText, <%=pos%>, 4)">
							<%=dateStr(to.getAir_w())%>
						</td>
						<!-- Gps -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getGpsM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayGps%>" id="<%=pos%>t5" ondblclick="editDate(this.id, this.innerText, <%=pos%>, 5)">
							<%=dateStr(to.getGps())%>
						</td>
						<!-- Gasn -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getGasnM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayGasn%>" id="<%=pos%>t6" ondblclick="editDate(this.id, this.innerText, <%=pos%>, 6)">
							<%=dateStr(to.getGasn())%>
						</td>
						<!-- Ses -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getSesM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displaySes%>" id="<%=pos%>t7" ondblclick="editDate(this.id, this.innerText, <%=pos%>, 7)">
							<%=dateStr(to.getSes())%>
						</td>
						<!-- в\ч -->
						<% if(isDM_DF)
									colorStr = getColorBG(to.getVchM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayVch%>" id="<%=pos%>t8" ondblclick="editDate(this.id, this.innerText, <%=pos%>, 8)">
							<%=dateStr(to.getVch())%>
						</td>
						<!-- Tu -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getTuM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayTu%>" id="<%=pos%>t9" ondblclick="editDate(this.id, this.innerText, <%=pos%>, 9)">
							<%=dateStr(to.getTu())%>
						</td>
						<!-- Otvod -->
						<% if(isDM_DF)
									colorStr = getColorBG(to.getOtvodM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayOtvod%>" id="<%=pos%>t10" ondblclick="editDate(this.id, this.innerText, <%=pos%>, 10)">
							<%=dateStr(to.getOtvod())%>
						</td>
						<!-- Kadastr -->
						<% if(isDM_DF)
									colorStr = getColorBG(to.getKadastrM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayKadastr %>" id="<%=pos%>t11" ondblclick="editDate(this.id, this.innerText, <%=pos%>, 11)">
							<%=dateStr(to.getKadastr())%>
						</td>
						<!-- Property -->
						<% if(isDM_DF)
									colorStr = getColorBG(to.getPropertyM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayProperty%>" id="<%=pos%>t12" ondblclick="editDate(this.id, this.innerText, <%=pos%>, 12)">
							<%=dateStr(to.getProperty())%>
						</td>
				</tr>
			</logic:iterate>
			</logic:equal>
			<!-- Режим просмотра -->
			<logic:equal name="LicenceListForm" property="showColumn.isEdit" value="false">
			<logic:iterate id="it" name="LicenceListForm" property="page.list" scope="session"> 
				<%
					LicenciesTO to = (LicenciesTO) it;
						int pos = to.getStoragePlace();
						String colorStr = colorNULL;
						String isNoteFlag = to.getIsNote().equals("Y")?"+" : "&nbsp;";
				%>
				<tr>
						<!--Note -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getNoteM()); 
						%>
						<td nowrap  align="middle" style="width: 60px;<%= colorStr%>" id="<%=pos%>t13" ondblclick="editNote(this.id, this.innerText, <%=pos%>, 13)">
							<%=isNoteFlag%>
						</td>
						<!-- Fas -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getFasM()); 
						%>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayFas%>">
							<%=dateStr(to.getFas())%>
						</td>
						<!-- Rutsr -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getRutsrM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayRutsr%>">
							<%=dateStr(to.getRutsr())%>
						</td>
						<!-- Air_gr -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getAir_grM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayAir_gr%>">
							<%=dateStr(to.getAir_gr())%>
						</td>
						<!-- Air_w -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getAir_wM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayAir_w%>">
							<%=dateStr(to.getAir_w())%>
						</td>
						<!-- Gps -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getGpsM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayGps%>">
							<%=dateStr(to.getGps())%>
						</td>
						<!-- Gasn -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getGasnM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayGasn%>">
							<%=dateStr(to.getGasn())%>
						</td>
						<!-- Ses1800 -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getSesM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displaySes%>">
							<%=dateStr(to.getSes())%>
						</td>
						<!-- Ses800 -->
						<% if(isDM_DF)
									colorStr = getColorBG(to.getVchM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayVch%>">
							<%=dateStr(to.getVch())%>
						</td>
						<!-- Tu -->
						<% if(isDM_DF)
								colorStr = getColorBG(to.getTuM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayTu%>">
							<%=dateStr(to.getTu())%>
						</td>
						<!-- Otvod -->
						<% if(isDM_DF)
									colorStr = getColorBG(to.getOtvodM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayOtvod%>">
							<%=dateStr(to.getOtvod())%>
						</td>
						<!-- Kadastr -->
						<% if(isDM_DF)
									colorStr = getColorBG(to.getKadastrM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayKadastr %>">
							<%=dateStr(to.getKadastr())%>
						</td>
						<!-- Property -->
						<% if(isDM_DF)
									colorStr = getColorBG(to.getPropertyM());
						 %>
						<td nowrap style="width: 60px;<%= colorStr%><%= displayProperty%>">
							<%=dateStr(to.getProperty())%>
						</td>
				</tr>
			</logic:iterate>
			</logic:equal>

	</TBODY>
</TABLE>
</BODY>

</HTML>
<% counter.finish("PERF.scroll_right"); %>