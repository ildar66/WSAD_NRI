<%@ page language = "java" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.siteinfo.*,com.hps.july.persistence.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "8"; %>

<SCRIPT>
//<!--
var  gelid;
var  gscard;

function onDownloadDone(s) {
  document.all [gelid].innerHTML='<IMG SRC="/images/izmena.gif" BORDER=0> ' + s;
}

function editComment(elid, argSCard) {
  gelid = elid;
  gscard = argSCard;
  document.all.commFrame.src="/siteinfo/EditEquipComment.do?action=Edit&storagecard=" + gscard;
  document.all.commFrame.style.visibility='visible';
}

function refreshComment() {
  document.all [gelid].innerHTML='<IMG SRC="/images/izmena.gif" BORDER=0>';
  document.all.commFrame.style.visibility='hidden';
  oDownload.startDownload('/siteinfo/GetEquipmentComment?storagecard=' + gscard, onDownloadDone);
}

var curtd;

function onSetSerialDone(s) {
  if(curtd) {
    var code = s.substr(0,3);
    var msg = s.substr(5);
    if(code == '200') {
      curtd.innerHTML = msg;
    } else {
      alert('Ошибка: ' + msg);
    }
  } else {
    alert('Не выбрана строчка.');
  }
}

function processOnSerialClick(scard) {
  var bubbleres = false;
  try {
    var snumvar = document.all['snum'+scard];
    curtd = snumvar.parentNode;
    var newsn = "";
    newsn = prompt('Заменить серийный номер на',snumvar.innerText);
    if(newsn != null) {
      oDownload.startDownload('/siteinfo/ChangeSerial?storagecard='+scard+'&newsn='+newsn,onSetSerialDone);
    }
  } catch(e) {}
  return bubbleres;
}

//-->
</SCRIPT>

<IE:DOWNLOAD ID="oDownload" STYLE="behavior:url(#default#download)" />

<july:browseform action="/ShowEquipdetList.do">

    <IFRAME WIDTH="600" HEIGHT="200" ID="commFrame"
      STYLE="position:absolute;
      left:expression(document.body.clientWidth/2-200);
      top:expression(document.body.scrollTop + 200);
      z-index:1; visibility:hidden"
      ></IFRAME>

<table class="main">

<july:separator colspan="<%= gColSpan %>" />
<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.equipment.posname"/>:</td>
       <td class="title"><bean:write name="EquipdetMultiListForm" property="posid" />&nbsp;&nbsp;&nbsp;<bean:write name="EquipdetMultiListForm" property="posname" /></td>
    </TR>        
    </table>
    
  </TD>
</TR>


    <july:separator colspan="<%= gColSpan %>" />

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:backbutton/><%--july:printbutton href="/crystalclear/equipment.rpt?dll=pdsequip.dll&prompt1=0" paramId="prompt0" paramName="EquipdetMultiListForm" paramProperty="storageplace" /--%></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.equipdet.complect" colType="string"/>
	<july:headercolumn key="label.equipdet.name" colType="string"/>
	<july:headercolumn key="label.equipdet.model" colType="string"/>
	<july:headercolumn key="label.equipdet.serial" colType="string"/>
	<july:headercolumn key="label.equipdet.qty" colType="string"/>
	<july:headercolumn key="null" colType="string"/>
	<july:headercolumn key="label.equipdet.place" colType="string"/>
	<july:headercolumn key="label.equipdet.comment" colType="string"/>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<!-- Table body -->
<logic:iterate id="equ" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="equ">
<%
	String sc = equ.getColumn("storagecard").asString();
	pageContext.setAttribute("storagecard",sc);
	boolean showChSbutton = "S".equals(equ.getColumn("policy").asString()) && "Y".equals(equ.getColumn("isfictserial").asString());
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="text"><july:stringwrite name="equ" property="complectname" /></td>
	<td class="text"><july:stringwrite name="equ" property="name" /></td>
	<td class="text"><july:stringwrite name="equ" property="model" /></td>
	<td class="text" nowrap><%if(showChSbutton) {%><img src="/images/izmena.gif" border="0" style="cursor:hand;" onclick="return processOnSerialClick('<%=sc%>');"> <%}%><span id='snum<july:stringwrite name="equ" property="storagecard"/>' nowrap><july:stringwrite name="equ" property="sn"/></span></td>
	<td class="number"><july:numberwrite name="equ" property="qty" /></td>
	<td class="text">
		<%if(equ.getColumn("contents").asObject() != null && "S".equals(equ.getColumn("policy").asString())) {%>
			<july:link page="/ShowEquipsdetList.do" paramId="storagecard" paramName="storagecard">
        <IMG SRC="/images/details.gif" BORDER="0"
          ALT='<bean:message key="label.eqipdet.cont"/>'>
      </july:link>
		<%}%>
	</td>
	<td class="text"><july:stringwrite name="equ" property="place" /></td>
	<td class="text" ID='equ<july:stringwrite name="equ" property="storagecard"/>'
    onclick='document.recalc(true);editComment(this.id, <july:stringwrite name="equ" property="storagecard"/>);'>
    <IMG SRC="/images/izmena.gif" BORDER=0>
    <july:stringwrite name="equ" property="comment" />
  </td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:backbutton/><%--july:printbutton href="/crystalclear/equipment.rpt?dll=pdsequip.dll&prompt1=0" paramId="prompt0" paramName="EquipdetMultiListForm" paramProperty="storageplace" /--%></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      <july:separator colspan="<%= gColSpan %>" />
</table>

</july:browseform>


