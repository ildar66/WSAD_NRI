package com.hps.july.persistence;

/**
 * EJSRemoteCMPSwitch
 */
public class EJSRemoteCMPSwitch extends com.hps.july.persistence.EJSRemoteCMPSwitch_dc445190 implements Switch {
	/**
	 * EJSRemoteCMPSwitch
	 */
	public EJSRemoteCMPSwitch() throws java.rmi.RemoteException {
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
