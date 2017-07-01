<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<tr>
	<td class="text"><bean:message key="label.equipment.switch"/>:</td>
	<td>
		<html:hidden property="switchId"/>
		<july:string property="switchNumberFrm" styleId="switchnum" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowSwitchLookupList.do?constructionState=2&type=1" styleId="switchl" fieldNames="switchnum;sposname;switchId" insertable="true" updatable="true" />
		<july:string size="25" property="switchname" styleId="sposname"  insertable="false" updatable="false" />
	</td>
</tr>
<script language="javascript">
function switchSwitch(dis) {
	refreshLookup(dis,'switchnum','sposname','switchl');
	document.all.switchId.disabled = dis;
}
</script>
