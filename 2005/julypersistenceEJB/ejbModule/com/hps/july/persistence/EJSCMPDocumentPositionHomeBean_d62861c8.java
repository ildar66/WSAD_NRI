package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPDocumentPositionHomeBean_d62861c8
 */
public class EJSCMPDocumentPositionHomeBean_d62861c8 extends EJSHome {
	/**
	 * EJSCMPDocumentPositionHomeBean_d62861c8
	 */
	public EJSCMPDocumentPositionHomeBean_d62861c8() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.DocumentPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.DocumentPosition) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByStorageAfterDate
	 */
	public com.hps.july.persistence.DocumentPosition findByStorageAfterDate(java.lang.Integer argStorage, java.sql.Date argDate) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPDocumentPositionBean_d62861c8)persister).findByStorageAfterDate(argStorage, argDate);	}
	/**
	 * findDocPositionsByDocOrderByOrderAsc
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderAsc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findDocPositionsByDocOrderByOrderAsc(argDocument));	}
	/**
	 * findByResourceSetAndStorageAfterDate
	 */
	public com.hps.july.persistence.DocumentPosition findByResourceSetAndStorageAfterDate(java.lang.Integer argDocument, java.lang.Integer argStorage, java.sql.Date argDate) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPDocumentPositionBean_d62861c8)persister).findByResourceSetAndStorageAfterDate(argDocument, argStorage, argDate);	}
	/**
	 * findByDocumentQBE
	 */
	public java.util.Enumeration findByDocumentQBE(java.lang.Integer argDocument, java.lang.String argPolicy, java.lang.String argNumber, java.lang.Boolean isResource, java.lang.Integer argResource, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findByDocumentQBE(argDocument, argPolicy, argNumber, isResource, argResource, order));	}
	/**
	 * findDocumentPositionByResource
	 */
	public java.util.Enumeration findDocumentPositionByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findDocumentPositionByResource(inKey));	}
	/**
	 * findDocumentPositionByDocument
	 */
	public java.util.Enumeration findDocumentPositionByDocument(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findDocumentPositionByDocument(inKey));	}
	/**
	 * findMaxOrderPosition
	 */
	public com.hps.july.persistence.DocumentPosition findMaxOrderPosition(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPDocumentPositionBean_d62861c8)persister).findMaxOrderPosition(argDocument);	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Integer argResource, java.lang.Integer argOwner, java.lang.Boolean isSerial, java.lang.String argSerial, java.lang.Boolean isParty, java.lang.String argParty, java.lang.Boolean isTo, java.lang.Integer argTo, java.lang.Boolean isFrom, java.lang.Integer argFrom, java.lang.String argDocType, java.lang.Boolean isAddDoc, java.lang.Integer argAddDoc) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findByQBE(argResource, argOwner, isSerial, argSerial, isParty, argParty, isTo, argTo, isFrom, argFrom, argDocType, isAddDoc, argAddDoc));	}
	/**
	 * findByAgregateAfterDate
	 */
	public com.hps.july.persistence.DocumentPosition findByAgregateAfterDate(java.lang.String argAgregatSerial, java.sql.Date argDate) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPDocumentPositionBean_d62861c8)persister).findByAgregateAfterDate(argAgregatSerial, argDate);	}
	/**
	 * findDocumentPositionByOwner
	 */
	public java.util.Enumeration findDocumentPositionByOwner(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findDocumentPositionByOwner(inKey));	}
	/**
	 * findByDocumentQBE2
	 */
	public java.util.Enumeration findByDocumentQBE2(java.lang.Integer argDocument, java.lang.String argPolicy, java.lang.String argNumber, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isResource, java.lang.Integer argResource, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findByDocumentQBE2(argDocument, argPolicy, argNumber, isOwner, owner, isResource, argResource, order));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.DocumentPosition findByPrimaryKey(com.hps.july.persistence.DocumentPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPDocumentPositionBean_d62861c8) persister).findByPrimaryKey(key);
	}
	/**
	 * findBadAgregatesByDocument
	 */
	public java.util.Enumeration findBadAgregatesByDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findBadAgregatesByDocument(argDocument));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.DocumentPosition create(int argDocposition, java.lang.Integer argResource, java.lang.Integer argOwner, java.lang.Integer argDocument, int argOrder, java.math.BigDecimal argQty, java.math.BigDecimal argPrice, java.lang.Boolean argSourceBoxed, java.lang.Boolean argResultBoxed, java.lang.Boolean argSourceBroken, java.lang.Boolean argResultBroken, java.lang.Boolean argSourceClosed, java.lang.Boolean argResultClosed) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.DocumentPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.DocumentPositionBean bean = (com.hps.july.persistence.DocumentPositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocposition, argResource, argOwner, argDocument, argOrder, argQty, argPrice, argSourceBoxed, argResultBoxed, argSourceBroken, argResultBroken, argSourceClosed, argResultClosed);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			afterPostCreateWrapper(beanO, _primaryKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAgregatePartsByAgregate
	 */
	public java.util.Enumeration findAgregatePartsByAgregate(com.hps.july.persistence.DocumentPositionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findAgregatePartsByAgregate(inKey));	}
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderAsc
	 */
	public java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderAsc(java.lang.Integer argDocument, java.lang.String argPolicy) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findDocPositionsByDocAndPolicyOrderByOrderAsc(argDocument, argPolicy));	}
	/**
	 * findByDocumentSerialnum
	 */
	public com.hps.july.persistence.DocumentPosition findByDocumentSerialnum(java.lang.Integer argDocument, java.lang.String argSerial) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPDocumentPositionBean_d62861c8)persister).findByDocumentSerialnum(argDocument, argSerial);	}
	/**
	 * findInDocumentPositionByCardTo
	 */
	public java.util.Enumeration findInDocumentPositionByCardTo(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findInDocumentPositionByCardTo(inKey));	}
	/**
	 * findByDocOrderByAgregateAsc
	 */
	public java.util.Enumeration findByDocOrderByAgregateAsc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findByDocOrderByAgregateAsc(argDocument));	}
	/**
	 * findDocPositionsByDocOrderByOrderDesc
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderDesc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findDocPositionsByDocOrderByOrderDesc(argDocument));	}
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderDesc
	 */
	public java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderDesc(java.lang.Integer argDocument, java.lang.String argPolicy) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findDocPositionsByDocAndPolicyOrderByOrderDesc(argDocument, argPolicy));	}
	/**
	 * findOutDocumentPositionByCardFrom
	 */
	public java.util.Enumeration findOutDocumentPositionByCardFrom(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findOutDocumentPositionByCardFrom(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.DocumentPosition create(int argDocposition) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.DocumentPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.DocumentPositionBean bean = (com.hps.july.persistence.DocumentPositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocposition);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argDocposition);
			afterPostCreateWrapper(beanO, _primaryKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByDocOrderByAgregateDesc
	 */
	public java.util.Enumeration findByDocOrderByAgregateDesc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findByDocOrderByAgregateDesc(argDocument));	}
	/**
	 * findByRequestResource
	 */
	public java.util.Enumeration findByRequestResource(java.lang.Integer requestId, java.lang.Integer resourceId) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderDocumentPositionBean)persister).findByRequestResource(requestId, resourceId));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.DocumentPositionBean tmpEJB = (com.hps.july.persistence.DocumentPositionBean) generalEJB;
		com.hps.july.persistence.DocumentPositionKey keyClass = new com.hps.july.persistence.DocumentPositionKey();
		keyClass.docposition = tmpEJB.docposition;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.DocumentPositionKey keyFromFields(int f0) {
		com.hps.july.persistence.DocumentPositionKey keyClass = new com.hps.july.persistence.DocumentPositionKey();
		keyClass.docposition = f0;
		return keyClass;
	}
}
