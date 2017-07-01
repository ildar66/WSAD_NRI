package com.hps.july.arenda.formbean;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.arenda.cdbcobjects.CDBC_SchetFact_Object;
import com.hps.july.arenda.valueobject.LeaseDocumentValueObject;
import com.hps.july.persistence.LeaseContractAccessBean;
import com.hps.july.persistence.LeaseMutualActNewAccessBean;
import com.hps.july.persistence.OperatorObject;
import com.hps.july.web.util.StringAndSqlDateProperty;
/**
 * Bean-form
 * Форма фактуры акта(лист).
 * Creation date: (22.05.2003 15:21:39)
 * @author: Sergey Gourov
 */
public class FacturaMutactList extends com.hps.july.web.util.BrowseForm {
	private int leaseDocument;
	private java.lang.String documentNumber;
	private java.sql.Date documentDate;
	private java.lang.String searchState;
	private java.lang.Boolean isAutoProcError;
	private java.lang.String messageError;
	private java.lang.Boolean isSearch;
	private java.lang.String acttype;
	private java.sql.Date actstartdate;
	private java.sql.Date actenddate;

	private String calcType;
	private String calcAbonentType;
	private String calcArendaType;
	private java.lang.String type = "D";//Вид счет-фактуры для печати = "Определять по дате"

	private java.lang.String sortBy;
	private int idContractcode;
	private java.lang.String operation = "";
	private int idCode = -1;
	private java.lang.String toState = "";
	private java.lang.Integer operatorCode;
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2003 15:22:06)
	 */
	public FacturaMutactList() {
		setFinderMethodName("findByQBE"); // findByIdActOrderByDateSchetFaktAsc
		setSearchState("1");
		//patch SI: setIsSearch(new Boolean(false));
		setIsSearch(Boolean.TRUE);
		setSortBy("numberSchetFakt");
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (29.05.2003 14:57:31)
	 * @return java.sql.Date
	 */
	public java.sql.Date getActenddate() {
		return actenddate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (29.05.2003 14:57:12)
	 * @return java.sql.Date
	 */
	public java.sql.Date getActstartdate() {
		return actstartdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (29.05.2003 14:56:14)
	 * @return java.lang.String
	 */
	public java.lang.String getActtype() {
		return acttype;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCalcAbonentType() {
		return calcAbonentType;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCalcArendaType() {
		return calcArendaType;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCalcType() {
		return calcType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2003 17:33:21)
	 * @return java.sql.Date
	 */
	public java.sql.Date getDocumentDate() {
		return documentDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2003 17:30:55)
	 * @return java.lang.String
	 */
	public java.lang.String getDocumentNumber() {
		return documentNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.06.2002 16:47:06)
	 * @return java.util.ArrayList
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
	 * Creation date: (22.05.2003 15:21:39)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		String s = "";
		if (getSearchState().equals("2")) {
			s = "A";
		} else if (getSearchState().equals("1")) {
			s = "C";
		}

		//Integer idAct, Boolean isContractType, String typeContract, Integer order
		//return new Object[] { new Integer(getLeaseDocument()), getIsSearch().booleanValue() ? Boolean.FALSE : Boolean.TRUE, s, new Integer(1) };
		return new Object[] {
			new Integer(getLeaseDocument()),
			getIsSearch().booleanValue() ? Boolean.FALSE : Boolean.TRUE,
			s,
			getSortBy()};
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.05.2003 14:39:32)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getIsAutoProcError() {
		return isAutoProcError;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.05.2003 18:39:07)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getIsSearch() {
		return isSearch;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2003 15:28:35)
	 * @return int
	 */
	public int getLeaseDocument() {
		return leaseDocument;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.05.2003 14:43:40)
	 * @return java.lang.String
	 */
	public java.lang.String getMessageError() {
		return messageError;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2003 19:45:29)
	 * @return java.lang.String
	 */
	public java.lang.String getSearchState() {
		return searchState;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.04.2004 17:23:11)
	 * @return java.lang.String
	 */
	public java.lang.String getType() {
		return type;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (29.05.2003 14:57:31)
	 * @param newActenddate java.sql.Date
	 */
	public void setActenddate(java.sql.Date newActenddate) {
		actenddate = newActenddate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (29.05.2003 14:57:12)
	 * @param newActstartdate java.sql.Date
	 */
	public void setActstartdate(java.sql.Date newActstartdate) {
		actstartdate = newActstartdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (29.05.2003 14:56:14)
	 * @param newActtype java.lang.String
	 */
	public void setActtype(java.lang.String newActtype) {
		acttype = newActtype;
	}
	/**
	 * 
	 * @param newCalcAbonentType java.lang.String
	 */
	public void setCalcAbonentType(java.lang.String newCalcAbonentType) {
		calcAbonentType = newCalcAbonentType;
	}
	/**
	 * 
	 * @param newCalcArendaType java.lang.String
	 */
	public void setCalcArendaType(java.lang.String newCalcArendaType) {
		calcArendaType = newCalcArendaType;
	}
	/**
	 * 
	 * @param newCalcType java.lang.String
	 */
	public void setCalcType(java.lang.String newCalcType) {
		calcType = newCalcType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2003 17:33:21)
	 * @param newDocumentDate java.sql.Date
	 */
	public void setDocumentDate(java.sql.Date newDocumentDate) {
		documentDate = newDocumentDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2003 17:30:55)
	 * @param newDocumentNumber java.lang.String
	 */
	public void setDocumentNumber(java.lang.String newDocumentNumber) {
		documentNumber = newDocumentNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.05.2003 14:39:32)
	 * @param newIsAutoProcError java.lang.Boolean
	 */
	public void setIsAutoProcError(java.lang.Boolean newIsAutoProcError) {
		isAutoProcError = newIsAutoProcError;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.05.2003 18:39:07)
	 * @param newIsSearch java.lang.Boolean
	 */
	public void setIsSearch(java.lang.Boolean newIsSearch) {
		isSearch = newIsSearch;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2003 15:28:35)
	 * @param newLeaseDocument int
	 */
	public void setLeaseDocument(int newLeaseDocument) {
		leaseDocument = newLeaseDocument;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.05.2003 14:43:40)
	 * @param newMessageError java.lang.String
	 */
	public void setMessageError(java.lang.String newMessageError) {
		messageError = newMessageError;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2003 19:45:29)
	 * @param newSearchState java.lang.String
	 */
	public void setSearchState(java.lang.String newSearchState) {
		searchState = newSearchState;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.04.2004 17:23:11)
	 * @param newType java.lang.String
	 */
	public void setType(java.lang.String newType) {
		type = newType;
	}
	/**
	 * @return
	 */
	public java.lang.String getSortBy() {
		return sortBy;
	}

	/**
	 * @param string
	 */
	public void setSortBy(java.lang.String string) {
		sortBy = string;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.05.2003 14:33:15)
	 * @return java.util.Enumeration
	 */
	public Enumeration getDocuments() {
		try {
			Vector v = new Vector();
			LeaseMutualActNewAccessBean idAct = new LeaseMutualActNewAccessBean();
			idAct.setInitKey_leaseDocument(getLeaseDocument());
			idAct.refreshCopyHelper();

			Enumeration e =
				new LeaseContractAccessBean().findLeaseContractsByReglamentOrderByCodeAsc(
					new Integer(idAct.getLeaseMutualReglamentKey().leaseDocument));
			while (e.hasMoreElements()) {
				LeaseContractAccessBean bean = (LeaseContractAccessBean) e.nextElement();

				LeaseDocumentValueObject valueObject = new LeaseDocumentValueObject();
				valueObject.setLeaseDocument(bean.getLeaseDocument());
				String message = null;
				if (bean.getContractType().equals("A")) {
					message = "Аренда";
				} else if (bean.getContractType().equals("B")) {
					message = "Аренда у нас";
				} else if (bean.getContractType().equals("C")) {
					message = "Аб.договор";
				} else if (bean.getContractType().equals("D")) {
					message = "Дог. на аренду канала связи";
				}
				StringAndSqlDateProperty dateProperty = new StringAndSqlDateProperty();
				dateProperty.setSqlDate(bean.getDocumentDate());

				valueObject.setValue(message + ", " + dateProperty.getString() + ", " + bean.getDocumentNumber());
				v.addElement(valueObject);
			}

			return v.elements();
		} catch (Exception e) {
			e.printStackTrace();
			return new java.util.Vector().elements();
		}
	}
	/**
	 * @return
	 */
	public int getIdContractcode() {
		return idContractcode;
	}

	/**
	 * @param i
	 */
	public void setIdContractcode(int i) {
		idContractcode = i;
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
	 * 
	 * @param request
	 */

	private void initOperatorCode(javax.servlet.http.HttpServletRequest request) {
		setOperatorCode(OperatorObject.getOperatorCode(request.getRemoteUser()));
	}
	/**
	 * @return
	 */
	public java.lang.Integer getOperatorCode() {
		return operatorCode;
	}

	/**
	 * @param integer
	 */
	private void setOperatorCode(java.lang.Integer integer) {
		operatorCode = integer;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#initBrowse(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		if (getOperatorCode() == null)
			initOperatorCode(request);
		return null;
	}
	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		operation = "";
		idCode = -1;
		toState = "";
	}

}
