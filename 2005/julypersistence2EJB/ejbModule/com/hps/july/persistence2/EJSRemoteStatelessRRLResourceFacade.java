package com.hps.july.persistence2;

/**
 * EJSRemoteStatelessRRLResourceFacade
 */
public class EJSRemoteStatelessRRLResourceFacade extends com.hps.july.persistence2.EJSRemoteStatelessRRLResourceFacade_d111db25 implements RRLResourceFacade {
	/**
	 * EJSRemoteStatelessRRLResourceFacade
	 */
	public EJSRemoteStatelessRRLResourceFacade() throws java.rmi.RemoteException {
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
