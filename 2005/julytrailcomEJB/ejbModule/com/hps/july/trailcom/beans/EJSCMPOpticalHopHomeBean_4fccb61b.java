package com.hps.july.trailcom.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPOpticalHopHomeBean_4fccb61b
 */
public class EJSCMPOpticalHopHomeBean_4fccb61b extends EJSHome {
	/**
	 * EJSCMPOpticalHopHomeBean_4fccb61b
	 */
	public EJSCMPOpticalHopHomeBean_4fccb61b() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.trailcom.beans.OpticalHop postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.trailcom.beans.OpticalHop) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.trailcom.beans.OpticalHop create(int hopid) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.trailcom.beans.OpticalHop _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.trailcom.beans.OpticalHopBean bean = (com.hps.july.trailcom.beans.OpticalHopBean) beanO.getEnterpriseBean();
			bean.ejbCreate(hopid);
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
	 * findOpticalHopByHopid
	 */
	public com.hps.july.trailcom.beans.OpticalHop findOpticalHopByHopid(com.hps.july.trailcom.beans.HopKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.trailcom.beans.EJSJDBCPersisterCMPOpticalHopBean_4fccb61b)persister).findOpticalHopByHopid(inKey);	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.trailcom.beans.OpticalHop findByPrimaryKey(com.hps.july.trailcom.beans.OpticalHopKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.trailcom.beans.EJSJDBCPersisterCMPOpticalHopBean_4fccb61b) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.trailcom.beans.OpticalHopBean tmpEJB = (com.hps.july.trailcom.beans.OpticalHopBean) generalEJB;
		com.hps.july.trailcom.beans.OpticalHopKey keyClass = new com.hps.july.trailcom.beans.OpticalHopKey();
		keyClass.hopid_hopsid = tmpEJB.hopid_hopsid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.trailcom.beans.OpticalHopKey keyFromFields(java.lang.Integer f0) {
		com.hps.july.trailcom.beans.OpticalHopKey keyClass = new com.hps.july.trailcom.beans.OpticalHopKey();
		keyClass.hopid_hopsid = f0;
		return keyClass;
	}
}
