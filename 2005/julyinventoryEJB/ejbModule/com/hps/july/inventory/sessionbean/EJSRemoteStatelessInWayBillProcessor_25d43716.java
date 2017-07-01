package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessInWayBillProcessor_25d43716
 */
public class EJSRemoteStatelessInWayBillProcessor_25d43716 extends EJSWrapper implements InWayBillProcessor {
	/**
	 * EJSRemoteStatelessInWayBillProcessor_25d43716
	 */
	public EJSRemoteStatelessInWayBillProcessor_25d43716() throws java.rmi.RemoteException {
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
	 * calcPrice
	 */
	public com.hps.july.inventory.sessionbean.CurrencySumProcessingError calcPrice(java.lang.Integer argDocPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.CurrencySumProcessingError _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.InWayBillProcessorBean beanRef = (com.hps.july.inventory.sessionbean.InWayBillProcessorBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.calcPrice(argDocPosition);
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
	 * applyDocument
	 */
	public com.hps.july.inventory.sessionbean.DocumentProcessingException applyDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.DocumentProcessingException _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.InWayBillProcessorBean beanRef = (com.hps.july.inventory.sessionbean.InWayBillProcessorBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.applyDocument(argDocument);
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
	 * cancelDocument
	 */
	public com.hps.july.inventory.sessionbean.DocumentProcessingException cancelDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.DocumentProcessingException _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.InWayBillProcessorBean beanRef = (com.hps.july.inventory.sessionbean.InWayBillProcessorBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.cancelDocument(argDocument);
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
	/**
	 * changeOuterDocPositionPrice
	 */
	public void changeOuterDocPositionPrice(java.lang.Integer argOuterDocPosition, java.math.BigDecimal argNewPrice) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.inventory.sessionbean.InWayBillProcessorBean beanRef = (com.hps.july.inventory.sessionbean.InWayBillProcessorBean)container.preInvoke(this, 3, _EJS_s);
			beanRef.changeOuterDocPositionPrice(argOuterDocPosition, argNewPrice);
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
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * dropOuterDocPosition
	 */
	public void dropOuterDocPosition(java.lang.Integer argOuterDocPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.inventory.sessionbean.InWayBillProcessorBean beanRef = (com.hps.july.inventory.sessionbean.InWayBillProcessorBean)container.preInvoke(this, 4, _EJS_s);
			beanRef.dropOuterDocPosition(argOuterDocPosition);
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
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSerial
	 */
	public void setSerial(java.lang.Integer argDocPosition, java.lang.String newSerial, java.lang.String newManucode) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.inventory.sessionbean.InWayBillProcessorBean beanRef = (com.hps.july.inventory.sessionbean.InWayBillProcessorBean)container.preInvoke(this, 5, _EJS_s);
			beanRef.setSerial(argDocPosition, newSerial, newManucode);
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
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
