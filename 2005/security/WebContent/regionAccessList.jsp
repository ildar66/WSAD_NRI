<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "6"; %>

<july:browseform action="/ShowRegionAccessList.do" styleId="RegionAccessForm">

<table class="main" border='0'>

<!--upperMenu begin : Phisicals > Operators > Operators roles > Region access -->
<tr class="title">
       <td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowPeopleList.do" styleClass="navigator">
           <bean:message key="label.people"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowOperatorList.do" styleClass="navigator">
           <bean:message key="label.operators"/></html:link> 
           <july:sepmark/>
           <july:currmark><bean:message key="label.regions"/></july:currmark>
       </td>
</tr>
<!--upperMenu end-->

<july:separator colspan="<%= gColSpan %>" />

<SCRIPT>
function disablesuperregion(){
   if(RegionAccessForm.allsuperregions[0].checked) {
	RegionAccessForm.superregionid.className='editdisabled';
        //document.RegionAccessForm.superregionid.selectedIndex = 0;
   } else {
        RegionAccessForm.superregionid.className='editsearch';
   }
   document.RegionAccessForm.superregionid.disabled = document.RegionAccessForm.allsuperregions[0].checked;
}
</SCRIPT>

<tr class="normal">
 <td colspan="<%= gColSpan %>">
    <table class="find">
        <!-- FIO begin -->
        <tr>
           <td class="title"><bean:message key="label.people.fullname"/>:</td>
           <td class="title"><bean:write name="operator" property="man.fullName"/></td>
        </tr>
        <!-- FIO end -->
        <tr class="normal">
            <td class="title">
                <bean:message key="label.superregion"/>
            </td>
            <td class="title" colspan="<%= gColSpan %>">
                <july:checkbox property="allsuperregions" insertable="true" updatable="true" onclick="disablesuperregion();"/>
                <bean:message key="label.allsuperregions"/>

                <july:select collection="superregions" property="superregionid" insertable="true" updatable="true" styleClass="search">
                        <%--html:option  key=" "  value=" "/--%>
                        <html:options collection="superregions" property="supregid" labelProperty="supregname"/>
                </july:select>
                <july:searchbutton/>

                <SCRIPT language='JAVASCRIPT'>
                disablesuperregion();
                </SCRIPT>
            </td>
        </tr>
        <!-- Operator begin -->
        <tr>
          <td class="title"><bean:message key="label.operator.loginid"/>:</td>
          <td class="title"><bean:write name="operator" property="login" /></td>
        </tr>
        <!-- Operator end -->
    </table>
  </td>
</tr>

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
        
        <logic:iterate id="regionaccesses" name="browseList" indexId="index">
            <logic:present name="regionaccesses">
            <% String regionId = String.valueOf(RequestUtils.lookup(pageContext, "regionaccesses", "regionid", null)); %>
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number">
                      <bean:write name="regionaccesses" property="regionid" filter="true"/>
                </td>
                <td class="text">
                      <bean:write name="regionaccesses" property="regname" filter="true"/>
                </td>
                <td class="text">
                  <july:checkbox property="viewplan" onclick="if (!this.checked) document.all.item('EP' + this.id.substr(2), 0).checked=false;"  styleId='<%= "VP" + index  %>' value="<%= regionId %>" insertable="true" updatable="true"/>
                </td>
                <td class="link">
                  <july:checkbox property="editplan" onclick="if (this.checked) document.all.item('VP' + this.id.substr(2), 0).checked=true;"  styleId='<%= "EP" + index  %>' value="<%= regionId %>" insertable="true" updatable="true"/>
                </td>
                <td class="link">
                  <july:checkbox property="viewfact" onclick="if (!this.checked) document.all.item('EF' + this.id.substr(2), 0).checked=false;"  styleId='<%= "VF" + index  %>' value="<%= regionId %>" insertable="true" updatable="true"/>
                </td>
                <td class="link">
                  <july:checkbox property="editfact" onclick="if (this.checked) document.all.item('VF' + this.id.substr(2), 0).checked=true;"  styleId='<%= "EF" + index  %>' value="<%= regionId %>" insertable="true" updatable="true"/>
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
      
<!--underMenu begin : Phisicals > Operators > Operators roles > Region access -->
<tr class="title">
       <td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowPeopleList.do" styleClass="navigator">
           <bean:message key="label.people"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowOperatorList.do" styleClass="navigator">
           <bean:message key="label.operators"/></html:link> 
           <july:sepmark/>
           <july:currmark><bean:message key="label.regions"/></july:currmark>
       </td>
</tr>
<!--underMenu end-->
        
</table>

</july:browseform>
