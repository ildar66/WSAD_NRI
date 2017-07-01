<script language="javascript">
var multipleSelectForm = BSLookupListForm;

// generate array here

</script>

<script language="javascript" src="basestation/bsLookupList/multipleSelect.jsp"></script>

<tr>
	<td class="title" colspan="2">
		<table class="find">
		<tr>
			<td class="title">
				<bean:message key="label.mselect.superregion"/>
				<july:checkbox property="allsuperregions" onclick="switchSupregSearch(this.checked);switchSupregSearchAfter(this.checked);" insertable="true" updatable="true" /><bean:message key="label.all"/>
			</td>
			<td class="title">
				<bean:message key="label.mselect.region"/>
				<july:checkbox property="allregions" styleId="regionsAll" onclick="switchRegionSearch(this.checked);switchRegionSearchAfter(this.checked);" insertable="true" updatable="true" /><bean:message key="label.all"/>
			</td>
			<td class="title">
				<bean:message key="label.mselect.netzone"/>
				<july:checkbox property="allnetzones" onclick="switchNetzoneSearch(this.checked);switchNetzoneSearchAfter(this.checked);" insertable="true" updatable="true" /><bean:message key="label.all"/>
			</td>
		</tr>
		<tr>
			<td class="title">
				<july:select styleId="superregions" onchange="showRegions();reselectRegions();" collection="superregionsList" property="superregions" multiple="true" size="3" insertable="true" updatable="true" styleClass="editsmallsearch" style="width: 180pt">
					<html:options collection="superregionsList" property="superregid" labelProperty="supregname"/>
				</july:select>
			</td>
			<td class="title">
				<july:select styleId="regions" collection="regionsList" property="regions" multiple="true" size="3" insertable="true" updatable="true" styleClass="editsmallsearch" style="width: 180pt">
					<html:options collection="regionsList" property="regionid" labelProperty="regname"/>
				</july:select>
			</td>
			<td class="title">
				<july:select styleId="netzones" collection="netzonesList" property="netzones" multiple="true" size="3" insertable="true" updatable="true" styleClass="editsmallsearch" style="width: 180pt">
					<html:options collection="netzonesList" property="netzone" labelProperty="name"/>
				</july:select>
			</td>
		</tr>
		</table>
	</td>
</tr>
