package com.hps.july.persistence2;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPOfficeMemoHeaderBean_7991c071
 */
public class EJSJDBCPersisterCMPOfficeMemoHeaderBean_7991c071 extends EJSJDBCPersister implements com.hps.july.persistence2.EJSFinderOfficeMemoHeaderBean {
	private static final String _createString = "INSERT INTO officememoheaders (idheader, abonentContract, arendaContract, date, filename, from, leasebill, man, number, state, target, to, type, usetype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM officememoheaders  WHERE idheader = ?";
	private static final String _storeString = "UPDATE officememoheaders  SET abonentContract = ?, arendaContract = ?, date = ?, filename = ?, from = ?, leasebill = ?, man = ?, number = ?, state = ?, target = ?, to = ?, type = ?, usetype = ? WHERE idheader = ?";
	private static final String _loadString = "SELECT T1.idheader, T1.abonentContract, T1.arendaContract, T1.date, T1.filename, T1.from, T1.leasebill, T1.man, T1.number, T1.state, T1.target, T1.to, T1.type, T1.usetype FROM officememoheaders  T1 WHERE T1.idheader = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"abonentContract", "arendaContract", "date", "filename", "from", "leasebill", "man", "number", "state", "target", "to", "type", "usetype"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPOfficeMemoHeaderBean_7991c071
	 */
	public EJSJDBCPersisterCMPOfficeMemoHeaderBean_7991c071() throws java.rmi.RemoteException {
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
		OfficeMemoHeaderBean b = (OfficeMemoHeaderBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[13];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.idheader);
			pstmt.setInt(2, b.abonentContract);
			cacheData[0] = new Integer(b.abonentContract);
			if (b.arendaContract == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.arendaContract.intValue());
			}
			cacheData[1] = b.arendaContract;
			if (b.date == null) {
				pstmt.setNull(4, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(4, b.date);
			}
			cacheData[2] = b.date;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.filename);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			cacheData[3] = objectTemp;
			if (b.from == null) {
				pstmt.setNull(6, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(6, b.from);
			}
			cacheData[4] = b.from;
			if (b.leasebill == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.leasebill.intValue());
			}
			cacheData[5] = b.leasebill;
			pstmt.setInt(8, b.man);
			cacheData[6] = new Integer(b.man);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.number);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			cacheData[7] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.state);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			cacheData[8] = objectTemp;
			pstmt.setInt(11, b.target);
			cacheData[9] = new Integer(b.target);
			if (b.to == null) {
				pstmt.setNull(12, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(12, b.to);
			}
			cacheData[10] = b.to;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.type);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			cacheData[11] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.usetype);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			cacheData[12] = objectTemp;
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
		OfficeMemoHeaderBean b = (OfficeMemoHeaderBean) eb;
		com.hps.july.persistence2.OfficeMemoHeaderKey _primaryKey = (com.hps.july.persistence2.OfficeMemoHeaderKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.idheader = _primaryKey.idheader;
		b.abonentContract = resultSet.getInt(2);
		tempint = resultSet.getInt(3);
		b.arendaContract = resultSet.wasNull() ? null : new Integer(tempint);
		b.date = resultSet.getDate(4);
		b.filename = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.from = resultSet.getString(6);
		tempint = resultSet.getInt(7);
		b.leasebill = resultSet.wasNull() ? null : new Integer(tempint);
		b.man = resultSet.getInt(8);
		b.number = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(9));
		b.state = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		b.target = resultSet.getInt(11);
		b.to = resultSet.getString(12);
		b.type = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(13));
		b.usetype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(14));
		Object[] cacheData = new Object[13];
		tempint = resultSet.getInt(2);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(3);
		cacheData[1] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[2] = resultSet.getDate(4);
		cacheData[3] = resultSet.getString(5);
		cacheData[4] = resultSet.getString(6);
		tempint = resultSet.getInt(7);
		cacheData[5] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		cacheData[6] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[7] = resultSet.getString(9);
		cacheData[8] = resultSet.getString(10);
		tempint = resultSet.getInt(11);
		cacheData[9] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[10] = resultSet.getString(12);
		cacheData[11] = resultSet.getString(13);
		cacheData[12] = resultSet.getString(14);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		OfficeMemoHeaderBean b = (OfficeMemoHeaderBean) eb;
		com.hps.july.persistence2.OfficeMemoHeaderKey _primaryKey = (com.hps.july.persistence2.OfficeMemoHeaderKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.idheader);
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
		OfficeMemoHeaderBean b = (OfficeMemoHeaderBean) eb;
		com.hps.july.persistence2.OfficeMemoHeaderKey _primaryKey = new com.hps.july.persistence2.OfficeMemoHeaderKey();
		_primaryKey.idheader = b.idheader;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		OfficeMemoHeaderBean b = (OfficeMemoHeaderBean) eb;
		com.hps.july.persistence2.OfficeMemoHeaderKey _primaryKey = new com.hps.july.persistence2.OfficeMemoHeaderKey();
		_primaryKey.idheader = b.idheader;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(14, _primaryKey.idheader);
			pstmt.setInt(1, b.abonentContract);
			if (b.arendaContract == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.arendaContract.intValue());
			}
			if (b.date == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.date);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.filename);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.from == null) {
				pstmt.setNull(5, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(5, b.from);
			}
			if (b.leasebill == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.leasebill.intValue());
			}
			pstmt.setInt(7, b.man);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.number);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.state);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			pstmt.setInt(10, b.target);
			if (b.to == null) {
				pstmt.setNull(11, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(11, b.to);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.type);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.usetype);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			int inputPos = 14;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
			}
			if (cacheData[7] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[9]).intValue());
			}
			if (cacheData[10] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[11]);
			}
			if (cacheData[12] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[12]);
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
		OfficeMemoHeaderBean b = (OfficeMemoHeaderBean) eb;
		com.hps.july.persistence2.OfficeMemoHeaderKey _primaryKey = new com.hps.july.persistence2.OfficeMemoHeaderKey();
		_primaryKey.idheader = b.idheader;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.idheader);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
			}
			if (cacheData[2] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
			}
			if (cacheData[7] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[9]).intValue());
			}
			if (cacheData[10] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[11]);
			}
			if (cacheData[12] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[12]);
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
		com.hps.july.persistence2.OfficeMemoHeaderKey key = new com.hps.july.persistence2.OfficeMemoHeaderKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.idheader = resultSet.getInt(1);
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
	public com.hps.july.persistence2.OfficeMemoHeader findByPrimaryKey(com.hps.july.persistence2.OfficeMemoHeaderKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence2.OfficeMemoHeader) home.activateBean(key);
	}
}
