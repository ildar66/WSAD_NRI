package com.hps.july.persistence2;

/**
 * EJSRemoteCMPRRLDocs
 */
public class EJSRemoteCMPRRLDocs extends com.hps.july.persistence2.EJSRemoteCMPRRLDocs_d716392c implements RRLDocs {
	/**
	 * EJSRemoteCMPRRLDocs
	 */
	public EJSRemoteCMPRRLDocs() throws java.rmi.RemoteException {
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
