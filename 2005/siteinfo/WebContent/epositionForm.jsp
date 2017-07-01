<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessEPosition.do" enctype="multipart/form-data">

<table class="main">

    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>
     
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.eposition.posname"/>:</td>
        <td>
           <bean:write name="EPositionForm" property="posid"/>&nbsp;&nbsp;&nbsp;<bean:write name="EPositionForm" property="posname"/>
        </td>
    </tr>
    
    <july:separator/>
    <tr>
        <td class="text"><bean:message key="label.position.ex.addr"/>:</td>
        <td>
           <bean:write name="EPositionForm" property="posAddr"/>
        </td>
    </tr>
    
    <july:separator/>
    
    <html:hidden property="storageplace"/>
    <%-- tr>
        <td class="text"><july:reqmark><bean:message key="label.code"/>:</july:reqmark></td>
        <td>
           <july:string property="storageplace" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/ --%>
    
    <tr>
        <td class="text"><bean:message key="label.eposition.contactphones"/>:</td>
        <td>
          <july:textarea style="width: 500pt" property="contactPhonest" cols="50" rows="7" insertable="false" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <%-- tr>
        <td class="text"><bean:message key="label.eposition.servicephones"/>:</td>
        <td>
          <july:textarea property="servicePhones" cols="50" rows="2" insertable="false" updatable="true" />
        </td>
    </tr>
    
    <july:separator/ --%>
    
    <tr>
        <td class="text"><bean:message key="label.eposition.pathtype"/>:</td>
        <td>
          <july:textarea style="width: 500pt" property="pathType" cols="50" rows="6" insertable="false" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.eposition.equipmentplaces"/>:</td>
        <td>
          <july:textarea style="width: 500pt" property="equipmentPlaces" cols="50" rows="6" insertable="false" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.eposition.engeneering"/>:</td>
        <td>
          <july:textarea style="width: 500pt" property="engenering" cols="50" rows="6" insertable="false" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
<%--    
    <tr>
        <td class="text"><bean:message key="label.eposition.accesslist"/>:</td>
        <td>
          <%if(request.isUserInRole("siteProjector")){%>
           <html:file property="accessListFrm" size="35" disabled="true"/>
          <%}else{%>
           <html:file property="accessListFrm" size="35" />
          <%}%>
 <html:link page="/AccessListDownload" paramId="storageplace" paramName="EPositionForm" paramProperty="storageplace" target="_blank"><bean:write name="EPositionForm" property="accessListFileName"/></html:link>
        </td>
    </tr>
    
    <july:separator/>
    <tr>
        <td class="text"><bean:message key="label.eposition.accessdate"/>:</td>
        <td>
          <july:date property="accesslistexpFrm" size="20" insertable="false" updatable="true" required="false" />
        </td>
    </tr>    
    <july:separator/>
--%>     
    <july:formbuttons><%-- july:printbutton page="/PrintEPosition.do?action=View" paramId="storageplace" paramName="EPositionForm" paramProperty="storageplace"/ --%></july:formbuttons>    

	<july:separator/>
    
</table>


</july:editform>

