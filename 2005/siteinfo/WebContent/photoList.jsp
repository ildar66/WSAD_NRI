<%@ page import="com.hps.july.siteinfo.formbean.PositionForm"%>
<%@ page import="com.hps.july.persistence.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.hps.july.apptags.HasAccessTag, com.hps.july.cdbc.lib.*"%>
<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	java.lang.String gColSpan = "7";
	boolean hasRegionAccess=((PositionForm)pageContext.findAttribute("PositionForm")).hasRegionAccess(request);
	boolean editroles = request.isUserInRole("administrator") || request.isUserInRole("siteProjector") || request.isUserInRole("siteExploitor");
	boolean viewroles = request.isUserInRole("siteStation") || request.isUserInRole("siteTransport") || request.isUserInRole("siteLook");
%>

<july:browseform action="DeletePhoto.do" styleId="PosForm">

<style>
<!--
	TD.normal {
		BACKGROUND-COLOR: #D3E9FF; FONT-FAMILY: Verdana,Arial;
	TD.selected {
		 BACKGROUND-COLOR: #FFF799; FONT-FAMILY: Verdana,Arial;
}
}

-->
</style>
<script>
<!--
	var prev = -1;
	function setSelected(id) {
		if(id) {
			var el1 = document.getElementById(id + '_1');
			var el2 = document.getElementById(id + '_2');
			if(prev != -1 && prev != id) {
				var el11 = document.getElementById(id + '_1');
				var el22 = document.getElementById(prev + '_2');
				if(el22 && el11) {
					el22.className = 'normal';
					el11.className = 'normal';
				}
			}
			prev = id;
			if(el2 && el1) {
				el2.className = 'selected';
				el1.className = 'selected';
			}
		}
	}
	function saveLocal() {
			var photos = "";
               var list2 = document.getElementsByTagName('INPUT');
                for (var i = 0; i < list2.length; i++) {
					var type = list2[i].getAttribute('type');
                        var name = list2[i].getAttribute('name');
                        if(type == 'checkbox' && name == 'photoid') {
                        	if(list2[i].checked) {
								photos +=(";" + list2[i].value);
								list2[i].checked = false;
							}    
                        }
                }
		return photos;
		
	}
-->
</script>
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
function selectAll(check){
	for(var i = 0; i < document.all.length; i++){
		var elem = document.all[i];
		if(elem.type == "checkbox" && elem.name.substring(0, 7) == "photoid")
			if(check.checked)
				elem.checked = true;
			else
				elem.checked = false;
	}
}
function deletePhoto(){
	if(window.confirm('<bean:message key="delete.photo.confirm1"/>\n<bean:message key="delete.photo.confirm2"/>'))
			document.forms[0].submit();
	else
			return;
}
function _onmouseout() {
	document.body.style.cursor='auto';
}
function _onmouseover() {
	document.body.style.cursor='hand';
}

</script>

<july:selectableTable styleClass="main"  modelName="list" selectable="1" selectedClass="selected" paramName="selID">

<tr class="normal">
	<td colspan="<%= gColSpan %>">
	<table class="find">
	<tr>
		<td class="title" ><bean:message key="label.photo.posname"/>:</td>
		<td class="title" colspan="3"><bean:write name="PhotoListForm" property="posid" />&nbsp;&nbsp;&nbsp;<bean:write name="PhotoListForm" property="posname" /></td>
		<td align="right"><july:searchbutton/></td>
	</tr>        
	<tr>
        	<td class="text"><bean:message key="label.photo.date"/></td>
	        <td>
			<july:checkbox property="isDate" styleId="isDate" insertable="true" updatable="true" onclick="switchDate()" />&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:message key="label.photo.c"/>
		</td>
		<td><july:date property="dateFrm1" insertable="true" updatable="true" styleId="date1"/></td>
		<td>&nbsp;&nbsp;<bean:message key="label.photo.po"/>&nbsp;&nbsp;</td>
		<td><july:date property="dateFrm2" insertable="true" updatable="true" styleId="date2"/></td>
	</tr>
	<tr>
        	<td class="text"><bean:message key="label.photo.photographer"/></td>
	        <td><july:checkbox property="isPhotographer" styleId="isPhotographer" insertable="true" updatable="true" onclick="switchPhotographer(document.all.isPhotographer[0].checked)" />&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;</td>
		<td colspan="3" class="title">
			<july:string property="photographerId" styleId="photographerId" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="r1l" fieldNames="photographerId;photographerName" onclick="set_opt_params_r1l('?photographerId='+document.all.photographerId.value)" insertable="true" updatable="true" />
			<july:string size="30" property="photographerName" styleId="photographerName" insertable="false" updatable="false" />
		</td>
	</tr>
	<tr>
        	<td class="text">Группы</td>
	        <td colspan="4">
			<july:select collection="groupNames" property="groupName" insertable="true" updatable="true" style="background-color:white">
			    <html:option value="">Все группы</html:option>
		        <july:options collection="groupNames" property="gn" labelProperty="gn" />
		    </july:select>
			</td>
	</tr>
	<tr>
        	<td class="text">Просмотр/Редактирование</td>
	        <td colspan="4"><july:checkbox property="preview" styleId="preview" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;</td>
	</tr>
	</table>
	</tr>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons">
			<%if(hasRegionAccess && editroles){%>
				<IMG SRC="/images/plus.gif" BORDER='0' ALT='<bean:message key="add.photo"/>' onClick="moveto()" onMouseOver="_onmouseover()" onMouseOut="_onmouseout()">
			<%}%>
			<july:backbutton page="/EditPosition.do?action=View" paramId="storageplace" paramName="PhotoListForm" paramProperty="storageplace"/>
		<logic:present name="PhotoListForm" property="preview">
			<logic:equal name="PhotoListForm" property="preview" value="false">
				<%if(hasRegionAccess && editroles) {%>
					<IMG SRC="/images/del_marked.gif" BORDER='0' ALT='<bean:message key="delete.photo"/>' onclick="deletePhoto()" onMouseOver="_onmouseover()" onMouseOut="_onmouseout()">
				<%}%>
				<logic:present name="javaVer" scope="session">
				<logic:equal name="javaVer" value="true" scope="session">
					<IMG SRC="/images/save.gif" BORDER='0' ALT='<bean:message key="img.savelocal"/>' onclick="downloadPhoto()" onMouseOver="_onmouseover()" onMouseOut="_onmouseout()">              
				</logic:equal>			  
				</logic:present>
			</logic:equal>			  
		</logic:present>
				<span style="font-size:10px">&nbsp;&nbsp;количество файлов: <%=((Collection)request.getAttribute("browseList")).size()%></span>			
		</td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
  
<logic:present name="PhotoListForm" property="preview">
	<logic:equal name="PhotoListForm" property="preview" value="true">

<%
	Collection bl = (Collection)request.getAttribute("browseList"); 
	if(bl != null) {
	    for (Iterator it = bl.iterator(); it.hasNext(); ) {
    	    CDBCRowObject pht = (CDBCRowObject)it.next();
			if(pht == null) continue;
			String photoID = pht.getColumn("photo").asString();
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'" >
<td bgcolor="white" valign="middle">
	<table class="main" cellpadding="0" cellspacing="2">
	<tr>
		<td id="<%=photoID%>_1" style="width:16%;" class="normal" align="center" valign="middle" height="100%">
			<table cellpadding="1" cellspacing="1" width="100%" height="100%">
				<tr id="<%=photoID%>_2" class="normal"><td align="center" height="100%" valign="middle">
		      <a href="PhotoDownload?photo=<%=photoID%>" onclick="document.body.style.cursor='normal';" target="_blank">
	          <IMG SRC="PhotoDownload?photo=<%=photoID%>&small=1" WIDTH="70" BORDER="0" onerror="showLink(<%=photoID%>)" onclick="setSelected(<%=photoID%>)">
    	  </a><br/>
		  <span style="font-size:10px"><%=pht.getColumn("filename").asString()%></span>
			</td></tr></table>
	    </td>
<%
		if(it.hasNext()) {
			pht = (CDBCRowObject)it.next();
			photoID = pht.getColumn("photo").asString();
%>
		<td id="<%=photoID%>_1" style="width:16%;" class="normal" align="center" valign="middle" height="100%"> 
			<table cellpadding="1" cellspacing="1" width="100%" height="100%">
				<tr id="<%=photoID%>_2" class="normal"><td align="center" height="100%" valign="middle">
		      <a href="PhotoDownload?photo=<%=photoID%>" onclick="document.body.style.cursor='normal';" target="_blank">
	          <IMG SRC="PhotoDownload?photo=<%=photoID%>&small=1" WIDTH="70" BORDER="0" onerror="showLink(<%=pht.getColumn("photo").asString()%>)" onclick="setSelected(<%=photoID%>)"/>
    	  </a><br/>
		  <span style="font-size:10px"><%=pht.getColumn("filename").asString()%></span>
			</td></tr></table>
	    </td>
<%
		} else {
%>
		<td style="width:16%;" class="normal"  align="center" valign="middle" height="100%">
			<table cellpadding="1" cellspacing="1" width="100%" height="100%">
				<tr class="normal"><td align="center" height="100%" valign="middle">&nbsp;</td></tr></table>
		</td>
<%
		}
%>
<%
		if(it.hasNext()) {
			pht = (CDBCRowObject)it.next();
			photoID = pht.getColumn("photo").asString();
%>
		<td id="<%=photoID%>_1" style="width:16%;" class="normal" align="center" valign="middle" height="100%"> 
			<table cellpadding="1" cellspacing="1" width="100%" height="100%">
				<tr id="<%=photoID%>_2" class="normal"><td align="center" height="100%" valign="middle">
		      <a href="PhotoDownload?photo=<%=photoID%>" onclick="document.body.style.cursor='normal';" target="_blank">
	          <IMG SRC="PhotoDownload?photo=<%=photoID%>&small=1" WIDTH="70" BORDER="0" onerror="showLink(<%=pht.getColumn("photo").asString()%>)" onclick="setSelected(<%=photoID%>)"/>
    	  </a><br/>
		  <span style="font-size:10px"><%=pht.getColumn("filename").asString()%></span>
			</td></tr></table>
	    </td>
<%
		} else {
%>
		<td style="width:16%;" class="normal"  align="center" valign="middle" height="100%">
			<table cellpadding="1" cellspacing="1" width="100%" height="100%">
				<tr class="normal"><td align="center" height="100%" valign="middle">&nbsp;</td></tr></table>
		</td>
<%
		}
%>
<%
		if(it.hasNext()) {
			pht = (CDBCRowObject)it.next();
			photoID = pht.getColumn("photo").asString();
%>
		<td id="<%=photoID%>_1" style="width:16%;" class="normal" align="center" valign="middle" height="100%"> 
			<table cellpadding="1" cellspacing="1" width="100%" height="100%">
				<tr id="<%=photoID%>_2" class="normal"><td align="center" height="100%" valign="middle">
		      <a href="PhotoDownload?photo=<%=photoID%>" onclick="document.body.style.cursor='normal';" target="_blank">
	          <IMG SRC="PhotoDownload?photo=<%=photoID%>&small=1" WIDTH="70" BORDER="0" onerror="showLink(<%=pht.getColumn("photo").asString()%>)" onclick="setSelected(<%=photoID%>)"/>
    	  </a><br/>
		  <span style="font-size:10px"><%=pht.getColumn("filename").asString()%></span>
			</td></tr></table>
	    </td>
<%
		} else {
%>
		<td style="width:16%;" class="normal"  align="center" valign="middle" height="100%">
			<table cellpadding="1" cellspacing="1" width="100%" height="100%">
				<tr class="normal"><td align="center" height="100%" valign="middle">&nbsp;</td></tr></table>
		</td>
<%
		}
%>
<%
		if(it.hasNext()) {
			pht = (CDBCRowObject)it.next();
			photoID = pht.getColumn("photo").asString();
%>
		<td id="<%=photoID%>_1" style="width:16%;" class="normal" align="center" valign="middle" height="100%"> 
			<table cellpadding="1" cellspacing="1" width="100%" height="100%">
				<tr id="<%=photoID%>_2" class="normal"><td align="center" height="100%" valign="middle">
		      <a href="PhotoDownload?photo=<%=photoID%>" onclick="document.body.style.cursor='normal';" target="_blank">
	          <IMG SRC="PhotoDownload?photo=<%=photoID%>&small=1" WIDTH="70" BORDER="0" onerror="showLink(<%=pht.getColumn("photo").asString()%>)" onclick="setSelected(<%=photoID%>)"/>
    	  </a><br/>
		  <span style="font-size:10px"><%=pht.getColumn("filename").asString()%></span>
			</td></tr></table>
	    </td>
<%
		} else {
%>
		<td style="width:16%;" class="normal"  align="center" valign="middle" height="100%">
			<table cellpadding="1" cellspacing="1" width="100%" height="100%">
				<tr class="normal"><td align="center" height="100%" valign="middle">&nbsp;</td></tr></table>
		</td>
<%
		}
%>
<%
		if(it.hasNext()) {
			pht = (CDBCRowObject)it.next();
			photoID = pht.getColumn("photo").asString();
%>
		<td id="<%=photoID%>_1" style="width:16%;" class="normal" align="center" valign="middle" height="100%"> 
			<table cellpadding="1" cellspacing="1" width="100%" height="100%">
				<tr id="<%=photoID%>_2" class="normal"><td align="center" height="100%" valign="middle">
		      <a href="PhotoDownload?photo=<%=photoID%>" onclick="document.body.style.cursor='normal';" target="_blank">
	          <IMG SRC="PhotoDownload?photo=<%=photoID%>&small=1" WIDTH="70" BORDER="0" onerror="showLink(<%=pht.getColumn("photo").asString()%>)" onclick="setSelected(<%=photoID%>)"/>
    	  </a><br/>
		  <span style="font-size:10px"><%=pht.getColumn("filename").asString()%></span>
			</td></tr></table>
	    </td>
<%
		} else {
%>
		<td style="width:16%;" class="normal"  align="center" valign="middle" height="100%">
			<table cellpadding="1" cellspacing="1" width="100%" height="100%">
				<tr class="normal"><td align="center" height="100%" valign="middle">&nbsp;</td></tr></table>
		</td>
<%
		}
%>
	</tr>
	</table>
	</td>
</tr>

<%
		
		}
	}
%>
</logic:equal>

<logic:equal name="PhotoListForm" property="preview" value="false">
<!-- Table header -->
<tr class="title">
    <td class="title" style="width:5%"><%if(editroles){%>&nbsp;<%}%></td>
	<july:headercolumn key="label.photo.filename" colType="string"/>
	<july:headercolumn key="label.photo.date" colType="string"/>
    <td class="title" style="width:25%">Группа</td>
	<july:headercolumn key="label.photo.photographer" colType="string"/>
        <july:headercolumn key="label.photo.description" colType="string"/>
        <%--july:headercolumn key="label.photo.filename" colType="string"/--%>
        <td class="title" style="width:5%">
			<%if(editroles){%>
				<label title="выбрать фотографии для удаления/выгрузки">
					<input type="checkbox" name="selectChecks" onclick="selectAll(this)">
				</label>
			<%}%>
		</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<%int count = 0;%>
		<script>
			<!--
				function showLink(id) {
					var ph = document.getElementById('ph' + id);
					var linkPh = document.getElementById('linkPh' + id);
					if(ph && linkPh) {
						ph.style.visibility = 'hidden';
						linkPh.style.visibility = 'visible';
					}
				}
	        -->
		</script>
<logic:iterate id="pht" name="browseList">
<logic:present name="pht">
<% String photoId = ((CDBCRowObject)pht).getColumn("photo").asString(); 
	String poscode = ((CDBCRowObject)pht).getColumn("storageplace").asString();
%>
<july:selectableTR styleId="<%=photoId%>" styleClass="normal"  onmouseover="className='select'" onmouseout="className='normal'" paramName="selID">
<!-- tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'" -->
  <td class="text" style="width:5px">
		<july:anchor />
		<%if(editroles) {
			if(hasRegionAccess&&HasAccessTag.hasAccess(pageContext,"/EditPhoto.do")){ %>
			<july:editbutton page='<%="/EditPhoto.do?storageplace="+poscode%>' action="Edit" paramId="photo" paramName="pht" paramProperty="photo" paramScope="page"/>
		<%} else { %>  &nbsp; <%}
		} else { %>
			&nbsp;
		<% } %>
  </td>

<td class="text" style="width:25%">
      <july:link page="/PhotoDownload"
        paramId="photo" paramName="pht" paramProperty="photo" paramScope="page"
        onclick="document.body.style.cursor='normal';"
        target="_blank">
          <IMG SRC="PhotoDownload?photo=<july:stringwrite name='pht' property='photo'/>&small=1" WIDTH="70" BORDER="0" onerror="showLink(<july:stringwrite name='pht' property='photo'/>)">
      </july:link><br/>
	  <span style="font-size:10px"><july:stringwrite name="pht" property="filename"/></span>
	
  </td>
  <td class="text" style="width:10%">
        <july:datewrite name="pht" property="date"/>
  </td>
	<td style="width:10%;" nowrap>
			<% 		String grpName = ((CDBCRowObject)pht).getColumn("groupname").asString(); %>
				<%= grpName%>&nbsp;
		</td>
		<td style="width:20%;">
			<% 
				String phName = ((CDBCRowObject)pht).getColumn("phname").asString();
				String exName = ((CDBCRowObject)pht).getColumn("exname").asString();
				boolean phB = (phName != null && phName.length() > 0);
				boolean exB = (exName != null  && exName.length() > 0);
			    	if(phB && exB) {
						phName += ("/" + exName);
					} else {
						if(!phB && !exB) { phName = ""; }
						else {
							if(!phB && exB) phName = exName;
						}
					}
				%>
				<%= phName%>&nbsp;
		</td>
    <td class="text" style="width:35%;">
      <july:stringwrite name="pht" property="description"/>
    </td>
    <%-- td class="text">
					<july:link page="/PhotoDownload"
            paramId="photo" paramName="pht" paramProperty="photo" paramScope="page"
            onclick="document.body.style.cursor='normal';"
            target="_blank">
              <july:stringwrite name="pht" property="filename"/>
          </july:link>
    </td --%>
    <td class="link" style="width:5%">
		<%if(hasRegionAccess && editroles) {%>
		<%
			String styleid="photoid"+(++count);
			String photoid = ""+((com.hps.july.cdbc.lib.CDBCRowObject)pht).getColumn("photo").asString();
		%>
		<label title="выбрать фотографию для удаления/выгрузки">
		<july:checkbox property="photoid" styleId="<%=styleid%>" value="<%=photoid%>" insertable="true" updatable="true" />
		</label>
		<%}%>
		</td>
</july:selectableTR>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
      </logic:iterate>
	</logic:equal>
</logic:present>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
			  <%if(hasRegionAccess && editroles) {%>
				<IMG SRC="/images/plus.gif" BORDER='0' ALT='<bean:message key="add.photo"/>' onClick="moveto()" onMouseOver="_onmouseover()" onMouseOut="_onmouseout()">
			  <%}%>
			  <july:backbutton page="/EditPosition.do?action=View" paramId="storageplace" paramName="PhotoListForm" paramProperty="storageplace"/>
			  <%if(hasRegionAccess && editroles) {%>
			  <IMG SRC="/images/del_marked.gif" BORDER='0' ALT='<bean:message key="delete.photo"/>' onclick="deletePhoto()" onMouseOver="_onmouseover()" onMouseOut="_onmouseout()">
			  <%}%>
		<logic:present name="javaVer" scope="session">
		<logic:equal name="javaVer" value="true" scope="session">
			  <IMG SRC="/images/save.gif" BORDER='0' ALT='<bean:message key="img.savelocal"/>' onclick="downloadPhoto()" onMouseOver="_onmouseover()" onMouseOut="_onmouseout()">              
		</logic:equal>			  
		</logic:present>
			  </TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
</july:selectableTable>

<input type="hidden" name="javaVer" value="1">
<applet
	code="com/hps/july/siteinfo/applets/JavaVersion.class"
	ARCHIVE="/applets/JavaVersion.jar"
	name="ver"
	width=0
	height=0 >
</applet>
<script type="text/javascript" language="JavaScript">
function moveto(){
	document.all.javaVer.value = document.all.ver.getVersion();
	window.location.href="EditPhoto.do?action=Add&storageplace="+<bean:write name="PhotoListForm" property="storageplace"/>+"&javaVer="+document.all.javaVer.value;
}
function downloadPhoto(){
	document.body.style.cursor='wait';
	var ids = saveLocal();
	document.all.down.save(ids);
	document.body.style.cursor='auto';
}
</script>

</july:browseform>

<applet
	code="com/hps/july/siteinfo/applets/DownloadImg.class"
	ARCHIVE="/applets/down.jar"
	name="down"
	width=0
	height=0 >
	<param name=servletPath value="uploadImg">
	<param name=storageplace value="<bean:write name="PhotoListForm" property="storageplace"/>">
</applet>

<script language="javascript">
	switchDate();
	switchPhotographer(document.all.isPhotographer[0].checked);
</script>
