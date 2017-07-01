<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%int gColSpan = Integer.parseInt(request.getAttribute("colspan")+"");%>

<tr>
	<td class="text"><bean:message key="additionalActions"/>:</td>
	<td class="text" colspan=<%=gColSpan-1%> >
		<july:link page="/ShowSiteDocTypeList.do?returnPage=/ShowSiteDocList.do">
			<bean:message key="documentTypes"/>
		</july:link>
	</td>
</tr>