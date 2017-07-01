package com.hps.july.persistence;

/**
 * EJSRemoteCMPSearchGrouppingHome
 */
public class EJSRemoteCMPSearchGrouppingHome extends com.hps.july.persistence.EJSRemoteCMPSearchGrouppingHome_251bf269 implements com.hps.july.persistence.SearchGrouppingHome {
	/**
	 * EJSRemoteCMPSearchGrouppingHome
	 */
	public EJSRemoteCMPSearchGrouppingHome() throws java.rmi.RemoteException {
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
