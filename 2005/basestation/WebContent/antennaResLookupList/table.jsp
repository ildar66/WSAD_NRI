<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.basestation.valueobject.*,com.hps.july.basestation.formbean.*"%>
<% java.lang.String gColSpan = "9"; %>




<TR>
     <TD>
<table class="main" id="br_table">
<tr class="title">

	<july:headercolumn bundle="dictionaryResources" key="label.code" colType="number"/>
	<july:headercolumn bundle="dictionaryResources" key="label.antena.model" colType="string"/>
	<july:headercolumn bundle="dictionaryResources" key="label.antena.manufacturer" colType="string"/>
	<july:headercolumn bundle="dictionaryResources" key="label.antena.range" colType="string"/>
	<july:headercolumn bundle="dictionaryResources" key="label.antena.polar" colType="string"/>
	<july:headercolumn bundle="dictionaryResources" key="label.antena.dir" colType="string"/>
	<july:headercolumn bundle="dictionaryResources" key="label.antena.amplify" colType="string"/>
    <td></td>

</tr>

<%-- july:separator colspan="<%= gColSpan %>"/ --%>

<logic:iterate id="it" name="browseList" indexId="index">
	<logic:present name="it">
<%
AntenaValue ant=(AntenaValue)pageContext.findAttribute("it");

%>
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

		<td class="number">
			<bean:write name="it" property="o.resource" filter="true"/>
		</td>
		<td class="text">
<july:lookupreturn     >
			<bean:write name="it" property="o.model" filter="true"/>
</july:lookupreturn>
		</td>
		<td class="text">
			<logic:present name="it" property="o.manufacturer">
				<bean:write name="it" property="o.manufacturer.name" filter="true"/>
			</logic:present>
		</td>
		<td class="text">

			<bean:write name="it" property="ranges" filter="true"/>
		</td>
		<td class="text">
			<logic:equal name="it" property="o.polarization" value="V">Вертикальная</logic:equal>
			<logic:equal name="it" property="o.polarization" value="C">Кросс</logic:equal>
		</td>
		<td class="text">
        <%--
			<bean:write name="it" property="o.length" filter="true"/>x<bean:write name="it" property="o.width" filter="true"/>x<bean:write name="it" property="o.height" filter="true"/>
		--%>
        <bean:write name="it" property="widthStr" filter="true"/>

        </td>
		<td class="text">
			<bean:write name="it" property="amps" filter="true"/>
		</td>

        <td style='visibility:hidden;display:none'>
          <%=ant.getO().getModel()+" "+ant.getO().getName()%>
        </td>

		</tr>

		<july:separator colspan="<%= gColSpan %>"/>
	</logic:present>
</logic:iterate>


</table>
</TD>
</TR>
