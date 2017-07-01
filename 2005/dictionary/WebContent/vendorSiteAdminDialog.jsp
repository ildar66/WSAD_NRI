<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*,com.hps.july.valueobject.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT> 
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/VendorSiteAdminProcess.do";
	String form = "VendorSiteAdminDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
	String isUpdatable = "false";
	boolean isWideView = request.isUserInRole("administrator") || request.isUserInRole("developer");
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "Удалить запись"; %>
</logic:equal>
<logic:equal name="<%= form %>" property="to.vo.source" value="2">
		<% isUpdatable = "true"; %>
</logic:equal>

<july:editform action="<%= action %>" styleId="<%= form %>" focus="to.vo.name">
<html:hidden property="id"/>
<html:hidden property="vendor_VO.typeVendor"/>

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
<logic:notEqual name="<%= form %>" property="action" value="Delete">	
	with(theForm){
		if(!field_check(theForm['vendor_VO.name'], 'Наименование поставщика(из справочника)', 0, true)) return false;
		//if(!field_check(theForm['vo.vendorSiteCode'], 'Код', 3, true)) return false;
		if(!field_check(theForm['to.vo.name'], 'Наименование', 0, true)) return false;
		//if(!field_check(theForm['to.vo.kpp'], 'КПП', 3, true)) return false;
		//if(!field_check(theForm['vo.korAccount'], 'Банк.Корр-счет', 3, true)) return false;
		//if(!field_check(theForm.summStr, 'Сумма начисления', 6, true)) return false;
		//if(!field_check(theForm.beginDateStr, 'период c', 0, true)) return false;
		//if(!field_check(theForm.endDateStr, 'период по', 0, true)) return false;
		//if(!field_check(theForm.dateEndSfStr, 'СФ период по', 0, true)) return false;
		//if(!field_check(theForm.sumNdsStr,'В т.ч. НДС',6,true)) return false;
		if(!field_check(theForm['to.vo.idOwnerNfs'], 'Владелец',0,true)) return false;
		//if(!field_check(theForm.otherMan, 'Кто принимал', 0, true)) return false;
	}
</logic:notEqual>	
	return true;
}
function changeTypeVendor(){
	var theForm = document.<%= form %>;
	if(theForm['vendor_VO.typeVendor'].value == "<%=Vendor_VO.TYPE_VENDOR_JURIDICAL%>") {
		kpp_ID.style.setAttribute("display", "block");
		accountManagerFio_ID.style.setAttribute("display", "block");
		directorFio_ID.style.setAttribute("display", "block");
		directorJob_ID.style.setAttribute("display", "block");
		lastName_ID.style.setAttribute("display", "none");
		firstName_ID.style.setAttribute("display", "none");
		middleName_ID.style.setAttribute("display", "none");
		passportSer_ID.style.setAttribute("display", "none");
		passportNum_ID.style.setAttribute("display", "none");
		passportDate_ID.style.setAttribute("display", "none");
		passportWhom_ID.style.setAttribute("display", "none");
	} else if (theForm['vendor_VO.typeVendor'].value == "<%=Vendor_VO.TYPE_VENDOR_PHYSICAL%>"){
		kpp_ID.style.setAttribute("display", "none");
		accountManagerFio_ID.style.setAttribute("display", "none");
		directorFio_ID.style.setAttribute("display", "none");
		directorJob_ID.style.setAttribute("display", "none");
		lastName_ID.style.setAttribute("display", "block");
		firstName_ID.style.setAttribute("display", "block");
		middleName_ID.style.setAttribute("display", "block");
		passportSer_ID.style.setAttribute("display", "block");
		passportNum_ID.style.setAttribute("display", "block");
		passportDate_ID.style.setAttribute("display", "block");
		passportWhom_ID.style.setAttribute("display", "block");		
	} else if (theForm['vendor_VO.typeVendor'].value == "<%=Vendor_VO.TYPE_VENDOR_OTHER%>"){
		kpp_ID.style.setAttribute("display", "block");
		accountManagerFio_ID.style.setAttribute("display", "none");
		directorFio_ID.style.setAttribute("display", "none");
		directorJob_ID.style.setAttribute("display", "none");
		lastName_ID.style.setAttribute("display", "none");
		firstName_ID.style.setAttribute("display", "none");
		middleName_ID.style.setAttribute("display", "none");
		passportSer_ID.style.setAttribute("display", "none");
		passportNum_ID.style.setAttribute("display", "none");
		passportDate_ID.style.setAttribute("display", "none");
		passportWhom_ID.style.setAttribute("display", "none");	
	} else {
		kpp_ID.style.setAttribute("display", "none");
		accountManagerFio_ID.style.setAttribute("display", "none");
		directorFio_ID.style.setAttribute("display", "none");
		directorJob_ID.style.setAttribute("display", "none");
		lastName_ID.style.setAttribute("display", "none");
		firstName_ID.style.setAttribute("display", "none");
		middleName_ID.style.setAttribute("display", "none");
		passportSer_ID.style.setAttribute("display", "none");
		passportNum_ID.style.setAttribute("display", "none");
		passportDate_ID.style.setAttribute("display", "none");
		passportWhom_ID.style.setAttribute("display", "none");	
	}
}
function onChangeName(){
	var theForm = document.<%= form %>;
	theForm['to.vo.name'].value = theForm['to.vo.lastName'].value + " " + theForm['to.vo.firstName'].value + " " + theForm['to.vo.middleName'].value;
}		
</script>

<table class="main" style="font-size:8pt;">

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
    		<july:actionalert/><B style="font-size: 8pt; color: blue"> &uml;Отделение: id: <bean:write name="<%= form %>" property="to.vo.idVendorSite"/>&uml;</B>
    	</td>
    </tr>
    <july:separator/>
    
    <tr>
        <td class="text">Код поставщика:</td>
        <td>
			<july:string style="font-size:8pt;" property="vendor_VO.vendorCode" size="25" insertable="false" updatable="false" />
			<html:hidden property="to.vo.idVendor"/>
			<%if(isUpdatable.equals("true")){%>
			<html:link page="/../dict/VendorLookupList.do?formname=VendorSiteAdminDialogForm&onMySelect=changeTypeVendor();&fieldnames=to.vo.idVendor|vendor_VO.vendorCode|vendor_VO.name|vendor_VO.inn|to.vo.name|to.vo.address|to.vo.accountManagerFio|to.vo.directorFio|to.vo.directorJob|vendor_VO.typeVendor" onclick="return openDialog(this.href, 'VendorLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes');" title="справочник поставщиков">		
				<img src='/images/lookup.gif' border='0' alt='Справочник поставщиков'></html:link>		
			<%}%>
        </td>
    </tr>
    <tr>
        <td class="text">Наименование поставщика:</td>
        <td>
          <july:string style="font-size:8pt;" property="vendor_VO.name" size="30" insertable="false" updatable="false" />
        </td>
    </tr>
    <tr>
        <td class="text">Инн поставщика:</td>
        <td>
          <july:string style="font-size:8pt;" property="vendor_VO.inn" size="25" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text">Код отделения:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.vendorSiteCode" size="25" insertable="false" updatable="false" />
        </td>
    </tr>
    <tr>
        <td class="text"><july:reqmark>Наименование:</july:reqmark></td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.name" size="30" insertable="true" updatable="<%= isUpdatable%>" />
        </td>
    </tr>
    <tr>
        <td class="text">Наименование для печати:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.nameForPrintDoc" size="30" insertable="true" updatable="true" />
        </td>
    </tr>       
    <tr>
        <td class="text"><july:reqmark>Владелец:</july:reqmark></td>
        <td>
		    <july:select style="width: 130; font-size:8pt;" collection="owners" property="to.vo.idOwnerNfs" insertable="true" updatable="true">
		    	<%--html:option value=""/--%>
				<html:options collection="owners" property="idOwnerNFS" labelProperty="nameOwnerNFS"/>
		   	</july:select>          
        </td>
    </tr>
    <tr>
        <td class="text">Адрес:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.address" size="30" insertable="true" updatable="<%= isUpdatable%>" />
        </td>
    </tr>
    <tr>
        <td class="text">Адрес для печати:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.addressForPrintDoc" size="30" insertable="true" updatable="true" />
        </td>
    </tr>    
           
    <%--july:separator/--%>
    
    <tr id="kpp_ID">
        <td class="text">КПП:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.kpp" size="30" insertable="true" updatable="<%= isUpdatable%>" />
        </td>
    </tr>
    <tr id="accountManagerFio_ID">
        <td class="text">ФИО бухгалтера:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.accountManagerFio" size="30" insertable="true" updatable="true" />
        </td>
    </tr>
    <tr id="directorFio_ID">
        <td class="text">ФИО руководителя:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.directorFio" size="30" insertable="true" updatable="true" />
        </td>
    </tr>
	<tr id="directorJob_ID">
        <td class="text">Должность руководителя:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.directorJob" size="30" insertable="true" updatable="true" />
        </td>
    </tr>
    
   <tr id="lastName_ID">
        <td class="text">Фамилия:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.lastName" size="30" insertable="true" updatable="true" onchange="onChangeName()" />
        </td>
    </tr>
    <tr id="firstName_ID">
        <td class="text"> Имя: </td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.firstName" size="30" insertable="true" updatable="true" onchange="onChangeName()" />
        </td>
    </tr>
	<tr id="middleName_ID">
        <td class="text">Отчество:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.middleName" size="30" insertable="true" updatable="true" onchange="onChangeName()" />
        </td>
    </tr>
	<tr id="passportSer_ID">
        <td class="text">серия паспорта:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.passportSer" size="30" insertable="true" updatable="true" />
        </td>
    </tr>    
	<tr id="passportNum_ID">
        <td class="text">номер паспорта:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.passportNum" size="30" insertable="true" updatable="true" />
        </td>
    </tr>
	<tr id="passportDate_ID">
        <td class="text">когда выдан:</td>
        <td>
          <july:date style="font-size:8pt;" required="false" property="to.passportDate"  insertable="true" updatable="true" />
        </td>
    </tr>
	<tr id="passportWhom_ID">
        <td class="text">кем выдан:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.passportWhom" size="30" insertable="true" updatable="true" />
        </td>
    </tr>    
    
    <%--july:separator colspan="<%= gColSpan %>"/--%>
        
    <tr>
        <td class="text">Коммент:</td>
        <td>
          <july:textarea style="font-size:8pt; width: 400;" property="to.vo.comment" cols="30" rows="3" insertable="true" updatable="true" />
        </td>
    </tr>
    <july:separator colspan="<%= gColSpan %>"/>

<logic:notEqual name="<%= form %>" property="action" value="Add">    
    <%if(isWideView){%>
    <tr>    
    	<td colspan="2">
    	<table class="main" style="font-size:8pt;">
		    <tr>
		        <td class="text">создал:</td>
		        <td>
					<bean:write name="<%=form%>" property="to.createdBy"  filter="true" />(<july:datewrite name="<%=form%>" property="to.vo.created" />)
		        </td>
		    </tr>
		    <tr>
		        <td class="text">изменил:</td>
		        <td>
					<bean:write name="<%=form%>" property="to.modifiedBy"  filter="true" />(<july:datewrite name="<%=form%>" property="to.vo.modified" />)
		        </td>
		    </tr>
		    <tr>
		        <td class="text">ссылка на отд. в НФС:</td>
		        <td><bean:write name="<%=form%>" property="to.vo.idVendorSiteNFS"  filter="true" /></td>
		    </tr>
		    <tr>
		        <td class="text">использовать в NRI:</td>
		        <td><bean:write name="<%=form%>" property="to.vo.useInNri"  filter="true" /></td>
		    </tr>
		    <tr>
		        <td class="text">источник:</td>
		        <td><bean:write name="<%=form%>" property="to.vo.sourceStr"  filter="true" /></td>
		    </tr>
		    <tr>
		        <td class="text">Статус:</td>
		        <td><bean:write name="<%=form%>" property="to.vo.recordStatus"  filter="true" /></td>
		    </tr>
	    </table>
        </td>
    </tr>		    
    <july:separator colspan="<%= gColSpan %>"/>                      
    <%}%>
</logic:notEqual>
    
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

<script language="javascript" type="text/javascript">
	changeTypeVendor();
</script>

</july:editform>

