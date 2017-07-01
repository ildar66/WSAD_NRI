<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.siteinfo.valueobject.Regions"%>
<%@ page import="com.hps.july.siteinfo.valueobject.RegionsSelector"%>

<% java.lang.String gColSpan = "6"; %>

<july:browseform action="/ShowNetzoneList.do">
<%
	String regionsSelectorProperty = "regionsSelector";
	Object o = pageContext.findAttribute("regionsSelectorProperty");
	if(o != null) {
		regionsSelectorProperty = String.valueOf(o);
	} 
	RegionsSelector rs = RegionsSelector.findRegionsSelector(pageContext);
%>
<script language="javascript">
function toggleSelect(sel,toggle) {
	if(sel.length > 0) {
		if(toggle) {
			for(var i = sel.length-1; i >= 0; i--) {
				sel.options[i].selected = true;
			}
			sel.disabled = true;
		} else {
			sel.disabled = false;
			sel.options[0].selected = true;
			for(var i = sel.length-1; i > 0; i--) {
				sel.options[i].selected = false;
			}
		}
	}
}
function onAllSuperregionsClick() {
	if(document.all.superregioncodes) {
		toggleSelect(document.all.superregioncodes,document.all.allSuperregions.checked);
		onSrChange();
	}
}
function onAllRegionsClick() {
	if(document.all.regioncodes) {
		toggleSelect(document.all.regioncodes,document.all.allRegions.checked);
	}
}
function getSelectedItems(selectobject) {
	var res = '';
	var i = 0;
	if(selectobject) {
	for(i = 0; i < selectobject.length; i++) {
		if(selectobject.options[i].selected) {
			res += selectobject.options[i].value + '-';
		}
	}
	}
	return res;
}
function copyOptions(ssrc,sdest) {
	sdest.innerHTML = '';
	for(i = 0; i < ssrc.options.length; i++) {
		var oOpt = document.createElement("OPTION");
		oOpt.value = ssrc.options[i].value;
		oOpt.text = ssrc.options[i].text;
		oOpt.selected = ssrc.options[i].selected;
		sdest.add(oOpt);
	}
}
function updateSCRegion() {
	var frm = document.frames("downloadServiceFrameR");
	if(frm.document.all.content) {
		copyOptions(frm.document.all.content,document.all.regioncodes);
		toggleSelect(document.all.regioncodes,document.all.allRegions.checked);
	}
}
function onSrChange() {
	var frm = document.frames("downloadServiceFrameR");
	if(!frm.document.forms[0]) {
		frm.document.write('<form name="params" method="POST" action="/siteinfo/regionsDataProviderHTML.jsp">');
		frm.document.write('<input type="text" name="lt" value="R">');
		frm.document.write('<input type="text" name="sr" value="">');
		frm.document.write('<input type="text" name="rg" value="">');
		frm.document.write('<input type="text" name="nz" value="">');
		frm.document.write('</form>');
	}
	frm.document.forms[0].lt.value='R';
	if(document.all.allSuperregions.checked) {
		frm.document.forms[0].sr.value='*';
	} else {
		frm.document.forms[0].sr.value=getSelectedItems(document.all.superregioncodes);
	}
	if(document.all.allRegions.checked) {
		frm.document.forms[0].rg.value='*';
	} else {
		frm.document.forms[0].rg.value=getSelectedItems(document.all.regioncodes);
	}
	frm.document.forms[0].submit();
}
function initRegionsSelector() {
	onSrChange();
}
function switchInput(itemname,controlname,check_disable) {
            if(!document.all.item(controlname).checked^check_disable) {
                    document.all.item(itemname).className = 'editdisabled';
                    document.all.item(itemname).disabled = true;
            } else {
                    document.all.item(itemname).className = 'editsearch';
                    document.all.item(itemname).disabled = false;
            }
}

</script>
<iframe id="downloadServiceFrameR" onload="updateSCRegion();" style="display:none;visibility:hidden;" width=1 height=1></iframe>
<table class="main">
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
	<td colspan="<%= gColSpan %>"><table class="find">
	<tr>
		<td>
			<bean:message key="label.position.search.supregs"/>:
		</td>
		<td>
			<july:checkbox styleId='allSuperregions' property='<%=regionsSelectorProperty+".allSuperregions"%>' insertable="true" updatable="true" onclick="onAllSuperregionsClick();"/>
			<bean:message key="label.search.all"/>
			<select name='<%=regionsSelectorProperty+".superregioncodes"%>' id="superregioncodes" onchange="onSrChange();" class="editsearch" <%=(rs.isAllSuperregions()?"disabled":"")%>>
				<%=Regions.getOptionsList("S",rs,request.getRemoteUser(),request.isUserInRole("administrator"))%>
			</select>
		</td>
		<td><july:searchbutton/></td>
	</tr>
	<tr>
		<td>
			<bean:message key="label.position.search.regions"/>:
		</td>
		<td colspan="2">
			<july:checkbox styleId='allRegions' property='<%=regionsSelectorProperty+".allRegions"%>' insertable="true" updatable="true" onclick="onAllRegionsClick();" />
			<bean:message key="label.search.all"/>
			<select name='<%=regionsSelectorProperty+".regioncodes"%>' id="regioncodes" class="editsearch" <%=(rs.isAllRegions()?"disabled":"")%>>
				<%=Regions.getOptionsList("R",rs,request.getRemoteUser(),request.isUserInRole("administrator"))%>
			</select>
		</td>
	</tr>
	<tr>
		<td>
			<bean:message key="label.regionList.search"/>
		</td>
		<td colspan="2">
			<july:radio styleId="isAllNamesTrue" insertable="true" updatable="true" property="searchBy" value="all" onclick="switchInput('searchVal','isAllNamesTrue',true);"/>
			<bean:message key="label.search.all"/>&nbsp;
			<july:radio styleId="isAllNamesFalse" insertable="true" updatable="true" property="searchBy" value="name" onclick="switchInput('searchVal','isAllNamesTrue',true);"/>
			<bean:message key="label.regionList.search.name"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string styleClass="editsearch" property="searchVal" styleId="name" insertable="true" updatable="true"/>
			<script language="javascript">switchInput('searchVal','isAllNamesTrue',true);</script>
		</td>
	</tr>
	</table></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons"><tr class="title">
              <td class="buttons"><july:addbutton page="/EditNetzone.do?action=Add"/> <july:backbutton page="/main.do"/></td>
              <td class="navigator"><july:navigator/></td>
	</tr></table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<!-- Table header -->
<tr class="title">
	<td class="title">&nbsp;</td>
	<july:headercolumn key="label.regionList.superRegion" colType="string"/>
	<july:headercolumn key="label.position.region" colType="string"/>
	<july:headercolumn key="label.name" colType="string"/>
	<july:headercolumn key="label.netzone.zonecode" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<!-- Table body -->
<logic:iterate id="nzn" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="nzn">
<%
	String nzone = nzn.getColumn("netzone").asString();
	pageContext.setAttribute("netzone",nzone);
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="link"><july:editbutton page="/EditNetzone.do" action="Edit" paramId="netzone" paramName="netzone" paramScope="page"/></td>
	<td class="text"><july:stringwrite name="nzn" property="supregname"/></td>
	<td class="text"><july:stringwrite name="nzn" property="regname"/></td>
	<td class="text"><july:stringwrite name="nzn" property="name"/></td>
	<td class="text"><july:stringwrite name="nzn" property="zonecode"/></td>
	<td class="link"><july:delbutton page="/EditNetzone.do?action=Delete" paramId="netzone" paramName="netzone" paramScope="page"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>
<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons"><tr class="title">
		<td class="buttons"><july:addbutton page="/EditNetzone.do?action=Add"/> <july:backbutton page="/main.do"/></td>
		<td class="navigator"><july:navigator/></td>
	</tr></table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</table>
<script language="javascript">initRegionsSelector();</script>
</july:browseform>

