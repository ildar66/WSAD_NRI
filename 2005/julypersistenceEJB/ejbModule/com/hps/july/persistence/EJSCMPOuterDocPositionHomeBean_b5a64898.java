package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPOuterDocPositionHomeBean_b5a64898
 */
public class EJSCMPOuterDocPositionHomeBean_b5a64898 extends EJSHome {
	/**
	 * EJSCMPOuterDocPositionHomeBean_b5a64898
	 */
	public EJSCMPOuterDocPositionHomeBean_b5a64898() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.OuterDocPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.OuterDocPosition) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findMaxOrderPosition
	 */
	public com.hps.july.persistence.OuterDocPosition findMaxOrderPosition(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPOuterDocPositionBean_b5a64898)persister).findMaxOrderPosition(argDocument);	}
	/**
	 * findByDocumentResource
	 */
	public java.util.Enumeration findByDocumentResource(java.lang.Integer argDocument, java.lang.Integer argResource) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOuterDocPositionBean)persister).findByDocumentResource(argDocument, argResource));	}
	/**
	 * findByInWayBillOrderByOrderAsc
	 */
	public java.util.Enumeration findByInWayBillOrderByOrderAsc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOuterDocPositionBean)persister).findByInWayBillOrderByOrderAsc(argDocument));	}
	/**
	 * findOuterDocPositionByResource
	 */
	public java.util.Enumeration findOuterDocPositionByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOuterDocPositionBean)persister).findOuterDocPositionByResource(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.OuterDocPosition create(int argOuterDocPosition, java.lang.Integer argResource, java.lang.Integer argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.OuterDocPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.OuterDocPositionBean bean = (com.hps.july.persistence.OuterDocPositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argOuterDocPosition, argResource, argDocument);
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.OuterDocPosition findByPrimaryKey(com.hps.july.persistence.OuterDocPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPOuterDocPositionBean_b5a64898) persister).findByPrimaryKey(key);
	}
	/**
	 * findOuterDocPositionByInWayBill
	 */
	public java.util.Enumeration findOuterDocPositionByInWayBill(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOuterDocPositionBean)persister).findOuterDocPositionByInWayBill(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.OuterDocPosition create(int argOuterDocPosition) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.OuterDocPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.OuterDocPositionBean bean = (com.hps.july.persistence.OuterDocPositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argOuterDocPosition);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argOuterDocPosition);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.OuterDocPositionBean tmpEJB = (com.hps.july.persistence.OuterDocPositionBean) generalEJB;
		com.hps.july.persistence.OuterDocPositionKey keyClass = new com.hps.july.persistence.OuterDocPositionKey();
		keyClass.outerDocPosition = tmpEJB.outerDocPosition;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.OuterDocPositionKey keyFromFields(int f0) {
		com.hps.july.persistence.OuterDocPositionKey keyClass = new com.hps.july.persistence.OuterDocPositionKey();
		keyClass.outerDocPosition = f0;
		return keyClass;
	}
}
