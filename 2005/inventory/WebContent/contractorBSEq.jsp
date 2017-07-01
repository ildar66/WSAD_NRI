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
	
	int bsCount = frm.getBSCount();
    int acCount = frm.getACCount();
	int bpCount = frm.getBPCount();
	int vbpCount = frm.getVBPCount();
	int baCount = frm.getBACount();

	HashMap xlserrors = (HashMap)request.getSession().getAttribute("xlserrors");
	boolean changable = "1".equals(frm.getDocumentState()) && !frm.getIsautodoc();
%>

	<tr>
		<td colspan="2">
		<table class="print" style="font-size:8pt;" id="bstable">

		<tr class="print">
		<td class="print" colspan="9" style="background-color: DCDCDC;">
			<a title="Спрятать/показать параметры добавления" href="javascript:toggleDetail('bsID')">
				<B><%=frm.C_BS%></B>
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
			<table id="bsID" style="font-size:8pt;" width="100%">
				<tr>
					<td>
						Тип:
						<july:select collection="BIS1ResourcesList" property="bstypetmp" insertable="true" updatable="true">
								<july:options collection="BIS1ResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
						</july:select>
						&nbsp;&nbsp;
						Кол-во:
						<july:string property="bscnttmp"
							size="5"
							style="font-size:8pt;"
							insertable="true" updatable="true"/>

						<IMG SRC="/images/plus.gif" onclick="addBSS();" BORDER=0>
					</td>
					<td align="right">
						<B>Комплект</B>&nbsp;
						<html:hidden property="complectbs"/>
						<july:string size="20" property="complectbsname" styleId="complectbsname" insertable="false" updatable="false" />
						<july:lookupbutton action="/ShowComplectLookupList.do" styleId="cl" fieldNames="complectbs;complectbsname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_cl('?position='+document.all.positioncode.value)"/>
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
		№ помещ
		</td>
		<td class="print" width="200">
		Комплект
		</td>
		<td class="print" width="30">
		&nbsp;
		</td>
		</tr>

		<% for (int i2=0; i2 < bsCount; i2++) { 
			
			PosVO bpvo= (PosVO)frm.getBis(i2);

			ArrayList biserrors = bpvo.getCalcerrors();
			boolean hasErrors = !biserrors.isEmpty();

			boolean typeError = bpvo.getType()!=null && bpvo.getType().intValue() == 0 && xlserrors!=null;
			boolean snError = bpvo.isSnError(bpvo.getSn());
			int idc = bpvo.getResourcecateg();
		%>

		<%if(hasErrors){
		    Iterator iter = biserrors.iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%>
		<tr><td class="print" colspan="8"><IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<b><FONT style="color: red; font-size: 8pt;"><%=error%></FONT></b></td></tr>
		<%  }
		 }%>
		
		<tr <%if(hasErrors){%>style="background-color: FF7F9A;"<%}%>>
			<td class="print">
			<html:hidden property='<%= "bis["+i2+"].id"%>'/>
			<html:hidden property='<%= "bis["+i2+"].resourcecateg"%>'/>
			<html:hidden property='<%= "bis["+i2+"].position"%>'/>
			<%=i2+1%>
			</td>
			<td class="print">Базовая станция</td>
			<td class="print" <%if(typeError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(typeError){
					String error = (String)xlserrors.get(new Integer(bpvo.getPosition()));
				%>
				<b><FONT style="font-size: 8pt;"><%=error%></FONT></b>
				<% }%>

				<july:select collection="BIS1ResourcesList" property='<%= "bis["+i2+"].type"%>' onchange='<%= "changeBIS("+i2+");"%>' insertable="true" updatable="true" style="font-size:8pt; width: 140px;">
						<html:option value="0">&nbsp;</html:option>
						<july:options collection="BIS1ResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
				</july:select>

				<%--<html:select collection="BIS1ResourcesList" property='<%= "bis["+i2+"].type"%>' style="font-size:8pt; width: 140px;" onchange='<%= "changeBIS("+i2+");"%>'>
						<html:option value="0">&nbsp;</html:option>
						<html:options collection="BIS1ResourcesList" property="resource" labelProperty="model"/>
				</html:select>--%>

				<%String dpage = "/showCategoryResources.jsp?compid=bis&number=" + i2 + "&idc=" + idc;%>
				<jsp:include page='<%= dpage%>' flush="true"></jsp:include>

			</td>
			<td class="print">
				<span id="bissp<%=i2%>"><july:string property='<%= "bis["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" <%if(snError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(snError){%>
				<b><FONT style="font-size: 8pt;">Указано несколько с/н</FONT></b>
				<% }%>

				<span id="bissp<%=i2%>"><july:string property='<%= "bis["+i2+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" />

				<%String checkFict = "checkFictionSerial('bis',"+i2+");";%>
				<july:checkbox property='<%= "bis["+i2+"].fictionSerial"%>' insertable="true" updatable="true" value="true" styleClass="text" onclick="<%=checkFict%>"/>
				<script language="javascript">
					<%=checkFict%>
				</script>

				</span>

			</td>			
			<td class="print">
				<span id="bissp<%=i2%>"><july:string property='<%= "bis["+i2+"].note"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print">
				<span id="bissp<%=i2%>"><july:string property='<%= "bis["+i2+"].roomnumber"%>' style="font-size:8pt;" size="5" insertable="true" updatable="true" /></span>
			</td>
			<td class="print">

				<span id="bissp<%=i2%>"><html:hidden property='<%= "bis["+i2+"].complect"%>'/><html:text property='<%= "bis["+i2+"].complectname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="25" readonly="true"/>
				 
				<%String cpage = "/ShowComplectContractor.jsp?compid=bis&number=" + i2;%>
				<jsp:include page='<%= cpage%>' flush="true"></jsp:include>

				</span>
			</td>
			<td class="print">
				<input type="image" src="/images/del.gif" onclick="delBS();return false;" name="delBS"/>
			</td>
			<script language="javascript">
				var table = document.getElementById('bstable');
				table.rows(<%=i2+3%>).onmouseover = saveBIndex;
			</script>
			<%if(!typeError){%>
				<script language="javascript">
					changeBIS(<%=i2%>);
				</script>
			<%}%>
		</tr>


		<%}%>


		</table>
		</td>
	</tr>


	<%--    Источник питания бс --%>


	<tr>
		<td colspan="2">
		<table class="print" style="font-size:8pt;" id="bptable">

		<tr class="print">
		<td class="print" colspan="9" style="background-color: DCDCDC;">		
		<a title="Спрятать/показать параметры добавления" href="javascript:toggleDetail('bpID')">
			<B>Источник питания Базовой станции</B>
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
			<table id="bpID" style="font-size:8pt;" width="100%">
				<tr>
					<td>
						Тип:

						<july:select collection="BPResourcesList" property="bptypetmp" insertable="true" updatable="true">
								<july:options collection="BPResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
						</july:select>
						&nbsp;&nbsp;
						Кол-во:
						<july:string property="bpcnttmp"
							size="5"
							style="font-size:8pt;"
							insertable="true" updatable="true"/>

						<IMG SRC="/images/plus.gif" onclick="addBPP();" BORDER=0>
					</td>
					<td align="right">
						<B>Комплект</B>&nbsp;
						<html:hidden property="complectbp"/>
						<july:string size="20" property="complectbpname" styleId="complectbpname" insertable="false" updatable="false" />
						<july:lookupbutton action="/ShowComplectLookupList.do" styleId="c2" fieldNames="complectbp;complectbpname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_c2('?position='+document.all.positioncode.value)"/>
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
		№ помещ
		</td>
		<td class="print" width="200">
		Комплект
		</td>
		<td class="print" width="30">
		&nbsp;
		</td>
		</tr>

		<% for (int i2=0; i2 < bpCount; i2++) { 

		   PosVO bpvo= (PosVO)frm.getBip(i2);
		   ArrayList biperrors = bpvo.getCalcerrors();
		   boolean hasErrors = !biperrors.isEmpty();

		   boolean typeError = bpvo.getType()!=null && bpvo.getType().intValue() == 0 && xlserrors!=null;
			boolean snError = bpvo.isSnError(bpvo.getSn());
		   int idc = bpvo.getResourcecateg();
		%>
		<%if(hasErrors){
		    Iterator iter = biperrors.iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%>
		<tr><td class="print" colspan="8"><IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<b><FONT style="color: red; font-size: 8pt;"><%=error%></FONT></b></td></tr>
		<%  }
		 }%>

		<tr <%if(hasErrors){%>style="background-color: FF7F9A;"<%}%>>
			<td class="print">
			<html:hidden property='<%= "bip["+i2+"].id"%>'/>
			<html:hidden property='<%= "bip["+i2+"].resourcecateg"%>'/>
			<html:hidden property='<%= "bip["+i2+"].position"%>'/>
			<%=i2+1%>
			</td>
			<td class="print"><%=frm.C_IBP%></td>
			<td class="print" <%if(typeError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(typeError){
					String error = (String)xlserrors.get(new Integer(bpvo.getPosition()));
				%>
				<b><FONT style="font-size: 8pt;"><%=error%></FONT></b>
				<% }%>

				<july:select collection="BPResourcesList" property='<%= "bip["+i2+"].type"%>' onchange='<%= "changeBP("+i2+");"%>' insertable="true" updatable="true" style="font-size:8pt; width: 140px;">
						<html:option value="0">&nbsp;</html:option>
						<july:options collection="BPResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
				</july:select>

				<%String dpage = "/showCategoryResources.jsp?compid=bip&number=" + i2 + "&idc=" + idc;%>
				<jsp:include page='<%= dpage%>' flush="true"></jsp:include>

			</td>
			<td class="print">
				<span id="bipsp<%=i2%>"><july:string property='<%= "bip["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" <%if(snError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(snError){%>
				<b><FONT style="font-size: 8pt;">Указано несколько с/н</FONT></b>
				<% }%>

				<span id="bipsp<%=i2%>"><july:string property='<%= "bip["+i2+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" />

				<%String checkFict = "checkFictionSerial('bip',"+i2+");";%>
				<july:checkbox property='<%= "bip["+i2+"].fictionSerial"%>' insertable="true" updatable="true" value="true" styleClass="text" onclick="<%=checkFict%>"/>
				<script language="javascript">
					<%=checkFict%>
				</script>
				</span>

			</td>			
			<td class="print">
				<span id="bipsp<%=i2%>"><july:string property='<%= "bip["+i2+"].note"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print">
				<span id="bipsp<%=i2%>"><july:string property='<%= "bip["+i2+"].roomnumber"%>' style="font-size:8pt;" size="5" insertable="true" updatable="true" /></span>
			</td>
			<td class="print">

				<span id="bipsp<%=i2%>"><html:hidden property='<%= "bip["+i2+"].complect"%>'/><html:text property='<%= "bip["+i2+"].complectname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="25" readonly="true"/>
				 
				<%String cpage = "/ShowComplectContractor.jsp?compid=bip&number=" + i2;%>
				<jsp:include page='<%= cpage%>' flush="true"></jsp:include>

				</span>
			</td>
			<td class="print">
				<input type="image" src="/images/del.gif" onclick="delBP();return false;" name="delBP"/>				
			</td>
			<script language="javascript">
				var table = document.getElementById('bptable');
				table.rows(<%=i2+3%>).onmouseover = saveBPIndex;
			</script>
			<%if(!typeError){%>
				<script language="javascript">
					changeBP(<%=i2%>);
				</script>
			<%}%>
		</tr>


		<%}%>


		</table>
		</td>
	</tr>


	<%--    Выпрямители источников питания бс --%>


	<tr>
		<td colspan="2">
		<table class="print" style="font-size:8pt;" id="vbptable">

		<tr class="print">
		<td class="print" colspan="9" style="background-color: DCDCDC;">		
		<a title="Спрятать/показать параметры добавления" href="javascript:toggleDetail('vbpID')">
			<B>Выпрямители источников питания Базовой станции</B>
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
			<table id="vbpID" style="font-size:8pt;" width="100%">
				<tr>
					<td>
						Тип:

						<july:select collection="VBPResourcesList" property="vbptypetmp" insertable="true" updatable="true">
								<july:options collection="VBPResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
						</july:select>
						&nbsp;&nbsp;
						Кол-во:
						<july:string property="vbpcnttmp"
							size="5"
							style="font-size:8pt;"
							insertable="true" updatable="true"/>

						<IMG SRC="/images/plus.gif" onclick="addVBPP();" BORDER=0>
					</td>
					<td align="right">
						<B>Комплект</B>&nbsp;
						<html:hidden property="complectvbp"/>
						<july:string size="20" property="complectvbpname" styleId="complectvbpname" insertable="false" updatable="false" />
						<july:lookupbutton action="/ShowComplectLookupList.do" styleId="c3" fieldNames="complectvbp;complectvbpname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_c3('?position='+document.all.positioncode.value)"/>
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
		№ помещ
		</td>
		<td class="print" width="200">
		Комплект
		</td>
		<td class="print" width="30">
		&nbsp;
		</td>
		</tr>

		<% for (int i2=0; i2 < vbpCount; i2++) { 
		
		   PosVO bpvo= (PosVO)frm.getVbip(i2);
		   ArrayList vbiperrors = bpvo.getCalcerrors();
		   boolean hasErrors = !vbiperrors.isEmpty();

		   boolean typeError = bpvo.getType()!=null && bpvo.getType().intValue() == 0 && xlserrors!=null;
		   boolean snError = bpvo.isSnError(bpvo.getSn());
		   int idc = bpvo.getResourcecateg();
		%>
		<%if(hasErrors){
		    Iterator iter = vbiperrors.iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%>
		<tr><td class="print" colspan="8"><IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<b><FONT style="color: red; font-size: 8pt;"><%=error%></FONT></b></td></tr>
		<%  }
		 }%>


		<tr <%if(hasErrors){%>style="background-color: FF7F9A;"<%}%>>
			<td class="print">
			<html:hidden property='<%= "vbip["+i2+"].id"%>'/>
			<html:hidden property='<%= "vbip["+i2+"].resourcecateg"%>'/>
			<html:hidden property='<%= "vbip["+i2+"].position"%>'/>
			<%=i2+1%>
			</td>
			<td class="print">Ячейка питания</td>
			<td class="print" <%if(typeError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(typeError){
					String error = (String)xlserrors.get(new Integer(bpvo.getPosition()));
				%>
				<b><FONT style="font-size: 8pt;"><%=error%></FONT></b>
				<% }%>

				<july:select collection="VBPResourcesList" property='<%= "vbip["+i2+"].type"%>' onchange='<%= "changeVBP("+i2+");"%>' insertable="true" updatable="true" style="font-size:8pt; width: 140px;">
						<html:option value="0">&nbsp;</html:option>
						<july:options collection="VBPResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
				</july:select>
				<%String dpage = "/showCategoryResources.jsp?compid=vbip&number=" + i2 + "&idc=" + idc;%>
				<jsp:include page='<%= dpage%>' flush="true"></jsp:include>
			</td>
			<td class="print">
				<span id="vbipsp<%=i2%>"><july:string property='<%= "vbip["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" <%if(snError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(snError){%>
				<b><FONT style="font-size: 8pt;">Указано несколько с/н<br></FONT></b>
				<% }%>

				<span id="vbipsp<%=i2%>"><july:string property='<%= "vbip["+i2+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" />

				<%String checkFict = "checkFictionSerial('vbip',"+i2+");";%>
				<july:checkbox property='<%= "vbip["+i2+"].fictionSerial"%>' insertable="true" updatable="true" value="true" styleClass="text" onclick="<%=checkFict%>"/>
				<script language="javascript">
					<%=checkFict%>
				</script>
				</span>

			</td>	
			<td class="print">
				<span id="bipsp<%=i2%>"><july:string property='<%= "vbip["+i2+"].note"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print">
				<span id="vbipsp<%=i2%>"><july:string property='<%= "vbip["+i2+"].roomnumber"%>' style="font-size:8pt;" size="5" insertable="true" updatable="true" /></span>
			</td>
			<td class="print">
				<span id="vbipsp<%=i2%>"><html:hidden property='<%= "vbip["+i2+"].complect"%>'/><html:text property='<%= "vbip["+i2+"].complectname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="25" readonly="true"/>
				 
				<%String cpage = "/ShowComplectContractor.jsp?compid=vbip&number=" + i2;%>
				<jsp:include page='<%= cpage%>' flush="true"></jsp:include>

				</span>
			</td>
			<td class="print">
				<input type="image" src="/images/del.gif" onclick="delVBP();return false;" name="delVBP"/>
			</td>
			<script language="javascript">
				var table = document.getElementById('vbptable');
				table.rows(<%=i2+3%>).onmouseover = saveVBPIndex;
			</script>
			<%if(!typeError){%>
				<script language="javascript">
					changeVBP(<%=i2%>);
				</script>
			<%}%>
		</tr>


		<%}%>


		</table>
		</td>
	</tr>

	<%--    Аккумуляторы источников питания бс --%>


	<tr>
		<td colspan="2">
		<table class="print" style="font-size:8pt;" id="actable">

		<tr class="print">
		<td class="print" colspan="10" style="background-color: DCDCDC;">		
		<a title="Спрятать/показать параметры добавления" href="javascript:toggleDetail('accID')">
			<B>Аккумуляторы источников питания БС и BSC</B>
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
		<td class="print" colspan="10">
			<table id="accID" style="font-size:8pt;" width="100%">
				<tr>
					<td>
						Тип:

						<july:select collection="ACCResourcesList" property="actypetmp" insertable="true" updatable="true">
								<july:options collection="ACCResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
						</july:select>
						&nbsp;&nbsp;
						Кол-во:
						<july:string property="accnttmp"
							size="5"
							style="font-size:8pt;"
							insertable="true" updatable="true"/>

						<IMG SRC="/images/plus.gif" onclick="addACC();" BORDER=0>
					</td>
					<td align="right">
						<B>Комплект</B>&nbsp;
						<html:hidden property="complectac"/>
						<july:string size="20" property="complectacname" styleId="complectacname" insertable="false" updatable="false" />
						<july:lookupbutton action="/ShowComplectLookupList.do" styleId="c4" fieldNames="complectac;complectacname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_c4('?position='+document.all.positioncode.value)"/>
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
		<td class="print" width="80">
		Нач. напр.
		</td>
		<td class="print" width="80">
		После часа
		</td>
		<td class="print" width="200">
		Комплект
		</td>
		<td class="print" width="30">
		&nbsp;
		</td>
		</tr>

		<% for (int i2=0; i2 < acCount; i2++) { 
			PosVO bpvo= (PosVO)frm.getAcc(i2);
			ArrayList accerrors = bpvo.getCalcerrors();
			boolean hasErrors = !accerrors.isEmpty();	

			boolean typeError = bpvo.getType()!=null && bpvo.getType().intValue() == 0 && xlserrors!=null;
			boolean snError = bpvo.isSnError(bpvo.getSn());
			int idc = bpvo.getResourcecateg();
		%>
		<%if(hasErrors){
		    Iterator iter = accerrors.iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%>
		<tr><td class="print" colspan="8"><IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<b><FONT style="color: red; font-size: 8pt;"><%=error%></FONT></b></td></tr>
		<%  }
		 }%>

		<tr <%if(hasErrors){%>style="background-color: FF7F9A;"<%}%>>
			<td class="print" width="5">
			<html:hidden property='<%= "acc["+i2+"].id"%>'/>
			<html:hidden property='<%= "acc["+i2+"].resourcecateg"%>'/>
			<html:hidden property='<%= "acc["+i2+"].position"%>'/>
			<%=i2+1%>
			</td>
			<td class="print" width="80">Аккумулятор</td>
			<td class="print" <%if(typeError){%>style="background-color: FF7F9A;"<%}%> width="160">
				<%if(typeError){
					String error = (String)xlserrors.get(new Integer(bpvo.getPosition()));
				%>
				<b><FONT style="font-size: 8pt;"><%=error%></FONT></b>
				<% }%>

				<july:select collection="ACCResourcesList" property='<%= "acc["+i2+"].type"%>' onchange='<%= "changeACC("+i2+");"%>' insertable="true" updatable="true" style="font-size:8pt; width: 140px;">
						<html:option value="0">&nbsp;</html:option>
						<july:options collection="ACCResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
				</july:select>
				<%String dpage = "/showCategoryResources.jsp?compid=acc&number=" + i2 + "&idc=" + idc;%>
				<jsp:include page='<%= dpage%>' flush="true"></jsp:include>
			</td>
			<td class="print" width="70">
				<span id="accsp<%=i2%>"><july:string property='<%= "acc["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="160" <%if(snError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(snError){%>
				<b><FONT style="font-size: 8pt;">Указано несколько с/н</FONT></b>
				<% }%>

				<span id="accsp<%=i2%>"><july:string property='<%= "acc["+i2+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" />				
				
				<%String checkFict = "checkFictionSerial('acc',"+i2+");";%>
				<july:checkbox property='<%= "acc["+i2+"].fictionSerial"%>' insertable="true" updatable="true" value="true" styleClass="text" onclick="<%=checkFict%>"/>
				<script language="javascript">
					<%=checkFict%>
				</script>
				</span>
			</td>
			<td class="print">
				<span id="accsp<%=i2%>" width="80"><july:string property='<%= "acc["+i2+"].comment"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print">
				<span id="accsp<%=i2%>" width="80"><july:string property='<%= "acc["+i2+"].note"%>' style="font-size:8pt;" size="5" insertable="true" updatable="true" /></span>
			</td>
			<td class="print">
				<span id="accsp<%=i2%>" width="80"><july:string property='<%= "acc["+i2+"].roomnumber"%>' style="font-size:8pt;" size="5" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="200">

				<span id="accsp<%=i2%>"><html:hidden property='<%= "acc["+i2+"].complect"%>'/><html:text property='<%= "acc["+i2+"].complectname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="25" readonly="true"/>
				 
				<%String cpage = "/ShowComplectContractor.jsp?compid=acc&number=" + i2;%>
				<jsp:include page='<%= cpage%>' flush="true"></jsp:include>

				</span>
			</td>
			<td class="print" width="30">
				<input type="image" src="/images/del.gif" onclick="delAC();return false;" name="delAC"/>				
			</td>
			<script language="javascript">
				var table = document.getElementById('actable');
				table.rows(<%=i2+3%>).onmouseover = saveAIndex;
			</script>
			<%if(!typeError){%>
				<script language="javascript">
					changeACC(<%=i2%>);
				</script>
			<%}%>
		</tr>


		<%}%>


		</table>
		</td>
	</tr>
	



	<%--    Блок преобразования аварий --%>

	<script language="javascript">
		<%=frm.getBaJSData()%>
	</script>

	<tr>
		<td colspan="2">
		<table class="print" style="font-size:8pt;" id="batable">

		<tr class="print">
		<td class="print" colspan="9" style="background-color: DCDCDC;">		
		<a title="Спрятать/показать параметры добавления" href="javascript:toggleDetail('baID')">
			<B>Блок преобразования аварий</B>
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
			<table id="baID" style="font-size:8pt;" width="100%">
				<tr>
					<td>
						<html:select property='bacategtmp'  style="background-color: D6EBFF;" onchange="refreshBA();" >
								<html:option value="1">Инвертер аварий</html:option>
								<html:option value="2">Блок внешних аварий</html:option>
						</html:select>
						&nbsp;&nbsp;
						Тип:
						<july:select collection="BAResourcesList" property="batypetmp" insertable="true" updatable="true">
								<july:options collection="BAResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
						</july:select>
						&nbsp;&nbsp;
						Кол-во:
						<july:string property="bacnttmp"
							size="5"
							style="font-size:8pt;"
							insertable="true" updatable="true"/>

						<IMG SRC="/images/plus.gif" onclick="addBAA();" BORDER=0>
					</td>
					<td align="right">			
						<B>Комплект</B>&nbsp;
						<html:hidden property="complectba"/>
						<july:string size="20" property="complectbaname" styleId="complectbaname" insertable="false" updatable="false" />
						<july:lookupbutton action="/ShowComplectLookupList.do" styleId="c5" fieldNames="complectba;complectbaname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_c5('?position='+document.all.positioncode.value)"/>
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

		<% for (int i2=0; i2 < baCount; i2++) { 
					
			PosVO bpvo= (PosVO)frm.getBia(i2);
			ArrayList biaerrors = bpvo.getCalcerrors();
			boolean hasErrors = !biaerrors.isEmpty();

			boolean typeError = bpvo.getType()!=null && bpvo.getType().intValue() == 0 && xlserrors!=null;
			boolean snError = bpvo.isSnError(bpvo.getSn());
			int idc = bpvo.getResourcecateg();

			String catS = "";
			int cat = bpvo.getCateg().intValue();
			if(cat==1) catS="Инвертер аварий";
			else if(cat==2) catS="Блок внешних аварий";
		%>
		<%if(hasErrors){
		    Iterator iter = biaerrors.iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%>
		<tr><td class="print" colspan="8"><IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<b><FONT style="color: red; font-size: 8pt;"><%=error%></FONT></b></td></tr>
		<%  }
		 }%>

		<tr <%if(hasErrors){%>style="background-color: FF7F9A;"<%}%>>
			<td class="print" width="5">
			<html:hidden property='<%= "bia["+i2+"].categ"%>'/>
			<html:hidden property='<%= "bia["+i2+"].resourcecateg"%>'/>
			<html:hidden property='<%= "bia["+i2+"].position"%>'/>
			<%=i2+1%>
			</td>
			<td class="print"  width="80"><html:hidden property='<%= "bia["+i2+"].id"%>'/><%=catS%></td>
			<td class="print" <%if(typeError){%>style="background-color: FF7F9A;"<%}%> width="160">
				<%if(typeError){
					String error = (String)xlserrors.get(new Integer(bpvo.getPosition()));
				%>
				<b><FONT style="font-size: 8pt;"><%=error%></FONT></b>
				<% }%>

				<july:select collection="BAResourcesList" property='<%= "bia["+i2+"].type"%>' onchange='<%= "changeBA("+i2+");"%>' insertable="true" updatable="true" style="font-size:8pt; width: 140px;">
						<html:option value="0">&nbsp;</html:option>
						<july:options collection="BAResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
				</july:select>
				<%String dpage = "/showCategoryResources.jsp?compid=bia&number=" + i2 + "&idc=" + idc;%>
				<jsp:include page='<%= dpage%>' flush="true"></jsp:include>
			</td>

			
			<%if(changable){%>			
				<script language="javascript">	
					refreshRow(<%= "'bia["+i2+"].type'"%>,<%=cat%>,bajs);
				</script>
			<%}%>

			<td class="print" width="70">
				<span id="biasp<%=i2%>"><july:string property='<%= "bia["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="160" <%if(snError){%>style="background-color: FF7F9A;"<%}%>>
				<%if(snError){%>
				<b><FONT style="font-size: 8pt;">Указано несколько с/н</FONT></b>
				<% }%>

				<span id="biasp<%=i2%>"><july:string property='<%= "bia["+i2+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" />

				<%String checkFict = "checkFictionSerial('bia',"+i2+");";%>
				<july:checkbox property='<%= "bia["+i2+"].fictionSerial"%>' insertable="true" updatable="true" value="true" styleClass="text" onclick="<%=checkFict%>"/>
				<script language="javascript">
					<%=checkFict%>
				</script>
				</span>
			</td>			
			<td class="print" width="120">
				<span id="biasp<%=i2%>"><july:string property='<%= "bia["+i2+"].note"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="70">
				<span id="biasp<%=i2%>"><july:string property='<%= "bia["+i2+"].roomnumber"%>' style="font-size:8pt;" size="5" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="200">

				<span id="biasp<%=i2%>"><html:hidden property='<%= "bia["+i2+"].complect"%>'/><html:text property='<%= "bia["+i2+"].complectname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="25" readonly="true"/>
				 
				<%String cpage = "/ShowComplectContractor.jsp?compid=bia&number=" + i2;%>
				<jsp:include page='<%= cpage%>' flush="true"></jsp:include>

				</span>
			</td>
			<td class="print" width="30">
				<input type="image" src="/images/del.gif" onclick="delBA();return false;" name="delBA"/>
			</td>
			<script language="javascript">
				var table = document.getElementById('batable');
				table.rows(<%=i2+3%>).onmouseover = saveBAIndex;
			</script>
			<%if(!typeError){%>
				<script language="javascript">
					changeBA(<%=i2%>);
				</script>
			<%}%>
		</tr>


		<%}%>


		</table>
		</td>
	</tr>

	<%if(changable){%>
		<script language="javascript">
			refreshBA();
		</script>
	<%}%>

	<script language="javascript">
			

		toggleDetail('bsID');
		toggleDetail('bpID');
		toggleDetail('vbpID');
		toggleDetail('accID');
		toggleDetail('baID');

	</script>