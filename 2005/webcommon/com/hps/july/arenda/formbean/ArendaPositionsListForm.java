package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import java.math.*;
/**
 * Form-Bean.
 * список "Позиций абонентского договора".
 * Creation date: (01.07.2002 11:58:50)
 * @author: Sergey Gourov
 */
public class ArendaPositionsListForm extends com.hps.july.web.util.BrowseForm {
	private int leaseDocument;
	private java.lang.String documentNumber;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	private java.lang.String orgCustomer;
	private java.lang.String orgExecutor;
	private BigDecimal currency1;
	private BigDecimal currency2;
	private java.lang.String curr1;
	private java.lang.String curr2;
	private java.lang.String mainEconomist;
	private java.lang.String stateOfContract;
	
	private Integer position;
	private String positionname;
	private java.lang.Integer mainPosition;
/**
 * ArendaPositionsListForm constructor comment.
 */
public ArendaPositionsListForm() {
	super();
	setFinderMethodName("findLeaseonpositionsByLeaseArendaAgreementNew");
}
/**
 * Включает позицию в акт по указанному leaseDocument и position
 * При успешном добавлении позиции очищает данные о позиции.
 * В случе возникновения ошибок ничего не добавляет.
 * Created: 19.01.2004
 */
public void addPosition()
{
	if (position != null) {
		try {
			LeaseOnPositionAccessBean lopBean = new LeaseOnPositionAccessBean();
			lopBean.setInitKey_leaseArendaAgreementNew_leaseDocument(new Integer(leaseDocument));
			lopBean.setInitKey_position_storageplace(position);
			lopBean.refreshCopyHelper();
			// Если дошли этого места значит позиция уже включена
			position = null;
			positionname = null;
		} catch(Exception e) {
			try {
				// Включаем позицию
				LeaseOnPositionAccessBean lopBean = 
					new LeaseOnPositionAccessBean(
						new Integer(leaseDocument), position
					);
				position = null;
				positionname = null;
			} catch(Exception ex) {
				// Позиция создаться не может
				System.out.println("ARENDA_POSITION_LIST: Can't create position("+leaseDocument+","+position+")");
				ex.printStackTrace(System.out);
			}
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2002 12:32:18)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2002 12:32:46)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:20:50)
 * @return com.ibm.math.BigDecimal
 */
public BigDecimal getCurrency1() {
	return currency1;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:21:05)
 * @return com.ibm.math.BigDecimal
 */
public BigDecimal getCurrency2() {
	return currency2;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:03:30)
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
 * Creation date: (05.07.2002 12:05:43)
 * @return java.sql.Date
 */
public java.sql.Date getEndDate() {
	return endDate;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 11:58:50)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new com.hps.july.persistence.LeaseDocumentKey(getLeaseDocument()) };
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 12:48:27)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 11:09:18)
 * @return java.lang.String
 */
public java.lang.String getMainEconomist() {
	return mainEconomist;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2004 11:48:15)
 * @return java.lang.Integer
 */
public java.lang.Integer getMainPosition() {
	return mainPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:06:03)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:06:19)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutor() {
	return orgExecutor;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getPosition() {
	return position;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:05:28)
 * @return java.sql.Date
 */
public java.sql.Date getStartDate() {
	return startDate;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2002 18:37:20)
 * @return java.lang.String
 */
public java.lang.String getStateOfContract() {
	return stateOfContract;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2002 12:32:18)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2002 12:32:46)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:20:50)
 * @param newCurrency1 com.ibm.math.BigDecimal
 */
public void setCurrency1(BigDecimal newCurrency1) {
	currency1 = newCurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:21:05)
 * @param newCurrency2 com.ibm.math.BigDecimal
 */
public void setCurrency2(BigDecimal newCurrency2) {
	currency2 = newCurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:03:30)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:05:43)
 * @param newEndDate java.sql.Date
 */
public void setEndDate(java.sql.Date newEndDate) {
	endDate = newEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 12:48:27)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 11:09:18)
 * @param newMainEconomist java.lang.String
 */
public void setMainEconomist(java.lang.String newMainEconomist) {
	mainEconomist = newMainEconomist;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2004 11:48:15)
 * @param newMainPosition java.lang.Integer
 */
public void setMainPosition(java.lang.Integer newMainPosition) {
	mainPosition = newMainPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:06:03)
 * @param newOrgCustomer java.lang.String
 */
public void setOrgCustomer(java.lang.String newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:06:19)
 * @param newOrgExecutor java.lang.String
 */
public void setOrgExecutor(java.lang.String newOrgExecutor) {
	orgExecutor = newOrgExecutor;
}
/**
 * 
 * @param newPosition java.lang.Integer
 */
public void setPosition(java.lang.Integer newPosition) {
	position = newPosition;
}
/**
 * 
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:05:28)
 * @param newStartDate java.sql.Date
 */
public void setStartDate(java.sql.Date newStartDate) {
	startDate = newStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2002 18:37:20)
 * @param newStateOfContract java.lang.String
 */
public void setStateOfContract(java.lang.String newStateOfContract) {
	stateOfContract = newStateOfContract;
}
}
