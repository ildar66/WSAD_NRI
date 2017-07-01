package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * InternalWayBillPositionFactory
 * @generated
 */
public class InternalWayBillPositionFactory extends AbstractEJBFactory {
	/**
	 * InternalWayBillPositionFactory
	 * @generated
	 */
	public InternalWayBillPositionFactory() {
		super();
	}
	/**
	 * _acquireInternalWayBillPositionHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.InternalWayBillPositionHome _acquireInternalWayBillPositionHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.InternalWayBillPositionHome) _acquireEJBHome();
	}
	/**
	 * acquireInternalWayBillPositionHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.InternalWayBillPositionHome acquireInternalWayBillPositionHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence
			.InternalWayBillPositionHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/InternalWayBillPosition";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.InternalWayBillPositionHome.class;
	}
	/**
	 * resetInternalWayBillPositionHome
	 * @generated
	 */
	public void resetInternalWayBillPositionHome() {
		resetEJBHome();
	}
	/**
	 * setInternalWayBillPositionHome
	 * @generated
	 */
	public void setInternalWayBillPositionHome(
		com.hps.july.persistence.InternalWayBillPositionHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.InternalWayBillPosition findByPrimaryKey(
		com.hps.july.persistence.DocumentPositionKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalWayBillPositionHome().findByPrimaryKey(key);
	}
	/**
	 * findMaxOrderPosition
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.InternalWayBillPosition findMaxOrderPosition(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalWayBillPositionHome().findMaxOrderPosition(
			argDocument);
	}
	/**
	 * findByDocOrderByAgregateAsc
	 * @generated
	 */
	public java.util.Enumeration findByDocOrderByAgregateAsc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalWayBillPositionHome()
			.findByDocOrderByAgregateAsc(
			argDocument);
	}
	/**
	 * findByDocumentSerialnum
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.InternalWayBillPosition findByDocumentSerialnum(
		java.lang.Integer argDocument,
		java.lang.String argSerial)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalWayBillPositionHome().findByDocumentSerialnum(
			argDocument,
			argSerial);
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
		return _acquireInternalWayBillPositionHome()
			.findDocPositionsByDocAndPolicyOrderByOrderDesc(
			argDocument,
			argPolicy);
	}
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderAsc
	 * @generated
	 */
	public java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderAsc(
		java.lang.Integer argDocument,
		java.lang.String argPolicy)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalWayBillPositionHome()
			.findDocPositionsByDocAndPolicyOrderByOrderAsc(
			argDocument,
			argPolicy);
	}
	/**
	 * findDocPositionsByDocOrderByOrderAsc
	 * @generated
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderAsc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalWayBillPositionHome()
			.findDocPositionsByDocOrderByOrderAsc(
			argDocument);
	}
	/**
	 * findByDocOrderByAgregateDesc
	 * @generated
	 */
	public java.util.Enumeration findByDocOrderByAgregateDesc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalWayBillPositionHome()
			.findByDocOrderByAgregateDesc(
			argDocument);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.InternalWayBillPosition create(
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
		return _acquireInternalWayBillPositionHome().create(
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
	 * findDocPositionsByDocOrderByOrderDesc
	 * @generated
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderDesc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalWayBillPositionHome()
			.findDocPositionsByDocOrderByOrderDesc(
			argDocument);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.InternalWayBillPosition create(
		int argDocposition)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireInternalWayBillPositionHome().create(argDocposition);
	}
	/**
	 * findBadAgregatesByDocument
	 * @generated
	 */
	public java.util.Enumeration findBadAgregatesByDocument(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalWayBillPositionHome()
			.findBadAgregatesByDocument(
			argDocument);
	}
}
