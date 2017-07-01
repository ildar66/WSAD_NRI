<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.formbean.*"%>

<% java.lang.String gColSpan = "15"; %>
<july:editform action="/CheckReportsForFileNumber.do">
<table class="main">

<july:separator colspan="<%= gColSpan %>" />

<tr class="normal">
	<td colspan="<%= gColSpan %>">
		<table class="find">
			<tr>
			<td class="title" nowrap>
				<bean:message key="label.reports.haveplan.filenumber"/>:
			</td>
			<td class="title" nowrap>
				<td class="title" nowrap><july:string size="5" property="filenumberFrm" insertable="true" updatable="true" styleClass="editkodsearch"/>
				<july:searchbutton/>
			</td>
			</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<% 
	Object fileexistsObj = request.getAttribute("fileexists");
	String filenumber = null;
	if(null != fileexistsObj) {
		boolean fileexists = ((Boolean)fileexistsObj).booleanValue();
		if(fileexists) {
			pageContext.setAttribute("filenumber", request.getAttribute("filenumber"));
			filenumber = (String)request.getAttribute("filenumber");
%>
<tr class="normal">
	<td><html:link href="GetReportHavePlan.do" target="_blank" paramId="filenumber" paramName="filenumber">
		�������� ����� � ������� &laquo;�����������&raquo;
		</html:link>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
	<td><html:link href="GetReportHavePlan2.do" target="_blank" paramId="filenumber" paramName="filenumber">
		�������� ����� � ������� &laquo;�����������&raquo; �� ��������
	</html:link></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
	<td><july:exceledit styleId="exceled1" url='<%= "GetReportFrequencyRequest.do?filenumber=" + filenumber %>' uploadurl="FreqRequestUploadAction.do" documentid="<%= filenumber %>" updatable="true">
		�������� �������� &laquo;������ �� �������&raquo;
	</july:exceledit></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
	<td><html:link href="GetReportFrequencyRequest.do?type=2" target="_blank" paramId="filenumber" paramName="filenumber">
		�������� �������� &laquo;������ �� �������&raquo; (2 ���)
		</html:link>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
	<td>
		<july:wordedit styleId='<%= "wrdedreport4" + filenumber %>' url='<%= "GetReportRadioFreqRequest.do?filenumber=" + filenumber %>' uploadurl="null" documentid="<%= filenumber %>" updatable="false">
�������� �������� &laquo;������ �� ���������� ����������� ��� ������������� ����� �����&raquo;
		</july:wordedit>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
	<td>
		<july:wordedit styleId='<%= "wrdedreport6" + filenumber %>' url='<%= "GetReportRequestLetter.do?filenumber=" + filenumber %>' addurl='<%= "http://" + request.getServerName() + "/basestation/beeline_header.jsp"%>' uploadurl="null" documentid="<%= filenumber %>" updatable="false">
�������� �������� &laquo;������-������ � ����&raquo;
		</july:wordedit>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
	<td><html:link href="GetReportRRLList.do" target="_blank" paramId="filenumber" paramName="filenumber">
�������� ����� &laquo;������ ���&raquo;
		</html:link></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
	<td><html:link href="GetReportFreqHistory.do" target="_blank" paramId="filenumber" paramName="filenumber">
		�������� ����� &laquo;������� �����&raquo;
	</html:link></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
	<td><html:link href="GetReportComlines.do" target="_blank" paramId="filenumber" paramName="filenumber">
		�������� ����� &laquo;������������� �����&raquo;
	</html:link></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
	<td><html:link href="GetReportComlinesPositions.do" target="_blank" paramId="filenumber" paramName="filenumber">
		�������� ����� &laquo;������������� ����� � �������&raquo;
	</html:link></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
	<td>
	<july:wordedit styleId='<%= "wrdedreport8" + filenumber %>' url='<%= "GetReportAppropriationRequest.do?filenumber=" + filenumber %>' uploadurl="null" documentid="<%= filenumber %>" updatable="false">
		�������� �������� &laquo;��������� �� ���������� ����������� � ���&raquo;
	</july:wordedit>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
	<td><html:link href="GetReportProtocol.do" target="_blank" paramId="filenumber" paramName="filenumber">
		�������� ����� &laquo;������ �� ��������� ��������� ����������� ���������� ��������� ��� (�� �����)&raquo;
	</html:link></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />

<%		} // end of if(fileexists)
	} // end of if(null != fileexistsObj) {
%>
</table>
</july:editform>
