package com.hps.july.arenda.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessArendaDocumentProcessor_49b89b95
 */
public class EJSRemoteStatelessArendaDocumentProcessor_49b89b95 extends EJSWrapper implements ArendaDocumentProcessor {
	/**
	 * EJSRemoteStatelessArendaDocumentProcessor_49b89b95
	 */
	public EJSRemoteStatelessArendaDocumentProcessor_49b89b95() throws java.rmi.RemoteException {
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
	 * getDefaultBudjet
	 */
	public int getDefaultBudjet(int organization) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getDefaultBudjet(organization);
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
	 * getDefaultExpence
	 */
	public int getDefaultExpence(int organization) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getDefaultExpence(organization);
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
	 * makeAutomaticCharges
	 */
	public int makeAutomaticCharges(java.sql.Date dateFinish, java.lang.Integer economist, java.lang.Integer contract, java.lang.Integer operator) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.makeAutomaticCharges(dateFinish, economist, contract, operator);
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
	 * makeAutomaticPayments
	 */
	public int makeAutomaticPayments(java.sql.Date dateStart, java.sql.Date dateFinish, java.lang.Integer economist, java.lang.Integer contract, java.lang.Integer operator) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.makeAutomaticPayments(dateStart, dateFinish, economist, contract, operator);
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
	 * makeCalcForReport
	 */
	public int makeCalcForReport(int actCode, int operator) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.makeCalcForReport(actCode, operator);
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
	 * makeQryGetPays
	 */
	public int makeQryGetPays(int operator, java.lang.Integer contract, java.lang.Integer payment, java.sql.Date dstart, java.sql.Date dfinish) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.makeQryGetPays(operator, contract, payment, dstart, dfinish);
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
	 * moveBanToBilling
	 */
	public int moveBanToBilling(int contractcode) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.moveBanToBilling(contractcode);
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
	 * prolongLeaseArendaAgreement
	 */
	public int prolongLeaseArendaAgreement(java.sql.Date dateStart, java.sql.Date dateFinish, java.lang.Integer economist, java.lang.Integer contract, java.lang.Integer operator) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.prolongLeaseArendaAgreement(dateStart, dateFinish, economist, contract, operator);
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
	 * delShfOnAkt
	 */
	public java.lang.Object[] delShfOnAkt(int type, int actcode) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Object[] _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.delShfOnAkt(type, actcode);
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
	 * makeSchfOnAkt
	 */
	public java.lang.Object[] makeSchfOnAkt(int type, int actcode, int rule) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Object[] _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.makeSchfOnAkt(type, actcode, rule);
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
	 * moveContractToPie
	 */
	public java.lang.Object[] moveContractToPie(int leaseDocument, java.lang.String stateFrom, java.lang.String stateTo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Object[] _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.moveContractToPie(leaseDocument, stateFrom, stateTo);
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
	 * movePayToPie
	 */
	public java.lang.Object[] movePayToPie(int leaseDocPosition, java.lang.String stateFrom, java.lang.String stateTo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Object[] _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean)container.preInvoke(this, 11, _EJS_s);
			_EJS_result = beanRef.movePayToPie(leaseDocPosition, stateFrom, stateTo);
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
	 * prepareShetFact
	 */
	public java.lang.Object[] prepareShetFact(int chargecode) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Object[] _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean)container.preInvoke(this, 12, _EJS_s);
			_EJS_result = beanRef.prepareShetFact(chargecode);
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
	 * prepareShetFact
	 */
	public java.lang.Object[] prepareShetFact(int chargecode, java.lang.Integer argCurrency) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Object[] _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean)container.preInvoke(this, 13, _EJS_s);
			_EJS_result = beanRef.prepareShetFact(chargecode, argCurrency);
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
	 * getActNumber
	 */
	public java.lang.String getActNumber(int reglamentcode) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean beanRef = (com.hps.july.arenda.sessionbean.ArendaDocumentProcessorBean)container.preInvoke(this, 14, _EJS_s);
			_EJS_result = beanRef.getActNumber(reglamentcode);
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
}
