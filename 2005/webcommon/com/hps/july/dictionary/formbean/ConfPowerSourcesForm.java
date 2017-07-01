/*
 * Created on 20.11.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCDictionaryObject;
import com.hps.july.constants.Applications;
import com.hps.july.dictionary.valueobject.CmplStruct_VO;
import com.hps.july.dictionary.valueobject.CurComplect_VO;
import com.hps.july.web.util.BrowseForm;
import com.hps.july.web.util.ParamsParser;

/**
 * @author irogachev
 */
public abstract class ConfPowerSourcesForm extends CommonConfigCtrlForm {

	// Настроечные параметры для разных типов источников питания (УЗО и ёликтронной аппаратуры)
	public static final String POWER_SOURCE_TYPE_VAR = "POWER_SOURCE_TYPE_VAR";
	public static final String ELAP_POWER_SOURCE_TYPE = "ELAP_POWER_SOURCE_TYPE";
	public static final String UZO_POWER_SOURCE_TYPE = "UZO_POWER_SOURCE_TYPE";
	// здесь у нас инсталляционные комплекты БС
	public static final String INST_COMPL_BASE_STATION_TYPE = "INST_COMPL_BASE_STATION_TYPE";

	private String searchLabel = "";
	private String complectLabel = "";
	private String structLabel = "";
	private String modelTypeCode = "";
	private String complectTypeCode = "";
	private Integer resourceSetClassConst = new Integer(0);

	// общие константы и переменные 

	public static final String CUR_COMPLECT_SUBMIT_MODE = "CUR_COMPLECT_SUBMIT_MODE";  
	public static final String SRC_NFS = "SRC_NFS";  
	public static final String SRC_CMPL = "SRC_CMPL";  
	public static final String SRC_MODEL = "SRC_MODEL";  
	public static final String CMPL_TITLE = "CMPL_TITLE";  

	private String searchParameterName = SRC_NFS;
	private String nfsCodeSearchParam = "";
	private String cmplCodeSearchParam = "";
	private String filterModelParam = "";
	private String modelCodeSearchParam = "";
	private String titleSearchParam = "";
	private String isModelFiltersProcess = FALSE_STR;
	private List modelsList = new ArrayList();
	private String isComplectSelectProcess = FALSE_STR;
	// private String isComplectRefresh = FALSE_STR;
	private List curComplectList =  new ArrayList();

	private String curComplectSelectedID = BEGIN_ID_INDEX;
	private String curComplectOldRowClassName;
	// пока это не отображается
	private String curComplectWholeString;
		
	private String curResourceSelectedID;
	private String curResourceOldRowClassName;
	
	public int getState() {
		int returnState = com.hps.july.dictionary.APPStates.CONF_POWER_SOURCES_LIST;
		System.out.println("### ConfPowerSourcesForm getState() getSubmitMode() = " + getSubmitMode());
		if (CUR_COMPLECT_SUBMIT_MODE.equals(getSubmitMode())) {
			returnState = com.hps.july.dictionary.APPStates.CONF_POWER_SOURCES_STRUCT_CUR_COMPLECT_LIST;
			setSubmitMode(MAIN_SUBMIT_MODE);
		} 
		return returnState;
	}

	// в зависимости от параметров фильтрации возвращает список строк текущего комплекта	
	public void prapareCurComplectList() {
		ArrayList outList = new ArrayList();
		// запоминаем старое текущее значение
		boolean isOldFound = false;
		String oldCurComlectCode = getCurComplectSelectedID();
		String oldWholeString = "";
		if (oldCurComlectCode == null) {
			oldCurComlectCode = "";
		}
		System.out.println("### oldCurComlectCode = " + oldCurComlectCode);
		//
		String paramValue = getCurComplectParamValue();
		int paramCode = getCurComplectParamCode();
		CDBCResultSet curComplectRS = CDBCDictionaryObject.findConfigPowerSources(paramCode, paramValue, getComplectTypeCode());
		Iterator it = curComplectRS.listIterator();
		while(it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			CurComplect_VO curCmplVO = new CurComplect_VO();
			curCmplVO.setComplectCode(ro.getColumn("complectCode").asString());
			curCmplVO.setNfsCode(ro.getColumn("nfsCode").asString());
			curCmplVO.setComplectName(ro.getColumn("complectName").asString());
			curCmplVO.setPower(ro.getColumn("power").asString());
			curCmplVO.setNfsName(ro.getColumn("nfsName").asString());
			curCmplVO.setNfsId(ro.getColumn("nfsId").asString());
			outList.add(curCmplVO);
			if (oldCurComlectCode.equals(curCmplVO.getComplectCode())) {
				isOldFound = true;
				oldWholeString = curCmplVO.toString();
				System.out.println("### isOldFound = " + curCmplVO.getComplectCode());
			}
		}	
		String curCmplSelId = BEGIN_ID_INDEX;
		String curCmplWhStr = ""; 
		if (isOldFound) {
			curCmplSelId = oldCurComlectCode;
			curCmplWhStr = oldWholeString;
		} else {
			if (outList.size() > 0) {
				curCmplSelId = ((CurComplect_VO)outList.get(0)).getComplectCode();
				curCmplWhStr = ((CurComplect_VO)outList.get(0)).toString();
			} 
		}
		setCurComplectSelectedID(curCmplSelId);
		setCurComplectWholeString(curCmplWhStr);
		setCurComplectList(outList);
	}	

	/**
	 * @return
	 */
	private String getCurComplectParamValue() {
		String outStr = "";
		if (SRC_NFS.equals(getSearchParameterName())) {
			outStr = getNfsCodeSearchParam();
		} else if (SRC_CMPL.equals(getSearchParameterName())) {
			outStr = getCmplCodeSearchParam();
		} else if (SRC_MODEL.equals(getSearchParameterName())) {
			outStr = getModelCodeSearchParam();
		} else if (CMPL_TITLE.equals(getSearchParameterName())) {
			outStr = "*"+getTitleSearchParam()+"*";
		}
		return outStr;
	}

	/**
	 * @return
	 */
	private int getCurComplectParamCode() {
		int outInt = 1;
		if (SRC_NFS.equals(getSearchParameterName())) {
			outInt = 1;
		} else if (SRC_CMPL.equals(getSearchParameterName())) {
			outInt = 2;
		} else if (SRC_MODEL.equals(getSearchParameterName())) {
			outInt = 3;
		} else if (CMPL_TITLE.equals(getSearchParameterName())) {
			outInt = 4;
		}
		return outInt;
	}

	public List getCmplStructList() {
		ArrayList outList = new ArrayList();
		CDBCResultSet curComplectRS = CDBCDictionaryObject.findCmplStruct(Integer.parseInt(getCurComplectSelectedID()));
		CDBCResultSet curComplectNfsCountRS = CDBCDictionaryObject.findCmplStructNfsCount(Integer.parseInt(getCurComplectSelectedID()));
		HashMap enabledcodes = CDBCDictionaryObject.getCanShowNfsCodes(getCurComplectSelectedID());
		//
		Iterator it = curComplectRS.listIterator();
		Iterator itNfsCount = curComplectNfsCountRS.listIterator();
		// для сохранения старого курсора
		boolean isOldFound = false;
		String oldSelResId = getCurResourceSelectedID();
		System.out.println("### oldSelResId = " + oldSelResId);
		if (oldSelResId==null) {
			oldSelResId = "";
		}
		while(it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			CDBCRowObject roNfsCount = (CDBCRowObject)itNfsCount.next();

			//
			CmplStruct_VO cmplStructVO = new CmplStruct_VO();
			cmplStructVO.setNriCode(ro.getColumn("nriCode").asString());
			if (oldSelResId.equals(cmplStructVO.getNriCode())) {
				isOldFound = true;
				System.out.println("### isOldFound = " + cmplStructVO.getNriCode());
			}
			cmplStructVO.setResourceName(ro.getColumn("resourceName").asString());
			cmplStructVO.setModel(ro.getColumn("model").asString());
			// убираем знаки после запятой
			cmplStructVO.setQuantity(getIntegerString(ro.getColumn("quantity").asString(), isUnitInt()));
			cmplStructVO.setUnit_name(ro.getColumn("unit_name").asString());
			Boolean enabledvalue = (Boolean) enabledcodes.get(ro.getColumn("nriCode").asString());
			cmplStructVO.setEnablednfs(enabledvalue.booleanValue());
			cmplStructVO.setNfsid(CDBCDictionaryObject.getFirstNFSCode(new Integer(ro.getColumn("nriCode").asString())));
			cmplStructVO.setCount_nfs(CDBCDictionaryObject.nfsCodeCount(cmplStructVO.getNriCode()));
			outList.add(cmplStructVO);
		}	
		String curResourceCmplSelId = BEGIN_ID_INDEX;
		if (isOldFound) {
			curResourceCmplSelId = oldSelResId;
		} else {
			if (outList.size() > 0) {
				curResourceCmplSelId = ((CmplStruct_VO)outList.get(0)).getNriCode();
			}
		}
		setCurResourceSelectedID(curResourceCmplSelId);
		return outList;
	}	

	/**
	 * @return
	 */
	public String getCurComplectOldRowClassName() {
		return curComplectOldRowClassName;
	}

	/**
	 * @return
	 */
	public String getCurComplectSelectedID() {
		return curComplectSelectedID;
	}

	/**
	 * @param string
	 */
	public void setCurComplectOldRowClassName(String string) {
		curComplectOldRowClassName = string;
	}

	/**
	 * @param string
	 */
	public void setCurComplectSelectedID(String string) {
		curComplectSelectedID = string;
	}

	/**
	 * @return
	 */
	public String getCurComplectWholeString() {
		return curComplectWholeString;
	}

	/**
	 * @param string
	 */
	public void setCurComplectWholeString(String string) {
		curComplectWholeString = string;
	}

	/**
	 * @return
	 */
	public String getSearchParameterName() {
		return searchParameterName;
	}

	/**
	 * @param string
	 */
	public void setSearchParameterName(String string) {
		searchParameterName = string;
	}

	/**
	 * @return
	 */
	public String getCmplCodeSearchParam() {
		return cmplCodeSearchParam;
	}

	/**
	 * @return
	 */
	public String getNfsCodeSearchParam() {
		return nfsCodeSearchParam;
	}

	/**
	 * @param string
	 */
	public void setCmplCodeSearchParam(String string) {
		cmplCodeSearchParam = string;
	}

	/**
	 * @param string
	 */
	public void setNfsCodeSearchParam(String string) {
		nfsCodeSearchParam = string;
	}

	/**
	 * @return
	 */
	public String getFilterModelParam() {
		return filterModelParam;
	}

	/**
	 * @param string
	 */
	public void setFilterModelParam(String string) {
		filterModelParam = string;
	}

	/**
	 * @return
	 */
	public String getModelCodeSearchParam() {
		return modelCodeSearchParam;
	}

	/**
	 * @param string
	 */
	public void setModelCodeSearchParam(String string) {
		modelCodeSearchParam = string;
	}

	/**
	 * @return
	 */
	public String getIsModelFiltersProcess() {
		return isModelFiltersProcess;
	}

	/**
	 * @param b
	 */
	public void setIsModelFiltersProcess(String b) {
		isModelFiltersProcess = b;
	}

	/**
	 * 
	 */
	public void prepareModelList() {
		ArrayList modelList = new ArrayList();
		CDBCResultSet modelListRS = CDBCDictionaryObject.findModelList(filterModelParam.trim(), getModelTypeCode());
		Iterator it = modelListRS.listIterator();
		while(it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			OptionEntry oe = new OptionEntry();
			oe.setKey(ro.getColumn("id").asString());
			oe.setValue(ro.getColumn("model").asString());
			modelList.add(oe);
		}	
		//
		setModelsList(modelList);
	}

	/**
	 * @return
	 */
	public List getModelsList() {
		return modelsList;
	}

	/**
	 * @param list
	 */
	public void setModelsList(List list) {
		modelsList = list;
	}

	/**
	 * @return
	 */
	public String getIsComplectSelectProcess() {
		return isComplectSelectProcess;
	}

	/**
	 * @param string
	 */
	public void setIsComplectSelectProcess(String string) {
		isComplectSelectProcess = string;
	}

	/**
	 * @param list
	 */
	public void setCurComplectList(List list) {
		curComplectList = list;
	}

	public List getCurComplectList() {
		return curComplectList;
	}	


	/**
	 * @return
	 */
	public String getCurResourceOldRowClassName() {
		return curResourceOldRowClassName;
	}

	/**
	 * @return
	 */
	public String getCurResourceSelectedID() {
		return curResourceSelectedID;
	}

	/**
	 * @param string
	 */
	public void setCurResourceOldRowClassName(String string) {
		curResourceOldRowClassName = string;
	}

	/**
	 * @param string
	 */
	public void setCurResourceSelectedID(String string) {
		curResourceSelectedID = string;
	}

	/**
	 * @return
	 */
	public String getComplectLabel() {
		return complectLabel;
	}

	/**
	 * @return
	 */
	public String getSearchLabel() {
		return searchLabel;
	}

	/**
	 * @return
	 */
	public String getStructLabel() {
		return structLabel;
	}

	/**
	 * @param string
	 */
	public void setComplectLabel(String string) {
		complectLabel = string;
	}

	/**
	 * @param string
	 */
	public void setSearchLabel(String string) {
		searchLabel = string;
	}

	/**
	 * @param string
	 */
	public void setStructLabel(String string) {
		structLabel = string;
	}

	public static String getActionString(HttpSession theSession) {
		String sourceType = getSourceType(theSession);
		String action = "???";
		if (ConfPowerSourcesForm.ELAP_POWER_SOURCE_TYPE.equals(sourceType)) {
			action = "/ShowConfPowerSourcesElAp.do";
		} else if (ConfPowerSourcesForm.UZO_POWER_SOURCE_TYPE.equals(sourceType)) {
			action = "/ShowConfPowerSourcesUzo.do";
		} else if (ConfPowerSourcesForm.INST_COMPL_BASE_STATION_TYPE.equals(sourceType)) {
			action = "/ShowInstComplBaseStation.do";
		} 
		return action;
	}
	
	public static String getFormString(HttpSession theSession) {
		String sourceType = getSourceType(theSession);
		String form = "???";
		if (ConfPowerSourcesForm.ELAP_POWER_SOURCE_TYPE.equals(sourceType)) {
			form = "ConfPowerSourcesElApForm";
		} else if (ConfPowerSourcesForm.UZO_POWER_SOURCE_TYPE.equals(sourceType)) {
			form = "ConfPowerSourcesUzoForm";
		} else if (ConfPowerSourcesForm.INST_COMPL_BASE_STATION_TYPE.equals(sourceType)) {
			form = "ShowInstComplBaseStationForm";
		} 
		return form;
	}

	private static String getSourceType(HttpSession theSession) {
		String sourceType = (String)theSession.getAttribute(ConfPowerSourcesForm.POWER_SOURCE_TYPE_VAR);
		return sourceType;
	}

	public static boolean getIsElAp(HttpSession theSession) {
		String sourceType = getSourceType(theSession);
		return (ConfPowerSourcesForm.ELAP_POWER_SOURCE_TYPE.equals(sourceType));
	}

	public static boolean getIsUzo(HttpSession theSession) {
		String sourceType = getSourceType(theSession);
		return (ConfPowerSourcesForm.UZO_POWER_SOURCE_TYPE.equals(sourceType));
	}

	public static boolean getIsIkBs(HttpSession theSession) {
		String sourceType = getSourceType(theSession);
		return (ConfPowerSourcesForm.INST_COMPL_BASE_STATION_TYPE.equals(sourceType));
	}
	/**
	 * @return
	 */
	public String getModelTypeCode() {
		return modelTypeCode;
	}

	/**
	 * @param string
	 */
	public void setModelTypeCode(String string) {
		modelTypeCode = string;
	}

	/**
	 * @return
	 */
	public String getComplectTypeCode() {
		return complectTypeCode;
	}

	/**
	 * @param string
	 */
	public void setComplectTypeCode(String string) {
		complectTypeCode = string;
	}

	/**
	 * @return
	 */
	public Integer getResourceSetClassConst() {
		return resourceSetClassConst;
	}

	/**
	 * @param integer
	 */
	public void setResourceSetClassConst(Integer integer) {
		resourceSetClassConst = integer;
	}

	/**
	 * @return
	 */
	public String getIsCurComplectListExist() {
		List localCurCmplList = getCurComplectList();
		if ((localCurCmplList != null) && (localCurCmplList.size() > 0)) {
			return TRUE_STR;			
		} else {
			return FALSE_STR;					
		}
	}
	
	public List getSearchParameterList() {
		List locSearchParamList = new ArrayList();
		//
		OptionEntry oe = new OptionEntry();
		oe.setKey(ConfPowerSourcesForm.SRC_NFS);
		oe.setValue("коду НФС");
		locSearchParamList.add(oe);
		//
		oe = new OptionEntry();
		oe.setKey(ConfPowerSourcesForm.SRC_CMPL);
		oe.setValue("коду комплекта");
		locSearchParamList.add(oe);
		//
		oe = new OptionEntry();
		oe.setKey(ConfPowerSourcesForm.SRC_MODEL);
		oe.setValue("типу источника");
		locSearchParamList.add(oe);
		//
		return locSearchParamList;
	}

	/**
	 * @return
	 */
	public String getTitleSearchParam() {
		return titleSearchParam;
	}

	/**
	 * @param string
	 */
	public void setTitleSearchParam(String string) {
		titleSearchParam = string;
	}

}
