package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPAbonentBillBean_75fa4e4f
 */
public class EJSJDBCPersisterCMPAbonentBillBean_75fa4e4f extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderAbonentBillBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO informix.abonentbills (leasebill, billnumber, billstatus, billtype, notessummopl, billperiodstart, summopl, billdate, bensource, recordstatus, flagworknri, useinnri, ben, billperiodend, changeuseinnri, sumchangereason, leasedocument) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM informix.abonentbills  WHERE leasebill = ?";
	private static final String _storeString = "UPDATE informix.abonentbills  SET billnumber = ?, billstatus = ?, billtype = ?, notessummopl = ?, billperiodstart = ?, summopl = ?, billdate = ?, bensource = ?, recordstatus = ?, flagworknri = ?, useinnri = ?, ben = ?, billperiodend = ?, changeuseinnri = ?, sumchangereason = ?, leasedocument = ? WHERE leasebill = ?";
	private static final String _loadString = "SELECT T1.billnumber, T1.billstatus, T1.billtype, T1.notessummopl, T1.billperiodstart, T1.summopl, T1.billdate, T1.bensource, T1.leasebill, T1.recordstatus, T1.flagworknri, T1.useinnri, T1.ben, T1.billperiodend, T1.changeuseinnri, T1.sumchangereason, T1.leasedocument FROM informix.abonentbills  T1 WHERE T1.leasebill = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"billnumber", "billstatus", "billtype", "notessummopl", "billperiodstart", "summopl", "billdate", "bensource", "recordstatus", "flagworknri", "useinnri", "ben", "billperiodend", "changeuseinnri", "sumchangereason", "leasedocument"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPAbonentBillBean_75fa4e4f
	 */
	public EJSJDBCPersisterCMPAbonentBillBean_75fa4e4f() throws java.rmi.RemoteException {
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
		AbonentBillBean b = (AbonentBillBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[16];
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.billnumber);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.billstatus);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.billtype);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			cacheData[2] = objectTemp;
			if (b.notessummopl == null) {
				pstmt.setNull(5, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(5, b.notessummopl);
			}
			cacheData[3] = b.notessummopl;
			if (b.billperiodstart == null) {
				pstmt.setNull(6, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(6, b.billperiodstart);
			}
			cacheData[4] = b.billperiodstart;
			if (b.summopl == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.summopl);
			}
			cacheData[5] = b.summopl;
			if (b.billdate == null) {
				pstmt.setNull(8, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(8, b.billdate);
			}
			cacheData[6] = b.billdate;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bensource);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			cacheData[7] = objectTemp;
			pstmt.setInt(1, b.leasebill);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.recordstatus);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			cacheData[8] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.flagworknri));
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			cacheData[9] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.useinnri);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			cacheData[10] = objectTemp;
			if (b.ben == null) {
				pstmt.setNull(13, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(13, b.ben.shortValue());
			}
			cacheData[11] = b.ben;
			if (b.billperiodend == null) {
				pstmt.setNull(14, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(14, b.billperiodend);
			}
			cacheData[12] = b.billperiodend;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.changeuseinnri);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			cacheData[13] = objectTemp;
			if (b.sumchangereason == null) {
				pstmt.setNull(16, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(16, b.sumchangereason);
			}
			cacheData[14] = b.sumchangereason;
			if (b.leaseabonentban_leaseDocument == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.leaseabonentban_leaseDocument.intValue());
			}
			cacheData[15] = b.leaseabonentban_leaseDocument;
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
		AbonentBillBean b = (AbonentBillBean) eb;
		com.hps.july.persistence.AbonentBillKey _primaryKey = (com.hps.july.persistence.AbonentBillKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.leasebill = _primaryKey.leasebill;
		b.billnumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		b.billstatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.billtype = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.notessummopl = resultSet.getString(4);
		b.billperiodstart = resultSet.getDate(5);
		b.summopl = resultSet.getBigDecimal(6);
		b.billdate = resultSet.getDate(7);
		b.bensource = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(8));
		b.recordstatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(11));
		b.flagworknri = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.useinnri = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(12));
		tempshort = resultSet.getShort(13);
		b.ben = resultSet.wasNull() ? null : new Short(tempshort);
		b.billperiodend = resultSet.getDate(14);
		b.changeuseinnri = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(15));
		b.sumchangereason = resultSet.getString(16);
		tempint = resultSet.getInt(17);
		b.leaseabonentban_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[16];
		cacheData[0] = resultSet.getString(1);
		cacheData[1] = resultSet.getString(2);
		cacheData[2] = resultSet.getString(3);
		cacheData[3] = resultSet.getString(4);
		cacheData[4] = resultSet.getDate(5);
		cacheData[5] = resultSet.getBigDecimal(6);
		cacheData[6] = resultSet.getDate(7);
		cacheData[7] = resultSet.getString(8);
		cacheData[8] = resultSet.getString(10);
		cacheData[9] = resultSet.getString(11);
		cacheData[10] = resultSet.getString(12);
		tempshort = resultSet.getShort(13);
		cacheData[11] = resultSet.wasNull() ? null : new Short(tempshort);
		cacheData[12] = resultSet.getDate(14);
		cacheData[13] = resultSet.getString(15);
		cacheData[14] = resultSet.getString(16);
		tempint = resultSet.getInt(17);
		cacheData[15] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		AbonentBillBean b = (AbonentBillBean) eb;
		com.hps.july.persistence.AbonentBillKey _primaryKey = (com.hps.july.persistence.AbonentBillKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.leasebill);
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
		AbonentBillBean b = (AbonentBillBean) eb;
		com.hps.july.persistence.AbonentBillKey _primaryKey = new com.hps.july.persistence.AbonentBillKey();
		_primaryKey.leasebill = b.leasebill;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		AbonentBillBean b = (AbonentBillBean) eb;
		com.hps.july.persistence.AbonentBillKey _primaryKey = new com.hps.july.persistence.AbonentBillKey();
		_primaryKey.leasebill = b.leasebill;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(17, _primaryKey.leasebill);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.billnumber);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.billstatus);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.billtype);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.notessummopl == null) {
				pstmt.setNull(4, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(4, b.notessummopl);
			}
			if (b.billperiodstart == null) {
				pstmt.setNull(5, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(5, b.billperiodstart);
			}
			if (b.summopl == null) {
				pstmt.setNull(6, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(6, b.summopl);
			}
			if (b.billdate == null) {
				pstmt.setNull(7, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(7, b.billdate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.bensource);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.recordstatus);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.flagworknri));
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.useinnri);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			if (b.ben == null) {
				pstmt.setNull(12, java.sql.Types.SMALLINT);
			}
			else {
				pstmt.setShort(12, b.ben.shortValue());
			}
			if (b.billperiodend == null) {
				pstmt.setNull(13, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(13, b.billperiodend);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.changeuseinnri);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			if (b.sumchangereason == null) {
				pstmt.setNull(15, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(15, b.sumchangereason);
			}
			if (b.leaseabonentban_leaseDocument == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.leaseabonentban_leaseDocument.intValue());
			}
			int inputPos = 17;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
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
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setShort(++inputPos, ((Number)cacheData[11]).shortValue());
			}
			if (cacheData[12] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[13]);
			}
			if (cacheData[14] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[14]);
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
		AbonentBillBean b = (AbonentBillBean) eb;
		com.hps.july.persistence.AbonentBillKey _primaryKey = new com.hps.july.persistence.AbonentBillKey();
		_primaryKey.leasebill = b.leasebill;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.leasebill);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
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
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setShort(++inputPos, ((Number)cacheData[11]).shortValue());
			}
			if (cacheData[12] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[13]);
			}
			if (cacheData[14] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[14]);
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
		com.hps.july.persistence.AbonentBillKey key = new com.hps.july.persistence.AbonentBillKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.leasebill = resultSet.getInt(9);
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
	 * findByBen
	 */
	public EJSFinder findByBen(java.lang.Short argBen) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.billnumber, T1.billstatus, T1.billtype, T1.notessummopl, T1.billperiodstart, T1.summopl, T1.billdate, T1.bensource, T1.leasebill, T1.recordstatus, T1.flagworknri, T1.useinnri, T1.ben, T1.billperiodend, T1.changeuseinnri, T1.sumchangereason, T1.leasedocument FROM informix.abonentbills  T1 WHERE ben = ?");
			pstmt.setObject(1, argBen);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByFlagWorkNRI
	 */
	public EJSFinder findByFlagWorkNRI(java.lang.String argFlagWorkNRI) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.billnumber, T1.billstatus, T1.billtype, T1.notessummopl, T1.billperiodstart, T1.summopl, T1.billdate, T1.bensource, T1.leasebill, T1.recordstatus, T1.flagworknri, T1.useinnri, T1.ben, T1.billperiodend, T1.changeuseinnri, T1.sumchangereason, T1.leasedocument FROM informix.abonentbills  T1 WHERE flagworknri = ?");
			if (argFlagWorkNRI == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, argFlagWorkNRI);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByQBE
	 */
	public EJSFinder findByQBE(java.lang.Boolean isLeaseDocument, java.lang.Integer leaseDocument, java.lang.Boolean isBillDate, java.sql.Date fromBillDate, java.sql.Date toBillDate, java.lang.Boolean isBillType, java.lang.String billType, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(isLeaseDocument, leaseDocument, isBillDate, fromBillDate, toBillDate, isBillType, billType, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByQBE2
	 */
	public EJSFinder findByQBE2(java.lang.Boolean isLeaseDocument, java.lang.Integer leaseDocument, java.lang.Boolean isBillDate, java.sql.Date fromBillDate, java.sql.Date toBillDate, java.lang.Boolean isBillType, java.lang.String billType, java.lang.Boolean isUseinNRI, java.lang.Boolean useInNRI, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE2(isLeaseDocument, leaseDocument, isBillDate, fromBillDate, toBillDate, isBillType, billType, isUseinNRI, useInNRI, order);
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
	public com.hps.july.persistence.AbonentBill findByPrimaryKey(com.hps.july.persistence.AbonentBillKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.AbonentBill) home.activateBean(key);
	}
	/**
	 * findByBanStartServDate
	 */
	public EJSFinder findByBanStartServDate(java.lang.Integer argBan, java.sql.Date argStartDate) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.billnumber, T1.billstatus, T1.billtype, T1.notessummopl, T1.billperiodstart, T1.summopl, T1.billdate, T1.bensource, T1.leasebill, T1.recordstatus, T1.flagworknri, T1.useinnri, T1.ben, T1.billperiodend, T1.changeuseinnri, T1.sumchangereason, T1.leasedocument FROM informix.abonentbills  T1 WHERE flagworknri = \'Y\' AND leasedocument IN (SELECT leaseDocument FROM LeaseAbonentBan WHERE ban = ? AND bil_StartServDate > ?)");
			pstmt.setObject(1, argBan);
			pstmt.setDate(2, argStartDate);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findAbonentBillsByLeaseabonentban
	 */
	public EJSFinder findAbonentBillsByLeaseabonentban(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.billnumber, T1.billstatus, T1.billtype, T1.notessummopl, T1.billperiodstart, T1.summopl, T1.billdate, T1.bensource, T1.leasebill, T1.recordstatus, T1.flagworknri, T1.useinnri, T1.ben, T1.billperiodend, T1.changeuseinnri, T1.sumchangereason, T1.leasedocument FROM informix.abonentbills  T1 WHERE T1.leasedocument = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.leaseDocument);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T1.billnumber, T1.billstatus, T1.billtype, T1.notessummopl, T1.billperiodstart, T1.summopl, T1.billdate, T1.bensource, T1.leasebill, T1.recordstatus, T1.flagworknri, T1.useinnri, T1.ben, T1.billperiodend, T1.changeuseinnri, T1.sumchangereason, T1.leasedocument FROM informix.abonentbills  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {305};
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
	private AbonentBillBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.AbonentBillBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.AbonentBillBeanFinderObject temp_finderObject = new com.hps.july.persistence.AbonentBillBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
