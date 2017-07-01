<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.formbean.*"%>
<%@ page import="com.hps.july.web.util.*"%>
<%@ page import="com.hps.july.basestation.*"%>

<july:editform action="/ProcessEtapType" styleId="EtapTypeForm">
<html:hidden property="etaptypeid"/>
<table class="main">
<july:separator/>
<july:formbuttons/>
<july:separator/>
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.etaptype.ettypename"/></july:reqmark>:</td>
	<td class="text">
		<july:string size="35" property="ettypename" styleId="ettypename" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"></td>
	<td class="text">
		<july:checkbox property="haveendtime" styleId="haveendtime" insertable="true" updatable="true"/>
		<bean:message key="label.etaptype.haveendtime"/>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"></td>
	<td class="text">
		<july:checkbox property="hopslink" styleId="hopslink" insertable="true" updatable="true"/>
		<bean:message key="label.etaptype.havehopslink"/>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"></td>
	<td class="text">
		<july:checkbox property="havepaycheck" styleId="havepaycheck" insertable="true" updatable="true"/>
		<bean:message key="label.etap.form.havepaycheck"/>
	</td>
</tr>
<july:separator/>
<july:formbuttons/>
<july:separator/>
</table>
</july:editform>
