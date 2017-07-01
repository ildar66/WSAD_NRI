<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.inventory.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	int state = ParamsParser.getState( pageContext );
	String action = null;
	String formName = null;
	switch( state )
	{
	case APPStates.EDITMIS:
		action = "/ProcessMismatch.do";
		formName = "MismatchForm";
		break;
	case APPStates.EDITEOM:
		action = "/ProcessExternalMismatch.do";
		formName = "ExternalMismatchForm";
		break;
	}
%>

<july:editform action="<%=action%>" enctype="multipart/form-data">

<html:hidden property="documentstr" />

<table class="main">
    
    
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
			<bean:write name="<%=formName%>" property="ownername" filter="true" /><html:hidden property="ownername" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.mismatch.storage"/>:</td>
        <td>
			<bean:write name="<%=formName%>" property="storagename" filter="true" /><html:hidden property="storagename" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.mismatch.order"/>:</td>
        <td><bean:message key="label.num"/>
        <%-- &nbsp;<bean:write name="<%=formName%>" property="blankindex" /> --%>
        &nbsp;<bean:write name="<%=formName%>" property="blanknumberr" />&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="<%=formName%>" property="blankdatestr" />
<html:hidden property="blankindex" /><html:hidden property="blanknumberr" /><html:hidden property="blankdatestr" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.mismatch.account"/>:</td>
        <td><html:hidden property="cordocnumr" /><html:hidden property="cordocdatestr" />
			<logic:present name="<%=formName%>" property="cordocnumr">
				<bean:message key="label.num"/>&nbsp;<bean:write name="<%=formName%>" property="cordocnumr" />&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="<%=formName%>" property="cordocdatestr" />
			</logic:present>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.mismatch.supplier"/>:</td>
        <td>
			<bean:write name="<%=formName%>" property="suppliername" /><html:hidden property="suppliername" />
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
			<july:string size="40" property="dActRepresentative" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.mismatch.storman"/>:</july:reqmark></td>
        <td>
			<july:string property="dActStorManagercode" styleId="dActStorManagercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="sml" fieldNames="dActStorManagercode;dActStorManagername;dActStorManagertitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="dActStorManagername" styleId="dActStorManagername" insertable="false" updatable="false" />
			<july:string size="25" property="dActStorManagertitle" styleId="dActStorManagertitle" insertable="false" updatable="false" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark/><bean:message key="label.mismatch.techstuff"/>:</july:reqmark></td>
        <td>
			<july:string property="dActTechStufcode" styleId="dActTechStufcode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="workl" fieldNames="dActTechStufcode;dActTechStufname;dActTechStuftitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="dActTechStufname" styleId="dActTechStufname" insertable="false" updatable="false" />
			<july:string size="25" property="dActTechStuftitle" styleId="dActTechStuftitle" insertable="false" updatable="false" />
        </td>
    </tr>

    <july:separator/>
    
	<tr>
		<td class="text"><bean:message key="label.mismatch.text"/></td>
		<td class="text">
<%
	if(state == APPStates.EDITEOM) {
%>
			<logic:equal name="ExternalMismatchForm" property="action" value="Add">
			<html:file property="dActTextFrm" size="35" />&nbsp;
			</logic:equal>
<%
	} else {
%>
			<logic:equal name="MismatchForm" property="action" value="Edit">
			<html:file property="dActTextFrm" size="35" />&nbsp;
			</logic:equal>
<%
	}
%>
			<logic:present name="<%=formName%>" property="dActFileName">
			<html:link page="/MismatchDownload" paramId="document" paramName="<%=formName%>" paramProperty="documentstr" target="_blank">
				<bean:write name="<%=formName%>" property="dActFileName" filter="true"/>
			</html:link>
			<html:hidden property="dActFileName"/><br>
<logic:equal name="<%=formName%>" property="action" value="Edit">
			<july:checkbox property="DActFileDelete" insertable="true" updatable="true" value="true"/>&nbsp;<bean:message key="label.mismatch.deletefile"/>
</logic:equal>
			</logic:present>
	   </td>
	</tr>

    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

