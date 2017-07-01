package com.hps.july.persistence;

/**
 * EJSRemoteCMPOperatorHome
 */
public class EJSRemoteCMPOperatorHome extends com.hps.july.persistence.EJSRemoteCMPOperatorHome_b06d3afd implements com.hps.july.persistence.OperatorHome {
	/**
	 * EJSRemoteCMPOperatorHome
	 */
	public EJSRemoteCMPOperatorHome() throws java.rmi.RemoteException {
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
