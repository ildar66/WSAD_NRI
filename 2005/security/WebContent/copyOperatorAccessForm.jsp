<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessCopyOperatorAccess.do" styleId="CopyOperatorAccessForm">
<INPUT TYPE="HIDDEN" NAME="action_process" VALUE='0'>

<table class="main" border='0'>

<!--upperMenu begin : Phisicals > Operators > right access copy -->
    <tr class="title">
    	<td class="title" colspan="4">
           <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowOperatorList.do" styleClass="navigator"><bean:message key="label.operators"/></html:link> 
           <july:sepmark/>
           <july:currmark><bean:message key="label.accessRightsCopy"/></july:currmark>
       </td>
    </tr>
<!--upperMenu end-->

<july:separator colspan="4"/>

<!--header begin-->
<tr class="title">
 <td class="title" colspan="4">
        <bean:message key="label.operator.accesscopy.header"/>
  </td>
</tr>
<!--header end-->

<july:separator colspan="4"/>

<!-- FIO begin -->
<tr class="text">
           <td class="text"><bean:message key="label.people.fullname"/>:</td>
           <td class="text" colspan="3"><bean:write name="operator" property="man.fullName"/></td>
</tr>
<!-- FIO end -->

<july:separator colspan="4"/>

<!-- Operator begin -->
<tr class="text">
          <td class="text"><bean:message key="label.operator.loginid"/>:</td>
          <td class="text" colspan="3"><bean:write name="operator" property="login" /></td>
</tr>
<!-- Operator end -->

<july:separator colspan="4"/>


<!--footer begin-->
<tr class="title">
  <td class="title" colspan="4">
        <bean:message key="label.operator.accesscopy.footer"/>:
  </td>
</tr>
<!--footer end-->

<july:separator colspan="4"/>

<tr class="text">
           <td class="text"><bean:message key="label.people.fullname"/>:</td>
           <td><july:string property="man" size="5" maxlength='10' insertable='false'/>
           <july:lookupbutton action="/ShowPeopleLookupList.do" 
                                  styleId="peopleLookup" 
                                  fieldNames="man;fullName;firstOperator;operatorToCopy"
                                  newWindowName="peopleLookup" 
                                  insertable="true" 
                                  updatable="true"/>
           
           <july:string  property="fullName" size="15" readonly='true' insertable='false'/>
</tr>

<july:separator colspan="4"/>

<tr class="text">
          <td class="text"><bean:message key="label.operator.loginid"/>:</td>
          <td><july:string property="firstOperator" size="7" maxlength='10' insertable='false'/>
          <july:lookupbutton action="/ShowOperatorLookupList.do" 
                                  styleId="operatorLookup" 
                                  fieldNames="operatorToCopy;firstOperator"
                                  newWindowName="operatorLookup"
                                  insertable="true" 
                                  updatable="true"
                                  onclick="set_opt_params_operatorLookup('?man='+ document.all.man.value + '&fullName=' + document.all.fullName.value);"
                                  />
           <html:hidden property="operatorToCopy"/>
           <html:hidden property="operator"/>
           </td>
</tr>

<july:separator colspan="4"/>

<tr class="text">
<td class="text" colspan="4">
    <font class="attention"><b>
    <bean:message key="label.operator.copy.attention1"/>
    <bean:write name="operator" property="login"/>
    <bean:message key="label.operator.copy.attention2"/>
    </b></font>
</td>
</tr>

<july:separator colspan="4"/>

<!---buttons begin -->
<tr class="title">
   <td colspan="4">
      <TABLE class="buttons">
      <tr class="title">
         <td class="buttons">
              <july:formbuttons />
         </td>
      </tr>
      </TABLE>
   </td>
</tr>
<!---buttons end-->

<july:separator colspan="4"/>

<!--underMenu begin : Phisicals > Operators > right access copy -->
   <tr class="title">
    	<td class="title" colspan="4">
           <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowOperatorList.do" styleClass="navigator"><bean:message key="label.operators"/></html:link> 
           <july:sepmark/>
           <july:currmark><bean:message key="label.accessRightsCopy"/></july:currmark>
       </td>
    </tr>
<!--underMenu end-->
</table>

</july:editform>
