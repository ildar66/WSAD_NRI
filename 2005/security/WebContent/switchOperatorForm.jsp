<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<html:form action="/SwitchOperator.do">

<input type="hidden" name="action" value=""/>

<table class="main">
<!--
    <tr class="title">
    	<td class="title" colspan="2"><font class="attention"><b>Режим переключения пользователей</b></font></td>
    </tr>
-->
    <tr class="title"><td class="title" colspan="2">&nbsp;</td></tr>
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><FONT class="attention"><B>Режим переключения пользователей</B></FONT></td>
    </tr>

<!--    <july:separator/> -->
    
    <tr>
    	<td colspan="2">
	        <table border=0>
		        <tr><td class="text"><july:reqmark><bean:message key="label.operator.login"/>:</july:reqmark></td>
		        	<td><html:text property="operatorLogin" size="20" onkeypress="if(event.keyCode == 13){ action.click(); return false; }"/></td>
				</tr>
				<tr><td colspan="2" align="right"><html:submit onclick="action.value='Enter';">Ввод</html:submit></td></tr>        
	        </table>
		</td>
    </tr>

    <july:separator/>
    <tr class="title"><td class="title" colspan="2">&nbsp;</td></tr>
    <july:separator/>
     
</table>
	Test Info: <br>
	RemoteUser=<%=request.getRemoteUser()%><br>
	IsUserInRole("administrator")=<%=request.isUserInRole("administrator")%><br>
</html:form>

