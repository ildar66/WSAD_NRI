package com.hps.july.arenda.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessCalculateArendaAct_0dca3001
 */
public class EJSRemoteStatelessCalculateArendaAct_0dca3001 extends EJSWrapper implements CalculateArendaAct {
	/**
	 * EJSRemoteStatelessCalculateArendaAct_0dca3001
	 */
	public EJSRemoteStatelessCalculateArendaAct_0dca3001() throws java.rmi.RemoteException {
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
	 * calcAct
	 */
	public boolean calcAct(java.lang.Integer idAct, int operator, java.lang.Integer economist) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.calcAct(idAct, operator, economist);
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
	 * calcAct
	 */
	public boolean calcAct(java.lang.Integer idAct, int operator, java.lang.Integer economist, int argIdtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.calcAct(idAct, operator, economist, argIdtask);
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
	 * calculateContractSaldo
	 */
	public boolean calculateContractSaldo(java.lang.Integer idAct) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.calculateContractSaldo(idAct);
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
	 * checkAllResourcesInPaymentsTemp
	 */
	public boolean checkAllResourcesInPaymentsTemp(java.lang.Integer idAct) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.checkAllResourcesInPaymentsTemp(idAct);
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
	 * checkOplChargesTemp
	 */
	public boolean checkOplChargesTemp(java.lang.Integer idAct) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.checkOplChargesTemp(idAct);
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
	 * clearCharge2Pay
	 */
	public boolean clearCharge2Pay(java.lang.Integer idPayment, java.lang.Integer idCharge) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.clearCharge2Pay(idPayment, idCharge);
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
	 * clearCharge2PayTemp
	 */
	public boolean clearCharge2PayTemp(java.lang.Integer idAct, java.lang.Integer idPayment, java.lang.Integer idCharge) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.clearCharge2PayTemp(idAct, idPayment, idCharge);
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
	 * closeChargesInPeriodAct
	 */
	public boolean closeChargesInPeriodAct() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.closeChargesInPeriodAct();
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
	 * compareContracts
	 */
	public boolean compareContracts(java.lang.Integer idAct, int idContract1, int idContract2) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.compareContracts(idAct, idContract1, idContract2);
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
	 * createPayChargeSaldo
	 */
	public boolean createPayChargeSaldo(java.lang.Integer idAct) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.createPayChargeSaldo(idAct);
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
	 * findAndCalcComplementaryContracts
	 */
	public boolean findAndCalcComplementaryContracts() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.findAndCalcComplementaryContracts();
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
	 * findAndCalcComplementaryContractsTemp
	 */
	public boolean findAndCalcComplementaryContractsTemp(java.lang.Integer idAct) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 11, _EJS_s);
			_EJS_result = beanRef.findAndCalcComplementaryContractsTemp(idAct);
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
	 * getPreviousSaldoTemp
	 */
	public boolean getPreviousSaldoTemp(java.lang.Integer idAct) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 12, _EJS_s);
			_EJS_result = beanRef.getPreviousSaldoTemp(idAct);
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
	 * isMemberBeelineTemp
	 */
	public boolean isMemberBeelineTemp(java.lang.Integer idAct, com.hps.july.persistence.OrganizationAccessBean organization) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 13, _EJS_s);
			_EJS_result = beanRef.isMemberBeelineTemp(idAct, organization);
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
	 * linkCharge2PayTemp
	 */
	public boolean linkCharge2PayTemp(java.lang.Integer idAct, java.lang.Integer idPayment, java.lang.Integer idCharge) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 14, _EJS_s);
			_EJS_result = beanRef.linkCharge2PayTemp(idAct, idPayment, idCharge);
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
	 * setChargesRURRateTemp
	 */
	public boolean setChargesRURRateTemp(java.lang.Integer idAct, int idCharges) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 15, _EJS_s);
			_EJS_result = beanRef.setChargesRURRateTemp(idAct, idCharges);
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
	 * getComplementaryChargeByPayTemp
	 */
	public int getComplementaryChargeByPayTemp(java.lang.Integer idAct, int level, java.lang.Integer paymentId) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 16, _EJS_s);
			_EJS_result = beanRef.getComplementaryChargeByPayTemp(idAct, level, paymentId);
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
	 * getChargeRateTemp
	 */
	public java.math.BigDecimal getChargeRateTemp(int idAct, int idCharges, int paramCurrency, boolean onlyRead) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 17, _EJS_s);
			_EJS_result = beanRef.getChargeRateTemp(idAct, idCharges, paramCurrency, onlyRead);
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
	 * getPaymentRateTemp
	 */
	public java.math.BigDecimal getPaymentRateTemp(int idPaiment, int inCurrency, int idAct, boolean flagAutoSaveRate) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 18, _EJS_s);
			_EJS_result = beanRef.getPaymentRateTemp(idPaiment, inCurrency, idAct, flagAutoSaveRate);
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
	 * getSaldoContractTemp
	 */
	public java.math.BigDecimal getSaldoContractTemp(java.lang.Integer idAct, java.lang.Integer contract) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 19, _EJS_s);
			_EJS_result = beanRef.getSaldoContractTemp(idAct, contract);
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
	 * getSaldoContractResourceTemp
	 */
	public java.math.BigDecimal[] getSaldoContractResourceTemp(java.lang.Integer idAct, java.lang.Integer idContract, java.lang.Integer resource, int currency) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal[] _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.CalculateArendaActBean beanRef = (com.hps.july.arenda.sessionbean.CalculateArendaActBean)container.preInvoke(this, 20, _EJS_s);
			_EJS_result = beanRef.getSaldoContractResourceTemp(idAct, idContract, resource, currency);
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
}
