<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "6"; %>

<july:browseform action="/ShowSuperRegionAccessList.do">

<table class="main" border='0'>

<!--upperMenu begin : Phisicals > Operators > Operators roles > SuperRegion access -->
<tr class="title">
       <td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowPeopleList.do" styleClass="navigator">
           <bean:message key="label.people"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowOperatorList.do" styleClass="navigator">
           <bean:message key="label.operators"/></html:link> 
           <july:sepmark/>
           <july:currmark><bean:message key="label.superRegions"/></july:currmark>
       </td>
</tr>
<!--upperMenu end-->

<!-- FIO and Operator begin -->
<tr class="normal">
 <td colspan="<%= gColSpan %>">
    <table class="find">
        <tr>
           <td class="title"><bean:message key="label.people.fullname"/>:</td>
           <td class="title"><bean:write name="operator" property="man.fullName"/></td>
        </tr>    
        <tr>
          <td class="title"><bean:message key="label.operator.loginid"/>:</td>
          <td class="title"><bean:write name="operator" property="login" /></td>
        </tr>
     </table>
  </td>
</tr>
<!-- FIO and Operator end -->

<!---buttons and navigator begin -->
<tr class="title">
   <td colspan="<%= gColSpan %>">
      <TABLE class="buttons">
      <tr class="title">
         <td class="buttons">
              <july:savebutton/>
              <july:backbutton page="/ShowOperatorList.do"/>
         </td>
         <td class="navigator">
              <%--july:navigator/--%>
         </td>
      </tr>
      </TABLE>
   </td>
</tr>
<!---buttons and navigator end-->

<jsp:include page="/regionAccessTableHeader.jsp" flush="true"></jsp:include>

        <!-- Table body begin-->
        
        <logic:iterate id="superregionaccesses" name="browseList" indexId="index">
            <logic:present name="superregionaccesses">
            <% String supregId = String.valueOf(RequestUtils.lookup(pageContext, "superregionaccesses", "supregid", null)); %>
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number">
                      <bean:write name="superregionaccesses" property="supregid" filter="true"/>
                </td>
                <td class="text">
                      <bean:write name="superregionaccesses" property="supregname" filter="true"/>
                </td>
                <td class="text">
                  <july:checkbox property="viewplan" onclick="if (!this.checked) document.all.item('EP' + this.id.substr(2), 0).checked=false;" value="<%= supregId %>" styleId='<%= "VP" + index  %>' insertable="true" updatable="true"/>
                </td>
                <td class="link">
                  <july:checkbox property="editplan" onclick="if (this.checked) document.all.item('VP' + this.id.substr(2), 0).checked=true;" value="<%= supregId %>" styleId='<%= "EP" + index  %>' insertable="true" updatable="true"/>
                </td>
                <td class="link">
                  <july:checkbox property="viewfact" onclick="if (!this.checked) document.all.item('EF' + this.id.substr(2), 0).checked=false;" value="<%= supregId %>" styleId='<%= "VF" + index  %>' insertable="true" updatable="true"/>
                </td>
                <td class="link">
                  <july:checkbox property="editfact" onclick="if (this.checked) document.all.item('VF' + this.id.substr(2), 0).checked=true;" value="<%= supregId %>" styleId='<%= "EF" + index  %>' insertable="true" updatable="true"/>
                </td>
            </tr>
            <july:separator colspan="<%= gColSpan %>" />
	    </logic:present>
        </logic:iterate>
        <!-- Table body end-->

<!---buttons and navigator begin -->
<tr class="title">
   <td colspan="<%= gColSpan %>">
      <TABLE class="buttons">
      <tr class="title">
         <td class="buttons">
              <july:savebutton/>
              <july:backbutton page="/ShowOperatorList.do"/>
         </td>
         <td class="navigator">
              <%--july:navigator/--%>
         </td>
      </tr>
      </TABLE>
   </td>
</tr>
<!---buttons and navigator end-->
        
      <july:separator colspan="<%= gColSpan %>" />
      
<!--underMenu begin : Phisicals > Operators > Operators roles > SuperRegion access -->
<tr class="title">
       <td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowPeopleList.do" styleClass="navigator">
           <bean:message key="label.people"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowOperatorList.do" styleClass="navigator">
           <bean:message key="label.operators"/></html:link> 
           <july:sepmark/>
           <july:currmark><bean:message key="label.superRegions"/></july:currmark>
       </td>
</tr>
<!--underMenu end-->
        
</table>

</july:browseform>
