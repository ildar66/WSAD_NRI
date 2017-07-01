<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.dictionary.formbean.*"%>
<SCRIPT language=javascript src="/scripts/string_format.js" type="text/javascript"></SCRIPT>  
<%
	String gColSpan = "7";
	String maxWidth = "735";
	String paramTextLength = "50";
	String enterValueStr = "Ввод значения:";
	String contentIFrameHeight = "160";
%>

<%
	// проверяем в каком режиме вызвана страница
	String action = ConfPowerSourcesForm.getActionString(session);
	String form = ConfPowerSourcesForm.getFormString(session); 
%> 
<!-- action="<%=action%>" styleId="<%=form%>" -->
<july:editform action="<%=action%>" styleId="<%=form%>">

<html:hidden property="submitMode" value="<%=ConfPowerSourcesForm.MAIN_SUBMIT_MODE%>"/>
<html:hidden property="isModelFiltersProcess"/>
<html:hidden property="isComplectSelectProcess"/>
<html:hidden property="curResourceSelectedID"/>

<table class="main"  id="mainTableID">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>" width="<%=maxWidth%>">
	<table class="main" id="searchTableID" border="0"> 
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">&nbsp;&nbsp;&nbsp;
			<bean:write name="<%=form%>" property="searchLabel" filter="true"/>	
		</td>
	</tr>
	<tr class="normal">
		<td class="title" nowrap width="210" valign="middle">Поиск по:&nbsp;
			<july:select collection="searchParameterList" property="searchParameterName" styleId="searchParameterNameSelectId" 
						style="font-size:8pt;width=120px" insertable="false" updatable="false"
						onchange="searchParamChange();">
					<html:options collection="searchParameterList" property="key" labelProperty="value"/>						
      		</july:select>		
      	</td>
      	<td class="title" align="left" width="500">
      	<div id="nfsDivId" style="display:'block';">
      		<%=enterValueStr%>&nbsp;<html:text property="nfsCodeSearchParam" size="<%=paramTextLength%>"
      									styleId="nfsCodeSearchParamId" onkeypress="searchByEnter();"/>
      	</div>	
      	<div id="codeCmplDivId" style="display:'none';">
      		<%=enterValueStr%>&nbsp;<html:text property="cmplCodeSearchParam" size="<%=paramTextLength%>"
      									styleId="cmplCodeSearchParamId" onkeypress="searchByEnter();"/>
      	</div>	 
      	<div id="modelDivId" style="display:'none';">Подстрока поиска:&nbsp;
					<html:text property="filterModelParam" size="10" styleId="filterModelParamId" onkeypress="searchModelByEnter();"/>
					<A onclick="runFilterModelProcess();">
							<IMG SRC="/images/filter_06.gif" BORDER='0' ALT='Фильтровать типы'>
					</A>
					<br><%=enterValueStr%>&nbsp;
			<july:select collection="modelsList" property="modelCodeSearchParam" styleId="modelCodeSearchParamId" 
						style="font-size:8pt;width=350px" insertable="false" updatable="false" onkeypress="searchByEnter();">
					<html:options collection="modelsList" property="key" labelProperty="value"/>						
      		</july:select>		
      	</div>	
      	<div id="titleCmplDivId" style="display:'none';">
      		<%=enterValueStr%>&nbsp;<html:text property="titleSearchParam" size="<%=paramTextLength%>"
      									styleId="titleSearchParamId" onkeypress="searchByEnter();"/>
      	</div>	 
      	</td>
      	<td align="right" class="normal" width="20">
			<A HREF="#">
					<IMG SRC="/images/refresh.gif" BORDER="0" ALT="Поиск" onclick="runSearchProcess();"/>
			</A>
      	</td>
	</tr>
	<%-- нужно для одинакового выравнивания таблиц --%>
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

<TR class="normal">
 <TD colspan="<%= gColSpan %>" width="<%=maxWidth%>">
	<table class="main" id="curCmplTableID"> 
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">&nbsp;&nbsp;&nbsp;
			<bean:write name="<%=form%>" property="complectLabel" filter="true"/>	
		</td>
	</tr>
	<tr class="normal">
		<td width = "100%" class="normal" >
			<iframe width="<%=maxWidth%>" MARGINWIDTH="0" MARGINHEIGHT="0" 
				ALIGN="top" frameborder="1" name="curCmplTitleIFrame" 
				height="42" src="curCmplPwSrcTitle.jsp?<%=ConfPowerSourcesForm.getUniqueMockParams()%>" SCROLLING="no" >
			</iframe>
		</td>
	</tr>
	<tr class="normal">
		<td width = "100%" class="normal" >
			<iframe width="<%=maxWidth%>" MARGINWIDTH="0" MARGINHEIGHT="0" 
				ALIGN="top" frameborder="1" name="curCmplIFrame" 
				height="<%=contentIFrameHeight%>" src="curCmplPwSrc.jsp?<%=ConfPowerSourcesForm.getUniqueMockParams()%>" SCROLLING="auto" >
			</iframe>
		</td>
	</tr>
	</table>
 </TD>	
</TR>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>" width="<%=maxWidth%>">
	<table class="main" id="strucTableID"> 
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">&nbsp;&nbsp;&nbsp;
			<bean:write name="<%=form%>" property="structLabel" filter="true"/>	
		</td>
	</tr>
	<tr class="normal">
		<td width = "100%" class="normal" >
			<iframe width="<%=maxWidth%>" MARGINWIDTH="0" MARGINHEIGHT="0" 
				ALIGN="top" frameborder="1" name="strucTitleIFrame" 
				height="42" src="strucPwSrcTitle.jsp?<%=ConfPowerSourcesForm.getUniqueMockParams()%>" SCROLLING="no" >
			</iframe>
		</td>
	</tr>
	<tr class="normal">
		<td width = "100%" class="normal" >
			<iframe width="<%=maxWidth%>" MARGINWIDTH="0" MARGINHEIGHT="0" 
				ALIGN="top" frameborder="1" name="strucIFrame" 
				height="<%=contentIFrameHeight%>" src="strucPwSrc.jsp?<%=ConfPowerSourcesForm.getUniqueMockParams()%>" SCROLLING="auto" >
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

function getKey() {
    if (document.layers) {
        Key = e.which;
    } else {
        Key = window.event.keyCode;
    }
    return Key;
}    

function searchModelByEnter() {
	Key = getKey();
    if (Key == 13) {
		runFilterModelProcess();
    }
}

function searchByEnter(e) {
	Key = getKey();
    if (Key == 13) {
		runSearchProcess();
    }
}

 function runSearchProcess() {
 	// alert("runSearchProcess");
	var paramName = getSearchParamName();
 	if (paramName=="<%=ConfPowerSourcesForm.SRC_NFS%>") {
	 	var nfsCodeSearchParamValue = document.all['nfsCodeSearchParamId'].value;
		if (nfsCodeSearchParamValue.length == 0) {
			alert("Введите строку поиска!");
	 		return false;
		}
 	}
 	// проверяем если это код комплекта, тогда только цифры
 	if (paramName=="<%=ConfPowerSourcesForm.SRC_CMPL%>") {
	 	var cmplCodeSearchParamValue = document.all['cmplCodeSearchParamId'].value;
		if (cmplCodeSearchParamValue.length == 0) {
			alert("Введите строку поиска!");
	 		return false;
		}
		if (numericStr(cmplCodeSearchParamValue) == false) {
			alert("Код комплекта должен быть целым числом!");
		 	return false;
		}
 	}
 	// для наименования
 	if (paramName=="<%=ConfPowerSourcesForm.CMPL_TITLE%>") {
	 	var titleSearchParamValue = document.all['titleSearchParamId'].value;
		if (titleSearchParamValue.length == 0) {
			alert("Введите строку поиска!");
	 		return false;
		}
 	}
 	document.all['isComplectSelectProcess'].value='<%=ConfPowerSourcesForm.TRUE_STR%>';
 	<%=form%>.submit();
 }
 
 function searchParamChange() {
 	// alert("searchParamChange");
	var paramName = getSearchParamName();
 	// alert(paramName);
 	searchDivProcess(paramName);
 }

 function getSearchParamName() {
 	var searchParamBox = document.all['searchParameterNameSelectId'];
	var paramName = searchParamBox.options[searchParamBox.selectedIndex].value;
	return paramName;
 }
 function searchDivProcess(paramName) {
 	// alert(paramName);
 	if (paramName=="<%=ConfPowerSourcesForm.SRC_NFS%>") {
 		document.all['nfsDivId'].style.display = 'block';
 		document.all['codeCmplDivId'].style.display = 'none';
 		document.all['modelDivId'].style.display = 'none';
 		document.all['titleCmplDivId'].style.display = 'none';
 	}
 	if (paramName=="<%=ConfPowerSourcesForm.SRC_CMPL%>") {
 		document.all['nfsDivId'].style.display = 'none';
 		document.all['codeCmplDivId'].style.display = 'block';
 		document.all['modelDivId'].style.display = 'none';
 		document.all['titleCmplDivId'].style.display = 'none';
 	}
 	if (paramName=="<%=ConfPowerSourcesForm.SRC_MODEL%>") {
 		document.all['nfsDivId'].style.display = 'none';
 		document.all['codeCmplDivId'].style.display = 'none';
 		document.all['modelDivId'].style.display = 'block';
 		document.all['titleCmplDivId'].style.display = 'none';
 	}
 	if (paramName=="<%=ConfPowerSourcesForm.CMPL_TITLE%>") {
 		document.all['nfsDivId'].style.display = 'none';
 		document.all['codeCmplDivId'].style.display = 'none';
 		document.all['modelDivId'].style.display = 'none';
 		document.all['titleCmplDivId'].style.display = 'block';
 	}
 }
 function runFilterModelProcess() {
 	// alert("runFilterModelProcess()");
	document.all['isModelFiltersProcess'].value='<%=ConfPowerSourcesForm.TRUE_STR%>';
	// alert(document.all['isModelFiltersProcess'].value);
 	<%=form%>.submit();
 }

searchParamChange();

</script>
 