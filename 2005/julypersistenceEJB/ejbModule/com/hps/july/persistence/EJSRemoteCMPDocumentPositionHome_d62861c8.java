package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPDocumentPositionHome_d62861c8
 */
public class EJSRemoteCMPDocumentPositionHome_d62861c8 extends EJSWrapper implements com.hps.july.persistence.DocumentPositionHome {
	/**
	 * EJSRemoteCMPDocumentPositionHome_d62861c8
	 */
	public EJSRemoteCMPDocumentPositionHome_d62861c8() throws java.rmi.RemoteException {
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
	public com.hps.july.persistence.DocumentPosition create(int argDocposition) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.DocumentPosition _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.create(argDocposition);
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
	public com.hps.july.persistence.DocumentPosition create(int argDocposition, java.lang.Integer argResource, java.lang.Integer argOwner, java.lang.Integer argDocument, int argOrder, java.math.BigDecimal argQty, java.math.BigDecimal argPrice, java.lang.Boolean argSourceBoxed, java.lang.Boolean argResultBoxed, java.lang.Boolean argSourceBroken, java.lang.Boolean argResultBroken, java.lang.Boolean argSourceClosed, java.lang.Boolean argResultClosed) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.DocumentPosition _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.create(argDocposition, argResource, argOwner, argDocument, argOrder, argQty, argPrice, argSourceBoxed, argResultBoxed, argSourceBroken, argResultBroken, argSourceClosed, argResultClosed);
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
	 * findByAgregateAfterDate
	 */
	public com.hps.july.persistence.DocumentPosition findByAgregateAfterDate(java.lang.String argAgregatSerial, java.sql.Date argDate) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.DocumentPosition _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.findByAgregateAfterDate(argAgregatSerial, argDate);
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
	 * findByDocumentSerialnum
	 */
	public com.hps.july.persistence.DocumentPosition findByDocumentSerialnum(java.lang.Integer argDocument, java.lang.String argSerial) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.DocumentPosition _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.findByDocumentSerialnum(argDocument, argSerial);
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.DocumentPosition findByPrimaryKey(com.hps.july.persistence.DocumentPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.DocumentPosition _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 4, _EJS_s);
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
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByResourceSetAndStorageAfterDate
	 */
	public com.hps.july.persistence.DocumentPosition findByResourceSetAndStorageAfterDate(java.lang.Integer argDocument, java.lang.Integer argStorage, java.sql.Date argDate) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.DocumentPosition _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.findByResourceSetAndStorageAfterDate(argDocument, argStorage, argDate);
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
	 * findByStorageAfterDate
	 */
	public com.hps.july.persistence.DocumentPosition findByStorageAfterDate(java.lang.Integer argStorage, java.sql.Date argDate) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.DocumentPosition _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.findByStorageAfterDate(argStorage, argDate);
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
	 * findMaxOrderPosition
	 */
	public com.hps.july.persistence.DocumentPosition findMaxOrderPosition(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.DocumentPosition _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.findMaxOrderPosition(argDocument);
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
	 * findAgregatePartsByAgregate
	 */
	public java.util.Enumeration findAgregatePartsByAgregate(com.hps.july.persistence.DocumentPositionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.findAgregatePartsByAgregate(inKey);
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
	 * findBadAgregatesByDocument
	 */
	public java.util.Enumeration findBadAgregatesByDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.findBadAgregatesByDocument(argDocument);
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
	 * findByDocOrderByAgregateAsc
	 */
	public java.util.Enumeration findByDocOrderByAgregateAsc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.findByDocOrderByAgregateAsc(argDocument);
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
	 * findByDocOrderByAgregateDesc
	 */
	public java.util.Enumeration findByDocOrderByAgregateDesc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 11, _EJS_s);
			_EJS_result = beanRef.findByDocOrderByAgregateDesc(argDocument);
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
				container.postInvoke(this, 11, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByDocumentQBE
	 */
	public java.util.Enumeration findByDocumentQBE(java.lang.Integer argDocument, java.lang.String argPolicy, java.lang.String argNumber, java.lang.Boolean isResource, java.lang.Integer argResource, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 12, _EJS_s);
			_EJS_result = beanRef.findByDocumentQBE(argDocument, argPolicy, argNumber, isResource, argResource, order);
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
				container.postInvoke(this, 12, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByDocumentQBE2
	 */
	public java.util.Enumeration findByDocumentQBE2(java.lang.Integer argDocument, java.lang.String argPolicy, java.lang.String argNumber, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isResource, java.lang.Integer argResource, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 13, _EJS_s);
			_EJS_result = beanRef.findByDocumentQBE2(argDocument, argPolicy, argNumber, isOwner, owner, isResource, argResource, order);
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
				container.postInvoke(this, 13, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Integer argResource, java.lang.Integer argOwner, java.lang.Boolean isSerial, java.lang.String argSerial, java.lang.Boolean isParty, java.lang.String argParty, java.lang.Boolean isTo, java.lang.Integer argTo, java.lang.Boolean isFrom, java.lang.Integer argFrom, java.lang.String argDocType, java.lang.Boolean isAddDoc, java.lang.Integer argAddDoc) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 14, _EJS_s);
			_EJS_result = beanRef.findByQBE(argResource, argOwner, isSerial, argSerial, isParty, argParty, isTo, argTo, isFrom, argFrom, argDocType, isAddDoc, argAddDoc);
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
				container.postInvoke(this, 14, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByRequestResource
	 */
	public java.util.Enumeration findByRequestResource(java.lang.Integer requestId, java.lang.Integer resourceId) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 15, _EJS_s);
			_EJS_result = beanRef.findByRequestResource(requestId, resourceId);
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
				container.postInvoke(this, 15, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderAsc
	 */
	public java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderAsc(java.lang.Integer argDocument, java.lang.String argPolicy) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 16, _EJS_s);
			_EJS_result = beanRef.findDocPositionsByDocAndPolicyOrderByOrderAsc(argDocument, argPolicy);
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
				container.postInvoke(this, 16, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderDesc
	 */
	public java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderDesc(java.lang.Integer argDocument, java.lang.String argPolicy) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 17, _EJS_s);
			_EJS_result = beanRef.findDocPositionsByDocAndPolicyOrderByOrderDesc(argDocument, argPolicy);
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
				container.postInvoke(this, 17, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findDocPositionsByDocOrderByOrderAsc
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderAsc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 18, _EJS_s);
			_EJS_result = beanRef.findDocPositionsByDocOrderByOrderAsc(argDocument);
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
				container.postInvoke(this, 18, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findDocPositionsByDocOrderByOrderDesc
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderDesc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 19, _EJS_s);
			_EJS_result = beanRef.findDocPositionsByDocOrderByOrderDesc(argDocument);
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
				container.postInvoke(this, 19, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findDocumentPositionByDocument
	 */
	public java.util.Enumeration findDocumentPositionByDocument(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 20, _EJS_s);
			_EJS_result = beanRef.findDocumentPositionByDocument(inKey);
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
				container.postInvoke(this, 20, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findDocumentPositionByOwner
	 */
	public java.util.Enumeration findDocumentPositionByOwner(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 21, _EJS_s);
			_EJS_result = beanRef.findDocumentPositionByOwner(inKey);
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
				container.postInvoke(this, 21, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findDocumentPositionByResource
	 */
	public java.util.Enumeration findDocumentPositionByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 22, _EJS_s);
			_EJS_result = beanRef.findDocumentPositionByResource(inKey);
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
				container.postInvoke(this, 22, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findInDocumentPositionByCardTo
	 */
	public java.util.Enumeration findInDocumentPositionByCardTo(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 23, _EJS_s);
			_EJS_result = beanRef.findInDocumentPositionByCardTo(inKey);
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
				container.postInvoke(this, 23, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findOutDocumentPositionByCardFrom
	 */
	public java.util.Enumeration findOutDocumentPositionByCardFrom(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 24, _EJS_s);
			_EJS_result = beanRef.findOutDocumentPositionByCardFrom(inKey);
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
				container.postInvoke(this, 24, _EJS_s);
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
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 25, _EJS_s);
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
				container.postInvoke(this, 25, _EJS_s);
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
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 26, _EJS_s);
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
				container.postInvoke(this, 26, _EJS_s);
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
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 27, _EJS_s);
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
				container.postInvoke(this, 27, _EJS_s);
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
			com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8 beanRef = (com.hps.july.persistence.EJSCMPDocumentPositionHomeBean_d62861c8)container.preInvoke(this, 28, _EJS_s);
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
				container.postInvoke(this, 28, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
