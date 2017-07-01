<HTML>
<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.web.util.*, com.hps.july.basestation.formbean.*, com.hps.july.inventory.formbean.*, com.hps.july.inventory.valueobject.*"%>
<BODY onload="scrollFrame();" leftmargin=0 topmargin=0 onscroll="scrolling();">

<style>
TD.tableCell {
	text-align: center;
}
TD {
	border-style: solid; 
	border-color: green; 
	border-width: 1;
}
TABLE.construct {
	border-style: solid; 
	border-color: green; 
	border-width: 1;
}
</style>

<july:editform action="/ShowCfgEditIFrameForm.do" styleId="ConfigEqEditForm_TrxsContent">
<%--
	request.setAttribute("action", "Edit");
	pageContext.setAttribute("action", "Edit");

<input type="hidden" name="partForSubmit" value="<%=ConfigEqEditForm.STANDS_CONTENT_PART%>"/>
--%>

<script>
var xscroll=0; 
var titleFrameName = "trxsTitleIFrame";

function scrolling() 
{
	if (xscroll!=document.body.scrollLeft)
	{
	if (parent.document.frames[titleFrameName])
	parent.document.frames[titleFrameName].document.body.scrollLeft=document.body.scrollLeft;
	}
	xscroll=document.body.scrollLeft;
}

function scrollFrame()
{
	if (parent.document.frames[titleFrameName] && parent.document.readyState=="complete")
	 document.body.scrollLeft=parent.document.frames[titleFrameName].document.body.scrollLeft;
}

function  submitForm(theObject) {
	// alert("!!!!!!!!!!!!!!!!");
	ConfigEqEditForm_StandsContent.submit();
	/*
	var antennContForm = parent.document.frames["antennsContentIFrame"].document.ConfigEqEditForm_AntennsContent;
	// alert("antennContForm = "+antennContForm);
	antennContForm.submit();
	*/
}
</script>

<table  width="967" cellspacing="0" cellpadding="0" class="construct" style="font-family:tahoma,arial;font-size:8pt;">
	<tr>
		<td align="left">1</td> 
		<td align="left">2</td> 
		<td align="center">2'</td> 
		<td align="left">3</td> 
		<td align="left">4</td> 
		<td align="left">
				<july:select collection="standsProdusers" property="standsProduserId" insertable="true" updatable="true">
					<html:options collection="standsProdusers" property="code" labelProperty="name"/>
				</july:select>
		</td> 
		<td align="center">6</td> 
		<td align="center">7</td> 
		<td align="center">8</td> 
		<td align="center">9</td> 
		<td align="center">10</td> 
		<td align="center">11</td> 
		<td align="center">12</td> 
		<td align="center">13</td> 
		<td align="center">14</td> 
		<td align="center">15</td> 
		<td align="center">16</td> 
	</tr>	
	<tr>
		<td align="left">1</td> 
		<td align="left">2</td> 
		<td align="center">2'</td> 
		<td align="left">3</td> 
		<td align="left">4</td> 
		<td align="left">
				<july:select collection="standsProdusers" property="standsProduserId" insertable="true" updatable="true">
					<html:options collection="standsProdusers" property="code" labelProperty="name"/>
				</july:select>
		</td> 
		<td align="center">6</td> 
		<td align="center">7</td> 
		<td align="center">8</td> 
		<td align="center">9</td> 
		<td align="center">10</td> 
		<td align="center">11</td> 
		<td align="center">12</td> 
		<td align="center">13</td> 
		<td align="center">14</td> 
		<td align="center">15</td> 
		<td align="center">16</td> 
	</tr>	
	<tr>
		<td align="left">1</td> 
		<td align="left">2</td> 
		<td align="center">2'</td> 
		<td align="left">3</td> 
		<td align="left">4</td> 
		<td align="left">
				<july:select collection="standsProdusers" property="standsProduserId" insertable="true" updatable="true">
					<html:options collection="standsProdusers" property="code" labelProperty="name"/>
				</july:select>
		</td> 
		<td align="center">6</td> 
		<td align="center">7</td> 
		<td align="center">8</td> 
		<td align="center">9</td> 
		<td align="center">10</td> 
		<td align="center">11</td> 
		<td align="center">12</td> 
		<td align="center">13</td> 
		<td align="center">14</td> 
		<td align="center">15</td> 
		<td align="center">16</td> 
	</tr>	
	<%-- Это очень важные строки! Именно они форматируют эту таблицу! --%>
	<tr>
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="295" align="left"></td> 
		<td width="90" align="center"></td> 
		<td width="44" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="44" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
	</tr>	
</table>				
</july:editform>
<%--
<script>
	var antennContForm = parent.document.frames["antennsContentIFrame"].document.ConfigEqEditForm_AntennsContent;
	// alert("antennContForm = "+antennContForm);
	if (antennContForm) {
		antennContForm.submit();
	}
</script>
--%>
</BODY>
</HTML>
