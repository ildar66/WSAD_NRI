<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessExternalMismatch.do">

<html:hidden property="documentstr" />

<table class="main">
    <tr class="title">
		<td class="title" colspan="2">
			<html:link page="/ShowExternalList.do" styleClass="navigator"><bean:message key="label.external"/></html:link> 
			<july:sepmark/> 
			<july:currmark><bean:message key="label.mismatch.title"/></july:currmark> 
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
        <td class="text"><bean:message key="label.mismatch.owner"/>:</td>
        <td>
			<bean:write name="ExternalMismatchForm" property="ownername" filter="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.mismatch.storage"/>:</td>
        <td>
			<bean:write name="ExternalMismatchForm" property="storagename" filter="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.mismatch.order"/>:</td>
        <td>
			<bean:message key="label.num"/>
			<%-- &nbsp;<bean:write name="ExternalMismatchForm" property="blankindex" /> --%>
			&nbsp;<bean:write name="ExternalMismatchForm" property="blanknumber" />&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="ExternalMismatchForm" property="blankdatestr" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.mismatch.account"/>:</td>
        <td>
			<logic:present name="ExternalMismatchForm" property="cordocnumr">
				<bean:message key="label.num"/>&nbsp;<bean:write name="ExternalMismatchForm" property="cordocnumr" />&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="ExternalMismatchForm" property="cordocdatestr" />
			</logic:present>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.mismatch.supplier"/>:</td>
        <td>
			<bean:write name="ExternalMismatchForm" property="suppliername" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.mismatch.dnum"/>:</july:reqmark></td>
        <td>
			<july:string property="dActNumber" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.mismatch.ddate"/>:</july:reqmark></td>
        <td>
			<july:date property="dActDatestr" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.mismatch.representative"/>:</july:reqmark></td>
        <td>
			<july:string size="50" property="dActRepresentative" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.mismatch.storman"/>:</july:reqmark></td>
        <td>
			<july:string property="dActStorManagercode" styleId="dActStorManagercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="sml" fieldNames="dActStorManagercode;dActStorManagername;dActStorManagertitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="35" property="dActStorManagername" styleId="dActStorManagername" insertable="false" updatable="false" />
			<july:string size="35" property="dActStorManagertitle" styleId="dActStorManagertitle" insertable="false" updatable="false" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark/><bean:message key="label.mismatch.techstuff"/>:</july:reqmark></td>
        <td>
			<july:string property="dActTechStufcode" styleId="dActTechStufcode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="workl" fieldNames="dActTechStufcode;dActTechStufname;dActTechStuftitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="35" property="dActTechStufname" styleId="dActTechStufname" insertable="false" updatable="false" />
			<july:string size="35" property="dActTechStuftitle" styleId="dActTechStuftitle" insertable="false" updatable="false" />
        </td>
    </tr>

    <july:separator/>
    
	<tr>
		<td class="text"><bean:message key="label.mismatch.text"/></td>
		<td class="text">
<logic:equal name="ExternalMismatchForm" property="action" value="Add">
			<html:file property="dActText" style="" />&nbsp;
</logic:equal>
			<html:link page="/MismatchDownload" paramId="document" paramName="ExternalMismatchForm" paramProperty="document">
				<bean:write name="ExternalMismatchForm" property="dActFileName" filter="true"/>
			</html:link>
	   </td>
	</tr>

    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

