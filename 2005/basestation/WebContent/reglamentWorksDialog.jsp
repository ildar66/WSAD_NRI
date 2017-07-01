<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.basestation.*,com.hps.july.basestation.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/ProcessReglamentWorksDialog.do";
	String form = "ReglamentWorksDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "Удалить запись"; %>
</logic:equal>


<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="idWork"/>

<script language="javascript">
	function Close()
		{
			if(window.opener) {
				//opener.location.reload(true);
				opener.storeSelectedRow('docID', document.all.idWork.value);
				window.opener.window.location.href=window.opener.window.location.href;
				window.opener.focus();
			}
			window.close();
		}
	function switchReglamentWorkTypesList() {
		if(<%= form %>.typeWork.value == -1) {
			regWorkTypeSepID.style.setAttribute("display", "block");
			regWorkTypeID.style.setAttribute("display", "block");
		} else {
			regWorkTypeSepID.style.setAttribute("display", "none");
			regWorkTypeID.style.setAttribute("display", "none");
		}
	}
</script>

<table class="main"  style="font-size:8pt;">

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="document.body.style.cursor='wait';">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>

    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<%-- <td class="text">Лист оборудования по позиции:</td> --%>
		<td class="text"><b>Позиция:</b></td>
		<td class="text">
			<july:select style="width: 500;" property="regWork.vo.equipment" collection="equipNameList" styleId="regWorkEquipment" insertable="true" updatable="true">
				<html:options collection="equipNameList" property="equipment" labelProperty="storageName"/>
			</july:select>
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<%-- <td class="text">Лист типов работ:</td> --%>
		<td class="text">Список типов работ:</td>
		<td class="text">
			<july:select style="width: 500;" property="regWork.vo.typeWork" collection="reglamentWorkTypesList" styleId="typeWork" insertable="true" updatable="true" onchange="switchReglamentWorkTypesList()">
				<html:options collection="reglamentWorkTypesList" property="idtype" labelProperty="nametype"/>
				<html:option value="-1">&lt;Новый тип работ&gt;</html:option> 
			</july:select>
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>" trid="regWorkTypeSepID"/>

	<tr id="regWorkTypeID">
		<td class="text" style="color:darkgray">Новый тип работ:</td>
		<td class="text">
			<html:hidden property="regWorkType.idtype"/>
			<july:string size="50" property="regWorkType.nametype" insertable="true" updatable="true"/>
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<%-- <td class="text"><july:reqmark>дата работы:</july:reqmark></td> --%>
		<td class="text"><july:reqmark>Дата проведения работы:</july:reqmark></td>
		<td class="text">
			<july:date property="dateWorkStr" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark>Работник:</july:reqmark></td>
		<td class="text">
			<logic:present name="ReglamentWorksDialogForm" property="regWork.vo">
				<html:hidden property="regWork.vo.man"/>
				<july:lookupbutton action="/../security/ShowPeopleLookupList.do" styleId="manl" fieldNames="regWork.vo.man;regWork.manName" newWindowName="manlookup" insertable="true" updatable="true"/>
				<july:string size="50" property="regWork.manName" insertable="false" updatable="false"/>
			</logic:present>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

<%--
	<tr>
		<td class="text">дата созд.</td>
		<td class="text"><bean:write name="ReglamentWorksDialogForm" property="regWork.vo.created" filter="true"/></td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">ФИО созд.:</td>
		<td class="text"><bean:write name="ReglamentWorksDialogForm" property="regWork.createdName" filter="true"/></td>
    </tr>
		
	<july:separator colspan="<%= gColSpan %>"/>
--%>

<%--
<logic:notEqual name="<%= form %>" property="action" value="Add">	
	<tr>
		<td class="text">дата изм.</td>
		<td class="text"><bean:write name="ReglamentWorksDialogForm" property="regWork.vo.modified" filter="true"/></td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">ФИО изм.:</td>
		<td class="text"><bean:write name="ReglamentWorksDialogForm" property="regWork.modifiedName" filter="true"/></td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>
</logic:notEqual>
--%>

	<tr>
		<%-- <td class="text">Комментарий:</td>  --%>
		<td class="text" valign="top">Содержание работы:</td> 
		<td class="text">
			<july:textarea style="width: 300;"cols="40" rows="6" property="regWork.vo.noteWork" insertable="true" updatable="true" styleId="note"/>
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" styleID="submitID" onclick="document.body.style.cursor='wait';">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>
	
</table>

<logic:equal name="ReglamentWorksDialogForm" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>

<script language="javascript">
	switchReglamentWorkTypesList();
</script>

</july:editform>
