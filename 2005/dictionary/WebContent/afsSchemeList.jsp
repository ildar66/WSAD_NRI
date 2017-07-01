<%@ page language="java" %>
<%@ page contentType="TEXT/HTML; charset=windows-1251" %>
<%@ page import = "com.hps.july.dictionary.valueobject.AfsSchemeRow" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "18"; %>

<july:browseform action="/ShowAfsSchemeList.do" styleId="AfsSchemeListForm">

<table class="main">

<july:separator colspan="<%= gColSpan %>"/>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<TABLE class="buttons">
	<TR class="title">
		<TD class="buttons">
			<july:addbutton page="/EditAfsScheme.do?action=Add"/>
			<july:backbutton/>
		</TD>
		<TD class="navigator">
			<july:navigator/>
		</TD>
	</TR>
	</TABLE>
	</TD>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="title">
	<td>&nbsp;</td>
	<td class="smallheader"><bean:message key="label.afsscheme.numscheme"/></td>
	<td class="smallheader"><bean:message key="label.afsscheme.sectcount900"/></td>
	<td class="smallheader"><bean:message key="label.afsscheme.sectcount1800"/></td>
	<td class="smallheader"><bean:message key="label.afsscheme.antX2"/></td>
	<td class="smallheader"><bean:message key="label.afsscheme.antX4"/></td>
	<td class="smallheader"><bean:message key="label.afsscheme.antV1.short"/></td>
	<td class="smallheader"><bean:message key="label.afsscheme.antV2.short"/></td>
	<td class="smallheader"><bean:message key="label.afsscheme.dbc1"/></td>
	<td class="smallheader"><bean:message key="label.afsscheme.dbc2"/></td>
	<td class="smallheader"><bean:message key="label.afsscheme.df1"/></td>
	<td class="smallheader"><bean:message key="label.afsscheme.df2"/></td>
	<td class="smallheader"><bean:message key="label.afsscheme.tma.short"/></td>
	<td class="smallheader"><bean:message key="label.afsscheme.jo"/></td>
	<td class="smallheader"><bean:message key="label.afsscheme.ji"/></td>
	<td class="smallheader"><bean:message key="label.afsscheme.con"/></td>
	<td class="smallheader"><bean:message key="label.afsscheme.notes"/></td>
	<td>&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>


<logic:iterate id="it" name="browseList">
	<logic:present name="it">

		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="link"><july:editbutton page="/EditAfsScheme.do" action="Edit" paramId="schemeid" paramName="it" paramProperty="schemeid" paramScope="page"/></td>
			<td class="text"><july:stringwrite name="it" property="numscheme"/></td>
			<td class="number"><july:stringwrite name="it" property="sectcount900"/></td>
			<td class="number"><july:stringwrite name="it" property="sectcount1800"/></td>
			<td class="number"><july:stringwrite name="it" property="antX2"/></td>
			<td class="number"><july:stringwrite name="it" property="antX4"/></td>
			<td class="number"><july:stringwrite name="it" property="antV1"/></td>
			<td class="number"><july:stringwrite name="it" property="antV2"/></td>
			<td class="number"><july:stringwrite name="it" property="dbc1"/></td>
			<td class="number"><july:stringwrite name="it" property="dbc2"/></td>
			<td class="number"><july:stringwrite name="it" property="df1"/></td>
			<td class="number"><july:stringwrite name="it" property="df2"/></td>
			<td class="number"><july:stringwrite name="it" property="tma"/></td>
			<td class="number"><july:stringwrite name="it" property="jo"/></td>
			<td class="number"><july:stringwrite name="it" property="ji"/></td>
			<td class="number"><july:stringwrite name="it" property="con"/></td>
			<td class="text"><july:stringwrite name="it" property="notes"/></td>
			<td class="link"><july:delbutton page="/EditAfsScheme.do?action=Delete" paramId="schemeid" paramName="it" paramProperty="schemeid" paramScope="page"/></td>
		</tr>
		<july:separator colspan="<%= gColSpan %>"/>
	</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<TABLE class="buttons">
	<TR class="title">
		<TD class="buttons">
			<july:addbutton page="/EditAfsScheme.do?action=Add"/>
			<july:backbutton/>
		</TD>
		<TD class="navigator">
			<july:navigator/>
		</TD>
	</TR>
	</TABLE>
	</TD>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:browseform>
