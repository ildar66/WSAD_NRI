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
	int rpCount = frm2.getRPCount();
	HashMap xlserrors = (HashMap)request.getSession().getAttribute("xlserrors");
	boolean changable = "1".equals(frm2.getDocumentState()) && !frm2.getIsautodoc();
%>


	<%--    Репитер --%>

	<tr>
		<td colspan="2">
		<table class="print" style="font-size:8pt;" id="rptable">

		<tr class="print">
		<td class="print" colspan="10" style="background-color: DCDCDC;">		
		<a title="Спрятать/показать параметры добавления" href="javascript:toggleDetail('rpID')">
			<B>Репитер</B>
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
		<td class="print" colspan="10">

			<table id="rpID" style="font-size:8pt;" width="100%">
				<tr>
					<td>
						Тип:

						<july:select collection="RPResourcesList" property="rptypetmp" insertable="true" updatable="true">
								<july:options collection="RPResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
						</july:select>
						&nbsp;&nbsp;
						Кол-во:
						<july:string property="rpcnttmp"
							size="5"
							style="font-size:8pt;"
							insertable="true" updatable="true"/>

						<IMG SRC="/images/plus.gif" onclick="addRPP();" BORDER=0>
					</td>
					<td align="right">
						<B>Комплект</B>&nbsp;
						<html:hidden property="complectrp"/>
						<july:string size="20" property="complectrpname" styleId="complectrpname" insertable="false" updatable="false" />
						<july:lookupbutton action="/ShowComplectLookupList.do" styleId="c12" fieldNames="complectrp;complectrpname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_c12('?position='+document.all.positioncode.value)"/>
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
		<td class="print" width="120">
		Тип репитера
		</td>
		<td class="print" width="70">
		Диапазон
		</td>
		<td class="print" width="200">
		Комплект
		</td>
		<td class="print" width="30">
		&nbsp;
		</td>
		</tr>

		<% for (int i2=0; i2 < rpCount; i2++) { 
			
			PosVO bpvo= (PosVO)frm2.getRip(i2);			
			ArrayList riperrors = bpvo.getCalcerrors();
			boolean hasErrors = !riperrors.isEmpty();	

			boolean typeError = bpvo.getType()!= null && bpvo.getType().intValue() == 0 && xlserrors!=null;
			boolean snError = bpvo.isSnError(bpvo.getSn());

			int idc = bpvo.getResourcecateg();
		%>
		<%if(hasErrors){
		    Iterator iter = riperrors.iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%>
		<tr><td class="print" colspan="8"><IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<b><FONT style="color: red; font-size: 8pt;"><%=error%></FONT></b></td></tr>
		<%  }
		 }%>

		<tr <%if(hasErrors){%>style="background-color: FF7F9A;"<%}%>>
			<td class="print" width="5">
			<html:hidden property='<%= "rip["+i2+"].id"%>'/>
			<html:hidden property='<%= "rip["+i2+"].resourcecateg"%>'/>
			<html:hidden property='<%= "rip["+i2+"].position"%>'/>
			<%=i2+1%>
			</td>
			<td class="print" width="80">Репитер</td>
			<td class="print" <%if(typeError){%>style="background-color: FF7F9A;"<%}%> width="160">
				<%if(typeError){
					String error = (String)xlserrors.get(new Integer(bpvo.getPosition()));
				%>
				<b><FONT style="font-size: 8pt;"><%=error%></FONT></b>
				<% }%>

				<july:select collection="RPResourcesList" property='<%= "rip["+i2+"].type"%>' onchange='<%= "changeRP("+i2+");"%>' insertable="true" updatable="true" style="font-size:8pt; width: 140px;">
						<html:option value="0">&nbsp;</html:option>
						<july:options collection="RPResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
				</july:select>
				<%String dpage = "/showCategoryResources.jsp?compid=rip&number=" + i2 + "&idc=" + idc;%>
				<jsp:include page='<%= dpage%>' flush="true"></jsp:include>
			</td>
			<td class="print" width="70">
				<span id="ripsp<%=i2%>"><july:string property='<%= "rip["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="160" <%if(snError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(snError){%>
				<b><FONT style="font-size: 8pt;">Указано несколько с/н</FONT></b>
				<% }%>

				<span id="ripsp<%=i2%>"><july:string property='<%= "rip["+i2+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" />

				<%String checkFict = "checkFictionSerial('rip',"+i2+");";%>
				<july:checkbox property='<%= "rip["+i2+"].fictionSerial"%>' insertable="true" updatable="true" value="true" styleClass="text" onclick="<%=checkFict%>"/>
				<script language="javascript">
					<%=checkFict%>
				</script>
				</span>
			</td>		
			<td class="print">
				<span id="ripsp<%=i2%>" width="80"><july:string property='<%= "rip["+i2+"].comment"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="120">
				<span id="ripsp<%=i2%>"><july:string property='<%= "rip["+i2+"].note"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="70">
				<span id="ripsp<%=i2%>"><july:string property='<%= "rip["+i2+"].roomnumber"%>' style="font-size:8pt;" size="5" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="200">

				<span id="ripsp<%=i2%>"><html:hidden property='<%= "rip["+i2+"].complect"%>'/><html:text property='<%= "rip["+i2+"].complectname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="25" readonly="true"/>
				 
				<%String cpage = "/ShowComplectContractor.jsp?compid=rip&number=" + i2;%>
				<jsp:include page='<%= cpage%>' flush="true"></jsp:include>

				</span>
			</td>
			<td class="print" width="30">
				<input type="image" src="/images/del.gif" onclick="delRP();return false;" name="delRP"/>
			</td>
			<script language="javascript">
				var table = document.getElementById('rptable');
				table.rows(<%=i2+3%>).onmouseover = saveRPIndex;
			</script>
			<%if(!typeError){%>
				<script language="javascript">
					changeRP(<%=i2%>);
				</script>
			<%}%>
		</tr>


		<%}%>


		</table>
		</td>
	</tr>


	<script language="javascript">		
		toggleDetail('rpID');
	</script>