<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.basestation.valueobject.*,com.hps.july.siteinfo.valueobject.*,com.hps.july.basestation.formbean.*" %>



<tr class="title">
  <td class="title" colspan="2">
    <html:link page="/BaseStationList.do" styleClass="navigator">
      <bean:message key="FactBaseStationForm.navigator.basestations"/>
    </html:link>
    <july:sepmark/>

<html:link page="/Edit_ViewFactBaseStation.do?action=View" styleClass="navigator">
Базовая станция
<%--
 <bean:message key="FactBaseStationForm.navigator.basestationview"/>
--%>
</html:link>
<july:sepmark/>
<html:link page="/ShowEquipmentList.do"  styleClass="navigator">
Сектора и антенны
<%--
 <bean:message key="FactBaseStationForm.navigator.basestationview"/>
--%>
</html:link>
<july:sepmark/>
<html:link page="/EditSector.do?action=Edit"  styleClass="navigator">
Сектор
<%--
 <bean:message key="FactBaseStationForm.navigator.basestationview"/>
--%>
</html:link>
<july:sepmark/>
выбор антенн


</td>
</tr>

