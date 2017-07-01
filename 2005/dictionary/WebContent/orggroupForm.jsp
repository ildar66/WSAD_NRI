<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	int state = ParamsParser.getState( pageContext );
    String action = null;
	switch( state )
		{
		case APPStates.EDITORGG:
          action = "/ProcessOrggroup.do";
          break;
		case APPStates.EDITORGGC:
          action = "/ProcessOrggroupC.do";
          break;
        }
%>

<july:editform action="<%= action %>">

<html:hidden property="org" />

<table class="main">
<%--
    <tr class="title">
    	<td class="title" colspan="2">
           <jsp:useBean id="CURRENT_STATE" scope="request" type="java.lang.String" />
           <logic:equal name="CURRENT_STATE" value="<%= String.valueOf(APPStates.EDITORGG) %>">
		       <html:link page="/ShowOrganizationListM.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link> 
    		   <july:sepmark/> 
    		   <html:link page="/ShowOrggroupList.do" styleClass="navigator"><bean:message key="label.orggroups"/></html:link>
	           <july:sepmark/>
    	       <july:actionname/>
		   </logic:equal>
           <logic:equal name="CURRENT_STATE" value="<%= String.valueOf(APPStates.EDITORGGC) %>">
		       <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link> 
		       <july:sepmark/> 
		       <html:link page="/ShowOrganizationListC.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link> 
		       <july:sepmark/> 
    		   <html:link page="/ShowOrggroupListC.do" styleClass="navigator"><bean:message key="label.orggroups"/></html:link>
	           <july:sepmark/>
    	       <july:actionname/>
		   </logic:equal>
		</td>
    </tr>
--%>    
<july:separator/>
 
<july:formbuttons/>
    
<july:separator/>	

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.orggroup.organization"/>:</td>
	<td class="text"><july:string property="orgname" size="30" insertable="false" updatable="false"/></td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.orggroup.group"/>:</july:reqmark></td>
	<td>
		<july:string property="searchgroup" styleId="searchgroup" size="5" insertable="true" updatable="false" />
		<july:lookupbutton action="/ShowGroupLookupList.do" styleId="gl" fieldNames="searchgroup;searchgroupname" insertable="true" updatable="false"/>
		<july:string size="30" property="searchgroupname" styleId="searchgroupname" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.orggroup.groupping"/>:</july:reqmark></td>
	<td>
		<july:string property="searchgroupping" styleId="searchgroupping" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowGrouppingLookupList.do" styleId="gpl" fieldNames="searchgroupping;searchgrouppingname" onclick="set_opt_params_gpl('?searchgroup='+document.all.searchgroup.value)" insertable="true" updatable="true"/>
		<july:string size="30" property="searchgrouppingname" styleId="searchgrouppingname" insertable="false" updatable="false" />		
	</td>
</tr>
    
<%-- july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.orggroup.order"/>:</july:reqmark></td>
        <td>
          <july:string property="order" size="5" insertable="true" updatable="true" />
        </td>
    </tr --%>

<july:separator/>
    
<july:formbuttons/>
    
<july:separator/>
    
</table>


</july:editform>

