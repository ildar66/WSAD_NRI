package com.hps.july.config.beans;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPCfgSavedConfigHome_6e49ac1d
 */
public class EJSRemoteCMPCfgSavedConfigHome_6e49ac1d extends EJSWrapper implements com.hps.july.config.beans.CfgSavedConfigHome {
	/**
	 * EJSRemoteCMPCfgSavedConfigHome_6e49ac1d
	 */
	public EJSRemoteCMPCfgSavedConfigHome_6e49ac1d() throws java.rmi.RemoteException {
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
	public com.hps.july.config.beans.CfgSavedConfig create(int savconfigid, java.lang.String name) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.config.beans.CfgSavedConfig _EJS_result = null;
		try {
			com.hps.july.config.beans.EJSCMPCfgSavedConfigHomeBean_6e49ac1d beanRef = (com.hps.july.config.beans.EJSCMPCfgSavedConfigHomeBean_6e49ac1d)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.create(savconfigid, name);
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
	public com.hps.july.config.beans.CfgSavedConfig findByPrimaryKey(com.hps.july.config.beans.CfgSavedConfigKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.config.beans.CfgSavedConfig _EJS_result = null;
		try {
			com.hps.july.config.beans.EJSCMPCfgSavedConfigHomeBean_6e49ac1d beanRef = (com.hps.july.config.beans.EJSCMPCfgSavedConfigHomeBean_6e49ac1d)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.findByPrimaryKey(primaryKey);
		}
		catch (javax.ejb.FinderException ex) {
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
	 * getEJBMetaData
	 */
	public javax.ejb.EJBMetaData getEJBMetaData() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		javax.ejb.EJBMetaData _EJS_result = null;
		try {
			com.hps.july.config.beans.EJSCMPCfgSavedConfigHomeBean_6e49ac1d beanRef = (com.hps.july.config.beans.EJSCMPCfgSavedConfigHomeBean_6e49ac1d)container.preInvoke(this, 2, _EJS_s);
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
				container.postInvoke(this, 2, _EJS_s);
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
			com.hps.july.config.beans.EJSCMPCfgSavedConfigHomeBean_6e49ac1d beanRef = (com.hps.july.config.beans.EJSCMPCfgSavedConfigHomeBean_6e49ac1d)container.preInvoke(this, 3, _EJS_s);
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
				container.postInvoke(this, 3, _EJS_s);
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
			com.hps.july.config.beans.EJSCMPCfgSavedConfigHomeBean_6e49ac1d beanRef = (com.hps.july.config.beans.EJSCMPCfgSavedConfigHomeBean_6e49ac1d)container.preInvoke(this, 4, _EJS_s);
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
				container.postInvoke(this, 4, _EJS_s);
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
			com.hps.july.config.beans.EJSCMPCfgSavedConfigHomeBean_6e49ac1d beanRef = (com.hps.july.config.beans.EJSCMPCfgSavedConfigHomeBean_6e49ac1d)container.preInvoke(this, 5, _EJS_s);
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
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
