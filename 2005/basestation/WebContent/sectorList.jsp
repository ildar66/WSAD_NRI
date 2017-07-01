<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.basestation.formbean.FactBaseStationForm" %>
<%@ page import="com.hps.july.basestation.formbean.AntennaSectorListForm" %>
<%@ page import="com.hps.july.basestation.valueobject.*" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport" %>
<%@ page import="com.hps.july.apptags.HasRegionAccessTag" %>
<%@ page import="com.hps.july.apptags.HasAccessTag" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks" %>

<%!
private String[] dampsLett = { "O", "A", "B", "C", "D", "E", "F", "G", "", "" };
private String[] gsmLett = { "O", "A", "B", "C", "D", "E", "F", "G", "H", "O" };
%>
<%
	String colspan="9";

	boolean canEdit=false;

	String add_link=null;
	String del_link=null;
	String edit_link=null;
	String proc_link=null;

	String bscodeFrm = "";
	String formname = "";
	String stationType = "";
	String bsNumber = "";

	if(session.getAttribute("returnFormName").equals("FactBaseStationForm")) {
		formname = "FactBaseStationForm";
		FactBaseStationForm frm = (FactBaseStationForm)session.getAttribute(formname);
		stationType = frm.getStationType();
		bsNumber = frm.getNumberFrm();
		bscodeFrm = String.valueOf(frm.getBasestation());
		add_link="/EditSector_FBS.do?action=Add&bscodeFrm="+bscodeFrm.trim();
		del_link="/EditSector_FBS.do?action=Delete";
		edit_link="/EditSector_FBS.do";
		proc_link="/ProcessSector_FBS.do";
		canEdit = true; //frm.canEditFact(request.getRemoteUser());
	} else if(session.getAttribute("returnFormName").equals("AntennaSectorListForm")) {
		formname = "AntennaSectorListForm";
		AntennaSectorListForm frm = (AntennaSectorListForm)session.getAttribute(formname);
		stationType = frm.getBsForm().getStationType();
		bsNumber = frm.getBsForm().getNumberFrm();
		bscodeFrm = String.valueOf(frm.getBsForm().getBasestation());
		add_link="/EditSector_E.do?action=Add&bscodeFrm="+bscodeFrm.trim();
		del_link="/EditSector_E.do?action=Delete";
		edit_link="/EditSector_E.do";
		proc_link="/ProcessSector_E.do";
		canEdit = true;
	}
	boolean canEditRole = HasAccessTag.hasAccess(pageContext,proc_link);
	
	canEdit = canEdit && canEditRole;
%>

<table class="main" id="brtable">
<tr class="title">
	<td class="title" colspan=<%=colspan%>>
		<%if(canEdit) {%><html:link page="<%=add_link%>"><img alt='<bean:message key="label.add"/>' src="/images/plus.gif" border=0/></html:link><%}%>
		&nbsp;&nbsp;<bean:message key="label.sectors"/>
	</td>
</tr>

<tr class="title">
	<td>&nbsp;</td>
	<td class="title">CellID</td>
	<td class="title">LAC</td>
	<td class="title">CellName</td>
<!--	<july:headercolumn key="Sector.numsect" colType="string"/> -->
	<july:headercolumn key="Sector.namesect" colType="string"/>
	<july:headercolumn key="Sector.band" colType="string"/>
	<july:headercolumn key="Sector.trxnum" colType="string"/>
	<july:headercolumn key="Sector.btsnumber" colType="string"/>
	<td>&nbsp;</td>
</tr>

<logic:iterate id="sec" name="<%=formname%>" property="sectors" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="sec">
<%
	pageContext.setAttribute("idsect",sec.getColumn("id_sect").asString());
	Object o = sec.getColumn("lac").asObject();
	String lac = "";
	if(o != null) {	
		int l = ((Integer)o).intValue();
		lac += l;
		lac += "/";
		lac += LACConverter.toHex(l);
		lac += "/";
		lac += LACConverter.toHdx(l);
	}
	String num = sec.getColumn("num_sect").asString();
	String lett;
	String name = sec.getColumn("name_sect").asString();
	if(name != null) { name = name.trim(); } else { name = ""; }
	if(num != null && num.length() > 0) { lett = String.valueOf(num.charAt(num.length()-1)); } else { lett = ""; }
	String cellname = bsNumber + lett;
	try {
		int i = Integer.parseInt(lett);
		if("D".equals(stationType)) {
			lett = dampsLett[i];
		} else {
			lett = gsmLett[i];
		}
	} catch(Exception e) {
		lett = null;
	}
	
	pageContext.setAttribute("lac",lac);
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="link">
		<%if(canEdit) {%>
			<july:editbutton page="<%=edit_link%>" action="Edit" paramId="idsect" paramName="idsect" />
		<%} else {%>
			<july:editbutton page="<%=edit_link%>" action="View" paramId="idsect" paramName="idsect" />
		<%}%>
	</td>
	<td class="number"><july:stringwrite name="sec" property="num_sect"/></td>
	<td class="number"><july:stringwrite name="lac"/></td>
	<td class="number"><%=cellname%></td>
	<td class="text"><july:stringwrite name="sec" property="name_sect"/></td>
	<td class="number"><july:stringwrite name="sec" property="band"/></td>
	<td class="text"><july:stringwrite name="sec" property="trxstring"/></td>
	<td class="text"><july:stringwrite name="sec" property="btsnumber"/></td>
	<td class="link" ><%if(canEdit){%><july:delbutton page="<%=del_link%>" paramId="idsect" paramName="idsect" /><%}%>
	</td>
	</tr>
</logic:present>
</logic:iterate>

</table>
