/*
 * Created on 15.01.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.formbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.taglib.template.GetTag;

import com.hps.july.arenda.cdbcobjects.CDBC_Helper;
import com.hps.july.arenda.cdbcobjects.CDBC_SchetFact_Object;
import com.hps.july.arenda.valueobject.CurrencyVO;
import com.hps.july.arenda.valueobject.LeaseSchetFact_VO;
import com.hps.july.arenda.valueobject.PeopleVO;
import com.hps.july.cdbc.objects.CDBC_LeaseSchetFakt2Charge_Object;
import com.hps.july.logic.DataPeriod;
import com.hps.july.persistence.CurrencyAccessBean;
import com.hps.july.valueobject.DomainObject;
import com.hps.july.valueobject.LeaseSchetFakt2Charge_TO;
import com.hps.july.web.util.EditForm;
import com.hps.july.web.util.ValidationException;
import java.math.BigDecimal;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SchetFactDialogForm extends EditForm {
	private int id;
	private boolean flagOperation;
	private com.hps.july.arenda.valueobject.LeaseSchetFact_VO vo;
	private int idContract;
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
	private java.util.ArrayList currencies;
	private java.util.ArrayList leaseSF2charges; //список привязанных начислений
	private java.lang.String operation = "";
	private String[] linkSumCharge = new String[0];
	private static BigDecimal NULL_BD = new BigDecimal("0.00");
	private static BigDecimal ERROR_BD = new BigDecimal(-1);
	private PeopleVO operatorVO;
	private Integer codeLinkToCharge;
	private Integer idAkt;
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 19:01:54)
	 */
	public SchetFactDialogForm() {
		initCurrencies();
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getApplication()
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.ARENDA;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.SCHET_FACT_DIALOG;
	}

	/**
	 * @return
	 */
	public boolean isFlagOperation() {
		return flagOperation;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return
	 */
	public int getIdContract() {
		return idContract;
	}

	/**
	 * @return
	 */
	public com.hps.july.arenda.valueobject.LeaseSchetFact_VO getVo() {
		return vo;
	}

	/**
	 * @param b
	 */
	public void setFlagOperation(boolean b) {
		flagOperation = b;
	}

	/**
	 * @param i
	 */
	public void setId(int i) {
		id = i;
	}

	/**
	 * @param i
	 */
	public void setIdContract(int i) {
		idContract = i;
	}

	/**
	 * @param fakt_VO
	 */
	public void setVo(com.hps.july.arenda.valueobject.LeaseSchetFact_VO fakt_VO) {
		vo = fakt_VO;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initCollections(javax.servlet.http.HttpServletRequest)
	 */
	public void initCollections(HttpServletRequest request) throws Exception {
		setFlagOperation(false);
		if (operatorVO == null)
			operatorVO = CDBC_Helper.getPeopleVO_fromOperatorCode(request.getRemoteUser());
	}
	/**
	 * 
	 * @return String
	 */
	public String getContractInfo() {
		return CDBC_Helper.getContractInfo(getIdContract());
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#loadRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void loadRecord(HttpServletRequest request) throws Exception {
		vo = CDBC_SchetFact_Object.find(getId());
		setIdContract(getVo().getIdContract().intValue());
		setIdAkt(getVo().getIdAkt());
		setLeaseSF2charges(CDBC_LeaseSchetFakt2Charge_Object.getListForSchetFact(vo.getIdSchetFakt(), null));
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void initRecord(HttpServletRequest request) throws Exception {
		int key = new com.hps.july.commonbean.KeyGeneratorAccessBean().getNextKey("tables.leaseSchetFakt");
		setId(key);
		vo = new LeaseSchetFact_VO(new Integer(key));
		vo.setState("O"); //редактируется
		vo.setIdContract(new Integer(getIdContract()));
		vo.setIdAkt(getIdAkt());
		setLeaseSF2charges(new ArrayList());
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:24:59)
	 * @return java.lang.String
	 * @param flag boolean
	 */
	private String process(boolean ok, ActionErrors errors) {
		if (!ok) {
			String errorStr = "Ошибка CRUD операции : LeaseSchetFact_VO:id" + getVo().getIdSchetFakt();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
			setFlagOperation(false);
		} else {
			setFlagOperation(true);
		}
		return "success";
	}
	/**
	 * Этот метод вызывается в режиме удаления записи.
	 * Creation date: (10.02.2004 14:01:52)
	 */
	public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
		//boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_SchetFact_Object.delete(getVo());
		//return process(flag, errors);
		try {
			String errorStr = CDBC_SchetFact_Object.delete(getVo().getIdSchetFakt());
			if (errorStr != null) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
				setFlagOperation(false);
			} else {
				setFlagOperation(true);
			}
		} catch (Exception e) {
			System.out.println(this.getClass() + ".processDelete:errorTxt: " + e);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
			e.printStackTrace();
		}
		return "success";
	}

	/**
	 * Этот метод вызывается в режиме добавления записи.
	 * Creation date: (10.02.2004 14:06:40)
	 */
	public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
		CDBC_Helper.initDomainObject(getVo(), getOperatorVO());
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_SchetFact_Object.add(getVo());
		if (flag) {
			processLeaseSF2charges(errors);
		}
		return process(flag, errors);
	}

	/**
	 * Этот метод вызывается в режиме изменения записи.
	 * Creation date: (10.02.2004 14:04:31)
	 */
	public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
		CDBC_Helper.updateDomainObject(getVo(), getOperatorVO());
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_SchetFact_Object.edit(getVo());
		if (flag && getVo().getState().equals("O")) {
			processLeaseSF2charges(errors);
		}
		return process(flag, errors);
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @return java.lang.String
	 */
	public java.lang.String getDateSchetFaktStr() {
		if (getVo() != null && getVo().getDateSchetFakt() != null) {
			return format.format(new java.util.Date(getVo().getDateSchetFakt().getTime()));
		}
		return null;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @return java.lang.String
	 */
	public java.lang.String getDateStartSfStr() {
		if (getVo() != null && getVo().getDateStartSf() != null) {
			return format.format(new java.util.Date(getVo().getDateStartSf().getTime()));
		}
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @return java.lang.String
	 */
	public java.lang.String getDateEndSfStr() {
		if (getVo() != null && getVo().getDateEndSf() != null) {
			return format.format(new java.util.Date(getVo().getDateEndSf().getTime()));
		}
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @param newDateActStr java.lang.String
	 */
	public void setDateSchetFaktStr(java.lang.String newDateStr) throws java.text.ParseException {
		if (newDateStr == null || newDateStr.trim().length() == 0) {
			getVo().setDateSchetFakt(null);
		} else {
			java.util.Date d = format.parse(newDateStr);
			getVo().setDateSchetFakt(new java.sql.Date(d.getTime()));
		}
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @param newDateActStr java.lang.String
	 */
	public void setDateStartSfStr(java.lang.String newDateStr) throws java.text.ParseException {
		if (newDateStr == null || newDateStr.trim().length() == 0) {
			getVo().setDateStartSf(null);
		} else {
			java.util.Date d = format.parse(newDateStr);
			getVo().setDateStartSf(new java.sql.Date(d.getTime()));
		}
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @param newDateActStr java.lang.String
	 */
	public void setDateEndSfStr(java.lang.String newDateStr) throws java.text.ParseException {
		if (newDateStr == null || newDateStr.trim().length() == 0) {
			getVo().setDateEndSf(null);
		} else {
			java.util.Date d = format.parse(newDateStr);
			getVo().setDateEndSf(new java.sql.Date(d.getTime()));
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 19:02:34)
	 */
	private void initCurrencies() {
		try {
			ArrayList listCurrencies = new ArrayList();
			CurrencyAccessBean bean = new CurrencyAccessBean();
			Enumeration enum = bean.findAllOrderByNameAsc();
			while (enum.hasMoreElements()) {
				CurrencyAccessBean ab = (CurrencyAccessBean) enum.nextElement();
				CurrencyVO vo = new CurrencyVO(new Integer(ab.getCurrency()));
				vo.setName(ab.getName());
				listCurrencies.add(vo);
			}
			setCurrencies(listCurrencies);
		} catch (Exception e) {
			System.out.println("SchetFactDialogForm.initCurrencies(): Ошибка формирования листа валют!!!");
			e.printStackTrace(System.out);
		}
	}
	/**
	 * @return
	 */
	public java.util.ArrayList getCurrencies() {
		return currencies;
	}

	/**
	 * @param list
	 */
	private void setCurrencies(java.util.ArrayList list) {
		currencies = list;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:42:13)
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("ArendaMainEconomist");
		roles.add("ArendaEconomist");
		roles.add("administrator");
		return roles;
	}
	/**
	 * @return
	 */
	public java.util.ArrayList getLeaseSF2charges() {
		return leaseSF2charges;
	}

	/**
	 * @param list
	 */
	private void setLeaseSF2charges(java.util.ArrayList list) {
		leaseSF2charges = list;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#validateValues(org.apache.struts.action.ActionErrors)
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		//super.validateValues(errors);
		System.out.println("операция для СФ: " + getOperation()); //temp
		if (getOperation().equalsIgnoreCase("addLeaseSF2charges")) {
			//операция "добавляем связь с начислением":
			//errors.add("org.apache.struts.action.GLOBAL_WARNING", new ActionError("error.txt", "Добавлены начисления"));
			setOperation("");
			throw new ValidationException();
		} else if (getOperation().equalsIgnoreCase("deleteLinkToCharge")) {
			//операция "удаляем связь с начислением":
			deleteLinkToCharge();
			setOperation("");
			setCodeLinkToCharge(null);
			throw new ValidationException();
		} else if (getOperation().equalsIgnoreCase("computePeriodSF")) {
			//операция "Вычисляем период SF":
			DataPeriod periodSF = computePeriodSF(getLeaseSF2charges());
			getVo().setDateStartSf(periodSF.getFromDate());
			getVo().setDateEndSf(periodSF.getToDate());
			setOperation("");
			throw new ValidationException();
		} else if (getOperation().equalsIgnoreCase("computeDateSF")) {
			//операция "Вычисляем дату SF":
			DataPeriod periodSF = computePeriodSF(getLeaseSF2charges());
			getVo().setDateSchetFakt(periodSF.getToDate());
			setOperation("");
			throw new ValidationException();
		} else if (getOperation().equalsIgnoreCase("computeDateAndPeriodSF")) {
			//операция "Вычисляем дату и период SF":
			DataPeriod periodSF = computePeriodSF(getLeaseSF2charges());
			getVo().setDateStartSf(periodSF.getFromDate());
			getVo().setDateEndSf(periodSF.getToDate());			
			getVo().setDateSchetFakt(periodSF.getToDate());
			setOperation("");
			throw new ValidationException();
		}

		if (!errors.empty()) {
			throw new ValidationException();
		}
	}
	/**
	 * удаляем связь с начислением:
	 */
	private void deleteLinkToCharge() {
		CDBC_LeaseSchetFakt2Charge_Object.delete(getVo().getIdSchetFakt(), getCodeLinkToCharge());
		for (Iterator iter = getLeaseSF2charges().iterator(); iter.hasNext();) {
			LeaseSchetFakt2Charge_TO to = (LeaseSchetFakt2Charge_TO) iter.next();
			if (to.getChargeVO().getLeaseDocPosition().equals(getCodeLinkToCharge())) {
				getLeaseSF2charges().remove(to);
				break;
			}
		}
	}

	/**
	 * Вычисляем период SF
	 * @param aListCharges
	 */
	private DataPeriod computePeriodSF(ArrayList aListCharges) {
		DataPeriod period = new DataPeriod();
		java.sql.Date fromDate = null;
		java.sql.Date toDate = null;
		for (Iterator iter = aListCharges.iterator(); iter.hasNext();) {
			LeaseSchetFakt2Charge_TO to = (LeaseSchetFakt2Charge_TO) iter.next();
			if (fromDate == null) {
				fromDate = to.getChargeVO().getBeginDate();
			} else {
				if (fromDate.after(to.getChargeVO().getBeginDate())) {
					fromDate = to.getChargeVO().getBeginDate();
				}
			}
			if (toDate == null) {
				toDate = to.getChargeVO().getEndDate();
			} else {
				if (toDate.before(to.getChargeVO().getEndDate())) {
					toDate = to.getChargeVO().getEndDate();
				}
			}
		}
		period.setFromDate(fromDate);
		period.setToDate(toDate);
		return period;
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
	 * Cвязи с начислениями:
	 */
	private void processLeaseSF2charges(ActionErrors errors) {
		//System.out.println("getLinkSumCharge.length=" + getLinkSumCharge().length); //temp
		//Введенные пользователем суммы для связей:		
		ArrayList linkSumChargeArray = getLinkSumChargeArray();
		//Введенные пользователем остатки начислений для связей:
		Iterator iter = getLeaseSF2charges().iterator();
		for (int i = 0; iter.hasNext(); i++) {
			LeaseSchetFakt2Charge_TO to = (LeaseSchetFakt2Charge_TO) iter.next();
			BigDecimal linkSumCharge = (BigDecimal) linkSumChargeArray.get(i);
			//удаляем связь:
			if (linkSumCharge.equals(NULL_BD)) {
				CDBC_LeaseSchetFakt2Charge_Object.delete(getVo().getIdSchetFakt(), to.getChargeVO().getLeaseDocPosition());
				continue;
			}
			//пропускаем неправильный Ввод пользователя для связи:
			if (linkSumCharge.equals(ERROR_BD)) {
				continue;
			}
			/**			
						//корректируем превышение остатка Ввод пользователя для связи:
						if (linkSumCharge.compareTo(to.getChargeVO().getOstSumForSF()) > 0) {
							linkSumCharge = to.getChargeVO().getOstSumForSF();
						}
			*/
			//СУЩЕСТВУЕТ ЛИ СВЯЗЬ в БД?
			BigDecimal retBD = CDBC_LeaseSchetFakt2Charge_Object.find(getVo().getIdSchetFakt(), to.getChargeVO().getLeaseDocPosition());
			to.setLinkSumCharge(linkSumCharge);
			//добавление/изменение:
			if (retBD == null) {
				to.setIdSchetfakt(getVo().getIdSchetFakt());
				CDBC_LeaseSchetFakt2Charge_Object.add(to);
			} else {
				CDBC_LeaseSchetFakt2Charge_Object.edit(to);
			}
		}

	}

	/**
	 * @return
	 */
	public String[] getLinkSumCharge() {
		return linkSumCharge;
	}

	/**
	 * @param strings
	 */
	public void setLinkSumCharge(String[] strings) {
		linkSumCharge = strings;
	}

	/**
	 * 
	 */
	private ArrayList getLinkSumChargeArray() {
		ArrayList linkSumChargeArray = new ArrayList(getLinkSumCharge().length);
		for (int i = 0; i < getLinkSumCharge().length; i++) {
			try {
				linkSumChargeArray.add(new BigDecimal(getLinkSumCharge()[i]).abs());
			} catch (Exception e) {
				if (!"".equals(getLinkSumCharge()[i].trim()))
					linkSumChargeArray.add(ERROR_BD); //признак ошибки ввода
				else
					linkSumChargeArray.add(NULL_BD); //признак Удаления записи
			}
		}
		return linkSumChargeArray;
	}

	/**
	 * @return
	 */
	private PeopleVO getOperatorVO() {
		return operatorVO;
	}

	/**
	 * @param peopleVO
	 */
	private void setOperatorVO(PeopleVO peopleVO) {
		operatorVO = peopleVO;
	}

	/**
	 * @return
	 */
	public Integer getCodeLinkToCharge() {
		return codeLinkToCharge;
	}

	/**
	 * @param i
	 */
	public void setCodeLinkToCharge(Integer i) {
		codeLinkToCharge = i;
	}

	/**
	 * @return
	 */
	public Integer getIdAkt() {
		return idAkt;
	}

	/**
	 * @param integer
	 */
	public void setIdAkt(Integer integer) {
		idAkt = integer;
	}

}
