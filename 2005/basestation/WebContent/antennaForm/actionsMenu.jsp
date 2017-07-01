<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.basestation.valueobject.*,com.hps.july.siteinfo.valueobject.*,com.hps.july.basestation.formbean.*" %>
<%@ page import="com.hps.july.persistence.AntennaAccessBean" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants" %>
<%@ page import="com.hps.july.constants.Applications" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.ObjectType" %>

<logic:equal name="AntennaForm" property="action" value="Edit">
<%
//StateManager sm=(StateManager)session.getAttribute(AppConstants.PARAM_STATE_MANAGER);
boolean isFromSiteinfo=false;//sm.getRootState().getApp()==Applications.SITEINFO;

AntennaForm form1=(AntennaForm)pageContext.findAttribute("AntennaForm");
//String positionId=((AntennaAccessBean)form1.getDataBean(request)).getEquipment().getPositionKey().storageplace+"";
String linkCopy1="/EditCopyAntenna.do";
/*
if(form1.getPath().equals("/EditAntenna_FBS")){
  linkCopy1="/Edit_CopyAntenna_FBS.do";
}else if(form1.getPath().equals("/EditAntenna_PBS")){
  linkCopy1="/Edit_CopyAntenna_PBS.do";
}else if(form1.getPath().equals("/EditAntenna_E")){
  linkCopy1="/Edit_CopyAntenna_E.do";
}
*/
String journalUrl=AppConstants.BASE_POSITION+"/ShowJournalList.do?objecttype="+ObjectType.Antenna+"&objectid="+form1.getIdanten();
String onclickStr="openWindow('"+journalUrl+"');return false;";
%>

<tr>
<td class="text"><bean:message key="label.position.actions"/>:</td>
<td>

<%if(!isFromSiteinfo){%>
<alex:hasAccess href="<%=linkCopy1%>" >

  <july:link page="<%=linkCopy1%>">
     <bean:message key="label.basestation.copy"/>
  </july:link>

</alex:hasAccess>
<%}%>
<%--журнал изменений--%>
<alex:hasAccess href="/ShowJournalList.do" file="/WEB-INF/web_siteinfo.xml">

  <july:link onclick="<%=onclickStr%>"    page="<%=journalUrl%>"  >
       <bean:message key="label.menu.journal"/>
  </july:link>
</alex:hasAccess>

</td>
</tr>

</logic:equal>