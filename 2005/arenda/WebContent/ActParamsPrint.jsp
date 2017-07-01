<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<%
	String celColor = "#000099" ;
%>
<html:form action="/ActParamsPrint.do">


<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
          <july:closebutton page="/"/>
          <july:printerbutton/> 
        </td>
    </tr>
    
    <july:separator/>
    
    <TR class="printable">
    <TD class="printable">
    
        <TABLE class="print" style="border-style: none; border-color: black; border-width: 0; border-collapse:collapse;">
        <tr class="printable">
            <td class="printable" style="font-weight: bold; font-size: 16pt">
               <bean:message key="label.actpprint.header" />
            </td>
        </tr>
        
        <tr class="printable">
            <td class="printable" style="font-size: 10pt">
				<bean:message key="label.actpprint.header1"/> <FONT color="<%= celColor %>"><bean:write name="ActParamsPrintForm" property="header1"/></FONT>
               <bean:message key="label.actpprint.header2"/> <FONT color="<%= celColor %>"><bean:write name="ActParamsPrintForm" property="header2"/></FONT>
               <bean:message key="label.actpprint.header3"/> <FONT color="<%= celColor %>"><bean:write name="ActParamsPrintForm" property="header3"/></FONT>
            </td>
        </tr>
        <tr class="printable">
            <td class="printable" style="font-size: 10pt">&nbsp;
            </td>
        </tr>
        <tr class="printable">
            <td class="printable" style="font-size: 10pt">
               <I><bean:message key="label.actpprint.header4"/></I>
            </td>
        </tr>
        <tr class="printable">
            <td class="printable" style="font-size: 10pt">&nbsp;
            </td>
        </tr>
        <tr class="printable">
            <td class="printable" style="font-weight: bold; font-size: 10pt">
               <bean:message key="label.actpprint.header5" />
            </td>
        </tr>
            

		<%--  New Arenda Contract --%>
		<%
			int mainContract = 0;
			int contract = 0;
			boolean isFirst = true;
			com.hps.july.arenda.formbean.ActParamsPrintForm aform = (com.hps.july.arenda.formbean.ActParamsPrintForm)request.getAttribute("ActParamsPrintForm");
			java.util.Iterator table1 = aform.getTable1().iterator();
			while (table1.hasNext()) {
				com.hps.july.arenda.valueobject.ActParamsPrintObject1 ob1 = (com.hps.july.arenda.valueobject.ActParamsPrintObject1)table1.next();
				request.setAttribute("ob1", ob1);
				if (mainContract != ob1.getMaindoc()) {
					mainContract = ob1.getMaindoc();
					contract = 0;
		%>
				<% 
					if (!isFirst) {
						isFirst = false;
				%>
									</TABLE>
							</TD>
						</TR>
				<%
					}
				%>
				<tr class="printable">
					<td class="printable" style="font-size: 10pt">&nbsp;
					</td>
				</tr>
				<tr class="printable">
					<td class="printable" style="font-size: 10pt">
					   <bean:message key="label.actpprint.dognumber"/> <FONT color="<%= celColor %>"><bean:write name="ob1" property="dognumber" filter="true"/></FONT>
					   <bean:message key="label.actpprint.from"/> <FONT color="<%= celColor %>"><july:datewrite name="ob1" property="dogdate"/></FONT>
					</td>
				</tr>
				<tr class="printable">
					<td class="printable" style="font-size: 10pt">
					   <bean:message key="label.actpprint.customer"/> <FONT color="<%= celColor %>"><bean:write name="ob1" property="custname" filter="true"/></FONT>
					</td>
				</tr>
				<tr class="printable">
					<td class="printable" style="font-size: 10pt">
					   <bean:message key="label.actpprint.executor"/> <FONT color="<%= celColor %>"><bean:write name="ob1" property="orgname" filter="true"/></FONT>
					</td>
				</tr>
		<%
				}
				if (contract != ob1.getDocument()) {
					contract = ob1.getDocument();
		%>
				<% 
					if (!isFirst) {
				%>
								</TABLE>
						</TD>
					</TR>
				<%
					}
					isFirst = false;
				%>
				<tr class="printable">
					<td class="printable" style="font-size: 10pt">&nbsp;
					</td>
				</tr>
				<tr class="printable">
					<td class="printable" style="font-size: 10pt">
					   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.actpprint.sdate"/> <FONT color="<%= celColor %>"> <july:datewrite name="ob1" property="sdate"/></FONT>
					   <bean:message key="label.actpprint.edate"/> <FONT color="<%= celColor %>"> <july:datewrite name="ob1" property="edate"/></FONT>
					</td>
				</tr>
				<tr class="printable">
					<td class="printable" style="font-size: 10pt">
					   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.actpprint.prolong"/> <FONT color="<%= celColor %>"><bean:write name="ob1" property="prolong" filter="true"/></FONT>
					</td>
				</tr>
				<tr class="printable">
					<td class="printable" style="font-size: 10pt">
					   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.actpprint.payraterule"/> <FONT color="<%= celColor %>"><bean:write name="ob1" property="payraterule" filter="true"/></FONT>
					</td>
				</tr>

				<tr class="printable">
					<td class="printable" style="font-size: 10pt">&nbsp;
					</td>
				</tr>

				<tr class="printable">
					<td class="printable" style="font-size: 10pt">
						<TABLE class="print">
							<tr class="print">
								<td class="print" rowspan="2" style="font-size: 10pt">
								   <bean:message key="label.actpprint.resource" />
								</td>
								<td class="print" rowspan="2" style="font-size: 10pt">
								   <bean:message key="label.actpprint.currency" />
								</td>
								<td class="print" colspan="2" style="font-size: 10pt">
								   <bean:message key="label.actpprint.chargerules" />
								</td>
								<td class="print" colspan="3" style="font-size: 10pt">
								   <bean:message key="label.actpprint.payrules" />
								</td>
								<td class="print" rowspan="2" style="font-size: 10pt">
								   <bean:message key="label.actpprint.traffsumm" />
								</td>
							</tr>
							<tr class="print">
								<td class="print" style="font-size: 10pt">
								   <bean:message key="label.actpprint.chargesumm" />
								</td>
								<td class="print" style="font-size: 10pt">
								   <bean:message key="label.actpprint.chargeperiod" />
								</td>
								<td class="print" style="font-size: 10pt">
								   <bean:message key="label.actpprint.paytype" />
								</td>
								<td class="print" style="font-size: 10pt">
								   <bean:message key="label.actpprint.paysumm" />
								</td>
								<td class="print" style="font-size: 10pt">
								   <bean:message key="label.actpprint.payperiod" />
								</td>
							</tr>
			<%
				}
			%>
						<tr class="print">
							<td class="print" style="font-size: 10pt">
							   <FONT color="<%= celColor %>"><bean:write name="ob1" property="resname" filter="true"/></FONT>
							</td>
							<td class="print" style="font-size: 10pt">
							   <FONT color="<%= celColor %>"><bean:write name="ob1" property="currname" filter="true"/></FONT>
							</td>
							<td class="print" NOWRAP style="font-size: 10pt; text-align: right;">
							   <FONT color="<%= celColor %>"><july:numberwrite name="ob1" property="chargesumm" fractdigits="2"/></FONT>
							</td>
							<td class="print" style="font-size: 10pt">
							   <FONT color="<%= celColor %>"><bean:write name="ob1" property="chargeperiod" filter="true"/></FONT>
							</td>
							<td class="print" style="font-size: 10pt">
							   <FONT color="<%= celColor %>"><bean:write name="ob1" property="paytype" filter="true"/></FONT>
							</td>
							<td class="print" NOWRAP style="font-size: 10pt; text-align: right;">
							   <FONT color="<%= celColor %>"><july:numberwrite name="ob1" property="paysumm" fractdigits="2"/></FONT>
							</td>
							<td class="print" style="font-size: 10pt">
							   <FONT color="<%= celColor %>"><bean:write name="ob1" property="payperiod" filter="true"/></FONT>
							</td>
							<td class="print" NOWRAP style="font-size: 10pt; text-align: right;">
							   <FONT color="<%= celColor %>"><july:numberwrite name="ob1" property="trafsumm" fractdigits="2"/></FONT>
							</td>
						</tr>


		<%
			}
		%>
        
			
					</TABLE>
				</TD>
			</TR>

		<logic:notEqual name="ActParamsPrintForm" property="acttype" value="S">
			<tr class="printable">
				<td class="printable" style="font-size: 10pt">&nbsp;
				</td>
			</tr>
			<tr class="printable">
				<td class="printable" style="font-weight: bold; font-size: 10pt">
				   <bean:message key="label.actpprint.header10" />
				</td>
			</tr>
			<%
				java.util.Iterator table2 = aform.getTable2().iterator();
				while (table2.hasNext()) {
					com.hps.july.arenda.valueobject.ActParamsPrintObject2 ob2 = (com.hps.july.arenda.valueobject.ActParamsPrintObject2)table2.next();
					request.setAttribute("ob2", ob2);
			%>
				<tr class="printable">
					<td class="printable" style="font-size: 10pt">&nbsp;
					</td>
				</tr>
				<%--
				<tr class="printable">
					<td class="printable" style="font-size: 10pt">
					   <bean:message key="label.actpprint.customer"/> <FONT color="<%= celColor %>"><bean:write name="ob2" property="custname" filter="true"/></FONT>
					</td>
				</tr>
				<tr class="printable">
					<td class="printable" style="font-size: 10pt">
					   <bean:message key="label.actpprint.executor"/> <FONT color="<%= celColor %>"><bean:write name="ob2" property="orgname" filter="true"/></FONT>
					</td>
				</tr>
				--%>
				<tr class="printable">
					<td class="printable" style="font-size: 10pt">
					   <bean:message key="label.actpprint.ban"/> <FONT color="<%= celColor %>"><bean:write name="ob2" property="ban" filter="true"/></FONT>
					   <bean:message key="label.actpprint.bens"/> <FONT color="<%= celColor %>"><bean:write name="ob2" property="bens" filter="true"/></FONT>
					</td>
				</tr>
			<%
				}
			%>
		</logic:notEqual>
			
		<tr class="printable">
			<td class="printable" style="font-size: 10pt">&nbsp;
			</td>
		</tr>
		<tr class="printable">
			<td class="printable" style="font-size: 10pt">
			   <bean:message key="label.actpprint.header7"/> <FONT color="<%= celColor %>"><bean:write name="ActParamsPrintForm" property="header4" filter="true"/></FONT>
			</td>
		</tr>
		<tr class="printable">
			<td class="printable" style="font-size: 10pt">&nbsp;
			</td>
		</tr>

		<logic:equal name="ActParamsPrintForm" property="commonRate" value="true">
			<tr class="printable">
				<td class="printable" style="font-size: 10pt">
				   <bean:message key="label.actpprint.header8"/> <FONT color="<%= celColor %>"><bean:write name="ActParamsPrintForm" property="header5" filter="true"/></FONT>
				</td>
			</tr>
		</logic:equal>
		<logic:equal name="ActParamsPrintForm" property="commonRate" value="false">
			<tr class="printable">
				<td class="printable" style="font-size: 10pt">
				   <bean:message key="label.actpprint.header9"/>
				</td>
			</tr>
			<tr class="printable">
				<td class="printable" style="font-size: 10pt">
						<TABLE class="print">
							<tr class="print">
								<td class="print" style="font-size: 10pt">
								   <bean:message key="label.actpprint.resource" />
								</td>
								<td class="print" style="font-size: 10pt">
								   <bean:message key="label.actpprint.schetuse" />
								</td>
								<td class="print" style="font-size: 10pt">
								   <bean:message key="label.actpprint.payschetuse" />
								</td>
								<td class="print" style="font-size: 10pt">
								   <bean:message key="label.actpprint.payuse" />
								</td>
							</tr>
						<%
							java.util.Iterator table3 = aform.getTable3().iterator();
							while (table3.hasNext()) {
								com.hps.july.arenda.valueobject.ActParamsPrintObject3 ob3 = (com.hps.july.arenda.valueobject.ActParamsPrintObject3)table3.next();
								request.setAttribute("ob3", ob3);
						%>
							<tr class="print">
								<td class="print" style="font-size: 10pt">
									<FONT color="<%= celColor %>"><bean:write name="ob3" property="resname" filter="true"/></FONT>
								</td>
								<td class="print" style="font-size: 10pt">
									<FONT color="<%= celColor %>"><bean:write name="ob3" property="schetuse" filter="true"/></FONT>
								</td>
								<td class="print" style="font-size: 10pt">
									<FONT color="<%= celColor %>"><bean:write name="ob3" property="usebillbyrate" filter="true"/></FONT>
								</td>
								<td class="print" style="font-size: 10pt">
									<FONT color="<%= celColor %>"><bean:write name="ob3" property="usepay" filter="true"/></FONT>
								</td>
							</tr>
						<%
							}
						%>
						</TABLE>
				</td>
			</tr>
		</logic:equal>

    </TABLE>
    </TD>
    </TR>
    
    <july:separator/>
    
    <tr class="title">
    	<td class="title" colspan="2">
          <july:closebutton page="/"/>
          <july:printerbutton/> 
        </td>
    </tr>
    
    <july:separator/>
    
</table>


</html:form>
