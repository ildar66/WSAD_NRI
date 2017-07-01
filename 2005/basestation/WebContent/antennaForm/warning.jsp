<%@ page language = "java" %>
<%@ page import="com.hps.july.persistence.*"%>
<%@ page import="com.hps.july.basestation.formbean.AntennaForm"%>
<%@ page import="com.hps.july.basestation.formbean.SectorForm"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%
	String gColSpan = "2";
	AntennaForm dForm=(AntennaForm)pageContext.findAttribute("AntennaForm");
	boolean hasLinks=dForm.hasSectorLinks();
%>

<tr>
	<td class="title" colspan="2">
		<%if(hasLinks){%><FONT class="attention"><B><bean:message key="AntennaForm.warning.hasSectorLinks" /></B></FONT><br><%}%>
		<%if(hasLinks){%><FONT class="attention"><B><bean:message key="confirm.delete" /></B></FONT><%}%>
	</td>
</tr>





