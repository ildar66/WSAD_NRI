<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "7"; %>

<july:browseform action="/ShowComplectContentList.do">

<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
        <html:link page="/ShowRestypeList.do" styleClass="navigator"><bean:message key="label.restypes"/></html:link>
        <july:sepmark/> 
        <html:link page="/ShowRessbtypeList.do" styleClass="navigator"><bean:message key="label.subtypes"/></html:link>
        <july:sepmark/> 
        <html:link page="/ShowComplectList.do" styleClass="navigator"><bean:message key="label.complects"/></html:link>
        <july:sepmark/> 
        <july:currmark><bean:message key="label.content"/></july:currmark></td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<tr class="normal">
 <td colspan="<%= gColSpan %>">
    <table class="find">
    <tr>
       <td class="title"><bean:message key="label.complect"/>:</td>
       <td class="title"><bean:write name="ComplectContentListForm" property="resourcesetname" /></td>
    </tr>
    </table>
  </td>
</tr>


<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditComplectContent.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <TD class="title" width="1%">&nbsp;</TD>
            <july:headercolumn key="label.content.code" colType="number"/>
            <july:headercolumn key="label.resource.model" colType="string"/>
            <july:headercolumn key="label.content.name" colType="string"/>
            <july:headercolumn key="label.content.qty.short" colType="number"/>
            <july:headercolumn key="label.content.unit.short" colType="number"/>
            <TD class="title" width="1%">&nbsp;</TD>
        </tr>


<july:separator colspan="<%= gColSpan %>" />

    
        <!-- Table body -->
        <logic:iterate id="ul" name="browseList">
	      <logic:present name="ul">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="link">
			<july:editbutton page="/EditComplectContent.do" action="Edit" paramId="resourcepart" paramName="ul" paramProperty="part.resource" paramScope="page"/>
		</td>
                <td class="number">
                    <bean:write name="ul" property="part.resource" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="ul" property="part.model" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="ul" property="part.name" filter="true"/>
                </td>
                <td class="number">
                    <july:numberwrite name="ul" property="qty"/>
                </td>
                <td class="text">
                    <logic:present name="ul" property="part.unit">
	                  <bean:write name="ul" property="part.unit.shortname" filter="true"/>
                    </logic:present>
                </td>
                <td class="link"><july:delbutton page="/EditComplectContent.do?action=Delete" paramId="resourcepart" paramName="ul" paramProperty="part.resource" paramScope="page"/></td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditComplectContent.do?action=Add"/><july:backbutton/></TD>
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
            <html:link page="/ShowComplectList.do" styleClass="navigator"><bean:message key="label.complects"/></html:link>
            <july:sepmark/> 
            <july:currmark><bean:message key="label.content"/></july:currmark></td>
      </tr>
--%>        
    </table>

</july:browseform>
