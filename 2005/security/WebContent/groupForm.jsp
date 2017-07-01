<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessGroup.do">

<table  class="main">
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowDirectionList.do" styleClass="navigator"><bean:message key="label.directions"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowServiceList.do" styleClass="navigator"><bean:message key="label.services"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowDepartmentList.do" styleClass="navigator"><bean:message key="label.departments"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowGroupList.do" styleClass="navigator"><bean:message key="label.groups"/></html:link> 
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
        <td class="text"><bean:message key="label.department.name"/>:</td>
        <td class="text"><bean:write name="department" property="name" /></td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.code"/>:</july:reqmark></td>
        <td>
          <july:string property="group" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.name"/>:</july:reqmark></td>
        <td>
          <july:string property="name" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.department.shortname"/>:</july:reqmark></td>
        <td>
          <july:string property="shortname" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.service.boss"/>:</td>
        <td>
          <july:string property="bosscode" styleId="boss" size="5" insertable="false" updatable="true" />
          <july:lookupbutton action="/ShowWorkerLookupList.do" styleId="wlp" onclick="set_opt_params_wlp('?searchby=D&divcode='+document.all.group.value)" fieldNames="boss;bossname" insertable="false" updatable="true" />
          <july:string size="30" property="bossname" styleId="bossname"  insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
	
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.division.active"/>:</july:reqmark></td>
        <td><july:checkbox property="isactive" insertable="true" updatable="true"/></td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>

</july:editform>

