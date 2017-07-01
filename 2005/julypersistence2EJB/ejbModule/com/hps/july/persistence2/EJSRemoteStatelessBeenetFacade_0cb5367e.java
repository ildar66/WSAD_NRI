package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessBeenetFacade_0cb5367e
 */
public class EJSRemoteStatelessBeenetFacade_0cb5367e extends EJSWrapper implements BeenetFacade {
	/**
	 * EJSRemoteStatelessBeenetFacade_0cb5367e
	 */
	public EJSRemoteStatelessBeenetFacade_0cb5367e() throws java.rmi.RemoteException {
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
	 * createBeenet
	 */
	public void createBeenet(java.lang.String beenetid, int categid, int position, int[] equipment) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.BeenetFacadeBean beanRef = (com.hps.july.persistence2.BeenetFacadeBean)container.preInvoke(this, 0, _EJS_s);
			beanRef.createBeenet(beenetid, categid, position, equipment);
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
	 * deleteBeenet
	 */
	public void deleteBeenet(java.lang.String beenetid) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.BeenetFacadeBean beanRef = (com.hps.july.persistence2.BeenetFacadeBean)container.preInvoke(this, 1, _EJS_s);
			beanRef.deleteBeenet(beenetid);
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
	 * updateBeenet
	 */
	public void updateBeenet(java.lang.String beenetid, int categid, int[] equipment) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence2.BeenetFacadeBean beanRef = (com.hps.july.persistence2.BeenetFacadeBean)container.preInvoke(this, 2, _EJS_s);
			beanRef.updateBeenet(beenetid, categid, equipment);
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
}
