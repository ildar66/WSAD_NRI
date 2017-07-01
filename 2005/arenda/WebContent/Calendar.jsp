<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
    String dataStr =  request.getParameter("dataStr");
	String id =  request.getParameter("id");
	String positionStr =  request.getParameter("positionStr");
	String typeStr =  request.getParameter("typeStr");
	String operatorStr=  request.getParameter("operatorStr");
	String flagOperation =  request.getParameter("flagOperation");
%>
<HTML>
<HEAD>
	<TITLE>Календарь</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=Windows-1251">
<script language="javascript" type="text/javascript">
	function Go(strval) {
		/**
		if(strval =='')
			strval = '...';
		strHTML = '<A style=\'text-decoration: none; color: red\' href=\'Calendar.jsp?id=<%=id%>
		&operatorStr=<%=operatorStr%>&dataStr=<%=dataStr%>&positionStr=<%=positionStr%>&typeStr=<%=typeStr%>\' 
		onclick=\'window.open(this.href, \"_blank\", \"top=100, left=100, width=250, height=250, scrollbars=yes, resizable=yes\");return false;\'>'+strval +'</A>';window.opener.document.all["<%=id%>"].innerHTML=strHTML;
		*/
		if(strval =='')
			strval = '&nbsp;';
		window.opener.document.all["<%=id%>"].innerHTML='<DIV style=\'color: red\'>'+strval+'</DIV>';
		Close();
	}
	function Close()
	{
		if(window.opener) {
			window.opener.focus();
		}
		window.close();
	}
function isDate(s)
{
	var a = s.split('.');
	var d = new Date(a[2], parseFloat(a[1]) - 1, a[0]);
	var isDate =  (!isNaN(d)) && (parseFloat(a[0]) == d.getDate()) && (parseFloat(a[1]) == (d.getMonth() + 1)) && (a[2] == d.getFullYear());
	//alert (isDate);
	if(isDate == true || demoform.dc.value==""){
		demoform.dataStr.value=demoform.dc.value;
		demoform.flagOperation.value = 'true';	
		return true;
	}
	else {
		alert ("Формат даты должен быть ДД.ММ.ГГГГ(например 12.01.2005)");
		document.forms(0).dc.focus();
		return false;
	}
}
</script>
</HEAD>
<BODY bgcolor="#dcdcdc">
<!-- Simple huh? just a theme plus an agenda file. -->
<html:errors/>

<FORM name="demoform" action="LicenceProcess.do" onsubmit="return isDate(demoform.dc.value);">
<!--hidden field-->
<INPUT type="hidden" name="dataStr" value="<%=dataStr%>">
<INPUT type="hidden" name="id" value="<%=id%>">
<INPUT type="hidden" name="positionStr" value="<%=positionStr%>">
<INPUT type="hidden" name="typeStr" value="<%=typeStr%>">
<INPUT type="hidden" name="operatorStr" value="<%=operatorStr%>">
<INPUT type="hidden" name="flagOperation" value="<%=flagOperation%>">
<input type="text" name="dc" size="11" value="<%=dataStr%>" >
	<a href="javascript:void(0)" onclick="gfPop.fPopCalendar(document.demoform.dc);return false;" HIDEFOCUS>
		<img name="popcal" align="absbottom" src="/images/calbtn.gif" width="34" height="22" border="0" alt="Открыть календарь"></a>&nbsp;
	<IMG SRC="/images/save.gif" onclick="if(isDate(demoform.dc.value))demoform.submit();" ALT="Сохранить дату" border=0>
<%--
	<IMG SRC="/images/restore.gif" onclick="document.forms(0).dc.value = document.forms(0).dataStr.value;" ALT="Отменить правку" border=0>
--%>&nbsp;
	<IMG SRC="/images/cancel.gif" onclick="Close();" ALT="Отказ и возврат" border=0>
</FORM>


<!--  PopCalendar(tag name and id must match) Tags should sit at the page bottom -->
<iframe width=191 height=195 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="ipopeng.jsp" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;">
</iframe>
	<script language="javascript" type="text/javascript">
		if(document.forms(0).flagOperation.value == 'true'){
			Go(document.forms(0).dc.value);
		}
		else{
			document.forms(0).dc.focus();
		}
	</script>
</BODY>	
</HTML>