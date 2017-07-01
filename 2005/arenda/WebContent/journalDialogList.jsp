<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.formbean.*,com.hps.july.arenda.*,com.hps.july.persistence.*,org.apache.struts.action.*,org.apache.struts.util.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% String gColSpan = "2"; %>


<%	String action = "/JournalList";
	String form = "JournalListForm";
%>


<july:browseform action="<%= action %>" styleId="<%= form %>">


<%	JournalProlongationsListForm listForm = ((JournalProlongationsListForm) request.getSession().getAttribute(form)); %>


<table class="main">

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text">
						<%	if (ParamsParser.getState(pageContext) == APPStates.JOURNAL_PROLONGATIONS_LIST) { %>
							<bean:message key="label.autoproc.prolongation.date"/>:
						<%	} else { %>
							<bean:message key="label.autoproc.date"/>:
						<%	} %>
					</td>
					<td class="text" nowrap>
						<%	if (ParamsParser.getState(pageContext) == APPStates.JOURNAL_PROLONGATIONS_LIST) { %>
							<july:datewrite name="<%= form %>" property="firstDate"/>&nbsp;
						<%	} %>
						<bean:message key="label.filter.stop"/>&nbsp;
						<july:datewrite name="<%= form %>" property="secondDate"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.autoproc.prolongation.operator"/>:</td>
					<td class="text" nowrap>
						<bean:write name="<%= form %>" property="operatorname" filter="true"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.autoproc.prolongation.timeperiod"/>:</td>
					<td class="text" nowrap>
						<july:datewrite name="<%= form %>" property="startDate" showtime="true"/>&nbsp;
						<bean:message key="label.filter.stop"/>&nbsp;
						<july:datewrite name="<%= form %>" property="endDate" showtime="true"/>
					</td>
				</tr>
				
				<tr>
					<td class="text"><bean:message key="label.journal.message.type"/>:</td>
					<td class="text">
						<july:checkbox property="isSuccess" insertable="true" updatable="true"/><bean:message key="label.journal.message.type.success"/>
						<july:checkbox property="isWarning" insertable="true" updatable="true"/><bean:message key="label.journal.message.type.warning"/>
						<july:checkbox property="isError" insertable="true" updatable="true"/><bean:message key="label.journal.message.type.error"/>
						<july:searchbutton/>
					</td>		
				</tr>
				
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons"></td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<!-- Table header -->
	<tr class="title">
		<july:headercolumn key="label.journal.message.type" colType="string"/>
		<july:headercolumn key="label.journal.message" colType="string"/>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="text">
					<logic:equal name="it" property="jrntype" value="S"><bean:message key="label.journal.message.type.success"/></logic:equal>
					<logic:equal name="it" property="jrntype" value="W"><bean:message key="label.journal.message.type.warning"/></logic:equal>
					<logic:equal name="it" property="jrntype" value="E"><bean:message key="label.journal.message.type.error"/></logic:equal>
				</td>
				
 				<td class="text">
						<bean:write name="it" property="jrnmessage" filter="true"/>
                </td>
			</tr>
			<july:separator colspan="<%= gColSpan %>"/>
		</logic:present>
	</logic:iterate>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
		
	<july:separator colspan="<%= gColSpan %>"/>
	
</table>


</july:browseform>

