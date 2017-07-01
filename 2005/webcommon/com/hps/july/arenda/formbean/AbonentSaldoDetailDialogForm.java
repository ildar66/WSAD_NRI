/*
 * Created on 15.01.2006
 *
 * "Сальдо для договоров аренды" EditForm
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.hps.july.arenda.cdbcobjects.CDBC_Helper;
import com.hps.july.arenda.cdbcobjects.CDBC_SaldoDetailsObject;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.cdbc.objects.CDBC_MapFactory;
import com.hps.july.persistence.NamedValueAccessBean;
import com.hps.july.persistence.ResourceAccessBean;
import com.hps.july.persistence.ResourceSubTypeKey;
import com.hps.july.web.util.*;
import java.util.*;

/**
 * @author IShaffigulin
 *
 * "Сальдо для договоров аренды" EditForm
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AbonentSaldoDetailDialogForm extends EditForm {
	private int id = -1;
	private boolean flagOperation = false;
	private SaldoDetail_TO to = null;
	private int idContract = -1;
	private java.util.List currencies = null;
	private java.util.List resources = null;
	private java.lang.String operation = "";
	private PeopleVO operatorVO;
	public final static String NULL_STR = "0";
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 19:01:54)
	 */
	public AbonentSaldoDetailDialogForm() {
		setCurrencies(CDBC_MapFactory.getListCurrencies());
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
		return com.hps.july.arenda.APPStates.ABONENT_SALDO_DETAIL_DIALOG;
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
	
	public String getContractInfo() {
		return CDBC_Helper.getContractInfo(getIdContract());
	}
	 */
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#loadRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void loadRecord(HttpServletRequest request) throws Exception {
		to = CDBC_SaldoDetailsObject.findTO(getId());
		setIdContract(getTo().getVo().getLeaseContract().intValue());
		initResources(new Integer(getIdContract()));
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void initRecord(HttpServletRequest request) throws Exception {
		initResources(new Integer(getIdContract()));
		int key = new com.hps.july.commonbean.KeyGeneratorAccessBean().getNextKey("tables.leaseSaldoDetail");
		setId(key);
		to = new SaldoDetail_TO(new SaldoDetail_VO(new Integer(key)));
		to.getVo().setSalDate(new java.sql.Date(System.currentTimeMillis()));
		to.getVo().setOperator(getOperatorVO().getOperatorCode());
		to.getVo().setLeaseContract(new Integer(getIdContract()));
		to.getVo().setSaldoByHand("Y");
		to.setRateNds("18"); //temp
	}

	/**
	 * 
	 * @param request
	 * @param errors
	 * @param operation
	 * @return
	 */
	private String process(javax.servlet.http.HttpServletRequest request, ActionErrors errors, String operation) {
		try {
			String errorStr = com.hps.july.arenda.cdbcobjects.CDBC_SaldoDetailsObject.procedure(getTo().getVo(), getOperatorVO().getOperatorCode(), operation);
			if (errorStr != null) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
				setFlagOperation(false);
			} else {
				setId(getTo().getVo().getIdSldDetail().intValue());
				setFlagOperation(true);
			}
		} catch (Exception e) {
			System.out.println("SaldoDetailDialogForm.process():errorTxt: " + e);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * Этот метод вызывается в режиме удаления записи.
	 * Creation date: (10.02.2004 14:01:52)
	 */
	public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
		return process(request, errors, "D");
	}

	/**
	 * Этот метод вызывается в режиме добавления записи.
	 * Creation date: (10.02.2004 14:06:40)
	 */
	public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
		return process(request, errors, "I");
	}

	/**
	 * Этот метод вызывается в режиме изменения записи.
	 * Creation date: (10.02.2004 14:04:31)
	 */
	public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
		return process(request, errors, "U");
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @param newDateActStr java.lang.String
	public void setDateEndSfStr(java.lang.String newDateStr) throws java.text.ParseException {
		if (newDateStr == null || newDateStr.trim().length() == 0) {
			getVo().setDateEndSf(null);
		} else {
			java.util.Date d = format.parse(newDateStr);
			getVo().setDateEndSf(new java.sql.Date(d.getTime()));
		}
	}
	*/
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 19:02:34)
	
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
	public java.util.List getCurrencies() {
		return currencies;
	}

	/**
	 * @param list
	 */
	private void setCurrencies(java.util.List list) {
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
	 * @param aIdContract
	 */
	public void initResources(Integer aIdContract) {
		try {
			ArrayList listResources = new ArrayList();
			Vector v = new Vector();
			v.addElement(aIdContract);
			NamedValueAccessBean bean = new NamedValueAccessBean();
			bean.setInitKey_id("ARENDA_TYPE");
			bean.refreshCopyHelper();
			Enumeration enum =
				new ResourceAccessBean().findResourcesByQBE(new Boolean(true), new ResourceSubTypeKey(bean.getIntvalue()), new Boolean(false), null, new Boolean(false), null, new Integer(3));
			while (enum.hasMoreElements()) {
				ResourceAccessBean ab = (ResourceAccessBean) enum.nextElement();
				ResourceVO vo = new ResourceVO(new Integer(ab.getResource()));
				vo.setName(ab.getName());
				listResources.add(vo);
			}
			setResources(listResources);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" initResources(): Ошибка формирования листа ресурсов!!!");
		}
	}

	/**
	 * @return
	 */
	public java.util.List getResources() {
		return resources;
	}

	/**
	 * @param list
	 */
	private void setResources(java.util.List list) {
		resources = list;
	}

	/**
	 * @return
	 */
	public SaldoDetail_TO getTo() {
		return to;
	}

	/**
	 * @param detail_TO
	 */
	public void setTo(SaldoDetail_TO detail_TO) {
		to = detail_TO;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#validateValues(org.apache.struts.action.ActionErrors)
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		//super.validateValues(errors);
		if (getTo().getGroupRec().booleanValue()) {
			getTo().setRateNds(NULL_STR);
			getTo().setMainNdsSum(NULL_STR);
			getTo().setAdditionalNdsSum(NULL_STR);
		}
		if (new Integer(NULL_STR).equals(getTo().getVo().getAdditionalCurrency())) {
			getTo().setAdditionalNdsSum(NULL_STR);
			getTo().setAdditionalSum(NULL_STR);
		}
	}

}
