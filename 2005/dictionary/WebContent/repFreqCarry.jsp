<% java.lang.String gColSpan = "10"; %>

<tr>
	<td><bean:message key="label.repeater.freqcarry.linkfreq"/>:</td>
	<td>
		<july:select collection="usedBands" property="linkbandFrm" insertable="true" updatable="true"
		onchange="queryResetLinks()" tabindex="">
			<july:options collection="usedBands" property="bandid" labelProperty="bandname"/>
		</july:select>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<jsp:useBean id="repform" class="com.hps.july.dictionary.formbean.RepeaterForm"/>
<%
	for (int i=0;i<repform.getDonorUnitCount();i++){
		String resource = repform.getDonorUnitInfo(i).getResource();
		String power = repform.getDonorUnitInfo(i).getPower();
		String workband = repform.getDonorUnitInfo(i).getWorkband();
		String linkband = repform.getDonorUnitInfo(i).getLinkband();
		String gainfactor = repform.getDonorUnitInfo(i).getGainfactor();
		String voltageid = repform.getDonorUnitInfo(i).getVoltageid();
		String usedpower = repform.getDonorUnitInfo(i).getUsedpower();
		String entriescount = repform.getDonorUnitInfo(i).getEntriescount();
		String antgatescount = repform.getDonorUnitInfo(i).getAntgatescount();
		String signaldelay = repform.getDonorUnitInfo(i).getSignaldelay();
		String noisefactor = repform.getDonorUnitInfo(i).getNoisefactor();
%>
		i= <%= i %><BR>
		resource= <%= resource %><BR>
		power= <%= power %><BR>
		workband= <%= workband %><BR>
		linkband= <%= linkband %><BR>
		gainfactor= <%= gainfactor %><BR>
		voltageid= <%= voltageid %><BR>
		usedpower= <%= usedpower %><BR>
		entriescount= <%= entriescount %><BR>
		antgatescount= <%= antgatescount %><BR>
		signaldelay= <%= signaldelay %><BR>
		noisefactor= <%= noisefactor %><BR>
<%
	}
%>