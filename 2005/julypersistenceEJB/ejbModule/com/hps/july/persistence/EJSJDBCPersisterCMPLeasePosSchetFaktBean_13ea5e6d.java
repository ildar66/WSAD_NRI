package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeasePosSchetFaktBean_13ea5e6d
 */
public class EJSJDBCPersisterCMPLeasePosSchetFaktBean_13ea5e6d extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeasePosSchetFaktBean {
	private static final String _createString = "INSERT INTO leaseposschetfakt (idPosSchetFakt, Country, Edizm, excise, NameResource, NumGTD, posorder, Price, Qty, RateNds, SumFreeTax, SumNds, SumWithTax, idSchetFakt, ResourceNri) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM leaseposschetfakt  WHERE idPosSchetFakt = ?";
	private static final String _storeString = "UPDATE leaseposschetfakt  SET Country = ?, Edizm = ?, excise = ?, NameResource = ?, NumGTD = ?, posorder = ?, Price = ?, Qty = ?, RateNds = ?, SumFreeTax = ?, SumNds = ?, SumWithTax = ?, idSchetFakt = ?, ResourceNri = ? WHERE idPosSchetFakt = ?";
	private static final String _loadString = "SELECT T1.idPosSchetFakt, T1.Country, T1.Edizm, T1.excise, T1.NameResource, T1.NumGTD, T1.posorder, T1.Price, T1.Qty, T1.RateNds, T1.SumFreeTax, T1.SumNds, T1.SumWithTax, T1.idSchetFakt, T1.ResourceNri FROM leaseposschetfakt  T1 WHERE T1.idPosSchetFakt = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"Country", "Edizm", "excise", "NameResource", "NumGTD", "posorder", "Price", "Qty", "RateNds", "SumFreeTax", "SumNds", "SumWithTax", "idSchetFakt", "ResourceNri"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true, true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeasePosSchetFaktBean_13ea5e6d
	 */
	public EJSJDBCPersisterCMPLeasePosSchetFaktBean_13ea5e6d() throws java.rmi.RemoteException {
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
		LeasePosSchetFaktBean b = (LeasePosSchetFaktBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[14];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.idPosSchetFakt);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.country);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.edizm);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			if (b.excise == null) {
				pstmt.setNull(4, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(4, b.excise);
			}
			cacheData[2] = b.excise;
			if (b.nameResource == null) {
				pstmt.setNull(5, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(5, b.nameResource);
			}
			cacheData[3] = b.nameResource;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numGTD);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			cacheData[4] = objectTemp;
			pstmt.setInt(7, b.posorder);
			cacheData[5] = new Integer(b.posorder);
			if (b.price == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.price);
			}
			cacheData[6] = b.price;
			if (b.qty == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.qty);
			}
			cacheData[7] = b.qty;
			if (b.rateNds == null) {
				pstmt.setNull(10, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(10, b.rateNds);
			}
			cacheData[8] = b.rateNds;
			if (b.sumFreeTax == null) {
				pstmt.setNull(11, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(11, b.sumFreeTax);
			}
			cacheData[9] = b.sumFreeTax;
			if (b.sumNds == null) {
				pstmt.setNull(12, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(12, b.sumNds);
			}
			cacheData[10] = b.sumNds;
			if (b.sumWithTax == null) {
				pstmt.setNull(13, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(13, b.sumWithTax);
			}
			cacheData[11] = b.sumWithTax;
			if (b.idSchetFakt_idSchetFakt == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.idSchetFakt_idSchetFakt.intValue());
			}
			cacheData[12] = b.idSchetFakt_idSchetFakt;
			if (b.resourceNri_resource == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.resourceNri_resource.intValue());
			}
			cacheData[13] = b.resourceNri_resource;
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
		LeasePosSchetFaktBean b = (LeasePosSchetFaktBean) eb;
		com.hps.july.persistence.LeasePosSchetFaktKey _primaryKey = (com.hps.july.persistence.LeasePosSchetFaktKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.idPosSchetFakt = _primaryKey.idPosSchetFakt;
		b.country = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.edizm = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.excise = resultSet.getBigDecimal(4);
		b.nameResource = resultSet.getString(5);
		b.numGTD = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(6));
		b.posorder = resultSet.getInt(7);
		b.price = resultSet.getBigDecimal(8);
		b.qty = resultSet.getBigDecimal(9);
		b.rateNds = resultSet.getBigDecimal(10);
		b.sumFreeTax = resultSet.getBigDecimal(11);
		b.sumNds = resultSet.getBigDecimal(12);
		b.sumWithTax = resultSet.getBigDecimal(13);
		tempint = resultSet.getInt(14);
		b.idSchetFakt_idSchetFakt = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(15);
		b.resourceNri_resource = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[14];
		cacheData[0] = resultSet.getString(2);
		cacheData[1] = resultSet.getString(3);
		cacheData[2] = resultSet.getBigDecimal(4);
		cacheData[3] = resultSet.getString(5);
		cacheData[4] = resultSet.getString(6);
		tempint = resultSet.getInt(7);
		cacheData[5] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[6] = resultSet.getBigDecimal(8);
		cacheData[7] = resultSet.getBigDecimal(9);
		cacheData[8] = resultSet.getBigDecimal(10);
		cacheData[9] = resultSet.getBigDecimal(11);
		cacheData[10] = resultSet.getBigDecimal(12);
		cacheData[11] = resultSet.getBigDecimal(13);
		tempint = resultSet.getInt(14);
		cacheData[12] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(15);
		cacheData[13] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeasePosSchetFaktBean b = (LeasePosSchetFaktBean) eb;
		com.hps.july.persistence.LeasePosSchetFaktKey _primaryKey = (com.hps.july.persistence.LeasePosSchetFaktKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.idPosSchetFakt);
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
		LeasePosSchetFaktBean b = (LeasePosSchetFaktBean) eb;
		com.hps.july.persistence.LeasePosSchetFaktKey _primaryKey = new com.hps.july.persistence.LeasePosSchetFaktKey();
		_primaryKey.idPosSchetFakt = b.idPosSchetFakt;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeasePosSchetFaktBean b = (LeasePosSchetFaktBean) eb;
		com.hps.july.persistence.LeasePosSchetFaktKey _primaryKey = new com.hps.july.persistence.LeasePosSchetFaktKey();
		_primaryKey.idPosSchetFakt = b.idPosSchetFakt;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(15, _primaryKey.idPosSchetFakt);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.country);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.edizm);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.excise == null) {
				pstmt.setNull(3, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(3, b.excise);
			}
			if (b.nameResource == null) {
				pstmt.setNull(4, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(4, b.nameResource);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numGTD);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			pstmt.setInt(6, b.posorder);
			if (b.price == null) {
				pstmt.setNull(7, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(7, b.price);
			}
			if (b.qty == null) {
				pstmt.setNull(8, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(8, b.qty);
			}
			if (b.rateNds == null) {
				pstmt.setNull(9, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(9, b.rateNds);
			}
			if (b.sumFreeTax == null) {
				pstmt.setNull(10, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(10, b.sumFreeTax);
			}
			if (b.sumNds == null) {
				pstmt.setNull(11, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(11, b.sumNds);
			}
			if (b.sumWithTax == null) {
				pstmt.setNull(12, java.sql.Types.DECIMAL);
			}
			else {
				pstmt.setBigDecimal(12, b.sumWithTax);
			}
			if (b.idSchetFakt_idSchetFakt == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.idSchetFakt_idSchetFakt.intValue());
			}
			if (b.resourceNri_resource == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.resourceNri_resource.intValue());
			}
			int inputPos = 15;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
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
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[6]);
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
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[11]);
			}
			if (cacheData[12] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[12]).intValue());
			}
			if (cacheData[13] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[13]).intValue());
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
		LeasePosSchetFaktBean b = (LeasePosSchetFaktBean) eb;
		com.hps.july.persistence.LeasePosSchetFaktKey _primaryKey = new com.hps.july.persistence.LeasePosSchetFaktKey();
		_primaryKey.idPosSchetFakt = b.idPosSchetFakt;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.idPosSchetFakt);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[2]);
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
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[6]);
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
				pstmt.setBigDecimal(++inputPos, (java.math.BigDecimal)cacheData[11]);
			}
			if (cacheData[12] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[12]).intValue());
			}
			if (cacheData[13] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[13]).intValue());
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
		com.hps.july.persistence.LeasePosSchetFaktKey key = new com.hps.july.persistence.LeasePosSchetFaktKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.idPosSchetFakt = resultSet.getInt(1);
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
	 * findLeasePosSchetFaktByResourceNri
	 */
	public EJSFinder findLeasePosSchetFaktByResourceNri(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.idPosSchetFakt, T1.Country, T1.Edizm, T1.excise, T1.NameResource, T1.NumGTD, T1.posorder, T1.Price, T1.Qty, T1.RateNds, T1.SumFreeTax, T1.SumNds, T1.SumWithTax, T1.idSchetFakt, T1.ResourceNri FROM leaseposschetfakt  T1 WHERE T1.ResourceNri = ?");
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
	 * findByIdSchetFaktOrderByPosorderDesc
	 */
	public EJSFinder findByIdSchetFaktOrderByPosorderDesc(java.lang.Integer idSchetFact) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.idPosSchetFakt, T1.Country, T1.Edizm, T1.excise, T1.NameResource, T1.NumGTD, T1.posorder, T1.Price, T1.Qty, T1.RateNds, T1.SumFreeTax, T1.SumNds, T1.SumWithTax, T1.idSchetFakt, T1.ResourceNri FROM leaseposschetfakt  T1 WHERE T1.IdSchetFakt = ? order by T1.posorder desc");
			pstmt.setObject(1, idSchetFact);
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
	public com.hps.july.persistence.LeasePosSchetFakt findByPrimaryKey(com.hps.july.persistence.LeasePosSchetFaktKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.LeasePosSchetFakt) home.activateBean(key);
	}
	/**
	 * findLeasePosSchetFaktsByIdSchetFakt
	 */
	public EJSFinder findLeasePosSchetFaktsByIdSchetFakt(com.hps.july.persistence.LeaseSchetFaktKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.idPosSchetFakt, T1.Country, T1.Edizm, T1.excise, T1.NameResource, T1.NumGTD, T1.posorder, T1.Price, T1.Qty, T1.RateNds, T1.SumFreeTax, T1.SumNds, T1.SumWithTax, T1.idSchetFakt, T1.ResourceNri FROM leaseposschetfakt  T1 WHERE T1.idSchetFakt = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.idSchetFakt);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByIdSchetFaktOrderByPosorderAsc
	 */
	public EJSFinder findByIdSchetFaktOrderByPosorderAsc(java.lang.Integer idSchetFact) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.idPosSchetFakt, T1.Country, T1.Edizm, T1.excise, T1.NameResource, T1.NumGTD, T1.posorder, T1.Price, T1.Qty, T1.RateNds, T1.SumFreeTax, T1.SumNds, T1.SumWithTax, T1.idSchetFakt, T1.ResourceNri FROM leaseposschetfakt  T1 WHERE T1.IdSchetFakt = ? order by T1.posorder asc");
			pstmt.setObject(1, idSchetFact);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
