package com.hps.july.persistence;

/**
 * EJSRemoteCMPUserRepGroupHome
 */
public class EJSRemoteCMPUserRepGroupHome extends com.hps.july.persistence.EJSRemoteCMPUserRepGroupHome_1512cf12 implements com.hps.july.persistence.UserRepGroupHome {
	/**
	 * EJSRemoteCMPUserRepGroupHome
	 */
	public EJSRemoteCMPUserRepGroupHome() throws java.rmi.RemoteException {
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
