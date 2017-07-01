<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.formbean.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% String gColSpan = "6"; %>


<%	String action = null;
	String form = null;
	String actionJournal = null;
	String parent = null;
	String parent2 = null;
	String parent3 = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.START_ACT_LIST:
        	action = "/ShowStartActList.do";
			form = "StartActListForm";
			actionJournal = "/ShowJournalActList.do";
			parent2 = "/ShowMutualReglamentsList.do";
			parent3 = "/ShowMutualActsList.do";
        	break;
		case APPStates.FROMCONTRACT_START_ACT_LIST:
        	action = "/ShowFromContractStartActList.do";
			form = "FromContractStartActListForm";
			actionJournal = "/ShowFromContractJournalActList.do";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowFromContractMutualReglamentsList.do";
			parent3 = "/ShowFromContractMutualActsList.do";
        	break;
		case APPStates.FROMHISTORY_START_ACT_LIST:
        	action = "/ShowFromHistoryStartActList.do";
			form = "FromHistoryStartActListForm";
			actionJournal = "/ShowFromHistoryJournalActList.do";
			parent = "/ViewHistory.do";
			parent2 = "/ShowFromHistoryMutualReglamentsList.do";
			parent3 = "/ShowFromHistoryMutualActsList.do";
        	break;
    } %>


<july:browseform action="<%= action %>" styleId="<%= form %>">


<script language="javascript">
function switchTaskType() {
	if (document.all.isTaskType[0].checked) {
		<%= form %>.taskType.className = 'editdisabled';
		<%= form %>.taskType.disabled = true;
	} else {
		<%= form %>.taskType.className = 'editsearch';
		<%= form %>.taskType.disabled = false;
	}
}
</script>


<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.FROMCONTRACT_START_ACT_LIST ||
				ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_START_ACT_LIST) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_START_ACT_LIST) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
	        	<% } %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
				<july:sepmark/>
			<%	} %>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.mutualreglmnts"/></html:link>
			<july:sepmark/>
			<html:link page="<%= parent3 %>" styleClass="navigator"><bean:message key="label.mutualacts"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.startact"/></july:currmark>
		</td>
	</tr>
--%>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text"><bean:message key="label.startact.actcode"/>:</td>
					<td class="text" nowrap><bean:write name="<%= form %>" property="actCode" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.startact.actnumber"/>:</td>
					<td class="text" nowrap><bean:write name="<%= form %>" property="actNumber" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.startact.actdate"/>:</td>
					<td class="text" nowrap><july:datewrite name="<%= form %>" property="actDate"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.startact.actperiod"/>:</td>
					<td class="text" nowrap>
						<july:datewrite name="<%= form %>" property="actStartDate"/>&nbsp;
						<bean:message key="label.filter.stop"/>&nbsp;
						<july:datewrite name="<%= form %>" property="actEndDate"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.startact.actiontype"/>:</td>
					<td class="text" nowrap>
						<july:checkbox property="isTaskType" insertable="true" updatable="true" onclick="switchTaskType()"/>&nbsp;
						<bean:message key="label.filter.all"/>&nbsp;
						<july:select styleId="taskType" style="width: 300;" property="taskType" insertable="true" updatable="true">
							<html:option key="label.taskstart.tasktype.d" value="4"/>
							<html:option key="label.taskstart.tasktype.e" value="5"/>
						</july:select>
						<july:searchbutton/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
<script language="javascript">
	switchTaskType();
</script>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons"><july:backbutton page="<%= parent3 %>"/></td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<!-- Table header -->
	<tr class="title">
		<july:headercolumn key="label.startact.code" colType="string"/>
		<july:sortcolumn key="label.startact.startdate" colType="string" ascFinder="1" descFinder="2"/>
		<july:headercolumn key="label.startact.enddate" colType="string"/>
		<july:headercolumn key="label.startact.actiontype" colType="string"/>
		<july:headercolumn key="label.startact.operator" colType="string"/>
		<td class="title">&nbsp;</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="number">
					<bean:write name="it" property="taskstart" filter="true"/>
                </td>
				<td class="date">
					<july:datewrite name="it" property="startdate" showtime="true"/>
                </td>
 				<td class="date">
                    <july:datewrite name="it" property="enddate" showtime="true"/>
                </td>
				<td class="text">
					<logic:equal name="it" property="tasktype" value="4"><bean:message key="label.taskstart.tasktype.d"/></logic:equal>
					<logic:equal name="it" property="tasktype" value="5"><bean:message key="label.taskstart.tasktype.e"/></logic:equal>
                </td>
 				<td class="text">
					<logic:present name="it" property="startOperator">
						<bean:write name="it" property="startOperator.man.fullName" filter="true"/>
					</logic:present>
                </td>
				<td class="link">
					<july:link page="<%= actionJournal %>" paramId="taskStart" paramName="it" paramProperty="taskstart" paramScope="page">
						<bean:message key="label.startact.journal.short"/>
					</july:link>
				</td>
			</tr>
			<july:separator colspan="<%= gColSpan %>"/>
		</logic:present>
	</logic:iterate>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons"><july:backbutton page="<%= parent3 %>"/></td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
		
	<july:separator colspan="<%= gColSpan %>"/>
	
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.FROMCONTRACT_START_ACT_LIST ||
				ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_START_ACT_LIST) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_START_ACT_LIST) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
	        	<% } %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
				<july:sepmark/>
			<%	} %>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.mutualreglmnts"/></html:link>
			<july:sepmark/>
			<html:link page="<%= parent3 %>" styleClass="navigator"><bean:message key="label.mutualacts"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.startact"/></july:currmark>
		</td>
	</tr>
--%>


</table>


</july:browseform>

