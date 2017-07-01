package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPSiteDocFileBean_3813d797
 */
public class EJSJDBCPersisterCMPSiteDocFileBean_3813d797 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderSiteDocFileBean {
	private static final String _createString = "INSERT INTO sitedocfiles (sitedocfile, sitedocfilename, note, sitedocfiledate, file_size, file_created, file_modified, sitedoc) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM sitedocfiles  WHERE sitedocfile = ?";
	private static final String _storeString = "UPDATE sitedocfiles  SET sitedocfilename = ?, note = ?, sitedocfiledate = ?, file_size = ?, file_created = ?, file_modified = ?, sitedoc = ? WHERE sitedocfile = ?";
	private static final String _loadString = "SELECT T1.sitedocfile, T1.sitedocfilename, T1.note, T1.sitedocfiledate, T1.file_size, T1.file_created, T1.file_modified, T1.sitedoc FROM sitedocfiles  T1 WHERE T1.sitedocfile = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"sitedocfilename", "note", "sitedocfiledate", "file_size", "file_created", "file_modified", "sitedoc"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPSiteDocFileBean_3813d797
	 */
	public EJSJDBCPersisterCMPSiteDocFileBean_3813d797() throws java.rmi.RemoteException {
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
		SiteDocFileBean b = (SiteDocFileBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[7];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.sitedocfile);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.sitedocfilename);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			if (b.note == null) {
				pstmt.setNull(3, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(3, b.note);
			}
			cacheData[1] = b.note;
			if (b.sitedocfiledate == null) {
				pstmt.setNull(4, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(4, b.sitedocfiledate);
			}
			cacheData[2] = b.sitedocfiledate;
			if (b.filesize == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.filesize.intValue());
			}
			cacheData[3] = b.filesize;
			if (b.filecreated == null) {
				pstmt.setNull(6, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(6, b.filecreated);
			}
			cacheData[4] = b.filecreated;
			if (b.filemodified == null) {
				pstmt.setNull(7, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(7, b.filemodified);
			}
			cacheData[5] = b.filemodified;
			if (b.siteDoc_sitedoc == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.siteDoc_sitedoc.intValue());
			}
			cacheData[6] = b.siteDoc_sitedoc;
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
		SiteDocFileBean b = (SiteDocFileBean) eb;
		com.hps.july.persistence.SiteDocFileKey _primaryKey = (com.hps.july.persistence.SiteDocFileKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.sitedocfile = _primaryKey.sitedocfile;
		b.sitedocfilename = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.note = resultSet.getString(3);
		b.sitedocfiledate = resultSet.getDate(4);
		tempint = resultSet.getInt(5);
		b.filesize = resultSet.wasNull() ? null : new Integer(tempint);
		b.filecreated = resultSet.getTimestamp(6);
		b.filemodified = resultSet.getTimestamp(7);
		tempint = resultSet.getInt(8);
		b.siteDoc_sitedoc = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[7];
		cacheData[0] = resultSet.getString(2);
		cacheData[1] = resultSet.getString(3);
		cacheData[2] = resultSet.getDate(4);
		tempint = resultSet.getInt(5);
		cacheData[3] = resultSet.wasNull() ? null : new Integer(tempint);
		cacheData[4] = resultSet.getTimestamp(6);
		cacheData[5] = resultSet.getTimestamp(7);
		tempint = resultSet.getInt(8);
		cacheData[6] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		SiteDocFileBean b = (SiteDocFileBean) eb;
		com.hps.july.persistence.SiteDocFileKey _primaryKey = (com.hps.july.persistence.SiteDocFileKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.sitedocfile);
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
		SiteDocFileBean b = (SiteDocFileBean) eb;
		com.hps.july.persistence.SiteDocFileKey _primaryKey = new com.hps.july.persistence.SiteDocFileKey();
		_primaryKey.sitedocfile = b.sitedocfile;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		SiteDocFileBean b = (SiteDocFileBean) eb;
		com.hps.july.persistence.SiteDocFileKey _primaryKey = new com.hps.july.persistence.SiteDocFileKey();
		_primaryKey.sitedocfile = b.sitedocfile;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(8, _primaryKey.sitedocfile);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.sitedocfilename);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.note == null) {
				pstmt.setNull(2, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(2, b.note);
			}
			if (b.sitedocfiledate == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.sitedocfiledate);
			}
			if (b.filesize == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.filesize.intValue());
			}
			if (b.filecreated == null) {
				pstmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(5, b.filecreated);
			}
			if (b.filemodified == null) {
				pstmt.setNull(6, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(6, b.filemodified);
			}
			if (b.siteDoc_sitedoc == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.siteDoc_sitedoc.intValue());
			}
			int inputPos = 8;
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
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
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
		SiteDocFileBean b = (SiteDocFileBean) eb;
		com.hps.july.persistence.SiteDocFileKey _primaryKey = new com.hps.july.persistence.SiteDocFileKey();
		_primaryKey.sitedocfile = b.sitedocfile;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.sitedocfile);
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
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[4]);
			}
			if (cacheData[5] != null) {
				pstmt.setTimestamp(++inputPos, (java.sql.Timestamp)cacheData[5]);
			}
			if (cacheData[6] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[6]).intValue());
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
		com.hps.july.persistence.SiteDocFileKey key = new com.hps.july.persistence.SiteDocFileKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.sitedocfile = resultSet.getInt(1);
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
	public com.hps.july.persistence.SiteDocFile findByPrimaryKey(com.hps.july.persistence.SiteDocFileKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.SiteDocFile) home.activateBean(key);
	}
	/**
	 * findBySitedocOrderBySitedocAsc
	 */
	public EJSFinder findBySitedocOrderBySitedocAsc(java.lang.Integer siteDoc) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.sitedocfile, T1.sitedocfilename, T1.note, T1.sitedocfiledate, T1.file_size, T1.file_created, T1.file_modified, T1.sitedoc FROM sitedocfiles  T1 WHERE T1.sitedoc = ? order by T1.sitedoc asc");
			pstmt.setObject(1, siteDoc);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findBySitedocOrderBySitedocDesc
	 */
	public EJSFinder findBySitedocOrderBySitedocDesc(java.lang.Integer siteDoc) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.sitedocfile, T1.sitedocfilename, T1.note, T1.sitedocfiledate, T1.file_size, T1.file_created, T1.file_modified, T1.sitedoc FROM sitedocfiles  T1 WHERE T1.sitedoc = ? order by T1.sitedoc desc");
			pstmt.setObject(1, siteDoc);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findSiteDocFilesBySiteDoc
	 */
	public EJSFinder findSiteDocFilesBySiteDoc(com.hps.july.persistence.SiteDocKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.sitedocfile, T1.sitedocfilename, T1.note, T1.sitedocfiledate, T1.file_size, T1.file_created, T1.file_modified, T1.sitedoc FROM sitedocfiles  T1 WHERE T1.sitedoc = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.sitedoc);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findBySitedocsOrderByPKAsc
	 */
	public EJSFinder findBySitedocsOrderByPKAsc(java.lang.Integer siteDoc) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.sitedocfile, T1.sitedocfilename, T1.note, T1.sitedocfiledate, T1.file_size, T1.file_created, T1.file_modified, T1.sitedoc FROM sitedocfiles  T1 WHERE T1.sitedoc = ? order by T1.sitedocfile asc");
			pstmt.setObject(1, siteDoc);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findBySitedocsOrderByPKDesc
	 */
	public EJSFinder findBySitedocsOrderByPKDesc(java.lang.Integer siteDoc) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.sitedocfile, T1.sitedocfilename, T1.note, T1.sitedocfiledate, T1.file_size, T1.file_created, T1.file_modified, T1.sitedoc FROM sitedocfiles  T1 WHERE T1.sitedoc = ? order by T1.sitedocfile desc");
			pstmt.setObject(1, siteDoc);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
