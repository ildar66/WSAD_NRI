package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPApparatPlaceTypeHomeBean_82cd314b
 */
public class EJSCMPApparatPlaceTypeHomeBean_82cd314b extends EJSHome {
	/**
	 * EJSCMPApparatPlaceTypeHomeBean_82cd314b
	 */
	public EJSCMPApparatPlaceTypeHomeBean_82cd314b() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.ApparatPlaceType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.ApparatPlaceType) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.ApparatPlaceType findByPrimaryKey(com.hps.july.persistence2.ApparatPlaceTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPApparatPlaceTypeBean_82cd314b) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.ApparatPlaceType create(int argApplacetypeid, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.ApparatPlaceType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.ApparatPlaceTypeBean bean = (com.hps.july.persistence2.ApparatPlaceTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argApplacetypeid, argName);
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
		com.hps.july.persistence2.ApparatPlaceTypeBean tmpEJB = (com.hps.july.persistence2.ApparatPlaceTypeBean) generalEJB;
		com.hps.july.persistence2.ApparatPlaceTypeKey keyClass = new com.hps.july.persistence2.ApparatPlaceTypeKey();
		keyClass.applacetypeid = tmpEJB.applacetypeid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.ApparatPlaceTypeKey keyFromFields(int f0) {
		com.hps.july.persistence2.ApparatPlaceTypeKey keyClass = new com.hps.july.persistence2.ApparatPlaceTypeKey();
		keyClass.applacetypeid = f0;
		return keyClass;
	}
}
