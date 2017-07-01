<%@ page language = "java" import="com.hps.july.security.formbean.DivisionListForm" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<bean:write name="divisionLookup" property="companyName"/>:&nbsp;

<%
DivisionListForm form = (DivisionListForm)session.getAttribute("divisionLookup");
int countLevel = form.getCountLevel();
int[] history = form.getHistory();
for(int i=0; i<=countLevel; i++){
	if(i != countLevel){%>
	<a href="divisionLookup.do?upparent=<%=history[i]%>&countLevel=<%=i%>">
	<% if(i == 0){%>
	<bean:message key="label.division.direction"/></a><july:sepmark/>
	<%} else if(i == 1){%>
	<bean:message key="label.division.department"/></a><july:sepmark/>
	<%} else if(i == 2){%>
	<bean:message key="label.division.dept"/></a><july:sepmark/>
	<%} else if(i == 3){%>
	<bean:message key="label.division.group"/></a><july:sepmark/>
	<%}}
	else{
		if(i == 0){%>
		<july:currmark><bean:message key="label.division.direction"/></july:currmark>
		<%} else if(i == 1){%>
		<july:currmark><bean:message key="label.division.department"/></july:currmark>
		<%} else if(i == 2){%>
		<july:currmark><bean:message key="label.division.dept"/></july:currmark>
		<%} else if(i == 3){%>
		<july:currmark><bean:message key="label.division.group"/></july:currmark>
<%}}}%>

