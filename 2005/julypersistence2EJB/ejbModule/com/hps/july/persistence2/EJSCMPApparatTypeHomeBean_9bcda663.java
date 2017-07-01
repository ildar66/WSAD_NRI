package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPApparatTypeHomeBean_9bcda663
 */
public class EJSCMPApparatTypeHomeBean_9bcda663 extends EJSHome {
	/**
	 * EJSCMPApparatTypeHomeBean_9bcda663
	 */
	public EJSCMPApparatTypeHomeBean_9bcda663() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.ApparatType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.ApparatType) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.ApparatType findByPrimaryKey(com.hps.july.persistence2.ApparatTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPApparatTypeBean_9bcda663) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.ApparatType create(int argAptypeid, java.lang.String argName, java.lang.String argApType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.ApparatType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.ApparatTypeBean bean = (com.hps.july.persistence2.ApparatTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argAptypeid, argName, argApType);
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
		com.hps.july.persistence2.ApparatTypeBean tmpEJB = (com.hps.july.persistence2.ApparatTypeBean) generalEJB;
		com.hps.july.persistence2.ApparatTypeKey keyClass = new com.hps.july.persistence2.ApparatTypeKey();
		keyClass.aptypeid = tmpEJB.aptypeid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.ApparatTypeKey keyFromFields(int f0) {
		com.hps.july.persistence2.ApparatTypeKey keyClass = new com.hps.july.persistence2.ApparatTypeKey();
		keyClass.aptypeid = f0;
		return keyClass;
	}
}
