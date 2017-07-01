<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport" %>
<%@ page import="com.hps.july.constants.Applications" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants" %>

<july:editform action="/ProcessGKRCHDocFile.do" enctype="multipart/form-data">
<html:hidden property="sitedoc"/>
<html:hidden property="sitedocfile"/>
<table class="main">
<july:separator/>
<july:formbuttons/>
<july:separator/>
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.gkrch.title"/>:</td>
	<td>
		<bean:message key="label.gkrch.title.document"/>
		<bean:write name="GKRCHForm" property="vo.blanknumber" filter="true"/>
		<bean:message key="label.gkrch.title.from"/>
		<bean:write name="GKRCHForm" property="blankdate.string" filter="true"/>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.gkrch.file"/>:</july:reqmark></td>
	<td class="text">
		<html:file name="GKRCHFileForm" property="sitedocfilebodyFrm" size="35"/>
		<logic:present name="GKRCHFileForm" property="sitedocfilename">
			<html:link page="/OpenFile.do" target="_blank" paramId="sitedocfile" paramName="GKRCHFileForm" paramProperty="sitedocfile">
			&nbsp;<bean:write name="GKRCHFileForm" property="sitedocfilename" filter="true"/>
			</html:link>
		</logic:present>
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="label.gkrch.comment"/>:</td>
	<td>
		<july:textarea property="note" cols="50" rows="2" insertable='true' updatable='true' />
	</td>
</tr>
<july:separator/>
<july:formbuttons/>
<july:separator/>
</july:editform>
</table>



