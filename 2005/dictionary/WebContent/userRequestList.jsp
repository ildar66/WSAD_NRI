<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "10"; %>

<SCRIPT language="javascript">
	function processFilialType() {
		if (document.all.filialtype.value=="1"){
	    	document.all.filialstring.style.display = 'block';
	    	document.all.filialstring.style.visibility = 'visible';
	    	document.all.regionstring.style.display = 'none';
	    	document.all.regionstring.style.visibility = 'hidden';
		} else if (document.all.filialtype.value=="2"){
	    	document.all.filialstring.style.display = 'none';
	    	document.all.filialstring.style.visibility = 'hidden';
	    	document.all.regionstring.style.display = 'block';
	    	document.all.regionstring.style.visibility = 'visible';
		} else if (document.all.filialtype.value=="3"){
	    	document.all.filialstring.style.display = 'none';
	    	document.all.filialstring.style.visibility = 'hidden';
	    	document.all.regionstring.style.display = 'none';
	    	document.all.regionstring.style.visibility = 'hidden';
		}
	}
</SCRIPT>

<SCRIPT language="javascript">
	function byrequesttype_onchange(){
		if(document.all.byrequesttype[0].checked) {
			document.all.requesttype.disabled = false;
			document.all.requesttype.className = 'edit';
		} else {
			document.all.requesttype.disabled = true;
			document.all.requesttype.className = 'editdisabled';
		}
	}
	function byfilialtype_onchange(){
		if(document.all.byfilialtype[0].checked) {
			document.all.filialtype.disabled = false;
			document.all.filialtype.className = 'edit';
		} else {
			document.all.filialtype.disabled = true;
			document.all.filialtype.className = 'editdisabled';
		}
	}
	function byfilial_onchange(){
		if(document.all.byfilial[0].checked) {
			document.all.regionid.disabled = false;
			document.all.regionid.className = 'edit';
		} else {
			document.all.regionid.disabled = true;
			document.all.regionid.className = 'editdisabled';
		}
	}
	function byregion_onchange(){
		if(document.all.byregion[0].checked) {
			document.all.supregid.disabled = false;
			document.all.supregid.className = 'edit';
		} else {
			document.all.supregid.disabled = true;
			document.all.supregid.className = 'editdisabled';
		}
	}
	function byworker_onchange(){
		if(document.all.byworker[0].checked) {
			document.all.worker.disabled = false;
			document.all.worker.className = 'editsmall';
		} else {
			document.all.worker.disabled = true;
			document.all.worker.className = 'editsmalldisabled';
		}
	}
	function bymodule_onchange(){
		if(document.all.bymodule[0].checked) {
			document.all.module.disabled = false;
			document.all.module.className = 'edit';
		} else {
			document.all.module.disabled = true;
			document.all.module.className = 'editdisabled';
		}
	}
	function bystatus_onchange(){
		if(document.all.bystatus[0].checked) {
			document.all.status.disabled = false;
			document.all.status.className = 'edit';
		} else {
			document.all.status.disabled = true;
			document.all.status.className = 'editdisabled';
		}
	}
	function byrfc_onchange(){
		if(document.all.byrfc[0].checked) {
			document.all.rfc.disabled = false;
			document.all.rfc.className = 'edit';
		} else {
			document.all.rfc.disabled = true;
			document.all.rfc.className = 'editdisabled';
		}
	}
</SCRIPT>

<july:browseform action="/ShowUserRequestList.do">

	<%--<html:hidden property="donotcommit"/>--%>

	<table class="main">

		<july:separator colspan="<%= gColSpan %>" />

       	<TR class="title">
        	<TD nowrap>
           		<bean:message key="label.userrequests.findbydate"/>
           		с
				<july:date property="finddate_fromFrm" size="25" insertable="true" updatable="true" styleId="findDateFrom"/>
				по
				<july:date property="finddate_toFrm" size="25" insertable="true" updatable="true" styleId="findDateTo"/>
				<july:searchbutton/>
			</TD>
       	</TR>

		<july:separator colspan="<%= gColSpan %>" />
		
		<TR class="title">
		
			<TD colspan="<%= gColSpan %>">

				<table class="find">
	
	            	<TR>
	            		<TD class="title" nowrap>
	            			<july:checkbox styleClass="text" property="byrequesttype" insertable="true" updatable="true" 
	            			onclick="byrequesttype_onchange()"/>&nbsp;&nbsp;&nbsp;
	            			<bean:message key="label.userrequests.requesttype"/>
	            		</TD>
	            		<TD class="title" nowrap>
						    <july:select collection="requestTypes" property="requesttype" insertable="true" updatable="true">
								<july:options collection="requestTypes" property="requesttype" labelProperty="name"/>
							</july:select>
						</TD>
	        	    </TR>
	            	<TR>
	            		<TD class="title" nowrap>
	            			<july:checkbox styleClass="text" property="byfilialtype" insertable="true" updatable="true" 
	            			onclick="byfilialtype_onchange()"/>&nbsp;&nbsp;&nbsp;
	            			<bean:message key="label.userrequests.filialtype"/>
	            		</TD>
	            		<TD class="title" nowrap>
							<july:select collection="filialTypes" property="filialtype" insertable="true" updatable="true"
							onchange="processFilialType()">
								<july:options collection="filialTypes" property="filialtype" labelProperty="name"/>
							</july:select>
						</TD>
	        	    </TR>
	            	<TR id="filialstring">
	            		<TD class="title" nowrap>
	            			<july:checkbox styleClass="text" property="byfilial" insertable="true" updatable="true" 
	            			onclick="byfilial_onchange()"/>&nbsp;&nbsp;&nbsp;
	            			<bean:message key="label.userrequests.filialid"/>
	            		</TD>
	            		<TD class="title" nowrap>
							<july:select collection="filials" property="regionid" insertable="true" updatable="true">
								<july:options collection="filials" property="regionid" labelProperty="regname"/>
							</july:select>					
						</TD>
	        	    </TR>
	            	<TR id="regionstring">
	            		<TD class="title" nowrap>
	            			<july:checkbox styleClass="text" property="byregion" insertable="true" updatable="true" 
	            			onclick="byregion_onchange()"/>&nbsp;&nbsp;&nbsp;
	            			<bean:message key="label.userrequests.regionid"/>
	            		</TD>
	            		<TD class="title" nowrap>
							<july:select collection="regions" property="supregid" insertable="true" updatable="true">
								<july:options collection="regions" property="supregid" labelProperty="supregname"/>
							</july:select>
						</TD>
	        	    </TR>
	            	<TR>
	            		<TD class="title" nowrap>
	            			<july:checkbox styleClass="text" property="byworker" insertable="true" updatable="true" 
	            			onclick="byworker_onchange()"/>&nbsp;&nbsp;&nbsp;
	            			<bean:message key="label.userrequests.man"/>
	            		</TD>
	            		<TD class="title" nowrap>
							<july:string property="worker" styleId="worker" size="5" insertable="true" updatable="true"/>
							<july:lookupbutton action="dict/../inventory/ShowWorkerLookupList.do" styleId="workl" fieldNames="worker;workername;workertitle" newWindowName="workerlookup" insertable="true" updatable="true" />
							<july:string size="25" property="workername" styleId="workername" insertable="false" updatable="false" />
							<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
						</TD>
	        	    </TR>
	            	<TR>
	            		<TD class="title" nowrap>
	            			<july:checkbox styleClass="text" property="bymodule" insertable="true" updatable="true" 
	            			onclick="bymodule_onchange()"/>&nbsp;&nbsp;&nbsp;
	            			<bean:message key="label.userrequests.module"/>
	            		</TD>
	            		<TD class="title" nowrap>
							<july:select collection="nriModules" property="module" insertable="true" updatable="true">
								<july:options collection="nriModules" property="module" labelProperty="name"/>
							</july:select>
						</TD>
	        	    </TR>
	            	<TR>
	            		<TD class="title" nowrap>
	            			<july:checkbox styleClass="text" property="bystatus" insertable="true" updatable="true" 
	            			onclick="bystatus_onchange()"/>&nbsp;&nbsp;&nbsp;
	            			<bean:message key="label.userrequests.status"/>
	            		</TD>
	            		<TD class="title" nowrap>
							<july:select collection="statuses" property="status" insertable="true" updatable="true">
								<html:options name="statuses"/>
							</july:select>
						</TD>
	        	    </TR>
	            	<TR>
	            		<TD class="title" nowrap>
	            			<july:checkbox styleClass="text" property="byrfc" insertable="true" updatable="true" 
	            			onclick="byrfc_onchange()"/>&nbsp;&nbsp;&nbsp;
	            			<bean:message key="label.userrequests.rfcnum"/>
	            		</TD>
	            		<TD class="title" nowrap>
	            			<july:string size="10" property="rfc" insertable="true" updatable="true" />
						</TD>
	        	    </TR>
				</table>
			</td>
		</tr>    
		
		<july:separator colspan="<%= gColSpan %>" />
		
	</table>

	<table class="main">
    	<tr class="title">
	    	<td colspan="<%= gColSpan %>">
        		<TABLE class="buttons">
            		<TR class="title">
						<TD class="buttons">
							<july:addbutton page="/EditUserRequest.do?action=Add"/>
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
	        <july:headercolumn key="label.code" colType="number"/>
	        <july:headercolumn key="label.userrequests.requesttype" colType="string"/>
	        <july:headercolumn key="label.userrequests.man" colType="string"/>
	        <july:headercolumn key="label.userrequests.module" colType="string"/>
	        <july:headercolumn key="label.userrequests.status" colType="string"/>
	        <TD class="title" width="1%">&nbsp;</TD>
	    </tr>
	
		<july:separator colspan="<%= gColSpan %>" />
	    
	    <!-- Table body -->
	    <logic:iterate id="rg" name="browseList">
	 	   <logic:present name="rg">
	            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	                <td class="link">
	                    <july:editbutton page="/EditUserRequest.do" action="Edit" paramId="request" paramName="rg" paramProperty="request" paramScope="page"/>
	                </td>
	                <td class="number">
	                    <bean:write name="rg" property="request" filter="true"/>
	                </td>
	                <td class="text">
	                    <bean:write name="rg" property="requesttype" filter="true"/>
	                </td>
	                <td class="text">
	                    <bean:write name="rg" property="worker" filter="true"/>
	                </td>
	                <td class="text">
	                    <bean:write name="rg" property="module" filter="true"/>
	                </td>
	                <td class="text">
	                    <bean:write name="rg" property="status" filter="true"/>
	                </td>
	                <td class="link">
		                <july:delbutton page="/EditUserRequest.do?action=Delete" paramId="request" paramName="rg" paramProperty="request" paramScope="page"/>
	                </td>
	            </tr>
	
	            <july:separator colspan="<%= gColSpan %>" />
	
			</logic:present>
	    </logic:iterate>
	
	    <tr class="title">
		    <td colspan="<%= gColSpan %>">
		    	<TABLE class="buttons">
	            	<TR class="title">
						<TD class="buttons">
							<july:addbutton page="/EditUserRequest.do?action=Add"/>
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
		processFilialType();
		byrequesttype_onchange();
		byfilialtype_onchange();
		byfilial_onchange();
		byregion_onchange();
		byworker_onchange();
		bymodule_onchange();
		bystatus_onchange();
		byrfc_onchange();
	</SCRIPT>
    
</july:browseform>
