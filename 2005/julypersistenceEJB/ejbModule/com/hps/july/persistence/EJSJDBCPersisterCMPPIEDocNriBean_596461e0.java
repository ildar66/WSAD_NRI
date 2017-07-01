package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPIEDocNriBean_596461e0
 */
public class EJSJDBCPersisterCMPPIEDocNriBean_596461e0 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderPIEDocNriBean {
	private static final String _createString = "INSERT INTO pie_docsnri (idrecdoc, contrgagent, datedoc, gtdnumber, headuser, iddogovnri, idvaluta, owner, placefrom, placeto, prim, soprnumber, sumdoc, tempinbill, typedocnri, typedogovnri, id_query) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM pie_docsnri  WHERE idrecdoc = ?";
	private static final String _storeString = "UPDATE pie_docsnri  SET contrgagent = ?, datedoc = ?, gtdnumber = ?, headuser = ?, iddogovnri = ?, idvaluta = ?, owner = ?, placefrom = ?, placeto = ?, prim = ?, soprnumber = ?, sumdoc = ?, tempinbill = ?, typedocnri = ?, typedogovnri = ?, id_query = ? WHERE idrecdoc = ?";
	private static final String _loadString = "SELECT T1.idrecdoc, T1.contrgagent, T1.datedoc, T1.gtdnumber, T1.headuser, T1.iddogovnri, T1.idvaluta, T1.owner, T1.placefrom, T1.placeto, T1.prim, T1.soprnumber, T1.sumdoc, T1.tempinbill, T1.typedocnri, T1.typedogovnri, T1.id_query FROM pie_docsnri  T1 WHERE T1.idrecdoc = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"contrgagent", "datedoc", "gtdnumber", "headuser", "iddogovnri", "idvaluta", "owner", "placefrom", "placeto", "prim", "soprnumber", "sumdoc", "tempinbill", "typedocnri", "typedogovnri", "id_query"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPIEDocNriBean_596461e0
	 */
	public EJSJDBCPersisterCMPPIEDocNriBean_596461e0() throws java.rmi.RemoteException {
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
		PIEDocNriBean b = (PIEDocNriBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[16];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.idrecdoc);
			if (b.contragent == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.contragent.intValue());
			}
			cacheData[0] = b.contragent;
			if (b.datedoc == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.datedoc);
			}
			cacheData[1] = b.datedoc;
			if (b.gtdnumber == null) {
				pstmt.setNull(4, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(4, b.gtdnumber);
			}
			cacheData[2] = b.gtdnumber;
			if (b.headuser == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.headuser.intValue());
			}
			cacheData[3] = b.headuser;
			if (b.iddogovnri == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.iddogovnri.intValue());
			}
			cacheData[4] = b.iddogovnri;
			if (b.idvaluta == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.idvaluta.intValue());
			}
			cacheData[5] = b.idvaluta;
			pstmt.setInt(8, b.owner);
			cacheData[6] = new Integer(b.owner);
			if (b.placefrom == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.placefrom.intValue());
			}
			cacheData[7] = b.placefrom;
			if (b.placeto == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.placeto.intValue());
			}
			cacheData[8] = b.placeto;
			if (b.prim == null) {
				pstmt.setNull(11, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(11, b.prim);
			}
			cacheData[9] = b.prim;
			if (b.soprnumber == null) {
				pstmt.setNull(12, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(12, b.soprnumber);
			}
			cacheData[10] = b.soprnumber;
			if (b.sumdoc == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.sumdoc);
			}
			cacheData[11] = b.sumdoc;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.tempinbill);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			cacheData[12] = objectTemp;
			pstmt.setShort(15, b.typedocnri);
			cacheData[13] = new Short(b.typedocnri);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.typedogovnri);
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			cacheData[14] = objectTemp;
			if (b.query_idquery == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.query_idquery.intValue());
			}
			cacheData[15] = b.query_idquery;
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
		PIEDocNriBean b = (PIEDocNriBean) eb;
		com.hps.july.persistence.PIEDocNriKey _primaryKey = (com.hps.july.persistence.PIEDocNriKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		short tempshort;
		int tempint;

		b.idrecdoc = _primaryKey.idrecdoc;
		tempint = resultSet.getInt(2);
		b.contragent = resultSet.wasNull() ? null : new Integer(tempint);
		b.datedoc = resultSet.getDate(3);
		b.gtdnumber = resultSet.getString(4);
		tempint = resultSet.getInt(5);
		b.headuser = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(6);
		b.iddogovnri = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(7);
		b.idvaluta = resultSet.wasNull() ? null : new Integer(tempint);
		b.owner = resultSet.getInt(8);
		tempint = resultSet.getInt(9);
		b.placefrom = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(10);
		b.placeto = resultSet.wasNull() ? null : new Integer(tempint);
		b.prim = resultSet.getString(11);
		b.soprnumber = resultSet.getString(12);
		b.sumdoc = resultSet.getBigDecimal(13);
		b.tempinbill = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(14));
		b.typedocnri = resultSet.getShort(15);
		b.typedogovnri = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(16));
		tempint = resultSet.getInt(17);
		b.query_idquery = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[16];
		tempint = resultSet.getInt(2);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[1] = resultSet.getDate(3);
		cacheData[2] = resultSet.getString(4);
		tempint = resultSet.getInt(5);
		cacheData[3] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(6);
		cacheData[4] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(7);
		cacheData[5] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		cacheData[6] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(9);
		cacheData[7] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(10);
		cacheData[8] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[9] = resultSet.getString(11);
		cacheData[10] = resultSet.getString(12);
		cacheData[11] = resultSet.getBigDecimal(13);
		cacheData[12] = resultSet.getString(14);
		tempshort = resultSet.getShort(15);
		cacheData[13] = resultSet.wasNull() ? null : new Short(tempshort);
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
		PIEDocNriBean b = (PIEDocNriBean) eb;
		com.hps.july.persistence.PIEDocNriKey _primaryKey = (com.hps.july.persistence.PIEDocNriKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.idrecdoc);
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
		PIEDocNriBean b = (PIEDocNriBean) eb;
		com.hps.july.persistence.PIEDocNriKey _primaryKey = new com.hps.july.persistence.PIEDocNriKey();
		_primaryKey.idrecdoc = b.idrecdoc;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		PIEDocNriBean b = (PIEDocNriBean) eb;
		com.hps.july.persistence.PIEDocNriKey _primaryKey = new com.hps.july.persistence.PIEDocNriKey();
		_primaryKey.idrecdoc = b.idrecdoc;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(17, _primaryKey.idrecdoc);
			if (b.contragent == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.contragent.intValue());
			}
			if (b.datedoc == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, b.datedoc);
			}
			if (b.gtdnumber == null) {
				pstmt.setNull(3, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(3, b.gtdnumber);
			}
			if (b.headuser == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.headuser.intValue());
			}
			if (b.iddogovnri == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.iddogovnri.intValue());
			}
			if (b.idvaluta == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.idvaluta.intValue());
			}
			pstmt.setInt(7, b.owner);
			if (b.placefrom == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.placefrom.intValue());
			}
			if (b.placeto == null) {
				pstmt.setNull(9, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(9, b.placeto.intValue());
			}
			if (b.prim == null) {
				pstmt.setNull(10, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(10, b.prim);
			}
			if (b.soprnumber == null) {
				pstmt.setNull(11, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(11, b.soprnumber);
			}
			if (b.sumdoc == null) {
				pstmt.setNull(12, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(12, b.sumdoc);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.tempinbill);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			pstmt.setShort(14, b.typedocnri);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.typedogovnri);
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			if (b.query_idquery == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.query_idquery.intValue());
			}
			int inputPos = 17;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[4]).intValue());
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
			}
			if (cacheData[7] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[7]).intValue());
			}
			if (cacheData[8] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[8]).intValue());
			}
			if (cacheData[9] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[11]);
			}
			if (cacheData[12] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setShort(++inputPos, ((Number)cacheData[13]).shortValue());
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
		PIEDocNriBean b = (PIEDocNriBean) eb;
		com.hps.july.persistence.PIEDocNriKey _primaryKey = new com.hps.july.persistence.PIEDocNriKey();
		_primaryKey.idrecdoc = b.idrecdoc;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.idrecdoc);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[4]).intValue());
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
			}
			if (cacheData[7] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[7]).intValue());
			}
			if (cacheData[8] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[8]).intValue());
			}
			if (cacheData[9] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[11]);
			}
			if (cacheData[12] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[12]);
			}
			if (cacheData[13] != null) {
				pstmt.setShort(++inputPos, ((Number)cacheData[13]).shortValue());
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
		com.hps.july.persistence.PIEDocNriKey key = new com.hps.july.persistence.PIEDocNriKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.idrecdoc = resultSet.getInt(1);
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
	public com.hps.july.persistence.PIEDocNri findByPrimaryKey(com.hps.july.persistence.PIEDocNriKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.PIEDocNri) home.activateBean(key);
	}
	/**
	 * findPIEDocNrisByQuery
	 */
	public EJSFinder findPIEDocNrisByQuery(com.hps.july.persistence.PIEQueryKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.idrecdoc, T1.contrgagent, T1.datedoc, T1.gtdnumber, T1.headuser, T1.iddogovnri, T1.idvaluta, T1.owner, T1.placefrom, T1.placeto, T1.prim, T1.soprnumber, T1.sumdoc, T1.tempinbill, T1.typedocnri, T1.typedogovnri, T1.id_query FROM pie_docsnri  T1 WHERE T1.id_query = ?");
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
}
