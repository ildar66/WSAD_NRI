<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessPeople.do">

<html:hidden property="initialState"/>

<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
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
			        <td class="text" colspan="2"><july:reqmark><bean:message key="label.code"/>:</july:reqmark></td>
			        <td>
			          <july:string property="man" size="5" insertable="false" updatable="false" />
			        </td>
			    </tr>
			    
			    <july:separator colspan="3"/>
			    
			    <tr>
			        <td class="text" colspan="2"><july:reqmark><bean:message key="label.people.lastname"/>:</july:reqmark></td>
			        <td>
			          <july:string property="lastname" size="25" insertable="true" updatable="true" />
			        </td>
			    </tr>
			    
			    <july:separator colspan="3"/>
			    
			    <tr>
			        <td class="text" colspan="2"><july:reqmark><bean:message key="label.people.firstname"/>:</july:reqmark></td>
			        <td>
			          <july:string property="firstname" size="25" insertable="true" updatable="true" />
			        </td>
			    </tr>
			    
			    <july:separator colspan="3"/>
			    
			    <tr>
			        <td class="text" colspan="2"><july:reqmark><bean:message key="label.people.middlename"/>:</july:reqmark></td>
			        <td>
			          <july:string property="middlename" size="25" insertable="true" updatable="true" />
			        </td>
			    </tr>
			    
			    <july:separator colspan="3"/>
			    
			    <tr>
			        <td class="text" width="11%"><july:reqmark><bean:message key="label.people.passport"/>:</july:reqmark></td>
					<td class="text" width="30%"><bean:message key="label.people.passport.ser"/></td>
			        <td><july:string property="passportser" size="25" insertable="true" updatable="true"/></td>
			    </tr>
			    
			    <tr>
			        <td class="text">&nbsp;</td>
					<td class="text"><bean:message key="label.people.passport.date"/></td>
			        <td><july:date property="passportDateFrm" size="25" insertable="true" updatable="true" required="false"/></td>
			    </tr>
				
			    <tr>
					<td class="text">&nbsp;</td>
					<td class="text"><bean:message key="label.people.passport.whom"/></td>
			        <td><july:string property="passportWhom" size="25" insertable="true" updatable="true"/></td>
			    </tr>
				
				<july:separator colspan="3"/>
				
			    <tr>
			        <td class="text" colspan="2"><july:reqmark><bean:message key="label.people.isactive"/>:</july:reqmark></td>
			        <td>
						<DIV class="edit"><july:radio property="isActive" insertable="true" updatable="true" value="true"><bean:message key="label.people.isactive.enabled"/></july:radio></DIV>
						<DIV class="edit"><july:radio property="isActive" insertable="true" updatable="true" value="false"><bean:message key="label.people.isactive.disabled"/></july:radio></DIV>
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
