package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;

import javax.servlet.*;
import java.io.*;
import java.sql.Date;

import javax.servlet.http.*;

import com.hps.july.web.util.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.arenda.cdbcobjects.CDBC_LeaseZPOfficeMemo_Object;
import com.hps.july.persistence.*;
import com.hps.july.cdbc.lib.*;
/**
 * Служебная записка по «Создание\Изменение ЗП» BrowseForm Object.
 * Creation date: (12.10.2005 15:40:48)
 * @author: Shafigullin Ildar
 */
public class LeaseZPOfficeMemoListForm extends com.hps.july.web.util.BrowseForm {
	private int idContract; //код договора(может быть доп. соглашения)
	private int filter;
	private String searchString;
	private java.lang.String sortBy; //признак сортировки
	//изменение состояния:
	private java.lang.Integer operatorCode;
	private java.lang.String operation = "";
	private int idCode = -1;
	private java.lang.String toState = "";
	//информация о договоре:
	private String docNumber;
	private Date docDate;
	private Integer mainLeaseContractKey;

	/**
	 * LeaseZPOfficeMemoListForm constructor comment.
	 */
	public LeaseZPOfficeMemoListForm() {
		super();

		setFilter(2);
		setSearchString("");
		setSortBy("dateStartZP desc");
	}
	/**
	 * Возвращает имя bean для броуза.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.arenda.cdbcobjects.CDBC_LeaseZPOfficeMemo_Object";
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:39:52)
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("ArendaMainEconomist");
		roles.add("ArendaEconomist");
		roles.add("administrator");
		return roles;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.10.2005 16:04:43)
	 * @return int
	 */
	public int getFilter() {
		return filter;
	}
	/**
	 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
	 * Creation date: (12.10.2005 15:40:48)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		return new Object[] { getMainLeaseContractKey(), new Integer(getFilter()) , getSearchString(), getSortBy()};
	}
	/**
	 * Возвращает имя метода поиска.
	 * Creation date: (22.01.2002 11:20:35)
	 * @return java.lang.String
	 */
	public java.lang.String getFinderMethodName() {
		return "getList";
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (12.10.2005 16:04:43)
	 * @return java.lang.String
	 */
	public java.lang.String getSearchString() {
		return searchString;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.10.2005 16:04:43)
	 * @return java.lang.String
	 */
	public java.lang.String getSortBy() {
		return sortBy;
	}
	/**
	 * Инициализация режима просмотра списка.
	 * Creation date: (22.05.2002 16:35:23)
	 * @return java.lang.Object
	 * @param o java.lang.Object
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.LEASE_ZP_OFFICE_MEMO_LIST);
		initAgreementInfo();
		if (getOperatorCode() == null)
			initOperatorCode(request);
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.10.2005 16:04:43)
	 * @param newFilter int
	 */
	public void setFilter(int newFilter) {
		filter = newFilter;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.10.2005 16:04:43)
	 * @param newSortBy java.lang.String
	 */
	public void setSortBy(java.lang.String newSortBy) {
		sortBy = newSortBy;
	}
	/**
	 * @param string
	 */
	public void setSearchString(String string) {
		searchString = string;
	}

	/**
	 * 
	 * @param request
	 */

	private void initOperatorCode(javax.servlet.http.HttpServletRequest request) {
		setOperatorCode(OperatorObject.getOperatorCode(request.getRemoteUser()));
	}
	/**
	 * 
	 * @param request
	
	
	private void initWorkerID(javax.servlet.http.HttpServletRequest request) {
		setWorkerID(CDBC_Helper.getWorkerID_fromRemoteUser(request.getRemoteUser()));
	}
	 */
	/**
	 * @return
	 */
	public java.lang.Integer getOperatorCode() {
		return operatorCode;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		operation = "";
		idCode = -1;
		toState = "";
	}
	/**
	 * @return
	 */
	public int getIdCode() {
		return idCode;
	}

	/**
	 * @return
	 */
	public java.lang.String getOperation() {
		return operation;
	}

	/**
	 * @return
	 */
	public java.lang.String getToState() {
		return toState;
	}

	/**
	 * @param i
	 */
	public void setIdCode(int i) {
		idCode = i;
	}

	/**
	 * @param string
	 */
	public void setOperation(java.lang.String string) {
		operation = string;
	}

	/**
	 * @param string
	 */
	public void setToState(java.lang.String string) {
		toState = string;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#validateValues(org.apache.struts.action.ActionErrors)
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		if (operation.equalsIgnoreCase("deleteItem")) {
			//deleteItem(errors);
		} else if (operation.equalsIgnoreCase("changeState")) {
			changeState(errors);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2004 14:45:13)
	 * @param errors org.apache.struts.action.ActionErrors
	 */
	private void changeState(ActionErrors errors) {
		String errorTxt = CDBC_LeaseZPOfficeMemo_Object.changeStateLeaseZPOfficeMemo(getIdCode(), getToState(), getOperatorCode().intValue());
		if (!errorTxt.equals("")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorTxt));
		}
	}

	/**
	 * @param integer
	 */
	public void setOperatorCode(java.lang.Integer integer) {
		operatorCode = integer;
	}

	/**
	 * @return
	 */
	public Date getDocDate() {
		return docDate;
	}

	/**
	 * @return
	 */
	public String getDocNumber() {
		return docNumber;
	}

	/**
	 * @return
	 */
	public Integer getMainLeaseContractKey() {
		return mainLeaseContractKey;
	}

	/**
	 * @param date
	 */
	private void setDocDate(Date date) {
		docDate = date;
	}

	/**
	 * @param string
	 */
	private void setDocNumber(String string) {
		docNumber = string;
	}

	/**
	 * @param integer
	 */
	private void setMainLeaseContractKey(Integer integer) {
		mainLeaseContractKey = integer;
	}
	/**
	 * Информация о договоре
	 */
	private void initAgreementInfo() {
		try {
			LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
			bean.setInitKey_leaseDocument(getIdContract());
			bean.refreshCopyHelper();
			LeaseArendaAgreementNewAccessBean beanMain = null;
			if (bean.getMainDocument() != null) {
				beanMain = new LeaseArendaAgreementNewAccessBean();
				beanMain.setInitKey_leaseDocument(bean.getMainDocument().intValue());
				beanMain.refreshCopyHelper();
			} else {
				beanMain = bean;
			}
			setMainLeaseContractKey(new Integer(beanMain.getLeaseDocument()));
			//если нужна доп инфо сделать как CompletWorkActsListForm:
			setDocNumber(beanMain.getDocumentNumber());
			setDocDate(beanMain.getDocumentDate());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ошибка initAgreement для getIdContract =" + getIdContract());
		}
	}

	/**
	 * @return
	 */
	public int getIdContract() {
		return idContract;
	}

	/**
	 * @param i
	 */
	public void setIdContract(int i) {
		idContract = i;
	}

}
