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
	int muCount = frm2.getMUCount();
	int cdCount = frm2.getCDCount();
	HashMap xlserrors = (HashMap)request.getSession().getAttribute("xlserrors");
	boolean changable = "1".equals(frm2.getDocumentState()) && !frm2.getIsautodoc();
%>


	<%--    Малошумящий усилитель --%>

	<script language="javascript">
		<%=frm2.getMuJSData()%>
	</script>

	<tr>
		<td colspan="2">
		<table class="print" style="font-size:8pt;" id="mutable">

		<tr class="print">
		<td class="print" colspan="9" style="background-color: DCDCDC;">		
		<a title="Спрятать/показать параметры добавления" href="javascript:toggleDetail('muID')">
			<B>Малошумящий усилитель</B>
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

			<table id="muID" style="font-size:8pt;" width="100%">
				<tr>
					<td>
					<html:select property='mucategtmp'  style="background-color: D6EBFF;" onchange="refreshMU();" >
							<html:option value="1">МШУ.Источник питания</html:option>
							<html:option value="2">МШУ.Усилитель</html:option>
							<html:option value="3">МШУ.Инжектор</html:option>
					</html:select>
					&nbsp;&nbsp;
					Тип:
					<july:select collection="MUResourcesList" property="mutypetmp" insertable="true" updatable="true">
							<july:options collection="MUResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
					</july:select>
					&nbsp;&nbsp;
					Кол-во:
					<july:string property="mucnttmp"
						size="5"
						style="font-size:8pt;"
						insertable="true" updatable="true"/>

					<IMG SRC="/images/plus.gif" onclick="addMUU();" BORDER=0>

					</td>
					<td align="right">

					<B>Комплект</B>&nbsp;
					<html:hidden property="complectmu"/>
					<july:string size="20" property="complectmuname" styleId="complectmuname" insertable="false" updatable="false" />
					<july:lookupbutton action="/ShowComplectLookupList.do" styleId="c8" fieldNames="complectmu;complectmuname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_c8('?position='+document.all.positioncode.value)"/>

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
		<td class="print" width="120">
		Тип
		</td>
		<td class="print" width="70">
		Кол-во
		</td>
		<td class="print" width="150">
		Серийный №
		</td>		
		<td class="print" width="120">
		Примечание
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

		<% for (int i2=0; i2 < muCount; i2++) { 
					
			PosVO bpvo= (PosVO)frm2.getMio(i2);

			ArrayList mioerrors = bpvo.getCalcerrors();
			boolean hasErrors = !mioerrors.isEmpty();

			boolean typeError = bpvo.getType()!=null && bpvo.getType().intValue() == 0 && xlserrors!=null;
			boolean snError = bpvo.isSnError(bpvo.getSn());

			String catS = "";
			int cat = bpvo.getCateg().intValue();
			if(cat==1) catS="МШУ.Источник питания";
			else if(cat==2) catS="МШУ.Усилитель";
			else if(cat==3) catS="МШУ.Инжектор";

			int idc = bpvo.getResourcecateg();
		%>
		<%if(hasErrors){
		    Iterator iter = mioerrors.iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%>
		<tr><td class="print" colspan="8"><IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<b><FONT style="color: red; font-size: 8pt;"><%=error%></FONT></b></td></tr>
		<%  }
		 }%>

		<tr <%if(hasErrors){%>style="background-color: FF7F9A;"<%}%>>
			<td class="print">
			<html:hidden property='<%= "mio["+i2+"].categ"%>'/>
			<html:hidden property='<%= "mio["+i2+"].resourcecateg"%>'/>
			<html:hidden property='<%= "mio["+i2+"].position"%>'/>
			<%=i2+1%>
			</td>
			<td class="print"><html:hidden property='<%= "mio["+i2+"].id"%>'/><%=catS%></td>
			<td class="print"  <%if(typeError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(typeError){
					String error = (String)xlserrors.get(new Integer(bpvo.getPosition()));
				%>
				<b><FONT style="font-size: 8pt;"><%=error%></FONT></b>
				<% }%>
				
				<july:select collection="MUResourcesList" property='<%= "mio["+i2+"].type"%>' onchange='<%= "changeMU("+i2+");"%>' insertable="true" updatable="true" style="font-size:8pt; width: 140px;">
						<html:option value="0">&nbsp;</html:option>
						<july:options collection="MUResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
				</july:select>

				<%String dpage = "/showCategoryResources.jsp?compid=mio&number=" + i2 + "&idc=" + idc;%>
				<jsp:include page='<%= dpage%>' flush="true"></jsp:include>
			</td>

			<%if(changable){%>
				<script language="javascript">	
					refreshRow(<%= "'mio["+i2+"].type'"%>,<%=cat%>,mujs);
				</script>
			<%}%>

			<td class="print">
				<span id="miosp<%=i2%>"><july:string property='<%= "mio["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" <%if(snError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(snError){%>
				<b><FONT style="font-size: 8pt;">Указано несколько с/н</FONT></b>
				<% }%>

				<span id="miosp<%=i2%>"><july:string property='<%= "mio["+i2+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" />

				<%String checkFict = "checkFictionSerial('mio',"+i2+");";%>
				<july:checkbox property='<%= "mio["+i2+"].fictionSerial"%>' insertable="true" updatable="true" value="true" styleClass="text" onclick="<%=checkFict%>"/>
				<script language="javascript">
					<%=checkFict%>
				</script>
				</span>
			</td>	
			<td class="print">
				<span id="miosp<%=i2%>"><july:string property='<%= "mio["+i2+"].note"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print">
				<span id="miosp<%=i2%>"><july:string property='<%= "mio["+i2+"].roomnumber"%>' style="font-size:8pt;" size="5" insertable="true" updatable="true" /></span>
			</td>
			<td class="print">

				<span id="miosp<%=i2%>"><html:hidden property='<%= "mio["+i2+"].complect"%>'/><html:text property='<%= "mio["+i2+"].complectname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="25" readonly="true"/>
				 
				<%String cpage = "/ShowComplectContractor.jsp?compid=mio&number=" + i2;%>
				<jsp:include page='<%= cpage%>' flush="true"></jsp:include>

				</span>
			</td>
			<td class="print" width="30">
				<input type="image" src="/images/del.gif" onclick="delMU();return false;" name="delMU"/>
			</td>
			<script language="javascript">
				var table = document.getElementById('mutable');
				table.rows(<%=i2+3%>).onmouseover = saveMUIndex;
			</script>
			<%if(!typeError){%>
				<script language="javascript">
					changeMU(<%=i2%>);
				</script>
			<%}%>
		</tr>


		<%}%>


		</table>
		</td>
	</tr>



	<%--    Комбайнеры. Делители. --%>

	<script language="javascript">
		<%=frm2.getCdJSData()%>
	</script>

	<tr>
		<td colspan="2">
		<table class="print" style="font-size:8pt;" id="cdtable">

		<tr class="print">
		<td class="print" colspan="9" style="background-color: DCDCDC;">		
		<a title="Спрятать/показать параметры добавления" href="javascript:toggleDetail('cdID')">
			<B>Комбайнеры. Делители.</B>
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

			<table id="cdID" style="font-size:8pt;" width="100%">
				<tr>
					<td>
			
					<html:select property='cdcategtmp'  style="background-color: D6EBFF;" onchange="refreshCD();" >
							<html:option value="1">Делитель</html:option>
							<html:option value="2">Диплексер</html:option>
							<html:option value="3">Комбайнер 900/1800</html:option>
					</html:select>
					&nbsp;&nbsp;
					Тип:
					<july:select collection="CDResourcesList" property="cdtypetmp" insertable="true" updatable="true">
							<july:options collection="CDResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
					</july:select>
					&nbsp;&nbsp;
					Кол-во:
					<july:string property="cdcnttmp"
						size="5"
						style="font-size:8pt;"
						insertable="true" updatable="true"/>

					<IMG SRC="/images/plus.gif" onclick="addCDD();" BORDER=0>


					</td>
					<td align="right">

					<B>Комплект</B>&nbsp;
					<html:hidden property="complectcd"/>
					<july:string size="20" property="complectcdname" styleId="complectcdname" insertable="false" updatable="false" />
					<july:lookupbutton action="/ShowComplectLookupList.do" styleId="c9" fieldNames="complectcd;complectcdname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_c9('?position='+document.all.positioncode.value)"/>

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

		<% for (int i2=0; i2 < cdCount; i2++) { 
					
			PosVO bpvo= (PosVO)frm2.getCio(i2);

			ArrayList cioerrors = bpvo.getCalcerrors();
			boolean hasErrors = !cioerrors.isEmpty();

			boolean typeError = bpvo.getType()!=null && bpvo.getType().intValue() == 0 && xlserrors!=null;
			boolean snError = bpvo.isSnError(bpvo.getSn());

			String catS = "";
			int cat = bpvo.getCateg().intValue();
			if(cat==1) catS="Делитель";
			else if(cat==2) catS="Диплексер";
			else if(cat==3) catS="Комбайнер 900/1800";

			int idc = bpvo.getResourcecateg();
		%>
		<%if(hasErrors){
		    Iterator iter = cioerrors.iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%>
		<tr><td class="print" colspan="8"><IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<b><FONT style="color: red; font-size: 8pt;"><%=error%></FONT></b></td></tr>
		<%  }
		 }%>
		
		<tr <%if(hasErrors){%>style="background-color: FF7F9A;"<%}%>>
			<td class="print"  width="5">
			<html:hidden property='<%= "cio["+i2+"].categ"%>'/>
			<html:hidden property='<%= "cio["+i2+"].resourcecateg"%>'/>
			<html:hidden property='<%= "cio["+i2+"].position"%>'/>
			<%=i2+1%>
			</td>
			<td class="print" width="80"><html:hidden property='<%= "cio["+i2+"].id"%>'/><%=catS%></td>
			<td class="print"  <%if(typeError){%>style="background-color: FF7F9A;"<%}%>  width="160">
				<%if(typeError){
					String error = (String)xlserrors.get(new Integer(bpvo.getPosition()));
				%>
				<b><FONT style="font-size: 8pt;"><%=error%></FONT></b>
				<% }%>

				<july:select collection="CDResourcesList" property='<%= "cio["+i2+"].type"%>' onchange='<%= "changeCD("+i2+");"%>' insertable="true" updatable="true" style="font-size:8pt; width: 140px;">
						<html:option value="0">&nbsp;</html:option>
						<july:options collection="CDResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
				</july:select>
				<%String dpage = "/showCategoryResources.jsp?compid=cio&number=" + i2 + "&idc=" + idc;%>
				<jsp:include page='<%= dpage%>' flush="true"></jsp:include>
			</td>

			<%if(changable){%>
				<script language="javascript">	
					refreshRow(<%= "'cio["+i2+"].type'"%>,<%=cat%>,cdjs);
				</script>
			<%}%>

			<td class="print" width="70">
				<span id="ciosp<%=i2%>"><july:string property='<%= "cio["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="160" <%if(snError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(snError){%>
				<b><FONT style="font-size: 8pt;">Указано несколько с/н</FONT></b>
				<% }%>

				<span id="ciosp<%=i2%>"><july:string property='<%= "cio["+i2+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" />

				<%String checkFict = "checkFictionSerial('cio',"+i2+");";%>
				<july:checkbox property='<%= "cio["+i2+"].fictionSerial"%>' insertable="true" updatable="true" value="true" styleClass="text" onclick="<%=checkFict%>"/>
				<script language="javascript">
					<%=checkFict%>
				</script>
				</span>
			</td>			
			<td class="print" width="120">
				<span id="ciosp<%=i2%>"><july:string property='<%= "cio["+i2+"].note"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="70">
				<span id="ciosp<%=i2%>"><july:string property='<%= "cio["+i2+"].roomnumber"%>' style="font-size:8pt;" size="5" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="200">

				<span id="ciosp<%=i2%>"><html:hidden property='<%= "cio["+i2+"].complect"%>'/><html:text property='<%= "cio["+i2+"].complectname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="25" readonly="true"/>
				 
				<%String cpage = "/ShowComplectContractor.jsp?compid=cio&number=" + i2;%>
				<jsp:include page='<%= cpage%>' flush="true"></jsp:include>

				</span>
			</td>
			<td class="print" width="30">
				<input type="image" src="/images/del.gif" onclick="delCD();return false;" name="delCD"/>
			</td>
			<script language="javascript">
				var table = document.getElementById('cdtable');
				table.rows(<%=i2+3%>).onmouseover = saveCDIndex;
			</script>
			<%if(!typeError){%>
				<script language="javascript">
					changeCD(<%=i2%>);
				</script>
			<%}%>
		</tr>


		<%}%>


		</table>
		</td>
	</tr>

	<%if(changable){%>
		<script language="javascript">
			refreshMU();
			refreshCD();
		</script>
	<%}%>

	<script language="javascript">
		toggleDetail('muID');
		toggleDetail('cdID');
	</script>