<%@ page language = "java" %>
<%@ page import="com.hps.july.persistence.*,
                                  com.hps.july.basestation.formbean.AntennaForm,
                 com.hps.july.basestation.formbean.SectorForm,
                 com.hps.july.basestation.formbean.FactBaseStationForm"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<% String gColSpan = "2";
FactBaseStationForm dForm=(FactBaseStationForm)pageContext.findAttribute("FactBaseStationForm");
    boolean hasAntennes=dForm.hasAntennes();
    boolean hasSectors=dForm.hasSectors();
    boolean hasDocuments=dForm.hasDocuments();
    boolean hasLinks=hasAntennes||hasSectors||hasDocuments;
%>

<tr>

<td class="title" colspan="2">

 <%if(hasAntennes){%>
<FONT class="attention"><B>
 <bean:message key="BaseStationForm.warning.hasAntennes" />
</B></FONT>
  <br>
<%}%>

<%if(hasSectors){%>
<FONT class="attention"><B>
 <bean:message key="BaseStationForm.warning.hasSectors" />
</B></FONT>
  <br>
<%}%>

<%if(hasDocuments){%>
<FONT class="attention"><B>
 <bean:message key="BaseStationForm.warning.hasDocuments" />
</B></FONT>
  <br>
<%}%>

<%if(hasLinks){%>
<FONT class="attention"><B>
<bean:message key="confirm.delete" />
 </B></FONT>

 <%}%>


     </td>
</tr>





