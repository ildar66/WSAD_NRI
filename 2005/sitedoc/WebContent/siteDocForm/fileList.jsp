<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.persistence.*,com.hps.july.jdbcpersistence.lib.*"%>
<%@ page import="com.hps.july.sitedoc.formbean.SiteDocForm"%>
<%@ page import="com.hps.july.sitedoc.valueobject.*"%>

<%
String colspan="6";
String addFileAction="/EditSiteDocFile.do?action=Add";
String delSelectedFilesAction="/DeleteSiteDocFileList.do";

//Site Doc List Form lForm=(Site Doc List Form)pageContext.findAttribute("Site Doc List Form");
DocObjectDef odef = DocObjectDef.getDef(session);
%>
<table class="main" id="brtable" width='100%' height='100%'>
<FORM id=delFileListForm name=delFileListForm action='<%=AppConstants.BASE_SITEDOC+delSelectedFilesAction%>' method=post>

<tr class="title">
<td class="title" colspan=<%=colspan%>>

<bean:message key="FileList.header"/>:&nbsp;

<%if(odef.isCanModify()){%>
<html:link page="<%=addFileAction%>" >
<img alt='<bean:message key="label.add"/>' src="/images/plus.gif" border=0/>
</html:link>
&nbsp;
<input onclick='return confirm(<bean:message key="FileList.confirm.delete" />);'  type=image alt='<bean:message key="FileList.alt.del"/>'
   src='/images/del_marked.gif' name=submit/>
<%}%>

</td>
</tr>


<tr class="title">
<td>&nbsp;</td>
<july:headercolumn key="FileList.order" colType="string"/>
<july:headercolumn key="FileList.filename" colType="string"/>
<july:headercolumn key="FileList.comment" colType="string"/>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>


<logic:iterate id="file" name="SiteDocForm" property="files">
<logic:present name="file">
<%
	int i=1;
//SiteDocFileAccessBean bean=(SiteDocFileAccessBean) pageContext.getAttribute("file");
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

<td class="link">
<%if(odef.isCanModify()) {%>
<july:editbutton page="/EditSiteDocFile.do" action="Edit" paramId="sitedocfile" paramName="file" paramProperty="sitedocfile" />
<%}%>
</td>

<td class="number">
<%=i++%>
</td>

<td class="link">
<logic:present name="file" property="sitedocfilename" >
	<html:link page="/OpenFile.do" target="_blank" paramId="sitedocfile" paramName="file" paramProperty="sitedocfile">
		<bean:write name="file" property="sitedocfilename"  />
	</html:link>
</logic:present>
</td>

<td class="text">
	<logic:present name="file" property="note">
		<bean:write name="file" property="note" filter="true"/>
	</logic:present>
</td>

<td class="link">
<%if(odef.isCanModify()){%>
	<input type=checkbox class=editcheckbox value='<bean:write name="file" property="sitedocfile"/>' name='check_del'  />
<%}%>
</td>

<td class="link" >
<%if(odef.isCanModify()){%>
 <july:delbutton page="/EditSiteDocFile.do?action=Delete" paramId="sitedocfile" paramName="file" paramProperty="sitedocfile" />
<%}%>
</td>

</tr>

</logic:present>
</logic:iterate>
</FORM>
</table>

