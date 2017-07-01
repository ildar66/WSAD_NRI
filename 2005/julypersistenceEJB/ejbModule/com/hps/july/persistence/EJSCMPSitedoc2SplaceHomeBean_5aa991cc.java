package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSitedoc2SplaceHomeBean_5aa991cc
 */
public class EJSCMPSitedoc2SplaceHomeBean_5aa991cc extends EJSHome {
	/**
	 * EJSCMPSitedoc2SplaceHomeBean_5aa991cc
	 */
	public EJSCMPSitedoc2SplaceHomeBean_5aa991cc() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Sitedoc2Splace postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Sitedoc2Splace) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findSitedoc2SplacesByStoragePlace
	 */
	public java.util.Enumeration findSitedoc2SplacesByStoragePlace(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSitedoc2SplaceBean)persister).findSitedoc2SplacesByStoragePlace(inKey));	}
	/**
	 * findSitedoc2SplacesBySiteDoc
	 */
	public java.util.Enumeration findSitedoc2SplacesBySiteDoc(com.hps.july.persistence.SiteDocKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSitedoc2SplaceBean)persister).findSitedoc2SplacesBySiteDoc(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Sitedoc2Splace findByPrimaryKey(com.hps.july.persistence.Sitedoc2SplaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSitedoc2SplaceBean_5aa991cc) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Sitedoc2Splace create(int sitedoc, int storageplace) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Sitedoc2Splace _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.Sitedoc2SplaceBean bean = (com.hps.july.persistence.Sitedoc2SplaceBean) beanO.getEnterpriseBean();
			bean.ejbCreate(sitedoc, storageplace);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.Sitedoc2SplaceBean tmpEJB = (com.hps.july.persistence.Sitedoc2SplaceBean) generalEJB;
		com.hps.july.persistence.Sitedoc2SplaceKey keyClass = new com.hps.july.persistence.Sitedoc2SplaceKey();
		keyClass.storagePlace_storageplace = tmpEJB.storagePlace_storageplace;
		keyClass.siteDoc_sitedoc = tmpEJB.siteDoc_sitedoc;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.Sitedoc2SplaceKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1) {
		com.hps.july.persistence.Sitedoc2SplaceKey keyClass = new com.hps.july.persistence.Sitedoc2SplaceKey();
		keyClass.storagePlace_storageplace = f0;
		keyClass.siteDoc_sitedoc = f1;
		return keyClass;
	}
}
