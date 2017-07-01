<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.inventory.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	    int appState = ParamsParser.getState( pageContext );
%>

<table width="200" height="300">
	<tr class="select">
		<td class="menu" vAlign=top>
<july:menu selectedId="<%=appState%>">
	<july:menuitem key="label.menu.root" action="main.do?navclear=1" stateId="<%=APPStates.MAIN %>">
		<july:menuselection stateId="<%=APPStates.MAIN%>"/>
<%
if(request.isUserInRole("StorageManager") || request.isUserInRole("administrator")) {
%>
		<july:menuitem key="label.menu.income" stateId="-1">
			<july:menuitem key="label.menu.income.internal" action="ShowInternalList.do?navclear=1" stateId="<%=APPStates.IOLIST%>">
				<july:menuselection stateId="<%=APPStates.IOLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITIO%>"/>
				<july:menuselection stateId="<%=APPStates.EDITIOST%>"/>
				<july:menuselection stateId="<%=APPStates.IODLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITIOD%>"/>
				<july:menuselection stateId="<%=APPStates.IOPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITIOP%>"/>
				<july:menuselection stateId="<%=APPStates.IOLOADEXCEL%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.income.external" action="ShowExternalList.do?navclear=1" stateId="<%=APPStates.EOLIST%>">
				<july:menuselection stateId="<%=APPStates.EOLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITEO%>"/>
				<july:menuselection stateId="<%=APPStates.EDITEOST%>"/>
				<july:menuselection stateId="<%=APPStates.EOPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITEOP%>"/>
				<july:menuselection stateId="<%=APPStates.EOSLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITEOS%>"/>
				<july:menuselection stateId="<%=APPStates.EDITEOM%>"/>
				<july:menuselection stateId="<%=APPStates.EOLOADEXCEL%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.income.mismatch" action="ShowMismatchList.do?navclear=1" stateId="<%=APPStates.MISLIST%>">
				<july:menuselection stateId="<%=APPStates.MISLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITMIS%>"/>
			</july:menuitem>
		</july:menuitem>
		<july:menuitem key="label.menu.outcome" stateId="-2">
			<july:menuitem key="label.menu.outcome.internalr" action="ShowInternalRList.do?navclear=1" stateId="<%=APPStates.IORLIST%>">
				<july:menuselection stateId="<%=APPStates.IORLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITIOR%>"/>
				<july:menuselection stateId="<%=APPStates.EDITIORST%>"/>
				<july:menuselection stateId="<%=APPStates.IORPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITIORP%>"/>
				<july:menuselection stateId="<%=APPStates.IORLOADEXCEL%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.outcome.externalr" action="ShowExternalRList.do?navclear=1" stateId="<%=APPStates.EORLIST%>">
				<july:menuselection stateId="<%=APPStates.EORLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITEOR%>"/>
				<july:menuselection stateId="<%=APPStates.EDITEORST%>"/>
				<july:menuselection stateId="<%=APPStates.EORPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITEORP%>"/>
			</july:menuitem>
		</july:menuitem>
		<july:menuitem key="label.menu.other" stateId="-3">
			<july:menuitem key="label.menu.inventory.acts" action="ShowInvActList.do?navclear=1" stateId="<%=APPStates.IVALIST %>">
				<july:menuselection stateId="<%=APPStates.IVALIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITIVA%>"/>
				<july:menuselection stateId="<%=APPStates.EDITIVAS%>"/>
				<july:menuselection stateId="<%=APPStates.IVAPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITIVAP%>"/>
				<july:menuselection stateId="<%=APPStates.IRASLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITIRAS%>"/>
				<july:menuselection stateId="<%=APPStates.INVACTLOADEXCEL%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.other.changes" action="ShowChangeSList.do?navclear=1" stateId="<%=APPStates.CHSLIST%>">
				<july:menuselection stateId="<%=APPStates.CHSLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITCHS%>"/>
				<july:menuselection stateId="<%=APPStates.EDITCHSST%>"/>
				<july:menuselection stateId="<%=APPStates.CHSPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITCHSP%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.changee" action="ShowChangeEList.do?navclear=1" stateId="<%=APPStates.CHELIST%>">
				<july:menuselection stateId="<%=APPStates.CHELIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITCHE%>"/>
				<july:menuselection stateId="<%=APPStates.EDITCHEST%>"/>
				<july:menuselection stateId="<%=APPStates.CHEPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITCHEP%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.other.assact" action="ShowAssactList.do?navclear=1" stateId="<%=APPStates.ASSLIST%>">
				<july:menuselection stateId="<%=APPStates.ASSLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITASS%>"/>
				<july:menuselection stateId="<%=APPStates.EDITASSST%>"/>
				<july:menuselection stateId="<%=APPStates.ASSPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITASSP%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.other.dassact" action="ShowDAssactList.do?navclear=1" stateId="<%=APPStates.DASSLIST%>">
				<july:menuselection stateId="<%=APPStates.DASSLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITDASS%>"/>
				<july:menuselection stateId="<%=APPStates.EDITDASSST%>"/>
				<july:menuselection stateId="<%=APPStates.DASSPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITDASSP%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.other.payoff" action="ShowPayoffList.do?navclear=1" stateId="<%=APPStates.POLIST%>">
				<july:menuselection stateId="<%=APPStates.POLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITPO%>"/>
				<july:menuselection stateId="<%=APPStates.EDITPOST%>"/>
				<july:menuselection stateId="<%=APPStates.POPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITPOP%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.other.req" action="ShowReqList.do?navclear=1" stateId="<%=APPStates.REQLIST%>">
				<july:menuselection stateId="<%=APPStates.REQLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITREQ%>"/>
				<july:menuselection stateId="<%=APPStates.EDITREQST%>"/>
				<july:menuselection stateId="<%=APPStates.REQPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITREQP%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.barcodes" stateId="-20">
				<july:menuitem key="label.menu.barcodes.ser" action="ShowBarList.do?navclear=1" stateId="<%=APPStates.BARLIST%>">
					<july:menuselection stateId="<%=APPStates.BARLIST%>"/>
					<july:menuselection stateId="<%=APPStates.EDITBAR%>"/>
					<july:menuselection stateId="<%=APPStates.BARPARAMS%>"/>
					<july:menuselection stateId="<%=APPStates.BARPRINT%>"/>
				</july:menuitem>
				<july:menuitem key="label.menu.barcodes.code" action="BarSParams.do?navclear=1" stateId="<%=APPStates.SERPARAMS%>">
					<july:menuselection stateId="<%=APPStates.SERPARAMS%>"/>
					<july:menuselection stateId="<%=APPStates.SERPRINT%>"/>
				</july:menuitem>
			</july:menuitem>
		</july:menuitem>
<%
}
if(request.isUserInRole("siteTransport") || request.isUserInRole("siteStation") || request.isUserInRole("siteExploitor") || request.isUserInRole("TechStuff") || request.isUserInRole("administrator")) {
%>
		<july:menuitem key="label.menu.posincome" stateId="-9">
			<july:menuitem key="label.menu.oppos.assemblingp" action="ShowAssemblingPList.do?navclear=1" stateId="<%=APPStates.ASPLIST%>">
				<july:menuselection stateId="<%=APPStates.ASPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITASP%>"/>
				<july:menuselection stateId="<%=APPStates.MOUNTEDIT2%>"/>
				<july:menuselection stateId="<%=APPStates.EDITASPPU%>"/>
				<july:menuselection stateId="<%=APPStates.MOUNTEDIT3%>"/>
				<july:menuselection stateId="<%=APPStates.EDITASPST%>"/>
				<july:menuselection stateId="<%=APPStates.ASPPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITASPP%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.other.assactb" action="ShowAssactBList.do?navclear=1" stateId="<%=APPStates.ASSBLIST%>">
				<july:menuselection stateId="<%=APPStates.ASSBLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITASSB%>"/>
				<july:menuselection stateId="<%=APPStates.EDITASSBST%>"/>
				<july:menuselection stateId="<%=APPStates.ASSBPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITASSBP%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.oppos.afs" action="ShowAfsList.do?navclear=1" stateId="<%=APPStates.AFSLIST%>">
				<july:menuselection stateId="<%=APPStates.AFSLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITAFS%>"/>
				<july:menuselection stateId="<%=APPStates.AFSSTATE%>"/>
				<july:menuselection stateId="<%=APPStates.AFSPOSLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITAFSPOSG%>"/>
				<july:menuselection stateId="<%=APPStates.EDITAFSPOSA%>"/>
				<july:menuselection stateId="<%=APPStates.EDITAFSPOS%>"/>
				<july:menuselection stateId="<%=APPStates.AFSEDIT21 %>"/>
				<july:menuselection stateId="<%=APPStates.AFSEDIT22 %>"/>
				<july:menuselection stateId="<%=APPStates.AFSINDOOR %>"/>
				<july:menuselection stateId="<%=APPStates.EDITAFSDPOS %>"/>
			</july:menuitem>
		</july:menuitem>
		<july:menuitem key="label.menu.posoutcome" stateId="-8">
			<july:menuitem key="label.menu.oppos.dismantlingp" action="ShowDemountList.do?navclear=1" stateId="<%=APPStates.DIPLIST%>">
				<july:menuselection stateId="<%=APPStates.DIPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITDIP%>"/>
				<july:menuselection stateId="<%=APPStates.EDITDIPST%>"/>
				<july:menuselection stateId="<%=APPStates.DIPPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITDIPP%>"/>
				<july:menuselection stateId="<%=APPStates.DISM_FFDB%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.other.dassactb" action="ShowDAssactBList.do?navclear=1" stateId="<%=APPStates.DASSBLIST%>">
				<july:menuselection stateId="<%=APPStates.DASSBLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITDASSB%>"/>
				<july:menuselection stateId="<%=APPStates.EDITDASSBST%>"/>
				<july:menuselection stateId="<%=APPStates.DASSBPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITDASSBP%>"/>
			</july:menuitem>
		</july:menuitem>
		<july:menuitem key="label.menu.oppos" stateId="-10">
			<july:menuitem key="label.menu.inventory.pos" action="ShowPositionInventoryList.do?navclear=1" stateId="<%=APPStates.INVLIST %>">
				<july:menuselection stateId="<%=APPStates.INVLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITINV%>"/>
				<july:menuselection stateId="<%=APPStates.EDITINVS%>"/>
				<july:menuselection stateId="<%=APPStates.INVPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITINVP%>"/>
				<july:menuselection stateId="<%=APPStates.INVLOADEXCEL%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.other.change" action="ShowChangePList.do?navclear=1" stateId="<%=APPStates.CHPLIST%>">
				<july:menuselection stateId="<%=APPStates.CHPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITCHP%>"/>
				<july:menuselection stateId="<%=APPStates.EDITCHPST%>"/>
				<july:menuselection stateId="<%=APPStates.CHPPLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITCHPP%>"/>
			</july:menuitem>

			<july:menuitem key="label.menu.inventory.contractor" action="ShowContractorInventoryList.do?navclear=1" stateId="<%=APPStates.CONTRLIST %>">
				<july:menuselection stateId="<%=APPStates.CONTRLIST %>"/>
				<july:menuselection stateId="<%=APPStates.EDITCONTR%>"/>
				<july:menuselection stateId="<%=APPStates.CONTRLOADXLS%>"/>
			</july:menuitem>

			<july:menuitem key="label.menu.oppos.fault" action="ShowFaultList.do?navclear=1" stateId="<%=APPStates.FLTLIST%>">
				<july:menuselection stateId="<%=APPStates.FLTLIST%>"/>
				<july:menuselection stateId="<%=APPStates.EDITFLT%>"/>
				<july:menuselection stateId="<%=APPStates.EDITFLTST%>"/>
			</july:menuitem>
		</july:menuitem>
<%
}
%>
		<july:menuitem key="label.menu.reports" stateId="-12">
			<july:menuitem key="label.menu.reports.1" action="Report1Params.do?navclear=1" stateId="<%=APPStates.RPT1PARAMS%>">
				<july:menuselection stateId="<%=APPStates.RPT1PARAMS%>"/>
				<july:menuselection stateId="<%=APPStates.RPT1%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.reports.2" action="Report2Params.do?navclear=1" stateId="<%=APPStates.RPT2PARAMS%>">
				<july:menuselection stateId="<%=APPStates.RPT2PARAMS%>"/>
				<july:menuselection stateId="<%=APPStates.RPT2%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.reports.3" action="Report3Params.do?navclear=1" stateId="<%=APPStates.RPT3PARAMS%>">
				<july:menuselection stateId="<%=APPStates.RPT3PARAMS%>"/>
				<july:menuselection stateId="<%=APPStates.RPT3%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.reports.4" action="Report4Params.do?navclear=1" stateId="<%=APPStates.RPT4PARAMS%>">
				<july:menuselection stateId="<%=APPStates.RPT4PARAMS%>"/>
				<july:menuselection stateId="<%=APPStates.RPT4%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.reports.5" action="Report5Params.do?navclear=1" stateId="<%=APPStates.RPT5PARAMS%>">
				<july:menuselection stateId="<%=APPStates.RPT5PARAMS%>"/>
				<july:menuselection stateId="<%=APPStates.RPT5%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.reports.6" action="Report6Params.do?navclear=1" stateId="<%=APPStates.RPT6PARAMS%>">
				<july:menuselection stateId="<%=APPStates.RPT6PARAMS%>"/>
				<july:menuselection stateId="<%=APPStates.RPT6%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.reports.7" action="Report7Params.do?navclear=1" stateId="<%=APPStates.RPT7PARAMS%>">
				<july:menuselection stateId="<%=APPStates.RPT7PARAMS%>"/>
				<july:menuselection stateId="<%=APPStates.RPT7%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.reports.8" action="Report8Params.do?navclear=1" stateId="<%=APPStates.RPT8PARAMS%>">
				<july:menuselection stateId="<%=APPStates.RPT8PARAMS%>"/>
				<july:menuselection stateId="<%=APPStates.RPT8%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.reports.9" action="Report9Params.do?navclear=1" stateId="<%=APPStates.RPT9PARAMS%>">
				<july:menuselection stateId="<%=APPStates.RPT9PARAMS%>"/>
				<july:menuselection stateId="<%=APPStates.RPT9%>"/>
			</july:menuitem>
			<july:menuitem key="label.menu.reports.91" action="Report91Params.do?navclear=1" stateId="<%=APPStates.RPT91PARAMS%>">
				<july:menuselection stateId="<%=APPStates.RPT91PARAMS%>"/>
				<july:menuselection stateId="<%=APPStates.RPT91%>"/>
			</july:menuitem>
		</july:menuitem>
<%
if(request.isUserInRole("administrator")) {
%>
		<july:menuitem key="label.menu.masscalc" action="MassCalcParams.do?navclear=1" stateId="<%=APPStates.MASSCALCPARAMS%>">
			<july:menuselection stateId="<%=APPStates.MASSCALCPARAMS%>"/>
			<july:menuselection stateId="<%=APPStates.MASSCALC%>"/>
		</july:menuitem>
		<july:menuitem key="label.menu.massdoc" action="MassdocParams.do?navclear=1" stateId="<%=APPStates.MASSDOCPARAMS%>">
			<july:menuselection stateId="<%=APPStates.MASSDOCPARAMS%>"/>
			<july:menuselection stateId="<%=APPStates.MASSDOC%>"/>
		</july:menuitem>
		<july:menuitem key="label.menu.other.other" stateId="-13">
			<july:menuitem key="label.menu.inventory.wrk" action="ShowWorkerInvActList.do?navclear=1" stateId="<%=APPStates.WRKINVLIST %>">
				<july:menuselection stateId="<%=APPStates.WRKINVLIST %>"/>
				<july:menuselection stateId="<%=APPStates.WRKINVFORM %>"/>
				<july:menuselection stateId="<%=APPStates.WRKINVPOS %>"/>
				<july:menuselection stateId="<%=APPStates.WRKINVFILLDB %>"/>
			</july:menuitem>
		</july:menuitem>
<%
}
%>
            <%
                if(com.hps.july.util.AppUtils.isMicrostrategyAccess(request.getRemoteUser())) {
                String url = URLUtil.getMicrostrategyURL(request);
            %>
            <july:menuitem key="label.menu.microstrategy.report" action='<%=url%>' stateId="-801" target="1" windowName="Microstrategy">
                <july:menuselection stateId="-801"/>
            </july:menuitem>
            <%
                }
            %>

<%
if(request.isUserInRole("administrator") || request.isUserInRole("siteTransport") ||
request.isUserInRole("siteStation") || request.isUserInRole("StorageManager")) {
     String urlMolkom = URLUtil.getMolkomURL(request);;
%>
    <july:menuitem key="label.menu.molkom" action='<%= urlMolkom %>' stateId="-802" target="1" windowName="Molkom">
        <july:menuselection stateId="-802"/>
    </july:menuitem>
<%
}
%>
	</july:menuitem>
</july:menu>
        </td>
    </tr>
</table>
