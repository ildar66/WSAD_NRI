package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseSaldoBean_6f33cd6c
 */
public class EJSJDBCPersisterCMPLeaseSaldoBean_6f33cd6c extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseSaldoBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO leasesaldo (saldate, leasecontract, resource, mainsum, additionalndssum, istemp, mainndssum, additionalsum, saldobyhand, notes, msumcalc, mndscalc, asumcalc, andscalc, operator, act, additionalcurrency, maincurrency) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM leasesaldo  WHERE saldate = ? AND leasecontract = ? AND resource = ?";
	private static final String _storeString = "UPDATE leasesaldo  SET mainsum = ?, additionalndssum = ?, istemp = ?, mainndssum = ?, additionalsum = ?, saldobyhand = ?, notes = ?, msumcalc = ?, mndscalc = ?, asumcalc = ?, andscalc = ?, operator = ?, act = ?, additionalcurrency = ?, maincurrency = ? WHERE saldate = ? AND leasecontract = ? AND resource = ?";
	private static final String _loadString = "SELECT T1.mainsum, T1.additionalndssum, T1.saldate, T1.istemp, T1.leasecontract, T1.mainndssum, T1.additionalsum, T1.saldobyhand, T1.notes, T1.msumcalc, T1.mndscalc, T1.asumcalc, T1.andscalc, T1.operator, T1.act, T1.additionalcurrency, T1.maincurrency, T1.resource FROM leasesaldo  T1 WHERE T1.saldate = ? AND T1.leasecontract = ? AND T1.resource = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"mainsum", "additionalndssum", "istemp", "mainndssum", "additionalsum", "saldobyhand", "notes", "msumcalc", "mndscalc", "asumcalc", "andscalc", "operator", "act", "additionalcurrency", "maincurrency"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseSaldoBean_6f33cd6c
	 */
	public EJSJDBCPersisterCMPLeaseSaldoBean_6f33cd6c() throws java.rmi.RemoteException {
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
		LeaseSaldoBean b = (LeaseSaldoBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[15];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.mainsum == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.mainsum);
			}
			cacheData[0] = b.mainsum;
			if (b.additionalndssum == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.additionalndssum);
			}
			cacheData[1] = b.additionalndssum;
			if (b.SalDate == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, b.SalDate);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.istemp);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			cacheData[2] = objectTemp;
			if (b.leaseContract == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.leaseContract.intValue());
			}
			if (b.mainndssum == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.mainndssum);
			}
			cacheData[3] = b.mainndssum;
			if (b.additionalsum == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.additionalsum);
			}
			cacheData[4] = b.additionalsum;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.saldobyhand));
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			cacheData[5] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.notes);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			cacheData[6] = objectTemp;
			if (b.msumcalc == null) {
				pstmt.setNull(11, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(11, b.msumcalc);
			}
			cacheData[7] = b.msumcalc;
			if (b.mndscalc == null) {
				pstmt.setNull(12, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(12, b.mndscalc);
			}
			cacheData[8] = b.mndscalc;
			if (b.asumcalc == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.asumcalc);
			}
			cacheData[9] = b.asumcalc;
			if (b.andscalc == null) {
				pstmt.setNull(14, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(14, b.andscalc);
			}
			cacheData[10] = b.andscalc;
			if (b.operator == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.operator.intValue());
			}
			cacheData[11] = b.operator;
			if (b.act_leaseDocument == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.act_leaseDocument.intValue());
			}
			cacheData[12] = b.act_leaseDocument;
			if (b.additionalcurrency_currency == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.additionalcurrency_currency.intValue());
			}
			cacheData[13] = b.additionalcurrency_currency;
			if (b.maincurrency_currency == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.maincurrency_currency.intValue());
			}
			cacheData[14] = b.maincurrency_currency;
			if (b.resource_resource == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.resource_resource.intValue());
			}
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
		LeaseSaldoBean b = (LeaseSaldoBean) eb;
		com.hps.july.persistence.LeaseSaldoKey _primaryKey = (com.hps.july.persistence.LeaseSaldoKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.SalDate = _primaryKey.SalDate;
		b.leaseContract = _primaryKey.leaseContract;
		b.resource_resource = _primaryKey.resource_resource;
		b.mainsum = resultSet.getBigDecimal(1);
		b.additionalndssum = resultSet.getBigDecimal(2);
		b.istemp = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(4));
		b.mainndssum = resultSet.getBigDecimal(6);
		b.additionalsum = resultSet.getBigDecimal(7);
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(8));
		b.saldobyhand = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.notes = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(9));
		b.msumcalc = resultSet.getBigDecimal(10);
		b.mndscalc = resultSet.getBigDecimal(11);
		b.asumcalc = resultSet.getBigDecimal(12);
		b.andscalc = resultSet.getBigDecimal(13);
		tempint = resultSet.getInt(14);
		b.operator = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(15);
		b.act_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(16);
		b.additionalcurrency_currency = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(17);
		b.maincurrency_currency = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(18);
		b.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[15];
		cacheData[0] = resultSet.getBigDecimal(1);
		cacheData[1] = resultSet.getBigDecimal(2);
		cacheData[2] = resultSet.getString(4);
		cacheData[3] = resultSet.getBigDecimal(6);
		cacheData[4] = resultSet.getBigDecimal(7);
		cacheData[5] = resultSet.getString(8);
		cacheData[6] = resultSet.getString(9);
		cacheData[7] = resultSet.getBigDecimal(10);
		cacheData[8] = resultSet.getBigDecimal(11);
		cacheData[9] = resultSet.getBigDecimal(12);
		cacheData[10] = resultSet.getBigDecimal(13);
		tempint = resultSet.getInt(14);
		cacheData[11] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(15);
		cacheData[12] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(16);
		cacheData[13] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(17);
		cacheData[14] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseSaldoBean b = (LeaseSaldoBean) eb;
		com.hps.july.persistence.LeaseSaldoKey _primaryKey = (com.hps.july.persistence.LeaseSaldoKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			if (_primaryKey.SalDate == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, _primaryKey.SalDate);
			}
			if (_primaryKey.leaseContract == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.leaseContract.intValue());
			}
			if (_primaryKey.resource_resource == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.resource_resource.intValue());
			}
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
		LeaseSaldoBean b = (LeaseSaldoBean) eb;
		com.hps.july.persistence.LeaseSaldoKey _primaryKey = new com.hps.july.persistence.LeaseSaldoKey();
		_primaryKey.SalDate = b.SalDate;
		_primaryKey.leaseContract = b.leaseContract;
		_primaryKey.resource_resource = b.resource_resource;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeaseSaldoBean b = (LeaseSaldoBean) eb;
		com.hps.july.persistence.LeaseSaldoKey _primaryKey = new com.hps.july.persistence.LeaseSaldoKey();
		_primaryKey.SalDate = b.SalDate;
		_primaryKey.leaseContract = b.leaseContract;
		_primaryKey.resource_resource = b.resource_resource;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.SalDate == null) {
				pstmt.setNull(16, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(16, _primaryKey.SalDate);
			}
			if (_primaryKey.leaseContract == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, _primaryKey.leaseContract.intValue());
			}
			if (_primaryKey.resource_resource == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, _primaryKey.resource_resource.intValue());
			}
			if (b.mainsum == null) {
				pstmt.setNull(1, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(1, b.mainsum);
			}
			if (b.additionalndssum == null) {
				pstmt.setNull(2, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(2, b.additionalndssum);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.istemp);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.mainndssum == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.mainndssum);
			}
			if (b.additionalsum == null) {
				pstmt.setNull(5, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(5, b.additionalsum);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.saldobyhand));
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.notes);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			if (b.msumcalc == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.msumcalc);
			}
			if (b.mndscalc == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.mndscalc);
			}
			if (b.asumcalc == null) {
				pstmt.setNull(10, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(10, b.asumcalc);
			}
			if (b.andscalc == null) {
				pstmt.setNull(11, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(11, b.andscalc);
			}
			if (b.operator == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.operator.intValue());
			}
			if (b.act_leaseDocument == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.act_leaseDocument.intValue());
			}
			if (b.additionalcurrency_currency == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.additionalcurrency_currency.intValue());
			}
			if (b.maincurrency_currency == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.maincurrency_currency.intValue());
			}
			if (b.resource_resource == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.resource_resource.intValue());
			}
			int inputPos = 18;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[11]).intValue());
			}
			if (cacheData[12] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[12]).intValue());
			}
			if (cacheData[13] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[13]).intValue());
			}
			if (cacheData[14] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[14]).intValue());
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
		LeaseSaldoBean b = (LeaseSaldoBean) eb;
		com.hps.july.persistence.LeaseSaldoKey _primaryKey = new com.hps.july.persistence.LeaseSaldoKey();
		_primaryKey.SalDate = b.SalDate;
		_primaryKey.leaseContract = b.leaseContract;
		_primaryKey.resource_resource = b.resource_resource;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.SalDate == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, _primaryKey.SalDate);
			}
			if (_primaryKey.leaseContract == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.leaseContract.intValue());
			}
			if (_primaryKey.resource_resource == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.resource_resource.intValue());
			}
			int inputPos = 3;
			if (cacheData[0] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[3]);
			}
			if (cacheData[4] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[6]);
			}
			if (cacheData[7] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[7]);
			}
			if (cacheData[8] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[8]);
			}
			if (cacheData[9] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[9]);
			}
			if (cacheData[10] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[10]);
			}
			if (cacheData[11] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[11]).intValue());
			}
			if (cacheData[12] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[12]).intValue());
			}
			if (cacheData[13] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[13]).intValue());
			}
			if (cacheData[14] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[14]).intValue());
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
		com.hps.july.persistence.LeaseSaldoKey key = new com.hps.july.persistence.LeaseSaldoKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			key.SalDate = resultSet.getDate(3);
			tempint = resultSet.getInt(5);
			key.leaseContract = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(18);
			key.resource_resource = resultSet.wasNull() ? null : new Integer(tempint);
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
	 * findByLeaseContractAndResourceOrderDateDesc
	 */
	public EJSFinder findByLeaseContractAndResourceOrderDateDesc(java.lang.Integer leaseContract, java.lang.Integer resource) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.mainsum, T1.additionalndssum, T1.saldate, T1.istemp, T1.leasecontract, T1.mainndssum, T1.additionalsum, T1.saldobyhand, T1.notes, T1.msumcalc, T1.mndscalc, T1.asumcalc, T1.andscalc, T1.operator, T1.act, T1.additionalcurrency, T1.maincurrency, T1.resource FROM leasesaldo  T1 WHERE leasecontract=? and resource=? order by saldate desc");
			pstmt.setObject(1, leaseContract);
			pstmt.setObject(2, resource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByLeaseContractAndResourceOrderDateAsc
	 */
	public EJSFinder findByLeaseContractAndResourceOrderDateAsc(java.lang.Integer leaseContract, java.lang.Integer resource) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.mainsum, T1.additionalndssum, T1.saldate, T1.istemp, T1.leasecontract, T1.mainndssum, T1.additionalsum, T1.saldobyhand, T1.notes, T1.msumcalc, T1.mndscalc, T1.asumcalc, T1.andscalc, T1.operator, T1.act, T1.additionalcurrency, T1.maincurrency, T1.resource FROM leasesaldo  T1 WHERE leasecontract=? and resource=? order by saldate asc");
			pstmt.setObject(1, leaseContract);
			pstmt.setObject(2, resource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeaseSaldoMainsByMaincurrency
	 */
	public EJSFinder findLeaseSaldoMainsByMaincurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.mainsum, T1.additionalndssum, T1.saldate, T1.istemp, T1.leasecontract, T1.mainndssum, T1.additionalsum, T1.saldobyhand, T1.notes, T1.msumcalc, T1.mndscalc, T1.asumcalc, T1.andscalc, T1.operator, T1.act, T1.additionalcurrency, T1.maincurrency, T1.resource FROM leasesaldo  T1 WHERE T1.maincurrency = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.currency);
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
	public com.hps.july.persistence.LeaseSaldo findByPrimaryKey(com.hps.july.persistence.LeaseSaldoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.LeaseSaldo) home.activateBean(key);
	}
	/**
	 * findLeaseSaldosByAct
	 */
	public EJSFinder findLeaseSaldosByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.mainsum, T1.additionalndssum, T1.saldate, T1.istemp, T1.leasecontract, T1.mainndssum, T1.additionalsum, T1.saldobyhand, T1.notes, T1.msumcalc, T1.mndscalc, T1.asumcalc, T1.andscalc, T1.operator, T1.act, T1.additionalcurrency, T1.maincurrency, T1.resource FROM leasesaldo  T1 WHERE T1.act = ?");
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
	/**
	 * findLeaseSaldoByResource
	 */
	public EJSFinder findLeaseSaldoByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.mainsum, T1.additionalndssum, T1.saldate, T1.istemp, T1.leasecontract, T1.mainndssum, T1.additionalsum, T1.saldobyhand, T1.notes, T1.msumcalc, T1.mndscalc, T1.asumcalc, T1.andscalc, T1.operator, T1.act, T1.additionalcurrency, T1.maincurrency, T1.resource FROM leasesaldo  T1 WHERE T1.resource = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.resource);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeaseSaldoAddsByAdditionalcurrency
	 */
	public EJSFinder findLeaseSaldoAddsByAdditionalcurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.mainsum, T1.additionalndssum, T1.saldate, T1.istemp, T1.leasecontract, T1.mainndssum, T1.additionalsum, T1.saldobyhand, T1.notes, T1.msumcalc, T1.mndscalc, T1.asumcalc, T1.andscalc, T1.operator, T1.act, T1.additionalcurrency, T1.maincurrency, T1.resource FROM leasesaldo  T1 WHERE T1.additionalcurrency = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.currency);
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
	public EJSFinder findByQBE(java.lang.Integer leaseContract, java.lang.Boolean isDateStart, java.sql.Date fromDateStart, java.sql.Date toDateStart, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(leaseContract, isDateStart, fromDateStart, toDateStart, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T1.mainsum, T1.additionalndssum, T1.saldate, T1.istemp, T1.leasecontract, T1.mainndssum, T1.additionalsum, T1.saldobyhand, T1.notes, T1.msumcalc, T1.mndscalc, T1.asumcalc, T1.andscalc, T1.operator, T1.act, T1.additionalcurrency, T1.maincurrency, T1.resource FROM leasesaldo  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {291};
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
	private LeaseSaldoBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.LeaseSaldoBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.LeaseSaldoBeanFinderObject temp_finderObject = new com.hps.july.persistence.LeaseSaldoBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
