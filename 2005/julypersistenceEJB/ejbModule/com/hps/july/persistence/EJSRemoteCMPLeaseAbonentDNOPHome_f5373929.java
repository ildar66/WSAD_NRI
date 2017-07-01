package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPLeaseAbonentDNOPHome_f5373929
 */
public class EJSRemoteCMPLeaseAbonentDNOPHome_f5373929 extends EJSWrapper implements com.hps.july.persistence.LeaseAbonentDNOPHome {
	/**
	 * EJSRemoteCMPLeaseAbonentDNOPHome_f5373929
	 */
	public EJSRemoteCMPLeaseAbonentDNOPHome_f5373929() throws java.rmi.RemoteException {
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
	 * create
	 */
	public com.hps.july.persistence.LeaseAbonentDNOP create(int argIdabonentdnop, int argLeaseBill, int argPayPos, java.math.BigDecimal argSumLinkUSD, boolean argFlagWorkNRI, java.lang.String argRecordStatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.LeaseAbonentDNOP _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929 beanRef = (com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.create(argIdabonentdnop, argLeaseBill, argPayPos, argSumLinkUSD, argFlagWorkNRI, argRecordStatus);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseAbonentDNOP findByPrimaryKey(com.hps.july.persistence.LeaseAbonentDNOPKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.LeaseAbonentDNOP _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929 beanRef = (com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.findByPrimaryKey(key);
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
	 * findByFlagWorkNRI
	 */
	public java.util.Enumeration findByFlagWorkNRI(java.lang.String argFlagWorkNRI) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929 beanRef = (com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.findByFlagWorkNRI(argFlagWorkNRI);
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
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPayPos
	 */
	public java.util.Enumeration findByPayPos(java.lang.Integer argPayPos) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929 beanRef = (com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.findByPayPos(argPayPos);
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
	 * findByPayPosLeaseBill
	 */
	public java.util.Enumeration findByPayPosLeaseBill(java.lang.Integer argPayPos, java.lang.Integer argLeaseBill) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929 beanRef = (com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.findByPayPosLeaseBill(argPayPos, argLeaseBill);
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
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findLeaseAbonentDNOPsByAbonentbill
	 */
	public java.util.Enumeration findLeaseAbonentDNOPsByAbonentbill(com.hps.july.persistence.AbonentBillKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929 beanRef = (com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.findLeaseAbonentDNOPsByAbonentbill(inKey);
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
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findLeaseAbonentDNOPsByAbonentpayment
	 */
	public java.util.Enumeration findLeaseAbonentDNOPsByAbonentpayment(com.hps.july.persistence.AbonentPaymentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929 beanRef = (com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.findLeaseAbonentDNOPsByAbonentpayment(inKey);
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
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getEJBMetaData
	 */
	public javax.ejb.EJBMetaData getEJBMetaData() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		javax.ejb.EJBMetaData _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929 beanRef = (com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.getEJBMetaData();
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
	 * getHomeHandle
	 */
	public javax.ejb.HomeHandle getHomeHandle() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		javax.ejb.HomeHandle _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929 beanRef = (com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.getHomeHandle();
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
	 * remove
	 */
	public void remove(java.lang.Object arg0) throws java.rmi.RemoteException, javax.ejb.RemoveException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929 beanRef = (com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929)container.preInvoke(this, 9, _EJS_s);
			beanRef.remove(arg0);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * remove
	 */
	public void remove(javax.ejb.Handle arg0) throws java.rmi.RemoteException, javax.ejb.RemoveException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929 beanRef = (com.hps.july.persistence.EJSCMPLeaseAbonentDNOPHomeBean_f5373929)container.preInvoke(this, 10, _EJS_s);
			beanRef.remove(arg0);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
}
