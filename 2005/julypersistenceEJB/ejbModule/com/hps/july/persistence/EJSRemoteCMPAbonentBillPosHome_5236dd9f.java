package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPAbonentBillPosHome_5236dd9f
 */
public class EJSRemoteCMPAbonentBillPosHome_5236dd9f extends EJSWrapper implements com.hps.july.persistence.AbonentBillPosHome {
	/**
	 * EJSRemoteCMPAbonentBillPosHome_5236dd9f
	 */
	public EJSRemoteCMPAbonentBillPosHome_5236dd9f() throws java.rmi.RemoteException {
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
	public com.hps.july.persistence.AbonentBillPos create(int argBillpos) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AbonentBillPos _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.create(argBillpos);
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
	public com.hps.july.persistence.AbonentBillPos create(int argBillPos, int argLeaseBill, int argResource, java.math.BigDecimal argQty, int argCurrency, java.math.BigDecimal argSummPure, java.math.BigDecimal argSumPureNRI, java.math.BigDecimal argSumm, java.math.BigDecimal argSummNRI, java.math.BigDecimal argNDSSumm, java.math.BigDecimal argNDSSummNRI, java.math.BigDecimal argNSPSumm, java.math.BigDecimal argNSPSummNRI, java.lang.String argRecordStatus, boolean argSumByHand) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AbonentBillPos _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.create(argBillPos, argLeaseBill, argResource, argQty, argCurrency, argSummPure, argSumPureNRI, argSumm, argSummNRI, argNDSSumm, argNDSSummNRI, argNSPSumm, argNSPSummNRI, argRecordStatus, argSumByHand);
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.AbonentBillPos findByPrimaryKey(com.hps.july.persistence.AbonentBillPosKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AbonentBillPos _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f)container.preInvoke(this, 2, _EJS_s);
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
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAbonentBillPosesByPos2bill
	 */
	public java.util.Enumeration findAbonentBillPosesByPos2bill(com.hps.july.persistence.AbonentBillKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.findAbonentBillPosesByPos2bill(inKey);
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
	 * findAbonentBillPosesByPos2currency
	 */
	public java.util.Enumeration findAbonentBillPosesByPos2currency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.findAbonentBillPosesByPos2currency(inKey);
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
	 * findAbonentBillPosesByPos2resource
	 */
	public java.util.Enumeration findAbonentBillPosesByPos2resource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.findAbonentBillPosesByPos2resource(inKey);
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
	 * findByLeaseBill
	 */
	public java.util.Enumeration findByLeaseBill(java.lang.Integer leaseBill) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.findByLeaseBill(leaseBill);
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
			com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f)container.preInvoke(this, 7, _EJS_s);
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
			com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f)container.preInvoke(this, 8, _EJS_s);
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
			com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f)container.preInvoke(this, 9, _EJS_s);
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
			com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f beanRef = (com.hps.july.persistence.EJSCMPAbonentBillPosHomeBean_5236dd9f)container.preInvoke(this, 10, _EJS_s);
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
