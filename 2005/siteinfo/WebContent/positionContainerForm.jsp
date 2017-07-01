<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<html>
<head>
 <META HTTP-EQUIV = "Pragma" CONTENT="no-cache">
 <title><bean:message key="label.siteinfo"/></title>
 <link rel="stylesheet" type="text/css" href="/main.css">
<SCRIPT SRC='support.js'>
   document.write("errors in 'support.js' or file not found");
</SCRIPT>


<script language="JavaScript">
	//Function below changes cursor to default, when specific image loaded into page
	function changeCursor()
	{
	   document.body.style.cursor="auto";
	}
</script>

</head>

<body id="abody" onload="document.body.style.cursor='auto';">
<script language="JavaScript">
	document.body.style.cursor="wait";
</script>

<july:licence licence="/comctl2.lpk" />

<FORM METHOD="POST" ID="thefirstform">

<SCRIPT language="JScript">
				
var myWindow;
function lookup_params() {
  var s = new String("s");
  var a = s.lookup("s");
}

// Save results in parent form		
function doSave() {
	opener.execScript("addContainerSave();");
}

</SCRIPT>
		
<INPUT TYPE="hidden" name="dummy1" value=''>
<INPUT TYPE="hidden" name="dummy2" value=''>
<INPUT TYPE="hidden" name="dummy3" value=''>

<table class="main">

    <july:separator/>

	<TR class="title">
		<TD colspan="2">&nbsp;</TD>
	</TR>

    <july:separator/>

    <tr>
        <td class="title" colspan="2"><bean:message key="label.position.containers"/></td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.code"/>:</july:reqmark></td>
        <td>
           <INPUT TYPE="TEXT" NAME="rescode" id="rescode" SIZE="5" class="editkod">
			<july:lookupbutton href="/inventory/ShowResourceLookupList.do" 
				styleId="resl" fieldNames="rescode;resmod;resname;resfname" 
				newWindowName="resourcelookup" insertable="true" updatable="true"/>
           <INPUT TYPE="TEXT" NAME="resfname" ID="resfname" SIZE="35" class="editbigdisabled">
			<input type="hidden" name="resourcemodel" id="resmod">
			<input type="hidden" name="resourcename" id="resname">
        </td>
    </tr>
    
    <july:separator/>

    
    <tr>
        <td class="text"><bean:message key="label.position.contsizew"/> /
			<bean:message key="label.position.contsizeh"/> /
			<bean:message key="label.position.contsizel"/>:
		</td>
        <td>
           <INPUT TYPE="TEXT" NAME="contsizew" SIZE="5" class="editkod">
		   &nbsp;&nbsp;
		   <INPUT TYPE="TEXT" NAME="contsizeh" SIZE="5" class="editkod">
		   &nbsp;&nbsp;
		   <INPUT TYPE="TEXT" NAME="contsizel" SIZE="5" class="editkod">
        </td>
    </tr>
    
    <july:separator/>
        
    <tr>
        <td class="text"><bean:message key="label.position.contyear"/>:</td>
        <td>
           <INPUT TYPE="TEXT" NAME="contyear" SIZE="5" class="editkod">
        </td>
    </tr>

    <july:separator/>

	<TR class="title">
		<TD colspan="2"><IMG SRC="/images/save.gif" BORDER="0" onclick="doSave(); window.close(); return false;"><IMG SRC="/images/cancel.gif" BORDER="0" onclick="window.close();return false;"></TD>
	</TR>

    <july:separator/>
</table>

</FORM>


</body>
</html>
