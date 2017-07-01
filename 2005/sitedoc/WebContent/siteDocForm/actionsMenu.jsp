<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%--@ page import=" com.hps.july.jdbcpersistence.lib.*,
                 com.hps.july.constants.Applications,
                 com.hps.july.siteinfo.formbean.EquipmentForm" --%>
<%//int gColSpan = Integer.parseInt(request.getAttribute("colspan")+"");
int gColSpan=7;
%>

    <tr>
        <td class="text"><bean:message key="additionalActions"/>:</td>

<td class="text" colspan=<%=gColSpan-1%> >
<july:link  page="/ShowSiteDocTypeList.do?returnPage=/EditSiteDoc.do"   >
       <bean:message key="documentTypes"/>
</july:link>
</td>
</tr>