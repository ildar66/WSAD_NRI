<%@page language = "java" %>

<%@page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/july.tld" prefix="july" %>



<july:editform action="/PrintEPosition.do">



<table class="main">

    <tr class="title">

    	<td class="title" colspan="2">

          <july:closebutton page="/"/>

          <july:printerbutton/> 

        </td>

    </tr>

    

    <july:separator/>

    

    <TR class="printable">

    <TD class="printable">

    

        <table class="print">

        <tr class="print">

            <td class="print">1</td>

            <td class="print"><bean:message key="print.eposition.posname"/></td>

            <td class="print" style="font-weight: bold">

               <bean:write name="EPositionPrintForm" property="posid"/>&nbsp;&nbsp;&nbsp;<bean:write name="EPositionPrintForm" property="posname"/>

            </td>

        </tr>

        

        <tr class="print">

            <td class="print">2</td>

            <td class="print"><bean:message key="print.eposition.address"/>:</td>

            <td class="print">

              <bean:write name="EPositionPrintForm" property="posAddr" filter="true" />

            </td>

        </tr>

        

        <tr class="print">

            <td class="print">3</td>

            <td class="print"><bean:message key="print.eposition.contactphones"/>:</td>

            <td class="print">

              <bean:write name="EPositionPrintForm" property="contactPhonest" filter="true" />

            </td>

        </tr>

                

        <tr class="print">

            <td class="print">4</td>

            <td class="print"><bean:message key="print.eposition.pathtype"/>:</td>

            <td class="print">

              <bean:write name="EPositionPrintForm" property="pathType" filter="true" />

            </td>

        </tr>

        

        <tr class="print">

            <td class="print">5</td>

            <td class="print"><bean:message key="print.eposition.equipmentplaces"/>:</td>

            <td class="print">

              <bean:write name="EPositionPrintForm" property="equipmentPlaces" filter="true" />

            </td>

        </tr>

        

        <tr class="print">

            <td class="print">6</td>

            <td class="print"><bean:message key="print.eposition.engeneering"/>:</td>

            <td class="print">

              <bean:write name="EPositionPrintForm" property="engenering" filter="true" />

            </td>

        </tr>

        

        <tr class="print">

            <td class="print">7</td>

            <td class="print"><bean:message key="print.eposition.details"/>:</td>

            <td class="print">

              <bean:write name="EPositionPrintForm" property="details" filter="true" />

            </td>

        </tr>

            

        <logic:present name="browseList">

          <% int iNum = 8; %>

            <logic:iterate id="wrs" name="browseList">

                <logic:present name="wrs">

                <logic:equal name="wrs" property="type.isPrint" value="true">

                    <tr class="print">

                        <td class="print"><%= iNum++ %></td>

                        <td class="print"><bean:write name="wrs" property="type.name" filter="true"/>:</td>

                        <td class="print">&nbsp;
						<logic:present name="wrs" property="worker">

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
						  </logic:present>
                        </td>

                    </tr>

        

                  </logic:equal>

        	      </logic:present>

              </logic:iterate>

        </logic:present>

        

        

    </TABLE>

    </TD>

    </TR>

    

    <july:separator/>

    

    <tr class="title">

    	<td class="title" colspan="2">

          <july:closebutton page="/"/>

          <july:printerbutton/> 

        </td>

    </tr>

    

    <july:separator/>

    

</table>





</july:editform>



