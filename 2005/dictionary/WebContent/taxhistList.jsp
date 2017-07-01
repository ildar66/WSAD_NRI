<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5"; %>

<july:browseform action="/ShowTaxhistList.do" styleId="restaxhistform">

<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
    	   <html:link page="/ShowRestypeList.do" styleClass="navigator"><bean:message key="label.restypes"/></html:link>
           <july:sepmark/> 
           <html:link page="/ShowRessbtypeList.do" styleClass="navigator"><bean:message key="label.subtypes"/></html:link> 
           <july:sepmark/> 
           <html:link page="/ShowResourceList.do" styleClass="navigator"><bean:message key="label.resource"/></html:link> 
           <july:sepmark/> 
	       <july:currmark><bean:message key="label.restaxhist"/></july:currmark></td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
     <TR>
       <td class="title"><bean:message key="label.restaxhist.resource"/>:</td>
       <td class="title"><july:string property="resource" styleId="resource" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
          <july:lookupbutton action="/ShowResourceLookupList.do" styleId="wpl" fieldNames="resource;resourcemodel;resourcename" insertable="true" updatable="true" /> <%--  onclick="set_opt_params_wpl('?resourcesubtype='+document.all.resourcesubtype.value)" --%>
          <july:string size="25" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" /><BR>
          <july:string size="50" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
		  <july:searchbutton/>
	   </td>
     </TR>
<%--
     <TR>
       <td class="title"><bean:message key="label.restax.date"/>:</td>
       <td class="title"><july:string styleClass="search" property="datestr" size="14" insertable="true" updatable="true" /><INPUT TYPE="image" src="images/refresh.gif"  border="0" alt='<bean:message key="button.refresh"/>'></td>
     </TR>
--%>
     </table>
    
  </TD>
</TR>


<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditTaxhist.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <TD class="title" width="1%">&nbsp;</TD>
            <july:headercolumn key="label.restaxhist.date" colType="link"/>
            <july:headercolumn key="label.restaxhist.nds" colType="link"/>
            <july:headercolumn key="label.restaxhist.nsp" colType="link"/>
            <TD class="title" width="1%">&nbsp;</TD>
        </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
        <logic:iterate id="rtl" name="browseList">
            <logic:present name="rtl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="link">
		<july:canedit>
                   <A href='EditTaxhist.do?action=Edit&datestr=<july:datewrite name="rtl" property="date" />'  title="<bean:message key='label.edit'/>"><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
                   </july:canedit>
		</td>
                <td class="number">
                       <july:datewrite name="rtl" property="date" />
                </td>
                <td class="text">
                    <bean:write name="rtl" property="nds" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="rtl" property="nsp" filter="true"/>
                </td>
                <td class="link">
                   <july:canedit>
                   <A href='EditTaxhist.do?action=Delete&datestr=<july:datewrite name="rtl" property="date" />'>
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
              <TD class="buttons"><july:addbutton page="/EditTaxhist.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
<%--      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
        	   <html:link page="/ShowRestypeList.do" styleClass="navigator"><bean:message key="label.restypes"/></html:link>
               <july:sepmark/> 
               <html:link page="/ShowRessbtypeList.do" styleClass="navigator"><bean:message key="label.subtypes"/></html:link> 
               <july:sepmark/> 
               <html:link page="/ShowResourceList.do" styleClass="navigator"><bean:message key="label.resource"/></html:link> 
               <july:sepmark/> 
    	       <july:currmark><bean:message key="label.restaxhist"/></july:currmark></td>
      </tr>
--%>        
    </table>

</july:browseform>
