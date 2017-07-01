<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessInvPos.do">

<script language="javascript">
function copy2manuf() {
	InvPosForm.manufserial.value = InvPosForm.serialnumber.value;
}
</script>

<html:hidden property="docposition" />
<html:hidden property="document" />
<html:hidden property="utype" value="-"/>
<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="/ShowInvList.do" styleClass="navigator"><bean:message key="label.inventorypositions"/></html:link> 
           <july:sepmark/> 
           <html:link page="/ShowInvPosList.do" styleClass="navigator"><bean:message key="label.invpos"/></html:link> 
           <july:sepmark/> 
		<july:currmark><bean:message key="label.invpos.postitle"/></july:currmark>
	</td>
    </tr>
    
    <july:separator/>
    
	<july:formbuttons/>
    
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.invpos.act"/>:</td>
        <td>
		   <bean:message key="label.num"/>&nbsp;<bean:write name="InvPosListForm" property="blankindex" />&nbsp;<bean:write name="InvPosListForm" property="blanknumber" />&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="InvPosListForm" property="blankdatestr" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.invpos.org"/>:</td>
        <td>
			<bean:write name="InvPosListForm" property="ownername" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.invpos.place"/>:</td>
        <td>
			<bean:write name="InvPosListForm" property="positionname" />,&nbsp;<bean:write name="InvPosListForm" property="complectname" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.invpos.num"/>:</july:reqmark></td>
        <td>
           <july:string property="order" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.invpos.serialnum"/>:</td>
        <td>
		   <july:string property="serialnumber" size="15" insertable="true" updatable="true" />&nbsp;<input type="image" src="/images/copybtn.gif" width="16" height="16" name="copybtn" onclick="copy2manuf();return false;"/>
		   <logic:equal name="InvPosForm" property="action" value="Add"><INPUT TYPE="IMAGE" NAME="submit" src="/images/searchsn.gif"  ALT="Найти по карточке" onClick="utype.value = 'S';"></logic:equal>
		   <logic:equal name="InvPosForm" property="action" value="Edit"><INPUT TYPE="IMAGE" NAME="submit" src="/images/searchsn.gif"  ALT="Найти по карточке" onClick="utype.value = 'S';"></logic:equal>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.manufserial"/>:</td>
        <td>
		   <july:string property="manufserial" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.invpos.partnum"/>:</td>
        <td>
           <july:string property="party" size="15" insertable="true" updatable="true" />
		   <logic:equal name="InvPosForm" property="action" value="Add"><INPUT TYPE="IMAGE" NAME="submit" src="/images/searchsn.gif"  ALT="Найти по карточке" onClick="utype.value = 'P';"></logic:equal>
		   <logic:equal name="InvPosForm" property="action" value="Edit"><INPUT TYPE="IMAGE" NAME="submit" src="/images/searchsn.gif"  ALT="Найти по карточке" onClick="utype.value = 'P';"></logic:equal>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.invpos.resource"/>:</july:reqmark></td>
        <td>
			<july:string property="resourcecode" styleId="resourcecode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" insertable="true" updatable="true"/>
			<july:string size="20" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
			<july:string size="25" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.invpos.configuration"/>:</td>
        <td>
           <july:string property="configuration" size="30" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
<%--    
    <tr>
       <td class="text"><bean:message key="label.invpos.boxed"/></td>
       <td>
			<july:checkbox property="boxed" insertable="true" updatable="true" value="true"/><html:hidden property="boxed" value="false"/>
       </td>
    </tr>
    
    <july:separator/>
--%>    
    <tr>
       <td class="text"><bean:message key="label.invpos.broken"/></td>
       <td>
			<july:checkbox property="broken" insertable="true" updatable="true" value="true"/><html:hidden property="broken" value="false"/>
       </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.invpos.owner"/>:</july:reqmark></td>
        <td>
			<july:select collection="organizations" property="ownercode" insertable="true" updatable="true">
				<html:options collection="organizations" property="organization" labelProperty="name"/>
			</july:select>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.invpos.qty"/>:</july:reqmark></td>
        <td>
           <july:string property="qtystr" size="10" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.invpos.price"/>:</td>
        <td>
           <july:string property="pricestr" size="10" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.invpos.sum"/>:</td>
        <td>
           <july:string property="sumstr" size="15" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>

<%--<logic:equal name="InvPosListForm" property="type" value="A">--%>
    <tr>
	<td class="text"><july:reqmark><bean:message key="label.fitplace"/>:</july:reqmark></td>
	<td>
		<july:string property="fitplace" size="20" insertable="true" updatable="true" />
	</td>
    </tr>
    
    <july:separator/>
<%--</logic:equal>--%>
    
    <tr>
        <td class="text"><bean:message key="label.invpos.note"/>:</td>
        <td>
           <july:string property="note" size="35" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
       <td class="text"><bean:message key="label.invpos.contract"/>:</td>
       <td>
	   <july:string property="contractcode" styleId="contractcode" size="5" insertable="true" updatable="true" />
	   <july:lookupbutton action="/ShowContractLookupList.do" styleId="ctl" fieldNames="contractcode;contractname" insertable="true" updatable="true" newWindowName="contractLookup"  onclick="set_opt_params_ctl('?allcontragent=true'+'&owner='+document.all.ownercode.options[document.all.ownercode.selectedIndex].value+'&allowner=false');"/>
	   <july:string size="35" property="contractname" styleId="contractname" insertable="false" updatable="false" />
       </td>
    </tr>
    
    <july:separator/>

    <tr>
       <td class="text"><bean:message key="label.invpos.cordocnum"/>:</td>
       <td>
		<july:string size="20" property="cordocnum" styleId="cordocnum" insertable="true" updatable="true" />
       </td>
    </tr>
    
    <july:separator/>

    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

