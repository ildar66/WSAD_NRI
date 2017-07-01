<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessSysconst.do">

<font class="red">*&nbsp;</font><bean:message key="label.sysconst.id"/>:
<july:string property="id" size="5" insertable="true" updatable="false" /><BR>
<july:date property="datevaluestr" size="25" insertable="true" updatable="true" />
<july:formbuttons/>
</july:editform>

