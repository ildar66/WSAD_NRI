<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<logic:equal name="mapState" value="1" scope="session">
	<html:link page="/PositionListMap.do?imageFromCache=true" styleClass="navigator"><bean:message key="label.menu.map"/></html:link> 
</logic:equal>

<logic:equal name="mapbyPositionState" value="1" scope="session">
	<%com.hps.july.siteinfo.formbean.PositionOnMapForm form = 
	(com.hps.july.siteinfo.formbean.PositionOnMapForm)session.getAttribute("PositionOnMapForm");
	%>
	<html:link href="<%=form.getFrom()%>" styleClass="navigator"><bean:message key="<%=form.getLabelKey()%>"/> </html:link>&nbsp;
	<july:sepmark/>
	<html:link page="/PositionOnmap.do?imageFromCache=true" styleClass="navigator"><bean:message key="label.position.positionAndComlines"/></html:link> 
</logic:equal>

<logic:equal name="mapState" value="0" scope="session">
	<logic:equal name="mapbyPositionState" value="0" scope="session">
		<html:link page="/ShowPositionList.do" styleClass="navigator"><bean:message key="label.position"/></html:link> 
	</logic:equal>
</logic:equal>
