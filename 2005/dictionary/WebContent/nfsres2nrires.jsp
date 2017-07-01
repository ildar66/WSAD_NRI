<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.cdbc.lib.*,java.util.*"%>

<july:editform action="/NFSRes2NRIRes.do">
<bean:define id="resourceList" name="NFSRes2NRIResForm" property="resourceList" scope="request" type="com.hps.july.cdbc.lib.CDBCRowObject"/>
<bean:define id="linkedResourceList" name="NFSRes2NRIResForm" property="linkedResourceList" scope="request" type="com.hps.july.cdbc.lib.CDBCResultSet"/>
<html:hidden property="resource" />
<html:hidden property="linkedres" />


<SCRIPT language=javascript src="/common/userDecode.js" type="text/javascript"></SCRIPT>  
<script src="/grid/js/activewidgets/lib/aw.js"></script>
<link href="/grid/js/activewidgets/styles/xp/aw.css" rel="stylesheet"></link>

<style>
	.active-controls-grid {
        font-size: 10pt;
    }

	#linkedGrid { width: expression(window.document.body.offsetWidth-35); height: 220px; }
	#linkedGrid .aw-grid-headers {font-size: 10pt; font-weight: bold;}
	#linkedGrid .aw-grid-row {height: 32px; border-bottom: 1px solid #ccc}
    #linkedGrid .aw-grid-control {height: 160px; width: 100%; margin: 0px; border: none; font: menu;} 
    #linkedGrid .aw-scroll-bars.gecko { overflow:hidden; }
<%--    #linkedGrid .aw-scroll-bars.gecko { overflow-y: visible; }
        #linkedGrid .active-grid-row.gecko, .active-box-normal.gecko { overflow:hidden; } 
	#linkedGrid .active-grid-row.gecko, .active-box-normal.gecko { overflow-y: visible; } --%> 

	#NFSGrid { width: expression(window.document.body.offsetWidth-35); height: 220px; }
	#NFSGrid .aw-grid-headers {font-size: 10pt; font-weight: bold;}
	#NFSGrid .aw-grid-row {height: 48px; border-bottom: 1px solid #ccc}
	

/********************************************************************
	Columns
********************************************************************/

	#linkedGrid .aw-column-0 {width: 1; border-right: 0px dotted #ccc; display: none; visibility: hidden;}
	#linkedGrid .aw-column-1 {width: expression((window.document.body.offsetWidth-80)*0.12); border-right: 1px dotted #ccc; }
	#linkedGrid .aw-column-2 {width: expression((window.document.body.offsetWidth-80)*0.16); border-right: 1px dotted #ccc;}
	#linkedGrid .aw-column-3 {width: expression((window.document.body.offsetWidth-80)*0.16); border-right: 1px dotted #ccc;}
	#linkedGrid .aw-column-4 {width: expression((window.document.body.offsetWidth-80)*0.16); border-right: 1px dotted #ccc;}
	#linkedGrid .aw-column-5 {width: expression((window.document.body.offsetWidth-80)*0.39); border-right: 1px dotted #ccc;}
	#linkedGrid .aw-column-6 {width: 30px; border-right: 1px dotted #ccc;}

	#NFSGrid .aw-column-0 {width: 1; border-right: 0px dotted #ccc; display: none; visibility: hidden;}
	#NFSGrid .aw-column-1 {width: expression((window.document.body.offsetWidth-80)*0.12); border-right: 1px dotted #ccc; }
	#NFSGrid .aw-column-2 {width: expression((window.document.body.offsetWidth-80)*0.16); border-right: 1px dotted #ccc;}
	#NFSGrid .aw-column-3 {width: expression((window.document.body.offsetWidth-80)*0.16); border-right: 1px dotted #ccc;}
	#NFSGrid .aw-column-4 {width: expression((window.document.body.offsetWidth-80)*0.16); border-right: 1px dotted #ccc;}
	#NFSGrid .aw-column-5 {width: expression((window.document.body.offsetWidth-80)*0.39); border-right: 1px dotted #ccc;}
	#NFSGrid .aw-column-6 {width: 30px; border-right: 1px dotted #ccc;}

</style>


<script>	

	var xmlNFSResListData = new Array(
        	<%
        		ListIterator it = linkedResourceList.listIterator();
        		boolean isFirst = true;
        		while (it.hasNext()) {
        			CDBCRowObject ro = (CDBCRowObject)it.next();
        			pageContext.setAttribute("ro", ro);
		    %>
		
			<% if (!isFirst) { %>,<% } else { isFirst = false; } %>
			new Array(
				"<july:stringwrite name="ro" property="item_id"/>",
				"<july:stringwrite name="ro" property="segment1"/>",
				"<july:stringwrite name="ro" property="manucode"/>",
				"<july:stringwrite name="ro" property="model"/>",
				"<july:stringwrite name="ro" property="shortname"/>",
				"<july:stringwrite name="ro" property="name"/>",
				"<IMG SRC='/images/del.gif' BORDER=0 onclick='del();'>"
			)
		<% } %>
	);

	
	var headerList = ['', '<bean:message key="label.resource.nfscode"/>',
		'<bean:message key="label.resource.manucode"/>',
		'<bean:message key="label.resource.model"/>',
		'<bean:message key="label.resource.manufacturer"/>',
		'<bean:message key="label.resource.name"/>',
		''];
	//	create ActiveWidgets data model - XML-based table
	// var table = new AW.XML.Table;
	//  get reference to the xml data island node
	//var xml = document.getElementById("xmlNFSResListData");
	//	provide data XML

	//	create ActiveWidgets Grid javascript object
	var obj = new AW.UI.Grid;

    obj.setCellText(function(col, row){
    					//alert("row=" + row + ", col=" + col);
    				var res = 'E';
    				try {
                       res = xmlNFSResListData[row][col] 
                    } catch (exception) {
                    	//
                    }
                    return res;
                 }
                 );
                    
	obj.setColumnCount(headerList.length);
	obj.setRowCount(xmlNFSResListData.length);

	//	provide column labels
	obj.setHeaderText(headerList);

	//	provide external model as a grid data source
	// obj.setCellModel(table);
	//obj.getRowTemplate().setClass("text", "normal");
	obj.getRowTemplate().setClass("text", "wrap");	// multiline text
	obj.getCellTemplate().setStyle("font-size", "10pt");
	//obj.setRowHeight(32);
	obj.setHeaderHeight(20);
	obj.setVirtualMode(true);	
	// obj.setVirtualMode(false);	
	obj.setId("linkedGrid");
	//	set row selection
	obj.setSelectionMode("single-row");
	//	write grid html to the page
	document.body.setAttribute("linkedTbl", obj);
	
	function del(){
		var i = obj.getCurrentRow();
		xmlNFSResListData[i][0] = '0';
		obj.deleteRow(i);
	}
	
	// Instantiate a DOM object.
	var doc = new ActiveXObject("msxml2.DOMDocument.3.0");
	doc.async = false;
	doc.resolveExternals = false;
	doc.validateOnParse = false;
	
	// Load an XML file into the DOM instance.
	//doc.load("GetNFSResourceData?searchby=D&searchparam=*BSC*");
	
	// Display the content of the object.
	//alert("doc: "+doc.xml);
	
	
	var headerList2 = ['', '<bean:message key="label.resource.nfscode"/>',
		'<bean:message key="label.resource.manucode"/>',
		'<bean:message key="label.resource.model"/>',
		'<bean:message key="label.resource.manufacturer"/>', 
		'<bean:message key="label.resource.name"/>',
		''];
	//	create ActiveWidgets data model - XML-based table
	var table2 = new AW.XML.Table;
	//  get reference to the xml data island node
	//var xml2 = document.getElementById("xmlNFSListData");
	//	provide data XML
	//table2.setXML(xml2);
	//obj2.setRowCount(1);


	//	create ActiveWidgets Grid javascript object
	var obj2 = new AW.UI.Grid;

    //obj2.setCellText(function(col, row){
    //                   return xmlNFSListData[row][col] }
    //                );
                    
	obj2.setColumnCount(headerList2.length);

	//	provide column labels
	obj2.setHeaderText(headerList2);

	//	provide external model as a grid data source
	obj2.setCellModel(table2);
	obj2.getRowTemplate().setClass("text", "wrap");	// multiline text // setClass("text", "normal");
	obj2.getCellTemplate().setStyle("font-size", "10pt");
	obj2.setHeaderHeight(20);
	// obj2.setVirtualMode(false);	
	obj2.setVirtualMode(true);	
	obj2.setId("NFSGrid");
	//	set row selection
	obj2.setSelectionMode("single-row");
	//	write grid html to the page
	document.body.setAttribute("nfsTbl", obj2);
	//doFind();
	
	var RowCount = xmlNFSResListData.length;
	
	function ins(){
		var k = obj2.getCurrentRow();
        for(var i = 0; i < xmlNFSResListData.length; i++) {
            if(xmlNFSResListData[i][0] == obj2.getCellText(0, k)) {
                alert('Такой код уже существует в списке !');
                return;
            }
        }
		var n = RowCount;
		xmlNFSResListData [n] = new Array(6);
		for (i=0; i < 7; i++) {
        	xmlNFSResListData [n][i] = obj2.getCellText(i, k);
		}
		xmlNFSResListData [n][6] = '<IMG SRC="/images/del.gif" BORDER="0" onclick="del();">';
		var j = obj.addRow(RowCount++);
		obj.refresh();
	}
	
// !!!!!!!!!!!!!

changeEscape();

// !!!!!!!!!!!!!
	
	function doFind() {
		document.body.style.cursor = 'wait';
		// var sendValue = escape(document.all.searchparam.value);
		// var sendValue = encodeURIComponent(document.all.searchparam.value);
		var sendValue = document.all.searchparam.value;
		// alert("sendValue = "+sendValue);
		var url = "GetNFSResourceData?searchby=" + document.all.searchby.value + "&searchparam=" + escape(sendValue);
		// alert("url = "+url);
		doc.load(url);
		var xml3 = doc.xml;
		table2.setXML(xml3);
		//alert(xml3);
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
		var aStr = "";
        for (var i = 0; i < xmlNFSResListData.length; i++) {
        	if (i > 0)
        		aStr = aStr + ",";
            aStr = aStr + xmlNFSResListData[i][0];
		}
		document.all.linkedres.value = aStr;
		document.all.action.value = 'Save';
	}

	
	function beyVBuben() {
		// !!!!!!!!!!!!!!! шаманство !!!!!!!!!!!!!!!
		var oldHeaderHeight = obj.getHeaderHeight();
		obj.setRowCount(100);
		obj.setColumnCount(0);
		obj.setVirtualMode(true);	
		obj.setRowCount(0);
		obj.setHeaderHeight(1);
		obj.setSortColumn(1);
		obj.setSortDirection("ascending");
		obj.refresh();
		lt.refresh();

		obj.setColumnCount(headerList.length);
		obj.setRowCount(xmlNFSResListData.length);
		// obj.setVirtualMode(false);	
		obj.setVirtualMode(true);	
		obj.setHeaderHeight(oldHeaderHeight);
		obj.setSortColumn(1);
		obj.setSortDirection("descending");
		obj.refresh();
		lt.refresh();

		obj.setSortColumn(0);
		obj.setSortDirection("ascending");
		obj.refresh();
		lt.refresh();
	}
</script>	

<table class="main">
 
    <tr class="title">
        <td class="title" colspan="2"><bean:message key="label.nfsres2nrires.title"/></td>
    </tr>
    
    <july:separator/>
    
	<TR class="title">
		<TD class="title">
			<A HREF="#"><IMG SRC="/images/save.gif" BORDER="0" onclick="doSave();document.body.style.cursor='wait';if (document.forms(0).elements('wasposted').value == 1) { alert('Запрос уже отправлен на сервер пожалуйста подождите'); return false; }  else { document.forms(0).elements('wasposted').value=1; document.forms(0).submit(); }"/></A>
			<july:closebutton page="/"/>
		</TD>
	</TR>
    
    <july:separator/>

    <tr>
        <td class="title" colspan="2">
        	<bean:message key="label.resource"/>: <july:stringwrite name="resourceList" property="name"/>
        	<TABLE class="main">
			<tr class="title">
				<july:headercolumn key="label.resource.code" colType="number"/> 
				<july:headercolumn key="label.resource.model" colType="text"/> 
				<july:headercolumn key="label.resource.manucode" colType="text"/> 
				<july:headercolumn key="label.resource.manufacturer" colType="text"/> 
			</tr>
			<tr class="title">
				<td class="text"><july:stringwrite name="resourceList" property="resource"/></td>
				<td class="text"><july:stringwrite name="resourceList" property="model"/></td>
				<td class="text"><july:stringwrite name="resourceList" property="manucode"/></td>
				<td class="text"><july:stringwrite name="resourceList" property="orgname"/></td>
			</tr>
        	</TABLE>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr class="title">
        <td class="title" colspan="2">
        	<bean:message key="label.resource.linkednfs"/>
        </td>
    </tr>
    <tr>
        <td class="title" colspan="2">
        
<script>	
	var lt = document.body.getAttribute("linkedTbl");
	document.write(lt);
	lt.refresh();
</script>
        </td>
    </tr>
    
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
<!--        
<script language="javascript">	
	document.write(document.body.getAttribute("nfsTbl"));

// !!!!!!!!!!!!!!! шаманство !!!!!!!!!!!!!!!
beyVBuben();


</script>
-->
        </td>
    </tr>
    
    <july:separator/>
    
	<TR class="title">
		<TD class="title">
			<A HREF="#"><IMG SRC="/images/save.gif" BORDER="0" onclick="doSave();document.body.style.cursor='wait';if (document.forms(0).elements('wasposted').value == 1) { alert('Запрос уже отправлен на сервер пожалуйста подождите'); return false; }  else { document.forms(0).elements('wasposted').value=1; document.forms(0).submit(); }"/></A>
			<july:closebutton page="/"/>
		</TD>
	</TR>
    
    <july:separator/>
    
</table>

<script language="javascript">	
	document.write(document.body.getAttribute("nfsTbl"));

// !!!!!!!!!!!!!!! шаманство !!!!!!!!!!!!!!!
beyVBuben();


</script>


</july:editform>

<script language="javascript" src="/focus.js"></script>

<script language="javascript">
	if (document.all.action.value == "Close") {
		window.opener.execScript("submitForm();");
		window.close();
	}

// !!!!!!!!!!!!!!! шаманство !!!!!!!!!!!!!!!
beyVBuben();

</script>
