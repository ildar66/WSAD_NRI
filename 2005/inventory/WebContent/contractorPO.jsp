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
	int proCount = frm2.getPROCount();
	HashMap xlserrors = (HashMap)request.getSession().getAttribute("xlserrors");
	boolean changable = "1".equals(frm2.getDocumentState()) && !frm2.getIsautodoc();
%>


	<%--    Прочее оборудование --%>

	<tr>
		<td colspan="2">
		<table class="print" style="font-size:8pt;" id="protable">

		<tr class="print">
		<td class="print" colspan="9" style="background-color: DCDCDC;">		
		<a title="Спрятать/показать параметры добавления" href="javascript:toggleDetail('proID')">
			<B>Прочее оборудование</B>
		</a>
		&nbsp;
			<%if(changable){%>
				<A href='ContrEquipList.do?action=Edit&storageplace=<%=frm2.getStorageplace()%>&act=<%=frm2.getIdact()%>' onclick='window.open(this.href, "contrEquipList", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes").focus(); return false;'>
					<IMG SRC="/images/details.gif" BORDER='0' ALT='Список оборудования'>
				</A>
			<%}%>
		</td>
		</tr>

		<tr class="print">
		<td class="print" colspan="9">

			<table id="proID" style="font-size:8pt;" width="100%">
				<tr>
					<td>
						Тип:

						<july:string size="15" property="protypetmp" styleId="protypetmp" insertable="true" updatable="true" />
						<html:hidden property="propolicytmp"/>
						<july:lookupbutton action="/ShowResourceLookupList.do" styleId="protl" fieldNames="protypetmp;protypetmp;propolicytmp;propolicytmp;propolicytmp;" newWindowName="reslookup" insertable="true" updatable="true"/>

						&nbsp;&nbsp;
						Кол-во:
						<july:string property="procnttmp"
							size="5"
							style="font-size:8pt;"
							insertable="true" updatable="true"/>

						<IMG SRC="/images/plus.gif" onclick="addPRO();" BORDER=0>
					</td>
					<td align="right">
						<B>Комплект</B>&nbsp;
						<html:hidden property="complectpro"/>
						<july:string size="20" property="complectproname" styleId="complectproname" insertable="false" updatable="false" />
						<july:lookupbutton action="/ShowComplectLookupList.do" styleId="c15" fieldNames="complectpro;complectproname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_c15('?position='+document.all.positioncode.value)"/>
					</td>
				</tr>
			</table>

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

		<% for (int i2=0; i2 < proCount; i2++) { 
			
			PosVO bpvo= (PosVO)frm2.getPrio(i2);			
			ArrayList prioerrors = bpvo.getCalcerrors();
			boolean hasErrors = !prioerrors.isEmpty();	

			boolean typeError = (bpvo.getTypename()== null || (bpvo.getTypename()!= null && bpvo.getTypename().equals("")))  && xlserrors!=null;
			boolean snError = bpvo.isSnError(bpvo.getSn());
			int idc = bpvo.getResourcecateg();
		%>
		<%if(hasErrors){
		    Iterator iter = prioerrors.iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%>
		<tr><td class="print" colspan="8"><IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<b><FONT style="color: red; font-size: 8pt;"><%=error%></FONT></b></td></tr>
		<%  }
		 }%>

		<tr <%if(hasErrors){%>style="background-color: FF7F9A;"<%}%>>
			<td class="print" width="5">
			<html:hidden property='<%= "prio["+i2+"].id"%>'/>
			<html:hidden property='<%= "prio["+i2+"].resourcecateg"%>'/>
			<html:hidden property='<%= "prio["+i2+"].position"%>'/>
			<html:hidden property='<%= "prio["+i2+"].policy"%>'/>
			<%=i2+1%>
			</td>
			<td class="print" width="80">
				<%--<july:string property='<%= "prio["+i2+"].categname"%>' style="background-color: DCDCDC;font-size:8pt;" size="10" insertable="true" updatable="true" />--%>

				<html:text property='<%= "prio["+i2+"].categname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="12" readonly="true"/>
			</td>
			<td class="print" <%if(typeError){%>style="background-color: FF7F9A;"<%}%> width="160">
				<%if(typeError){
					String error = (String)xlserrors.get(new Integer(bpvo.getPosition()));
				%>
				<b><FONT style="font-size: 8pt;"><%=error%></FONT></b>
				<% }%>

				<july:string property='<%= "prio["+i2+"].typename"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" />

				<%String dpage = "/showResourceContractor.jsp?compid=prio&prefix=t&number=" + i2;%>
				<jsp:include page='<%= dpage%>' flush="true"></jsp:include>
			</td>
			<td class="print" width="70">
				<span id="priosp<%=i2%>"><july:string property='<%= "prio["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="160" <%if(snError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(snError){%>
				<b><FONT style="font-size: 8pt;">Указано несколько с/н</FONT></b>
				<% }%>

				<span id="priosp<%=i2%>"><july:string property='<%= "prio["+i2+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" />

				<%String checkFict = "checkFictionSerial('prio',"+i2+");";%>
				<july:checkbox property='<%= "prio["+i2+"].fictionSerial"%>' insertable="true" updatable="true" value="true" styleClass="text" onclick="<%=checkFict%>"/>
				<script language="javascript">
					<%=checkFict%>
				</script>
				</span>
			</td>			
			<td class="print" width="120">
				<span id="priosp<%=i2%>"><july:string property='<%= "prio["+i2+"].note"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="70">
				<span id="priosp<%=i2%>"><july:string property='<%= "prio["+i2+"].roomnumber"%>' style="font-size:8pt;" size="5" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="200">

				<span id="priosp<%=i2%>"><html:hidden property='<%= "prio["+i2+"].complect"%>'/><html:text property='<%= "prio["+i2+"].complectname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="25" readonly="true"/>
				 
				<%String cpage = "/ShowComplectContractor.jsp?compid=prio&number=" + i2;%>
				<jsp:include page='<%= cpage%>' flush="true"></jsp:include>

				</span>
			</td>
			<td class="print" width="30">
				<input type="image" src="/images/del.gif" onclick="delPRO();return false;" name="delPRO"/>
			</td>
			<script language="javascript">
				var table = document.getElementById('protable');
				table.rows(<%=i2+3%>).onmouseover = savePROIndex;
			</script>
			<%if(!typeError){%>
				<script language="javascript">
					changePRO(<%=i2%>);
				</script>
			<%}%>
		</tr>


		<%}%>


		</table>
		</td>
	</tr>

	<script language="javascript">		
		toggleDetail('proID');
	</script>