<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT> 

<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/ChargeProcess.do";
	String form = "ChargeDialogForm";
	String temp = null;
	String src = "/images/save.gif";
	String alt = "Сохранить запись";	
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<july:editform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="idContract"/>
<html:hidden property="id"/>
<html:hidden property="calctype" value="-"/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "Удалить запись"; %>
</logic:equal>

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
<logic:notEqual name="<%= form %>" property="action" value="Delete">	
		if(!field_check(theForm.summStr, 'Сумма начисления', 6, true)) return false;
		if(!field_check(theForm.beginDateStr, 'период c', 0, true)) return false;
		if(!field_check(theForm.endDateStr, 'период по', 0, true)) return false;
		//if(!field_check(theForm.dateEndSfStr, 'СФ период по', 0, true)) return false;
		if(!field_check(theForm.sumNdsStr,'В т.ч. НДС',6,true)) return false;
		if(!field_check(theForm['vo.currency'], 'Валюта начисления',4,true)) return false;
		//if(!field_check(theForm.otherMan, 'Кто принимал', 0, true)) return false;
</logic:notEqual>		
	}
	return true;
}
</script>
<% String isCertain = "true"; %>
<logic:equal name="<%= form %>" property="action" value="Add">
	<% isCertain = "false"; %>
</logic:equal>

<script language="javascript">

function switchRate() {
	if (document.all.byhandraterur[0].checked) {
		<%= form %>.rate.disabled = false;
		<%= form %>.rate.className = 'edit';
	} else {
		<%= form %>.rate.disabled = true;
		<%= form %>.rate.className = 'editdisabled';
	}
}

function switchDate() {
	if (document.all.isCorrection[0].checked) {
		<%= form %>.dateFrm.enabled = true;
	} else {
		<%= form %>.dateFrm.enabled = false;
	}
}

function update() {
	var ndsRate = new Number(coma_replace(document.all.ndsRateFrm.value, '.'));
    var sum = coma_replace(document.all.summFrm.value, '.');
	document.all.sumndsFrm.value = Math.round((sum * ndsRate) / (100.0 + ndsRate) * 100.0) / 100.0;
}

function coma_replace(n, dd){
	var a = n.toString().split(',');
	if(a[1] == null)
		return a[0]; 
	else 
		return (a[0] + dd + a[1]);
}
//при услуге-электроэнергия: валюта = руб.(при добавлении)
function setCurrency(){
	if(<%= form %>.resourcecode.value == "10448")
		<%= form %>.currencycode.value="810";	
}
</script>

<table class="main">

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
				<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="return Check();">
			&nbsp;<%--july:closebutton page="/"/--%>
			<a href="#" title="Закрыть" onclick="document.body.style.cursor='wait'; document.body.style.cursor='auto';"><IMG SRC="/images/cancel.gif" BORDER='0' ALT='Закрыть' onclick="document.body.style.cursor='auto'; window.close();"></a>
        </td>
    </tr>
    <july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
	</tr>
	
	<tr>
		<td class="text"><july:reqmark>Услуга:</july:reqmark></td>
		<td class="text">
			<july:select style="width: 300;" collection="resources" property="vo.resource" insertable="true" updatable="true" styleId="resourcecode">
				<html:options collection="resources" property="resource" labelProperty="name"/>
			</july:select>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark>Период:</july:reqmark></td>
		<td class="text">
			<july:date property="beginDateStr" size="25" insertable="true" updatable="true" required="<%= isCertain %>"/>&nbsp;
			по&nbsp;
			<july:date property="endDateStr" size="25" insertable="true" updatable="true" required="<%= isCertain %>"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark>Сумма начисления:</july:reqmark></td>
		<td class="text">
			<july:string size="10" property="summStr" insertable="true" updatable="true" styleId="summFrm" onkeyup="update()"/>&nbsp;
			<july:select style="width: 150;" collection="currencies" property="vo.currency" insertable="true" updatable="true" styleId="currencycode">
				<html:option value="">&nbsp;</html:option>
				<html:options collection="currencies" property="currency" labelProperty="name"/>
			</july:select>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark>В т.ч. НДС:</july:reqmark></td>
		<td class="text">
			<july:string size="5" property="sumNdsStr" insertable="true" updatable="true" styleId="sumndsFrm"/>
			<logic:notEqual name="<%= form %>" property="action" value="Delete">
				<logic:notEqual name="<%= form %>" property="action" value="View">
					&nbsp;<input type='image' name='submit' value='1' src='/images/obchet1.gif' alt='<bean:message key="label.filter.calcnds"/>' onclick='calctype.value = "N";'>
				</logic:notEqual>
			</logic:notEqual>
			СТАВКА НДС:
			<july:string size="5" property="ndsRateFrm" insertable="true" updatable="true" onkeyup="update()"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Номер счета:</td>
		<td class="text">
			<july:string size="15" property="vo.billNumber" insertable="true" updatable="true"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Дата счета:</td>
		<td class="text">
			<july:date property="billDateStr" size="25" insertable="true" updatable="true" required="false"/>
		</td>
	</tr>		
	
	<%
		String isEdit = "false";	
		if(request.isUserInRole("administrator")) {
	%>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Корр. начисление:</td>
		<td class="text">
			<july:checkbox property="isCorrection" insertable="<%= isEdit%>" updatable="<%= isEdit%>" onclick="switchDate()"/>&nbsp;
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Дата учета в акте :</td>
		<td class="text">
			<july:date property="dateStr" size="25" insertable="<%= isEdit%>" updatable="<%= isEdit%>" styleId="dateFrm"/>
		</td>
	</tr>	

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Курс неоплаченной части начисления в рубли:</td>
		<td class="text">
			<july:checkbox property="byhandraterur" insertable="<%= isEdit%>" updatable="<%= isEdit%>" styleId="byhandraterur" onclick="switchRate()"/>&nbsp;
			<july:string size="25" property="remainderRate2RurStr" insertable="<%= isEdit%>" updatable="<%= isEdit%>" styleId="rate"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Источник:</td>
		<td class="text">
			<logic:equal name="<%= form %>" property="vo.source" value="A"><bean:message key="label.docpositions.source.auto"/></logic:equal>
			<logic:equal name="<%= form %>" property="vo.source" value="B"><bean:message key="label.docpositions.source.bill"/></logic:equal>
			<logic:equal name="<%= form %>" property="vo.source" value="P"><bean:message key="label.docpositions.source.platinum"/></logic:equal>
			<logic:equal name="<%= form %>" property="vo.source" value="M"><bean:message key="label.docpositions.source.manual"/></logic:equal>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Тип:</td>
		<td class="text">
			<logic:equal name="<%= form %>" property="vo.docPosVid" value="Q"><bean:message key="label.docpositions.docposvid.q"/></logic:equal>
			<logic:equal name="<%= form %>" property="vo.docPosVid" value="K"><bean:message key="label.docpositions.docposvid.k"/></logic:equal>
			<logic:equal name="<%= form %>" property="vo.docPosVid" value="Z"><bean:message key="label.docpositions.docposvid.z"/></logic:equal>
			<logic:equal name="<%= form %>" property="vo.docPosVid" value="N"><bean:message key="label.docpositions.docposvid.n"/></logic:equal>
			<logic:equal name="<%= form %>" property="vo.docPosVid" value="C"><bean:message key="label.docpositions.docposvid.c"/></logic:equal>
		</td>
	</tr>
	<%}%>
	
<%--logic:notEqual name="<%= form %>" property="action" value="<%=com.hps.july.web.util.EditForm.ACTION_ADD%>"--%>	
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			Формировать СФ:
			<july:checkbox property="needSf" insertable="true" updatable="true" styleId="needSf"/>
			<%--logic:equal name="<%= form %>" property="vo.needSf" value="N">
				<img src="/images/check_off.gif" border="0" alt='Формировать СФ'/>
			</logic:equal>
			<logic:equal name="<%= form %>" property="vo.needSf" value="Y">
				<img src="/images/check_on.gif" border="0" alt='Формировать СФ'/>
			</logic:equal--%>			
		</td>
		<td class="text">
			Формировать Акт ВР:
			<july:checkbox property="needCwAct" insertable="true" updatable="true" styleId="needCwAct"/>
			<%--logic:equal name="<%= form %>" property="vo.needCwAct" value="N">
				<img src="/images/check_off.gif" border="0" alt='Формировать Акт выполненных работ'/>
			</logic:equal>
			<logic:equal name="<%= form %>" property="vo.needCwAct" value="Y">
				<img src="/images/check_on.gif" border="0" alt='Формировать Акт выполненных работ'/>
			</logic:equal--%>			
		</td>
	</tr>
<%--/logic:notEqual--%>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text" nowrap="nowrap">учет СФ(старый):
			<logic:equal name="<%= form %>" property="vo.isSchetFakt1" value="N">
				<img src="/images/check_off.gif" border="0" alt='<bean:message key="label.dhist.btnissf"/> 1'/>
			</logic:equal>
			<logic:equal name="<%= form %>" property="vo.isSchetFakt1" value="Y">
				<img src="/images/check_on.gif" border="0" alt='<bean:message key="label.dhist.btnissf"/> 1'/>
			</logic:equal>
			<logic:equal name="<%= form %>" property="vo.isSchetFakt2" value="N">
				<img src="/images/check_off.gif" border="0" alt='<bean:message key="label.dhist.btnissf"/> 2'/>
			</logic:equal>
			<logic:equal name="<%= form %>" property="vo.isSchetFakt2" value="Y">
				<img src="/images/check_on.gif" border="0" alt='<bean:message key="label.dhist.btnissf"/> 2'/>
			</logic:equal>
			<logic:equal name="<%= form %>" property="vo.isSchetFakt3" value="N">
				<img src="/images/check_off.gif" border="0" alt='<bean:message key="label.dhist.btnissf"/> 3'/>
			</logic:equal>
			<logic:equal name="<%= form %>" property="vo.isSchetFakt3" value="Y">
				<img src="/images/check_on.gif" border="0" alt='<bean:message key="label.dhist.btnissf"/> 3'/>
			</logic:equal>									
		
		</td>
		<td class="text" nowrap="nowrap">учет АВ по старому виду:
			<logic:equal name="<%= form %>" property="vo.isWorkAct1" value="N">
				<img src="/images/check_off.gif" border="0" alt='Признак наличия АВ 1'/>
			</logic:equal>
			<logic:equal name="<%= form %>" property="vo.isWorkAct1" value="Y">
				<img src="/images/check_on.gif" border="0" alt='Признак наличия АВ 1'/>
			</logic:equal>
			<logic:equal name="<%= form %>" property="vo.isWorkAct2" value="N">
				<img src="/images/check_off.gif" border="0" alt='Признак наличия АВ 2'/>
			</logic:equal>
			<logic:equal name="<%= form %>" property="vo.isWorkAct2" value="Y">
				<img src="/images/check_on.gif" border="0" alt='Признак наличия АВ 2'/>
			</logic:equal>
			<logic:equal name="<%= form %>" property="vo.isWorkAct3" value="N">
				<img src="/images/check_off.gif" border="0" alt='Признак наличия АВ 3'/>
			</logic:equal>
			<logic:equal name="<%= form %>" property="vo.isWorkAct3" value="Y">
				<img src="/images/check_on.gif" border="0" alt='Признак наличия АВ 3'/>
			</logic:equal>									
		</td>
	</tr>
	
<logic:notEqual name="<%= form %>" property="action" value="Add">
<july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="text">создал:</td>
        <td>
			<bean:write name="<%=form%>" property="vo.createdByName"  filter="true" />(<july:datewrite name="<%=form%>" property="vo.created" showtime="true"/>)
        </td>
    </tr>
    <tr>
        <td class="text">изменил:</td>
        <td>
			<bean:write name="<%=form%>" property="vo.modifiedByName"  filter="true" />(<july:datewrite name="<%=form%>" property="vo.modified" showtime="true"/>)
        </td>
    </tr>
</logic:notEqual>
	
	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
				<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="return Check();">
			&nbsp;<%--july:closebutton page="/"/--%>
			<a href="#" title="Закрыть" onclick="document.body.style.cursor='wait'; document.body.style.cursor='auto';"><IMG SRC="/images/cancel.gif" BORDER='0' ALT='Закрыть' onclick="document.body.style.cursor='auto'; window.close();"></a>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>
</table>

<logic:equal name="<%=form%>" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>

<script language="javascript">
	switchRate();
</script>
<logic:notEqual name="<%= form %>" property="action" value="Delete">
	<logic:notEqual name="<%= form %>" property="action" value="View">
		<script language="javascript">
			switchDate();
		</script>
	</logic:notEqual>
</logic:notEqual>

<logic:equal name="<%= form %>" property="action" value="Add">
		<script language="javascript">
			setCurrency();
		</script>
</logic:equal>

<script language="javascript" type="text/javascript">
	if(<%= form %>.docnumber != null)
		<%= form %>.docnumber.focus();
</script>

</july:editform>
