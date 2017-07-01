package com.hps.july.persistence;

/**
 * EJSRemoteCMPDirectionHome
 */
public class EJSRemoteCMPDirectionHome extends com.hps.july.persistence.EJSRemoteCMPDirectionHome_ef0dc99a implements com.hps.july.persistence.DirectionHome {
	/**
	 * EJSRemoteCMPDirectionHome
	 */
	public EJSRemoteCMPDirectionHome() throws java.rmi.RemoteException {
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
