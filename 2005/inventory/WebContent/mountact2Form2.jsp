<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.*"%>
<%@ page import="com.hps.july.inventory.valueobject.*"%>
<%@ page import="com.hps.july.web.util.ImportResponseWrapper"%>


<script type="text/javascript" language="javascript">
	
	function changeFieldStatus(field, check){
		if (!check.checked) {
			if (!check.disabled) {
				field.className = '';
				field.disabled = false;
			}
			
			if (field.value == 'Номер неизвестен'){
				if (field.getAttribute("oldvalue")) field.value = field.getAttribute("oldvalue");
				else field.value = '';
			}
			
		} else {
			field.setAttribute("oldvalue", field.value);			
			field.value = 'Номер неизвестен';		
			field.disabled = true;
			field.className = 'editdisabled';
		}
	}
	
	function openInvResourceLookupWindow(categoryId) {
		myWindow = window.open("/dict/ShowInvResourceListWN.do?category=" + categoryId, "newWindow", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes");  
		myWindow.focus();
	}
	
</script> 


<%-- <html:form action="/MountAct2Edit2" styleId="form"> --%>
<july:editform action="/MountAct2Edit2" styleId="form">
<SCRIPT language="JScript">var myWindow;function lookup_params() {  var s = new String("s");  var a = s.lookup("s");}</SCRIPT>

<!-- deprecated: use for load showInvResourceList lookup-->
<input type="hidden" name="refreshFields"/>

<html:hidden property="mountAct.documentId"/>
<html:hidden property="mountAct.needApprove"/>
<html:hidden property="mountAct.documentState"/>

<html:hidden property="controlButtonIndex" value="-1"/>
<!-- c:set var="controlButtonIndex" value="-1" scope="request"/ -->
<% request.setAttribute("controlButtonIndex", new Integer(-1)); %>
<% MountAct2Form2 form = (MountAct2Form2)request.getAttribute("form"); %>

<%
	boolean isDeleted = false;
	MountAct2Form2 frm = (MountAct2Form2)request.getAttribute("MountAct2Form2");
	if (frm == null) {
		frm = (MountAct2Form2)request.getSession().getAttribute("MountAct2Form2");
	}
	if("Delete".equals(frm.getAction())) {
		isDeleted = true;
	}
	String idDeletedStr = new Boolean(isDeleted).toString();
%>
<html:hidden property="deleteConfirm" value="<%=idDeletedStr%>"/>

<!-- c:if test="${!empty form.document}" -->
<% if (form.getDocument() != null) { %>	
    <july:inventorycalcerrors document="<%=form.getDocument()%>" />		
<!-- /c:if -->
<% } %>

<!-- c:if test="${form.mountAct.countingState}" -->
<% if(form.getMountAct().isCountingState()) { %>
	<!-- c:set var="disabledMode" value="disabled" scope="request"/ -->
	<% String DISABLED_MODE = "editdisabled"; 
		request.setAttribute("DISABLED_MODE", DISABLED_MODE);
	%>
<!-- /c:if  -->
<% } %>


<%-- =((MountAct2Form2)request.getAttribute("form")).getMountAct().getDocumentId()--%>

<table class="main">

    <july:separator/>
	<% if (isDeleted) { %>    
    <TR class="title"><TD colspan="1">
    	<table class="main">
    		<TR class="title">
				<july:formbuttons/>
    		<tr>
    	</table>
    </td>
	<td><span style="font-size:8pt">По возникшим вопросам просьба обращаться в Отдел информационного обеспечения. Контактное лицо – Сергей Уколов. <br>тел. 42-15 или 8-903-767-4215, e-mail <a href="mailto:SUkolov@partners.beeline.ru">SUkolov@partners.beeline.ru</a></span>
	</td>    
	<% } else {%>    
    <TR class="title"><TD colspan="1">
	    
	    <!-- html:image property="saveAction" src="/images/save.gif"  alt="Сохранить" onclick="document.body.style.cursor='wait';" disabled="${!empty DISABLED_MODE}"/ -->
		<!-- c:if test="${!empty DISABLED_MODE}" -->
		<% if (request.getAttribute("DISABLED_MODE") == null) { %>
	    	<html:image property="saveAction" src="/images/save.gif"  alt="Сохранить" onclick="document.body.style.cursor='wait';"/>
	    <!--  /c:if -->
	    <% } %>
		<july:backbutton/>
		<%--
    	<a href='/inventory/ShowAssemblingPList.do' title="Отказ и возврат"><IMG SRC="/images/cancel.gif" ALT="Отказ и возврат" onclick="document.body.style.cursor='wait';" BORDER=0></A>
    	--%>
    	
		<!-- c:if test="${!empty form.mountAct.documentId}" -->
		<% if (form.getMountAct().getDocumentId() != null) { %>
			<!-- c:choose -->
				<!-- c:when test="${form.mountAct.introduceState}" -->	 	
				<% if (form.getMountAct().isIntroduceState()) { %>
			 		<html:image property="documentCountingAction" src="/images/calculate.gif" alt="Обсчёт"/>
			 		
			 		<!-- c:if test="${IS_COUNTING_WARNING_PRESENT}" -->
			 		<% if (request.getAttribute("IS_COUNTING_WARNING_PRESENT") != null) { %>
						<html:image property="documentCountingWithAutoCorrectAction" src="/images/calculatea.gif" alt="Обсчёт с автоматическим исправлением несоответствий"/>
					<% } %>	
	 				<!-- /c:if -->
				<!-- /c:when -->
				<!-- c:otherwise -->
				<% } else { %>
					<html:image property="cancelDocumentCountingAction" src="/images/calculates.gif" alt="Снять обсчёт"/>
				<!-- /c:otherwise -->
				<% } %>
			<!-- /c:choose -->
		<% } %>
		<!-- /c:if -->
	    </TD>
    	<td><span style="font-size:8pt">По возникшим вопросам просьба обращаться в Отдел информационного обеспечения. Контактное лицо – Сергей Уколов. <br>тел. 42-15 или 8-903-767-4215, e-mail <a href="mailto:SUkolov@partners.beeline.ru">SUkolov@partners.beeline.ru</a></span></td>
    </TR>
	<% } %>    
	<july:separator/>
	<tr>
        <td class="title" colspan="2">Акт монтажа аппаратуры</td>
    </tr>

    <july:separator/>

	<tr>
		<td class="title" colspan="2"><july:actionalert/></td>
	</tr>

	<july:separator/>

    <TR><TD class="text" colspan="2">
		<TABLE class="print" style="font-size:8pt;">
	    <TR class="print">
        	<TD COLSPAN="6" class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
		    	<div><span style="color:red"><html:errors property="mountAct.posNumber"/></span>
		    		<span style="color:red;"><html:errors property="mountAct.complectCode"/></span>
		    	</div>
				
				<table style="font-size:8pt;">
				<tr class="print">
        			<td style="font-size:8pt;"><bean:message key="label.mountact2.actno"/>&nbsp;<bean:message key="label.mountact2.bsno"/></td>
					<td>
					<!-- c:choose -->
						<!-- c:when test="${!empty bsResSetList}"-->
						<% if (request.getAttribute("bsResSetList") != null) { %>
							<!-- html:select property="mountAct.posNumber" style="font-size:8pt;" disabled="${!empty DISABLED_MODE}" -->
							<% boolean mountAct_posNumber_isDisabled = ((request.getAttribute("DISABLED_MODE") != null) || (isDeleted)); %>
							<html:select property="mountAct.posNumber" style="font-size:8pt;" disabled="<%=mountAct_posNumber_isDisabled%>">
								<html:options collection="bsResSetList" property="type" labelProperty="name"/>
							</html:select>
						<!-- /c:when -->
						<!-- c:otherwise -->
						<% } else { %>
							<!-- add form.bsLlist -->				
					   		<!-- html:text property="mountAct.posNumber" style="font-size:8pt;" styleClass="editkod${DISABLED_MODE}" size="5" disabled="${!empty DISABLED_MODE}"/ -->
					   		<% String mountAct_posNumber_styleClass = "editkod" +(request.getAttribute("DISABLED_MODE") != null ? "disabled" : ""); 
					   			boolean mountAct_posNumber_isDisabled = ((request.getAttribute("DISABLED_MODE") != null) || (isDeleted)); %>
					   		<html:text property="mountAct.posNumber" style="font-size:8pt;" styleClass="<%=mountAct_posNumber_styleClass%>" size="5" readonly="<%=mountAct_posNumber_isDisabled%>" onkeypress="if(event.keyCode == 13){ document.form.all.updateAction.click(); return false; }"/>
					   		<html:hidden property="oldPosNumber"/>
					   		<!-- c:choose -->
					   			<!-- c:when test="${empty form.mountAct.posNumber || !empty complect}" -->
					   			<% if (form.getMountAct().getPosNumber() == null ||
					   					request.getAttribute("complect") != null) { %>
					   				<% Complect complect = (Complect) request.getAttribute("complect"); %>
					   				<!--  html:hidden property="mountAct.complectCode" value="${complect.id}"/ -->
					   				<% String complectId = (complect != null ? (complect.getId() != null ? complect.getId().toString() : "") : ""); %>
					   				<html:hidden property="mountAct.complectCode" value="<%=complectId%>"/>
									<!--  html:text size="25" style="font-size:8pt;" property="mountAct.complectName" readonly="true" styleClass="editdisabled" value="${complect.name}"/ -->
									<% String complectName = complect != null ? complect.getName() : ""; %>
									<html:text size="25" style="font-size:8pt;" property="mountAct.complectName" readonly="true" styleClass="editdisabled" value="<%=complectName%>"/>
					   			<!-- /c:when -->
								<!-- c:otherwise -->
								<% } else { %>
									<!-- html:select property="mountAct.complectCode" style="font-size:8pt;" styleClass="edit" disabled="${!empty DISABLED_MODE}" -->
									<% boolean mountAct_complectCode = ((request.getAttribute("DISABLED_MODE") != null) || (isDeleted)); %>
									<html:select property="mountAct.complectCode" style="font-size:8pt;" styleClass="edit" disabled="<%=mountAct_complectCode%>">
										<html:option value="">&nbsp;</html:option>
										<html:options collection="complects" property="id" labelProperty="name"/>
									</html:select>
								<!--  /c:otherwise -->
					   		<!-- /c:choose -->
					   			<% } %>

						<!-- /c:otherwise -->
					<!-- /c:choose -->
			   		    <% } %>

					  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    <SPAN style="font-size:8pt;font-weight:bold;"><!-- c:out value="${visualType.name}"/ --><%=((VisualType)request.getAttribute("visualType")) != null ? ((VisualType)request.getAttribute("visualType")).getName() : ""%></SPAN>
					    <html:hidden property="mountAct.visualType"/>
					</TD>
				</TR>
				<TR>
					<TD style="font-size:8pt;"><bean:message key="label.mountact2.project"/></TD>
			  		<TD>
				  		<html:hidden property="mountAct.projectId"/>
						<html:hidden property="mountAct.projectName"/>
						<html:text size="35" style="font-size:8pt;" property="mountAct.projectName" readonly="true" styleClass="editbigdisabled"/>
					    <html:image property="updateAction" src="/images/dictrefrsh.gif" border="0" alt="Обновить данные" tabindex="0"/>
		    	    </TD>
				</TR>    
				<tr><td colspan="2"><span style="color:red"><html:errors property="mountAct.frequencyRange"/></span></td></tr>
				<TR>
					<TD style="font-size:8pt;">Оборудование в диапазоне</TD>
			  		<TD>
			  			<html:select property="mountAct.frequencyRange" style="font-size:8pt; width:100px" styleClass="edit" disabled="<%=isDeleted%>">
			  				<html:option value="">&nbsp;</html:option>
			  				<html:option value="S">GSM</html:option>
			  				<html:option value="C">DCS</html:option>
			  				<html:option value="G">GSM/DCS</html:option>
			  			</html:select>
		    	    </TD>
				</TR>    
				</TABLE>
			</TD>
		</TR>
  		<tr class="print">
    		<td class="print" width="23%" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">Категория</td>
    		<td class="print" width="20%" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">Тип</td>
    		<td class="print" width="18%" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">Заводской N</td>
    		<td class="print" width="18%" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">Инвентарный N</td>
    		<td class="print" width="18%" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">Инвентарный N подразделения</td>
    		<td class="print" width="3%" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">&nbsp;</td>
    	</tr>

		<!-- c:set var="categoryList" value="${rootCategoryList}" scope="request"/ -->
		<%	request.setAttribute("categoryList", request.getAttribute("rootCategoryList")); %>
		<!-- c:set var="docPositionListBean" value="${form.mountAct.docPositions}" scope="request"/ -->	
		<% request.setAttribute("docPositionListBean", form.getMountAct().getDocPositions()); %>

		<!-- c:import url="/mountAct2TreeLevel.jsp?level=0&parentPath=mountAct."/ -->
		<% String url = "/mountAct2TreeLevel.jsp?level=0&parentPath=mountAct.";
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

	    </TABLE>
		
			<table class="print" style="font-size:8pt;">
		    	<tr class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
			 	   <td width="15%" class="print"><bean:message key="label.mountact2.organization"/></td>
		       	   <td width="35%" class="print">
			          <div><span style="color:red"><html:errors property="mountAct.providerCode"/></span></div>
    			      <html:hidden property="providerCode"/>
    			      <% if  (! isDeleted) { %>
    			      <july:lookupbutton formname="form" action="/ShowOrganizationLookupList.do" styleId="provl" fieldNames="providerCode;providerName" newWindowName="organizationlookup" onclick="set_opt_params_provl('?selisprovider=true&selisrenter=false&selissupplier=false');" updatable="true"/>
    			      <% } %>
		    		  <html:text size="15" property="providerName" readonly="true" styleClass="editdisabled" style="font-size:8pt; width:200px;" disabled="<%=isDeleted%>"/>
			       </td>
			       <td width="30%" class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
			           <div><span style="color:red"><html:errors property="mountAct.insuranceMan"/></span></div>
    			      <% boolean mountAct_insuranceMan_isDisabled = ((request.getAttribute("DISABLED_MODE") != null) || (isDeleted)) ; 
	    			      String mountAct_insuranceMan_styleClass = "edit" +(request.getAttribute("DISABLED_MODE") != null ? "disabled" : ""); %>
					   <!-- html:text size="15" property="mountAct.insuranceMan" style="font-size:8pt; width:200px;" styleClass="edit${DISABLED_MODE}" readonly="${!empty DISABLED_MODE}"/ -->
  					   <html:text size="15" property="mountAct.insuranceMan" style="font-size:8pt; width:200px;" styleClass="<%=mountAct_insuranceMan_styleClass%>" readonly="<%=mountAct_insuranceMan_isDisabled%>"/>
			       </td>
			       <td width="20%" class="print">&nbsp;</td>
				</tr>
				<tr class="print">
					<td class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;"><bean:message key="label.mountact2.customer"/></td>
					<td class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
		    			<% boolean mountAct_ownerCode_isDisabled = ((request.getAttribute("DISABLED_MODE") != null) || (isDeleted));  %>
		    			<!-- html:select property="mountAct.ownerCode" style="font-size:8pt;" styleClass="edit" disabled="${!empty DISABLED_MODE}" -->
		    			<html:select property="mountAct.ownerCode" style="font-size:8pt;" styleClass="edit" disabled="<%=mountAct_ownerCode_isDisabled%>">
	    					<html:options collection="owners" property="organization" labelProperty="name"/>
		    			</html:select>
			        </td>
			        <td class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
			        	<div><span style="color:red"><html:errors property="mountAct.workerCode"/></span></div>
		    			<html:hidden property="workerCode"/>
		    			<html:hidden property="workerTitle"/>
		    			<% if (! isDeleted) { %>
    					<july:lookupbutton formname="form" action="/ShowWorkerLookupList.do" styleId="work1l" fieldNames="workerCode;workerName;workerTitle" newWindowName="workerlookup" updatable="true"/>
		    			<% } %>
		    			<html:text size="15" property="workerName" style="font-size:8pt; width:200px;" styleClass="editdisabled" disabled="<%=isDeleted%>" />
			        </td>
			        <td class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
			        	<span style="color:red"><html:errors property="mountAct.date"/></span>
				        <july:date property="mountAct.date" size="25" style="font-size:8pt; width: 100px;" required="false" insertable="true" updatable="true"/>
			        </td>
				</tr>
			    <tr class="print">
		    	    <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">&nbsp;</TD>
			        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;"><bean:message key="label.mountact2.header6"/></TD>
			        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;"><bean:message key="label.mountact2.header7"/></TD>
			        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">Дата монтажа</TD>
		        </TR>
		  	</table>

	</TD></TR>
	<july:separator/>
	<% if (isDeleted) { %>    
		<july:formbuttons/>
	<% } else { %>    
	 <TR class="title"><!-- height="30" -->
	 <TD class="text" colspan="2" align="left">
	 <!-- TD class="text" colspan="2" align="left" style="padding-left: 40px;" -->
	 	
	 	<!-- html:image property="saveAction" src="/images/save.gif"  alt="Сохранить" onclick="document.body.style.cursor='wait';" disabled="${!empty DISABLED_MODE}"/ -->
		<!-- c:if test="${!empty DISABLED_MODE}" -->
		<% if (request.getAttribute("DISABLED_MODE") == null) { %>
	    	<html:image property="saveAction" src="/images/save.gif"  alt="Сохранить" onclick="document.body.style.cursor='wait';"/>
	    <!--  /c:if -->
	    <% } %>

    	<a href='/inventory/ShowAssemblingPList.do' title="Отказ и возврат"><IMG SRC="/images/cancel.gif" ALT="Отказ и возврат" onclick="document.body.style.cursor='wait';" BORDER=0></A>
    	
		<!-- c:if test="${!empty form.mountAct.documentId}" -->
		<% if (form.getMountAct().getDocumentId() != null) { %>
			<!-- c:choose -->
				<!-- c:when test="${form.mountAct.introduceState}" -->	 	
				<% if (form.getMountAct().isIntroduceState()) { %>
			 		<html:image property="documentCountingAction" src="/images/calculate.gif" alt="Обсчёт"/>
			 		
			 		<!-- c:if test="${IS_COUNTING_WARNING_PRESENT}" -->
			 		<% if (request.getAttribute("IS_COUNTING_WARNING_PRESENT") != null) { %>
						<html:image property="documentCountingWithAutoCorrectAction" src="/images/calculatea.gif" alt="Обсчёт с автоматическим исправлением несоответствий"/>
					<% } %>	
	 				<!-- /c:if -->
				<!-- /c:when -->
				<!-- c:otherwise -->
				<% } else { %>
					<html:image property="cancelDocumentCountingAction" src="/images/calculates.gif" alt="Снять обсчёт"/>
				<!-- /c:otherwise -->
				<% } %>
			<!-- /c:choose -->
		<% } %>
		<!-- /c:if -->
	 	
	 	<%--
	 	
	 	<!-- html:submit property="saveAction" disabled="${!empty DISABLED_MODE}" -->
	 	<% boolean saveAction_isDisabled = request.getAttribute("DISABLED_MODE") != null; %>
	 	<html:submit property="saveAction.x" disabled="<%=saveAction_isDisabled%>" onclick="document.body.style.cursor='wait';"
	 		style="width: 110px; height: 24px; padding-left: 10px; padding-right: 5px; background-image: url(../images/save.gif); background-repeat: no-repeat; background-position: 5px -3px; margin-left: 5px; margin-right: 5px; font-family: Arial; font-size: 11px; font-weight: normal;">Сохранить</html:submit>
		
		<!-- c:if test="${!empty form.mountAct.documentId}" -->
		<% if (form.getMountAct().getDocumentId() != null) { %>
			<!-- c:choose -->
				<!-- c:when test="${form.mountAct.introduceState}" -->	 	
				<% if (form.getMountAct().isIntroduceState()) { %>
			 		<html:submit property="documentCountingAction.x" onclick="document.body.style.cursor='wait';"
			 			style="width: 110px; height: 24px; padding-left: 10px; padding-right: 5px; background-repeat: no-repeat; background-position: 5px -3px; margin-left: 5px; margin-right: 5px; font-family: Arial; font-size: 11px; font-weight: normal;">Обсчёт</html:submit>
			 		<!-- html:image property="documentCountingAction" src="/images/calculate.gif" alt="Обсчёт"/ -->	
			 		
			 		<!-- c:if test="${IS_COUNTING_WARNING_PRESENT}" -->
			 		<% if (request.getAttribute("IS_COUNTING_WARNING_PRESENT") != null) { %>
				 		<html:submit property="documentCountingWithAutoCorrectAction.x" onclick="document.body.style.cursor='wait';"
				 			style="height: 24px; padding-left: 10px; padding-right: 5px; background-repeat: no-repeat; background-position: 5px -3px; margin-left: 5px; margin-right: 5px; font-family: Arial; font-size: 11px; font-weight: normal;">Обсчёт с исправлением несоответствий</html:submit>
						<!-- html:image property="documentCountingWithAutoCorrectAction" src="/images/calculatea.gif" alt="Обсчёт с автоматическим исправлением несоответствий"/ -->
					<% } %>	
	 				<!-- /c:if -->
				<!-- /c:when -->
				<!-- c:otherwise -->
				<% } else { %>
					<html:submit property="cancelDocumentCountingAction.x"
			 			style="width: 110px; height: 24px; padding-left: 10px; padding-right: 5px; background-repeat: no-repeat; background-position: 5px -3px; margin-left: 5px; margin-right: 5px; font-family: Arial; font-size: 11px; font-weight: normal;">Снять обсчёт</html:submit>
					<!-- html:image property="cancelDocumentCountingAction" src="/images/calculates.gif" alt="Снять обсчёт"/ -->
				<!-- /c:otherwise -->
				<% } %>
			<!-- /c:choose -->
		<% } %>
		<!-- /c:if -->
		
	 	<html:button property="return" onclick="window.location.href='/inventory/ShowAssemblingPList.do'"
	 		style="width: 110px; height: 24px; padding-left: 10px; padding-right: 5px; background-image: url(../images/cancel.gif); background-repeat: no-repeat; background-position: 5px 0px; margin-left: 5px; margin-right: 5px; font-family: Arial; font-size: 11px; font-weight: normal;">Отмена</html:button>
		
		--%>
<%--

<%if(showStateLink){%>
	<%if("1".equals(docstate)) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='false';return checkPosted();" title="Обсчёт">
<%if(com.hps.july.util.AppUtils.isNewInventory()) {%>
<%  if(frm.getWarnProc() != null && frm.getWarnProc().booleanValue()) {%>
		<input type="image" name="submit" src="/images/calculatea.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='true';return checkPosted();" title="Обсчёт с автоматическим исправлением несоответствий">
<%  }%>
<%}%>
	<%} else {%>
		<html:link page="/ProcessMountAct2.do?action=Edit&processState=C" paramId="document" paramName="MountAct2Form" paramProperty="document" paramScope="request" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>

--%>

	 </TD></TR>
	<% } %>    
	
	<july:separator/>
</table>

</july:editform>
<%-- </html:form> --%>
