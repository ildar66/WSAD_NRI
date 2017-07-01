<%@ page import="com.hps.july.jdbcpersistence.lib.SearchConstants"%>
<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<script language="javascript">
  function switchInput(itemname,controlname,check_disable) {
            if(!document.all.item(controlname).checked^check_disable) {
                    document.all.item(itemname).className = 'editdisabled';
                    document.all.item(itemname).disabled = true;
            } else {
                    document.all.item(itemname).className = 'editsearch';
                    document.all.item(itemname).disabled = false;
            }
}
</script>

<% String gColSpan = request.getAttribute("colspan")+"";
//SiteDocTypeListForm dForm=(SiteDocTypeListForm)pageContext.findAttribute("SiteDocTypeListForm");
%>


<TR class="normal">

 <TD colspan="<%= gColSpan %>">



    <table class="find">

    <tr>

       <td class="title" ><bean:message key="label.regionList.search.superRegion"/>
&nbsp;
       <july:checkbox  styleId="isAllSupRegions" property="isAllSuperRegions" insertable="true" updatable="true"  value="true" onclick="switchInput('superRegionCode','isAllSupRegions',true);"/>
<bean:message key="label.search.all"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <july:select styleId="superRegionCode" collection="superRegions" property="superRegionCode" insertable="true" updatable="true"  >
               <html:options collection="superRegions" property="supregid" labelProperty="supregname"/>
          </july:select>
     <script language="javascript">
       switchInput('superRegionCode','isAllSupRegions',true);
     </script>


         <july:searchbutton/>
       </td>
     </tr>

     <tr>

       <td class="title"><bean:message key="label.regionList.search"/>

<july:radio styleId="isAllNamesTrue" insertable="true" updatable="true" property="searchType" value="<%=SearchConstants.SEARCH_ALL%>" onclick="switchInput('name','isAllNamesTrue',true);"/>
<bean:message key="label.search.all"/>&nbsp;
<july:radio styleId="isAllNamesFalse" insertable="true" updatable="true" property="searchType" value="<%=SearchConstants.SEARCHBY_NAME%>" onclick="switchInput('name','isAllNamesTrue',true);"/>
<bean:message key="label.regionList.search.name"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<july:string styleClass="editsearch" property="name" styleId="name" insertable="true" updatable="true"/>
     <script language="javascript">
     switchInput('name','isAllNamesTrue',true);

     </script>
       </td>
     </tr>

     </table>



  </TD>

</TR>
