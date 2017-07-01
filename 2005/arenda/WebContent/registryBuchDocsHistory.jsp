<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<july:editform action="/RegistryBuchDocsHistory.do">

<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
          <july:closebutton page="/"/>
          <july:printerbutton/> 
        </td>
    </tr>
    
    <july:separator/>

	<logic:present name="historyList">

    <TR class="printable">
		<TD class="printable" colspan="2">
			<table class="print" STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 8pt;">

				<!-- Table header -->
				<tr class="print" style="background-color: 'D6EBFF'">
					<td class="print" style="font-weight: bold">№ описи</td>
					<td class="print" style="font-weight: bold">Оператор</td>
					<td class="print" style="font-weight: bold">Время записи</td>
					<td class="print" style="font-weight: bold">Состояние</td>
				</tr>
				<!-- Table body -->
				<logic:iterate id="it" name="historyList">
					<logic:present name="it">
						<tr>
							<td class="print"><bean:write name="it" property="vo.idRegistryDoc" filter="true"/></td>
							<td class="print"><bean:write name="it" property="peopleName" filter="true"/></td>
							<td class="print"><july:datewrite name="it" property="vo.actionTime" showtime="true" showyear="true"/></td>
							<td class="print"><bean:write name="it" property="vo.state" filter="true"/></td>
		    	        </tr>
			</logic:present>
		</logic:iterate>	
		
	</table>
	    </TD>
    </TR>

	</logic:present>
    
    <july:separator/>
    
    <tr class="title">
    	<td class="title" colspan="2">
          <july:closebutton page="/"/>
          <july:printerbutton/> 
        </td>
    </tr>
    
</table>


</july:editform>



