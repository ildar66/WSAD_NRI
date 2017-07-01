/*
 * Created on 25.01.2007
 */
package com.hps.july.dictionary.formbean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCDictionaryObject;
import com.hps.july.dictionary.valueobject.Cable_VO;
import com.hps.july.dictionary.valueobject.ResourceCompat_VO;
import com.hps.july.dictionary.valueobject.Resource_VO;
import com.hps.july.persistence.ResourceAccessBeanData;

/**
 * @author irogachev
 */
public class ShowConfConnectorCableCompatForm extends CommonConfigCtrlForm {
	
	// параметры для поиска разъемов
	private String searchConnectorParameterName = "1"; 
	private String nriCodeConnectorSearchParam = "";
	private String nfsCodeConnectorSearchParam = "";
	private String modelConnectorSearchParam = "";
	private String activeConnectorSearchParam = "";

	// параметры для поиска кабелей
	private String searchCableParameterName = "1";
	private String nriCodeCableSearchParam = "";
	private String nfsCodeCableSearchParam = "";
	private String modelCableSearchParam = "";
	private String activeCableSearchParam = "";
	private List diamsList =  new ArrayList();
	private String diamCableCodeSearchParam = "";


	private List connectorsList =  new ArrayList();

	private String curConnectorSelectedID = BEGIN_ID_INDEX;
	private String curConnectorOldRowClassName;

	private List cablesList =  new ArrayList();

	private String curCableSelectedID = BEGIN_ID_INDEX;
	private String curCableOldRowClassName;

	private String isConnectorSelectProcess = FALSE_STR;	
	private String isCableSelectProcess = FALSE_STR;
	private String isNeedCrossToRefresh = FALSE_STR;

	private List resourcesCompatList = new ArrayList();
	private String selectedCompatRes1 = BEGIN_ID_INDEX;
	private String selectedCompatRes2 = BEGIN_ID_INDEX;

	private String isSetNewCompat = FALSE_STR;
	private String isDeleteResCompat = FALSE_STR;
	
	private boolean userInAdminRole = false;
	
	public ShowConfConnectorCableCompatForm() {
		super();
		prepareDiamList();
	}

	public int getState() {
		return com.hps.july.dictionary.APPStates.CONF_CONNECTOR_CABLE_COMPAT_LIST;
	}

	/**
	 * @return
	 */
	public String getSearchConnectorParameterName() {
		return searchConnectorParameterName;
	}

	/**
	 * @param string
	 */
	public void setSearchConnectorParameterName(String string) {
		searchConnectorParameterName = string;
	}

	/**
	 * @return
	 */
	public String getSearchCableParameterName() {
		return searchCableParameterName;
	}

	/**
	 * @param string
	 */
	public void setSearchCableParameterName(String string) {
		searchCableParameterName = string;
	}

	/**
	 * @return
	 */
	public String getNriCodeCableSearchParam() {
		return nriCodeCableSearchParam;
	}

	/**
	 * @return
	 */
	public String getNriCodeConnectorSearchParam() {
		return nriCodeConnectorSearchParam;
	}

	/**
	 * @param string
	 */
	public void setNriCodeCableSearchParam(String string) {
		nriCodeCableSearchParam = string;
	}

	/**
	 * @param string
	 */
	public void setNriCodeConnectorSearchParam(String string) {
		nriCodeConnectorSearchParam = string;
	}

	/**
	 * @return
	 */
	public List getConnectorsList() {
		return connectorsList;
	}

	/**
	 * @param list
	 */
	public void setConnectorsList(List list) {
		connectorsList = list;
	}

	/**
	 * Получение списка разъемов 
	 *
	 */
	public void prepareConnectorsList() {
		List selectedConnectorsList = new ArrayList();
		int searchParamNum = Integer.parseInt(getSearchConnectorParameterName());
		String searchParamValue = "";
		switch (searchParamNum) {
			case 1: searchParamValue = getNriCodeConnectorSearchParam();
					break;
			case 2: searchParamValue = getNfsCodeConnectorSearchParam();
					break;
			case 3: searchParamValue = getModelConnectorSearchParam();
					break;
			case 4: searchParamValue = getActiveConnectorSearchParam();
					break;
		}
		CDBCResultSet selectedConnectorsCDBCResultSet = 
			CDBCDictionaryObject.findConnector4CompatList(searchParamNum, searchParamValue);
		CDBCResultSet selectedConnectorsNFSCountCDBCResultSet = 
			CDBCDictionaryObject.findConnector4CompatNFSCountList(searchParamNum, searchParamValue);
		// популируем массив connectorVO
		Iterator connectorIterator = selectedConnectorsCDBCResultSet.listIterator();
		Iterator connectorNFSCountIterator = selectedConnectorsNFSCountCDBCResultSet.listIterator();
		while (connectorIterator.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)connectorIterator.next();
			CDBCRowObject roNFSCount = (CDBCRowObject)connectorNFSCountIterator.next();
			Resource_VO connector_VO = new Resource_VO(); 
			connector_VO.setId(ro.getColumn("id").asString());			
			connector_VO.setManuf(ro.getColumn("manuf").asString());			
			connector_VO.setModel(ro.getColumn("model").asString());			
			connector_VO.setUnit(ro.getColumn("unit").asString());			
			connector_VO.setActive(ro.getColumn("active").asString());			
			connector_VO.setNfsid(roNFSCount.getColumn("nfsid").asString());
			connector_VO.setCountnfs(roNFSCount.getColumn("countnfs").asString());
			//
			selectedConnectorsList.add(connector_VO);			
		}
		setConnectorsList(selectedConnectorsList);
		setCurConnectorSelectedID(BEGIN_ID_INDEX);
		prepareCompatList();
	}

	/**
	 * Получение списка кабелей 
	 *
	 */
	public void prepareCablesList() {
		List selectedCablesList = new ArrayList();
		int searchParamNum = Integer.parseInt(getSearchCableParameterName());
		String searchParamValue = "";
		switch (searchParamNum) {
			case 1: searchParamValue = getNriCodeCableSearchParam();
					break;
			case 2: searchParamValue = getNfsCodeCableSearchParam();
					break;
			case 3: searchParamValue = getModelCableSearchParam();
					break;
			case 4: searchParamValue = getActiveCableSearchParam();
					break;
			case 5: searchParamValue = getDiamCableCodeSearchParam();
					break;
		}
		CDBCResultSet selectedCablesCDBCResultSet = 
			CDBCDictionaryObject.findCable4CompatList(searchParamNum, searchParamValue);
		CDBCResultSet selectedCablesNFSCountCDBCResultSet = 
			CDBCDictionaryObject.findCable4CompatNFSCountList(searchParamNum, searchParamValue);
		// популируем массив cable_VO
		Iterator cableIterator = selectedCablesCDBCResultSet.listIterator();
		Iterator cableNFSCountIterator = selectedCablesNFSCountCDBCResultSet.listIterator();
		while (cableIterator.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)cableIterator.next();
			CDBCRowObject roNFSCount = (CDBCRowObject)cableNFSCountIterator.next();
			Cable_VO cable_VO = new Cable_VO(); 
			cable_VO.setId(ro.getColumn("id").asString());			
			cable_VO.setManuf(ro.getColumn("manuf").asString());			
			cable_VO.setModel(ro.getColumn("model").asString());			
			cable_VO.setUnit(ro.getColumn("unit").asString());			
			cable_VO.setActive(ro.getColumn("active").asString());			
			cable_VO.setDiamid(ro.getColumn("diamid").asString());			
			cable_VO.setDiamname(ro.getColumn("diamname").asString());			
			cable_VO.setNfsid(roNFSCount.getColumn("nfsid").asString());
			cable_VO.setCountnfs(roNFSCount.getColumn("countnfs").asString());
			//
			selectedCablesList.add(cable_VO);			
		}
		// System.out.println("# selectedCablesList.size() " + selectedCablesList.size());
		setCablesList(selectedCablesList);
		setCurCableSelectedID(BEGIN_ID_INDEX);
		prepareCompatList();
	}
	
	/**
	 * @return
	 */
	public String getCurConnectorOldRowClassName() {
		return curConnectorOldRowClassName;
	}

	/**
	 * @return
	 */
	public String getCurConnectorSelectedID() {
		return curConnectorSelectedID;
	}

	/**
	 * @param string
	 */
	public void setCurConnectorOldRowClassName(String string) {
		curConnectorOldRowClassName = string;
	}

	/**
	 * @param string
	 */
	public void setCurConnectorSelectedID(String string) {
		// System.out.println("### setCurConnectorSelectedID = " + string);
		curConnectorSelectedID = string;
	}

	/**
	 * @return
	 */
	public List getCablesList() {
		return cablesList;
	}

	/**
	 * @return
	 */
	public String getCurCableOldRowClassName() {
		return curCableOldRowClassName;
	}

	/**
	 * @return
	 */
	public String getCurCableSelectedID() {
		return curCableSelectedID;
	}

	/**
	 * @param list
	 */
	public void setCablesList(List list) {
		cablesList = list;
	}

	/**
	 * @param string
	 */
	public void setCurCableOldRowClassName(String string) {
		curCableOldRowClassName = string;
	}

	/**
	 * @param string
	 */
	public void setCurCableSelectedID(String string) {
		// System.out.println("### setCurCableSelectedID = " + string);
		curCableSelectedID = string;
	}

	/**
	 * @return
	 */
	public String getActiveConnectorSearchParam() {
		return activeConnectorSearchParam;
	}

	/**
	 * @return
	 */
	public String getModelConnectorSearchParam() {
		return modelConnectorSearchParam;
	}

	/**
	 * @return
	 */
	public String getNfsCodeConnectorSearchParam() {
		return nfsCodeConnectorSearchParam;
	}

	/**
	 * @param string
	 */
	public void setActiveConnectorSearchParam(String string) {
		activeConnectorSearchParam = string;
	}

	/**
	 * @param string
	 */
	public void setModelConnectorSearchParam(String string) {
		modelConnectorSearchParam = string;
	}

	/**
	 * @param string
	 */
	public void setNfsCodeConnectorSearchParam(String string) {
		nfsCodeConnectorSearchParam = string;
	}

	/**
	 * @return
	 */
	public String getIsConnectorSelectProcess() {
		return isConnectorSelectProcess;
	}

	/**
	 * @param string
	 */
	public void setIsConnectorSelectProcess(String string) {
		isConnectorSelectProcess = string;
	}

	/**
	 * @return
	 */
	public String getActiveCableSearchParam() {
		return activeCableSearchParam;
	}

	/**
	 * @return
	 */
	public String getDiamCableCodeSearchParam() {
		return diamCableCodeSearchParam;
	}

	/**
	 * @return
	 */
	public List getDiamsList() {
		return diamsList;
	}

	/**
	 * @return
	 */
	public String getModelCableSearchParam() {
		return modelCableSearchParam;
	}

	/**
	 * @return
	 */
	public String getNfsCodeCableSearchParam() {
		return nfsCodeCableSearchParam;
	}

	/**
	 * @param string
	 */
	public void setActiveCableSearchParam(String string) {
		activeCableSearchParam = string;
	}

	/**
	 * @param string
	 */
	public void setDiamCableCodeSearchParam(String string) {
		diamCableCodeSearchParam = string;
	}

	/**
	 * @param list
	 */
	public void setDiamsList(List list) {
		diamsList = list;
	}

	/**
	 * @param string
	 */
	public void setModelCableSearchParam(String string) {
		modelCableSearchParam = string;
	}

	/**
	 * @param string
	 */
	public void setNfsCodeCableSearchParam(String string) {
		nfsCodeCableSearchParam = string;
	}

	/**
 	* Подготавливает список диаметров для лукапа 
 	*/
	private void prepareDiamList() {
		ArrayList locDiamList = new ArrayList();
		CDBCResultSet diamCDBCResultSet = CDBCDictionaryObject.findCableDiamsList();
		Iterator it = diamCDBCResultSet.listIterator();
		while(it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			OptionEntry oe = new OptionEntry();
			oe.setKey(ro.getColumn("id").asString());
			oe.setValue(ro.getColumn("name").asString());
			locDiamList.add(oe);
		}	
		//
		if (locDiamList.size() > 0) {
			String theKey = ((OptionEntry)locDiamList.get(0)).getKey(); 
			setDiamCableCodeSearchParam(theKey);
		}
		setDiamsList(locDiamList);
	}

	/**
	 * @return
	 */
	public String getIsCableSelectProcess() {
		return isCableSelectProcess;
	}

	/**
	 * @param string
	 */
	public void setIsCableSelectProcess(String string) {
		isCableSelectProcess = string;
	}

	/**
	 * 
	 */
	public void prepareCompatList() {
		List locCompatList = new ArrayList();
		CDBCResultSet compatCDBCResultSet =
			CDBCDictionaryObject.findResourceCompatList(
			getCurConnectorSelectedID(), getCurCableSelectedID(), BEGIN_ID_INDEX);
		// 
		Iterator compatIterator = compatCDBCResultSet.listIterator();
		while (compatIterator.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)compatIterator.next();
			ResourceCompat_VO resourceCompat_VO = new ResourceCompat_VO();
			resourceCompat_VO.setResource1(ro.getColumn("resource1").asString()); 
			resourceCompat_VO.setResource2(ro.getColumn("resource2").asString()); 
			//
			locCompatList.add(resourceCompat_VO);			
		}
		// System.out.println("### locCompatList.size() = " + locCompatList.size());
		// 
		setResourcesCompatList(locCompatList);
	}

	/**
	 * @return
	 */
	public int getCompatibilityNeedToRefreshState() {
		return com.hps.july.dictionary.APPStates.CONF_CONNECTOR_CABLE_COMPAT_LIST_REFRESH;
	}

	/**
	 * @return
	 */
	public String getIsNeedCrossToRefresh() {
		return isNeedCrossToRefresh;
	}

	/**
	 * @param string
	 */
	public void setIsNeedCrossToRefresh(String string) {
		// System.out.println("### setIsNeedCrossToRefresh = " + string);
		isNeedCrossToRefresh = string;
	}

	/**
	 * @return
	 */
	public String getSelectedCompatRes1() {
		return selectedCompatRes1;
	}

	/**
	 * @return
	 */
	public String getSelectedCompatRes2() {
		return selectedCompatRes2;
	}

	/**
	 * @param string
	 */
	public void setSelectedCompatRes1(String string) {
		selectedCompatRes1 = string;
	}

	/**
	 * @param string
	 */
	public void setSelectedCompatRes2(String string) {
		selectedCompatRes2 = string;
	}

	/**
	 * @return
	 */
	public List getResourcesCompatList() {
		return resourcesCompatList;
	}

	/**
	 * @param list
	 */
	public void setResourcesCompatList(List list) {
		resourcesCompatList = list;
	}

	public int getResourcesCompatListSize() {
		return resourcesCompatList.size();
	}

	public String getCanNewCompatCreate() {
		String outStr = FALSE_STR;
		if (isUserInAdminRole()) {
			if ((getResourcesCompatListSize()==0) && 
				(! BEGIN_ID_INDEX.equals(getCurConnectorSelectedID()))&& 
				(! BEGIN_ID_INDEX.equals(getCurCableSelectedID()))) {
					outStr = TRUE_STR;
				}
		}
		return outStr;	
	}

	public String getCanDeleteCompat() {
		String outStr = FALSE_STR;
		if (isUserInAdminRole()) {
				outStr = TRUE_STR;
			}
		return outStr;	
	}

	/**
	 * @return
	 */
	public String getIsSetNewCompat() {
		return isSetNewCompat;
	}

	/**
	 * @param string
	 */
	public void setIsSetNewCompat(String string) {
		isSetNewCompat = string;
	}

	/**
	 * @return
	 */
	public String getIsDeleteResCompat() {
		return isDeleteResCompat;
	}

	/**
	 * @param string
	 */
	public void setIsDeleteResCompat(String string) {
		isDeleteResCompat = string;
	}

	/**
	 * @return
	 */
	public boolean isUserInAdminRole() {
		return userInAdminRole;
	}

	/**
	 * @param b
	 */
	public void setUserInAdminRole(boolean b) {
		userInAdminRole = b;
	}

}
