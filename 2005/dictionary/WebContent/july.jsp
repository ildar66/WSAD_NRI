<%@ page language = "java" %> 
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.dictionary.*" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%@include file="initProfile.jspf"%>

<html>
<head>
	<META HTTP-EQUIV = "Pragma" CONTENT="no-cache"> 
	<title>Основные справочники</title> 
	<link rel="stylesheet" type="text/css" href="/main.css">
</head>

<body id="abody" onload="document.body.style.cursor='auto';">
<script language="JavaScript">
	document.body.style.cursor="wait";
</script>

<july:licence licence="/comctl2.lpk"/>
	<%
	int app = ParamsParser.getApplication( pageContext );
	int state = ParamsParser.getState( pageContext );
	switch( app ) {
	  case Applications.DICTIONARY:
      switch( state )
        {
        case APPStates.NFSRES2NRIRES :
          %>
          <jsp:include page="/nfsres2nrires.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.NFS_RES_LOOKUP :
          %>
          <jsp:include page="/nfsresLookupForm.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.NRI_RES_LOOKUP :
          %>
          <jsp:include page="/nriResLookupForm.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.RTPLOOKUP :
          %>
          <jsp:include page="/restypeLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
//////////////////////////////////////////////
        case APPStates.PEOPLELOOKUP :
          %>
          <jsp:include page="/peopleLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
//////////////////////////////////////////////          
        case APPStates.RSTPLOOKUP :
          %>
          <jsp:include page="/ressbtypeLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.CRNCLOOKUP :
          %>
          <jsp:include page="/currencyLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.RATPLOOKUP :
          %>
          <jsp:include page="/ratetypeLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.UNITLOOKUP :
          %>
          <jsp:include page="/unitLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.RESLOOKUP :
          %>
          <jsp:include page="/resourceLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.COMPLOOKUP :
          %>
          <jsp:include page="/companyLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.BANKLOOKUP :
          %>
          <jsp:include page="/bankLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
		case APPStates.GRPLOOKUP :
          %>
          <jsp:include page="/groupLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
		case APPStates.GRPPLOOKUP :
          %>
          <jsp:include page="/grouppingLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
		case APPStates.ORGLOOKUP :
          %>
          <jsp:include page="/organizationLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
		case APPStates.MANUFLOOKUP :
          %>
          <jsp:include page="/equipmanufLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
		case APPStates.RESGROUPLOOKUP :
          %>
          <jsp:include page="/resgroupLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.DIRLOOKUP  :
          %>
          <jsp:include page="/directionLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.SERVLOOKUP :
          %>
          <jsp:include page="/serviceLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.DEPLOOKUP  :
          %>
          <jsp:include page="/departmentLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.DGRPLOOKUP  :
          %>
          <jsp:include page="/dgroupLookupList.jsp" flush="true"></jsp:include>
          <%
          break;

		case APPStates.INVRESOURCE_LIST_WN:
		%><jsp:include page="/invResourceListWN.jsp" flush="true"></jsp:include><%
		break;

		case APPStates.CHORTYPE_WN:
		%><jsp:include page="/choosertypeFormWN.jsp" flush="true"></jsp:include><%
		break;

		case APPStates.BASESTATION_RES_EDIT_WN:
		%><jsp:include page="/basestationFormWN.jsp" flush="true"></jsp:include><%
		break;

		case APPStates.ANTENA_RES_EDIT_WN:
		%><jsp:include page="/antenaFormWN.jsp" flush="true"></jsp:include><%
		break;

		case APPStates.REPEATER_RES_EDIT_WN:
		%><jsp:include page="/repeaterFormWN.jsp" flush="true"></jsp:include><%
		break;

		case APPStates.CABLE_RES_EDIT_WN:
		%><jsp:include page="/cableFormWN.jsp" flush="true"></jsp:include><%
		break;

		case APPStates.EDITRES_WN:
		%><jsp:include page="/resourceFormWN.jsp" flush="true"></jsp:include><%
		break;

		case APPStates.PERSON_DIALOG:
		%><jsp:include page="/personDialog.jsp" flush="true"></jsp:include><%
		break;

		case APPStates.PERSON_LOOKUP_LIST:
		%><jsp:include page="/personLookupList.jsp" flush="true"></jsp:include><%
		break;
		
		case APPStates.ORGANIZATION_DIALOG:
		%><jsp:include page="/organizationDialog.jsp" flush="true"></jsp:include><%
		break;		

		case APPStates.ACCOUNT_DIALOG:
		%><jsp:include page="/accountDialog.jsp" flush="true"></jsp:include><%
		break;
		
		case APPStates.REGION_DIALOG:
		%><jsp:include page="/regionDialog.jsp" flush="true"></jsp:include><%
		break;

		case APPStates.REGION_LOOKUP_LIST:
		%><jsp:include page="/regionLookupList.jsp" flush="true"></jsp:include><%
		break;
		
		case APPStates.BANKS_DIALOG:
		%><jsp:include page="/banksDialog.jsp" flush="true"></jsp:include><%
		break;

		case APPStates.BANKS_LOOKUP_LIST:
		%><jsp:include page="/banksLookupList.jsp" flush="true"></jsp:include><%
		break;
		
		case APPStates.VENDOR_DIALOG:
		%><jsp:include page="/vendorDialog.jsp" flush="true"></jsp:include><%
		break;

		case APPStates.VENDOR_LOOKUP_LIST:
		%><jsp:include page="/vendorLookupList.jsp" flush="true"></jsp:include><%
		break;
		
		case APPStates.VENDOR_SITE_DIALOG:
		%><jsp:include page="/vendorSiteDialog.jsp" flush="true"></jsp:include><%
		break;

		case APPStates.VENDOR_SITE_LOOKUP_LIST:
		%><jsp:include page="/vendorSiteLookupList.jsp" flush="true"></jsp:include><%
		break;
		
		case APPStates.ACCOUNTS_DIALOG:
		%><jsp:include page="/accountsDialog.jsp" flush="true"></jsp:include><%
		break;

		case APPStates.ACCOUNTS_LOOKUP_LIST:
		%><jsp:include page="/accountsLookupList.jsp" flush="true"></jsp:include><%
		break;
		
		case APPStates.VENDOR_ADMIN_DIALOG:
		%><jsp:include page="/vendorAdminDialog.jsp" flush="true"></jsp:include><%
		break;
		
		case APPStates.VENDOR_SITE_ADMIN_DIALOG:
		%><jsp:include page="/vendorSiteAdminDialog.jsp" flush="true"></jsp:include><%
		break;														
		
		case APPStates.CONF_POWER_SOURCES_CUR_COMPLECT_LIST:
		%><jsp:include page="/curCmplPwSrc.jsp" flush="true"></jsp:include><%
		break;		

		case APPStates.CONF_POWER_SOURCES_STRUCT_CUR_COMPLECT_LIST:
		%><jsp:include page="/strucPwSrc.jsp" flush="true"></jsp:include><%
		break;		

		case APPStates.CONF_POWER_SOURCES_FORM:
		%><jsp:include page="/cmplPwSrcForm.jsp" flush="true"></jsp:include><%
		break;		
		 
		case APPStates.EDIT_POWER_RESOURCE_FORM:
		%><jsp:include page="/powerResourceForm.jsp" flush="true"></jsp:include><%
		break;		
		 
		case APPStates.BASE_STATION_CONF_FORM:
		%><jsp:include page="/baseStationComplectForm.jsp" flush="true"></jsp:include><%
		break;		
		
		case APPStates.CONF_CONNECTOR_CABLE_COMPAT_LIST_REFRESH:
		%><jsp:include page="/compatibilityList.jsp" flush="true"></jsp:include><%
		break;		
		
        default:
          %>
          <jsp:include page="/dictionaryGraph.jsp" flush="true"></jsp:include>
          <%
          break;
        }
		  break;
		default:
			%>
			<jsp:include page="/error.jsp" flush="true"></jsp:include>
			<%
			break;
		}
	%>
</body>
</html>
