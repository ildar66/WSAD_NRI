/*
 * Created on 15.01.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.formbean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.hps.july.arenda.cdbcobjects.CDBC_Helper;
import com.hps.july.arenda.cdbcobjects.CDBC_CompletWorkActs_Object;
import com.hps.july.arenda.valueobject.CurrencyVO;
import com.hps.july.arenda.valueobject.CompletWorkAct_VO;
import com.hps.july.arenda.valueobject.PeopleVO;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBC_CompletWorkAkt2Charge_Object;
import com.hps.july.logic.DataPeriod;
import com.hps.july.persistence.CurrencyAccessBean;
import com.hps.july.valueobject.DomainObject;
import com.hps.july.valueobject.CompletWorkAkt2Charge_TO;
import com.hps.july.web.util.EditForm;
import com.hps.july.web.util.ValidationException;
import java.math.BigDecimal;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CompletWorkAktDialogForm extends EditForm {
	private int id;
	private boolean flagOperation;
	private com.hps.july.arenda.valueobject.CompletWorkAct_VO vo;
	private int idContract;
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
	private java.util.ArrayList currencies;
	private java.util.ArrayList cwa2charges; //список привязанных начислений
	private java.lang.String operation = "";
	private String[] linkSumCharge = new String[0];
	private static BigDecimal NULL_BD = new BigDecimal("0.00");
	private static BigDecimal ERROR_BD = new BigDecimal(-1);
	private PeopleVO operatorVO;
	private Integer codeLinkToCharge;
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 19:01:54)
	 */
	public CompletWorkAktDialogForm() {
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
		return com.hps.july.arenda.APPStates.COMPLET_WORK_AKT_DIALOG;
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
	public com.hps.july.arenda.valueobject.CompletWorkAct_VO getVo() {
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
	public void setVo(com.hps.july.arenda.valueobject.CompletWorkAct_VO fakt_VO) {
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
		CDBCRowObject ro = CDBC_CompletWorkActs_Object.findCompletWorkAct(getId());
		if (ro != null) {
			vo = new CompletWorkAct_VO(ro);
			vo.setCreatedByName(ro.getColumn("createdByName").asString());
			vo.setModifiedByName(ro.getColumn("modifiedByName").asString());
			setIdContract(vo.getIdContract().intValue());
			//устанавливаем ставку НДС:
			//calsRateNds();
		} else {
			System.out.println("Нет записи CompletWorkAct с idcwacode=" + getId());
			throw new Exception("Нет записи CompletWorkAct с idcwacode=" + getId());
		}
		//список привязанных начислений:
		setCwa2charges(CDBC_CompletWorkAkt2Charge_Object.getListForCWA(vo.getIdcwacode(), null));
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void initRecord(HttpServletRequest request) throws Exception {
		int key = new com.hps.july.commonbean.KeyGeneratorAccessBean().getNextKey("tables.CompletWorkActs");
		setId(key);
		vo = new CompletWorkAct_VO();
		vo.setIdcwacode(new Integer(key));
		vo.setActstate("O"); //редактируется
		vo.setIdContract(new Integer(getIdContract()));
		CDBC_CompletWorkActs_Object.initCompletWorkAct(getVo());
		//список привязанных начислений:
		setCwa2charges(new ArrayList());
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:24:59)
	 * @return java.lang.String
	 * @param flag boolean
	 */
	private String process(boolean ok, ActionErrors errors) {
		if (!ok) {
			String errorStr = "Ошибка CRUD операции : CompletWorkAct_VO:id" + getVo().getIdcwacode();
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
		//boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_CompletWorkActs_Object.delete(getVo());
		//return process(flag, errors);
		try {
			String errorStr = CDBC_CompletWorkActs_Object.delete(getVo().getIdcwacode());
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
	public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		CDBC_Helper.initDomainObject(getVo(), getOperatorVO());
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_CompletWorkActs_Object.addCompletWorkAct(getVo());
		if (flag) {
			processCWA2charges(errors);
		}
		return process(flag, errors);
	}

	/**
	 * Этот метод вызывается в режиме изменения записи.
	 * Creation date: (10.02.2004 14:04:31)
	 */
	public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		CDBC_Helper.updateDomainObject(getVo(), getOperatorVO());
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_CompletWorkActs_Object.editCompletWorkAct(getVo());
		if (flag && getVo().getActstate().equals("O")) {
			processCWA2charges(errors);
		}
		return process(flag, errors);
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @return java.lang.String
	 */
	public java.lang.String getDocdateStr() {
		if (getVo() != null && getVo().getDocdate() != null) {
			return format.format(new java.util.Date(getVo().getDocdate().getTime()));
		}
		return null;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @return java.lang.String
	 */
	public java.lang.String getActstartdateStr() {
		if (getVo() != null && getVo().getActstartdate() != null) {
			return format.format(new java.util.Date(getVo().getActstartdate().getTime()));
		}
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @return java.lang.String
	 */
	public java.lang.String getActenddateStr() {
		if (getVo() != null && getVo().getActenddate() != null) {
			return format.format(new java.util.Date(getVo().getActenddate().getTime()));
		}
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @param newDateActStr java.lang.String
	 */
	public void setDocdateStr(java.lang.String newDateStr) throws java.text.ParseException {
		if (newDateStr == null || newDateStr.trim().length() == 0) {
			getVo().setDocdate(null);
		} else {
			java.util.Date d = format.parse(newDateStr);
			getVo().setDocdate(new java.sql.Date(d.getTime()));
		}
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @param newDateActStr java.lang.String
	 */
	public void setActstartdateStr(java.lang.String newDateStr) throws java.text.ParseException {
		if (newDateStr == null || newDateStr.trim().length() == 0) {
			getVo().setActstartdate(null);
		} else {
			java.util.Date d = format.parse(newDateStr);
			getVo().setActstartdate(new java.sql.Date(d.getTime()));
		}
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @param newDateActStr java.lang.String
	 */
	public void setActenddateStr(java.lang.String newDateStr) throws java.text.ParseException {
		if (newDateStr == null || newDateStr.trim().length() == 0) {
			getVo().setActenddate(null);
		} else {
			java.util.Date d = format.parse(newDateStr);
			getVo().setActenddate(new java.sql.Date(d.getTime()));
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
	public java.util.ArrayList getCwa2charges() {
		return cwa2charges;
	}

	/**
	 * @param list
	 */
	private void setCwa2charges(java.util.ArrayList list) {
		cwa2charges = list;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#validateValues(org.apache.struts.action.ActionErrors)
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		//super.validateValues(errors);
		if (getOperation().equalsIgnoreCase("addCWA2charges")) {
			//операция "addCWA2charges":
			//errors.add("org.apache.struts.action.GLOBAL_WARNING", new ActionError("error.txt", "Добавлены начисления"));
			setOperation("");
			throw new ValidationException();
		} else if (getOperation().equalsIgnoreCase("deleteLinkToCharge")) {
			//операция "deleteLinkToCharge":
			deleteLinkToCharge();
			setOperation("");
			setCodeLinkToCharge(null);
			throw new ValidationException();
		} else if (getOperation().equalsIgnoreCase("computeDateAndPeriodCWA")) {
			//операция "Вычисляем дату и период CWA":
			DataPeriod periodCWA = computePeriodCWA(getCwa2charges());
			getVo().setActstartdate(periodCWA.getFromDate());
			getVo().setActenddate(periodCWA.getToDate());
			getVo().setDocdate(periodCWA.getToDate());
			//формируем "Наименование услуги":
			getVo().setNameWork(computeNameWork());
			
			setOperation("");
			throw new ValidationException();
		}

		if (!errors.empty()) {
			throw new ValidationException();
		}
	}
	
	/**
	 * 
	 * @return
	 */	
	private String computeNameWork(){
		String oldNameWorkStr = getVo().getNameWork();
		StringBuffer nameWork = null;
		try {
			int indexChange = oldNameWorkStr.indexOf(" с ");
			if(indexChange > 0){
				nameWork = new StringBuffer(oldNameWorkStr.substring(0, indexChange));//"Услуги по договору №T-3848ВК от 01.07.2005 за период с 01.10.2005 по 31.12.2005";				
			}else{
				nameWork = new StringBuffer(getContractInfo());//"Услуги по договору №T-3848ВК от 01.07.2005 за период с 01.10.2005 по 31.12.2005";
			}
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
			String startDateStr = format.format (getVo().getActstartdate());
			nameWork.append(" с " + startDateStr);
			String endDateStr = format.format (getVo().getActenddate());
			nameWork.append(" по " + endDateStr);
			oldNameWorkStr = nameWork.toString();		
		} catch (Exception e) {
			System.out.println("Ошибка computeNameWork()");
			e.printStackTrace();
		}
		return oldNameWorkStr;
	}
	
	/**
		 * Вычисляем период CWA
		 * @param aListCharges
		 */
	private DataPeriod computePeriodCWA(ArrayList aListCharges) {
		DataPeriod period = new DataPeriod();
		java.sql.Date fromDate = null;
		java.sql.Date toDate = null;
		for (Iterator iter = aListCharges.iterator(); iter.hasNext();) {
			CompletWorkAkt2Charge_TO to = (CompletWorkAkt2Charge_TO) iter.next();
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
	 * удаляем связь с начислением:
	 */
	private void deleteLinkToCharge() {
		CDBC_CompletWorkAkt2Charge_Object.delete(getVo().getIdcwacode(), getCodeLinkToCharge());
		for (Iterator iter = getCwa2charges().iterator(); iter.hasNext();) {
			CompletWorkAkt2Charge_TO to = (CompletWorkAkt2Charge_TO) iter.next();
			if (to.getChargeVO().getLeaseDocPosition().equals(getCodeLinkToCharge())) {
				getCwa2charges().remove(to);
				break;
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
	 * Cвязи с начислениями:
	 */
	private void processCWA2charges(ActionErrors errors) {
		//System.out.println("getLinkSumCharge.length=" + getLinkSumCharge().length); //temp
		//Введенные пользователем суммы для связей:		
		ArrayList linkSumChargeArray = getLinkSumChargeArray();
		//Введенные пользователем остатки начислений для связей:
		Iterator iter = getCwa2charges().iterator();
		for (int i = 0; iter.hasNext(); i++) {
			CompletWorkAkt2Charge_TO to = (CompletWorkAkt2Charge_TO) iter.next();
			BigDecimal linkSumCharge = (BigDecimal) linkSumChargeArray.get(i);
			//удаляем связь:
			if (linkSumCharge.equals(NULL_BD)) {
				CDBC_CompletWorkAkt2Charge_Object.delete(getVo().getIdcwacode(), to.getChargeVO().getLeaseDocPosition());
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
			BigDecimal retBD = CDBC_CompletWorkAkt2Charge_Object.find(getVo().getIdcwacode(), to.getChargeVO().getLeaseDocPosition());
			to.setLinkSumCharge(linkSumCharge);
			//добавление/изменение:
			if (retBD == null) {
				to.setIdCwaCode(getVo().getIdcwacode());
				CDBC_CompletWorkAkt2Charge_Object.add(to);
			} else {
				CDBC_CompletWorkAkt2Charge_Object.edit(to);
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

}
