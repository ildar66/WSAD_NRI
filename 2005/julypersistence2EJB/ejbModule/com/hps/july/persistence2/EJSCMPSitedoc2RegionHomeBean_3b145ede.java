package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSitedoc2RegionHomeBean_3b145ede
 */
public class EJSCMPSitedoc2RegionHomeBean_3b145ede extends EJSHome {
	/**
	 * EJSCMPSitedoc2RegionHomeBean_3b145ede
	 */
	public EJSCMPSitedoc2RegionHomeBean_3b145ede() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Sitedoc2Region postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Sitedoc2Region) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.Sitedoc2Region findByPrimaryKey(com.hps.july.persistence2.Sitedoc2RegionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPSitedoc2RegionBean_3b145ede) persister).findByPrimaryKey(key);
	}
	/**
	 * findAllBySitedoc
	 */
	public java.util.Enumeration findAllBySitedoc(int argSiteDoc) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence2.EJSFinderSitedoc2RegionBean)persister).findAllBySitedoc(argSiteDoc));	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.Sitedoc2Region create(int argRegion, int argSitedoc) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.Sitedoc2Region _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.Sitedoc2RegionBean bean = (com.hps.july.persistence2.Sitedoc2RegionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argRegion, argSitedoc);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argRegion, argSitedoc);
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
		com.hps.july.persistence2.Sitedoc2RegionBean tmpEJB = (com.hps.july.persistence2.Sitedoc2RegionBean) generalEJB;
		com.hps.july.persistence2.Sitedoc2RegionKey keyClass = new com.hps.july.persistence2.Sitedoc2RegionKey();
		keyClass.region = tmpEJB.region;
		keyClass.sitedoc = tmpEJB.sitedoc;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.Sitedoc2RegionKey keyFromFields(int f0, int f1) {
		com.hps.july.persistence2.Sitedoc2RegionKey keyClass = new com.hps.july.persistence2.Sitedoc2RegionKey();
		keyClass.region = f0;
		keyClass.sitedoc = f1;
		return keyClass;
	}
}
