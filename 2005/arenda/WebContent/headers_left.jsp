<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.arenda.*" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%!
private String isUp(String aSort, String name) {
 if(aSort.startsWith(name)) {
	 if(aSort.endsWith("desc")) 
		return (" <img src='/images/up.gif'  border='0' alt='по возрастанию'> ");
	 else
		return (" <img src='/images/down.gif'  border='0' alt='по убыванию'> "); 
 }
 else return ("");      
}
%>

<html:html>
<HEAD>
	<TITLE>headers_left.jsp</TITLE>
</HEAD>

<BODY>
<html:errors />
<%
	LicenceListForm listForm = (LicenceListForm)session.getAttribute("LicenceListForm");
	String sortBy = listForm.getSortBy();
%>
<html:form action="/ShowListLicence" styleId="thisForm"  target="_top">
	<html:hidden property="sortBy" />
	<html:hidden property="school" />
<script>
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.thisForm.school.value = "";	
    document.body.style.cursor="wait";
	document.thisForm.submit();
}
</script>

<TABLE width="100%" border="1" style="border-collapse:collapse; border-color:  black; font-size:10pt;">
	<TBODY>
		<TR>
			<TH nowrap style="width: 20px;">&nbsp;</TH>
			<TH nowrap style="width: 20px;">&nbsp;</TH>
			<TH nowrap style="width: 70px;">
				<A title="GSM"	href="javascript:SortBy('gsmid')">GSM </A><%=isUp(sortBy, "gsmid")%>
			</TH>
			<TH nowrap style="width: 70px;">
				<A title="DAMPS"	href="javascript:SortBy('dampsid')">DAMPS </A><%=isUp(sortBy, "dampsid")%>
			</TH>
			<TH nowrap style="width: 400px;" align="left">
				<A title="наименование"	href="javascript:SortBy('name')">наименование</A><%=isUp(sortBy, "name")%>
			</TH> 
		</TR>
	</TBODY>
</TABLE>

</html:form>
</BODY>
</html:html> 
