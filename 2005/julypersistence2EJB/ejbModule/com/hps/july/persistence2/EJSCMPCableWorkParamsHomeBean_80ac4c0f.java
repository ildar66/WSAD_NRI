package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCableWorkParamsHomeBean_80ac4c0f
 */
public class EJSCMPCableWorkParamsHomeBean_80ac4c0f extends EJSHome {
	/**
	 * EJSCMPCableWorkParamsHomeBean_80ac4c0f
	 */
	public EJSCMPCableWorkParamsHomeBean_80ac4c0f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.CableWorkParams postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.CableWorkParams) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByCable
	 */
	public java.util.Enumeration findByCable(java.lang.Integer argCableId) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence2.EJSFinderCableWorkParamsBean)persister).findByCable(argCableId));	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.CableWorkParams create(short argBand, int argId_anten, int argId_cable) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.CableWorkParams _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.CableWorkParamsBean bean = (com.hps.july.persistence2.CableWorkParamsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argBand, argId_anten, argId_cable);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argBand, argId_anten, argId_cable);
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
	public com.hps.july.persistence2.CableWorkParams findByPrimaryKey(com.hps.july.persistence2.CableWorkParamsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPCableWorkParamsBean_80ac4c0f) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.CableWorkParamsBean tmpEJB = (com.hps.july.persistence2.CableWorkParamsBean) generalEJB;
		com.hps.july.persistence2.CableWorkParamsKey keyClass = new com.hps.july.persistence2.CableWorkParamsKey();
		keyClass.id_anten = tmpEJB.id_anten;
		keyClass.id_cable = tmpEJB.id_cable;
		keyClass.band = tmpEJB.band;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.CableWorkParamsKey keyFromFields(int f0, int f1, short f2) {
		com.hps.july.persistence2.CableWorkParamsKey keyClass = new com.hps.july.persistence2.CableWorkParamsKey();
		keyClass.id_anten = f0;
		keyClass.id_cable = f1;
		keyClass.band = f2;
		return keyClass;
	}
}
