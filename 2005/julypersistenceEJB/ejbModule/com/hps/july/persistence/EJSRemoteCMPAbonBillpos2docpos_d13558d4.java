package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPAbonBillpos2docpos_d13558d4
 */
public class EJSRemoteCMPAbonBillpos2docpos_d13558d4 extends EJSWrapper implements AbonBillpos2docpos {
	/**
	 * EJSRemoteCMPAbonBillpos2docpos_d13558d4
	 */
	public EJSRemoteCMPAbonBillpos2docpos_d13558d4() throws java.rmi.RemoteException {
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
	 * getBillpos
	 */
	public com.hps.july.persistence.AbonentBillPos getBillpos() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AbonentBillPos _EJS_result = null;
		try {
			com.hps.july.persistence.AbonBillpos2docposBean beanRef = (com.hps.july.persistence.AbonBillpos2docposBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getBillpos();
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
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getBillposKey
	 */
	public com.hps.july.persistence.AbonentBillPosKey getBillposKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AbonentBillPosKey _EJS_result = null;
		try {
			com.hps.july.persistence.AbonBillpos2docposBean beanRef = (com.hps.july.persistence.AbonBillpos2docposBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getBillposKey();
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
	 * getLeasedocposition
	 */
	public com.hps.july.persistence.LeaseDocPosition getLeasedocposition() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.LeaseDocPosition _EJS_result = null;
		try {
			com.hps.july.persistence.AbonBillpos2docposBean beanRef = (com.hps.july.persistence.AbonBillpos2docposBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getLeasedocposition();
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
	 * getLeasedocpositionKey
	 */
	public com.hps.july.persistence.LeaseDocPositionKey getLeasedocpositionKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.LeaseDocPositionKey _EJS_result = null;
		try {
			com.hps.july.persistence.AbonBillpos2docposBean beanRef = (com.hps.july.persistence.AbonBillpos2docposBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getLeasedocpositionKey();
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
				container.postInvoke(this, 3, _EJS_s);
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
			com.hps.july.persistence.AbonBillpos2docposBean beanRef = (com.hps.july.persistence.AbonBillpos2docposBean)container.preInvoke(this, 4, _EJS_s);
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
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * privateSetBillposKey
	 */
	public void privateSetBillposKey(com.hps.july.persistence.AbonentBillPosKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.AbonBillpos2docposBean beanRef = (com.hps.july.persistence.AbonBillpos2docposBean)container.preInvoke(this, 5, _EJS_s);
			beanRef.privateSetBillposKey(inKey);
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
		return ;
	}
	/**
	 * secondarySetBillpos
	 */
	public void secondarySetBillpos(com.hps.july.persistence.AbonentBillPos aBillpos) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.AbonBillpos2docposBean beanRef = (com.hps.july.persistence.AbonBillpos2docposBean)container.preInvoke(this, 6, _EJS_s);
			beanRef.secondarySetBillpos(aBillpos);
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
		return ;
	}
	/**
	 * setBillpos
	 */
	public void setBillpos(com.hps.july.persistence.AbonentBillPos aBillpos) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.AbonBillpos2docposBean beanRef = (com.hps.july.persistence.AbonBillpos2docposBean)container.preInvoke(this, 7, _EJS_s);
			beanRef.setBillpos(aBillpos);
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
		return ;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable arg0) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.AbonBillpos2docposBean beanRef = (com.hps.july.persistence.AbonBillpos2docposBean)container.preInvoke(this, 8, _EJS_s);
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
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
