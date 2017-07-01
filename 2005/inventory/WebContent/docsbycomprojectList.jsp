<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5"; %>

<july:browseform action="/ShowDocsByComprojectList.do">

	<table class="main">

		<july:separator colspan="<%= gColSpan %>" />

		<TR class="normal">
		 <TD colspan="<%= gColSpan %>">
		 
		    <table class="find">
		    <TR>
		       <td class="title"><bean:message key="label.docsbycomproj.project"/></td>
		       <td class="title"><bean:write name="DocsByComprojectListForm" property="projectname" filter="true"/></td>
		     </tr>        
		     </table>
		    
		  </TD>
		</TR>
		
		
		<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:closebutton page=""/></TD>
              <TD class="navigator"></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <TD class="title" width="1%">&nbsp;</TD>
            <july:headercolumn key="label.docsbycomproj.document" colType="string"/>
            <july:headercolumn key="label.docsbycomproj.date" colType="string"/>
            <july:headercolumn key="label.docsbycomproj.number" colType="string"/>
            <july:headercolumn key="label.docsbycomproj.storageplace" colType="string"/>
        </tr>


		<july:separator colspan="<%= gColSpan %>" />

    
        <!-- Table body -->
        <logic:iterate id="cl" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
	      <logic:present name="cl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="link">
				</td>
                <td class="text">
                	<bean:message key='<%= "label.doctype." + cl.getColumn("docname").asString() %>'/>
                </td>
                <td class="text">
                    <july:datewrite name="cl" property="blankdate"/>
                </td>
                <td class="text">
                	<july:stringwrite name="cl" property="docnum"/>
                </td>
                <td class="text">
                	<july:stringwrite name="cl" property="positionname"/>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:closebutton page="" /></TD>
              <TD class="navigator"></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
      
    </table>

</july:browseform>
