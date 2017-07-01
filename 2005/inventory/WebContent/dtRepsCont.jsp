<HTML>
<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.web.util.*, com.hps.july.basestation.formbean.*"%>
<BODY onload="scrollFrame();" leftmargin=0 topmargin=0 onscroll="scrolling();">
<style>
TD.tableCell {
	text-align: center;
}
TD {
	border-style: solid; 
	border-color: green; 
	border-width: 1;
}
TABLE.construct {
	border-style: solid; 
	border-color: red; 
	border-width: 0;
}
</style>

<script>
var xscroll=0;
var titleFrameName = "dtRepsTitleIFrame";

function scrolling() 
{
	if (xscroll!=document.body.scrollLeft)
	{
	if (parent.document.frames[titleFrameName])
	parent.document.frames[titleFrameName].document.body.scrollLeft=document.body.scrollLeft;
	}
	xscroll=document.body.scrollLeft;
}

function scrollFrame()
{
	if (parent.document.frames[titleFrameName] && parent.document.readyState=="complete")
	 document.body.scrollLeft=parent.document.frames[titleFrameName].document.body.scrollLeft;
}

</script>
<table  width="440" cellspacing="0" cellpadding="0" style="font-family:tahoma,arial;font-size:8pt;">
	<logic:iterate id="it" name="ConfigEqEditForm" property="dtRepList" type="com.hps.july.inventory.valueobject.DtRepiterVO">
		<logic:present name="it">
			<tr>
				<td width="80" align="center"><bean:write name="it" property="num" filter="true"/></td> 
				<td width="120" align="center"><bean:write name="it" property="donorSector" filter="true"/></td> 
				<td width="120" align="center"><bean:write name="it" property="connType" filter="true"/></td> 
				<td width="120" align="center"><bean:write name="it" property="state" filter="true"/></td> 
			</tr>	
		</logic:present>
	</logic:iterate>
</table>				
</BODY>
</HTML>
