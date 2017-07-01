<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.dictionary.formbean.*"%>
<SCRIPT language=javascript src="/scripts/string_format.js" type="text/javascript"></SCRIPT>  
<%
	String gColSpan = "15";
	String maxWidth = "735";
	String paramTextLength = "50";
	String enterValueStr = "���� ��������:";
	String contentIFrameHeight = "360"; // "320"; // "160";
%>

<july:editform action="/ShowConfBaseStation.do" styleId="ShowConfBaseStationForm">

<html:hidden property="isStandPrepareProcess"/>
<html:hidden property="isBaseStationCurComplectPrepareProcess"/>
<html:hidden property="curComplectSelectedID"/>
<html:hidden property="curComplectOldRowClassName"/>

<table class="main"  id="mainTableID">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>" width="<%=maxWidth%>">
	<table class="main" id="searchTableID" border="0"> 
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">&nbsp;&nbsp;&nbsp;
			����� ����� ������� �������	
		</td>
	</tr>
	<tr class="normal">
		<td class="title" nowrap width="210" valign="middle">����������:&nbsp;
			<july:select property="searchActiveParameValue" styleId="searchActiveParameValueId" 
						style="font-size:8pt;width=100px" insertable="false" updatable="false"
						onchange="searchActiveParameValueChange();">
      				<html:option value="<%=ShowConfBaseStationForm.ACTIVE_SEARCH_VALUE%>">��������</html:option>
      				<html:option value="<%=ShowConfBaseStationForm.NOT_ACTIVE_SEARCH_VALUE%>">����������</html:option>
      				<html:option value="<%=ShowConfBaseStationForm.ALL_SEARCH_VALUE%>">���</html:option>
      		</july:select>		
      	</td>
      	<td class="title" align="left" width="520">�������������:&nbsp;
			<july:select collection="manufList" property="searchManufParameValue" styleId="searchManufParameValueId" 
						style="font-size:8pt;width=380px" insertable="false" updatable="false" 
						onchange="searchManufParameValueChange();">
					<html:options collection="manufList" property="key" labelProperty="value"/>						
      		</july:select>		
      	</td>
	</tr>
	<tr class="normal">
      	<td class="title" colspan="2" align="left" width="730">��� �����:&nbsp;
			<july:select collection="standList" property="searchStandParameValue" styleId="searchStandParameValueId" 
						style="font-size:8pt;width=635px" insertable="false" updatable="false" 
						onchange="searchStandParameValueChange();">
					<html:options collection="standList" property="key" labelProperty="value"/>						
      		</july:select>		
      	</td>
	</tr>

	<%-- ����� ��� ����������� ������������ ������ --%>
	<tr class="normal">
		<td colspan="<%= gColSpan %>" class="normal" >
			<iframe width="<%=maxWidth%>" MARGINWIDTH="0" MARGINHEIGHT="0" 
				ALIGN="top" frameborder="0" 
				height="0">
			</iframe>
		</td>
	</tr>
	</table>
 </TD>	
</TR>

<july:separator colspan="<%= gColSpan %>" />
<!-- ������ ��� ��������� -->

<TR class="normal">
 <TD colspan="<%= gColSpan %>" width="<%=maxWidth%>">
	<table class="main" id="curCmplTableID"> 
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">&nbsp;&nbsp;&nbsp;
			������� ������������ ������� �������	
		</td>
	</tr>
	<tr class="normal">
      	<td class="title" colspan="<%= gColSpan %>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      		������� 1800&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;������� 900
      	</td>
	</tr>
	<tr class="normal">
		<td width = "100%" class="normal" >
			<iframe width="<%=maxWidth%>" MARGINWIDTH="0" MARGINHEIGHT="0" 
				ALIGN="top" frameborder="1" name="curBaseStationCmplTitleIFrame" 
				height="42" src="curBaseStationCmplTitle.jsp?<%=ShowConfBaseStationForm.getUniqueMockParams()%>" SCROLLING="no" >
			</iframe>
		</td>
	</tr>
	<tr class="normal">
		<td width = "100%" class="normal" >
			<iframe width="<%=maxWidth%>" MARGINWIDTH="0" MARGINHEIGHT="0" 
				ALIGN="top" frameborder="1" name="curBaseStationCmplIFrame" 
				height="<%=contentIFrameHeight%>" src="curBaseStationCmpl.jsp?<%=ShowConfBaseStationForm.getUniqueMockParams()%>" SCROLLING="auto" >
			</iframe>
		</td>
	</tr>
	</table>
 </TD>	
</TR>

<july:separator colspan="<%= gColSpan %>" />

</table>

</july:editform>

<script language="javascript"> 

function searchActiveParameValueChange() {
	// alert("searchActiveParameValueChange");
	startStandPrep();
}

function searchManufParameValueChange() {
	// alert("searchManufParameValueChange");
	startStandPrep();
}

function searchStandParameValueChange() {
	// alert("searchStandParameValueChange");
	runSearchProcess();
}

function startStandPrep() {
	document.all['isStandPrepareProcess'].value='<%=ShowConfBaseStationForm.TRUE_STR%>';
 	ShowConfBaseStationForm.submit();
}

function runSearchProcess() {
	document.all['isBaseStationCurComplectPrepareProcess'].value='<%=ShowConfBaseStationForm.TRUE_STR%>';
 	ShowConfBaseStationForm.submit();
}

</script>
