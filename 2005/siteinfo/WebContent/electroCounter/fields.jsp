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

<%
    String gColSpan = request.getAttribute("colspan")+"";
%>


<TR class="normal">
 <TD colspan="<%= gColSpan %>">
    <table class="find">
        <tr>
            <td class="title" >
                <bean:message key="label.regionList.search"/>&nbsp;&nbsp;
                <bean:message key="label.electroCounterInfo.search.code"/>&nbsp;
                <july:string styleClass="editsearch" styleId="code" property="code" insertable="true" updatable="true"/>
                &nbsp;
                <bean:message key="label.electroCounterInfo.search.name"/>&nbsp;
                <july:string styleClass="editsearch" styleId="name" property="name" insertable="true" updatable="true"/>
                <july:searchbutton/>
           </td>
        </tr>
     </table>
  </TD>
</TR>
