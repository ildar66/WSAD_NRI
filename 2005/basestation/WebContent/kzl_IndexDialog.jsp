<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.basestation.*,com.hps.july.basestation.formbean.*"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/Kzl_IndexDialog.do";
	String form = "Kzl_IndexDialogForm";
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="positionID"/>
<html:hidden property="operation" value=""/>
<html:hidden property="formname"/>
<html:hidden property="fieldnames"/>
<html:hidden property="index"/>

<script language="javascript">
	function Go(strval) {
		var thisform = document.<%= form %>;
		var outform = window.opener.document.forms[thisform.formname.value];
		if(outform != null)
		{
			var names = thisform.fieldnames.value.split('|'), values = strval.split('|');
			for(var i in names) {
				if(names[i].length > 0){
					if(names[i] == "numberFrmId"){
						outform[names[i]].value = unescape(thisform.index.value + values[i]);
					}else{
						outform[names[i]].value = unescape(values[i]);
					}
				}
			}
		}
		Close();
	}
	function Close()
		{
			if(window.opener) {
				window.opener.focus();
			}
			window.close();
		}
	function changeRegionID(){
		document.all.operation.value = "changeRegionID";
		<%= form %>.submit();
		return false;
	}
</script>
<!-- Стили -->
<style>
TD.normal {
	background-color:#CCCCCC;
}
TD.select {
	background-color:#FFFFFF;
}
TD.selected {
	background-color:#FFF0D0;
} 
</style>
<table class="main"  style="font-size:8pt;">

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><B>Регион сети планирования радиодоступа:</B></td>
		<td class="text">
			<july:select style="width: 200;" property="regionID" collection="kzlRegionList" styleId="regionID" insertable="true" updatable="true"  onchange="changeRegionID();">
				<html:options collection="kzlRegionList" property="regionid" labelProperty="regionname"/>
			</july:select>
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td bgcolor="#8899FF"><B>официальная нумерация:</B></td>
<%--
		<td bgcolor="#A5F3C6"><B>нумерация по CI (CGI):</B></td>
--%>
    </tr>

	<tr class="normal">
		<td bgcolor="#8899FF" style="padding-left:4px;padding-right:4px;">
			<table  width="100%" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;">
				<tr bgcolor="#CCCCCC">
					<logic:iterate id="it" name="<%= form %>" property="kzlRegionPrefixList" type="com.hps.july.basestation.valueobject.KzlRegionsPrefix_VO" indexId="indexId">
						<logic:present name="it">
								<td align="middle" onMouseOver="className='select'" onMouseOut="className='normal'" ondblclick='Go("<bean:write name="it" property="cellname_prefix" filter="true"/>|<bean:write name="it" property="cellid_prefix" filter="true"/>")'>
									<bean:write name="it" property="cellname_prefix" filter="true"/>
								</td>
								<%if((indexId.intValue() + 1) % 4 == 0) {%>
									</tr><tr bgcolor="#CCCCCC">
								<%}%>
						</logic:present>
					</logic:iterate>
				</tr>
			</table>
		</td>
<%--
		<td bgcolor="#A5F3C6" style="padding-left:4px;padding-right:4px;">
			<table  width="100%" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;">
				<tr bgcolor="#CCCCCC">
					<logic:iterate id="it" name="<%= form %>" property="kzlRegionPrefixList" type="com.hps.july.basestation.valueobject.KzlRegionsPrefix_VO" indexId="indexId">
						<logic:present name="it">
								<td align="middle" onMouseOver="className='select'" onMouseOut="className='normal'"  ondblclick='Go("<bean:write name="it" property="cellname_prefix" filter="true"/>|<bean:write name="it" property="cellid_prefix" filter="true"/>")'>
									<bean:write name="it" property="cellid_prefix" filter="true"/>
								</td>
								<%if((indexId.intValue() + 1) % 4 == 0) {%>
									</tr><tr bgcolor="#CCCCCC">
								<%}%>
						</logic:present>
					</logic:iterate>
				</tr>
			</table>
		</td>
--%>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:editform>
