package com.hps.july.platinum.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessArendaPlatinumProcessor_6bcc1db9
 */
public class EJSRemoteStatelessArendaPlatinumProcessor_6bcc1db9 extends EJSWrapper implements ArendaPlatinumProcessor {
	/**
	 * EJSRemoteStatelessArendaPlatinumProcessor_6bcc1db9
	 */
	public EJSRemoteStatelessArendaPlatinumProcessor_6bcc1db9() throws java.rmi.RemoteException {
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
	 * isProcessingEnabled
	 */
	public boolean isProcessingEnabled() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.isProcessingEnabled();
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
	 * makeQryGetBanks
	 */
	public int makeQryGetBanks(int operator, java.lang.Integer bank) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.makeQryGetBanks(operator, bank);
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
	 * makeQryGetPays
	 */
	public int makeQryGetPays(int operator, java.lang.Integer contract, java.lang.Integer payment, java.sql.Date payDateStart, java.sql.Date payDateFinish) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.makeQryGetPays(operator, contract, payment, payDateStart, payDateFinish);
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
	 * makeQryGetSprArenda
	 */
	public int makeQryGetSprArenda(int operator) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.makeQryGetSprArenda(operator);
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
	 * makeQueryGetBanks
	 */
	public void makeQueryGetBanks(java.lang.Integer paramIdBank, java.lang.Integer operator) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean)container.preInvoke(this, 4, _EJS_s);
			beanRef.makeQueryGetBanks(paramIdBank, operator);
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
	 * makeQueryGetPaymentsFromPlatinum
	 */
	public void makeQueryGetPaymentsFromPlatinum(java.sql.Timestamp paramDateStart, java.lang.Integer paramIdDogovor, java.lang.Integer operator) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean)container.preInvoke(this, 5, _EJS_s);
			beanRef.makeQueryGetPaymentsFromPlatinum(paramDateStart, paramIdDogovor, operator);
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
	/**
	 * makeQueryGetSimpleSprav
	 */
	public void makeQueryGetSimpleSprav(java.lang.Integer operator) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean)container.preInvoke(this, 6, _EJS_s);
			beanRef.makeQueryGetSimpleSprav(operator);
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
		return ;
	}
	/**
	 * makeQueryMoveAccountInPlatinum
	 */
	public void makeQueryMoveAccountInPlatinum(java.lang.String paramTypeAction, java.lang.Integer paramAccount, java.lang.Integer operator) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean)container.preInvoke(this, 7, _EJS_s);
			beanRef.makeQueryMoveAccountInPlatinum(paramTypeAction, paramAccount, operator);
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
		return ;
	}
	/**
	 * makeQueryMovePartnerInPlatinum
	 */
	public void makeQueryMovePartnerInPlatinum(java.lang.String paramTypeAction, java.lang.Integer paramPartner, java.lang.Integer operator) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean)container.preInvoke(this, 8, _EJS_s);
			beanRef.makeQueryMovePartnerInPlatinum(paramTypeAction, paramPartner, operator);
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
		return ;
	}
	/**
	 * moveAllPaymentsPlatinum2Nri
	 */
	public void moveAllPaymentsPlatinum2Nri(int paramOperator) throws java.rmi.RemoteException, java.lang.Exception {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean)container.preInvoke(this, 9, _EJS_s);
			beanRef.moveAllPaymentsPlatinum2Nri(paramOperator);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.RuntimeException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.Exception ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
		return ;
	}
	/**
	 * moveBanksPlatinumToNri
	 */
	public void moveBanksPlatinumToNri(int operatorId) throws java.rmi.RemoteException, java.lang.Exception {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean)container.preInvoke(this, 10, _EJS_s);
			beanRef.moveBanksPlatinumToNri(operatorId);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.RuntimeException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.Exception ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
		return ;
	}
	/**
	 * moveDogovorNriToPlatinum
	 */
	public void moveDogovorNriToPlatinum(int paramOperator, java.lang.Integer idDogovor, java.lang.String stateFrom, java.lang.String stateTo) throws javax.naming.NamingException, javax.ejb.CreateException, java.rmi.RemoteException, java.lang.Exception {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean)container.preInvoke(this, 11, _EJS_s);
			beanRef.moveDogovorNriToPlatinum(paramOperator, idDogovor, stateFrom, stateTo);
		}
		catch (javax.naming.NamingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.RuntimeException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.Exception ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
		return ;
	}
	/**
	 * movePaymentNriToPlatinum
	 */
	public void movePaymentNriToPlatinum(int operatorId, java.lang.String typeAction, java.lang.Integer idPaiment, java.lang.String stateFrom, java.lang.String stateTo) throws java.rmi.RemoteException, java.lang.Exception {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean)container.preInvoke(this, 12, _EJS_s);
			beanRef.movePaymentNriToPlatinum(operatorId, typeAction, idPaiment, stateFrom, stateTo);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.RuntimeException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (java.lang.Exception ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
		return ;
	}
	/**
	 * test
	 */
	public void test(int i) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorBean)container.preInvoke(this, 13, _EJS_s);
			beanRef.test(i);
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
		return ;
	}
}
