package com.hps.july.arenda.sessionbean;

import java.math.*;
import java.util.*;
import com.hps.july.persistence.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is a Session Bean Class
 * Процессор доп. соглашений аренды
 */
public class LeaseArendaAgreementProcessorBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Insert the method's description here.
 * Creation date: (05.02.2003 17:03:18)
 * @param mainDocument int
 */
public void changeActiveDocument(Integer mainDocument) throws java.rmi.RemoteException {
	try {
		int i = 0;
		Enumeration e = new LeaseArendaAgreementNewAccessBean().findByQBE2(mainDocument, new Boolean(false), null,
			new Boolean(false), null, new Integer(2));
		while (e.hasMoreElements()) {
			LeaseArendaAgreementNewAccessBean bean = (LeaseArendaAgreementNewAccessBean) e.nextElement();
			if (++i == 1) {
				bean.setIsActive(new Boolean(true));
			} else {
				bean.setIsActive(new Boolean(false));
			}
			bean.commitCopyHelper();
		}
	} catch (Exception e) {
		e.printStackTrace();
		throw new java.rmi.RemoteException("While change active document, ", e);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 13:01:18)
 * @return boolean
 * @param contractCode java.lang.Integer
 * @param resourceCode java.lang.Integer
 */
public boolean checkOpenPeriod(int leasedocpositionCode) throws java.rmi.RemoteException {
	try {
		LeaseDocPositionAccessBean ldpBean = new LeaseDocPositionAccessBean();
		ldpBean.setInitKey_leaseDocPosition(leasedocpositionCode);
		ldpBean.refreshCopyHelper();
		
		Enumeration e = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(
			new Integer(ldpBean.getLeaseContractKey().leaseDocument), new Integer(ldpBean.getResourceKey().resource));
		if (e.hasMoreElements()) {
			LeaseSaldoAccessBean bean = (LeaseSaldoAccessBean) e.nextElement();
			return ldpBean.getDate().after(bean.getSalDate()) ? true : false;
		}
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		throw new java.rmi.RemoteException("While check open period, ", e);
	}
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {}
/**
 * ejbCreate method comment
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 12:10:11)
 * @return int
 * @param contract int
 */
public int getBaseContract(int contract) throws java.rmi.RemoteException {
	try {
		LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
		bean.setInitKey_leaseDocument(contract);
		bean.refreshCopyHelper();
		
		return bean.getMainDocument() == null ? contract : bean.getMainDocument().intValue();
	} catch (Exception e) {
		e.printStackTrace();
		throw new java.rmi.RemoteException("While get Base contract", e);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 12:48:19)
 * @return java.util.Date
 * @param contract int
 */
public java.sql.Date getEndDateOfContract(int contract) throws java.rmi.RemoteException {
	try {
		Enumeration e = new LeaseArendaAgreementNewAccessBean().findByQBE2(new Integer(getBaseContract(contract)),
			new Boolean(false), null, new Boolean(false), null, new Integer(1));
		if (e.hasMoreElements()) {
			boolean isCertain = false;
			boolean isLast = false;
			LeaseArendaAgreementNewAccessBean bean = null;
			
			while (e.hasMoreElements()) {
				bean = (LeaseArendaAgreementNewAccessBean) e.nextElement();
				
				if (bean.getLeaseDocument() == contract) {
					isCertain = true;
					if (!e.hasMoreElements()) {
						isLast = true;
					}
				} else if (isCertain) {
					break;
				}
			}
			
			if (isLast) {
				return bean.getEndDate();
			} else {
				GregorianCalendar c = new GregorianCalendar();
				c.setTime(bean.getStartDate());
				c.add(Calendar.DAY_OF_MONTH, -1);
				return new java.sql.Date(c.getTime().getTime());
			}
			
		} else {
			LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
			bean.setInitKey_leaseDocument(contract);
			bean.refreshCopyHelper();

			return bean.getEndDate();
		}
	} catch (Exception e) {
		e.printStackTrace();
		throw new java.rmi.RemoteException("While get end date of contract", e);
	}
}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * Insert the method's description here.
 * Creation date: (01.10.2002 17:15:32)
 * @return boolean
 * @param documentcode int
 */
public boolean isChangeState(int documentcode) throws java.rmi.RemoteException {
	try {
		LeaseArendaAgreementNewAccessBean agreementBean = new LeaseArendaAgreementNewAccessBean();
		agreementBean.setInitKey_leaseDocument(documentcode);
		agreementBean.refreshCopyHelper();
		
		BigDecimal sum1 = new BigDecimal(0);
		BigDecimal sum2 = new BigDecimal(0);
		
		Enumeration e = new LeasePayRuleAccessBean().findByLeaseDocument(new Integer(documentcode), new Boolean(false), new Integer(1));
		while (e.hasMoreElements()) {
			LeasePayRuleAccessBean payRuleBean = (LeasePayRuleAccessBean) e.nextElement();
			
			if (payRuleBean.getCurrencyKey().currency == agreementBean.getCurrency1Key().currency) {
				sum1 = sum1.add(payRuleBean.getSum());
			} else if (agreementBean.getCurrency2() != null && payRuleBean.getCurrencyKey().currency == agreementBean.getCurrency2Key().currency) {
				sum2 = sum2.add(payRuleBean.getSum());
			}
		}
		
		if (sum1.compareTo(agreementBean.getSumm1()) != 0 || (agreementBean.getSumm2() != null && sum2.compareTo(agreementBean.getSumm2()) != 0) ||
			(agreementBean.getSumm2() == null && sum2.compareTo(new BigDecimal(0)) != 0)) {
			return false;
		}
		
		sum1 = new BigDecimal(0);
		sum2 = new BigDecimal(0);
		
		e = new LeaseChargeRuleAccessBean().findByLeaseDocument(new Integer(documentcode), new Integer(1));
		while (e.hasMoreElements()) {
			LeaseChargeRuleAccessBean chargeRuleBean = (LeaseChargeRuleAccessBean) e.nextElement();
			
			if (chargeRuleBean.getCurencyKey().currency == agreementBean.getCurrency1Key().currency) {
				sum1 = sum1.add(chargeRuleBean.getSum());
			} else if (agreementBean.getCurrency2() != null && chargeRuleBean.getCurencyKey().currency == agreementBean.getCurrency2Key().currency) {
				sum2 = sum2.add(chargeRuleBean.getSum());
			}
		}
		
		if (sum1.compareTo(agreementBean.getSumm1()) != 0 || (agreementBean.getSumm2() != null && sum2.compareTo(agreementBean.getSumm2()) != 0) ||
			(agreementBean.getSumm2() == null && sum2.compareTo(new BigDecimal(0)) != 0)) {
			return false;
		}
		
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		throw new java.rmi.RemoteException("While change state document", e);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2002 14:59:43)
 * @return boolean
 * @param mainDocument int
 */
public boolean isChangeStateToEdit(int leaseDocument, boolean isExistDocument) throws java.rmi.RemoteException {
	try {
		int mainDocument = getBaseContract(leaseDocument);
		LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
		bean.setInitKey_leaseDocument(mainDocument);
		bean.refreshCopyHelper();

		if ((isExistDocument ? leaseDocument != mainDocument : true) && bean.getContractState().equals("A")) {
			return false;
		} else {
			Enumeration e = new LeaseArendaAgreementNewAccessBean().findByQBE2(
				new Integer(mainDocument), new Boolean(false), null, new Boolean(false), null, new Integer(1));
			while (e.hasMoreElements()) {
				bean = (LeaseArendaAgreementNewAccessBean) e.nextElement();
				if ((isExistDocument ? leaseDocument != bean.getLeaseDocument() : true) && bean.getContractState().equals("A")) {
					return false;
				}
			}
		}
		
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		throw new java.rmi.RemoteException("While is change state to edit", e);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.01.2003 11:17:33)
 * @return boolean
 */
public boolean isInitialSaldo(int leaseContractcode, int resourcecode, java.sql.Date salDate) throws java.rmi.RemoteException {
	try {
		LeaseSaldoAccessBean bean = new LeaseSaldoAccessBean();
		bean.setInitKey_leaseContract(new Integer(leaseContractcode));
		bean.setInitKey_resource_resource(new Integer(resourcecode));
		bean.setInitKey_SalDate(salDate);
		bean.refreshCopyHelper();
		
		LeaseContractAccessBean lcBean = new LeaseContractAccessBean();
		lcBean.setInitKey_leaseDocument(leaseContractcode);
		lcBean.refreshCopyHelper();

		GregorianCalendar c = new GregorianCalendar();
		c.setTime(lcBean.getStartDate());
		c.add(Calendar.DAY_OF_MONTH, -1);
		
		if (salDate.compareTo(c.getTime()) == 0 && bean.getAct() == null) {
			return true;
		}
		return false;
	} catch (Exception e) {
		e.printStackTrace();
		throw new java.rmi.RemoteException("While check initial saldo", e);
	}
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
}
