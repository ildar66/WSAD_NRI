package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPSiteDocBean_92b2e4e2
 */
public class EJSJDBCPersisterCMPSiteDocBean_92b2e4e2 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderSiteDocBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO sitedocs (sitedoc, blanknumber, blankdate, expiredate, comment, projectaction, sitedoctype, man) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM sitedocs  WHERE sitedoc = ?";
	private static final String _storeString = "UPDATE sitedocs  SET blanknumber = ?, blankdate = ?, expiredate = ?, comment = ?, projectaction = ?, sitedoctype = ?, man = ? WHERE sitedoc = ?";
	private static final String _loadString = "SELECT T1.blanknumber, T1.sitedoc, T1.blankdate, T1.expiredate, T1.comment, T1.projectaction, T1.sitedoctype, T1.man FROM sitedocs  T1 WHERE T1.sitedoc = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"blanknumber", "blankdate", "expiredate", "comment", "projectaction", "sitedoctype", "man"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPSiteDocBean_92b2e4e2
	 */
	public EJSJDBCPersisterCMPSiteDocBean_92b2e4e2() throws java.rmi.RemoteException {
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
		SiteDocBean b = (SiteDocBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[7];
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.blanknumber);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			pstmt.setInt(1, b.sitedoc);
			if (b.blankdate == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.blankdate);
			}
			cacheData[1] = b.blankdate;
			if (b.expiredate == null) {
				pstmt.setNull(4, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(4, b.expiredate);
			}
			cacheData[2] = b.expiredate;
			if (b.comment == null) {
				pstmt.setNull(5, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(5, b.comment);
			}
			cacheData[3] = b.comment;
			if (b.projectAction_projectaction == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.projectAction_projectaction.intValue());
			}
			cacheData[4] = b.projectAction_projectaction;
			if (b.siteDocType_sitedoctype == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.siteDocType_sitedoctype.intValue());
			}
			cacheData[5] = b.siteDocType_sitedoctype;
			if (b.man_man == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.man_man.intValue());
			}
			cacheData[6] = b.man_man;
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
		SiteDocBean b = (SiteDocBean) eb;
		com.hps.july.persistence.SiteDocKey _primaryKey = (com.hps.july.persistence.SiteDocKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.sitedoc = _primaryKey.sitedoc;
		b.blanknumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		b.blankdate = resultSet.getDate(3);
		b.expiredate = resultSet.getDate(4);
		b.comment = resultSet.getString(5);
		tempint = resultSet.getInt(6);
		b.projectAction_projectaction = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(7);
		b.siteDocType_sitedoctype = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		b.man_man = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[7];
		cacheData[0] = resultSet.getString(1);
		cacheData[1] = resultSet.getDate(3);
		cacheData[2] = resultSet.getDate(4);
		cacheData[3] = resultSet.getString(5);
		tempint = resultSet.getInt(6);
		cacheData[4] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(7);
		cacheData[5] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(8);
		cacheData[6] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		SiteDocBean b = (SiteDocBean) eb;
		com.hps.july.persistence.SiteDocKey _primaryKey = (com.hps.july.persistence.SiteDocKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.sitedoc);
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
		SiteDocBean b = (SiteDocBean) eb;
		com.hps.july.persistence.SiteDocKey _primaryKey = new com.hps.july.persistence.SiteDocKey();
		_primaryKey.sitedoc = b.sitedoc;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		SiteDocBean b = (SiteDocBean) eb;
		com.hps.july.persistence.SiteDocKey _primaryKey = new com.hps.july.persistence.SiteDocKey();
		_primaryKey.sitedoc = b.sitedoc;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(8, _primaryKey.sitedoc);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.blanknumber);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.blankdate == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, b.blankdate);
			}
			if (b.expiredate == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.expiredate);
			}
			if (b.comment == null) {
				pstmt.setNull(4, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(4, b.comment);
			}
			if (b.projectAction_projectaction == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.projectAction_projectaction.intValue());
			}
			if (b.siteDocType_sitedoctype == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.siteDocType_sitedoctype.intValue());
			}
			if (b.man_man == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.man_man.intValue());
			}
			int inputPos = 8;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
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
		SiteDocBean b = (SiteDocBean) eb;
		com.hps.july.persistence.SiteDocKey _primaryKey = new com.hps.july.persistence.SiteDocKey();
		_primaryKey.sitedoc = b.sitedoc;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.sitedoc);
			int inputPos = 1;
			if (cacheData[0] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[0]);
			}
			if (cacheData[1] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[1]);
			}
			if (cacheData[2] != null) {
				pstmt.setDate(++inputPos, (java.sql.Date)cacheData[2]);
			}
			if (cacheData[3] != null) {
				pstmt.setString(++inputPos, (java.lang.String)cacheData[3]);
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
		com.hps.july.persistence.SiteDocKey key = new com.hps.july.persistence.SiteDocKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.sitedoc = resultSet.getInt(2);
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
	 * findSiteDocsBySiteDocType
	 */
	public EJSFinder findSiteDocsBySiteDocType(com.hps.july.persistence.SiteDocTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.blanknumber, T1.sitedoc, T1.blankdate, T1.expiredate, T1.comment, T1.projectaction, T1.sitedoctype, T1.man FROM sitedocs  T1 WHERE T1.sitedoctype = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.sitedoctype);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByPosition
	 */
	public EJSFinder findByPosition(java.lang.Integer position, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByPosition(position, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByProjectactions_Project
	 */
	public EJSFinder findByProjectactions_Project(java.lang.Integer project) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.blanknumber, T1.sitedoc, T1.blankdate, T1.expiredate, T1.comment, T1.projectaction, T1.sitedoctype, T1.man FROM sitedocs  T1 WHERE  projectaction in(select projectaction from projectactions where project = ?)");
			pstmt.setObject(1, project);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByProjectaction
	 */
	public EJSFinder findByProjectaction(java.lang.Integer projectaction) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.blanknumber, T1.sitedoc, T1.blankdate, T1.expiredate, T1.comment, T1.projectaction, T1.sitedoctype, T1.man FROM sitedocs  T1 WHERE  projectaction = ? ");
			pstmt.setObject(1, projectaction);
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
	public com.hps.july.persistence.SiteDoc findByPrimaryKey(com.hps.july.persistence.SiteDocKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.SiteDoc) home.activateBean(key);
	}
	/**
	 * findByEquipment
	 */
	public EJSFinder findByEquipment(java.lang.Integer position, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByEquipment(position, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByHop
	 */
	public EJSFinder findByHop(java.lang.Integer hopid, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByHop(hopid, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findSiteDocsByMan
	 */
	public EJSFinder findSiteDocsByMan(com.hps.july.persistence.PeopleKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.blanknumber, T1.sitedoc, T1.blankdate, T1.expiredate, T1.comment, T1.projectaction, T1.sitedoctype, T1.man FROM sitedocs  T1 WHERE T1.man = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.man);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findSiteDocsByProjectAction
	 */
	public EJSFinder findSiteDocsByProjectAction(com.hps.july.persistence.ProjectActionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.blanknumber, T1.sitedoc, T1.blankdate, T1.expiredate, T1.comment, T1.projectaction, T1.sitedoctype, T1.man FROM sitedocs  T1 WHERE T1.projectaction = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.projectaction);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T1.blanknumber, T1.sitedoc, T1.blankdate, T1.expiredate, T1.comment, T1.projectaction, T1.sitedoctype, T1.man FROM sitedocs  T1 WHERE ";
	private static final int[] genericFindInsertPoints = {141};
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
	private SiteDocBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.SiteDocBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.SiteDocBeanFinderObject temp_finderObject = new com.hps.july.persistence.SiteDocBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
