package com.hps.july.arenda.billing;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessTransfer_401727ca
 */
public class EJSRemoteStatelessTransfer_401727ca extends EJSWrapper implements Transfer {
	/**
	 * EJSRemoteStatelessTransfer_401727ca
	 */
	public EJSRemoteStatelessTransfer_401727ca() throws java.rmi.RemoteException {
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
	 * moveAllBufferNri2Nri
	 */
	public boolean moveAllBufferNri2Nri(int operator) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.TransferBean beanRef = (com.hps.july.arenda.billing.TransferBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.moveAllBufferNri2Nri(operator);
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
	 * moveAllPie2BufferNri
	 */
	public boolean moveAllPie2BufferNri(int operator) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.TransferBean beanRef = (com.hps.july.arenda.billing.TransferBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.moveAllPie2BufferNri(operator);
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
	/**
	 * moveAllPie2Nri
	 */
	public java.lang.Object[] moveAllPie2Nri(int operator) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Object[] _EJS_result = null;
		try {
			com.hps.july.arenda.billing.TransferBean beanRef = (com.hps.july.arenda.billing.TransferBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.moveAllPie2Nri(operator);
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
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
