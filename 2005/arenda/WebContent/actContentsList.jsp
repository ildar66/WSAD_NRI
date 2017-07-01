<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<html:form action="/ShowActContentsList.do" styleId="ActContentsListForm">

<html:hidden property="actcode"/>
<html:hidden property="action_process"/>
<html:hidden property="action"/>

<table class="main">

<july:separator colspan="1"/>

	<TR class="normal">
		<TD>
			<table class="find">
				<tr>
					<td class="text"><bean:message key="label.mutualacts.actnumber"/></td>
					<td class="text"><bean:write name="ActContentsListForm" property="actnumber" filter="true"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.mutualacts.actdate"/></td>
					<td class="text"><july:datewrite name="ActContentsListForm" property="actdate"/>
						<july:searchbutton/>
					</td>
				</tr>
				<logic:notEqual name="ActContentsListForm" property="action" value="View">
				<tr>
					<td class="text" colspan="2">
					<html:link styleClass="button" page="/ActContentsRecalculate.do" paramId="actcode" paramName="ActContentsListForm" paramProperty="actcode">
						<bean:message key="label.actcontents.defact"/>
					</html:link>
					</td>
				</tr>
				</logic:notEqual>
			</table>
		</TD>
	</TR>
	
	<july:separator colspan="1"/>
	
	<tr class="title">
		<td class="text">
			<logic:notEqual name="ActContentsListForm" property="action" value="View">
				<%--july:savebutton/--%>
				<input type='image' name='submit' src='/images/save.gif' alt='Сохранить' onclick = "window.document.forms(0).all('action_process').value='1';">
			</logic:notEqual>
			<july:backbutton/>
		</td>
	</tr>

	<july:separator colspan="1"/>
	
	<tr class="title">
		<td class="text"><B><bean:message key="label.actcontents.header1"/></B></td>
	</tr>

	<TR>
		<TD>
			<table class="main">
				<%
					int curDocument = 0;
				%>
				<logic:iterate id="it" name="table1">
					<logic:present name="it">
					<%
						com.hps.july.arenda.valueobject.ActContentsValueObject ob = (com.hps.july.arenda.valueobject.ActContentsValueObject)it;
						if (ob.getLeasedocument() != curDocument) {
							curDocument = ob.getLeasedocument();
					%>
						<tr class="normal">
							<td colspan="6">
								<bean:message key="label.actcontents.contract"/>: <bean:write name="it" property="docnumber" filter="true"/>
								<bean:message key="label.actcontents.cdate"/> <july:datewrite name="it" property="docdate"/>, 
								<bean:message key="label.actcontents.orgname"/>: <bean:write name="it" property="orgname" filter="true"/>
							</td>
						</tr>
						<!-- Table header -->
						<tr class="title">
							<july:headercolumn key="label.actcontents.resource" colType="string"/>
							<july:headercolumn key="label.actcontents.sdate" colType="string"/>
							<july:headercolumn key="label.actcontents.edate" colType="string"/>
							<july:headercolumn key="label.actcontents.summ" colType="string"/>
							<july:headercolumn key="label.actcontents.currency" colType="string"/>
							<july:headercolumn key="label.actcontents.willbeinact" colType="string"/>
						</tr>
					<%
						}
					%>

						<july:separator colspan="6"/>

						<!-- Table body -->
						<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
							
							<td class="text">
								<bean:write name="it" property="resname" filter="true"/>
							</td>
							
							<td class="text">
								<july:datewrite name="it" property="begindate"/>
							</td>

							<td class="text">
								<july:datewrite name="it" property="enddate"/>
							</td>

							<td class="text" NOWRAP align="right">
								<july:numberwrite name="it" property="summ" fractdigits="2"/>
							</td>

							<td class="text">
								<bean:write name="it" property="currname" filter="true"/>
							</td>
							
							<td class="text">
								<july:checkbox property="selchrgd" value="<%= new Integer(ob.getLeasedocposition()).toString() %>"
									insertable="true" updatable="true"/>
							</td>
						</tr>
					  </logic:present>
					</logic:iterate>
			</table>
		</td>
	</tr>

	<tr>
		<td>&nbsp;</td>
	</tr>

	<july:separator colspan="1"/>
	
	<tr class="title">
		<td class="text"><B><bean:message key="label.actcontents.header2"/></B></td>
	</tr>

	<TR>
		<TD>
			<table class="main">
				<%
					curDocument = 0;
				%>
				<logic:iterate id="it" name="table2">
					<logic:present name="it">
					<%
						com.hps.july.arenda.valueobject.ActContentsValueObject ob = (com.hps.july.arenda.valueobject.ActContentsValueObject)it;
						if (ob.getLeasedocument() != curDocument) {
							curDocument = ob.getLeasedocument();
					%>
						<tr class="normal">
							<td colspan="8">
								<bean:message key="label.actcontents.ban"/>: <bean:write name="it" property="ban" filter="true"/>
								<bean:message key="label.actcontents.ben"/>: <bean:write name="it" property="ben" filter="true"/>, 
								<bean:message key="label.actcontents.orgname"/>: <bean:write name="it" property="orgname" filter="true"/>
							</td>
						</tr>
						<!-- Table header -->
						<tr class="title">
							<july:headercolumn key="label.actcontents.billdate" colType="string"/>
							<july:headercolumn key="label.actcontents.billnumber" colType="string"/>
							<july:headercolumn key="label.actcontents.resource" colType="string"/>
							<july:headercolumn key="label.actcontents.sdate" colType="string"/>
							<july:headercolumn key="label.actcontents.edate" colType="string"/>
							<july:headercolumn key="label.actcontents.summ" colType="string"/>
							<july:headercolumn key="label.actcontents.currency" colType="string"/>
							<july:headercolumn key="label.actcontents.willbeinact" colType="string"/>
						</tr>
					<%
						}
					%>

						<july:separator colspan="8"/>

						<!-- Table body -->
						<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
							
							<td class="text">
								<bean:write name="it" property="billnumber" filter="true"/>
							</td>
							
							<td class="text">
								<july:datewrite name="it" property="billdate"/>
							</td>

							<td class="text">
								<bean:write name="it" property="resname" filter="true"/>
							</td>
							
							<td class="text">
								<july:datewrite name="it" property="begindate"/>
							</td>

							<td class="text">
								<july:datewrite name="it" property="enddate"/>
							</td>

							<td class="text" NOWRAP align="right">
								<july:numberwrite name="it" property="summ" fractdigits="2"/>
							</td>

							<td class="text">
								<bean:write name="it" property="currname" filter="true"/>
							</td>
							
							<td class="text">
								<july:checkbox property="selchrga" value="<%= new Integer(ob.getLeasedocposition()).toString() %>"
									insertable="true" updatable="true"/>
							</td>
						</tr>
					  </logic:present>
					</logic:iterate>
			</table>
		</td>
	</tr>

	<tr>
		<td>&nbsp;</td>
	</tr>

	<july:separator colspan="1"/>
	
	<tr class="title">
		<td class="text"><B><bean:message key="label.actcontents.header3"/></B></td>
	</tr>

	<TR>
		<TD>
			<table class="main">
				<%
					curDocument = 0;
				%>
				<logic:iterate id="it" name="table3">
					<logic:present name="it">
					<%
						com.hps.july.arenda.valueobject.ActContentsValueObject ob = (com.hps.july.arenda.valueobject.ActContentsValueObject)it;
						if (ob.getLeasedocument() != curDocument) {
							curDocument = ob.getLeasedocument();
					%>
						<tr class="normal">
							<td colspan="5">
								<bean:message key="label.actcontents.contract"/>: <bean:write name="it" property="docnumber" filter="true"/>
								<bean:message key="label.actcontents.cdate"/> <july:datewrite name="it" property="docdate"/>, 
								<bean:message key="label.actcontents.orgname"/>: <bean:write name="it" property="orgname" filter="true"/>
							</td>
						</tr>
						<!-- Table header -->
						<tr class="title">
							<july:headercolumn key="label.actcontents.resource" colType="string"/>
							<july:headercolumn key="label.actcontents.paydate" colType="string"/>
							<july:headercolumn key="label.actcontents.paynumber" colType="string"/>
							<july:headercolumn key="label.actcontents.summrub" colType="string"/>
							<july:headercolumn key="label.actcontents.willbeinact" colType="string"/>
						</tr>
					<%
						}
					%>

						<july:separator colspan="5"/>

						<!-- Table body -->
						<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
							
							<td class="text">
								<bean:write name="it" property="resname" filter="true"/>
							</td>
							
							<td class="text">
								<july:datewrite name="it" property="billdate"/>
							</td>

							<td class="text">
								<bean:write name="it" property="billnumber" filter="true"/>
							</td>

							<td class="text" NOWRAP align="right">
								<july:numberwrite name="it" property="summ" fractdigits="2"/>
							</td>

							<td class="text">
								<july:checkbox property="selpayd" value="<%= new Integer(ob.getLeasedocposition()).toString() %>"
									insertable="true" updatable="true"/>
							</td>
						</tr>
					  </logic:present>
					</logic:iterate>
			</table>
		</td>
	</tr>

	<tr>
		<td>&nbsp;</td>
	</tr>

	<july:separator colspan="1"/>
	
	<tr class="title">
		<td class="text"><B><bean:message key="label.actcontents.header4"/></B></td>
	</tr>

	<TR>
		<TD>
			<table class="main">
				<%
					curDocument = 0;
				%>
				<logic:iterate id="it" name="table4">
					<logic:present name="it">
					<%
						com.hps.july.arenda.valueobject.ActContentsValueObject ob = (com.hps.july.arenda.valueobject.ActContentsValueObject)it;
						if (ob.getLeasedocument() != curDocument) {
							curDocument = ob.getLeasedocument();
					%>
						<tr class="normal">
							<td colspan="5">
								<bean:message key="label.actcontents.ban"/>: <bean:write name="it" property="ban" filter="true"/>
								<bean:message key="label.actcontents.ben"/>: <bean:write name="it" property="ben" filter="true"/>, 
								<bean:message key="label.actcontents.orgname"/>: <bean:write name="it" property="orgname" filter="true"/>
							</td>
						</tr>
						<!-- Table header -->
						<tr class="title">
							<july:headercolumn key="label.actcontents.resource" colType="string"/>
							<july:headercolumn key="label.actcontents.paydate" colType="string"/>
							<july:headercolumn key="label.actcontents.paynumber" colType="string"/>
							<july:headercolumn key="label.actcontents.summrub" colType="string"/>
							<july:headercolumn key="label.actcontents.willbeinact" colType="string"/>
						</tr>
					<%
						}
					%>

						<july:separator colspan="5"/>

						<!-- Table body -->
						<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
							
							<td class="text">
								<bean:write name="it" property="resname" filter="true"/>
							</td>
							
							<td class="text">
								<july:datewrite name="it" property="billdate"/>
							</td>

							<td class="text">
								<bean:write name="it" property="billnumber" filter="true"/>
							</td>

							<td class="text" NOWRAP align="right">
								<july:numberwrite name="it" property="summ" fractdigits="2"/>
							</td>

							<td class="text">
								<july:checkbox property="selpaya" value="<%= new Integer(ob.getLeasedocposition()).toString() %>"
									insertable="true" updatable="true"/>
							</td>
						</tr>
					  </logic:present>
					</logic:iterate>
			</table>
		</td>
	</tr>

	<tr>
		<td>&nbsp;</td>
	</tr>

	<july:separator colspan="1"/>

	<tr class="title">
		<td class="text">
			<logic:notEqual name="ActContentsListForm" property="action" value="View">
				<%--july:savebutton/--%>
				<input type='image' name='submit' src='/images/save.gif' alt='Сохранить' onclick = "window.document.forms(0).all('action_process').value='1';">
			</logic:notEqual>
			<july:backbutton/>
		</td>
	</tr>

	<july:separator colspan="1"/>

</table>

<INPUT TYPE="HIDDEN" NAME="selchrgd" VALUE="0">
<INPUT TYPE="HIDDEN" NAME="selchrga" VALUE="0">
<INPUT TYPE="HIDDEN" NAME="selpayd" VALUE="0">
<INPUT TYPE="HIDDEN" NAME="selpaya" VALUE="0">
</html:form>
