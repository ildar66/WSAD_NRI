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
	String gColSpan = "9";
	RegistryBuchDocsCompositionListForm listForm = (RegistryBuchDocsCompositionListForm)request.getAttribute("RegistryBuchDocsCompositionListForm");
	String sortBy = listForm.getOrderBy();
	//роли:
	//boolean isArendaPurchaser = request.isUserInRole("ArendaPurchaser");
	//boolean isArendaAccountant = request.isUserInRole("ArendaAccountant");
	//группы:
	//boolean isReturnDocumentGroup = isArendaPurchaser || isArendaAccountant;
	//boolean isInitialGroup = !isReturnDocumentGroup;
	boolean isInitialGroup = true;
	//boolean isEdit = !listForm.getTo().getVo().getState().equals("3");
	boolean isEdit = listForm.getTo().getVo().getState().equals("1") && isInitialGroup;	
%>


<july:browseform action="/RegistryBuchDocsCompositionList.do" styleId="listForm">
<html:hidden property="orderBy"/>
<html:hidden property="operation" value=""/>
<html:hidden property="economist"/>
<html:hidden property="idRegistryDoc"/>
<html:hidden property="selectIds" value=""/>
<html:hidden property="stateSelectIds" value=""/>
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

function revertStateDocSF(idDoc, stateSelectIds){
	listForm.selectIds.value=idDoc;
	listForm.stateSelectIds.value=stateSelectIds;
	listForm.operation.value="revertStateDocSF";
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
         <td align="right">отобрано записей:<%=request.getAttribute("numberOfLines")%></td>
      </tr>
      </TABLE>
   </td>
</tr>
<!---buttons and navigator end-->

<!-- Table header  begin :-->
<tr class="title">

	   <td  class="title">&nbsp;</td>

       <td  class="title">
			<A title="Сортировать по полю 'Номер договора'" href="javascript:SortBy('docNumber')">Номер договора</A><%=isUp(sortBy, "docNumber")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Дата договора'" href="javascript:SortBy('docDate')">Дата договора</A><%=isUp(sortBy, "docDate")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Номер СФ'" href="javascript:SortBy('numberSchetFakt')">Номер СФ</A><%=isUp(sortBy, "numberSchetFakt")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Дата СФ'" href="javascript:SortBy('dateSchetFakt')">Дата СФ</A><%=isUp(sortBy, "dateSchetFakt")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Сумма СФ'" href="javascript:SortBy('sumSf')">Сумма СФ</A><%=isUp(sortBy, "sumSf")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Арендодатель'" href="javascript:SortBy('nameOrg')">Арендодатель</A><%=isUp(sortBy, "nameOrg")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Номер позиции'" href="javascript:SortBy('numberPosition')">Номер позиции</A><%=isUp(sortBy, "numberPosition")%></td>
       <td  class="title">
			<A title="Сортировать по полю 'Наименование Позиции'" href="javascript:SortBy('namePosition')">наим. позиции</A><%=isUp(sortBy, "namePosition")%></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
<!-- Table header  end :-->        


        <!-- Table body begin-->
        
        <logic:iterate id="it" name="browseList" indexId="index" type="com.hps.july.arenda.valueobject.RegistryBuchCompositionSF_TO">
            <logic:present name="it">
			<% String idSchetFakt = String.valueOf(((com.hps.july.arenda.valueobject.RegistryBuchCompositionSF_TO)it).getIdSchetFakt()); %>
            <tr class="include" onMouseOver="className='select'" onMouseOut="className='include'">
       			<td class="text">
				<%if(isEdit){%>       		
               		<input type="checkbox" name="selIds" value='<%= idSchetFakt %>' id="selIds" checked="checked" title="Исключить из описи">
            	<%}else{%>
            		<% if(!isInitialGroup){%>
            		<A title="Изменить статус документа" href="javascript:revertStateDocSF('<%= idSchetFakt %>', '<bean:write name="it" property="docState" filter="true"/>')">
            			<bean:write name="it" property="docStateStr" filter="true"/></A>
            		<%}else{%>
            			<bean:write name="it" property="docStateStr" filter="true"/>
            		<%}%>
            	<%}%>             	
                </td>
                <td class="number">
                    <bean:write name="it" property="docNumber" filter="true"/>
                </td>
                <td class="text">
                	<july:datewrite name="it" property="docDate"/>
                </td>
                <td class="number">
                    <bean:write name="it" property="numberSf" filter="true"/>
                </td>
                <td class="text">
                    <july:datewrite name="it" property="dateSf"/>
                </td>
                <td class="number" align="right">
                    <july:sumwrite name="it" property="sumSf"/>
                </td>
                <td class="number">
                    <bean:write name="it" property="nameOrg" filter="true"/>
                </td>
                <td class="number">
                    <bean:write name="it" property="numberPosition" filter="true"/>
                </td>                
                <td class="number">
                    <bean:write name="it" property="namePosition" filter="true"/>
                </td>                                                                     
             </tr>
	    </logic:present>
        </logic:iterate>
        <!-- Table body end-->
<%if(isEdit){%>
<!-- buttons and navigator begin -->
<tr class="title">
   <td colspan="<%= gColSpan %>">
      <TABLE class="buttons">
      <tr class="title">
         <td class="buttons">
  			<%if(isEdit){%>
         	  <A title="Сохранить" href="javascript:SaveComposition()"><IMG SRC="/images/save.gif" BORDER='0' ALT='Сохранить'></A>
         	<%}%>
			<july:backbutton/>
			<B>Доступные документы:</B>
			<july:searchbutton />
         </td>
		 <TH style="text-align: left;">
		 	Пользователь:
		 	<july:checkbox property="isCreatedBy" insertable="true" updatable="true"/>создал документ&nbsp;&nbsp;
		 	<july:checkbox property="isModifiedBy" insertable="true" updatable="true"/>изменил документ&nbsp;&nbsp;
		 	<july:checkbox property="isEconomist" insertable="true" updatable="true"/>Экономист договора&nbsp;&nbsp;
		 </TH>
      </tr>
      </TABLE>      
   </td>
</tr>
<!---buttons and navigator end-->

<!-- Table "listAccessDocs"  body -->
        <logic:iterate id="it" name="listAccessDocs" indexId="index" type="com.hps.july.arenda.valueobject.RegistryBuchCompositionSF_TO">
            <logic:present name="it">
			<% String idSchetFakt = String.valueOf(((com.hps.july.arenda.valueobject.RegistryBuchCompositionSF_TO)it).getIdSchetFakt()); %>
            <tr class="exclude" onMouseOver="className='select'" onMouseOut="className='exclude'">
           		<td class="text">
                	<%--html:checkbox property="selectIds" name="it" value="<%= idSchetFakt %>"/--%>
                	<input type="checkbox" name="selIds" value='<%= idSchetFakt %>' id="selIds" title="Включить в опись">
                </td>            
                <td class="number">
                    <bean:write name="it" property="docNumber" filter="true"/>
                </td>
                <td class="text">
                	<july:datewrite name="it" property="docDate"/>
                </td>
                <td class="number">
                    <bean:write name="it" property="numberSf" filter="true"/>
                </td>
                <td class="text">
                    <july:datewrite name="it" property="dateSf"/>
                </td>
                <td class="number" align="right">
                    <july:sumwrite name="it" property="sumSf"/>
                </td>
                <td class="number">
                    <bean:write name="it" property="nameOrg" filter="true"/>
                </td>
                <td class="number">
                    <bean:write name="it" property="numberPosition" filter="true"/>
                </td>                
                <td class="number">
                    <bean:write name="it" property="namePosition" filter="true"/>
                </td>                                                                     
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
