<%@ page language = "java" %>

<%@ page import="com.hps.july.basestation.formbean.SwitchListForm"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="org.apache.struts.util.RequestUtils"%>
<%@ page import="com.hps.july.basestation.valueobject.SwitchObject"%>

<%@ page  contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	java.lang.String gColSpan = "10";
	request.setAttribute("colspan",gColSpan);//для использования во включенных jsp
	SwitchListForm lForm=(SwitchListForm)pageContext.findAttribute("SwitchListForm");
	request.setAttribute("EquipmentListForm",lForm);//для использования во включенных jsp
	String trailcomMapUrl = com.hps.july.util.AppUtils.getNamedValueString("PathMapTrailcom");
	String ruser = request.getRemoteUser();
%>

<script src="/grid/js/activewidgets/lib/aw.js"></script>
<link href="/grid/js/activewidgets/styles/xp/aw.css" rel="stylesheet"></link>

<style>
	.active-controls-grid {
        font-size: 10pt;
    }

	#positionGrid { width: 100%; height: 450px; }
	#positionGrid .aw-grid-headers {font-size: 10pt; font-weight: bold;}
	

/********************************************************************
	Columns
********************************************************************/

	#positionGrid .aw-column-0 {width: 30px; border-right: 1px dotted #ccc; }
	#positionGrid .aw-column-1 {width: 70px; border-right: 1px dotted #ccc;}
	#positionGrid .aw-column-2 {width: 100px; border-right: 1px dotted #ccc;}
	#positionGrid .aw-column-3 {width: 150px; border-right: 1px dotted #ccc;}
	#positionGrid .aw-column-4 {width: 150px; border-right: 1px dotted #ccc;}
	#positionGrid .aw-column-5 {width: 70px; border-right: 1px dotted #ccc;}
	#positionGrid .aw-column-6 {width: 150px; border-right: 1px dotted #ccc;}
	#positionGrid .aw-column-7 {width: 70px; border-right: 1px dotted #ccc;}
	#positionGrid .aw-column-8 {width: 70px; border-right: 1px dotted #ccc;}
	#positionGrid .aw-column-9 {width: 30px; border-right: 1px dotted #ccc;}

</style>
<!-- Table body -->
<%
	String editAction = "/EditFactSwitch.do";
	boolean hasRoleAccess=false;
	int rowCount = 0;
%>
<alex:hasAccess href="<%=editAction%>" ><%hasRoleAccess=true;%></alex:hasAccess>
	<xml id="xmlSwitchListData">
		<positions>
		<logic:iterate id="obj" name="browseList">
		<logic:present name="obj">
			<position>
		<%
			rowCount++;
			boolean canEdit=false;
			String action=null;
			String alttextKey=null;
			SwitchObject ob=(SwitchObject)pageContext.getAttribute("obj");
			canEdit=hasRoleAccess&&ob.isEditRegion();
			if(canEdit) {
				action="Edit";
				alttextKey="SwitchList.table.alttext.edit";
			} else {
				action="View";
				alttextKey="SwitchList.table.alttext.view";
		//		editAction="/EditSwitch.do";
			}
		%>
		
			<col1><![CDATA[<july:editbutton page="<%=editAction%>"  action='<%=action%>' paramId="storageplace" paramName="obj" paramProperty="id"/>]]></col1>
			<col2>
				<bean:write name="obj" property="number" filter="true"/>
			</col2>
			<col3>
				<logic:present name="obj" property="standart">
					<logic:equal name="obj" property="standart" value="1"><bean:message key="switch_type_1"/></logic:equal>
					<logic:equal name="obj" property="standart" value="2"><bean:message key="switch_type_2"/></logic:equal>
				</logic:present>
			</col3>
			<col4>
				<bean:write name="obj" property="resourceName" filter="true"/>
			</col4>
			<col5><bean:write name="obj" property="name" filter="true"/></col5>
			<col6><%if(ob.getMscid() != null){%><%=Integer.toHexString(ob.getMscid().intValue()).toUpperCase()%><%}%></col6>
			<col7>
				<bean:write name="obj" property="address" filter="true"/>
			</col7>
			<col8>
				<bean:write name="obj" property="capacityplan" filter="true"/>
			</col8>
			<col9>
				<bean:write name="obj" property="capacityused" filter="true"/>
			</col9>
			<col10><![CDATA[
				<%if(canEdit){%>
					<july:delbutton page='<%=editAction+"?action=Delete"%>' paramId="storageplace" paramName="obj" paramProperty="id" />
				<%}%>
				]]>
			</col10>
			</position>
		</logic:present>
		</logic:iterate>
		</positions>
	</xml>


<july:browseform action="/ShowSwitchList.do" styleId="SwitchListForm">
<table class="main" style="font-size: 8pt;">
<july:separator colspan="<%= gColSpan %>" />
<%--филтр поиска--%>

<script language="javascript">

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
								alert('На данный момент функция отображения нескольких коммутаторов отключена. Выберите одну коммутатор.');
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



function switchAllSearch() {
	//switchInputField('searchstringId',!document.all.item('searchBy')[0].checked);
	if(document.all.item('searchById')[0].checked ) {
		document.all.item('searchstringId').className = 'editdisabled';
		document.all.item('searchstringId').disabled = true;
	} else {
		document.all.item('searchstringId').className = 'editsearch';
		document.all.item('searchstringId').disabled = false;
	}
}

</script>

<tr class="normal">
<td colspan="<%= gColSpan %>">
<table class="find" style="font-size: 8pt;">
<tr>
	<td class="title" colspan="2">
	<table border=0 width="100%" cellpadding=0 cellspacing=0 style="font-size: 8pt;">  
	<tr>
		<td><jsp:include page="/common/regionsselect.jsp" flush="true" /></td>
		<td></td>
	</tr>
	</table>
	</td>
</tr>
<%--jsp:include page="/common/multipleSelect.jsp"  flush="true" /--%>
<%--искать по .. --%>
<tr>
	<td class="title"><bean:message key="label.position.searchby"/></td>
	<td class="title" NOWRAP>
		<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%=lForm.SEARCH_ALL%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message key="search.all"/>&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%=lForm.SEARCHBY_NUMBER%>" onclick="switchAllSearch();document.forms(0).elements('finderMethodName').value = '5';" insertable="true" updatable="true" />
		<bean:message key="search.byNumber"/>&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%=lForm.SEARCHBY_NAME%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message  key="search.byName"/>&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%=lForm.SEARCHBY_ADDRESS%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message  key="search.byAddress"/>
		&nbsp;&nbsp;
		<html:text styleClass="search" property="searchString" styleId="searchstringId" size="25"/>
	</td>
</tr>
<tr>
	<td class="title"><bean:message key="SwitchList.fields.state"/></td>
	<td class="title">
		<july:select style="font-size: 8pt;" property="equipmentState" styleId="equipmentStateId"  insertable="true" updatable="true" styleClass="editsmallsearch" style="width:160pt">
			<html:option key="label.all" value="*"/>
			<html:option key="label.baseStationList.state.P" value="P"/>
			<html:option key="label.baseStationList.state.M" value="M"/>
			<html:option key="label.baseStationList.state.W" value="W"/>
			<html:option key="label.baseStationList.state.D" value="D"/>
		</july:select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:searchbutton/>
	</td>
</tr>
</table>

</td>
</tr>

<script language="javascript">switchAllSearch();</script>

<july:separator colspan="<%= gColSpan %>" />
<%--навигатор и другие кнопки--%>

<tr class="title"><td colspan="<%= gColSpan %>"><TABLE class="buttons"><TR class="title">
<TD class="buttons">
	<alex:hasAccess href="/EditFactSwitch.do">
		<html:link page='/EditFactSwitch.do?action=Add'>
			<IMG alt='<bean:message key="SwitchList.buttons.addFact"/>' src="/images/plus.gif" border=0>
		</html:link>
	</alex:hasAccess>

	<IMG alt="" src="/images/empty.gif" width=3 border=0>

	<july:backbutton page="/main.do"/>&nbsp;
	<image name="onMap" src="/images/map.gif" alt="<bean:message key="SwitchList.buttons.map"/>" onclick='determineMaps("<%=trailcomMapUrl%>","<%=ruser%>");' />
</TD>
<TD class="navigator">
	
</TD>
</TR></TABLE></TD></tr>

<july:separator colspan="<%= gColSpan %>" />
<%--таблица с результатами--%>


<SCRIPT language="JavaScript">

function checkAll(select, groupId) {
//alert("document.all.item(groupId)="+document.all.item(groupId));
	if(document.all.item(groupId)!=null) {
		document.all.item(groupId).checked=select;
		for(var i=0; i< document.all.item(groupId).length; i++) {
			document.all.item(groupId)[i].checked=select;
		}
	}
}
</SCRIPT>

<tr class="title"><td colspan="<%= gColSpan %>">
<script>	
	var headerList = ['','№','Тип коммутатора','Тип оборудования','Наименование','MSCID','Адрес', 'План Емкость', 'Монтир Емкость', ''];
	//	create ActiveWidgets data model - XML-based table
	var table = new AW.XML.Table;
	//  get reference to the xml data island node
	var xml = document.getElementById("xmlSwitchListData");
	//	provide data XML
	table.setXML(xml);

	//	create ActiveWidgets Grid javascript object
	var obj = new AW.UI.Grid;

	obj.setColumnCount(headerList.length);
	obj.setRowCount(<%= rowCount %>);

	//	provide column labels
	obj.setHeaderText(headerList);

	//	provide external model as a grid data source
	obj.setCellModel(table);
	obj.getRowTemplate().setClass("text", "normal");
	obj.getCellTemplate().setStyle("font-size", "10pt");
	obj.setHeaderHeight(20);
	obj.setVirtualMode(false);	
	obj.setId("positionGrid");
	//	set row selection
	obj.setSelectionMode("single-row");
	//	write grid html to the page
	document.write(obj);
</script>

</TD>
</TR>

<%--навигатор и другие кнопки--%>
<tr class="title"><td colspan="<%= gColSpan %>"><TABLE class="buttons"><TR class="title">
<TD class="buttons">
	<alex:hasAccess href="/EditFactSwitch.do">
		<html:link page='/EditFactSwitch.do?action=Add'>
			<IMG alt='<bean:message key="SwitchList.buttons.addFact"/>' src="/images/plus.gif" border=0>
		</html:link>
	</alex:hasAccess>

	<IMG alt="" src="/images/empty.gif" width=3 border=0>

	<july:backbutton page="/main.do"/>&nbsp;
	<image name="onMap" src="/images/map.gif" alt="<bean:message key="SwitchList.buttons.map"/>" onclick='determineMaps("<%=trailcomMapUrl%>","<%=ruser%>");' />
</TD>
<TD class="navigator">
	
</TD>
</TR></TABLE></TD></tr>
<july:separator colspan="<%= gColSpan %>" />
</table>
</july:browseform>
