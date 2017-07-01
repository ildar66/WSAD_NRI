<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.*,com.hps.july.logic.VisualDocTypes"%>

<% java.lang.String gColSpan = "10"; %>
<%
	com.hps.july.jdbcpersistence.lib.TimeCounter ts = new com.hps.july.jdbcpersistence.lib.TimeCounter("PERF.INVENTORY.AssemblingPList");
	ts.start();
	AssemblingPListForm frm = (AssemblingPListForm)session.getAttribute("AssemblingPListForm");			
	String positioncode = frm.getPositioncode();
%>

<script type="text/javascript" src="/domapi/script/domapi.js?theme=aqua"></script>
<script type="text/javascript">
    domapi.loadUnit("popupmenu");

    onload = function(){
      document.body.style.cursor='auto';
      menu1 = domapi.Popupmenu({x:300,y:50,doShadow:true,mouseButton:1});
      menu1.beginUpdate();
      try{        
		  menu1.addItem({text:"Alcatel", onselected:"changeLoc1(11);", name:"alcatel"});
		  menu1.addItem({text:"Ericsson", onselected:"changeLoc1(12);", name:"eric"});
		  menu1.addItem({text:"Nokia", onselected:"changeLoc1(13);", name:"nokia"});
		  menu1.addItem({text:"Siemens", onselected:"changeLoc1(14);", name:"siemens"});
		  menu1.addItem({text:"Huawei", onselected:"changeLoc1(15);", name:"huawei"});
          menu1.hideItem(menu1.miShouldntSeeMe);
      }finally{
        menu1.endUpdate();
      }
      elm2 = domapi.Elm({id:"btnbts1"});
      elm3 = domapi.Elm({id:"btnbts2"});

      menu1.attach(elm2); // makes menu1 the popupmenu for elm2
      menu1.attach(elm3); // makes menu1 the popupmenu for elm2
    };
    
    onunload = function(){
      elm2.popupmenu     = null;
      elm2.oncontextmenu = null;
      elm2 = null; 
      menu1 = null;
    };
  
  
</script>


<july:browseform action="/ShowAssemblingPList.do" styleId="AssemblingPListForm">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		AssemblingPListForm[itemname].className = 'editkoddisabled';
		AssemblingPListForm[itemname].disabled = true;
		AssemblingPListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		AssemblingPListForm[itemname].className = 'editkodsearch';
		AssemblingPListForm[itemname].disabled = false;
		AssemblingPListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchFilter() {
	if(AssemblingPListForm.type[0].checked) {
		switchLookup('providercode','prov',true);
		switchLookup('workercode','work',true);
		AssemblingPListForm['providername'].disabled = true;
		AssemblingPListForm['workername'].disabled = true;
		AssemblingPListForm['workertitle'].disabled = true;
	} else if(AssemblingPListForm.type[1].checked) {
		switchLookup('providercode','prov',false);
		switchLookup('workercode','work',true);
		AssemblingPListForm['providername'].disabled = false;
		AssemblingPListForm['workername'].disabled = true;
		AssemblingPListForm['workertitle'].disabled = true;
	} else if(AssemblingPListForm.type[2].checked) {
		switchLookup('providercode','prov',true);
		switchLookup('workercode','work',false);
		AssemblingPListForm['providername'].disabled = true;
		AssemblingPListForm['workername'].disabled = false;
		AssemblingPListForm['workertitle'].disabled = false;
	} else {
		switchLookup('providercode','prov',false);
		switchLookup('workercode','work',false);
		AssemblingPListForm['providername'].disabled = false;
		AssemblingPListForm['workername'].disabled = false;
		AssemblingPListForm['workertitle'].disabled = false;
	}
}

function switchOwner() {
	if(AssemblingPListForm.isowner[0].checked) {
		AssemblingPListForm.ownercode.className='editdisabled';
	} else {
		AssemblingPListForm.ownercode.className='editsearch';
	}
	AssemblingPListForm.ownercode.disabled=AssemblingPListForm.isowner[0].checked;
}

function switchPosition() {
	switchLookup('positioncode','pos',AssemblingPListForm.isposition[0].checked);
}
function printWord(prompt1){
	//Печать актов:
	window.location.href='reports/assactp.jsp?prompt1='+prompt1;
}
function changeLoc1(vistype){
	window.location.href="MountAct2Edit2.do?positioncode=" + document.all.positioncode.value + "&visualtype=" + vistype;
}

function changeLoc2(){
	window.location.href="EditMountAct3.do?action=Add&positioncode=" + document.all.positioncode.value;
}

function changeLoc(vistype){
	window.location.href="MountAct2.do?action=Add&positioncode=" + document.all.positioncode.value + "&visualtype=" + vistype;
}

</script>

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <tr>
		<td class="title"><bean:message key="label.assemblingp.owner"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><html:hidden property="isowner" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   		<july:select collection="owners" property="ownercode" insertable="true" updatable="true" styleClass="search">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select><july:searchbutton/>
			<script language="javascript">switchOwner();</script>
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.assemblingp.position"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isposition" insertable="true" updatable="true" value="true" onclick="switchPosition();"/><html:hidden property="isposition" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="positioncode" styleId="positioncode" size="5" insertable="true" updatable="true" styleId="editkodsearch"/>
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positioncode;positionid;positionname" newWindowName="poslookup" insertable="true" updatable="true" />
			<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
			<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
			<script language="javascript">switchPosition();</script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.assemblingp.date"/></td>
		<td class="title" colspan="2">
			<bean:message key="label.assemblingp.datefrom"/> &nbsp;&nbsp;&nbsp; <july:date property="datefromstr" size="25" insertable="true" updatable="true"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:message key="label.assemblingp.dateto"/> &nbsp;&nbsp;&nbsp; <july:date property="datetostr" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.assemblingp.type"/></td>
		<td class="title" colspan="2">
			<july:radio insertable="true" updatable="true" property="type" value="A" onclick="switchFilter();"/><bean:message key="label.all"/>
			<july:radio insertable="true" updatable="true" property="type" value="P" onclick="switchFilter();"/><bean:message key="label.acttype.forp"/>
			<july:radio insertable="true" updatable="true" property="type" value="W" onclick="switchFilter();"/><bean:message key="label.acttype.forw"/>
		</td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.assemblingp.provider"/></td>
		<td class="title" colspan="2">
			<july:string property="providercode" styleId="providercode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="provl" fieldNames="providercode;providername" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_provl('?selisprovider=true&selisrenter=false&selissupplier=false');"/>
			<july:string size="35" property="providername" styleId="providername" insertable="false" updatable="false" />
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.assemblingp.worker"/></td>
		<td class="title" colspan="2">
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true"  styleClass="editkodsearch" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="workl" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup" insertable="true" updatable="true" />
			<july:string size="25" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
		</td>
    </tr>
    </table>
	<script language="javascript">
    switchFilter();
  </script>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons">

			<!--
			<a href="#" onclick="javascript:return false;" title="Добавить акт монтажа BTS">
			  	<img src="/images/add_bts.gif"  id="btnbts1" border=0 title="Добавить акт монтажа BTS"></a>
			-->
			<a href="javascript:changeLoc2();" title="Добавить акт монтажа BSC"><img src="/images/add_bsc.gif"  border=0></a>

			<%--<july:addbutton image="add_bts.gif" page="<%=getPos()%>"  alttext="label.mountact2.add"/>--%>
	  	    <%--<july:addbutton image="add_bsc.gif" page="/EditMountAct3.do?action=Add"  alttext="label.mountact3.add"/>--%>
			<july:addbutton page="/EditAssemblingP.do?action=Add" alttext="label.assact.add"/>
			<july:backbutton page="/main.do"/>
			<%--a href="#" onclick="changeLoc();" title="Добавить акт монтажа BTS">
			  	<img src="/images/add_bts.gif"  id="btnbts1" border=0 title="Добавить акт монтажа BTS"></a--%>
			</td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.void" colType="number"/> <%-- Edit button --%>
	<july:sortcolumn key="label.internal.date" colType="string" ascFinder="3" descFinder="4"/>
	<july:sortcolumn key="label.num" colType="number" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.assemblingp.owner" colType="number"/> <%-- Owner --%>
	<td class="title"><bean:message key="label.assemblingp.place"/></td> <%-- Position --%>
	<td class="title"><bean:message key="label.assemblingp.expedition"/></td> <%-- From --%>
	<july:headercolumn key="label.assemblingp.state" colType="string"/> <%-- documentState --%>
	<july:headercolumn key="label.void" colType="string"/> <%-- Print --%>
	<july:headercolumn key="label.void" colType="string"/> <%-- Delete --%>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<%
	String masterTagId = "assemblingListWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<!-- Table body -->
<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	pageContext.setAttribute("document",it.getColumn("document").asString());
	String docState = it.getColumn("docstate").asString();
	pageContext.setAttribute("documentState", docState);
	if(it.getColumn("orgto").asObject() != null) {
		pageContext.setAttribute("expedition",it.getColumn("orgto").asString());
	} else if(it.getColumn("workerto").asObject() != null) {
		pageContext.setAttribute("expedition",it.getColumn("workerto").asString());
	}
	boolean isAutoDoc = "Y".equals(it.getColumn("isautodoc").asString());
	Integer visualType = (Integer)it.getColumn("visualtype").asObject();
	String theDocument = it.getColumn("document").asString();
%> 
<tr selectableID='<july:stringwrite name="it" property="document"/>' classReal='<%=(isAutoDoc?"autodoc":"normal")%>' class='<%=(isAutoDoc?"autodoc":"normal")%>' id='selID<july:stringwrite name="it" property="document"/>' onMouseOver='className="select"' onMouseOut="className='<%=(isAutoDoc?"autodoc":"normal")%>'">
	<td class="text"> 
		<%if (isVisualDocType(visualType)) 
		{ %>
			<%if("1".equals(docState) && !isAutoDoc) {%>
				<july:editbutton page="/EditMountAct2.do" action="Edit" paramId="document" paramName="document" paramScope="page" alttext="label.assact.edit"/>
				<%--july:editbutton page="/MountAct2.do" action="Edit" paramId="document" paramName="document" paramScope="page" alttext="label.assact.edit"/--%>
			<%} else {%>
				<july:editbutton page="/EditMountAct2.do" action="View" paramId="document" paramName="document" paramScope="page" alttext="label.assact.view"/>
				<%--july:editbutton page="/MountAct2.do" action="View" paramId="document" paramName="document" paramScope="page" alttext="label.assact.view"/--%>
			<%}%>
		<%} else if (isVisualDocTypeN(visualType)) {%>
			<%if("1".equals(docState) && !isAutoDoc) {%>
				<july:editbutton page="/MountAct2Edit2.do" action="Edit" paramId="document" paramName="document" paramScope="page" alttext="label.assact.edit"/>
			<%} else {%>
				<july:editbutton page="/MountAct2Edit2.do" action="View" paramId="document" paramName="document" paramScope="page" alttext="label.assact.view"/>
			<%}%>
		<%} else {%>
			<%if("1".equals(docState) && !isAutoDoc) {%>
				
				<july:editbutton page="/EditAssemblingP.do" action="Edit" paramId="doc" paramName="document" paramScope="page" alttext="label.assact.edit"/>
			<%} else {%>
				<july:editbutton page="/EditAssemblingP.do" action="View" paramId="doc" paramName="document" paramScope="page" alttext="label.assact.view"/>
			<%}%>
		<%}%>
		<a name="selID<july:stringwrite name="it" property="document"/>"></a>
	</td>
	<td class="text"><july:datewrite name="it" property="blankdate"/></td>
	<td class="text">
		<%-- <july:stringwrite name="it" property="blankindex"/>&nbsp; --%>
		<july:stringwrite name="it" property="blanknumber"/>
	</td>
	<td class="text"><july:stringwrite name="it" property="ownername"/></td>
	<td class="text"><july:stringwrite name="it" property="posname"/><br><july:stringwrite name="it" property="equname"/></td>
	<td class="text"><july:stringwrite name="expedition"/></td>
	<td class="text">
		<%if("1".equals(docState)) {%>
			<bean:message key="label.state.entering"/>
		<%} else if("2".equals(docState)) {%>
			<bean:message key="label.state.calculated"/>
		<%}%>
<%--
				<html:link page="/EditAssemblingPState.do?action=Edit" paramId="doc" paramName="it" paramProperty="so.document" paramScope="page">
					<logic:equal name="it" property="so.documentState" value="1"><bean:message key="label.state.entering"/></logic:equal>
					<logic:equal name="it" property="so.documentState" value="2"><bean:message key="label.state.calculated"/></logic:equal>
				</html:link>
--%>
	</td>
	<td class="link">
<%--
		<july:docprintbutton docstatebean="documentState" href="/crystalclear/assactp.rpt?dll=pdsmount.dll" paramId="prompt0" paramName="document" paramScope="page"/>
--%>
<%--
		<A href='javascript:printWord(<july:stringwrite name="document"/>)'>
			<img src="/images/print.gif" border=0 alt='Напечатать акт'>
		</A>
--%>

		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "assembAct_" + theDocument %>' 
			url='<%= "reports/assactp.jsp?prompt1=" + theDocument %>' 
			uploadurl=''
			updatable='false'
			documentid="<%= theDocument %>">
			<IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'>
		</july:wordEditSlave>

	</td>
	<td class="link">
		<%-- BEE00001243
		<%if("1".equals(docState)) {%>
			<july:delbutton page="/EditAssemblingP.do?action=Delete" paramId="doc" paramName="document" paramScope="page"/>
		<%}%>
		--%>
		<%if (isVisualDocType(visualType)) 
		{ %>
			<%if("1".equals(docState)) {%>
				<july:delbutton page="/EditMountAct2.do?action=Delete" paramId="doc" paramName="document" paramScope="page"/>
			<%}%>
		<%} else if (isVisualDocTypeN(visualType)) {%>
			<%if("1".equals(docState)) {%>
				<july:delbutton page="/MountAct2Edit2.do?action=Delete" paramId="document" paramName="document" paramScope="page"/>
				<%-- <july:delbutton page="/MountAct2Edit2.do?action=Delete" paramId="doc" paramName="document" paramScope="page"/> --%>
			<%}%>
		<%} else {%>
			<%if("1".equals(docState)) {%>
				<july:delbutton page="/EditAssemblingP.do?action=Delete" paramId="doc" paramName="document" paramScope="page"/>
			<%}%>
		<%}%>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons">
			<!--
			<a href="#" onclick="javascript:return false;" 
			  title="Добавить акт монтажа BTS"><img src="/images/add_bts.gif"  id="btnbts2" border=0 
			  title="Добавить акт монтажа BTS"></a>-->
				<july:addbutton image="add_bsc.gif" page="/EditMountAct3.do?action=Add" alttext="label.mountact3.add"/>
				<july:addbutton page="/EditAssemblingP.do?action=Add" alttext="label.assact.add"/>
				<july:backbutton page="/main.do"/>
			</td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
      
<july:separator colspan="<%= gColSpan %>" />   

</july:selectableTable>

</july:browseform>
<%
	ts.finish("JSP");
%>

<%!
	public boolean isVisualDocType(Integer visualType) {
		boolean outBool = com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_ALCATEL.equals(visualType) ||
		      com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_ERIC.equals(visualType) ||
		      com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_NOKIA.equals(visualType) ||
		      com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_SIEMENS.equals(visualType) ||
		      com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_HUAWEI.equals(visualType);
		return outBool;      
	}
	
	public boolean isVisualDocTypeN(Integer visualType) {
		boolean outBool = com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_ALCATEL_N.equals(visualType) ||
			      com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_ERIC_N.equals(visualType) ||
			      com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_NOKIA_N.equals(visualType) ||
			      com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_SIEMENS_N.equals(visualType) ||
			      com.hps.july.logic.VisualDocTypes.BTS_MOUNT_ACT_HUAWEI_N.equals(visualType);
		return outBool;      
	}
%>
