<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessResAntenna.do">

<table class="main">

    <july:separator/>
    
	<july:formbuttons/>
    
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.code"/>:</td>
        <td>
           <july:string property="resource" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.name"/>:</td>
        <td>
          <july:string property="name" size="25" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.resource.nrimodel"/>:</td>
        <td>
          <july:string property="model" size="25" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.resource.manufacturer"/>:</td>
        <td>
          <july:string property="manufidStr" size="25" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.groupres.lookup.code"/>:</td>
        <td>
        	<july:string property="groupidFrm" size="5" insertable="true" updatable="true" />
        	<%--<july:editbutton page="/ShowResourceGroupList.do" action="View" paramId="groupid" paramProperty="groupid" paramScope="page"/>--%>
			<july:lookupbutton action="/ShowResourceGroupLookupList.do" styleId="orgl" fieldNames="groupidFrm;groupname" insertable="true" updatable="true" />
			<july:string size="35" property="groupname" styleId="groupname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

