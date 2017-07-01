package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPInWayBillBLOBHomeBean_cfd95fed
 */
public class EJSCMPInWayBillBLOBHomeBean_cfd95fed extends EJSHome {
	/**
	 * EJSCMPInWayBillBLOBHomeBean_cfd95fed
	 */
	public EJSCMPInWayBillBLOBHomeBean_cfd95fed() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.InWayBillBLOB postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.InWayBillBLOB) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.InWayBillBLOB findByPrimaryKey(com.hps.july.persistence.InWayBillBLOBKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPInWayBillBLOBBean_cfd95fed) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.InWayBillBLOB create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.InWayBillBLOB _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.InWayBillBLOBBean bean = (com.hps.july.persistence.InWayBillBLOBBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argDocument);
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
		com.hps.july.persistence.InWayBillBLOBBean tmpEJB = (com.hps.july.persistence.InWayBillBLOBBean) generalEJB;
		com.hps.july.persistence.InWayBillBLOBKey keyClass = new com.hps.july.persistence.InWayBillBLOBKey();
		keyClass.document = tmpEJB.document;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.InWayBillBLOBKey keyFromFields(int f0) {
		com.hps.july.persistence.InWayBillBLOBKey keyClass = new com.hps.july.persistence.InWayBillBLOBKey();
		keyClass.document = f0;
		return keyClass;
	}
}
