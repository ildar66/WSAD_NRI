package com.hps.july.basestation.formbean;

import com.hps.july.siteinfo.valueobject.RegionsSelector;

/**
 * Форма списка контроллеров связанных с коммутатором
 */
public class SwitchControllersListForm 
	extends ControllerListForm
{
public String actionName() {
	return "ShowSwitchControllersList.do";
}
public int getState() {
	return com.hps.july.basestation.APPStates.SWCH_CONNECTED_CONTR;
}
public void prepare(javax.servlet.http.HttpServletRequest request) {
    super.prepare(request);
	RegionsSelector s = getRegionsSelector();
	s.setAllNetzones(true);
	s.setAllRegions(true);
	s.setAllSuperregions(true);
    setSearchBy(this.SEARCH_ALL);
    setSearchString("");
    setEquipmentState(this.EQUIPMENT_STATE_WORK_W);
//    setPlanstate(this.POSITION_PLANSTATE_Fact);
    setIsSwitch(false); // SwitchId always should be setted
}
}
