<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.inventory.formbean.*"%>
<%@ page import="java.util.*"%>


<%
	ContractorInventoryForm frm2 = (ContractorInventoryForm)request.getSession().getAttribute("ContractorInventoryForm");	
	int stioCount = frm2.getSTIOCount();
	boolean changable = "1".equals(frm2.getDocumentState()) && !frm2.getIsautodoc();
%>


	<%--    Старое оборудование --%>

	<tr>
		<td colspan="2">
		<table class="print" style="font-size:8pt;" id="stiotable">

		<tr class="print">
		<td class="print" colspan="9" style="background-color: DCDCDC;">
			<B>Старое оборудование</B>
			&nbsp;
			<%if(changable){%>
				<A href='ContrEquipList.do?action=Edit&storageplace=<%=frm2.getStorageplace()%>&act=<%=frm2.getIdact()%>' onclick='window.open(this.href, "contrEquipList", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes").focus(); return false;'>
					<IMG SRC="/images/details.gif" BORDER='0' ALT='Список оборудования'>
				</A>
			<%}%>
		</td>
		
		</tr>

		<tr>
		<td class="print" width="5">
		№
		</td>
		<td class="print" width="80">
		Наименование
		</td>
		<td class="print" width="160">
		Тип
		</td>
		<td class="print" width="70">
		Кол-во
		</td>
		<td class="print" width="160">
		Серийный №
		</td>		
		<td class="print" width="120">
		Примечание
		</td>
		<td class="print" width="70">
		№ помещ
		</td>
		<td class="print" width="200">
		Комплект
		</td>
		<td class="print" width="30">
		&nbsp;
		</td>
		</tr>

		<% for (int i2=0; i2 < stioCount; i2++) { 
			
			PosVO bpvo= (PosVO)frm2.getStio(i2);			
			
			int idc = bpvo.getResourcecateg();
		%>

		<tr>
			<td class="print" width="5">
			<html:hidden property='<%= "stio["+i2+"].id"%>'/>
			<html:hidden property='<%= "stio["+i2+"].resourcecateg"%>'/>
			<html:hidden property='<%= "stio["+i2+"].position"%>'/>
			<%=i2+1%>
			</td>
			<td class="print" width="80">
				<html:text property='<%= "stio["+i2+"].categname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="12" readonly="true"/>
			</td>
			<td class="print" width="160">
				<july:string property='<%= "stio["+i2+"].typename"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" />

				<%String dpage = "/showResourceContractor.jsp?compid=stio&prefix=o&number=" + i2;%>
				<jsp:include page='<%= dpage%>' flush="true"></jsp:include>
			</td>
			<td class="print" width="70">
				<span id="stiosp<%=i2%>"><july:string property='<%= "stio["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="160" >				
				<span id="stiosp<%=i2%>"><july:string property='<%= "stio["+i2+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" /></span>

				<%String checkFict = "checkFictionSerial('stio',"+i2+");";%>
				<july:checkbox property='<%= "stio["+i2+"].fictionSerial"%>' insertable="true" updatable="true" value="true" styleClass="text" onclick="<%=checkFict%>"/>
				<script language="javascript">
					<%=checkFict%>
				</script>
			</td>			
			<td class="print" width="120">
				<span id="stiosp<%=i2%>"><july:string property='<%= "stio["+i2+"].note"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="70">
				<span id="stiosp<%=i2%>"><july:string property='<%= "stio["+i2+"].roomnumber"%>' style="font-size:8pt;" size="5" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="200">

				<span id="stiosp<%=i2%>"><html:hidden property='<%= "stio["+i2+"].complect"%>'/><html:text property='<%= "stio["+i2+"].complectname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="25" readonly="true"/>
				 
				<%String cpage = "/ShowComplectContractor.jsp?compid=stio&number=" + i2;%>
				<jsp:include page='<%= cpage%>' flush="true"></jsp:include>

				</span>
			</td>
			<td class="print" width="30">
				&nbsp;
			</td>
		</tr>


		<%}%>


		</table>
		</td>
	</tr>