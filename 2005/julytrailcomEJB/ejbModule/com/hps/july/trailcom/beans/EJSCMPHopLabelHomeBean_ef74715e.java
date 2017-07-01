package com.hps.july.trailcom.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPHopLabelHomeBean_ef74715e
 */
public class EJSCMPHopLabelHomeBean_ef74715e extends EJSHome {
	/**
	 * EJSCMPHopLabelHomeBean_ef74715e
	 */
	public EJSCMPHopLabelHomeBean_ef74715e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.trailcom.beans.HopLabel postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.trailcom.beans.HopLabel) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findHopLabelsByHopid
	 */
	public java.util.Enumeration findHopLabelsByHopid(com.hps.july.trailcom.beans.HopKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.trailcom.beans.EJSFinderHopLabelBean)persister).findHopLabelsByHopid(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.trailcom.beans.HopLabel create(int argHopslabelid) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.trailcom.beans.HopLabel _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.trailcom.beans.HopLabelBean bean = (com.hps.july.trailcom.beans.HopLabelBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argHopslabelid);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argHopslabelid);
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
	public com.hps.july.trailcom.beans.HopLabel findByPrimaryKey(com.hps.july.trailcom.beans.HopLabelKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.trailcom.beans.EJSJDBCPersisterCMPHopLabelBean_ef74715e) persister).findByPrimaryKey(key);
	}
	/**
	 * findByHopsidOrderByHopslabelidAsc
	 */
	public java.util.Enumeration findByHopsidOrderByHopslabelidAsc(java.lang.Integer hopid) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.trailcom.beans.EJSFinderHopLabelBean)persister).findByHopsidOrderByHopslabelidAsc(hopid));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.trailcom.beans.HopLabelBean tmpEJB = (com.hps.july.trailcom.beans.HopLabelBean) generalEJB;
		com.hps.july.trailcom.beans.HopLabelKey keyClass = new com.hps.july.trailcom.beans.HopLabelKey();
		keyClass.hopslabelid = tmpEJB.hopslabelid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.trailcom.beans.HopLabelKey keyFromFields(int f0) {
		com.hps.july.trailcom.beans.HopLabelKey keyClass = new com.hps.july.trailcom.beans.HopLabelKey();
		keyClass.hopslabelid = f0;
		return keyClass;
	}
}
