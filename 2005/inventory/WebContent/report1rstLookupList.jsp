<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "4"; %>

<script for="window" event="onload">
document.body.style.cursor='auto';
if(document.all.mustClose.value == 'true') {
	document.all.mustClose.value = 'false';
	window.close();
}
</script>

<july:browseform action="/ShowReport1rstLookupList.do" styleId="Report1rstLookupListForm">

<script language="javascript">
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

<input type="hidden" name="mustClose" value='<%=(request.getParameter("mustClose")!=null?request.getParameter("mustClose"):"false")%>'>

<table class="main">
<TR class="title">
 <TD class="title">
    <bean:message key="label.choose.ressbtype"/>
 </TD>
</TR>
<TR class="normal">
<TD>
	<table class="find">
	<TR>
		<td class="title"><bean:message key="label.restype"/></td>
		<td colspan="2" class="title"><bean:write name="Report1rstLookupListForm" property="resourcetypename" filter="true" /></td>
	</tr>        
	</table>
  </TD>
</TR>

<tr class="title">
  <td><TABLE class="buttons">
    <TR class="title">
      <td class="buttons"><a href="/"><IMG SRC="/images/save.gif" border="0" onclick="window.document.forms(0).submit();return false;" ALT="Сохранить"></a><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'><july:closebutton page="/"/></TD>
      <td class="navigator"><july:navigator/></TD>
    </TR>
    </TABLE></TD>
</tr>

<TR>
  <TD>

    <table class="main" id="brtable">

        <!-- Table header -->
        <tr class="title">
        <july:headercolumn key="label.subtype.code" colType="number"/>
        <july:headercolumn key="label.subtype.name" colType="string"/>
        <july:headercolumn key="label.void" colType="string"/>
        </tr>

        <!-- Table body -->
        <logic:iterate id="rstl" name="browseList" indexId="index" type="com.hps.july.persistence.ResourceSubTypeAccessBean">
	      <logic:present name="rstl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<% java.lang.String s = (java.lang.String)(RequestUtils.lookup(pageContext, "rstl", "resourcesubtype", null).toString()); %>
                <td class="number"><bean:write name="rstl" property="resourcesubtype" filter="true"/></td>
                <td class="text"><bean:write name="rstl" property="name" filter="true"/></td>
                <td class="link"><july:checkbox property="selectedSubtypes" value="<%= s %>" insertable="true" updatable="true"/></td>
            </tr>
	      </logic:present>
          
	      <logic:notPresent name="rstl">
            <tr class="normal">
                <td class="text" colspan="<%= gColSpan %>">
                   <bean:message key="label.norecords"/>
                </td>
            </tr>
	      </logic:notPresent>
          
          <july:separator colspan="<%= gColSpan %>" />
        </logic:iterate>
	<INPUT TYPE="HIDDEN" NAME="selectedSubtypes" VALUE="0">
    </table>
</TD>
</TR>

<tr class="title">
  <td><TABLE class="buttons">
    <TR class="title">
      <td class="buttons"><a href="/"><IMG SRC="/images/save.gif" border="0" onclick="return (saveValues());" ALT="Сохранить"></a><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'><july:closebutton page="/"/></TD>
      <td class="navigator"><july:navigator/></TD>
    </TR>
    </TABLE></TD>
</tr>

</TABLE>
    
</july:browseform>
