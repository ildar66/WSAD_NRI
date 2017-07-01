<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "18"; %>

<july:browseform action="/ShowReqLookupList.do" styleId="reqform">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		ReqLookupListForm[itemname].className = 'editkoddisabled';
		ReqLookupListForm[itemname].disabled = true;
		ReqLookupListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		ReqLookupListForm[itemname].className = 'editkodsearch';
		ReqLookupListForm[itemname].disabled = false;
		ReqLookupListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}
function switchItem(itemname,state) {
	if(state) {
		ReqLookupListForm[itemname].disabled = true;
		ReqLookupListForm[itemname].className = 'editdisabled';
	} else {
		ReqLookupListForm[itemname].disabled = false;
		ReqLookupListForm[itemname].className = 'editsearch';
	}
}

function switchPosition() {
	switchLookup('positioncode','pos',ReqLookupListForm.isposition[0].checked);
}
</script>

<july:lookupresult tableId="brtable" resultCols="0;2;1;3;4;5;6;7;8;9;10;12;11"/>

<table class="main">
<TR class="title">
 <TD class="title">
    <bean:message key="label.choose.req"/>
 </TD>
</TR>
<TR class="normal">
<td>
	<table class="find">
	<tr>
		<td class="title" nowrap><bean:message key="label.req.position"/></td>
		<td class="title" nowrap colspan="1">
			<july:checkbox property="isposition" insertable="true" updatable="true" value="true" onclick="switchPosition();"/><html:hidden property="isposition" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="positioncode" styleId="positioncode" size="5" insertable="true" updatable="true"  styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positioncode;positionid;positionname" newWindowName="poslookup" insertable="true" updatable="true"/>
			<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
			<july:string size="15" property="positionname" styleId="positionname" insertable="false" updatable="false" />&nbsp;<july:searchbutton />
		</td>
	</tr>        
	<script language="javascript">switchPosition();</script>
	</table>
</td>
</tr>

<tr class="title">
  <td><TABLE class="buttons">
    <TR class="title">
      <TD class="buttons"><july:closebutton page="/"/></TD>
      <TD class="navigator"><july:navigator/></TD>
    </TR>
    </TABLE></TD>
</tr>

<tr>
  <td>
    <table class="main" id="brtable">

        <!-- Table header -->
        <tr class="title">
<td style="visibility:hidden;display:none;"></td>
		<july:headercolumn key="label.req.date" colType="string"/>
		<july:headercolumn key="label.num" colType="number"/>
<td style="visibility:hidden;display:none;"></td>
<td style="visibility:hidden;display:none;"></td>
<td style="visibility:hidden;display:none;"></td>
<td style="visibility:hidden;display:none;"></td>
<td style="visibility:hidden;display:none;"></td>
<td style="visibility:hidden;display:none;"></td>
<td style="visibility:hidden;display:none;"></td>
<td style="visibility:hidden;display:none;"></td>
<td style="visibility:hidden;display:none;"></td>
		<july:headercolumn key="label.req.expedition"/></td>
		<july:headercolumn key="label.req.position"/></td>
		<july:headercolumn key="label.req.division" colType="string"/>
        </tr>

        <!-- Table body -->
        <logic:iterate id="rstl" name="browseList" indexId="index">
	      <logic:present name="rstl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
<td style="visibility:hidden;display:none;"><bean:write name="rstl" property="so.document" filter="true"/></td>
                <td class="text"><july:lookupreturn><july:datewrite name="rstl" property="so.blankdate" /></july:lookupreturn></td>
                <td class="number"><bean:write name="rstl" property="so.blankindex" filter="true"/>&nbsp;<bean:write name="rstl" property="so.blanknumber" filter="true"/></td>
<td style="visibility:hidden;display:none;"><bean:write name="rstl" property="type" filter="true"/></td>
<td style="visibility:hidden;display:none;"><bean:write name="rstl" property="wcode" filter="true"/></td>
<td style="visibility:hidden;display:none;"><bean:write name="rstl" property="wname" filter="true"/></td>
<td style="visibility:hidden;display:none;"><bean:write name="rstl" property="wpos" filter="true"/></td>
<td style="visibility:hidden;display:none;"><bean:write name="rstl" property="pcode" filter="true"/></td>
<td style="visibility:hidden;display:none;"><bean:write name="rstl" property="pname" filter="true"/></td>
<td style="visibility:hidden;display:none;"><bean:write name="rstl" property="pfio" filter="true"/></td>
<td style="visibility:hidden;display:none;"><bean:write name="rstl" property="poscode" filter="true"/></td>
<td style="visibility:hidden;display:none;"><bean:write name="rstl" property="posid" filter="true"/></td>
<td style="visibility:hidden;display:none;"><bean:write name="rstl" property="posname" filter="true"/></td>
                <td class="text"><bean:write name="rstl" property="expedition" filter="true"/></td>
                <td class="text"><bean:write name="rstl" property="posname" filter="true"/> <bean:write name="rstl" property="posid" filter="true"/></td>
                <td class="text"><logic:present name="rstl" property="so.divisionRequester"><bean:write name="rstl" property="so.divisionRequester.name" filter="true"/></logic:present></td>
            </tr>
	</logic:present>
          
	<logic:notPresent name="rstl">
            <tr class="normal">
                <td class="text" colspan="<%= gColSpan %>"><bean:message key="label.norecords"/></td>
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
