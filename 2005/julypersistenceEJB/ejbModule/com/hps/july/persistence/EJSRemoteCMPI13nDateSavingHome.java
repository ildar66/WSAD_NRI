package com.hps.july.persistence;

/**
 * EJSRemoteCMPI13nDateSavingHome
 */
public class EJSRemoteCMPI13nDateSavingHome extends com.hps.july.persistence.EJSRemoteCMPI13nDateSavingHome_85b3cc12 implements com.hps.july.persistence.I13nDateSavingHome {
	/**
	 * EJSRemoteCMPI13nDateSavingHome
	 */
	public EJSRemoteCMPI13nDateSavingHome() throws java.rmi.RemoteException {
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
