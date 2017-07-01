<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessBank.do">

<table class="main">
<%--
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="/ShowBankList.do" styleClass="navigator"><bean:message key="label.banks"/></html:link>
           <july:sepmark/>
           <july:actionname/></td>
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
        <td class="text"><july:reqmark><bean:message key="label.code"/>:</july:reqmark></td>
        <td>
          <july:string property="organization" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.name"/>:</july:reqmark></td>
        <td>
          <july:textarea property="name" cols="50" rows="3" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.organization.bik"/>:</july:reqmark></td>
        <td>
          <july:string property="bik" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.organization.swift"/>:</td>
        <td>
          <july:string property="swift" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.organization.corraccount"/>:</td>
        <td>
          <july:string property="koraccount" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.organization.legaladdress"/>:</td>
        <td>
          <july:textarea property="legaladdress" cols="50" rows="4" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.organization.legalzip"/>:</td>
        <td>
          <july:string property="zip" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>

</july:editform>

