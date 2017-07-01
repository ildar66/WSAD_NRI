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
	String action = "/LeaseContractProblemProcess.do";
	String form = "LeaseContractProblemDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
	boolean isWideView = request.isUserInRole("administrator") || request.isUserInRole("developer");
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
		<logic:notEqual name="<%= form %>" property="action" value="Delete">
		var theForm = document.<%= form %>;
		with(theForm){
			//if(!field_check(theForm.idRegistryDoc, 'Номер описи', 0, true)) return false;
			//if(!field_check(theForm.dateActStr, 'Дата акта', 0, true)) return false;
			//if(!field_check(theForm.planSumStr,'Планируемая стоимость',6,true)) return false;
			if(!field_check(theForm['to.vo.owner'], 'Инициатор(из справочника)',0,true)) return false;
			if(!field_check(theForm['to.vo.executor'], 'Исполнитель(из справочника)',0,true)) return false;
			//if(!field_check(theForm.otherMan, 'Кто принимал', 0, true)) return false;
		}
		</logic:notEqual>
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
		<td class="text"><july:reqmark>Инцидент №:</july:reqmark></td> 
		<td class="text">
			<july:string size="10" property="to.vo.idProblem" styleId="idProblem" insertable="false" updatable="false"/>&nbsp;&nbsp;&nbsp;
			<%--Дата:<july:date property="dateActStr" size="20" insertable="true" updatable="true" required="false" styleId="dateActStr"/> --%>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Тип инцидента:</july:reqmark></td>
		<td class="text">
			<july:select style="width: 320;" property="to.vo.typeProblem" insertable="true" updatable="true">
				<html:option value="1">нельзя оформить ЗП</html:option>
				<html:option value="2">нельзя оформить Платеж</html:option>
				<html:option value="3">отсутствуют первичные документы</html:option>
				<html:option value="4">отсутствуют подписанные акты взаимозачета</html:option>
				<html:option value="5">задолженность по абонентскому договору</html:option>
				<html:option value="6">проблема разработчиков NRI</html:option>
			</july:select>
		</td>
	</tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<july:reqmark>Инициатор:</july:reqmark>&nbsp;&nbsp;&nbsp;
			<html:hidden property="to.vo.owner"/>
			<july:lookupbutton action="/../security/ShowPeopleLookupList.do" styleId="manl_1" fieldNames="to.vo.owner;to.ownerName" newWindowName="manlookup" insertable="true" updatable="true"/>			
		</td>
		<td class="text">
			<july:string size="30" property="to.ownerName" styleId="ownerName" insertable="true" updatable="false"/>
		</td>
	</tr>	
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<july:reqmark>Исполнитель:</july:reqmark>
			<html:hidden property="to.vo.executor"/>
			<july:lookupbutton action="/../security/ShowPeopleLookupList.do" styleId="manl_2" fieldNames="to.vo.executor;to.executorName" newWindowName="manlookup" insertable="true" updatable="true"/>			
		</td>
		<td class="text">
			<july:string size="30" property="to.executorName" styleId="executorName" insertable="true" updatable="false"/>
		</td>
	</tr>
<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text">Описание инцидента:</td> 
		<td class="text">
			<july:textarea cols="30" rows="3" style="width: 250pt;font-size:8pt;" property="to.vo.note" styleId="note" insertable="true" updatable='true'/>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>	
    
<logic:notEqual name="<%= form %>" property="action" value="Add">
    <%if(isWideView){%>
    <tr>
        <td class="text">создал:</td>
        <td>
			<bean:write name="<%=form%>" property="to.createdByName"  filter="true" />(<july:datewrite name="<%=form%>" property="to.vo.created" showtime="true"/>)
        </td>
    </tr>
    <tr>
        <td class="text">изменил:</td>
        <td>
			<bean:write name="<%=form%>" property="to.modifiedByName"  filter="true" />(<july:datewrite name="<%=form%>" property="to.vo.modified" showtime="true"/>)
        </td>
    </tr>
    <july:separator colspan="<%= gColSpan %>"/>                      
    <%}%>
</logic:notEqual>

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
	if(<%= form %>.idProblem != null)
		<%= form %>.idProblem.focus();
</script>

</july:editform>
