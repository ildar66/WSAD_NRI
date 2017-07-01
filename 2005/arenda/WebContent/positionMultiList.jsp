<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% java.lang.String gColSpan = "7"; %>


<%
    String action = null;
	String form = null;
	String parent = null;
	String parent2 = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.POS_MULTI:
        	action = "/ShowPositionMultiList.do";
			form = "PositionMultiListForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowArendaPositionsList.do";
        	break;
		case APPStates.HISTORY_POS_MULTI:
        	action = "/ShowHistoryPositionMultiList.do";
			form = "HistoryPositionMultiListForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowHistoryArendaPositionsList.do";
        	break;
    }
%>


<july:browseform action="<%= action %>" styleId="<%= form %>">


<script language="javascript">
function switchNZoneSearch(state) {
	if(state) {
		<%= form %>.netzone.className = 'editdisabled';
		<%= form %>.netzone.disabled = true;
	} else {
		<%= form %>.netzone.className = 'search';
		<%= form %>.netzone.disabled = false;
	}
}
function switchRenterSearch(state) {
	if(state) {
		<%= form %>.organization.className = 'editkoddisabled';
		<%= form %>.organization.disabled = true;
		document.all['lookupimg_r1l'].src='/images/lookup_disabled.gif';
	} else {
		<%= form %>.organization.className = 'editkodsearch';
		<%= form %>.organization.disabled = false;
		document.all['lookupimg_r1l'].src='/images/lookup.gif';
	}
}
function switchWorkerSearch(state) {
	if(state) {
		<%= form %>.worker.className = 'editkoddisabled';
		<%= form %>.worker.disabled = true;
		document.all['lookupimg_wrkl'].src='/images/lookup_disabled.gif';
	} else {
		<%= form %>.worker.className = 'editkodsearch';
		<%= form %>.worker.disabled = false;
		document.all['lookupimg_wrkl'].src='/images/lookup.gif';
	}
}
function switchAllSearch() {
	if(<%= form %>.searchmode [0].checked) {
		<%= form %>.searchstr.className = 'editdisabled';
		<%= form %>.searchstr.disabled = true;
	} else {
		<%= form %>.searchstr.className = 'editsearch';
		<%= form %>.searchstr.disabled = false;
	}
}
</script>


<table class="main">


<july:separator colspan="<%= gColSpan %>"/>


<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
        <td><bean:message key="label.position.netzonename"/></td>
        <td><july:checkbox insertable="true" updatable="true" property="isnetzone" styleId="isnetzone" onclick="switchNZoneSearch(document.all.isnetzone[0].checked)"/><html:hidden property="isnetzone" value="false"/><bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:select collection="netzones" property="netzone" insertable="true" updatable="true">
				<html:options collection="netzones" property="netzone" labelProperty="name"/>
			</july:select><july:searchbutton/>
		</td>
     </tr>
    <TR>
        <td><bean:message key="label.position.searchby"/></td>
        <td>
			<july:radio insertable="true" updatable="true" property="searchmode" value="0" onclick="switchAllSearch()"/><bean:message key="label.position.search.all"/><br>
			<july:radio insertable="true" updatable="true" property="searchmode" value="1" onclick="switchAllSearch()"/><bean:message key="label.position.search.gsmid"/><br>
			<july:radio insertable="true" updatable="true" property="searchmode" value="2" onclick="switchAllSearch()"/><bean:message key="label.position.search.dampsid"/><br>
			<july:radio insertable="true" updatable="true" property="searchmode" value="3" onclick="switchAllSearch()"/><bean:message key="label.position.search.name"/><br>
			<july:radio insertable="true" updatable="true" property="searchmode" value="4" onclick="switchAllSearch()"/><bean:message key="label.position.search.addr"/><br>
		</td>
     </tr>
	      
    <TR>
        <td><bean:message key="label.position.search.text"/></td>
        <td>
			<html:text styleClass="search" property="searchstr" size="35"/>
		</td>
     </tr>
	 
	<TR>
		<td class="title"><bean:message key="label.position.renter"/></td>
		<td class="title"><july:checkbox property="isRenter" styleId="isRenter" insertable="true" updatable="true" onclick="switchRenterSearch(document.all.isRenter[0].checked)"/>&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;
			<july:string property="organization" styleId="organization" size="5" insertable="true" updatable="true"/>
			<july:lookupbutton action="/ShowRenterLookupList.do" styleId="r1l" newWindowName="wrkwnd" fieldNames="organization;orgname" insertable="true" updatable="true" onclick="if (document.all.isRenter[0].checked) { return false; }"/>
			<july:string size="25" property="orgname" styleId="orgname" insertable="false" updatable="false"/>
		</td>
	</tr>
	
    <TR>
       <td class="title"><bean:message key="label.position.worker"/></td>
       <td class="title"><july:checkbox property="isWorker" styleId="isWorker" insertable="true" updatable="true" onclick="switchWorkerSearch(document.all.isWorker[0].checked)"/>&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;
          <july:string property="worker" styleId="worker" size="5" insertable="true" updatable="false"/>
          <july:lookupbutton action="/ShowWorkerLookupList.do" newWindowName="wrkwnd" styleId="wrkl" fieldNames="worker;workername" insertable="true" updatable="false" onclick="if (document.all.isWorker[0].checked) { return false; }"/>
          <july:string size="25" property="workername" styleId="workername"  insertable="false" updatable="false"/>
       </td>
    </TR>
	
    <TR>
       <td class="title"><bean:message key="label.position.inaction"/></td>
       <td class="title"><july:radio  styleClass="editcheckbox" property="inaction" value="A" insertable="true" updatable="true"/><bean:message key="label.position.inaction.all"/>
              &nbsp;<july:radio styleClass="editcheckbox" property="inaction" value="B" insertable="true" updatable="true"/><bean:message key="label.position.inaction.yes"/>
              &nbsp;<july:radio styleClass="editcheckbox" property="inaction" value="C" insertable="true" updatable="true"/><bean:message key="label.position.inaction.no"/>
       </td>
     </TR>


</table>
    
  </TD>
</TR>


<script language="javascript">
  switchNZoneSearch(document.all.isnetzone[0].checked);
  switchRenterSearch(document.all.isRenter[0].checked);
  switchWorkerSearch(document.all.isWorker[0].checked);
  switchAllSearch();
</script>


<july:separator colspan="<%= gColSpan %>"/>


      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:savebutton/><july:backbutton page="<%= parent2 %>"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>"/>
  
    <!-- Table header -->
    <tr class="title">
            <july:sortcolumn key="label.position.bsid" colType="string"
                   ascFinder="5" descFinder="6"/>
            <july:sortcolumn key="label.position.name" colType="string"
                   ascFinder="3" descFinder="4"/>
            <july:headercolumn key="label.position.addr" colType="string"/>
            <july:headercolumn key="label.position.netzone" colType="string"/>
            <july:headercolumn key="label.position.inactionh" colType="string"/>
            <july:sortcolumn key="label.code" colType="number"
                   ascFinder="1" descFinder="2"/>
			<td class="title">&nbsp;</td>
    </tr>


	<july:separator colspan="<%= gColSpan %>"/>


        <!-- Table body -->
    <logic:iterate id="pos" name="browseList">
        <logic:present name="pos">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="text">
                    <logic:present name="pos" property="gsmid">
						D<bean:write name="pos" property="gsmid" filter="true"/>
					</logic:present>
                    <logic:present name="pos" property="dampsid">
	                    A<bean:write name="pos" property="dampsid" filter="true"/>
					</logic:present> 
                </td>
                <td class="text">
                   <bean:write name="pos" property="name" filter="true"/>
                   <logic:present name="pos" property="dampsname">
                     <% java.lang.String s = ""; %>
                     <logic:notEqual name="pos" property="dampsname" value="<%= s %>">
                         &nbsp;/&nbsp;<bean:write name="pos" property="dampsname" filter="true"/>
                     </logic:notEqual>
                   </logic:present>
                </td>
                <td class="text">
					<bean:write name="pos" property="address" filter="true"/>
                </td>
				
                <td class="text">
                    <logic:present name="pos" property="netZone">
	                    <bean:write name="pos" property="netZone.zonecode" filter="true"/>
					</logic:present>
                </td>
				
                <td class="text">
					<logic:present name="pos" property="inAction">
						<logic:equal name="pos" property="inAction" value="true"><bean:message key="label.position.inactionh"/></logic:equal>
					</logic:present>
                </td>
                <td class="number"><bean:write name="pos" property="storageplace" filter="true"/></td>
				
                <% java.lang.String s = (java.lang.String)(RequestUtils.lookup(pageContext, "pos", "storageplace", null).toString()); %>
                <td class="link"><july:checkbox property="selectedPos" value="<%= s %>" insertable="true" updatable="true"/></td>
            </tr>


            <july:separator colspan="<%= gColSpan %>"/>


	      </logic:present>
      </logic:iterate>
      
      <INPUT TYPE="HIDDEN" NAME="selectedPos" VALUE="0">


      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:savebutton/><july:backbutton page="<%= parent2 %>"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>"/>
      
</table>


</july:browseform>

