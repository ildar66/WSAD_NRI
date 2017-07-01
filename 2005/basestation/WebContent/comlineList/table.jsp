<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.RequestUtils"%>
<%@ page import="com.hps.july.basestation.valueobject.ComlineObject"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<script language="JavaScript">

	

	function determineMaps(url,user) {
		var checkboxs = document.getElementsByTagName('INPUT');
		var positions = "";
		var isMany = false;
		if(checkboxs) {
			for(var i = 0; i < checkboxs.length; i++) {
				var element = checkboxs[i];
				if(element.getAttribute('type') && element.getAttribute('type') == 'checkbox') {
					if(element.getAttribute('name') && element.getAttribute('name') == 'checkComline') {
						if(element.getAttribute('checked') && element.getAttribute('checked') == true){
							
							<%--if(element.getAttribute('regionid') && element.getAttribute('regionid') != '') {
								if(positions != '') positions += ','
								positions += (element.getAttribute('value') + ',' + element.getAttribute('regionid'));
							}--%>

							if(isMany){
								alert('На данный момент функция отображения нескольких линий связи отключена. Выберите одну линию связи.');
								return false;
							}
							isMany = true;
							positions = '?id='+user+'&type=2&position=' + element.getAttribute('value');
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
		alert(urlShortInfo);
        retVal = window.open(urlShortInfo, "retVal", "top=10,left=10,width=1000,height=800,resizable=1,scrollbars=1,statusbar=1,status=0,toolbar=0");
        if(retVal) retVal.focus();
		return true;
	}


    function showMap(map, region, pos) {
        if(retVal) retVal.close();
        document.location.href= ('/siteinfo/spm?rrl=1&map=' + map + '&supregion=' + region + '&positionid=' + pos);
    }

function checkAll(select, groupId){
	//alert("document.all.item(groupId)="+document.all.item(groupId));
	if(document.all.item(groupId)!=null){
		document.all.item(groupId).checked=select;
		for(var i=0; i< document.all.item(groupId).length; i++){
			document.all.item(groupId)[i].checked=select;
		}
	}
}

</script>

<% String gColSpan = request.getAttribute("colspan")+""; %>

<!-- Table header -->
<tr class="title">
<td></td>
<july:headercolumn  key="ComlineList.table.code" colType="string"/>
<july:headercolumn  key="ComlineList.table.beenetid" colType="string"/>
<july:headercolumn  key="ComlineList.table.position1" colType="string"/>
<td></td>
<july:headercolumn  key="ComlineList.table.position2" colType="string"/>
<july:headercolumn  key="ComlineList.table.resource1" colType="string"/>
<july:headercolumn  key="ComlineList.table.resource2" colType="string"/>
<july:headercolumn  key="ComlineList.table.type" colType="string"/>
<july:headercolumn  key="ComlineList.table.hopsate" colType="string"/>
<%if(request.isUserInRole("FreqManager") || request.isUserInRole("administrator")) {%>
<july:headercolumn  key="ComlineList.table.file" colType="string"/>
<%}%>
<td class="title">
	<bean:message key="ComlineList.table.map"/><br>
	<input type=checkbox class=editcheckbox value='true' name='isAllComline' id='isAllComlineId' onclick='checkAll(this.checked ,"isComlineId" )' />
</td>
<td></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
<!-- Table body -->
<%
	String editAction="/EditComlineR.do";
	boolean hasRoleAccess=false;
%>
<alex:hasAccess href="/ProcessComlineR.do" ><%hasRoleAccess=true;%></alex:hasAccess>

<logic:iterate id="obj" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="obj">
<%
	boolean canEdit=false;
	String action=null;
	String alttextKey=null;
	canEdit = hasRoleAccess && "Y".equals(obj.getColumn("editregion").asString());

	if (canEdit) {
		action="Edit";
		alttextKey="ComlineList.table.alttext.edit";
	} else {
		action="View";
		alttextKey="ComlineList.table.alttext.view";
	}
	String state = "ComlineList.state.C";
	if(!"".equals(obj.getColumn("hopstate").asString())) {
		state = "ComlineList.state."+obj.getColumn("hopstate").asString();
	}
	String id = obj.getColumn("hopsid").asString();
	String htype = obj.getColumn("hopstype").asString();
	String p1 = obj.getColumn("p1code").asString();
	String rg1 = obj.getColumn("srg1").asString();
	String p2 = obj.getColumn("p2code").asString();
	String rg2 = obj.getColumn("srg2").asString();
%>


<july:selectableTR styleId="<%=id%>" paramName="comID" selectable="true" styleClass="normal"  onmouseover="className='select'" onmouseout="className='normal'">
	<td class="link"><%if("R".equals(htype)){%><july:editbutton page="<%= editAction %>"  action="<%= action %>" paramId="hopsid" paramName="obj" paramProperty="hopsid"/><%}%></td>
	<td class="text"><july:stringwrite name="obj" property="hopsname"/></td>
	<td class="text"><july:stringwrite name="obj" property="beenetid"/></td>
	<td class="text"><july:stringwrite name="obj" property="id1"/> <july:stringwrite name="obj" property="name1"/></td>
	<td class="text">-</td>
	<td class="text"><july:stringwrite name="obj" property="id2"/> <july:stringwrite name="obj" property="name2"/></td>
	<td class="text"><july:stringwrite name="obj" property="equname1"/></td>
	<td class="text"><july:stringwrite name="obj" property="equname2"/></td>
	<td class="text"><%if("R".equals(htype)){%><bean:message key="ComlineList.table.type.rrl"/><%} else {%><bean:message key='<%="ComlineList.table.type."+htype%>'/><%}%></td>
	<td class="text"><bean:message key="<%=state%>"/></td>
<%if(request.isUserInRole("FreqManager") || request.isUserInRole("administrator")) {%>
	<td class="text"><july:stringwrite name="obj" property="filenumber"/></td>
<%}%>
	<td class="link">
		<input type=checkbox class=editcheckbox value='<%=id%>' name='checkComline' id='isComlineId'/>
		<input type="hidden" value='<%=p1%>' name='isP1Id<%=id%>' id='isP1Id<%=id%>' regionid="<%=rg1%>"/>
		<input type="hidden" value='<%=p2%>' name='isP2Id<%=id%>' id='isP2Id<%=id%>' regionid="<%=rg2%>"/>
	</td>
	<td class="link">
		<% if(canEdit){ %>
			<july:delbutton page='<%=editAction+"?action=Delete"%>' paramId="hopsid" paramName="obj" paramProperty="hopsid" />
		<% } %>
	</td>
</july:selectableTR>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>

