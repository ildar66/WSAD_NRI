<%@ page language = "java" %>
<%@ page import="com.hps.july.siteinfo.formbean.PositionForm"%>
<%@ page import="java.util.*,com.hps.july.persistence.*,com.hps.july.siteinfo.actionbean.*,com.hps.july.siteinfo.formbean.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<script language="javascript">
function clearCheckbox(obj, name) {
	var checkbox;	
	for(var i = 0; i < PosForm.length; i++){
		if(PosForm.elements[i].name == name){
			checkbox = PosForm.elements[i];
			break;
		}
	}
	if(!obj.checked){
		checkbox.checked = false;
		checkbox.disabled = true;
	} else {
		checkbox.checked = true;
		checkbox.disabled = false;
	}
}
</script>

<% java.lang.String gColSpan = "2";%>

<july:browseform action="/buildListPass.do" styleId="PosForm" onsubmit="document.all.showword.value=1">

<html:hidden property="showword" styleId="showword"/> 

<html:hidden name="PositionForm" property="storageplace"/> 
<table class="main">
	<july:separator colspan="<%= gColSpan %>" />
      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons" colspan="<%= gColSpan %>"><july:backbutton page="/EditPosition.do?action=View" paramId="storageplace" paramName="PositionForm" paramProperty="storageplace"/></TD>
            </TR>
            </TABLE>
		</TD>
      </tr>
      
	<july:separator colspan="<%= gColSpan %>" />
		<tr class="title">
          <td colspan="<%= gColSpan %>"><bean:message key="word.label.buildlist.param"/></td></tr>
	<july:separator colspan="<%= gColSpan %>" />
	<TR class="normal">
	<TD colspan="<%= gColSpan %>">
	<table class="find">
		<tr>
				<td><july:checkbox property="workerBeeline" styleId="workerBeeline" insertable="true" updatable="true" onclick="clearCheckbox(this, 'paspDataWorkerBeeline')"/></td>
				<td><bean:message key="word.label.buildlist.listBee"/></td>
		</tr>  
		<tr>
				<td>&nbsp;</td>
				<td><july:checkbox property="paspDataWorkerBeeline" styleId="paspDataWorkerBeeline"  insertable="true" updatable="true"/>&nbsp;&nbsp;&nbsp;<bean:message key="word.label.buildlist.paspData"/></td>
		</tr>  
		<tr>
				<td><july:checkbox property="workerNoBeeline" styleId="workerNoBeeline" insertable="true" updatable="true" onclick="clearCheckbox(this, 'paspDataWorkerNoBeeline')"/></td>
				<td><bean:message key="word.label.buildlist.listnoBee"/></td>
		</tr>  
		<tr>
				<td>&nbsp;</td>
				<td><july:checkbox property="paspDataWorkerNoBeeline" insertable="true" updatable="true"/>&nbsp;&nbsp;&nbsp;<bean:message key="word.label.buildlist.paspDataNoBee"/></td>
		</tr>  
		<tr>
				<td><july:checkbox property="carBeeline" insertable="true" updatable="true"/></td>
				<td><bean:message key="word.label.buildlist.carsBee"/></td>
		</tr>  
		<tr>
				<td><july:checkbox property="carNoBeeline" insertable="true" updatable="true"/></td>
				<td><bean:message key="word.label.buildlist.carsNoBee"/></td>
		</tr>  
	</table>    
	</TD>
	</TR>
	<july:separator colspan="<%= gColSpan %>" />
	<tr class="title">
		<td colspan="<%= gColSpan %>"><TABLE class="buttons">
			<TR class="title">
				<TD class="buttons" colspan="<%= gColSpan %>">
				<july:backbutton page="/EditPosition.do?action=View" paramId="storageplace" paramName="PositionForm" paramProperty="storageplace"/>
				<logic:equal name="BuildListPassForm" property="haveWordDoc" value="true">
					<input type='image' src="/images/load2word.gif"  border='0' alt='Сформировать список прохода'
						onclick='return confirm("После сохранения существующий документ <Список прохода> будет заменен. Продолжить ?");'
					>
				</logic:equal>
				<logic:equal name="BuildListPassForm" property="haveWordDoc" value="false">
					<input type='image' src="/images/load2word.gif"  border='0' alt='Сформировать список прохода'
					>
				</logic:equal>
				</TD>
			</TR>
		</TABLE>
		</TD>
      </tr>
	<july:separator colspan="<%= gColSpan %>" />

</table>
</july:browseform>

<%
	BuildListPassForm form = ((BuildListPassForm)session.getAttribute("BuildListPassForm"));
	String tempIdDoc = "" + form.getStorageplace();
%>

<july:wordedit styleId="wrded1" 
	url='<%= "printListPass.do" %>'
	uploadurl="ListPassWordUploadAction.do" documentid="<%= tempIdDoc %>"
	>
</july:wordedit>


<script language="javascript">
	if (document.all.showword.value == "1") {
		wrded1_call();
	}
</script>

<%--<script language="javascript">
if(!document.all.workerBeeline[0].checked){
	document.all.paspDataWorkerBeeline[0].checked=false;
	document.all.paspDataWorkerBeeline[0].disabled=true;
}
if(!document.all.workerNoBeeline[0].checked){
	document.all.paspDataWorkerNoBeeline[0].checked=false;
	document.all.paspDataWorkerNoBeeline[0].disabled=true;
}
</script>--%>