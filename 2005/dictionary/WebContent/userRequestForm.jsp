<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<SCRIPT language="javascript">
	function processFilialType() {
		if (document.all.filialtype.value=="1"){
	    	document.all.filialstring.style.display = 'block';
	    	document.all.filialstring.style.visibility = 'visible';
	    	document.all.regionstring.style.display = 'none';
	    	document.all.regionstring.style.visibility = 'hidden';
		} else if (document.all.filialtype.value=="2"){
	    	document.all.filialstring.style.display = 'none';
	    	document.all.filialstring.style.visibility = 'hidden';
	    	document.all.regionstring.style.display = 'block';
	    	document.all.regionstring.style.visibility = 'visible';
		} else if (document.all.filialtype.value=="3"){
	    	document.all.filialstring.style.display = 'none';
	    	document.all.filialstring.style.visibility = 'hidden';
	    	document.all.regionstring.style.display = 'none';
	    	document.all.regionstring.style.visibility = 'hidden';
		}
	}
</SCRIPT>

<july:editform action="/ProcessUserRequest.do">

<table class="main">

    <july:separator/>
    
	<july:formbuttons/>
    
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.userrequests.request"/>:</td>
        <td>
           <july:string property="request" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.userrequests.datetimein"/>:</td>
        <td>
          <july:date property="datetimeinFrm" size="25" insertable="false" updatable="false" styleId="commitDate"/>
        </td>
    </tr>
   
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.userrequests.requesttype"/></july:reqmark>:</td>
        <td>		    
		    <july:select collection="requestTypes" property="requesttype" insertable="true" updatable="true">
				<july:options collection="requestTypes" property="requesttype" labelProperty="name"/>
			</july:select>
        </td>
    </tr>
   
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.userrequests.filialtype"/></july:reqmark>:</td>
        <td>        	
			<july:select collection="filialTypes" property="filialtype" insertable="true" updatable="true"
			onchange="processFilialType()">
				<july:options collection="filialTypes" property="filialtype" labelProperty="name"/>
			</july:select>
        </td>
    </tr>
   
    <july:separator/>

    <tr id="filialstring">
        <td class="text"><july:reqmark><bean:message key="label.userrequests.filialid"/></july:reqmark>:</td>
        <td>        	
			<july:select collection="filials" property="regionidFrm" insertable="true" updatable="true">
				<july:options collection="filials" property="regionid" labelProperty="regname"/>
			</july:select>
        </td>
    </tr>
   
    <tr id="regionstring">
        <td class="text"><july:reqmark><bean:message key="label.userrequests.regionid"/></july:reqmark>:</td>
        <td>        	
			<july:select collection="regions" property="supregidFrm" insertable="true" updatable="true">
				<july:options collection="regions" property="supregid" labelProperty="supregname"/>
			</july:select>
        </td>
    </tr>
   
    <july:separator/>    

    <tr class="text">
	    <td class="text"><july:reqmark><bean:message key="label.userrequests.man"/></july:reqmark>:</td>
	    <td>
			<july:string property="worker" styleId="man" size="5" insertable="true" updatable="true"/>
			<july:lookupbutton action="dict/../inventory/ShowWorkerLookupList.do" styleId="workl" fieldNames="worker;workername;workertitle" newWindowName="workerlookup" insertable="true" updatable="true" />
			<july:string size="25" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
		</td>
	</tr>

    <july:separator/>

	<tr>
        <td class="text"><july:reqmark><bean:message key="label.userrequests.module"/></july:reqmark>:</td>
        <td>
			<july:select collection="nriModules" property="module" insertable="true" updatable="true">
				<july:options collection="nriModules" property="module" labelProperty="name"/>
			</july:select>
        </td>
    </tr>
   
    <july:separator/>

	<tr>
        <td class="text"><july:reqmark><bean:message key="label.userrequests.description"/></july:reqmark>:</td>
        <td><july:textarea property="description" cols="40" rows="7" insertable="true" updatable="true"/></td>
    </tr>
   
    <july:separator/>

	<tr>
        <td class="text"><july:reqmark><bean:message key="label.userrequests.status"/></july:reqmark>:</td>
        <td>
			<july:select collection="statuses" property="status" insertable="true" updatable="true">
				<html:options name="statuses"/>
			</july:select>
        </td>
    </tr>
   
    <july:separator/>

	<tr>
        <td class="text"><bean:message key="label.userrequests.rfcnum"/>:</td>
        <td>
			<july:string property="rfcnum" size="25" insertable="true" updatable="true" />        
		</td>
    </tr>
   
    <july:separator/>

    <july:formbuttons/>
    
    <july:separator/>
    
</table>

<script language="javascript">
processFilialType();
</script>

</july:editform>