package com.hps.july.dictionary.formbean;

import java.util.*;

import org.apache.struts.action.*;

import com.hps.july.persistence.BankAccessBean;
import com.hps.july.valueobject.*;
import com.hps.july.web.util.*;
import com.hps.july.cdbc.objects.*;

import com.hps.july.commonbean.KeyGeneratorAccessBean;
/**
* Справочник расчетных счетов организаций DialogForm.
* Creation date: (05.10.2005 12:06:05)
* @author: Shafigullin Ildar
*/
public class AccountsDialogForm extends com.hps.july.web.util.EditForm {
	private int id;
	private boolean flagOperation;
	private Accounts_TO to;
	private People_VO operatorVO;
	private int idVendorSite;
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
		return com.hps.july.dictionary.APPStates.ACCOUNTS_DIALOG;
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
		int key = keyGen.getNextKey(com.hps.july.jdbcpersistence.lib.TablesRef.ACCOUNTS);
		setId(key);
		Accounts_VO vo = new Accounts_VO(new Integer(key));
		vo.setActive(Boolean.TRUE);
		vo.setIdVendorSite(new Integer(getIdVendorSite()));
		Accounts_TO accounts_TO = new Accounts_TO(vo);
		accounts_TO.setBank_VO(new Banks_VO(null));
		setTo(accounts_TO);
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
		Accounts_VO vo = CDBC_Accounts_Object.find(new Integer(getId()));
		setIdVendorSite(vo.getIdVendorSite().intValue());
		Accounts_TO accounts_TO = new Accounts_TO(vo);
		Banks_VO bank_VO = CDBC_Banks_Object.find(vo.getBank());
		accounts_TO.setBank_VO(bank_VO);
		setTo(accounts_TO);
	}
	/**
	 * Этот метод вызывается в режиме удаления записи.
	 * Creation date: (10.02.2004 14:01:52)
	 */
	public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		boolean ok = CDBC_Accounts_Object.delete(new Integer(getId()));
		return process(ok, errors);
	}
	/**
	 * Этот метод вызывается в режиме добавления записи.
	 * Creation date: (10.02.2004 14:06:40)
	 */
	public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		CDBC_MapFactory.initDomainObject(getTo().getVo(), getOperatorVO());
		boolean ok = CDBC_Accounts_Object.add(getTo().getVo());
		return process(ok, errors);
	}
	/**
	 * Этот метод вызывается в режиме изменения записи.
	 * Creation date: (10.02.2004 14:04:31)
	 */
	public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		CDBC_MapFactory.updateDomainObject(getTo().getVo(), getOperatorVO());
		boolean ok = CDBC_Accounts_Object.edit(getTo().getVo());
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
			String errorStr = "Ошибка CRUD операции : VO:Id=" + getTo().getVo().getAccountId();
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
	public int getIdVendorSite() {
		return idVendorSite;
	}

	/**
	 * @return
	 */
	public Accounts_TO getTo() {
		return to;
	}

	/**
	 * @param i
	 */
	public void setIdVendorSite(int i) {
		idVendorSite = i;
	}

	/**
	 * @param accounts_TO
	 */
	public void setTo(Accounts_TO accounts_TO) {
		to = accounts_TO;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#validateValues(org.apache.struts.action.ActionErrors)
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		if ((getTo().getVo().getAccount() == null) || (getTo().getVo().getAccount().length() == 0))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.account.value"));
		/** Логика построена на возможности ввести BIK произвольно*/
		if (getTo().getBank_VO().getBik() != null && !"".equals(getTo().getBank_VO().getBik().trim())) {
			try {
				//ServiceLocator serviceLocator = new ServiceLocator();
				//BankHome bankHome = (BankHome) serviceLocator.getRemoteHome(JNDINames.BANK, BankHome.class);
				//Bank bank = bankHome.findBankByBik(getBankbik());
				BankAccessBean bankAB = new BankAccessBean();
				BankAccessBean bankFinder = bankAB.findBankByBik(getTo().getBank_VO().getBik());
				if (bankFinder == null) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", "Банк не найден по BIK"));
				} else if (bankFinder.getRecordStatus().equals("D")) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", "Банк удален"));
				} else {
					getTo().getVo().setBank(bankFinder.getIdBank());
				}
			} catch (Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.account.bank"));
			}
		} else {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.account.bank"));
		}

		if (!errors.empty())
			throw new ValidationException();
	}

}
