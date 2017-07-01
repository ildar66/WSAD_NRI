<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "6"; %>

<script language="javascript">
	function clickedClassType(){
		document.forms[0].submit();
	}
</script>

<july:browseform action="/ShowClassList.do">

<table class="main">

	<july:separator colspan="<%= gColSpan %>" />
		
	<tr class="title">
    	<td colspan="<%= gColSpan %>">
        	<TABLE class="main">
            	<TR class="title">
            		<TD class="text">
						<july:radio styleClass="text" insertable="true" updatable="true" property="classtype" value="R" onclick="clickedClassType()"/><bean:message key="label.resource.resourceclass"/>&nbsp;&nbsp;&nbsp;
						<july:radio styleClass="text" insertable="true" updatable="true" property="classtype" value="C" onclick="clickedClassType()"/><bean:message key="label.resource.resourcesetclass"/>&nbsp;&nbsp;&nbsp;
					</TD>
        	    </TR>
            </TABLE>
        </TD>
    </tr>
    
    <jsp:useBean id="classlist" class="com.hps.july.dictionary.formbean.ResourceClassListForm"/>
    
    <% 
    String action = (String) request.getAttribute("actionname");
    String delaction = action + "?action=Delete";
    String addaction = action + "?action=Add";
    %>
    
	<july:separator colspan="<%= gColSpan %>" />

    <tr class="title">
	    <td colspan="<%= gColSpan %>">
        	<TABLE class="buttons">
            	<TR class="title">
            		<TD class="buttons"><july:addbutton page="<%= addaction %>"/><july:backbutton/></TD>
    	        	<TD class="navigator"><july:navigator/></TD>
        	    </TR>
            </TABLE>
        </TD>
    </tr>
		
		
	<july:separator colspan="<%= gColSpan %>" />
        
    <!-- Table header -->
    <tr class="title">
        <TD class="title" width="1%">&nbsp;</TD>
        <july:sortcolumn key="label.resource.classid" colType="number" ascFinder="1" descFinder="2"/>
		<july:sortcolumn key="label.resource.classname" colType="string" ascFinder="3" descFinder="4"/>
		<TD class="title" width="1%">&nbsp;</TD>
    </tr>

	<july:separator colspan="<%= gColSpan %>" />
    
    <!-- Table body -->
    <logic:iterate id="rg" name="browseList">
		<logic:present name="rg">
        	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
            	<td class="link">
					<july:editbutton page="<%= action %>" action="Edit" paramId="classid" paramName="rg" paramProperty="classid" paramScope="page"/>					
                </td>
                <td class="number">
                    <bean:write name="rg" property="classid" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="rg" property="classname" filter="true"/>
                </td>
                <td class="link">
                	<july:delbutton page="<%= delaction %>" paramId="classid" paramName="rg" paramProperty="classid" paramScope="page"/>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="<%= action %>?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

    </table>
    
</july:browseform>