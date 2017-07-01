<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*,org.apache.struts.action.Action"%>
<%@ page import="com.hps.july.persistence.*,com.hps.july.jdbcpersistence.lib.*"%>
<%@ page import="com.hps.july.sitedoc.formbean.SiteDocForm"%>
<%@ page import="com.hps.july.sitedoc.valueobject.*"%>


<%
String colspan="5";
DocObjectDef odef = DocObjectDef.getDef(session);
String addPositionAction="/ProcessPositionList.do";
String addEquipmentsAction="/ProcessEquipmentList.do";
String addComlineAction="/ProcessComlineList.do";
String delObjectListAction="/DeleteObjectList.do";
//String delObjectAction="/DeleteObject.do";
%>

<table class="main" id="brtable" width='100%' height='100%'>
<FORM id=delObjectListForm name=delFileListForm
      action='<%=AppConstants.BASE_SITEDOC+delObjectListAction%>' method=post>

<tr class="title">
<td class="title" colspan=<%=colspan%>>

<bean:message key="ObjectList.header"/>:&nbsp;

<%if(odef.isCanModify()){%>
<html:link page="<%=addPositionAction%>" >
<IMG alt='<bean:message key="ObjectList.alt.add.position"/>' src="/images/link3.gif" border=0/>
</html:link>

<html:link page="<%=addEquipmentsAction%>" >
<IMG alt='<bean:message key="ObjectList.alt.add.equipment"/>' src="/images/link2.gif" border=0/>
</html:link>

<html:link page="<%=addComlineAction%>" >
<IMG alt='<bean:message key="ObjectList.alt.add.comline"/>' src="/images/link4.gif" border=0/>
</html:link>

&nbsp;&nbsp;&nbsp;

<input onclick='return confirm(<bean:message key="confirm.delete.object.list"/>);'
   type=image alt='<bean:message key="ObjectList.alt.del"/>'
   src='/images/breaklinkmarked.gif' name=submit/>

<%}%>
</td>
</tr>


<tr class="title">

<july:headercolumn key="FileList.order" colType="string"/>
<july:headercolumn key="ObjectList.type" colType="string"/>
<july:headercolumn key="ObjectList.number_name" colType="string"/>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<%
	int i=1;
%>
<logic:iterate id="obj" name="SiteDocForm" property="objectList">
<logic:present name="obj">
<%
	LinkObject ob = (LinkObject)pageContext.getAttribute("obj");
%>

<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="number">
		<%=i++%>
	</td>
	<td class="text">
		<bean:write name="obj" property="linktype"/>
	</td>
	<td class="text">
		<bean:write name="obj" property="linkname"/>
	</td>
	<td class="link">
		<%if(odef.isCanModify()){%>
			<INPUT type=checkbox class=editcheckbox value='<%=ob.getObjecttype()%><%=ob.getObjectid()%>' name='check_del'/>
		<%}%>
	</td>
	<td class="link" >
	<%if(odef.isCanModify()){%>
	<%
		//String arg = ResponseUtils.filter(ob.getLinktype()+" "+ob.getLinkname());
		String arg = ob.getLinktype()+" "+ob.getLinkname();
		arg = arg.replace('"', '`');
		arg = arg.replace('\'', '`');
	%>
	<a href='/sitedoc/DeleteObject.do?objectId=<%=ob.getObjecttype()%><%=ob.getObjectid()%>' onclick='return confirm(<bean:message key="confirm.delete.object" arg0="<%=arg%>" />);'>
		<IMG alt='<bean:message key="ObjectList.alt.delone"/>' src="/images/breaklink2.gif" border=0/>
	</a>
	<%}%>
	</td>
</tr>
</logic:present>
</logic:iterate>
</FORM>
</table>

