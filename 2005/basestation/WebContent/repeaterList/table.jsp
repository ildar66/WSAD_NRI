<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.RequestUtils"%>
<%@ page import="com.hps.july.basestation.valueobject.RepeaterObject"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<% String gColSpan = request.getAttribute("colspan") + ""; %>

<SCRIPT language="JavaScript">
<!--
    var retVal;
    function determineMaps() {
		var checkboxs = document.getElementsByTagName('INPUT');
		var positions = "";
		if(checkboxs) {
			for(var i = 0; i < checkboxs.length; i++) {
				var element = checkboxs[i];
				if(element.getAttribute('type') && element.getAttribute('type') == 'checkbox') {
					if(element.getAttribute('name') && element.getAttribute('name') == 'checkEquipment') {
						if(element.getAttribute('checked') && element.getAttribute('checked') == true)
							if(element.getAttribute('regionid') && element.getAttribute('regionid') != '') {
								if(positions != '') positions += ','
								positions += (element.getAttribute('value') + ',' + element.getAttribute('regionid'));
							}
					}
				}
			}
		}
		if(positions == '') {
			alert('Не выбранно ни одной позиции ! ');
			return false;
		}
        var urlShortInfo = ('/siteinfo/dpm?posAndRegs=' + positions);
        retVal = window.open(urlShortInfo, "retVal", "top=200,left=200,width=400,height=400,resizable=0,scrollbars=0,statusbar=0,status=0,toolbar=0");
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

-->
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
<logic:iterate id="obj" name="browseList">
	<logic:present name="obj">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td align="center">
				<july:editbutton page="/EditFactRepeater.do" action='Edit' paramId="storageplace" paramName="obj" paramProperty="id"/>
			</td>
			<td class="text"><bean:write name="obj" property="posname" filter="true"/></td>
			<td class="text"><bean:write name="obj" property="number" filter="true"/></td>
			<td class="text"><bean:write name="obj" property="resourcename" filter="true"/></td>
			<td class="text">
				<logic:equal name="obj" property="repiterclass" value="A"><bean:message key="repeaterlist.repiterclass.a"/></logic:equal>
				<logic:equal name="obj" property="repiterclass" value="B"><bean:message key="repeaterlist.repiterclass.b"/></logic:equal>
				<logic:equal name="obj" property="repiterclass" value="C"><bean:message key="repeaterlist.repiterclass.c"/></logic:equal>
				<logic:equal name="obj" property="repiterclass" value="D"><bean:message key="repeaterlist.repiterclass.d"/></logic:equal>
				<logic:equal name="obj" property="repiterclass" value="E"><bean:message key="repeaterlist.repiterclass.e"/></logic:equal>
			</td>
			<td class="text"><july:sumwrite name="obj" property="reppower"/></td>
			<td class="text"><july:sumwrite name="obj" property="bandwidthOrNumchanals"/></td>
			<td class="text">
				<logic:equal name="obj" property="donortype" value="A"><bean:message key="repeaterlist.donortype.a"/></logic:equal>
				<logic:equal name="obj" property="donortype" value="B"><bean:message key="repeaterlist.donortype.b"/></logic:equal>
				<logic:equal name="obj" property="donortype" value="C"><bean:message key="repeaterlist.donortype.c"/></logic:equal>
			</td>
			<td class="link">
				<input type="checkbox" name="checkEquipment" value='<%=""+(((RepeaterObject)obj).getPositionId())%>' regionid='<%=""+(((RepeaterObject)obj).getSupreg())%>'  class="editcheckbox" id="isEquipmentId"/>
			</td>
			<td class="link">
				<july:delbutton page='/EditFactRepeater.do?action=Delete' paramId="storageplace" paramName="obj" paramProperty="id"/>
			</td>
		</tr>
		
		<july:separator colspan="<%= gColSpan %>"/>
		
	</logic:present>
</logic:iterate>
