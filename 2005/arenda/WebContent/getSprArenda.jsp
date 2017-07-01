<%@ page language = "java" %> 
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<table class="main">


	<tr class="normal">
		<td class="text">&nbsp;</td>
	</tr>
	
	<tr class="normal">
		<td class="text">
			<html:link page="/GetSprArendaResult.do"><bean:message key="label.getsprarenda"/></html:link>
		</td>
	</tr>
	
	<tr class="normal">
		<td class="text">&nbsp;</td>
	</tr>
	
	<july:separator/>
	
</table>