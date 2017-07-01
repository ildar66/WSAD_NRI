<HTML>
<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.web.util.*, com.hps.july.inventory.formbean.*, com.hps.july.inventory.valueobject.*"%>
<BODY onload="scrollFrame();" leftmargin=0 topmargin=0 onscroll="scrolling();">

<style>
TD.tableCell {
	text-align: center;
}
TABLE.construct {
	border-style: solid; 
	border-color: red; 
	border-width: 0;
}
TD {
	border-style: solid; 
	border-color: yellow; 
	border-width: 0; 
}
</style>

<july:editform action="/ShowCfgEditIFrameForm.do" styleId="ConfigEqEditForm_StandsContent">
<%--
	request.setAttribute("action", "Edit");
	pageContext.setAttribute("action", "Edit");
--%>

<input type="hidden" name="partForSubmit" value="<%=ConfigEqEditForm.STANDS_CONTENT_PART%>"/>
<input type="hidden" name="curStandId" id="curStandId_inputId" value="<bean:write name="ConfigEqEditForm" property="curStandId" filter="true"/>"/>
<input type="hidden" name="deletedStandId" id="deletedStandId_inputId" value="<bean:write name="ConfigEqEditForm" property="deletedStandId" filter="true"/>"/>
<input type="hidden" name="standsQuantity" id="standsQuantity_inputId" value="<bean:write name="ConfigEqEditForm" property="standsQuantity" filter="true"/>"/>

<script>
var xscroll=0;
var titleFrameName = "standsTitleIFrame";

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

// function  submitForm(theObject) {
//	// alert("!!!!!!!!!!!!!!!!");
// 	ConfigEqEditForm_StandsContent.submit();
// }
function submitStandForm(theObject, stadnId) {
	var curStandId = document.getElementById("curStandId_inputId");
	// alert("stadnId = "+stadnId.value);
	curStandId.value = stadnId.value; 
	// submitForm(theObject);
	ConfigEqEditForm_StandsContent.submit();
}

function deleteStandForm(theObject, stadnId) {
	var deletedStandId = document.getElementById("deletedStandId_inputId");
	// alert("stadnId = "+stadnId.value);
	deletedStandId.value = stadnId.value; 
}

function notImplimented() {
	alert("Данный режим пока не реализован.");
}
function scrollToCurPartId(curPartId) {
	// alert("curPartId = "+curPartId);
	var curPartIdHidden = document.getElementById(curPartId);
	// alert("curPartIdHidden = "+curPartIdHidden);
	var theId =	curPartIdHidden.value; 
	// alert("theId = "+theId);
	var myAnchors = document.getElementsByTagName("a");
	for (i = 0; i < myAnchors.length; i++) {
		var theAnchor = myAnchors[i];
		// alert("theAnchor.name = " + theAnchor.name);
		// alert("theAnchor.offsetTop = " + theAnchor.offsetTop)
		if (theAnchor.name == theId) {
			// alert("goto " + theAnchor.name);
			// alert("theAnchor.offsetTop = " + theAnchor.offsetTop)
		   	// scrollTo(0, theAnchor.offsetTop);
			theAnchor.scrollIntoView(true);
			break;
		}
	}
}
</script>

<%
	System.out.println("###### 001");
  	ConfigEqEditForm configEqEditForm = (ConfigEqEditForm)request.getSession().getAttribute("ConfigEqEditForm");
	Integer standQuantity = configEqEditForm.getStandsQuantity();
	StandVO [] standVOArray = configEqEditForm.getStands();
	System.out.println("###### 002");
%>

<table  width="720" cellspacing="0" cellpadding="0" class="construct" style="font-family:tahoma,arial;font-size:8pt;">
	<%
		for (int i = 0; i < standVOArray.length; i++) {
		System.out.println("###### 003 "+i);
		String standsCollectionTypes = "stands["+i+"].types";
		String standsTypeId = "stands["+i+"].curTypeId";
		String standsNum = "stands["+i+"].number";
		String transQuant = "stands["+i+"].transQuant";
		String inStore = "stands["+i+"].inStore";
		String partId = "stands["+i+"].partId"; 
		String submitForm = "submitStandForm(this, standId"+i+"); ";
		String isDeleted = "stands["+i+"].isDeleted";
		String curState = "stands["+i+"].curState";
		String deleteStand = "deleteStandForm(this, standId"+i+"); ";
	%>
	<input type='hidden' name='standId<%=i%>' value='<bean:write name="ConfigEqEditForm" property="<%=partId%>" filter="true"/>'/>
	<%-- <input type='hidden' name='standId<%=i%>' property='<%=partId%>'/> --%>
	<tr>
		<td valign="center" align="center">
			<A name="<bean:write name="ConfigEqEditForm" property="<%=partId%>" filter="true"/>"></A>
			<A onclick="<%=deleteStand%> <%=submitForm%>">
			<logic:equal name="ConfigEqEditForm" property="<%=isDeleted%>" value="true">		
				<IMG SRC="/images/delconf.gif" BORDER='0' ALT='Удалить строку'>
			</logic:equal>		
			<logic:equal name="ConfigEqEditForm" property="<%=isDeleted%>" value="false">		
				<IMG SRC="/images/del2.gif" BORDER='0' ALT='Удалить строку'>
			</logic:equal>		
			</A>
		</td> 
		<td valign="center" align="center">
			<A onclick="notImplimented();">
				<IMG SRC="/images/copybtn.gif" BORDER='0' ALT='Копировать строку'>
			</A>
		</td> 
		<td valign="center" align="center">
			<logic:equal name="ConfigEqEditForm" property="<%=isDeleted%>" value="true">		
				<july:checkbox property="<%=inStore%>" insertable="true" updatable="true" onclick="<%=submitForm%>"/>
			</logic:equal>		
		</td> 
		<td valign="center" align="center">
			<A onclick="notImplimented();">
				<IMG SRC="/images/info_empty.gif" BORDER='0' ALT='Информация (пустой блок)'>
			</A>
		</td> 
		<td valign="center" align="center">
			<A onclick="notImplimented();">
				<IMG SRC="/images/ser_calc.gif" BORDER='0' ALT='Серийный учет'>
			</A>
		</td> 
		<td colspan="2" align="center">
			<july:select style="width:300px;" collection="<%=standsCollectionTypes%>" property="<%=standsTypeId%>" insertable="true" updatable="true" onchange="<%=submitForm%>">
				<html:options collection="<%=standsCollectionTypes%>" property="code" labelProperty="name"/>
			</july:select>
		<%--
			<july:select collection="<%=standsCollectionTypes%>" property="<%=standsTypeId%>" insertable="true" updatable="true">
				<html:options collection="<%=standsCollectionTypes%>" property="code" labelProperty="name"/>
			</july:select>
		--%>	
		</td> 
		<td align="center">
			<july:string style="width:70px;" size="10" property="<%=standsNum%>" insertable="true" updatable="true" onchange="<%=submitForm%>"/>
		<%--
			<july:string size="10" property="<%=standsNum%>" insertable="true" updatable="true"/>
		--%>	
		</td> 
		<td align="center">
			<bean:write name="ConfigEqEditForm" property="<%=transQuant%>" filter="true"/>
			#
			<bean:write name="ConfigEqEditForm" property="<%=curState%>" filter="true"/>
		</td> 
	</tr>	
	<%
		} 
	%>
	<tr>
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="35" align="left"></td> 
		<td width="293" align="left"></td> 
		<td width="90" align="center"></td> 
		<td width="150" align="center"></td> 
	</tr>	
</table>				

</july:editform>
<script>
<%--
	if (parent.document.frames["antennsContentIFrame"]) {
		var antennContForm = parent.document.frames["antennsContentIFrame"].document.ConfigEqEditForm_AntennsContent;
		// alert("antennContForm = "+antennContForm);
		if (antennContForm) {
			antennContForm.submit();
		}
	}
--%>
// scroll to cur stand
scrollToCurPartId("curStandId_inputId");
// корректировка количества шкафов
var standsQuantity_text = parent.document.frames["standsTitleIFrame"].document.getElementById("standsQuantity_text_id");
// alert("standsQuantity_text = "+standsQuantity_text);
if (standsQuantity_text) {
	var standsQuantity = document.getElementById("standsQuantity_inputId");
	// alert("standsQuantity = "+standsQuantity);
	if (standsQuantity) {
		standsQuantity_text.value = standsQuantity.value;
	}
}
</script>
</BODY>
</HTML>
