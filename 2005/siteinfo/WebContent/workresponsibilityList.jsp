<%@ page language = "java" %>
<%@ page import="com.hps.july.siteinfo.formbean.PositionForm,
                 com.hps.july.apptags.HasRegionAccessTag"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.ObjectType" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5";
	PositionForm pForm=(PositionForm) pageContext.findAttribute("PositionForm");
  boolean hasRegionAccess=pForm.hasRegionAccess(request);

	String journalUrl="/ShowJournalList.do?objecttype="+ObjectType.Workresponsibility+"&objectid="+pForm.getStorageplace();
	String onclickStr="openWindow('/siteinfo"+journalUrl+"');return false;";
%>

<july:browseform action="/ShowWorkresponsibilityList.do">

<table class="main">
<july:separator colspan="<%= gColSpan %>" />
<TR class="normal">
 <TD colspan="<%= gColSpan %>">

    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.workresponsibility.posname"/>:</td>
       <td class="title"><bean:write name="WorkresponsibilityListForm" property="posid" />&nbsp;&nbsp;&nbsp;<bean:write name="WorkresponsibilityListForm" property="posname" /></td>
     </tr>
		<tr>
			<td class="title">&nbsp;</td>
			<td class="title">
				<july:radio property="searchstate" insertable="true" updatable="true" value="0"/><bean:message key="label.search.all"/>
				<july:radio property="searchstate" insertable="true" updatable="true" value="1"/><bean:message key="label.workresponsibility.men"/>
				<july:radio property="searchstate" insertable="true" updatable="true" value="2"/><bean:message key="label.workresponsibility.orgs"/>
				<july:searchbutton/>
			</td>
		</tr>
     </table>
  </TD>
</TR>


    <july:separator colspan="<%= gColSpan %>" />

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
 <%if(hasRegionAccess){%>
 <july:addbutton page="/EditWorkresponsibility.do?action=Add"/>
 <%}%>
 <july:backbutton page="/EditPosition.do?action=View" paramId="storageplace" paramName="WorkresponsibilityListForm" paramProperty="storageplace"/>
           <%--журнал изменений--%>
          <alex:hasAccess href="/ShowJournalList.do" >
            <html:link onclick="<%=onclickStr%>" page="<%=journalUrl%>"  >
               <bean:message key="label.menu.journal"/>
            </html:link>
          </alex:hasAccess>
</TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>

      <july:separator colspan="<%= gColSpan %>" />

    <!-- Table header -->
    <tr class="title">
        <july:headercolumn key="label.workresponsibility.typeresponsibility" colType="string"/>
        <july:headercolumn key="label.workresponsibility.division" colType="string"/>
        <july:headercolumn key="label.workresponsibility.worker" colType="string"/>
        <july:headercolumn key="label.workresponsibility.phone" colType="string"/>
        <TD class="title">&nbsp;</TD>
    </tr>

     <july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
    <logic:iterate id="wrs" name="browseList">
        <logic:present name="wrs">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number">
                    <bean:write name="wrs" property="type.name" filter="true"/>
                </td>
                <td class="text">
					<logic:equal name="wrs" property="resptype" value="W"><bean:write name="wrs" property="worker.division.name" filter="true"/></logic:equal>
					<logic:equal name="wrs" property="resptype" value="O"><bean:write name="wrs" property="organization.name" filter="true"/></logic:equal>
                </td>
                <td class="text">
                    <logic:equal name="wrs" property="resptype" value="W"><bean:write name="wrs" property="worker.man.fullName" filter="true"/></logic:equal>
					<logic:equal name="wrs" property="resptype" value="O"><bean:write name="wrs" property="organization.directorinfo" filter="true"/></logic:equal>
                </td>
                <td class="text">
					<logic:equal name="wrs" property="resptype" value="W">
	                    <bean:write name="wrs" property="worker.mobilephone" filter="true"/>
						<logic:present name="wrs" property="worker.localphone">
							&nbsp;&nbsp;<bean:message key="label.workresponsibility.locphone"/>&nbsp;
							<bean:write name="wrs" property="worker.localphone" filter="true"/>
						</logic:present>
					</logic:equal>
					<logic:equal name="wrs" property="resptype" value="O">
						<bean:write name="wrs" property="organization.phone" filter="true"/>
					</logic:equal>
                </td>
                <td class="link">
                   <july:canedit>
                   <%if(hasRegionAccess){%>
                       <A href="EditWorkresponsibility.do?action=Delete&poscode=<bean:write name='wrs' property='position.storageplace'/>&typecode=<bean:write name='wrs' property='type.responsibilityType'/>&resptype=<bean:write name='wrs' property='resptype'/>">
                            <img src="/images/del.gif" border="0" alt='<bean:message key="label.delete"/>'>
                       </A>
                    <%}%>
                    </july:canedit>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><%if(hasRegionAccess){%><july:addbutton page="/EditWorkresponsibility.do?action=Add"/><%}%><july:backbutton page="/EditPosition.do?action=View" paramId="storageplace" paramName="WorkresponsibilityListForm" paramProperty="storageplace"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>

</table>

</july:browseform>
