<%@ page language="java" %>
<%@ page import="com.hps.july.persistence.*"%>
<%@ page import="com.hps.july.sitedoc.valueobject.SiteDocObject"%>
<%@ page import="com.hps.july.sitedoc.formbean.SiteDocForm"%>
<%@ page import="java.util.*"%>
<%@ page import="com.hps.july.sitedoc.valueobject.*"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<%
//String gColSpan = "7";
String gColSpan = request.getAttribute("colspan")+"";
DocObjectDef odef = DocObjectDef.getDef(session);
%>

<!-- Table header -->

<tr class="title">
   <TD class="title">&nbsp;</TD>
   <july:headercolumn key="SiteDocList.blankdate" colType="string"/>
   <july:headercolumn key="SiteDocList.blanknumber" colType="string"/>
   <july:headercolumn key="SiteDocList.siteDocType" colType="string"/>
   <july:headercolumn key="SiteDocList.expiredate" colType="string"/>
   <july:headercolumn key="SiteDocList.comment" colType="string"/>
   <july:headercolumn key="SiteDocList.files" colType="string"/>
   <TD class="title">&nbsp;</TD>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->

<logic:iterate id="sitedoc" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="sitedoc">
<%
	int sd = ((Number)sitedoc.getColumn("sitedoc").asObject()).intValue();
	boolean isnotetap = sitedoc.getColumn("etapdocid").asObject() == null;
%>

<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
<td class="text">
<%
	if(isnotetap) {
		String action=odef.isCanModify()?"Edit":"View";
%><july:editbutton page='<%="/EditSiteDoc.do?sitedoc="+sd%>' action="<%=action%>"  /><%
	}
%>
</td>
<td class="link"><july:datewrite name="sitedoc" property="blankdate"/></td>
<td class="text"><july:stringwrite name="sitedoc" property="blanknumber"/></td>
<td class="text"><july:stringwrite name="sitedoc" property="sitedoctypename"/></td>
<td class="text"><july:datewrite name="sitedoc" property="expiredate"/></td>
<td class="text"><july:stringwrite name="sitedoc" property="comment"/></td>
<td class="text">
<%
SiteDocFileAccessBean fb=new SiteDocFileAccessBean();
Enumeration enum=null;
try {
	enum=fb.findBySitedocsOrderByPKAsc(new Integer(sd));
	if(enum == null) {
		throw new Exception();
	}
} catch(Exception e) {
	enum=new Vector().elements();
}
pageContext.setAttribute("fileList",enum);
%>

<logic:iterate name="fileList" id="file" >
	<logic:present name="file" property="sitedocfilename" >
	<%
		if(((SiteDocFileAccessBean)file).getSiteDoc().getSitedoc() == sd) {
	%>
		<html:link page="/OpenFile.do" target="_blank" paramId="sitedocfile" paramName="file" paramProperty="sitedocfile">
			<bean:write name="file" property="sitedocfilename"  />
		</html:link>
	<%
		}
	%>
	</logic:present>
</logic:iterate>
</td>

<td class="link">
<%
if(odef.isCanModify() && isnotetap) {
%>
<july:delbutton page='<%="/EditSiteDoc.do?action=Delete&sitedoc="+sd%>'  />
<%
}
%>
</td class="link">

</tr>

<july:separator colspan="<%= gColSpan %>" />

  </logic:present>

</logic:iterate>


