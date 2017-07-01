package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPeopleHomeBean_5bd41c74
 */
public class EJSCMPPeopleHomeBean_5bd41c74 extends EJSHome {
	/**
	 * EJSCMPPeopleHomeBean_5bd41c74
	 */
	public EJSCMPPeopleHomeBean_5bd41c74() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.People postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.People) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findMaxKeyValue
	 */
	public java.util.Enumeration findMaxKeyValue() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPeopleBean)persister).findMaxKeyValue());	}
	/**
	 * findWorkerByLastNameOrderByLastNameAsc
	 */
	public java.util.Enumeration findWorkerByLastNameOrderByLastNameAsc(java.lang.String name) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPeopleBean)persister).findWorkerByLastNameOrderByLastNameAsc(name));	}
	/**
	 * findByNameOrderByNameDesc
	 */
	public java.util.Enumeration findByNameOrderByNameDesc(java.lang.String name) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPeopleBean)persister).findByNameOrderByNameDesc(name));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.People findByPrimaryKey(com.hps.july.persistence.PeopleKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPeopleBean_5bd41c74) persister).findByPrimaryKey(key);
	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isLastName, java.lang.String lastName, java.lang.Integer argConnected, java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPeopleBean)persister).findByQBE(isLastName, lastName, argConnected, isIsActive, isActive, order));	}
	/**
	 * findByConnectedOrderByNameAsc
	 */
	public java.util.Enumeration findByConnectedOrderByNameAsc(java.lang.Integer argConnected) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPeopleBean)persister).findByConnectedOrderByNameAsc(argConnected));	}
	/**
	 * findByNameOrderByNameAsc
	 */
	public java.util.Enumeration findByNameOrderByNameAsc(java.lang.String name) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPeopleBean)persister).findByNameOrderByNameAsc(name));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.People create(int argMan, java.lang.String argFirstName, java.lang.String argMiddleName, java.lang.String argLastName, java.lang.String argPassportSer) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.People _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PeopleBean bean = (com.hps.july.persistence.PeopleBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argMan, argFirstName, argMiddleName, argLastName, argPassportSer);
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
	 * create
	 */
	public com.hps.july.persistence.People create(int argMan, java.lang.String argFirstName, java.lang.String argMiddleName, java.lang.String argLastName, java.lang.String argPassportSer, java.lang.Boolean argIsActive) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.People _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PeopleBean bean = (com.hps.july.persistence.PeopleBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argMan, argFirstName, argMiddleName, argLastName, argPassportSer, argIsActive);
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
	 * create
	 */
	public com.hps.july.persistence.People create(int argMan) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.People _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PeopleBean bean = (com.hps.july.persistence.PeopleBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argMan);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argMan);
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
		com.hps.july.persistence.PeopleBean tmpEJB = (com.hps.july.persistence.PeopleBean) generalEJB;
		com.hps.july.persistence.PeopleKey keyClass = new com.hps.july.persistence.PeopleKey();
		keyClass.man = tmpEJB.man;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PeopleKey keyFromFields(int f0) {
		com.hps.july.persistence.PeopleKey keyClass = new com.hps.july.persistence.PeopleKey();
		keyClass.man = f0;
		return keyClass;
	}
}
