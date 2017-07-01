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
	int cbsCount = frm2.getCBSCount();
	int cbpCount = frm2.getCBPCount();
	HashMap xlserrors = (HashMap)request.getSession().getAttribute("xlserrors");
	boolean changable = "1".equals(frm2.getDocumentState()) && !frm2.getIsautodoc();
%>

<%--    Аппаратура контроллера базовых станций --%>

	<script language="javascript">
		<%=frm2.getCbsJSData()%>
	</script>

	<tr>
		<td colspan="2">
		<table class="print" style="font-size:8pt;" id="cbstable">

		<tr class="print">
		<td class="print" colspan="9" style="background-color: DCDCDC;">		
		<a title="Спрятать/показать параметры добавления" href="javascript:toggleDetail('cbsID')">
			<B>Контроллер</B>
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

			<table id="cbsID" style="font-size:8pt;" width="100%">
				<tr>
					<td>

					<html:select property='cbscategtmp'  style="background-color: D6EBFF;" onchange="refreshCBS();" >
							<html:option value="1">Основная стойка</html:option>
							<html:option value="2">Стойка расширения</html:option>
					</html:select>
					&nbsp;&nbsp;
					Тип:
					<july:select collection="CBSResourcesList" property="cbstypetmp" insertable="true" updatable="true">
							<july:options collection="CBSResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
					</july:select>
					&nbsp;&nbsp;
					Кол-во:
					<july:string property="cbscnttmp"
						size="5"
						style="font-size:8pt;"
						insertable="true" updatable="true"/>
					<IMG SRC="/images/plus.gif" onclick="addCBS();" BORDER=0>

					</td>
					<td align="right">	

					<B>Комплект</B>&nbsp;
					<html:hidden property="complectcbs"/>
					<july:string size="20" property="complectcbsname" styleId="complectcbsname" insertable="false" updatable="false" />
					<july:lookupbutton action="/ShowComplectLookupList.do" styleId="c10" fieldNames="complectcbs;complectcbsname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_c10('?position='+document.all.positioncode.value)"/>

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

		<% for (int i2=0; i2 < cbsCount; i2++) { 
					
			PosVO bpvo= (PosVO)frm2.getCbis(i2);
			
			ArrayList cbiserrors = bpvo.getCalcerrors();
			boolean hasErrors = !cbiserrors.isEmpty();

			boolean typeError = bpvo.getType()!=null && bpvo.getType().intValue() == 0 && xlserrors!=null;
			boolean snError = bpvo.isSnError(bpvo.getSn());

			String catS = "";
			int cat = bpvo.getCateg().intValue();
			if(cat==1) catS="Основная стойка";
			else if(cat==2) catS="Стойка расширения";

			int idc = bpvo.getResourcecateg();
		%>	
		<%if(hasErrors){
		    Iterator iter = cbiserrors.iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%>
		<tr><td class="print" colspan="8"><IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<b><FONT style="color: red; font-size: 8pt;"><%=error%></FONT></b></td></tr>
		<%  }
		 }%>        

		<tr <%if(hasErrors){%>style="background-color: FF7F9A;"<%}%>>
			<td class="print" width="5">
			<html:hidden property='<%= "cbis["+i2+"].categ"%>'/>
			<html:hidden property='<%= "cbis["+i2+"].resourcecateg"%>'/>
			<html:hidden property='<%= "cbis["+i2+"].position"%>'/>
			<%=i2+1%>
			</td>
			<td class="print" width="80"><html:hidden property='<%= "cbis["+i2+"].id"%>'/><%=catS%></td>
			<td class="print" <%if(typeError){%>style="background-color: FF7F9A;"<%}%> width="160">
				<%if(typeError){
					String error = (String)xlserrors.get(new Integer(bpvo.getPosition()));
				%>
				<b><FONT style="font-size: 8pt;"><%=error%></FONT></b>
				<% }%>

				<july:select collection="CBSResourcesList" property='<%= "cbis["+i2+"].type"%>' onchange='<%= "changeCBS("+i2+");"%>' insertable="true" updatable="true" style="font-size:8pt; width: 140px;">
						<html:option value="0">&nbsp;</html:option>
						<july:options collection="CBSResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
				</july:select>
				<%String dpage = "/showCategoryResources.jsp?compid=cbis&number=" + i2 + "&idc=" + idc;%>
				<jsp:include page='<%= dpage%>' flush="true"></jsp:include>
			</td>

			<%if(changable){%>
				<script language="javascript">	
					refreshRow(<%= "'cbis["+i2+"].type'"%>,<%=cat%>,cbsjs);
				</script>
			<%}%>

			<td class="print" width="70">
				<span id="cbissp<%=i2%>"><july:string property='<%= "cbis["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="160" <%if(snError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(snError){%>
				<b><FONT style="font-size: 8pt;">Указано несколько с/н</FONT></b>
				<% }%>

				<span id="cbissp<%=i2%>"><july:string property='<%= "cbis["+i2+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" />

				<%String checkFict = "checkFictionSerial('cbis',"+i2+");";%>
				<july:checkbox property='<%= "cbis["+i2+"].fictionSerial"%>' insertable="true" updatable="true" value="true" styleClass="text" onclick="<%=checkFict%>"/>
				<script language="javascript">
					<%=checkFict%>
				</script>
				</span>
			</td>			
			<td class="print" width="120">
				<span id="cbissp<%=i2%>"><july:string property='<%= "cbis["+i2+"].note"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="70">
				<span id="cbissp<%=i2%>"><july:string property='<%= "cbis["+i2+"].roomnumber"%>' style="font-size:8pt;" size="5" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="200">

				<span id="cbissp<%=i2%>"><html:hidden property='<%= "cbis["+i2+"].complect"%>'/><html:text property='<%= "cbis["+i2+"].complectname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="25" readonly="true"/>
				 
				<%String cpage = "/ShowComplectContractor.jsp?compid=cbis&number=" + i2;%>
				<jsp:include page='<%= cpage%>' flush="true"></jsp:include>

				</span>
			</td>
			<td class="print" width="30">
				<input type="image" src="/images/del.gif" onclick="delCBS();return false;" name="delCBS"/>
			</td>
			<script language="javascript">
				var table = document.getElementById('cbstable');
				table.rows(<%=i2+3%>).onmouseover = saveCBSIndex;
			</script>
			<%if(!typeError){%>
				<script language="javascript">
					changeCBS(<%=i2%>);
				</script>
			<%}%>
		</tr>


		<%}%>


		</table>
		</td>
	</tr>


	<%--    Источник питания контроллера базовых станций --%>

	<tr>
		<td colspan="2">
		<table class="print" style="font-size:8pt;" id="cbptable">

		<tr class="print">
		<td class="print" colspan="10" style="background-color: DCDCDC;">		
		<a title="Спрятать/показать параметры добавления" href="javascript:toggleDetail('cbpID')">
			<B>Источник питания контроллера базовых станций</B>
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

			<table id="cbpID" style="font-size:8pt;" width="100%">
				<tr>
					<td>
						Тип:

						<july:select collection="CBPResourcesList" property="cbptypetmp" insertable="true" updatable="true">
								<july:options collection="CBPResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
						</july:select>
						&nbsp;&nbsp;
						Кол-во:
						<july:string property="cbpcnttmp"
							size="5"
							style="font-size:8pt;"
							insertable="true" updatable="true"/>

						<IMG SRC="/images/plus.gif" onclick="addCBP();" BORDER=0>

					</td>
					<td align="right">			

						<B>Комплект</B>&nbsp;
						<html:hidden property="complectcbp"/>
						<july:string size="20" property="complectcbpname" styleId="complectcbpname" insertable="false" updatable="false" />
						<july:lookupbutton action="/ShowComplectLookupList.do" styleId="c11" fieldNames="complectcbp;complectcbpname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_c11('?position='+document.all.positioncode.value)"/>

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
		Привязка к BSC
		</td>
		<td class="print" width="70">
		Батареи
		</td>
		<td class="print" width="200">
		Комплект
		</td>
		<td class="print" width="30">
		&nbsp;
		</td>
		</tr>

		<% for (int i2=0; i2 < cbpCount; i2++) { 
			
			PosVO bpvo= (PosVO)frm2.getCbip(i2);			
			ArrayList cbiperrors = bpvo.getCalcerrors();
			boolean hasErrors = !cbiperrors.isEmpty();	

			boolean typeError = bpvo.getType()!=null && bpvo.getType().intValue() == 0 && xlserrors!=null;
			boolean snError = bpvo.isSnError(bpvo.getSn());

			int idc = bpvo.getResourcecateg();
		%>
		<%if(hasErrors){
		    Iterator iter = cbiperrors.iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%>
		<tr><td class="print" colspan="8"><IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<b><FONT style="color: red; font-size: 8pt;"><%=error%></FONT></b></td></tr>
		<%  }
		 }%>

		<tr <%if(hasErrors){%>style="background-color: FF7F9A;"<%}%>>
			<td class="print" width="5">
			<html:hidden property='<%= "cbip["+i2+"].id"%>'/>
			<html:hidden property='<%= "cbip["+i2+"].resourcecateg"%>'/>
			<html:hidden property='<%= "cbip["+i2+"].position"%>'/>
			<%=i2+1%>
			</td>
			<td class="print" width="80">Источник питания</td>
			<td class="print" <%if(typeError){%>style="background-color: FF7F9A;"<%}%> width="160">
				<%if(typeError){
					String error = (String)xlserrors.get(new Integer(bpvo.getPosition()));
				%>
				<b><FONT style="font-size: 8pt;"><%=error%></FONT></b>
				<% }%>

				<july:select collection="CBPResourcesList" property='<%= "cbip["+i2+"].type"%>' onchange='<%= "changeCBP("+i2+");"%>' insertable="true" updatable="true" style="font-size:8pt; width: 140px;">
						<html:option value="0">&nbsp;</html:option>
						<july:options collection="CBPResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
				</july:select>
				<%String dpage = "/showCategoryResources.jsp?compid=cbip&number=" + i2 + "&idc=" + idc;%>
				<jsp:include page='<%= dpage%>' flush="true"></jsp:include>
			</td>
			<td class="print" width="70">
				<span id="cbipsp<%=i2%>"><july:string property='<%= "cbip["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="160" <%if(snError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(snError){%>
				<b><FONT style="font-size: 8pt;">Указано несколько с/н</FONT></b>
				<% }%>

				<span id="cbipsp<%=i2%>"><july:string property='<%= "cbip["+i2+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" />

				<%String checkFict = "checkFictionSerial('cbip',"+i2+");";%>
				<july:checkbox property='<%= "cbip["+i2+"].fictionSerial"%>' insertable="true" updatable="true" value="true" styleClass="text" onclick="<%=checkFict%>"/>
				<script language="javascript">
					<%=checkFict%>
				</script>
				</span>
			</td>	
			<td class="print">
				<span id="cbipsp<%=i2%>" width="80"><july:string property='<%= "cbip["+i2+"].comment"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="120">
				<span id="cbipsp<%=i2%>"><july:string property='<%= "cbip["+i2+"].note"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="70">
				<span id="cbipsp<%=i2%>"><july:string property='<%= "cbip["+i2+"].roomnumber"%>' style="font-size:8pt;" size="5" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="200">

				<span id="cbipsp<%=i2%>"><html:hidden property='<%= "cbip["+i2+"].complect"%>'/><html:text property='<%= "cbip["+i2+"].complectname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="25" readonly="true"/>
				 
				<%String cpage = "/ShowComplectContractor.jsp?compid=cbip&number=" + i2;%>
				<jsp:include page='<%= cpage%>' flush="true"></jsp:include>

				</span>
			</td>
			<td class="print" width="30">
				<input type="image" src="/images/del.gif" onclick="delCBP();return false;" name="delCBP"/>
			</td>
			<script language="javascript">
				var table = document.getElementById('cbptable');
				table.rows(<%=i2+3%>).onmouseover = saveCBPIndex;
			</script>
			<%if(!typeError){%>
				<script language="javascript">
					changeCBP(<%=i2%>);
				</script>
			<%}%>
		</tr>


		<%}%>


		</table>
		</td>
	</tr>

	<%if(changable){%>
		<script language="javascript">
			refreshCBS();
		</script>
	<%}%>

	<script language="javascript">		
		toggleDetail('cbsID');
		toggleDetail('cbpID');
	</script>