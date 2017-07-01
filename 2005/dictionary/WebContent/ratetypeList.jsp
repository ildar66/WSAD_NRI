<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "7"; %>

<july:browseform action="/ShowRatetypeList.do">

<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <july:currmark><bean:message key="label.ratetype"/></july:currmark></td>
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
              <TD class="buttons"><july:addbutton page="/EditRatetype.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <TD class="title">&nbsp;</TD>
            <july:headercolumn key="label.ratetype.code" colType="number"/>
		<july:headercolumn key="label.ratetype.name" colType="string"/>
		<july:headercolumn key="label.ratetype.basecur.code" colType="number"/>
		<july:headercolumn key="label.ratetype.basecur.name" colType="number"/>
		<july:headercolumn key="label.currateh" colType="string"/>
            <TD class="title">&nbsp;</TD>
        </tr>


<july:separator colspan="<%= gColSpan %>" />

    
        <!-- Table body -->
        <logic:iterate id="rtl" name="browseList">
	      <logic:present name="rtl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="link">
			<july:editbutton page="/EditRatetype.do" action="Edit" paramId="ratetype" paramName="rtl" paramProperty="ratetype" paramScope="page"/>
		</td>
                <td class="number">
                   	<bean:write name="rtl" property="ratetype" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="rtl" property="name" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="rtl" property="basecurrency.currency" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="rtl" property="basecurrency.name" filter="true"/>
                </td>
                <td class="text">
                    <july:link page="/ShowCurrateList.do" paramId="ratetype" paramName="rtl" paramProperty="ratetype" paramScope="page" alttext="msg.currate">
                        <bean:message key="label.currateh"/>
                    </july:link>
                </td>
                <td class="link"><july:delbutton page="/EditRatetype.do?action=Delete" paramId="ratetype" paramName="rtl" paramProperty="ratetype" paramScope="page"/></td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditRatetype.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
    </TABLE></TD>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />
<%--      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <july:currmark><bean:message key="label.ratetype"/></july:currmark></td>
      </tr>
--%>        
</table>

</july:browseform>
