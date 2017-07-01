<%@ page import="com.hps.july.sitedoc.formbean.SiteDocForm"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.*"%>
<%@ page import="com.hps.july.persistence.SiteDocType"%>
<%@ page import="com.hps.july.sitedoc.valueobject.DocObjectDef"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%
	DocObjectDef odef = DocObjectDef.getDef(session);
	String clsp;
	if(request.getAttribute("colspan")==null){
		clsp="2";
	} else {
		clsp=(Integer.parseInt(""+request.getAttribute("colspan"))-1)+"";
	}
	String canUpdate=(odef.isEquipment())?"true":"false";
%>

<tr>
<td colspan="<%=clsp%>" style="padding:0px;"><table border=0 width="100%" class="main">
<tr>
	<td class="text" width="25%"><bean:message key="sitedoclist.show"/>:</td>
	<td>
		<july:radio styleClass="editcheckbox" property="searchBy" value="P" styleId="isNetZoneCh" insertable="<%=canUpdate%>" updatable="<%=canUpdate%>"/>
		<bean:message key="sitedoclist.allbyposition"/>
		&nbsp;&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" value="O" styleId="isNetZoneCh" insertable="<%=canUpdate%>" updatable="<%=canUpdate%>"/>
		<bean:message key="sitedoclist.allbyobject"/>
		&nbsp;&nbsp;&nbsp; <july:searchbutton/>
	</td>
</tr>
</table></td>
</tr>
