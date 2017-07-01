<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.dictionary.valueobject.ResourceGroupItemRow"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessResourceGroup.do">

<html:hidden property="donotcommit"/>

<html:hidden property="classid"/>

<SCRIPT language="javascript">
	function reloadForm(){
		document.all.donotcommit.value=true;
		document.forms[0].submit();
	}
</SCRIPT>

<table class="main">
<%--
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="/ShowUnitList.do" styleClass="navigator"><bean:message key="label.units"/></a> 
           <july:sepmark/>
           <july:actionname/></td>
    </tr>
--%>    
    <july:separator/>
    
	<july:formbuttons/>
    
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.unit.code"/>:</july:reqmark></td>
        <td>
           <july:string property="groupid" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.unit.name"/>:</july:reqmark></td>
        <td>
          <july:string property="name" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>

	<table class="main" border="0" ID="antaccessories">
		<tr class="title">
			<td class="title" colspan="5">Аксессуары к антеннам БС</td>
		</tr>
		<july:separator colspan="5"/>
		<jsp:useBean id="rgform" class="com.hps.july.dictionary.formbean.ResourceGroupForm"/>
		<tr class="title">
			<td></td>
			<td> <bean:message key="label.code"/> </td>
			<td> <bean:message key="label.name"/> </td>
			<td> <bean:message key="label.resource.manufacturer"/> </td>
			<td> <bean:message key="label.content.qty"/> </td>
		</tr>
		<july:separator colspan="5"/>
		<%
			int count = rgform.getAccessoriesCount();
			for (int i=0;i<count;i++){
				ResourceGroupItemRow row = rgform.getAntAccessoryInfo(i);
				String resource=row.getResourceStr();
				String resourcesubtype=row.getResourcesubtype();
				String unit=row.getUnit();
				String name=row.getName();
				String model=row.getModel();
				String notes=row.getNotes();
				String complect=row.getComplect();
				String countpolicy=row.getCountpolicy();
				String boxable=row.getBoxable();
				String pricable=row.getPricable();
				String complectpart=row.getComplectpart();
				String actualcode=row.getActualcode();
				String active=row.getActive();
				//String manufacturer=row.getManufacturer();
				String manucode=row.getManucode();
				String resourceclass=row.getResourceclass();
				String resourceclass2=row.getResourceclass2();
				String groupid=row.getGroupid();
				String manufid=row.getManufid();
				String checked="";
				if (rgform.getAntAccessory(i)) checked="true";
				else checked="false";
		%>	
				<tr class='<%= (checked=="true") ? "normal" : "select" %>'>
					<td>
						<july:checkbox styleClass="main" property='<%= "antAccessoryStr["+i+"]"%>' insertable="true" updatable="true" onclick="reloadForm()"/>
					</td>
					<td> <%= resource %> </td>
					<td> <%= name %> </td>
					<td> <%= manufid %> </td>
					<td> 
						<july:string size="5" property='<%= "accessoryQuantity["+i+"]"%>' insertable='<%= checked %>' updatable='<%= checked %>' />
					</td>
				</tr>
				<july:separator colspan="5"/>
	<%
			}
	%>
	</table>		

	<table class="main">    

	    <july:formbuttons/>
    
    	<july:separator/>
    
	</table>

</july:editform>