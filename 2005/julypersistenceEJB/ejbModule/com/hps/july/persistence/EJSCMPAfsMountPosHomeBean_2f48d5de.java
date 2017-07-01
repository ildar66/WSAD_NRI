package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAfsMountPosHomeBean_2f48d5de
 */
public class EJSCMPAfsMountPosHomeBean_2f48d5de extends EJSHome {
	/**
	 * EJSCMPAfsMountPosHomeBean_2f48d5de
	 */
	public EJSCMPAfsMountPosHomeBean_2f48d5de() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AfsMountPos postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AfsMountPos) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findDocPositionsByDocOrderByOrderAsc
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderAsc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAfsMountPosBean)persister).findDocPositionsByDocOrderByOrderAsc(argDocument));	}
	/**
	 * findMaxOrderPosition
	 */
	public com.hps.july.persistence.AfsMountPos findMaxOrderPosition(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPAfsMountPosBean_2f48d5de)persister).findMaxOrderPosition(argDocument);	}
	/**
	 * findByAfs
	 */
	public java.util.Enumeration findByAfs(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAfsMountPosBean)persister).findByAfs(argDocument));	}
	/**
	 * findAfsMountPosesByGroundresource
	 */
	public java.util.Enumeration findAfsMountPosesByGroundresource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAfsMountPosBean)persister).findAfsMountPosesByGroundresource(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.AfsMountPos findByPrimaryKey(com.hps.july.persistence.DocumentPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPAfsMountPosBean_2f48d5de) persister).findByPrimaryKey(key);
	}
	/**
	 * findBadAgregatesByDocument
	 */
	public java.util.Enumeration findBadAgregatesByDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAfsMountPosBean)persister).findBadAgregatesByDocument(argDocument));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.AfsMountPos create(int argDocposition, java.lang.Integer argResource, java.lang.Integer argOwner, java.lang.Integer argDocument, int argOrder, java.math.BigDecimal argQty, java.math.BigDecimal argPrice, java.lang.Boolean argSourceBoxed, java.lang.Boolean argResultBoxed, java.lang.Boolean argSourceBroken, java.lang.Boolean argResultBroken, java.lang.Boolean argSourceClosed, java.lang.Boolean argResultClosed) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.AfsMountPos _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AfsMountPosBean bean = (com.hps.july.persistence.AfsMountPosBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocposition, argResource, argOwner, argDocument, argOrder, argQty, argPrice, argSourceBoxed, argResultBoxed, argSourceBroken, argResultBroken, argSourceClosed, argResultClosed);
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
	 * findDocPositionsByDocAndPolicyOrderByOrderAsc
	 */
	public java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderAsc(java.lang.Integer argDocument, java.lang.String argPolicy) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAfsMountPosBean)persister).findDocPositionsByDocAndPolicyOrderByOrderAsc(argDocument, argPolicy));	}
	/**
	 * findByDocumentSerialnum
	 */
	public com.hps.july.persistence.AfsMountPos findByDocumentSerialnum(java.lang.Integer argDocument, java.lang.String argSerial) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPAfsMountPosBean_2f48d5de)persister).findByDocumentSerialnum(argDocument, argSerial);	}
	/**
	 * findByDocOrderByAgregateAsc
	 */
	public java.util.Enumeration findByDocOrderByAgregateAsc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAfsMountPosBean)persister).findByDocOrderByAgregateAsc(argDocument));	}
	/**
	 * findChildrenByParent
	 */
	public java.util.Enumeration findChildrenByParent(java.lang.Integer parentAfsPosition) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAfsMountPosBean)persister).findChildrenByParent(parentAfsPosition));	}
	/**
	 * findChildByParent
	 */
	public com.hps.july.persistence.AfsMountPos findChildByParent(java.lang.Integer parentAfsPosition) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPAfsMountPosBean_2f48d5de)persister).findChildByParent(parentAfsPosition);	}
	/**
	 * findDocPositionsByDocOrderByOrderDesc
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderDesc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAfsMountPosBean)persister).findDocPositionsByDocOrderByOrderDesc(argDocument));	}
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderDesc
	 */
	public java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderDesc(java.lang.Integer argDocument, java.lang.String argPolicy) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAfsMountPosBean)persister).findDocPositionsByDocAndPolicyOrderByOrderDesc(argDocument, argPolicy));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.AfsMountPos create(int argDocposition) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.AfsMountPos _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AfsMountPosBean bean = (com.hps.july.persistence.AfsMountPosBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocposition);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argDocposition);
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
	 * findByDocOrderByAgregateDesc
	 */
	public java.util.Enumeration findByDocOrderByAgregateDesc(java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAfsMountPosBean)persister).findByDocOrderByAgregateDesc(argDocument));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.AfsMountPosBean tmpEJB = (com.hps.july.persistence.AfsMountPosBean) generalEJB;
		com.hps.july.persistence.DocumentPositionKey keyClass = new com.hps.july.persistence.DocumentPositionKey();
		keyClass.docposition = tmpEJB.docposition;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.DocumentPositionKey keyFromFields(int f0) {
		com.hps.july.persistence.DocumentPositionKey keyClass = new com.hps.july.persistence.DocumentPositionKey();
		keyClass.docposition = f0;
		return keyClass;
	}
}
