package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEQueryHomeBean_3b29e425
 */
public class EJSCMPPIEQueryHomeBean_3b29e425 extends EJSHome {
	/**
	 * EJSCMPPIEQueryHomeBean_3b29e425
	 */
	public EJSCMPPIEQueryHomeBean_3b29e425() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEQuery postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEQuery) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIEQuery create(int argIdquery, java.lang.String argTypeQuery, java.lang.String argOperation, java.lang.String argStatus, java.lang.String argStatusop, java.sql.Timestamp argVdat) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEQuery _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEQueryBean bean = (com.hps.july.persistence.PIEQueryBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdquery, argTypeQuery, argOperation, argStatus, argStatusop, argVdat);
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
	 * findByTypeStatusOrderByCodeAsc
	 */
	public java.util.Enumeration findByTypeStatusOrderByCodeAsc(java.lang.String argType, java.lang.String argStatus) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEQueryBean)persister).findByTypeStatusOrderByCodeAsc(argType, argStatus));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.PIEQuery findByPrimaryKey(com.hps.july.persistence.PIEQueryKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEQueryBean_3b29e425) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEQueryBean tmpEJB = (com.hps.july.persistence.PIEQueryBean) generalEJB;
		com.hps.july.persistence.PIEQueryKey keyClass = new com.hps.july.persistence.PIEQueryKey();
		keyClass.idquery = tmpEJB.idquery;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEQueryKey keyFromFields(int f0) {
		com.hps.july.persistence.PIEQueryKey keyClass = new com.hps.july.persistence.PIEQueryKey();
		keyClass.idquery = f0;
		return keyClass;
	}
}
