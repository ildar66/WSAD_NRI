<%@ page language = "java" %>
<%@ page import="com.hps.july.persistence.*"%>
<%--@ page import="com.hps.july.sitedoc.formbean.SiteDocTypeListForm"--%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%
	String gColSpan = request.getAttribute("colspan")+"";
//	SiteDocTypeListForm dForm=(SiteDocTypeListForm)pageContext.findAttribute("SiteDocTypeListForm");
%>

<tr class="title">
          <td colspan="<%= gColSpan %>">
          <TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
                 <alex:hasAccess href="/EditSiteDoc.do" >
                   <july:addbutton page="/EditSiteDocType.do?action=Add"/>
                 </alex:hasAccess>

                 <july:backbutton />
			  </TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE>
            </TD>
</tr>





