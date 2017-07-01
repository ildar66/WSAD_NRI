<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<html:html>
<HEAD>
<TITLE>factsLeasePageBottom.jsp</TITLE>
<link rel="stylesheet" type="text/css" href="/main.css">
</HEAD>
 
<BODY>
<html:errors />
<html:form action="/FactsLeasePage" styleId="thisForm"  target="_top">
	<%--html:hidden property="school" /--%>
<script>
function MoveTo(school)
{ 
	document.thisForm.school.value = school;
    document.body.style.cursor="wait";	
	document.thisForm.submit();
	return false;	
}
</script>

		<TABLE  class="main">
			<TBODY>
				<%--logic:greaterEqual name="FactsLeasePageForm" property="page.size" value="3000">
				<TR >
					<TD style="width: 30%;">&nbsp;</TD>
					<TD align="right">
						<logic:equal name="FactsLeasePageForm" property="page.previousPageAvailable" value="true">
							<INPUT type=button value=" &lt;  " onclick="MoveTo('previous')">
						</logic:equal>
						<logic:equal name="FactsLeasePageForm" property="page.nextPageAvailable" value="true">						
							<INPUT type=button value="  &gt; " onclick="MoveTo('next')">
						</logic:equal>
					</TD>
					<TD align="right">номер старт. записи: <html:text name="FactsLeasePageForm"
						property="start" size="5" />.</TD>
					<TD align="right">макс. записей на странице: <html:text name="FactsLeasePageForm"
						property="count" size="5" />.</TD>
					<TD align="right"><INPUT type=button value="Обновить" onclick="MoveTo('')"></TD>
				</TR>
				</logic:greaterEqual--%>
				<TR>
					<TD align="center" class="copyright" style="font-size:10pt;" colspan="5">
						записей на странице: <B><bean:write name="FactsLeasePageForm"	property="page.size" /></B>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&copy; 2002 Copyright&nbsp;&nbsp;BeeLine&nbsp;&nbsp;
					</TD>
				</TR>
			</TBODY>
		</TABLE>

</html:form>
</BODY>
</html:html>
