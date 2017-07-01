package com.hps.july.dictionary.formbean;

import java.util.Collections;

import org.apache.struts.action.*;

import com.hps.july.valueobject.AdminRegion_VO;
import com.hps.july.valueobject.Region_VO;
import com.hps.july.valueobject.SuperRegion_VO;
import com.hps.july.web.util.*;
import com.hps.july.cdbc.objects.CDBC_AdminRegionTypes_Object;
import com.hps.july.cdbc.objects.CDBC_AdminRegion_Object;
import com.hps.july.cdbc.objects.CDBC_Regions_Object;
import com.hps.july.cdbc.objects.CDBC_SuperRegions_Object;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence.*;
/**
* Insert the type's description here.
* Creation date: (05.10.2005 12:06:05)
* @author: Shafigullin Ildar
*/
public class RegionDialogForm extends com.hps.july.web.util.EditForm {
	private int id;
	private boolean flagOperation;
	private com.hps.july.valueobject.AdminRegion_VO vo;
	private com.hps.july.valueobject.AdminRegion_VO parentVO;
	private java.lang.Integer parentRegID;
	//Для Согласования С NRI:
	private java.util.List supRegList = null; //Collections.EMPTY_LIST
	private java.util.List filialNriList = Collections.EMPTY_LIST;
	private Integer supRegCode = null;

	private java.lang.String operation = "";
	/**
	 * Текущее приложение.
	 * Creation date: (05.10.2005 12:06:05)
	 * @return int
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.DICTIONARY;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 12:35:40)
	 * @return int
	 */
	public int getId() {
		return id;
	}
	/**
	 * Текущее состояние приложения.
	 * Creation date: (05.10.2005 12:06:05)
	 * @return int
	 */
	public int getState() {
		return com.hps.july.dictionary.APPStates.REGION_DIALOG;
	}
	/**
	 * Инициализация коллекций перед отображением пользователю.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
		setFlagOperation(false);
	}
	/**
	 * Инициализация полей в режиме добавления записи.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		int key = keyGen.getNextKey(com.hps.july.jdbcpersistence.lib.TablesRef.ADMIN_REGIONS);
		setId(key);
		vo = new AdminRegion_VO(new Integer(key));
		if (getParentRegID() != null && getParentRegID().intValue() != CDBC_AdminRegion_Object.NULL_PARENT_ID.intValue()) {
			vo.setParent_regionid(getParentRegID());
		} else {
			vo.setParent_regionid(null);
		}
		setSupRegCode(null);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 12:36:01)
	 * @return boolean
	 */
	public boolean isFlagOperation() {
		return flagOperation;
	}
	/**
	 * Метод загрузки данных в форму
	 * Creation date: (13.02.2002 10:12:41)
	 */
	public void loadRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		vo = CDBC_AdminRegion_Object.find(getId());
		if(vo.getParent_regionid() != null){
			parentVO = CDBC_AdminRegion_Object.find(vo.getParent_regionid().intValue());
		}else{
			parentVO = null;
		}
		if (vo.getFilialnri() != null) {
			Region_VO regVO = CDBC_Regions_Object.find(vo.getFilialnri());
			Integer aSupRegCode = regVO.getSupRegID();
			setSupRegCode(aSupRegCode);
		} else {
			setSupRegCode(null);
		}

	}
	/**
	 * Этот метод вызывается в режиме удаления записи.
	 * Creation date: (10.02.2004 14:01:52)
	 */
	public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
		boolean flag = CDBC_AdminRegion_Object.delete(getVo());
		return process(flag, errors);
	}
	/**
	 * Этот метод вызывается в режиме добавления записи.
	 * Creation date: (10.02.2004 14:06:40)
	 */
	public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
		boolean flag = CDBC_AdminRegion_Object.add(getVo());
		return process(flag, errors);
	}
	/**
	 * Этот метод вызывается в режиме изменения записи.
	 * Creation date: (10.02.2004 14:04:31)
	 */
	public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
		boolean flag = CDBC_AdminRegion_Object.edit(getVo());
		return process(flag, errors);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:24:59)
	 * @return java.lang.String
	 * @param flag boolean
	 */
	private String process(boolean ok, ActionErrors errors) {
		if (!ok) {
			String errorStr = "Ошибка CRUD операции : AdminRegion_VO:id" + getVo().getRegionid();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
			setFlagOperation(false);
		} else {
			setFlagOperation(true);
		}
		return "success";
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 12:36:01)
	 * @param newFlagOperation boolean
	 */
	public void setFlagOperation(boolean newFlagOperation) {
		flagOperation = newFlagOperation;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 12:35:40)
	 * @param newId int
	 */
	public void setId(int newId) {
		id = newId;
	}
	/**
	 * @return
	 */
	public com.hps.july.valueobject.AdminRegion_VO getVo() {
		return vo;
	}

	/**
	 * @param region_VO
	 */
	public void setVo(com.hps.july.valueobject.AdminRegion_VO region_VO) {
		vo = region_VO;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getParentRegID() {
		return parentRegID;
	}

	/**
	 * @param integer
	 */
	public void setParentRegID(java.lang.Integer integer) {
		parentRegID = integer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.08.2005 11:45:59)
	 * @return String
	 */
	public String getRegionareaStr() {
		if (vo != null && vo.getRegionarea() != null)
			return vo.getRegionarea().toString();
		else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.08.2005 11:45:59)
	 * @return String
	 */
	public String getRegionlatStr() {
		if (vo != null && vo.getRegionlat() != null)
			return vo.getRegionlat().toString();
		else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.08.2005 11:45:59)
	 * @return String
	 */
	public String getRegionlonStr() {
		if (vo != null && vo.getRegionlon() != null)
			return vo.getRegionlon().toString();
		else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.08.2005 11:45:59)
	 * @param newRegionarea String
	 */
	public void setRegionareaStr(String decimalStr) {
		if (vo != null && !decimalStr.equals(""))
			vo.setRegionarea(new java.math.BigDecimal(decimalStr));
	}
	/**
	 * @param String
	 */
	public void setRegionlatStr(String decimalStr) {
		if (vo != null && !decimalStr.equals(""))
			vo.setRegionlat(new java.math.BigDecimal(decimalStr));
	}

	/**
	 * @param String
	 */
	public void setRegionlonStr(String decimalStr) {
		if (vo != null && !decimalStr.equals(""))
			vo.setRegionlon(new java.math.BigDecimal(decimalStr));
	}
	/**
	 * @return
	 */
	public java.util.List getFilialNriList() {
		return filialNriList;
	}

	/**
	 * @return java.util.List
	 */
	public java.util.List getSupRegList() {
		if (supRegList == null)
			initSupRegList();
		return supRegList;
	}
	/**
	 * @return java.util.List
	 */
	public java.util.List getAdminRegionTypesList() {
		return CDBC_AdminRegionTypes_Object.getListAdminRegionTypes();
	}	
	/**
	 * @return
	 */
	private void initSupRegList() {
		java.util.List list =
			CDBC_SuperRegions_Object.getList(
				Boolean.FALSE,
				null,
				Boolean.FALSE,
				null,
				Boolean.FALSE,
				null,
				"supregname");
		setSupRegList(list);
		/**		
				if (list.size() > 0) {
					Integer supRegCode = ((SuperRegion_VO) getSupRegList().get(0)).getSupRegCode();
					setSupRegCode(supRegCode);
					initFilialNriList();
				}
		*/
	}

	/**
	 * @param list
	 */
	private void setFilialNriList(java.util.List list) {
		filialNriList = list;
	}

	/**
	 * @param list
	 */
	private void setSupRegList(java.util.List list) {
		supRegList = list;
	}

	/**
	 * @return
	 */
	public Integer getSupRegCode() {
		return supRegCode;
	}

	/**
	 * @param aSupRegCode
	 */
	public void setSupRegCode(Integer aSupRegCode) {
		supRegCode = aSupRegCode;
		initFilialNriList(aSupRegCode);
	}
	/**
	 * @return
	 */
	private void initFilialNriList(Integer aSupRegCode) {
		java.util.List list = Collections.EMPTY_LIST;
		if(aSupRegCode != null){
			list = CDBC_Regions_Object.getList(Boolean.FALSE, null, Boolean.TRUE, aSupRegCode, "regname");
		}
		setFilialNriList(list);
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#validateValues(org.apache.struts.action.ActionErrors)
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		//операция с "...":
		if (operation.equalsIgnoreCase("changeSupRegID")) {
			initFilialNriList(getSupRegCode());
			operation = "";
			throw new ValidationException();
		}
		//проверка кода KL_KLADR ?
		if(getVo().getKladrCode() != null){
			boolean hasKladrCode = CDBC_AdminRegion_Object.hasKladrCode(getVo().getKladrCode());
			if(!hasKladrCode){
				String errorStr = "Общероссийский классификатор адресов не найден!!!";
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));				
			}
		}
	}

	/**
	 * @return
	 */
	public java.lang.String getOperation() {
		return operation;
	}

	/**
	 * @param string
	 */
	public void setOperation(java.lang.String string) {
		operation = string;
	}

	/**
	 * @return
	 */
	public com.hps.july.valueobject.AdminRegion_VO getParentVO() {
		return parentVO;
	}

	/**
	 * @param region_VO
	 */
	private void setParentVO(com.hps.july.valueobject.AdminRegion_VO region_VO) {
		parentVO = region_VO;
	}

}
