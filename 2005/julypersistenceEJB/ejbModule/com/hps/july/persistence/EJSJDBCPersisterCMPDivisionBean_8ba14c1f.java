package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPDivisionBean_8ba14c1f
 */
public class EJSJDBCPersisterCMPDivisionBean_8ba14c1f extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderDivisionBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO divisions (division, name, shortname, isactive, boss, company, encloser, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM divisions  WHERE division = ?";
	private static final String _storeString = "UPDATE divisions  SET name = ?, shortname = ?, isactive = ?, boss = ?, company = ?, encloser = ?, type = ? WHERE division = ?";
	private static final String _loadString = "SELECT T1.division, T1.name, T1.shortname, T1.isactive, T1.boss, T1.company, T1.encloser, T1.type FROM divisions  T1 WHERE T1.type IN (\'D\', \'P\', \'Q\', \'G\', \'S\') AND T1.division = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private static final String[] _predicateColumnNames = {"name", "shortname", "isactive", "boss", "company", "encloser"};
	private static final boolean[] _predicateMaps = {true, true, true, true, true, true};
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPDivisionBean_8ba14c1f
	 */
	public EJSJDBCPersisterCMPDivisionBean_8ba14c1f() throws java.rmi.RemoteException {
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
		DivisionBean b = (DivisionBean) eb;
		PreparedStatement pstmt;
		Object cacheData[] = new Object[6];
		pstmt = getPreparedStatement(_createString);
		try {
			pstmt.setInt(1, b.division);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			cacheData[0] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.shortname);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			cacheData[1] = objectTemp;
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isactive);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			cacheData[2] = objectTemp;
			if (b.boss_worker == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.boss_worker.intValue());
			}
			cacheData[3] = b.boss_worker;
			if (b.company_company == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.company_company.intValue());
			}
			cacheData[4] = b.company_company;
			if (b.parent_division == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.parent_division.intValue());
			}
			cacheData[5] = b.parent_division;
			pstmt.setString(8, "Q");
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
		DivisionBean b = (DivisionBean) eb;
		com.hps.july.persistence.DivisionKey _primaryKey = (com.hps.july.persistence.DivisionKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.division = _primaryKey.division;
		b.name = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.shortname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.isactive = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(4));
		tempint = resultSet.getInt(5);
		b.boss_worker = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(6);
		b.company_company = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(7);
		b.parent_division = resultSet.wasNull() ? null : new Integer(tempint);
		Object[] cacheData = new Object[6];
		cacheData[0] = resultSet.getString(2);
		cacheData[1] = resultSet.getString(3);
		cacheData[2] = resultSet.getString(4);
		tempint = resultSet.getInt(5);
		cacheData[3] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(6);
		cacheData[4] = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(7);
		cacheData[5] = resultSet.wasNull() ? null : new Integer(tempint);
		putDataIntoCache(cacheData);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		DivisionBean b = (DivisionBean) eb;
		com.hps.july.persistence.DivisionKey _primaryKey = (com.hps.july.persistence.DivisionKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.division);
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
		DivisionBean b = (DivisionBean) eb;
		com.hps.july.persistence.DivisionKey _primaryKey = new com.hps.july.persistence.DivisionKey();
		_primaryKey.division = b.division;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		DivisionBean b = (DivisionBean) eb;
		com.hps.july.persistence.DivisionKey _primaryKey = new com.hps.july.persistence.DivisionKey();
		_primaryKey.division = b.division;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_storeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(8, _primaryKey.division);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.name);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.shortname);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isactive);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.boss_worker == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.boss_worker.intValue());
			}
			if (b.company_company == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.company_company.intValue());
			}
			if (b.parent_division == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.parent_division.intValue());
			}
			pstmt.setString(7, "Q");
			int inputPos = 8;
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
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[4]).intValue());
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
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
		DivisionBean b = (DivisionBean) eb;
		com.hps.july.persistence.DivisionKey _primaryKey = new com.hps.july.persistence.DivisionKey();
		_primaryKey.division = b.division;
		PreparedStatement pstmt;
		Object cacheData[] = getDataFromCache();
		RdbRt  aTemplate = new RdbRt(_removeString, _predicateColumnNames, _predicateMaps);
		pstmt = getPreparedStatement(aTemplate.nativeQuery(cacheData));
		try {
			pstmt.setInt(1, _primaryKey.division);
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
				pstmt.setInt(++inputPos, ((Number)cacheData[3]).intValue());
			}
			if (cacheData[4] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[4]).intValue());
			}
			if (cacheData[5] != null) {
				pstmt.setInt(++inputPos, ((Number)cacheData[5]).intValue());
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
		com.hps.july.persistence.DivisionKey key = new com.hps.july.persistence.DivisionKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.division = resultSet.getInt(1);
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
	 * getBean
	 */
	public javax.ejb.EJBObject getBean(Object obj) throws Exception {
		javax.ejb.EJBObject bean = null;
		ResultSet rs = (ResultSet) obj;
		java.lang.String discriminator = rs.getString(8).trim();
		if ( discriminator.equals("Q") ) {
			bean = super.getBean(obj);
		}
		else {
			String homeName = null;
			if ( discriminator.equals("P") ) {
				homeName = "Department";
			}
			else
			if ( discriminator.equals("D") ) {
				homeName = "Direction";
			}
			else
			if ( discriminator.equals("G") ) {
				homeName = "Group";
			}
			else
			if ( discriminator.equals("S") ) {
				homeName = "Service";
			}
			if (homeName != null) {
				bean = ((com.ibm.ejs.container.EJSHome)home).getBean(homeName, getPrimaryKey(rs), rs);
			}
		}
		if (bean == null) {
			try{
				if (rs != null) rs.close();
			}
			catch (SQLException sqlExc) {}
			throw new EJSPersistenceException("Unknown or superclass discriminator value retrieved from database.");
		}
		return bean;
	}
	/**
	 * findAllByProjectActionTypeOrderByNameAsc
	 */
	public EJSFinder findAllByProjectActionTypeOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.division, T1.name, T1.shortname, T1.isactive, T1.boss, T1.company, T1.encloser, T1.type FROM divisions  T1 WHERE T1.type IN (\'D\', \'P\', \'Q\', \'G\', \'S\') AND  division IN (SELECT p.division FROM projectactiontypes p) order by name asc ");
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findChildsByParent
	 */
	public EJSFinder findChildsByParent(com.hps.july.persistence.DivisionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.division, T1.name, T1.shortname, T1.isactive, T1.boss, T1.company, T1.encloser, T1.type FROM divisions  T1 WHERE T1.type IN (\'D\', \'P\', \'Q\', \'G\', \'S\') AND T1.encloser = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.division);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByParentOrderByNameDesc
	 */
	public EJSFinder findByParentOrderByNameDesc(java.lang.Integer parent) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByParentOrderByNameDesc(parent);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findDivisionsByCompany
	 */
	public EJSFinder findDivisionsByCompany(com.hps.july.persistence.CompanyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.division, T1.name, T1.shortname, T1.isactive, T1.boss, T1.company, T1.encloser, T1.type FROM divisions  T1 WHERE T1.type IN (\'D\', \'P\', \'Q\', \'G\', \'S\') AND T1.company = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.company);
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
	public com.hps.july.persistence.Division findByPrimaryKey(com.hps.july.persistence.DivisionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.Division result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.DivisionKey _primaryKey = (com.hps.july.persistence.DivisionKey)key;
		try {
			try {
				result = (com.hps.july.persistence.Division)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.division);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.Division)tmpFinder.nextElement();
				}
			}
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
		finally {
			if ( tmpFinder != null ) tmpFinder.close();
		}
		if (result == null) {
			throw new javax.ejb.ObjectNotFoundException();
		}
		return result;
	}
	/**
	 * findControlleddivisionsByBoss
	 */
	public EJSFinder findControlleddivisionsByBoss(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.division, T1.name, T1.shortname, T1.isactive, T1.boss, T1.company, T1.encloser, T1.type FROM divisions  T1 WHERE T1.type IN (\'D\', \'P\', \'Q\', \'G\', \'S\') AND T1.boss = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.worker);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByParentOrderByNameAsc
	 */
	public EJSFinder findByParentOrderByNameAsc(java.lang.Integer parent) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByParentOrderByNameAsc(parent);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findAllByProjectCommsByNameAsc
	 */
	public EJSFinder findAllByProjectCommsByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.division, T1.name, T1.shortname, T1.isactive, T1.boss, T1.company, T1.encloser, T1.type FROM divisions  T1 WHERE T1.type IN (\'D\', \'P\', \'Q\', \'G\', \'S\') AND  division IN (SELECT p.division FROM projectactioncomms p) order by name asc");
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByParentCompany
	 */
	public EJSFinder findByParentCompany(java.lang.Integer parent, java.lang.Integer company, java.lang.Boolean isRoot, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByParentCompany(parent, company, isRoot, order);
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
	public EJSFinder findByQBE(java.lang.Boolean isParent, java.lang.Integer parent, java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(isParent, parent, isIsActive, isActive, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findAllByProjectColumnsOrderByNameAsc
	 */
	public EJSFinder findAllByProjectColumnsOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.division, T1.name, T1.shortname, T1.isactive, T1.boss, T1.company, T1.encloser, T1.type FROM divisions  T1 WHERE T1.type IN (\'D\', \'P\', \'Q\', \'G\', \'S\') AND division IN (SELECT p.division FROM projectdivcolumns p) order by name asc");
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T1.division, T1.name, T1.shortname, T1.isactive, T1.boss, T1.company, T1.encloser, T1.type FROM divisions  T1 WHERE T1.type IN (\'D\', \'P\', \'Q\', \'G\', \'S\') AND ";
	private static final int[] genericFindInsertPoints = {164};
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
	private DivisionBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.DivisionBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.DivisionBeanFinderObject temp_finderObject = new com.hps.july.persistence.DivisionBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
