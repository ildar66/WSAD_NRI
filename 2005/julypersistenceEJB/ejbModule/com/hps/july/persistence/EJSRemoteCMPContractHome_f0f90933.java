package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPContractHome_f0f90933
 */
public class EJSRemoteCMPContractHome_f0f90933 extends EJSWrapper implements com.hps.july.persistence.ContractHome {
	/**
	 * EJSRemoteCMPContractHome_f0f90933
	 */
	public EJSRemoteCMPContractHome_f0f90933() throws java.rmi.RemoteException {
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
	public com.hps.july.persistence.Contract create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Contract _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 beanRef = (com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.create(argDocument);
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
	 * create
	 */
	public com.hps.july.persistence.Contract create(int argDocument, java.lang.Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Integer argCurrency, java.lang.String argName, java.lang.Integer argWorker, java.lang.Integer argController, java.sql.Date argStartDate, java.sql.Date argFinishDate, java.math.BigDecimal argSum, java.lang.Integer argSupplyType, java.lang.Integer argBaseAgreement) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Contract _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 beanRef = (com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.create(argDocument, argOwner, argBlankDate, argBlankindex, argBlankNumber, argState, argCurrency, argName, argWorker, argController, argStartDate, argFinishDate, argSum, argSupplyType, argBaseAgreement);
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
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Contract findByPrimaryKey(com.hps.july.persistence.DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Contract _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 beanRef = (com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933)container.preInvoke(this, 2, _EJS_s);
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
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findContractByBaseAgreement
	 */
	public java.util.Enumeration findContractByBaseAgreement(com.hps.july.persistence.BaseAgreementKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 beanRef = (com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.findContractByBaseAgreement(inKey);
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
	 * findContractByCurrency
	 */
	public java.util.Enumeration findContractByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 beanRef = (com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.findContractByCurrency(inKey);
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
	 * findContractByQBE
	 */
	public java.util.Enumeration findContractByQBE(java.lang.Integer argSupplyType, java.lang.Boolean isBaseAgreement, java.lang.Integer argBaseAgreement, java.lang.Boolean isOrganization, java.lang.Integer argOrganization, java.lang.Boolean isContragent, java.lang.Integer argContragent, java.sql.Date argStartDate, java.sql.Date argFinishDate, java.lang.Boolean isState, java.lang.String argState, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 beanRef = (com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.findContractByQBE(argSupplyType, isBaseAgreement, argBaseAgreement, isOrganization, argOrganization, isContragent, argContragent, argStartDate, argFinishDate, isState, argState, order);
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
	 * findContractByQBE2
	 */
	public java.util.Enumeration findContractByQBE2(java.lang.Boolean isSupplyType, java.lang.Integer sypplyType, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isContragent, java.lang.Integer contragent, java.lang.String matchName, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 beanRef = (com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.findContractByQBE2(isSupplyType, sypplyType, isOwner, owner, isContragent, contragent, matchName, order);
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
	 * findContractByQBE3
	 */
	public java.util.Enumeration findContractByQBE3(java.lang.Integer argSupplyType, java.lang.Boolean isBaseAgreement, java.lang.Integer argBaseAgreement, java.lang.Boolean isOrganization, java.lang.Integer argOrganization, java.lang.Boolean isContragent, java.lang.Integer argContragent, java.sql.Date argBlankDate, java.sql.Date argFinishDate, java.lang.Boolean isState, java.lang.String argState, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 beanRef = (com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.findContractByQBE3(argSupplyType, isBaseAgreement, argBaseAgreement, isOrganization, argOrganization, isContragent, argContragent, argBlankDate, argFinishDate, isState, argState, order);
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
	 * findContractBySupplyType
	 */
	public java.util.Enumeration findContractBySupplyType(com.hps.july.persistence.SupplyTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 beanRef = (com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.findContractBySupplyType(inKey);
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
	 * findControlledContractByController
	 */
	public java.util.Enumeration findControlledContractByController(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 beanRef = (com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.findControlledContractByController(inKey);
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
				container.postInvoke(this, 9, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findWorkedContractByWorker
	 */
	public java.util.Enumeration findWorkedContractByWorker(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 beanRef = (com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.findWorkedContractByWorker(inKey);
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
				container.postInvoke(this, 10, _EJS_s);
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
			com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 beanRef = (com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933)container.preInvoke(this, 11, _EJS_s);
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
				container.postInvoke(this, 11, _EJS_s);
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
			com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 beanRef = (com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933)container.preInvoke(this, 12, _EJS_s);
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
				container.postInvoke(this, 12, _EJS_s);
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
			com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 beanRef = (com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933)container.preInvoke(this, 13, _EJS_s);
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
				container.postInvoke(this, 13, _EJS_s);
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
			com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933 beanRef = (com.hps.july.persistence.EJSCMPContractHomeBean_f0f90933)container.preInvoke(this, 14, _EJS_s);
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
				container.postInvoke(this, 14, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
