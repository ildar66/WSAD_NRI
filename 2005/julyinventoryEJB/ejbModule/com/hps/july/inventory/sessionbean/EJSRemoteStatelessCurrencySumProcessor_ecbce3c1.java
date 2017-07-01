package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessCurrencySumProcessor_ecbce3c1
 */
public class EJSRemoteStatelessCurrencySumProcessor_ecbce3c1 extends EJSWrapper implements CurrencySumProcessor {
	/**
	 * EJSRemoteStatelessCurrencySumProcessor_ecbce3c1
	 */
	public EJSRemoteStatelessCurrencySumProcessor_ecbce3c1() throws java.rmi.RemoteException {
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
	 * getBaseCurrency
	 */
	public com.hps.july.inventory.sessionbean.CurrencySumProcessingError getBaseCurrency() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.CurrencySumProcessingError _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.CurrencySumProcessorBean beanRef = (com.hps.july.inventory.sessionbean.CurrencySumProcessorBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getBaseCurrency();
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
	 * getDefaultRateType
	 */
	public com.hps.july.inventory.sessionbean.CurrencySumProcessingError getDefaultRateType() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.CurrencySumProcessingError _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.CurrencySumProcessorBean beanRef = (com.hps.july.inventory.sessionbean.CurrencySumProcessorBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getDefaultRateType();
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
	 * recalcSumToCurrency
	 */
	public com.hps.july.inventory.sessionbean.CurrencySumProcessingError recalcSumToCurrency(java.lang.Integer sourceCurrency, java.math.BigDecimal sourceSum, java.lang.Integer destCurrency, java.sql.Date currencyDate, java.lang.Integer currencyRateType) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.CurrencySumProcessingError _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.CurrencySumProcessorBean beanRef = (com.hps.july.inventory.sessionbean.CurrencySumProcessorBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.recalcSumToCurrency(sourceCurrency, sourceSum, destCurrency, currencyDate, currencyRateType);
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
