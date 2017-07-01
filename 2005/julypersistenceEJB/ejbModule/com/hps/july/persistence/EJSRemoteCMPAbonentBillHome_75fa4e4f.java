package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPAbonentBillHome_75fa4e4f
 */
public class EJSRemoteCMPAbonentBillHome_75fa4e4f extends EJSWrapper implements com.hps.july.persistence.AbonentBillHome {
	/**
	 * EJSRemoteCMPAbonentBillHome_75fa4e4f
	 */
	public EJSRemoteCMPAbonentBillHome_75fa4e4f() throws java.rmi.RemoteException {
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
	public com.hps.july.persistence.AbonentBill create(int argLeasebill) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AbonentBill _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.create(argLeasebill);
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
	 * create
	 */
	public com.hps.july.persistence.AbonentBill create(int argLeaseBill, int argLeaseDocument, java.lang.String argBenSource, boolean argFlagWorkNRI) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AbonentBill _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.create(argLeaseBill, argLeaseDocument, argBenSource, argFlagWorkNRI);
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
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.AbonentBill create(int argLeaseBill, int argLeaseDocument, java.lang.String argBenSource, boolean argFlagWorkNRI, java.lang.String argRecordStatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AbonentBill _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.create(argLeaseBill, argLeaseDocument, argBenSource, argFlagWorkNRI, argRecordStatus);
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
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.AbonentBill findByPrimaryKey(com.hps.july.persistence.AbonentBillKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AbonentBill _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f)container.preInvoke(this, 3, _EJS_s);
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
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAbonentBillsByLeaseabonentban
	 */
	public java.util.Enumeration findAbonentBillsByLeaseabonentban(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.findAbonentBillsByLeaseabonentban(inKey);
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
	 * findByBanStartServDate
	 */
	public java.util.Enumeration findByBanStartServDate(java.lang.Integer argBan, java.sql.Date argStartDate) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.findByBanStartServDate(argBan, argStartDate);
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
	 * findByBen
	 */
	public java.util.Enumeration findByBen(java.lang.Short argBen) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.findByBen(argBen);
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
	 * findByFlagWorkNRI
	 */
	public java.util.Enumeration findByFlagWorkNRI(java.lang.String argFlagWorkNRI) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f)container.preInvoke(this, 7, _EJS_s);
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
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isLeaseDocument, java.lang.Integer leaseDocument, java.lang.Boolean isBillDate, java.sql.Date fromBillDate, java.sql.Date toBillDate, java.lang.Boolean isBillType, java.lang.String billType, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.findByQBE(isLeaseDocument, leaseDocument, isBillDate, fromBillDate, toBillDate, isBillType, billType, order);
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
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.lang.Boolean isLeaseDocument, java.lang.Integer leaseDocument, java.lang.Boolean isBillDate, java.sql.Date fromBillDate, java.sql.Date toBillDate, java.lang.Boolean isBillType, java.lang.String billType, java.lang.Boolean isUseinNRI, java.lang.Boolean useInNRI, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.findByQBE2(isLeaseDocument, leaseDocument, isBillDate, fromBillDate, toBillDate, isBillType, billType, isUseinNRI, useInNRI, order);
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
				container.postInvoke(this, 9, _EJS_s);
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
			com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f)container.preInvoke(this, 10, _EJS_s);
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
				container.postInvoke(this, 10, _EJS_s);
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
			com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f)container.preInvoke(this, 11, _EJS_s);
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
				container.postInvoke(this, 11, _EJS_s);
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
			com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f)container.preInvoke(this, 12, _EJS_s);
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
				container.postInvoke(this, 12, _EJS_s);
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
			com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillHomeBean_75fa4e4f)container.preInvoke(this, 13, _EJS_s);
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
				container.postInvoke(this, 13, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
