<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.security.*,com.hps.july.security.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT> 
<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/Operator2roleProcess.do";
	String form = "Operator2roleDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<july:editform action="<%= action %>" styleId="<%= form %>" focus="sortOrder">
<%--html:hidden property="role"/--%>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "Удалить запись"; %>
</logic:equal>

<script language="javascript">
	function Close()
		{
			if(window.opener) {
				opener.storeSelectedRow(document.all.role.value);
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
			if(!field_check(theForm.role, 'Код', 0, true)) return false;
			if(!field_check(theForm.rolename, 'Роль', 0, true)) return false;
			if(!field_check(theForm.sortOrder, 'Номер сортировки', 3, true)) return false;			
			//if(!field_check(theForm.planSumStr,'Планируемая стоимость',6,true)) return false;
			//if(!field_check(theForm['to.vo.owner'], 'Инициатор(из справочника)',0,true)) return false;
			//if(!field_check(theForm.otherMan, 'Кто принимал', 0, true)) return false;
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
		<td class="text"><july:reqmark>Код:</july:reqmark></td> 
		<td class="text" nowrap="nowrap">
			<july:string size="25" property="vo.role" styleId="role" insertable="true" updatable="false"/>&nbsp;&nbsp;&nbsp;
			№ сортировки: <july:string size="5" style="width: 40pt" property="vo.sortOrder" styleId="sortOrder" insertable="true" updatable="true"/>
		</td>
    </tr>
    
<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text"><july:reqmark>Роль:</july:reqmark></td> 
		<td class="text">
			<july:string size="40" style="width: 300pt" property="vo.rolename" styleId="rolename" insertable="true" updatable="false"/>
			<%--Дата:<july:date property="dateActStr" size="20" insertable="true" updatable="true" required="false" styleId="dateActStr"/> --%>
		</td>
    </tr>
    
<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text">Модуль:</td> 
		<td class="text">
			<july:string size="40" style="width: 300pt" property="vo.taskComment" styleId="taskComment" insertable="true" updatable="true"/>
			<%--Дата:<july:date property="dateActStr" size="20" insertable="true" updatable="true" required="false" styleId="dateActStr"/> --%>
		</td>
    </tr>
    
<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text" colspan="2">
			&nbsp;<B style="text-align: center;">Описание:<B>
			&nbsp;<july:textarea style="width: 460;" cols="30" rows="6" property="vo.comment" insertable="true" updatable="true"/>		
		</td>
    </tr>           
    
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

</july:editform>
