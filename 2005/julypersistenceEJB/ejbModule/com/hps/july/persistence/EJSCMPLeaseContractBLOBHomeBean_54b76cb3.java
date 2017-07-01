package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseContractBLOBHomeBean_54b76cb3
 */
public class EJSCMPLeaseContractBLOBHomeBean_54b76cb3 extends EJSHome {
	/**
	 * EJSCMPLeaseContractBLOBHomeBean_54b76cb3
	 */
	public EJSCMPLeaseContractBLOBHomeBean_54b76cb3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseContractBLOB postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseContractBLOB) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.LeaseContractBLOB create(int argLeaseDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseContractBLOB _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseContractBLOBBean bean = (com.hps.july.persistence.LeaseContractBLOBBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocument);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argLeaseDocument);
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
	public com.hps.july.persistence.LeaseContractBLOB findByPrimaryKey(com.hps.july.persistence.LeaseContractBLOBKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseContractBLOBBean_54b76cb3) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseContractBLOBBean tmpEJB = (com.hps.july.persistence.LeaseContractBLOBBean) generalEJB;
		com.hps.july.persistence.LeaseContractBLOBKey keyClass = new com.hps.july.persistence.LeaseContractBLOBKey();
		keyClass.leaseDocument = tmpEJB.leaseDocument;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseContractBLOBKey keyFromFields(int f0) {
		com.hps.july.persistence.LeaseContractBLOBKey keyClass = new com.hps.july.persistence.LeaseContractBLOBKey();
		keyClass.leaseDocument = f0;
		return keyClass;
	}
}
