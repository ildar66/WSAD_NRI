package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessContractFinder_f173df16
 */
public class EJSRemoteStatelessContractFinder_f173df16 extends EJSWrapper implements ContractFinder {
	/**
	 * EJSRemoteStatelessContractFinder_f173df16
	 */
	public EJSRemoteStatelessContractFinder_f173df16() throws java.rmi.RemoteException {
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
	 * findContractByParty
	 */
	public java.lang.Integer findContractByParty(java.lang.String party) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.ContractFinderBean beanRef = (com.hps.july.inventory.sessionbean.ContractFinderBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.findContractByParty(party);
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
	/**
	 * findContractBySerial
	 */
	public java.lang.Integer findContractBySerial(java.lang.String serial) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.ContractFinderBean beanRef = (com.hps.july.inventory.sessionbean.ContractFinderBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.findContractBySerial(serial);
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
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
