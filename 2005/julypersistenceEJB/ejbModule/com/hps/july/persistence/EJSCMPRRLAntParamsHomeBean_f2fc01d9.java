package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPRRLAntParamsHomeBean_f2fc01d9
 */
public class EJSCMPRRLAntParamsHomeBean_f2fc01d9 extends EJSHome {
	/**
	 * EJSCMPRRLAntParamsHomeBean_f2fc01d9
	 */
	public EJSCMPRRLAntParamsHomeBean_f2fc01d9() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.RRLAntParams postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.RRLAntParams) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.RRLAntParams create(int argRrlantid, int argResource, java.math.BigDecimal argAntDiam, java.math.BigDecimal argAmplifKoeff, java.math.BigDecimal argDNAngleH, java.math.BigDecimal argDNAngleW) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.RRLAntParams _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.RRLAntParamsBean bean = (com.hps.july.persistence.RRLAntParamsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argRrlantid, argResource, argAntDiam, argAmplifKoeff, argDNAngleH, argDNAngleW);
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
	public com.hps.july.persistence.RRLAntParams findByPrimaryKey(com.hps.july.persistence.RRLAntParamsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPRRLAntParamsBean_f2fc01d9) persister).findByPrimaryKey(key);
	}
	/**
	 * findByResourceAndDiam
	 */
	public java.util.Enumeration findByResourceAndDiam(int argResource, java.math.BigDecimal argDiam) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRRLAntParamsBean)persister).findByResourceAndDiam(argResource, argDiam));	}
	/**
	 * findByResource
	 */
	public java.util.Enumeration findByResource(int argResource) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRRLAntParamsBean)persister).findByResource(argResource));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.RRLAntParamsBean tmpEJB = (com.hps.july.persistence.RRLAntParamsBean) generalEJB;
		com.hps.july.persistence.RRLAntParamsKey keyClass = new com.hps.july.persistence.RRLAntParamsKey();
		keyClass.rrlantid = tmpEJB.rrlantid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.RRLAntParamsKey keyFromFields(int f0) {
		com.hps.july.persistence.RRLAntParamsKey keyClass = new com.hps.july.persistence.RRLAntParamsKey();
		keyClass.rrlantid = f0;
		return keyClass;
	}
}
