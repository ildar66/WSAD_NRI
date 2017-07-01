package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPGKRCHDocHomeBean_1f693e3f
 */
public class EJSCMPGKRCHDocHomeBean_1f693e3f extends EJSHome {
	/**
	 * EJSCMPGKRCHDocHomeBean_1f693e3f
	 */
	public EJSCMPGKRCHDocHomeBean_1f693e3f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.GKRCHDoc postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.GKRCHDoc) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.GKRCHDoc create(int argSitedoc) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.GKRCHDoc _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.GKRCHDocBean bean = (com.hps.july.persistence2.GKRCHDocBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSitedoc);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argSitedoc);
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
	public com.hps.july.persistence2.GKRCHDoc findByPrimaryKey(com.hps.july.persistence2.GKRCHDocKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPGKRCHDocBean_1f693e3f) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.GKRCHDocBean tmpEJB = (com.hps.july.persistence2.GKRCHDocBean) generalEJB;
		com.hps.july.persistence2.GKRCHDocKey keyClass = new com.hps.july.persistence2.GKRCHDocKey();
		keyClass.sitedoc = tmpEJB.sitedoc;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.GKRCHDocKey keyFromFields(int f0) {
		com.hps.july.persistence2.GKRCHDocKey keyClass = new com.hps.july.persistence2.GKRCHDocKey();
		keyClass.sitedoc = f0;
		return keyClass;
	}
}
