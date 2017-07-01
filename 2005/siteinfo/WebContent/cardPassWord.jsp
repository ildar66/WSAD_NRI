<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<jsp:useBean id="EPositionPrintForm" class="com.hps.july.persistence.PositionAccessBean" scope="request" />

<%
	String name = "";
	if (EPositionPrintForm.getDampsid() != null)
		name = "À" + EPositionPrintForm.getDampsid();
	if ( (EPositionPrintForm.getDampsid() != null) && (EPositionPrintForm.getGsmid() != null))
		name = name + "_";
	if (EPositionPrintForm.getGsmid() != null)
		name = name + "Ä" + EPositionPrintForm.getGsmid();

	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword; name=" + java.net.URLEncoder.encode(name+".doc") +";charset=windows-1251");
	response.setHeader ("Content-Disposition", "attachment; filename=cardpass.doc");
%>

<html>
<head>
 <META HTTP-EQUIV = "Pragma" CONTENT="no-cache">
 <meta http-equiv="Content-Type" content="application/msword; charset=Windows-1251">
 <title><bean:message key="label.siteinfo"/></title>
</head>
<body>

   <table border=1 cellspacing=0 cellpadding=0 width=633 align=center style='width:474.9pt;margin-left:3.5pt;border-collapse:collapse;mso-padding-alt:0cm 3.5pt 0cm 3.5pt'>
        <tr>
            <td>&nbsp;1&nbsp;</td>
            <td><bean:message key="print.eposition.posname"/></td>
            <td style="font-weight: bold">
               <bean:write name="EPositionPrintForm" property="name" />&nbsp;&nbsp;&nbsp;
			   <logic:present name="EPositionPrintForm" property="gsmid" />
					D<bean:write name="EPositionPrintForm" property="gsmid"/>&nbsp;&nbsp;
			   </logic:present>
			   <logic:present name="EPositionPrintForm" property="dampsid" />
					A<bean:write name="EPositionPrintForm" property="dampsid"/>&nbsp;&nbsp;
			   </logic:present>
            </td>
        </tr>        
        <tr>
            <td>&nbsp;2&nbsp;</td>
            <td><bean:message key="print.eposition.address"/>:</td>
            <td>
			<logic:present name="EPositionPrintForm" property="address"> 
              <bean:write name="EPositionPrintForm" property="address" filter="true" />
			</logic:present>
            </td>
        </tr>
        
        <tr>
            <td>&nbsp;3&nbsp;</td>
            <td><bean:message key="print.eposition.contactphones"/>:</td>
            <td>
              <bean:write name="blob" property="contactPhonest" filter="true" />
            </td>
        </tr>

		<tr>
            <td>&nbsp;4&nbsp;</td>
            <td><bean:message key="print.eposition.servicephones"/>:</td>
            <td>
              <bean:write name="blob" property="servicePhones" filter="true" />
            </td>
        </tr>
                
        <tr>
            <td>&nbsp;5&nbsp;</td>
            <td><bean:message key="print.eposition.pathtype"/>:</td>
            <td>
              <bean:write name="blob" property="pathType" filter="true" />
            </td>
        </tr>
        
        <tr>
            <td>&nbsp;6&nbsp;</td>
            <td><bean:message key="print.eposition.equipmentplaces"/>:</td>
            <td>
              <bean:write name="blob" property="equipmentPlaces" filter="true" />
            </td>
        </tr>
        
        <tr>
            <td>&nbsp;7&nbsp;</td>
            <td><bean:message key="print.eposition.engeneering"/>:</td>
            <td>
              <bean:write name="blob" property="engenering" filter="true" />
            </td>
        </tr>
        
        <tr>
            <td>&nbsp;8&nbsp;</td>
            <td><bean:message key="print.eposition.details"/>:</td>
            <td>
              <bean:write name="EPositionPrintForm" property="details" filter="true" />
            </td>
        </tr>

		<logic:present name="browseList">
          <% int iNum = 9; %>
            <logic:iterate id="wrs" name="browseList">
                <logic:present name="wrs">
				<logic:present name="wrs" property="worker">
                <logic:equal name="wrs" property="type.isPrint" value="true">
                    <tr class="print">
                        <td class="print"><%= iNum++ %></td>
                        <td class="print"><bean:write name="wrs" property="type.name" filter="true"/>:</td>
                        <td class="print">
                          <bean:write name="wrs" property="worker.man.fullName" filter="true"/><BR>
                          <bean:write name="wrs" property="worker.division.name" filter="true"/><BR>
                          <logic:present name="wrs" property="worker.phone1">
                             <bean:message key="print.eposition.phone1"/>:
                             <bean:write name="wrs" property="worker.phone1" filter="true"/><BR>
                          </logic:present>
                          <logic:present name="wrs" property="worker.phone2">
                             <bean:message key="print.eposition.phone2"/>:
                             <bean:write name="wrs" property="worker.phone2" filter="true"/><BR>
                          </logic:present>
                          <logic:present name="wrs" property="worker.localphone">
                             <bean:message key="print.eposition.localphone"/>:
                             <bean:write name="wrs" property="worker.localphone" filter="true"/><BR>
                          </logic:present>
                          <logic:present name="wrs" property="worker.fax">
                             <bean:message key="print.eposition.fax"/>:
                             <bean:write name="wrs" property="worker.fax" filter="true"/><BR>
                          </logic:present>
                          <logic:present name="wrs" property="worker.mobilephone">
                             <bean:message key="print.eposition.mobilephone"/>:
                             <bean:write name="wrs" property="worker.mobilephone" filter="true"/><BR>
                          </logic:present>
                        </td>
                    </tr>
        
                  </logic:equal>
        	      </logic:present>
				  </logic:present>
              </logic:iterate>
        </logic:present>

		<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
                 
    </TABLE>
</body>
</html>
