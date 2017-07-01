<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.basestation.valueobject.*,com.hps.july.basestation.formbean.*"%>

<%
	AntennaObject bean=null;
	String conf=config.getInitParameter("application");
	if(conf==null)conf="com.hps.july.basestation.ApplicationResources";
	MessageResources resources=MessageResources.getMessageResources(conf);
	String gColSpan="11";
%>

<tr><td>
<table class="main" id="brtable">
<tr class="title">
	<july:headercolumn key="Antenna.number" colType="string"/>
	<july:headercolumn key="Antenna.type" colType="string"/>
	<july:headercolumn key="Antenna.asim" colType="string"/>
	<july:headercolumn key="Antenna.boand" colType="string"/>
	<july:headercolumn key="Antenna.direct" colType="string"/>
	<july:headercolumn bundle="dictionaryResources" key="label.antena.dir" colType="string"/>
	<july:headercolumn key="Antenna.ky" colType="string"/>
	<july:headercolumn key="Antenna.higth" colType="string"/>
	<july:headercolumn key="Antenna.nakl" colType="string"/>
	<td>&nbsp;</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<logic:iterate id="ant" name="AntennesChoiceForm" property="antennes">
<logic:present name="ant">
<%bean=(AntennaObject) pageContext.getAttribute("ant");%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="number">
		<logic:present name="ant" property="numant"><bean:write name="ant" property="numant" filter="true"/></logic:present>
	</td>
	<td class="text">
		<%=bean.getResource()!=null&&bean.getResource().getModel()!=null?bean.getResource().getModel():""%>
	</td>
	<td class="number">
		<logic:present name="ant" property="azant"><bean:write name="ant" property="azant" filter="true"/></logic:present>
	</td>
	<td class="number">
		<%=bean.getBandsString() %>
	</td>
<%--Прием передача--%>
	<td class="text"><%=AntennaObject.getKindAntTitle(bean.getKindant())%></td>
<%--диаграмма направленности--%>
	<td class="text"><%=bean.getWidthDiagram()%></td>
<%--коэф. усиления--%>
	<td class="text"><%=bean.getAmplificationStr()%></td>
<%--высота подвеса--%>
	<td class="text"><%=bean.getHset1()%></td>
<%--мех наклон--%>
	<td class="text"><%=bean.getNakl()%></td>
	<td class="link"><july:checkbox  property="choiceAntennes" value="<%=String.valueOf(bean.getIdanten())%>" insertable="true" updatable="true" /></td>
</tr>
</logic:present>
</logic:iterate>

</table>
</td></tr>
