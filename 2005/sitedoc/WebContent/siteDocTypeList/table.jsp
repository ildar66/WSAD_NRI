<%@ page language = "java" %>
<%@ page import="com.hps.july.persistence.*,
                 com.hps.july.sitedoc.valueobject.SiteDocObject,
                 com.hps.july.jdbcpersistence.lib.DebugSupport"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>


<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% //String gColSpan = "7";

String gColSpan = request.getAttribute("colspan")+"";
%>

        <!-- Table header -->

<tr class="title">
   <TD class="title">&nbsp;</TD>
   <july:headercolumn key="SiteDocTypeList.table.name" colType="string"/>
   <july:headercolumn key="SiteDocTypeList.table.txt" colType="string"/>
   <TD class="title">&nbsp;</TD>

</tr>

<july:separator colspan="<%= gColSpan %>" />

     <!-- Table body -->

<logic:iterate id="docType" name="browseList">
<%SiteDocTypeAccessBean dType=(SiteDocTypeAccessBean)pageContext.getAttribute("docType");
//DebugSupport.printlnTest("siteDocTypeList.jsp sitedoctype="+dType.getSitedoctype());
%>

<logic:present name="docType">

<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

<td class="link">

  <july:editbutton page="/EditSiteDocType.do" action="Edit" paramId="sitedoctype" paramName="docType" paramProperty="sitedoctype"/>

<%--
  <july:editbutton page="/EditSiteDocType.do?action=Edit&sitedoctype=<%=dType.getSitedoctype()%>" action="Edit"/>
--%>
</td>

<td class="text">
  <bean:write name="docType" property="sitedoctypename"/>
</td>

<td class="text">
  <bean:write name="docType" property="sitedoctypetxt"/>
</td>

<td class="link">
<july:delbutton page="/EditSiteDocType.do?action=Delete" paramId="sitedoctype" paramName="docType" paramProperty="sitedoctype"/>
</td class="link">

</tr>

<july:separator colspan="<%= gColSpan %>" />

  </logic:present>

</logic:iterate>


