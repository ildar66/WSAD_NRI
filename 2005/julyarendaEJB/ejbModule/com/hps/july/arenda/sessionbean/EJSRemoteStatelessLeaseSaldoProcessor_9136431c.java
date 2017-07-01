package com.hps.july.arenda.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessLeaseSaldoProcessor_9136431c
 */
public class EJSRemoteStatelessLeaseSaldoProcessor_9136431c extends EJSWrapper implements LeaseSaldoProcessor {
	/**
	 * EJSRemoteStatelessLeaseSaldoProcessor_9136431c
	 */
	public EJSRemoteStatelessLeaseSaldoProcessor_9136431c() throws java.rmi.RemoteException {
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
	 * createSaldo
	 */
	public void createSaldo(java.lang.Integer leaseContract, java.sql.Date salDate, java.lang.Integer resource, java.lang.Integer mainCurrency, java.math.BigDecimal mainSum, java.math.BigDecimal mainNdsSum, int additionalCurrencycode, java.math.BigDecimal additionalSum, java.math.BigDecimal additionalNdsSum) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.sessionbean.LeaseSaldoProcessorBean beanRef = (com.hps.july.arenda.sessionbean.LeaseSaldoProcessorBean)container.preInvoke(this, 0, _EJS_s);
			beanRef.createSaldo(leaseContract, salDate, resource, mainCurrency, mainSum, mainNdsSum, additionalCurrencycode, additionalSum, additionalNdsSum);
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
		return ;
	}
	/**
	 * deleteSaldo
	 */
	public void deleteSaldo(java.lang.Integer leaseContract, java.sql.Date salDate, java.lang.Integer resource) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.sessionbean.LeaseSaldoProcessorBean beanRef = (com.hps.july.arenda.sessionbean.LeaseSaldoProcessorBean)container.preInvoke(this, 1, _EJS_s);
			beanRef.deleteSaldo(leaseContract, salDate, resource);
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
		return ;
	}
	/**
	 * updateSaldo
	 */
	public void updateSaldo(java.lang.Integer leaseContract, java.sql.Date salDate, java.lang.Integer resource, int mainCurrency, java.math.BigDecimal mainSum, java.math.BigDecimal mainNdsSum, int additionalCurrencycode, java.math.BigDecimal additionalSum, java.math.BigDecimal additionalNdsSum) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.sessionbean.LeaseSaldoProcessorBean beanRef = (com.hps.july.arenda.sessionbean.LeaseSaldoProcessorBean)container.preInvoke(this, 2, _EJS_s);
			beanRef.updateSaldo(leaseContract, salDate, resource, mainCurrency, mainSum, mainNdsSum, additionalCurrencycode, additionalSum, additionalNdsSum);
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
		return ;
	}
}
