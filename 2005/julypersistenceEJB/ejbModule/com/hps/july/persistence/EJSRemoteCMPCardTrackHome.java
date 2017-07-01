package com.hps.july.persistence;

/**
 * EJSRemoteCMPCardTrackHome
 */
public class EJSRemoteCMPCardTrackHome extends com.hps.july.persistence.EJSRemoteCMPCardTrackHome_f33ec78d implements com.hps.july.persistence.CardTrackHome {
	/**
	 * EJSRemoteCMPCardTrackHome
	 */
	public EJSRemoteCMPCardTrackHome() throws java.rmi.RemoteException {
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
