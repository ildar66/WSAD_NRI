<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.dictionary.formbean.*"%>

<%!
private String isUp(String aSort, String name) {
 if(aSort.startsWith(name)) {
	 if(aSort.endsWith("desc")) 
		return (" <img src='/images/up.gif'  border='0' alt='по возрастанию'> ");
	 else
		return (" <img src='/images/down.gif'  border='0' alt='по убыванию'> "); 
 }
 else return ("");      
}
%>

<%
	java.lang.String gColSpan = "6";
	CurrateListForm listForm = (CurrateListForm)session.getAttribute("CurrateListForm");
	String sortBy = listForm.getSortBy();
%>

<july:browseform action="/ShowCurrateList.do" styleId="listForm">
<html:hidden property="sortBy"/>
<html:hidden property="selectedID" value="0"/>
<script language="javascript">
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
function onMouseOutRow(selectedID){
	if(document.all.selectedID.value==selectedID) {
		document.all.tableID.rows(selectedID,0).className="selected";
	}
	else {
		document.all.tableID.rows(selectedID,0).className="normal";
	}
}
function onClickRow(selectedID) {
	if(document.all.tableID.rows(document.all.selectedID.value) != null){
		document.all.tableID.rows(document.all.selectedID.value,0).className="normal";
	}
	document.all.selectedID.value=selectedID;
	document.all.tableID.rows(selectedID,0).className="selected";
	storeSelectedRow(selectedID);
}
function storeSelectedRow(selectedID) {
	document.cookie = listForm.name+"=" + selectedID;
}
function loadSelectedRow() {
	var cookies = document.cookie;
//	считываем selectedID:
	var startLoc = cookies.indexOf(listForm.name+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
    document.all.selectedID.value = cookies.substring(sepLoc+1, endLoc);
//	подчеркиваем строку в таблице:
	if( document.all.tableID.rows(document.all.selectedID.value) != null ) {
 		document.all.tableID.rows(document.all.selectedID.value,0).className="selected";
	}
}
</script>

<table class="main"  id="tableID">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
     <TR>
       <td class="title">Валюта:</td>
       <td class="text">
		    <july:select   style="width:133;" styleClass="seach" collection="currencies"  property="currency.currency"  insertable="true" updatable="true">
				<html:option  value="-1">Все</html:option>
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>	   
	   </td>
	   <td class="title"><july:searchbutton/></td>
     </TR>
     <TR>
        <td class="title"><bean:message key="label.ratetype.code"/>:</td>
        <td class="title">
 			<july:select  style="width:133;" styleClass="seach" collection="ratetypes" property="rateType.ratetype" insertable="true" updatable="false">
				<html:options collection="ratetypes" property="ratetype" labelProperty="name"/>
			</july:select>
        </td>
		<td class="title">&nbsp;</td>
     </TR>
	 <TR>
		<td class="text" nowrap>Период:</td>
		<td class="text">
			<july:date property="dataPeriod.fromDateFrm" size="25" insertable="true" updatable="true" styleId="fromDate"/>
			<B>&nbsp;по&nbsp;</B>
			<july:date property="dataPeriod.toDateFrm" size="25" insertable="true" updatable="true" styleId="toDate"/>
		</td>
		<td class="title">&nbsp;</td>
	</TR>	 
   </table>
    
  </TD>
</TR>


<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditCurrate.do?action=Add"/><july:backbutton/></TD>
			  <TD align="right">отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <TD class="title">&nbsp;</TD>
			<TD class="title" nowrap>
				<A title="Сортировать по полю 'Дата'" href="javascript:SortBy('date')"><bean:message key="label.currate.date"/></A><%=isUp(sortBy, "date")%>
			</TD>
			<TD class="title" nowrap>
				<A title="Сортировать по полю 'Курс'" href="javascript:SortBy('value')"><bean:message key="label.currate.value"/></A><%=isUp(sortBy, "value")%>
			</TD>
			<TD class="title" nowrap>
				<A title="Сортировать по полю 'Наим.'" href="javascript:SortBy('currName')"><bean:message key="label.currency.name"/></A><%=isUp(sortBy, "currName")%>
			</TD>
			<TD class="title" nowrap>
				<A title="Сортировать по полю 'Валюта'" href="javascript:SortBy('currency')"><bean:message key="label.currency.code"/></A><%=isUp(sortBy, "currency")%>
			</TD>
            <TD class="title">&nbsp;</TD>
        </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
        <logic:iterate id="cl" name="browseList"  indexId="indexId">
            <logic:present name="cl">
            <tr class="normal" id='<bean:write name="cl" property="date" filter="true"/>_<bean:write name="CurrateListForm" property="rateType.ratetype" filter="true"/>_<bean:write name="cl" property="currency.currency" filter="true"/>' onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id);" style="font-size:8pt;" onclick='onClickRow(this.id);'>
				<td class="link">
					<july:canedit>
						<A href='EditCurrate.do?action=Edit&currencycode=<bean:write name="cl" property="currency.currency" filter="true"/>&datestr=<july:datewrite name="cl" property="date"/>' title="<bean:message key='label.edit'/>"><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
					</july:canedit>
				</td>
                <td class="text">
                    <july:datewrite name="cl" property="date"/>
                </td>
                <td class="text" align="right">
                    <bean:write name="cl" property="value" filter="true"/>
                </td>
                <td class="text">
                      <bean:write name="cl" property="currency.name" filter="true"/>
                </td>
                <td class="number">
                    <bean:write name="cl" property="currency.currency" filter="true"/>
                </td>
                <td class="link">
                   <july:canedit>
					<A href='EditCurrate.do?action=Delete&currencycode=<bean:write name="cl" property="currency.currency" filter="true"/>&datestr=<july:datewrite name="cl" property="date"/>'>
                        <img src="/images/del.gif" border="0" alt='<bean:message key="label.delete"/>'>
					</A>
                   </july:canedit>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	        </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditCurrate.do?action=Add"/><july:backbutton/></TD>
			  <TD align="right">отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
<%--      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowRatetypeList.do" styleClass="navigator"><bean:message key="label.ratetype"/></html:link>
           <july:sepmark/> 
           <july:currmark><bean:message key="label.currate"/></july:currmark></td>
      </tr>
--%>        
    </table>

</july:browseform>

<script language="javascript">
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>
