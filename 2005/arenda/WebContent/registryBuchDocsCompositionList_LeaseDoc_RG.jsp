<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.*, com.hps.july.arenda.formbean.*" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%!
	private String isUp(String aSort, String name) {
		 if(aSort.startsWith(name)) {
			 if(aSort.endsWith("desc")) 
				return (" <img src='/images/up.gif'  border='0' alt='по возрастанию'> ");
			 else
				return (" <img src='/images/down.gif'  border='0' alt='по убыванию'> "); 
		 }
		 else return ("");      
	}
%>

<%
	String gColSpan = "13";
	RegistryBuchDocsCompositionListForm listForm = (RegistryBuchDocsCompositionListForm)request.getAttribute("RegistryBuchDocsCompositionListForm");
	String sortBy = listForm.getOrderBy();
	//роли:
	//boolean isArendaPurchaser = request.isUserInRole("ArendaPurchaser");
	//boolean isArendaAccountant = request.isUserInRole("ArendaAccountant");
	//группы:
	//boolean isReturnDocumentGroup = isArendaPurchaser || isArendaAccountant;
	//boolean isInitialGroup = !isReturnDocumentGroup;
	boolean isInitialGroup = false;
	//boolean isEdit = !listForm.getTo().getVo().getState().equals("3");
	boolean isEdit = listForm.getTo().getVo().getState().equals("1") && isInitialGroup;	
%>


<july:browseform action="/RegistryBuchDocsCompositionList.do" styleId="listForm">
<html:hidden property="orderBy"/>
<html:hidden property="operation" value=""/>
<html:hidden property="economist"/>
<html:hidden property="idRegistryDoc"/>
<html:hidden property="selectIds" value=""/>
<html:hidden property="isInitialGroup"/>

<style>
TR.include {
	background-color:#A5F3C6;
}
TR.exclude {
	background-color:#F0F0F0;
}
TR.selectedrow {
	background-color:#FFF0D0;
} 
</style>

<script language="javascript">
function SortBy(field) 
{
	var e = document.all.orderBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
function SaveComposition(){
	var retStr = "";
	var e = listForm.selIds;
	var isOK = false;
	if(e == null) return;
	if(e.length){	
		for(var i = 0, j = 0; i < e.length; i++){
			if(e[i].checked) {
			    if(j == 0)
					retStr  =  "" + e[i].value ;
				else
					retStr  =  retStr + ", " + e[i].value;
				j++;
				isOK = true;
		    }
		 }
	}else{
		if(e.checked){
			retStr = retStr + e.value;
			isOK = true;
		}
	}
	//alert("retStr="+retStr);//temp
	listForm.selectIds.value=retStr;
	listForm.operation.value="save";
	listForm.submit();
}
</script>

<table class="main" border='0' style="font-size:8pt;">

<july:separator colspan="<%= gColSpan %>" />

<!---buttons and navigator begin -->
<tr class="title">
   <td colspan="<%= gColSpan %>">
      <TABLE class="buttons">
      <tr class="title">
         <td class="buttons">
         	<%if(isEdit){%>
         	  <A title="Сохранить" href="javascript:SaveComposition()"><IMG SRC="/images/save.gif" BORDER='0' ALT='Сохранить'></A>
         	<%}%>
              <july:backbutton/>
         </td>
         <th class="navigator">Текущие документы описи №: <bean:write name="RegistryBuchDocsCompositionListForm" property="idRegistryDoc"/></th>
         <td class="navigator"><july:navigator /></td>
      </tr>
      </TABLE>
   </td>
</tr>
<!---buttons and navigator end-->

<!-- Table header  begin :-->
<tr class="title">
	   <td  class="title">&nbsp;</td>
       <td  class="title">
			<A title="Сортировать по полю 'Номер договора'" href="javascript:SortBy('ld.docNumber')">Номер договора</A><%=isUp(sortBy, "ld.docNumber")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Дата договора'" href="javascript:SortBy('ld.docDate')">Дата договора</A><%=isUp(sortBy, "ld.docDate")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Организация'" href="javascript:SortBy('nameOrg')">Организация</A><%=isUp(sortBy, "nameOrg")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Наименование Позиции'" href="javascript:SortBy('namePosition')">наим. позиции</A><%=isUp(sortBy, "namePosition")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Номер позиции'" href="javascript:SortBy('numberPosition')">№ позиции</A><%=isUp(sortBy, "numberPosition")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Номер д.с.'" href="javascript:SortBy('docNdop')">Номер д.с.</A><%=isUp(sortBy, "docNdop")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Дата д.с.'" href="javascript:SortBy('docDdop')">Дата д.с.</A><%=isUp(sortBy, "docDdop")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Сумма'" href="javascript:SortBy('summ1')">Сумма</A><%=isUp(sortBy, "summ1")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Валюта'" href="javascript:SortBy('nameCurrency')">Валюта</A><%=isUp(sortBy, "nameCurrency")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Тип договора'" href="javascript:SortBy('typeContract')">Тип договора</A><%=isUp(sortBy, "typeContract")%></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
<!-- Table header  end :-->        


        <!-- Table body begin-->
        
        <logic:iterate id="it" name="browseList" indexId="index" type="com.hps.july.arenda.valueobject.RegistryBuchCompositionLeaseDoc_TO">
            <logic:present name="it">
			<% String idStr = String.valueOf(((com.hps.july.arenda.valueobject.RegistryBuchCompositionLeaseDoc_TO)it).getLeaseDocument()); %>
            <tr class="include" onMouseOver="className='select'" onMouseOut="className='include'">
           		<td class="text">
            	<%if(isEdit){%>
                	<input type="checkbox" name="selIds" value='<%= idStr %>' id="selIds" checked="checked">            
                <%}%>
                </td>
                <td class="number">
                    <bean:write name="it" property="docNumber" filter="true"/></td>
                <td class="text">
                	<july:datewrite name="it" property="docDate"/></td>
                <td class="number">
                    <bean:write name="it" property="nameOrg" filter="true"/></td>
                <td class="number">
                    <bean:write name="it" property="namePosition" filter="true"/></td>                                                                     
                <td class="number">
                    <bean:write name="it" property="numberPosition" filter="true"/></td>                                                                     
                <td class="number">
                    <bean:write name="it" property="docNumberDop" filter="true"/></td>
                <td class="text">
                    <july:datewrite name="it" property="docDateDop"/></td>
                <td class="number" align="right">
                    <july:sumwrite name="it" property="sum"/></td>
                <td class="number">
                    <bean:write name="it" property="nameCurrency" filter="true"/></td>
                <td class="number">
                    <bean:write name="it" property="typeDoc" filter="true"/></td>
             </tr>
	    </logic:present>
        </logic:iterate>
        <!-- Table body end-->
<%if(isEdit){%>
<!---buttons and navigator begin -->
<tr class="title">
   <td colspan="<%= gColSpan %>">
      <TABLE class="buttons">
      <tr class="title">
         <td class="buttons">
         	<%if(isEdit){%>
         	  <A title="Сохранить" href="javascript:SaveComposition()"><IMG SRC="/images/save.gif" BORDER='0' ALT='Сохранить'></A>
         	<%}%>
              <july:backbutton/>
         </td>
		 <TH colspan="<%= gColSpan %>">Доступные документы:</TH>
      </tr>
      </TABLE>
   </td>
</tr>
<!---buttons and navigator end-->

<!-- Table "listAccessDocs"  body -->
        <logic:iterate id="it" name="listAccessDocs" indexId="index" type="com.hps.july.arenda.valueobject.RegistryBuchCompositionLeaseDoc_TO">
            <logic:present name="it">
			<% String idStr = String.valueOf(((com.hps.july.arenda.valueobject.RegistryBuchCompositionLeaseDoc_TO)it).getLeaseDocument()); %>
            <tr class="exclude" onMouseOver="className='select'" onMouseOut="className='exclude'">
           		<td class="text">
                	<%--html:checkbox property="selectIds" name="it" value="<%= idStr %>"/--%>
                	<input type="checkbox" name="selIds" value='<%= idStr %>' id="selIds"></td>            
                <td class="number">
                    <bean:write name="it" property="docNumber" filter="true"/></td>
                <td class="text">
                	<july:datewrite name="it" property="docDate"/></td>
                <td class="number">
                    <bean:write name="it" property="nameOrg" filter="true"/></td>
                <td class="number">
                    <bean:write name="it" property="namePosition" filter="true"/></td>                                                                     
                <td class="number">
                    <bean:write name="it" property="numberPosition" filter="true"/></td>                                                                     
                <td class="number">
                    <bean:write name="it" property="docNumberDop" filter="true"/></td>
                <td class="text">
                    <july:datewrite name="it" property="docDateDop"/></td>
                <td class="number" align="right">
                    <july:sumwrite name="it" property="sum"/></td>
                <td class="number">
                    <bean:write name="it" property="nameCurrency" filter="true"/></td>
                <td class="number">
                    <bean:write name="it" property="typeDoc" filter="true"/></td>
             </tr>
	    </logic:present>
        </logic:iterate>
<!-- Table "listAnoveAccessForOperator"  body end-->
<%}%>
<!---buttons and navigator begin -->
<tr class="title">
   <td colspan="<%= gColSpan %>">
      <TABLE class="buttons">
      <tr class="title">
         <td class="buttons">
         	<%if(isEdit){%>
         	  <A title="Сохранить" href="javascript:SaveComposition()"><IMG SRC="/images/save.gif" BORDER='0' ALT='Сохранить'></A>
         	<%}%>
              <july:backbutton/>
         </td>
		 <TH colspan="<%= gColSpan %>"></TH>
      </tr>
      </TABLE>
   </td>
</tr>
<!---buttons and navigator end-->
        
      <july:separator colspan="<%= gColSpan %>" />
</table>

</july:browseform>
