<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5"; %>

<july:browseform action="/ShowCurrateHList.do" styleId="curratehform">

<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowCurrencyList.do" styleClass="navigator"><bean:message key="label.currency"/></html:link>
       <july:sepmark/> 
       <july:currmark><bean:message key="label.currateh"/></july:currmark></td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
     <TR>
       <td class="title"><bean:message key="label.currency.code"/>:</td>
       <td class="title"><bean:write name="CurrateHListForm" property="currencyname" /></td>
     </TR>        
     <TR>
       <td class="title"><bean:message key="label.ratetype.code"/>:</td>
       <td class="title"><july:string property="ratetype" styleId="rate" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
          <july:lookupbutton action="/ShowRatetypeLookupList.do" styleId="wpl" fieldNames="ratetype;ratetypename" onclick="set_opt_params_wpl('?ratetype='+document.all.ratetype.value)"  insertable="true" updatable="true" />
          <july:string size="30" property="ratetypename" styleId="ratetypename" insertable="false" updatable="false" />
		  <july:searchbutton/></td>

     </TR>        
     </table>
  </TD>
</TR>


<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditCurrateH.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
      
        <!-- Table header -->
        <tr class="title">
            <TD class="title" width="1%">&nbsp;</TD>
            <july:headercolumn key="label.currateh.date" colType="string"/>
            <july:headercolumn key="label.currateh.value" colType="number"/>
            <TD class="title" width="1%">&nbsp;</TD>
        </tr>


<july:separator colspan="<%= gColSpan %>" />

    
        <!-- Table body -->
        <logic:iterate id="crhl" name="browseList">
	      <logic:present name="crhl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="link">
			<july:canedit>
				<a href='EditCurrateH.do?action=Edit&datestr=<july:datewrite name="crhl" property="date" />' title="<bean:message key='label.edit'/>"><IMG SRC="/images/izmena.gif" BORDER='0' ALT='<bean:message key="label.edit"/>'></a>
			</july:canedit>
		</td>
                <td class="text">
                       <july:datewrite name="crhl" property="date" />
                </td>
                <td class="number">
                    <bean:write name="crhl" property="value" filter="true"/>
                </td>
                <td class="link">
                   <july:canedit>
                   <A href='EditCurrateH.do?action=Delete&datestr=<july:datewrite name="crhl" property="date" />'>
                        <img src="/images/del.gif" border="0" alt='<bean:message key="label.delete"/>'>
                   </A>
                   </july:canedit>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditCurrateH.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
<%--      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowCurrencyList.do" styleClass="navigator"><bean:message key="label.currency"/></html:link>
           <july:sepmark/> 
           <july:currmark><bean:message key="label.currateh"/></july:currmark></td>
      </tr>
--%>        
    </table>

</july:browseform>
