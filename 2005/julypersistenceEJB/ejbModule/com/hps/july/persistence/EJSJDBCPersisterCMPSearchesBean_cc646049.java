package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPSearchesBean_cc646049
 */
public class EJSJDBCPersisterCMPSearchesBean_cc646049 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderSearchesBean {
	private static final String _createString = "INSERT INTO searches (searchgroup, organization, order, searchgroupping) VALUES (?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM searches  WHERE searchgroup = ? AND organization = ?";
	private static final String _storeString = "UPDATE searches  SET order = ?, searchgroupping = ? WHERE searchgroup = ? AND organization = ?";
	private static final String _loadString = "SELECT T1.order, T1.searchgroup, T1.searchgroupping, T1.organization FROM searches  T1 WHERE T1.searchgroup = ? AND T1.organization = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"order", "searchgroupping"};
	private static final boolean[] _predicateMaps = {true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPSearchesBean_cc646049
	 */
	public EJSJDBCPersisterCMPSearchesBean_cc646049() throws java.rmi.RemoteException {
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
		SearchesBean b = (SearchesBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[2];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(3, b.order);
			cacheData[0] = new Integer(b.order);
			if (b.group_searchgroup == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.group_searchgroup.intValue());
			}
			if (b.groupping_searchGroupping == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.groupping_searchGroupping.intValue());
			}
			cacheData[1] = b.groupping_searchGroupping;
			if (b.organization_organization == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.organization_organization.intValue());
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
		SearchesBean b = (SearchesBean) eb;
		com.hps.july.persistence.SearchesKey _primaryKey = (com.hps.july.persistence.SearchesKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.group_searchgroup = _primaryKey.group_searchgroup;
		b.organization_organization = _primaryKey.organization_organization;
		b.order = resultSet.getInt(1);
		tempint = resultSet.getInt(2);
		b.group_searchgroup = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(3);
		b.groupping_searchGroupping = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(4);
		b.organization_organization = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[2];
		tempint = resultSet.getInt(1);
		cacheData[0] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(3);
		cacheData[1] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		SearchesBean b = (SearchesBean) eb;
		com.hps.july.persistence.SearchesKey _primaryKey = (com.hps.july.persistence.SearchesKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			if (_primaryKey.group_searchgroup == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.group_searchgroup.intValue());
			}
			if (_primaryKey.organization_organization == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.organization_organization.intValue());
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
		SearchesBean b = (SearchesBean) eb;
		com.hps.july.persistence.SearchesKey _primaryKey = new com.hps.july.persistence.SearchesKey();
		_primaryKey.group_searchgroup = b.group_searchgroup;
		_primaryKey.organization_organization = b.organization_organization;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		SearchesBean b = (SearchesBean) eb;
		com.hps.july.persistence.SearchesKey _primaryKey = new com.hps.july.persistence.SearchesKey();
		_primaryKey.group_searchgroup = b.group_searchgroup;
		_primaryKey.organization_organization = b.organization_organization;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.group_searchgroup == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, _primaryKey.group_searchgroup.intValue());
			}
			if (_primaryKey.organization_organization == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, _primaryKey.organization_organization.intValue());
			}
			pstmt.setInt(1, b.order);
			if (b.group_searchgroup == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.group_searchgroup.intValue());
			}
			if (b.groupping_searchGroupping == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.groupping_searchGroupping.intValue());
			}
			if (b.organization_organization == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.organization_organization.intValue());
			}
			int inputPos = 4;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
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
		SearchesBean b = (SearchesBean) eb;
		com.hps.july.persistence.SearchesKey _primaryKey = new com.hps.july.persistence.SearchesKey();
		_primaryKey.group_searchgroup = b.group_searchgroup;
		_primaryKey.organization_organization = b.organization_organization;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			if (_primaryKey.group_searchgroup == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, _primaryKey.group_searchgroup.intValue());
			}
			if (_primaryKey.organization_organization == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, _primaryKey.organization_organization.intValue());
			}
			int inputPos = 2;
			if (cacheData[0] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[0]).intValue());
			}
			if (cacheData[1] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[1]).intValue());
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
		com.hps.july.persistence.SearchesKey key = new com.hps.july.persistence.SearchesKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			int tempint;

			tempint = resultSet.getInt(2);
			key.group_searchgroup = resultSet.wasNull() ? null : new Integer(tempint);
			tempint = resultSet.getInt(4);
			key.organization_organization = resultSet.wasNull() ? null : new Integer(tempint);
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
	 * findSearchesByOrganization
	 */
	public EJSFinder findSearchesByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.order, T1.searchgroup, T1.searchgroupping, T1.organization FROM searches  T1 WHERE T1.organization = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.organization);
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
	public com.hps.july.persistence.Searches findByPrimaryKey(com.hps.july.persistence.SearchesKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.Searches) home.activateBean(key);
	}
	/**
	 * findSearchesByGroupping
	 */
	public EJSFinder findSearchesByGroupping(com.hps.july.persistence.SearchGrouppingKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.order, T1.searchgroup, T1.searchgroupping, T1.organization FROM searches  T1 WHERE T1.searchgroupping = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.searchGroupping);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findSearchesByGroup
	 */
	public EJSFinder findSearchesByGroup(com.hps.july.persistence.SearchGroupKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.order, T1.searchgroup, T1.searchgroupping, T1.organization FROM searches  T1 WHERE T1.searchgroup = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.searchgroup);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
}
