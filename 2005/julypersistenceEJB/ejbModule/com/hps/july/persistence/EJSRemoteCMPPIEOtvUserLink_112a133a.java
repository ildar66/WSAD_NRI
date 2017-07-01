package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPPIEOtvUserLink_112a133a
 */
public class EJSRemoteCMPPIEOtvUserLink_112a133a extends EJSWrapper implements PIEOtvUserLink {
	/**
	 * EJSRemoteCMPPIEOtvUserLink_112a133a
	 */
	public EJSRemoteCMPPIEOtvUserLink_112a133a() throws java.rmi.RemoteException {
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
	 * getOtvuserplatinum
	 */
	public com.hps.july.persistence.PIEOtvUserPlatinum getOtvuserplatinum() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.PIEOtvUserPlatinum _EJS_result = null;
		try {
			com.hps.july.persistence.PIEOtvUserLinkBean beanRef = (com.hps.july.persistence.PIEOtvUserLinkBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getOtvuserplatinum();
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
	 * getOtvuserplatinumKey
	 */
	public com.hps.july.persistence.PIEOtvUserPlatinumKey getOtvuserplatinumKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.PIEOtvUserPlatinumKey _EJS_result = null;
		try {
			com.hps.july.persistence.PIEOtvUserLinkBean beanRef = (com.hps.july.persistence.PIEOtvUserLinkBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getOtvuserplatinumKey();
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
	 * getOtvusernri
	 */
	public int getOtvusernri() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.PIEOtvUserLinkBean beanRef = (com.hps.july.persistence.PIEOtvUserLinkBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getOtvusernri();
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
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Hashtable _EJS_result = null;
		try {
			com.hps.july.persistence.PIEOtvUserLinkBean beanRef = (com.hps.july.persistence.PIEOtvUserLinkBean)container.preInvoke(this, 3, _EJS_s);
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
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * privateSetOtvuserplatinumKey
	 */
	public void privateSetOtvuserplatinumKey(com.hps.july.persistence.PIEOtvUserPlatinumKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.PIEOtvUserLinkBean beanRef = (com.hps.july.persistence.PIEOtvUserLinkBean)container.preInvoke(this, 4, _EJS_s);
			beanRef.privateSetOtvuserplatinumKey(inKey);
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
		return ;
	}
	/**
	 * secondarySetOtvuserplatinum
	 */
	public void secondarySetOtvuserplatinum(com.hps.july.persistence.PIEOtvUserPlatinum anOtvuserplatinum) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.PIEOtvUserLinkBean beanRef = (com.hps.july.persistence.PIEOtvUserLinkBean)container.preInvoke(this, 5, _EJS_s);
			beanRef.secondarySetOtvuserplatinum(anOtvuserplatinum);
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
	 * setOtvuserplatinum
	 */
	public void setOtvuserplatinum(com.hps.july.persistence.PIEOtvUserPlatinum anOtvuserplatinum) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.PIEOtvUserLinkBean beanRef = (com.hps.july.persistence.PIEOtvUserLinkBean)container.preInvoke(this, 6, _EJS_s);
			beanRef.setOtvuserplatinum(anOtvuserplatinum);
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
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable arg0) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.PIEOtvUserLinkBean beanRef = (com.hps.july.persistence.PIEOtvUserLinkBean)container.preInvoke(this, 7, _EJS_s);
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
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
