package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSiteDocFileHomeBean_3813d797
 */
public class EJSCMPSiteDocFileHomeBean_3813d797 extends EJSHome {
	/**
	 * EJSCMPSiteDocFileHomeBean_3813d797
	 */
	public EJSCMPSiteDocFileHomeBean_3813d797() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SiteDocFile postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SiteDocFile) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.SiteDocFile findByPrimaryKey(com.hps.july.persistence.SiteDocFileKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSiteDocFileBean_3813d797) persister).findByPrimaryKey(key);
	}
	/**
	 * findBySitedocOrderBySitedocAsc
	 */
	public java.util.Enumeration findBySitedocOrderBySitedocAsc(java.lang.Integer siteDoc) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSiteDocFileBean)persister).findBySitedocOrderBySitedocAsc(siteDoc));	}
	/**
	 * findBySitedocOrderBySitedocDesc
	 */
	public java.util.Enumeration findBySitedocOrderBySitedocDesc(java.lang.Integer siteDoc) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSiteDocFileBean)persister).findBySitedocOrderBySitedocDesc(siteDoc));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.SiteDocFile create(int argSitedocfile, int siteDoc) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SiteDocFile _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SiteDocFileBean bean = (com.hps.july.persistence.SiteDocFileBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSitedocfile, siteDoc);
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
	 * findSiteDocFilesBySiteDoc
	 */
	public java.util.Enumeration findSiteDocFilesBySiteDoc(com.hps.july.persistence.SiteDocKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSiteDocFileBean)persister).findSiteDocFilesBySiteDoc(inKey));	}
	/**
	 * findBySitedocsOrderByPKAsc
	 */
	public java.util.Enumeration findBySitedocsOrderByPKAsc(java.lang.Integer siteDoc) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSiteDocFileBean)persister).findBySitedocsOrderByPKAsc(siteDoc));	}
	/**
	 * findBySitedocsOrderByPKDesc
	 */
	public java.util.Enumeration findBySitedocsOrderByPKDesc(java.lang.Integer siteDoc) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSiteDocFileBean)persister).findBySitedocsOrderByPKDesc(siteDoc));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.SiteDocFileBean tmpEJB = (com.hps.july.persistence.SiteDocFileBean) generalEJB;
		com.hps.july.persistence.SiteDocFileKey keyClass = new com.hps.july.persistence.SiteDocFileKey();
		keyClass.sitedocfile = tmpEJB.sitedocfile;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.SiteDocFileKey keyFromFields(int f0) {
		com.hps.july.persistence.SiteDocFileKey keyClass = new com.hps.july.persistence.SiteDocFileKey();
		keyClass.sitedocfile = f0;
		return keyClass;
	}
}
