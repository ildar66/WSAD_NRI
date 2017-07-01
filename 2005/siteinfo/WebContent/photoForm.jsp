<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.siteinfo.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<script type="text/javascript" language="JavaScript">
<!--
function toList() {
	document.location.href="ShowPhotoList.do?storageplace="+<%=request.getParameter("storageplace")%>;
}
function upload(){
	document.body.style.cursor='wait';
	if (document.forms(0).elements('wasposted').value == 1) 
		{ alert('<bean:message key="add.photo.request"/>'); return false; }
	document.forms(0).elements('wasposted').value = 1;
	var result = document.all.uploadImg.upload
		(document.all.poscode.value, 
		document.all.photographerId.value,
		document.all.description.value,
		document.all.dateFrm.value,
		document.all.externalPhotographer.value,
		document.all.groupName1.value,
		'<%=request.getRemoteUser()%>');
	
	//document.location.href="ShowPhotoList.do?storageplace="+<%=request.getParameter("storageplace")%>;
	//else
	if(result != "OK") {
		alert(result);
	}
	document.forms(0).elements('wasposted').value = 0;
	document.body.style.cursor='auto';
	//document.all.description.value = '';
	//document.all.externalPhotographer.value = '';
	//document.all.photographerId.value = '';
}
function _onmouseout(){
document.body.style.cursor='auto';
}
function _onmouseover(){
document.body.style.cursor='hand';
}
-->
</script>

<july:editform action="/ProcessPhoto.do" enctype="multipart/form-data">

<table class="main">

<%--
    <tr class="title">
    	<td class="title" colspan="2">
		   <jsp:include page="/mapLinks.jsp" flush="true"></jsp:include>
           <july:sepmark/> 
           <html:link page="/EditPosition.do?action=View" paramId="storageplace" paramName="PhotoForm" paramProperty="poscode" styleClass="navigator"><bean:message key="label.workresponsibility.position"/></html:link> 
           <july:sepmark/> 
           <html:link page="/ShowPhotoList.do" styleClass="navigator"><bean:message key="label.photos"/></html:link>
           <july:sepmark/> 
           <july:actionname/></td>
    </tr>
    
    <july:separator/>
--%>
	<logic:equal name="PhotoForm" property="sunJavaVersion" value="false">
		<july:formbuttons/>   
	</logic:equal>
    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>
    
    <july:separator/>
    
    <%-- tr>
        <td class="text"><july:reqmark><bean:message key="label.code"/>:</july:reqmark></td>
        <td>
           <july:string property="photo" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/ --%>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.photo.posname"/>:</july:reqmark></td>
        <td>
			<html:hidden property="photo"/>
			<html:hidden property="poscode"/>
          <%-- july:string property="poscode" styleId="poscode" size="5" insertable="false" updatable="false" / --%>
          <july:string size="10" property="posid" styleId="posid"  insertable="false" updatable="false" />
          <july:string size="35" property="posname" styleId="posname"  insertable="false" updatable="false" />
          <%-- july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="poscode;posid;posname" insertable="false" updatable="false" / --%>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.photo.date"/>:</july:reqmark></td>
        <td>
           <july:date property="dateFrm" insertable="true" updatable="true" />
		   
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.photo.description"/>:</july:reqmark></td>
        <td>
           <july:textarea property="description" cols="50" rows="2" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
<logic:equal name="PhotoForm" property="sunJavaVersion" value="false">
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.photo.filename"/>:</july:reqmark></td>
        <td>
           <html:file property="imageFrm" size="35" styleClass="editsmall"/>
           <july:string property="filename" size="35" insertable="false" updatable="false"/>
        </td>
    </tr>
</logic:equal>
<logic:equal name="PhotoForm" property="sunJavaVersion" value="true">
    <tr>
		<td class="text"><july:reqmark><bean:message key="label.photo.filename"/>:</july:reqmark></td>
        <td>
		<applet
		code="com/hps/july/siteinfo/applets/UploadImg.class"
		ARCHIVE="/applets/up.jar"
		name="uploadImg"
		width=510
		height=100 >
		<param name=servletPath value="appletPhotos">
		<param name=background value="FFFFFF">
		<param name=foreground value="000000">
	</applet>
		</td>
    </tr>
</logic:equal>
    
    <july:separator/>
<tr>
        <td class="text"><bean:message key="label.photo.photographer"/></td>
        
		<td><july:string property="photographerId" styleId="photographerId" size="5" insertable="true" updatable="true" />
    	
		<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="r1l" fieldNames="photographerId;photographerName" onclick="set_opt_params_r1l('?photographerId='+document.all.photographerId.value)" insertable="true" updatable="true" />
    	<july:string size="33" property="photographerName" styleId="photographerName" insertable="false" updatable="false" /></td>
</tr>
    <july:separator/>
	<tr>
			<script><!--
				function onChangeGrp(elem) {
					var grp = document.getElementById('groupName1');
					grp.value = elem.options[elem.selectedIndex].value;
				}
			-->
			</script>
        	<td class="text">Группы</td>
	        <td colspan="4">
			<july:string size="10" property="groupName1" styleId="groupName1" insertable="true" updatable="true" />
			<july:select collection="groupNames" property="groupName" insertable="true" updatable="true" onchange="onChangeGrp(this)">
			    <html:option value="">_______________</html:option>
		        <july:options collection="groupNames" property="gn" labelProperty="gn" />
		    </july:select>
			</td>
	</tr>
    <july:separator/>
	<tr>
        	<td class="text">Внештатный фотограф</td>
		<td>
			<july:string size="30" property="externalPhotographer" styleId="externalPhotographer" insertable="true" updatable="true" />
		</td>
	</tr>
<july:separator/>

<logic:equal name="PhotoForm" property="sunJavaVersion" value="false">
    <july:formbuttons/>   
</logic:equal>
<logic:equal name="PhotoForm" property="sunJavaVersion" value="true">
    <TR class="title"><TD colspan="2"><IMG SRC="/images/save.gif" ALT='<bean:message key="img.save"/>' onclick="upload()" BORDER=0 onMouseOver="_onmouseover()" onMouseOut="_onmouseout()">&nbsp;<A ID="ResetButton" HREF='#'><IMG SRC="/images/restore.gif" onclick="document.forms(0).reset()" ALT='<bean:message key="img.canceledit"/>' border=0></A>&nbsp;<A HREF='ShowPhotoList.do' TITLE='<bean:message key="img.calcel"/>'><IMG SRC="/images/cancel.gif" ALT="Отказ и возврат" onclick="document.body.style.cursor='wait';" BORDER=0></A></TD></TR>   
</logic:equal>

<%--
	<july:separator/>
    
	<tr class="title">
    	<td class="title" colspan="2">
		   <jsp:include page="/mapLinks.jsp" flush="true"></jsp:include>
           <july:sepmark/> 
           <html:link page="/EditPosition.do?action=View" paramId="storageplace" paramName="PhotoForm" paramProperty="poscode" styleClass="navigator"><bean:message key="label.workresponsibility.position"/></html:link> 
           <july:sepmark/> 
           <html:link page="/ShowPhotoList.do" styleClass="navigator"><bean:message key="label.photos"/></html:link>
           <july:sepmark/> 
           <july:actionname/></td>
    </tr>
    <july:separator/>

--%>

</table>

</july:editform>

