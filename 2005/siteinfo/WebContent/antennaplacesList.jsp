<%@ page language = "java" %>
<%@ page import="com.hps.july.cdbc.lib.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5"; %>

<july:browseform action="/ShowAntennaPlacesList.do">

<table class="main">

  <july:separator colspan="<%= gColSpan %>" />
    <tr class="title">
      <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditAntennaPlaces.do?action=Add"/><july:backbutton page="/main.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>

        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <TD class="title">&nbsp;</TD>
            <july:headercolumn key="label.code" colType="number"/>
            <july:headercolumn key="label.name" colType="string"/>
            <july:headercolumn key="label.antennaplaces.isvc" colType="string"/>
            <TD class="title">&nbsp;</TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table body -->
        <logic:iterate id="it" name="browseList" type="CDBCRowObject">
	      <logic:present name="it">
            <%
              String paramVal = "antplaceid=" + it.getColumn("antplaceid").asString();
            %>
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="link">
                   <%
                      String editPage = "/EditAntennaPlaces.do?" + paramVal;
                   %>
                   <july:editbutton page="<%= editPage %>" action="Edit"/>
                </td>
                <td class="number">
                       <july:stringwrite name="it" property="antplaceid"/>
                </td>
                <td class="text">
                       <july:stringwrite name="it" property="name"/>
                </td>
                <td class="text">
                  <%
                    if ("Y".equals(it.getColumn("isvc").asString())) {
                  %>
                      <IMG SRC="/images/setrow.gif" BORDER="0">
                  <%
                    }
                  %>
                </td>
                <td class="link">
                   <%
                      String delPage = "/EditAntennaPlaces.do?action=Delete&" + paramVal;
                   %>
                   <july:delbutton page="<%= delPage %>"/>
                </td>
            </tr>
            <july:separator colspan="<%= gColSpan %>" />
	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditAntennaPlaces.do?action=Add"/><july:backbutton page="/main.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>

		</tr>

		<july:separator colspan="<%= gColSpan %>" />

    </table>


</july:browseform>

