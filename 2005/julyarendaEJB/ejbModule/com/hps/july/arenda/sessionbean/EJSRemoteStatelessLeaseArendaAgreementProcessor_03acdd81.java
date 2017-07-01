package com.hps.july.arenda.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessLeaseArendaAgreementProcessor_03acdd81
 */
public class EJSRemoteStatelessLeaseArendaAgreementProcessor_03acdd81 extends EJSWrapper implements LeaseArendaAgreementProcessor {
	/**
	 * EJSRemoteStatelessLeaseArendaAgreementProcessor_03acdd81
	 */
	public EJSRemoteStatelessLeaseArendaAgreementProcessor_03acdd81() throws java.rmi.RemoteException {
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
	 * checkOpenPeriod
	 */
	public boolean checkOpenPeriod(int leasedocpositionCode) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessorBean beanRef = (com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessorBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.checkOpenPeriod(leasedocpositionCode);
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
	 * isChangeState
	 */
	public boolean isChangeState(int documentcode) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessorBean beanRef = (com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessorBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.isChangeState(documentcode);
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
	 * isChangeStateToEdit
	 */
	public boolean isChangeStateToEdit(int leaseDocument, boolean isExistDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessorBean beanRef = (com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessorBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.isChangeStateToEdit(leaseDocument, isExistDocument);
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
	 * isInitialSaldo
	 */
	public boolean isInitialSaldo(int leaseContractcode, int resourcecode, java.sql.Date salDate) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessorBean beanRef = (com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessorBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.isInitialSaldo(leaseContractcode, resourcecode, salDate);
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
	 * getBaseContract
	 */
	public int getBaseContract(int contract) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessorBean beanRef = (com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessorBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getBaseContract(contract);
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
	 * getEndDateOfContract
	 */
	public java.sql.Date getEndDateOfContract(int contract) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessorBean beanRef = (com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessorBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.getEndDateOfContract(contract);
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
	 * changeActiveDocument
	 */
	public void changeActiveDocument(java.lang.Integer mainDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessorBean beanRef = (com.hps.july.arenda.sessionbean.LeaseArendaAgreementProcessorBean)container.preInvoke(this, 6, _EJS_s);
			beanRef.changeActiveDocument(mainDocument);
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
}
