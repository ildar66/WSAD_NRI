<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<html:form action="/ShowAvailableRegion.do" styleId="AvailableRegionForm">
<table class="main">
<july:separator colspan="1"/>

	<TR class="normal">
		<TD>
			<table class="find">
				<tr>
					<td class="text">Выбор филиала
					
					</td>
				</tr>
			</table>
		</TD>
	</TR>
	
	<july:separator colspan="1"/>
	
	<tr class="title">
		<td class="text"><july:backbutton/></td>
	</tr>

	<july:separator colspan="1"/>
	
	<TR>
		<TD>
			<html:hidden property="action" value="Edit"/>
			<input type="hidden" name="curRegID"/>
			
			<script>
			<!--
				function submitForm() {
					with(document.forms['AvailableRegionForm']) {
					curRegID.value = curRegId.options[curRegId.selectedIndex].value;
					submit();
					}
				}
			-->
			</script>
			<table class="main">
				<logic:present name="AvailableRegionForm" property="availableRegions">
						<tr class="normal">
							<td>
						   		<select name="curRegId" onchange="submitForm(); return true;" style="width:400px;" class="edit">
									<%
									com.hps.july.arenda.formbean.AvailableRegionForm aForm = (com.hps.july.arenda.formbean.AvailableRegionForm)session.getAttribute("AvailableRegionForm");
									if(aForm != null) {
									java.util.Collection accessList = aForm.getAvailableRegions();
									java.lang.Integer curReg = aForm.getCurRegId();
									if(curReg == null) curReg = new java.lang.Integer(-9999);
							        for(java.util.Iterator it = accessList.iterator(); it.hasNext();) {
							            com.hps.july.valueobject.RegionsAccess_TO to = (com.hps.july.valueobject.RegionsAccess_TO)it.next();
							            if(to == null) continue;
									%>
									<% if(curReg.equals(to.getVo().getRegionid())){%>
										<option value="<%=to.getVo().getRegionid()%>" selected><%=to.getRegionName()%></option>
									<% }else{%>
										<option value="<%=to.getVo().getRegionid()%>"><%=to.getRegionName()%></option>
									<% }
							        } 
							        }
							        %>
								</select>
							
						   		<%--<july:select collection="availableRegions" property="curRegId" insertable="true" updatable="true" style="width:400px;" onchange="submitForm(); return true;">
									<html:options collection="availableRegions" property="regionId" labelProperty="regionName"/>
								</july:select> --%>
							</td>
						</tr>
					  </logic:present>
				</table>
		</td>
	</tr>

	<july:separator colspan="1"/>
	<tr class="title">
		<td class="text"><july:backbutton/></td>
	</tr>
	<july:separator colspan="1"/>
	
</table>

</html:form>
