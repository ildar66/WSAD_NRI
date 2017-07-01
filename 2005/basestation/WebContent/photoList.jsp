<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5"; %>

<july:browseform action="/ShowPhotoList.do" styleId="PosForm">

<script language="javascript">
function switchPhotographer(state) {
	if(state) {
		PosForm.photographerId.className = 'editkoddisabled';
		PosForm.photographerId.disabled = true;
	} else {
		PosForm.photographerId.className = 'editkodsearch';
		PosForm.photographerId.disabled = false;
	}
}
function switchDate() {
	if (!document.all.isDate[0].checked) {
        document.all.date1_dt.enabled = true;
		document.all.date2_dt.enabled = true;
	} else {
		document.all.date1_dt.enabled = false;
		document.all.date2_dt.enabled = false;
	}	
}
</script>

<table class="main">

<%-- DD

<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
	   <jsp:include page="/mapLinks.jsp" flush="true"></jsp:include>
	   <july:sepmark/> 
       <html:link page="/EditPosition.do?action=View" paramId="storageplace" paramName="PhotoListForm" paramProperty="storageplace" styleClass="navigator"><bean:message key="label.workresponsibility.position"/></html:link> 
       <july:sepmark/> 
       <july:currmark><bean:message key="label.photos"/></july:currmark></td>
</tr>
--%>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title" ><bean:message key="label.photo.posname"/>:</td>
       <td class="title" colspan="3"><bean:write name="PhotoListForm" property="posid" />&nbsp;&nbsp;&nbsp;<bean:write name="PhotoListForm" property="posname" /></td>
	   <td align="right"><july:searchbutton/></td>
	   
     </tr>        
<tr>
        <td class="text"><bean:message key="label.photo.date"/></td>
        <td>
		<july:checkbox property="isDate" styleId="isDate" insertable="true" updatable="true" onclick="switchDate()" />&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<bean:message key="label.photo.c"/></td>
		<td><july:date property="dateFrm1" insertable="true" updatable="true" styleId="date1"/></td>
		<td>&nbsp;&nbsp;<bean:message key="label.photo.po"/>&nbsp;&nbsp;</td>
		<td><july:date property="dateFrm2" insertable="true" updatable="true" styleId="date2"/></td>
</tr>
<tr>
        <td class="text"><bean:message key="label.photo.photographer"/></td>
        <td><july:checkbox property="isPhotographer" styleId="isPhotographer" insertable="true" updatable="true" onclick="switchPhotographer(document.all.isPhotographer[0].checked)" />&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;</td>

		<td colspan="3" class="title"><july:string property="photographerId" styleId="photographerId" size="5" insertable="true" updatable="true" />
    	&nbsp;
		<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="r1l" fieldNames="photographerId;photographerName" onclick="set_opt_params_r1l('?photographerId='+document.all.photographerId.value)" insertable="true" updatable="true" />&nbsp;&nbsp;
    	<july:string size="30" property="photographerName" styleId="photographerName" insertable="false" updatable="false" /></td>
</tr>
     </table>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditPhoto.do?action=Add"/><july:backbutton page="/EditPosition.do?action=View" paramId="storageplace" paramName="PhotoListForm" paramProperty="storageplace"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
        <july:headercolumn key="label.photo.date" colType="string"/>
		<july:headercolumn key="label.photo.photographer" colType="string"/>
        <july:headercolumn key="label.photo.description" colType="string"/>
        <july:headercolumn key="label.photo.filename" colType="string"/>
        <TD class="title">&nbsp;</TD>
    </tr>

     <july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
    <logic:iterate id="pht" name="browseList">
        <logic:present name="pht">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="text">
                    <july:editlink page="/EditPhoto.do" action="Edit" paramId="photo" paramName="pht" paramProperty="photo" paramScope="page">
                      <july:datewrite name="pht" property="date"/>
                    </july:editlink>
                </td>
				<td style="width:25%;"><%if(((com.hps.july.persistence.PhotoAccessBean)pht).getPhotographer()!=null){%>
				<bean:write name="pht" property="photographer.man.lastname" filter="true"/>&nbsp;
				<bean:write name="pht" property="photographer.man.firstname" filter="true"/>&nbsp;
				<bean:write name="pht" property="photographer.man.middlename" filter="true"/>
				</td><%}%>
                <td class="text">
                    <bean:write name="pht" property="description" filter="true"/>
                </td>
                <td class="text">
                    <html:link page="/PhotoDownload" paramId="photo" paramName="pht" paramProperty="photo" paramScope="page" target="_blank">
                      <bean:write name="pht" property="filename"/>
                    </html:link>
                </td>
                <td class="link"><july:delbutton page="/EditPhoto.do?action=Delete" paramId="photo" paramName="pht" paramProperty="photo" paramScope="page"/></td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditPhoto.do?action=Add"/><july:backbutton page="/EditPosition.do?action=View" paramId="storageplace" paramName="PhotoListForm" paramProperty="storageplace"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
      
<%-- DD

      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
		   <jsp:include page="/mapLinks.jsp" flush="true"></jsp:include>
           <july:sepmark/> 
           <html:link page="/EditPosition.do?action=View" paramId="storageplace" paramName="PhotoListForm" paramProperty="storageplace" styleClass="navigator"><bean:message key="label.workresponsibility.position"/></html:link> 
           <july:sepmark/> 
           <july:currmark><bean:message key="label.photos"/></july:currmark></td>
      </tr>
--%>

</table>
</july:browseform>
<script language="javascript">
	switchDate();
	switchPhotographer(document.all.isPhotographer[0].checked);
</script>