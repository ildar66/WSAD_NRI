<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "6"; %>

<july:browseform action="/ShowCurrencyList.do">

<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <july:currmark><bean:message key="label.currency"/></july:currmark></td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title">&nbsp;</td>
       <td class="title"></td>
     </tr>        
     </table>
    
  </TD>
</TR>


<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditCurrency.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <TD class="title" width="1%">&nbsp;</TD>
            <july:headercolumn key="label.currency.code" colType="number"/>
            <july:headercolumn key="label.currency.name" colType="string"/>
            <july:headercolumn key="label.currency.shortname" colType="string"/>
            <july:headercolumn key="label.currateh" colType="string"/>
            <TD class="title" width="1%">&nbsp;</TD>
        </tr>


<july:separator colspan="<%= gColSpan %>" />

    
        <!-- Table body -->
        <logic:iterate id="cl" name="browseList">
	      <logic:present name="cl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="link">
			<july:editbutton page="/EditCurrency.do" action="Edit" paramId="currency" paramName="cl" paramProperty="currency" paramScope="page"/>
		</td>
                <td class="number">
                    <bean:write name="cl" property="currency" filter="true"/>
                </td>
                <td class="text">
<%--                    <july:editlink page="/EditCurrency.do" action="Edit" paramId="currency" paramName="cl" paramProperty="currency" paramScope="page"> --%>
                    <bean:write name="cl" property="name" filter="true"/>
<%--                    </july:editlink>--%>
                </td>
                <td class="text">
                    <bean:write name="cl" property="shortname" filter="true"/>
                </td>
                <td class="text">
                    <july:link page="/ShowCurrateHList.do" paramId="currency" paramName="cl" paramProperty="currency" paramScope="page" alttext="msg.curratehist">
                        <bean:message key="label.currateh"/>
                    </july:link>
                </td>
                <td class="link"><july:delbutton page="/EditCurrency.do?action=Delete" paramId="currency" paramName="cl" paramProperty="currency" paramScope="page"/></td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditCurrency.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
<%--      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <july:currmark><bean:message key="label.currency"/></july:currmark></td>
      </tr>
--%>        
    </table>

</july:browseform>
