package com.hps.july.basestation.formbean;

import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.siteinfo.valueobject.RegionsSelector;

/**
 * Форма выбора донорной базовой станции
 */
public class BSLookupListForm
	extends BrowseForm
{
	private RegionsSelector regionsSelector = new RegionsSelector();

	private String stationtype = "D"; // GSM/DCS - 'D', DAMPS	- 'A'
	private String searchby = "1"; // Все - 'A', По номеру БС - '1', По названию - '2', По адресу - '3'
	private String searchstring;

	private boolean allcontroller = true;
	private ControllerModel acontroller = new ControllerModel();
	private boolean allswitch = true;
	private SwitchModel aswitch = new SwitchModel();
public ControllerModel getAcontroller() {
	return acontroller;
}
public SwitchModel getAswitch() {
	return aswitch;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		new Boolean(!regionsSelector.isAllSuperregions()), (regionsSelector.getSuperregioncodes() != null)?regionsSelector.getSuperregioncodes():(new Integer[] {new Integer(0)}),
		new Boolean(!regionsSelector.isAllRegions()), (regionsSelector.getRegioncodes() != null)?regionsSelector.getRegioncodes():(new Integer[] {new Integer(0)}),
		new Boolean(!regionsSelector.isAllNetzones()), (regionsSelector.getNetzonecodes() != null)?regionsSelector.getNetzonecodes():(new Integer[] {new Integer(0)}),
		(stationtype == null)?"":stationtype,
		(searchby == null)?"":searchby,
		(searchstring == null)?"":searchstring,
		new Boolean(!allcontroller),(acontroller.getKey() == null)?new Integer(0):acontroller.getKey(),
		new Boolean(!allswitch),(aswitch.getKey() == null)?new Integer(0):aswitch.getKey(),
		new Integer(1)
	};
}
public String getFinderMethodName() {
	return "find";
}
/**
 * 
 * @return com.hps.july.siteinfo.valueobject.RegionsSelector
 */
public com.hps.july.siteinfo.valueobject.RegionsSelector getRegionsSelector() {
	return regionsSelector;
}
public String getSearchby() {
	return searchby;
}
public String getSearchstring() {
	return searchstring;
}
public String getStationtype() {
	return stationtype;
}
public boolean isAllcontroller() {
	return allcontroller;
}
public boolean isAllswitch() {
	return allswitch;
}
public static void log(String s)
{
	System.out.println("BSLOOKUP: "+s);
}
public void setAllcontroller(boolean newAllcontroller) {
	allcontroller = newAllcontroller;
}
public void setAllswitch(boolean newAllswitch) {
	allswitch = newAllswitch;
}
public void setSearchby(String newSearchby) {
	searchby = newSearchby;
}
public void setSearchstring(String newSearchstring) {
	searchstring = newSearchstring;
}
public void setStationtype(String newStationtype) {
	stationtype = newStationtype;
}
}
