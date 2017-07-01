package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPIEDogovorNRIBean_c9266334
 */
public class EJSJDBCPersisterCMPPIEDogovorNRIBean_c9266334 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderPIEDogovorNRIBean {
	private static final String _createString = "INSERT INTO pie_dogovorsnri (idrecdogovor, description, dogblankcode, dogdate, dogfinishdate, dogstartdate, idaccountnri, idbudjet, iddogovorplatinum, idexpence, idheaduser, idorgbeeline, idpartnernri, overprice, purpose, sumdog, valute, id_query) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM pie_dogovorsnri  WHERE idrecdogovor = ?";
	private static final String _storeString = "UPDATE pie_dogovorsnri  SET description = ?, dogblankcode = ?, dogdate = ?, dogfinishdate = ?, dogstartdate = ?, idaccountnri = ?, idbudjet = ?, iddogovorplatinum = ?, idexpence = ?, idheaduser = ?, idorgbeeline = ?, idpartnernri = ?, overprice = ?, purpose = ?, sumdog = ?, valute = ?, id_query = ? WHERE idrecdogovor = ?";
	private static final String _loadString = "SELECT T1.idrecdogovor, T1.description, T1.dogblankcode, T1.dogdate, T1.dogfinishdate, T1.dogstartdate, T1.idaccountnri, T1.idbudjet, T1.iddogovorplatinum, T1.idexpence, T1.idheaduser, T1.idorgbeeline, T1.idpartnernri, T1.overprice, T1.purpose, T1.sumdog, T1.valute, T1.id_query FROM pie_dogovorsnri  T1 WHERE T1.idrecdogovor = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"description", "dogblankcode", "dogdate", "dogfinishdate", "dogstartdate", "idaccountnri", "idbudjet", "iddogovorplatinum", "idexpence", "idheaduser", "idorgbeeline", "idpartnernri", "overprice", "purpose", "sumdog", "valute", "id_query"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPIEDogovorNRIBean_c9266334
	 */
	public EJSJDBCPersisterCMPPIEDogovorNRIBean_c9266334() throws java.rmi.RemoteException {
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
		PIEDogovorNRIBean b = (PIEDogovorNRIBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[17];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.idrecdogovor);
			if (b.description == null) {
				pstmt.setNull(2, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(2, b.description);
			}
			cacheData[0] = b.description;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.dogblankcode);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			if (b.dogdate == null) {
				pstmt.setNull(4, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(4, b.dogdate);
			}
			cacheData[2] = b.dogdate;
			if (b.dogfinishdate == null) {
				pstmt.setNull(5, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(5, b.dogfinishdate);
			}
			cacheData[3] = b.dogfinishdate;
			if (b.dogstartdate == null) {
				pstmt.setNull(6, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(6, b.dogstartdate);
			}
			cacheData[4] = b.dogstartdate;
			pstmt.setInt(7, b.idaccountnri);
			cacheData[5] = new Integer(b.idaccountnri);
			pstmt.setInt(8, b.idbudjet);
			cacheData[6] = new Integer(b.idbudjet);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.iddogovorplatinum);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			cacheData[7] = objectTemp;
			pstmt.setInt(10, b.idexpence);
			cacheData[8] = new Integer(b.idexpence);
			if (b.idheaduser == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.idheaduser.intValue());
			}
			cacheData[9] = b.idheaduser;
			pstmt.setInt(12, b.idorgowner);
			cacheData[10] = new Integer(b.idorgowner);
			pstmt.setInt(13, b.idpartnernri);
			cacheData[11] = new Integer(b.idpartnernri);
			if (b.overprice == null) {
				pstmt.setNull(14, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(14, b.overprice);
			}
			cacheData[12] = b.overprice;
			if (b.purpose == null) {
				pstmt.setNull(15, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(15, b.purpose);
			}
			cacheData[13] = b.purpose;
			if (b.sumdog == null) {
				pstmt.setNull(16, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(16, b.sumdog);
			}
			cacheData[14] = b.sumdog;
			pstmt.setInt(17, b.valute);
			cacheData[15] = new Integer(b.valute);
			if (b.piequery_idquery == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.piequery_idquery.intValue());
			}
			cacheData[16] = b.piequery_idquery;
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
		PIEDogovorNRIBean b = (PIEDogovorNRIBean) eb;
		com.hps.july.persistence.PIEDogovorNRIKey _primaryKey = (com.hps.july.persistence.PIEDogovorNRIKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.idrecdogovor = _primaryKey.idrecdogovor;
		b.description = resultSet.getString(2);
		b.dogblankcode = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.dogdate = resultSet.getDate(4);
		b.dogfinishdate = resultSet.getDate(5);
		b.dogstartdate = resultSet.getDate(6);
		b.idaccountnri = resultSet.getInt(7);
		b.idbudjet = resultSet.getInt(8);
		b.iddogovorplatinum = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(9));
		b.idexpence = resultSet.getInt(10);
		tempint = resultSet.getInt(11);
		b.idheaduser = resultSet.wasNull() ? null : new Integer(tempint);
		b.idorgowner = resultSet.getInt(12);
		b.idpartnernri = resultSet.getInt(13);
		b.overprice = resultSet.getBigDecimal(14);
		b.purpose = resultSet.getString(15);
		b.sumdog = resultSet.getBigDecimal(16);
		b.valute = resultSet.getInt(17);
		tempint = resultSet.getInt(18);
		b.piequery_idquery = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[17];
		cacheData[0] = resultSet.getString(2);
		cacheData[1] = resultSet.getString(3);
		cacheData[2] = resultSet.getDate(4);
		cacheData[3] = resultSet.getDate(5);
		cacheData[4] = resultSet.getDate(6);
		tempint = resultSet.getInt(7);
		cacheData[5] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		cacheData[6] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[7] = resultSet.getString(9);
		tempint = resultSet.getInt(10);
		cacheData[8] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(11);
		cacheData[9] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(12);
		cacheData[10] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(13);
		cacheData[11] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[12] = resultSet.getBigDecimal(14);
		cacheData[13] = resultSet.getString(15);
		cacheData[14] = resultSet.getBigDecimal(16);
		tempint = resultSet.getInt(17);
		cacheData[15] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(18);
		cacheData[16] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		PIEDogovorNRIBean b = (PIEDogovorNRIBean) eb;
		com.hps.july.persistence.PIEDogovorNRIKey _primaryKey = (com.hps.july.persistence.PIEDogovorNRIKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.idrecdogovor);
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
		PIEDogovorNRIBean b = (PIEDogovorNRIBean) eb;
		com.hps.july.persistence.PIEDogovorNRIKey _primaryKey = new com.hps.july.persistence.PIEDogovorNRIKey();
		_primaryKey.idrecdogovor = b.idrecdogovor;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		PIEDogovorNRIBean b = (PIEDogovorNRIBean) eb;
		com.hps.july.persistence.PIEDogovorNRIKey _primaryKey = new com.hps.july.persistence.PIEDogovorNRIKey();
		_primaryKey.idrecdogovor = b.idrecdogovor;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(18, _primaryKey.idrecdogovor);
			if (b.description == null) {
				pstmt.setNull(1, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(1, b.description);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.dogblankcode);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.dogdate == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.dogdate);
			}
			if (b.dogfinishdate == null) {
				pstmt.setNull(4, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(4, b.dogfinishdate);
			}
			if (b.dogstartdate == null) {
				pstmt.setNull(5, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(5, b.dogstartdate);
			}
			pstmt.setInt(6, b.idaccountnri);
			pstmt.setInt(7, b.idbudjet);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.iddogovorplatinum);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			pstmt.setInt(9, b.idexpence);
			if (b.idheaduser == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.idheaduser.intValue());
			}
			pstmt.setInt(11, b.idorgowner);
			pstmt.setInt(12, b.idpartnernri);
			if (b.overprice == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.overprice);
			}
			if (b.purpose == null) {
				pstmt.setNull(14, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(14, b.purpose);
			}
			if (b.sumdog == null) {
				pstmt.setNull(15, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(15, b.sumdog);
			}
			pstmt.setInt(16, b.valute);
			if (b.piequery_idquery == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.piequery_idquery.intValue());
			}
			int inputPos = 18;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[4]);
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
				pstmt.setInt(++inputPos, ((Number)cacheData[8]).intValue());
			}
			if (cacheData[9] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[9]).intValue());
			}
			if (cacheData[10] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[10]).intValue());
			}
			if (cacheData[11] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[11]).intValue());
			}
			if (cacheData[12] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[13]);
			}
			if (cacheData[14] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[14]);
			}
			if (cacheData[15] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[15]).intValue());
			}
			if (cacheData[16] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[16]).intValue());
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
		PIEDogovorNRIBean b = (PIEDogovorNRIBean) eb;
		com.hps.july.persistence.PIEDogovorNRIKey _primaryKey = new com.hps.july.persistence.PIEDogovorNRIKey();
		_primaryKey.idrecdogovor = b.idrecdogovor;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.idrecdogovor);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[4]);
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
				pstmt.setInt(++inputPos, ((Number)cacheData[8]).intValue());
			}
			if (cacheData[9] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[9]).intValue());
			}
			if (cacheData[10] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[10]).intValue());
			}
			if (cacheData[11] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[11]).intValue());
			}
			if (cacheData[12] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[13]);
			}
			if (cacheData[14] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[14]);
			}
			if (cacheData[15] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[15]).intValue());
			}
			if (cacheData[16] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[16]).intValue());
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
		com.hps.july.persistence.PIEDogovorNRIKey key = new com.hps.july.persistence.PIEDogovorNRIKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.idrecdogovor = resultSet.getInt(1);
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
	 * findPIEDogovorNRIsByPiequery
	 */
	public EJSFinder findPIEDogovorNRIsByPiequery(com.hps.july.persistence.PIEQueryKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.idrecdogovor, T1.description, T1.dogblankcode, T1.dogdate, T1.dogfinishdate, T1.dogstartdate, T1.idaccountnri, T1.idbudjet, T1.iddogovorplatinum, T1.idexpence, T1.idheaduser, T1.idorgbeeline, T1.idpartnernri, T1.overprice, T1.purpose, T1.sumdog, T1.valute, T1.id_query FROM pie_dogovorsnri  T1 WHERE T1.id_query = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.idquery);
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
	public com.hps.july.persistence.PIEDogovorNRI findByPrimaryKey(com.hps.july.persistence.PIEDogovorNRIKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.PIEDogovorNRI) home.activateBean(key);
	}
}
