<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.formbean.FactBaseStationForm" %>
<%@ page import="com.hps.july.basestation.formbean.AntennaSectorListForm" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport"%>
<%@ page import="com.hps.july.persistence.AntennaAccessBean"%>
<%@ page import="com.hps.july.basestation.valueobject.AntennaObject"%>
<%@ page import="com.hps.july.apptags.HasRegionAccessTag"%>
<%@ page import="com.hps.july.apptags.HasAccessTag"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>

<%
	String colspan;
	String bscodeFrm = "";

	boolean canEditRole=false;
	boolean canEdit=false;

	String add_link=null;
	String del_link=null;
	String edit_link=null;
	String proc_link=null;

	String formname = "";

	if(session.getAttribute("returnFormName")!=null)
	{
		colspan="12";

		if(session.getAttribute("returnFormName").equals("FactBaseStationForm")){
			formname = "FactBaseStationForm";
			FactBaseStationForm frm = (FactBaseStationForm)session.getAttribute(formname);
			bscodeFrm = String.valueOf(frm.getBasestation());
			add_link="/EditAntenna_FBS.do?action=Add&bscodeFrm="+bscodeFrm.trim();
			del_link="/EditAntenna_FBS.do?action=Delete";
			edit_link="/EditAntenna_FBS.do";
			proc_link="/ProcessAntenna_FBS.do";
			canEdit = true; //frm.canEdit();
		} else if(session.getAttribute("returnFormName").equals("AntennaSectorListForm")) {
			formname = "AntennaSectorListForm";
			AntennaSectorListForm frm = (AntennaSectorListForm)session.getAttribute(formname);
			bscodeFrm = String.valueOf(frm.getBsForm().getBasestation());
			add_link="/EditAntenna_E.do?action=Add&bscodeFrm="+bscodeFrm.trim();
			del_link="/EditAntenna_E.do?action=Delete";
			edit_link="/EditAntenna_E.do";
			proc_link="/ProcessAntenna_E.do";
			canEdit = true; //frm.canEdit();
		}
		canEditRole=HasAccessTag.hasAccess(pageContext,proc_link);
		canEdit = canEdit && canEditRole;
	} else {
		colspan="10";
	}
%>

<table class="main" id="brtable">

<tr class="title">
<td class="title" colspan=<%=colspan%>>

<%if(canEdit){%>
<html:link page="<%=add_link%>">
<IMG alt='<bean:message key="label.add"/>' src="/images/plus.gif" border=0/>
</html:link>
<%}%>
&nbsp;&nbsp;<bean:message key="label.antennes"/>
</td>
</tr>


<tr class="title">
	<logic:present name="returnFormName">
		<td>&nbsp;</td>
	</logic:present>
	<july:headercolumn key="Antenna.number" colType="string"/>
	<july:headercolumn key="Antenna.type" colType="string"/>
	<july:headercolumn key="Antenna.asim" colType="string"/>
	<july:headercolumn key="Antenna.nakl" colType="string"/>
	<july:headercolumn key="Antenna.higth" colType="string"/>
	<july:headercolumn bundle="dictionaryResources" key="label.antena.dir" colType="string"/>
	<july:headercolumn key="Antenna.ky" colType="string"/>
	<july:headercolumn key="Antenna.boand" colType="string"/>
	<july:headercolumn key="Antenna.direct" colType="string"/>
	<july:headercolumn key="Antenna.letters" colType="string"/>
	<logic:present name="returnFormName">
		<td>&nbsp;</td>
	</logic:present>
</tr>

<logic:iterate id="ant" name="<%=formname%>" property="antennes">
<logic:present name="ant">
<%
	AntennaObject bean=null;
	bean=new AntennaObject(((AntennaAccessBean) pageContext.getAttribute("ant")).getEJBRef());
%>

<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<logic:present name="returnFormName">
	<td class="link">
	<%if(canEdit){%>
		<july:editbutton page="<%=edit_link%>" action="Edit" paramId="idanten" paramName="ant" paramProperty="idanten" />
	<%}else{%>
		<july:editbutton page="<%=edit_link%>" action="View" paramId="idanten" paramName="ant" paramProperty="idanten" />
	<%}%>
	</td>
	</logic:present>

	<td class="number">
		<logic:present name="ant" property="numant"><bean:write name="ant" property="numant" filter="true"/></logic:present>
	</td>
	<td class="text">
		<%=bean.getResource()!=null&&bean.getResource().getModel()!=null?bean.getResource().getModel():""%>
	</td>
	<td class="number">
		<logic:present name="ant" property="azant"><july:numberwrite name="ant" property="azant" /></logic:present>
	</td>
<%--мех наклон--%>
	<td class="text">
		<july:numberwrite name="ant" property="nakl" />
	</td>
<%--высота подвеса--%>
	<td class="text">
		<july:numberwrite name="ant" property="hset1" />
	</td>
<%--диаграмма направленности--%>
	<td class="text"><%=bean.getWidthDiagram()%></td>
<%--коэф. усиления--%>
	<td class="text"><%=bean.getAmplificationStr()%></td>

	<td class="number"><%=bean.getBandsString() %></td>
<%--Прием передача--%>
	<td class="text"><%=AntennaObject.getKindAntTitle(bean.getKindant())%></td>
	<td class="text"><%=bean.getSectorLetters()%></td>
	<logic:present name="returnFormName">
	<td class="link" >
	<%if(canEdit){%><july:delbutton page="<%=del_link%>" paramId="idanten" paramName="ant" paramProperty="idanten" /><%}%>
	</td>
	</logic:present>
</tr>
</logic:present>
</logic:iterate>
</table>

