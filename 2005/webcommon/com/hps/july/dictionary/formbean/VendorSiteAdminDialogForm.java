package com.hps.july.dictionary.formbean;

import java.util.*;

import org.apache.struts.action.*;
import org.apache.struts.taglib.template.GetTag;

import com.hps.july.valueobject.VendorSite_TO;
import com.hps.july.valueobject.VendorSite_VO;
import com.hps.july.valueobject.People_VO;
import com.hps.july.valueobject.Vendor_VO;
import com.hps.july.web.util.*;
import com.hps.july.cdbc.objects.CDBC_MapFactory;
import com.hps.july.cdbc.objects.CDBC_OwnerSystemNFS_Object;
import com.hps.july.cdbc.objects.CDBC_VendorSite_Object;
import com.hps.july.cdbc.objects.CDBC_Vendor_Object;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
/**
* Отделения поставщиков DialogForm.
* Creation date: (05.10.2005 12:06:05)
* @author: Shafigullin Ildar
*/
public class VendorSiteAdminDialogForm extends com.hps.july.web.util.EditForm {
	private int id;
	private boolean flagOperation;
	private VendorSite_TO to;
	private People_VO operatorVO;
	private int idVendor;
	private Vendor_VO vendor_VO;
	private java.util.List owners;
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
		return com.hps.july.dictionary.APPStates.VENDOR_SITE_ADMIN_DIALOG;
	}
	/**
	 * Инициализация коллекций перед отображением пользователю.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
		setFlagOperation(false);
		if (getOperatorVO() == null)
			setOperatorVO(CDBC_MapFactory.getPeopleVO_fromOperatorCode(request.getRemoteUser()));
		initOwners(request);
	}
	/**
	 * Инициализация полей в режиме добавления записи.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		int key = keyGen.getNextKey(com.hps.july.jdbcpersistence.lib.TablesRef.VENDORSITES);
		setId(key);
		VendorSite_VO vo = new VendorSite_VO(new Integer(key));
		vo.setVendorSiteCode("NRI");
		vo.setRecordStatus("A");
		vo.setSource(new Integer("2")); //редактируемые отделения
		vo.setUseInNri("Y");
		vo.setIdVendor(new Integer(getIdVendor()));
		vo.setIsOwnerContract("N"); //уточнить???
		to = new VendorSite_TO(vo);	
		initVendor_VO_and_CopyPropertyToVendorSite(getIdVendor(), vo);
	}
	/**
	 * 
	 * @param vendorID
	 * @param vo
	 */
	private void initVendor_VO_and_CopyPropertyToVendorSite(int vendorID, VendorSite_VO vo) {
		vendor_VO = CDBC_Vendor_Object.find(new Integer(vendorID));
		if(vendor_VO == null){
			//будет определен позже на форме(из справочника):
			vendor_VO = new Vendor_VO(null);
		}else{
			vo.setName(vendor_VO.getName());
			vo.setAddress(vendor_VO.getLegalAddress());
			vo.setFirstName(vendor_VO.getFirstName());
			vo.setLastName(vendor_VO.getLastName());
			vo.setMiddleName(vendor_VO.getMiddleName());
			vo.setPassportDate(vendor_VO.getPassportDate());
			vo.setPassportNum(vendor_VO.getPassportNum());
			vo.setPassportSer(vendor_VO.getPassportSer());
			vo.setPassportWhom(vendor_VO.getPassportWhom());
		}
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
		to = CDBC_VendorSite_Object.findTO(new Integer(getId()));
		setIdVendor(getTo().getVo().getIdVendor().intValue());
		vendor_VO = CDBC_Vendor_Object.find(getTo().getVo().getIdVendor());
	}
	/**
	 * Этот метод вызывается в режиме удаления записи.
	 * Creation date: (10.02.2004 14:01:52)
	 */
	public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		boolean ok = CDBC_VendorSite_Object.delete(new Integer(getId()));
		return process(ok, errors);
	}
	/**
	 * Этот метод вызывается в режиме добавления записи.
	 * Creation date: (10.02.2004 14:06:40)
	 */
	public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		CDBC_MapFactory.initDomainObject(getTo().getVo(), getOperatorVO());
		boolean ok = CDBC_VendorSite_Object.add(getTo().getVo());
		return process(ok, errors);
	}
	/**
	 * Этот метод вызывается в режиме изменения записи.
	 * Creation date: (10.02.2004 14:04:31)
	 */
	public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		CDBC_MapFactory.updateDomainObject(getTo().getVo(), getOperatorVO());
		boolean ok = CDBC_VendorSite_Object.edit(getTo().getVo());
		return process(ok, errors);
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
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:24:59)
	 * @return java.lang.String
	 * @param flag boolean
	 */
	private String process(boolean ok, ActionErrors errors) {
		if (!ok) {
			String errorStr = "Ошибка CRUD операции : VO:Id=" + getTo().getVo().getIdVendorSite();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
			setFlagOperation(false);
		} else {
			setFlagOperation(true);
		}
		return "success";
	}
	/**
	 * @return
	 */
	public People_VO getOperatorVO() {
		return operatorVO;
	}

	/**
	 * @param people_VO
	 */
	public void setOperatorVO(People_VO people_VO) {
		operatorVO = people_VO;
	}

	/**
	 * @return
	 */
	public VendorSite_TO getTo() {
		return to;
	}

	/**
	 * @param vendorSite_VO
	 */
	public void setTo(VendorSite_TO vendorSite_TO) {
		to = vendorSite_TO;
	}

	/**
	 * @return
	 */
	public int getIdVendor() {
		return idVendor;
	}

	/**
	 * @return
	 */
	public Vendor_VO getVendor_VO() {
		return vendor_VO;
	}

	/**
	 * @param i
	 */
	public void setIdVendor(int i) {
		idVendor = i;
	}

	/**
	 * @param vendor_VO
	 */
	private void setVendor_VO(Vendor_VO vendor_VO) {
		this.vendor_VO = vendor_VO;
	}

	/**
	 * @return
	 */
	public java.util.List getOwners() {
		return owners;
	}

	/**
	 * @param list
	 */
	private void setOwners(java.util.List list) {
		owners = list;
	}

	private void initOwners(javax.servlet.http.HttpServletRequest request) {
		setOwners(CDBC_OwnerSystemNFS_Object.getList(Boolean.FALSE, null , null));
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#validateValues(org.apache.struts.action.ActionErrors)
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		if(getTo().getVo().getIdOwnerNfs() == null){
			String errorStr = "Не указан OwnerNfs";
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));			
		}
		if (!errors.empty()) {
			throw new ValidationException();
		}
	}

}
