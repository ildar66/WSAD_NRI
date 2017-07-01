<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5"; %>

<july:browseform action="/ShowEquipmanufLookupList.do" styleId="EquipmanufLookupForm">

<july:lookupresult tableId="brtable" resultCols="0;2"/>

<SCRIPT language="javascript">
	function bymanufid_onchange(){
		if(document.all.bymanufid[0].checked) {
			document.all.manufidFrm.disabled = false;
			document.all.manufidFrm.className = 'edit';
		} else {
			document.all.manufidFrm.disabled = true;
			document.all.manufidFrm.className = 'editdisabled';
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
	function byshortname_onchange(){
		if(document.all.byshortname[0].checked) {
			document.all.shortname.disabled = false;
			document.all.shortname.className = 'edit';
		} else {
			document.all.shortname.disabled = true;
			document.all.shortname.className = 'editdisabled';
		}
	}
	function byequipcatalog_onchange(){
		if(document.all.byequipcatalog[0].checked) {
			document.all.equipcatalog.disabled = false;
			document.all.equipcatalog.className = 'edit';
		} else {
			document.all.equipcatalog.disabled = true;
			document.all.equipcatalog.className = 'editdisabled';
		}
	}
	function byofficialsite_onchange(){
		if(document.all.byofficialsite[0].checked) {
			document.all.officialsite.disabled = false;
			document.all.officialsite.className = 'edit';
		} else {
			document.all.officialsite.disabled = true;
			document.all.officialsite.className = 'editdisabled';
		}
	}
</SCRIPT>

<table class="main">
<TR class="title">
 <TD class="title">
       <july:currmark><bean:message key="label.choose.equipmanuf"/></july:currmark></td>
 </TD>
</TR>

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
	<table class="find">

	   	<TR>
	  		<TD class="title" nowrap>
	   			<july:checkbox styleClass="text" property="bymanufid" insertable="true" updatable="true" 
	   			onclick="bymanufid_onchange()"/>&nbsp;&nbsp;&nbsp;
	   			<bean:message key="label.equipmanuf.manufid"/>
	        </TD>
	        <TD class="title" nowrap>
	            <july:string size="10" property="manufidFrm" insertable="true" updatable="true" />
	            <july:searchbutton/>
			</TD>
	    </TR>
	    <TR>
	        <TD class="title" nowrap>
	            <july:checkbox styleClass="text" property="byname" insertable="true" updatable="true" 
	            onclick="byname_onchange()"/>&nbsp;&nbsp;&nbsp;
	            <bean:message key="label.equipmanuf.name"/>
	        </TD>
	        <TD class="title" nowrap>
	            <july:string size="10" property="name" insertable="true" updatable="true" />
			</TD>
	    </TR>
	    <TR>
	        <TD class="title" nowrap>
	            <july:checkbox styleClass="text" property="byshortname" insertable="true" updatable="true" 
	            onclick="byshortname_onchange()"/>&nbsp;&nbsp;&nbsp;
	            <bean:message key="label.equipmanuf.shortname"/>
	        </TD>
	        <TD class="title" nowrap>
	            <july:string size="10" property="shortname" insertable="true" updatable="true" />
			</TD>
	    </TR>
	    <TR>
	        <TD class="title" nowrap>
	            <july:checkbox styleClass="text" property="byequipcatalog" insertable="true" updatable="true" 
	            onclick="byequipcatalog_onchange()"/>&nbsp;&nbsp;&nbsp;
	            <bean:message key="label.equipmanuf.equipcatalog"/>
	        </TD>
	        <TD class="title" nowrap>
	            <july:string size="10" property="equipcatalog" insertable="true" updatable="true" />
			</TD>
	    </TR>
	    <TR>
	        <TD class="title" nowrap>
	            <july:checkbox styleClass="text" property="byofficialsite" insertable="true" updatable="true" 
	            onclick="byofficialsite_onchange()"/>&nbsp;&nbsp;&nbsp;
	            <bean:message key="label.equipmanuf.officialsite"/>
	        </TD>
	        <TD class="title" nowrap>
	            <july:string size="10" property="officialsite" insertable="true" updatable="true" />
			</TD>
	    </TR>
	</table>
    
  </TD>
</TR>

<SCRIPT language="javascript">
	bymanufid_onchange();
	byname_onchange();
	byshortname_onchange();
	byequipcatalog_onchange();
	byofficialsite_onchange();
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
	        <july:headercolumn key="label.equipmanuf.manufid" colType="number"/>
    	    <july:headercolumn key="label.equipmanuf.name" colType="string"/>
	        <july:headercolumn key="label.equipmanuf.shortname" colType="string"/>
    	    <july:headercolumn key="label.equipmanuf.equipcatalog" colType="string"/>
    	    <july:headercolumn key="label.equipmanuf.officialsite" colType="string"/>
        </tr>
        
        <!-- Table body -->
        <logic:iterate id="org" name="browseList" indexId="index" type="com.hps.july.cdbc.lib.CDBCRowObject">
	      <logic:present name="org">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><july:stringwrite name="org" property="manufid"/></td>
                <td class="text"><july:lookupreturn><july:stringwrite name="org" property="name"/></july:lookupreturn></td>
                <td class="text"><july:stringwrite name="org" property="shortname"/></td>
                <td class="text"><july:stringwrite name="org" property="equipcatalog"/></td>
                <td class="text"><july:stringwrite name="org" property="officialsite"/></td>
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
