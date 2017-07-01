package com.hps.july.persistence2;

/**
 * EJSRemoteStatelessBeenetFacade
 */
public class EJSRemoteStatelessBeenetFacade extends com.hps.july.persistence2.EJSRemoteStatelessBeenetFacade_0cb5367e implements BeenetFacade {
	/**
	 * EJSRemoteStatelessBeenetFacade
	 */
	public EJSRemoteStatelessBeenetFacade() throws java.rmi.RemoteException {
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
