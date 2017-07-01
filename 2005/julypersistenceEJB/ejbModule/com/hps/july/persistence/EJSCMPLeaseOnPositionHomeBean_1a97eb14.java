package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseOnPositionHomeBean_1a97eb14
 */
public class EJSCMPLeaseOnPositionHomeBean_1a97eb14 extends EJSHome {
	/**
	 * EJSCMPLeaseOnPositionHomeBean_1a97eb14
	 */
	public EJSCMPLeaseOnPositionHomeBean_1a97eb14() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseOnPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseOnPosition) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findLeaseOnPositionByPosition
	 */
	public java.util.Enumeration findLeaseOnPositionByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseOnPositionBean)persister).findLeaseOnPositionByPosition(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseOnPosition create(java.lang.Integer argDocument, java.lang.Integer argPosition) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseOnPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseOnPositionBean bean = (com.hps.july.persistence.LeaseOnPositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argPosition);
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
	 * create
	 */
	public com.hps.july.persistence.LeaseOnPosition create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseOnPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseOnPositionBean bean = (com.hps.july.persistence.LeaseOnPositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate();
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate();
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
	public com.hps.july.persistence.LeaseOnPosition findByPrimaryKey(com.hps.july.persistence.LeaseOnPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseOnPositionBean_1a97eb14) persister).findByPrimaryKey(key);
	}
	/**
	 * findLeaseonpositionsByLeaseArendaAgreementNew
	 */
	public java.util.Enumeration findLeaseonpositionsByLeaseArendaAgreementNew(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseOnPositionBean)persister).findLeaseonpositionsByLeaseArendaAgreementNew(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseOnPositionBean tmpEJB = (com.hps.july.persistence.LeaseOnPositionBean) generalEJB;
		com.hps.july.persistence.LeaseOnPositionKey keyClass = new com.hps.july.persistence.LeaseOnPositionKey();
		keyClass.leaseArendaAgreementNew_leaseDocument = tmpEJB.leaseArendaAgreementNew_leaseDocument;
		keyClass.position_storageplace = tmpEJB.position_storageplace;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseOnPositionKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1) {
		com.hps.july.persistence.LeaseOnPositionKey keyClass = new com.hps.july.persistence.LeaseOnPositionKey();
		keyClass.leaseArendaAgreementNew_leaseDocument = f0;
		keyClass.position_storageplace = f1;
		return keyClass;
	}
}
