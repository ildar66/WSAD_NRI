package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPEtap2HopHomeBean_9a16d484
 */
public class EJSCMPEtap2HopHomeBean_9a16d484 extends EJSHome {
	/**
	 * EJSCMPEtap2HopHomeBean_9a16d484
	 */
	public EJSCMPEtap2HopHomeBean_9a16d484() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Etap2Hop postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Etap2Hop) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findBySitedocAndPermid
	 */
	public java.util.Enumeration findBySitedocAndPermid(java.lang.Integer argSiteDoc, java.lang.Integer argPermid) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence2.EJSFinderEtap2HopBean)persister).findBySitedocAndPermid(argSiteDoc, argPermid));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence2.Etap2Hop findByPrimaryKey(com.hps.july.persistence2.Etap2HopKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPEtap2HopBean_9a16d484) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.Etap2Hop create(int argHopsid, int argSitedoc, int argFreqpermid) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.Etap2Hop _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.Etap2HopBean bean = (com.hps.july.persistence2.Etap2HopBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argHopsid, argSitedoc, argFreqpermid);
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
		com.hps.july.persistence2.Etap2HopBean tmpEJB = (com.hps.july.persistence2.Etap2HopBean) generalEJB;
		com.hps.july.persistence2.Etap2HopKey keyClass = new com.hps.july.persistence2.Etap2HopKey();
		keyClass.hopsid = tmpEJB.hopsid;
		keyClass.sitedoc = tmpEJB.sitedoc;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.Etap2HopKey keyFromFields(int f0, int f1) {
		com.hps.july.persistence2.Etap2HopKey keyClass = new com.hps.july.persistence2.Etap2HopKey();
		keyClass.hopsid = f0;
		keyClass.sitedoc = f1;
		return keyClass;
	}
}
