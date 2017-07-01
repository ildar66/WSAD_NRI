<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants"%>
<%@ page import="com.hps.july.basestation.formbean.ComlineRForm"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.apptags.HasAccessTag"%>
<%@ page import="com.hps.july.web.util.*"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%
	int gColSpan=7;
	boolean isFromSiteinfo=ParamsParser.getRootApp(pageContext)==Applications.SITEINFO;
	ComlineRForm eForm=(ComlineRForm)request.getAttribute("EquipmentPForm");
	String siteDocUrl=AppConstants.BASE_SITEDOC+"/ShowSiteDocList.do?appHome="+ParamsParser.getRootApp(pageContext)+"&objectId="+eForm.getHopsid()+"&objectType=Comline&canModify="+HasAccessTag.hasAccess(pageContext,"/EditComlineR.do");
	String factUrl = AppConstants.BASE_BASESTATION+"/EditComlineR.do?showType=F&hopsid="+eForm.getHopsid();
	String docsUrl = AppConstants.BASE_BASESTATION+"/EditComlineR.do?showType=D&hopsid="+eForm.getHopsid();
	String copyUrl = AppConstants.BASE_BASESTATION+"/ProcessComlineR.do";
	String equipA = AppConstants.BASE_POSITION+"/ShowEquipdetList.do?storageplace="+eForm.getEquipmentid_enda()+"&appHome="+ParamsParser.getRootApp(pageContext);
	String equipB = AppConstants.BASE_POSITION+"/ShowEquipdetList.do?storageplace="+eForm.getEquipmentid_endb()+"&appHome="+ParamsParser.getRootApp(pageContext);
	String newAction = eForm.getAction();
%>
<script language="javascript">
function SubmitCopy(val) {
	document.body.style.cursor="wait";
	document.all.cpy.value=val;
	ComlineRForm.submit();
}
</script>
<tr>
	<td class="text"><bean:message key="label.position.actions"/>:</td>
	<td class="text" colspan="<%=gColSpan-1%>" ><input type="hidden" name="cpy" value="">
		<script>
		<!--
			function showTerrabyteWin() {
				var terrabyteWin = window.open("<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?type=hops&id=<%=eForm.getHopsid()%>&uid=<%=request.getRemoteUser()%>", "terrabyteWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,titlebar=yes,toolbar=no");
				if(terrabyteWin) terrabyteWin.focus();
			}
		-->
		</script>
		<a href="#" onclick="showTerrabyteWin();"><nobr><bean:message key="link.documents"/></nobr></a>
		<%-- july:link href="<%=siteDocUrl%>"><bean:message key="link.documents"/></july:link --%>
<%if("D".equals(eForm.getShowType())) {%>
	&nbsp;&nbsp;&nbsp; <july:link href="<%=copyUrl%>" onclick="document.all.action.value='Edit';SubmitCopy('chF');return false;">Фактические данные</july:link>
<%} else {%>
	&nbsp;&nbsp;&nbsp; <july:link href="<%=copyUrl%>" onclick="document.all.action.value='Edit';SubmitCopy('chD');return false;">Данные по разрешению</july:link>
<%}%>
<%if(!"View".equals(eForm.getAction())) {%>
	&nbsp;&nbsp;&nbsp; <july:link href="<%=equipA%>">Оборудование A</july:link>
	&nbsp;&nbsp;&nbsp; <july:link href="<%=equipB%>">Оборудование B</july:link>
	&nbsp;&nbsp;&nbsp; <july:link href="<%=copyUrl%>" onclick="SubmitCopy('fd');return false;"><img src="/images/copy_fact2doc.gif" border=0 width=32 height=16 alt="Скопировать фактические данные в поля данных по разрешению"></july:link>
	&nbsp;&nbsp;&nbsp; <july:link href="<%=copyUrl%>" onclick="SubmitCopy('df');return false;"><img src="/images/copy_doc2fact.gif" border=0 width=32 height=16 alt="Скопировать данные по разрешению в поля фактических данных"></july:link>
<%}%>
	</td>
</tr>
