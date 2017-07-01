<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<% java.lang.String gColSpan = "3"; %>



<july:browseform action="/ShowTyperesponsibilityList.do">

<table class="main">

<july:separator colspan="<%= gColSpan %>" />
        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditTyperesponsibility.do?action=Add"/><july:backbutton page="/main.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>

        </tr>
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <july:headercolumn key="label.code" colType="number"/>
            <july:headercolumn key="label.name" colType="string"/>
            <TD class="title">&nbsp;</TD>
        </tr>
<july:separator colspan="<%= gColSpan %>" />

        <!-- Table body -->
        <logic:iterate id="trsp" name="browseList">
	      <logic:present name="trsp">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number">
                       <bean:write name="trsp" property="responsibilityType" filter="true"/>
                </td>
                <td class="text">
                    <july:editlink page="/EditTyperesponsibility.do" action="Edit" paramId="responsibilityType" paramName="trsp" paramProperty="responsibilityType" paramScope="page">
                       <bean:write name="trsp" property="name" filter="true"/>
                    </july:editlink>
                </td>
                <td class="link">
                   <july:delbutton page="/EditTyperesponsibility.do?action=Delete" paramId="responsibilityType" paramName="trsp" paramProperty="responsibilityType" paramScope="page"/>
                </td>
            </tr>
            <july:separator colspan="<%= gColSpan %>" />
	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditTyperesponsibility.do?action=Add"/><july:backbutton page="/main.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        
		</tr>

		<july:separator colspan="<%= gColSpan %>" />

    </table>


</july:browseform>

