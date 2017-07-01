<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ taglib uri="/WEB-INF/bsapptags.tld" prefix="jbs" %>


<%	String isCertain = "true"; %>

<logic:equal name="ControllerDescForm" property="action" value="View">
		<%	isCertain = "false"; %>
</logic:equal>

<logic:equal name="ControllerDescForm" property="action" value="View">

		<tr>
			<td class="text"><bean:message key="controller.addinfo.showdate"/>:</td>
			<td class="text">
				<jbs:selectdates property="act_dateFrm" collection="actdates" styleClass="text" name="ControllerDescForm" onchange="submit();"/>
				<alex:hasAccess href="/EditFactControllerDesc.do" >
<logic:equal name="ControllerDescForm" property="editable" value="true">
					<logic:present name="ControllerDescForm" property="act_date">
						<july:editbutton page="/EditFactControllerDesc.do" action="Edit"/>
					</logic:present>
					<july:addbutton page="/EditFactControllerDesc.do?action=Add"/>
					<logic:present name="ControllerDescForm" property="act_date">
						<july:delbutton page="/EditFactControllerDesc.do?action=Delete"/>
					</logic:present>
</logic:equal>
				</alex:hasAccess>
			</td>
		</tr>

	</logic:equal>

	<logic:notEqual name="ControllerDescForm" property="action" value="View">

		<tr>
			<td class="text"><bean:message key="controller.addinfo.date"/>:</td>
			<td class="text"><july:date property="act_dateFrm" size="25" insertable="true" updatable="false"/></td>
		</tr>

	</logic:notEqual>

	<july:separator/>

	<tr>
		<td class="text" colspan=2>
			<table class="main">
				<tr>
					<td class="text" width="30%"><bean:message key="controller.addinfo.load_max_day"/>:</td>
					<td class="text" width="20%"><july:string size="10" property="load_max_day" insertable="<%= isCertain %>" updatable="<%= isCertain %>"/></td>
					<td class="text" width="30%"><bean:message key="controller.addinfo.load_max_hour"/>:</td>
					<td class="text" width="20%"><july:string size="10" property="load_max_hour" insertable="<%= isCertain %>" updatable="<%= isCertain %>"/></td>
				</tr>

				<tr>
					<td class="text" width="70%" colspan=3><bean:message key="controller.addinfo.koef_kk"/>:</td>
					<td class="text" width="30%"><july:string property="koef_kkFrm" size="10" insertable="<%= isCertain %>" updatable="<%= isCertain %>"/>&nbsp;%</td>
				</tr>

				<tr>
					<td class="text" width="30%"><bean:message key="controller.addinfo.traf_aint"/>:</td>
					<td class="text" width="20%"><july:string property="traf_aintFrm" size="10" insertable="<%= isCertain %>" updatable="<%= isCertain %>"/></td>
					<td class="text" width="30%"><bean:message key="controller.addinfo.load_aint_percent"/>:</td>
					<td class="text" width="20%"><july:string property="load_aint_percentFrm" size="10" insertable="<%= isCertain %>" updatable="<%= isCertain %>"/>&nbsp;%</td>
				</tr>

				<tr>
					<td class="text" width="70%" colspan=3><bean:message key="controller.addinfo.ss7_load_avg"/>:</td>
					<td class="text" width="30%"><july:string property="ss7_load_avgFrm" size="10" insertable="<%= isCertain %>" updatable="<%= isCertain %>"/></td>
				</tr>

				<logic:equal name="ControllerDescForm" property="action" value="View">

					<tr>
						<td class="text" width="30%"><bean:message key="controller.addinfo.ter"/>:</td>
						<td class="text" width="20%"><jbs:vselect collection="ter" keyname="paramid" idname="param_level" valuename="param_value" target="ter_fld"/>&nbsp;%</td>
						<td class="text" width="50%" colspan=2>
							<input type="text" class="editsmalldisabled" name="ter_fld">

							<logic:present name="ControllerDescForm" property="act_date">
								<alex:hasAccess href="/EditControllerDescParam.do" >
									<july:editbutton page="/EditControllerDescParam.do?paramid=1" action="Edit" alttext="label.params.edit"/>
								</alex:hasAccess>
                					</logic:present>
						</td>
					</tr>

				</logic:equal>

				<tr>
					<td class="text" width="70%" colspan=3><bean:message key="controller.addinfo.acc_load"/>:</td>
					<td class="text" width="30%"><july:string property="acc_loadFrm" size="10" insertable="<%= isCertain %>" updatable="<%= isCertain %>"/></td>
				</tr>

				<tr>
					<td class="text" width="70%" colspan=3><bean:message key="controller.addinfo.cap_use_percent"/>:</td>
					<td class="text" width="30%"><july:string property="cap_use_percentFrm" size="10" insertable="<%= isCertain %>" updatable="<%= isCertain %>"/>&nbsp;%</td>
				</tr>

				<logic:equal name="ControllerDescForm" property="action" value="View">

					<tr>
						<td class="text" width="30%"><bean:message key="controller.addinfo.ksot"/>:</td>
						<td class="text" width="20%"><jbs:vselect collection="ksot" keyname="paramid" idname="param_level" valuename="param_value" target="ksot_fld"/></td>
						<td class="text" width="30%"><bean:message key="controller.addinfo.vs"/>:</td>
						<td class="text" width="20%">
							<input type="text" class="editsmalldisabled" name="ksot_fld">
							<logic:present name="ControllerDescForm" property="act_date">
								<alex:hasAccess href="/EditControllerDescParam.do" >
									<july:editbutton page="/EditControllerDescParam.do?paramid=2" action="Edit" alttext="label.params.edit"/>
								</alex:hasAccess>
							</logic:present>
						</td>
					</tr>

					<tr>
						<td class="text" width="30%"><bean:message key="controller.addinfo.ksos"/>:</td>
						<td class="text" width="20%"><jbs:vselect collection="ksos" keyname="paramid" idname="param_level" valuename="param_value" target="ksos_fld"/></td>
						<td class="text" width="30%"><bean:message key="controller.addinfo.vs"/>:</td>
						<td class="text" width="20%">
							<input type="text" class="editsmalldisabled" name="ksos_fld">
							<logic:present name="ControllerDescForm" property="act_date">
								<alex:hasAccess href="/EditControllerDescParam.do" >
									<july:editbutton page="/EditControllerDescParam.do?paramid=3" action="Edit" alttext="label.params.edit"/>
								</alex:hasAccess>
							</logic:present>
						</td>
					</tr>

					<script language="javascript">
						onChangeSelect_ter();
						onChangeSelect_ksot();
						onChangeSelect_ksos();
					</script>

				</logic:equal>

				<tr>
					<td class="text" width="70%" colspan=3><bean:message key="controller.addinfo.bad_cunsr_percent"/>:</td>
					<td class="text" width="30%"><july:string property="bad_cunsr_percentFrm" size="10" insertable="<%= isCertain %>" updatable="<%= isCertain %>"/>&nbsp;%</td>
				</tr>

				<tr>
					<td class="text" width="30%" colspan=3><bean:message key="controller.addinfo.bad_cunssr_percent"/>:</td>
					<td class="text" width="30%"><july:string property="bad_cunssr_percentFrm" size="10" insertable="<%= isCertain %>" updatable="<%= isCertain %>"/>&nbsp;%</td>
				</tr>

				<tr>
					<td class="text" width="30%" colspan=3><bean:message key="controller.addinfo.conn_lost_avg"/>:</td>
					<td class="text" width="30%"><july:string property="conn_lost_avgFrm" size="10" insertable="<%= isCertain %>" updatable="<%= isCertain %>"/></td>
				</tr>
			</table>
		</td>
	</tr>