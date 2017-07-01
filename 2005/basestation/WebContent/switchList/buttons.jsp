<%@ page import="com.hps.july.basestation.formbean.SwitchListForm"%>
<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%
	String gColSpan = request.getAttribute("colspan")+"";
	SwitchListForm lForm=(SwitchListForm)pageContext.findAttribute("SwitchListForm");
%>
<tr class="title">
  <td colspan="<%= gColSpan %>">
     <TABLE class="buttons">
        <TR class="title">
           <TD class="buttons">
<%
String editFactAction="/EditFactSwitch.do";
%>
<alex:hasAccess href="/EditFactSwitch.do" >
 <html:link page='/EditFactSwitch.do?action=Add'>
   <IMG alt='<bean:message key="SwitchList.buttons.addFact"/>' src="/images/plus.gif" border=0>
 </html:link>
</alex:hasAccess>

<IMG alt="" src="/images/empty.gif" width=3 border=0>

<july:backbutton page="/main.do"/>
&nbsp;
<image name="onMap" src="/images/map.gif" alt="<bean:message key="SwitchList.buttons.map"/>" onclick="determineMaps();" />
</TD>
<TD class="navigator">
   <july:navigator/>
</TD>
</TR>
</TABLE>
</TD>
</tr>

