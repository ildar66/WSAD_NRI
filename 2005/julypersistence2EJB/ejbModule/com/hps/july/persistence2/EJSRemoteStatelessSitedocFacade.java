package com.hps.july.persistence2;

/**
 * EJSRemoteStatelessSitedocFacade
 */
public class EJSRemoteStatelessSitedocFacade extends com.hps.july.persistence2.EJSRemoteStatelessSitedocFacade_41d8fcb3 implements SitedocFacade {
	/**
	 * EJSRemoteStatelessSitedocFacade
	 */
	public EJSRemoteStatelessSitedocFacade() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getDeployedSupport
	 */
	public com.ibm.ejs.container.EJSDeployedSupport getDeployedSupport() {
		return new com.ibm.ejs.container.EJSDeployedSupport();
	}
	/**
	 * putDeployedSupport
	 */
	public void putDeployedSupport(com.ibm.ejs.container.EJSDeployedSupport support) {
		return;
	}
}
