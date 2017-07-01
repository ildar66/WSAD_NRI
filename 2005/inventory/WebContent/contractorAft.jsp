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
	int aftCount = frm2.getAFTCount();
	HashMap xlserrors = (HashMap)request.getSession().getAttribute("xlserrors");
	boolean changable = "1".equals(frm2.getDocumentState()) && !frm2.getIsautodoc();
%>



	<%--    Антенно-фидерный тракт --%>
	<tr>
		<td colspan="2">
		<table class="print" style="font-size:8pt;" id="afttable">

		<tr class="print">
		<td class="print" colspan="9" style="background-color: DCDCDC;">		
		<a title="Спрятать/показать параметры добавления" href="javascript:toggleDetail('aftID')">
			<B>Кабель р/ч</B>
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

			<table id="aftID" style="font-size:8pt;" width="100%">
				<tr>
					<td>

					<html:select property='aftcategtmp'  style="background-color: D6EBFF;">
							<html:option value="1"><%=frm2.C_CABLE_0%></html:option>
							<html:option value="2"><%=frm2.C_CABLE_14%></html:option>
							<html:option value="3"><%=frm2.C_CABLE_12%></html:option>
							<html:option value="4"><%=frm2.C_CABLE_114%></html:option>
							<html:option value="5"><%=frm2.C_CABLE_158%></html:option>
							<html:option value="6"><%=frm2.C_CABLE_78%></html:option>
							<html:option value="7"><%=frm2.C_CABLE_1751%></html:option>
					</html:select>
					&nbsp;&nbsp;
					Тип:
					<july:select collection="AFTResourcesList" property="afttypetmp" insertable="true" updatable="true">
							<july:options collection="AFTResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
					</july:select>
					&nbsp;&nbsp;
					Кол-во:
					<july:string property="aftcnttmp"
						size="5"
						style="font-size:8pt;"
						insertable="true" updatable="true"/>
					<IMG SRC="/images/plus.gif" onclick="addAFT();" BORDER=0>

					</td>
					<td align="right">	

					<B>Комплект</B>&nbsp;
					<html:hidden property="complectaft"/>
					<july:string size="20" property="complectaftname" styleId="complectaftname" insertable="false" updatable="false" />
					<july:lookupbutton action="/ShowComplectLookupList.do" styleId="c14" fieldNames="complectaft;complectaftname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_c14('?position='+document.all.positioncode.value)"/>

					</td>
				</tr>
			</table>	

		</td>
		</tr>

		<tr>
		<td class="print" width="5">
		№
		</td>
		<td class="print" width="120">
		Кабель р/ч
		</td>
		<td class="print" width="120">
		Сектор
		</td>
		<td class="print" width="70">
		Длина
		</td>
		<td class="print" width="120">
		Тип кабеля
		</td>		
		<td class="print" width="120">
		КСВ
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



		<% for (int i2=0; i2 < aftCount; i2++) { 
					
			PosVO aifvo= (PosVO)frm2.getAif(i2);
				
			int idc = aifvo.getResourcecateg();
			ArrayList aiferrors = aifvo.getCalcerrors();
			boolean hasErrors = !aiferrors.isEmpty();

			boolean typeError = aifvo.getType()!=null && aifvo.getType().intValue() == 0 && xlserrors!=null;

			String catS = "";
			int cat = aifvo.getCateg().intValue();
			if(cat==1) catS=frm2.C_CABLE_0;
			else if(cat==2) catS=frm2.C_CABLE_14;
			else if(cat==3) catS=frm2.C_CABLE_12;
			else if(cat==4) catS=frm2.C_CABLE_114;
			else if(cat==5) catS=frm2.C_CABLE_158;
			else if(cat==6) catS=frm2.C_CABLE_78;
			else if(cat==7) catS=frm2.C_CABLE_1751;

		%>	
		<%if(hasErrors){
		    Iterator iter = aiferrors.iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%>
		<tr><td class="print" colspan="8"><IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<b><FONT style="color: red; font-size: 8pt;"><%=error%></FONT></b></td></tr>
		<%  }
		 }%>

		<tr <%if(hasErrors){%>style="background-color: FF7F9A;"<%}%>>
			<td class="print" width="5">
			<html:hidden property='<%= "aif["+i2+"].categ"%>'/>
			<html:hidden property='<%= "aif["+i2+"].resourcecateg"%>'/>
			<html:hidden property='<%= "aif["+i2+"].position"%>'/>
			<%=i2+1%>
			</td>
			<td class="print"><html:hidden property='<%= "aif["+i2+"].id"%>'/><%=catS%></td>
			<td class="print" width="120">
				<span id="aifsp<%=i2%>"><july:string property='<%= "aif["+i2+"].sector"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>	
			<td class="print" width="70">
				<span id="aifsp<%=i2%>"><july:string property='<%= "aif["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" /></span>
			</td>
			<td class="print"  <%if(typeError){%>style="background-color: FF7F9A;"<%}%> width="120">
				<%if(typeError){
					String error = (String)xlserrors.get(new Integer(aifvo.getPosition()));
				%>
				<b><FONT style="font-size: 8pt;"><%=error%></FONT></b>
				<% }%>

				<july:select collection="AFTResourcesList" property='<%= "aif["+i2+"].type"%>' insertable="true" updatable="true" style="font-size:8pt; width: 140px;">
						<html:option value="0">&nbsp;</html:option>
						<july:options collection="AFTResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
				</july:select>
				<%String dpage = "/showCategoryResources.jsp?compid=aif&number=" + i2 + "&idc=" + idc;%>
				<jsp:include page='<%= dpage%>' flush="true"></jsp:include>
			</td>					
			<td class="print" width="120">
				<span id="aifsp<%=i2%>"><july:string property='<%= "aif["+i2+"].ksb"%>' style="font-size:8pt;" size="10" insertable="true" updatable="true" /></span>
			</td>
			<td class="print" width="70">
				<html:select property='<%= "aif["+i2+"].gsm"%>' style="font-size:8pt; background-color: D6EBFF; width: 55px;">
						<html:option value="900" >900</html:option>
						<html:option value="1800" >1800</html:option>
				</html:select>
			</td>
			<td class="print" width="200">

				<span id="aifsp<%=i2%>"><html:hidden property='<%= "aif["+i2+"].complect"%>'/><html:text property='<%= "aif["+i2+"].complectname"%>' style="font-size:8pt;FONT-FAMILY: Verdana,Arial;background-color: DCDCDC;" size="25" readonly="true"/>
				 
				<%String cpage = "/ShowComplectContractor.jsp?compid=aif&number=" + i2;%>
				<jsp:include page='<%= cpage%>' flush="true"></jsp:include>

				</span>
			</td>
			<td class="print" width="30">
				<input type="image" src="/images/del.gif" onclick="delAFT();return false;" name="delAFT"/>
			</td>
			<script language="javascript">
				var table = document.getElementById('afttable');
				table.rows(<%=i2+3%>).onmouseover = saveAFTIndex;
			</script>
		</tr>


		<%}%>


		</table>
		</td>
	</tr>

	<script language="javascript">
		toggleDetail('aftID');
	</script>
