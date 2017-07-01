<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5"; %>

<july:browseform action="/ShowResourceGroupLookupList.do" styleId="ResourceGroupLookupForm">

<july:lookupresult tableId="brtable" resultCols="0;1"/>

<SCRIPT language="javascript">
	function bygroupid_onchange(){
		if(document.all.bygroupid[0].checked) {
			document.all.groupidFrm.disabled = false;
			document.all.groupidFrm.className = 'edit';
		} else {
			document.all.groupidFrm.disabled = true;
			document.all.groupidFrm.className = 'editdisabled';
		}
	}
	function byname_onchange(){
		if(document.all.byname[0].checked) {
			document.all.name.disabled = false;
			document.all.name.className = 'edit';
		} else {
			document.all.name.disabled = true;
			document.all.name.className = 'editdisabled';
		}
	}
</SCRIPT>

<table class="main">
<TR class="title">
 <TD class="title">
       <july:currmark><bean:message key="label.choose.resgroup"/></july:currmark></td>
 </TD>
</TR>

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
	<table class="find">

	   	<TR>
	  		<TD class="title" nowrap>
	   			<july:checkbox styleClass="text" property="bygroupid" insertable="true" updatable="true" 
	   			onclick="bygroupid_onchange()"/>&nbsp;&nbsp;&nbsp;
	   			<bean:message key="label.groupres.lookup.code"/>
	        </TD>
	        <TD class="title" nowrap>
	            <july:string size="10" property="groupidFrm" insertable="true" updatable="true" />
	            <july:searchbutton/>
			</TD>
	    </TR>
	    <TR>
	        <TD class="title" nowrap>
	            <july:checkbox styleClass="text" property="byname" insertable="true" updatable="true" 
	            onclick="byname_onchange()"/>&nbsp;&nbsp;&nbsp;
	            <bean:message key="label.groupres.lookup.name"/>
	        </TD>
	        <TD class="title" nowrap>
	            <july:string size="10" property="name" insertable="true" updatable="true" />
			</TD>
	    </TR>
	</table>
    
  </TD>
</TR>

<SCRIPT language="javascript">
	bygroupid_onchange();
	byname_onchange();
</SCRIPT>

<tr class="title">
  <td><TABLE class="buttons">
    <TR class="title">
      <TD class="buttons"><july:closebutton page="/"/></TD>
      <TD class="navigator"><july:navigator/></TD>
    </TR>
    </TABLE></TD>
</tr>

<TR>
  <TD>

    <table class="main" id="brtable">

        <!-- Table header -->
        <tr class="title">
	        <july:headercolumn key="label.groupres.lookup.code" colType="number"/>
    	    <july:headercolumn key="label.groupres.lookup.name" colType="string"/>
        </tr>
        
        <!-- Table body -->
        <logic:iterate id="org" name="browseList" indexId="index" type="com.hps.july.cdbc.lib.CDBCRowObject">
	      <logic:present name="org">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><july:stringwrite name="org" property="groupid"/></td>
                <td class="text"><july:lookupreturn><july:stringwrite name="org" property="name"/></july:lookupreturn></td>
            </tr>
	      </logic:present>
          
	      <logic:notPresent name="org">
            <tr class="normal">
                <td class="text" colspan="<%= gColSpan %>">
                   <bean:message key="label.norecords"/>
                </td>
            </tr>
	      </logic:notPresent>
          
          <july:separator colspan="<%= gColSpan %>" />
            
        </logic:iterate>

    </table>
</TD>
</TR>

<tr class="title">
  <td><TABLE class="buttons">
    <TR class="title">
      <TD class="buttons"><july:closebutton page="/"/></TD>
      <TD class="navigator"><july:navigator/></TD>
    </TR>
    </TABLE></TD>
</tr>

</TABLE>

</july:browseform>
