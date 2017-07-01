package com.hps.july.persistence;

/**
 * EJSRemoteCMPPeople
 */
public class EJSRemoteCMPPeople extends com.hps.july.persistence.EJSRemoteCMPPeople_5bd41c74 implements People {
	/**
	 * EJSRemoteCMPPeople
	 */
	public EJSRemoteCMPPeople() throws java.rmi.RemoteException {
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
