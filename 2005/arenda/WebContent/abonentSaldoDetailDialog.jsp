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
    String action = "/AbonentSaldoDetailProcess.do";
	String form = "AbonentSaldoDetailDialogForm";
	String temp = null;//tmp
	String src = "/images/save.gif";
	String alt = "Сохранить запись";	
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="idContract"/>
<html:hidden property="id"/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "Удалить запись"; %>
</logic:equal>


<script language='javascript'>
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
			if(!field_check(theForm.salDate, 'дата', 7, true)) return false;
			//if(!field_check(theForm.endDateStr, 'период по', 0, true)) return false;
			//if(!field_check(theForm.dateEndSfStr, 'СФ период по', 0, true)) return false;
			if(!field_check(theForm.mainSum, 'Сумма в осн. валюте', 6, true)) return false;
			if(!field_check(theForm.mainNdsSum,'НДС в осн. валюте', 6, true)) return false;
			if(!field_check(theForm.rateNds,'Ставка НДС', 8, true)) return false;
			//if(!field_check(theForm['vo.currency'], 'Валюта начисления',4,true)) return false;
			//if(!field_check(theForm.otherMan, 'Кто принимал', 0, true)) return false;
			if(theForm.addcurr.value != "0") {
				if(!field_check(theForm.addSum, 'Сумма в доп. валюте', 6, true)) return false;
				if(!field_check(theForm.addNds,'НДС в доп. валюте', 6, true)) return false;
			}
			if(!field_check(theForm['to.vo.notes'], 'Причина изменения сальдо', 0, true)) return false;				
		</logic:notEqual>		
	}
	return true;
}

function popCalInFrame(dateCtrl) {
	var w=gfPop;
	//w.gbFixedPos=true;	// enable fixed positioning
	//w.gPosOffset=[70,0];	// set position
	w.fPopCalendar(dateCtrl);	// pop calendar
}

function switchDopFilter() {
	var theForm = document.<%= form %>;
	if(theForm.addcurr.value != "0") {
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "block");
		}
	} else {
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "none");
		}
	}
}

function updateSumNds(sum, rate) {
    var sum = coma_replace(sum, '.');
	var ndsRate = new Number(coma_replace(rate, '.'));
	return Math.round((sum * ndsRate) / (100.0 + ndsRate) * 100.0) / 100.0;
}

function updateRateNds() {
	document.all.mainNdsSum.value = updateSumNds(document.all.mainSum.value, document.all.rateNds.value);
	document.all.addNds.value = updateSumNds(document.all.addSum.value, document.all.rateNds.value);
}
	
function coma_replace(n, dd) {
	var a = n.toString().split(',');
	if(a[1] == null)
		return a[0]; 
	else 
		return (a[0] + dd + a[1]);
}

function updateGroupRec(){
	var theForm = document.<%= form %>;
	if(!theForm.groupRec.checked) {
		document.all.rateNds.value = "18";
	}else{
		document.all.rateNds.value = "0";
	}
	updateRateNds();
	updateGroupRec2();
}

function updateGroupRec2(){
	var theForm = document.<%= form %>;
	if(!theForm.groupRec.checked) {
		document.all.mainNdsSum.disabled=false;
		document.all.addNds.disabled=false;
		document.all.rateNds.disabled=false;
	}else{
		document.all.mainNdsSum.disabled=true;
		document.all.addNds.disabled=true;
		document.all.rateNds.disabled=true;
	}
}
</script>

<table class="main" style="font-size: 8pt">
	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="return Check();">
			<a href="#" title="Закрыть" onclick="document.body.style.cursor='wait'; document.body.style.cursor='auto';"><IMG SRC="/images/cancel.gif" BORDER='0' ALT='Закрыть' onclick="document.body.style.cursor='auto'; window.close();"></a>
        </td>
    </tr>

    <july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.saldo.saldate"/>:</july:reqmark></td>
		<td class="text">
			<%--july:date property="to.salDate" size="25" insertable="true" updatable="false" required="true"/--%>
			<html:text property="to.salDate" size="11" styleId="salDate"/>
				<a href="javascript:void(0)" onclick="popCalInFrame(document.<%= form %>.salDate);return false;" HIDEFOCUS>
					<img name="popcal" align="absbottom" src="/images/calbtn.gif" width="34" height="22" border="0" alt=""></a>			
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.saldo.resource"/>:</july:reqmark></td>
		<td class="text">
			<logic:equal name="<%= form %>" property="action" value="Add">
				<% temp = "true"; %>
			</logic:equal>
			<logic:notEqual name="<%= form %>" property="action" value="Add">
				<% temp = "false"; %>
			</logic:notEqual>
		    <july:select style="width: 300;" collection="resources" property="to.vo.resource" insertable="<%= temp %>" updatable="<%= temp %>">
				<html:options collection="resources" property="resource" labelProperty="name"/>
		   	</july:select>
		</td>
    </tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Сумма в осн. валюте:</july:reqmark></td>
		<td class="text">
			<july:string size="10" property="to.mainSum" insertable="true" updatable="true" styleId="mainSum" onkeyup="document.all.mainNdsSum.value = updateSumNds(document.all.mainSum.value, document.all.rateNds.value);"/>&nbsp;
		    <july:select style="width: 160;" collection="currencies" property="to.vo.mainCurrency" insertable="true" updatable="true">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
		</td>
	</tr>

	<tr>
		<td class="text"><july:reqmark>НДС в осн. валюте:</july:reqmark></td>
		<td class="text">
			<july:string size="10" property="to.mainNdsSum" insertable="true" updatable="true" styleId="mainNdsSum"/>
			<%--logic:notEqual name="<%= form %>" property="action" value="Delete">
				<logic:notEqual name="<%= form %>" property="action" value="View">
					&nbsp;<input type='image' name='submit' src="/images/obchet1.gif" alt='<bean:message key="label.filter.calcnds"/>' onclick='calctype.value = "N";'>
				</logic:notEqual>
			</logic:notEqual--%>
		</td>
	</tr>
	
	<tr>
		<td class="text"><july:reqmark>Ставка НДС:</july:reqmark></td>
		<td class="text">
			<july:string size="10" property="to.rateNds" insertable="true" updatable="true" styleId="rateNds" onkeyup="updateRateNds();"/>&nbsp;
			НДС по акту: <july:checkbox property="to.groupRec" insertable="true" updatable="true" styleId="groupRec" onclick="updateGroupRec();"/>
		</td>
	</tr>	

	<tr>
		<td class="text" colspan="<%= gColSpan %>">
			<bean:message key="label.saldo.msumcalc"/>: <july:sumwrite name="<%= form%>" property="to.vo.MSumCalc"/>
		</td>
		<%--td class="text"><july:string size="25" property="to.vo.MSumCalc" insertable="false" updatable="false"/></td--%>
	</tr>

	<tr>
		<td class="text" colspan="<%= gColSpan %>">
			<bean:message key="label.saldo.mndscalc"/>: <july:sumwrite name="<%= form%>" property="to.vo.MNdsCalc"/>
		</td>
		<%--td class="text"><july:string size="25" property="to.vo.MNdsCalc" insertable="false" updatable="false"/></td--%>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"colspan="2">
			<B><bean:message key="label.saldo.isadd"/>:</B>
			<%--july:checkbox property="isDopFilter" onclick="switchDopFilter()" insertable="true" updatable="true"/--%>
		    <july:select style="width: 160;" collection="currencies" property="to.vo.additionalCurrency" insertable="true" updatable="true" styleId="addcurr" onchange="switchDopFilter()">
		    	<html:option value="0">нет</html:option>
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>			
		</td>
	</tr>
	
	<tr id="dopFilterID">
		<td class="text">Сумма в доп. валюте:</td>
		<td class="text">
			<july:string size="10" property="to.additionalSum" insertable="true" updatable="true" styleId="addSum" onkeyup="document.all.addNds.value = updateSumNds(document.all.addSum.value, document.all.rateNds.value);"/>&nbsp;
		</td>
	</tr>
	
	<tr id="dopFilterID">
		<td class="text">НДС в доп. валюте:</td>
		<td class="text">
			<july:string size="10" property="to.additionalNdsSum" insertable="true" updatable="true" styleId="addNds"/>
			<%--logic:notEqual name="<%= form %>" property="action" value="Delete">
				<logic:notEqual name="<%= form %>" property="action" value="View">
					&nbsp;<input type='image' name='submit' src="/images/obchet1.gif" alt='<bean:message key="label.filter.calcnds"/>' onclick='calctype.value = "NA";'>
				</logic:notEqual>
			</logic:notEqual--%>
		</td>
	</tr>

	<tr id="dopFilterID">
		<td class="text" colspan="<%= gColSpan %>">
			<bean:message key="label.saldo.asumcalc"/>: <july:sumwrite name="<%= form%>" property="to.vo.ASumCalc"/>
		</td>
		<%--td class="text"><july:string size="25" property="to.vo.ASumCalc" insertable="false" updatable="false"/></td--%>
	</tr>

	<tr id="dopFilterID">
		<td class="text" colspan="<%= gColSpan %>">
			<bean:message key="label.saldo.andscalc"/>: <july:sumwrite name="<%= form%>" property="to.vo.ANdsCalc"/>
		</td>
		<%--td class="text"><july:string size="25" property="to.vo.ANdsCalc" insertable="false" updatable="false"/></td--%>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text" colspan="<%= gColSpan %>" align="center"><B><bean:message key="label.saldo.notes"/>:</B></td>
	</tr>	
	<tr>
		<td class="text" colspan="<%= gColSpan %>">
			<july:textarea style="width: 450;" cols="30" rows="3" property="to.vo.notes" insertable="true" updatable="true"/>
		</td>
	</tr>
	
	<%--july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><bean:message key="label.saldo.operator"/>:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="operatorName" />
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<july:formbuttons/>
	<july:separator colspan="<%= gColSpan %>"/--%>
	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="return Check();">
			<a href="#" title="Закрыть" onclick="document.body.style.cursor='wait'; document.body.style.cursor='auto';"><IMG SRC="/images/cancel.gif" BORDER='0' ALT='Закрыть' onclick="document.body.style.cursor='auto'; window.close();"></a>
        </td>
    </tr>
    <july:separator colspan="<%= gColSpan %>"/>		
</table>

<script language='javascript'>
	switchDopFilter();
	updateGroupRec2()
</script>
<%--logic:equal name="<%= form %>" property="action" value="Add">
	<script language='javascript'>
		switchDopFilter();
	</script>
</logic:equal>


<logic:notEqual name="<%= form %>" property="action" value="Add">
	<logic:present name="<%= form %>" property="additionalsum">
		<script language='javascript'>
			document.all.isAdd[0].checked = true;
		</script>
	</logic:present>
</logic:notEqual>


<logic:notEqual name="<%= form %>" property="action" value="Delete">
	<logic:notEqual name="<%= form %>" property="action" value="View">
		<script language='javascript'>
			switchAdd();
		</script>
	</logic:notEqual>
</logic:notEqual--%>

<logic:equal name="<%=form%>" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>

</july:editform>
<!-- Opera 7.0 has a z-index bug that prevents the calendar panel from floating above the centerIframe.
A workaround is to move the <iframe> calendar tag from the page bottom to page top.
-->
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="ipopeng.jsp" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;">
</iframe>
