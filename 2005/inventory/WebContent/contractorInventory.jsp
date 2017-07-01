<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.inventory.formbean.*"%>
<%@ page import="java.util.*"%>

<july:editform action="/ProcessContractorInventory.do">

<script language="javascript" src="/action.js"></script>
<jsp:include page="/contractorInventoryJS.jsp" flush="true"></jsp:include>

<%
	ContractorInventoryForm frm = (ContractorInventoryForm)request.getSession().getAttribute("ContractorInventoryForm");
	String docstate = frm.getDocumentState();
	boolean changable = "1".equals(frm.getDocumentState()) && !frm.getIsautodoc();
	boolean showStateLink = ("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()
			&& frm.getRentername()!=null && !frm.getRentername().equals("");
	boolean hasErs = !(frm.getCalcerrors()).isEmpty() || !(frm.getHeadercalcerrors()).isEmpty();

	String mockIndex = frm.getBlankindexFrm(); 
	if (mockIndex == null || mockIndex.length() == 0) {
		mockIndex = frm.MOCK_DOC_ID;
	}
	
%>

<script>
	var hX = -150;
	var vY = 15;
</script>

<%if(changable){%>
<div id="Float" style="position: absolute;
                           background-color: #D3E9FF;
                           width: 130px;
                           border-width: 1;
                           border-style:outset;
                           border-color:#A5F3C6;
                           padding:5px">
			<center>
					<A href='ContrEquipList.do?action=Edit&storageplace=<%=frm.getStorageplace()%>&act=<%=frm.getIdact()%>' onclick='window.open(this.href, "contrEquipList", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes").focus(); return false;'>
						<FONT style="font-size: 8pt;">Оборудование</FONT>
						<IMG SRC="/images/details.gif" BORDER='0' ALT='Список оборудования'>
					</A>
			
			</center>
</div>
<%}%>

<script>	
	var nn=(navigator.appName.indexOf("Netscape")!=-1);
	var dD=document,dH=dD.html,dB=dD.body,px=dD.layers?'':'px';	
	floatLink(hX,vY,'Float').Fm();
</script>



<%if(hasErs){%>
	<b><FONT style="color: red; font-size: 10pt;">При обсчете документа возникли следующие расхождения:</FONT></b>
	<br><br>
	<%
	Iterator iter = frm.getHeadercalcerrors().iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%>
		&nbsp;&nbsp;&nbsp;<IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<FONT style="color: red; font-size: 10pt;"><%=error%></FONT>
		<%  }
}%>

<html:hidden property="idact" />
<html:hidden property="documentstr" />
<html:hidden property="expeditionstr" />
<html:hidden property="processState"/>
<html:hidden property="warnProc"/>
<INPUT TYPE="HIDDEN" NAME="refreshFields" ID="refreshFields" VALUE="0">

<table class="main">
    
    <july:separator/>

    <july:formbuttons>

	&nbsp;

  <%if(showStateLink){%>
	<%if("1".equals(docstate)) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='false';return checkPosted();" title="Обсчёт">
		<%if(frm.isAutodoc()) {%>
			<input type="image" name="submit" src="/images/calculatea.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='true';return checkPosted();" title="Обсчёт с автоматическим исправлением несоответствий">
		<%}%>
	<%} else {%>
		<input type="image" name="submit" src="/images/calculates.gif" onclick="document.all.action.value='Edit';document.all.processState.value='C';document.all.warnProc.value='false';return checkPosted();" title="Снять обсчёт">
	<%}%>
  <%}%>
	</july:formbuttons>

	<july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.internal.owner"/>:</july:reqmark></td>
        <td>
		<july:select collection="owners" property="ownercode" insertable="true" updatable="true">
			<html:options collection="owners" property="organization" labelProperty="name"/>
		</july:select>
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.internal.num"/>:</july:reqmark></td>
        <td>
           <%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
		   <html:hidden property="blankindexFrm" value="<%=mockIndex%>" />
           <july:string property="blanknumber" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.internal.date"/>:</july:reqmark></td>
        <td>
			<july:date property="blankdatestr" styleId="blankdatestrctl" size="25" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark>Позиция:</july:reqmark></td>
        <td>
			<july:string property="positioncode" styleId="positioncode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positioncode;positionid;positionname" newWindowName="positionlookup"  insertable="true" updatable="true" />
			<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
			<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.internal.renter"/>:</july:reqmark></td>
        <td>
			<july:string property="rentercode" styleId="rentercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="rentl" fieldNames="rentercode;rentername" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_rentl('?selisprovider=true&selisrenter=false&selissupplier=false');"/>
			<july:string size="35" property="rentername" styleId="rentername" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.internal.representative"/>:</july:reqmark></td>
        <td>
			<july:string size="35" property="insuranseMan" insertable="true" updatable="true" />
        </td>
    </tr>
        
    <july:separator/>
    
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.inventory.tech1"/>:</july:reqmark></td>
		<td>
			<july:string property="storagemancode" styleId="storagemancode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="w1l" fieldNames="storagemancode;storagemanname" newWindowName="storlookup"  insertable="true" updatable="true" />
			<july:string size="35" property="storagemanname" styleId="storagemanname" insertable="false" updatable="false" />
		</td>
	</tr>

	<july:separator/>

    <tr>
        <td class="text"><bean:message key="label.internal.state"/>:</td>
        <td>
			<%if(docstate!=null && docstate.equals("2")){%>
				Обсчитан
			<%}else{%>
				Вводится
			<%}%>		   
        </td>
    </tr>
    
	<july:separator/>

	<tr>
        <td>&nbsp;</td>        
    </tr>	
	<tr><td><b>1. Инвентаризация аппаратной</b></td></tr>
	<tr><td style="font-size:8pt;" ><b>1.1 Аппаратура базовой станции</b></td></tr>

	<jsp:include page="/contractorBSEq.jsp" flush="true"></jsp:include>

	<tr><td>&nbsp;</td></tr>
	<tr><td style="font-size:8pt;" ><b>1.2 Инженерное оборудование</b></td></tr>

	<jsp:include page="/contractorIngEq.jsp" flush="true"></jsp:include>	

	<tr><td>&nbsp;</td></tr>
	<tr><td style="font-size:8pt;" ><b>1.3 Аппаратура АФС в аппаратной</b></td></tr>

	<jsp:include page="/contractorAfs.jsp" flush="true"></jsp:include>

	<tr><td>&nbsp;</td></tr>
	<tr><td style="font-size:8pt;" ><b>1.4 Аппаратура контроллера базовых станций</b></td></tr>

	<jsp:include page="/contractorBSC.jsp" flush="true"></jsp:include>

	<tr><td>&nbsp;</td></tr>
	<tr><td style="font-size:8pt;" ><b>1.5 Репитер</b></td></tr>

	<jsp:include page="/contractorRep.jsp" flush="true"></jsp:include>

	<tr><td>&nbsp;</td></tr>
	<tr><td><b>2. Инвентаризация вне аппаратной</b></td></tr>
	<tr><td style="font-size:8pt;" ><b>2.1 Антенно фидерный тракт</b></td></tr>

	<jsp:include page="/contractorAft.jsp" flush="true"></jsp:include>

	<tr><td style="font-size:8pt;" ><b>2.2 Антенны</b></td></tr>

	<jsp:include page="/contractorAnt.jsp" flush="true"></jsp:include>

	<tr><td>&nbsp;</td></tr>
	<tr><td><b>3. Прочее оборудование</b></td></tr>

	<jsp:include page="/contractorPO.jsp" flush="true"></jsp:include>

	<tr><td>&nbsp;</td></tr>
	<tr><td><b>4. Старое оборудование</b></td></tr>

	<jsp:include page="/contractorOldEq.jsp" flush="true"></jsp:include>
	


   <july:formbuttons>

	&nbsp;

  <%if(showStateLink){%>
	<%if("1".equals(docstate)) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='false';return checkPosted();" title="Обсчёт">
		<%if(frm.isAutodoc()) {%>
			<input type="image" name="submit" src="/images/calculatea.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='true';return checkPosted();" title="Обсчёт с автоматическим исправлением несоответствий">
		<%}%>
	<%} else {%>
		<input type="image" name="submit" src="/images/calculates.gif" onclick="document.all.action.value='Edit';document.all.processState.value='C';document.all.warnProc.value='false';return checkPosted();" title="Снять обсчёт">
	<%}%>
  <%}%>
	</july:formbuttons>

</table>

<%
  frm.clearAll();
  frm.getCalcerrors().clear();
  frm.getHeadercalcerrors().clear();
%>

</july:editform>

<%request.getSession().removeAttribute("idact");  
%>

