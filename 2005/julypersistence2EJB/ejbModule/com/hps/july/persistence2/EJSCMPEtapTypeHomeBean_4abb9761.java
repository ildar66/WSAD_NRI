package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPEtapTypeHomeBean_4abb9761
 */
public class EJSCMPEtapTypeHomeBean_4abb9761 extends EJSHome {
	/**
	 * EJSCMPEtapTypeHomeBean_4abb9761
	 */
	public EJSCMPEtapTypeHomeBean_4abb9761() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.EtapType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.EtapType) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.EtapType findByPrimaryKey(com.hps.july.persistence2.EtapTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPEtapTypeBean_4abb9761) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.EtapType create(int argEtaptypeid, java.lang.String argEttypename, boolean argHaveEndTime) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.EtapType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.EtapTypeBean bean = (com.hps.july.persistence2.EtapTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argEtaptypeid, argEttypename, argHaveEndTime);
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
		com.hps.july.persistence2.EtapTypeBean tmpEJB = (com.hps.july.persistence2.EtapTypeBean) generalEJB;
		com.hps.july.persistence2.EtapTypeKey keyClass = new com.hps.july.persistence2.EtapTypeKey();
		keyClass.etaptypeid = tmpEJB.etaptypeid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.EtapTypeKey keyFromFields(int f0) {
		com.hps.july.persistence2.EtapTypeKey keyClass = new com.hps.july.persistence2.EtapTypeKey();
		keyClass.etaptypeid = f0;
		return keyClass;
	}
}
