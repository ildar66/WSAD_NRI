<HTML>
<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.web.util.*, com.hps.july.basestation.formbean.*, com.hps.july.inventory.formbean.*, com.hps.july.inventory.valueobject.*"%>
<BODY onload="scrollFrame(); scrolling();" leftmargin=0 topmargin=0 onscroll="scrolling();">

<style>
TD.tableCell {
	text-align: center;
}
TD {
	border-style: solid; 
	border-color: green; 
	border-width: 1;
	valign: center;
}
TABLE.construct {
	border-style: solid; 
	border-color: green; 
	border-width: 1;
}
</style>

<script>
var xscroll=0;
var titleFrameName = "antennsTitleIFrame";

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

function notImplimented() {
	alert("Данный режим пока не реализован.");
}

function  submitAntennsContentForm() {
 	ConfigEqEditForm_AntennsContent.submit();
}

</script>

<july:editform action="/ShowCfgEditIFrameForm.do" styleId="ConfigEqEditForm_AntennsContent">
	<input type="hidden" name="partForSubmit" value="<%=ConfigEqEditForm.ANTENNS_CONTENT_PART%>"/>

<%
	String antennTRValues[] = {"T", "R", "D"};
	pageContext.setAttribute("antennTRValues", antennTRValues);
	String antennTRLabels[] = {"T", "R", "T/R"};
	pageContext.setAttribute("antennTRLabels", antennTRLabels);
%>

<%
	String antennImplValues[] = {"I", "O"};
	pageContext.setAttribute("antennImplValues", antennImplValues);
	String antennImplLabels[] = {"Indoor", "Outdoor"};
	pageContext.setAttribute("antennImplLabels", antennImplLabels);
%>

<%
	System.out.println("###### antenns 001");
  	ConfigEqEditForm configEqEditForm = (ConfigEqEditForm)request.getSession().getAttribute("ConfigEqEditForm");
	Integer antennsQuantity = configEqEditForm.getAntennsQuantity();
	AntennVO [] antennVOArray = configEqEditForm.getAntenns();
	System.out.println("###### antenns  002");
%>

<table width="1910" cellspacing="0" cellpadding="0" class="construct" style="font-family:tahoma,arial;font-size:8pt;">
	<%
		for (int i = 0; i < antennsQuantity.intValue(); i++) {
		System.out.println("###### 003 "+i);
		String inStore = "antenns["+i+"].inStore";
		String isDeleted = "antenns["+i+"].isDeleted";
		String typeId = "antenns["+i+"].typeId";
		String typeName = "antenns["+i+"].typeName";
		String partId = "antenns["+i+"].partId"; 
		String azimut = "antenns["+i+"].azimutStr"; 
		String height = "antenns["+i+"].heightStr"; 
		String maxPitch = "antenns["+i+"].maxPitchStr"; 
		String tr900 = "antenns["+i+"].tr900"; 
		// private String tr1800;
		String implementation = "antenns["+i+"].implementation"; 
		String sectors900 = "antenns["+i+"].sectors900"; 
		String sectors1800 = "antenns["+i+"].sectors1800"; 
		//
		String fiderType900Id = "antenns["+i+"].fiderType900Id"; 
		String fiderType900List = "antenns["+i+"].fiderType900List";
		String fiderType900Name = "antenns["+i+"].fiderType900Name"; 
		String fider900Length = "antenns["+i+"].fider900LengthStr"; 
		//
		String fiderType1800Id = "antenns["+i+"].fiderType1800Id"; 
		String fiderType1800List = "antenns["+i+"].fiderType1800List";
		String fiderType1800Name = "antenns["+i+"].fiderType1800Name"; 
		String fider1800Length = "antenns["+i+"].fider1800LengthStr"; 
		//
		String fiderKSVN900 = "antenns["+i+"].fiderKSVN900Str"; 
		String fiderKSVN1800 = "antenns["+i+"].fiderKSVN1800Str"; 
	%>
	<tr>
		<td valign="center" align="center">
			<A onclick="notImplimented();">
				<IMG SRC="/images/del2.gif" BORDER='0' ALT='Удалить строку'>
			</A>
		</td> 
		<td valign="center" align="center">
			<A onclick="notImplimented();">
				<IMG SRC="/images/copybtn.gif" BORDER='0' ALT='Копировать строку'>
			</A>
		</td> 
		<td valign="center" align="center">
			<logic:equal name="ConfigEqEditForm" property="<%=isDeleted%>" value="true">		
				<july:checkbox style="width:25px;" property="<%=inStore%>" insertable="true" updatable="true"
					onclick="submitAntennsContentForm();"
				/>
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
		<td align="center">
			<bean:write name="ConfigEqEditForm" property="<%=typeName%>" filter="true"/>
		</td> 
		<td align="center">
			<A onclick="notImplimented();">
				<IMG SRC="/images/blank_button.gif" BORDER='0' ALT='Очистить сектора'>
			</A>
		</td> 
		<td align="center">
			<july:radio style="width:25px;" property="<%=sectors900%>" insertable="true" updatable="true" value="O"
					onclick="submitAntennsContentForm();"
			/>O
		</td> 
		<td align="center">
			<july:radio style="width:25px;" property="<%=sectors900%>" insertable="true" updatable="true" value="E"
					onclick="submitAntennsContentForm();"
			/>E
		</td> 
		<td align="center">
			<july:radio style="width:25px;" property="<%=sectors900%>" insertable="true" updatable="true" value="F"
					onclick="submitAntennsContentForm();"
			/>F
		</td> 
		<td align="center">
			<july:radio style="width:25px;" property="<%=sectors900%>" insertable="true" updatable="true" value="G"
					onclick="submitAntennsContentForm();"
			/>G
		</td> 
		<td align="center">
			<july:radio style="width:25px;" property="<%=sectors900%>" insertable="true" updatable="true" value="H"
					onclick="submitAntennsContentForm();"
			/>H
		</td> 
		<td align="center">
			<july:radio style="width:25px;" property="<%=sectors1800%>" insertable="true" updatable="true" value="O"
					onclick="submitAntennsContentForm();"
			/>O
		</td> 
		<td align="center">
			<july:radio style="width:25px;" property="<%=sectors1800%>" insertable="true" updatable="true" value="A"
					onclick="submitAntennsContentForm();"
			/>A
		</td> 
		<td align="center">
			<july:radio style="width:25px;" property="<%=sectors1800%>" insertable="true" updatable="true" value="B"
					onclick="submitAntennsContentForm();"
			/>B
		</td> 
		<td align="center">
			<july:radio style="width:25px;" property="<%=sectors1800%>" insertable="true" updatable="true" value="C"
					onclick="submitAntennsContentForm();"
			/>C
		</td> 
		<td align="center">
			<july:radio style="width:25px;" property="<%=sectors1800%>" insertable="true" updatable="true" value="D"
					onclick="submitAntennsContentForm();"
			/>D
		</td> 
		<td align="center">
			<july:string style="width:80px;" size="5" property="<%=azimut%>" insertable="true" updatable="true"
					onchange="submitAntennsContentForm();"
			/>
		</td> 
		<td align="center">
			<july:string style="width:90px;" size="5" property="<%=height%>" insertable="true" updatable="true"
					onchange="submitAntennsContentForm();"
			/>
		</td> 
		<td align="center">
			<july:string style="width:70px;" size="5" property="<%=maxPitch%>" insertable="true" updatable="true"
					onchange="submitAntennsContentForm();"
			/>
		</td> 
		<td align="center">
			<july:select style="width:70px;" property="<%=tr900%>" 
				insertable="true" updatable="true"
					onchange="submitAntennsContentForm();"
				>
      				<html:options name="antennTRValues" labelName="antennTRLabels"/>
      		</july:select>		
		<td align="center">12</td> 
		<td align="center">
			<july:select style="width:90px;" property="<%=implementation%>" 
				insertable="true" updatable="true"
					onchange="submitAntennsContentForm();"
				>
      				<html:options name="antennImplValues" labelName="antennImplLabels"/>
      		</july:select>		
		<td align="center">
		<%--
			<bean:write name="ConfigEqEditForm" property="<%=fiderType900Name%>" filter="true"/>
		--%>	
			<july:select style="width:150px;" collection="<%=fiderType900List%>" property="<%=fiderType900Id%>" insertable="true" updatable="true"
					onchange="submitAntennsContentForm();"
			>
				<html:options collection="<%=fiderType900List%>" property="code" labelProperty="name"/>
			</july:select>
		</td> 
		<td align="center">
			<july:string style="width:80px;" size="5" property="<%=fider900Length%>" insertable="true" updatable="true"
					onchange="submitAntennsContentForm();"
			/>
		</td> 
		<td align="center">
		<%--
			<bean:write name="ConfigEqEditForm" property="<%=fiderType1800Name%>" filter="true"/>
		--%>	
			<july:select style="width:150px;" collection="<%=fiderType1800List%>" property="<%=fiderType1800Id%>" insertable="true" updatable="true"
					onchange="submitAntennsContentForm();"
			>
				<html:options collection="<%=fiderType1800List%>" property="code" labelProperty="name"/>
			</july:select>
		</td> 
		<td align="center">
			<july:string style="width:80px;" size="5" property="<%=fider1800Length%>" insertable="true" updatable="true"
					onchange="submitAntennsContentForm();"
			/>
		</td> 
		<td align="center">18</td> 
		<td align="center">
			<july:string style="width:80px;" size="5" property="<%=fiderKSVN900%>" insertable="true" updatable="true"
					onchange="submitAntennsContentForm();"
			/>
		</td> 
		<td align="center">
			<july:string style="width:80px;" size="5" property="<%=fiderKSVN1800%>" insertable="true" updatable="true"
					onchange="submitAntennsContentForm();"
			/>
		</td> 
	</tr>	
	<%
		} 
	%>
	<tr>
		<td width="30" align="center"></td> 
		<td width="30" align="center"></td> 
		<td width="30" align="center"></td> 
		<td width="30" align="center"></td> 
		<td width="30" align="center"></td> 
		<td width="160" align="center"></td> 
		<td width="30" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="70" align="center"></td> 
		<td width="80" align="center"></td> 
		<td width="90" align="center"></td> 
		<td width="70" align="center"></td> 
		<td width="70" align="center"></td> 
		<td width="90" align="center"></td> 
		<td width="150" align="center"></td> 
		<td width="80" align="center"></td> 
		<td width="150" align="center"></td> 
		<td width="80" align="center"></td> 
		<td width="50" align="center"></td> 
		<td width="80" align="center"></td> 
		<td width="80" align="center"></td> 
	</tr>	
</table>
</july:editform>
</BODY>
</HTML>



