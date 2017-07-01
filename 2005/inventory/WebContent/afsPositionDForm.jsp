<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.inventory.formbean.*,com.hps.july.inventory.actionbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessAfsDPosition.do">
<%
	AfsDPositionForm aform = (AfsDPositionForm)request.getAttribute("AfsDPositionForm");
	boolean browseBySerial = aform.isBrowseBySerial();
%>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	var dall = document.all;
	if(disabled) {
		dall[itemname].className = 'editdisabled';
		dall[itemname].disabled = true;
		dall[itemname].readonly = true;
		dall['lookupbtn_'+lookupname+'l'].disabled = true;
		dall['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
		dall['lookupbtn_'+lookupname+'l'].style.cursor = 'default';
/*		dall['lookupimg_'+lookupname+'l'].style.cursor = 'default';*/
	} else {
		dall[itemname].className = 'edit';
		dall[itemname].disabled = false;
		dall[itemname].readonly = false;
		dall['lookupbtn_'+lookupname+'l'].disabled = false;
		dall['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
		dall['lookupbtn_'+lookupname+'l'].style.cursor = 'hand';
/*		dall['lookupimg_'+lookupname+'l'].style.cursor = 'hand';*/
	}
}
</script>

<html:hidden property="docpos" />
<html:hidden property="positioncode" />
<html:hidden property="complectcode" />
<html:hidden property="expedition" />
<html:hidden property="ownercode" />

<html:hidden name="AfsForm" property="doc"/>

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
	<td class="title"><bean:message key="label.afs.document"/></td>
	<td class="title"><bean:message key="label.num"/>
		<%-- &nbsp;<bean:write name="AfsForm" property="blankindex"/> --%>
		&nbsp;<bean:write name="AfsForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="AfsForm" property="blankdatestr"/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="title"><bean:message key="label.afs.owner"/></td>
	<td class="title"><bean:write name="AfsForm" property="ownername"/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="title"><bean:message key="label.afs.position"/></td>
	<td class="title"><bean:write name="AfsForm" property="positionid"/> <bean:write name="AfsForm" property="positionname"/></td>
</tr>

<july:separator/>

<tr>
	<td class="title"><bean:message key="label.afs.complect"/></td>
	<td class="title"><bean:write name="AfsForm" property="complectname"/></td>
</tr>

<logic:present name="AfsForm" property="type">
<logic:equal name="AfsForm" property="type" value="P">
<july:separator/>

	<tr>
		<td class="title"><bean:message key="label.afs.provider"/>:</td>
		<td class="title">
			<bean:write name="AfsForm" property="providername"/>
		</td>
	</tr>

<july:separator/>

	<tr>
		<td class="title"><bean:message key="label.afs.insuranceman"/>:</td>
		<td class="title">
			<bean:write name="AfsForm" property="insuranseMan"/>
		</td>
	</tr>
</logic:equal>
<logic:equal name="AfsForm" property="type" value="W">
<july:separator/>

	<tr>
		<td class="title"><bean:message key="label.afs.worker"/>:</td>
		<td class="title">
			<bean:write name="AfsForm" property="workername"/>
		</td>
	</tr>
</logic:equal>
</logic:present>

<july:separator/>
<tr class="title">
	<td class="title" colspan="2">Делитель:</td>
</tr>
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.afs.numpp"/>:</july:reqmark></td>
	<td>
		<logic:equal name="AfsForm" property="readonly" value="false">
			<july:string property="orderstr" size="10" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="AfsForm" property="readonly" value="true">
			<july:string property="orderstr" size="10" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.afs.resourceset"/>:</td>
	<td>
		<logic:equal name="AfsForm" property="readonly" value="false">
			<july:string size="5" property="resourcesetcode" styleId="resourcesetcode" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowResourceSetLookupList.do" styleId="ressetl" fieldNames="resourcesetcode;resourcesetname;resourcecode;resourcemodel;resourcename" newWindowName="ressetlookup" insertable="true" updatable="false"/>
			<july:string size="30" property="resourcesetname" styleId="resourcesetname" insertable="false" updatable="false" />
		</logic:equal>
		<logic:equal name="AfsForm" property="readonly" value="true">
			<july:string size="5" property="resourcesetcode" styleId="resourcesetcode" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowResourceSetLookupList.do" styleId="ressetl" fieldNames="resourcesetcode;resourcesetname" newWindowName="ressetlookup" insertable="false" updatable="false"/>
			<july:string size="30" property="resourcesetname" styleId="resourcesetname" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.afs.resource"/>:</july:reqmark></td>
	<td>
		<logic:equal name="AfsForm" property="readonly" value="false">
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="false" />
			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="false"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + aform.getSnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="false" image="lookup_red"/>
			<%}%>
			<july:string size="25" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
			<july:string size="20" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
		</logic:equal>
		<logic:equal name="AfsForm" property="readonly" value="true">
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="false" updatable="false" />
			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + aform.getSnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false" image="lookup_red"/>
			<%}%>
			<july:string size="25" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
			<july:string size="20" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.afs.configuration"/>:</td>
	<td>
		<july:string property="configuration" size="35" insertable="false" updatable="false" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.afs.qty"/>:</july:reqmark></td>
	<td>
		<logic:equal name="AfsForm" property="readonly" value="false">
			<july:string property="qtystr" size="15" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="AfsForm" property="readonly" value="true">
			<july:string property="qtystr" size="15" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.afs.price"/>:</td>
	<td>
		<july:string property="pricestr" size="15" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><bean:message key="label.afs.serialnum"/>:</td>
	<td>
		<logic:equal name="AfsForm" property="readonly" value="false">
<script language="javascript">
function checkFictionSerial() {
	if(document.all.action.value == 'Add' || document.all.action.value == 'Edit') {
		switchLookup('snumber','ser',document.all.fictionSerial[0].checked);
	}
}
</script>
			<july:string property="snumber" size="15" insertable="true" updatable='<%=""+aform.isSerialUpdatable()%>' />
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="serl" onclick="set_opt_params_serl('?owner=&storage='+document.all.expedition.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.doc.value)" fieldNames="resourcecode;resourcename;resourcemodel;configuration;snumber;party;qtystr;_dummy_;_dummy_;manufserial;ownercode;pricestr" newWindowName="seriallookup" insertable="true" updatable="true"/>&nbsp;
			<july:checkbox property="fictionSerial" insertable="true" updatable="true" value="true" styleClass="text" onclick="checkFictionSerial();"/>с/н неизвестен
			<script language="javascript">checkFictionSerial();</script>
		</logic:equal>
		<logic:equal name="AfsForm" property="readonly" value="true">
			<july:string property="snumber" size="15" insertable="false" updatable="false" />
			<july:checkbox property="fictionSerial" insertable="false" updatable="false" value="true" styleClass="text"/>с/н неизвестен
		</logic:equal>
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
	<td class="text"><bean:message key="label.afs.partynum"/>:</td>
	<td>
		<logic:equal name="AfsForm" property="readonly" value="false">
			<july:string property="party" size="15" insertable="true" updatable='<%=""+aform.isPartyUpdatable()%>' />
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="partl" onclick="set_opt_params_partl('?owner=&storage='+document.all.expedition.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.doc.value)" fieldNames="resourcecode;resourcename;resourcemodel;configuration;snumber;party;qtystr;_dummy_;_dummy_;manufserial;ownercode;pricestr" newWindowName="partylookup" insertable="true" updatable="true"/>&nbsp;
		</logic:equal>
		<logic:equal name="AfsForm" property="readonly" value="true">
			<july:string property="party" size="15" insertable="false" updatable="false" />
		</logic:equal>
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

<tr>
	<td class="text"><bean:message key="label.inventory.comment"/>:</td>
	<td>
		<july:string property="comment" size="40" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark>Кабель</july:reqmark>:</td>
	<td>
		<july:select collection="cableTypes" property="cableres" insertable="true" updatable="true" style="width:300pt;">
			<html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
		</july:select>
	</td>
</tr>
<tr>
	<td class="text" style="padding-left:20pt;">Длина:</td>
	<td>
		<july:string property="cablelen" size="10" insertable="true" updatable="true"/>
	</td>
</tr>
<july:separator/>

<july:formbuttons/>
    
<july:separator/>
    
</table>

</july:editform>

