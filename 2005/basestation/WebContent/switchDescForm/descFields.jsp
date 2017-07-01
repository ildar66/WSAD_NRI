<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/bsapptags.tld"    prefix="jbs" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="org.apache.struts.util.*"%>

<tr>
<%-- Показать характеристику на дату --%>
	<td class="text" width="30%"><bean:message key="label.swd.date"/></td>
	<td width="70%">
		<logic:equal name="SwitchDescForm" property="action" value="View">
		<jbs:selectdates property="date.string" collection="dates" styleClass="text" style="width:128;" onchange="submit();"/>
<%---------Edit buttons-----%>
<alex:hasAccess href="/EditFactSwitchDesc.do" >
<logic:equal name="SwitchDescForm" property="editable" value="true">
		<logic:present name="SwitchDescForm" property="date.sqlDate">
			<july:editbutton page="/EditFactSwitchDesc.do" action="Edit"/>
		</logic:present>
		<july:addbutton page="/EditFactSwitchDesc.do?action=Add"/>
		<logic:present name="SwitchDescForm" property="date.sqlDate">
			<july:delbutton page="/EditFactSwitchDesc.do?action=Delete"/>
		</logic:present>
</logic:equal>
</alex:hasAccess>
<%-------------end--------------%>
			<%--july:searchbutton/--%>
		</logic:equal>
		<logic:notEqual name="SwitchDescForm" property="action" value="View">
			<july:date property="date.string" insertable="true" updatable="false"/>
		</logic:notEqual>
	</td>
</tr>

<july:separator/>

<tr>
<td colspan="2">
<table class="main">
<tr>
<%-- День наибольшей нагрузки (д.н.н.) --%>
	<td class="text" width="30%"><bean:message key="label.swd.load_max_day"/></td>
	<td class="text"  width="70%" colspan=3>
		<july:string size="10" property="load_max_day" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
<%-- Час наибольшей нагрузки (общий ч.н.н.) --%>
	<td class="text" width="30%"><bean:message key="label.swd.load_max_hour_all"/></td>
	<td class="text" width="20%">
		<july:string size="10" property="load_max_hour_all" insertable="true" updatable="true" />
	</td>
<%-- Значение общего трафика Эрл. (общий ч.н.н.) --%>
	<td class="text" width="30%"><bean:message key="label.swd.traf_all"/></td>
	<td class="text" width="20%">
		<july:string size="10" property="traf_all.string" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
<%-- Значение BSS трафика Эрл. (общий ч.н.н.) --%>
	<td class="text"><bean:message key="label.swd.traf_bss_all"/></td>
	<td class="text">
		<july:string size="10" property="traf_bss_all.string" insertable="true" updatable="true" />
	</td>
<%-- Значение NSS трафика Эрл. (общий ч.н.н.) --%>
	<td class="text"><bean:message key="label.swd.traf_nss_all"/></td>
	<td class="text">
		<july:string size="10" property="traf_nss_all.string" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
<%-- Час наибольшей загрузки для трафика BSS (ч.н.н. BSS) --%>
	<td class="text"><bean:message key="label.swd.load_max_hour_bss"/></td>
	<td class="text">
		<july:string size="10" property="load_max_hour_bss" insertable="true" updatable="true" />
	</td>
<%-- Значение BSS трафика Эрл. (ч.н.н. BSS) --%>
	<td class="text"><bean:message key="label.swd.traf_bss_bss"/></td>
	<td class="text">
		<july:string size="10" property="traf_bss_bss.string" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
<%-- Количествро абонентов в VLR --%>
	<td class="text"><bean:message key="label.swd.abon_qty_bss"/></td>
	<td class="text">
		<july:string size="10" property="abon_qty_bss.string" insertable="true" updatable="true" />
	</td>
<%-- Активность абонентов (VLR) Ерл/Аб в ч.н.н. BSS --%>
	<td class="text"><bean:message key="label.swd.abon_act_bss"/></td>
	<td class="text">
		<july:string size="10" property="abon_act_bss.string" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
<%-- Час наибольшей загрузки для трафика NSS (ч.н.н.) --%>
	<td class="text"><bean:message key="label.swd.load_max_hour_nss"/></td>
	<td class="text">
		<july:string size="10" property="load_max_hour_nss" insertable="true" updatable="true" />
	</td>
<%-- Значение NSS трафика (ч.н.н. NSS) --%>
	<td class="text"><bean:message key="label.swd.traf_nss_nss"/></td>
	<td class="text">
		<july:string size="10" property="traf_nss_nss.string" insertable="true" updatable="true" />
	</td>
</tr>
<tr>

<logic:equal name="SwitchDescForm" property="action" value="View">
<%-- Техническая ёмкость Эрл. в сторону BSS по уровню перегрузки --%>
	<td class="text"><bean:message key="label.swd.bsscerl"/></td>
	<td class="text">
		<jbs:vselect collection="bsscerl" keyname="paramid" idname="param_level" valuename="param_value" target="bsscerl_fld"/> %
	</td>
	<td class="text" colspan=2>
		<input type="text" class="editsmalldisabled" name="bsscerl_fld">
		<alex:hasAccess href="/EditSwitchDescParam.do" >
			<logic:present name="SwitchDescForm" property="date.sqlDate">
				<july:editbutton page="/EditSwitchDescParam.do?paramid=1" action="Edit" alttext="label.params.edit"/>
			</logic:present>
		</alex:hasAccess>
	</td>
</tr>
<tr>
<%-- Техническая ёмкость Эрл. в сторону NSS по уровню перегрузки --%>
	<td class="text"><bean:message key="label.swd.nsscerl"/></td>
	<td class="text">
		<jbs:vselect collection="nsscerl" keyname="paramid" idname="param_level" valuename="param_value" target="nsscerl_fld"/> %
	</td>
	<td class="text" colspan=2>
		<input type="text" class="editsmalldisabled" name="nsscerl_fld">
		<alex:hasAccess href="/EditSwitchDescParam.do" >
			<logic:present name="SwitchDescForm" property="date.sqlDate">
				<july:editbutton page="/EditSwitchDescParam.do?paramid=2" action="Edit" alttext="label.params.edit"/>
			</logic:present>
		</alex:hasAccess>
	</td>
</tr>
</logic:equal>

<tr>
<%-- Общее количество попыток для мобильного трафика (общий ч.н.н.) --%>
	<td class="text"><bean:message key="label.swd.tryqty_mobile_all"/></td>
	<td class="text">
		<july:string size="10" property="tryqty_mobile_all.string" insertable="true" updatable="true" />
	</td>
<%-- Мобильная нагрузка в процентах от максимальной --%>
	<td class="text"><bean:message key="label.swd.load_mobile"/></td>
	<td class="text">
		<july:string size="10" property="load_mobile.string" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
<%-- Общее количество попыток для транзитного трафика (общий ч.н.н.) --%>
	<td class="text"><bean:message key="label.swd.tryqty_transit_all"/></td>
	<td class="text">
		<july:string size="10" property="tryqty_transit_all.string" insertable="true" updatable="true" />
	</td>
<%-- Транзитная нагрузка в процентах от максимальной --%>
	<td class="text"><bean:message key="label.swd.load_transit"/></td>
	<td class="text">
		<july:string size="10" property="load_transit.string" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
<%-- Общее количество SMS --%>
	<td class="text"><bean:message key="label.swd.tryqty_sms_all"/></td>
	<td class="text">
		<july:string size="10" property="tryqty_sms_all.string" insertable="true" updatable="true" />
	</td>
<%-- SMS нагрузка в процентах от максимальной --%>
	<td class="text"><bean:message key="label.swd.load_sms_percent"/></td>
	<td class="text">
		<july:string size="10" property="load_sms_percent.string" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
<%-- Общая событийная нагрузка в процентах от максимальной --%>
	<td class="text"><bean:message key="label.swd.load_event_percent"/></td>
	<td class="text">
		<july:string size="10" property="load_event_percent.string" insertable="true" updatable="true" />
	</td>
<%-- Загрузка процессора в процентах от максимальной --%>
	<td class="text"><bean:message key="label.swd.load_all_percent"/></td>
	<td class="text">
		<july:string size="10" property="load_all_percent.string" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
<%-- Коэффициент концентрации нагрузки в процентах (отношение общего суммарного трафика к трафику в общий ч.н.н.) --%>
	<td class="text" colspan=3><bean:message key="label.swd.koeff_kn"/></td>
	<td class="text">
		<july:string size="10" property="koeff_kn.string" insertable="true" updatable="true" />
	</td>
</tr>

<logic:equal name="SwitchDescForm" property="action" value="View">
<tr>
<%-- Количество А-инт с перегрузкой выше --%>
	<td class="text"><bean:message key="label.swd.aint_overload"/></td>
	<td class="text">
		<jbs:vselect collection="aint_overload" keyname="paramid" idname="param_level" valuename="param_value" target="aint_overload_fld"/> %
	</td>
<%-- в собственный ч.н.н. Контроллера --%>
	<td class="text"><bean:message key="label.swd.aint_contr"/></td>
	<td class="text">
		<input type="text" class="editsmalldisabled" name="aint_overload_fld">
		<alex:hasAccess href="/EditSwitchDescParam.do" >
			<logic:present name="SwitchDescForm" property="date.sqlDate">
				<july:editbutton page="/EditSwitchDescParam.do?paramid=3" action="Edit" alttext="label.params.edit"/>
			</logic:present>
		</alex:hasAccess>
	</td>

</tr>
<tr>
<%-- Количество TKG-ROUTE с перегрузкой выше --%>
	<td class="text"><bean:message key="label.swd.tkg_overload"/></td>
	<td class="text">
		<jbs:vselect collection="tkg_overload" keyname="paramid" idname="param_level" valuename="param_value" target="tkg_overload_fld"/> %
	</td>
<%-- в собственный ч.н.н. TKG-ROUTE --%>
	<td class="text"><bean:message key="label.swd.tkg_contr"/></td>
	<td class="text">
		<input type="text" class="editsmalldisabled" name="tkg_overload_fld">
		<alex:hasAccess href="/EditSwitchDescParam.do" >
			<logic:present name="SwitchDescForm" property="date.sqlDate">
				<july:editbutton page="/EditSwitchDescParam.do?paramid=4" action="Edit" alttext="label.params.edit"/>
			</logic:present>
		</alex:hasAccess>
	</td>
</tr>
<tr>
<%-- Количество TKG-ROUTE где CSR выше --%>
	<td class="text"><bean:message key="label.swd.tkgcsr_overload"/></td>
	<td class="text">
		<jbs:vselect collection="tkgcsr_overload" keyname="paramid" idname="param_level" valuename="param_value" target="tkgcsr_overload_fld"/>
	</td>
<%-- в собственный ч.н.н. --%>
	<td class="text"><bean:message key="label.swd.tkgcsr_contr"/></td>
	<td class="text">
		<input type="text" class="editsmalldisabled" name="tkgcsr_overload_fld">
		<alex:hasAccess href="/EditSwitchDescParam.do" >
			<logic:present name="SwitchDescForm" property="date.sqlDate">
				<july:editbutton page="/EditSwitchDescParam.do?paramid=5" action="Edit" alttext="label.params.edit"/>
			</logic:present>
		</alex:hasAccess>
	</td>
</tr>
<tr>
<%-- Количество звеньев SS-7 с нагрузкой выше --%>
	<td class="text"><bean:message key="label.swd.ss7_load"/></td>
	<td class="text">
		<jbs:vselect collection="ss7_load" keyname="paramid" idname="param_level" valuename="param_value" target="ss7_load_fld"/>
	</td>
<%-- Эрл. в собственный ч.н.н. --%>
	<td class="text"><bean:message key="label.swd.ss7_contr"/></td>
	<td class="text">
		<input type="text" class="editsmalldisabled" name="ss7_load_fld">
		<alex:hasAccess href="/EditSwitchDescParam.do" >
			<logic:present name="SwitchDescForm" property="date.sqlDate">
				<july:editbutton page="/EditSwitchDescParam.do?paramid=6" action="Edit" alttext="label.params.edit"/>
			</logic:present>
		</alex:hasAccess>
	</td>
</tr>
<script language="javascript">
	onChangeSelect_bsscerl();
	onChangeSelect_nsscerl();
	onChangeSelect_aint_overload();
	onChangeSelect_tkg_overload();
	onChangeSelect_tkgcsr_overload();
	onChangeSelect_ss7_load();
</script>
</logic:equal>

</table>
</td>
</tr>
