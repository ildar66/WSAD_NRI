<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
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
	case APPStates.EDITORGM:
        action = "/ProcessOrganizationM.do";
		break;
	case APPStates.EDITORGC:
		action = "/ProcessOrganizationC.do";
		break;
	}
%>
<july:editform action="<%= action %>">

<html:hidden property="organization" />

<table class="main">
<%--
    <tr class="title">
    	<td class="title" colspan="2">
           <jsp:useBean id="CURRENT_STATE" scope="request" type="java.lang.String" />
           <logic:equal name="CURRENT_STATE" value="<%= new java.lang.Integer(APPStates.EDITORGM).toString() %>">
               <html:link page="/ShowOrganizationListM.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link>
               <july:sepmark/> 
           </logic:equal>
           <logic:equal name="CURRENT_STATE" value="<%= new java.lang.Integer(APPStates.EDITORGC).toString() %>">
               <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link>
               <july:sepmark/> 
               <html:link page="/ShowOrganizationListC.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link>
               <july:sepmark/> 
           </logic:equal>
           <july:actionname/></td>
    </tr>
--%>    
    <july:separator/>
    
	<july:formbuttons/>
    
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>
<%--    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.code"/>:</july:reqmark></td>
        <td>
          <july:string property="organization" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
--%>    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.organization.shortname"/>:</july:reqmark></td>
        <td>
		<july:string property="shortname" size="15" insertable="true" updatable="true"/>
<%--
          <july:string property="organizationType" size="5" insertable="true" updatable="true"/>&nbsp;
		  <bean:message key="label.organization.shortname"/>:&nbsp;
--%>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.name"/>:</july:reqmark></td>
        <td>
          <july:string property="name" size="50" insertable="true" updatable="true"/>
        </td>
    </tr>
    
    <july:separator/>
    
	<tr>
		<td colspan="2">
			<table class="main">
				<tr>
			        <td class="text" width="20%">
						<bean:message key="label.organization.issupplier"/>:&nbsp;
						<july:checkbox property="issupplier" insertable="true" updatable="true" value="true"/>
					</td>
					<td class="text" width="20%">
						<bean:message key="label.organization.isprovider"/>:&nbsp;
						<july:checkbox property="isprovider" insertable="true" updatable="true" value="true"/>
					</td>
					<td class="text">
						<bean:message key="label.organization.isrenter"/>:&nbsp;
						<july:checkbox property="isrenter" insertable="true" updatable="true" value="true"/>
			        </td>
				</tr>
			</table>
		</td>
	</tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.organization.company"/>:</td>
        <td>
          <july:string property="companycode" styleId="cmp" size="5" insertable="false" updatable="false" />
          <july:lookupbutton action="/ShowCompanyLookupList.do" styleId="cmpl" fieldNames="cmp;cmpname" insertable="false" updatable="false" />
          <july:string size="30" property="companyname" styleId="cmpname"  insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.organization.okonh"/>:</td>
        <td>
          <july:string property="okonh" size="25" insertable="true" updatable="true"/>&nbsp;
		  <bean:message key="label.organization.okpo"/>:&nbsp;
		  <july:string property="okpo" size="25" insertable="true" updatable="true"/>
        </td>
    </tr>
    
	<july:separator/>
	
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.organization.inn"/>:</july:reqmark></td>
        <td nowrap>
          <july:string property="inn" size="10" insertable="true" updatable="true"/>&nbsp;
		  <july:reqmark><bean:message key="label.organization.kpp"/>:</july:reqmark>&nbsp;
		  <july:string property="kpp" size="10" insertable="true" updatable="true"/>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.organization.directorfio"/>:</july:reqmark></td>
        <td>
          <july:string property="directorinfo" size="25" insertable="true" updatable="true"/>&nbsp;
		  <bean:message key="label.organization.accountmanagerfio"/>:&nbsp;
		  <july:string property="accauntmanagerinfo" size="25" insertable="true" updatable="true"/>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.organization.bossposition"/>:</july:reqmark></td>
        <td>
          <july:textarea property="bossPosition" style="width:618;" rows="2" insertable="true" updatable="true"/>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.organization.legaladdress"/>:</july:reqmark></td>
        <td>
          <july:textarea property="legaladdress" style="width:618;" rows="2" insertable="true" updatable="true"/>
        </td>
    </tr>
    
    <july:separator/>
    
    <%-- tr>
        <td class="text"><bean:message key="label.organization.legalzip"/>:</td>
        <td>
          <july:string property="zip" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/ --%>
    
    <tr>
        <td class="text"><bean:message key="label.organization.phisicaladdress"/>:</td>
        <td>
          <july:textarea property="phisicaladdress" style="width:618;" rows="2" insertable="true" updatable="true"/>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.organization.phone"/>:</td>
        <td>
          <july:string property="phone" size="25" insertable="true" updatable="true"/>&nbsp;
		  <bean:message key="label.organization.fax"/>:&nbsp;
		  <july:string property="fax" size="25" insertable="true" updatable="true"/>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.organization.contactlist"/>:</td>
        <td>
          <july:textarea property="contactList" style="width:618;" rows="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>

</july:editform>

