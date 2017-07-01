package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPIEQueryBean_3b29e425
 */
public class EJSJDBCPersisterCMPPIEQueryBean_3b29e425 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderPIEQueryBean {
	private static final String _createString = "INSERT INTO pie_query (id_query, voper, typeobjnri, dat_end, id_platinum_qry, idobjplat, idobjnriint, status_op, type_query, status, dat_beg, owner, vdat, operation, idobjnristr) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM pie_query  WHERE id_query = ?";
	private static final String _storeString = "UPDATE pie_query  SET voper = ?, typeobjnri = ?, dat_end = ?, id_platinum_qry = ?, idobjplat = ?, idobjnriint = ?, status_op = ?, type_query = ?, status = ?, dat_beg = ?, owner = ?, vdat = ?, operation = ?, idobjnristr = ? WHERE id_query = ?";
	private static final String _loadString = "SELECT T1.voper, T1.typeobjnri, T1.dat_end, T1.id_platinum_qry, T1.idobjplat, T1.idobjnriint, T1.status_op, T1.type_query, T1.status, T1.dat_beg, T1.owner, T1.vdat, T1.operation, T1.idobjnristr, T1.id_query FROM pie_query  T1 WHERE T1.id_query = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"voper", "typeobjnri", "dat_end", "id_platinum_qry", "idobjplat", "idobjnriint", "status_op", "type_query", "status", "dat_beg", "owner", "vdat", "operation", "idobjnristr"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPIEQueryBean_3b29e425
	 */
	public EJSJDBCPersisterCMPPIEQueryBean_3b29e425() throws java.rmi.RemoteException {
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
		PIEQueryBean b = (PIEQueryBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[14];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.voper == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.voper.intValue());
			}
			cacheData[0] = b.voper;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.typeobjnri);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			if (b.dateend == null) {
				pstmt.setNull(4, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(4, b.dateend);
			}
			cacheData[2] = b.dateend;
			if (b.idplatinumqry == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.idplatinumqry.intValue());
			}
			cacheData[3] = b.idplatinumqry;
			if (b.idobjplat == null) {
				pstmt.setNull(6, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(6, b.idobjplat);
			}
			cacheData[4] = b.idobjplat;
			if (b.idobjnriint == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.idobjnriint.intValue());
			}
			cacheData[5] = b.idobjnriint;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.statusop);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			cacheData[6] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.typequery);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			cacheData[7] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.status);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			cacheData[8] = objectTemp;
			if (b.datebeg == null) {
				pstmt.setNull(11, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(11, b.datebeg);
			}
			cacheData[9] = b.datebeg;
			if (b.owner == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.owner.intValue());
			}
			cacheData[10] = b.owner;
			if (b.vdat == null) {
				pstmt.setNull(13, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(13, b.vdat);
			}
			cacheData[11] = b.vdat;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.operation);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			cacheData[12] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.idobjnristr);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			cacheData[13] = objectTemp;
			pstmt.setInt(1, b.idquery);
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
		PIEQueryBean b = (PIEQueryBean) eb;
		com.hps.july.persistence.PIEQueryKey _primaryKey = (com.hps.july.persistence.PIEQueryKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.idquery = _primaryKey.idquery;
		tempint = resultSet.getInt(1);
		b.voper = resultSet.wasNull() ? null : new Integer(tempint);
		b.typeobjnri = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.dateend = resultSet.getTimestamp(3);
		tempint = resultSet.getInt(4);
		b.idplatinumqry = resultSet.wasNull() ? null : new Integer(tempint);
		b.idobjplat = resultSet.getString(5);
		tempint = resultSet.getInt(6);
		b.idobjnriint = resultSet.wasNull() ? null : new Integer(tempint);
		b.statusop = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(7));
		b.typequery = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(8));
		b.status = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(9));
		b.datebeg = resultSet.getTimestamp(10);
		tempint = resultSet.getInt(11);
		b.owner = resultSet.wasNull() ? null : new Integer(tempint);
		b.vdat = resultSet.getTimestamp(12);
		b.operation = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(13));
		b.idobjnristr = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(14));
		Object[] cacheData = new Object[14];
		tempint = resultSet.getInt(1);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[1] = resultSet.getString(2);
		cacheData[2] = resultSet.getTimestamp(3);
		tempint = resultSet.getInt(4);
		cacheData[3] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[4] = resultSet.getString(5);
		tempint = resultSet.getInt(6);
		cacheData[5] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[6] = resultSet.getString(7);
		cacheData[7] = resultSet.getString(8);
		cacheData[8] = resultSet.getString(9);
		cacheData[9] = resultSet.getTimestamp(10);
		tempint = resultSet.getInt(11);
		cacheData[10] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[11] = resultSet.getTimestamp(12);
		cacheData[12] = resultSet.getString(13);
		cacheData[13] = resultSet.getString(14);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		PIEQueryBean b = (PIEQueryBean) eb;
		com.hps.july.persistence.PIEQueryKey _primaryKey = (com.hps.july.persistence.PIEQueryKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.idquery);
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
		PIEQueryBean b = (PIEQueryBean) eb;
		com.hps.july.persistence.PIEQueryKey _primaryKey = new com.hps.july.persistence.PIEQueryKey();
		_primaryKey.idquery = b.idquery;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		PIEQueryBean b = (PIEQueryBean) eb;
		com.hps.july.persistence.PIEQueryKey _primaryKey = new com.hps.july.persistence.PIEQueryKey();
		_primaryKey.idquery = b.idquery;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(15, _primaryKey.idquery);
			if (b.voper == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.voper.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.typeobjnri);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.dateend == null) {
				pstmt.setNull(3, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(3, b.dateend);
			}
			if (b.idplatinumqry == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.idplatinumqry.intValue());
			}
			if (b.idobjplat == null) {
				pstmt.setNull(5, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(5, b.idobjplat);
			}
			if (b.idobjnriint == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.idobjnriint.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.statusop);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.typequery);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.status);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			if (b.datebeg == null) {
				pstmt.setNull(10, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(10, b.datebeg);
			}
			if (b.owner == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.owner.intValue());
			}
			if (b.vdat == null) {
				pstmt.setNull(12, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(12, b.vdat);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.operation);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.idobjnristr);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			int inputPos = 15;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
			}
			if (cacheData[6] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[10]).intValue());
			}
			if (cacheData[11] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[11]);
			}
			if (cacheData[12] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[13]);
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
		PIEQueryBean b = (PIEQueryBean) eb;
		com.hps.july.persistence.PIEQueryKey _primaryKey = new com.hps.july.persistence.PIEQueryKey();
		_primaryKey.idquery = b.idquery;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.idquery);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
			}
			if (cacheData[6] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[10]).intValue());
			}
			if (cacheData[11] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[11]);
			}
			if (cacheData[12] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[13]);
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
		com.hps.july.persistence.PIEQueryKey key = new com.hps.july.persistence.PIEQueryKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.idquery = resultSet.getInt(15);
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
	 * findByTypeStatusOrderByCodeAsc
	 */
	public EJSFinder findByTypeStatusOrderByCodeAsc(java.lang.String argType, java.lang.String argStatus) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.voper, T1.typeobjnri, T1.dat_end, T1.id_platinum_qry, T1.idobjplat, T1.idobjnriint, T1.status_op, T1.type_query, T1.status, T1.dat_beg, T1.owner, T1.vdat, T1.operation, T1.idobjnristr, T1.id_query FROM pie_query  T1 WHERE upper(type_query) matches upper(?) AND upper(status) MATCHES upper(?) ORDER BY id_query ASC");
			if (argType == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argType);
			}
			if (argStatus == null) {
			   pstmt.setNull(2, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(2, argStatus);
			}
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
	public com.hps.july.persistence.PIEQuery findByPrimaryKey(com.hps.july.persistence.PIEQueryKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.PIEQuery) home.activateBean(key);
	}
}
