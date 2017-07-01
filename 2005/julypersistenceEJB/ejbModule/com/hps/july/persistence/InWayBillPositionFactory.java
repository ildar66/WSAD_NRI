package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * InWayBillPositionFactory
 * @generated
 */
public class InWayBillPositionFactory extends AbstractEJBFactory {
	/**
	 * InWayBillPositionFactory
	 * @generated
	 */
	public InWayBillPositionFactory() {
		super();
	}
	/**
	 * _acquireInWayBillPositionHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.InWayBillPositionHome _acquireInWayBillPositionHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.InWayBillPositionHome) _acquireEJBHome();
	}
	/**
	 * acquireInWayBillPositionHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.InWayBillPositionHome acquireInWayBillPositionHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence
			.InWayBillPositionHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/InWayBillPosition";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.InWayBillPositionHome.class;
	}
	/**
	 * resetInWayBillPositionHome
	 * @generated
	 */
	public void resetInWayBillPositionHome() {
		resetEJBHome();
	}
	/**
	 * setInWayBillPositionHome
	 * @generated
	 */
	public void setInWayBillPositionHome(
		com.hps.july.persistence.InWayBillPositionHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.InWayBillPosition findByPrimaryKey(
		com.hps.july.persistence.DocumentPositionKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInWayBillPositionHome().findByPrimaryKey(key);
	}
	/**
	 * findMaxOrderPosition
	 * @generated
	 */
	public com.hps.july.persistence.InWayBillPosition findMaxOrderPosition(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInWayBillPositionHome().findMaxOrderPosition(
			argDocument);
	}
	/**
	 * findInWayBillPositionByOuterDocPosition
	 * @generated
	 */
	public java.util.Enumeration findInWayBillPositionByOuterDocPosition(
		com.hps.july.persistence.OuterDocPositionKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInWayBillPositionHome()
			.findInWayBillPositionByOuterDocPosition(
			inKey);
	}
	/**
	 * findByDocumentSerialnum
	 * @generated
	 */
	public com.hps.july.persistence.InWayBillPosition findByDocumentSerialnum(
		java.lang.Integer argDocument,
		java.lang.String argSerial)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInWayBillPositionHome().findByDocumentSerialnum(
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
		return _acquireInWayBillPositionHome()
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
		return _acquireInWayBillPositionHome()
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
		return _acquireInWayBillPositionHome()
			.findDocPositionsByDocOrderByOrderAsc(
			argDocument);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.InWayBillPosition create(
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
		java.lang.Boolean argResultClosed,
		java.lang.Integer argOuterDocPos,
		java.math.BigDecimal argSourcePrice)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireInWayBillPositionHome().create(
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
			argResultClosed,
			argOuterDocPos,
			argSourcePrice);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.InWayBillPosition create(
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
		java.lang.Boolean argResultClosed,
		java.lang.Integer argOuterDocPos)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireInWayBillPositionHome().create(
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
			argResultClosed,
			argOuterDocPos);
	}
	/**
	 * findDocPositionsByDocOrderByOrderDesc
	 * @generated
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderDesc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInWayBillPositionHome()
			.findDocPositionsByDocOrderByOrderDesc(
			argDocument);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.InWayBillPosition create(
		int argDocposition)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireInWayBillPositionHome().create(argDocposition);
	}
	/**
	 * findBadAgregatesByDocument
	 * @generated
	 */
	public java.util.Enumeration findBadAgregatesByDocument(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInWayBillPositionHome().findBadAgregatesByDocument(
			argDocument);
	}
}
