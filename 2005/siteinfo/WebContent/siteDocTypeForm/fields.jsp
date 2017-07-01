<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="org.apache.struts.util.*,

  com.hps.july.siteinfo.formbean.*,
  com.hps.july.jdbcpersistence.lib.*"%>

<html:hidden property="sitedoctype" />



<tr>
<%--название--%>
 <td class="text">
   <july:reqmark><bean:message key="SiteDocTypeForm.sitedoctypename"/>:</july:reqmark>
 </td>
 <td>
   <july:string property="sitedoctypename" size="50" insertable="true" updatable="true" />
 </td>
</tr>

<tr>
<%--Комментарий --%>
<td class="text"><bean:message key="SiteDocTypeForm.sitedoctypetxt"/>:</td>
 <td>
    <july:textarea property="sitedoctypetxt" cols="50" rows="2" insertable='true' updatable='true' />
 </td>
</tr>



