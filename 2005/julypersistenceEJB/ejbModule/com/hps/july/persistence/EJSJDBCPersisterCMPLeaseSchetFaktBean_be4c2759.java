package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseSchetFaktBean_be4c2759
 */
public class EJSJDBCPersisterCMPLeaseSchetFaktBean_be4c2759 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseSchetFaktBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO leaseschetfakt (idSchetFakt, DateSchetFakt, BaseDocDate, BaseDocNumber, NumberSchetFakt, docfilename, doctext, datestartsf, dateendsf, created, createdby, modified, modifiedby, state, idregistrydoc, idAkt, idCurrency, idContract) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM leaseschetfakt  WHERE idSchetFakt = ?";
	private static final String _storeString = "UPDATE leaseschetfakt  SET DateSchetFakt = ?, BaseDocDate = ?, BaseDocNumber = ?, NumberSchetFakt = ?, docfilename = ?, doctext = ?, datestartsf = ?, dateendsf = ?, created = ?, createdby = ?, modified = ?, modifiedby = ?, state = ?, idregistrydoc = ?, idAkt = ?, idCurrency = ?, idContract = ? WHERE idSchetFakt = ?";
	private static final String _loadString = "SELECT T1.DateSchetFakt, T1.idSchetFakt, T1.BaseDocDate, T1.BaseDocNumber, T1.NumberSchetFakt, T1.docfilename, T1.doctext, T1.datestartsf, T1.dateendsf, T1.created, T1.createdby, T1.modified, T1.modifiedby, T1.state, T1.idregistrydoc, T1.idAkt, T1.idCurrency, T1.idContract FROM leaseschetfakt  T1 WHERE T1.idSchetFakt = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"state"};
	private static final boolean[] _predicateMaps = {true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseSchetFaktBean_be4c2759
	 */
	public EJSJDBCPersisterCMPLeaseSchetFaktBean_be4c2759() throws java.rmi.RemoteException {
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
		LeaseSchetFaktBean b = (LeaseSchetFaktBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[1];
		pstmt = getPreparedStatement(_createString);
		try {
			if (b.dateSchetFakt == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, b.dateSchetFakt);
			}
			pstmt.setInt(1, b.idSchetFakt);
			if (b.baseDocDate == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.baseDocDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.baseDocNumber);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numberSchetFakt);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.docfilename);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			if (b.doctext == null) {
				pstmt.setNull(7, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(7, b.doctext);
			}
			if (b.dateStartSf == null) {
				pstmt.setNull(8, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(8, b.dateStartSf);
			}
			if (b.dateEndSf == null) {
				pstmt.setNull(9, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(9, b.dateEndSf);
			}
			if (b.created == null) {
				pstmt.setNull(10, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(10, b.created);
			}
			if (b.createdBy == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.createdBy.intValue());
			}
			if (b.modified == null) {
				pstmt.setNull(12, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(12, b.modified);
			}
			if (b.modifiedBy == null) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(13, b.modifiedBy.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.state);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			if (b.idRegistryDoc == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.idRegistryDoc.intValue());
			}
			if (b.idAct_leaseDocument == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.idAct_leaseDocument.intValue());
			}
			if (b.idCurrency_currency == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.idCurrency_currency.intValue());
			}
			if (b.idContract_leaseDocument == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.idContract_leaseDocument.intValue());
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
		LeaseSchetFaktBean b = (LeaseSchetFaktBean) eb;
		com.hps.july.persistence.LeaseSchetFaktKey _primaryKey = (com.hps.july.persistence.LeaseSchetFaktKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.idSchetFakt = _primaryKey.idSchetFakt;
		b.dateSchetFakt = resultSet.getDate(1);
		b.baseDocDate = resultSet.getDate(3);
		b.baseDocNumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.numberSchetFakt = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(5));
		b.docfilename = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(6));
		b.doctext = resultSet.getBytes(7);
		b.dateStartSf = resultSet.getDate(8);
		b.dateEndSf = resultSet.getDate(9);
		b.created = resultSet.getTimestamp(10);
		tempint = resultSet.getInt(11);
		b.createdBy = resultSet.wasNull() ? null : new Integer(tempint);
		b.modified = resultSet.getTimestamp(12);
		tempint = resultSet.getInt(13);
		b.modifiedBy = resultSet.wasNull() ? null : new Integer(tempint);
		b.state = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(14));
		tempint = resultSet.getInt(15);
		b.idRegistryDoc = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(16);
		b.idAct_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(17);
		b.idCurrency_currency = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(18);
		b.idContract_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[1];
		cacheData[0] = resultSet.getString(14);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseSchetFaktBean b = (LeaseSchetFaktBean) eb;
		com.hps.july.persistence.LeaseSchetFaktKey _primaryKey = (com.hps.july.persistence.LeaseSchetFaktKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.idSchetFakt);
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
		LeaseSchetFaktBean b = (LeaseSchetFaktBean) eb;
		com.hps.july.persistence.LeaseSchetFaktKey _primaryKey = new com.hps.july.persistence.LeaseSchetFaktKey();
		_primaryKey.idSchetFakt = b.idSchetFakt;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeaseSchetFaktBean b = (LeaseSchetFaktBean) eb;
		com.hps.july.persistence.LeaseSchetFaktKey _primaryKey = new com.hps.july.persistence.LeaseSchetFaktKey();
		_primaryKey.idSchetFakt = b.idSchetFakt;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(18, _primaryKey.idSchetFakt);
			if (b.dateSchetFakt == null) {
				pstmt.setNull(1, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(1, b.dateSchetFakt);
			}
			if (b.baseDocDate == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, b.baseDocDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.baseDocNumber);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.numberSchetFakt);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.docfilename);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.doctext == null) {
				pstmt.setNull(6, java.sql.Types.LONGVARBINARY);
			}
			else {
				pstmt.setBytes(6, b.doctext);
			}
			if (b.dateStartSf == null) {
				pstmt.setNull(7, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(7, b.dateStartSf);
			}
			if (b.dateEndSf == null) {
				pstmt.setNull(8, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(8, b.dateEndSf);
			}
			if (b.created == null) {
				pstmt.setNull(9, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(9, b.created);
			}
			if (b.createdBy == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.createdBy.intValue());
			}
			if (b.modified == null) {
				pstmt.setNull(11, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(11, b.modified);
			}
			if (b.modifiedBy == null) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(12, b.modifiedBy.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.state);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			if (b.idRegistryDoc == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.idRegistryDoc.intValue());
			}
			if (b.idAct_leaseDocument == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.idAct_leaseDocument.intValue());
			}
			if (b.idCurrency_currency == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.idCurrency_currency.intValue());
			}
			if (b.idContract_leaseDocument == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.idContract_leaseDocument.intValue());
			}
			int inputPos = 18;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
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
		LeaseSchetFaktBean b = (LeaseSchetFaktBean) eb;
		com.hps.july.persistence.LeaseSchetFaktKey _primaryKey = new com.hps.july.persistence.LeaseSchetFaktKey();
		_primaryKey.idSchetFakt = b.idSchetFakt;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.idSchetFakt);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
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
		com.hps.july.persistence.LeaseSchetFaktKey key = new com.hps.july.persistence.LeaseSchetFaktKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.idSchetFakt = resultSet.getInt(2);
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
	 * findLeaseSchetFaktsByIdAct
	 */
	public EJSFinder findLeaseSchetFaktsByIdAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.DateSchetFakt, T1.idSchetFakt, T1.BaseDocDate, T1.BaseDocNumber, T1.NumberSchetFakt, T1.docfilename, T1.doctext, T1.datestartsf, T1.dateendsf, T1.created, T1.createdby, T1.modified, T1.modifiedby, T1.state, T1.idregistrydoc, T1.idAkt, T1.idCurrency, T1.idContract FROM leaseschetfakt  T1 WHERE T1.idAkt = ?");
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
	 * findByIdActOrderByNumberSchetFaktAsc
	 */
	public EJSFinder findByIdActOrderByNumberSchetFaktAsc(java.lang.Integer idAct) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.DateSchetFakt, T1.idSchetFakt, T1.BaseDocDate, T1.BaseDocNumber, T1.NumberSchetFakt, T1.docfilename, T1.doctext, T1.datestartsf, T1.dateendsf, T1.created, T1.createdby, T1.modified, T1.modifiedby, T1.state, T1.idregistrydoc, T1.idAkt, T1.idCurrency, T1.idContract FROM leaseschetfakt  T1 WHERE T1.idAkt = ? order by T1.NumberSchetFakt asc");
			pstmt.setObject(1, idAct);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeaseSchetFaktsByIdContract
	 */
	public EJSFinder findLeaseSchetFaktsByIdContract(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.DateSchetFakt, T1.idSchetFakt, T1.BaseDocDate, T1.BaseDocNumber, T1.NumberSchetFakt, T1.docfilename, T1.doctext, T1.datestartsf, T1.dateendsf, T1.created, T1.createdby, T1.modified, T1.modifiedby, T1.state, T1.idregistrydoc, T1.idAkt, T1.idCurrency, T1.idContract FROM leaseschetfakt  T1 WHERE T1.idContract = ?");
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseSchetFakt findByPrimaryKey(com.hps.july.persistence.LeaseSchetFaktKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.LeaseSchetFakt) home.activateBean(key);
	}
	/**
	 * findByIdContractOrderByDateSchetFaktAsc
	 */
	public EJSFinder findByIdContractOrderByDateSchetFaktAsc(java.lang.Integer idContract) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.DateSchetFakt, T1.idSchetFakt, T1.BaseDocDate, T1.BaseDocNumber, T1.NumberSchetFakt, T1.docfilename, T1.doctext, T1.datestartsf, T1.dateendsf, T1.created, T1.createdby, T1.modified, T1.modifiedby, T1.state, T1.idregistrydoc, T1.idAkt, T1.idCurrency, T1.idContract FROM leaseschetfakt  T1 WHERE T1.idContract = ? order by T1.DateSchetFakt asc");
			pstmt.setObject(1, idContract);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByIdContractOrderByDateSchetFaktDesc
	 */
	public EJSFinder findByIdContractOrderByDateSchetFaktDesc(java.lang.Integer idContract) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.DateSchetFakt, T1.idSchetFakt, T1.BaseDocDate, T1.BaseDocNumber, T1.NumberSchetFakt, T1.docfilename, T1.doctext, T1.datestartsf, T1.dateendsf, T1.created, T1.createdby, T1.modified, T1.modifiedby, T1.state, T1.idregistrydoc, T1.idAkt, T1.idCurrency, T1.idContract FROM leaseschetfakt  T1 WHERE T1.idContract = ? order by T1.DateSchetFakt desc");
			pstmt.setObject(1, idContract);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByIdContractOrderByNumberSchetFaktDesc
	 */
	public EJSFinder findByIdContractOrderByNumberSchetFaktDesc(java.lang.Integer idContract) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.DateSchetFakt, T1.idSchetFakt, T1.BaseDocDate, T1.BaseDocNumber, T1.NumberSchetFakt, T1.docfilename, T1.doctext, T1.datestartsf, T1.dateendsf, T1.created, T1.createdby, T1.modified, T1.modifiedby, T1.state, T1.idregistrydoc, T1.idAkt, T1.idCurrency, T1.idContract FROM leaseschetfakt  T1 WHERE T1.idContract = ? order by T1.NumberSchetFakt desc");
			pstmt.setObject(1, idContract);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByIdActOrderByDateSchetFaktDesc
	 */
	public EJSFinder findByIdActOrderByDateSchetFaktDesc(java.lang.Integer idAct) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.DateSchetFakt, T1.idSchetFakt, T1.BaseDocDate, T1.BaseDocNumber, T1.NumberSchetFakt, T1.docfilename, T1.doctext, T1.datestartsf, T1.dateendsf, T1.created, T1.createdby, T1.modified, T1.modifiedby, T1.state, T1.idregistrydoc, T1.idAkt, T1.idCurrency, T1.idContract FROM leaseschetfakt  T1 WHERE T1.idAkt = ? order by T1.DateSchetFakt desc");
			pstmt.setObject(1, idAct);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByIdActOrderByDateSchetFaktAsc
	 */
	public EJSFinder findByIdActOrderByDateSchetFaktAsc(java.lang.Integer idAct) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.DateSchetFakt, T1.idSchetFakt, T1.BaseDocDate, T1.BaseDocNumber, T1.NumberSchetFakt, T1.docfilename, T1.doctext, T1.datestartsf, T1.dateendsf, T1.created, T1.createdby, T1.modified, T1.modifiedby, T1.state, T1.idregistrydoc, T1.idAkt, T1.idCurrency, T1.idContract FROM leaseschetfakt  T1 WHERE T1.idAkt = ? order by T1.DateSchetFakt asc");
			pstmt.setObject(1, idAct);
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
	public EJSFinder findByQBE(java.lang.Integer idAct, java.lang.Boolean isContractType, java.lang.String typeContract, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(idAct, isContractType, typeContract, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByIdContractOrderByNumberSchetFaktAsc
	 */
	public EJSFinder findByIdContractOrderByNumberSchetFaktAsc(java.lang.Integer idContract) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.DateSchetFakt, T1.idSchetFakt, T1.BaseDocDate, T1.BaseDocNumber, T1.NumberSchetFakt, T1.docfilename, T1.doctext, T1.datestartsf, T1.dateendsf, T1.created, T1.createdby, T1.modified, T1.modifiedby, T1.state, T1.idregistrydoc, T1.idAkt, T1.idCurrency, T1.idContract FROM leaseschetfakt  T1 WHERE T1.idContract = ? order by T1.NumberSchetFakt asc");
			pstmt.setObject(1, idContract);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findLeaseSchetFaktsByIdCurrency
	 */
	public EJSFinder findLeaseSchetFaktsByIdCurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.DateSchetFakt, T1.idSchetFakt, T1.BaseDocDate, T1.BaseDocNumber, T1.NumberSchetFakt, T1.docfilename, T1.doctext, T1.datestartsf, T1.dateendsf, T1.created, T1.createdby, T1.modified, T1.modifiedby, T1.state, T1.idregistrydoc, T1.idAkt, T1.idCurrency, T1.idContract FROM leaseschetfakt  T1 WHERE T1.idCurrency = ?");
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
	 * findByIdActOrderByNumberSchetFaktDesc
	 */
	public EJSFinder findByIdActOrderByNumberSchetFaktDesc(java.lang.Integer idAct) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.DateSchetFakt, T1.idSchetFakt, T1.BaseDocDate, T1.BaseDocNumber, T1.NumberSchetFakt, T1.docfilename, T1.doctext, T1.datestartsf, T1.dateendsf, T1.created, T1.createdby, T1.modified, T1.modifiedby, T1.state, T1.idregistrydoc, T1.idAkt, T1.idCurrency, T1.idContract FROM leaseschetfakt  T1 WHERE T1.idAkt = ? order by T1.NumberSchetFakt desc");
			pstmt.setObject(1, idAct);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T1.DateSchetFakt, T1.idSchetFakt, T1.BaseDocDate, T1.BaseDocNumber, T1.NumberSchetFakt, T1.docfilename, T1.doctext, T1.datestartsf, T1.dateendsf, T1.created, T1.createdby, T1.modified, T1.modifiedby, T1.state, T1.idregistrydoc, T1.idAkt, T1.idCurrency, T1.idContract FROM leaseschetfakt  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {304};
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
	private LeaseSchetFaktBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.LeaseSchetFaktBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.LeaseSchetFaktBeanFinderObject temp_finderObject = new com.hps.july.persistence.LeaseSchetFaktBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
