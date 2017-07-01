package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPBeenetCategoryHomeBean_df18e43e
 */
public class EJSCMPBeenetCategoryHomeBean_df18e43e extends EJSHome {
	/**
	 * EJSCMPBeenetCategoryHomeBean_df18e43e
	 */
	public EJSCMPBeenetCategoryHomeBean_df18e43e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.BeenetCategory postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.BeenetCategory) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.BeenetCategory findByPrimaryKey(com.hps.july.persistence2.BeenetCategoryKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPBeenetCategoryBean_df18e43e) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.BeenetCategory create(int argCategid, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.BeenetCategory _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.BeenetCategoryBean bean = (com.hps.july.persistence2.BeenetCategoryBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argCategid, argName);
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
		com.hps.july.persistence2.BeenetCategoryBean tmpEJB = (com.hps.july.persistence2.BeenetCategoryBean) generalEJB;
		com.hps.july.persistence2.BeenetCategoryKey keyClass = new com.hps.july.persistence2.BeenetCategoryKey();
		keyClass.categid = tmpEJB.categid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.BeenetCategoryKey keyFromFields(int f0) {
		com.hps.july.persistence2.BeenetCategoryKey keyClass = new com.hps.july.persistence2.BeenetCategoryKey();
		keyClass.categid = f0;
		return keyClass;
	}
}
