<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.inventory.formbean.*,com.hps.july.inventory.actionbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<july:editform action="/ProcessAfsAPosition.do">

<html:hidden property="docpos" />
<html:hidden property="positioncode" />
<html:hidden property="complectcode" />
<html:hidden property="expedition" />
<html:hidden property="ownercode" />

<html:hidden name="AfsPositionListForm" property="document"/>

<input type="hidden" name="_dummy_" value="">

<table class="main">
    
<july:separator/>
    
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="title"><bean:message key="label.afsa.document"/></td>
	<td class="title"><bean:message key="label.num"/>
		<%-- &nbsp;<bean:write name="AfsPositionListForm" property="blankindex"/> --%>
		&nbsp;<bean:write name="AfsPositionListForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="AfsPositionListForm" property="blankdatestr"/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="title"><bean:message key="label.afs.owner"/></td>
	<td class="title"><bean:write name="AfsPositionListForm" property="ownername"/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="title"><bean:message key="label.afs.position"/></td>
	<td class="title"><bean:write name="AfsPositionListForm" property="positionname"/></td>
</tr>

<july:separator/>

<tr>
	<td class="title"><bean:message key="label.afs.complect"/></td>
	<td class="title"><bean:write name="AfsPositionListForm" property="complectname"/></td>
</tr>

<logic:present name="AfsPositionListForm" property="type">
<logic:equal name="AfsPositionListForm" property="type" value="P">
<july:separator/>

	<tr>
		<td class="title"><bean:message key="label.afs.provider"/>:</td>
		<td class="title">
			<bean:write name="AfsPositionListForm" property="providername"/>
		</td>
	</tr>

<july:separator/>

	<tr>
		<td class="title"><bean:message key="label.afs.insuranceman"/>:</td>
		<td class="title">
			<bean:write name="AfsPositionListForm" property="insuranseMan"/>
		</td>
	</tr>
</logic:equal>
<logic:equal name="AfsPositionListForm" property="type" value="W">
<july:separator/>

	<tr>
		<td class="title"><bean:message key="label.afs.worker"/>:</td>
		<td class="title">
			<bean:write name="AfsPositionListForm" property="workername"/>
		</td>
	</tr>
</logic:equal>
</logic:present>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.numpp"/></july:reqmark>:</td>
	<td>
		<logic:equal name="AfsPositionListForm" property="readonly" value="false">
			<july:string property="order.string" size="10" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="AfsPositionListForm" property="readonly" value="true">
			<july:string property="order.string" size="10" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><table class="main"><tr>
		<td class="text"><july:reqmark><bean:message key="label.afsa.sector"/></july:reqmark></td><td class="text">800</td></tr></table></td>
	<td>
		<july:checkbox property="sectorA" insertable="true" updatable="true" value="true"/>A&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:checkbox property="sectorB" insertable="true" updatable="true" value="true"/>B&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:checkbox property="sectorC" insertable="true" updatable="true" value="true"/>C&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:checkbox property="sectorD" insertable="true" updatable="true" value="true"/>D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:checkbox property="sectorE" insertable="true" updatable="true" value="true"/>E&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:checkbox property="sectorO" insertable="true" updatable="true" value="true"/>O&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.az_ant"/></july:reqmark>:</td>
	<td>
		<logic:equal name="AfsPositionListForm" property="readonly" value="false">
			<july:string property="az_ant.string" size="5" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:message key="label.afsa.az_variation"/><july:string property="az_variation" size="15" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="AfsPositionListForm" property="readonly" value="true">
			<july:string property="az_ant.string" size="5" insertable="false" updatable="false" />
			<bean:message key="label.afsa.az_variation"/><july:string property="az_variation" size="15" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.kind_ant"/></july:reqmark>:</td>
	<td>
		<july:radio property="kind_ant" insertable="true" updatable="true" value="T"><bean:message key="label.afsa.kind_ant.tr"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:radio property="kind_ant" insertable="true" updatable="true" value="R"><bean:message key="label.afsa.kind_ant.r"/>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.antenna"/>:</july:reqmark></td>
	<td>
		<logic:equal name="AfsPositionListForm" property="readonly" value="false">
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="false" />
			<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="false"/>
			<july:string size="25" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
			<july:string size="20" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
		</logic:equal>
		<logic:equal name="AfsPositionListForm" property="readonly" value="true">
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false"/>
			<july:string size="25" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
			<july:string size="20" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.qty"/>:</july:reqmark></td>
	<td>
		<july:string property="qty.string" size="5" insertable="false" updatable="false" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:string property="price.string" size="15" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>

<%
	AfsAPositionForm aform = (AfsAPositionForm)request.getAttribute("AfsAPositionForm");
%>

<tr>
	<td class="text"><bean:message key="label.afsa.serialnum"/>:</td>
	<td>
		<logic:equal name="AfsPositionListForm" property="readonly" value="false">
<script language="javascript">
function checkFictionSerial() {
}
</script>
			<july:string property="snumber" size="15" insertable="true" updatable='true' />  <%-- <%=""+aform.isSerialUpdatable()%>  --%>
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="serl" onclick="set_opt_params_serl('?pagetype=2&owner=&storage='+document.all.expedition.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.document.value)" fieldNames="resourcecode;resourcename;resourcemodel;_dummy_;snumber;_dummy_;_dummy_;_dummy_;_dummy_;_dummy_;_dummy_;_dummy_" newWindowName="seriallookup" insertable="true" updatable="true"/>&nbsp;
			<july:checkbox property="fictionSerial" insertable="true" updatable="true" value="true" styleClass="text" onclick="checkFictionSerial();"/>с/н неизвестен    <%-- <%=updatable%> --%>
		</logic:equal>
		<logic:equal name="AfsPositionListForm" property="readonly" value="true">
			<july:string property="snumber" size="15" insertable="false" updatable="false" />
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
	<td class="text"><july:reqmark><bean:message key="label.afsa.nakl"/></july:reqmark>:</td>
	<td>
		<logic:equal name="AfsPositionListForm" property="readonly" value="false">
			<july:string property="nakl.string" size="5" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:message key="label.afsa.nakl_variation"/><july:string property="nakl_variation" size="15" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="AfsPositionListForm" property="readonly" value="true">
			<july:string property="az_ant.string" size="5" insertable="false" updatable="false" />
			<bean:message key="label.afsa.nakl_variation"/><july:string property="nakl_variation" size="15" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.h_set1"/></july:reqmark>:</td>
	<td>
		<logic:equal name="AfsPositionListForm" property="readonly" value="false">
			<july:string property="h_set1.string" size="5" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:message key="label.afsa.ksvn"/><july:string property="ksvn.string" size="15" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="AfsPositionListForm" property="readonly" value="true">
			<july:string property="h_set1.string" size="5" insertable="false" updatable="false" />
			<bean:message key="label.afsa.ksvn"/><july:string property="ksvn.string" size="15" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>

<july:separator/>

<tr class="title">
	<td class="title" colspan="2"><bean:message key="label.afsa.cable"/></td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.cable"/>:</july:reqmark></td>
	<td>
		<logic:equal name="AfsPositionListForm" property="readonly" value="false">
			<july:string size="5" property="cablecode" styleId="cablecode" insertable="true" updatable="false" />
			<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="cablecode;cablemodel;cablename" newWindowName="resourcelookup" insertable="true" updatable="false"/>
			<july:string size="25" property="cablemodel" styleId="cablemodel" insertable="false" updatable="false" />
			<july:string size="20" property="cablename" styleId="cablename" insertable="false" updatable="false" />
		</logic:equal>
		<logic:equal name="AfsPositionListForm" property="readonly" value="true">
			<july:string size="5" property="cablecode" styleId="cablecode" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="cablecode;cablemodel;cablename" newWindowName="resourcelookup" insertable="false" updatable="false"/>
			<july:string size="25" property="cablemodel" styleId="cablemodel" insertable="false" updatable="false" />
			<july:string size="20" property="cablename" styleId="cablename" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.len_cable"/>:</july:reqmark></td>
	<td>
		<july:string property="len_cable.string" size="20" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.afsa.cableparty"/>:</td>
	<td>
		<logic:equal name="AfsPositionListForm" property="readonly" value="false">
			<july:string property="party" size="15" insertable="true" updatable='true' />  <%-- <%=""+aform.isPartyUpdatable()%> --%>
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="partl" onclick="set_opt_params_partl('?pagetype=3&owner=&storage='+document.all.expedition.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.document.value)" fieldNames="cablecode;cablename;cablemodel;_dummy_;_dummy_;party;len_cable.string;_dummy_;_dummy_;_dummy_;_dummy_;_duumy_" newWindowName="partylookup" insertable="true" updatable="true"/>&nbsp;
		</logic:equal>
		<logic:equal name="AfsPositionListForm" property="readonly" value="true">
			<july:string property="party" size="15" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.ground"/>:</july:reqmark></td>
	<td>
		<logic:equal name="AfsPositionListForm" property="readonly" value="false">
			<july:string size="5" property="groundcode" styleId="groundcode" insertable="true" updatable="false" />
			<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="groundcode;groundmodel;groundname" newWindowName="resourcelookup" insertable="true" updatable="false"/>
			<july:string size="25" property="groundmodel" styleId="groundmodel" insertable="false" updatable="false" />
			<july:string size="20" property="groundname" styleId="groundname" insertable="false" updatable="false" />
		</logic:equal>
		<logic:equal name="AfsPositionListForm" property="readonly" value="true">
			<july:string size="5" property="groundcode" styleId="groundcode" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="groundcode;groundmodel;groundname" newWindowName="resourcelookup" insertable="false" updatable="false"/>
			<july:string size="25" property="groundmodel" styleId="groundmodel" insertable="false" updatable="false" />
			<july:string size="20" property="groundname" styleId="groundname" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.groundqty"/>:</july:reqmark></td>
	<td>
		<july:string property="groundqty.string" size="20" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><bean:message key="label.afsa.sector"/></td>
	<td>
		<july:checkbox property="has_flt" insertable="true" updatable="true" value="true"/><bean:message key="label.afsa.has_flt"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:checkbox property="has_lna" insertable="true" updatable="true" value="true"/><bean:message key="label.afsa.has_lna"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:checkbox property="has_buster" insertable="true" updatable="true" value="true"/><bean:message key="label.afsa.has_buster"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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

