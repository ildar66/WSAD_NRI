package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessChangeActProcessor_daccbe62
 */
public class EJSRemoteStatelessChangeActProcessor_daccbe62 extends EJSWrapper implements ChangeActProcessor {
	/**
	 * EJSRemoteStatelessChangeActProcessor_daccbe62
	 */
	public EJSRemoteStatelessChangeActProcessor_daccbe62() throws java.rmi.RemoteException {
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
	 * applyChangeAct
	 */
	public com.hps.july.inventory.sessionbean.DocumentProcessingException applyChangeAct(java.lang.Integer actCode) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.DocumentProcessingException _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.ChangeActProcessorBean beanRef = (com.hps.july.inventory.sessionbean.ChangeActProcessorBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.applyChangeAct(actCode);
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
	 * cancelChangeAct
	 */
	public com.hps.july.inventory.sessionbean.DocumentProcessingException cancelChangeAct(java.lang.Integer argAct) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.DocumentProcessingException _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.ChangeActProcessorBean beanRef = (com.hps.july.inventory.sessionbean.ChangeActProcessorBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.cancelChangeAct(argAct);
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
