<%@ page language = "java" %>
<%@ page import="com.hps.july.cdbc.lib.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
    String gColSpan = request.getAttribute("colspan")+"";
%>

<tr class="title" style="text-align : center; vertical-align : middle">
    <TD class="title">&nbsp;</TD>
    <july:headercolumn key="label.electroCounterInfo.table.code" colType="string"/>
    <july:headercolumn key="label.electroCounterInfo.table.name" colType="string"/>
    <TD class="title">Интервал поверки</TD>
    <TD class="title">&nbsp;</TD>
</tr>

<july:separator colspan="<%= gColSpan %>" />
        <!-- Table body -->
<logic:iterate id="sreg" name="browseList" type="CDBCRowObject" >
  <logic:present name="sreg">
    <%
        String id = sreg.getColumn("id").asString();
        String paramVal = "id=" + id;
    %>
    <july:selectableTR styleId="<%=id%>" paramName="selID" selectable="true" styleClass="normal"  onmouseover="className='select'" onmouseout="className='normal'">
<%--
     <tr class="normal" selectableID="<%=id%>" id="id<%=id%>" onMouseOver="className='select'" onMouseOut="className='normal'">
--%>
         <td class="text" style="width : 5%; text-align : center; vertical-align : middle">
           <%
               String editPage = "/EditElectroCounterInfo.do?" + paramVal;
           %>
           <july:anchor />
<%--
           <july:anchor name='<%="p"+id%>' />
--%>
           <july:editbutton page="<%= editPage %>" action="Edit" modelName="list" selectable="1"/>
        </td>
         <td class="text" style="width : 35%; text-align : center; vertical-align : middle">
           <july:stringwrite name="sreg" property="code" />
        </td>
        <td class="text" style="width : 35%; text-align : center; vertical-align : middle">
            <july:stringwrite name="sreg" property="name" />
        </td>
        <td class="text" style="width : 20%; text-align : center; vertical-align : middle">
            <july:stringwrite name="sreg" property="verification_inter" />
        </td>
        <td class="link" style="width : 5%; text-align : center; vertical-align : middle">
           <%
               String delPage = "/EditElectroCounterInfo.do?action=Delete&" + paramVal;
           %>
            <july:delbutton page="<%= delPage %>" modelName="list" selectable="1"/>
        </td>
    </july:selectableTR>
<%--
    </tr>
--%>
  <july:separator colspan="<%= gColSpan %>" />
  </logic:present>
</logic:iterate>