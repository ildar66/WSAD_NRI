<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import = "com.hps.july.dictionary.valueobject.ResourceCommonRow" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "10"; %>

<jsp:include page="showNfsScript.jsp" flush="true"/>

<SCRIPT language="javascript">
	function checkActualResclass(resclass){
		if (resclass=="-1"){
			document.all.upperctrl.style.display = 'none';
			document.all.upperctrl.style.visibility = 'hidden';		
			document.all.lowerctrl.style.display = 'none';
			document.all.lowerctrl.style.visibility = 'hidden';
		}
		else{
			document.all.upperctrl.style.display = 'block';
			document.all.upperctrl.style.visibility = 'visible';
			document.all.lowerctrl.style.display = 'block';
			document.all.lowerctrl.style.visibility = 'visible';
		}
	}
	function submitForm(){
		submitRefresh();
	}
	function submitNorefresh(){
		document.all.donotrefresh.value="true";
		document.forms["ResourcesCommonListForm"].submit();
	}
	function submitRefresh(){
		document.forms["ResourcesCommonListForm"].submit();
	}

	function byname_onchange(){
		if(document.all.isname[0].checked) {
			document.all.name.disabled = false;
			document.all.name.className = 'search';
		} else {
			document.all.name.disabled = true;
			document.all.name.className = 'editdisabled';
		}
	}
	function bymanuf_onchange(){
		if(document.all.ismanuf[0].checked) {
			document.all.manuf.disabled = false;
			document.all.manuf.className = 'editkodsearch';
			document.all['lookupbtn_rstl'].disabled = false;
			document.all['lookupimg_rstl'].src='/images/lookup.gif';
		} else {
			document.all.manuf.disabled = true;
			document.all.manuf.className = 'editkoddisabled';
			document.all['lookupbtn_rstl'].disabled = true;
			document.all['lookupimg_rstl'].src='/images/lookup_disabled.gif';
		}
	}
	function bymodel_onchange(){
		if(document.all.ismodel[0].checked) {
			document.all.model.disabled = false;
			document.all.model.className = 'search';
		} else {
			document.all.model.disabled = true;
			document.all.model.className = 'editdisabled';
		}
	}
	function bymanucode_onchange(){
		if(document.all.ismanucode[0].checked) {
			document.all.manucode.disabled = false;
			document.all.manucode.className = 'search';
		} else {
			document.all.manucode.disabled = true;
			document.all.manucode.className = 'editdisabled';
		}
	}
	function bynfscode_onchange(){
		if(document.all.isnfscode[0].checked) {
			document.all.nfscode.disabled = false;
			document.all.nfscode.className = 'search';
		} else {
			document.all.nfscode.disabled = true;
			document.all.nfscode.className = 'editdisabled';
		}
	}
	function bynricode_onchange(){
		if(document.all.isnricode[0].checked) {
			document.all.nricode.disabled = false;
			document.all.nricode.className = 'search';
		} else {
			document.all.nricode.disabled = true;
			document.all.nricode.className = 'editdisabled';
		}
	}
</SCRIPT>

<july:browseform action="/ShowResourcesCommonList.do" styleId="ResourcesCommonListForm">

	<%--<html:hidden property="donotcommit"/>--%>
	<html:hidden property="donotrefresh"/>

	<table class="main">

		<july:separator colspan="<%= gColSpan %>" />

       	<TR class="title">
        	<TD nowrap>
           		<bean:message key="label.resource.resclass"/>
				<july:select collection="resClasses" property="resclassFrm" insertable="true" updatable="true" styleClass="search" onchange="submitForm()">
					<html:option value="-1" key="label.resourceclass2.notselect"/>
					<july:options collection="resClasses" property="classid" labelProperty="classname"/>
				</july:select>
			</TD>
       	</TR>

		<july:separator colspan="<%= gColSpan %>" />
		
		<TR class="title">
		
			<TD colspan="<%= gColSpan %>">

				<table class="find">
	
	            	<TR>
	            		<TD class="title" nowrap>
	            			<july:checkbox styleClass="text" property="isname" insertable="true" updatable="true" 
	            			onclick="byname_onchange()"/>&nbsp;&nbsp;&nbsp;
	            			<bean:message key="label.resource.byname"/>
	            		</TD>
	            		<TD class="title" nowrap>
							<july:string property="name" styleId="name" size="25" insertable="true" updatable="true" styleClass="editkodsearch" />
							<%--&nbsp;<INPUT TYPE='image' src='/images/refresh.gif'  onclick='document.body.style.cursor=\"wait\"; document.all.donotrefresh.value=\"false\";' border='0' alt='Искать'>--%>
							<july:searchbutton/>
						</TD>
	        	    </TR>
	            	<TR>
	            		<TD class="title" nowrap>
	            			<july:checkbox styleClass="text" property="ismanuf" insertable="true" updatable="true" 
	            			onclick="bymanuf_onchange()"/>&nbsp;&nbsp;&nbsp;
	            			<bean:message key="label.resource.bymanufacturer"/>
	            		</TD>
	            		<TD class="title" nowrap>
							<july:string property="manuf" styleId="manuf" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
							<%--<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="rstl" fieldNames="manuf;manufname" newWindowName="manuflookup" insertable="true" updatable="true"/>--%>
							<july:lookupbutton action="/ShowEquipmanufLookupList.do" styleId="rstl" fieldNames="manuf;manufname" newWindowName="manuflookup" insertable="true" updatable="true"/>
							<july:string size="35" property="manufname" styleId="manufname" insertable="false" updatable="false"/>
						</TD>
	        	    </TR>
	            	<TR>
	            		<TD class="title" nowrap>
	            			<july:checkbox styleClass="text" property="ismodel" insertable="true" updatable="true" 
	            			onclick="bymodel_onchange()"/>&nbsp;&nbsp;&nbsp;
	            			<bean:message key="label.resource.bysign"/>
	            		</TD>
	            		<TD class="title" nowrap>
							<july:string property="model" styleId="model" size="25" insertable="true" updatable="true" styleClass="search" />
						</TD>
	        	    </TR>
	            	<TR>
	            		<TD class="title" nowrap>
	            			<july:checkbox styleClass="text" property="ismanucode" insertable="true" updatable="true" 
	            			onclick="bymanucode_onchange()"/>&nbsp;&nbsp;&nbsp;
	            			<bean:message key="label.resource.bymanucode"/>
	            		</TD>
	            		<TD class="title" nowrap>
							<july:string property="manucode" styleId="manucode" size="25" insertable="true" updatable="true" styleClass="search" />
						</TD>
	        	    </TR>
	            	<TR>
	            		<TD class="title" nowrap>
	            			<july:checkbox styleClass="text" property="isnfscode" insertable="true" updatable="true" 
	            			onclick="bynfscode_onchange()"/>&nbsp;&nbsp;&nbsp;
	            			<bean:message key="label.resource.nfscode"/>
	            		</TD>
	            		<TD class="title" nowrap>
							<july:string property="nfscode" styleId="nfscode" size="25" insertable="true" updatable="true" styleClass="search" />
						</TD>
	        	    </TR>
	            	<TR>
	            		<TD class="title" nowrap>
	            			<july:checkbox styleClass="text" property="isnricode" insertable="true" updatable="true" 
	            			onclick="bynricode_onchange()"/>&nbsp;&nbsp;&nbsp;
	            			<bean:message key="label.resource.nricode"/>
	            		</TD>
	            		<TD class="title" nowrap>
							<july:string property="nricode" styleId="nricode" size="25" insertable="true" updatable="true" styleClass="search" />
						</TD>
	        	    </TR>
	            	<TR>
	            		<TD nowrap>
	            			<bean:message key="label.resource.show"/>
						</TD>
	            		<TD class="title" nowrap>	            			
							<html:select property="showtype">
								<html:option value="*" key="label.resource.showall"/>
								<html:option value="Y" key="label.resource.shownew"/>
								<html:option value="N" key="label.resource.showold"/>
							</html:select>						
						</TD>
	        	    </TR>
				</table>
			</td>
		</tr>    
		
		<july:separator colspan="<%= gColSpan %>" />
		
	</table>
	
	<%
    Integer resclass = (Integer) request.getAttribute("resclass");
    int resc = resclass.intValue();
    String action = "";
    switch (resc){
    	case 2: action = "/EditCable.do"; break;
    	case 3: action = "/EditAntena.do"; break;
    	case 4: action = "/EditRRLResource.do"; break;
    	case 5: action = "/EditRepeater.do"; break;
    	case 18: action = "/EditAccumBattery.do"; break;
    	case 21: action = "/EditDonorUnit.do"; break;
    	case 23: action = "/EditTranceiver.do"; break;
    	case 1: action = "/EditBasestation.do"; break;
    	default: action = "/EditResource.do"; break;    	
    }
    String delaction = action + "?action=Delete";
    String addaction = action + "?action=Add";
    if (action.equalsIgnoreCase("/EditResource.do")){
    	addaction+="&amp;resclass2=";
    	addaction+=resc;
    }
	%>
	

	<table class="main">
    	<tr class="title">
	    	<td colspan="<%= gColSpan %>">
        		<TABLE class="buttons">
            		<TR class="title" id="upperctrl">
						<TD class="buttons">
							<july:addbutton page="<%= addaction %>" styleId="add1"/>
							<july:backbutton/>
						</TD>
    		        	<TD class="navigator"><july:navigator/></TD>
        		    </TR>
	            </TABLE>
    	    </TD>
	    </tr>
		
		<july:separator colspan="<%= gColSpan %>" />
        
	    <!-- Table header -->
	    <tr class="title">
	    
	        <TD class="title" width="1%">&nbsp;</TD>
	        <july:headercolumn key="label.resource.nricodeLabel" colType="number"/>
	        <july:headercolumn key="label.resource.nfscodes" colType="string"/>
	        <july:sortcolumn key="label.resource.manucode" colType="string" ascFinder="5" descFinder="6"/>
	        <july:sortcolumn key="label.resource.model" colType="string" ascFinder="1" descFinder="2"/>
	        <july:sortcolumn key="label.resource.name" colType="string" ascFinder="3" descFinder="4"/>
	        <july:headercolumn key="label.resource.unit.short" colType="string"/>
	        <july:headercolumn key="label.resource.countpolicy.short" colType="string"/>
	        <july:headercolumn key="label.resource.double" colType="string"/>
	        <TD class="title" width="1%">&nbsp;</TD>
	    </tr>
	
		<july:separator colspan="<%= gColSpan %>" />
	    
	    <!-- Table body -->
	    <logic:iterate id="rg" name="browseList">
	 		<logic:present name="rg">
				<%
	 	 		ResourceCommonRow row = (ResourceCommonRow) rg;
				pageContext.setAttribute("resource",row.getResource());	 	 		
	 	 		if ("N".equals(row.getActive())) { 
	 	 		%>
				<tr class="autodoc" onMouseOver="className='select'" onMouseOut="className='autodoc'">
				<% } else { %>
				<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<% } %>
					<td class="link">
						<july:editbutton page="<%= action %>" action="Edit" paramId="resource" paramName="resource" paramScope="page"  styleId="editact"/>
					</td>	            
            		<td class="number"><july:stringwrite name="rg" property="resource"/></td>
            		<td class="text" width="130">
					<% 
					if ("Y".equals(row.getDisablenfscodes())){
					%>
					<A HREF="#"><IMG BORDER="0" SRC="/images/bd_red.gif" width="17" height="17" onclick='showNFS(<july:stringwrite name="rg" property="resource"/>); return false;'></A>
					<%
					} else {
						if (request.isUserInRole("dictResAdmin") || request.isUserInRole("administrator") || request.isUserInRole("developer")) { %> 
						<A HREF="#"><IMG BORDER="0" SRC="/images/bd.gif" onclick='editNFS(<july:stringwrite name="rg" property="resource"/>); return false;'></A>
						<% } else { %> 
						<A HREF="#"><IMG BORDER="0" SRC="/images/bd.gif" onclick='showNFS(<july:stringwrite name="rg" property="resource"/>); return false;'></A>
						<% } 
					}
					%>
					<july:stringwrite name="rg" property="nfslist"/>
					</td>
	                <td class="text">
	                    <bean:write name="rg" property="manucode" filter="true"/>
	                </td>
	                <td class="text">
	                    <bean:write name="rg" property="model" filter="true"/>
	                </td>
	                <td class="text">
	                    <bean:write name="rg" property="name" filter="true"/>
	                </td>
	                <td class="text">
	                    <bean:write name="rg" property="unit" filter="true"/>
	                </td>
	                <td class="text">
	                    <bean:write name="rg" property="countpolicy" filter="true"/>
	                </td>
					<td class="link">
						<%--<%if(request.isUserInRole("administrator")) {%>--%>
						<july:link page="/EditDouble.do?action=Edit" paramId="resource" paramName="resource" paramScope="page" alttext="msg.double"><bean:message key="label.resource.double"/></july:link>
						<%--<%}%>--%>
					</td>
	                <td class="link">
		                <july:delbutton page="<%= delaction %>" paramId="resource" paramName="rg" paramProperty="resource" paramScope="page" styleId="deleteact"/>
	                </td>
	            </tr>
	
	            <july:separator colspan="<%= gColSpan %>" />
	
			</logic:present>
	    </logic:iterate>
	
	    <tr class="title">
		    <td colspan="<%= gColSpan %>">
		    	<TABLE class="buttons">
	            	<TR class="title" id="lowerctrl">
						<TD class="buttons">
							<july:addbutton page="<%= addaction %>"  styleId="add2"/>
							<july:backbutton/>
						</TD>
		    	        <TD class="navigator"><july:navigator/></TD>
	            	</TR>
	            </TABLE>
	        </TD>
	    </tr>
	        
		<july:separator colspan="<%= gColSpan %>" />
	
	</table>
 
	<SCRIPT language="javascript">
		//alert(document.all.donotrefresh.value);
		byname_onchange();
		bymanuf_onchange();
		bymodel_onchange();
		bymanucode_onchange();
		bynfscode_onchange();
		bynricode_onchange();
		checkActualResclass(document.all.resclassFrm.value);
	</SCRIPT>
    
</july:browseform>
