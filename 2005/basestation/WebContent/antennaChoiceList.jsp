<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.valueobject.*"%>
<%@ page import="com.hps.july.basestation.formbean.*"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%
	AntennesChoiceForm form=(AntennesChoiceForm)pageContext.findAttribute("AntennesChoiceForm");
	SectorForm sForm=(SectorForm)pageContext.findAttribute("SectorForm");
	DebugSupport.printlnTest("!!antennaChoiceList.jsp sForm.getPath()="+sForm.getPath());
	form.setReturnPage( sForm.getPath().substring(1)+".do");
	String link_action="/ProcessChoiceAntennes_FBS.do";
%>

<july:editform action="<%=link_action%>" >
<table class="main">
<july:separator />
<july:formbuttons/>
<july:separator />
<%@ include file="/antennaChoiceList/table.jsp"%>
<july:separator />
<july:formbuttons/>
<july:separator />
</table>



</july:editform>
