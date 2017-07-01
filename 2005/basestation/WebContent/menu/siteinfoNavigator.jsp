<%@ page import="com.hps.july.constants.Applications,
                 com.hps.july.jdbcpersistence.lib.*"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%--
DebugSupport.printlnTest("!!!!!!siteinfoNavigator.jsp started");
--%>

<%
//DebugSupport.printlnTest("!!!!!!siteinfoNavigator.jsp started");
//DebugSupport.printlnTest("!!!!!!siteinfoNavigator.jsp "+AppConstants.APP_HOME+"="+session.getAttribute(AppConstants.APP_HOME));
int app=((Integer)session.getAttribute(AppConstants.APP_HOME)).intValue();
String positionId=(String)session.getAttribute("positionId");
//DebugSupport.printlnTest("!!!!!!siteinfoNavigator.jsp positionId="+positionId);

String positionBase=AppConstants.BASE_POSITION;
String positionLink=positionBase+"/EditPosition.do?action=View&storageplace="+positionId;
String equipmentLink=positionBase+"/ShowEquipmentList.do";
String positionListLink=positionBase+"/ShowPositionList.do";
%>
<html:link href="<%=positionListLink%>" styleClass="navigator">
   <bean:message bundle="siteinfoResources" key="label.position"/>
</html:link>

<july:sepmark/>

<html:link href="<%=positionLink%>"  styleClass="navigator">
   <bean:message bundle="siteinfoResources" key="label.workresponsibility.position"/>
</html:link>

<july:sepmark/>

<html:link href="<%=equipmentLink%>" styleClass="navigator">
    <bean:message bundle="siteinfoResources" key="label.equipment"/>
</html:link>


