package com.hps.july.persistence2;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPUserRequestsBean_1c968d68
 */
public class EJSJDBCPersisterCMPUserRequestsBean_1c968d68 extends EJSJDBCPersister implements com.hps.july.persistence2.EJSFinderUserRequestsBean {
	private static final String _createString = "INSERT INTO userrequests (request, datetimein, requesttype, filialtype, module, description, status, rfcnum, regionid, supregid, worker) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM userrequests  WHERE request = ?";
	private static final String _storeString = "UPDATE userrequests  SET datetimein = ?, requesttype = ?, filialtype = ?, module = ?, description = ?, status = ?, rfcnum = ?, regionid = ?, supregid = ?, worker = ? WHERE request = ?";
	private static final String _loadString = "SELECT T1.request, T1.datetimein, T1.requesttype, T1.filialtype, T1.module, T1.description, T1.status, T1.rfcnum, T1.regionid, T1.supregid, T1.worker FROM userrequests  T1 WHERE T1.request = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"datetimein", "requesttype", "filialtype", "module", "description", "status", "rfcnum", "worker"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPUserRequestsBean_1c968d68
	 */
	public EJSJDBCPersisterCMPUserRequestsBean_1c968d68() throws java.rmi.RemoteException {
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
		UserRequestsBean b = (UserRequestsBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[8];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.request);
			if (b.datetimein == null) {
				pstmt.setNull(2, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(2, new java.sql.Timestamp(b.datetimein.getTime()));
			}
			cacheData[0] = b.datetimein;
			pstmt.setInt(3, b.requesttype);
			cacheData[1] = new Integer(b.requesttype);
			pstmt.setInt(4, b.filialtype);
			cacheData[2] = new Integer(b.filialtype);
			pstmt.setInt(5, b.module);
			cacheData[3] = new Integer(b.module);
			if (b.description == null) {
				pstmt.setNull(6, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(6, b.description);
			}
			cacheData[4] = b.description;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.status);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			cacheData[5] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.rfcnum);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			cacheData[6] = objectTemp;
			if (b.regionid == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.regionid.intValue());
			}
			if (b.supregid == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.supregid.intValue());
			}
			pstmt.setInt(11, b.worker);
			cacheData[7] = new Integer(b.worker);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		putDataIntoCache(cacheData);
	}
	/**
	 * hydrate
	 */
	public void hydrate(EntityBean eb, Object data, Object pKey) throws Exception {
		Object objectTemp = null;
		UserRequestsBean b = (UserRequestsBean) eb;
		com.hps.july.persistence2.UserRequestsKey _primaryKey = (com.hps.july.persistence2.UserRequestsKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.request = _primaryKey.request;
		b.datetimein = (resultSet.getTimestamp(2) == null) ? null : new java.sql.Date(resultSet.getTimestamp(2).getTime());
		b.requesttype = resultSet.getInt(3);
		b.filialtype = resultSet.getInt(4);
		b.module = resultSet.getInt(5);
		b.description = resultSet.getString(6);
		b.status = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(7));
		b.rfcnum = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(8));
		tempint = resultSet.getInt(9);
		b.regionid = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(10);
		b.supregid = resultSet.wasNull() ? null : new Integer(tempint);
		b.worker = resultSet.getInt(11);
		Object[] cacheData = new Object[8];
		cacheData[0] = resultSet.getTimestamp(2);
		tempint = resultSet.getInt(3);
		cacheData[1] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(4);
		cacheData[2] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(5);
		cacheData[3] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[4] = resultSet.getString(6);
		cacheData[5] = resultSet.getString(7);
		cacheData[6] = resultSet.getString(8);
		tempint = resultSet.getInt(11);
		cacheData[7] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		UserRequestsBean b = (UserRequestsBean) eb;
		com.hps.july.persistence2.UserRequestsKey _primaryKey = (com.hps.july.persistence2.UserRequestsKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.request);
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
		UserRequestsBean b = (UserRequestsBean) eb;
		com.hps.july.persistence2.UserRequestsKey _primaryKey = new com.hps.july.persistence2.UserRequestsKey();
		_primaryKey.request = b.request;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		UserRequestsBean b = (UserRequestsBean) eb;
		com.hps.july.persistence2.UserRequestsKey _primaryKey = new com.hps.july.persistence2.UserRequestsKey();
		_primaryKey.request = b.request;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(11, _primaryKey.request);
			if (b.datetimein == null) {
				pstmt.setNull(1, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(1, new java.sql.Timestamp(b.datetimein.getTime()));
			}
			pstmt.setInt(2, b.requesttype);
			pstmt.setInt(3, b.filialtype);
			pstmt.setInt(4, b.module);
			if (b.description == null) {
				pstmt.setNull(5, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(5, b.description);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.status);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.rfcnum);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			if (b.regionid == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.regionid.intValue());
			}
			if (b.supregid == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.supregid.intValue());
			}
			pstmt.setInt(10, b.worker);
			int inputPos = 11;
			if (cacheData[0] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[7]).intValue());
			}
			if (pstmt.executeUpdate() < 1) {
				throw new OptimisticUpdateFailureException("executeUpdate returned zero rows updated");
			}
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
		UserRequestsBean b = (UserRequestsBean) eb;
		com.hps.july.persistence2.UserRequestsKey _primaryKey = new com.hps.july.persistence2.UserRequestsKey();
		_primaryKey.request = b.request;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.request);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[2]).intValue());
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[7]).intValue());
			}
			if (pstmt.executeUpdate() < 1) {
				throw new OptimisticUpdateFailureException("executeUpdate returned zero rows updated");
			}
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * getPrimaryKey
	 */
	public Object getPrimaryKey(Object data) throws Exception {
		com.hps.july.persistence2.UserRequestsKey key = new com.hps.july.persistence2.UserRequestsKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.request = resultSet.getInt(1);
			return key;
		}
return null;
	}

	/**
	 * RdbRt
	 */
	public class RdbRt {
	public static final String EQUALS = " = ";
	public static final String ISNULL = " IS NULL";
	public static final String MARKER = "?";
	public static final String AND = " AND ";
	private String fStatement;
	private String[] fPredicates = new String[0];
	private boolean[] fPredicateMap = new boolean[0];
	public RdbRt() { }
	public RdbRt(String aStmt) {
		rootStmt(aStmt);
	}
	public RdbRt(String aStmt, String[] anArray, boolean[] aMap) {
		rootStmt(aStmt);
		predicates(anArray);
		predicateMap(aMap);
	}
	public String nativeQuery() {
		StringBuffer aBuffer = new StringBuffer();
		statementOn(aBuffer);
		return aBuffer.toString();
	}
	public String nativeQuery(Object[] values) {
		StringBuffer aBuffer = new StringBuffer();
		statementOn(aBuffer, values);
		return aBuffer.toString();
	}
	public String[] predicates() {
		return fPredicates;
	}
	public void predicates(String[] anArray) {
		fPredicates = anArray;
	}
	public boolean[] predicateMap() {
		return fPredicateMap;
	}
	public void predicateMap(boolean[] anArray) {
		fPredicateMap = anArray;
	}
	public void predicatesOn(StringBuffer aBuffer, Object[] values) {
		int j = predicates().length;
		if (j != values.length)
			throw new RuntimeException("differing number of predicates and values");
		String each;
		for (int i = 0; i < j; i++) {
			if (!fPredicateMap[i]) continue;
				aBuffer.append(AND);
			each = predicates()[i];
			aBuffer.append(each);
			if (values[i] == null)
				aBuffer.append(ISNULL);
			else {
				aBuffer.append(EQUALS);
				aBuffer.append(MARKER);
			}
		}
	}
	public String rootStmt() {
		return fStatement;
	}
	public void rootStmt(String aStmt) {
		fStatement = aStmt;
	}
	public void statementOn(StringBuffer aBuffer) {
		aBuffer.append(rootStmt());
	}
	public void statementOn(StringBuffer aBuffer, Object[] values) {
		aBuffer.append(rootStmt());
		if (predicates() != null && predicates().length != 0) {
			predicatesOn(aBuffer, values);
		}
	}
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence2.UserRequests findByPrimaryKey(com.hps.july.persistence2.UserRequestsKey primaryKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence2.UserRequests) home.activateBean(primaryKey);
	}
}
