<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import = "com.hps.july.cdbc.lib.CDBCRowObject" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "10"; %>

<jsp:include page="showNfsScript.jsp" flush="true"/>

<SCRIPT language="javascript">
	function submitForm(){
		submitRefresh();
	}
	function submitNorefresh(){
		//document.all.donotrefresh.value="true";
		document.forms["ResourceReport"].submit();
	}
	function submitRefresh(){
		document.forms["ResourceReport"].submit();
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
		} else {
			document.all.manuf.disabled = true;
			document.all.manuf.className = 'editkoddisabled';
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

<july:browseform action="/ShowResourceReport.do" styleId="ResourceReport">

	<%--<html:hidden property="donotcommit"/>--%>
	<%--<html:hidden property="donotrefresh"/>--%>

	<table class="main">

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
	
	<table class="main">
    	<tr class="title">
	    	<td colspan="<%= gColSpan %>">
        		<TABLE class="buttons">
            		<TR class="title" id="upperctrl">
						<TD class="buttons">
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
	        <july:sortcolumn key="label.resourcereport.classid" colType="number" ascFinder="1" descFinder="2"/>
	        <july:sortcolumn key="label.resourcereport.classname" colType="string" ascFinder="3" descFinder="4"/>
	        <july:sortcolumn key="label.resource.nricodeLabel" colType="number" ascFinder="5" descFinder="6"/>
	        <july:headercolumn key="label.resource.nfscodes" colType="string"/>
	        <july:sortcolumn key="label.resource.manucode" colType="string" ascFinder="7" descFinder="8"/>
	        <july:sortcolumn key="label.resource.model" colType="string" ascFinder="9" descFinder="10"/>
	        <july:sortcolumn key="label.resource.name" colType="string" ascFinder="11" descFinder="12"/>
	        <july:headercolumn key="label.resource.unit.short" colType="string"/>
	        <july:headercolumn key="label.resource.countpolicy.short" colType="string"/>
	        <july:sortcolumn key="label.resource.manufacturer" colType="string" ascFinder="13" descFinder="14"/>
	    </tr>
	
		<july:separator colspan="<%= gColSpan %>" />
	    
	    <!-- Table body -->
	    <logic:iterate id="rg" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
	 		<logic:present name="rg">
				<%
				CDBCRowObject row = (CDBCRowObject) rg;
				String cpolicy = "";
				if (row.hasColumn("countpolicy")){
					String cp = row.getColumn("countpolicy").asString();
					switch (cp.charAt(0)){
						case 'S': cpolicy="Серийный"; break;
						case 'P': cpolicy="Партионный"; break;
						case 'B': cpolicy="Обычный"; break;
					} 
				}
				pageContext.setAttribute("resource",row.getColumn("resource").asString());	 	 		
	 	 		if ("N".equals(row.getColumn("active").asString())) { 
	 	 		%>
				<tr class="autodoc" onMouseOver="className='select'" onMouseOut="className='autodoc'">
				<% } else { %>
				<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<% } %>
					<td class="number"><july:stringwrite name="rg" property="classid"/></td>
					<td class="text"><july:stringwrite name="rg" property="classname"/></td>
            		<td class="number"><july:stringwrite name="rg" property="resource"/></td>
            		<td class="text" width="130">
					<% 
					if ("Y".equals(row.getColumn("disablenfscodes").asString())){
					%>
					<A HREF="#"><IMG BORDER="0" SRC="/images/bd_red.gif" width="17" height="17" onclick='showNFS(<july:stringwrite name="rg" property="resource"/>); return false;'></A>
					<%
					} else {
					%> 
					<A HREF="#"><IMG BORDER="0" SRC="/images/bd.gif" onclick='showNFS(<july:stringwrite name="rg" property="resource"/>); return false;'></A>
					<%
					}
					%>
					<july:stringwrite name="rg" property="nfslist"/>
					</td>
	                <td class="text">
	                    <july:stringwrite name="rg" property="manucodelst"/><%-- filter="true"--%>
	                </td>
	                <td class="text">
	                    <july:stringwrite name="rg" property="modellst"/><%-- filter="true"--%>
	                </td>
	                <td class="text">
	                    <july:stringwrite name="rg" property="namelst"/><%-- filter="true"--%>
	                </td>
	                <td class="text">
	                    <july:stringwrite name="rg" property="unit"/><%-- filter="true"--%>
	                </td>
	                <td class="text">
	                	<%= cpolicy %>
	                    <%--<july:stringwrite name="rg" property="countpolicy"/>--%><%-- filter="true"--%>
	                </td>
					<td class="link">
	                    <july:stringwrite name="rg" property="manufname"/><%-- filter="true"--%>
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
		byname_onchange();
		bymanuf_onchange();
		bymodel_onchange();
		bymanucode_onchange();
		bynfscode_onchange();
		bynricode_onchange();
	</SCRIPT>
    
</july:browseform>
