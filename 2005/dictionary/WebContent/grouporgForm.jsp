<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessGrouporg.do">

<html:hidden property="searchgroup" />
<html:hidden property="searchgroupping" />

<table class="main">
<%--
    <tr class="title">
    	<td class="title" colspan="2">
	       <html:link page="/ShowGroupList.do" styleClass="navigator"><bean:message key="label.groups"/></html:link>
    	   <july:sepmark/> 
		   <html:link page="/ShowGrouppingList.do" styleClass="navigator"><bean:message key="label.groupping"/></html:link>
    	   <july:sepmark/> 
		   <html:link page="/ShowGrouporgList.do" styleClass="navigator"><bean:message key="label.grouporg"/></html:link>
           <july:sepmark/>
   	       <july:actionname/>
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
        <td class="text"><bean:message key="label.orggroup.group"/>:</td>
        <td class="text"><july:string property="searchgroupname" size="30" insertable="false" updatable="false"/></td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.orggroup.groupping"/>:</td>
        <td class="text"><july:string property="searchgrouppingname" size="30" insertable="false" updatable="false"/></td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.orggroup.organization"/>:</july:reqmark></td>
        <td>
			<july:string property="org" styleId="org" size="5" insertable="true" updatable="false" />
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="org;orgname" insertable="true" updatable="false"/>
			<july:string size="30" property="orgname" styleId="orgname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.orggroup.order"/>:</july:reqmark></td>
        <td>
          <july:string property="order" size="5" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

