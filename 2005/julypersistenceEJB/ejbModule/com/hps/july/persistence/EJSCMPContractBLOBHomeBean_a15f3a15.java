package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPContractBLOBHomeBean_a15f3a15
 */
public class EJSCMPContractBLOBHomeBean_a15f3a15 extends EJSHome {
	/**
	 * EJSCMPContractBLOBHomeBean_a15f3a15
	 */
	public EJSCMPContractBLOBHomeBean_a15f3a15() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ContractBLOB postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ContractBLOB) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.ContractBLOB create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ContractBLOB _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ContractBLOBBean bean = (com.hps.july.persistence.ContractBLOBBean) beanO.getEnterpriseBean();
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ContractBLOB findByPrimaryKey(com.hps.july.persistence.ContractBLOBKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPContractBLOBBean_a15f3a15) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ContractBLOBBean tmpEJB = (com.hps.july.persistence.ContractBLOBBean) generalEJB;
		com.hps.july.persistence.ContractBLOBKey keyClass = new com.hps.july.persistence.ContractBLOBKey();
		keyClass.document = tmpEJB.document;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ContractBLOBKey keyFromFields(int f0) {
		com.hps.july.persistence.ContractBLOBKey keyClass = new com.hps.july.persistence.ContractBLOBKey();
		keyClass.document = f0;
		return keyClass;
	}
}
