<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.basestation.valueobject.*,com.hps.july.siteinfo.valueobject.*,com.hps.july.basestation.formbean.*,
                 com.hps.july.jdbcpersistence.lib.DebugSupport" %>

<%
    SectorForm form=(SectorForm)pageContext.findAttribute("SectorForm");
    boolean isFact=form.getBaseStation().getPosition().getPlanstate().equals(Position.PLANSTATE_CHECK_Fact);
    String bspage;
    if(isFact||form.getPath().indexOf("_E")>=0){
    bspage="/Edit_ViewFactBaseStation.do?action=View";
    }else{
    bspage="/Edit_ViewPlanBaseStation.do?action=View";
    }
%>
<tr class="title">
  <td class="title" colspan="2">
    <jsp:include page="/navigator.jsp" flush="true"/>
    <july:sepmark/>



<html:link page="<%=bspage%>"  styleClass="navigator">
Просмотр БС
</html:link>
<july:sepmark/>

<%  //DebugSupport.printlnTest("!!antennaForm navigatorTop.jsp isFact_ant="+isFact);
    //DebugSupport.printlnTest("!!antennaForm navigatorTop.jsp form_ant.getPath()="+form.getPath());
    if(form.getPath().indexOf("_E")>=0){%>
  <html:link page="/ShowAntennaSectorList.do" paramId="basestation" paramName="AntennaForm" paramProperty="baseStation.storageplace" styleClass="navigator">
Сектора и антенны
 </html:link>
<july:sepmark/>
<%}%>

<%String anPage_at=null;
  if(form.getPath().equals("/Edit_CopySector_FBS")){
    anPage_at="/EditSector_FBS.do?action=Edit";

  }else if (form.getPath().equals("/Edit_CopySector_PBS")){
     anPage_at="/EditSector_PBS.do?action=Edit";

  }else if (form.getPath().equals("/Edit_CopySector_E")){
    anPage_at="/EditSector_E.do?action=Edit";
  }
   if(anPage_at!=null){
%>
<html:link page="<%=anPage_at%>"  styleClass="navigator">
Сектор
</html:link>
<july:sepmark/>
<%}%>

<july:actionname/>&nbsp;<FONT class="attention"><B>сектор</B></FONT>

</td>
</tr>

<%--
<%
SectorForm form_snt=(SectorForm)pageContext.findAttribute("SectorForm");
boolean isFact_snt=form_snt.getBaseStation().getPosition().getPlanstate().equals(Position.PLANSTATE_CHECK_Fact);
String bspage2;
if(isFact_snt){
bspage2="/Edit_ViewFactBaseStation.do?action=View";
}else{
bspage2="/Edit_ViewPlanBaseStation.do?action=View";
}
%>
<tr class="title">
  <td class="title" colspan="2">
    <jsp:include page="/navigator.jsp" flush="true"/>
    <july:sepmark/>



<html:link page="<%=bspage2%>" paramId="basestation" paramName="SectorForm" paramProperty="baseStation.storageplace" styleClass="navigator">

Просмотр БС
</html:link>
<july:sepmark/>

<%if(isFact_snt&&form_snt.getPath().indexOf("_E")>=0){%>
  <html:link page="/ShowAntennaSectorList.do" paramId="basestation" paramName="SectorForm" paramProperty="baseStation.storageplace" styleClass="navigator">

Сектора и антенны
 </html:link>
<july:sepmark/>
<%}%>


<%String secPage_st=null;
  if(form_snt.getPath().equals("/Edit_CopySector_FBS")){
    secPage_st="/EditSector_FBS.do?action=Edit";

  }else if (form_snt.getPath().equals("/Edit_CopySector_PBS")){
     secPage_st="/EditSector_PBS.do?action=Edit";

  }else if (form_snt.getPath().equals("/Edit_CopySector_E")){
    secPage_st="/EditSector_E.do?action=Edit";
  }

   if(secPage_st!=null){
%>
  <html:link page="<%=secPage_st%>"  styleClass="navigator">

Сектор
 </html:link>
<july:sepmark/>
<%}%>


<july:actionname/>&nbsp;<FONT class="attention"><B>сектор</B></FONT>

</td>
</tr>
--%>
