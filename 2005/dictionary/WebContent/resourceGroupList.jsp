<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "4"; %>
<% java.lang.String gColWidth = "10"; %>
<%-- width="<%= gColWidth %>"--%>

<script language="javascript">
	function setFilterVisible() {
		if (document.all.usesearch[0].checked){
	    	//document.all.searchcontrol.style.display = 'block';
	    	//document.all.searchcontrol.style.visibility = 'visible';
	    	document.all.code1field.style.display = 'block';
	    	document.all.code1field.style.visibility = 'visible';
	    	document.all.code2field.style.display = 'block';
	    	document.all.code2field.style.visibility = 'visible';
	    	document.all.model1field.style.display = 'block';
	    	document.all.model1field.style.visibility = 'visible';
	    	document.all.model2field.style.display = 'block';
	    	document.all.model2field.style.visibility = 'visible';
	    	document.all.manucode1field.style.display = 'block';
	    	document.all.manucode1field.style.visibility = 'visible';
	    	document.all.manucode2field.style.display = 'block';
	    	document.all.manucode2field.style.visibility = 'visible';
	    	document.all.accesstitle.style.display = 'block';
	    	document.all.accesstitle.style.visibility = 'visible';
		}
		else {
	    	//document.all.searchcontrol.style.display = 'none';
	    	//document.all.searchcontrol.style.visibility = 'hidden';
	    	document.all.code1field.style.display = 'none';
	    	document.all.code1field.style.visibility = 'hidden';
	    	document.all.code2field.style.display = 'none';
	    	document.all.code2field.style.visibility = 'hidden';
	    	document.all.model1field.style.display = 'none';
	    	document.all.model1field.style.visibility = 'hidden';
	    	document.all.model2field.style.display = 'none';
	    	document.all.model2field.style.visibility = 'hidden';
	    	document.all.manucode1field.style.display = 'none';
	    	document.all.manucode1field.style.visibility = 'hidden';
	    	document.all.manucode2field.style.display = 'none';
	    	document.all.manucode2field.style.visibility = 'hidden';
	    	document.all.accesstitle.style.display = 'none';
	    	document.all.accesstitle.style.visibility = 'hidden';
		}
	}
	function clickedEmptyGroups(){
		if (document.all.findemptygroups[0].checked)
			if (document.all.usesearch[0].checked) document.all.usesearch[0].checked=false;
		processForm();
	}
	function clickedUseSearch(){
		if (document.all.usesearch[0].checked)
			document.all.findemptygroups[0].checked=false;
		processForm();
	}
	function processForm(){
		setFilterVisible();
		document.forms[0].submit();
	}
</script>

<july:browseform action="/ShowResourceGroupList.do">

<%@include file="resources/script.jsp" %>

<%--<html:hidden property="donotcommit"/>--%>

<table class="main">

	<july:separator colspan="<%= gColSpan %>" />
		
	<tr class="title">
    	<td colspan="<%= gColSpan %>">
    	<%--
        	<TABLE class="main">
            	<TR class="title">
            		<TD class="text">
            		--%>
						<july:checkbox styleClass="text" property="findemptygroups" insertable="true" 
						updatable="true" onclick="clickedEmptyGroups()"/>
						<bean:message key="label.antacess.emptyonly"/>
					<%--
					</TD>
        	    </TR>
            </TABLE>
        --%>
        </TD>
    </tr>
		
	<july:separator colspan="<%= gColSpan %>" />
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table>
				<tr class="title">
			    	<td colspan="<%= gColSpan %>">
			        	<%--
			        	<TABLE class="main">
			            	<TR class="title">
				            	<td class="text" nowrap>--%>
						<july:checkbox styleClass="text" property="usesearch" insertable="true" 
						updatable="true" onclick="clickedUseSearch()"/>
						<bean:message key="label.antacess.searchaccess"/>
						<july:searchbutton/>
					</td>
								<%--
								<td class="buttons"  id="searchcontrol" nowrap></td>
								--%>
			    </TR>
			    <TR id="accesstitle">
			       	<td class="main">
			       		<bean:message key="label.antacess.accessory1"/>
					</td>
					<td class="main">
						<bean:message key="label.antacess.accessory2"/>
					</td>
			    </TR>
				<tr>
					<td class="main" id="code1field" nowrap>
						<july:string property="code1Frm" size="5" insertable="true" updatable="true"  styleClass="editkodsearch"/>
						<bean:message key="label.antacess.id"/>
					</td>
					<td class="main" id="code2field" nowrap>
						<july:string property="code2Frm" size="5" insertable="true" updatable="true"  styleClass="editkodsearch"/>
						<bean:message key="label.antacess.id"/>
					</td>
				</tr>        	    
				<tr>
					<td class="main" id="model1field" nowrap>
						<july:string property="model1" size="40" insertable="true" updatable="true"  styleClass="editkodsearch"/>
						<bean:message key="label.antacess.model"/>
					</td>
					<td class="main" id="model2field" nowrap>
						<july:string property="model2" size="40" insertable="true" updatable="true"  styleClass="editkodsearch"/>
						<bean:message key="label.antacess.model"/>
					</td>
				</tr>        	    
				<tr>
					<td class="main" id="manucode1field" nowrap>
						<july:string property="manucode1" size="10" insertable="true" updatable="true"  styleClass="editkodsearch"/>
						<bean:message key="label.antacess.manucode"/>
					</td>
					<td class="main" id="manucode2field" nowrap>
						<july:string property="manucode2" size="10" insertable="true" updatable="true"  styleClass="editkodsearch"/>
							<bean:message key="label.antacess.manucode"/>
							<%--
								</td>
							</tr>
						</TABLE>
					--%>
			        </TD>
			    </tr>		
			</table>	
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>" />

   	<tr class="title">
	    <td colspan="<%= gColSpan %>">
       		<TABLE class="buttons">
   	        	<TR class="title">
            		<TD class="buttons">
              			<july:addbutton page="/EditResourceGroup.do?action=Add"/><july:backbutton/>
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
	        <july:headercolumn key="label.unit.code" colType="number"/>
            <july:headercolumn key="label.unit.name" colType="string"/>
        <TD class="title" width="1%">&nbsp;</TD>
    </tr>

	<july:separator colspan="<%= gColSpan %>" />
    
    <!-- Table body -->
    <logic:iterate id="rg" name="browseList">
		<logic:present name="rg">
        	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="link">
                    <july:editbutton page="/EditResourceGroup.do" action="Edit" paramId="groupid" paramName="rg" paramProperty="groupid" paramScope="page"/>
                </td>
                <td class="number" width="10">
                    <bean:write name="rg" property="groupid" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="rg" property="name" filter="true"/>
                </td>
                <td class="link">
    	            <july:delbutton page="/EditResourceGroup.do?action=Delete" paramId="groupid" paramName="rg" paramProperty="groupid" paramScope="page"/>
        	    </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	    </logic:present>
    </logic:iterate>

    <tr class="title">
    	<td colspan="<%= gColSpan %>">
    		<TABLE class="buttons">
        		<TR class="title">
            		<TD class="buttons"><july:addbutton page="/EditResourceGroup.do?action=Add"/><july:backbutton/></TD>
	              	<TD class="navigator"><july:navigator/></TD>
    	        </TR>
            </TABLE>
        </TD>
    </tr>
        
    <july:separator colspan="<%= gColSpan %>" />

	<%--      
    	<tr class="title">
    		<td class="title" colspan="<%= gColSpan %>">
           		<july:currmark><bean:message key="label.units"/></july:currmark>
           	</td>
		</tr>
	--%>        
</table>
    
<script language="javascript">
setFilterVisible();
</script>    

</july:browseform>
