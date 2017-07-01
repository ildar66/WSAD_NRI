<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.AppUtils"%>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.inventory.formbean.*"%>

<july:editform action="/ProcessAssactpos.do">
<%
	AssactForm pform = (AssactForm)request.getSession().getAttribute("AssactForm");
	boolean readonly = true;
	readonly = !("1".equals(pform.getDState()) && !pform.getIsautodoc());
	AssactposForm dform = (AssactposForm)request.getAttribute("AssactposForm");

	boolean browseBySerial = dform.isBrowseBySerial();
%>

<html:hidden property="docposition" />
<html:hidden property="storagecode" />
<html:hidden property="ownercode" />
<html:hidden property="agregateSerial" />

<html:hidden name="AssactForm" property="document"/>

<input type="hidden" name="_dummy_">

<input type="hidden" name="configuration" value="">

<table class="main">
    
<july:separator/>

<july:formbuttons/>	

<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.assactpos.document"/></td>
	<td class="text"><bean:message key="label.num"/>
		<%-- &nbsp;<bean:write name="AssactForm" property="blankindex"/> --%>
		&nbsp;<bean:write name="AssactForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<july:datewrite name="AssactForm" property="blankdate"/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.assactpos.storage"/></td>
	<td class="text"><bean:write name="AssactForm" property="storagename"/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.assactpos.agregate"/></td>
	<td class="text"><bean:write name="AssactForm" property="agregatname"/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.assactpos.num"/>:</july:reqmark></td>
	<td>
		<%if(!readonly) {%>
			<july:string property="orderstr" size="10" insertable="true" updatable="true" />
		<%} else {%>
			<july:string property="orderstr" size="10" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.assactpos.resource"/>:</july:reqmark></td>
	<td>
		<%if(!readonly) {%>
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="true" />
		
			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="true"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + dform.getSerialnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="true" image="lookup_red"/>
			<%}%>
			
			<july:string size="30" property="resourcemodel" styleId="resourcemodel"
			    insertable="false" updatable="false" />			
			<july:string size="30" property="resourcename" styleId="resourcename" 
			   style="width: 433px;"
			   insertable="false" updatable="false" />
		<%} else {%>
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="false" updatable="false" />
			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + dform.getSerialnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false" image="lookup_red"/>
			<%}%>
			
			<july:string size="30" property="resourcemodel" styleId="resourcemodel"
			   insertable="false" updatable="false" />			
			<july:string size="30" property="resourcename" styleId="resourcename" 
			   style="width: 433px;"
			   insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.assactpos.qty"/>:</july:reqmark></td>
	<td>
		<%if(!readonly) {%>
			<july:string property="qtystr" size="15" insertable="true" updatable="true" />
		<%} else {%>
			<july:string property="qtystr" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
    
<july:separator/>
    
<%--    
    
<tr>
	<td class="text"><bean:message key="label.internalrpos.price"/>:</td>
	<td>
		<july:string property="pricestr" size="15" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>

--%>
<html:hidden property="pricestr"/>

<INPUT TYPE="HIDDEN" NAME="stcode" ID="stcode" VALUE='<bean:write name="AssactForm" property="storagecode"/>'>
    
<script language="javascript" src="/wscheck.js"></script>

<tr>
	<td COLSPAN="2"><B><bean:message key="label.allserials"/></B></TD>
</TR>

<tr>
	<TD>&nbsp;&nbsp;<SPAN title='<bean:message key="label.allserials.manuf.help"/>'><bean:message key="label.allserials.manuf"/>&nbsp;<IMG SRC="/images/help-little.gif" BORDER="0"></SPAN></TD>
	<td>
		<%if(!readonly){%>
			<july:string property="serialnumber" size="15" styleId="serialnumber"
			   insertable="true" updatable="true" />
			<SPAN STYLE="width: 30px;">
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="serl" onclick="set_opt_params_serl('?owner=&storage='+document.all.stcode.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.document.value);"                                 fieldNames="resourcecode;resourcename;resourcemodel;configuration;serialnumber;party;qtystr;fitplace;_dummy_;manufserial;ownercode;pricestr" newWindowName="seriallookup" insertable="true" updatable="true"/>&nbsp;
			</SPAN>
		    <july:checkbox property="sn_absent" onclick="switchCheck('sn_absent', 'serialnumber', 1, 1);"
		         insertable="true" updatable="true" />
		    <bean:message key="label.allserials.noserial"/>
		<%} else {%>
			<july:string property="serialnumber" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
<tr>
	<TD>&nbsp;&nbsp;<SPAN title='<bean:message key="label.allserials.invent.help"/>'><bean:message key="label.allserials.invent"/>&nbsp;<IMG SRC="/images/help-little.gif" BORDER="0"></SPAN></TD>
	<td>
		<%if(!readonly){%>
			<july:string property="manufserial" size="15" insertable="true" updatable="true" />
			<SPAN STYLE="width: 30px;"></SPAN>
		    <july:checkbox property="inv_absent" onclick="switchCheck('inv_absent', 'manufserial', 2, 1);"
		         insertable="true" updatable="true" />
		    <bean:message key="label.allserials.noserial"/>
		<%} else {%>
		    <july:string property="manufserial" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
<tr>
	<TD>&nbsp;&nbsp;<SPAN title='<bean:message key="label.allserials.local.help"/>'><bean:message key="label.allserials.local"/>&nbsp;<IMG SRC="/images/help-little.gif" BORDER="0"></SPAN></TD>
	<td>
		<%if(!readonly){%>
			<july:string property="localserial" size="15" insertable="true" updatable="true" />
			<SPAN STYLE="width: 30px;"></SPAN>
		    <july:checkbox property="loc_absent" onclick="switchCheck('loc_absent', 'localserial', 3, 1);"
		         insertable="true" updatable="true" />
		    <bean:message key="label.allserials.noserial"/>
		<%} else {%>
		    <july:string property="localserial" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
    
<%if(!readonly){%>
<SCRIPT language="JavaScript">
  switchCheck('sn_absent', 'serialnumber', 1, 0);
  switchCheck('inv_absent', 'manufserial', 2, 0);
  switchCheck('loc_absent', 'localserial', 3, 0);
</SCRIPT>
<%}%>

    
<july:separator/>


    
<tr>
	<td class="text"><bean:message key="label.assactpos.partynum"/>:</td>
	<td>
		<%if(!readonly) {%>
			<july:string property="party" size="15" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="partl" onclick="set_opt_params_partl('?owner=&storage='+document.all.stcode.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.document.value);" fieldNames="resourcecode;resourcename;resourcemodel;configuration;serialnumber;party;qtystr;fitplace;_dummy_;manufserial;ownercode;pricestr" newWindowName="partylookup" insertable="true" updatable="true"/>&nbsp;
		<%} else {%>
			<july:string property="party" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.fitplace"/>:</july:reqmark></td>
	<td>
		<july:string property="fitplace" size="20" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>

<july:formbuttons/>
    
<july:separator/>
    
</table>

</july:editform>

