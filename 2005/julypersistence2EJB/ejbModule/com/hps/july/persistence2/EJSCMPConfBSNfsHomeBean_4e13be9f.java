package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPConfBSNfsHomeBean_4e13be9f
 */
public class EJSCMPConfBSNfsHomeBean_4e13be9f extends EJSHome {
	/**
	 * EJSCMPConfBSNfsHomeBean_4e13be9f
	 */
	public EJSCMPConfBSNfsHomeBean_4e13be9f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.ConfBSNfs postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.ConfBSNfs) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.ConfBSNfs findByPrimaryKey(com.hps.july.persistence2.ConfBSNfsKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPConfBSNfsBean_4e13be9f) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * findByAll
	 */
	public java.util.Enumeration findByAll(java.lang.String argConfType, int argSectA, int argSectB, int argSectC, int argSectD, int argSectE, int argSectF, int argSectG, int argSectH, java.math.BigDecimal argVoltage, java.lang.String argNFSId, int argCodeNRI) throws javax.ejb.FinderException, java.rmi.RemoteException {
return super.getEnumeration(((com.hps.july.persistence2.EJSFinderConfBSNfsBean)persister).findByAll(argConfType, argSectA, argSectB, argSectC, argSectD, argSectE, argSectF, argSectG, argSectH, argVoltage, argNFSId, argCodeNRI));	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.ConfBSNfs create(int argId, int argCodeNri, int argSectorA, int argSectorB, int argSectorC, int argSectorD, int argSectorE, int argSectorF, int argSectorG, int argSectorH, java.lang.String argNfsItemId, java.lang.String argConfType, int argSect_o900, int argSect_o1800) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.ConfBSNfs _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.ConfBSNfsBean bean = (com.hps.july.persistence2.ConfBSNfsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argId, argCodeNri, argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argNfsItemId, argConfType, argSect_o900, argSect_o1800);
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
		com.hps.july.persistence2.ConfBSNfsBean tmpEJB = (com.hps.july.persistence2.ConfBSNfsBean) generalEJB;
		com.hps.july.persistence2.ConfBSNfsKey keyClass = new com.hps.july.persistence2.ConfBSNfsKey();
		keyClass.id = tmpEJB.id;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.ConfBSNfsKey keyFromFields(int f0) {
		com.hps.july.persistence2.ConfBSNfsKey keyClass = new com.hps.july.persistence2.ConfBSNfsKey();
		keyClass.id = f0;
		return keyClass;
	}
}
