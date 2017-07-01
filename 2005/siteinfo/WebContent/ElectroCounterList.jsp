<%@ page language = "java" %>

<%@ page import="com.hps.july.web.util.*,
		 com.hps.july.siteinfo.APPStates,
                 com.hps.july.constants.Applications,
                 com.hps.july.siteinfo.valueobject.ElectroCounter"%>

<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import = "com.hps.july.siteinfo.formbean.*"%>

<%!
	private String isUp(String aSort, String name) {
		if (aSort.startsWith(name)) {
			if (aSort.endsWith("desc"))
				return (" <img src='/images/up.gif'  border='0' alt='по возрастанию'> ");
			else
				return (" <img src='/images/down.gif'  border='0' alt='по убыванию'> ");
		} else {
			return ("");
		}
	}
%>

<%	String gColSpan = "12";
	ElectroCounterListForm listForm =
		(ElectroCounterListForm) session.getAttribute("electroCounterListForm");
	String sortBy = listForm.getOrderBy();
%>
	
<script language="JavaScript">
	function prepareSubmit() {
	    return true;
	}
	function SortBy(field)	{
		var e = document.all.orderBy;
		e.value = (e.value == field)?field + ' desc':field;
	    document.body.style.cursor="wait";
	    listForm.operation.value = "<%= com.hps.july.siteinfo.formbean.ElectroCounterListForm.SORT_BY%>";
		listForm.submit();
		return false;
	}
	function ShowXLS() { 
		listForm.operation.value = "<%= com.hps.july.siteinfo.formbean.ElectroCounterListForm.PRINT_XLS%>";
		listForm.submit();
	}
	function Refresh() { 
		listForm.operation.value = "<%= com.hps.july.siteinfo.formbean.ElectroCounterListForm.EMPTY%>";
	    document.body.style.cursor="wait";
		listForm.submit();
	}
	function toggleState(n){
		listForm.operation.value = "<%= com.hps.july.siteinfo.formbean.ElectroCounterListForm.EMPTY%>";
		document.all.state[n].checked = true;
		listForm.submit();
	}			    
</script>
<july:browseform action="/ShowElectroCounterList.do" styleId="listForm">
	<html:hidden property="orderBy" />
	<html:hidden property="operation" value="" />
	
    <table class="main" style="font-size: 8pt">
        <july:separator colspan="1" />
        <tr class="normal">
            <td>
                <table style="width :100%;">
                    <tr>
                        <td align="left" valign="middle">
                            <table class="find" style="font-size: 8pt">
                                <tr>
                                    <td align="left" valign="middle"  style="width : 15%">Поиск по</td>
                                    <td align="left" valign="middle"  style="width : 20%">
                                        <html:select property="searchFor" onchange="onChangeSearch();" style="width: 100pt; font-size: 8pt">
                                            <html:option value="1">Все</html:option>
                                            <html:option value="2">номеру счетчика</html:option>
                                            <html:option value="3">номеру GSM</html:option>
                                            <html:option value="4">номеру DAMPS</html:option>
                                            <html:option value="5">наименованию позиции</html:option>
                                        </html:select>
                                    </td>
                                    <td align="left" valign="middle"  style="width : 10%">Значение</td>
                                    <td align="left" valign="middle"  class="title" style="width : 45%" >
                                        <july:string styleClass="editsearch" property="searchValue" styleId="searchValue" insertable="true" updatable="true" style="font-size: 8pt"/>
                                    </td>
                                    <td align="left" valign="middle"  style="width : 10%">
                                        <%--july:searchbutton/--%>
										<INPUT TYPE='IMAGE' SRC='/images/refresh.gif' onclick="Refresh();return false;" border='0' alt='Искать'>&nbsp;&nbsp;
										<INPUT TYPE='IMAGE' SRC='/images/msexcel.gif' onclick="ShowXLS();return false;" ALT="Отчет ХLS">
                                    </td>
                                </tr>
                            </table>
                            <script>
                                <!--
                                    function onChangeSearch() {
                                        var searchFor = document.forms[0].searchFor.options[document.forms[0].searchFor.selectedIndex].value;
                                        var searchValue = document.getElementById('searchValue');
                                        if(searchValue) {
                                            if(searchFor == 1) {
                                                searchValue.className = 'editdisabled';
                                            } else {
                                                searchValue.className = 'editsearch';
                                                searchValue.focus();
                                            }
                                        }
                                    }
                                    onChangeSearch();
                                -->
                            </script>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" valign="middle">
                            <table class="find" style="font-size: 8pt">
                                <tr>
                                    <td align="left" valign="middle" style="width : 10%">Состояние</td>
                                    <td align="right" valign="middle" style="width : 15%">
                                        <july:radio property="state" value="0" insertable="true" updatable="true">
                                            <A href="javascript:toggleState(0)">все</A>
                                        </july:radio>
                                    </td>
                                    <td align="right" valign="middle" style="width : 20%">
                                        <july:radio property="state" value="1" insertable="true" updatable="true">
                                            <A href="javascript:toggleState(1)">активные</A>
                                        </july:radio>
                                    </td>
                                    <td align="right" valign="middle" style="width : 25%">
                                        <july:radio property="state" value="2" insertable="true" updatable="true">
                                            <A href="javascript:toggleState(2)">заменённые</A>
                                        </july:radio>
                                    </td>
                                    <td align="right" valign="middle" style="width : 30%">
                                        <july:radio property="state" value="3" insertable="true" updatable="true">
                                            <A href="javascript:toggleState(3)">демонтированные</A>
                                        </july:radio>
                                    </td>
                                </tr>
                            </table>
                        </td>
                     </tr>
                    <tr>
                        <td align="left" valign="middle">
                            <table class="find" style="font-size: 8pt">
                                <tr class="title">
                                    <td align="center" valign="middle" colspan="4" >Контрольный период поверки: </td>
                                </tr>
                                <tr class="normal">
                                    <td align="right" valign="middle" width="10%">
                                      <july:radio property="control" value="1" insertable="true" updatable="true">
                                        все
                                      </july:radio>
                                    </td>
                                    <td align="right" valign="middle" width="40%">
                                      <july:radio property="control" value="2" insertable="true" updatable="true">
                                        следующий квартал
                                      </july:radio>
                                    </td>
                                    <td align="right" valign="middle" width="40%">
                                      <july:radio property="control" value="3" insertable="true" updatable="true">
                                        до указанной даты
                                      </july:radio> &nbsp;
                                    </td>
                                    <td align="right" valign="middle" width="10%">
                                      <july:date style="font-size: 8pt; width: 70pt; height: 17pt" property="controlValueFrm" insertable="true" updatable="true"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                     </tr>
                </table>
            </td>
        </tr>
        <july:separator colspan="1" />
        <tr class="title">
          <td>
	          <TABLE class="buttons">
	            <TR class="title">
	              <TD class="buttons"><july:addbutton page="/EditElectroCounter.do?action=Add" modelName="list" selectable="1" /><july:backbutton page="/main.do"/></TD>
	              <td align="right">отобрано записей: <B><%=request.getAttribute("numberOfLines")%></B></td>
	              <TD class="navigator"></TD>
	            </TR>
	          </TABLE>
		</TD>
	</tr>
    <july:separator colspan="1" />
        <tr>
            <td align="left" valign="middle">
            <style>
                <!--
                    .selectedTR, .selectedTR td {
                        background-color : #D6C6EA;
                    }
                -->
            </style>
            <july:selectableTable styleClass="main" modelName="list" selectable="1" selectedClass="selectedTR" paramName="selectedID" style="font-size: 8pt">
                    <tr class="title">
                        <td class="title" align="center" valign="middle"><img src="/images/empty.gif" width="1" height="1"/></td>
                        <td class="title" align="center" valign="middle">
							<A title="Сортировать по полю 'gsmid'"
								href="javascript:SortBy('gsmid')">GSM</A><%=isUp(sortBy, "gsmid")%>
							<A title="Сортировать по полю 'dampsid'"
								href="javascript:SortBy('dampsid')">DAMPS</A><%=isUp(sortBy, "dampsid")%> 								                       
							<A title="Сортировать по полю 'имя Позиции'"
								href="javascript:SortBy('posname')">Позиция</A><%=isUp(sortBy, "posname")%>
                        </td>
                        <td class="title" align="center" valign="middle">
							<A title="Сортировать по полю 'Зона'"
								href="javascript:SortBy('zoneName')">Зона</A><%=isUp(sortBy, "zoneName")%>
                       	</td>                        
                        <td class="title" align="center" valign="middle">
							<A title="Сортировать по полю 'Номер электросчётчика'"
								href="javascript:SortBy('vendor_number')"> № </A><%=isUp(sortBy, "vendor_number")%>
                       	</td>
                        <td class="title" align="center" valign="middle">
							<A title="Сортировать по полю 'Тип электросчётчика'"
								href="javascript:SortBy('code')">Тип</A><%=isUp(sortBy, "code")%>
                       	</td>                       	
                        <td class="title" align="center" valign="middle">
							<A title="Сортировать по полю 'Состояние'"
								href="javascript:SortBy('cstate')">Состояние</A><%=isUp(sortBy, "cstate")%>                        
                         </td>
                        <td class="title" align="center" valign="middle">
							<A title="Сортировать по полю 'Год выпуска'"
								href="javascript:SortBy('production_year')">Год</A><%=isUp(sortBy, "production_year")%>                        
                        </td>
                        <td class="title" align="center" valign="middle">
							<A title="Сортировать по полю 'Дата последней поверки'"
								href="javascript:SortBy('last_verification')">Дата посл. поверки</A><%=isUp(sortBy, "last_verification")%>                        
                        </td>
                        <td class="title" align="center" valign="middle">
							<A title="Сортировать по полю 'Дата следующей поверки'"
								href="javascript:SortBy('next_verification')">Дата след. поверки</A><%=isUp(sortBy, "next_verification")%>                        
                        </td>
                        <td class="title" align="center" valign="middle">
							<A title="Сортировать по полю 'Энергоснабжение'"
								href="javascript:SortBy('isVendorPowerSupply ')">Энерго<br>снабжение</A><%=isUp(sortBy, "isVendorPowerSupply ")%>                        
                        </td>                        
                        <td class="title" align="center" valign="middle"><img src="/images/empty.gif" width="1" height="1"/></td>
                    </tr>
                    <%
                        ElectroCounter ec = null;
                    %>
                    <style>
                        <!--
                            .color3, .color3 td {
                                background-color : #FF7878;
                            }
                        -->
                    </style>
                    <logic:iterate id="elCounter" name="browseList">
                    <% ec=(ElectroCounter)pageContext.getAttribute("elCounter"); %>
                      <logic:present name="elCounter">
                      <%
                        String className = "normal";
                        if(ec.getWarning().booleanValue()) className = "selected";
                        else if(ec.getError().booleanValue()) className = "color3";
                          String onMouseOut = "className='" + className + "'";
                      %>
                         <july:selectableTR styleId="<%=ec.getId().toString()%>" styleClass="<%=className%>" paramName="selectedID" onmouseover="className='select'" onmouseout="<%=onMouseOut%>">
<%--
                         <tr class="<% if(ec.getWarning().booleanValue()) out.print("selected");
                                        else if(ec.getError().booleanValue()) out.print("color3");
                                        else out.print("normal");
                                        %>" onMouseOver="className='select'" onMouseOut="className='<% if(ec.getWarning().booleanValue()) out.print("selected");
                                        else if(ec.getError().booleanValue()) out.print("color3");
                                        else out.print("normal");
                                        %>'" >
--%>
                             <td class="text" style="width : 2%">
								<july:anchor />
                                <july:editbutton page="/EditElectroCounter.do" action="Edit" paramId="counterid" paramName="elCounter" paramProperty="id" modelName="list" selectable="1"/>
                            </td>
                             <td class="text">
                                 <%=ec.getName()%>
                             </td>
                             <td class="text">
                                 <%=ec.getZoneName()%>
                             </td>                             
                             <td class="text" style="text-align:center; vertical-align:middle;">
                                        <%=ec.getVendorNumber()%>
                            </td>
                             <td class="text">
                                 <%=ec.getCode()%>
                             </td>                            
                             <td class="text" style="text-align:center; vertical-align:middle;">
                                    <% if(ec.getState().equals(new Integer(1))) out.print("Активный");
                                        else if(ec.getState().equals(new Integer(2))) out.print("Заменённый");
                                        else if(ec.getState().equals(new Integer(3))) out.print("Демонтированный");
                                    %>
                            </td>
                             <td class="text" style="text-align:center; vertical-align:middle;">
                                        <%=ec.getProductionYear()%>
                            </td>
                             <td class="text" style="text-align:center; vertical-align:middle;">
                                    <%=ec.getFormatLastVerification()%>
                            </td>
                             <td class="text" style="text-align:center; vertical-align:middle;">
                                    <%=ec.getFormatNextVerification()%>
                            </td>
                             <td class="text" style="text-align:center; vertical-align:middle;">
                                    <%=ec.getIsVendorPowerSupply()%>
                            </td>
                            <td class="link" style="text-align:center; vertical-align:middle">
                                <july:delbutton page="/EditElectroCounter.do?action=Delete" paramId="counterid" paramName="elCounter" paramProperty="id" modelName="list" selectable="1"/>
                            </td>
                        </july:selectableTR>
                        <july:separator colspan="8"/>
                      </logic:present>
                    </logic:iterate>
                </july:selectableTable>
            </td>
        </tr>
        <tr class="title">
              <td>
                  <TABLE class="buttons">
                    <TR class="title">
                      <TD class="buttons"><july:addbutton page="/EditElectroCounter.do?action=Add" modelName="list" selectable="1"/><july:backbutton page="/main.do"/></TD>
                      <td align="right">отобрано записей: <B><%=request.getAttribute("numberOfLines")%></B></td>
                      <TD class="navigator"></TD>
                    </TR>
                  </TABLE>
            </TD>
        </tr>
        <july:separator colspan="1" />
    </table>
</july:browseform>
