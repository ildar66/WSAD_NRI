<%@ page import="com.hps.july.web.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
<HEAD>
<%@ page 
language="java" 
contentType="text/html; charset=CP1251"
%>
<META http-equiv="Content-Type" content="text/html; charset=CP1251">
<TITLE>Меню</TITLE>
<link rel="stylesheet" type="text/css" href="/navtree.css">
</HEAD>

<BODY>
<%
	//роли:
	boolean isAdministrator = request.isUserInRole("administrator");
	boolean isArendaDirector =request.isUserInRole("ArendaDirector");
	boolean isArendaMainManager = request.isUserInRole("ArendaMainManager");
	boolean isArendaManager = request.isUserInRole("ArendaManager");
	boolean isArendaMainEconomist = request.isUserInRole("ArendaMainEconomist");
	boolean isArendaEconomist = request.isUserInRole("ArendaEconomist");
	boolean isViewerPays = request.isUserInRole("viewerPays");
	boolean isDictStaffOperator = request.isUserInRole("dictStaffOperator");
	boolean isAdminTerrabyte = request.isUserInRole("adminTerrabyte");
	boolean isDictResAdmin = request.isUserInRole("dictResAdmin");
	boolean isDictResOperator = request.isUserInRole("dictResOperator");
	boolean isDictPartAdmin = request.isUserInRole("dictPartAdmin");
	boolean isDictPartOperator = request.isUserInRole("dictPartOperator");
	boolean isDictCurrateOperator = request.isUserInRole("dictCurrateOperator");
	boolean isSiteProjector = request.isUserInRole("siteProjector");
	boolean isSiteExploitor = request.isUserInRole("siteExploitor");
	boolean isSiteTransport = request.isUserInRole("siteTransport");
	boolean isSiteStation = request.isUserInRole("siteStation");
	boolean isSiteLook = request.isUserInRole("siteLook");
	boolean isElectroCounterViewer = request.isUserInRole("electroCounterViewer");
	boolean isElectroCounterEditor = request.isUserInRole("electroCounterEditor");
	boolean isFreqManager = request.isUserInRole("FreqManager");
	boolean isRegionAdmin = request.isUserInRole("regionAdmin");
	boolean isSupregAdmin = request.isUserInRole("supregAdmin");
	boolean isDeveloper = request.isUserInRole("developer");
	boolean isTSProjectUser = request.isUserInRole("TSProjectUser");
	boolean isTSProjectAdmin = request.isUserInRole("TSProjectAdmin");
	//boolean isContractControler = request.isUserInRole("contractControler");
	//boolean isContractComposer = request.isUserInRole("contractComposer");
	boolean isTechStuff = request.isUserInRole("TechStuff");
	boolean isStorageManager = request.isUserInRole("StorageManager");
	boolean isPlanLook = request.isUserInRole("planLook");
	boolean isRegionCurator = request.isUserInRole("RegionCurator");
	boolean isPlanResponsible = request.isUserInRole("planResponsible");
	boolean isBscUser = request.isUserInRole("bscuser");
	boolean isArendaPurchaser = request.isUserInRole("ArendaPurchaser");
	boolean isArendaAccountant = request.isUserInRole("ArendaAccountant");
	//подгруппы:
	boolean isLcsGroup = request.isUserInRole("lcsEditAllLicence") || request.isUserInRole("lcsEditFAS") || request.isUserInRole("lcsEditGPS") || request.isUserInRole("lcsEditGASN") || request.isUserInRole("lcsEditSES") || request.isUserInRole("lcsEditElectro") || request.isUserInRole("lcsEditLand") || request.isUserInRole("lcsEditProperty");
	boolean isVisibleResources = isAdministrator || isArendaMainEconomist || isArendaEconomist || isArendaDirector || isDeveloper;
	//группы:
	boolean isSecurityGroup =  isAdministrator || isDictStaffOperator || isAdminTerrabyte || isDeveloper ;//1
	boolean isDictGroup =  isAdministrator || isDictResAdmin || isDictResOperator  || isDictPartAdmin || isDictCurrateOperator || isDictPartOperator || isArendaMainManager || isDeveloper; //2
	boolean isSiteinfoGroup =  isAdministrator || isSiteProjector || isSiteExploitor || isSiteTransport || isSiteStation || isArendaManager || isSiteLook || isArendaEconomist || isArendaMainEconomist || isArendaMainManager || isArendaDirector || isElectroCounterViewer || isElectroCounterEditor || isFreqManager || isRegionAdmin || isSupregAdmin || isLcsGroup || isDeveloper; //3
	//boolean isContractGroup =  isAdministrator || isContractControler || isContractComposer; //4
	boolean isInventoryGroup =  isAdministrator || isTechStuff || isStorageManager || isSiteTransport || isSiteStation || isSiteExploitor || isDeveloper; //5
	boolean isArendaGroup =  isAdministrator || isArendaMainEconomist || isArendaEconomist || isArendaDirector || isArendaMainManager || isArendaManager || isViewerPays || isLcsGroup || isDeveloper || isArendaPurchaser || isArendaAccountant;//6
	//boolean isBugsGroup =  isAdministrator || //7
	//boolean isProjectGroup =  isAdministrator || isPlanLook ;//8
	//boolean isPlatinumGroup =  isAdministrator || //9
	boolean isBasestationGroup =  isAdministrator || isSupregAdmin || isRegionAdmin || isSiteExploitor || isSiteStation || isSiteProjector || isRegionCurator || isSiteTransport || isFreqManager || isDeveloper;//10
	boolean isPlanGraphicGroup =  isAdministrator || isPlanResponsible || isTSProjectUser || isTSProjectAdmin || isDeveloper;//11
	//boolean isGroup =  isAdministrator || //12
	boolean isSitedocGroup =  isAdministrator || isTechStuff || isSiteTransport || isDeveloper;//13
	boolean isTr1Group =  isAdministrator || request.isUserInRole("ChannelTSUser") || request.isUserInRole("ChannelTSAdmin") || isDeveloper;//14
	boolean isBasestationGsmGroup =  isAdministrator || isSiteStation || isDeveloper;//15
	boolean isBSGroup =  isAdministrator || request.isUserInRole("BSProjectUser") || request.isUserInRole("BSProjectManager") || request.isUserInRole("BSProjectAdmin") || isDeveloper;//16
	boolean isSmssPermitGroup =  isAdministrator || request.isUserInRole("smssPermitEdit") || request.isUserInRole("smssPermitView") || isDeveloper;//17
	boolean isRolloutGroup = isAdministrator || request.isUserInRole("RolloutBSAdmin") || request.isUserInRole("RolloutBSUser") || isDeveloper;
	
	//RTS //13
	boolean isRTSViewer = isAdministrator || isDeveloper || request.isUserInRole("rtsViewer");
	
	//разрешения на комплекты:
	boolean isPermitGroup = isAdministrator || isDeveloper;
	boolean isRCHSGroup = isAdministrator || isDeveloper || isSiteLook;
	//Комплекты оборудования:
	boolean isEquipmentGroupGSM_DAMPS = isAdministrator || isDeveloper || request.isUserInRole("EquipmentLook") || request.isUserInRole("MSCEqpEdit") || request.isUserInRole("BSCEqpEdit") || request.isUserInRole("RepiterEqpEdit") || request.isUserInRole("ServiceEqpEdit") || isSiteStation; 
	
	// Проекты
	boolean isBscGroup = isAdministrator || isDeveloper || isBscUser;
	
	// Конфигурации
	boolean isConfigGroup = isAdministrator || isDeveloper || request.isUserInRole("confResOperator") || request.isUserInRole("confResAdmin");
	
	//Константы: 
	String pathDevPlan = com.hps.july.util.AppUtils.getNamedValueString("PathDevPlan");
	String trailcomUrl = com.hps.july.util.AppUtils.getNamedValueString("PathPositionTableTrailcom") + "?id=" + request.getRemoteUser();
	String trailcomMapUrl = com.hps.july.util.AppUtils.getNamedValueString("PathMapTrailcom") + "?id=" + request.getRemoteUser();
	String planGraphicWebUrl = com.hps.july.util.AppUtils.getNamedValueString("PlanGraphicWeb") + "?id=" + request.getRemoteUser();
	String arendaChanelPath = com.hps.july.util.AppUtils.getNamedValueString("ArendaChanel") + "?id=" + request.getRemoteUser();
	String pathHopsTableTrailcom = com.hps.july.util.AppUtils.getNamedValueString("PathHopsTableTrailcom") + "?id=" + request.getRemoteUser();
	String pathComplectPermitsTrailcom = com.hps.july.util.AppUtils.getNamedValueString("TRAILCOM_COMPLECT_PERMITS_URL") + "?id=" + request.getRemoteUser();
	String pathEquipmentListTrailcom = com.hps.july.util.AppUtils.getNamedValueString("PathEquipmentListTrailcom") + "?id=" + request.getRemoteUser();//комплекты оборудования
	String planGraphicWebBS = com.hps.july.util.AppUtils.getNamedValueString("PlanGraphicWebBS") + "?id=" + request.getRemoteUser();// проекты строительства БС
	String pathRolloutTrailcom = com.hps.july.util.AppUtils.getNamedValueString("PathRolloutTrailcom") + "?id=" + request.getRemoteUser();// План развития БС
	String pathDisplaySectorsTrailcom = com.hps.july.util.AppUtils.getNamedValueString("PathDisplaySectorsTrailcom") + "?id=" + request.getRemoteUser();// Список секторов БС GSM
	String bscprojectsUrl = com.hps.july.util.AppUtils.getNamedValueString("BSC_PROJECTS_URL");
	String rchspermitsUrl = com.hps.july.util.AppUtils.getNamedValueString("PathRchsPermitsTrailcom") + "?id=" + request.getRemoteUser();
	//инфо из профайла:
	Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
	String terrabyteUrl = "http://" + profile.getSystemTerrabyteHost() + ":" + profile.getSystemTerrabytePort() + "/terrabyte/index.jsp";
	String pathTNDocTerrabyteUrl = terrabyteUrl + "?uid=" + request.getRemoteUser() + "&type=tnd&id=1";
	
	
	
%>
<%--@ include file = "navtree_js.jsp" --%>
<script type="text/javascript" language="JavaScript" src="/scripts/aptree.js"></script>
<script type="text/javascript" language="JavaScript" src="/scripts/aptreeState.js"></script>
<script type="text/javascript" language="JavaScript1.2">
	setShowExpanders(true);
	setExpandDepth(1);
	setKeepState(true);
	setShowHealth(false);
	setInTable(false);
	//setTargetFrame("_top");
	openFolder = "/images/open_folder.gif";
	closedFolder = "/images/closed_folder.gif";
	plusIcon = "/images/lplus.gif";
	minusIcon = "/images/lminus.gif";
	blankIcon = "/images/blank20.gif";
	//function:
	function openWind(url, urlOld, itemMenuSel)	{
		//alert("itemMenuSel="+itemMenuSel.id);
		var itemMenuID = itemMenuSel.id;
		Sel(itemMenuID);
		var innerHTMLvar = document.all["Item"+itemMenuID].innerHTML;
		document.all["Item"+itemMenuID].innerHTML = "<B style='color:red'>"+innerHTMLvar +"</B>";
		var wnd = window.open(url +'&path='+urlOld, 'trailcom', 
		'top=0, left=0, height=' + (screen.availHeight-30) + ', width=' + (screen.availWidth-10) + ', fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=yes,titlebar=yes,toolbar=no');
		//закрытие дочерних окон:
		dialogArrayExit[dialogArrayExit.length]=wnd;
		//alert("dialogArrayExit.length="+dialogArrayExit.length);
		wnd.focus();
	}
	function openWind(url, urlOld, itemMenuSel, windowName)	{
		//alert("itemMenuSel="+itemMenuSel.id);
		var itemMenuID = itemMenuSel.id;
		Sel(itemMenuID);
		var innerHTMLvar = document.all["Item"+itemMenuID].innerHTML;
		document.all["Item"+itemMenuID].innerHTML = "<B style='color:red'>"+innerHTMLvar +"</B>";
		var wnd = window.open(url +'&path='+urlOld, windowName , 
		'top=0, left=0, height=' + (screen.availHeight-30) + ', width=' + (screen.availWidth-10) + ', fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=yes,titlebar=yes,toolbar=no');
		//закрытие дочерних окон:
		dialogArrayExit[dialogArrayExit.length]=wnd;
		//alert("dialogArrayExit.length="+dialogArrayExit.length);
		wnd.focus();
	}	
	function loadSelectedMenuItem() {
		var itemMenu = <%=request.getParameter("itemMenu")%>;
		if(!itemMenu) {
			<% if (profile != null) { %>
				itemMenu = <%=profile.getSystemMenuItem() %>;
			<% } %>
		}
		if(itemMenu){
			//document.all["Item"+itemMenu.id].style.backgroundColor = "red";//background-color: #CCCCCC 
			var innerHTMLvar = document.all["Item"+itemMenu.id].innerHTML;
			document.all["Item"+itemMenu.id].innerHTML = "<B>"+innerHTMLvar +"</B>";
			/*document.all["Item"+itemMenu.id].innerText = document.all["Item"+itemMenu.id].innerText;
			document.all["Item"+itemMenu.id].style.color = "red";*/
			//alert("color="+document.all["Item"+itemMenu.id].style.color);
			//alert(itemMenu.content);
			Sel(itemMenu.id);
			document.cookie = "itemMenuID=" + itemMenu.id;
		} else{
			var cookies = document.cookie;
			//считываем itemMenuID:
			var startLoc = cookies.indexOf("itemMenuID=");
			if(startLoc == -1){
				expandCompressNode(item1.id);
			    return;
			  }
			var sepLoc = cookies.indexOf("=", startLoc);
			var endLoc = cookies.indexOf(";", startLoc);
			if(endLoc == -1) {
				endLoc = cookies.length;
			}
			var itemMenuID = cookies.substring(sepLoc+1, endLoc);
			Sel(itemMenuID);
			var innerHTMLvar = document.all["Item"+itemMenuID].innerHTML;
			document.all["Item"+itemMenuID].innerHTML = "<B style='color:red'>"+innerHTMLvar +"</B>";
		}
	}
</script>

<DIV class="navtree">
<script type="text/javascript" language="JavaScript1.2">
	<%
		//Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
		com.hps.july.valueobject.RegionsAccess_TO curReg = profile.getProfileAccess().getCurrRegion();	
	%>
	root_domain = addRoot('', 'Основное меню:','');
	item1 = addItem(root_domain, "", "Задачи:", '');
	
	//SecurityGroup(Система разграничения доступа):
	<% if (isSecurityGroup) { %>
	item1_1 = addItem(item1, '', 'Система разграничения доступа', '');
	<%	 if (isAdministrator) { %>
	item1_1_1 = addItem(item1_1, '', 'Физические лица', '/security/ShowPeopleList.do?navclear=1&itemMenu=item1_1_1');
	item1_1_2 = addItem(item1_1, '', 'Должности', '/security/ShowWorkPositionList.do?navclear=1&itemMenu=item1_1_2');
	<%	 } %>
	<%	 if (isAdministrator  ||  isDictStaffOperator) { %>
	item1_1_3 = addItem(item1_1, '', 'Компании', '/security/ShowCompanyList.do?navclear=1&itemMenu=item1_1_3');
	<%	 } %>
	<%	 if (isAdministrator  ||  isAdminTerrabyte) {
		String urlTP = com.hps.july.util.AppUtils.getNamedValueString("TERRABYTE_PERMISSION_URL");
	%>
		item1_1_4 = addItem(item1_1, '', 'Пользователи MS', '/security/ShowMSUsersList.do?navclear=1&itemMenu=item1_1_4');
<%--
	item1_1_5 = addItem(item1_1, '', 'Отчет по операторам системы', '/security/ReportOperators.do?navclear=1&itemMenu=item1_1_5');
--%>
		item1_1_6 = addItem(item1_1, '', 'Разграничение доступа к типам документов', '<%=urlTP%>');
		item1_1_6.targetFrame="_blank";
	<%	 if (isAdministrator) { %>
			item1_1_7 = addItem(item1_1, '', 'Оповещение пользователей', '/security/MailMessageNri.do?navclear=1&action=Edit&itemMenu=item1_1_7');
			item1_1_8 = addItem(item1_1, '', 'Запросы пользователей', '/dict/ShowUserRequestList.do?navclear=1&action=Edit&itemMenu=item1_1_8');
	<%	 } %>		
	<%	} %>
	<%	 if (isAdministrator) { %>
			item1_1_7 = addItem(item1_1, '', 'Роли', '/security/RoleList.do?navclear=1&itemMenu=item1_1_7');
	<%	 } %>	
	<%} %>
	
	//DictGroup(Осн. справочники системы):
	<% if (isDictGroup || isConfigGroup) { %>
	item1_2 = addItem(item1, '', 'Осн. справочники системы', '');
	<% } %>
	<% if (isDictGroup) { %>
	itemResourcesCommonList = addItem(item1_2, '', 'Справочник ресурсов', '/dict/ShowResourcesCommonList.do?navclear=1&itemMenu=itemResourcesCommonList');
	item1_2_1 = addItem(item1_2, '', 'Виды и типы ресурсов', '/dict/ShowRestypeList.do?navclear=1&itemMenu=item1_2_1');
	item1_2_2 = addItem(item1_2, '', 'Ресурсы', '');
	item1_2_2_1 = addItem(item1_2_2, '', 'Базовые станции', '/dict/ShowBasestationList.do?navclear=1&itemMenu=item1_2_2_1');
	item1_2_2_2 = addItem(item1_2_2, '', 'Антенны базовых станций', '/dict/ShowAntenaList.do?navclear=1&itemMenu=item1_2_2_2');
	item1_2_2_3 = addItem(item1_2_2, '', 'Комплекты оборудования РРЛС', '/dict/ShowRRLResourceList.do?navclear=1&itemMenu=item1_2_2_3');
	item1_2_2_4 = addItem(item1_2_2, '', 'Репитерные станции', '/dict/ShowRepeaterList.do?navclear=1&itemMenu=item1_2_2_4 ');
	item1_2_2_9 = addItem(item1_2_2, '', 'Донорные блоки репитеров', '/dict/ShowDonorUnitList.do?navclear=1&itemMenu=item1_2_2_9 ');
	item1_2_2_10 = addItem(item1_2_2, '', 'Трансиверы', '/dict/ShowTranceiverList.do?navclear=1&itemMenu=item1_2_2_10 ');
	item1_2_2_5 = addItem(item1_2_2, '', 'Кабели базовых станций', '/dict/ShowCableList.do?navclear=1&itemMenu=item1_2_2_5');
	item1_2_2_6 = addItem(item1_2_2, '', 'Все ресурсы', '/dict/ShowResourceList.do?navclear=1&itemMenu=item1_2_2_6');
	item1_2_2_7 = addItem(item1_2_2, '', 'Наборы', '/dict/ShowComplectList.do?navclear=1&itemMenu=item1_2_2_7');
	item1_2_2_8 = addItem(item1_2_2, '', 'Ресурсы по категориям ввода', '/dict/ShowInvResourceList.do?navclear=1&itemMenu=item1_2_2_8');
	<% } %>
	// не по порядку
	<% if (isConfigGroup) { %>
	item1_2_15 = addItem(item1_2, '', 'Управление конфигурацией', '');
	item1_2_15_1 = addItem(item1_2_15, '', 'Конфигурация БС GSM/DCS', '/dict/ShowConfBaseStation.do?navclear=1&itemMenu=item1_2_15_1');
	item1_2_15_6 = addItem(item1_2_15, '', 'Инсталляц-е комплекты БС', '/dict/ShowInstComplBaseStation.do?navclear=1&itemMenu=item1_2_15_6');
	item1_2_15_2 = addItem(item1_2_15, '', 'Конфигурация ИП', '/dict/ShowConfPowerSourcesElAp.do?navclear=1&itemMenu=item1_2_15_2');
	item1_2_15_3 = addItem(item1_2_15, '', 'Конфигурация ИП УЗО', '/dict/ShowConfPowerSourcesUzo.do?navclear=1&itemMenu=item1_2_15_3');
	item1_2_15_4 = addItem(item1_2_15, '', 'Разъемы, кабели', '/dict/ShowConfConnectorCableCompat.do?navclear=1&itemMenu=item1_2_15_4');
	item1_2_15_5 = addItem(item1_2_15, '', 'Аксессуары к антеннам', '');
	item1_2_15_5_1 = addItem(item1_2_15_5, '', 'Группы аксессуаров', '/dict/ShowResourceGroupList.do?navclear=1&itemMenu=item1_2_15_5_1');
	item1_2_15_5_2 = addItem(item1_2_15_5, '', 'Антенны БС', '/dict/ShowResAntennaList.do?navclear=1&itemMenu=item1_2_15_5_2');
	// 1_2_15_6 размещен выше
	<% } %>
	//
	<% if (isDictGroup) { %>
	item1_2_3 = addItem(item1_2, '', 'Единицы измерения', '/dict/ShowUnitList.do?navclear=1&itemMenu=item1_2_3');
	item1_2_4 = addItem(item1_2, '', 'Налоги', '/dict/ShowTaxList.do?navclear=1&itemMenu=item1_2_4');
	item1_2_5 = addItem(item1_2, '', 'Валюты', '/dict/ShowCurrencyList.do?navclear=1&itemMenu=item1_2_5');
	item1_2_6 = addItem(item1_2, '', 'Типы курсов валют', '/dict/ShowRatetypeList.do?navclear=1&itemMenu=item1_2_6');
	<% if (isAdministrator) { %>
	item1_2_7 = addItem(item1_2, '', 'Системные константы', '/dict/ShowSysconstList.do?navclear=1&itemMenu=item1_2_7');
	<% } %>
	item1_2_9 = addItem(item1_2, '', 'Компании', '/dict/ShowCompanyList.do?navclear=1&itemMenu=item1_2_9');
	<% if (isAdministrator || isDeveloper || request.isUserInRole("editBank") ) { %>
	<% if ( isAdministrator || isDeveloper) { %>
	item1_2_10 = addItem(item1_2, '', 'Организации', '');
	item1_2_10_1 = addItem(item1_2_10, '', 'Юридические', '/dict/ShowOrganizationListM.do?navclear=1&itemMenu=item1_2_10_1');
	item1_2_10_2 = addItem(item1_2_10, '', 'Физические', '/dict/ShowPersonList.do?rootapp=7&navclear=1&itemMenu=item1_2_10_2');
	item1_2_10_3 = addItem(item1_2_10, '', 'Поставщики', '/dict/VendorAdminList.do?navclear=1&itemMenu=item1_2_10_3');	
	item1_2_10_4 = addItem(item1_2_10, '', 'Классификация юр. лиц', '/dict/ShowGroupList.do?navclear=1&itemMenu=item1_2_10_4');
	<% } %>	
	item1_2_10_5 = addItem(item1_2_10, '', 'Банки', '/dict/BanksList.do?navclear=1&itemMenu=item1_2_10_5');	
	<% } %>
	item1_2_12 = addItem(item1_2, '', 'Склады', '/dict/ShowStorageList.do?navclear=1&itemMenu=item1_2_12');
	// 1_2_15 см. выше 
	<%}%>
	
	//SiteinfoGroup(Описание позиций):
	<% if (isSiteinfoGroup) { %>
	item1_3 = addItem(item1, '', 'Описание позиций', '');
	<%-- if(isDeveloper) { %>
	item1_3_0 = addItem(item1_3, '', 'Позиции(old)', '/siteinfo/ShowPositionList.do?navclear=1&itemMenu=item1_3_0');
	<%}--%>
	item1_3_1 = addItem(item1_3, '', 'Позиции', 'javascript:openWind(\'<%=trailcomUrl %>\', \'returnUrl\', item1_3_1, \'windowN1\');');
	item1_3_2 = addItem(item1_3, '', 'Работа с картой',  'javascript:openWind(\'<%= trailcomMapUrl%>\', \'returnUrl\', item1_3_2, \'windowN2\');');
	item1_3_0 = addItem(item1_3, '', 'Справочники', '');
	<% if(isAdministrator) { %>
	item1_3_3 = addItem(item1_3_0, '', 'Регионы', '/siteinfo/ShowSuperRegionList.do?navclear=1&itemMenu=item1_3_3');
	item1_3_4 = addItem(item1_3_0, '', 'Филиалы', '/siteinfo/ShowRegionList.do?navclear=1&itemMenu=item1_3_4');
	item1_3_13 = addItem(item1_3_0, '', 'Административно-территориальное деление', '/dict/RegionList.do?navclear=1&itemMenu=item1_3_13');
	item1_3_5 = addItem(item1_3_0, '', 'Зоны сети', '/siteinfo/ShowNetzoneList.do?navclear=1&itemMenu=item1_3_5');	
	item1_3_6 = addItem(item1_3_0, '', 'Типы ответственности', '/siteinfo/ShowTyperesponsibilityList.do?navclear=1&itemMenu=item1_3_6');	
	<%}%>
	<% if(isAdministrator || isSiteProjector) { %>
	item1_3_7 = addItem(item1_3_0, '', 'Места размещения антенн', '/siteinfo/ShowAntennaPlacesList.do?navclear=1&itemMenu=item1_3_7');
	item1_3_8 = addItem(item1_3_0, '', 'Места размещения опор', '/siteinfo/ShowOporaPlacesList.do?navclear=1&itemMenu=item1_3_8');
	item1_3_9 = addItem(item1_3_0, '', 'Типы помещений аппаратной', '/siteinfo/ShowApparatPlaceTypesList.do?navclear=1&itemMenu=item1_3_9');
	item1_3_10 = addItem(item1_3_0, '', 'Типы аппаратной', '/siteinfo/ShowApparatTypesList.do?navclear=1&itemMenu=item1_3_10');
	item1_3_11 = addItem(item1_3_0, '', 'Места размещения аппаратной', '/siteinfo/ShowApparatPlacesList.do?navclear=1&itemMenu=item1_3_11');
	<%}%>
	<% if(isAdministrator || isElectroCounterViewer || isElectroCounterEditor) { %>
	item1_3_12 = addItem(item1_3, '', 'Электросчетчики', '');
	item1_3_12_1 = addItem(item1_3_12, '', 'Типы электросчетчиков', '/siteinfo/ShowElectroCounterInfoList.do?navclear=1&itemMenu=item1_3_12_1');
	item1_3_12_2 = addItem(item1_3_12, '', 'Места размещения электросчетчиков', '/siteinfo/ShowElectroCounterList.do?navclear=1&itemMenu=item1_3_12_2');
	<%}%>
	<%} %>
	
	//Сеть GSM/DAMPS:
	<% if (isBasestationGroup || isTr1Group || isSiteProjector || isBSGroup || isEquipmentGroupGSM_DAMPS || isRolloutGroup || isBscUser) { %>
	item1_8 = addItem(item1, '', 'Сеть GSM/DAMPS', '');
	<% if (isBSGroup) { %>
	item1_8_2 = addItem(item1_8, '', 'Проекты строительства БС GSM', '<%= planGraphicWebBS  + "&itemMenu=item1_8_2"%>');
	<% } %>
	<% if (isBasestationGsmGroup) { %>
	item1_8_3 = addItem(item1_8, "", "Эксплуатация оборудования GSM",  "/basestation/ShowBaseStationGSM.do?navclear=1&itemMenu=item1_8_3");
	<% } %>		
	<% if (isEquipmentGroupGSM_DAMPS) { %>
	item1_8_5 = addItem(item1_8, '', 'Комплекты оборудования GSM/DAMPS', 'javascript:openWind(\'<%= pathEquipmentListTrailcom + "&itemMenu=item1_8_5"%>\', \'returnUrl\', item1_8_5, \'windowN7\');');
	<% } %>
	<%-- if (isBasestationGroup) {%>
	item1_8_1 = addItem(item1_8, "", "Базовые станции GSM/DAMPS", '/basestation/ShowBaseStationList.do?navclear=1&itemMenu=item1_8_1');
	item1_8_4 = addItem(item1_8, "", "Репитеры GSM", '/basestation/ShowRepeaterList.do?navclear=1&itemMenu=item1_8_4');
	<% } --%>
	
	<%if(isAdministrator  || isDeveloper || request.isUserInRole("esnbsEditor") || request.isUserInRole("esnbsViewer")) {
		String cidnesUrl = com.hps.july.util.AppUtils.getNamedValueString("CIDNES_URL") + "?uid=" + request.getRemoteUser();
	%>
	item1_8_6 = addItem(item1_8, '', 'Единая система нумерации БС GSM', 'javascript:openWind(\'<%=cidnesUrl%>\', \'returnUrl\', item1_8_6, \'windowN3\');');
	<% } %>	
	<%if(isAdministrator || isSiteProjector ){%>
	item1_8_9 = addItem(item1_8, "", "Экспорт АФУ БС GSM для систем Hexagon и Forte", '/basestation/ExportFile.do?navclear=1&itemMenu=item1_8_9');
	<%}%>
	<%-- if( isRolloutGroup ){%>
	item1_8_10 = addItem(item1_8, "", "План развития сети", 'javascript:openWind(\'<%= pathRolloutTrailcom  + "&itemMenu=item1_8_10"%>\', \'returnUrl\', item1_8_10, \'windowN10\');');
	<%}  --%>
	<% if (isEquipmentGroupGSM_DAMPS) { %>
	item1_8_11 = addItem(item1_8, "", "Список секторов БС GSM", 'javascript:openWind(\'<%= pathDisplaySectorsTrailcom  + "&itemMenu=item1_8_11"%>\', \'returnUrl\', item1_8_11, \'windowN11\');');	
	<%}%>
	<% if (isBscGroup) { %>
	item1_8_12 = addItem(item1_8, "", "Проекты BSC", "<%= bscprojectsUrl %>");	
	<%}%>
	<% if (isAdministrator || isDeveloper || isBscUser) { %>
	item1_8_13 = addItem(item1_8, '', 'План развития', 'javascript:openWind(\'<%= pathDevPlan + "?itemMenu=item1_8_13"%>\', \'returnUrl\', item1_8_13, \'windowN15\');');
	<% } %>
	<% } %>	
	
	//Транспортная сеть:
	<% if (isBasestationGroup || isPlanGraphicGroup || isTr1Group || isRTSViewer) { %>
	item1_17 = addItem(item1, '', 'Транспортная сеть', '');
		<% if (isBasestationGroup) { %>
		item1_17_2 = addItem(item1_17, "", "Линии связи", 'javascript:openWind(\'<%=pathHopsTableTrailcom%>\', \'returnUrl\', item1_17_2, \'windowN4\');');		
			<% if (isDeveloper) { %>
		item1_17_1 = addItem(item1_17, "", "Линии связи(old)", '/basestation/ShowComlineList.do?navclear=1&itemMenu=item1_17_1');
			<% } %>
		<% } %>
		<% if (isPlanGraphicGroup) { %>
		item1_17_3 = addItem(item1_17, '', 'План-график строительства ТС', '<%= planGraphicWebUrl + "&itemMenu=item1_17_3"%>');
		<% } %>
		<% if (isTr1Group) { %>
		item1_17_4 = addItem(item1_17, '', 'Арендованные ресурсы', 'javascript:openWind(\'<%=arendaChanelPath%>\', \'returnUrl\', item1_17_4, \'windowN5\');');
		<% } %>
		<% if (isRTSViewer) { %>
		item1_17_5 = addItem(item1_17, '', 'Заявки на ТС', '');
            <%
                RTSMenu menu = new RTSMenu();
                out.println(menu.createRTSMenu(request, request.getRemoteUser()));
            %>
		<% } %>				
		<% if (isBasestationGroup || isPlanGraphicGroup) { %>
			item1_17_6 = addItem(item1_17, "", "Документы Транспортной сети", 'javascript:openWind(\'<%=pathTNDocTerrabyteUrl%>\', \'returnUrl\', item1_17_2, \'windowN1_17_6\');');
		<% } %>
	<% } %>
	
	//IventoryGroup(Учет оборудования):
	<% if (isInventoryGroup) { %>
	item1_5 = addItem(item1, '', 'Учет оборудования', '');
	<%	 if(isAdministrator || isStorageManager) {%>
	item1_5_1 = addItem(item1_5, '', 'Приход на склад', '');
		item1_5_1_1 = addItem(item1_5_1, '', 'Внутренние ордера', '/inventory/ShowInternalList.do?navclear=1&itemMenu=item1_5_1_1');
		item1_5_1_2 = addItem(item1_5_1, '', 'Внешние ордера', '/inventory/ShowExternalList.do?navclear=1&itemMenu=item1_5_1_2');
		item1_5_1_3 = addItem(item1_5_1, '', 'Акты рассогласования', '/inventory/ShowMismatchList.do?navclear=1&itemMenu=item1_5_1_3');
	item1_5_2 = addItem(item1_5, '', 'Расход со склада', '');
		item1_5_2_1 = addItem(item1_5_2, '', 'Внутренние накладные', '/inventory/ShowInternalRList.do?navclear=1&itemMenu=item1_5_2_1');
		item1_5_2_2 = addItem(item1_5_2, '', 'Внешние накладные', '/inventory/ShowExternalRList.do?navclear=1&itemMenu=item1_5_2_2');

	item1_5_3 = addItem(item1_5, '', 'Прочие операции на складе', '');
		item1_5_3_1 = addItem(item1_5_3, '', 'Инвентаризация на складе', '/inventory/ShowInvActList.do?navclear=1&itemMenu=item1_5_3_1');
		item1_5_3_2 = addItem(item1_5_3, '', 'Акты замены/модернизации', '/inventory/ShowChangeSList.do?navclear=1&itemMenu=item1_5_3_2');
		item1_5_3_3 = addItem(item1_5_3, '', 'Акты замены при ремонте', '/inventory/ShowChangeEList.do?navclear=1&itemMenu=item1_5_3_3');
		item1_5_3_4 = addItem(item1_5_3, '', 'Акты монтажа блоков', '/inventory/ShowAssactList.do?navclear=1&itemMenu=item1_5_3_4');
		item1_5_3_5 = addItem(item1_5_3, '', 'Акты демонтажа блоков ', '/inventory/ShowDAssactList.do?navclear=1&itemMenu=item1_5_3_5');
		item1_5_3_6 = addItem(item1_5_3, '', 'Акты списания', '/inventory/ShowPayoffList.do?navclear=1&itemMenu=item1_5_3_6');
		item1_5_3_7 = addItem(item1_5_3, '', 'Требования', '/inventory/ShowReqList.do?navclear=1&itemMenu=item1_5_3_7');
		item1_5_3_8 = addItem(item1_5_3, '', 'Штрих коды', '');
			item1_5_3_8_1 = addItem(item1_5_3_8, '', 'Серии штрих-кодов', '/inventory/ShowBarList.do?navclear=1&itemMenu=item1_5_3_8_1');
			item1_5_3_8_2 = addItem(item1_5_3_8, '', 'Печать этикетки', '/inventory/BarSParams.do?navclear=1&itemMenu=item1_5_3_8_2');
	<%} %>
	<%	if(isSiteTransport || isSiteStation || isSiteExploitor || isTechStuff || isAdministrator) { %>
	item1_5_4 = addItem(item1_5, '', 'Приход на позицию', '');
		item1_5_4_1 = addItem(item1_5_4, '', 'Акты монтажа', '/inventory/ShowAssemblingPList.do?navclear=1&itemMenu=item1_5_4_1');
		item1_5_4_2 = addItem(item1_5_4, '', 'Акты монтажа блоков', '/inventory/ShowAssactBList.do?navclear=1&itemMenu=item1_5_4_2');
		item1_5_4_3 = addItem(item1_5_4, '', 'Акты монтажа АФС', '/inventory/ShowAfsList.do?navclear=1&itemMenu=item1_5_4_3');
	item1_5_5 = addItem(item1_5, '', 'Расход с позиции', '');
		item1_5_5_1 = addItem(item1_5_5, '', 'Акты демонтажа', '/inventory/ShowDemountList.do?navclear=1&itemMenu=item1_5_5_1');
		item1_5_5_2 = addItem(item1_5_5, '', 'Акты демонтажа блоков', '/inventory/ShowDAssactBList.do?navclear=1&itemMenu=item1_5_5_2');

	item1_5_6 = addItem(item1_5, '', 'Прочие операции на позиции', '');
		item1_5_6_1 = addItem(item1_5_6, '', 'Инвентаризация на позиции', '/inventory/ShowPositionInventoryList.do?navclear=1&itemMenu=item1_5_6_1');
		item1_5_6_2 = addItem(item1_5_6, '', 'Акты замены/модернизации', '/inventory/ShowChangePList.do?navclear=1&itemMenu=item1_5_6_2');
		item1_5_6_3 = addItem(item1_5_6, '', 'Акты инвентаризации от подрядчика', '/inventory/ShowContractorInventoryList.do?navclear=1&itemMenu=item1_5_6_3');
		item1_5_6_4 = addItem(item1_5_6, '', 'FAULT REPORT', '/inventory/ShowFaultList.do?navclear=1&itemMenu=item1_5_6_4');
	<% if(isAdministrator ) { %>	
		item1_5_6_5 = addItem(item1_5_6, '', 'Конфигурация оборудования ФК БС', '/inventory/ShowConfigFormAction.do?navclear=1&itemMenu=item1_5_6_5');
	<% } %>
	<% } %>
	item1_5_7 = addItem(item1_5, '', 'Отчёты', '');
		item1_5_7_1 = addItem(item1_5_7, '', 'Наличие оборудования', '/inventory/Report1Params.do?navclear=1&itemMenu=item1_5_7_1');
		item1_5_7_2 = addItem(item1_5_7, '', 'Местоположение обор.', '/inventory/Report2Params.do?navclear=1&itemMenu=item1_5_7_2');
		item1_5_7_3 = addItem(item1_5_7, '', 'Обор. Контракты и поставки', '/inventory/Report3Params.do?navclear=1&itemMenu=item1_5_7_3');
		item1_5_7_4 = addItem(item1_5_7, '', 'Приход на объект', '/inventory/Report4Params.do?navclear=1&itemMenu=item1_5_7_4');
		item1_5_7_5 = addItem(item1_5_7, '', 'Приход обор. на объект', '/inventory/Report5Params.do?navclear=1&itemMenu=item1_5_7_5');
		item1_5_7_6 = addItem(item1_5_7, '', 'Расход с объекта', '/inventory/Report6Params.do?navclear=1&itemMenu=item1_5_7_6');
		item1_5_7_7 = addItem(item1_5_7, '', 'Расход обор. с объекта', '/inventory/Report7Params.do?navclear=1&itemMenu=item1_5_7_7');
		item1_5_7_8 = addItem(item1_5_7, '', 'Текущее местоположение', '/inventory/Report8Params.do?navclear=1&itemMenu=item1_5_7_8');
		item1_5_7_9 = addItem(item1_5_7, '', 'История перемещений', '/inventory/Report9Params.do?navclear=1&itemMenu=item1_5_7_9');
		item1_5_7_10 = addItem(item1_5_7, '', 'Краткая история перемещений', '/inventory/Report91Params.do?navclear=1&itemMenu=item1_5_7_10');
	item1_5_8 = addItem(item1_5, '', 'Массовый обсчёт', '/inventory/MassCalcParams.do?navclear=1&itemMenu=item1_5_8');
	item1_5_9 = addItem(item1_5, '', 'Необсчитанные документы', '/inventory/MassdocParams.do?navclear=1&itemMenu=item1_5_9');
	item1_5_10 = addItem(item1_5, '', 'Прочие операции', '');
		item1_5_10_1 = addItem(item1_5_10, '', 'Инвентаризация у сотрудника/подрядчика)', '/inventory/ShowWorkerInvActList.do?navclear=1&itemMenu=item1_5_10_1');
	<%
	if(isAdministrator || isSiteTransport || isSiteStation || isStorageManager) {
		 String urlMolkom = URLUtil.getMolkomURL(request);
	%>
	item1_5_11 = addItem(item1_5, '', 'Состояние склада МОЛКОМ', 'javascript:openWind(\'<%=urlMolkom%>\', \'returnUrl\', item1_5_11, \'windowN6\');');
	<% } %>
	<% } %>
	
	//ArendaGroup(Аренда позиций):
	<%
	if (isArendaGroup && curReg != null) { 	%>
		item1_6 = addItem(item1, '', 'Аренда позиций', '');
		//Доступные филиалы:
		item1_6_0 = addItem(item1_6, '', 'Доступные филиалы', '');
		<% 
		java.util.List accessList = profile.getProfileAccess().getRegionAccessList();
		for (int i = 0; i < accessList.size(); i++) {
			com.hps.july.valueobject.RegionsAccess_TO to = (com.hps.july.valueobject.RegionsAccess_TO)accessList.get(i);
		%>
		<% if( curReg.getVo().getRegionid() == to.getVo().getRegionid() ){%>
			item1_6_0_<%=i%> = addItem(item1_6_0, '', '<B><%=to.getRegionName()%></B>', '/arenda/main.do?navclear=1&rootapp=0&rootstate=0&curRegID=<%=to.getVo().getRegionid()%>&itemMenu=item1_6_0_<%=i%>');
		<% }else{%>
			item1_6_0_<%=i%> = addItem(item1_6_0, '', '<%=to.getRegionName()%>', '/arenda/main.do?navclear=1&rootapp=0&rootstate=0&curRegID=<%=to.getVo().getRegionid()%>&itemMenu=item1_6_0_<%=i%>');
		<% }%>
		<%}%>
		<% if (isVisibleResources) { %>
		item1_6_1 = addItem(item1_6, '', 'Договора аренды(мы арендуем)', '/arenda/ShowWeArendaList.do?navclear=1&itemMenu=item1_6_1');
		<%}%>
		<% if (isVisibleResources || isArendaManager || isArendaMainManager) { %>
		item1_6_2 = addItem(item1_6, '', 'Все договора по позиции', '/arenda/ListFromPosition.do?navclear=1&itemMenu=item1_6_2');
		<%}%>
		<% if (isVisibleResources) { %>
		item1_6_3 = addItem(item1_6, '', 'Ссудные договора', '/arenda/LoanContractList.do?navclear=1&itemMenu=item1_6_3');
		item1_6_4 = addItem(item1_6, '', 'Платежи по ответственному', '/arenda/ShowRespPaysList.do?navclear=1&itemMenu=item1_6_4');
		item1_6_5 = addItem(item1_6, '', 'Работа с биллингом', '');
		item1_6_5_1 = addItem(item1_6_5, '', 'Абонентские договора', '/arenda/ShowAbonentsList.do?navclear=1&itemMenu=item1_6_5_1');
		item1_6_5_2 = addItem(item1_6_5, '', 'Служебки к новым аб. дог.', '/arenda/ShowMemoListDetach.do?navclear=1&itemMenu=item1_6_5_2');
		item1_6_5_3 = addItem(item1_6_5, '', 'Связь ресурсов', '/arenda/ShowAbonentBillLinksList.do?navclear=1&itemMenu=item1_6_5_3');
		<% if (isAdministrator) { %>
			item1_6_5_4 = addItem(item1_6_5, '', 'Взаимодействие с билингом', '/arenda/AbonentBillQuery.do?navclear=1&itemMenu=item1_6_5_4');
			item1_6_5_5 = addItem(item1_6_5, '', 'Журнал Взаимодействия', '/arenda/ShowStartBillList.do?navclear=1&itemMenu=item1_6_5_5');
		<% }%>
		item1_6_6 = addItem(item1_6, '', 'Регламенты проведения актов', '/arenda/ShowMutualReglamentsList.do?navclear=1&itemMenu=item1_6_6');
		<%}%>
		<% if (isArendaMainEconomist || isAdministrator) { %>
		item1_6_7 = addItem(item1_6, '', 'Автоматические процедуры', '');
		item1_6_7_1 = addItem(item1_6_7, '', 'Продление договоров', '/arenda/ShowStartProlongationsList.do?navclear=1&itemMenu=item1_6_7_1');
		item1_6_7_2 = addItem(item1_6_7, '', 'Формирование начислений', '/arenda/ShowStartChargesList.do?navclear=1&itemMenu=item1_6_7_2');
		item1_6_7_3 = addItem(item1_6_7, '', 'Формирование платежей', '/arenda/ShowStartPaymentsList.do?navclear=1&itemMenu=item1_6_7_3');
		<%}%>
		<% if (isVisibleResources || isArendaManager || isArendaMainManager) { %>
		item1_6_8 = addItem(item1_6, '', 'Базовые отчеты', '/arenda/ArendaReport3Params.do?navclear=1&itemMenu=item1_6_8');
		<%}%>
		<% if (isVisibleResources) { %>
		item1_6_9 = addItem(item1_6, '', 'Основные справочники', '');
		item1_6_9_1 = addItem(item1_6_9, '', 'Банки', '/dict/BanksList.do?navclear=1&itemMenu=item1_6_9_1');
		//item1_6_9_2 = addItem(item1_6_9, '', 'Физические лица', '/dict/ShowPersonList.do?rootapp=7&navclear=1&itemMenu=item1_6_9_2');
		//item1_6_9_3 = addItem(item1_6_9, '', 'Юридические лица', '/dict/ShowOrganizationListM.do?rootapp=7&navclear=1&itemMenu=item1_6_9_3');
		item1_6_9_4 = addItem(item1_6_9, '', 'Курсы валют', '/dict/ShowCurrateList.do?rootapp=7&navclear=1&itemMenu=item1_6_9_4');
		item1_6_9_5 = addItem(item1_6_9, '', 'Поставщики', '/dict/VendorList.do?navclear=1&itemMenu=item1_6_9_5');
		<%}%>
		<% if (isViewerPays || isAdministrator) { %>
		item1_6_10 = addItem(item1_6, '', 'Платежи NFS', '/arenda/ShowNFS_ListDetach.do?navclear=1&itemMenu=item1_6_10');
		<%}%>
		<% if (isLcsGroup || isAdministrator || isArendaDirector || isArendaManager) { %>
		item1_6_11 = addItem(item1_6, '', 'Лицензия', '/arenda/ShowListLicence.do?navclear=1&itemMenu=item1_6_11');
		<%}%>
		<% if (isVisibleResources || isArendaPurchaser || isArendaAccountant) { %>		
		item1_6_12 = addItem(item1_6, '', 'Описи документов', '');
		<% 	if (isVisibleResources) { %>
		item1_6_12_1 = addItem(item1_6_12, '', 'Состав описи', '/arenda/RegistryBuchDocsListForInitialGroup.do?navclear=1&itemMenu=item1_6_12_1');
		<% 	}  %>
		<% 	if (isAdministrator || isArendaPurchaser || isArendaAccountant) { %>
		item1_6_12_2 = addItem(item1_6_12, '', 'Проверка описи', '/arenda/RegistryBuchDocsListForReturnDocumentGroup.do?navclear=1&itemMenu=item1_6_12_2');
		<% 	}  %>
		<% 	if (isAdministrator || (isVisibleResources && isArendaPurchaser) || (isVisibleResources && isArendaAccountant) ) { %>
		item1_6_12_3 = addItem(item1_6_12, '', '<%= curReg.getRegionName()%>', '/arenda/RegistryBuchDocsList.do?navclear=1&itemMenu=item1_6_12_3');
		<% 	}  %>		
		<%}%>
		<% if (isVisibleResources || isArendaManager || isArendaMainManager) { %>
		item1_6_13 = addItem(item1_6, '', 'Инциденты по договорам', '/arenda/LeaseProblemList.do?navclear=1&itemMenu=item1_6_13');		
		item1_6_14 = addItem(item1_6, '', 'Фактические данные', '/arenda/FactsLeasePage.do?navclear=1&itemMenu=item1_6_14');		
		<%}%>
	<%} %>
	
	//Разрешения 
	<% if (isPermitGroup || isFreqManager || isBasestationGroup || isSmssPermitGroup) { %>
	item1_16 = addItem(item1, '', 'Разрешения', '');
		<% if (isPermitGroup || isSmssPermitGroup) { %>
		item1_16_1 = addItem(item1_16, '', 'Разрешения РЭС и СС', 'javascript:openWind(\'<%= pathComplectPermitsTrailcom + "&itemMenu=item1_16_1"%>\', \'returnUrl\', item1_16_1, \'windowN8\');');
		<% } %>
		<% if( isDeveloper || isFreqManager ){ %>
		item1_16_2 = addItem(item1_16, "", "Разрешения ГКРЧ", '');
			item1_16_2_1 = addItem(item1_16_2, "", "Учет решений ГКРЧ", '/basestation/ShowGKRCHDocList.do?navclear=1&itemMenu=item1_16_2_1');
			item1_16_2_2 = addItem(item1_16_2, "", "Сертификаты на РРЛ", '/basestation/ShowRRLDocList.do?navclear=1&itemMenu=item1_16_2_2');
			item1_16_2_3 = addItem(item1_16_2, "", "Получение разрешений", '/basestation/ShowFrequencyLicenceList.do?navclear=1&itemMenu=item1_16_2_3');
			item1_16_2_4 = addItem(item1_16_2, "", "Типы этапов ЧР", '/basestation/ShowEtapTypeList.do?navclear=1&itemMenu=item1_16_2_4');
			item1_16_2_5 = addItem(item1_16_2, "", "Отчеты по ЧР", '/basestation/ReportBaseStation.do?navclear=1&itemMenu=item1_16_2_5');
			item1_16_2_6 = addItem(item1_16_2, "", "Отчет 'Заявки на пр. изм.'", '/basestation/ShowReportProtocolSfo.do?navclear=1&itemMenu=item1_16_2_6');
		<%}%>
	<% if (isBasestationGroup) {%>
		item1_16_3 = addItem(item1_16, "", "Импорт данных по разрешенным частотам", '/basestation/LoadXls.do?navclear=1&itemMenu=item1_16_3');
	<% } %>		

	<% if (isRCHSGroup) {%>
		item1_16_4 = addItem(item1_16, "", "Частотные разрешения", 'javascript:openWind(\'<%= rchspermitsUrl %>\', \'returnUrl\', item1_16_4, \'windowN10\');');
	<% } %>		
	<%}%>
					
	<% if (isSitedocGroup) { %>
	item1_10 = addItem(item1, '', 'Общие Документы по регионам', '/sitedoc/ShowRegionDocuments.do?navclear=1&rootapp=0&rootstate=0&itemMenu=item1_10');
	<% } %>
	<%
		if(com.hps.july.util.AppUtils.isMicrostrategyAccess(request.getRemoteUser())) {
		String url = URLUtil.getMicrostrategyURL(request);
	%>
	item1_15 = addItem(item1, '', 'Отчеты MS', 'javascript:openWind(\'<%=url%>\', \'returnUrl\', item1_15, \'windowN9\');');
	//item1_15.targetFrame="_blank";
	<%} %>
	item2 = addItem(root_domain, "", "Перерегистрация", '/Reregister.do?navclear=1');
	item3 = addItem(root_domain, "", "Выход", '/Logout.do?navclear=1');
</script>

<script type="text/javascript" language="JavaScript1.2">
	initialize();
	loadSelectedMenuItem();
</script>

</DIV>
</BODY>
</html:html>