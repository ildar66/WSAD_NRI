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
	ContractorInventoryForm frm = (ContractorInventoryForm)request.getSession().getAttribute("ContractorInventoryForm");
	
	int soCount = frm.getSOCount();
	int poCount = frm.getPOCount();
	HashMap xlserrors = (HashMap)request.getSession().getAttribute("xlserrors");
	boolean changable = "1".equals(frm.getDocumentState()) && !frm.getIsautodoc();
%>

<%--    Силовое оборудование --%>

	<script language="javascript">
		<%=frm.getSoJSData()%>
	</script>

	<tr>
		<td colspan="2">
		<table class="print" style="font-size:8pt;" id="sotable">

		<tr class="print">
		<td class="print" colspan="9" style="background-color: DCDCDC;">		
		<a title="Спрятать/показать параметры добавления" href="javascript:toggleDetail('soID')">
			<B>Силовое оборудование</B>
		</a>
		&nbsp;
			<%if(changable){%>
				<A href='ContrEquipList.do?action=Edit&storageplace=<%=frm.getStorageplace()%>&act=<%=frm.getIdact()%>' onclick='window.open(this.href, "contrEquipList", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes").focus(); return false;'>
					<IMG SRC="/images/details.gif" BORDER='0' ALT='Список оборудования'>
				</A>
			<%}%>
		</td>
		</tr>

		<tr class="print">
		<td class="print" colspan="9">

			<table id="soID" style="font-size:8pt;" width="100%">
				<tr>
					<td>
					<html:select property='socategtmp'  style="background-color: D6EBFF;" onchange="refreshSO();" >
							<html:option value="1">Щит питания</html:option>
							<html:option value="2">АВР</html:option>
							<html:option value="3">Панель коммутационная</html:option>
					</html:select>
					&nbsp;&nbsp;
					Тип:
					<july:select collection="SOResourcesList" property="sotypetmp" insertable="true" updatable="true">
							<july:options collection="SOResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
					</july:select>
					&nbsp;&nbsp;
					Кол-во:
					<july:string property="socnttmp"
						size="5"
						style="font-size:8pt;"
						insertable="true" updatable="true"/>

					<IMG SRC="/images/plus.gif" onclick="addSOO();" BORDER=0>

					</td>
					<td align="right">

					<B>Комплект</B>&nbsp;
					<html:hidden property="complectso"/>
					<july:string size="20" property="complectsoname" styleId="complectsoname" insertable="false" updatable="false" />
					<july:lookupbutton action="/ShowComplectLookupList.do" styleId="c6" fieldNames="complectso;complectsoname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_c6('?position='+document.all.positioncode.value)"/>

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

		<% for (int i2=0; i2 < soCount; i2++) { 
					
			PosVO bpvo= (PosVO)frm.getSio(i2);
			
			ArrayList sioerrors = bpvo.getCalcerrors();
			boolean hasErrors = !sioerrors.isEmpty();

			boolean typeError = bpvo.getType()!=null && bpvo.getType().intValue() == 0 && xlserrors!=null;
			boolean snError = bpvo.isSnError(bpvo.getSn());
			int idc = bpvo.getResourcecateg();

			String catS = "";
			int cat = bpvo.getCateg().intValue();
			if(cat==1) catS="Щит питания";
			else if(cat==2) catS="АВР";
			else if(cat==3) catS="Панель коммутационная";
		%>
		<%if(hasErrors){
		    Iterator iter = sioerrors.iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%>
		<tr><td class="print" colspan="8"><IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<b><FONT style="color: red; font-size: 8pt;"><%=error%></FONT></b></td></tr>
		<%  }
		 }%>

		<tr <%if(hasErrors){%>style="background-color: FF7F9A;"<%}%>>
			<td class="print" width="5">
			<html:hidden property='<%= "sio["+i2+"].categ"%>'/>
			<html:hidden property='<%= "sio["+i2+"].resourcecateg"%>'/>
			<html:hidden property='<%= "sio["+i2+"].position"%>'/>
			<%=i2+1%>
			</td>
			<td class="print" width="80"><html:hidden property='<%= "sio["+i2+"].id"%>'/><%=catS%></td>
			<td class="print" <%if(typeError){%>style="background-color: FF7F9A;"<%}%> width="160">	
				<%if(typeError){
					String error = (String)xlserrors.get(new Integer(bpvo.getPosition()));
				%>
				<b><FONT style="color: red; font-size: 8pt;"><%=error%></FONT></b>
				<% }%>

				<july:select collection="SOResourcesList" onchange='<%= "changeSO("+i2+");"%>' property='<%= "sio["+i2+"].type"%>' insertable="true" updatable="true" style="font-size:8pt; width: 140px;">
						<html:option value="0">&nbsp;</html:option>
						<july:options collection="SOResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
				</july:select>
				<%String dpage = "/showCategoryResources.jsp?compid=sio&number=" + i2 + "&idc=" + idc;%>
				<jsp:include page='<%= dpage%>' flush="true"></jsp:include>
			</td>

			<%if(changable){%>
				<script language="javascript">	
					refreshRow(<%= "'sio["+i2+"].type'"%>,<%=cat%>,sojs);
				</script>
			<%}%>

			<td class="print" width="70">
				<span id="siosp<%=i2%>"><july:string property='<%= "sio["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="160" <%if(snError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(snError){%>
				<b><FONT style="font-size: 8pt;">Указано несколько с/н</FONT></b>
				<% }%>

				<span id="siosp<%=i2%>"><july:string property='<%= "sio["+i2+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" />

				<%String checkFict = "checkFictionSerial('sio',"+i2+");";%>
				<july:checkbox property='<%= "sio["+i2+"].fictionSerial"%>' insertable="true" updatable="true" value="true" styleClass="text" onclick="<%=checkFict%>"/>
				<script language="javascript">
					<%=checkFict%>
				</script>
				</span>
			</td>			
			<td class="print" width="120">
				<span id="siosp<%=i2%>"><july:string property='<%= "sio["+i2+"].note"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="70">
				<span id="siosp<%=i2%>"><july:string property='<%= "sio["+i2+"].roomnumber"%>' style="font-size:8pt;" size="5" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="200">

				<span id="siosp<%=i2%>"><html:hidden property='<%= "sio["+i2+"].complect"%>'/><html:text property='<%= "sio["+i2+"].complectname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="25" readonly="true"/>
				 
				<%String cpage = "/ShowComplectContractor.jsp?compid=sio&number=" + i2;%>
				<jsp:include page='<%= cpage%>' flush="true"></jsp:include>

				</span>
			</td>
			<td class="print" width="30">
				<input type="image" src="/images/del.gif" onclick="delSO();return false;" name="delSO"/>
			</td>
			<script language="javascript">
				var table = document.getElementById('sotable');
				table.rows(<%=i2+3%>).onmouseover = saveSOIndex;
			</script>
			
			<%if(!typeError){%>
				<script language="javascript">
					changeSO(<%=i2%>);
				</script>
			<%}%>
			
		</tr>


		<%}%>


		</table>
		</td>
	</tr>




	<%--    Прочее оборудование --%>

	<script language="javascript">
		<%=frm.getPoJSData()%>
	</script>

	<tr>
		<td colspan="2">
		<table class="print" style="font-size:8pt;" id="potable">

		<tr class="print">
		<td class="print" colspan="9" style="background-color: DCDCDC;">		
		<a title="Спрятать/показать параметры добавления" href="javascript:toggleDetail('poID')">
			<B>Прочее оборудование</B>
		</a>
		&nbsp;
			<%if(changable){%>
				<A href='ContrEquipList.do?action=Edit&storageplace=<%=frm.getStorageplace()%>&act=<%=frm.getIdact()%>' onclick='window.open(this.href, "contrEquipList", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes").focus(); return false;'>
					<IMG SRC="/images/details.gif" BORDER='0' ALT='Список оборудования'>
				</A>
			<%}%>
		</td>
		</tr>

		<tr class="print">
		<td class="print" colspan="9">

			<table id="poID" style="font-size:8pt;" width="100%">
				<tr>
					<td>
					<html:select property='pocategtmp'  style="background-color: D6EBFF;" onchange="refreshPO();" >
							<html:option value="1">Кондиционер</html:option>
							<html:option value="2">Панель сигнализации</html:option>
							<html:option value="3">Источник питания УЗО</html:option>
							<html:option value="4">Преобразователь УЗО</html:option>
					</html:select>
					&nbsp;&nbsp;
					Тип:
					<july:select collection="POResourcesList" property="potypetmp" insertable="true" updatable="true">
							<july:options collection="POResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
					</july:select>
					&nbsp;&nbsp;
					Кол-во:
					<july:string property="pocnttmp"
						size="5"
						style="font-size:8pt;"
						insertable="true" updatable="true"/>

					<IMG SRC="/images/plus.gif" onclick="addPOO();" BORDER=0>

					</td>
					<td align="right">

					<B>Комплект</B>&nbsp;
					<html:hidden property="complectpo"/>
					<july:string size="20" property="complectponame" styleId="complectponame" insertable="false" updatable="false" />
					<july:lookupbutton action="/ShowComplectLookupList.do" styleId="c7" fieldNames="complectpo;complectponame" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_c7('?position='+document.all.positioncode.value)"/>

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

		<% for (int i2=0; i2 < poCount; i2++) { 
					
			PosVO bpvo= (PosVO)frm.getPio(i2);

			ArrayList pioerrors = bpvo.getCalcerrors();
			boolean hasErrors = !pioerrors.isEmpty();

			boolean typeError = bpvo.getType()!=null && bpvo.getType().intValue() == 0 && xlserrors!=null;
			boolean snError = bpvo.isSnError(bpvo.getSn());
			int idc = bpvo.getResourcecateg();
			
			String catS = "";
			int cat = bpvo.getCateg().intValue();
			if(cat==1) catS="Кондиционер";
			else if(cat==2) catS="Панель сигнализации";
			else if(cat==3) catS="Источник питания УЗО";
			else if(cat==4) catS="Преобразователь УЗО";
		%>
		<%if(hasErrors){
		    Iterator iter = pioerrors.iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%>
		<tr><td class="print" colspan="8"><IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<b><FONT style="color: red; font-size: 8pt;"><%=error%></FONT></b></td></tr>
		<%  }
		 }%>

		<tr <%if(hasErrors){%>style="background-color: FF7F9A;"<%}%>>
			<td class="print" width="5">
			<html:hidden property='<%= "pio["+i2+"].categ"%>'/>
			<html:hidden property='<%= "pio["+i2+"].resourcecateg"%>'/>
			<html:hidden property='<%= "pio["+i2+"].position"%>'/>
			<%=i2+1%>
			</td>
			<td class="print" width="80"><html:hidden property='<%= "pio["+i2+"].id"%>'/><%=catS%></td>
			<td class="print" <%if(typeError){%>style="background-color: FF7F9A;"<%}%> width="160">
				<%if(typeError){
					String error = (String)xlserrors.get(new Integer(bpvo.getPosition()));
				%>
				<%--<IMG SRC="/images/wdot.gif" BORDER=0>&nbsp;--%><b><FONT style="font-size: 8pt;"><%=error%></FONT></b>
				<% }%>
				<july:select collection="POResourcesList" onchange='<%= "changePO("+i2+");"%>' property='<%= "pio["+i2+"].type"%>' insertable="true" updatable="true" style="font-size:8pt; width: 140px;">
						<html:option value="0">&nbsp;</html:option>
						<july:options collection="POResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
				</july:select>
				<%String dpage = "/showCategoryResources.jsp?compid=pio&number=" + i2 + "&idc=" + idc;%>
				<jsp:include page='<%= dpage%>' flush="true"></jsp:include>
			</td>
			
			<%if(changable){%>
				<script language="javascript">	
					refreshRow(<%= "'pio["+i2+"].type'"%>,<%=cat%>,pojs);
				</script>
			<%}%>

			<td class="print" width="70">
				<span id="piosp<%=i2%>"><july:string property='<%= "pio["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="160" <%if(snError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(snError){%>
				<b><FONT style="font-size: 8pt;">Указано несколько с/н</FONT></b>
				<% }%>

				<span id="piosp<%=i2%>"><july:string property='<%= "pio["+i2+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" />

				<%String checkFict = "checkFictionSerial('pio',"+i2+");";%>
				<july:checkbox property='<%= "pio["+i2+"].fictionSerial"%>' insertable="true" updatable="true" value="true" styleClass="text" onclick="<%=checkFict%>"/>
				<script language="javascript">
					<%=checkFict%>
				</script>
				</span>
			</td>			
			<td class="print" width="120">
				<span id="piosp<%=i2%>"><july:string property='<%= "pio["+i2+"].note"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="70">
				<span id="piosp<%=i2%>"><july:string property='<%= "pio["+i2+"].roomnumber"%>' style="font-size:8pt;" size="5" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="200">

				<span id="piosp<%=i2%>"><html:hidden property='<%= "pio["+i2+"].complect"%>'/><html:text property='<%= "pio["+i2+"].complectname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="25" readonly="true"/>
				 
				<%String cpage = "/ShowComplectContractor.jsp?compid=pio&number=" + i2;%>
				<jsp:include page='<%= cpage%>' flush="true"></jsp:include>

				</span>
			</td>
			<td class="print" width="30">
				<input type="image" src="/images/del.gif" onclick="<%= "delPO();return false;"%>" name="delPO2"/>
			</td>
			<script language="javascript">
				var table = document.getElementById('potable');
				table.rows(<%=i2+3%>).onmouseover = savePOIndex;
			</script>

			<%if(!typeError){%>
				<script language="javascript">
					changePO(<%=i2%>);
				</script>
			<%}%>

		</tr>		

		<%}%>


		</table>
		</td>
	</tr>

	<%if(changable){%>
		<script language="javascript">
			refreshSO();
			refreshPO();
		</script>
	<%}%>

	<script language="javascript">		
		toggleDetail('soID');
		toggleDetail('poID');
	</script>