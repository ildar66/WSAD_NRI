<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.*" %>
<%@ page import="com.hps.july.constants.Applications" %>
<%@ page import="com.hps.july.siteinfo.formbean.EquipmentForm,java.util.*" %>
<%@ page import="com.hps.july.web.util.ParamsParser" %>

<logic:equal name="EquipmentForm" property="action" value="Edit">

<%
EquipmentForm eForm = (EquipmentForm)pageContext.findAttribute("EquipmentForm");

DebugSupport.printlnTest("AppConstants.BASE_SITEDOC="+AppConstants.BASE_SITEDOC);

//String requestUrl=request.getRequestURI()+request.getQueryString();
StringBuffer siteDocUrl= new StringBuffer(
	AppConstants.BASE_SITEDOC+"/ShowSiteDocList.do?appHome="
	+ParamsParser.getRootApp(pageContext)
	+"&objectId="+eForm.getStorageplace()+"&objectType="+eForm.getType()+"&searchBy=O"
	/*+"&"+((StateManager)session.getAttribute(AppConstants.PARAM_STATE_MANAGER)).getParameterString()*/	);
/*	Enumeration enum = request.getParameterNames();
	while(enum.hasMoreElements()){
		String name = (String)enum.nextElement();
		String[] values = request.getParameterValues(name);
		for(int i = 0; i < values.length; i++){
			siteDocUrl.append("&"+name+"="+values[i]);
		}
	}
*/
  //+"&objectUrl="+requestUrl;
%>
<tr>
	<td class="text"><bean:message key="label.position.actions"/>:</td>
<td>
<july:link  href="<%=siteDocUrl.toString()%>">
	<bean:message key="link.documents"/>
</july:link>
<july:separator />
</logic:equal>
