package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessRRLResourceFacade_d111db25
 */
public class EJSRemoteStatelessRRLResourceFacade_d111db25 extends EJSWrapper implements RRLResourceFacade {
	/**
	 * EJSRemoteStatelessRRLResourceFacade_d111db25
	 */
	public EJSRemoteStatelessRRLResourceFacade_d111db25() throws java.rmi.RemoteException {
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
	 * createRRLAntParams
	 */
	public void createRRLAntParams(com.hps.july.persistence2.RRLResourceParamsValue paramsValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.RRLResourceFacadeBean beanRef = (com.hps.july.persistence2.RRLResourceFacadeBean)container.preInvoke(this, 0, _EJS_s);
			beanRef.createRRLAntParams(paramsValue);
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
	 * createRRLAntena
	 */
	public void createRRLAntena(com.hps.july.persistence2.RRLAntenaValue antenaValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.RRLResourceFacadeBean beanRef = (com.hps.july.persistence2.RRLResourceFacadeBean)container.preInvoke(this, 1, _EJS_s);
			beanRef.createRRLAntena(antenaValue);
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
	 * createRRLSpeedParams
	 */
	public void createRRLSpeedParams(com.hps.july.persistence2.RRLResourceSpeedParamsValue speedValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.RRLResourceFacadeBean beanRef = (com.hps.july.persistence2.RRLResourceFacadeBean)container.preInvoke(this, 2, _EJS_s);
			beanRef.createRRLSpeedParams(speedValue);
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
	 * deleteRRLAntena
	 */
	public void deleteRRLAntena(int resource) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.RRLResourceFacadeBean beanRef = (com.hps.july.persistence2.RRLResourceFacadeBean)container.preInvoke(this, 3, _EJS_s);
			beanRef.deleteRRLAntena(resource);
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
	 * updateRRLAntParams
	 */
	public void updateRRLAntParams(com.hps.july.persistence2.RRLResourceParamsValue paramsValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.RRLResourceFacadeBean beanRef = (com.hps.july.persistence2.RRLResourceFacadeBean)container.preInvoke(this, 4, _EJS_s);
			beanRef.updateRRLAntParams(paramsValue);
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
	 * updateRRLAntena
	 */
	public void updateRRLAntena(com.hps.july.persistence2.RRLAntenaValue antenaValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.RRLResourceFacadeBean beanRef = (com.hps.july.persistence2.RRLResourceFacadeBean)container.preInvoke(this, 5, _EJS_s);
			beanRef.updateRRLAntena(antenaValue);
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
	 * updateRRLSpeedParams
	 */
	public void updateRRLSpeedParams(com.hps.july.persistence2.RRLResourceSpeedParamsValue speedValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.RRLResourceFacadeBean beanRef = (com.hps.july.persistence2.RRLResourceFacadeBean)container.preInvoke(this, 6, _EJS_s);
			beanRef.updateRRLSpeedParams(speedValue);
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
}
