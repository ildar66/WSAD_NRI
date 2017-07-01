<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants,
                 com.hps.july.constants.Applications,
                 com.hps.july.jdbcpersistence.lib.*"%>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	String base= AppConstants.BASE_PROJECT ;
%>

<html:link href='<%= base + "/projectList.do" %>' styleClass="navigator">
   <bean:message key="label.project"/>
</html:link>






