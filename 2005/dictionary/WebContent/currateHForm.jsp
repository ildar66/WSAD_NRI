<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessCurrateH.do">

<html:hidden property="currency"/>
<%--<html:hidden property="ratetype"/>--%>

<table class="main">
<%--
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="/ShowCurrencyList.do" styleClass="navigator"><bean:message key="label.currency"/></html:link>
           <july:sepmark/> 
           <html:link page="/ShowCurrateHList.do" styleClass="navigator"><bean:message key="label.currateh"/></html:link> 
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
        <td class="text"><bean:message key="label.currency.code"/>:</td>
        <td><bean:write name="CurrateHListForm" property="currencyname" /></td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.ratetype.code"/>:</td>
        <td>
            <%-- bean:write name="CurrateHListForm" property="ratetypename" / --%>
			<july:select collection="ratetypes" property="ratetype" insertable="true" updatable="false">
				<html:options collection="ratetypes" property="ratetype" labelProperty="name"/>
			</july:select>
		</td>
    </tr>
    
    <july:separator/>
    
<%--
    <tr>
        <td class="text"><font class="red">*&nbsp;</font><bean:message key="label.ratetype.code"/>:</td>
        <td>
          <july:string property="ratetype" styleId="ratetype" size="5" insertable="true" updatable="true" />
          <july:lookupbutton action="/ShowRatetypeLookupList.do" styleId="rtl" fieldNames="ratetype;ratetypename" insertable="true" updatable="true" />
          <july:string size="30" property="ratetypename" styleId="ratetypename" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
--%>
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.currateh.date"/>:</july:reqmark></td>
        <td>
		  <july:date property="datestr" size="25" insertable="true" updatable="false" />
          <%--july:string property="datestr" size="25" insertable="true" updatable="true" /--%>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.currateh.value"/>:</july:reqmark></td>
        <td>
          <july:string property="valuestr" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

