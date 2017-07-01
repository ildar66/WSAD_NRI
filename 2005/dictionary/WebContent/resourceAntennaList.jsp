<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "6"; %>

<script language="javascript">
	function clickedHasGroup(){
		document.forms[0].submit();
	}
</script>


<july:browseform action="/ShowResAntennaList.do">

<%--<html:hidden property="donotcommit"/>--%>

<table class="main">

	<july:separator colspan="<%= gColSpan %>" />
		
	<tr class="title">
    	<td colspan="<%= gColSpan %>">
        	<TABLE class="main">
            	<TR class="title">
            		<TD class="text">
						<july:checkbox styleClass="text" property="hasgroup" insertable="true" 
						updatable="true" onclick="clickedHasGroup()"/>
						<bean:message key="label.antacess.assignedgroups"/>
					</TD>
        	    </TR>
            </TABLE>
        </TD>
    </tr>

	<july:separator colspan="<%= gColSpan %>" />

    <tr class="title">
	    <td colspan="<%= gColSpan %>">
        	<TABLE class="buttons">
            	<TR class="title">
    	        	<TD class="navigator"><july:navigator/></TD>
        	    </TR>
            </TABLE>
        </TD>
    </tr>
		
		
		<july:separator colspan="<%= gColSpan %>" />
        
        <!-- Table header -->
        <tr class="title">
            <TD class="title" width="1%">&nbsp;</TD>
            <july:headercolumn key="label.code" colType="number"/>
            <july:headercolumn key="label.name" colType="string"/>
            <july:headercolumn key="label.resource.nrimodel" colType="string"/>
            <july:headercolumn key="label.resource.manufacturer" colType="string"/>
            <july:headercolumn key="label.access.groupid" colType="number"/>
        </tr>

		<july:separator colspan="<%= gColSpan %>" />
    
        <!-- Table body -->
        <logic:iterate id="rg" name="browseList">
	      <logic:present name="rg">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="link">
					<july:editbutton page="/EditResAntenna.do" action="Edit" paramId="resource" paramName="rg" paramProperty="resource" paramScope="page"/>					
                </td>
                <td class="number">
                    <bean:write name="rg" property="resource" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="rg" property="name" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="rg" property="model" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="rg" property="shortname" filter="true"/>
                </td>
                <td class="number">
                    <bean:write name="rg" property="groupid" filter="true"/>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditResAntenna.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

    </table>
    
</july:browseform>
