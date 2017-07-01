package com.hps.july.dictionary.formbean;

import org.apache.struts.action.*;

import com.hps.july.valueobject.*;
import com.hps.july.web.util.*;
import com.hps.july.cdbc.objects.CDBC_MapFactory;
import com.hps.july.cdbc.objects.CDBC_VendorSite_Object;
import com.hps.july.cdbc.objects.CDBC_Vendor_Object;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
/**
* Поставщики DialogForm.
* Creation date: (05.10.2005 12:06:05)
* @author: Shafigullin Ildar
*/
public class VendorAdminDialogForm extends com.hps.july.web.util.EditForm {
	private int id;
	private boolean flagOperation;
	private Vendor_TO to;
	private People_VO operatorVO;
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
		return com.hps.july.dictionary.APPStates.VENDOR_ADMIN_DIALOG;
	}
	/**
	 * Инициализация коллекций перед отображением пользователю.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
		setFlagOperation(false);
		if (getOperatorVO() == null)
			setOperatorVO(CDBC_MapFactory.getPeopleVO_fromOperatorCode(request.getRemoteUser()));
	}
	/**
	 * Инициализация полей в режиме добавления записи.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		int key = keyGen.getNextKey(com.hps.july.jdbcpersistence.lib.TablesRef.VENDORS);
		setId(key);
		Vendor_VO vo = new Vendor_VO(new Integer(key));
		vo.setRecordStatus("A");
		vo.setSource(new Integer("2")); //редактируемые организации
		vo.setUseInNri("Y");
		to = new Vendor_TO(vo);
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
		to = CDBC_Vendor_Object.findTO(new Integer(getId()));
	}
	/**
	 * Этот метод вызывается в режиме удаления записи.
	 * Creation date: (10.02.2004 14:01:52)
	 */
	public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		validateOnDelete(errors);
		boolean ok = CDBC_Vendor_Object.delete(new Integer(getId()));
		return process(ok, errors);
	}
	/**
	 * Этот метод вызывается в режиме добавления записи.
	 * Creation date: (10.02.2004 14:06:40)
	 */
	public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		CDBC_MapFactory.initDomainObject(getTo().getVo(), getOperatorVO());
		boolean ok = CDBC_Vendor_Object.add(getTo().getVo());
		return process(ok, errors);
	}
	/**
	 * Этот метод вызывается в режиме изменения записи.
	 * Creation date: (10.02.2004 14:04:31)
	 */
	public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		CDBC_MapFactory.updateDomainObject(getTo().getVo(), getOperatorVO());
		boolean ok = CDBC_Vendor_Object.edit(getTo().getVo());
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
			String errorStr = "Ошибка CRUD операции : vo:id=" + getTo().getVo().getIdVendor();
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
	public Vendor_TO getTo() {
		return to;
	}

	/**
	 * @param vendor_VO
	 */
	public void setTo(Vendor_TO vendor_TO) {
		to = vendor_TO;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#validateValues(org.apache.struts.action.ActionErrors)
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		if (getAction().equalsIgnoreCase(ACTION_ADD) && getTo().getVo().getTypeVendor().intValue() == Vendor_VO.TYPE_VENDOR_JURIDICAL && CDBC_Vendor_Object.isExistINN(getTo().getVo().getInn())) {
			String errorStr = "Не уникальный ИНН";
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
		}
		if (!errors.empty()) {
			throw new ValidationException();
		}
	}

	/**
	 * 
	 * @param errors
	 * @throws Exception
	 */

	public void validateOnDelete(ActionErrors errors) throws Exception {
		String errorStr = null;//информация об ошибке

		if (getTo().getVo().getSource().intValue() == Vendor_VO.SOURCE_NFS) {
			//проверка на источник поставщика(NRI - NFS):
			errorStr = "Нельзя удалять, т.к. Поставщик получен из системы НФС!";
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
		} else {
			//проверка на наличие отделений:
			java.util.List list = CDBC_VendorSite_Object.findList(Boolean.TRUE, getTo().getVo().getIdVendor(), Boolean.FALSE, null, Boolean.FALSE, null, Boolean.FALSE, Boolean.FALSE, null);
			if (list != null && list.size() > 0) {
				errorStr = "Нельзя удалять, т.к. Поставщик имеет отделение!";
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
			}
		}
		if (!errors.empty()) {
			throw new ValidationException();
		}
	}

}
