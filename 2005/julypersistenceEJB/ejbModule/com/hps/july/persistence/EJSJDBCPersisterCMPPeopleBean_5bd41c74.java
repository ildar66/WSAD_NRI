package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPPeopleBean_5bd41c74
 */
public class EJSJDBCPersisterCMPPeopleBean_5bd41c74 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderPeopleBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String _createString = "INSERT INTO people (man, firstname, lastname, passportser, middlename, passportdate, passportwhom, isActive) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM people  WHERE man = ?";
	private static final String _storeString = "UPDATE people  SET firstname = ?, lastname = ?, passportser = ?, middlename = ?, passportdate = ?, passportwhom = ?, isActive = ? WHERE man = ?";
	private static final String _loadString = "SELECT T1.firstname, T1.lastname, T1.passportser, T1.middlename, T1.man, T1.passportdate, T1.passportwhom, T1.isActive FROM people  T1 WHERE T1.man = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPPeopleBean_5bd41c74
	 */
	public EJSJDBCPersisterCMPPeopleBean_5bd41c74() throws java.rmi.RemoteException {
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
		PeopleBean b = (PeopleBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.firstname);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.lastname);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.passportser);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.middlename);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			pstmt.setInt(1, b.man);
			if (b.passportDate == null) {
				pstmt.setNull(6, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(6, b.passportDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.passportWhom);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isActive);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * hydrate
	 */
	public void hydrate(EntityBean eb, Object data, Object pKey) throws Exception {
		Object objectTemp = null;
		PeopleBean b = (PeopleBean) eb;
		com.hps.july.persistence.PeopleKey _primaryKey = (com.hps.july.persistence.PeopleKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		b.man = _primaryKey.man;
		b.firstname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		b.lastname = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(2));
		b.passportser = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		b.middlename = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.passportDate = resultSet.getDate(6);
		b.passportWhom = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(7));
		b.isActive = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(8));
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		PeopleBean b = (PeopleBean) eb;
		com.hps.july.persistence.PeopleKey _primaryKey = (com.hps.july.persistence.PeopleKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = (forUpdate) ?
			getPreparedStatement(_loadForUpdateString):
			getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.man);
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
		PeopleBean b = (PeopleBean) eb;
		com.hps.july.persistence.PeopleKey _primaryKey = new com.hps.july.persistence.PeopleKey();
		_primaryKey.man = b.man;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		PeopleBean b = (PeopleBean) eb;
		com.hps.july.persistence.PeopleKey _primaryKey = new com.hps.july.persistence.PeopleKey();
		_primaryKey.man = b.man;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString);
		try {
			pstmt.setInt(8, _primaryKey.man);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.firstname);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.lastname);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.passportser);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.middlename);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.passportDate == null) {
				pstmt.setNull(5, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(5, b.passportDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.passportWhom);
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isActive);
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			pstmt.executeUpdate();
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
		PeopleBean b = (PeopleBean) eb;
		com.hps.july.persistence.PeopleKey _primaryKey = new com.hps.july.persistence.PeopleKey();
		_primaryKey.man = b.man;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString);
		try {
			pstmt.setInt(1, _primaryKey.man);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
	}
	/**
	 * getPrimaryKey
	 */
	public Object getPrimaryKey(Object data) throws Exception {
		com.hps.july.persistence.PeopleKey key = new com.hps.july.persistence.PeopleKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.man = resultSet.getInt(5);
			return key;
		}
return null;
	}
	/**
	 * findMaxKeyValue
	 */
	public EJSFinder findMaxKeyValue() throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.firstname, T1.lastname, T1.passportser, T1.middlename, T1.man, T1.passportdate, T1.passportwhom, T1.isActive FROM people  T1 WHERE man = (select max(man) from people)");
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findWorkerByLastNameOrderByLastNameAsc
	 */
	public EJSFinder findWorkerByLastNameOrderByLastNameAsc(java.lang.String name) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.firstname, T1.lastname, T1.passportser, T1.middlename, T1.man, T1.passportdate, T1.passportwhom, T1.isActive FROM people  T1 WHERE upper(t1.lastname) matches upper(?) and exists (select w.worker from workers w where w.man=t1.man)  and isActive = \'Y\' order by t1.lastname asc");
			if (name == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, name);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByNameOrderByNameDesc
	 */
	public EJSFinder findByNameOrderByNameDesc(java.lang.String name) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.firstname, T1.lastname, T1.passportser, T1.middlename, T1.man, T1.passportdate, T1.passportwhom, T1.isActive FROM people  T1 WHERE upper(lastname) matches upper(?)  and isActive = \'Y\' order by lastname desc");
			if (name == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, name);
			}
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
	public com.hps.july.persistence.People findByPrimaryKey(com.hps.july.persistence.PeopleKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.People) home.activateBean(key);
	}
	/**
	 * findByQBE
	 */
	public EJSFinder findByQBE(java.lang.Boolean isLastName, java.lang.String lastName, java.lang.Integer argConnected, java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(isLastName, lastName, argConnected, isIsActive, isActive, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByConnectedOrderByNameAsc
	 */
	public EJSFinder findByConnectedOrderByNameAsc(java.lang.Integer argConnected) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByConnectedOrderByNameAsc(argConnected);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByNameOrderByNameAsc
	 */
	public EJSFinder findByNameOrderByNameAsc(java.lang.String name) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.firstname, T1.lastname, T1.passportser, T1.middlename, T1.man, T1.passportdate, T1.passportwhom, T1.isActive FROM people  T1 WHERE upper(lastname) matches upper(?)  and isActive = \'Y\' order by lastname asc");
			if (name == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, name);
			}
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T1.firstname, T1.lastname, T1.passportser, T1.middlename, T1.man, T1.passportdate, T1.passportwhom, T1.isActive FROM people  T1 WHERE ";
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
	private PeopleBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.PeopleBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.PeopleBeanFinderObject temp_finderObject = new com.hps.july.persistence.PeopleBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
