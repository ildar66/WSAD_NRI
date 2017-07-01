<%@ page import="com.hps.july.sitedoc.formbean.SiteDocForm,
                 com.hps.july.jdbcpersistence.lib.*,
                 com.hps.july.persistence.SiteDocType"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%
SiteDocForm dForm=(SiteDocForm)session.getAttribute("SiteDocForm");
//DebugSupport.printlnTest("tittleObject.jsp dForm.getNetzoneName()="+dForm.getNetzoneName());
String clsp;
if(request.getAttribute("colspan")==null){
    clsp="2";
}else{
    clsp=(Integer.parseInt(""+request.getAttribute("colspan"))-1)+"";
}

%>

<tr>
 <td class="text"><bean:message key="SiteDocForm.tittle.document"/>:</td>
 <td colspan=<%=clsp%>>
	<%=dForm.getSiteDocType().getSitedoctypename()+" N"+dForm.getBlanknumber()+" "%>
	<bean:message key="SiteDocForm.tittle.from"/>
	<%=" "+dForm.getBlankdateFrm()%>
 </td>
</tr>
