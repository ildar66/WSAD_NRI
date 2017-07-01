package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPRRLDocsHomeBean_d716392c
 */
public class EJSCMPRRLDocsHomeBean_d716392c extends EJSHome {
	/**
	 * EJSCMPRRLDocsHomeBean_d716392c
	 */
	public EJSCMPRRLDocsHomeBean_d716392c() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.RRLDocs postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.RRLDocs) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.RRLDocs findByPrimaryKey(com.hps.july.persistence2.RRLDocsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPRRLDocsBean_d716392c) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.RRLDocs create(int argSitedoc, int argOrganization) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.RRLDocs _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.RRLDocsBean bean = (com.hps.july.persistence2.RRLDocsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSitedoc, argOrganization);
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
		com.hps.july.persistence2.RRLDocsBean tmpEJB = (com.hps.july.persistence2.RRLDocsBean) generalEJB;
		com.hps.july.persistence2.RRLDocsKey keyClass = new com.hps.july.persistence2.RRLDocsKey();
		keyClass.sitedoc = tmpEJB.sitedoc;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.RRLDocsKey keyFromFields(int f0) {
		com.hps.july.persistence2.RRLDocsKey keyClass = new com.hps.july.persistence2.RRLDocsKey();
		keyClass.sitedoc = f0;
		return keyClass;
	}
}
