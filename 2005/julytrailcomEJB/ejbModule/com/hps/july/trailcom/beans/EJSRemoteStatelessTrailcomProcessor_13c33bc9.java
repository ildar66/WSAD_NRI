package com.hps.july.trailcom.beans;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessTrailcomProcessor_13c33bc9
 */
public class EJSRemoteStatelessTrailcomProcessor_13c33bc9 extends EJSWrapper implements TrailcomProcessor {
	/**
	 * EJSRemoteStatelessTrailcomProcessor_13c33bc9
	 */
	public EJSRemoteStatelessTrailcomProcessor_13c33bc9() throws java.rmi.RemoteException {
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
	 * blockAddressSpace
	 */
	public void blockAddressSpace(int argStorageCard) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.TrailcomProcessorBean beanRef = (com.hps.july.trailcom.beans.TrailcomProcessorBean)container.preInvoke(this, 0, _EJS_s);
			beanRef.blockAddressSpace(argStorageCard);
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
		return ;
	}
	/**
	 * cancelDocument
	 */
	public void cancelDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.TrailcomProcessorBean beanRef = (com.hps.july.trailcom.beans.TrailcomProcessorBean)container.preInvoke(this, 1, _EJS_s);
			beanRef.cancelDocument(argDocument);
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
		return ;
	}
	/**
	 * closeAddressSpace
	 */
	public void closeAddressSpace(int argStorageCard) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.TrailcomProcessorBean beanRef = (com.hps.july.trailcom.beans.TrailcomProcessorBean)container.preInvoke(this, 2, _EJS_s);
			beanRef.closeAddressSpace(argStorageCard);
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
		return ;
	}
	/**
	 * openAddressSpace
	 */
	public void openAddressSpace(int argStorageCard) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.TrailcomProcessorBean beanRef = (com.hps.july.trailcom.beans.TrailcomProcessorBean)container.preInvoke(this, 3, _EJS_s);
			beanRef.openAddressSpace(argStorageCard);
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
		return ;
	}
	/**
	 * processDocument
	 */
	public void processDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.TrailcomProcessorBean beanRef = (com.hps.july.trailcom.beans.TrailcomProcessorBean)container.preInvoke(this, 4, _EJS_s);
			beanRef.processDocument(argDocument);
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
