<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ page import="com.hps.july.basestation.formbean.RepeaterList"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.SearchConstants"%>
<%@ page import="com.hps.july.cdbc.lib.*"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	String gColSpan = "14";
	RepeaterList lForm = (RepeaterList) pageContext.findAttribute("RepeaterList");
	request.setAttribute("EquipmentListForm", lForm);
	String trailcomMapUrl = com.hps.july.util.AppUtils.getNamedValueString("PathMapTrailcom");
	String ruser = request.getRemoteUser();
%>

<july:browseform action="/ShowRepeaterList.do" styleId="RepeaterList">
<table class="main">
<july:separator colspan="<%= gColSpan %>"/>
<script language="javascript">
function switchAllSearch() {
	if (document.all.item('searchById')[0].checked ) {
		document.all.item('searchstringId').className = 'editdisabled';
		document.all.item('searchstringId').disabled = true;
	} else {
		document.all.item('searchstringId').className = 'editsearch';
		document.all.item('searchstringId').disabled = false;
	}
}
</script>

<table class="main">
<tr class="normal">
<td colspan="<%= gColSpan %>">
	<table class="find">
	<tr>
		<td class="title" colspan="2">
		<table border=0 width="100%" cellpadding=0 cellspacing=0>
		<tr>
			<td><jsp:include page="/common/regionsselect.jsp" flush="true" /></td>
			<td><july:searchbutton/></td>
		</tr>
		</table>
		</td>
	</tr>
				
	<TR>
		<td class="title"><bean:message key="label.repeaterlist.type"/></td>
		<td class="title" NOWRAP>
			<july:radio styleClass="editcheckbox" property="stationType" value="gsm" onclick="switchAllSearch()" insertable="true" updatable="true"/><bean:message key="label.repeaterlist.search.gsm"/>&nbsp;
			<july:radio styleClass="editcheckbox" property="stationType" value="damps" onclick="switchAllSearch()" insertable="true" updatable="true"/><bean:message key="label.repeaterlist.search.damps"/>
		</td>
	</TR>

	<TR>
		<td class="title"><bean:message key="label.position.searchby"/></td>
		<td class="title">
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%= lForm.SEARCH_ALL %>" onclick="switchAllSearch()" insertable="true" updatable="true"/><bean:message key="search.all"/>&nbsp;
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="numberbs" onclick="switchAllSearch();" insertable="true" updatable="true"/><bean:message key="search.bynumberbs"/>&nbsp;
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="namepos" onclick="switchAllSearch()" insertable="true" updatable="true"/><bean:message key="search.bynamepos"/><br>
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="addresspos" onclick="switchAllSearch()" insertable="true" updatable="true"/><bean:message key="search.byaddresspos"/>&nbsp;
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="numbersector" onclick="switchAllSearch()" insertable="true" updatable="true"/><bean:message key="search.bynumbersector"/>
		</td>
	</TR>
			
	<TR>
		<td class="title"><bean:message key="label.position.search.text"/></td>
		<td class="title"><html:text styleClass="search" property="searchString" styleId="searchstringId" size="25"/></td>
	</TR>

	<TR>
		<td class="title"><bean:message key="SwitchList.fields.state"/></td>
		<td class="title">
			<july:select  property="equipmentState" styleId="equipmentStateId"  insertable="true" updatable="true" styleClass="editsmallsearch" style="width:160pt">
				<html:option key="label.all" value="*"/>
				<html:option key="label.baseStationList.state.P" value="P"/>
				<html:option key="label.baseStationList.state.M" value="M"/>
				<html:option key="label.baseStationList.state.R" value="R"/>
				<html:option key="label.baseStationList.state.T" value="T"/>
				<html:option key="label.baseStationList.state.W" value="W"/>
				<html:option key="label.baseStationList.state.D" value="D"/>
			</july:select>
		</td>
	</tr>
	</table>
</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr class="title"><td colspan="<%= gColSpan %>"><table class="buttons"><tr class="title">
	<td class="buttons">
		<alex:hasAccess href="/EditFactRepeater.do" ><july:link page='/EditFactRepeater.do?action=Add'><img alt='<bean:message key="label.repeaterlist.add.fact"/>' src="/images/plus.gif" border=0></july:link></alex:hasAccess>&nbsp;
		<july:backbutton/>&nbsp;
		<image name="onMap" src="/images/map.gif" alt="<bean:message key="SwitchList.buttons.map"/>" onclick='determineMaps("<%=trailcomMapUrl%>","<%=ruser%>");' />
	</td>
	<td class="navigator"><july:navigator/></td>
</tr></table></td></tr>

<july:separator colspan="<%= gColSpan %>"/>

<SCRIPT language="JavaScript">

    var retVal;
    function determineMaps(url,user) {
		var checkboxs = document.getElementsByTagName('INPUT');
		var positions = "";
		var isMany = false;
		if(checkboxs) {
			for(var i = 0; i < checkboxs.length; i++) {
				var element = checkboxs[i];
				if(element.getAttribute('type') && element.getAttribute('type') == 'checkbox') {
					if(element.getAttribute('name') && element.getAttribute('name') == 'checkEquipment') {
						if(element.getAttribute('checked') && element.getAttribute('checked') == true){
							
							<%--if(element.getAttribute('regionid') && element.getAttribute('regionid') != '') {
								if(positions != '') positions += ','
								positions += (element.getAttribute('value') + ',' + element.getAttribute('regionid'));
							}--%>

							if(isMany){
								alert('На данный момент функция отображения нескольких репитеров отключена. Выберите одну репитер.');
								return false;
							}
							isMany = true;
							positions = '?id='+user+'&type=1&position=' + element.getAttribute('value');
						}
					}
				}
			}
		}

		if(positions == '') {
			alert('Не выбранно ни одной позиции ! ');
			return false;
		}        
		var urlShortInfo = (url + positions);

        retVal = window.open(urlShortInfo, "retVal", "top=10,left=10,width=1000,height=800,resizable=1,scrollbars=1,statusbar=1,status=0,toolbar=0");
        if(retVal) retVal.focus();
		return true;
	}

    function showMap(map, region, pos) {
        if(retVal) retVal.close();
        document.location.href= ('/siteinfo/spm?map=' + map + '&supregion=' + region + '&positionid=' + pos);
    }

    function checkAll(select, groupId){
        try {
            document.all.item(groupId).checked = select;
            for(var i = 0; i < document.all.item(groupId).length; i++) {
                document.all.item(groupId)[i].checked = select;
            }
        } catch (exception) {}
    }


</SCRIPT>

<!-- Table header -->
<tr class="title">
	<td>&nbsp;</td>
	<july:headercolumn key="repeaterlist.pos.name" colType="string"/>
	<july:headercolumn key="label.repeaterform.number" colType="string"/>
	<july:headercolumn key="repeaterlist.resource" colType="string"/>
	<july:headercolumn key="repeaterlist.repiterclass" colType="string"/>
	<july:headercolumn key="repeaterlist.reppower" colType="string"/>
	<july:headercolumn key="repeaterlist.bandwidth.numchanals" colType="string"/>
	<july:headercolumn key="repeaterlist.donortype" colType="string"/>
	<td class="title">Донорная БС</td>
	<td class="title">Донорный Сектор</td>
	<td class="title">
		<bean:message key="controllerlist.table.map"/><br>
		<input type=checkbox class=editcheckbox value='true' name='isAllEquipment' id='isAllEquipmentId' onclick='checkAll(this.checked ,"isEquipmentId" )'/>
		<input type=hidden name="checkComline" value=""/>
		<input type=hidden name="map" id="map" value=""/>
		<input type=hidden name="region" id="region" value=""/>
		<input type=hidden name="positionid" id="positionid" value=""/>
	</td>
	<td>&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>
<!-- Table body -->
<logic:iterate id="obj" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="obj">
<%
	String equipment = obj.getColumn("equipment").asString();
	pageContext.setAttribute("equipment",equipment);
	String rc = obj.getColumn("repiter_class").asString().toLowerCase();
	String dt = obj.getColumn("donor_type").asString().toLowerCase();
	String posid = obj.getColumn("positionid").asString();
	String supreg = obj.getColumn("supregid").asString();
	pageContext.setAttribute("bs_equipment",obj.getColumn("bsequ").asString());
%>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td align="center"><july:editbutton page="/ViewRepeater.do" action='View' paramId="storageplace" paramName="equipment"/></td>
		<td class="text"><july:stringwrite name="obj" property="posname"/></td>
		<td class="text"><july:stringwrite name="obj" property="number"/></td>
		<td class="text"><july:stringwrite name="obj" property="reptype"/></td>
		<td class="text"><% try { %><bean:message key='<%="repeaterlist.repiterclass."+rc%>'/><% } catch(Exception e) { e.printStackTrace(System.out); } %></td>
		<td class="text"><july:sumwrite name="obj" property="reppower"/></td>
		<td class="text"><july:sumwrite name="obj" property="bandwidth"/></td>
		<td class="text"><% try { %><bean:message key='<%="repeaterlist.donortype."+dt%>'/><% } catch(Exception e) { e.printStackTrace(System.out); } %></td>
		<td class="text">
<july:link page="/Edit_ViewFactBaseStation.do?action=View" paramId="basestation" paramName="bs_equipment" alttext="button.view.basestation"><july:stringwrite name="obj" property="bsname"/></july:link>
</td>
		<td class="text"><july:stringwrite name="obj" property="sectorname"/></td>
		<td class="link"><input type="checkbox" name="checkEquipment" value='<%=posid%>' regionid='<%=supreg%>'  class="editcheckbox" id="isEquipmentId"/></td>
		<td class="link"><july:delbutton page='/EditFactRepeater.do?action=Delete' paramId="storageplace" paramName="equipment"/></td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
</logic:present>
</logic:iterate>

<tr class="title"><td colspan="<%= gColSpan %>"><table class="buttons"><tr class="title">
	<td class="buttons">
		<alex:hasAccess href="/EditFactRepeater.do" ><july:link page='/EditFactRepeater.do?action=Add'><img alt='<bean:message key="label.repeaterlist.add.fact"/>' src="/images/plus.gif" border=0></july:link></alex:hasAccess>&nbsp;
		<july:backbutton/>&nbsp;
		<image name="onMap" src="/images/map.gif" alt="<bean:message key="SwitchList.buttons.map"/>" onclick='determineMaps("<%=trailcomMapUrl%>","<%=ruser%>");' />
	</td>
	<td class="navigator"><july:navigator/></td>
</tr></table></td></tr>
<july:separator colspan="<%= gColSpan %>"/>
</table>
<script language="javascript">
	switchAllSearch();
</script>
</july:browseform>
