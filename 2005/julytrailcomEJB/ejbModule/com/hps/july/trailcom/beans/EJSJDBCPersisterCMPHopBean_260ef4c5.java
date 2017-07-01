package com.hps.july.trailcom.beans;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPHopBean_260ef4c5
 */
public class EJSJDBCPersisterCMPHopBean_260ef4c5 extends EJSJDBCPersister implements com.hps.july.trailcom.beans.EJSFinderHopBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO hops (hopsid, siteid_endb, speed, equipmentid_endb, equipmentid_enda, abis_number, hopstype, hopstate, rezerv, expindate, beenetid, expoutdate, lease_info, permstatus, siteid_enda, modified, created, createdby, modifiedby) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM hops  WHERE hopsid = ?";
	private static final String _storeString = "UPDATE hops  SET siteid_endb = ?, speed = ?, equipmentid_endb = ?, equipmentid_enda = ?, abis_number = ?, hopstype = ?, hopstate = ?, rezerv = ?, expindate = ?, beenetid = ?, expoutdate = ?, lease_info = ?, permstatus = ?, siteid_enda = ?, modified = ?, created = ?, createdby = ?, modifiedby = ? WHERE hopsid = ?";
	private static final String _loadString = "SELECT T1.siteid_endb, T1.speed, T1.equipmentid_endb, T1.equipmentid_enda, T1.hopsid, T1.abis_number, T1.hopstype, T1.hopstate, T1.rezerv, T1.expindate, T1.beenetid, T1.expoutdate, T1.lease_info, T1.permstatus, T1.siteid_enda, T1.modified, T1.created, T1.createdby, T1.modifiedby FROM hops  T1 WHERE T1.hopsid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPHopBean_260ef4c5
	 */
	public EJSJDBCPersisterCMPHopBean_260ef4c5() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postInit
	 */
	public void postInit() {
	}
	/**
	 * _create
	 */
	public void _create(EntityBean eb) throws Exception {
		Object objectTemp = null;
		HopBean b = (HopBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.siteid_endb == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.siteid_endb.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.speed);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			pstmt.setInt(4, b.equipmentid_endb);
			pstmt.setInt(5, b.equipmentid_enda);
			pstmt.setInt(1, b.hopsid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.abis_number);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.hopstype);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.hopstate);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.rezerv);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			if (b.expindate == null) {
				pstmt.setNull(10, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(10, b.expindate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.beenetid);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			if (b.expoutdate == null) {
				pstmt.setNull(12, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(12, b.expoutdate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.lease_info);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.permstatus);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			if (b.siteid_enda == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.siteid_enda.intValue());
			}
			if (b.modified == null) {
				pstmt.setNull(16, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(16, b.modified);
			}
			if (b.created == null) {
				pstmt.setNull(17, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(17, b.created);
			}
			if (b.createdby == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.createdby.intValue());
			}
			if (b.modifiedby == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.modifiedby.intValue());
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * hydrate
	 */
	public void hydrate(EntityBean eb, Object data, Object pKey) throws Exception {
		Object objectTemp = null;
		HopBean b = (HopBean) eb;
		com.hps.july.trailcom.beans.HopKey _primaryKey = (com.hps.july.trailcom.beans.HopKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.hopsid = _primaryKey.hopsid;
		tempint = resultSet.getInt(1);
		b.siteid_endb = resultSet.wasNull() ? null : new Integer(tempint);
		b.speed = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.equipmentid_endb = resultSet.getInt(3);
		b.equipmentid_enda = resultSet.getInt(4);
		b.abis_number = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(6));
		b.hopstype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(7));
		b.hopstate = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(8));
		b.rezerv = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(9));
		b.expindate = resultSet.getDate(10);
		b.beenetid = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(11));
		b.expoutdate = resultSet.getDate(12);
		b.lease_info = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(13));
		b.permstatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(14));
		tempint = resultSet.getInt(15);
		b.siteid_enda = resultSet.wasNull() ? null : new Integer(tempint);
		b.modified = resultSet.getTimestamp(16);
		b.created = resultSet.getTimestamp(17);
		tempint = resultSet.getInt(18);
		b.createdby = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(19);
		b.modifiedby = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		HopBean b = (HopBean) eb;
		com.hps.july.trailcom.beans.HopKey _primaryKey = (com.hps.july.trailcom.beans.HopKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.hopsid);
			resultSet = pstmt.executeQuery();
			if (!(resultSet.next())) throw new javax.ejb.ObjectNotFoundException();
			hydrate(eb, resultSet, pKey);
		}
		finally {
			if (resultSet != null) resultSet.close();
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * refresh
	 */
	public void refresh(EntityBean eb, boolean forUpdate) throws Exception {
		HopBean b = (HopBean) eb;
		com.hps.july.trailcom.beans.HopKey _primaryKey = new com.hps.july.trailcom.beans.HopKey();
		_primaryKey.hopsid = b.hopsid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		HopBean b = (HopBean) eb;
		com.hps.july.trailcom.beans.HopKey _primaryKey = new com.hps.july.trailcom.beans.HopKey();
		_primaryKey.hopsid = b.hopsid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(19, _primaryKey.hopsid);
			if (b.siteid_endb == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.siteid_endb.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.speed);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			pstmt.setInt(3, b.equipmentid_endb);
			pstmt.setInt(4, b.equipmentid_enda);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.abis_number);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.hopstype);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.hopstate);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.rezerv);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			if (b.expindate == null) {
				pstmt.setNull(9, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(9, b.expindate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.beenetid);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			if (b.expoutdate == null) {
				pstmt.setNull(11, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(11, b.expoutdate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.lease_info);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.permstatus);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			if (b.siteid_enda == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.siteid_enda.intValue());
			}
			if (b.modified == null) {
				pstmt.setNull(15, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(15, b.modified);
			}
			if (b.created == null) {
				pstmt.setNull(16, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(16, b.created);
			}
			if (b.createdby == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.createdby.intValue());
			}
			if (b.modifiedby == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.modifiedby.intValue());
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * remove
	 */
	public void remove(EntityBean eb) throws Exception {
		Object objectTemp = null;
		HopBean b = (HopBean) eb;
		com.hps.july.trailcom.beans.HopKey _primaryKey = new com.hps.july.trailcom.beans.HopKey();
		_primaryKey.hopsid = b.hopsid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.hopsid);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * getPrimaryKey
	 */
	public Object getPrimaryKey(Object data) throws Exception {
		com.hps.july.trailcom.beans.HopKey key = new com.hps.july.trailcom.beans.HopKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.hopsid = resultSet.getInt(5);
			return key;
		}
return null;
	}
	/**
	 * findBySiteid_endbOrderByHopsidAsc
	 */
	public EJSFinder findBySiteid_endbOrderByHopsidAsc(java.lang.Integer siteid_endb) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.siteid_endb, T1.speed, T1.equipmentid_endb, T1.equipmentid_enda, T1.hopsid, T1.abis_number, T1.hopstype, T1.hopstate, T1.rezerv, T1.expindate, T1.beenetid, T1.expoutdate, T1.lease_info, T1.permstatus, T1.siteid_enda, T1.modified, T1.created, T1.createdby, T1.modifiedby FROM hops  T1 WHERE siteid_endb = ? order by hopsid asc");
			pstmt.setObject(1, siteid_endb);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findBySiteid_endaOrderByHopsidAsc
	 */
	public EJSFinder findBySiteid_endaOrderByHopsidAsc(java.lang.Integer siteid_enda) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.siteid_endb, T1.speed, T1.equipmentid_endb, T1.equipmentid_enda, T1.hopsid, T1.abis_number, T1.hopstype, T1.hopstate, T1.rezerv, T1.expindate, T1.beenetid, T1.expoutdate, T1.lease_info, T1.permstatus, T1.siteid_enda, T1.modified, T1.created, T1.createdby, T1.modifiedby FROM hops  T1 WHERE siteid_enda = ? order by hopsid asc");
			pstmt.setObject(1, siteid_enda);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByPositions
	 */
	public EJSFinder findByPositions(java.lang.Boolean isTypeR, java.lang.Boolean isTypeO, java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isAllType, java.lang.Boolean isDAMPS, java.lang.Boolean isGSM900, java.lang.Boolean isDCS1800, java.lang.Boolean isControllers, java.lang.Boolean isWorker, java.lang.Integer argWorker) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByPositions(isTypeR, isTypeO, isNetZone, argNetZone, isAllType, isDAMPS, isGSM900, isDCS1800, isControllers, isWorker, argWorker);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByPositionAndType
	 */
	public EJSFinder findByPositionAndType(java.lang.String hopstype, java.lang.Integer siteid_enda, java.lang.Integer siteid_endb) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.siteid_endb, T1.speed, T1.equipmentid_endb, T1.equipmentid_enda, T1.hopsid, T1.abis_number, T1.hopstype, T1.hopstate, T1.rezerv, T1.expindate, T1.beenetid, T1.expoutdate, T1.lease_info, T1.permstatus, T1.siteid_enda, T1.modified, T1.created, T1.createdby, T1.modifiedby FROM hops  T1 WHERE  hopstype = ? and (equipmentid_enda = ? or equipmentid_endb = ?) order by hopsid");
			if (hopstype == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, hopstype);
			}
			pstmt.setObject(2, siteid_enda);
			pstmt.setObject(3, siteid_endb);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findNestedLines
	 */
	public EJSFinder findNestedLines(java.lang.Boolean useType, java.lang.String type, java.lang.Integer hop, java.lang.Integer position) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findNestedLines(useType, type, hop, position);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findHopsByPosition
	 */
	public EJSFinder findHopsByPosition(java.lang.Integer position) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findHopsByPosition(position);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.trailcom.beans.Hop findByPrimaryKey(com.hps.july.trailcom.beans.HopKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.trailcom.beans.Hop) home.activateBean(key);
	}
	private static final String genericFindSqlString = "SELECT T1.siteid_endb, T1.speed, T1.equipmentid_endb, T1.equipmentid_enda, T1.hopsid, T1.abis_number, T1.hopstype, T1.hopstate, T1.rezerv, T1.expindate, T1.beenetid, T1.expoutdate, T1.lease_info, T1.permstatus, T1.siteid_enda, T1.modified, T1.created, T1.createdby, T1.modifiedby FROM hops  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {300};
	/**
	 * getMergedPreparedStatement
	 */
	public PreparedStatement getMergedPreparedStatement(String searchCondition) throws Exception {
		StringBuffer sb = new StringBuffer(genericFindSqlString);
		for (int i = 0; i < genericFindInsertPoints.length; i++) {
		   sb.insert(genericFindInsertPoints[i], searchCondition);
		}
		return super.getPreparedStatement(sb.toString());
	}
	/**
	 * getMergedWhereCount
	 */
	public int getMergedWhereCount() {
		return genericFindInsertPoints.length;
	}
	/**
	 * getGenericFindSqlString
	 */
	public String getGenericFindSqlString() {
		return genericFindSqlString;
	}
	/**
	 * getGenericFindInsertPoints
	 */
	public int[] getGenericFindInsertPoints() {
		return genericFindInsertPoints;
	}
	private HopBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.trailcom.beans.HopBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.trailcom.beans.HopBeanFinderObject temp_finderObject = new com.hps.july.trailcom.beans.HopBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
