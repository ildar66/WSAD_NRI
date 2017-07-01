<%@	page language =	"java" %>
<%@	page contentType = "text/html; charset=windows-1251" %>
<%@	page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.arenda.*" %>
<%@ page import="java.text.*"%>
<%@	taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@	taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"	%>
<%@	taglib uri="/WEB-INF/struts-html.tld" prefix="html"	%>
<%@	taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%!
//форматируем дату:
SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
private String dateStr(java.sql.Date date) {
	if(date==null) 
		return ("&nbsp;");
	else
		return	format.format (date);
}
%>
<HTML>
<HEAD>
	<TITLE>factsLeasePageHeaders_right.jsp</TITLE>
</HEAD>
<BODY>
<TABLE border="1" style="border-collapse:collapse; border-color:  black; font-size:9pt;">
	<TBODY>
		<%--TR>
				<TH nowrap style="width: 60px;">Коммент.	</TH>
			<logic:equal name="LicenceListForm"	property="showColumn.isFas"	value="true" scope="session">
				<TH nowrap style="width: 60px;">ФАС				</TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isRutsr" value="true"	scope="session">
				<TH nowrap style="width: 60px;">РУЦР			</TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isAir_gr" value="true" scope="session">
				<TH nowrap style="width: 60px;">Аэро-граж</TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isAir_w" value="true"	scope="session">
				<TH nowrap style="width: 60px;">Аэро-воен</TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isGps"	value="true" scope="session">
				<TH nowrap style="width: 60px;">ГПС				 </TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isGasn" value="true" scope="session">
				<TH nowrap style="width: 60px;">ГАСН		   </TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isSes"	value="true" scope="session">
				<TH nowrap style="width: 60px;">СЭС			   </TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isVch" value="true" scope="session">
				<TH nowrap style="width: 60px;">в\ч				   </TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isTu" value="true" scope="session">
				<TH nowrap style="width: 60px;">ТУ				  </TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isOtvod" value="true" scope="session">
				<TH nowrap style="width: 60px;">Акт	Земл. </TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isKadastr"	value="true" scope="session">
				<TH nowrap style="width: 60px;">Кадастр	   </TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isProperty" value="true" scope="session">
				<TH nowrap style="width: 60px;">Дог	имущ. </TH>
			</logic:equal>
		</TR--%>
		<TR>		
		<logic:iterate id="it" name="FactsLeasePageForm" property="page.headers" scope="session">
			<%java.sql.Date to = (java.sql.Date) it; //int pos = to.getStoragePlace();%>
			<td nowrap align="middle" style="width:5pt;border-right-width: 1.5pt;border-right-color: black;">&nbsp;<%=dateStr(to)%></td>
		</logic:iterate>
		</TR>				
	</TBODY>
</TABLE>
</BODY>
</HTML>
