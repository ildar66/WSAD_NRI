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
				return (" <img src='/images/up.gif'  border='0' alt='�� �����������'> ");
			 else
				return (" <img src='/images/down.gif'  border='0' alt='�� ��������'> "); 
		 }
		 else return ("");      
	}
%>

<%
	String gColSpan = "8";
	RegistryBuchDocsCompositionListForm listForm = (RegistryBuchDocsCompositionListForm)request.getAttribute("RegistryBuchDocsCompositionListForm");
	String sortBy = listForm.getOrderBy();
	//����:
	boolean isArendaPurchaser = request.isUserInRole("ArendaPurchaser");
	boolean isArendaAccountant = request.isUserInRole("ArendaAccountant");
	//������:
	boolean isReturnDocumentGroup = isArendaPurchaser || isArendaAccountant;
	boolean isInitialGroup = !isReturnDocumentGroup;
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
         	  <A title="���������" href="javascript:SaveComposition()"><IMG SRC="/images/save.gif" BORDER='0' ALT='���������'></A>
         	<%}%>
              <july:backbutton/>
         </td>
         <th class="navigator">������� ��������� ����� �: <bean:write name="RegistryBuchDocsCompositionListForm" property="idRegistryDoc"/></th>
         <td align="right">�������� �������:<%=request.getAttribute("numberOfLines")%></td>
      </tr>
      </TABLE>
   </td>
</tr>
<!---buttons and navigator end-->

<!-- Table header  begin :-->
<tr class="title">

	   <td  class="title">&nbsp;</td>

       <td  class="title">
			<A title="����������� �� ���� '����� ��������'" href="javascript:SortBy('docNumber')">����� ��������</A><%=isUp(sortBy, "docNumber")%></td>
       <td  class="title">
			<A title="����������� �� ���� '���� ��������'" href="javascript:SortBy('docDate')">���� ��������</A><%=isUp(sortBy, "docDate")%></td>
       <td  class="title">
			<A title="����������� �� ���� '����� ��'" href="javascript:SortBy('numberSchetFakt')">����� ��</A><%=isUp(sortBy, "numberSchetFakt")%></td>
       <td  class="title">
			<A title="����������� �� ���� '���� ��'" href="javascript:SortBy('dateSchetFakt')">���� ��</A><%=isUp(sortBy, "dateSchetFakt")%></td>
       <td  class="title">
			<A title="����������� �� ���� '����� ��'" href="javascript:SortBy('sumSf')">����� ��</A><%=isUp(sortBy, "sumSf")%></td>
       <td  class="title">
			<A title="����������� �� ���� '������������'" href="javascript:SortBy('nameOrg')">������������</A><%=isUp(sortBy, "nameOrg")%></td>
       <td  class="title">
			<A title="����������� �� ���� '�������'" href="javascript:SortBy('namePosition')">�������</A><%=isUp(sortBy, "namePosition")%></td>
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
               		<input type="checkbox" name="selIds" value='<%= idSchetFakt %>' id="selIds" checked="checked" title="��������� �� �����">
            	<%}else{%>
            		<% if(isReturnDocumentGroup){%>
            		<A title="�������� ������ ���������" href="javascript:revertStateDocSF('<%= idSchetFakt %>', '<bean:write name="it" property="docState" filter="true"/>')">
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
         	  <A title="���������" href="javascript:SaveComposition()"><IMG SRC="/images/save.gif" BORDER='0' ALT='���������'></A>
         	<%}%>
			<july:backbutton/>
			<B>��������� ���������:</B>
			<july:searchbutton />
         </td>
		 <TH style="text-align: left;">
		 	������������:
		 	<july:checkbox property="isCreatedBy" insertable="true" updatable="true"/>������ ��������&nbsp;&nbsp;
		 	<july:checkbox property="isModifiedBy" insertable="true" updatable="true"/>������� ��������&nbsp;&nbsp;
		 	<july:checkbox property="isEconomist" insertable="true" updatable="true"/>��������� ��������&nbsp;&nbsp;
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
                	<input type="checkbox" name="selIds" value='<%= idSchetFakt %>' id="selIds" title="�������� � �����">
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
         	  <A title="���������" href="javascript:SaveComposition()"><IMG SRC="/images/save.gif" BORDER='0' ALT='���������'></A>
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
