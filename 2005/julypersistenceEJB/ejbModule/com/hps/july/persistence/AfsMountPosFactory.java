package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * AfsMountPosFactory
 * @generated
 */
public class AfsMountPosFactory extends AbstractEJBFactory {
	/**
	 * AfsMountPosFactory
	 * @generated
	 */
	public AfsMountPosFactory() {
		super();
	}
	/**
	 * _acquireAfsMountPosHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.AfsMountPosHome _acquireAfsMountPosHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.AfsMountPosHome) _acquireEJBHome();
	}
	/**
	 * acquireAfsMountPosHome
	 * @generated
	 */
	public com.hps.july.persistence.AfsMountPosHome acquireAfsMountPosHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.AfsMountPosHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/AfsMountPos";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.AfsMountPosHome.class;
	}
	/**
	 * resetAfsMountPosHome
	 * @generated
	 */
	public void resetAfsMountPosHome() {
		resetEJBHome();
	}
	/**
	 * setAfsMountPosHome
	 * @generated
	 */
	public void setAfsMountPosHome(
		com.hps.july.persistence.AfsMountPosHome home) {
		setEJBHome(home);
	}
	/**
	 * findDocPositionsByDocOrderByOrderAsc
	 * @generated
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderAsc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountPosHome().findDocPositionsByDocOrderByOrderAsc(
			argDocument);
	}
	/**
	 * findMaxOrderPosition
	 * @generated
	 */
	public com.hps.july.persistence.AfsMountPos findMaxOrderPosition(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountPosHome().findMaxOrderPosition(argDocument);
	}
	/**
	 * findByAfs
	 * @generated
	 */
	public java.util.Enumeration findByAfs(java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountPosHome().findByAfs(argDocument);
	}
	/**
	 * findAfsMountPosesByGroundresource
	 * @generated
	 */
	public java.util.Enumeration findAfsMountPosesByGroundresource(
		com.hps.july.persistence.ResourceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountPosHome().findAfsMountPosesByGroundresource(
			inKey);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.AfsMountPos findByPrimaryKey(
		com.hps.july.persistence.DocumentPositionKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountPosHome().findByPrimaryKey(key);
	}
	/**
	 * findBadAgregatesByDocument
	 * @generated
	 */
	public java.util.Enumeration findBadAgregatesByDocument(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountPosHome().findBadAgregatesByDocument(
			argDocument);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AfsMountPos create(
		int argDocposition,
		java.lang.Integer argResource,
		java.lang.Integer argOwner,
		java.lang.Integer argDocument,
		int argOrder,
		java.math.BigDecimal argQty,
		java.math.BigDecimal argPrice,
		java.lang.Boolean argSourceBoxed,
		java.lang.Boolean argResultBoxed,
		java.lang.Boolean argSourceBroken,
		java.lang.Boolean argResultBroken,
		java.lang.Boolean argSourceClosed,
		java.lang.Boolean argResultClosed)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAfsMountPosHome().create(
			argDocposition,
			argResource,
			argOwner,
			argDocument,
			argOrder,
			argQty,
			argPrice,
			argSourceBoxed,
			argResultBoxed,
			argSourceBroken,
			argResultBroken,
			argSourceClosed,
			argResultClosed);
	}
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderAsc
	 * @generated
	 */
	public java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderAsc(
		java.lang.Integer argDocument,
		java.lang.String argPolicy)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountPosHome()
			.findDocPositionsByDocAndPolicyOrderByOrderAsc(
			argDocument,
			argPolicy);
	}
	/**
	 * findByDocumentSerialnum
	 * @generated
	 */
	public com.hps.july.persistence.AfsMountPos findByDocumentSerialnum(
		java.lang.Integer argDocument,
		java.lang.String argSerial)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountPosHome().findByDocumentSerialnum(
			argDocument,
			argSerial);
	}
	/**
	 * findByDocOrderByAgregateAsc
	 * @generated
	 */
	public java.util.Enumeration findByDocOrderByAgregateAsc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountPosHome().findByDocOrderByAgregateAsc(
			argDocument);
	}
	/**
	 * findChildrenByParent
	 * @generated
	 */
	public java.util.Enumeration findChildrenByParent(
		java.lang.Integer parentAfsPosition)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountPosHome().findChildrenByParent(
			parentAfsPosition);
	}
	/**
	 * findChildByParent
	 * @generated
	 */
	public com.hps.july.persistence.AfsMountPos findChildByParent(
		java.lang.Integer parentAfsPosition)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountPosHome().findChildByParent(parentAfsPosition);
	}
	/**
	 * findDocPositionsByDocOrderByOrderDesc
	 * @generated
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderDesc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountPosHome().findDocPositionsByDocOrderByOrderDesc(
			argDocument);
	}
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderDesc
	 * @generated
	 */
	public java
		.util
		.Enumeration findDocPositionsByDocAndPolicyOrderByOrderDesc(
		java.lang.Integer argDocument,
		java.lang.String argPolicy)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountPosHome()
			.findDocPositionsByDocAndPolicyOrderByOrderDesc(
			argDocument,
			argPolicy);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AfsMountPos create(int argDocposition)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAfsMountPosHome().create(argDocposition);
	}
	/**
	 * findByDocOrderByAgregateDesc
	 * @generated
	 */
	public java.util.Enumeration findByDocOrderByAgregateDesc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountPosHome().findByDocOrderByAgregateDesc(
			argDocument);
	}
}
