<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "4"; %>

<july:browseform action="/ShowRessbtypeList.do">

<table class="main">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="text"><bean:message key="label.restype"/>:</td>
       <td class="text"><bean:write name="RessbtypeListForm" property="resourcetypename" /></td>
     </tr>        
     </table>
    
  </TD>
</TR>


<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditRessbtype.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <TD class="title" width="1%">&nbsp;</TD>
            <july:headercolumn key="label.subtype.code" colType="number"/>
            <july:headercolumn key="label.subtype.name" colType="string"/>
<%--
            <july:headercolumn key="label.resource" colType="string"/>
            <july:headercolumn key="label.complects" colType="string"/>
--%>
            <TD class="title" width="1%">&nbsp;</TD>
        </tr>


<july:separator colspan="<%= gColSpan %>" />

    
        <!-- Table body -->
        <logic:iterate id="rstl" name="browseList">
	      <logic:present name="rstl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="link">
			<july:editbutton page="/EditRessbtype.do" action="Edit" paramId="resourcesubtype" paramName="rstl" paramProperty="resourcesubtype" paramScope="page"/>
		</td>
                <td class="number">
                    <bean:write name="rstl" property="resourcesubtype" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="rstl" property="name" filter="true"/>
                </td>
<%--
                <td class="link">
                    <july:link page="/ShowResourceList.do" paramId="resourcesubtype" paramName="rstl" paramProperty="resourcesubtype" paramScope="page" alttext="msg.res">
                        <bean:message key="label.resource"/>
                    </july:link>
                </td>
                <td class="link">
                    <july:link page="/ShowComplectList.do" paramId="resourcesubtype" paramName="rstl" paramProperty="resourcesubtype" paramScope="page" alttext="msg.complect">
                        <bean:message key="label.complects"/>
                    </july:link>
                </td>
--%>
                <td class="link"><july:delbutton page="/EditRessbtype.do?action=Delete" paramId="resourcesubtype" paramName="rstl" paramProperty="resourcesubtype" paramScope="page"/></td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditRessbtype.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE>
</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

</table>

</july:browseform>
