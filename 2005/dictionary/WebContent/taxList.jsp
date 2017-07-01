<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "8"; %>

<july:browseform action="/ShowTaxList.do" styleId="restaxform">

<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <july:currmark><bean:message key="label.restax"/></july:currmark></td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.restype"/>:</td>
       <td class="title"><july:string property="resourcetype" styleId="resourcetype" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
          <july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rtl" fieldNames="resourcetype;resourcetypename" newWindowName="restypelookup" insertable="true" updatable="true"/>
          <july:string size="30" property="resourcetypename" styleId="resourcetypename" insertable="false" updatable="false" /><july:searchbutton />
	   </td>
     </TR>        

     <TR>
       <td class="title"><bean:message key="label.subtype"/>:</td>
       <td class="title"><july:string property="resourcesubtype" styleId="resourcesubtype" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
          <july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="wpl" fieldNames="resourcesubtype;resourcesubtypename" newWindowName="ressbtypelookup" onclick="set_opt_params_wpl('?resourcetype='+document.all.resourcetype.value)" insertable="true" updatable="true"/>
          <july:string size="30" property="resourcesubtypename" styleId="resourcesubtypename" insertable="false" updatable="false" />
	   </td>
     </TR>        
     <TR>
       <td class="title"><bean:message key="label.restax.date"/>:</td>
       <td class="title"><july:date property="filterdatestr" size="25" insertable="true" updatable="true" /></td>
     </TR>        
     </table>
    
  </TD>
</TR>


<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditTax.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <TD class="title" width="1%">&nbsp;</TD>
            <july:headercolumn key="label.restax.resource.code" colType="number"/>
            <july:headercolumn key="label.resource.model" colType="string"/>
            <july:headercolumn key="label.restax.resource.name" colType="string"/>
            <july:headercolumn key="label.restax.date" colType="string"/>
            <july:headercolumn key="label.restax.nds" colType="number"/>
            <july:headercolumn key="label.restax.nsp" colType="number"/>
            <TD class="title" width="1%">&nbsp;</TD>
        </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
        <logic:iterate id="rtl" name="browseList">
            <logic:present name="rtl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="link">
                    <july:canedit>
    					<a href="EditTax.do?action=Edit&resourcecode=<bean:write name='rtl' property='resource.resource'/>&datestr=<july:datewrite name='rtl' property='date'/>" title="<bean:message key='label.edit'/>"><IMG SRC="/images/izmena.gif" BORDER='0' ALT='<bean:message key="label.edit"/>'></a>
                    </july:canedit>
		</td>
                <td class="number">
                    <bean:write name="rtl" property="resource.resource" filter="true"/>
                </td>
                <td class="text">
                          <bean:write name="rtl" property="resource.model" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="rtl" property="resource.name" filter="true"/>
                </td>
                <td class="text">
					<july:datewrite name="rtl" property="date" />
                </td>
                <td class="number">
                    <bean:write name="rtl" property="nds" filter="true"/>
                </td>
                <td class="number">
                    <bean:write name="rtl" property="nsp" filter="true"/>
                </td>
                <td class="link">
                    <july:canedit>
    					<a href="EditTax.do?action=Delete&resourcecode=<bean:write name='rtl' property='resource.resource'/>&datestr=<july:datewrite name='rtl' property='date'/>">
                            <img src="/images/del.gif" border="0" alt='<bean:message key="label.delete"/>'>
    					</a>
                    </july:canedit>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	        </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditTax.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
<%--      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <july:currmark><bean:message key="label.restax"/></july:currmark></td>
      </tr>
--%>        
    </table>

</july:browseform>
