package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPLeaseMutualActNewBean_c0a2cc67
 */
public class EJSJDBCPersisterCMPLeaseMutualActNewBean_c0a2cc67 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderLeaseMutualActNewBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO leasedocuments (leasedocument, createdby, modifiedby, docdate, docnumber, modified, created, operator, regionid, doctype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO leasemutualacts (leasedocument, actstate, actenddate, actstartdate, isSchetFakt, header, footer, istemp, actfilename, mutualnds, mutualreglament) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM leasemutualacts  WHERE leasedocument = ?", "DELETE FROM leasedocuments  WHERE leasedocument = ?"};
	private static final String[] _storeString = {"UPDATE leasemutualacts  SET actstate = ?, actenddate = ?, actstartdate = ?, isSchetFakt = ?, header = ?, footer = ?, istemp = ?, actfilename = ?, mutualnds = ?, mutualreglament = ? WHERE leasedocument = ?", "UPDATE leasedocuments  SET createdby = ?, modifiedby = ?, docdate = ?, docnumber = ?, modified = ?, created = ?, operator = ?, regionid = ?, doctype = ? WHERE leasedocument = ?"};
	private static final String _loadString = "SELECT T1.createdby, T1.modifiedby, T1.docdate, T1.docnumber, T1.leasedocument, T1.modified, T1.created, T1.operator, T1.regionid, T1.doctype, T2.actstate, T2.actenddate, T2.actstartdate, T2.isSchetFakt, T2.header, T2.footer, T2.istemp, T2.actfilename, T2.mutualnds, T2.mutualreglament FROM leasemutualacts  T2, leasedocuments  T1 WHERE T1.doctype = \'M\' AND T1.leasedocument = T2.leasedocument AND T1.leasedocument = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPLeaseMutualActNewBean_c0a2cc67
	 */
	public EJSJDBCPersisterCMPLeaseMutualActNewBean_c0a2cc67() throws java.rmi.RemoteException {
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
		LeaseMutualActNewBean b = (LeaseMutualActNewBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString[0]);
		try {
			if (b.createdby == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.createdby.intValue());
			}
			if (b.modifiedby == null) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, b.modifiedby.intValue());
			}
			if (b.documentDate == null) {
				pstmt.setNull(4, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(4, b.documentDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.documentNumber);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			pstmt.setInt(1, b.leaseDocument);
			if (b.modified == null) {
				pstmt.setNull(6, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(6, b.modified);
			}
			if (b.created == null) {
				pstmt.setNull(7, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(7, b.created);
			}
			if (b.operator == null) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(8, b.operator.intValue());
			}
			pstmt.setInt(9, b.regionid);
			pstmt.setString(10, "M");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.actState);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.actenddate == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.actenddate);
			}
			if (b.actstartdate == null) {
				pstmt.setNull(4, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(4, b.actstartdate);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isSchetFakt);
			if (objectTemp == null) {
				pstmt.setNull(5, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(5, (java.lang.String)objectTemp);
			}
			if (b.header == null) {
				pstmt.setNull(6, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(6, b.header);
			}
			if (b.footer == null) {
				pstmt.setNull(7, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(7, b.footer);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.istemp));
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.actfilename);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.mutualNDS);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			if (b.leaseMutualReglament_leaseDocument == null) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(11, b.leaseMutualReglament_leaseDocument.intValue());
			}
			pstmt.setInt(1, b.leaseDocument);
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
		LeaseMutualActNewBean b = (LeaseMutualActNewBean) eb;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = (com.hps.july.persistence.LeaseDocumentKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.leaseDocument = _primaryKey.leaseDocument;
		b.actState = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(11));
		b.actenddate = resultSet.getDate(12);
		b.actstartdate = resultSet.getDate(13);
		b.isSchetFakt = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(14));
		b.header = resultSet.getString(15);
		b.footer = resultSet.getString(16);
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(17));
		b.istemp = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.actfilename = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(18));
		b.mutualNDS = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(19));
		tempint = resultSet.getInt(20);
		b.leaseMutualReglament_leaseDocument = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(1);
		b.createdby = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(2);
		b.modifiedby = resultSet.wasNull() ? null : new Integer(tempint);
		b.documentDate = resultSet.getDate(3);
		b.documentNumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(4));
		b.modified = resultSet.getTimestamp(6);
		b.created = resultSet.getTimestamp(7);
		tempint = resultSet.getInt(8);
		b.operator = resultSet.wasNull() ? null : new Integer(tempint);
		b.regionid = resultSet.getInt(9);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		LeaseMutualActNewBean b = (LeaseMutualActNewBean) eb;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = (com.hps.july.persistence.LeaseDocumentKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.leaseDocument);
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
		LeaseMutualActNewBean b = (LeaseMutualActNewBean) eb;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = new com.hps.july.persistence.LeaseDocumentKey();
		_primaryKey.leaseDocument = b.leaseDocument;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		LeaseMutualActNewBean b = (LeaseMutualActNewBean) eb;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = new com.hps.july.persistence.LeaseDocumentKey();
		_primaryKey.leaseDocument = b.leaseDocument;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(11, _primaryKey.leaseDocument);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.actState);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			if (b.actenddate == null) {
				pstmt.setNull(2, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(2, b.actenddate);
			}
			if (b.actstartdate == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.actstartdate);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.isSchetFakt);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.header == null) {
				pstmt.setNull(5, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(5, b.header);
			}
			if (b.footer == null) {
				pstmt.setNull(6, java.sql.Types.VARCHAR);
			}
			else {
				pstmt.setString(6, b.footer);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.istemp));
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.actfilename);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.mutualNDS);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			if (b.leaseMutualReglament_leaseDocument == null) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(10, b.leaseMutualReglament_leaseDocument.intValue());
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_storeString[1]);
		try {
			pstmt.setInt(10, _primaryKey.leaseDocument);
			if (b.createdby == null) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(1, b.createdby.intValue());
			}
			if (b.modifiedby == null) {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(2, b.modifiedby.intValue());
			}
			if (b.documentDate == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.documentDate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.documentNumber);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.modified == null) {
				pstmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(5, b.modified);
			}
			if (b.created == null) {
				pstmt.setNull(6, java.sql.Types.TIMESTAMP);
			}
			else {
				pstmt.setTimestamp(6, b.created);
			}
			if (b.operator == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.operator.intValue());
			}
			pstmt.setInt(8, b.regionid);
			pstmt.setString(9, "M");
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
		LeaseMutualActNewBean b = (LeaseMutualActNewBean) eb;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = new com.hps.july.persistence.LeaseDocumentKey();
		_primaryKey.leaseDocument = b.leaseDocument;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString[0]);
		try {
			pstmt.setInt(1, _primaryKey.leaseDocument);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_removeString[1]);
		try {
			pstmt.setInt(1, _primaryKey.leaseDocument);
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
		com.hps.july.persistence.LeaseDocumentKey key = new com.hps.july.persistence.LeaseDocumentKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.leaseDocument = resultSet.getInt(5);
			return key;
		}
return null;
	}
	/**
	 * getBean
	 */
	public javax.ejb.EJBObject getBean(Object obj) throws Exception {
		javax.ejb.EJBObject bean = null;
		ResultSet rs = (ResultSet) obj;
		java.lang.String discriminator = rs.getString(10).trim();
		if ( discriminator.equals("M") ) {
			bean = super.getBean(obj);
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
	 * findLeaseMutualActNewByLeaseMutualReglament
	 */
	public EJSFinder findLeaseMutualActNewByLeaseMutualReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.createdby, T1.modifiedby, T1.docdate, T1.docnumber, T1.leasedocument, T1.modified, T1.created, T1.operator, T1.regionid, T1.doctype, T2.actstate, T2.actenddate, T2.actstartdate, T2.isSchetFakt, T2.header, T2.footer, T2.istemp, T2.actfilename, T2.mutualnds, T2.mutualreglament FROM leasemutualacts  T2, leasedocuments  T1 WHERE T1.doctype = \'M\' AND T1.leasedocument = T2.leasedocument AND T2.mutualreglament = ?");
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
	public com.hps.july.persistence.LeaseMutualActNew findByPrimaryKey(com.hps.july.persistence.LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.LeaseMutualActNew result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.LeaseDocumentKey _primaryKey = (com.hps.july.persistence.LeaseDocumentKey)key;
		try {
			try {
				result = (com.hps.july.persistence.LeaseMutualActNew)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.leaseDocument);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.LeaseMutualActNew)tmpFinder.nextElement();
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
	 * findByQBE
	 */
	public EJSFinder findByQBE(java.lang.Boolean isMutualReglament, java.lang.Integer mutualReglament, java.lang.Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE(isMutualReglament, mutualReglament, isDate, fromDate, toDate, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findByQBE2
	 */
	public EJSFinder findByQBE2(java.lang.Integer mutualReglament, java.lang.Boolean isEdit, java.lang.Boolean isRun, java.lang.Boolean isClose, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findByQBE2(mutualReglament, isEdit, isRun, isClose, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	private static final String genericFindSqlString = "SELECT T1.createdby, T1.modifiedby, T1.docdate, T1.docnumber, T1.leasedocument, T1.modified, T1.created, T1.operator, T1.regionid, T1.doctype, T2.actstate, T2.actenddate, T2.actstartdate, T2.isSchetFakt, T2.header, T2.footer, T2.istemp, T2.actfilename, T2.mutualnds, T2.mutualreglament FROM leasemutualacts  T2, leasedocuments  T1 WHERE T1.doctype = \'M\' AND T1.leasedocument = T2.leasedocument AND ";
	private static final int[] genericFindInsertPoints = {398};
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
	private LeaseMutualActNewBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.LeaseMutualActNewBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.LeaseMutualActNewBeanFinderObject temp_finderObject = new com.hps.july.persistence.LeaseMutualActNewBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}
