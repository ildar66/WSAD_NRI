<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT> 
<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/RegistryBuchDocsProcess.do";
	String form = "RegistryBuchDocsDialogForm";
	String src = "/images/save.gif";
	String alt = "��������� ������";
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="id"/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "������� ������"; %>
</logic:equal>

<script language="javascript">
	function Close()
		{
			if(window.opener) {
				opener.storeSelectedRow(document.all.id.value);
				//opener.location.reload(true);
				window.opener.window.document.forms(0).submit();
				//window.opener.window.location.href=window.opener.window.location.href;
				window.opener.focus();
			}
			window.close();
		}
	function Check()
	{
		var theForm = document.<%= form %>;
		with(theForm){
			if(!field_check(theForm.idRegistryDoc, '����� �����', 0, true)) return false;
			//if(!field_check(theForm.dateActStr, '���� ����', 0, true)) return false;
			//if(!field_check(theForm.planSumStr,'����������� ���������',6,true)) return false;
			if(!field_check(theForm['to.vo.owner'], '���������(�� �����������)',0,true)) return false;
			//if(!field_check(theForm.otherMan, '��� ��������', 0, true)) return false;
		}
		return true;
	}
</script>

<table class="main"  style="font-size:8pt;">

<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
    		<logic:notEqual name="<%= form %>" property="action" value="View">    	
				<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="return Check();">
			</logic:notEqual>
			&nbsp;<july:closebutton page="/"/>
        </td>
    </tr>

<july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>

<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text"><july:reqmark>����� �:</july:reqmark></td> 
		<td class="text">
			<july:string size="10" property="to.vo.idRegistryDoc" styleId="idRegistryDoc" insertable="true" updatable="false"/>&nbsp;&nbsp;&nbsp;
			<%--����:<july:date property="dateActStr" size="20" insertable="true" updatable="true" required="false" styleId="dateActStr"/> --%>
		</td>
    </tr>
    
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>��� ��������:</july:reqmark></td>
		<td class="text">
			<july:select style="width: 200;" property="to.vo.typeRegistry" insertable="true" updatable="false">
				<html:option value="1">�����-�������</html:option>
				<html:option value="2">���� ����������� �����</html:option>
				<html:option value="3">��������</html:option>
				<html:option value="4">��-� � ���� ���. �����</html:option>
				<html:option value="5">���� ������������</html:option>
			</july:select>
		</td>
	</tr>
	
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>���������:</july:reqmark></td>
		<td class="text">
			<html:hidden property="to.vo.owner"/>
			<july:string size="30" property="to.ownerName" styleId="ownerName" insertable="true" updatable="false"/>
				<july:lookupbutton action="/../security/ShowPeopleLookupList.do" styleId="manl" fieldNames="to.vo.owner;to.ownerName" newWindowName="manlookup" insertable="true" updatable="false"/>
		</td>
	</tr>
	
<logic:notEqual name="<%= form %>" property="action" value="Add">
<july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="text">������:</td>
        <td>
			<bean:write name="<%=form%>" property="to.createdByName"  filter="true" />(<july:datewrite name="<%=form%>" property="to.vo.created" showtime="true"/>)
        </td>
    </tr>
    <tr>
        <td class="text">�������:</td>
        <td>
			<bean:write name="<%=form%>" property="to.modifiedByName"  filter="true" />(<july:datewrite name="<%=form%>" property="to.vo.modified" showtime="true"/>)
        </td>
    </tr>
</logic:notEqual>
	
<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
    		<logic:notEqual name="<%= form %>" property="action" value="View">    	
				<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="return Check();">
			</logic:notEqual>
			&nbsp;<july:closebutton page="/"/>
        </td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>
	
</table>

<logic:equal name="<%=form%>" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>

<script language="javascript" type="text/javascript">
	if(<%= form %>.idRegistryDoc != null)
		<%= form %>.idRegistryDoc.focus();
</script>

</july:editform>
