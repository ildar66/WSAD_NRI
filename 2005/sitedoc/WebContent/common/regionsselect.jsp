<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.siteinfo.valueobject.Regions"%>
<%@ page import="com.hps.july.siteinfo.valueobject.RegionsSelector"%>

<%
	String regionsSelectorProperty = "regionsSelector";
	Object o = pageContext.findAttribute("regionsSelectorProperty");
	if(o != null) {
		regionsSelectorProperty = String.valueOf(o);
	} 
	Regions.updateRegionsList(request,RegionsSelector.findRegionsSelector(pageContext));
%>
<script language="javascript">
<%=request.getAttribute(Regions.REGIONS_JS_DATA)%>
</script>
<script language="javascript" src="/regionsselect.js"></script>
<table class='find'>
<tr>
	<td class="title">
		<bean:message key="label.position.search.supregs"/>
		<july:checkbox styleId='allSuperregions' property='<%=regionsSelectorProperty+".allSuperregions"%>' insertable="true" updatable="true" onclick="onAllSuperregionsClick();"/>
		<bean:message key="label.search.all"/>
	</td>
	<td class="title">
		<bean:message key="label.position.search.regions"/>
		<july:checkbox styleId='allRegions' property='<%=regionsSelectorProperty+".allRegions"%>' insertable="true" updatable="true" onclick="onAllRegionsClick();" />
		<bean:message key="label.search.all"/>
	</td>
	<td class="title">
		<bean:message key="label.position.netzonename"/>
		<july:checkbox styleId='allNetzones' property='<%=regionsSelectorProperty+".allNetzones"%>' insertable="true" updatable="true" onclick="onAllNetzonesClick();" />
		<bean:message key="label.search.all"/>
	</td>
</tr>
<tr>
	<td class="title">
		<july:select styleId="superregioncodes" property='<%=regionsSelectorProperty+".superregioncodes"%>' onchange="onSuperregionsChange();" insertable="true" updatable="true" multiple="true" size='3' styleClass="editsearch">
			<html:options collection="<%=Regions.SUPERREGIONS_LIST%>" property="supregid" labelProperty="supregname"/>
		</july:select>
	</td>
	<td class="title">
		<july:select styleId="regioncodes" property='<%=regionsSelectorProperty+".regioncodes"%>' insertable="true" updatable="true" multiple="true" size='3' styleClass="editsearch">
			<html:options collection="<%=Regions.REGIONS_LIST%>" property="regionid" labelProperty="regname"/>
		</july:select>
	</td>
	<td class="title">
		<july:select styleId="netzonecodes" property='<%=regionsSelectorProperty+".netzonecodes"%>' insertable="true" updatable="true" multiple="true" size='3' styleClass="editsearch">
			<html:options collection="<%=Regions.NETZONES_LIST%>" property="netzone" labelProperty="name"/>
		</july:select>
	</td>
</tr>
</table>
<script language="javascript">initRegionsSelector();</script>
