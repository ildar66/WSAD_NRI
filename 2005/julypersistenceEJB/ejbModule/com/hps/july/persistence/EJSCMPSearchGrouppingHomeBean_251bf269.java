package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSearchGrouppingHomeBean_251bf269
 */
public class EJSCMPSearchGrouppingHomeBean_251bf269 extends EJSHome {
	/**
	 * EJSCMPSearchGrouppingHomeBean_251bf269
	 */
	public EJSCMPSearchGrouppingHomeBean_251bf269() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SearchGroupping postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SearchGroupping) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.SearchGroupping create(int argSearchGroupping) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SearchGroupping _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SearchGrouppingBean bean = (com.hps.july.persistence.SearchGrouppingBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSearchGroupping);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argSearchGroupping);
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
	 * findSearchGrouppingBySearchGroup
	 */
	public java.util.Enumeration findSearchGrouppingBySearchGroup(com.hps.july.persistence.SearchGroupKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSearchGrouppingBean)persister).findSearchGrouppingBySearchGroup(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.SearchGroupping findByPrimaryKey(com.hps.july.persistence.SearchGrouppingKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSearchGrouppingBean_251bf269) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.SearchGroupping create(int argSearchGroupping, java.lang.Integer argGroup, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SearchGroupping _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SearchGrouppingBean bean = (com.hps.july.persistence.SearchGrouppingBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSearchGroupping, argGroup, argName);
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
		com.hps.july.persistence.SearchGrouppingBean tmpEJB = (com.hps.july.persistence.SearchGrouppingBean) generalEJB;
		com.hps.july.persistence.SearchGrouppingKey keyClass = new com.hps.july.persistence.SearchGrouppingKey();
		keyClass.searchGroupping = tmpEJB.searchGroupping;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.SearchGrouppingKey keyFromFields(int f0) {
		com.hps.july.persistence.SearchGrouppingKey keyClass = new com.hps.july.persistence.SearchGrouppingKey();
		keyClass.searchGroupping = f0;
		return keyClass;
	}
}
