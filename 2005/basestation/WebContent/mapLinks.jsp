<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
String map = (String)session.getAttribute("mapState");
String mapbyPosition = (String)session.getAttribute("mapbyPositionState");
if(map.equals("1")){%>
	<html:link page="/PositionListMap.do?mapMenu=0" styleClass="navigator"><bean:message key="label.menu.map"/></html:link> 

<% } else if(mapbyPosition.equals("1")){%>
<html:link page="/ShowPositionList.do" styleClass="navigator"><bean:message key="label.position"/> </html:link>&nbsp;<july:sepmark/>
	<html:link page="/PositionOnmap.do?positionMenu=0" styleClass="navigator"><bean:message key="label.position.positionAndComlines"/></html:link> 

<% } else {%>
<html:link page="/ShowPositionList.do" styleClass="navigator"><bean:message key="label.position"/></html:link> 
<%}%>
