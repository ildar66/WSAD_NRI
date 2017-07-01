package com.hps.july.persistence2;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPOfficeMemoPosBean_8b7defe2
 */
public class EJSJDBCPersisterCMPOfficeMemoPosBean_8b7defe2 extends EJSJDBCPersister implements com.hps.july.persistence2.EJSFinderOfficeMemoPosBean {
	private static final String _createString = "INSERT INTO OfficeMemoPos (idPos, simcardcnt, phoneNumber, isgarantie, tarifplan, equipname, equipcnt, comcardcnt, enddate, cardamount, opertype, service, defectdescr, cardname, startdate, idHeader, equipcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM OfficeMemoPos  WHERE idPos = ?";
	private static final String _storeString = "UPDATE OfficeMemoPos  SET simcardcnt = ?, phoneNumber = ?, isgarantie = ?, tarifplan = ?, equipname = ?, equipcnt = ?, comcardcnt = ?, enddate = ?, cardamount = ?, opertype = ?, service = ?, defectdescr = ?, cardname = ?, startdate = ?, idHeader = ?, equipcode = ? WHERE idPos = ?";
	private static final String _loadString = "SELECT T1.simcardcnt, T1.phoneNumber, T1.isgarantie, T1.tarifplan, T1.equipname, T1.equipcnt, T1.comcardcnt, T1.enddate, T1.cardamount, T1.opertype, T1.service, T1.defectdescr, T1.idPos, T1.cardname, T1.startdate, T1.idHeader, T1.equipcode FROM OfficeMemoPos  T1 WHERE T1.idPos = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"simcardcnt", "phoneNumber", "isgarantie", "tarifplan", "equipname", "equipcnt", "comcardcnt", "enddate", "cardamount", "opertype", "service", "defectdescr", "cardname", "startdate", "idHeader", "equipcode"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPOfficeMemoPosBean_8b7defe2
	 */
	public EJSJDBCPersisterCMPOfficeMemoPosBean_8b7defe2() throws java.rmi.RemoteException {
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
		OfficeMemoPosBean b = (OfficeMemoPosBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[16];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.simcardcnt == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.simcardcnt.intValue());
			}
			cacheData[0] = b.simcardcnt;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.phoneNumber);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isgarantie);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			cacheData[2] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.tarifplan);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			cacheData[3] = objectTemp;
			if (b.equipname == null) {
				pstmt.setNull(6, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(6, b.equipname);
			}
			cacheData[4] = b.equipname;
			if (b.equipcnt == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.equipcnt.intValue());
			}
			cacheData[5] = b.equipcnt;
			if (b.comcardcnt == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.comcardcnt.intValue());
			}
			cacheData[6] = b.comcardcnt;
			if (b.enddate == null) {
				pstmt.setNull(9, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(9, b.enddate);
			}
			cacheData[7] = b.enddate;
			if (b.cardamount == null) {
				pstmt.setNull(10, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(10, b.cardamount);
			}
			cacheData[8] = b.cardamount;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.opertype);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			cacheData[9] = objectTemp;
			if (b.service == null) {
				pstmt.setNull(12, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(12, b.service);
			}
			cacheData[10] = b.service;
			if (b.defectdescr == null) {
				pstmt.setNull(13, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(13, b.defectdescr);
			}
			cacheData[11] = b.defectdescr;
			pstmt.setInt(1, b.idpos);
			if (b.cardname == null) {
				pstmt.setNull(14, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(14, b.cardname);
			}
			cacheData[12] = b.cardname;
			if (b.startdate == null) {
				pstmt.setNull(15, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(15, b.startdate);
			}
			cacheData[13] = b.startdate;
			pstmt.setInt(16, b.idheader);
			cacheData[14] = new Integer(b.idheader);
			if (b.equipcode == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.equipcode.intValue());
			}
			cacheData[15] = b.equipcode;
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
		OfficeMemoPosBean b = (OfficeMemoPosBean) eb;
		com.hps.july.persistence2.OfficeMemoPosKey _primaryKey = (com.hps.july.persistence2.OfficeMemoPosKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.idpos = _primaryKey.idpos;
		tempint = resultSet.getInt(1);
		b.simcardcnt = resultSet.wasNull() ? null : new Integer(tempint);
		b.phoneNumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.isgarantie = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(3));
		b.tarifplan = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.equipname = resultSet.getString(5);
		tempint = resultSet.getInt(6);
		b.equipcnt = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(7);
		b.comcardcnt = resultSet.wasNull() ? null : new Integer(tempint);
		b.enddate = resultSet.getDate(8);
		b.cardamount = resultSet.getBigDecimal(9);
		b.opertype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		b.service = resultSet.getString(11);
		b.defectdescr = resultSet.getString(12);
		b.cardname = resultSet.getString(14);
		b.startdate = resultSet.getDate(15);
		b.idheader = resultSet.getInt(16);
		tempint = resultSet.getInt(17);
		b.equipcode = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[16];
		tempint = resultSet.getInt(1);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[1] = resultSet.getString(2);
		cacheData[2] = resultSet.getString(3);
		cacheData[3] = resultSet.getString(4);
		cacheData[4] = resultSet.getString(5);
		tempint = resultSet.getInt(6);
		cacheData[5] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(7);
		cacheData[6] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[7] = resultSet.getDate(8);
		cacheData[8] = resultSet.getBigDecimal(9);
		cacheData[9] = resultSet.getString(10);
		cacheData[10] = resultSet.getString(11);
		cacheData[11] = resultSet.getString(12);
		cacheData[12] = resultSet.getString(14);
		cacheData[13] = resultSet.getDate(15);
		tempint = resultSet.getInt(16);
		cacheData[14] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(17);
		cacheData[15] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		OfficeMemoPosBean b = (OfficeMemoPosBean) eb;
		com.hps.july.persistence2.OfficeMemoPosKey _primaryKey = (com.hps.july.persistence2.OfficeMemoPosKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.idpos);
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
		OfficeMemoPosBean b = (OfficeMemoPosBean) eb;
		com.hps.july.persistence2.OfficeMemoPosKey _primaryKey = new com.hps.july.persistence2.OfficeMemoPosKey();
		_primaryKey.idpos = b.idpos;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		OfficeMemoPosBean b = (OfficeMemoPosBean) eb;
		com.hps.july.persistence2.OfficeMemoPosKey _primaryKey = new com.hps.july.persistence2.OfficeMemoPosKey();
		_primaryKey.idpos = b.idpos;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(17, _primaryKey.idpos);
			if (b.simcardcnt == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.simcardcnt.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.phoneNumber);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isgarantie);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.tarifplan);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.equipname == null) {
				pstmt.setNull(5, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(5, b.equipname);
			}
			if (b.equipcnt == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.equipcnt.intValue());
			}
			if (b.comcardcnt == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.comcardcnt.intValue());
			}
			if (b.enddate == null) {
				pstmt.setNull(8, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(8, b.enddate);
			}
			if (b.cardamount == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.cardamount);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.opertype);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			if (b.service == null) {
				pstmt.setNull(11, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(11, b.service);
			}
			if (b.defectdescr == null) {
				pstmt.setNull(12, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(12, b.defectdescr);
			}
			if (b.cardname == null) {
				pstmt.setNull(13, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(13, b.cardname);
			}
			if (b.startdate == null) {
				pstmt.setNull(14, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(14, b.startdate);
			}
			pstmt.setInt(15, b.idheader);
			if (b.equipcode == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.equipcode.intValue());
			}
			int inputPos = 17;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
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
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[9]);
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
			if (cacheData[13] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[13]);
			}
			if (cacheData[14] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[14]).intValue());
			}
			if (cacheData[15] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[15]).intValue());
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
		OfficeMemoPosBean b = (OfficeMemoPosBean) eb;
		com.hps.july.persistence2.OfficeMemoPosKey _primaryKey = new com.hps.july.persistence2.OfficeMemoPosKey();
		_primaryKey.idpos = b.idpos;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.idpos);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
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
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[9]);
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
			if (cacheData[13] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[13]);
			}
			if (cacheData[14] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[14]).intValue());
			}
			if (cacheData[15] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[15]).intValue());
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
		com.hps.july.persistence2.OfficeMemoPosKey key = new com.hps.july.persistence2.OfficeMemoPosKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.idpos = resultSet.getInt(13);
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
	public com.hps.july.persistence2.OfficeMemoPos findByPrimaryKey(com.hps.july.persistence2.OfficeMemoPosKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence2.OfficeMemoPos) home.activateBean(key);
	}
}
