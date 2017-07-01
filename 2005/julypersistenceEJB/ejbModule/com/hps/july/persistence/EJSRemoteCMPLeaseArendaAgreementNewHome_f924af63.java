package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPLeaseArendaAgreementNewHome_f924af63
 */
public class EJSRemoteCMPLeaseArendaAgreementNewHome_f924af63 extends EJSWrapper implements com.hps.july.persistence.LeaseArendaAgreementNewHome {
	/**
	 * EJSRemoteCMPLeaseArendaAgreementNewHome_f924af63
	 */
	public EJSRemoteCMPLeaseArendaAgreementNewHome_f924af63() throws java.rmi.RemoteException {
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
	 * create
	 */
	public com.hps.july.persistence.LeaseArendaAgreementNew create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber, java.lang.String argContractType, java.lang.String argContractState, java.lang.Integer argOrgCustomer, java.lang.Integer argOrgExecutor, java.sql.Date argStartDate, java.sql.Date argEndDate, java.lang.String argExtendType, java.lang.String argReportPeriod, java.lang.Boolean argIsActive, java.lang.String argHowGivePhones, java.lang.String argCalcElectroType, java.lang.Boolean argIsDogElectro, java.lang.String agrCustname, java.lang.String argExecname, java.lang.Integer argMainDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.LeaseArendaAgreementNew _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63 beanRef = (com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.create(argLeaseDocument, argDocDate, argDocNumber, argContractType, argContractState, argOrgCustomer, argOrgExecutor, argStartDate, argEndDate, argExtendType, argReportPeriod, argIsActive, argHowGivePhones, argCalcElectroType, argIsDogElectro, agrCustname, argExecname, argMainDocument);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseArendaAgreementNew findByPrimaryKey(com.hps.july.persistence.LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.LeaseArendaAgreementNew _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63 beanRef = (com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.findByPrimaryKey(key);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findByContractAndResource
	 */
	public java.util.Enumeration findByContractAndResource(java.lang.Integer contract, java.lang.Integer resource, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63 beanRef = (com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.findByContractAndResource(contract, resource, order);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isOrgCustomer, java.lang.Integer orgCustomer, java.lang.Boolean isOrgExecutor, java.lang.Integer orgExecutor, java.lang.Boolean isMainEconomist, java.lang.Integer mainEconomist, java.lang.Boolean isPosition, java.lang.Integer position, java.lang.Boolean isDocNumber, java.lang.String docNumber, java.lang.Boolean isState, java.lang.String state, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63 beanRef = (com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.findByQBE(isOrgCustomer, orgCustomer, isOrgExecutor, orgExecutor, isMainEconomist, mainEconomist, isPosition, position, isDocNumber, docNumber, isState, state, order);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.lang.Integer mainLeaseDocument, java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Boolean isContractState, java.lang.String contractState, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63 beanRef = (com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.findByQBE2(mainLeaseDocument, isIsActive, isActive, isContractState, contractState, order);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findByQBE3
	 */
	public java.util.Enumeration findByQBE3(java.lang.Boolean isEndDate, java.sql.Date startEndDate, java.sql.Date finishEndDate, java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Boolean isContractState, java.lang.String ContractState, java.lang.Boolean isExtendType, java.lang.String ExtendType, java.lang.Boolean isEconomist, java.lang.Integer economist) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63 beanRef = (com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.findByQBE3(isEndDate, startEndDate, finishEndDate, isIsActive, isActive, isContractState, ContractState, isExtendType, ExtendType, isEconomist, economist);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findByQBE4
	 */
	public java.util.Enumeration findByQBE4(java.lang.Boolean isEconomist, java.lang.Integer economist) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63 beanRef = (com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.findByQBE4(isEconomist, economist);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findByQBE5
	 */
	public java.util.Enumeration findByQBE5(java.lang.Boolean isOrgCustomer, java.lang.Integer orgCustomer, java.lang.Boolean isOrgExecutor, java.lang.Integer orgExecutor, java.lang.Boolean isMainEconomist, java.lang.Integer mainEconomist, java.lang.Boolean isPosition, java.lang.Integer position, java.lang.Boolean isDocNumber, java.lang.String docNumber, java.lang.Boolean isState, java.lang.String state, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63 beanRef = (com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.findByQBE5(isOrgCustomer, orgCustomer, isOrgExecutor, orgExecutor, isMainEconomist, mainEconomist, isPosition, position, isDocNumber, docNumber, isState, state, order);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findLeaseArendaAgreementNewsByMainposition
	 */
	public java.util.Enumeration findLeaseArendaAgreementNewsByMainposition(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63 beanRef = (com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.findLeaseArendaAgreementNewsByMainposition(inKey);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * getEJBMetaData
	 */
	public javax.ejb.EJBMetaData getEJBMetaData() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		javax.ejb.EJBMetaData _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63 beanRef = (com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.getEJBMetaData();
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
	 * getHomeHandle
	 */
	public javax.ejb.HomeHandle getHomeHandle() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		javax.ejb.HomeHandle _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63 beanRef = (com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.getHomeHandle();
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
	 * remove
	 */
	public void remove(java.lang.Object arg0) throws java.rmi.RemoteException, javax.ejb.RemoveException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63 beanRef = (com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63)container.preInvoke(this, 11, _EJS_s);
			beanRef.remove(arg0);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.RemoveException ex) {
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
	 * remove
	 */
	public void remove(javax.ejb.Handle arg0) throws java.rmi.RemoteException, javax.ejb.RemoveException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63 beanRef = (com.hps.july.persistence.EJSCMPLeaseArendaAgreementNewHomeBean_f924af63)container.preInvoke(this, 12, _EJS_s);
			beanRef.remove(arg0);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.RemoveException ex) {
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
}
