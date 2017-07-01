<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.inventory.formbean.*,com.hps.july.inventory.actionbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessAssactposB.do">
<%
	boolean readonly = true;
	AssactBForm frm = (AssactBForm)request.getSession().getAttribute("AssactBForm");
	if("1".equals(frm.getDState()) && !frm.getIsautodoc()) {
		readonly = false;
	}
	AssactposBForm aform = (AssactposBForm)request.getAttribute("AssactposBForm");
	if("View".equals(aform.getAction()) || "Delete".equals(aform.getAction())) {
		readonly |= true;
	}

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

<html:hidden property="docposition" />
<html:hidden property="positioncode" />
<html:hidden property="complectcode" />
<html:hidden property="ownercode" />
<html:hidden property="agregateSerial" />

<html:hidden name="AssactBForm" property="document"/>
<html:hidden name="AssactBForm" property="storageplace" />

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
	<td class="title"><bean:message key="label.assactposb.document"/></td>
	<td class="title"><bean:message key="label.num"/>
		<%-- &nbsp;<bean:write name="AssactBForm" property="blankindex"/> --%>
		&nbsp;<bean:write name="AssactBForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<july:datewrite name="AssactBForm" property="blankdate"/></td>
</tr>

<july:separator/>
    
<tr>
		<td class="title"><bean:message key="label.assactposb.position"/></td>
		<td class="title">
			<bean:write name="AssactBForm" property="positionid"/>&nbsp;<bean:write name="AssactBForm" property="positionname"/>
		</td>
</tr>

<july:separator/>
    
<tr>
		<td class="title"><bean:message key="label.assactposb.complect"/></td>
		<td class="title">
			<bean:write name="AssactBForm" property="complectname"/>
		</td>
</tr>

<july:separator/>
    
<tr>
		<td class="title"><bean:message key="label.assactposb.agregate"/></td>
		<td class="title">
			<bean:write name="AssactBForm" property="agregatname"/> S/N:<bean:write name="AssactBForm" property="agregateserial"/>
		</td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.assactposb.num"/>:</july:reqmark></td>
	<td>
		<logic:equal name="AssactBForm" property="readonly" value="false">
			<july:string property="orderstr" size="10" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="AssactBForm" property="readonly" value="true">
			<july:string property="orderstr" size="10" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.assactposb.resource"/>:</july:reqmark></td>
	<td>
		<logic:equal name="AssactBForm" property="readonly" value="false">
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="true" />

			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="true"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + aform.getSnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="true" image="lookup_red"/>
			<%}%>
			
			<july:string size="30" property="resourcemodel" styleId="resourcemodel"
			   insertable="false" updatable="false"/>			
			<july:string size="30" style="width: 433px;" property="resourcename" 
			   styleId="resourcename"
			   style="width: 433px;"
			   insertable="false" updatable="false"/>
		</logic:equal>
		<logic:equal name="AssactBForm" property="readonly" value="true">
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="false" updatable="false" />

			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + aform.getSnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false" image="lookup_red"/>
			<%}%>

			<july:string size="30" property="resourcemodel" styleId="resourcemodel" 
			   insertable="false" updatable="false" />
			<july:string size="30" property="resourcename" styleId="resourcename" 
			   style="width: 433px;"
			insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.assactposb.qty"/>:</july:reqmark></td>
	<td>
		<logic:equal name="AssactBForm" property="readonly" value="false">
			<july:string property="qtystr" size="15" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="AssactBForm" property="readonly" value="true">
			<july:string property="qtystr" size="15" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
    
<july:separator/>
    
<%--    
    
<tr>
	<td class="text"><bean:message key="label.assactposb.price"/>:</td>
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
			<july:string property="snumber" size="15" styleId="snumber"
			   insertable="true" updatable="true" />
			<SPAN STYLE="width: 30px;">
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="serl" onclick="if(document.all.lookupbtn_serl.disabled){return false;}set_opt_params_serl('?owner=&storage='+document.all.storageplace.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.document.value);" fieldNames="resourcecode;resourcename;resourcemodel;configuration;snumber;party;qtystr;_dummy_;_dummy_;manufserial;ownercode;pricestr" newWindowName="seriallookup" insertable="true" updatable="true"/>&nbsp;
			</SPAN>
			<july:checkbox property="fictionSerial" insertable="true" updatable='true' 
			    value="true" onclick="checkFictionSerial();"/>
			<bean:message key="label.allserials.noserial"/>
		<%} else {%>
			<july:string property="snumber" size="15" insertable="false" updatable="false" />&nbsp;
			<july:checkbox property="fictionSerial" insertable="false" updatable='false' value="true" />
			<bean:message key="label.allserials.noserial"/>
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
  function checkFictionSerial() {
		switchLookup('snumber','ser',document.all.fictionSerial[0].checked);
  }
  checkFictionSerial();
  switchCheck('inv_absent', 'manufserial', 2, 0);
  switchCheck('loc_absent', 'localserial', 3, 0);
</SCRIPT>
<%}%>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.assactposb.partynum"/>:</td>
	<td>
		<logic:equal name="AssactBForm" property="readonly" value="false">
			<july:string property="party" size="15" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="partl" onclick="set_opt_params_partl('?owner=&storage='+document.all.storageplace.value+'&resourcecode='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.document.value);" fieldNames="resourcecode;resourcename;resourcemodel;configuration;snumber;party;qtystr;_dummy_;_dummy_;manufserial;ownercode;pricestr" newWindowName="partylookup" insertable="true" updatable="true"/>
		</logic:equal>
		<logic:equal name="AssactBForm" property="readonly" value="true">
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

<july:formbuttons/>
    
<july:separator/>
    
</table>

</july:editform>

