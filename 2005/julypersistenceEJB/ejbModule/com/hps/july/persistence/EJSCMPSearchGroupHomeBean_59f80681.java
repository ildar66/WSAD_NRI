package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSearchGroupHomeBean_59f80681
 */
public class EJSCMPSearchGroupHomeBean_59f80681 extends EJSHome {
	/**
	 * EJSCMPSearchGroupHomeBean_59f80681
	 */
	public EJSCMPSearchGroupHomeBean_59f80681() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SearchGroup postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SearchGroup) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.SearchGroup create(int argSearchgroup) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SearchGroup _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SearchGroupBean bean = (com.hps.july.persistence.SearchGroupBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSearchgroup);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argSearchgroup);
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
	public com.hps.july.persistence.SearchGroup create(int argSearchgroup, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SearchGroup _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SearchGroupBean bean = (com.hps.july.persistence.SearchGroupBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSearchgroup, argName);
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
	public com.hps.july.persistence.SearchGroup findByPrimaryKey(com.hps.july.persistence.SearchGroupKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSearchGroupBean_59f80681) persister).findByPrimaryKey(key);
	}
	/**
	 * findAll
	 */
	public java.util.Enumeration findAll() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSearchGroupBean)persister).findAll());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.SearchGroupBean tmpEJB = (com.hps.july.persistence.SearchGroupBean) generalEJB;
		com.hps.july.persistence.SearchGroupKey keyClass = new com.hps.july.persistence.SearchGroupKey();
		keyClass.searchgroup = tmpEJB.searchgroup;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.SearchGroupKey keyFromFields(int f0) {
		com.hps.july.persistence.SearchGroupKey keyClass = new com.hps.july.persistence.SearchGroupKey();
		keyClass.searchgroup = f0;
		return keyClass;
	}
}
