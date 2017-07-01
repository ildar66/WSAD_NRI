<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.inventory.formbean.Report1rtLookupListForm" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%!
	private boolean contains(int[] arr, int val) {
		if(arr == null) return false;
		boolean res = false;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == val) {
				res = true;
				break;
			}
		}
		return res;
	}
%>

<%
	java.lang.String gColSpan = "3";
%>

<script for="window" event="onload">
document.body.style.cursor='auto';
if(document.all.mustClose.value == 'true') {
	document.all.mustClose.value = 'false';
	window.close();
}
</script>

<july:browseform action="/ShowReport1rtLookupList.do">

<%
	Report1rtLookupListForm frm = (Report1rtLookupListForm)session.getAttribute("Report1rtLookupListForm");
	int[] selectedArray = (int[])frm.getSelectedType();
%>

<input type="hidden" name="mustClose" value='<%=(request.getParameter("mustClose")!=null?request.getParameter("mustClose"):"false")%>'>

<script language="javascript">
function showLookupWindow(name,params) {
	var href = "Show"+name+"LookupList.do";
	if(params != null) {
		href += "?" + params;
	}
	var myWindow = window.open(
		href,
		name+"lookup",
		"top=110, left=110, width=700, height=500, scrollbars=yes, resizable=yes"
	);
	return false;
}

function saveValues() {
	document.body.style.cursor='wait';
	if (document.forms(0).elements('wasposted').value == 1) {
		alert('Запрос уже отправлен на сервер пожалуйста подождите');
	} else {
		document.forms(0).elements('wasposted').value=1;
		document.all.mustClose.value='true';
		window.document.forms(0).submit();
	}
	return false;
}
</script>

<table class="main">
<TR class="title">
 <TD class="title">
	<bean:message key="label.choose.restype"/>
 </TD>
</TR>

<tr class="title">
  <td><table class="buttons">
    <tr class="title">
      <td class="buttons"><a href="/"><IMG SRC="/images/save.gif" border="0" onclick="window.document.forms(0).submit();return false;" ALT="Сохранить"></a><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'><july:closebutton page="/"/></TD>
      <td class="navigator"><july:navigator/></TD>
    </tr>
    </table>
  </td>
</tr>

<TR>
  <TD>

    <table class="main" id="brtable">

        <!-- Table header -->
        <tr class="title">
            <july:headercolumn key="label.restype.code" colType="number"/>
            <july:headercolumn key="label.restype.name" colType="string"/>
            <july:headercolumn key="label.void" colType="string"/>
        </tr>

        <!-- Table body -->
	<logic:iterate id="rtl" name="browseList" indexId="index" type="com.hps.july.persistence.ResourceTypeAccessBean">
		<logic:present name="rtl">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<% String s = String.valueOf(rtl.getResourcetype()); %>
			<td class="number"><bean:write name="rtl" property="resourcetype" filter="true"/></td>
			<td class="text"><a href="/" class="link" onclick="showLookupWindow('Report1rst','rtchecked=true&resourcetype=<%=s%>');return false;"><bean:write name="rtl" property="name" filter="true"/></a></td>
			<td class="link"><input type="checkbox" name="selectedType" value="<%=s%>" <%=(contains(selectedArray,rtl.getResourcetype())?"checked":"")%> class="editcheckbox"></td>
		</tr>
		</logic:present>

		<logic:notPresent name="rtl">
		<tr class="normal">
			<td class="text" colspan="<%= gColSpan %>"><bean:message key="label.norecords"/></td>
		</tr>
		</logic:notPresent>
		<july:separator colspan="<%= gColSpan %>" />
	</logic:iterate>
    </table>
</TD>
</TR>

<tr class="title">
  <td><table class="buttons">
    <tr class="title">
      <td class="buttons"><a href="/"><IMG SRC="/images/save.gif" border="0" onclick="return(saveValues());" ALT="Сохранить"></a><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'><july:closebutton page="/"/></TD>
      <td class="navigator"><july:navigator/></TD>
    </tr>
    </table>
  </td>
</tr>

</TABLE>

</july:browseform>
