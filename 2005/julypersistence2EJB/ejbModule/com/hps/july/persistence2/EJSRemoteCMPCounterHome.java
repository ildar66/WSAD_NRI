package com.hps.july.persistence2;

/**
 * EJSRemoteCMPCounterHome
 */
public class EJSRemoteCMPCounterHome extends com.hps.july.persistence2.EJSRemoteCMPCounterHome_b1595563 implements com.hps.july.persistence2.CounterHome {
	/**
	 * EJSRemoteCMPCounterHome
	 */
	public EJSRemoteCMPCounterHome() throws java.rmi.RemoteException {
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
