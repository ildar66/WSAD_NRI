package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEExpenceHomeBean_74e71f50
 */
public class EJSCMPPIEExpenceHomeBean_74e71f50 extends EJSHome {
	/**
	 * EJSCMPPIEExpenceHomeBean_74e71f50
	 */
	public EJSCMPPIEExpenceHomeBean_74e71f50() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEExpence postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEExpence) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByOwnerAndRecordstatusOrderByNameAsc
	 */
	public java.util.Enumeration findByOwnerAndRecordstatusOrderByNameAsc(java.lang.Integer owner, java.lang.String recordstatus) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEExpenceBean)persister).findByOwnerAndRecordstatusOrderByNameAsc(owner, recordstatus));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEExpence create(int argIdexpencenri, int argOwner, java.lang.String argIdItem, java.lang.String argNameItem, java.lang.String argRecordStatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEExpence _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEExpenceBean bean = (com.hps.july.persistence.PIEExpenceBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdexpencenri, argOwner, argIdItem, argNameItem, argRecordStatus);
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
	public com.hps.july.persistence.PIEExpence findByPrimaryKey(com.hps.july.persistence.PIEExpenceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEExpenceBean_74e71f50) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEExpenceBean tmpEJB = (com.hps.july.persistence.PIEExpenceBean) generalEJB;
		com.hps.july.persistence.PIEExpenceKey keyClass = new com.hps.july.persistence.PIEExpenceKey();
		keyClass.idexpencenri = tmpEJB.idexpencenri;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEExpenceKey keyFromFields(int f0) {
		com.hps.july.persistence.PIEExpenceKey keyClass = new com.hps.july.persistence.PIEExpenceKey();
		keyClass.idexpencenri = f0;
		return keyClass;
	}
}
