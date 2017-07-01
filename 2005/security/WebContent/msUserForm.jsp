<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessMSUsers.do">
<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="/ShowMSUsersList.do" styleClass="navigator"><bean:message key="label.menu.microstrategy.user"/></html:link>
           <july:sepmark/>
           <july:actionname/>
		</td>
    </tr>
    <july:separator colspan="2"/>
	<july:formbuttons/>
    <july:separator colspan="2"/>
    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>
    <july:separator colspan="2"/>
	<tr>
		<td colspan="2">
			<table class="main">
			    <tr>
			        <td class="text" colspan="2"><july:reqmark>Код :</july:reqmark></td>
			        <td>
			          <july:string property="msucode" size="5" insertable="false" updatable="false" />
			        </td>
			    </tr>
			    <july:separator colspan="3"/>
			    <tr>
			        <td class="text" colspan="2"><july:reqmark>Логин :</july:reqmark></td>
			        <td>
			          <july:string property="msuser" size="25" insertable="true" updatable="true" />
			        </td>
			    </tr>
			    <july:separator colspan="3"/>
			    <tr>
			        <td class="text" colspan="2"><july:reqmark>Пароль :</july:reqmark></td>
			        <td>
			          <july:string property="mspassword" size="25" insertable="true" updatable="true" />
			        </td>
			    </tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="2"/>
    <july:formbuttons/>
    <july:separator colspan="2"/>
</table>
</july:editform>
