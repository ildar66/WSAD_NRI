<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.inventory.formbean.*,com.hps.july.inventory.actionbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessExternalRPosition.do">
<%
	boolean readonly = true;
	ExternalRForm frm = (ExternalRForm)request.getSession().getAttribute("ExternalRForm");
	ExternalRPositionForm aform = (ExternalRPositionForm)request.getAttribute("ExternalRPositionForm");
	if("1".equals(frm.getDState()) && !frm.getIsautodoc() &&
	  !"Delete".equals(aform.getAction()) && !"View".equals(aform.getAction()) ) {
		readonly = false;
	}

	boolean browseBySerial = aform.isBrowseBySerial();
%>

<html:hidden property="docposition" />
<html:hidden property="storagecode" />
<html:hidden property="ownercode" />

<html:hidden name="ExternalRForm" property="document"/>

<input type="hidden" name="_dummy_" value="">

<table class="main">

<july:separator/>

<july:formbuttons/>

<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<tr>
	<td class="title"><bean:message key="label.externalrpos.document"/></td>
	<td class="title"><bean:message key="label.num"/>
	<%-- &nbsp;<bean:write name="ExternalRForm" property="blankindex"/> --%>
	&nbsp;<bean:write name="ExternalRForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="ExternalRForm" property="blankdatestr"/></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.externalrpos.num"/>:</july:reqmark></td>
	<td>
		<%if(!readonly){%>
			<july:string property="orderstr" size="10" insertable="true" updatable="true" />
		<%} else {%>
			<july:string property="orderstr" size="10" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.externalrpos.resource"/>:</july:reqmark></td>
	<td>
		<%if(!readonly){%>
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="false" />

			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="false"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + aform.getSerialnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="false" image="lookup_red"/>
			<%}%>

			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcemodel" readonly="true"/>			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcename" readonly="true"/>
		<%} else {%>
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="false" updatable="false" />

			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + aform.getSerialnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false" image="lookup_red"/>
			<%}%>

			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcemodel" readonly="true"/>			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcename" readonly="true"/>
		<%}%>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.externalrpos.configuration"/>:</td>
	<td>
		<july:string property="configuration" size="35" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.externalrpos.qty"/>:</july:reqmark></td>
	<td>
		<%if(!readonly){%>
			<july:string property="qtystr" size="15" insertable="true" updatable="true" />
		<%} else {%>
			<july:string property="qtystr" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.externalrpos.price"/>:</july:reqmark></td>
	<td>
		<july:string property="pricestr" size="15" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>

<script language="javascript" src="/wscheck.js"></script>

<tr>
	<td COLSPAN="2"><B><bean:message key="label.allserials"/></B></TD>
</TR>

<tr>
	<TD>&nbsp;&nbsp;<SPAN title='<bean:message key="label.allserials.manuf.help"/>'><bean:message key="label.allserials.manuf"/>&nbsp;<IMG SRC="/images/help-little.gif" BORDER="0"></SPAN></TD>
	<td>
		<%if(!readonly){%>
			<july:string property="serialnumber" size="15" styleId="serialnumber"
			   insertable="true" updatable='<%=""+aform.isSerialUpdatable()%>' />
			<SPAN STYLE="width: 30px;">
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="serl" onclick="set_opt_params_serl('?owner=&storage='+document.all.storagecode.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.document.value)" fieldNames="resourcecode;resourcename;resourcemodel;configuration;serialnumber;party;qtystr;_dummy_;_dummy_;manufserial;ownercode;pricestr" newWindowName="seriallookup" insertable="true" updatable="true"/>&nbsp;
			</SPAN>
		    <july:checkbox property="sn_absent" onclick="switchCheck('sn_absent', 'serialnumber', 1, 1);"
		         insertable="true" updatable='<%=""+aform.isSerialUpdatable()%>' />
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
			<july:string property="manufserial" size="15" insertable="true" updatable='<%=""+aform.isSerialUpdatable()%>' />
			<SPAN STYLE="width: 30px;"></SPAN>
		    <july:checkbox property="inv_absent" onclick="switchCheck('inv_absent', 'manufserial', 2, 1);"
		         insertable="true" updatable='<%=""+aform.isSerialUpdatable()%>' />
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
			<july:string property="localserial" size="15" insertable="true" updatable='<%=""+aform.isSerialUpdatable()%>' />
			<SPAN STYLE="width: 30px;"></SPAN>
		    <july:checkbox property="loc_absent" onclick="switchCheck('loc_absent', 'localserial', 3, 1);"
		         insertable="true" updatable='<%=""+aform.isSerialUpdatable()%>' />
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
	<td class="text"><bean:message key="label.externalrpos.partynum"/>:</td>
	<td>
		<%if(!readonly){%>
			<july:string property="party" size="15" insertable="true" updatable='<%=""+aform.isPartyUpdatable()%>' />
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="partl" onclick="set_opt_params_partl('?owner=&storage='+document.all.storagecode.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.document.value)" fieldNames="resourcecode;resourcename;resourcemodel;configuration;serialnumber;party;qtystr;_dummy_;_dummy_;manufserial;ownercode;pricestr" newWindowName="partylookup" insertable="true" updatable="true"/>&nbsp;
		<%} else {%>
			<july:string property="party" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
<july:separator/>
<july:formbuttons/>
<july:separator/>
</table>

</july:editform>

