<%@ page language = "java" %>
<%@ page import="com.hps.july.taglib.RolesValidation,com.hps.july.jdbcpersistence.lib.DebugSupport,com.hps.july.siteinfo.*,com.hps.july.siteinfo.formbean.*,com.hps.july.siteinfo.valueobject.Position" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.ObjectType" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants" %>
<%@ page import="com.hps.july.apptags.HasAccessTag" %>
<%@ page import="com.hps.july.web.util.ParamsParser" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<july:canedit rolesProperty="gosnetRoles">
<tr>
	<td class="text"><bean:message key="label.position.linktogosnetlat"/>:</td>
	<td>
		<july:string property="linktogosnetlatFrm" size="10" insertable="true" updatable="true" />
		&nbsp;&nbsp;&nbsp;&nbsp;
		<bean:message key="label.position.linktogosnetlon"/>:
		&nbsp;
		<july:string property="linktogosnetlonFrm" size="10" insertable="true" updatable="true" />
		<%if(request.isUserInRole("FreqManager") || request.isUserInRole("administrator")) {%>
		&nbsp; Заказ: <july:string property="orderno" size="20" insertable="true" updatable="true" />
		<%} else {%>
		<html:hidden property="orderno"/>
		<%}%>
	</td>
</tr>
</july:canedit>
<july:cannotedit rolesProperty="gosnetRoles">
<tr>
	<td class="text"><bean:message key="label.position.linktogosnetlat"/>:</td>
	<td>
		<july:string property="linktogosnetlatFrm" size="10" insertable="false" updatable="false" />
		&nbsp;&nbsp;&nbsp;&nbsp;
		<bean:message key="label.position.linktogosnetlon"/>:
		&nbsp;
		<july:string property="linktogosnetlonFrm" size="10" insertable="false" updatable="false" />
		<%if(request.isUserInRole("FreqManager") || request.isUserInRole("administrator")) {%>
		&nbsp; Заказ: <july:string property="orderno" size="20" insertable="false" updatable="false" />
		<%} else {%>
		<html:hidden property="orderno"/>
		<%}%>
	</td>
</tr>
</july:cannotedit>
<july:separator/>
<july:canedit rolesProperty="addrRoles2">
<tr>
	<td class="text"><july:reqmark><bean:message key="label.position.addr"/>:</july:reqmark></td>
	<td>
		<july:textarea property="address" cols="50" rows="2" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
</july:canedit>
<july:cannotedit rolesProperty="addrRoles2">
<tr>
	<td class="text"><july:reqmark><bean:message key="label.position.addr"/>:</july:reqmark></td>
	<td>
		<july:textarea property="address" cols="50" rows="2" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
</july:cannotedit>
<%if(request.isUserInRole("FreqManager") || request.isUserInRole("administrator")) {%>
<tr>
	<td class="text"><bean:message key="label.position.docaddr"/>:</td>
	<td>
		<july:textarea property="docaddress" cols="50" rows="2" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.position.grchaddr"/>:</td>
	<td>
		<july:textarea property="grchaddress" cols="50" rows="2" insertable="true" updatable="true" />
		<br>
		<bean:message key="label.position.grchlat"/>:
		<july:string property="grchlat" size="10" insertable="true" updatable="true" />
		&nbsp;
		<bean:message key="label.position.grchlong"/>:
		<july:string property="grchlong" size="10" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.position.comment_doc"/>:</td>
	<td>
		<july:textarea property="comment_doc" cols="50" rows="2" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<%} else if(request.isUserInRole("siteTransport") || request.isUserInRole("ArendaEconomist") || request.isUserInRole("ArendaManager") || request.isUserInRole("ArendaMainEconomist") || request.isUserInRole("ArendaMainManager")) {%>
<tr>
	<td class="text"><bean:message key="label.position.docaddr"/>:</td>
	<td>
		<july:textarea property="docaddress" cols="50" rows="2" insertable="false" updatable="false" />
<html:hidden property="comment_doc"/>
<html:hidden property="grchaddress"/>
<html:hidden property="grchlat"/>
<html:hidden property="grchlong"/>
	</td>
</tr>
<july:separator/>
<%} else {%>
<html:hidden property="comment_doc"/>
<html:hidden property="docaddress"/>
<html:hidden property="grchaddress"/>
<html:hidden property="grchlat"/>
<html:hidden property="grchlong"/>
<%}%>
