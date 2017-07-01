package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEBudjetHomeBean_740d54eb
 */
public class EJSCMPPIEBudjetHomeBean_740d54eb extends EJSHome {
	/**
	 * EJSCMPPIEBudjetHomeBean_740d54eb
	 */
	public EJSCMPPIEBudjetHomeBean_740d54eb() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEBudjet postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEBudjet) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIEBudjet findByPrimaryKey(com.hps.july.persistence.PIEBudjetKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEBudjetBean_740d54eb) persister).findByPrimaryKey(key);
	}
	/**
	 * findByOwnerAndRecordstatusOrderByNameAsc
	 */
	public java.util.Enumeration findByOwnerAndRecordstatusOrderByNameAsc(java.lang.Integer owner, java.lang.String recordstatus) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEBudjetBean)persister).findByOwnerAndRecordstatusOrderByNameAsc(owner, recordstatus));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEBudjet create(int argIdbudjetnri, int argOwner, java.lang.String argIdBudjet, java.lang.String argNameBudjet, java.lang.String argRecordStatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEBudjet _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEBudjetBean bean = (com.hps.july.persistence.PIEBudjetBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdbudjetnri, argOwner, argIdBudjet, argNameBudjet, argRecordStatus);
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
		com.hps.july.persistence.PIEBudjetBean tmpEJB = (com.hps.july.persistence.PIEBudjetBean) generalEJB;
		com.hps.july.persistence.PIEBudjetKey keyClass = new com.hps.july.persistence.PIEBudjetKey();
		keyClass.idbudjetnri = tmpEJB.idbudjetnri;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEBudjetKey keyFromFields(int f0) {
		com.hps.july.persistence.PIEBudjetKey keyClass = new com.hps.july.persistence.PIEBudjetKey();
		keyClass.idbudjetnri = f0;
		return keyClass;
	}
}
