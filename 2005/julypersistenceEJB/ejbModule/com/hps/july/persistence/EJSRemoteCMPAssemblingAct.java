package com.hps.july.persistence;

/**
 * EJSRemoteCMPAssemblingAct
 */
public class EJSRemoteCMPAssemblingAct extends com.hps.july.persistence.EJSRemoteCMPAssemblingAct_6fcd0905 implements AssemblingAct {
	/**
	 * EJSRemoteCMPAssemblingAct
	 */
	public EJSRemoteCMPAssemblingAct() throws java.rmi.RemoteException {
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
