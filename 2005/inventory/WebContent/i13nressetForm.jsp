<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.inventory.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	int pstate = ParamsParser.getState( pageContext );
	String action = null;
	String formName = null;
	String listFormName = null;
	switch( pstate )
	{
	case APPStates.EDITIRS:
		action = "/ProcessI13nResset.do";
		listFormName = "I13nRessetListForm";
		formName = "I13nRessetForm";
		break;
	case APPStates.EDITIRAS:
		action = "/ProcessI13nActResset.do";
		listFormName = "I13nActRessetListForm";
		formName = "I13nActRessetForm";
		break;
	}
%>

<july:editform action="<%=action%>">

<html:hidden property="document" />

<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
		<% if(pstate == APPStates.EDITIRAS) { %>
           <html:link page="/ShowInvActList.do" styleClass="navigator"><bean:message key="label.inventoryacts"/></html:link> 
           <july:sepmark/> 
           <html:link page="/ShowI13nActRessetList.do" styleClass="navigator"><bean:message key="label.resset"/></html:link> 
		<% } else if(pstate == APPStates.EDITIRS) { %>
           <html:link page="/ShowInvList.do" styleClass="navigator"><bean:message key="label.inventorypositions"/></html:link> 
           <july:sepmark/> 
           <html:link page="/ShowI13nRessetList.do" styleClass="navigator"><bean:message key="label.resset"/></html:link> 
		<% } %>
           <july:sepmark/> 
           <july:actionname/></td>
    </tr>
    
    <july:separator/>
    
	<july:formbuttons/>
    
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.resset.act"/>:</td>
        <td>
		   <bean:message key="label.num"/>&nbsp;<bean:write name="<%=listFormName%>" property="blankindex" />&nbsp;<bean:write name="<%=listFormName%>" property="blanknumber" />&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="<%=listFormName%>" property="blankdatestr" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.resset.org"/>:</td>
        <td>
			<bean:write name="<%=listFormName%>" property="ownername" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.resset.resource"/>:</july:reqmark></td>
        <td>
			<july:string property="resourcecode" styleId="resourcecode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcename;resourcemodel" insertable="true" updatable="true"/>
			<july:string size="25" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
			<july:string size="25" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

