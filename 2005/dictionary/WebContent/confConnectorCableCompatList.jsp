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
	String maxWidth = "735"; // "745"; // "735";
	String searchMaxWidth = "750"; // "735";
	String paramTextLength = "46"; // "50"; // "47";
	String enterValueStr = "Значение:";
	String contentIFrameHeight = "113"; // "110"; // "100"; // "79"; // "160";
%>

	<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
	<SCRIPT language=javascript src="/common/exitFromNRI.js" type="text/javascript"></SCRIPT>  

<july:editform action="ShowConfConnectorCableCompat" styleId="ShowConfConnectorCableCompatForm">

<html:hidden property="isConnectorSelectProcess" value="<%=ShowConfConnectorCableCompatForm.FALSE_STR%>"/> 
<html:hidden property="isCableSelectProcess" value="<%=ShowConfConnectorCableCompatForm.FALSE_STR%>"/> 
<html:hidden property="curConnectorSelectedID"/>
<html:hidden property="curCableSelectedID"/>
<html:hidden property="isSetNewCompat" value="<%=ShowConfConnectorCableCompatForm.FALSE_STR%>"/> 

<html:hidden property="isDeleteResCompat" value="<%=ShowConfConnectorCableCompatForm.FALSE_STR%>"/> 
<html:hidden property="selectedCompatRes1" value="<%=ShowConfConnectorCableCompatForm.BEGIN_ID_INDEX%>"/> 
<html:hidden property="selectedCompatRes2" value="<%=ShowConfConnectorCableCompatForm.BEGIN_ID_INDEX%>"/> 

<table class="main"  id="mainTableID">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>" width="<%=searchMaxWidth%>">
	<table class="main" width="<%=searchMaxWidth%>" id="searchTableID" style='table-layout: fixed;' border="0"> 
	<tr class="title">
		<td class="title" align="left" nowrap width="75" >Разъемы</td>
		<td class="title" nowrap width="235" valign="middle">Поиск по:&nbsp;
			<july:select property="searchConnectorParameterName" styleId="searchConnectorParameterNameSelectId" 
						style="font-size:8pt;width=150px" insertable="false" updatable="false"
						onchange="searchConnectorParamChange();">
      				<html:option value="1">коду NRI</html:option>
      				<html:option value="2">коду НФС</html:option>
      				<html:option value="3">модели</html:option>
      				<html:option value="4">признаку активности</html:option>
      		</july:select>		
      	</td>
      	<td class="title" align="left" width="390">
      	<div id="nriConnectorDivId" style="display:'block';">
      		<%=enterValueStr%>&nbsp;<html:text property="nriCodeConnectorSearchParam" size="<%=paramTextLength%>"
      									styleId="nriCodeConnectorSearchParamId" 
										onkeypress="searchConnectorByEnter();"
      									/>
      	</div>	
      	<div id="nfsConnectorDivId" style="display:'none';">
      		<%=enterValueStr%>&nbsp;<html:text property="nfsCodeConnectorSearchParam" size="<%=paramTextLength%>"
      									styleId="nfsCodeConnectorSearchParamId" 
										onkeypress="searchConnectorByEnter();"
      									/>
      	</div>	
      	<div id="modelConnectorDivId" style="display:'none';">
      		<%=enterValueStr%>&nbsp;<html:text property="modelConnectorSearchParam" size="<%=paramTextLength%>"
      									styleId="modelConnectorSearchParamId" 
										onkeypress="searchConnectorByEnter();"
      									/>
      	</div>	
      	<div id="activeConnectorDivId" style="display:'none';">
      		<%=enterValueStr%>&nbsp;
			<july:select property="activeConnectorSearchParam" styleId="activeConnectorSearchParamId" 
					style="font-size:8pt;width=300" insertable="false" updatable="false"
					>
      				<html:option value="<%=ShowConfConnectorCableCompatForm.ACTIVE_SEARCH_VALUE%>">Активные</html:option>
      				<html:option value="<%=ShowConfConnectorCableCompatForm.NOT_ACTIVE_SEARCH_VALUE%>">Неактивные</html:option>
      				<html:option value="<%=ShowConfConnectorCableCompatForm.ALL_SEARCH_VALUE%>">Все</html:option>
      		</july:select>		
      	</div>	 
      	</td>
      	<td align="right" class="normal" width="30">
			<A HREF="#"><IMG SRC="/images/refresh.gif" BORDER="0" ALT="Поиск" 
				onclick="runConnectorSearchProcess();"/></A>
      	</td>
	</tr>
	</table>
 </TD>	
</TR>

<TR class="normal">
 <TD colspan="<%= gColSpan %>" width="<%=maxWidth%>">
	<table class="main" id="curCmplTableID"> 
	<tr class="normal">
		<td width = "100%" class="normal" >
			<iframe width="<%=maxWidth%>" MARGINWIDTH="0" MARGINHEIGHT="0" 
				ALIGN="top" frameborder="1" name="curCmplTitleIFrame" 
				height="26" src="connectorTitle.jsp?<%=ConfPowerSourcesForm.getUniqueMockParams()%>" SCROLLING="no" >
			</iframe>
		</td>
	</tr>
	<tr class="normal">
		<td width = "100%" class="normal" >
			<iframe width="<%=maxWidth%>" MARGINWIDTH="0" MARGINHEIGHT="0" 
				ALIGN="top" frameborder="1" name="curCmplIFrame" 
				height="<%=contentIFrameHeight%>" 
				src="connectorList.jsp?<%=ConfPowerSourcesForm.getUniqueMockParams()%>" SCROLLING="auto" >
			</iframe>
		</td>
	</tr>
	</table>
 </TD>	
</TR>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>" width="<%=searchMaxWidth%>">
	<table class="main" width="<%=searchMaxWidth%>" style='table-layout: fixed;' id="searchTableID" border="0">
	<tr class="title">
		<td class="title" align="left" nowrap width="75">Кабели</td>
		<td class="title" nowrap width="235" valign="middle">Поиск по:&nbsp;
			<july:select property="searchCableParameterName" styleId="searchCableParameterNameSelectId" 
						style="font-size:8pt;width=150px" insertable="false" updatable="false"
						onchange="searchCableParamChange();">
      				<html:option value="1">коду NRI</html:option>
      				<html:option value="2">коду НФС</html:option>
      				<html:option value="3">модели</html:option>
      				<html:option value="5">диаметру</html:option>
      				<html:option value="4">признаку активности</html:option>
      		</july:select>		
      	</td>
      	<td class="title" align="left" width="390">
      	<div id="nriCableDivId" style="display:'block';">
      		<%=enterValueStr%>&nbsp;<html:text property="nriCodeCableSearchParam" size="<%=paramTextLength%>"
      									styleId="nriCodeCableSearchParamId" onkeypress="searchCableByEnter();"/>
      	</div>	
      	<div id="nfsCableDivId" style="display:'none';">
      		<%=enterValueStr%>&nbsp;<html:text property="nfsCodeCableSearchParam" size="<%=paramTextLength%>"
      									styleId="nfsCodeCableSearchParamId" 
										onkeypress="searchCableByEnter();"
      									/>
      	</div>	
      	<div id="modelCableDivId" style="display:'none';">
      		<%=enterValueStr%>&nbsp;<html:text property="modelCableSearchParam" size="<%=paramTextLength%>"
      									styleId="modelCableSearchParamId" 
										onkeypress="searchCableByEnter();"
      									/>
      	</div>	
      	<div id="activeCableDivId" style="display:'none';">
      		<%=enterValueStr%>&nbsp;
			<july:select property="activeCableSearchParam" styleId="activeCableSearchParamId" 
					style="font-size:8pt;width=300" insertable="false" updatable="false"
					>
      				<html:option value="<%=ShowConfConnectorCableCompatForm.ACTIVE_SEARCH_VALUE%>">Активные</html:option>
      				<html:option value="<%=ShowConfConnectorCableCompatForm.NOT_ACTIVE_SEARCH_VALUE%>">Неактивные</html:option>
      				<html:option value="<%=ShowConfConnectorCableCompatForm.ALL_SEARCH_VALUE%>">Все</html:option>
      		</july:select>		
      	</div>	 
      	<div id="diamCableDivId" style="display:'none';">
			<%=enterValueStr%>&nbsp;
			<july:select collection="diamsList" property="diamCableCodeSearchParam" styleId="diamCableCodeSearchParamId" 
						style="font-size:8pt;width=300px" insertable="false" updatable="false" onkeypress="searchByEnter();">
					<html:options collection="diamsList" property="key" labelProperty="value"/>						
      		</july:select>		
      	</div>	
      	</td>
      	<td align="left" class="normal" width="30">
      		<A HREF="#"><IMG SRC="/images/refresh.gif" BORDER="0" ALT="Поиск" 
      			onclick="runCableSearchProcess();"/></A>
      	</td>
	</tr>
	</table>
 </TD>	
</TR>

<TR class="normal">
 <TD colspan="<%= gColSpan %>" width="<%=maxWidth%>">
	<table class="main" id="strucTableID"> 
	<tr class="normal">
		<td width = "100%" class="normal" >
			<iframe width="<%=maxWidth%>" MARGINWIDTH="0" MARGINHEIGHT="0" 
				ALIGN="top" frameborder="1" name="connectorTitleIFrame" 
				height="26" src="cableTitle.jsp?<%=ConfPowerSourcesForm.getUniqueMockParams()%>" SCROLLING="no" >
			</iframe>
		</td>
	</tr>
	<tr class="normal">
		<td width = "100%" class="normal" >
			<iframe width="<%=maxWidth%>" MARGINWIDTH="0" MARGINHEIGHT="0" 
				ALIGN="top" frameborder="1" name="connectorIFrame" 
				height="<%=contentIFrameHeight%>" src="cableCompatList.jsp?<%=ConfPowerSourcesForm.getUniqueMockParams()%>" SCROLLING="auto" >
			</iframe>
		</td>
	</tr>
	</table>
 </TD>	
</TR>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>" width="<%=maxWidth%>">

	<table class="main" width="<%=maxWidth%>" id="strucCompatibilityTableID" style='table-layout: fixed;' border="0"> 
	<tr class="title"> 
		<td class="title" width="125" align="left">Совместимость</td>
		<td width = "608" class="normal">
			<iframe width="608" MARGINWIDTH="0" MARGINHEIGHT="0" 
				ALIGN="top" frameborder="1" name="compatibilityTitleIFrame" 
				height="26" src="compatibilityTitle.jsp?<%=ConfPowerSourcesForm.getUniqueMockParams()%>" SCROLLING="no" >
			</iframe>
		</td>
	</tr> 
	<tr class="normal">
		<td width = "125" class="normal" align="center" valign="middle">
      	<div id="notNewCompatDivId" style="display:'block';">
			&nbsp;
      	</div>
      	<div id="newCompatDivId" style="display:'none';">
			<A HREF="#"><IMG SRC="/images/compatibility.gif" 
      		BORDER="0" ALT="Установить взаимосвязь" onclick="setCompatability();"/></A>
      	</div>
		</td>
		<td width = "608" class="normal"> 
			<iframe width="608" MARGINWIDTH="0" MARGINHEIGHT="0" 
				ALIGN="top" frameborder="1" name="compatibilityIFrame" 
				height="<%=contentIFrameHeight%>" src="compatibilityList.jsp?<%=ConfPowerSourcesForm.getUniqueMockParams()%>" SCROLLING="auto" >
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

  function setCompatability() {
  	// alert("setCompatability");
	document.all['isSetNewCompat'].value = <%=ShowConfConnectorCableCompatForm.TRUE_STR%>;
	ShowConfConnectorCableCompatForm.submit();  	
  }

  function searchConnectorParamChange() {
	var paramName = getSearchParamName('searchConnectorParameterNameSelectId');
 	searchConnectorDivProcess(paramName);
  }

 function getSearchParamName(paramNameId) {
 	var searchParamBox = document.all[paramNameId];
	var paramName = searchParamBox.options[searchParamBox.selectedIndex].value;
	return paramName;
 }

 function searchConnectorDivProcess(paramName) {
 	if (paramName=="1") {
 		document.all['nriConnectorDivId'].style.display = 'block';
 		document.all['nfsConnectorDivId'].style.display = 'none';
 		document.all['modelConnectorDivId'].style.display = 'none';
 		document.all['activeConnectorDivId'].style.display = 'none';
 	}
 	if (paramName=="2") {
 		document.all['nriConnectorDivId'].style.display = 'none';
 		document.all['nfsConnectorDivId'].style.display = 'block';
 		document.all['modelConnectorDivId'].style.display = 'none';
 		document.all['activeConnectorDivId'].style.display = 'none';
 	}
 	if (paramName=="3") {
 		document.all['nriConnectorDivId'].style.display = 'none';
 		document.all['nfsConnectorDivId'].style.display = 'none';
 		document.all['modelConnectorDivId'].style.display = 'block';
 		document.all['activeConnectorDivId'].style.display = 'none';
 	}
 	if (paramName=="4") {
 		document.all['nriConnectorDivId'].style.display = 'none';
 		document.all['nfsConnectorDivId'].style.display = 'none';
 		document.all['modelConnectorDivId'].style.display = 'none';
 		document.all['activeConnectorDivId'].style.display = 'block';
 	}
 }

  function searchCableParamChange() {
	var paramName = getSearchParamName('searchCableParameterNameSelectId');
 	searchCableDivProcess(paramName);
  }

 function searchCableDivProcess(paramName) {
 	if (paramName=="1") {
 		document.all['nriCableDivId'].style.display = 'block';
 		document.all['nfsCableDivId'].style.display = 'none';
 		document.all['modelCableDivId'].style.display = 'none';
 		document.all['activeCableDivId'].style.display = 'none';
 		document.all['diamCableDivId'].style.display = 'none';
 	}
 	if (paramName=="2") {
 		document.all['nriCableDivId'].style.display = 'none';
 		document.all['nfsCableDivId'].style.display = 'block';
 		document.all['modelCableDivId'].style.display = 'none';
 		document.all['activeCableDivId'].style.display = 'none';
 		document.all['diamCableDivId'].style.display = 'none';
 	}
 	if (paramName=="3") {
 		document.all['nriCableDivId'].style.display = 'none';
 		document.all['nfsCableDivId'].style.display = 'none';
 		document.all['modelCableDivId'].style.display = 'block';
 		document.all['activeCableDivId'].style.display = 'none';
 		document.all['diamCableDivId'].style.display = 'none';
 	}
 	if (paramName=="4") {
 		document.all['nriCableDivId'].style.display = 'none';
 		document.all['nfsCableDivId'].style.display = 'none';
 		document.all['modelCableDivId'].style.display = 'none';
 		document.all['activeCableDivId'].style.display = 'block';
 		document.all['diamCableDivId'].style.display = 'none';
 	} 
 	if (paramName=="5") {
 		document.all['nriCableDivId'].style.display = 'none';
 		document.all['nfsCableDivId'].style.display = 'none';
 		document.all['modelCableDivId'].style.display = 'none';
 		document.all['activeCableDivId'].style.display = 'none';
 		document.all['diamCableDivId'].style.display = 'block';
 	}
 }

  function runConnectorSearchProcess() {
  	return checkAndSubmit('Connector');
  }

  function checkAndSubmit(prefix) {
	var paramName = getSearchParamName('search'+prefix+'ParameterNameSelectId');
 	if (paramName=="1") {
	 	var nriCodeSearchParamValue = document.all['nriCode'+prefix+'SearchParam'].value;
		if (nriCodeSearchParamValue.length == 0) {
			alert("Введите строку поиска!");
	 		return false;
		}
		if (numericStr(nriCodeSearchParamValue) == false) {
			alert("Код NRI должен быть целым числом!");
		 	return false;
		}
 	}
 	if (paramName=="2") {
	 	var nfsCodeSearchParamValue = document.all['nfsCode'+prefix+'SearchParam'].value;
		if (nfsCodeSearchParamValue.length == 0) {
			alert("Введите строку поиска!");
	 		return false;
		}
 	}
 	if (paramName=="3") {
	 	var modelSearchParamValue = document.all['model'+prefix+'SearchParam'].value;
		if (modelSearchParamValue.length == 0) {
			alert("Введите строку поиска!");
	 		return false;
		}
 	}
 	document.all['is'+prefix+'SelectProcess'].value='<%=ConfPowerSourcesForm.TRUE_STR%>';
 	ShowConfConnectorCableCompatForm.submit();
  }

  function runCableSearchProcess() {
  	return checkAndSubmit('Cable');
  }

  function searchCableByEnter() {
	Key = getKey();
    if (Key == 13) {
		runCableSearchProcess();    
    }
  }

  function searchConnectorByEnter() {
	Key = getKey();
    if (Key == 13) {
		runConnectorSearchProcess();    
    }
  }

  function getKey() {
    if (document.layers) {
        Key = e.which;
    } else {
        Key = window.event.keyCode;
    }
    return Key;
  }    
    
// начальные установки
searchConnectorParamChange();
searchCableParamChange();
    
</script>
 
 
