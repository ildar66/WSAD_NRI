<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessCurrate.do"  onsubmit="storeID();">

<script language="javascript">
function storeID() {
	//alert("CurrateListForm=" + document.all.datestr.value + "_"+ document.all.ratetype.value + "_"+ document.all.currencycode.value);//temp
	//document.cookie = "CurrateListForm=" + document.all.datestr.value + "_"+ document.all.ratetype.value + "_"+ document.all.currencycode.value;
}
</script>

<table class="main">
 
    <july:separator/>
    
	<july:formbuttons/>
    
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.ratetype.code"/>:</td>
        <td>
			<july:select styleClass="seach" style="width:133;" collection="ratetypes" property="ratetype" insertable="true" updatable="false">
				<html:options collection="ratetypes" property="ratetype" labelProperty="name"/>
			</july:select>
        </td>
    </tr>
    
    <july:separator/>
<%--    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.currency.code" />:</july:reqmark></td>
        <td>
          <july:string property="currencycode" styleId="currency" size="5" insertable="true" updatable="false" />
          <july:lookupbutton action="/ShowCurrencyLookupList.do" styleId="wlp" fieldNames="currency;currencyname" insertable="true" updatable="false" />
          <july:string size="30" property="currencyname" styleId="currencyname" insertable="false" updatable="false" />
        </td>
    </tr>
--%>  
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.currency.code" />:</july:reqmark></td>
        <td>
		    <july:select  styleClass="seach" style="width:133;" collection="currencies"  property="currencycode"  insertable="true" updatable="false">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>	
		</td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.currate.date"/>:</july:reqmark></td>
        <td>
			<july:date property="datestr" size="15" insertable="true" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.currate.value"/>:</july:reqmark></td>
        <td>
          <july:string property="valuestr" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>

</july:editform>

