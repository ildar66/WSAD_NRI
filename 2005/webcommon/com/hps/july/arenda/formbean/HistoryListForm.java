package com.hps.july.arenda.formbean;

import java.util.*;
import com.hps.july.persistence.*;
/**
 * Form-Bean "Истории договора аренды".
 * Creation date: (30.07.2002 15:38:10)
 * @author: Sergey Gourov
 */
public class HistoryListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String docNumber;
	private java.lang.String customer;
	private java.lang.String executor;
	private int leaseDocument;
	private java.lang.Integer executorcode;
	private java.lang.Integer customercode;
	private int mainDocumentcode;
	private java.lang.String stateOfContract;
	/**
	 * HistoryListForm constructor comment.
	 */
	public HistoryListForm() {
		super();
		setFinderMethodName("findByQBE2");
		//setFinderMethodName("findByQBECompose");
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.08.2002 10:21:14)
	 * @return java.util.Enumeration
	 * @param mainLeaseDocument java.lang.Integer
	 * @param isIsActive java.lang.Boolean
	 * @param isActive java.lang.Boolean
	 * @param order java.lang.Integer
	 * @exception java.rmi.RemoteException The exception description.
	 * @exception javax.ejb.FinderException The exception description.
	 */
	public Enumeration findByQBECompose(Integer mainLeaseDocument, Boolean isIsActive, Boolean isActive, Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

		LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
		Enumeration e = bean.findByQBE2(mainLeaseDocument, isIsActive, isActive, new Boolean(false), null, order);

		LeaseArendaAgreementNewAccessBean beanPrimary = new LeaseArendaAgreementNewAccessBean();
		try {
			beanPrimary.setInitKey_leaseDocument(mainLeaseDocument.intValue());
			beanPrimary.refreshCopyHelper();
		} catch (javax.ejb.CreateException ex) {
			ex.printStackTrace();
			return e;
		}

		Vector v = new Vector();
		while (e.hasMoreElements()) {
			v.addElement(e.nextElement());
		}

		switch (order.intValue()) {
			case 1 :
				{
					v.add(0, beanPrimary);
					break;
				}
			case 2 :
				{
					v.add(beanPrimary);
					break;
				}
		}

		return v.elements();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.07.2002 15:42:37)
	 * @return java.lang.String
	 */
	public java.lang.String getCustomer() {
		return customer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.08.2002 18:01:04)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCustomercode() {
		return customercode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.07.2002 15:42:13)
	 * @return java.lang.String
	 */
	public java.lang.String getDocNumber() {
		return docNumber;
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
	 * Creation date: (30.07.2002 15:42:49)
	 * @return java.lang.String
	 */
	public java.lang.String getExecutor() {
		return executor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.08.2002 18:00:20)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getExecutorcode() {
		return executorcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.07.2002 15:38:10)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		setMainDocumentcode(getPrimaryLeaseDocument(getLeaseDocument()));
		return new Object[] { new Integer(getMainDocumentcode()), new Boolean(false) /* show active doc too */
			, new Boolean(false), new Boolean(false), "", new Integer(2)};
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.08.2002 11:41:59)
	 * @return int
	 */
	public int getLeaseDocument() {
		return leaseDocument;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.08.2002 18:07:42)
	 * @return int
	 */
	public int getMainDocumentcode() {
		return mainDocumentcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.08.2002 10:37:14)
	 * @return int
	 * @param leaseDocument int
	 */
	private int getPrimaryLeaseDocument(int leaseDocument) {
		try {
			LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
			bean.setInitKey_leaseDocument(leaseDocument);
			bean.refreshCopyHelper();
			return (bean.getMainDocument() == null) ? leaseDocument : bean.getMainDocument().intValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (20.11.2002 11:17:16)
	 * @return java.lang.String
	 */
	public java.lang.String getStateOfContract() {
		return stateOfContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.07.2002 15:42:37)
	 * @param newCustomer java.lang.String
	 */
	public void setCustomer(java.lang.String newCustomer) {
		customer = newCustomer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.08.2002 18:01:04)
	 * @param newCustomercode java.lang.Integer
	 */
	public void setCustomercode(java.lang.Integer newCustomercode) {
		customercode = newCustomercode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.07.2002 15:42:13)
	 * @param newDocNumber java.lang.String
	 */
	public void setDocNumber(java.lang.String newDocNumber) {
		docNumber = newDocNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.07.2002 15:42:49)
	 * @param newExecutor java.lang.String
	 */
	public void setExecutor(java.lang.String newExecutor) {
		executor = newExecutor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.08.2002 18:00:20)
	 * @param newExecutorcode java.lang.Integer
	 */
	public void setExecutorcode(java.lang.Integer newExecutorcode) {
		executorcode = newExecutorcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.08.2002 11:41:59)
	 * @param newLeaseDocument int
	 */
	public void setLeaseDocument(int newLeaseDocument) {
		leaseDocument = newLeaseDocument;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.08.2002 18:07:42)
	 * @param newMainDocumentcode int
	 */
	public void setMainDocumentcode(int newMainDocumentcode) {
		mainDocumentcode = newMainDocumentcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (20.11.2002 11:17:16)
	 * @param newStateOfContract java.lang.String
	 */
	public void setStateOfContract(java.lang.String newStateOfContract) {
		stateOfContract = newStateOfContract;
	}
}
