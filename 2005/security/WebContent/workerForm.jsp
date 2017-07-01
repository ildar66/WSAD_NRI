<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.security.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	int state = ParamsParser.getState( pageContext );
	String action = null;
	switch( state )
	{
	case APPStates.EDITWRK:
		action = "/ProcessWorker.do";
		break;
	case APPStates.EDITWRKC:
		action = "/ProcessWorkerC.do";
		break;
	case APPStates.EDITWRKDR:
		action = "/ProcessWorkerDr.do";
		break;
	case APPStates.EDITWRKS:
		action = "/ProcessWorkerS.do";
		break;
	case APPStates.EDITWRKD:
		action = "/ProcessWorkerD.do";
		break;
	case APPStates.EDITWRKG:
		action = "/ProcessWorkerG.do";
		break;
	}

	boolean admin = request.isUserInRole("administrator");	
	String updatable = String.valueOf(admin);
%>

<july:editform action="<%= action %>">

<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
           <jsp:useBean id="CURRENT_STATE" scope="request" type="java.lang.String" />
           <logic:equal name="CURRENT_STATE" value="<%= new java.lang.Integer(APPStates.EDITWRK).toString() %>">
             <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
             <july:sepmark/>
             <html:link page="/ShowWorkerList.do" styleClass="navigator"><bean:message key="label.workers"/></html:link>
             <july:sepmark/>
           </logic:equal>
           <logic:equal name="CURRENT_STATE" value="<%= new java.lang.Integer(APPStates.EDITWRKC).toString() %>">
             <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link>
             <july:sepmark/>
             <html:link page="/ShowWorkerListC.do" styleClass="navigator"><bean:message key="label.workers"/></html:link>
             <july:sepmark/>
           </logic:equal>
           <logic:equal name="CURRENT_STATE" value="<%= new java.lang.Integer(APPStates.EDITWRKDR).toString() %>">
             <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link>
             <july:sepmark/>
             <html:link page="/ShowDirectionList.do" styleClass="navigator"><bean:message key="label.directions"/></html:link>
             <july:sepmark/>
             <html:link page="/ShowWorkerListDr.do" styleClass="navigator"><bean:message key="label.workers"/></html:link>
             <july:sepmark/>
           </logic:equal>
           <logic:equal name="CURRENT_STATE" value="<%= new java.lang.Integer(APPStates.EDITWRKS).toString() %>">
             <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link>
             <july:sepmark/>
             <html:link page="/ShowDirectionList.do" styleClass="navigator"><bean:message key="label.directions"/></html:link>
             <july:sepmark/>
             <html:link page="/ShowServiceList.do" styleClass="navigator"><bean:message key="label.services"/></html:link>
             <july:sepmark/>
             <html:link page="/ShowWorkerListS.do" styleClass="navigator"><bean:message key="label.workers"/></html:link>
             <july:sepmark/>
           </logic:equal>
           <logic:equal name="CURRENT_STATE" value="<%= new java.lang.Integer(APPStates.EDITWRKD).toString() %>">
             <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link>
             <july:sepmark/>
             <html:link page="/ShowDirectionList.do" styleClass="navigator"><bean:message key="label.directions"/></html:link>
             <july:sepmark/>
             <html:link page="/ShowServiceList.do" styleClass="navigator"><bean:message key="label.services"/></html:link>
             <july:sepmark/>
             <html:link page="/ShowDepartmentList.do" styleClass="navigator"><bean:message key="label.departments"/></html:link>
             <july:sepmark/>
             <html:link page="/ShowWorkerListD.do" styleClass="navigator"><bean:message key="label.workers"/></html:link>
             <july:sepmark/>
           </logic:equal>
           <logic:equal name="CURRENT_STATE" value="<%= new java.lang.Integer(APPStates.EDITWRKG).toString() %>">
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
             <html:link page="/ShowWorkerListG.do" styleClass="navigator"><bean:message key="label.workers"/></html:link>
             <july:sepmark/>
           </logic:equal>
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
        <td class="text"><july:reqmark><bean:message key="label.code"/>:</july:reqmark></td>
        <td>
          <july:string property="worker" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.people.fullname"/>:</july:reqmark></td>
        <td>
          <july:string property="mancode" styleId="man" size="5" insertable="true" updatable="<%=updatable%>" />
          <july:lookupbutton action="/ShowPeopleLookupList.do" styleId="wkl" fieldNames="man;manname" insertable="true" updatable="<%=updatable%>" />
          <july:string size="50" property="manname" styleId="manname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.worker.workposition"/>:</july:reqmark></td>
        <td>
          <july:string property="workposition" styleId="wp" size="5" insertable="true" updatable="<%=updatable%>" />
          <july:lookupbutton action="/ShowWorkPositionLookupList.do" styleId="wpl" fieldNames="wp;wpname" insertable="true" updatable="<%=updatable%>" />
          <july:string size="50" property="workpositionname" styleId="wpname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.worker.lotusaddress"/>:</td>
        <td>
          <july:string property="lotusaddress" size="50" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.worker.email"/>:</td>
        <td>
          <july:string property="email" size="35" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.worker.phone1"/>:</td>
        <td>
          <july:string property="phone1" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.worker.phone2"/>:</td>
        <td>
          <july:string property="phone2" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.worker.localphone"/>:</td>
        <td>
          <july:string property="localphone" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.worker.fax"/>:</td>
        <td>
          <july:string property="fax" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.worker.mobilephone"/>:</td>
        <td>
          <july:string property="mobilephone" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
	
    <tr>
        <td class="text"><bean:message key="label.worker.isservicestuff"/>:</td>
        <td><july:checkbox property="isservicestuff" insertable="true" updatable="true"/></td>
    </tr>
    
    <july:separator/>
    
    <!--
    <tr>
        <td class="text"><bean:message key="label.worker.platinumcode"/>:</td>
        <td>
          <july:string property="platinumcode" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    <tr>
        <td class="probel" colspan="2"><img src="images/empty.gif" width="1" height="1" border="0" alt=""></td>
    </tr>
    -->
    <tr>
        <td class="text"><bean:message key="label.worker.isenabled"/>:</td>
        <td>
          <DIV class="edit"><july:radio property="active" insertable="true" updatable="true" value="true"><bean:message key="label.operator.enabled"/></july:radio></DIV>
          <DIV class="edit"><july:radio property="active" insertable="true" updatable="true" value="false"><bean:message key="label.operator.disabled"/></july:radio></DIV>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.company.name"/>:</td>
        <td>
          <july:string property="companycodeFrm" styleId="cmp" size="5" insertable="true" updatable="<%=updatable%>" />
          <july:lookupbutton action="/ShowCompanyLookupList.do" styleId="cmpl" fieldNames="cmp;cmpname" insertable="true" updatable="<%=updatable%>" />
          <july:string size="50" property="companyname" styleId="cmpname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.division.name"/>:</td>
        <td>
          <july:string property="divisioncodeFrm" styleId="div" size="5" insertable="true" updatable="<%=updatable%>" />
          <july:lookupbutton action="/divisionLookup.do" styleId="divl" fieldNames="div;divname" onclick="set_opt_params_divl('?company='+document.all.cmp.value+'&division='+document.all.div.value)" insertable="true" updatable="<%=updatable%>" />
          <july:string size="50" property="divisionname" styleId="divname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>

</july:editform>
