<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	String action = null;
	String form = null;
	String navt = "L";
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.ANTENA_RES_EDIT_WN:
	        	action = "/ProcessAntenaResourceWN.do";
			form = "AntenaResourceWNForm";
			navt = "R";
        	break;
		case APPStates.ANTENA_EDIT:
	        	action = "/ProcessAntena.do";
			form = "AntenaForm";
			navt = "L";
        	break;
	}
%>

<july:editform action="<%=action%>">

<script language="javascript">
function rwplOnSelect() {
	document.all['resourcesubtypeFrm'].value = '';
	document.all['resourcesubtypename'].value = '';
}
</script>
<%String cpupdate = "true";%>
<logic:equal name="<%=form%>" property="isresourceused" value="true"><%cpupdate = "false";%></logic:equal>

<html:hidden property="resource"/>
<html:hidden property="complect"/>
	
<table class="main">

<tr><td colspan="3">
	<TABLE class="main" border="0" cellpadding="0" cellspacing="0" vAlign=top height="100%">
		<TR class="title" style="height:15">
		<TD class="title">
		<july:statenavigator/>
		</TD>
		</TR>
	</table>
	</td></tr>

<july:errors/>

<july:separator/>
  
<july:formbuttons/>

<july:separator/>	

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.restype"/></july:reqmark>:</td>
	<td>
		<july:string property="resourcetype" size="5" insertable="true" updatable="true" onkeypress="rwplOnSelect();"/>
		<july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rwpl" fieldNames="resourcetype;resourcetypename" insertable="true" updatable="true" onselect="rwplOnSelect();"/>
		<july:string size="35" property="resourcetypename" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.subtype"/>:</july:reqmark></td>
	<td>
		<july:string property="resourcesubtypeFrm" styleId="ressbtype" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="wpl" fieldNames="resourcesubtypeFrm;resourcesubtypename" onclick="set_opt_params_wpl('?resourcetype='+document.all.resourcetype.value)" insertable="true" updatable="true" />
		<july:string size="35" property="resourcesubtypename" styleId="ressbtypename" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.name"/></july:reqmark>:</td>
	<td>
		<july:string size="35" property="name" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.cable.model"/></july:reqmark>:</td>
	<td>
		<july:string size="35" property="model" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.cable.manufacturer"/>:</td>
	<td>
		<july:string property="manufacturerFrm" styleId="manufacturerFrm" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="manufacturerFrm;manufacturername" insertable="true" updatable="true" />
		<july:string size="35" property="manufacturername" styleId="manufacturername" insertable="false" updatable="false" />
        </td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.resource.manucode"/>:</td>
	<td>
		<july:string property="manucode" size="35" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.resource.unit"/></july:reqmark>:</td>
	<td>
		<july:select collection="units" property="unitFrm" insertable="true" updatable="true">
			<html:options collection="units" property="unit" labelProperty="name"/>
		</july:select>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.resource.notes"/>:</td>
	<td>
		<july:string property="notes" size="35" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td colspan="2" class="text">
<bean:message key="label.resource.complectpart"/>:&nbsp;<july:checkbox styleClass="text" property="node" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;
<bean:message key="label.resource.active"/>:&nbsp;<july:checkbox styleClass="text" property="active" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;
<bean:message key="label.resource.boxable"/>:&nbsp;<july:checkbox styleClass="text" property="boxable" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;
<bean:message key="label.resource.priceable"/>:&nbsp;<july:checkbox styleClass="text" property="priceable" insertable="true" updatable="true" />&nbsp;
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.resource.countpolicy"/>:</july:reqmark></td>
	<td>
		<july:radio styleClass="text" insertable="true" updatable="<%=cpupdate%>" property="countpolicy" value="S"/><bean:message key="label.resource.countpolicys"/>&nbsp;&nbsp;&nbsp;
		<july:radio styleClass="text" insertable="true" updatable="<%=cpupdate%>" property="countpolicy" value="P"/><bean:message key="label.resource.countpolicyp"/>&nbsp;&nbsp;&nbsp;
		<july:radio styleClass="text" insertable="true" updatable="<%=cpupdate%>" property="countpolicy" value="B"/><bean:message key="label.resource.countpolicyb"/>
	</td>
</tr>

<july:separator/>

<tr class="title">
	<td class="title" colspan="2"><bean:message key="label.cable.techparams"/></td>
</tr>

<%--    
<july:separator/>

<tr>
	<td class="text"><bean:message key="label.antena.range"/>:</td>
	<td>
		<july:select collection="ranges" property="range" insertable="true" updatable="true">
			<html:options name="ranges"/>
		</july:select>
	</td>
</tr>
--%>    
<july:separator/>

<tr>
	<td class="text"><bean:message key="label.antena.freqrange"/>:</td>
	<td>
		<july:string size="35" property="freqrange" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>

<script language="javascript">
function fix(fixNumber) {
	var ff = parseFloat(fixNumber);
	return ""+(Math.round(ff * 10.000000) / 10);
}
function calculateAmpcount(that) {
	if(<%=form%>['amplifyFrm['+that+']'].value == "") {
		<%=form%>['amplifycountFrm['+that+']'].value = "";
	} else {
		<%=form%>['amplifycountFrm['+that+']'].value = fix(Math.pow(10,<%=form%>['amplifyFrm['+that+']'].value/10.0));
	}
}
function freqEn(that) {
//	alert('Frq:'+that+' freqenabled='+<%=form%>['freqenabled['+that+']'][0].checked);
//<%=form%>['amplifyFrm[0]'].disabled = true;
	if(document.all['action'].value == 'Delete' || document.all['action'].value == 'View') {
		return;
	}
	var cc = !<%=form%>['freqenabled['+that+']'][0].checked;
	var cd;
	if(cc) { cd = cc; } else { cd = <%=form%>['omni'][0].checked; }
	var dd;
	var ee;
	if(cc) { dd = '#DCDCDC'; } else { dd = '#D6EBFF'; }
	if(cd) { ee = '#DCDCDC'; } else { ee = '#D6EBFF'; }
	<%=form%>['amplifyFrm['+that+']'].disabled = cc;
	<%=form%>['amplifyFrm['+that+']'].style.backgroundColor=dd;
	<%=form%>['amplifycountFrm['+that+']'].disabled = cc;
	<%=form%>['HWidthFrm['+that+']'].disabled = cd;
	<%=form%>['HWidthFrm['+that+']'].style.backgroundColor=ee;
	<%=form%>['VWidthFrm['+that+']'].disabled = cc;
	<%=form%>['VWidthFrm['+that+']'].style.backgroundColor=dd;
	<%=form%>['electricangleFrm['+that+']'].disabled = cc;
	<%=form%>['electricangleFrm['+that+']'].style.backgroundColor=dd;
	<%=form%>['ksvnFrm['+that+']'].disabled = cc;
	<%=form%>['ksvnFrm['+that+']'].style.backgroundColor=dd;
}
function checkOmni() {
	for(i = 0; i < 4; i++) { freqEn(i); }
	if(<%=form%>['omni'][0].checked) {
		<%=form%>['heightFrm'].disabled = true;
		<%=form%>['heightFrm'].style.backgroundColor = '#DCDCDC';
	} else {
		<%=form%>['heightFrm'].disabled = false;
		<%=form%>['heightFrm'].style.backgroundColor = '#D6EBFF';
	}
}
</script>    

<tr>
	<td class="text"><bean:message key="label.antena.polar"/>:</td>
	<td>
		<july:select collection="polars" property="polar" insertable="true" updatable="true">
			<html:options name="polars"/>
		</july:select>&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.antena.omni"/>:&nbsp;<july:checkbox styleClass="text" property="omni" insertable="true" updatable="true" onclick="checkOmni();"/>&nbsp;&nbsp;&nbsp;
	</td>
</tr>

<july:separator/>

<% String gColspan = "8"; %>
<tr>
	<td colspan="2">
		<table class="main">
		<tr class="title" style="background-color:#D6EBFF;">
			<td class="title" rowspan="2">&nbsp;</td>
			<td class="title" rowspan="2"><bean:message key="label.antena.band"/></td>
			<td class="title" colspan="2"><bean:message key="label.antena.amp"/></td>
			<td class="title" colspan="2"><bean:message key="label.antena.dir"/></td>
			<td class="title" rowspan="2">��. ������</td><%--bean:message key="label.antena.electricangle"/></td>--%>
			<td class="title" rowspan="2"><bean:message key="label.antena.ksvn"/></td>
		</tr>
		<tr class="title" style="background-color:#D6EBFF;">
			<td class="title"><bean:message key="label.antena.amp.db"/></td>
			<td class="title"><bean:message key="label.antena.amp.cnt"/></td>
			<td class="title">���.</td><%--bean:message key="label.antena.dir.horz"/></td>--%>
			<td class="title">����.</td><%--bean:message key="label.antena.dir.vert"/></td>--%>
		</tr>
		<july:separator colspan="<%=gColspan%>"/>
		<tr>
	            	<td class="text"><july:checkbox styleClass="text" property="freqenabled[0]" insertable="true" updatable="true" onclick="freqEn(0);"/></td>
	            	<td class="text">800</td>
			<td class="text"><july:string size="5" property="amplifyFrm[0]" insertable="true" updatable="true" onkeyup="calculateAmpcount(0);"/></td>
			<td class="text"><july:string size="5" property="amplifycountFrm[0]" insertable="false" updatable="false" /></td>
			<td class="text"><july:string size="5" property="HWidthFrm[0]" insertable="true" updatable="true" /></td>
			<td class="text"><july:string size="5" property="VWidthFrm[0]" insertable="true" updatable="true" /></td>
			<td class="text"><july:string size="5" property="electricangleFrm[0]" insertable="true" updatable="true" /></td>
			<td class="text"><july:string size="5" property="ksvnFrm[0]" insertable="true" updatable="true" /></td>
		</tr>
		<july:separator colspan="<%=gColspan%>"/>
		<tr>
	            	<td class="text"><july:checkbox styleClass="text" property="freqenabled[1]" insertable="true" updatable="true" onclick="freqEn(1);"/></td>
	            	<td class="text">900</td>
			<td class="text"><july:string size="5" property="amplifyFrm[1]" insertable="true" updatable="true" onkeyup="calculateAmpcount(1);"/></td>
			<td class="text"><july:string size="5" property="amplifycountFrm[1]" insertable="false" updatable="false" /></td>
			<td class="text"><july:string size="5" property="HWidthFrm[1]" insertable="true" updatable="true" /></td>
			<td class="text"><july:string size="5" property="VWidthFrm[1]" insertable="true" updatable="true" /></td>
			<td class="text"><july:string size="5" property="electricangleFrm[1]" insertable="true" updatable="true" /></td>
			<td class="text"><july:string size="5" property="ksvnFrm[1]" insertable="true" updatable="true" /></td>
		</tr>
		<july:separator colspan="<%=gColspan%>"/>
		<tr>
	            	<td class="text"><july:checkbox styleClass="text" property="freqenabled[2]" insertable="true" updatable="true" onclick="freqEn(2);"/></td>
	            	<td class="text">1800</td>
			<td class="text"><july:string size="5" property="amplifyFrm[2]" insertable="true" updatable="true" onkeyup="calculateAmpcount(2);"/></td>
			<td class="text"><july:string size="5" property="amplifycountFrm[2]" insertable="false" updatable="false" /></td>
			<td class="text"><july:string size="5" property="HWidthFrm[2]" insertable="true" updatable="true" /></td>
			<td class="text"><july:string size="5" property="VWidthFrm[2]" insertable="true" updatable="true" /></td>
			<td class="text"><july:string size="5" property="electricangleFrm[2]" insertable="true" updatable="true" /></td>
			<td class="text"><july:string size="5" property="ksvnFrm[2]" insertable="true" updatable="true" /></td>
		</tr>
		<july:separator colspan="<%=gColspan%>"/>
		<tr>
	            	<td class="text"><july:checkbox styleClass="text" property="freqenabled[3]" insertable="true" updatable="true" onclick="freqEn(3);"/></td>
	            	<td class="text">2000</td>
			<td class="text"><july:string size="5" property="amplifyFrm[3]" insertable="true" updatable="true" onkeyup="calculateAmpcount(3);"/></td>
			<td class="text"><july:string size="5" property="amplifycountFrm[3]" insertable="false" updatable="false" /></td>
			<td class="text"><july:string size="5" property="HWidthFrm[3]" insertable="true" updatable="true" /></td>
			<td class="text"><july:string size="5" property="VWidthFrm[3]" insertable="true" updatable="true" /></td>
			<td class="text"><july:string size="5" property="electricangleFrm[3]" insertable="true" updatable="true" /></td>
			<td class="text"><july:string size="5" property="ksvnFrm[3]" insertable="true" updatable="true" /></td>
		</tr>
		<july:separator colspan="<%=gColspan%>"/>
		</table>
	</td>
</tr>

<%--
<tr>
	<td class="text" colspan="2">
		 &lt;:&nbsp;<july:string size="10" property="ksvnFrm" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;
		:&nbsp;<july:string size="10" property="electricangleFrm" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;
	</td>
</tr>
    
<july:separator/>
--%>

<tr>
	<td class="text"><bean:message key="label.antena.port"/>:</td>
	<td>
		<july:string size="10" property="port" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.antena.extent"/>:</td>
	<td>
		<july:string size="10" property="lengthFrm" insertable="true" updatable="true"/>&nbsp;x&nbsp;<july:string size="10" property="widthFrm" insertable="true" updatable="true"/>&nbsp;x&nbsp;<july:string size="10" property="heightFrm" insertable="true" updatable="true"/>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.antena.weight"/>:</td>
	<td>
		<july:string size="10" property="weightFrm" insertable="true" updatable="true" />
	</td>
</tr>
    
<script language="javascript">
for(i =0; i < 4; i++) {
	calculateAmpcount(i);
	freqEn(i);
}
checkOmni();
</script>

<july:separator/>

<july:formbuttons/>

<july:separator/>
    
</table>

</july:editform>


