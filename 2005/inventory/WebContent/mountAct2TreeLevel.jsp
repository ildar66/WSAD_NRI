<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.*"%>
<%@ page import="com.hps.july.inventory.valueobject.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hps.july.web.util.ImportResponseWrapper"%>

	<% String parentPath = request.getParameter("parentPath"); %>
<%
	boolean isDeleted = false;
	MountAct2Form2 frm = (MountAct2Form2)request.getAttribute("MountAct2Form2");
	if (frm == null) {
		frm = (MountAct2Form2)request.getSession().getAttribute("MountAct2Form2");
	}
	if("Delete".equals(frm.getAction())) {
		isDeleted = true;
	}
%>

	<!-- c:set var="currentCategoryList" value="${categoryList}" scope="page"/ -->
	<% List currentCategoryList = (List)request.getAttribute("categoryList"); %>
	<!-- c:set var="currentDocPositionListBean" value="${docPositionListBean}" scope="page"/ -->	
	<% MountActDocPositionListBean currentDocPositionListBean = (MountActDocPositionListBean) request.getAttribute("docPositionListBean"); %>

	<!-- c:forEach items="${currentCategoryList}" var="category" -->
	<%  if (currentCategoryList != null)
		for (int i=0; i<currentCategoryList.size();i++) {
			Category category = (Category) currentCategoryList.get(i);
	%>
        <!-- c:set var="controlButtonIndex" value="${controlButtonIndex +1}" scope="request"/ -->
	    <%	Integer controlButtonIndex = (Integer)request.getAttribute("controlButtonIndex");
		    controlButtonIndex = controlButtonIndex != null ? new Integer(controlButtonIndex.intValue() +1) : new Integer(0);
	    	request.setAttribute("controlButtonIndex", controlButtonIndex);  
	    %>

		<tr class="print" style="background-color:#EEF7FF" >
       		<!-- td colspan="1" class="print" style="padding-left: <!-- c:out value="${param.level*30+15}"/>px; margin-top:0; margin-bottom:0; padding-top:1; padding-bottom:1" -->
       		<td colspan="1" class="print" style="padding-left: <%=String.valueOf(Integer.parseInt(request.getParameter("level"))*30+15)%>px; margin-top:0; margin-bottom:0; padding-top:1; padding-bottom:1">
       			<b><!-- c:out value="${category.name}"/--><%=category.getName()%></b>
       		</td>
	        <td colspan="6" nowrap="nowrap" class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 2; padding-bottom: 2;">
				<!-- c:choose -->
					<!-- c:when test="${empty DISABLED_MODE}" --> 	
					<% if ((request.getAttribute("DISABLED_MODE") == null) && (! isDeleted)) { %>
				        <!-- c:set var="resources" value="${category.visualCategory.resources}"/ -->
				        <% pageContext.setAttribute("resources", category.getVisualCategory().getResources()); %>
				        <!-- html:hidden property="controlButton[${controlButtonIndex}].parentPath" value="${param.parentPath}"/ -->
			        	<% String controlButton_parentPath = ("controlButton[" + controlButtonIndex + "].parentPath"); %>
			        	<html:hidden property="<%=controlButton_parentPath%>" value="<%=parentPath%>"/>
			        	<!-- html:hidden property="controlButton[${controlButtonIndex}].categoryId" value="${category.id}"/ -->
			        	<% String controlButton_categoryId = ("controlButton[" + controlButtonIndex + "].categoryId"); 
			        		String controlButton_categoryId_value = String.valueOf(category.getId());
			        	%>
			        	<html:hidden property="<%=controlButton_categoryId%>" value="<%=controlButton_categoryId_value%>"/>
			        	<!-- html:link href="#" onclick="openInvResourceLookupWindow(${category.visualCategory.id})" -->
			        	<% String openInvResourceLookupWindow_onclick = ("openInvResourceLookupWindow(" + category.getVisualCategory().getId().toString() + ")"); %>
			        	<html:link href="#" onclick="<%=openInvResourceLookupWindow_onclick%>"><img name="lookupimg_style" src="/images/bd.gif" border="0" alt="Настройка элементов выпадающего списка"></html:link>&nbsp;
			        	<!-- html:select property="controlButton[${controlButtonIndex}].resourceId" style="font-size:8pt; width:150px;" styleClass="edit" -->
			        	<% String controlButton_resourceId = ("controlButton[" + controlButtonIndex + "].resourceId"); %>
			        	<html:select property="<%=controlButton_resourceId%>" style="font-size:8pt; font-weight: bold; width:300px;" styleClass="edit">
			        		<html:option value="">&nbsp;</html:option>
			        		<!-- c:if test="${!empty resources}" -->
			        		<% if (pageContext.getAttribute("resources") != null) { %>
				        		<html:options collection="resources" property="id" labelProperty="modelName"/>
			        		<!-- /c:if -->
			        		<% } %>
			        	</html:select>&nbsp;
			        	<!-- html:image property="addResourceAction" onclick="controlButtonIndex.value=${controlButtonIndex};" title="Добавить комплект" src="../images/plus.gif"/ -->
			        	<% String addResourceAction_onclick = ("controlButtonIndex.value=" + controlButtonIndex + ";"); %>
			        	<html:image property="addResourceAction" onclick="<%=addResourceAction_onclick%>" alt="Добавить комплект" src="../images/plus.gif"/>
			        <!-- /c:when -->
			        <!-- c:otherwise -->
			        <% } else { %>
				        <img name="lookupimg_style" src="/images/bd.gif" border="0"/>
			        	<% String controlButton_resourceId = ("controlButton[" + controlButtonIndex + "].resourceId"); %>
			        	<html:select property="<%=controlButton_resourceId%>" style="font-size:8pt; width:150px;" styleClass="edit" disabled="<%=isDeleted%>">
			        		<html:option value="">&nbsp;</html:option>
			        	</html:select>&nbsp;
			        	<html:image disabled="true" src="../images/plus.gif"/>
			        <!-- /c:otherwise -->
			        <% } %>
		        <!-- /c:choose -->
<!--	        </td>-->
<!--	        -->
<!--	        <td class="print" colspan="5"> -->
	        	<!--  html:errors property="controlButton[${controlButtonIndex}].resourceId"/ -->
	        	<% String error_controlButton_resourceId = "controlButton[" + controlButtonIndex + "].resourceId"; %>
	        	<span style="color:red"><html:errors property="<%=error_controlButton_resourceId%>"/></span>
	        &nbsp;</td>
		</tr>
		
		<!-- c:forEach items="${currentDocPositionListBean.categoryDocPositions[category.id]}" var="position" varStatus="index" -->
		<% if (currentDocPositionListBean != null) {
			List categoryDocPositions = (List)currentDocPositionListBean.getCategoryDocPositions().get(category.getId()); 
			if (categoryDocPositions != null)
			for (int index=0; index<categoryDocPositions.size(); index++) {
				MountActDocPositionBean position = (MountActDocPositionBean)categoryDocPositions.get(index);				
		%>
			<tr><!--  td colspan="2" class="print" style="padding-left: <!-- c:out value="${param.level*30+15+30}"/>px; margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" -->
				<td colspan="2" valign="middle" class="print" style="padding-left:<%=String.valueOf(Integer.parseInt(request.getParameter("level"))*30+15)%>px; margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
					<html:img src="/images/link_arrow.gif" width="16" height="16"/>
					<!-- html:hidden property="${param.parentPath}docPosition[${position.index}].resource.modelName"/ -->
					<% String docPosition_resource_modelName = (parentPath + "docPosition[" + position.getIndex() + "].resource.modelName"); %>
					<html:hidden property="<%=docPosition_resource_modelName%>"/>
					<!-- html:hidden property="${param.parentPath}docPosition[${position.index}].resource.stockTakingType"/ -->
					<% String docPosition_resource_stockTakingType = (parentPath + "docPosition[" + position.getIndex() + "].resource.stockTakingType");  %>
					<html:hidden property="<%=docPosition_resource_stockTakingType%>"/>
	   	   			<!-- html:hidden property="${param.parentPath}docPosition[${position.index}].resourceId"/ -->
					<% String docPosition_resourceId = (parentPath + "docPosition[" + position.getIndex() + "].resourceId");  %>
					<html:hidden property="<%=docPosition_resourceId%>"/>	   	   				   	   			
	   	   			<!-- html:hidden property="${param.parentPath}docPosition[${position.index}].categoryId"/ -->
					<% String docPosition_categoryId = (parentPath + "docPosition[" + position.getIndex() + "].categoryId"); %>
					<html:hidden property="<%=docPosition_categoryId%>"/>	   	   				   	   			
	   	   			<!-- html:hidden property="${param.parentPath}docPosition[${position.index}].index"/ -->
	   	   			<% String docPosition_index = (parentPath + "docPosition[" + position.getIndex() + "].index"); %>
	   	   			<html:hidden property="<%=docPosition_index%>"/>	   	   				   	   			
	    			<!-- c:out value="${position.resource.modelName}"/ -->
	    			<span style="margin-left: 0;"><%=position.getResource().getModelName()%></span>
       			</td>
       			
       			<!-- c:if test="${position.resource.stockTakingType eq SERIAL_STOCK_TAKING_TYPE}" -->
       			<% if (position.getResource().getStockTakingType().equals(request.getAttribute("SERIAL_STOCK_TAKING_TYPE"))) { %>
	        		<td colspan="1" class="print" valign="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
			        	<% String docPosition_workNumber = (parentPath + "docPosition[" + position.getIndex() + "].worksNumber"); 
				        	boolean docPosition_workNumber_isDisabled = ((request.getAttribute("DISABLED_MODE") != null) || (isDeleted)); 
		      			    String docPosition_workNumber_styleClass = "" +(request.getAttribute("DISABLED_MODE") != null ? request.getAttribute("DISABLED_MODE").toString() : ""); %>
			        	<span style="color:red"><html:errors property="<%=docPosition_workNumber%>"/></span>
						<!-- html:checkbox property="${param.parentPath}docPosition[${position.index}].worksNumberExist" onclick="changeFieldStatus(form.elements['${param.parentPath}docPosition[${position.index}].worksNumber'], this);" disabled="${!empty DISABLED_MODE}"/ -->
						<% String docPosition_worksNumberExist = (parentPath + "docPosition[" + position.getIndex() + "].worksNumberExist");
							String docPosition_worksNumberExist_onclick = ("changeFieldStatus(form.elements['" + parentPath + "docPosition[" + position.getIndex() + "].worksNumber'], this);"); 
							boolean docPosition_worksNumberExist_isDisabled = ((request.getAttribute("DISABLED_MODE") != null) || (isDeleted)); %>
						<div style="white-space: nowrap">
							<html:checkbox property="<%=docPosition_worksNumberExist%>" onclick="<%=docPosition_worksNumberExist_onclick%>" disabled="<%=docPosition_worksNumberExist_isDisabled%>"/>
							<!-- html:text property="${param.parentPath}docPosition[${position.index}].worksNumber" style="font-size:8pt; width:140px" styleClass="edit${DISABLED_MODE}" readonly="${!empty DISABLED_MODE}" / -->	
				        	<html:text property="<%=docPosition_workNumber%>" style="font-size:8pt; width:140px" styleClass="<%=docPosition_workNumber_styleClass%>" readonly="<%=docPosition_workNumber_isDisabled%>"/>
				        </div>
			        	<!-- script type="text/javascript">changeFieldStatus(form.elements['<!-- c:out value="${param.parentPath}docPosition[${position.index}].worksNumber"/>'], form.elements['<!-- c:out value="${param.parentPath}docPosition[${position.index}].worksNumberExist"/>'] );</script -->
			        	<script type="text/javascript">changeFieldStatus(form.elements['<%=(parentPath + "docPosition[" + position.getIndex() + "].worksNumber")%>'], form.elements['<%=(parentPath + "docPosition[" + position.getIndex() + "].worksNumberExist")%>'] );</script>
        			</td>
		        	<td colspan="1" class="print" valign="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
						<% String docPosition_inventoryNumber = (parentPath + "docPosition[" + position.getIndex() + "].inventoryNumber"); 
				        	boolean docPosition_inventoryNumber_isDisabled = ((request.getAttribute("DISABLED_MODE") != null) || (isDeleted)); 
		      			    String docPosition_inventoryNumber_styleClass = "" +(request.getAttribute("DISABLED_MODE") != null ? request.getAttribute("DISABLED_MODE").toString() : ""); %>
		        	   	<span style="color:red"><html:errors property="<%=docPosition_inventoryNumber%>"/></span>
						<!-- html:checkbox property="${param.parentPath}docPosition[${position.index}].inventoryNumberExist" onclick="changeFieldStatus(form.elements['${param.parentPath}docPosition[${position.index}].inventoryNumber'], this.checked);" disabled="${!empty DISABLED_MODE}"/ -->
						<% String docPosition_inventoryNumberExist = (parentPath + "docPosition[" + position.getIndex() + "].inventoryNumberExist");
							String docPosition_inventoryNumberExist_onclick = ("changeFieldStatus(form.elements['" + parentPath + "docPosition[" + position.getIndex() + "].inventoryNumber'], this);"); 
				        	boolean docPosition_inventoryNumberExist_isDisabled = ((request.getAttribute("DISABLED_MODE") != null) || (isDeleted)); %>
						<div style="white-space: nowrap">
							<html:checkbox property="<%=docPosition_inventoryNumberExist%>" onclick="<%=docPosition_inventoryNumberExist_onclick%>" disabled="<%=docPosition_inventoryNumberExist_isDisabled%>"/>
					        <!-- html:text property="${param.parentPath}docPosition[${position.index}].inventoryNumber" style="font-size:8pt; width:140px" styleClass="edit${DISABLED_MODE}" readonly="${!empty DISABLED_MODE}" /-->
					        <html:text property="<%=docPosition_inventoryNumber%>" style="font-size:8pt; width:140px" styleClass="<%=docPosition_inventoryNumber_styleClass%>" readonly="<%=docPosition_inventoryNumber_isDisabled%>" />
					    </div>
   				        <!-- script type="text/javascript">changeFieldStatus(form.elements['<!-- c:out value="${param.parentPath}docPosition[${position.index}].inventoryNumber"/>'], form.elements['<!-- c:out value="${param.parentPath}docPosition[${position.index}].inventoryNumberExist"/>'] );</script -->
   			        	<script type="text/javascript">changeFieldStatus(form.elements['<%=(parentPath + "docPosition[" + position.getIndex() + "].inventoryNumber")%>'], form.elements['<%=(parentPath + "docPosition[" + position.getIndex() + "].inventoryNumberExist")%>'] );</script>
        			</td>
		        	<td class="print" valign="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
   				        <% String docPosition_subdivisionInventoryNumber = (parentPath + "docPosition[" + position.getIndex() + "].subdivisionInventoryNumber"); 
				           	boolean docPosition_subdivisionInventoryNumber_isDisabled = ((request.getAttribute("DISABLED_MODE") != null) || (isDeleted)); 
	    	  			    String docPosition_subdivisionInventoryNumber_styleClass = "" +(request.getAttribute("DISABLED_MODE") != null ? request.getAttribute("DISABLED_MODE").toString() : ""); %>
   			        	<span style="color:red"><html:errors property="<%=docPosition_subdivisionInventoryNumber%>"/></span>
						<!-- html:checkbox property="${param.parentPath}docPosition[${position.index}].subdivisionInventoryNumberExist" onclick="changeFieldStatus(form.elements['${param.parentPath}docPosition[${position.index}].subdivisionInventoryNumber'], this);" disabled="${!empty DISABLED_MODE}"/ -->
						<% String docPosition_subdivisionInventoryNumberExist = (parentPath + "docPosition[" + position.getIndex() + "].subdivisionInventoryNumberExist");
							String docPosition_subdivisionInventoryNumberExist_onclick = ("changeFieldStatus(form.elements['" + parentPath + "docPosition[" + position.getIndex() + "].subdivisionInventoryNumber'], this);"); 
				        	boolean docPosition_subdivisionInventoryNumberExist_isDisabled = ((request.getAttribute("DISABLED_MODE") != null) || (isDeleted)); %>
						<div style="white-space: nowrap">
							<html:checkbox property="<%=docPosition_subdivisionInventoryNumberExist%>" onclick="<%=docPosition_subdivisionInventoryNumberExist_onclick%>" disabled="<%=docPosition_subdivisionInventoryNumberExist_isDisabled%>"/>
					        <!-- html:text property="${param.parentPath}docPosition[${position.index}].subdivisionInventoryNumber" style="font-size:8pt; width:140px" styleClass="edit${DISABLED_MODE}" readonly="${!empty DISABLED_MODE}"/ -->
					        <html:text property="<%=docPosition_subdivisionInventoryNumber%>" style="font-size:8pt; width:140px" styleClass="<%=docPosition_subdivisionInventoryNumber_styleClass%>" readonly="<%=docPosition_subdivisionInventoryNumber_isDisabled%>" />
					    </div>
   			        	<!-- script type="text/javascript">changeFieldStatus(form.elements['<!-- c:out value="${param.parentPath}docPosition[${position.index}].subdivisionInventoryNumber"/>'], form.elements['<!-- c:out value="${param.parentPath}docPosition[${position.index}].subdivisionInventoryNumberExist"/>'] );</script -->
   			        	<script type="text/javascript">changeFieldStatus(form.elements['<%=(parentPath + "docPosition[" + position.getIndex() + "].subdivisionInventoryNumber")%>'], form.elements['<%=(parentPath + "docPosition[" + position.getIndex() + "].subdivisionInventoryNumberExist")%>'] );</script>
	        		</td>
	    		<!-- /c:if -->
	    		<% } %>
				
				<!-- c:if test="${position.resource.stockTakingType eq QUANTITY_STOCK_TAKING_TYPE}" -->
				<% if (position.getResource().getStockTakingType().equals(request.getAttribute("QUANTITY_STOCK_TAKING_TYPE"))) { %>
	        		<td colspan="3" class="print" style="padding-left: 29px; margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
			        	<% String docPosition_quantity = (parentPath + "docPosition[" + position.getIndex() + "].quantity"); 
				           	boolean docPosition_quantity_isDisabled = ((request.getAttribute("DISABLED_MODE") != null) || (isDeleted)); 
		      			    String docPosition_quantity_styleClass = "" +(request.getAttribute("DISABLED_MODE") != null ? request.getAttribute("DISABLED_MODE").toString() : ""); %>
			        	<!-- html:text property="${param.parentPath}docPosition[${position.index}].quantity" style="font-size:8pt; width:30%;" size="21"  styleClass="edit"/ --> 
			        	<html:text property="<%=docPosition_quantity%>" style="font-size:8pt; width:140px;" styleClass="<%=docPosition_quantity_styleClass%>" readonly="<%=docPosition_quantity_isDisabled%>"/> 
			        	шт. &nbsp;&nbsp;
			        	<span style="color:red"><html:errors property="<%=docPosition_quantity%>"/></span>
        			</td>
				<!-- /c:if -->
				<% } %>
				
	        	<td class="print" valign="bottom" style="margin-top:0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
       		        <!-- c:if test="${empty DISABLED_MODE}" -->
       		        <% if ((request.getAttribute("DISABLED_MODE") == null) && (! isDeleted)) { %>
	       		        <!-- c:set var="controlButtonIndex" value="${controlButtonIndex +1}" scope="request"/ -->
					    <%	controlButtonIndex = (Integer)request.getAttribute("controlButtonIndex");
						    controlButtonIndex = controlButtonIndex != null ? new Integer(controlButtonIndex.intValue() +1) : new Integer(0);
					    	request.setAttribute("controlButtonIndex", controlButtonIndex);  
					    %>
		        		<!-- html:hidden property="controlButton[${controlButtonIndex}].parentPath" value="${param.parentPath}"/ -->
		        		<% String controlDeleteButton_parentPath = ("controlButton[" + controlButtonIndex + "].parentPath"); %>
		        		<html:hidden property="<%=controlDeleteButton_parentPath%>" value="<%=parentPath%>"/>
		        		<!-- html:hidden property="controlButton[${controlButtonIndex}].positionIndex" value="${position.index}"/ -->
		        		<% String controlDeleteButton_positionIndex = ("controlButton[" + controlButtonIndex + "].positionIndex"); 
		        			String controlDeleteButton_positionIndex_value = String.valueOf(position.getIndex()); %>
		        		<html:hidden property="<%=controlDeleteButton_positionIndex%>" value="<%=controlDeleteButton_positionIndex_value%>"/>
			     		<!-- html:image property="deleteResourceAction" onclick="controlButtonIndex.value=${controlButtonIndex}" title="Удалить комплект" src="../images/del.gif"/ -->	        				
						<% String deleteResourceAction_onclick = ("if(window.confirm('Вы действительно хотите удалить строку оборудования из документа?')) { controlButtonIndex.value=" + controlButtonIndex + "; } else { return false; }"); %>
						<html:image property="deleteResourceAction" onclick="<%=deleteResourceAction_onclick%>" alt="Удалить комплект" src="../images/del.gif"/>	        				
					<!-- /c:if -->
					<% } %>
        		</td>
			</TR>
			
			<!-- c:set var="categoryList" value="${category.childrens}" scope="request"/ -->
			<% request.setAttribute("categoryList", category.getChildrens()); %>
			<!-- c:set var="docPositionListBean" value="${position.docPositions}" scope="request"/ -->	
			<% request.setAttribute("docPositionListBean", position.getDocPositions()); %>
			
			<!-- c:import url="/mountAct2TreeLevel.jsp?level=${param.level+1}&parentPath=${param.parentPath}docPosition[${position.index}]."/ -->
			<% String url = "/mountAct2TreeLevel.jsp?level="+ String.valueOf(Integer.parseInt(request.getParameter("level"))+1) + "&parentPath=" + parentPath + "docPosition[" + position.getIndex() + "].";
				try {
					ServletContext servletContext = pageContext.getServletContext();
				    RequestDispatcher requestDispatcher =
				    	servletContext.getRequestDispatcher(url);
		
				    ImportResponseWrapper importResponseWrapper  = 
						new ImportResponseWrapper(
						    (HttpServletResponse) pageContext.getResponse());
			
				    requestDispatcher.include(pageContext.getRequest(), importResponseWrapper);
			
				    pageContext.getOut().print(importResponseWrapper.getString());
				} catch (Exception e){
					pageContext.getOut().println(e.getMessage());
					e.printStackTrace(System.out);				
				}
			%>	

			<!-- c:remove var="categoryList" scope="request"/ -->
			<% request.removeAttribute("categoryList"); %>
			<!-- c:remove var="docPositionListBean" scope="request"/ -->
			<% request.removeAttribute("docPositionListBean"); %> 	
			
        <!-- /c:forEach -->
        <% } } %>
	<!-- /c:forEach -->
	<% } %>
