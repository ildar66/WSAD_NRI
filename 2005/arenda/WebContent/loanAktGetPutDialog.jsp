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
	String action = "/LoanAktGetPutProcess.do";
	String form = "LoanAktGetPutDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="id"/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "Удалить запись"; %>
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
			if(!field_check(theForm.numberAct, 'Номер акта', 0, true)) return false;
			if(!field_check(theForm.dateActStr, 'Дата акта', 0, true)) return false;
			//if(!field_check(theForm.planSumStr,'Планируемая стоимость',6,true)) return false;
			if(!field_check(theForm['to.vo.ourMan'], 'Кто передавал(из справочника)',0,true)) return false;
			if(!field_check(theForm.otherMan, 'Кто принимал', 0, true)) return false;
		}
		return true;
	}
</script>

<table class="main"  style="font-size:8pt;">

<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
				<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" styleID="submitID" onclick="return Check();">
			&nbsp;<july:closebutton page="/"/>
        </td>
    </tr>

<july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>

<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text"><july:reqmark>Акт №:</july:reqmark></td> 
		<td class="text">
			<july:string size="10" property="to.vo.numberAct" styleId="numberAct" insertable="true" updatable="true"/>&nbsp;&nbsp;&nbsp;
			Дата:<july:date property="dateActStr" size="20" insertable="true" updatable="true" required="false" styleId="dateActStr"/>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Тип:</july:reqmark></td>
		<td class="text">
			<july:select style="width: 130;" property="to.vo.typeAct" insertable="true" updatable="true">
				<html:option value="1">выдача</html:option>
				<html:option value="2">возврат</html:option>
			</july:select>
		</td>
	</tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Кто передавал:</july:reqmark></td>
		<td class="text">
			<html:hidden property="to.vo.ourMan"/>
			<july:string size="30" property="to.ourManName" styleId="ourManName" insertable="true" updatable="true"/>
				<july:lookupbutton action="/../security/ShowPeopleLookupList.do" styleId="manl" fieldNames="to.vo.ourMan;to.ourManName" newWindowName="manlookup" insertable="true" updatable="true"/>
		</td>
	</tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Кто принимал:</july:reqmark></td>
		<td class="text">
			<july:string size="30" property="to.vo.otherMan" styleId="otherMan" insertable="true" updatable="true"/>
		</td>
	</tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<html:link page="/ShowAbonentBillLookupList.do?formname=LoanAktGetPutDialogForm&fieldnames=to.vo.idLeasebill|aktAbonentBillInfo" paramId="leaseDocument" paramName="LoanAktGetPutDialogForm" paramProperty="abonentContract" scope="session" onclick="window.open(this.href, 'pWindow', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="справочник">		
				абонентский счет:
			</html:link>
		</td>
		<td class="text">
			<html:hidden property="to.vo.idLeasebill"/>
			<july:string size="30" property="aktAbonentBillInfo" insertable="true" updatable="true"/>			
		</td>
	</tr>
<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
				<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" styleID="submitID" onclick="return Check();">
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
	if(<%= form %>.docnumber != null)
		<%= form %>.docnumber.focus();
</script>

</july:editform>
