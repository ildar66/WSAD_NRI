package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessContractSuppliesInfo_29bb2881
 */
public class EJSRemoteStatelessContractSuppliesInfo_29bb2881 extends EJSWrapper implements ContractSuppliesInfo {
	/**
	 * EJSRemoteStatelessContractSuppliesInfo_29bb2881
	 */
	public EJSRemoteStatelessContractSuppliesInfo_29bb2881() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getDeployedSupport
	 */
	public com.ibm.ejs.container.EJSDeployedSupport getDeployedSupport() {
		return container.getEJSDeployedSupport(this);
	}
	/**
	 * putDeployedSupport
	 */
	public void putDeployedSupport(com.ibm.ejs.container.EJSDeployedSupport support) {
		container.putEJSDeployedSupport(support);
		return;
	}
	/**
	 * getSuppliesSum
	 */
	public java.math.BigDecimal getSuppliesSum(java.lang.Integer argContract) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.ContractSuppliesInfoBean beanRef = (com.hps.july.inventory.sessionbean.ContractSuppliesInfoBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getSuppliesSum(argContract);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
