package com.hps.july.persistence;

/**
 * EJSRemoteCMPPositionResponsibleWorkers
 */
public class EJSRemoteCMPPositionResponsibleWorkers extends com.hps.july.persistence.EJSRemoteCMPPositionResponsibleWorkers_5cb3b8ab implements PositionResponsibleWorkers {
	/**
	 * EJSRemoteCMPPositionResponsibleWorkers
	 */
	public EJSRemoteCMPPositionResponsibleWorkers() throws java.rmi.RemoteException {
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
