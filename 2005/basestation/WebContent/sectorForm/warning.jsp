<%@ page language = "java" %>
<%@ page import="com.hps.july.persistence.*,
                 com.hps.july.basestation.formbean.AntennaForm,
com.hps.july.basestation.formbean.SectorForm"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<% String gColSpan = "2";
   SectorForm dForm=(SectorForm)pageContext.findAttribute("SectorForm");
//   boolean hasAntennaLinks=dForm.hasAntennaLinks();
boolean hasAntennaLinks=false;// Нет такого метода MM 13.10.2003
%>

<tr>
     <td class="title" colspan="2">
 <%if(hasAntennaLinks){%>

<FONT class="attention"><B>
 <bean:message key="SectorForm.warning.hasAntennaLinks" />
</B></FONT>
  <br>
 <%}%>

<%if(hasAntennaLinks){%>
<FONT class="attention"><B>
<bean:message key="confirm.delete" />
 </B></FONT>

 <%}%>


     </td>
</tr>









