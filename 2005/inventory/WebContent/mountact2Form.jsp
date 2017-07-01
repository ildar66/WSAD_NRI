<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.*"%>

      <SCRIPT>
        function changeVis(tarr, aspan, ares) {
          if ( (tarr [ares.value] == 'b') || (tarr [ares.value] == 'B') ) {
            aspan [0].style.cssText = "visibility:hidden; display:none;"
            aspan [1].style.cssText = "visibility:visible; display:inline;"
            aspan [2].style.cssText = "visibility:visible; display:inline;"
          } else if ( (tarr [ares.value] == 'p') || (tarr [ares.value] == 'P') ) {
            aspan [0].style.cssText = "visibility:visible; display:inline;"
            aspan [1].style.cssText = "visibility:hidden; display:none;"
            aspan [2].style.cssText = "visibility:visible; display:inline;"
          } else if ( (tarr [ares.value] == 's') || (tarr [ares.value] == 'S') ) {
            aspan [0].style.cssText = "visibility:visible; display:inline;"
            aspan [1].style.cssText = "visibility:hidden; display:none;"
            aspan [2].style.cssText = "visibility:visible; display:inline;"
          } else {
            aspan [0].style.cssText = "visibility:hidden; display:none;"
            aspan [1].style.cssText = "visibility:hidden; display:none;"
            aspan [2].style.cssText = "visibility:hidden; display:none;"
          }
        }
      </SCRIPT>
      
<script language="javascript" src="/action.js"></script>

<bean:define id="bsList" name="MountAct2Form" property="bsList" scope="request" type="java.util.List"/>
<%
	MountAct2Form frm = (MountAct2Form)request.getAttribute("MountAct2Form");	
	boolean showStateLink = ("View".equals(frm.getAction()) || "Edit".equals(frm.getAction()));
	String docstate = frm.getDState();
	int visualtype = 0;
	if (frm.getVisualtype() != null)
		visualtype = frm.getVisualtype().intValue();
%>
<july:inventorycalcerrors document="<%= frm.getDocumentId() %>" />


<july:editform action="/ProcessMountAct2.do">
    
	
    <html:hidden property="document" />
    <html:hidden property="oldposnumber" />
    <html:hidden property="manycomplects" />
    <html:hidden property="processState" />
    <html:hidden property="warnProc" />
    <html:hidden property="DState"/>
    <html:hidden property="visualtype" />
    <INPUT TYPE="HIDDEN" NAME="refreshFields" ID="refreshFields" VALUE="0">

<table class="main">
    
    <july:separator/>
   
	<july:formbuttons>
	
<%if(showStateLink){%>
	<%if("1".equals(docstate)) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='false';return checkPosted();" title="Обсчёт">
<%if(com.hps.july.util.AppUtils.isNewInventory()) {%>
<%  if(frm.getWarnProc() != null && frm.getWarnProc().booleanValue()) {%>
		<input type="image" name="submit" src="/images/calculatea.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='true';return checkPosted();" title="Обсчёт с автоматическим исправлением несоответствий">
<%  }%>
<%}%>
	<%} else {%>
		<html:link page="/ProcessMountAct2.do?action=Edit&processState=C" paramId="document" paramName="MountAct2Form" paramProperty="document" paramScope="request" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
	</july:formbuttons>
    
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>
    
    <TR><TD class="text" colspan="2">
    
      <TABLE class="print" style="font-size:8pt;">
      <TR class="print">
        <TD COLSPAN="4" class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
          <DIV><july:errors property="head" shortformat="true"/></DIV>
          <TABLE>
            <TR>
            	<TD style="font-size:8pt;"><bean:message key="label.mountact2.actno"/>
          <bean:message key="label.mountact2.bsno"/>
				</TD>
				<TD>
		  <%if(!frm.getBsList().isEmpty()){%>	
			  <july:select collection="bsList" property="posnumber" style="font-size:8pt;" insertable="true" updatable="true">
				<july:options collection="bsList" property="type" labelProperty="name"/>
			  </july:select>
		  <%}else{%>
			  <july:string property="posnumber" style="font-size:8pt;"
				  size="5" insertable="true" updatable="true"/>
			  <logic:equal name="MountAct2Form" property="manycomplects" value="true">
					<july:select collection="complects" property="complectcode"
					style="font-size:8pt;"
					insertable="true" updatable="true">
						<html:option value="">&nbsp;</html:option>
						<july:options collection="complects" property="equipment" labelProperty="name"/>
					</july:select>
			  </logic:equal>
			  <logic:equal name="MountAct2Form" property="manycomplects" value="false">
					<html:hidden property="complectcode"/>
					<july:string size="25"
				  style="font-size:8pt;"
				  property="complectname" styleId="complectname" insertable="false" updatable="false" />
			  </logic:equal>
		  <%}%>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <SPAN style="font-size:8pt;font-weight:bold;"><july:stringwrite  property="vistypename" /></SPAN>
		  </TD>
		  </TR>
		  <TR>
		  	<TD style="font-size:8pt;"><bean:message key="label.mountact2.project"/></TD>
		  	<TD>
		  <html:hidden property="projectid"/>
		  <html:hidden property="projectname"/>
		  <july:string size="35" style="font-size:8pt;" 
		  	property="projectname" insertable="false" updatable="false"/>


          <A HREF="#" onclick="return false;">
          <IMG SRC="/images/dictrefrsh.gif" BORDER=0
            onclick="document.all.refreshFields.value=1; document.forms(0).submit();"
            alt="Обновить данные">
          </A>
            </TD>
		  </TR>            
		  </TABLE>
        </TD>
      </TR>
      <TR class="print">
        <TD width="30%" class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">&nbsp;</TD>
        <TD width="30%" class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"><bean:message key="label.mountact2.header3"/></TD>
        <TD width="20%" class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"><bean:message key="label.mountact2.header4"/></TD>
        <TD width="20%" class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"><bean:message key="label.mountact2.header5"/></TD>
      </TR>
      
   <%

	  		

      String[] labels = new String [] {"10", "20", "30", "40", "50", "60",
        "70", "75", "80", "90", "100", "110", "170", "180",
        "200", "210", "220", "240", "250", "260", "270"};   // "190" - кондиционер, пока закоментарен
        
      for(int j=0; j < labels.length; j++) {
        String i = "" + labels [j];
        String label = "label.mountact2.label" + i;
        String resource = "resource" + i;
        String serial = "serial" + i;
        String qty = "qty" + i;
        String comment = "comment" + i;
        String div = "div" + i;
        String categ = "categoryResources" + i;
        String change = "changeVis(categoryResources" + i + "_arr, document.all.div" + i + ", document.all.resource" + i + ");";

		String idc = frm.getCategoryId((new Integer(i)).intValue());
   %>
      <% if ("200".equals(i)) { %>
        <TR class="print">
          <TD colspan="4" class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
            <CENTER><bean:message key="label.mountact2.title4"/> <bean:message key="label.mountact2.title5"/></CENTER>
          </TD>
        </TR>
      <% } %>
      
      <TR class="print">
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"><bean:message key="<%= label %>"/></TD>
        <TD class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 2; padding-bottom: 2;">
          <DIV><july:errors property="<%= resource %>" shortformat="true"/></DIV>
    			<july:select collection="<%= categ %>" property="<%= resource %>"
					  onchange="<%= change %>"
					  style="font-size:8pt;width:80%;"
					  insertable="true" updatable="true">
    				  <html:option value="">&nbsp;</html:option>
    				  <july:options collection="<%= categ %>" property="resource" labelProperty="model" addProperty="countpolicy"/>
    			</july:select>
									

				<SCRIPT language="JScript">
				function open_window<%=i%>() {
					myWindow = window.open("/dict/ShowInvResourceListWN.do?category=<%=idc%>", "newWindow", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes");  
					myWindow.focus();
				}
				</SCRIPT>				
				
				<A HREF="#" name="lookupbtn_style" onclick="open_window<%=i%>(); return false;"><img name="lookupimg_style" src="/images/bd.gif" border="0" alt="Настройка элементов выпадающего списка"></A>	
				
				

        </TD>
        <TD class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
          <SPAN ID="<%= div %>">
            <DIV><july:errors property="<%= serial %>" shortformat="true"/></DIV>
            <july:string property="<%= serial %>"
              style="font-size:8pt;"
              size="10" insertable="true" updatable="true"/>
          </SPAN>
          <SPAN ID="<%= div %>">
            <DIV><july:errors property="<%= serial %>" shortformat="true"/></DIV>
            <july:string property="<%= qty %>" size="5"
              style="font-size:8pt;"
              insertable="true" updatable="true"/>&nbsp;<bean:message key="label.mountact2.qty"/></TD>
          </SPAN>
        </TD>
        <TD class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
          <SPAN ID="<%= div %>">
            <july:string property="<%= comment %>" size="10"
              style="font-size:8pt;"
              insertable="true" updatable="true"/>
          </SPAN>
        </TD>
      </TR>
      <SCRIPT>
        <%= change %>
      </SCRIPT>
   <%
      }
   %>

      <%--
      <TR class="print">
        <TD class="print"><bean:message key="label.mountact2.label120"/></TD>
        <TD class="print">&nbsp;</TD>
        <TD class="print">&nbsp;</TD>
        <TD class="print">&nbsp;</TD>
      </TR>

      <TR class="print">
        <TD class="print"><bean:message key="label.mountact2.label130"/></TD>
        <TD class="print">&nbsp;</TD>
        <TD class="print">&nbsp;</TD>
        <TD class="print">&nbsp;</TD>
      </TR>

      <TR class="print">
        <TD class="print"><bean:message key="label.mountact2.label140"/></TD>
        <TD class="print">&nbsp;</TD>
        <TD class="print">&nbsp;</TD>
        <TD class="print">&nbsp;</TD>
      </TR>

      <TR class="print">
        <TD class="print"><bean:message key="label.mountact2.label150"/></TD>
        <TD class="print">&nbsp;</TD>
        <TD class="print">&nbsp;</TD>
        <TD class="print">&nbsp;</TD>
      </TR>

      <TR class="print">
        <TD class="print"><bean:message key="label.mountact2.label160"/></TD>
        <TD class="print">&nbsp;</TD>
        <TD class="print">&nbsp;</TD>
        <TD class="print">&nbsp;</TD>
      </TR>

      --%>



      </TABLE>

      <TABLE class="print" style="font-size:8pt;">
      <TR class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
        <TD width="15%" class="print"><bean:message key="label.mountact2.organization"/></TD>
        <TD width="35%" class="print">
          <DIV><july:errors property="podr" shortformat="true"/></DIV>
    			<html:hidden property="providercode" />
    			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="provl" fieldNames="providercode;providername" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_provl('?selisprovider=true&selisrenter=false&selissupplier=false');"/>
    			<july:string size="15" property="providername"
            style="font-size:8pt; width:200px;"
            styleId="providername" insertable="false" updatable="false" />
        </TD>
        <TD width="30%" class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
           <DIV><july:errors property="insman" shortformat="true"/></DIV>
			     <july:string size="15" property="insuranceMan"
              style="font-size:8pt; width:200px;"
              insertable="true" updatable="true" />
        </TD>
        <TD width="20%" class="print">&nbsp;</TD>
      </TR>
      <TR class="print">
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;"><bean:message key="label.mountact2.customer"/></TD>
        <TD class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
    			<july:select collection="owners" property="ownercode"
              style="font-size:8pt;"
              insertable="true" updatable="true">
    				<html:options collection="owners" property="organization" labelProperty="name"/>
    			</july:select>
        </TD>
        <TD class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
          <DIV><july:errors property="worker" shortformat="true"/></DIV>
    			<html:hidden property="workercode"/>
    			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work1l" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
    			<july:string size="15" property="workername" styleId="workername"
              style="font-size:8pt; width:200px;"
              insertable="false" updatable="false" />
    			<html:hidden property="workertitle"/>
        </TD>
        <TD class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
          <DIV><july:errors property="actdate" shortformat="true"/></DIV>
          <july:date property="actdate" size="25"
              style="font-size:8pt; width: 100px;" required="false"
              insertable="true" updatable="true" />
        </TD>
      </TR>
      <TR class="print">
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">&nbsp;</TD>
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;"><bean:message key="label.mountact2.header6"/></TD>
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;"><bean:message key="label.mountact2.header7"/></TD>
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;"><bean:message key="label.mountact2.header8"/></TD>
      </TR>
      </TABLE>
      
    </TD></TR>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>

</july:editform>


