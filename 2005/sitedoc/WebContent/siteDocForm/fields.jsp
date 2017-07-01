<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.sitedoc.valueobject.*"%>
<%@ page import="com.hps.july.sitedoc.formbean.*"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.*"%>
<%@ page import="com.hps.july.constants.Applications"%>

<%
SiteDocForm dForm=(SiteDocForm)session.getAttribute("SiteDocForm");
DocObjectDef odef = DocObjectDef.getDef(session);
%>

<tr>
<%--тип документа--%>
  <td class="text"><july:reqmark><bean:message key="SiteDocForm.siteDocType"/>:</july:reqmark></td>
  <td>
    <july:select  style="width:340pt" collection="siteDocTypes" property="siteDocTypeIdFrm" insertable='true' updatable='true'>
       <html:options collection="siteDocTypes" property="sitedoctype" labelProperty="sitedoctypename"/>
    </july:select>
  </td>
</tr>

<%
if(odef.isProject()) {
%>
<tr>
<%--этап проекта--%>
  <td class="text"><july:reqmark><bean:message key="SiteDocForm.projectAction"/>:</july:reqmark></td>
  <td>
    <july:select   style="width:340pt" collection="projectActions"   property="projectActionFrm" insertable='true' updatable='true'>
       <html:options collection="projectActions" property="projectaction" labelProperty="projectactiontype.name"/>
    </july:select>
  </td>
</tr>
<%
}
%>

<tr>
<%--Регистр дата--%>
 <td class="text">
   <july:reqmark><bean:message key="SiteDocForm.blankdate"/>:</july:reqmark>
 </td>
 <td>
   <july:date property="blankdateFrm" required="true" styleId="blankdateId" size="25" insertable='true' updatable='true'/>
  </td>
</tr>

<tr>
<%--Номер документа--%>
 <td class="text">
   <july:reqmark><bean:message key="SiteDocForm.blanknumber"/>:</july:reqmark>
 </td>
 <td>
     <july:string property="blanknumber" size="50" insertable="true" updatable="true" />
 </td>
</tr>

<tr>
<%--Срок действия--%>
 <td class="text">
   <bean:message key="SiteDocForm.expiredate"/>:
 </td>
 <td>
   <july:date property="expiredateFrm" required="false" styleId="expiredateId" size="25" insertable='true' updatable='true'/>
 </td>
</tr>

<tr>
<%--Комментарий --%>
<td class="text"><bean:message key="SiteDocList.comment"/>:</td>
 <td>
    <july:textarea property="comment" cols="50" rows="2" insertable='true' updatable='true' />
 </td>
</tr>



