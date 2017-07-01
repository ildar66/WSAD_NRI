package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPInternalWayBillPositionHomeBean_18be2d9e
 */
public class EJSCMPInternalWayBillPositionHomeBean_18be2d9e extends EJSHome {
	/**
	 * EJSCMPInternalWayBillPositionHomeBean_18be2d9e
	 */
	public EJSCMPInternalWayBillPositionHomeBean_18be2d9e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.InternalWayBillPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.InternalWayBillPosition) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.InternalWayBillPosition findByPrimaryKey(com.hps.july.persistence.DocumentPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPInternalWayBillPositionBean_18be2d9e) persister).findByPrimaryKey(key);
	}
	/**
	 * findMaxOrderPosition
	 */
	public com.hps.july.persistence.InternalWayBillPosition findMaxOrderPosition(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPInternalWayBillPositionBean_18be2d9e)persister).findMaxOrderPosition(argDocument);	}
	/**
	 * findByDocOrderByAgregateAsc
	 */
	public java.util.Enumeration findByDocOrderByAgregateAsc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInternalWayBillPositionBean)persister).findByDocOrderByAgregateAsc(argDocument));	}
	/**
	 * findByDocumentSerialnum
	 */
	public com.hps.july.persistence.InternalWayBillPosition findByDocumentSerialnum(java.lang.Integer argDocument, java.lang.String argSerial) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPInternalWayBillPositionBean_18be2d9e)persister).findByDocumentSerialnum(argDocument, argSerial);	}
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderDesc
	 */
	public java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderDesc(java.lang.Integer argDocument, java.lang.String argPolicy) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInternalWayBillPositionBean)persister).findDocPositionsByDocAndPolicyOrderByOrderDesc(argDocument, argPolicy));	}
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderAsc
	 */
	public java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderAsc(java.lang.Integer argDocument, java.lang.String argPolicy) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInternalWayBillPositionBean)persister).findDocPositionsByDocAndPolicyOrderByOrderAsc(argDocument, argPolicy));	}
	/**
	 * findDocPositionsByDocOrderByOrderAsc
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderAsc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInternalWayBillPositionBean)persister).findDocPositionsByDocOrderByOrderAsc(argDocument));	}
	/**
	 * findByDocOrderByAgregateDesc
	 */
	public java.util.Enumeration findByDocOrderByAgregateDesc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInternalWayBillPositionBean)persister).findByDocOrderByAgregateDesc(argDocument));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.InternalWayBillPosition create(int argDocposition, java.lang.Integer argResource, java.lang.Integer argOwner, java.lang.Integer argDocument, int argOrder, java.math.BigDecimal argQty, java.math.BigDecimal argPrice, java.lang.Boolean argSourceBoxed, java.lang.Boolean argResultBoxed, java.lang.Boolean argSourceBroken, java.lang.Boolean argResultBroken, java.lang.Boolean argSourceClosed, java.lang.Boolean argResultClosed) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.InternalWayBillPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.InternalWayBillPositionBean bean = (com.hps.july.persistence.InternalWayBillPositionBean) beanO.getEnterpriseBean();
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
	 * findDocPositionsByDocOrderByOrderDesc
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderDesc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInternalWayBillPositionBean)persister).findDocPositionsByDocOrderByOrderDesc(argDocument));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.InternalWayBillPosition create(int argDocposition) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.InternalWayBillPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.InternalWayBillPositionBean bean = (com.hps.july.persistence.InternalWayBillPositionBean) beanO.getEnterpriseBean();
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
	 * findBadAgregatesByDocument
	 */
	public java.util.Enumeration findBadAgregatesByDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInternalWayBillPositionBean)persister).findBadAgregatesByDocument(argDocument));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.InternalWayBillPositionBean tmpEJB = (com.hps.july.persistence.InternalWayBillPositionBean) generalEJB;
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
