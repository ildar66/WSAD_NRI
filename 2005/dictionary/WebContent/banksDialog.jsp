<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT> 

<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/BanksProcess.do";
	String form = "BanksDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "Удалить запись"; %>
</logic:equal>

<july:editform action="<%= action %>" styleId="<%= form %>" focus="bank.name">
<html:hidden property="id"/>

<script language="javascript">
function Close(){
	if(window.opener) {
		opener.storeSelectedRow(document.all.id.value);
		//opener.location.reload(true);
		window.opener.window.document.forms(0).submit();
		//window.opener.window.location.href=window.opener.window.location.href;
		window.opener.focus();
	}
	window.close();
}
function Check(){
	var theForm = document.<%= form %>;
	with(theForm){
		if(!field_check(theForm['bank.name'], 'Наименование', 0, true)) return false;
		if(!field_check(theForm['bank.bik'], 'Бик', 3, true)) return false;
		if(!field_check(theForm['bank.korAccount'], 'Банк.Корр-счет', 3, true)) return false;
		//if(!field_check(theForm.summStr, 'Сумма начисления', 6, true)) return false;
		//if(!field_check(theForm.beginDateStr, 'период c', 0, true)) return false;
		//if(!field_check(theForm.endDateStr, 'период по', 0, true)) return false;
		//if(!field_check(theForm.dateEndSfStr, 'СФ период по', 0, true)) return false;
		//if(!field_check(theForm.sumNdsStr,'В т.ч. НДС',6,true)) return false;
		//if(!field_check(theForm['vo.currency'], 'Валюта начисления',4,true)) return false;
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
				<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="return Check();">&nbsp;
			</logic:notEqual>			
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>

    <tr>
    	<td class="title" colspan="2">
    		<july:actionalert/> <bean:message key="label.code"/>: <bean:write name="<%= form %>" property="bank.idBank"/>
    	</td>
    </tr>
    <july:separator/>
    
    <%--tr>
        <td class="text"><july:reqmark><bean:message key="label.code"/>:</july:reqmark></td>
        <td>
          <july:string property="bank.idBank" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    <july:separator/--%>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.name"/>:</july:reqmark></td>
        <td>
          <july:textarea property="bank.name" cols="50" rows="3" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.organization.bik"/>:</july:reqmark></td>
        <td>
          <july:string property="bank.bik" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.organization.swift"/>:</td>
        <td>
          <july:string property="bank.swift" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.organization.corraccount"/>:</td>
        <td>
          <july:string property="bank.korAccount" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.organization.legaladdress"/>:</td>
        <td>
          <july:textarea property="bank.legalAddress" cols="50" rows="4" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <%--tr>
        <td class="text"><bean:message key="label.organization.legalzip"/>:</td>
        <td>
          <july:string property="bank.zip" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    <july:separator/--%>
    
	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<logic:notEqual name="<%= form %>" property="action" value="View">    	
				<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="return Check();">&nbsp;
			</logic:notEqual>
			<july:closebutton page="/"/>
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

