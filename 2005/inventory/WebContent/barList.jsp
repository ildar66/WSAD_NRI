<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "7"; %>

<july:browseform action="/ShowBarList.do">

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
     <TR>
       <td class="title">&nbsp;</td>
       <td class="title">&nbsp;</td>
     </TR>        
     </table>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditBar.do?action=Add"/><july:backbutton page="/main.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <july:sortcolumn ascFinder="findOrderBySerprefixAsc" 
                             descFinder="findOrderBySerprefixDesc" 
                             key="label.bar.ser" colType="string"/>
            <july:sortcolumn ascFinder="findOrderBySerstartAsc" 
                             descFinder="findOrderBySerstartDesc" 
                             key="label.bar.start" colType="string"/>
            <july:headercolumn key="label.bar.end" colType="string"/>
            <july:headercolumn key="label.bar.date" colType="string"/>
            <july:headercolumn key="label.bar.worker" colType="string"/>
            <TD class="title">&nbsp;</TD>
            <TD class="title">&nbsp;</TD>
        </tr>


<july:separator colspan="<%= gColSpan %>" />

    
        <!-- Table body -->
        <logic:iterate id="br" name="browseList">
	      <logic:present name="br">
		    
            <tr selectableID='<bean:write name="br" property="serid" filter="true"/>' classReal='"normal"' class='"normal"' id='selID<bean:write name="br" property="serid" filter="true"/>' onMouseOver='className="select"' onMouseOut='className="normal"'>
                <td class="text">
                      <bean:write name="br" property="serprefix" filter="true"/>
					  <a name="selID<bean:write name="br" property="serid" filter="true"/>"></a>
                </td>
                <td class="text">
                    <july:editlink page="/EditBar.do" action="View" paramId="serid" paramName="br" paramProperty="serid" paramScope="page">
						<bean:write name="br" property="serstart" filter="true"/>
                    </july:editlink>
                </td>
                <td class="text">
                      <bean:write name="br" property="serend" filter="true"/>
                </td>
                <td class="text">
                      <july:datewrite name="br" property="serdate"/>
                </td>
                <td class="text">
                      <bean:write name="br" property="serworker.man.fullName" filter="true"/>
                </td>
                <td class="link">
                    <july:printbutton page="/BarParams.do" paramId="serid" paramName="br" paramProperty="serid" paramScope="page" />
                </td>
                <td class="link">
                   <july:delbutton page="/EditBar.do?action=Delete" paramId="serid" paramName="br" paramProperty="serid" paramScope="page"/>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditBar.do?action=Add"/><july:backbutton page="/main.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
          
        
    </july:selectableTable>

</july:browseform>
