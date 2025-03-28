package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPPIEMxranLink_8e0472a7
 */
public class EJSRemoteCMPPIEMxranLink_8e0472a7 extends EJSWrapper implements PIEMxranLink {
	/**
	 * EJSRemoteCMPPIEMxranLink_8e0472a7
	 */
	public EJSRemoteCMPPIEMxranLink_8e0472a7() throws java.rmi.RemoteException {
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
	 * getMxranplatinum
	 */
	public com.hps.july.persistence.PIEMxranPlatinum getMxranplatinum() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.PIEMxranPlatinum _EJS_result = null;
		try {
			com.hps.july.persistence.PIEMxranLinkBean beanRef = (com.hps.july.persistence.PIEMxranLinkBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getMxranplatinum();
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
	 * getMxranplatinumKey
	 */
	public com.hps.july.persistence.PIEMxranPlatinumKey getMxranplatinumKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.PIEMxranPlatinumKey _EJS_result = null;
		try {
			com.hps.july.persistence.PIEMxranLinkBean beanRef = (com.hps.july.persistence.PIEMxranLinkBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getMxranplatinumKey();
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
	 * getMxrannri
	 */
	public int getMxrannri() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.PIEMxranLinkBean beanRef = (com.hps.july.persistence.PIEMxranLinkBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getMxrannri();
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
			com.hps.july.persistence.PIEMxranLinkBean beanRef = (com.hps.july.persistence.PIEMxranLinkBean)container.preInvoke(this, 3, _EJS_s);
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
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable arg0) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.PIEMxranLinkBean beanRef = (com.hps.july.persistence.PIEMxranLinkBean)container.preInvoke(this, 4, _EJS_s);
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
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
