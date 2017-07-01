<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.siteinfo.*,com.hps.july.siteinfo.formbean.*" %>
<%@ page import="com.hps.july.constants.Applications" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<july:editform action="/ProcessBeenet.do" styleId="BeenetForm">
<%
	BeenetForm frm = (BeenetForm)request.getAttribute("BeenetForm");
	String beenetid = frm.getBeenetid();
%>
<table class="main">
<july:separator/>
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<html:hidden property="storageplace" />
<tr>
	<td class="text"><july:reqmark><bean:message key="label.beenet.beenetid"/>:</july:reqmark></td>
	<td>
		<july:string property="beenetid" size="8" insertable="true" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.beenet.category"/>:</july:reqmark></td>
	<td>
   		<july:select collection="categories" property="categid" insertable="true" updatable="true" style="width:400px;">
			<html:options collection="categories" property="categid" labelProperty="categname"/>
		</july:select>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.beenet.position"/>:</td>
	<td>
		<bean:write name="BeenetForm" property="posid" filter="true"/> <bean:write name="BeenetForm" property="posname" filter="true"/>
	</td>
</tr>
<july:separator />
<tr>
	<td colspan="2">
	<table width="100%" border="0" class="main" id="regtbl">
	<tr class="title">
		<july:headercolumn key="label.equipment.type" colType="string"/>
		<july:headercolumn key="label.equipment.name" colType="string"/>
		<td class="title">Другие №№ BeeNet</td>
		<td class="title">&nbsp;</td>
	</tr>
<logic:iterate id="equ" name="BeenetForm" property="equipmentList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<%if(equ != null) {%>
<%
	String equipment = equ.getColumn("equipment").asString();
	String type = equ.getColumn("type").asString();
	String equsubtype = equ.getColumn("equsubtype").asString();
	if(equ.getColumn("equsubtype").asObject() == null) {
		equsubtype = null;
	}
	String equname = equ.getColumn("equname").asString();
	String equstate = equ.getColumn("equstate").asString();
	Object haveAgregates = equ.getColumn("agrcount").asObject();

	pageContext.setAttribute("equ_equipment",equipment);
	String ob = frm.getOtherBeenets(equipment,beenetid);
	boolean showCB = false;
	showCB = ob == null || "".equals(ob.trim());
%>
	<tr class="normal">
		<td class="text"><%if(equsubtype != null && !"".equals(equsubtype)) {%><bean:message key="<%=equsubtype%>"/><%}%></td>
		<td class="text"><july:stringwrite name="equ" property="equname"/></td>
		<td class="text"><%=ob%></td>
		<td class="text"><%if(showCB){%><july:checkbox name="BeenetForm" property='equipment' value='<%=equipment%>' insertable="true" updatable="true"/><%}%></td>
	</tr>
<%}%>
</logic:iterate>
	</table>
	</td>
</tr>
<july:separator/>
<july:formbuttons/>
<july:separator/>
</table>
</july:editform>
