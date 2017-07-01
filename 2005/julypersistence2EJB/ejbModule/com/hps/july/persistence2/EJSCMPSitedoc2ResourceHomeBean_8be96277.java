package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSitedoc2ResourceHomeBean_8be96277
 */
public class EJSCMPSitedoc2ResourceHomeBean_8be96277 extends EJSHome {
	/**
	 * EJSCMPSitedoc2ResourceHomeBean_8be96277
	 */
	public EJSCMPSitedoc2ResourceHomeBean_8be96277() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Sitedoc2Resource postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Sitedoc2Resource) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.Sitedoc2Resource findByPrimaryKey(com.hps.july.persistence2.Sitedoc2ResourceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPSitedoc2ResourceBean_8be96277) persister).findByPrimaryKey(key);
	}
	/**
	 * findAllBySitedoc
	 */
	public java.util.Enumeration findAllBySitedoc(int argSiteDoc) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence2.EJSFinderSitedoc2ResourceBean)persister).findAllBySitedoc(argSiteDoc));	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.Sitedoc2Resource create(int argResource, int argSitedoc) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.Sitedoc2Resource _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.Sitedoc2ResourceBean bean = (com.hps.july.persistence2.Sitedoc2ResourceBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResource, argSitedoc);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argResource, argSitedoc);
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
		com.hps.july.persistence2.Sitedoc2ResourceBean tmpEJB = (com.hps.july.persistence2.Sitedoc2ResourceBean) generalEJB;
		com.hps.july.persistence2.Sitedoc2ResourceKey keyClass = new com.hps.july.persistence2.Sitedoc2ResourceKey();
		keyClass.resource = tmpEJB.resource;
		keyClass.sitedoc = tmpEJB.sitedoc;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.Sitedoc2ResourceKey keyFromFields(int f0, int f1) {
		com.hps.july.persistence2.Sitedoc2ResourceKey keyClass = new com.hps.july.persistence2.Sitedoc2ResourceKey();
		keyClass.resource = f0;
		keyClass.sitedoc = f1;
		return keyClass;
	}
}
