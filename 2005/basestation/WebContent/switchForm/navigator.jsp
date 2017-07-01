<%@ page import="com.hps.july.web.util.ParamsParser,
                 com.hps.july.basestation.APPStates"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<% String gColSpan = request.getAttribute("colspan") + "";
int state = ParamsParser.getState( pageContext );%>



<jsp:include page="/switchList/navigator.jsp" flush="true"/>
<july:sepmark/>
<%if(state==APPStates.SwitchForm){%>
  <july:actionname/>
<%}else{%>
  <july:link page="/EditSwitch.do" styleClass="navigator">
    <bean:message key="menu.switch"/>
  </july:link>
<%}%>
