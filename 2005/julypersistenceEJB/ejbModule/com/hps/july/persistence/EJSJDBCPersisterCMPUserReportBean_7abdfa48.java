package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPUserReportBean_7abdfa48
 */
public class EJSJDBCPersisterCMPUserReportBean_7abdfa48 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderUserReportBean {
	private static final String _createString = "INSERT INTO UserReports (userrepid, classname, jspclass, jspname, repname, rptname, rptparams, usergrpid) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM UserReports  WHERE userrepid = ?";
	private static final String _storeString = "UPDATE UserReports  SET classname = ?, jspclass = ?, jspname = ?, repname = ?, rptname = ?, rptparams = ?, usergrpid = ? WHERE userrepid = ?";
	private static final String _loadString = "SELECT T1.userrepid, T1.classname, T1.jspclass, T1.jspname, T1.repname, T1.rptname, T1.rptparams, T1.usergrpid FROM UserReports  T1 WHERE T1.userrepid = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPUserReportBean_7abdfa48
	 */
	public EJSJDBCPersisterCMPUserReportBean_7abdfa48() throws java.rmi.RemoteException {
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
		UserReportBean b = (UserReportBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.userrepid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.classname);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.jspclass);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.jspname);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.repname);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.rptname);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.rptparams == null) {
				pstmt.setNull(7, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(7, b.rptparams);
			}
			if (b.userRepGroup_usrgrpid == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.userRepGroup_usrgrpid.intValue());
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
		UserReportBean b = (UserReportBean) eb;
		com.hps.july.persistence.UserReportKey _primaryKey = (com.hps.july.persistence.UserReportKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.userrepid = _primaryKey.userrepid;
		b.classname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.jspclass = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.jspname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.repname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.rptname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(6));
		b.rptparams = resultSet.getString(7);
		tempint = resultSet.getInt(8);
		b.userRepGroup_usrgrpid = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		UserReportBean b = (UserReportBean) eb;
		com.hps.july.persistence.UserReportKey _primaryKey = (com.hps.july.persistence.UserReportKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.userrepid);
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
		UserReportBean b = (UserReportBean) eb;
		com.hps.july.persistence.UserReportKey _primaryKey = new com.hps.july.persistence.UserReportKey();
		_primaryKey.userrepid = b.userrepid;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		UserReportBean b = (UserReportBean) eb;
		com.hps.july.persistence.UserReportKey _primaryKey = new com.hps.july.persistence.UserReportKey();
		_primaryKey.userrepid = b.userrepid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(8, _primaryKey.userrepid);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.classname);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.jspclass);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.jspname);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.repname);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.rptname);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.rptparams == null) {
				pstmt.setNull(6, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(6, b.rptparams);
			}
			if (b.userRepGroup_usrgrpid == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.userRepGroup_usrgrpid.intValue());
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
		UserReportBean b = (UserReportBean) eb;
		com.hps.july.persistence.UserReportKey _primaryKey = new com.hps.july.persistence.UserReportKey();
		_primaryKey.userrepid = b.userrepid;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.userrepid);
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
		com.hps.july.persistence.UserReportKey key = new com.hps.july.persistence.UserReportKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.userrepid = resultSet.getInt(1);
			return key;
		}
return null;
	}
	/**
	 * findByGroupOrderByNameAsc
	 */
	public EJSFinder findByGroupOrderByNameAsc(java.lang.Integer argGroupId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.userrepid, T1.classname, T1.jspclass, T1.jspname, T1.repname, T1.rptname, T1.rptparams, T1.usergrpid FROM UserReports  T1 WHERE  usergrpid = ? order by repname asc ");
			pstmt.setObject(1, argGroupId);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findUserReportsByUserRepGroup
	 */
	public EJSFinder findUserReportsByUserRepGroup(com.hps.july.persistence.UserRepGroupKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.userrepid, T1.classname, T1.jspclass, T1.jspname, T1.repname, T1.rptname, T1.rptparams, T1.usergrpid FROM UserReports  T1 WHERE T1.usergrpid = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.usrgrpid);
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
	public com.hps.july.persistence.UserReport findByPrimaryKey(com.hps.july.persistence.UserReportKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.UserReport) home.activateBean(key);
	}
}
