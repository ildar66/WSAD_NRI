<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessRRLDiamParams.do">

<script language="javascript">
function rwplOnSelect() {
	document.all['resourcesubtypeFrm'].value = '';
	document.all['resourcesubtypename'].value = '';
}

</script>


<html:hidden property="complect"/>

<%
   com.hps.july.dictionary.formbean.RRLDiamParamForm form =
          (com.hps.july.dictionary.formbean.RRLDiamParamForm)pageContext.findAttribute("RRLDiamParamForm");
%>

<html:hidden property="resourceFrm" value="<%= Integer.toString(form.getResource()) %>"/>
<html:hidden property="rrlantid"/>

<table class="main">

<july:separator/>

<july:formbuttons/>

<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.rrlresource.params.antdiam"/></july:reqmark>:</td>
	<td>
		<july:string size="35" property="antdiamFrm" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.rrlresource.params.amplifkoeff"/></july:reqmark>:</td>
	<td>
		<july:string size="35" property="amplifkoeffFrm" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.rrlresource.params.dnangleh"/></july:reqmark>:</td>
	<td>
		<july:string size="35" property="dnanglehFrm" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.rrlresource.params.dnanglew"/></july:reqmark>:</td>
	<td>
		<july:string size="35" property="dnanglewFrm" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>

<july:formbuttons/>

<july:separator/>

</table>

</july:editform>


