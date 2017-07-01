package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseMutualActBLOBHomeBean_ddcc7e78
 */
public class EJSCMPLeaseMutualActBLOBHomeBean_ddcc7e78 extends EJSHome {
	/**
	 * EJSCMPLeaseMutualActBLOBHomeBean_ddcc7e78
	 */
	public EJSCMPLeaseMutualActBLOBHomeBean_ddcc7e78() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMutualActBLOB postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMutualActBLOB) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.LeaseMutualActBLOB findByPrimaryKey(com.hps.july.persistence.LeaseMutualActBLOBKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseMutualActBLOBBean_ddcc7e78) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseMutualActBLOB create(int argLeasedocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseMutualActBLOB _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseMutualActBLOBBean bean = (com.hps.july.persistence.LeaseMutualActBLOBBean) beanO.getEnterpriseBean();
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
		com.hps.july.persistence.LeaseMutualActBLOBBean tmpEJB = (com.hps.july.persistence.LeaseMutualActBLOBBean) generalEJB;
		com.hps.july.persistence.LeaseMutualActBLOBKey keyClass = new com.hps.july.persistence.LeaseMutualActBLOBKey();
		keyClass.leasedocument = tmpEJB.leasedocument;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseMutualActBLOBKey keyFromFields(int f0) {
		com.hps.july.persistence.LeaseMutualActBLOBKey keyClass = new com.hps.july.persistence.LeaseMutualActBLOBKey();
		keyClass.leasedocument = f0;
		return keyClass;
	}
}
