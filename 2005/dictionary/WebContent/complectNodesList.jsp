<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "4"; %>

<july:browseform action="/ShowComplectNodesList.do" styleId="cflist">

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
       <july:currmark><bean:message key="label.complectnodes"/></july:currmark></td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.complectnodes.complect"/>:</td>
       <td class="title"><july:string property="resource" styleId="resource" size="5" insertable="true" updatable="true" styleClass="editkodsearch" />
			<july:lookupbutton action="/ShowResourceLookupList.do" styleId="ul" fieldNames="resource;resourcemodel;resourcename" insertable="true" updatable="true" />
			<july:string size="10" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" /><BR>
			<july:string size="30" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
			<july:searchbutton/></td>
     </tr>        
     </table>
    
  </TD>
</TR>


<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:includebutton page="/EditComplectNodes.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <july:headercolumn key="label.complectnodes.part.code" colType="number"/>
            <july:headercolumn key="label.resource.model" colType="string"/>
            <july:headercolumn key="label.complectnodes.part.name" colType="string"/>
            <TD class="title">&nbsp;</TD>
        </tr>


<july:separator colspan="<%= gColSpan %>" />

    
        <!-- Table body -->
        <logic:iterate id="ul" name="browseList">
	      <logic:present name="ul">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number">
                    <bean:write name="ul" property="parts.resource" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="ul" property="parts.model" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="ul" property="parts.name" filter="true"/>
                </td>
                <td class="link"><july:excludebutton page="/EditComplectNodes.do?action=Delete" paramId="partcode" paramName="ul" paramProperty="parts.resource" paramScope="page"/></td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:includebutton page="/EditComplectNodes.do?action=Add"/><july:backbutton/></TD>
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
           <july:currmark><bean:message key="label.complectnodes"/></july:currmark></td>
      </tr>
--%>        
    </table>

</july:browseform>
