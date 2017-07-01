<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.*"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.basestation.formbean.SwitchForm"%>
<%@ page import="com.hps.july.basestation.valueobject.BaseStationObject"%>

<%
	SwitchForm dForm=(SwitchForm)session.getAttribute("SwitchForm");
%>

<%--@ include file="/common/positionFields.jsp"--%>

<jsp:include page="/common/positionFields.jsp" flush="true" />

<july:separator />

<jsp:include page="/common/equipmentStateFields.jsp" flush="true" />

<tr>
 <%--номер--%>
       <td class="text"><july:reqmark><bean:message key="SwitchForm.number"/>:</july:reqmark></td>
       <td class="text">
         <july:string property="numberFrm" styleId="numberFrmId" size="10" insertable="true" updatable="true" />
       </td>
</tr>
<tr>
 <%--название--%>
       <td class="text"><july:reqmark><bean:message key="SwitchForm.name"/>:</july:reqmark></td>
       <td class="text">
        <july:string property="name" styleId="nameId" size="50" insertable="true" updatable="true" />
       </td>
</tr>

<tr>
<%--стандарт--%>
   <td class="text"><july:reqmark><bean:message key="SwitchForm.switchType"/>:</july:reqmark></td>
     <td class="text">
       <july:select property="switchType" styleId="switchTypeId" insertable='true' updatable='false'>'
         <html:option key="switch_type_1" value="<%=Checks.SWITCH_TYPE_Damps%>"/>
         <html:option key="switch_type_2" value="<%=Checks.SWITCH_TYPE_Gsm%>"/>
       </july:select>
 </td>
</tr>

<%--наименование оборудование--%>
<tr>
	<td class="text"><bean:message key="SwitchForm.resource"/>:</td>
	<td>
    	<july:string size="5" property="resourceIdFrm" styleId="resourceId" insertable="true" updatable="true" />
	    <july:lookupbutton  formname="SwitchForm" href="/inventory/ShowResourceLookupList.do" styleId="resl" fieldNames="resourceId;resourcemodelId;resourcenameId;resourcefullnameId" newWindowName="resourcelookup" insertable="true" updatable="true"/>
        <july:string size="30" property="resourcefullname" styleId="resourcefullnameId" insertable="false" updatable="false" />

 <input type='hidden' name="resourcemodel" id="resourcemodelId"/>
		<input type='hidden' name="resourcename" id="resourcenameId" />

        </td>
</tr>

<%-- Extra Fields commented out
<tr>
       <td class="text"><bean:message key="SwitchForm.qtyshell"/>:</td>
       <td class="text">
         <july:string property="qtyshellFrm" styleId="qtyshellFrmId" size="10" insertable="true" updatable="true" />
       </td>
</tr>


<tr>
<td class="text"><bean:message key="SwitchForm.maxvlr"/>:</td>
<td class="text">
<july:string property="maxvlrFrm" styleId="maxvlrId" size="10" insertable="true" updatable="true" />
&nbsp;&nbsp;
<bean:message key="SwitchForm.qtyconhlr"/>:
<july:string property="qtyconhlrFrm" styleId="qtyconhlrId" size="10" insertable="true" updatable="true" />
</td>
</tr>

<tr>
<td colspan='2'>
<table class="main">
<tr>
 <td class="text"><bean:message key="SwitchForm.contrl"/>:</td>
 <td class="text">
   <july:string property="contrl" styleId="contrlId" size="10" insertable="false" updatable="false" />
 </td>
 <td class="text"><bean:message key="SwitchForm.qty_tkgroute_nss"/>:</td>
 <td class="text">
   <july:string property="qty_tkgroute_nssFrm" styleId="qty_tkgroute_nssFrmId" size="10" insertable="true" updatable="true" />
 </td>
</tr>

<tr>
 <td class="text"><bean:message key="SwitchForm.e1_qty_total"/>:</td>
 <td class="text">
   <july:string property="e1_qty_totalFrm" styleId="e1_qty_totalFrmId" size="10" insertable="true" updatable="true" />
 </td>
 <td class="text"><bean:message key="SwitchForm.e1_use_percent"/>:</td>
 <td class="text">
   <july:string property="e1_use_percentFrm" styleId="e1_use_percentFrmId" size="10" insertable="true" updatable="true" />
 </td>
</tr>

<tr>
<td class="text"><bean:message key="SwitchForm.e1_bss"/>:</td>
 <td class="text">
   <july:string property="e1_bssFrm" styleId="e1_bssFrmId" size="10" insertable="true" updatable="true" />
 </td>
 <td class="text"><bean:message key="SwitchForm.ss7bss"/>:</td>
 <td class="text">
   <july:string property="ss7bssFrm" styleId="ss7bssFrmId" size="10" insertable="true" updatable="true" />
 </td>
</tr>

<tr>
 <td class="text"><bean:message key="SwitchForm.e1_nss"/>:</td>
 <td class="text">
   <july:string property="e1_nssFrm" styleId="e1_nssFrmId" size="10" insertable="true" updatable="true" />
 </td>
 <td class="text"><bean:message key="SwitchForm.ss7nss"/>:</td>
 <td class="text">
   <july:string property="ss7nssFrm" styleId="ss7nssFrmId" size="10" insertable="true" updatable="true" />
 </td>
</tr>

<tr>
 <td class="text"><bean:message key="SwitchForm.e1_hlr"/>:</td>
 <td class="text">
   <july:string property="e1_hlrFrm" styleId="e1_hlrFrmId" size="10" insertable="true" updatable="true" />
 </td>
 <td class="text"><bean:message key="SwitchForm.ss7_hlrin"/>:</td>
 <td class="text">
   <july:string property="ss7_hlrinFrm" styleId="ss7_hlrinFrmId" size="10" insertable="true" updatable="true" />
 </td>
</tr>

</table>
</td>
</tr>
--%>


<jsp:include page="/common/equipmentBaseFields.jsp" flush="true" />
