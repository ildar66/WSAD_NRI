package com.hps.july.persistence;

/**
 * EJSRemoteCMPChangeAct
 */
public class EJSRemoteCMPChangeAct extends com.hps.july.persistence.EJSRemoteCMPChangeAct_1004ca71 implements ChangeAct {
	/**
	 * EJSRemoteCMPChangeAct
	 */
	public EJSRemoteCMPChangeAct() throws java.rmi.RemoteException {
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
