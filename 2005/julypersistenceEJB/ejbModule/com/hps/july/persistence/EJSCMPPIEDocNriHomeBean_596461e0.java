package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEDocNriHomeBean_596461e0
 */
public class EJSCMPPIEDocNriHomeBean_596461e0 extends EJSHome {
	/**
	 * EJSCMPPIEDocNriHomeBean_596461e0
	 */
	public EJSCMPPIEDocNriHomeBean_596461e0() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEDocNri postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEDocNri) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIEDocNri findByPrimaryKey(com.hps.july.persistence.PIEDocNriKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEDocNriBean_596461e0) persister).findByPrimaryKey(key);
	}
	/**
	 * findPIEDocNrisByQuery
	 */
	public java.util.Enumeration findPIEDocNrisByQuery(com.hps.july.persistence.PIEQueryKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEDocNriBean)persister).findPIEDocNrisByQuery(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEDocNri create(int argIdrecdoc, int argQuery, short argTypeDocNri, int argOwner) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEDocNri _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEDocNriBean bean = (com.hps.july.persistence.PIEDocNriBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdrecdoc, argQuery, argTypeDocNri, argOwner);
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
		com.hps.july.persistence.PIEDocNriBean tmpEJB = (com.hps.july.persistence.PIEDocNriBean) generalEJB;
		com.hps.july.persistence.PIEDocNriKey keyClass = new com.hps.july.persistence.PIEDocNriKey();
		keyClass.idrecdoc = tmpEJB.idrecdoc;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEDocNriKey keyFromFields(int f0) {
		com.hps.july.persistence.PIEDocNriKey keyClass = new com.hps.july.persistence.PIEDocNriKey();
		keyClass.idrecdoc = f0;
		return keyClass;
	}
}
