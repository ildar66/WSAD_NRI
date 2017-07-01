package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEQueryListHomeBean_543889f5
 */
public class EJSCMPPIEQueryListHomeBean_543889f5 extends EJSHome {
	/**
	 * EJSCMPPIEQueryListHomeBean_543889f5
	 */
	public EJSCMPPIEQueryListHomeBean_543889f5() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEQueryList postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEQueryList) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIEQueryList findByPrimaryKey(com.hps.july.persistence.PIEQueryListKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEQueryListBean_543889f5) persister).findByPrimaryKey(key);
	}
	/**
	 * findPIEQueryListsByQuery
	 */
	public java.util.Enumeration findPIEQueryListsByQuery(com.hps.july.persistence.PIEQueryKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEQueryListBean)persister).findPIEQueryListsByQuery(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEQueryList create(int argIdquerylist, int argQuery, java.lang.String argTypeobjnri) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEQueryList _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEQueryListBean bean = (com.hps.july.persistence.PIEQueryListBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdquerylist, argQuery, argTypeobjnri);
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
		com.hps.july.persistence.PIEQueryListBean tmpEJB = (com.hps.july.persistence.PIEQueryListBean) generalEJB;
		com.hps.july.persistence.PIEQueryListKey keyClass = new com.hps.july.persistence.PIEQueryListKey();
		keyClass.idquerylist = tmpEJB.idquerylist;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEQueryListKey keyFromFields(int f0) {
		com.hps.july.persistence.PIEQueryListKey keyClass = new com.hps.july.persistence.PIEQueryListKey();
		keyClass.idquerylist = f0;
		return keyClass;
	}
}
