package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSiteDocFileBLOBHomeBean_29f7bad5
 */
public class EJSCMPSiteDocFileBLOBHomeBean_29f7bad5 extends EJSHome {
	/**
	 * EJSCMPSiteDocFileBLOBHomeBean_29f7bad5
	 */
	public EJSCMPSiteDocFileBLOBHomeBean_29f7bad5() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SiteDocFileBLOB postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SiteDocFileBLOB) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.SiteDocFileBLOB create(int argSitedocfile) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SiteDocFileBLOB _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SiteDocFileBLOBBean bean = (com.hps.july.persistence.SiteDocFileBLOBBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSitedocfile);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argSitedocfile);
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
	public com.hps.july.persistence.SiteDocFileBLOB findByPrimaryKey(com.hps.july.persistence.SiteDocFileBLOBKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSiteDocFileBLOBBean_29f7bad5) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.SiteDocFileBLOBBean tmpEJB = (com.hps.july.persistence.SiteDocFileBLOBBean) generalEJB;
		com.hps.july.persistence.SiteDocFileBLOBKey keyClass = new com.hps.july.persistence.SiteDocFileBLOBKey();
		keyClass.sitedocfile = tmpEJB.sitedocfile;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.SiteDocFileBLOBKey keyFromFields(int f0) {
		com.hps.july.persistence.SiteDocFileBLOBKey keyClass = new com.hps.july.persistence.SiteDocFileBLOBKey();
		keyClass.sitedocfile = f0;
		return keyClass;
	}
}
