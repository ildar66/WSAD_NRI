<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="org.apache.struts.util.*,
  com.hps.july.sitedoc.valueobject.*,
  com.hps.july.sitedoc.formbean.*,
  com.hps.july.jdbcpersistence.lib.*"%>

<%
SiteDocFileForm dForm=(SiteDocFileForm)session.getAttribute("SiteDocFileForm");
%>



<tr>
<%--название--%>

<td class="text">
   <july:reqmark><bean:message key="SiteDocFile.choiceFile"/>:</july:reqmark>
 </td>

<td class="text">
  <html:file name="SiteDocFileForm" property="sitedocfilebodyFrm" size="35" />

 <logic:present name="SiteDocFileForm" property="sitedocfilename">
         <html:link page="/OpenFile.do" target="_blank" paramId="sitedocfile" paramName="SiteDocFileForm" paramProperty="sitedocfile">
                  &nbsp;<bean:write name="SiteDocFileForm" property="sitedocfilename" filter="true"/>
         </html:link>
   </logic:present>

</td>
</tr>

<tr>
    <td class="text"><bean:message key="label.comment"/>:</td>
    <td>
        <july:textarea property="note" cols="50" rows="2" insertable='true' updatable='true' />
    </td>
</tr>




