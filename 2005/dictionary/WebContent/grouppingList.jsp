<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5"; %>

<july:browseform action="/ShowGrouppingList.do">

<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowGroupList.do" styleClass="navigator"><bean:message key="label.groups"/></html:link>
       <july:sepmark/> 
       <july:currmark><bean:message key="label.groupping"/></july:currmark></td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="text"><bean:message key="label.group"/>:</td>
       <td class="text"><bean:write name="GrouppingListForm" property="searchgroupname" /></td>
     </tr>        
     </table>
    
  </TD>
</TR>


<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditGroupping.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <TD class="title" width="1%">&nbsp;</TD>
            <july:headercolumn key="label.groupping.code" colType="number"/>
            <july:headercolumn key="label.groupping.name" colType="string"/>
            <july:headercolumn key="label.organizations" colType="string"/>
            <TD class="title" width="1%">&nbsp;</TD>
        </tr>


<july:separator colspan="<%= gColSpan %>" />

    
        <!-- Table body -->
        <logic:iterate id="rstl" name="browseList">
	      <logic:present name="rstl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="link">
                    <july:editbutton page="/EditGroupping.do" action="Edit" paramId="searchgroupping" paramName="rstl" paramProperty="searchGroupping" paramScope="page"/>
		</td>
                <td class="number">
                    <bean:write name="rstl" property="searchGroupping" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="rstl" property="name" filter="true"/>
                </td>
                <td class="link">
                    <july:link page="/ShowGrouporgList.do" paramId="searchgroupping" paramName="rstl" paramProperty="searchGroupping" paramScope="page" alttext="msg.grouporg">
                        <bean:message key="label.organizations"/>
                    </july:link>
                </td>
                <td class="link"><july:delbutton page="/EditGroupping.do?action=Delete" paramId="searchgroupping" paramName="rstl" paramProperty="searchGroupping" paramScope="page"/></td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditGroupping.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
<%--      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowGroupList.do" styleClass="navigator"><bean:message key="label.groups"/></html:link>
           <july:sepmark/> 
           <july:currmark><bean:message key="label.groupping"/></july:currmark></td>
      </tr>
--%>        
    </table>

</july:browseform>
