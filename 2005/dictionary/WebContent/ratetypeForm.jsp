<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessRatetype.do">

<table class="main">
<%--
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="/ShowRatetypeList.do" styleClass="navigator"><bean:message key="label.ratetype"/></a> 
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
        <td class="text"><july:reqmark><bean:message key="label.ratetype.code"/>:</july:reqmark></td>
        <td>
           <july:string property="ratetype" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.ratetype.name"/>:</july:reqmark></td>
        <td>
          <july:string property="name" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.ratetype.basecur"/>:</july:reqmark></td>
        <td>
          <july:string property="basecurrencystr" styleId="basecur" size="5" insertable="true" updatable="true" />
          <july:lookupbutton action="/ShowCurrencyLookupList.do" styleId="cll" fieldNames="basecur;basecurname" insertable="true" updatable="true" />
          <july:string size="30" property="basecurrencyname" styleId="basecurname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

