<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.inventory.formbean.*,com.hps.july.inventory.actionbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessInternalPosition.do">

<%
	boolean readonly = true;
	InternalForm frm = (InternalForm)request.getSession().getAttribute("InternalForm");
	InternalPositionForm aform = (InternalPositionForm)request.getAttribute("InternalPositionForm");
	if("1".equals(frm.getDState()) && !frm.getIsautodoc() && 
	  !"Delete".equals(aform.getAction()) && !"View".equals(aform.getAction()) ) {
		readonly = false;
	}

	boolean browseBySerial = aform.isBrowseBySerial();
%>

<html:hidden property="docposition" />
<html:hidden property="storagecode" />
<html:hidden property="ownercode" />
<html:hidden property="expeditor" />

<html:hidden name="InternalForm" property="document"/>
<html:hidden name="InternalForm" property="brokentype"/>

<input type="hidden" name="_dummy_">

<table class="main">
    
<july:separator/>

<july:formbuttons/>

<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="title"><bean:message key="label.internalpos.document"/></td>
	<td class="title"><bean:message key="label.num"/>
	<%-- &nbsp;<bean:write name="InternalForm" property="blankindex"/> --%>
	&nbsp;<bean:write name="InternalForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="InternalForm" property="blankdatestr"/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.internalpos.num"/>:</july:reqmark></td>
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
	<td class="text"><july:reqmark><bean:message key="label.internalpos.resource"/>:</july:reqmark></td>
	<td>
		<%if(!readonly){%>
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="false" />

			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="true"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + aform.getSerialnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="true" image="lookup_red"/>
			<%}%>

			<july:string size="30" property="resourcemodel" insertable="false" updatable="false"/>			
			<july:string size="30" style="width: 433px;"
			property="resourcename" insertable="false" updatable="false"/>
		<%} else {%>
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false"/>
			<july:string size="30" property="resourcemodel" insertable="false" updatable="false"/>			
			<july:string size="30" 
			style="width: 433px;"
			property="resourcename" insertable="false" updatable="false"/>
		<%}%>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.internalpos.configuration"/>:</td>
	<td>
		<july:string property="configuration" size="35" 
			style="width: 433px;"
		insertable="false" updatable="false" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.internalpos.broken"/>:</td>
	<td>
		<july:checkbox property="resultBroken" insertable="true" updatable="true" value="true"/><html:hidden property="resultBroken" value="false"/>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.internalpos.docqty"/>:</july:reqmark></td>
	<td>
		<%if(!readonly){%>
			<july:string property="docQtystr" size="15" insertable="true" updatable="true" />
		<%} else {%>
			<july:string property="docQtystr" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.internalpos.qty"/>:</july:reqmark></td>
	<td>
		<%if(!readonly){%>
			<july:string property="qtystr" size="15" insertable="true" updatable="true" />
		<%} else {%>
			<july:string property="qtystr" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
    
<july:separator/>
    
<%--    
    
<tr>
	<td class="text"><bean:message key="label.internalpos.price"/>:</td>
	<td>
		<july:string property="pricestr" size="15" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>

--%>
<html:hidden property="pricestr"/>

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
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="serl" onclick="set_opt_params_serl('?owner=&storage='+document.all.expeditor.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype='+document.all.brokentype.value+'&documentkey='+document.all.document.value)" fieldNames="resourcecode;resourcename;resourcemodel;configuration;serialnumber;party;qtystr;_dummy_;_dummy_;manufserial;ownercode;pricestr" newWindowName="seriallookup" insertable="true" updatable="true"/>&nbsp;
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
	<td class="text"><bean:message key="label.internalpos.partynum"/>:</td>
	<td>
		<%if(!readonly){%>
			<july:string property="party" size="15" insertable="true" updatable='<%=""+aform.isPartyUpdatable()%>' />
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="partl" onclick="set_opt_params_partl('?owner=&storage='+document.all.expeditor.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype='+document.all.brokentype.value+'&documentkey='+document.all.document.value)" fieldNames="resourcecode;resourcename;resourcemodel;configuration;serialnumber;party;qtystr;_dummy_;_dummy_;manufserial;ownercode;pricestr" newWindowName="partylookup" insertable="true" updatable="true"/>&nbsp;
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

