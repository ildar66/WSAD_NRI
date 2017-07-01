package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseMutualActInfoHomeBean_77a58df7
 */
public class EJSCMPLeaseMutualActInfoHomeBean_77a58df7 extends EJSHome {
	/**
	 * EJSCMPLeaseMutualActInfoHomeBean_77a58df7
	 */
	public EJSCMPLeaseMutualActInfoHomeBean_77a58df7() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMutualActInfo postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMutualActInfo) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.LeaseMutualActInfo findByPrimaryKey(com.hps.july.persistence.LeaseMutualActInfoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseMutualActInfoBean_77a58df7) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseMutualActInfo create(int argLeasedocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseMutualActInfo _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseMutualActInfoBean bean = (com.hps.july.persistence.LeaseMutualActInfoBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeasedocument);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argLeasedocument);
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
		com.hps.july.persistence.LeaseMutualActInfoBean tmpEJB = (com.hps.july.persistence.LeaseMutualActInfoBean) generalEJB;
		com.hps.july.persistence.LeaseMutualActInfoKey keyClass = new com.hps.july.persistence.LeaseMutualActInfoKey();
		keyClass.leasedocument = tmpEJB.leasedocument;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseMutualActInfoKey keyFromFields(int f0) {
		com.hps.july.persistence.LeaseMutualActInfoKey keyClass = new com.hps.july.persistence.LeaseMutualActInfoKey();
		keyClass.leasedocument = f0;
		return keyClass;
	}
}
