package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSiteDocTypeHomeBean_e7563d77
 */
public class EJSCMPSiteDocTypeHomeBean_e7563d77 extends EJSHome {
	/**
	 * EJSCMPSiteDocTypeHomeBean_e7563d77
	 */
	public EJSCMPSiteDocTypeHomeBean_e7563d77() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SiteDocType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SiteDocType) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.SiteDocType create(int argSitedoctype, java.lang.String sitedoctypename) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SiteDocType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SiteDocTypeBean bean = (com.hps.july.persistence.SiteDocTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSitedoctype, sitedoctypename);
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
	public com.hps.july.persistence.SiteDocType findByPrimaryKey(com.hps.july.persistence.SiteDocTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSiteDocTypeBean_e7563d77) persister).findByPrimaryKey(key);
	}
	/**
	 * findAll
	 */
	public java.util.Enumeration findAll() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSiteDocTypeBean)persister).findAll());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.SiteDocTypeBean tmpEJB = (com.hps.july.persistence.SiteDocTypeBean) generalEJB;
		com.hps.july.persistence.SiteDocTypeKey keyClass = new com.hps.july.persistence.SiteDocTypeKey();
		keyClass.sitedoctype = tmpEJB.sitedoctype;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.SiteDocTypeKey keyFromFields(int f0) {
		com.hps.july.persistence.SiteDocTypeKey keyClass = new com.hps.july.persistence.SiteDocTypeKey();
		keyClass.sitedoctype = f0;
		return keyClass;
	}
}
