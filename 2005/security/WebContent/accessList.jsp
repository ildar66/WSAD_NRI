<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.*, com.hps.july.security.formbean.*" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%!
	private String isUp(String aSort, String name) {
		 if(aSort.startsWith(name)) {
			 if(aSort.endsWith("desc")) 
				return (" <img src='/images/up.gif'  border='0' alt='по возрастанию'> ");
			 else
				return (" <img src='/images/down.gif'  border='0' alt='по убыванию'> "); 
		 }
		 else return ("");      
	}
%>

<%
	String gColSpan = "9";
	AccessListForm listForm = (AccessListForm)session.getAttribute("AccessListForm");
	String sortBy = listForm.getOrderBy();
%>


<july:browseform action="/AccessList.do" styleId="listForm">
<html:hidden property="orderBy"/>
<html:hidden property="operation" value=""/>

<style>
TR.include {
	background-color:#A5F3C6;
}
TR.exclude {
	background-color:#F0F0F0;
}
TR.selectedrow {
	background-color:#FFF0D0;
} 
</style>

<script language="javascript">
function SortBy(field) 
{
	var e = document.all.orderBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
</script>

<table class="main" border='0' style="font-size: 8pt">

<!--upperMenu begin : Phisicals > Operators > Operators roles > Region access -->
<tr class="title">
       <td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowOperatorList.do" styleClass="navigator"><bean:message key="label.operators"/></html:link> 
           <july:sepmark/>
           <july:currmark><bean:message key="label.regions"/></july:currmark>
       </td>
</tr>
<!--upperMenu end-->

<july:separator colspan="<%= gColSpan %>" />

<%--
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
--%>


<!---buttons and navigator begin -->
<tr class="title">
   <td colspan="<%= gColSpan %>">
      <TABLE class="buttons">
      <tr class="title">
         <td class="buttons">
              <INPUT TYPE="IMAGE" NAME="submit" SRC="/images/save.gif"  ALT="Сохранить" onclick="operation.value='save';">
              <july:backbutton page="/ShowOperatorList.do"/>
         </td>
         <th class="navigator">Текущие права на филиалы:</th>
      </tr>
      </TABLE>
   </td>
</tr>
<!---buttons and navigator end-->

<!-- Table header  begin :-->
<tr class="title">
       <td  class="title" rowspan='2'>
			<A title="Сортировать по полю 'Код'" href="javascript:SortBy('regionid')">
			<bean:message key="label.superregion.code"/></A><%=isUp(sortBy, "regionid")%></td>
       <td  class="title" rowspan='2'>
			<A title="Сортировать по полю 'Регион'" href="javascript:SortBy('supregname')">Регион</A><%=isUp(sortBy, "supregname")%></td>
       <td  class="title" rowspan='2'>
			<A title="Сортировать по полю 'Филиал'" href="javascript:SortBy('regname')">Филиал</A><%=isUp(sortBy, "regname")%></td>
       <td  colspan='2' class="title"><bean:message key="label.superregion.planData"/></td>
       <td  colspan='2' class="title"><bean:message key="label.superregion.factData"/></td>
	   <td  colspan='2' class="title" align="center">Аренда</td>
</tr>
<tr class="title">
       <td class="title"><bean:message key="label.superregion.read"/></td>
       <td class="title"><bean:message key="label.superregion.write"/></td>
       <td class="title"><bean:message key="label.superregion.read"/></td>
       <td class="title"><bean:message key="label.superregion.write" /></td>
       <td class="title"><bean:message key="label.superregion.read"/></td>
       <td class="title"><bean:message key="label.superregion.write" /></td>
</tr>


<july:separator colspan="<%= gColSpan %>" />
<!-- Table header  end :-->        


        <!-- Table body begin-->
        
        <logic:iterate id="it" name="browseList" indexId="index" type="com.hps.july.valueobject.RegionsAccess_TO">
            <logic:present name="it">
			<% String regionId = String.valueOf(((com.hps.july.valueobject.RegionsAccess_TO)it).getVo().getRegionid()); %>
            <tr class="include" onMouseOver="className='select'" onMouseOut="className='include'">
                <td class="number">
                      <bean:write name="it" property="vo.regionid" filter="true"/>
                </td>
                <td class="text">
                      <bean:write name="it" property="supRegName" filter="true"/>
                </td>
                <td class="text">
                      <bean:write name="it" property="regionName" filter="true"/>
                </td>                
                <td class="text">
                  <html:checkbox property="viewplan" onclick="if (!this.checked) document.all.item('EP' + this.id.substr(2), 0).checked=false;"styleId='<%= "VP" + index  %>' name="it" value="<%= regionId %>"/>
                </td>
                <td class="link">
                  <html:checkbox property="editplan" onclick="if (this.checked) document.all.item('VP' + this.id.substr(2), 0).checked=true;"styleId='<%= "EP" + index  %>' name="it" value="<%= regionId %>"/>
                </td>
                <td class="link">
                  <html:checkbox property="viewfact" onclick="if (!this.checked) document.all.item('EF' + this.id.substr(2), 0).checked=false;"styleId='<%= "VF" + index  %>' name="it" value="<%= regionId %>"/>
                </td>
                <td class="link">
                  <html:checkbox property="editfact" onclick="if (this.checked) document.all.item('VF' + this.id.substr(2), 0).checked=true;"styleId='<%= "EF" + index  %>' name="it" value="<%= regionId %>"/> 
                </td>
                <td class="link">
                  <html:checkbox property="viewarenda" onclick="if (!this.checked) document.all.item('EA' + this.id.substr(2), 0).checked=false;"styleId='<%= "VA" + index  %>' name="it" value="<%= regionId %>"/>
                </td>
                <td class="link">
                  <html:checkbox property="editarenda" onclick="if (this.checked) document.all.item('VA' + this.id.substr(2), 0).checked=true;"styleId='<%= "EA" + index  %>' name="it" value="<%= regionId %>"/>
                </td>
            </tr>
	    </logic:present>
        </logic:iterate>
        <!-- Table body end-->

<!---buttons and navigator begin -->
<tr class="title">
   <td colspan="<%= gColSpan %>">
      <TABLE class="buttons">
      <tr class="title">
         <td class="buttons">
              <INPUT TYPE="IMAGE" NAME="submit" SRC="/images/save.gif"  ALT="Сохранить" onclick="operation.value='save';">
              <july:backbutton page="/ShowOperatorList.do"/>
         </td>
		 <TH colspan="<%= gColSpan %>">Доступные права на филиалы:</TH>
      </tr>
      </TABLE>
   </td>
</tr>
<!---buttons and navigator end-->

        <!-- Table "listAnoveAccessForOperator"  body -->
        <logic:iterate id="it" name="AccessListForm" property="listAnoveAccessForOperator" indexId="index" >
            <logic:present name="it">
            <tr class="exclude" onMouseOver="className='select'" onMouseOut="className='exclude'">
			<% String regionId = String.valueOf(((com.hps.july.valueobject.RegionsAccess_TO)it).getVo().getRegionid()); %>
                  <td class="number">
                      <bean:write name="it" property="vo.regionid" filter="true"/>
                </td>
                <td class="text">
                      <bean:write name="it" property="supRegName" filter="true"/>
                </td>
                <td class="text">
                      <bean:write name="it" property="regionName" filter="true"/>
                </td>
                <td class="text">
                  <html:checkbox property="viewplan" onclick="if (!this.checked) document.all.item('EP1' + this.id.substr(3), 0).checked=false;"styleId='<%= "VP1" + index  %>' name="it" value="<%= regionId %>"/>
                </td>
                <td class="link">
                  <html:checkbox property="editplan" onclick="if (this.checked) document.all.item('VP1' + this.id.substr(3), 0).checked=true;"styleId='<%= "EP1" + index  %>' name="it" value="<%= regionId %>"/>
                </td>
                <td class="link">
                  <html:checkbox property="viewfact" onclick="if (!this.checked) document.all.item('EF1' + this.id.substr(3), 0).checked=false;"styleId='<%= "VF1" + index  %>' name="it" value="<%= regionId %>"/>
                </td>
                <td class="link">
                  <html:checkbox property="editfact" onclick="if (this.checked) document.all.item('VF1' + this.id.substr(3), 0).checked=true;"styleId='<%= "EF1" + index  %>' name="it" value="<%= regionId %>"/> 
                </td>
                <td class="link">
                  <html:checkbox property="viewarenda" onclick="if (!this.checked) document.all.item('EA1' + this.id.substr(3), 0).checked=false;"styleId='<%= "VA1" + index  %>' name="it" value="<%= regionId %>"/>
                </td>
                <td class="link">
                  <html:checkbox property="editarenda" onclick="if (this.checked) document.all.item('VA1' + this.id.substr(3), 0).checked=true;"styleId='<%= "EA1" + index  %>' name="it" value="<%= regionId %>"/>
                </td>
            </tr>
	        </logic:present>
        </logic:iterate>
		<!-- Table "listAnoveAccessForOperator"  body end-->

<!---buttons and navigator begin -->
<tr class="title">
   <td colspan="<%= gColSpan %>">
      <TABLE class="buttons">
      <tr class="title">
         <td class="buttons">
              <INPUT TYPE="IMAGE" NAME="submit" SRC="/images/save.gif"  ALT="Сохранить" onclick="operation.value='save';">
              <july:backbutton page="/ShowOperatorList.do"/>
         </td>
		 <TH colspan="<%= gColSpan %>"></TH>
      </tr>
      </TABLE>
   </td>
</tr>
<!---buttons and navigator end-->
        
      <july:separator colspan="<%= gColSpan %>" />
      
<!--underMenu begin : Phisicals > Operators > Operators roles > Region access -->
<tr class="title">
       <td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowOperatorList.do" styleClass="navigator"><bean:message key="label.operators"/></html:link> 
           <july:sepmark/>
           <july:currmark><bean:message key="label.regions"/></july:currmark>
       </td>
</tr>
<!--underMenu end-->
        
</table>

</july:browseform>
