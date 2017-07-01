package com.hps.july.dictionary.formbean;

import org.apache.struts.action.*;

import com.hps.july.valueobject.Banks_VO;
import com.hps.july.valueobject.People_VO;
import com.hps.july.web.util.*;
import com.hps.july.cdbc.objects.CDBC_Banks_Object;
import com.hps.july.cdbc.objects.CDBC_MapFactory;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence.*;
/**
* Insert the type's description here.
* Creation date: (05.10.2005 12:06:05)
* @author: Shafigullin Ildar
*/
public class BanksDialogForm extends com.hps.july.web.util.EditForm {
	private int id;
	private boolean flagOperation;
	private Banks_VO bank;
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
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 12:36:47)
	 * @return Banks_VO
	 */
	public Banks_VO getBank() {
		return bank;
	}
	/**
	 * Текущее состояние приложения.
	 * Creation date: (05.10.2005 12:06:05)
	 * @return int
	 */
	public int getState() {
		return com.hps.july.dictionary.APPStates.BANKS_DIALOG;
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
		int key = keyGen.getNextKey(com.hps.july.jdbcpersistence.lib.TablesRef.BANKS);
		setId(key);
		bank = new Banks_VO(new Integer(key));
		bank.setRecordStatus("A");
		bank.setSource(new Integer("2"));//редактируемые банки
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
		bank = CDBC_Banks_Object.find(new Integer(getId()));
	}
	/**
	 * Этот метод вызывается в режиме удаления записи.
	 * Creation date: (10.02.2004 14:01:52)
	 */
	public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		boolean ok = CDBC_Banks_Object.delete(new Integer(getId()));
		return process(ok, errors);
	}
	/**
	 * Этот метод вызывается в режиме добавления записи.
	 * Creation date: (10.02.2004 14:06:40)
	 */
	public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		CDBC_MapFactory.initDomainObject(getBank(), getOperatorVO());
		boolean ok = CDBC_Banks_Object.add(getBank());
		return process(ok, errors);
	}
	/**
	 * Этот метод вызывается в режиме изменения записи.
	 * Creation date: (10.02.2004 14:04:31)
	 */
	public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		CDBC_MapFactory.updateDomainObject(getBank(), getOperatorVO());
		boolean ok = CDBC_Banks_Object.edit(getBank());
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
	 * Creation date: (05.10.2005 12:36:47)
	 * @param newBank com.hps.july.dictionary.valueobject.Bank_VO
	 */
	public void setBank(Banks_VO newBank) {
		bank = newBank;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:24:59)
	 * @return java.lang.String
	 * @param flag boolean
	 */
	private String process(boolean ok, ActionErrors errors) {
		if (!ok) {
			String errorStr = "Ошибка CRUD операции : AdminRegion_VO:id" + getBank().getIdBank();
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

}
