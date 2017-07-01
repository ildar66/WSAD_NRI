<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.arenda.*,com.hps.july.arenda.valueobject.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<HTML>
<HEAD>
<TITLE>scroll_left.jsp</TITLE>
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
function showInfo(positionStr){
	hrefStr = 'LicenceInfo.do?positionStr='+positionStr;
	window.open(hrefStr, 'pWindow', 'top=100,	left=150, width=650, height=310, scrollbars=yes, resizable=yes, menubar=no').focus();
	return false;
}
function showTerrabyteWin(positionStr) {
	var terrabyteWin = window.open('<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?type=pos&id='+ positionStr + '&uid=<bean:write name="LicenceListForm" property="userName" scope="session"></bean:write>', "terrabyteWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,titlebar=yes,toolbar=no");
	if(terrabyteWin) terrabyteWin.focus();
}

</script>
<TABLE border="1" width="100%" style="border-collapse:collapse; border-color:  black; font-size:10pt;"	>
	<TBODY>
			<!-- Table body -->
			<logic:iterate id="it" name="LicenceListForm" property="page.list" scope="session">
				<%LicenciesTO to = (LicenciesTO) it; int pos = to.getStoragePlace();%>
				<tr>
						<td nowrap style="width: 20px;" align="center">
								<a href="#" title="Просмотр позиции" onclick="showInfo(<%= pos%>); return false;">
									<B>iii</B></a>
						</td>
						<td nowrap style="width: 20px;" align="center">
								<a href="#" title="Документы" onclick="showTerrabyteWin(<%= pos%>); return false;">
									<B> Д </B></a>									
						</td>
						<td nowrap style="width: 70px;"><%=to.getGsmId()%> </td>
						<td nowrap style="width: 70px;"><%=to.getDampsId()%>  </td>
						<td nowrap style="width: 400px;"><%=to.getName()%></td>
				</tr>
			</logic:iterate>
	</TBODY>
</TABLE>
</BODY>

</HTML>
