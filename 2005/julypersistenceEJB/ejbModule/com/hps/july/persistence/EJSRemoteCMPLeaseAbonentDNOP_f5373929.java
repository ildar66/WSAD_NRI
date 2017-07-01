package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPLeaseAbonentDNOP_f5373929
 */
public class EJSRemoteCMPLeaseAbonentDNOP_f5373929 extends EJSWrapper implements LeaseAbonentDNOP {
	/**
	 * EJSRemoteCMPLeaseAbonentDNOP_f5373929
	 */
	public EJSRemoteCMPLeaseAbonentDNOP_f5373929() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getDeployedSupport
	 */
	public com.ibm.ejs.container.EJSDeployedSupport getDeployedSupport() {
		return container.getEJSDeployedSupport(this);
	}
	/**
	 * putDeployedSupport
	 */
	public void putDeployedSupport(com.ibm.ejs.container.EJSDeployedSupport support) {
		container.putEJSDeployedSupport(support);
		return;
	}
	/**
	 * getFlagworknri
	 */
	public boolean getFlagworknri() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getFlagworknri();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getAbonentbill
	 */
	public com.hps.july.persistence.AbonentBill getAbonentbill() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AbonentBill _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getAbonentbill();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getAbonentbillKey
	 */
	public com.hps.july.persistence.AbonentBillKey getAbonentbillKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AbonentBillKey _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getAbonentbillKey();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getAbonentpayment
	 */
	public com.hps.july.persistence.AbonentPayment getAbonentpayment() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AbonentPayment _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getAbonentpayment();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getAbonentpaymentKey
	 */
	public com.hps.july.persistence.AbonentPaymentKey getAbonentpaymentKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AbonentPaymentKey _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getAbonentpaymentKey();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getIdabonentdnop
	 */
	public int getIdabonentdnop() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.getIdabonentdnop();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRecordstatus
	 */
	public java.lang.String getRecordstatus() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.getRecordstatus();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSumlinkusd
	 */
	public java.math.BigDecimal getSumlinkusd() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.getSumlinkusd();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Hashtable _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef._copyFromEJB();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * privateSetAbonentbillKey
	 */
	public void privateSetAbonentbillKey(com.hps.july.persistence.AbonentBillKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 9, _EJS_s);
			beanRef.privateSetAbonentbillKey(inKey);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 9, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * privateSetAbonentpaymentKey
	 */
	public void privateSetAbonentpaymentKey(com.hps.july.persistence.AbonentPaymentKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 10, _EJS_s);
			beanRef.privateSetAbonentpaymentKey(inKey);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 10, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetAbonentbill
	 */
	public void secondarySetAbonentbill(com.hps.july.persistence.AbonentBill anAbonentbill) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 11, _EJS_s);
			beanRef.secondarySetAbonentbill(anAbonentbill);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 11, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetAbonentpayment
	 */
	public void secondarySetAbonentpayment(com.hps.july.persistence.AbonentPayment anAbonentpayment) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 12, _EJS_s);
			beanRef.secondarySetAbonentpayment(anAbonentpayment);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 12, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setAbonentbill
	 */
	public void setAbonentbill(com.hps.july.persistence.AbonentBill anAbonentbill) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 13, _EJS_s);
			beanRef.setAbonentbill(anAbonentbill);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 13, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setAbonentpayment
	 */
	public void setAbonentpayment(com.hps.july.persistence.AbonentPayment anAbonentpayment) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 14, _EJS_s);
			beanRef.setAbonentpayment(anAbonentpayment);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 14, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setFlagworknri
	 */
	public void setFlagworknri(boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 15, _EJS_s);
			beanRef.setFlagworknri(newValue);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 15, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRecordstatus
	 */
	public void setRecordstatus(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 16, _EJS_s);
			beanRef.setRecordstatus(newValue);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 16, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSumlinkusd
	 */
	public void setSumlinkusd(java.math.BigDecimal newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 17, _EJS_s);
			beanRef.setSumlinkusd(newValue);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 17, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable arg0) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentDNOPBean beanRef = (com.hps.july.persistence.LeaseAbonentDNOPBean)container.preInvoke(this, 18, _EJS_s);
			beanRef._copyToEJB(arg0);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 18, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
