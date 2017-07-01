<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "7"; %>

<SCRIPT>
  function changeVis(argChecked, allowsumbit) {
    if (argChecked) {
      document.all.divflt.style.display = 'none';
      document.all.divflt.style.visibility = 'hidden';
      document.all.spnsrch.style.display = 'inline';
      document.all.spnsrch.style.visibility = 'visible';
      if (allowsumbit)
        submitForm();
    } else {
      document.all.divflt.style.display = 'block';
      document.all.divflt.style.visibility = 'visible';
      document.all.spnsrch.style.display = 'none';
      document.all.spnsrch.style.visibility = 'hidden';
    }
  }

  // Результат обновления БД
  function onDownloadDone(s) {
    //alert(s);
  }
  
  function saveResource(argChecked, argCateg, argResource) {
    oDownload.startDownload('/dict/updateResourceCateg?create=' + argChecked +
      '&categ=' + argCateg + '&resource=' + argResource, onDownloadDone);
  }
  
</SCRIPT>

<IE:DOWNLOAD ID="oDownload" STYLE="behavior:url(#default#download)" />



<jsp:useBean id="InvResourceListForm" type="com.hps.july.dictionary.formbean.InvResourceListForm"
  scope="session"/>

<july:browseform action="/ShowInvResourceList.do">

<%@include file="resources/script.jsp" %>

<table class="main">

<july:separator colspan="<%= gColSpan %>" />

<tr class="normal">
	<td colspan="<%= gColSpan %>">
		  <table class="find">
  	<tr class="expired">
  	<td class="title" nowrap>
  		<bean:message key="label.resource.inpcategory"/>:
  	</td>
  	<td class="title" nowrap>
      <july:select size="1" collection="categories" property="category"
          styleClass="editbiggestsearch"
          insertable="true" updatable="true">
        <july:options collection="categories" property="categid" labelProperty="categname"/>
      </july:select>
      &nbsp;
      <july:checkbox property="bycategory"
        onclick="changeVis(document.all.bycategory [0].checked, true);"
        insertable="true" updatable="true"/>
  		<bean:message key="label.resource.bycategory"/>
  		<SPAN ID="spnsrch"><july:searchbutton/></SPAN>

  	</td>
  	</tr>
		</table>
		<table class="find" ID="divflt">
			<%@include file="resources/filter.jsp"%>
		</table>
	</td>
</tr>


<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons"><july:addbutton page="/ChooseRtype.do?action=Add"/><july:backbutton/></TD>
        	<td class="navigator"><july:navigator/></TD>
	</tr>
	</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:sortcolumn key="label.resource.manucode" colType="string" ascFinder="5" descFinder="6"/>
	<july:sortcolumn key="label.resource.model" colType="string" ascFinder="1" descFinder="2"/>
	<july:sortcolumn key="label.resource.name" colType="string" ascFinder="3" descFinder="4"/>
	<july:headercolumn key="label.resource.unit.short" colType="string"/>
	<july:headercolumn key="label.resource.countpolicy.serial" colType="string"/>
	<july:headercolumn key="label.resource.countpolicy.partial" colType="string"/>
	<td class="title" width="1%">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<%
  int checkNo = 0;
  String checkId = "";
%>
<!-- Table body -->
<logic:iterate id="rl" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="rl">
<%
  String resource = rl.getColumn("resource").asString();
  String crresource = rl.getColumn("crresource").asString();
	pageContext.setAttribute("resource", resource);
	InvResourceListForm.setCrresource(crresource);
	checkNo++;
	checkId = "checkb" + checkNo;
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="text"><july:stringwrite name="rl" property="manucode"/></td>
	<td class="text"><july:stringwrite name="rl" property="model"/></td>
	<td class="text"><july:stringwrite name="rl" property="name"/></td>
	<td class="text"><july:stringwrite name="rl" property="shortname"/></td>
	<td class="text"><%if("S".equals(rl.getColumn("countpolicy").asString())) { %>+<%}%></td>
	<td class="text"><%if("P".equals(rl.getColumn("countpolicy").asString())) { %>+<%}%></td>
	<td class="link">
      <july:checkbox styleId="<%= checkId %>" property="crresource"
        value="<%= resource %>"
        onclick='<%= "saveResource(document.all." + checkId + ".checked, " + InvResourceListForm.getCategory() + ", " + resource + ")" %>'
        insertable="true" updatable="true"/>
  </td>
</tr>
<july:separator colspan="<%= gColSpan %>" />

</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons"><july:addbutton page="/ChooseRtype.do?action=Add"/><july:backbutton/></td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

</table>

<script language="javascript">
changeVis(document.all.bycategory [0].checked, false);
switchResourcetype();
switchResourcesubtype();
switchName();
switchModel();
switchManuf();
switchManucode();
</script>

</july:browseform>
