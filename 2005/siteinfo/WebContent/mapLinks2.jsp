<%@ page language = "java" %>
<%@ page import="org.apache.struts.taglib.html.*,org.apache.struts.util.*,com.hps.july.web.util.EditForm,com.hps.july.siteinfo.formbean.PositionForm" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<TR class="title"><TD colspan="2">
<%
String map = (String)session.getAttribute("mapState");
String mapbyPosition = (String)session.getAttribute("mapbyPositionState");
Object valueAction =  RequestUtils.lookup(pageContext, Constants.BEAN_KEY, "action", "request");
if(map.equals("1")){
	if ("Delete".equals(valueAction)) {
	    	out.print("<INPUT TYPE=\"IMAGE\" NAME=\"submit\" SRC=\"/images/delconf.gif\" ALT=\"Удалить\">&nbsp;");
        } else if ("View".equals(valueAction)) {
	        // No additional buttons
        } else {	    
	    	out.print("<INPUT TYPE=\"IMAGE\" NAME=\"submit\" SRC=\"/images/save.gif\"  ALT=\"Сохранить\">&nbsp;");
	    	out.print("<A HREF='#'><IMG SRC=\"/images/restore.gif\" onclick=\"document.forms(0).reset()\" ALT=\"Отменить правку\" border=0></A>&nbsp;");
        }
	EditForm wrapForm = (EditForm)pageContext.getAttribute(Constants.BEAN_KEY, PageContext.REQUEST_SCOPE);
		if (wrapForm != null) {
			if("View".equals(valueAction)){
				out.print("<A HREF='" + "/siteinfo/PositionListMap.do?imageFromCache=true" + "' TITLE=\"Отказ и возврат\"><IMG SRC=\"/images/cancel.gif\" ALT=\"Отказ и возврат\" BORDER=0></A>");
			} else {
				out.print("<A HREF='" + "/siteinfo/EditPosition.do?action=View" + "' TITLE=\"Отказ и возврат\"><IMG SRC=\"/images/cancel.gif\" ALT=\"Отказ и возврат\" BORDER=0></A>");
			}
		} else {
		    out.print("<INPUT TYPE=\"IMAGE\" NAME=\"org.apache.struts.taglib.html.CANCEL\" SRC=\"/images/cancel.gif\" ALT=\"Отказ и возврат\">");
		}
} else if(mapbyPosition.equals("1")){
	if ("Delete".equals(valueAction)) {
	    	out.print("<INPUT TYPE=\"IMAGE\" NAME=\"submit\" SRC=\"/images/delconf.gif\" ALT=\"Удалить\">&nbsp;");
        } else if ("View".equals(valueAction)) {
	        // No additional buttons
        } else {	    
	    	out.print("<INPUT TYPE=\"IMAGE\" NAME=\"submit\" SRC=\"/images/save.gif\"  ALT=\"Сохранить\">&nbsp;");
	    	out.print("<A HREF='#'><IMG SRC=\"/images/restore.gif\" onclick=\"document.forms(0).reset()\" ALT=\"Отменить правку\" border=0></A>&nbsp;");
        }
	EditForm wrapForm = (EditForm)pageContext.getAttribute(Constants.BEAN_KEY, PageContext.REQUEST_SCOPE);
		if (wrapForm != null) {
			if("View".equals(valueAction)){
				out.print("<A HREF='" + "/siteinfo/PositionOnmap.do?imageFromCache=true" + "' TITLE=\"Отказ и возврат\"><IMG SRC=\"/images/cancel.gif\" ALT=\"Отказ и возврат\" BORDER=0></A>");
			} else {
				out.print("<A HREF='" + "/siteinfo/EditPosition.do?action=View" + "' TITLE=\"Отказ и возврат\"><IMG SRC=\"/images/cancel.gif\" ALT=\"Отказ и возврат\" BORDER=0></A>");
			}
		} else {
		    out.print("<INPUT TYPE=\"IMAGE\" NAME=\"org.apache.struts.taglib.html.CANCEL\" SRC=\"/images/cancel.gif\" ALT=\"Отказ и возврат\">");
		}
} else {%>




<july:formbuttons/>

<%}%>
</TD></TR>