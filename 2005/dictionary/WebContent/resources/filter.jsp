	<tr>
	<td class="title" nowrap>
		<july:checkbox property="isResourcetype" insertable="true" updatable="true" value="true" onclick="switchResourcetype();"/><html:hidden property="isResourcetype" value="false"/><bean:message key="label.resource.byrestype"/>:
	</td>
	<td class="title" nowrap>
		<july:string property="resourcetype.string" styleId="resourcetype" size="5" insertable="true" updatable="true"  styleClass="editkodsearch"/>
		<july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rtl" fieldNames="resourcetype;resourcetypename" newWindowName="restypelookup" insertable="true" updatable="true"/>
		<july:string size="35" property="resourcetypename" styleId="resourcetypename" insertable="false" updatable="false" />
		<july:searchbutton/>
	</td>
	</tr>
	<tr>
	<td class="title" nowrap>
		<july:checkbox property="isResourcesubtype" insertable="true" updatable="true" value="true" onclick="switchResourcesubtype();"/><html:hidden property="isResourcesubtype" value="false"/><bean:message key="label.resource.byressubtype"/>:
	</td>
	<td class="title" nowrap>
		<july:string property="resourcesubtype.string" styleId="resourcesubtype" size="5" insertable="true" updatable="true" styleClass="editkodsearch" />
		<july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="rstl" fieldNames="resourcesubtype;resourcesubtypename" newWindowName="ressbtypelookup" onclick="set_opt_params_rstl('?resourcetype='+document.all['resourcetype'].value)" insertable="true" updatable="true"/>
		<july:string size="35" property="resourcesubtypename" styleId="resourcesubtypename" insertable="false" updatable="false" />
	</td>
	</tr>
	<tr>
	<td class="title" nowrap>
		<july:checkbox property="isModel" insertable="true" updatable="true" value="true" onclick="switchModel();"/><html:hidden property="isModel" value="false"/><bean:message key="label.resource.bysign"/>:
	</td>
	<td class="title" nowrap><july:string size="40" property="model" styleId="model" insertable="true" updatable="true"  styleClass="search"/></td>
	</tr>
	<tr>
	<td class="title" nowrap>
		<july:checkbox property="isName" insertable="true" updatable="true" value="true" onclick="switchName();"/><html:hidden property="isName" value="false"/><bean:message key="label.resource.byname"/>:
	</td>
	<td class="title" nowrap><july:string size="40" property="name" styleId="name" insertable="true" updatable="true" styleClass="search" /></td>
	</tr>
	<tr>
	<td class="title" nowrap>
		<july:checkbox property="isManufid" insertable="true" updatable="true" value="true" onclick="switchManuf();"/><html:hidden property="isManuf" value="false"/><bean:message key="label.resource.bymanufacturer"/>:
	</td>
	<td class="title" nowrap>
		<july:string property="manufid.string" styleId="manufid" size="5" insertable="true" updatable="true" styleClass="editkodsearch" />
		<%--<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="manuf;manufname" newWindowName="orglookup" insertable="true" updatable="true"/>--%>
		<july:lookupbutton action="/ShowEquipmanufLookupList.do" styleId="orgl" fieldNames="manufid;manufname" newWindowName="orglookup" insertable="true" updatable="true"/>
		<july:string size="25" property="manufname" styleId="manufname" insertable="false" updatable="false" />
	</td>
	</tr>
	<tr>
	<td class="title" nowrap>
		<july:checkbox property="isManucode" insertable="true" updatable="true" value="true" onclick="switchManucode();"/><html:hidden property="isManucode" value="false"/><bean:message key="label.resource.bymanucode"/>:
	</td>
	<td class="title" nowrap><july:string size="40" property="manucode" styleId="manucode" insertable="true" updatable="true" styleClass="search" /></td>
	</tr>
	
	<tr>
	<td class="title" nowrap>
		<july:checkbox property="isNfscode" insertable="true" updatable="true" value="true" onclick="switchNfscode();"/><html:hidden property="isNfscode" value="false"/><bean:message key="label.resource.nfscode"/>:
	</td>
		<td class="title" nowrap><july:string size="40" property="nfscode" styleId="nfscode" insertable="true" updatable="true" styleClass="search" /></td>
	</tr>
	
	<tr>
	<td class="title"><bean:message key="label.resource.show"/>:</td>
	<td class="title">
		<html:select property="showType">
			<html:option value="*" key="label.resource.showall"/>
			<html:option value="Y" key="label.resource.shownew"/>
			<html:option value="N" key="label.resource.showold"/>
		</html:select>
	</td>
	</tr>        
	<tr>
		<td class="title">
			<july:checkbox property="isNricode" insertable="true" updatable="true" value="true" onclick="switchNricode();"/><html:hidden property="isNricode" value="false"/><bean:message key="label.resource.nricode"/>:
		</td>
			<td class="title" nowrap><july:string size="40" property="nricode" styleId="nricode" insertable="true" updatable="true" styleClass="search" /></td>
	</tr>        
<script language="javascript">
</script>
