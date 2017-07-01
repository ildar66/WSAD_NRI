package com.hps.july.arenda.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatefulArendaTransactionMethod_7943be6e
 */
public class EJSRemoteStatefulArendaTransactionMethod_7943be6e extends EJSWrapper implements ArendaTransactionMethod {
	/**
	 * EJSRemoteStatefulArendaTransactionMethod_7943be6e
	 */
	public EJSRemoteStatefulArendaTransactionMethod_7943be6e() throws java.rmi.RemoteException {
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
	 * _addMutuallyBetweenContract
	 */
	public boolean _addMutuallyBetweenContract(java.lang.Integer contractDebet, java.lang.Integer contractCredit, java.math.BigDecimal mutuallySum) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef._addMutuallyBetweenContract(contractDebet, contractCredit, mutuallySum);
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
	 * _addToLeaseSaldo
	 */
	public boolean _addToLeaseSaldo(java.lang.Integer contract, java.lang.Integer resource, java.math.BigDecimal mainSum, java.math.BigDecimal additionalSum, java.math.BigDecimal ndsSum, java.math.BigDecimal additionalNdsSum) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef._addToLeaseSaldo(contract, resource, mainSum, additionalSum, ndsSum, additionalNdsSum);
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
	 * _linkCharge2Pay
	 */
	public boolean _linkCharge2Pay(javax.ejb.Handle payment, javax.ejb.Handle charge, java.math.BigDecimal payRate, java.lang.Integer tempAct, java.lang.Boolean byhand, java.lang.String source, int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef._linkCharge2Pay(payment, charge, payRate, tempAct, byhand, source, idtask);
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
	 * _makeSaldoCharge
	 */
	public boolean _makeSaldoCharge(javax.ejb.Handle saldo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef._makeSaldoCharge(saldo);
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
		return _EJS_result;
	}
	/**
	 * _makeSaldoPayment
	 */
	public boolean _makeSaldoPayment(javax.ejb.Handle saldo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef._makeSaldoPayment(saldo);
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
		return _EJS_result;
	}
	/**
	 * _setLeaseChargesRemainderRate
	 */
	public boolean _setLeaseChargesRemainderRate(javax.ejb.Handle charge, java.math.BigDecimal rate) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef._setLeaseChargesRemainderRate(charge, rate);
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
		return _EJS_result;
	}
	/**
	 * _setLeaseDnopChargeRURSum
	 */
	public boolean _setLeaseDnopChargeRURSum(javax.ejb.Handle dnop, java.math.BigDecimal rateCharge) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef._setLeaseDnopChargeRURSum(dnop, rateCharge);
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
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * clearCharge2Pay
	 */
	public boolean clearCharge2Pay(javax.ejb.Handle dnop, int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.clearCharge2Pay(dnop, idtask);
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
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * clearCharge2PayOnAktLink
	 */
	public boolean clearCharge2PayOnAktLink(java.lang.Integer idAkt) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.clearCharge2PayOnAktLink(idAkt);
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
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * clearLeasevpayment
	 */
	public boolean clearLeasevpayment() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.clearLeasevpayment();
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
				container.postInvoke(this, 9, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * createChargeOrPaymentOnSaldo
	 */
	public boolean createChargeOrPaymentOnSaldo(java.lang.Integer contract, java.util.Date sldDate, java.lang.Integer resource) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.createChargeOrPaymentOnSaldo(contract, sldDate, resource);
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
				container.postInvoke(this, 10, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * createSaldo
	 */
	public boolean createSaldo(java.lang.Integer leaseContract, java.util.Date salDate, java.lang.Integer resource, java.lang.Integer mainCurrency, java.math.BigDecimal mainSum, java.math.BigDecimal mainNdsSum, int additionalCurrencycode, java.math.BigDecimal additionalSum, java.math.BigDecimal additionalNdsSum) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 11, _EJS_s);
			_EJS_result = beanRef.createSaldo(leaseContract, salDate, resource, mainCurrency, mainSum, mainNdsSum, additionalCurrencycode, additionalSum, additionalNdsSum);
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
				container.postInvoke(this, 11, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * deleteChargeOrPaymentOnSaldo
	 */
	public boolean deleteChargeOrPaymentOnSaldo(java.lang.Integer contract, java.util.Date sldDate, java.lang.Integer resource) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 12, _EJS_s);
			_EJS_result = beanRef.deleteChargeOrPaymentOnSaldo(contract, sldDate, resource);
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
				container.postInvoke(this, 12, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * fillUsedInAct
	 */
	public boolean fillUsedInAct(boolean fill) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 13, _EJS_s);
			_EJS_result = beanRef.fillUsedInAct(fill);
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
				container.postInvoke(this, 13, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * removeSaldo
	 */
	public boolean removeSaldo(java.lang.Integer contract, java.util.Date sldDate, java.lang.Integer resource) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 14, _EJS_s);
			_EJS_result = beanRef.removeSaldo(contract, sldDate, resource);
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
				container.postInvoke(this, 14, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * rollbackCalcAct
	 */
	public boolean rollbackCalcAct(java.lang.Integer idAct) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 15, _EJS_s);
			_EJS_result = beanRef.rollbackCalcAct(idAct);
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
				container.postInvoke(this, 15, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * rollbackCalcAct
	 */
	public boolean rollbackCalcAct(java.lang.Integer idAct, int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 16, _EJS_s);
			_EJS_result = beanRef.rollbackCalcAct(idAct, idtask);
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
				container.postInvoke(this, 16, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * setRateRurForPayment
	 */
	public boolean setRateRurForPayment() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 17, _EJS_s);
			_EJS_result = beanRef.setRateRurForPayment();
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
				container.postInvoke(this, 17, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * updateSaldo
	 */
	public boolean updateSaldo(java.lang.Integer leaseContract, java.util.Date salDate, java.lang.Integer resource, int mainCurrency, java.math.BigDecimal mainSum, java.math.BigDecimal mainNdsSum, int additionalCurrencycode, java.math.BigDecimal additionalSum, java.math.BigDecimal additionalNdsSum) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 18, _EJS_s);
			_EJS_result = beanRef.updateSaldo(leaseContract, salDate, resource, mainCurrency, mainSum, mainNdsSum, additionalCurrencycode, additionalSum, additionalNdsSum);
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
				container.postInvoke(this, 18, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * _makeCompensationCharge
	 */
	public java.lang.Integer _makeCompensationCharge(javax.ejb.Handle payment) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 19, _EJS_s);
			_EJS_result = beanRef._makeCompensationCharge(payment);
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
				container.postInvoke(this, 19, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * _makeCompensationPayment
	 */
	public java.lang.Integer _makeCompensationPayment(javax.ejb.Handle charge) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 20, _EJS_s);
			_EJS_result = beanRef._makeCompensationPayment(charge);
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
				container.postInvoke(this, 20, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * _makeMutualCharge
	 */
	public java.lang.Integer _makeMutualCharge(javax.ejb.Handle payment, java.math.BigDecimal minSum) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 21, _EJS_s);
			_EJS_result = beanRef._makeMutualCharge(payment, minSum);
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
				container.postInvoke(this, 21, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * _makeMutualPayment
	 */
	public java.lang.Integer _makeMutualPayment(javax.ejb.Handle charge, java.math.BigDecimal minSum) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 22, _EJS_s);
			_EJS_result = beanRef._makeMutualPayment(charge, minSum);
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
				container.postInvoke(this, 22, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * defineRatePaymentOnContract
	 */
	public java.lang.Object[] defineRatePaymentOnContract(java.lang.Integer idPayment, java.lang.Integer currency) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Object[] _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 23, _EJS_s);
			_EJS_result = beanRef.defineRatePaymentOnContract(idPayment, currency);
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
				container.postInvoke(this, 23, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * defineRatePaymentOnContract
	 */
	public java.lang.Object[] defineRatePaymentOnContract(java.lang.Integer currency, java.lang.Integer idContract, java.util.Date payDate, java.util.Date billDATE, java.util.Date beginDate, java.util.Date endDate, java.lang.Integer payId) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Object[] _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 24, _EJS_s);
			_EJS_result = beanRef.defineRatePaymentOnContract(currency, idContract, payDate, billDATE, beginDate, endDate, payId);
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
				container.postInvoke(this, 24, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * calcNds
	 */
	public java.math.BigDecimal calcNds(java.lang.Integer resource, java.util.Date localDate, java.math.BigDecimal localSum, java.lang.String typeCalc, int idTask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 25, _EJS_s);
			_EJS_result = beanRef.calcNds(resource, localDate, localSum, typeCalc, idTask);
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
				container.postInvoke(this, 25, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getChargeRate
	 */
	public java.math.BigDecimal getChargeRate(javax.ejb.Handle charge, int paramCurrency, boolean onlyRead) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 26, _EJS_s);
			_EJS_result = beanRef.getChargeRate(charge, paramCurrency, onlyRead);
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
				container.postInvoke(this, 26, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getChargeRateTemp
	 */
	public java.math.BigDecimal getChargeRateTemp(javax.ejb.Handle charge, int paramCurrency, boolean onlyRead, int idAct) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 27, _EJS_s);
			_EJS_result = beanRef.getChargeRateTemp(charge, paramCurrency, onlyRead, idAct);
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
				container.postInvoke(this, 27, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPaymentRate
	 */
	public java.math.BigDecimal getPaymentRate(javax.ejb.Handle payment, int inCurrency, boolean readOnly, java.lang.Integer actid, boolean otherUser) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 28, _EJS_s);
			_EJS_result = beanRef.getPaymentRate(payment, inCurrency, readOnly, actid, otherUser);
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
				container.postInvoke(this, 28, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPaymentRateTemp
	 */
	public java.math.BigDecimal getPaymentRateTemp(javax.ejb.Handle payment, int inCurrency, boolean readOnly, int idAct) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 29, _EJS_s);
			_EJS_result = beanRef.getPaymentRateTemp(payment, inCurrency, readOnly, idAct);
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
				container.postInvoke(this, 29, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * setChargeRemainderRate
	 */
	public java.math.BigDecimal setChargeRemainderRate(javax.ejb.Handle handle) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 30, _EJS_s);
			_EJS_result = beanRef.setChargeRemainderRate(handle);
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
				container.postInvoke(this, 30, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * _newCalcRate
	 */
	public void _newCalcRate(int leaseDocPosition, int currency, java.math.BigDecimal rate) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 31, _EJS_s);
			beanRef._newCalcRate(leaseDocPosition, currency, rate);
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
				container.postInvoke(this, 31, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * createSaldoSergey
	 */
	public void createSaldoSergey(java.lang.Integer leaseContract, java.util.Date salDate, java.lang.Integer resource, java.lang.Integer mainCurrency, java.math.BigDecimal mainSum, java.math.BigDecimal mainNdsSum, int additionalCurrencycode, java.math.BigDecimal additionalSum, java.math.BigDecimal additionalNdsSum) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 32, _EJS_s);
			beanRef.createSaldoSergey(leaseContract, salDate, resource, mainCurrency, mainSum, mainNdsSum, additionalCurrencycode, additionalSum, additionalNdsSum);
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
				container.postInvoke(this, 32, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * updateSaldoSergey
	 */
	public void updateSaldoSergey(java.lang.Integer leaseContract, java.util.Date salDate, java.lang.Integer resource, int mainCurrency, java.math.BigDecimal mainSum, java.math.BigDecimal mainNdsSum, int additionalCurrencycode, java.math.BigDecimal additionalSum, java.math.BigDecimal additionalNdsSum) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean beanRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethodBean)container.preInvoke(this, 33, _EJS_s);
			beanRef.updateSaldoSergey(leaseContract, salDate, resource, mainCurrency, mainSum, mainNdsSum, additionalCurrencycode, additionalSum, additionalNdsSum);
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
				container.postInvoke(this, 33, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
