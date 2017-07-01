<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.inventory.formbean.*,com.hps.july.inventory.actionbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessPayoffPosition.do">
<%
	PayoffForm frm = (PayoffForm)request.getSession().getAttribute("PayoffForm");
	boolean showpositions = "View".equals(frm.getAction()) || "Edit".equals(frm.getAction());
	boolean changable = "1".equals(frm.getDState()) && !frm.getIsautodoc() && showpositions;
	PayoffPositionForm aform = (PayoffPositionForm)request.getAttribute("PayoffPositionForm");

	boolean browseBySerial = aform.isBrowseBySerial();
%>


<html:hidden property="docposition" />
<html:hidden property="storagecode" />
<html:hidden property="ownercode" />

<html:hidden property="policy" />

<html:hidden name="PayoffForm" property="document"/>

<input type="hidden" name="configuration" value="">

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
	<td class="title"><bean:message key="label.payoff.storage"/></td>
	<td class="title"><bean:write name="PayoffForm" property="storagename"/></td>
</tr>
<july:separator/>
<tr>
	<td class="title"><bean:message key="label.payoff.document"/></td>
	<td class="title"><bean:message key="label.num"/>
		<%-- &nbsp;<bean:write name="PayoffForm" property="blankindex"/> --%>
		&nbsp;<bean:write name="PayoffForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="PayoffForm" property="blankdatestr"/></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payoff.numpp"/>:</july:reqmark></td>
	<td>
		<%if(changable){%>
			<july:string property="orderstr" size="10" insertable="true" updatable="true" />
		<%} else {%>
			<july:string property="orderstr" size="10" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payoff.resource"/>:</july:reqmark></td>
	<td>
		<%if(changable){%>
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="false" />

			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="false"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + aform.getSerialnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="false" image="lookup_red"/>
			<%}%>

			<july:string size="25" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
			<july:string size="25" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
		<%} else {%>
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="false" updatable="false" />

			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + aform.getSerialnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false" image="lookup_red"/>
			<%}%>

			<july:string size="25" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
			<july:string size="25" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.payoff.serialnum"/>:</td>
	<td>
		<%if(changable){%>
			<july:string property="serialnumber" size="15" insertable="true" updatable='<%=""+aform.isSerialUpdatable()%>' />
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="serl" onclick="set_opt_params_serl('?storage='+document.all.storagecode.value+'&resource='+document.all.resourcecode.value+'&owner=&agregate=&brokentype=1&documentkey='+document.all.document.value)" fieldNames="resourcecode;resourcename;resourcemodel;configuration;serialnumber;party;qtystr;_dummy_;_dummy_;manufserial;ownercode" newWindowName="seriallookup" insertable="true" updatable="true"/>&nbsp;
		<%} else {%>
			<july:string property="serialnumber" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.manufserial"/>:</td>
	<td>
		<july:string property="manufserial" size="15" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.payoff.partynum"/>:</td>
	<td>
		<%if(changable){%>
			<july:string property="party" size="15" insertable="true" updatable='<%=""+aform.isPartyUpdatable()%>' />
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="partl" onclick="set_opt_params_partl('?storage='+document.all.storagecode.value+'&resource='+document.all.resourcecode.value+'&owner=&agregate=&brokentype=1&documentkey='+document.all.document.value)" fieldNames="resourcecode;resourcename;resourcemodel;configuration;serialnumber;party;qtystr;_dummy_;_dummy_;manufserial;ownercode;pricestr" newWindowName="partylookup" insertable="true" updatable="true"/>&nbsp;
		<%} else {%>
			<july:string property="party" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payoff.qty"/>:</july:reqmark></td>
	<td>
		<%if(changable){%>
			<july:string property="qtystr" size="15" insertable="true" updatable="true" />
		<%} else {%>
			<july:string property="qtystr" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payoff.price"/>:</july:reqmark></td>
	<td>
		<july:string property="pricestr" size="15" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<july:formbuttons/>
<july:separator/>
</table>
</july:editform>

