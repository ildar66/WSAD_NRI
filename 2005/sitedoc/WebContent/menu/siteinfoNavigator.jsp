<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.*"%>
<%@ page import="com.hps.july.sitedoc.valueobject.*"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%
DocObjectDef odef = DocObjectDef.getDef(session);
int id = odef.getObjId();
String positionBase=AppConstants.BASE_POSITION;
String positionLink=positionBase+"/EditPosition.do?action=View&storageplace="+id;
String equipmentLink=positionBase+"/ShowEquipmentList.do";
String positionListLink=positionBase+"/ShowPositionList.do";
%>
<html:link href="<%=positionListLink%>" styleClass="navigator">
	<bean:message bundle="siteinfoResources" key="label.position"/>
</html:link>
<%
if(!odef.isPosition()) {
%>
<july:sepmark/>
<html:link href="<%=positionLink%>"  styleClass="navigator">
	<bean:message bundle="siteinfoResources" key="label.workresponsibility.position"/>
</html:link>
<july:sepmark/>
<html:link href="<%=equipmentLink%>" styleClass="navigator">
	<bean:message bundle="siteinfoResources" key="label.equipment"/>
</html:link>
<%
}
%>


