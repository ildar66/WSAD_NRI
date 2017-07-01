<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.dictionary.formbean.*,com.hps.july.cdbc.objects.*" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.util.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT> 
<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/RegionDialogProcess.do";
	String form = "RegionDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
	//int ADMINREGION_RUSSIA = AppUtils.getNamedValueInt("ADMINREGION_RUSSIA");
	RegionDialogForm aForm = (RegionDialogForm)session.getAttribute(form);
	boolean isRussiaRegion = false;
	if(aForm.getAction().equals(EditForm.ACTION_ADD)){
		if(aForm.getVo().getParent_regionid() != null){
			isRussiaRegion = CDBC_AdminRegion_Object.isRussiaRegion(aForm.getVo().getParent_regionid().intValue());	
		}
	}else{
		isRussiaRegion = CDBC_AdminRegion_Object.isRussiaRegion(aForm.getId());
	}
	String isEdit = String.valueOf(!isRussiaRegion);
	//System.out.println("isRussiaRegion="+isRussiaRegion);
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="id"/>
<html:hidden property="operation" value=""/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "Удалить запись"; %>
</logic:equal>

<script language="javascript">
	function Close()
		{
			if(window.opener) {
				opener.storeSelectedRow(document.all.id.value);
				//opener.location.reload(true);
				window.opener.window.document.forms(0).submit();
				//window.opener.window.location.href=window.opener.window.location.href;
				window.opener.focus();
			}
			window.close();
		}
	function Check()
	{
		<logic:notEqual name="<%= form %>" property="action" value="Delete">		
		var theForm = document.<%= form %>;
		with(theForm){
			if(!field_check(theForm.regionname, 'Наименование', 0, true)) return false;
			//if(!field_check(theForm.kladrCode, 'Код КЛАДР', 0, false)) return false;
			//if(!field_check(theForm.ruralpopulation, 'Сельское население', 3, false)) return false;
			//if(!field_check(theForm.regionarea, 'Площадь региона', 4, false)) return false;
			//if(!field_check(theForm.regionlon, 'Долгота', 4, false)) return false;
			//if(!field_check(theForm.regionlat, 'Широта', 4, false)) return false;
			//if(!field_check(theForm.planSumStr,'Планируемая стоимость',6,true)) return false;
			//if(!field_check(theForm['to.vo.ourMan'], 'Кто передавал(из справочника)',0,true)) return false;
			//if(!field_check(theForm.otherMan, 'Кто принимал', 0, true)) return false;
		}
		</logic:notEqual>
		return true;
	}
	function changeSupRegID(){
		//alert("adfasf");
		document.all.operation.value = "changeSupRegID";
		document.<%= form %>.submit();
		return false;
	}
	function showHelp(){
	//alert(document.<%= form %>.supRegCode[1].disabled);//temp
		if(document.<%= form %>.supRegCode.disabled == false){
			document.<%= form %>.supRegCode.className = 'editdisabled';
			document.<%= form %>.supRegCode.disabled = true;
			//document.<%= form %>.filialNRI[1].className = 'editdisabled';
			//document.<%= form %>.filialNRI[1].disabled = true;						
		}else{
			document.<%= form %>.supRegCode.className = 'editsearch';
			document.<%= form %>.supRegCode.disabled = false;
			//document.<%= form %>.filialNRI[1].className = 'editsearch';
			//document.<%= form %>.filialNRI[1].disabled = false;			
		}
	}		
</script>

<table class="main"  style="font-size:8pt;">

<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
				<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" styleID="submitID" onclick="return Check();">
			&nbsp;<july:closebutton page="/"/>
        </td>
    </tr>

<july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>

<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text"><july:reqmark>Наименование:</july:reqmark></td> 
		<td class="text">
			<july:string size="20" style="width:300;" property="vo.regionname" styleId="regionname" insertable="true" updatable="<%= isEdit%>"/>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Тип Oбъекта:</july:reqmark></td>
		<td class="text">
			<%--july:string size="10" property="vo.regiontype" styleId="regiontype" insertable="true" updatable="true"/--%>
			<!-- тип объекта: -->
			<july:select style="width: 300;" property="vo.regiontype" collection="adminRegionTypesList" styleId="regiontype" insertable="true" updatable="<%= isEdit%>">
				<html:options collection="adminRegionTypesList" property="regionType" labelProperty="nameType"/>
			</july:select>
		</td>
	</tr>	    
<%--july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text">Комментарий:</td> 
		<td class="text">
			<july:textarea property="vo.regioncomment" style="width:300;" rows="3" insertable="true" updatable="true"/>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text">Население региона:</td> 
		<td class="text">
			<july:string size="5" property="vo.regionpopulation" styleId="regionpopulation" insertable="true" updatable="true"/>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text">Сельское население:</td> 
		<td class="text">
			<july:string size="5" property="vo.ruralpopulation" styleId="ruralpopulation" insertable="true" updatable="true"/>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Площадь региона:</td>
		<td class="text">
			<july:string size="10" property="regionareaStr" styleId="regionarea" insertable="true" updatable="true"/>&nbsp;
		</td>
	</tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Долгота:</td>
		<td class="text">
			<july:string size="10" property="regionlonStr" styleId="regionlon" insertable="true" updatable="true"/>&nbsp;
		</td>
	</tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Широта:</td>
		<td class="text">
			<july:string size="10" property="regionlatStr" styleId="regionlat" insertable="true" updatable="true"/>&nbsp;
		</td>
	</tr--%>
<%if(isRussiaRegion){%>	
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Код КЛАДР:</td>
		<td class="text">
			<july:string size="10" property="vo.kladrCode" styleId="kladrCode" insertable="true" updatable="true"/>
			<logic:present name="<%=form%>" property="parentVO">
				Код КЛАДР родителя:<B><bean:write name="<%=form%>"
					property="parentVO.kladrCode" /></B>
			</logic:present>
		</td>
	</tr>
<%}%>		
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Регион NRI:
		<A href='#' onclick='showHelp(); return false;'>
			<IMG SRC="/images/lookup.gif" BORDER='0' ALT='показать/спрятать справочник:'></A>
		</td>
		<td class="text">		
			<!-- Суперрегион NRI: -->
			<july:select style="width: 300;" property="supRegCode" collection="supRegList" styleId="supRegCode" insertable="true" updatable="true"  onchange="changeSupRegID();">
				<html:option value="">&nbsp;</html:option>
				<html:options collection="supRegList" property="supRegID" labelProperty="supRegName"/>
			</july:select>			
		</td>
	</tr>	
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Филиал NRI:</td>
		<td class="text">
			<%--july:string size="10" property="vo.filialnri" styleId="filialNRI_0" insertable="true" updatable="true"/--%>
			<!-- Филиал NRI: -->
			<july:select style="width: 300;" property="vo.filialnri" collection="filialNriList" styleId="filialNRI" insertable="true" updatable="true">
				<html:option value="">&nbsp;</html:option>
				<html:options collection="filialNriList" property="regionID" labelProperty="regName"/>
			</july:select>
		</td>
	</tr>

<%--	
<july:separator colspan="<%= gColSpan %>"/>	
	<tr id="indexRowID">
		<td class="text">&nbsp;</td>
		<td>
			<!-- Филиал NRI: -->
			<july:select style="width: 40;" property="cellid_prefix" collection="kzlRegionPrefixList" styleId="cellname_prefix" insertable="true" updatable="true"  onchange="changeRegionPrefix(this);">
				<html:options collection="kzlRegionPrefixList" property="cellid_prefix" labelProperty="cellname_prefix"/>
			</july:select>
		</td>
	</tr>						                 
    
<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text"><july:reqmark>СФ период:</july:reqmark></td> 
		<td class="text">
			с :<july:date property="dateStartSfStr" size="20" insertable="true" updatable="true" required="false" styleId="dateStartSfStr"/>
			по:<july:date property="dateEndSfStr" size="20" insertable="true" updatable="true" required="false" styleId="dateEndSfStr"/>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Сумма:</july:reqmark></td>
		<td class="text"><july:string size="10" property="planSumStr" insertable="true" updatable="<%=isUpdatable%>"/>&nbsp;
		    <july:select style="width: 130;" collection="currencies" property="vo.idCurrency" insertable="true" updatable="true">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
			<july:select style="width: 130;" property="vo.chargeNds" insertable="true" updatable="<%=isUpdatable%>">
				<html:option value="true">без НДС</html:option>
				<html:option value="false">в том числе НДС</html:option>
			</july:select>
		</td>
	</tr>        
    
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Тип:</july:reqmark></td>
		<td class="text">
			<july:select style="width: 130;" property="to.vo.typeAct" insertable="true" updatable="true">
				<html:option value="1">выдача</html:option>
				<html:option value="2">возврат</html:option>
			</july:select>
		</td>
	</tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Кто передавал:</july:reqmark></td>
		<td class="text">
			<html:hidden property="to.vo.ourMan"/>
			<july:string size="30" property="to.ourManName" styleId="ourManName" insertable="true" updatable="true"/>
				<july:lookupbutton action="/../security/ShowPeopleLookupList.do" styleId="manl" fieldNames="to.vo.ourMan;to.ourManName" newWindowName="manlookup" insertable="true" updatable="true"/>
		</td>
	</tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Кто принимал:</july:reqmark></td>
		<td class="text">
			<july:string size="30" property="to.vo.otherMan" styleId="otherMan" insertable="true" updatable="true"/>
		</td>
	</tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<html:link page="/ShowAbonentBillLookupList.do?formname=SchetFactDialogForm&fieldnames=to.vo.idLeasebill|aktAbonentBillInfo" paramId="leaseDocument" paramName="SchetFactDialogForm" paramProperty="abonentContract" scope="session" onclick="window.open(this.href, 'pWindow', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="справочник">		
				абонентский счет:
			</html:link>
		</td>
		<td class="text">
			<html:hidden property="to.vo.idLeasebill"/>
			<july:string size="30" property="aktAbonentBillInfo" insertable="true" updatable="true"/>			
		</td>
	</tr>
--%>	
<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
				<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" styleID="submitID" onclick="return Check();">
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

<script language="javascript" type="text/javascript">
	if(<%= form %>.regionname != null){
		<%= form %>.regionname.focus();
	}
	showHelp();
</script>

</july:editform>
