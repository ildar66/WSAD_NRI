package com.hps.july.arenda.sessionbean;

/**
 * EJSRemoteStatefulArendaTransactionMethod
 */
public class EJSRemoteStatefulArendaTransactionMethod extends com.hps.july.arenda.sessionbean.EJSRemoteStatefulArendaTransactionMethod_7943be6e implements ArendaTransactionMethod {
	/**
	 * EJSRemoteStatefulArendaTransactionMethod
	 */
	public EJSRemoteStatefulArendaTransactionMethod() throws java.rmi.RemoteException {
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
