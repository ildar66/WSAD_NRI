<%@ page import="com.hps.july.jdbcpersistence.lib.RegionObject"%>
<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
String gColSpan = request.getAttribute("colspan")+"";
RegionObject reg=null;
%>

<tr class="title">
  <july:sortcolumn key="label.regionList.code" colType="number" ascFinder='<%=RegionObject.ORDER_BY_CODE_ASC+""%>' descFinder='<%=RegionObject.ORDER_BY_CODE_DESC+""%>'/>
  <july:sortcolumn key="label.regionList.superRegion" colType="string" ascFinder='<%=RegionObject.ORDER_BY_SUPREGNAME_ASC+""%>' descFinder='<%=RegionObject.ORDER_BY_SUPREGNAME_DESC+""%>'/>
  <july:sortcolumn key="label.regionList.name" colType="string" ascFinder='<%=RegionObject.ORDER_BY_REGNAME_ASC+""%>' descFinder='<%=RegionObject.ORDER_BY_REGNAME_DESC+""%>'/>
<TD class="title">&nbsp;</TD>
</tr>

<july:separator colspan="<%= gColSpan %>" />
        <!-- Table body -->
<logic:iterate id="sreg" name="browseList">
<%reg=(RegionObject)pageContext.getAttribute("sreg");%>
  <logic:present name="sreg">
     <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
         <td class="number">
             <%=reg.getId()%>
         </td>
         <td class="text">
    <%-- <july:link page='<%="/EditSuperRegion.do?action=Edit&supregid="+reg.getSupregId()%>'> --%>
                <%=reg.getSupregName()%>
    <%-- </july:link> --%>
        </td>
        <td class="text">
               <july:editlink page="/EditRegion.do" action="Edit" paramId="regionid" paramName="sreg" paramProperty="id">
                       <%=reg.getName()%>
               </july:editlink>
        </td>
        <td class="link">
                   <july:delbutton page="/EditRegion.do?action=Delete" paramId="regionid" paramName="sreg" paramProperty="id"/>
        </td>
    </tr>
  <july:separator colspan="<%= gColSpan %>" />
  </logic:present>
</logic:iterate>