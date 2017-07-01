package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseZPHomeBean_93845009
 */
public class EJSCMPLeaseZPHomeBean_93845009 extends EJSHome {
	/**
	 * EJSCMPLeaseZPHomeBean_93845009
	 */
	public EJSCMPLeaseZPHomeBean_93845009() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.LeaseZP postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.LeaseZP) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.LeaseZP create(int argIdzpnfs, int argLeasedocposition, boolean argIsActive) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.LeaseZP _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.LeaseZPBean bean = (com.hps.july.persistence2.LeaseZPBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdzpnfs, argLeasedocposition, argIsActive);
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
	public com.hps.july.persistence2.LeaseZP findByPrimaryKey(com.hps.july.persistence2.LeaseZPKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPLeaseZPBean_93845009) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.LeaseZPBean tmpEJB = (com.hps.july.persistence2.LeaseZPBean) generalEJB;
		com.hps.july.persistence2.LeaseZPKey keyClass = new com.hps.july.persistence2.LeaseZPKey();
		keyClass.idzpnfs = tmpEJB.idzpnfs;
		keyClass.leasedocposition = tmpEJB.leasedocposition;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.LeaseZPKey keyFromFields(int f0, int f1) {
		com.hps.july.persistence2.LeaseZPKey keyClass = new com.hps.july.persistence2.LeaseZPKey();
		keyClass.idzpnfs = f0;
		keyClass.leasedocposition = f1;
		return keyClass;
	}
}
