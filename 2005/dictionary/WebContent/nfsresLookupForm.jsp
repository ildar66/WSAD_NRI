<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.cdbc.lib.*,java.util.*"%>

<july:editform action="/NFSResLookup.do" styleId="NFSResLookupForm">
<html:hidden property="resource" />
<html:hidden property="linkedres" />


<SCRIPT language=javascript src="/common/userDecode.js" type="text/javascript"></SCRIPT>  
<script src="/grid/js/activewidgets/lib/aw.js"></script>
<link href="/grid/js/activewidgets/styles/xp/aw.css" rel="stylesheet"></link>

<style>
	.active-controls-grid {
        font-size: 10pt;
    }

	#NFSGrid { width: expression(window.document.body.offsetWidth-35); height: 220px; }
	#NFSGrid .aw-grid-headers {font-size: 10pt; font-weight: bold;}
	#NFSGrid .aw-grid-row {height: 48px; border-bottom: 1px solid #ccc}
	

/********************************************************************
	Columns
********************************************************************/

	#NFSGrid .aw-column-0 {width: 1; border-right: 0px dotted #ccc; display: none; visibility: hidden;}
	#NFSGrid .aw-column-1 {width: expression((window.document.body.offsetWidth-80)*0.12); border-right: 1px dotted #ccc; }
	#NFSGrid .aw-column-2 {width: expression((window.document.body.offsetWidth-80)*0.16); border-right: 1px dotted #ccc;}
	#NFSGrid .aw-column-3 {width: expression((window.document.body.offsetWidth-80)*0.16); border-right: 1px dotted #ccc;}
	#NFSGrid .aw-column-4 {width: expression((window.document.body.offsetWidth-80)*0.16); border-right: 1px dotted #ccc;}
	#NFSGrid .aw-column-5 {width: expression((window.document.body.offsetWidth-80)*0.39); border-right: 1px dotted #ccc;}
	// #NFSGrid .aw-column-6 {width: 30px; border-right: 1px dotted #ccc;}

</style>


<script>	

	// Instantiate a DOM object.
	var doc = new ActiveXObject("msxml2.DOMDocument.3.0");
	doc.async = false;
	doc.resolveExternals = false;
	doc.validateOnParse = false;
	
	var headerList2 = ['', '<bean:message key="label.resource.nfscode"/>',
		'<bean:message key="label.resource.manucode"/>',
		'<bean:message key="label.resource.model"/>',
		'<bean:message key="label.resource.manufacturer"/>', 
		'<bean:message key="label.resource.name"/>' 
		// , ''
		];
	//	create ActiveWidgets data model - XML-based table
	var table2 = new AW.XML.Table;
	var obj2 = new AW.UI.Grid;
                    
	obj2.setColumnCount(headerList2.length);

	//	provide column labels
	obj2.setHeaderText(headerList2);

	//	provide external model as a grid data source
	obj2.setCellModel(table2);
	obj2.getRowTemplate().setClass("text", "wrap");	// multiline text // setClass("text", "normal");
	obj2.getCellTemplate().setStyle("font-size", "10pt");
	obj2.setHeaderHeight(20);
	obj2.setVirtualMode(true);	
	obj2.setId("NFSGrid");
	//	set row selection
	obj2.setSelectionMode("single-row");
	//	write grid html to the page
	document.body.setAttribute("nfsTbl", obj2);

// !!!!!!!!!!!!!

changeEscape();

// !!!!!!!!!!!!!
	
	function doFind() {
		document.body.style.cursor = 'wait';
		var sendValue = document.all.searchparam.value;
		var url = "GetNFSResourceData?searchby=" + document.all.searchby.value + "&searchparam=" + escape(sendValue);
		doc.load(url);
		var xml3 = doc.xml;
		table2.setXML(xml3);
		var oNodes = doc.selectNodes("//ROOT/*");
    	obj2.setRowCount(oNodes.length);
		obj2.refresh();
		document.body.style.cursor = 'auto';
	}
	
	function checkFind() {
		if (window.event.keyCode == 13) {
			window.event.cancelBubble = true;
			doFind();
			return false;
		}
		return true;
	}

	function doSave() {
		var k = obj2.getCurrentRow();
		opener.document.all["<bean:write name="NFSResLookupForm" property="nfsId" filter="true"/>"].value = 
			obj2.getCellText(0, k);
		opener.document.all["<bean:write name="NFSResLookupForm" property="nfsCode" filter="true"/>"].value = 
			obj2.getCellText(1, k);
		opener.document.all["<bean:write name="NFSResLookupForm" property="nfsDescr" filter="true"/>"].value = 
			obj2.getCellText(5, k);
		window.close();
	}
	
</script>	

<table class="main">

    
    <july:separator/>
   
    
	<TR class="title">
		<TD class="title">
			<A HREF="#"><IMG SRC="/images/save.gif" BORDER="0" onclick="doSave();"/></A>
			<july:closebutton page="/"/>
		</TD>
	</TR>
    
    <july:separator/>
 
    <tr class="title">
        <td class="title" colspan="2">
        	<bean:message key="label.resource.allnfs"/>
        </td>
    </tr>
    
    <tr class="find">
        <td class="find" colspan="2">  
        	<bean:message key="label.nfsres2nrires.searchby"/>
        	<july:select property="searchby" styleId="searchby"
        		insertable="true" updatable="true">
        		<html:option key="label.nfsres2nrires.searchbyA" value="A"/>
        		<html:option key="label.nfsres2nrires.searchbyB" value="B"/>
        		<html:option key="label.nfsres2nrires.searchbyC" value="C"/>
        		<html:option key="label.nfsres2nrires.searchbyD" value="D"/>
        		<html:option key="label.nfsres2nrires.searchbyE" value="E"/>
        	</july:select>
        	<july:string size="10" property="searchparam" styleId="searchparam" 
        		onkeypress="return checkFind();" insertable="true" updatable="true"/>
        	<A HREF="#"><IMG SRC="/images/refresh.gif" BORDER="0" onclick="doFind(); return false;"/></A>
        </td>
    </tr>
    
    <tr>
        <td class="title" colspan="2">
        
<script language="javascript">	
	document.write(document.body.getAttribute("nfsTbl"));
</script>

        </td>
    </tr>
    
    <july:separator/>
   
    
	<TR class="title">
		<TD class="title">
			<A HREF="#"><IMG SRC="/images/save.gif" BORDER="0" onclick="doSave();"/></A>
			<july:closebutton page="/"/>
		</TD>
	</TR>
    
    <july:separator/>

    
</table>

</july:editform>

<script language="javascript" src="/focus.js"></script>

<script language="javascript">
	if (document.all.action.value == "Close") {
		window.opener.execScript("submitForm();");
		window.close();
	}
</script>






