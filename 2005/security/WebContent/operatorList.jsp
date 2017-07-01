<%@ page language = "java" %>
<%@ page import="com.hps.july.cdbc.lib.*" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
    
<% java.lang.String gColSpan = "9"; %>

<july:browseform action="/ShowOperatorList.do">

<html:hidden property="man"/>

<july:selectableTable styleClass="main"  modelName="list" selectable="1" selectedClass="selected" paramName="selID" >
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
       <july:sepmark/>
       <july:currmark><bean:message key="label.operators"/></july:currmark></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.people.fullname"/>:</td>
       <td class="title"><bean:write name="people" property="fullName" /></td>
     </tr>        
     </table>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
                   <july:addbutton page="/EditOperator.do?action=Add"  modelName="list" selectable="1"/>
                   <july:backbutton page="/ShowPeopleList.do"/>
              </TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <july:headercolumn key="label.operator.loginid" colType="string"/>
            <%--july:headercolumn key="label.operator.isenabled" colType="string"/--%>
            <TD class="title"><B>Логин MS</B></TD>
            <%--july:headercolumn key="label.operator2roles" colType="link"/--%>
            <TD class="title"><B>Роли</B></TD>
            <TD class="title" colspan='3'><B><bean:message key="label.operator.accessrights"/></B></TD>
            <july:headercolumn key="label.operator.actions" colType="link"/>
            <TD class="title">&nbsp;</TD>
        </tr>

<july:separator colspan="<%= gColSpan %>" />

        <!-- Table body -->
        <logic:iterate id="oper" name="browseList" type="CDBCRowObject">
            <logic:present name="oper">
            <%
                String id = oper.getColumn("oper").asString();
                String e = oper.getColumn("e").asString();
                String paramVal = "operator=" + id;
            %>
            <july:selectableTR styleId="<%=id%>" paramName="selID" selectable="true" styleClass="normal"  onmouseover="className='select'" onmouseout="className='normal'">
                <td class="text">
               <%
                   String editPage = "/EditOperator.do?" + paramVal;
               %>
               <july:anchor />
                <july:editlink page="<%= editPage %>" action="Edit" >
                    <july:stringwrite name="oper" property="login"/>
                </july:editlink>
                </td>
                <%--td class="text">
                    <% if(e.equals("Y")) { %>
                        <bean:message key="label.operator.enabled"/>
                    <% } else { %>
                        <bean:message key="label.operator.disabled"/>
                    <% } %>
                </td--%>
                <td class="text">
                    <july:stringwrite name="oper" property="ms" />
                </td>
                <td class="link">
                    <july:link page="/ShowOperator2roleList.do" paramId="operator" paramName="oper" paramProperty="oper" paramScope="page" alttext="msg.operator2roles">
                        Роли
                    </july:link>
                </td>
                <td class="link">
                    <july:link page="/ShowSuperRegionAccessList.do" paramId="operator" paramName="oper" paramProperty="oper" paramScope="page">
                        <bean:message key="label.superregion"/>
                    </july:link> 
                </td>
<%--                
                <td class="link">
                    <july:link page="/ShowRegionAccessList.do" paramId="operator" paramName="oper" paramProperty="oper" paramScope="page">
                        <bean:message key="label.region"/>
                    </july:link>
                </td>
--%>                
                <td class="link">
                    <july:link page="/AccessList.do" paramId="operator" paramName="oper" paramProperty="oper" paramScope="page">
                        <bean:message key="label.region"/>
                    </july:link>
                </td>
					<%
						String opaccessaction = (String) request.getAttribute("opaccess");
						System.out.println("opaccessaction = "+opaccessaction);
					%>
                <td class="link">
                	<A href='#' onclick='window.open("<%=opaccessaction%>?operatorId=<july:stringwrite name="oper" property="oper"/>")' title="Настроить права доступа">
                		Настроить права доступа
                	</A>
                	<%--
				    <july:link page="<%=opaccessaction%>" paramId="operatorId" paramName="oper" paramProperty="oper" paramScope="page" alttext="msg.operatorCopy">
				        Настроить права доступа
				    </july:link>
				    --%>
                </td>

                <td class="link">
				    <july:link page="/CopyOperatorAccess.do" paramId="operator" paramName="oper" paramProperty="oper" paramScope="page" alttext="msg.operatorCopy">
				        копия
				    </july:link>
                </td>
                <td class="link">
                   <%
                       String delPage = "/EditOperator.do?action=Delete&" + paramVal;
                   %>
                    <july:delbutton page="<%=delPage%>"  modelName="list" selectable="1"/>
                </td>
            </july:selectableTR>

            <july:separator colspan="<%= gColSpan %>" />

	        </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditOperator.do?action=Add"  modelName="list" selectable="1"/><july:backbutton page="/ShowPeopleList.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
           <july:sepmark/>
           <july:currmark><bean:message key="label.operators"/></july:currmark></td>
      </tr>
        
</july:selectableTable>
</july:browseform>
