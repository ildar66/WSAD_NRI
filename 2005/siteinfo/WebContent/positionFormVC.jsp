<%@ page language = "java" %>
<%@ page import="com.hps.july.siteinfo.*,com.hps.july.siteinfo.formbean.*,com.hps.july.siteinfo.valueobject.Position" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.ObjectType" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants" %>
<%@ page import="com.hps.july.apptags.HasAccessTag" %>
<%@ page import="com.hps.july.web.util.ParamsParser" %>
<%@ page import="com.hps.july.taglib.RolesValidation" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<SCRIPT language="JScript">

function changeAntPlace() {
	//alert(document.all.antennplaces.value);
	//alert(antennplaces_arr [document.all.antennplaces.value]);
	if (antennplaces_arr [document.all.antennplaces.value] == "Y") {
		document.all.opors1.style.display='block';
		document.all.opors1.style.visibility='visible';
		document.all.opors2.style.display='block';
		document.all.opors2.style.visibility='visible';
		document.all.opors3.style.display='block';
		document.all.opors3.style.visibility='visible';
	} else {
		document.all.opors1.style.display='none';
		document.all.opors1.style.visibility='hidden';
		document.all.opors2.style.display='none';
		document.all.opors2.style.visibility='hidden';
		document.all.opors3.style.display='none';
		document.all.opors3.style.visibility='hidden';
	}
}
function changeApType() {
	//alert(document.all.apparattypes.value);
	//alert(apparattypes_arr [document.all.apparattypes.value]);
	if (apparattypes_arr [document.all.apparattypes.value] == "P") {
		document.all.places.style.display='block';
		document.all.places.style.visibility='visible';
	} else {
		document.all.places.style.display='none';
		document.all.places.style.visibility='hidden';
	}
	if (apparattypes_arr [document.all.apparattypes.value] == "K") {
		document.all.containers.style.display='block';
		document.all.containers.style.visibility='visible';
	} else {
		document.all.containers.style.display='none';
		document.all.containers.style.visibility='hidden';
	}
}


var startLine = 2;
var curLine = 0;
var awindow;

// Adding new container form
function addContainer() {
	awindow = window.open("positionContainerForm.jsp", "_blank", "top=40, left=100, width=850, height=350, scrollbars=yes, resizable=yes");
}

// Deletes line
function deleteContainer() {
	document.all.conttbl.deleteRow(curLine);
}

function saveIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curLine=window.event.toElement.parentElement.rowIndex; 
	}
}

function addContainerSave() {
	var newRow = document.all.conttbl.insertRow();
	newRow.className = "normal";
	for (var i=0; i < 7; i++) {
		var newCell = newRow.insertCell();
		newCell.className = "text";
	}
	newRow.cells(0).innerHTML = awindow.document.all.rescode.value + '<INPUT TYPE="HIDDEN" NAME="rescode[' + newRow.rowIndex + ']" VALUE="' + awindow.document.all.rescode.value + '">';
	newRow.cells(1).innerText = awindow.document.all.resfname.value;
	newRow.cells(2).innerHTML = awindow.document.all.contsizew.value + '<INPUT TYPE="HIDDEN" NAME="contsizew[' + newRow.rowIndex + ']" VALUE="' + awindow.document.all.contsizew.value + '">';
	newRow.cells(3).innerHTML = awindow.document.all.contsizeh.value + '<INPUT TYPE="HIDDEN" NAME="contsizeh[' + newRow.rowIndex + ']" VALUE="' + awindow.document.all.contsizeh.value + '">';
	newRow.cells(4).innerHTML = awindow.document.all.contsizel.value + '<INPUT TYPE="HIDDEN" NAME="contsizel[' + newRow.rowIndex + ']" VALUE="' + awindow.document.all.contsizel.value + '">';
	newRow.cells(5).innerHTML = awindow.document.all.contyear.value + '<INPUT TYPE="HIDDEN" NAME="contyear[' + newRow.rowIndex + ']" VALUE="' + awindow.document.all.contyear.value + '">';
	newRow.cells(6).innerHTML = '<A HREF="#"><IMG SRC="/images/del.gif" BORDER="0" onclick="deleteContainer(); return false;"></A>';
	newRow.onmouseover=saveIndex;
}

</SCRIPT>

<%
	PositionForm pf = ((PositionForm)pageContext.findAttribute("PositionForm"));
	boolean vcRoles=RolesValidation.canModify(pageContext,"vcRoles");
	boolean isAddOrEdit=vcRoles & (pf.getAction().equals("Add") | pf.getAction().equals("Edit"));
	String isAddOrEditStr = "" + isAddOrEdit;
%>

<%--   Поля информации по высотным  сооружениям      --%>

		<%--
		<TR class="title">
			<TD class="title" colspan="2"><bean:message key="label.position.vcinfo"/></TD>
		</TR>
		--%>

        <tr>
            <td class="text"><bean:message key="label.position.genpodr"/>:</td>
            <td>
			  <html:hidden property="genpodrcode" styleId="genpodrcode"/>
			  <july:string size="35" property="genpodrname" styleId="genpodrname" insertable="false" updatable="false"/>
			  <july:lookupbutton action="/ShowOrganizationLookupList.do?selisprovider=true&selissupplier=false&selisrenter=false" styleId="podrl" fieldNames="genpodrcode;genpodrname" 
					insertable="<%= isAddOrEditStr %>" updatable="<%= isAddOrEditStr %>"/>
			  <% if (isAddOrEdit) { %>
				<IMG SRC="/images/delconf.gif" BORDER="0" onclick='document.all.genpodrcode.value="";document.all.genpodrname.value="";'>
			  <% } %>
            </td>
        </tr>

        <tr>
            <td class="text"><bean:message key="label.position.antplace"/>:</td>
            <td>
				 <july:select collection="antennplaces" property="antplaceid" styleId="antennplaces"
						style="width: 150px;"
						onchange="changeAntPlace();"
						insertable="<%= isAddOrEditStr %>" updatable="<%= isAddOrEditStr %>">
					<html:option value="">&nbsp;</html:option>
					<july:options collection="antennplaces" property="antplaceid" labelProperty="name" addProperty="isvc"/>
				 </july:select>
				 &nbsp;&nbsp;
				 <bean:message key="label.position.oporaour"/>:
				 <july:checkbox property="oporaour" insertable="<%= isAddOrEditStr %>" updatable="<%= isAddOrEditStr %>"/>
            </td>
        </tr>

        <tr id="opors1">
            <td class="text"><bean:message key="label.position.oporaplace"/>:</td>
            <td>
				 <july:select collection="oporaplaces" property="oporplaceid" 
						insertable="<%= isAddOrEditStr %>" updatable="<%= isAddOrEditStr %>">
					<html:option value="">&nbsp;</html:option>
					<july:options collection="oporaplaces" property="oplaceid" labelProperty="name"/>
				 </july:select>
            </td>
        </tr>

        <tr id="opors2">
            <td class="text"><bean:message key="label.position.oporatype"/>:</td>
            <td>
			  <html:hidden property="oportypecode" styleId="oportypecode"/>
			  <july:string size="35" property="oportypename" styleId="oportypename" insertable="false" updatable="false"/>
			  <july:lookupbutton action="/ShowOrganizationLookupList.do?selisprovider=true&selissupplier=false&selisrenter=false" 
				styleId="oporl" fieldNames="oportypecode;oportypename" 
				insertable="<%= isAddOrEditStr %>" updatable="<%= isAddOrEditStr %>"/>
			  <% if (isAddOrEdit) { %>
				<IMG SRC="/images/delconf.gif" BORDER="0" onclick='document.all.oportypecode.value="";document.all.oportypename.value="";'>
			  <% } %>
            </td>
        </tr>

        <tr id="opors3">
            <td class="text"><bean:message key="label.position.oporaheight"/>:</td>
            <td>
				<july:string property="oporaheightFrm" size="5" 
					insertable="<%= isAddOrEditStr %>" updatable="<%= isAddOrEditStr %>"/>
				&nbsp;&nbsp;

				<bean:message key="label.position.oporadate"/>:
				<july:date property="oporadateFrm" required="false" 
					insertable="<%= isAddOrEditStr %>" updatable="<%= isAddOrEditStr %>"/>
            </td>
        </tr>

        <tr>
            <td class="text"><bean:message key="label.position.apparattype"/>:</td>
            <td>
				 <july:select collection="apparattypes" property="aptypeid" styleId="apparattypes"
						style="width: 150px;"
						onchange="changeApType();"
						insertable="<%= isAddOrEditStr %>" updatable="<%= isAddOrEditStr %>">
					<html:option value="">&nbsp;</html:option>
					<july:options collection="apparattypes" property="aptypeid" labelProperty="name" addProperty="aptype"/>
				 </july:select>
				 &nbsp;
				 &nbsp;
				 <bean:message key="label.position.applace"/>:
				 <july:select collection="apparatplaces" property="applaceid" 
						style="width: 150px;"
						insertable="<%= isAddOrEditStr %>" updatable="<%= isAddOrEditStr %>">
					<html:option value="">&nbsp;</html:option>
					<july:options collection="apparatplaces" property="applaceid" labelProperty="name"/>
				 </july:select>
            </td>
        </tr>

        <tr id="places">
            <td class="text"><bean:message key="label.position.applacetype"/>:</td>
            <td>
				 <july:select collection="apparatplacetypes" property="applacetypeid" 
						insertable="<%= isAddOrEditStr %>" updatable="<%= isAddOrEditStr %>">
					<html:option value="">&nbsp;</html:option>
					<july:options collection="apparatplacetypes" property="applacetypeid" labelProperty="name"/>
				 </july:select>
            </td>
        </tr>

        <tr id="containers">
            <td class="text"><bean:message key="label.position.containers"/>:</td>
            <td>
				<TABLE class="main" id="conttbl">
					<% if (isAddOrEdit) { %>
					<TR class="title">
						<TD class="title" colspan="7"><IMG SRC="/images/plus.gif" BORDER="0" onclick="addContainer();"></TD>
					</TR>
					<% } %>
					<TR class="title">
						<TD class="title" colspan="2" rowspan="2"><bean:message key="label.position.conttype"/></TD>
						<TD class="title" colspan="3"><bean:message key="label.position.contsize"/></TD>
						<TD class="title" rowspan="2"><bean:message key="label.position.contyear"/></TD>
						<TD class="title" rowspan="2"></TD>
					</TR>
					<TR class="title">
						<TD class="title"><bean:message key="label.position.contsizew"/></TD>
						<TD class="title"><bean:message key="label.position.contsizeh"/></TD>
						<TD class="title"><bean:message key="label.position.contsizel"/></TD>
					</TR>
					<%
						for (int index=0; index < pf.MAXCONTAINERS; index++) {
							if ( (pf.getRescode(index) != null) || (pf.getResname(index) != null) ||
								(pf.getContsizew(index) != null) || (pf.getContsizeh(index) != null) ||
								(pf.getContsizel(index) != null) || (pf.getContyear(index) != null) ) {
					%>
					<TR class="normal" onmouseover="saveIndex();">
						<TD class="text">
							<july:stringwrite name="PositionForm" property='<%= "rescode[" + index + "]" %>'/>
							<INPUT TYPE="HIDDEN" NAME="rescode[<%= index %>]" 
								VALUE='<july:stringwrite name="PositionForm" property='<%= "rescode[" + index + "]" %>'/>'>
						</TD>
						<TD class="text">
							<july:stringwrite name="PositionForm" property='<%= "resname[" + index + "]" %>'/>
							<INPUT TYPE="HIDDEN" NAME="resname[<%= index %>]" 
								VALUE='<july:stringwrite name="PositionForm" property='<%= "resname[" + index + "]" %>'/>'>
						</TD>
						<TD class="text">
							<july:stringwrite name="PositionForm" property='<%= "contsizew[" + index + "]" %>'/>
							<INPUT TYPE="HIDDEN" NAME="contsizew[<%= index %>]" 
								VALUE='<july:stringwrite name="PositionForm" property='<%= "contsizew[" + index + "]" %>'/>'>
						</TD>
						<TD class="text">
							<july:stringwrite name="PositionForm" property='<%= "contsizeh[" + index + "]" %>'/>
							<INPUT TYPE="HIDDEN" NAME="contsizeh[<%= index %>]" 
								VALUE='<july:stringwrite name="PositionForm" property='<%= "contsizeh[" + index + "]" %>'/>'>
						</TD>
						<TD class="text">
							<july:stringwrite name="PositionForm" property='<%= "contsizel[" + index + "]" %>'/>
							<INPUT TYPE="HIDDEN" NAME="contsizel[<%= index %>]" 
								VALUE='<july:stringwrite name="PositionForm" property='<%= "contsizel[" + index + "]" %>'/>'>
						</TD>
						<TD class="text">
							<july:stringwrite name="PositionForm" property='<%= "contyear[" + index + "]" %>'/>
							<INPUT TYPE="HIDDEN" NAME="contyear[<%= index %>]" 
								VALUE='<july:stringwrite name="PositionForm" property='<%= "contyear[" + index + "]" %>'/>'>
						</TD>
						<TD>
							<% if (isAddOrEdit) { %>
									<A HREF="#"><IMG SRC="/images/del.gif" BORDER="0" onclick="deleteContainer(); return false;"></A>
							<% } %>
						</TD>
					</TR>
					<%
							}
						}
					%>
				</TABLE>
            </td>
        </tr>

<SCRIPT language="JavaScript">

changeAntPlace();
changeApType();

</SCRIPT>
