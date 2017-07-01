package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPUserRepGroupHomeBean_1512cf12
 */
public class EJSCMPUserRepGroupHomeBean_1512cf12 extends EJSHome {
	/**
	 * EJSCMPUserRepGroupHomeBean_1512cf12
	 */
	public EJSCMPUserRepGroupHomeBean_1512cf12() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.UserRepGroup postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.UserRepGroup) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.UserRepGroup findByPrimaryKey(com.hps.july.persistence.UserRepGroupKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPUserRepGroupBean_1512cf12) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.UserRepGroup create(int argUsrgrpid, java.lang.String argUsrgrpname) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.UserRepGroup _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.UserRepGroupBean bean = (com.hps.july.persistence.UserRepGroupBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argUsrgrpid, argUsrgrpname);
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
	 * findAllOrderByNameAsc
	 */
	public java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderUserRepGroupBean)persister).findAllOrderByNameAsc());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.UserRepGroupBean tmpEJB = (com.hps.july.persistence.UserRepGroupBean) generalEJB;
		com.hps.july.persistence.UserRepGroupKey keyClass = new com.hps.july.persistence.UserRepGroupKey();
		keyClass.usrgrpid = tmpEJB.usrgrpid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.UserRepGroupKey keyFromFields(int f0) {
		com.hps.july.persistence.UserRepGroupKey keyClass = new com.hps.july.persistence.UserRepGroupKey();
		keyClass.usrgrpid = f0;
		return keyClass;
	}
}
