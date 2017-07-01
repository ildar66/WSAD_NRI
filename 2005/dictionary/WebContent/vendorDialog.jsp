<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*,com.hps.july.valueobject.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT> 

<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/VendorProcess.do";
	String form = "VendorDialogForm";
	String src = "/images/save.gif";
	String alt = "��������� ������";
	String isUpdatable = "false";
	boolean isWideView = request.isUserInRole("administrator") || request.isUserInRole("developer");
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "������� ������"; %>
</logic:equal>
<logic:equal name="<%= form %>" property="to.vo.source" value="2">
		<% isUpdatable = "true"; %>
</logic:equal>

<july:editform action="<%= action %>" styleId="<%= form %>" focus="to.vo.name">
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
<logic:notEqual name="<%= form %>" property="action" value="Delete">
	with(theForm){
		//if(!field_check(theForm['vo.vendorCode'], '���', 3, true)) return false;
		if(!field_check(theForm['to.vo.name'], '������������', 0, true)) return false;
		if(document.all.typeVendor.value == "<%=Vendor_VO.TYPE_VENDOR_JURIDICAL%>") {
			if(!isINN(theForm['to.vo.inn'].value)){
				return confirm("�������� <bean:write name="<%= form %>" property="vendorFormView.nameInn"/> ��������. ��������?");
			}
		}
		//if(!field_check(theForm['to.vo.inn'], '���', 3, false)) return false;
		//if(!field_check(theForm['vo.korAccount'], '����.����-����', 3, true)) return false;
		//if(!field_check(theForm.summStr, '����� ����������', 6, true)) return false;
		//if(!field_check(theForm.beginDateStr, '������ c', 0, true)) return false;
		//if(!field_check(theForm.endDateStr, '������ ��', 0, true)) return false;
		//if(!field_check(theForm.dateEndSfStr, '�� ������ ��', 0, true)) return false;
		//if(!field_check(theForm.sumNdsStr,'� �.�. ���',6,true)) return false;
		//if(!field_check(theForm['vo.currency'], '������ ����������',4,true)) return false;
		//if(!field_check(theForm.otherMan, '��� ��������', 0, true)) return false;
	}
</logic:notEqual>	
	return true;
}
function changeTypeVendor(){
	if(document.all.typeVendor.value == "<%=Vendor_VO.TYPE_VENDOR_JURIDICAL%>") {
		for(var i = 0; i < typeVendor_JURIDICAL.length; i++){
				typeVendor_JURIDICAL[i].style.setAttribute("display", "block");
		}
		for(var i = 0; i < typeVendor_PHYSICAL.length; i++){
				typeVendor_PHYSICAL[i].style.setAttribute("display", "none");
		}
		legalAddress_ID.style.setAttribute("display", "block");
		addressForPrintDoc_ID.style.setAttribute("display", "block");		
	} else if(document.all.typeVendor.value == "<%=Vendor_VO.TYPE_VENDOR_PHYSICAL%>") {
		for(var i = 0; i < typeVendor_JURIDICAL.length; i++){
				typeVendor_JURIDICAL[i].style.setAttribute("display", "none");
		}
		for(var i = 0; i < typeVendor_PHYSICAL.length; i++){
				typeVendor_PHYSICAL[i].style.setAttribute("display", "block");
		}
		legalAddress_ID.style.setAttribute("display", "none");
		addressForPrintDoc_ID.style.setAttribute("display", "none");		
	} else if(document.all.typeVendor.value == "<%=Vendor_VO.TYPE_VENDOR_OTHER%>"){
		for(var i = 0; i < typeVendor_JURIDICAL.length; i++){
				typeVendor_JURIDICAL[i].style.setAttribute("display", "none");
		}
		for(var i = 0; i < typeVendor_PHYSICAL.length; i++){
				typeVendor_PHYSICAL[i].style.setAttribute("display", "none");
		}
		legalAddress_ID.style.setAttribute("display", "block");	
		addressForPrintDoc_ID.style.setAttribute("display", "block");		
	}
}
function isINN(s) {
	if(s.length < 10 || s.length > 12 || !isDigits(s))
		return false;
	else
		return true;
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
    		<july:actionalert/>
    		<B style="font-size: 8pt; color: blue;"> &uml;���������: id=<bean:write name="<%= form %>" property="to.vo.idVendor"/>&uml;</B> 
		    ���: <july:select style="width: 100; font-size: 8pt;" property="to.vo.typeVendor" insertable="true" updatable="true" onchange="changeTypeVendor()"  styleId="typeVendor">
				<%--html:option value="">&nbsp;</html:option--%>
				<html:option value="<%=String.valueOf(Vendor_VO.TYPE_VENDOR_JURIDICAL)%>">�����������</html:option>
				<html:option value="<%=String.valueOf(Vendor_VO.TYPE_VENDOR_PHYSICAL)%>">����������</html:option>
				<html:option value="<%=String.valueOf(Vendor_VO.TYPE_VENDOR_OTHER)%>">������</html:option>
		   	</july:select>	
    	</td>
    </tr>
    <july:separator/>
<%--    
    <tr>
        <td class="text"><july:reqmark>���:</july:reqmark></td>
        <td>
          <july:string property="to.vo.vendorCode" size="5" insertable="true" updatable="<%= isUpdatable%>" />
        </td>
    </tr>
    <july:separator/>
--%>    
    <tr>
        <td class="text"><july:reqmark>������������:</july:reqmark></td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.name" size="30" insertable="true" updatable="<%= isUpdatable%>" />
        </td>
    </tr>
    <tr>
        <td class="text">����. ��� ������:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.nameForPrintDoc" size="30" insertable="true" updatable="true" />
        </td>
    </tr>    
    <tr>
        <td class="text"><july:reqmark><bean:write name="<%= form %>" property="vendorFormView.nameInn"/>:</july:reqmark></td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.inn" size="25" insertable="true" updatable="<%= isUpdatable%>" />
        </td>
    </tr>
    <july:separator/>
    
    <!--  typeVendor_JURIDICAL -->
    <tr id="typeVendor_JURIDICAL">
        <td class="text">��� ����������:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.accountManagerFio" size="30" insertable="true" updatable="true" />
        </td>
    </tr>
    <tr id="typeVendor_JURIDICAL">
        <td class="text">��� ������������:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.directorFio" size="30" insertable="true" updatable="true" />
        </td>
    </tr>
	<tr id="typeVendor_JURIDICAL">
        <td class="text">��������� ������������:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.directorJob" size="30" insertable="true" updatable="true" />
        </td>
    </tr>
    <tr id="legalAddress_ID">
        <td class="text">����������� �����:</td>
        <td>
          <july:textarea style="font-size:8pt; width: 400;" property="to.vo.legalAddress" cols="50" rows="3" insertable="true" updatable="true" />
        </td>
    </tr>
    <tr id="addressForPrintDoc_ID">
        <td class="text">����� ��� ������:</td>
        <td>
          <july:textarea style="font-size:8pt; width: 400;" property="to.vo.addressForPrintDoc" cols="50" rows="3" insertable="true" updatable="true" />
        </td>
    </tr>    
    <%--tr id="typeVendor_JURIDICAL">
        <td class="text">����������� �����:</td>
        <td>
          <july:textarea style="font-size:8pt;" property="to.vo.phisicalAddress" cols="50" rows="3" insertable="true" updatable="true" />
        </td>
    </tr--%>

    <!--TYPE_VENDOR_PHYSICAL-->
    <tr id=typeVendor_PHYSICAL>
        <td class="text">�������:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.lastName" size="30" insertable="true" updatable="true" />
        </td>
    </tr>
    <tr id=typeVendor_PHYSICAL>
        <td class="text"> ���: </td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.firstName" size="30" insertable="true" updatable="true" />
        </td>
    </tr>
	<tr id=typeVendor_PHYSICAL>
        <td class="text">��������:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.middleName" size="30" insertable="true" updatable="true" />
        </td>
    </tr>
	<tr id=typeVendor_PHYSICAL>
        <td class="text">����� ��������:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.passportSer" size="30" insertable="true" updatable="true" />
        </td>
    </tr>    
	<tr id=typeVendor_PHYSICAL>
        <td class="text">����� ��������:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.passportNum" size="30" insertable="true" updatable="true" />
        </td>
    </tr>
	<tr id=typeVendor_PHYSICAL>
        <td class="text">����� �����:</td>
        <td>
          <july:date style="font-size:8pt;" required="false" property="to.passportDate"  insertable="true" updatable="true" />
        </td>
    </tr>
	<tr id=typeVendor_PHYSICAL>
        <td class="text">��� �����:</td>
        <td>
          <july:string style="font-size:8pt;" property="to.vo.passportWhom" size="30" insertable="true" updatable="true" />
        </td>
    </tr>            
    
    <july:separator colspan="<%= gColSpan %>"/>
<logic:notEqual name="<%= form %>" property="action" value="Add">    
    <%if(isWideView){%>
    <tr>
    	<td colspan="2">
    	<table class="main" style="font-size:8pt;">
		    <tr>
		        <td class="text">������:</td>
		        <td>
					<bean:write name="<%=form%>" property="to.createdBy"  filter="true" />(<july:datewrite name="<%=form%>" property="to.vo.created" />)
		        </td>
		    </tr>
		    <tr>
		        <td class="text">�������:</td>
		        <td>
					<bean:write name="<%=form%>" property="to.modifiedBy"  filter="true" />(<july:datewrite name="<%=form%>" property="to.vo.modified" />)
		        </td>
		    </tr>
		    <tr>
		        <td class="text">������ �� ����. � ���:</td>
		        <td><bean:write name="<%=form%>" property="to.vo.idVendorNfs"  filter="true" /></td>
		    </tr>
		    <tr>
		        <td class="text">��� ���������� � ���:</td>
		        <td><bean:write name="<%=form%>" property="to.vo.type"  filter="true" /></td>
		    </tr>
		    <tr>
		        <td class="text">������������ � NRI:</td>
		        <td><bean:write name="<%=form%>" property="to.vo.useInNri"  filter="true" /></td>
		    </tr>
		    <tr>
		        <td class="text">��������:</td>
		        <td><bean:write name="<%=form%>" property="to.vo.sourceStr"  filter="true" /></td>
		    </tr>
		    <tr>
		        <td class="text">���� ��������� ������������� ���������� � ���:</td>
		        <td><july:datewrite name="<%=form%>" property="to.vo.end_date_active" /></td>
		    </tr>
		    <tr>
		        <td class="text">������:</td>
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
<script language="javascript" type="text/javascript">
	changeTypeVendor();
</script>
<logic:equal name="<%=form%>" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>

</july:editform>

