<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessRtypeWN.do">

<table class="main">
	
	<tr><td colspan="3">
	<TABLE class="main" border="0" cellpadding="0" cellspacing="0" vAlign=top height="100%">
		<TR class="title" style="height:15">
		<TD class="title">
		<july:statenavigator/>
		</TD>
		</TR>
	</table>
	</td></tr>
    <july:separator/>
    
	<july:formbuttons/>
    
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.choosertype.type"/>:</td>
        <td class="text">
		<a href="ProcessRtypeWN.do?rtype=basestation"><bean:message key="label.choosertype.basestation"/></a><br/>
		<a href="ProcessRtypeWN.do?rtype=antenna"><bean:message key="label.choosertype.antenna"/></a><br/>
        <a href="ProcessRtypeWN.do?rtype=repeater"><bean:message key="label.choosertype.repeater"/></a><br/>
		<a href="ProcessRtypeWN.do?rtype=cable"><bean:message key="label.choosertype.cabel"/></a><br/>
		<a href="ProcessRtypeWN.do?rtype=other"><bean:message key="label.choosertype.other"/></a><br/>
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

