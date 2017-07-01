<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%  String gColSpan = ""+request.getAttribute("colspan");
	String trailcomMapUrl = com.hps.july.util.AppUtils.getNamedValueString("PathMapTrailcom");
	String ruser = request.getRemoteUser();
%>
<tr class="title">
  <td colspan="<%= gColSpan %>">
     <TABLE class="buttons">
        <TR class="title">
           <TD class="buttons">
		<alex:hasAccess href="/ProcessComlineR.do" >
			<html:link page='/EditComlineR.do?action=Add'><IMG alt='<bean:message key="ComlineList.buttons.add"/>' src="/images/plus.gif" border=0></html:link>
		</alex:hasAccess>
		<IMG alt="" src="/images/empty.gif" width=3 border=0>
		<july:backbutton/>
		&nbsp;
		<image name="onMap" src="/images/map.gif" alt="<bean:message key="ComlineList.buttons.map"/>" onclick='determineMaps("<%=trailcomMapUrl%>","<%=ruser%>");' />
	</TD>
	<TD class="navigator">
		<july:navigator/>
	</TD>
</TR>
</TABLE>
</TD>
</tr>
