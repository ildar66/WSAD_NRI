package com.hps.july.arenda.formbean;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.arenda.APPStates;
import com.hps.july.arenda.cdbcobjects.CDBC_SchetFact_Object;
import com.hps.july.constants.Applications;
import com.hps.july.persistence.LeaseArendaAgreementNewAccessBean;
import com.hps.july.persistence.OperatorObject;
import com.hps.july.web.util.ParamsParser;
/**
 * Insert the type's description here.
 * Creation date: (07.11.2005 11:56:14)
 * @author: Shafigullin Ildar
 */
public class SchetFactForChargeListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String sortBy;
	//private int idContract;
	private java.lang.String operation = "";
	private int idCode = -1;
	private java.lang.String toState = "";
	private java.lang.String type = "D";//Вид счет-фактуры для печати = "Определять по дате"
	//private String docNumber;
	//private Date docDate;
	private java.lang.Integer operatorCode;
	//private	Integer mainLeaseContractKey;
	private int chargeCode;//код начисления
	private Integer idPosSchetFakt;//Код сформированной сч\ф
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:08:01)
	 */
	public SchetFactForChargeListForm() {
		setSortBy("dateSchetFakt desc");
		setFinderMethodName("getListForCharge");
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2004 14:45:13)
	 * @param errors org.apache.struts.action.ActionErrors
	 */
	private void changeState(ActionErrors errors) {
		String errorTxt = CDBC_SchetFact_Object.changeState(getIdCode(), getToState(), getOperatorCode().intValue());
		if (!errorTxt.equals("")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorTxt));
		}
	}
	/**
	 * Возвращает имя bean для броуза.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.arenda.cdbcobjects.CDBC_SchetFact_Object";
	}
	/**
	 * Текущее приложение.
	 * Creation date: (07.11.2005 11:56:14)
	 * @return int
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.ARENDA;
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
		roles.add("ArendaManager");
		roles.add("ArendaMainManager");
		return roles;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:06:34)
	 * @return int

	public int getIdContract() {
		return idContract;
	}
	 */	
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:04:33)
	 * @return java.lang.String
	 */
	public java.lang.String getSortBy() {
		return sortBy;
	}
	/**
	 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
	 * Creation date: (25.10.2004 17:43:54)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		return new Object[] { new Integer(getChargeCode()), getSortBy()};
	}
	
	/**
	 * Инициализация режима просмотра списка.
	 * Creation date: (22.05.2002 16:35:23)
	 * @return java.lang.Object
	 * @param o java.lang.Object
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.SCHET_FACT_FOR_CHARGE_LIST);
		//initAgreementInfo();
		if (getOperatorCode() == null)
			initOperatorCode(request);
		return null;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:06:34)
	 * @param newLoanContract int

	public void setIdContract(int newLoanContract) {
		idContract = newLoanContract;
	}
	 */	
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:04:33)
	 * @param newSortBy java.lang.String
	 */
	public void setSortBy(java.lang.String newSortBy) {
		sortBy = newSortBy;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		operation = "";
		idCode = -1;
		toState = "";
		//docNumber = null;
		//docDate = null;
		chargeCode = -1;
		idPosSchetFakt = null;
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
	/**
	 * Метод для проверки правильности введеных значений.
	 * Creation date: (22.02.2002 17:29:04)
	 * @exception com.hps.july.web.util.ValidationException The exception description.
	 */
	public void validateValues(org.apache.struts.action.ActionErrors errors) throws Exception {
		if (operation.equalsIgnoreCase("createSF")) {
			createSF(errors);
		} else if (operation.equalsIgnoreCase("changeState")) {
			changeState(errors);
		}
	}

	/**
	 * @return
	 */
	public java.lang.String getType() {
		return type;
	}

	/**
	 * @param string
	 */
	public void setType(java.lang.String string) {
		type = string;
	}

	/**
	 * @return

	public Date getDocDate() {
		return docDate;
	}
	 */
	/**
	 * @return

	public String getDocNumber() {
		return docNumber;
	}
	 */
	/**
	 * @param date

	public void setDocDate(Date date) {
		docDate = date;
	}
	 */
	/**
	 * @param string

	public void setDocNumber(String string) {
		docNumber = string;
	}
	
	private void initAgreementInfo(){
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
			//setMainLeaseContractKey(new Integer(beanMain.getLeaseDocument()));				
			//если нужна доп инфо сделать как CompletWorkActsListForm:
			//setDocNumber(beanMain.getDocumentNumber());
			//setDocDate(beanMain.getDocumentDate());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ошибка initAgreement для getIdContract =" + getIdContract());
		}
	}
	 */
	/**
	 * @return
	 */
	private java.lang.Integer getOperatorCode() {
		return operatorCode;
	}

	/**
	 * @param integer
	 */
	private void setOperatorCode(java.lang.Integer integer) {
		operatorCode = integer;
	}
	/**
	 * 
	 * @param request
	 */

	private void initOperatorCode(javax.servlet.http.HttpServletRequest request) {
		setOperatorCode(OperatorObject.getOperatorCode(request.getRemoteUser()));
	}	

	/**
	 * @return

	public Integer getMainLeaseContractKey() {
		return mainLeaseContractKey;
	}
	 */
	/**
	 * @param integer

	private void setMainLeaseContractKey(Integer integer) {
		mainLeaseContractKey = integer;
	}
	 */	
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2004 14:45:13)
	 * @param errors org.apache.struts.action.ActionErrors
	 */	
	private void createSF(ActionErrors errors) {
		Object[] values = CDBC_SchetFact_Object.prepareShetFact(getChargeCode(), -1, getOperatorCode().intValue());
		Integer result = (Integer)values[0];//Признак ошибки (0 без ошибок)
		if (result.intValue() != 0) {
			String errorTxt = (String)values[1];
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorTxt));
			setIdPosSchetFakt(null);//Признак ошибки
		}else{
			setIdPosSchetFakt((Integer)values[2]);		
		}
	}

	/**
	 * @return
	 */
	public int getChargeCode() {
		return chargeCode;
	}

	/**
	 * @param i
	 */
	public void setChargeCode(int i) {
		chargeCode = i;
	}

	/**
	 * @return
	 */
	public Integer getIdPosSchetFakt() {
		return idPosSchetFakt;
	}

	/**
	 * @param i
	 */
	private void setIdPosSchetFakt(Integer i) {
		idPosSchetFakt = i;
	}

}
