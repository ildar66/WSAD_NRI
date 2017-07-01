package com.hps.july.persistence;

import com.ibm.ejs.persistence.*;
import javax.ejb.EntityBean;
import java.sql.*;

/**
 * EJSJDBCPersisterCMPI13nActBean_90887391
 */
public class EJSJDBCPersisterCMPI13nActBean_90887391 extends EJSJDBCPersister implements com.hps.july.persistence.EJSFinderI13nActBean, com.ibm.vap.finders.VapEJSJDBCRawFinderStatementHelper {
	private static final String[] _createString = {"INSERT INTO documents (document, insuranceact, blankdate, blanknumber, parentdocument, operator, isautodoc, blankindex, processsource, showtouser, state, processdestination, insurancedate, insuranceman, to2, needapprove, projectid, prjstatus, visualtype, owner, to, contragent, from, storagemanager, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "INSERT INTO i13nact (document, recalcagrprice, agregateserial, type, agregateresource, agregate, techstuff) VALUES (?, ?, ?, ?, ?, ?, ?)"};
	private static final String[] _removeString = {"DELETE FROM i13nact  WHERE document = ?", "DELETE FROM documents  WHERE document = ?"};
	private static final String[] _storeString = {"UPDATE i13nact  SET recalcagrprice = ?, agregateserial = ?, type = ?, agregateresource = ?, agregate = ?, techstuff = ? WHERE document = ?", "UPDATE documents  SET insuranceact = ?, blankdate = ?, blanknumber = ?, parentdocument = ?, operator = ?, isautodoc = ?, blankindex = ?, processsource = ?, showtouser = ?, state = ?, processdestination = ?, insurancedate = ?, insuranceman = ?, to2 = ?, needapprove = ?, projectid = ?, prjstatus = ?, visualtype = ?, owner = ?, to = ?, contragent = ?, from = ?, storagemanager = ?, type = ? WHERE document = ?"};
	private static final String _loadString = "SELECT T1.insuranceact, T1.blankdate, T1.blanknumber, T1.parentdocument, T1.operator, T1.isautodoc, T1.blankindex, T1.processsource, T1.showtouser, T1.state, T1.processdestination, T1.insurancedate, T1.insuranceman, T1.to2, T1.document, T1.needapprove, T1.projectid, T1.prjstatus, T1.visualtype, T1.owner, T1.to, T1.contragent, T1.from, T1.storagemanager, T1.type, T2.recalcagrprice, T2.agregateserial, T2.type, T2.agregateresource, T2.agregate, T2.techstuff FROM i13nact  T2, documents  T1 WHERE T1.type = \'I\' AND T1.document = T2.document AND T1.document = ?";
	private static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	private byte[] serObj = null;
	/**
	 * EJSJDBCPersisterCMPI13nActBean_90887391
	 */
	public EJSJDBCPersisterCMPI13nActBean_90887391() throws java.rmi.RemoteException {
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
		I13nActBean b = (I13nActBean) eb;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_createString[0]);
		try {
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.insuranceact);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			if (b.blankdate == null) {
				pstmt.setNull(3, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(3, b.blankdate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.blanknumber);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.parentdocument == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.parentdocument.intValue());
			}
			if (b.operator == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.operator.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.isautodoc));
			if (objectTemp == null) {
				pstmt.setNull(7, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(7, (java.lang.String)objectTemp);
			}
			pstmt.setInt(8, b.blankindex);
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.processSource);
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.showtouser));
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.documentState);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.processDestination);
			if (objectTemp == null) {
				pstmt.setNull(12, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(12, (java.lang.String)objectTemp);
			}
			if (b.insurancedate == null) {
				pstmt.setNull(13, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(13, b.insurancedate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.insuranseMan);
			if (objectTemp == null) {
				pstmt.setNull(14, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(14, (java.lang.String)objectTemp);
			}
			if (b.to2 == null) {
				pstmt.setNull(15, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(15, b.to2.intValue());
			}
			pstmt.setInt(1, b.document);
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.needapprove));
			if (objectTemp == null) {
				pstmt.setNull(16, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(16, (java.lang.String)objectTemp);
			}
			if (b.projectid == null) {
				pstmt.setNull(17, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(17, b.projectid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.prjstatus);
			if (objectTemp == null) {
				pstmt.setNull(18, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(18, (java.lang.String)objectTemp);
			}
			if (b.visualtype == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.visualtype.intValue());
			}
			if (b.owner_organization == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.owner_organization.intValue());
			}
			if (b.to_storageplace == null) {
				pstmt.setNull(21, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(21, b.to_storageplace.intValue());
			}
			if (b.contragent_organization == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.contragent_organization.intValue());
			}
			if (b.from_storageplace == null) {
				pstmt.setNull(23, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(23, b.from_storageplace.intValue());
			}
			if (b.storageManager_worker == null) {
				pstmt.setNull(24, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(24, b.storageManager_worker.intValue());
			}
			pstmt.setString(25, "I");
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_createString[1]);
		try {
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.recalcagrprice);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.agregateserial);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.type);
			if (objectTemp == null) {
				pstmt.setNull(4, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(4, (java.lang.String)objectTemp);
			}
			if (b.agregateresource == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.agregateresource.intValue());
			}
			if (b.agregate_storagecard == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.agregate_storagecard.intValue());
			}
			if (b.techStuff_worker == null) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(7, b.techStuff_worker.intValue());
			}
			pstmt.setInt(1, b.document);
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
		I13nActBean b = (I13nActBean) eb;
		com.hps.july.persistence.DocumentKey _primaryKey = (com.hps.july.persistence.DocumentKey)pKey;
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;
		int tempint;

		b.document = _primaryKey.document;
		b.recalcagrprice = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(26));
		b.agregateserial = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(27));
		b.type = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(28));
		tempint = resultSet.getInt(29);
		b.agregateresource = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(30);
		b.agregate_storagecard = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(31);
		b.techStuff_worker = resultSet.wasNull() ? null : new Integer(tempint);
		b.insuranceact = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(1));
		b.blankdate = resultSet.getDate(2);
		b.blanknumber = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(3));
		tempint = resultSet.getInt(4);
		b.parentdocument = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(5);
		b.operator = resultSet.wasNull() ? null : new Integer(tempint);
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(6));
		b.isautodoc = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.blankindex = resultSet.getInt(7);
		b.processSource = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(8));
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(9));
		b.showtouser = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		b.documentState = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(10));
		b.processDestination = (java.lang.Boolean)com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(11));
		b.insurancedate = resultSet.getDate(12);
		b.insuranseMan = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(13));
		tempint = resultSet.getInt(14);
		b.to2 = resultSet.wasNull() ? null : new Integer(tempint);
		objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().objectFrom(resultSet.getString(16));
		b.needapprove = (objectTemp == null) ? false : ((Boolean)objectTemp).booleanValue();
		tempint = resultSet.getInt(17);
		b.projectid = resultSet.wasNull() ? null : new Integer(tempint);
		b.prjstatus = (java.lang.String)com.ibm.vap.converters.VapTrimStringConverter.singleton().objectFrom(resultSet.getString(18));
		tempint = resultSet.getInt(19);
		b.visualtype = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(20);
		b.owner_organization = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(21);
		b.to_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(22);
		b.contragent_organization = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(23);
		b.from_storageplace = resultSet.wasNull() ? null : new Integer(tempint);
		tempint = resultSet.getInt(24);
		b.storageManager_worker = resultSet.wasNull() ? null : new Integer(tempint);
	}
	/**
	 * load
	 */
	public void load(EntityBean eb, Object pKey, boolean forUpdate) throws Exception {
		Object objectTemp = null;
		I13nActBean b = (I13nActBean) eb;
		com.hps.july.persistence.DocumentKey _primaryKey = (com.hps.july.persistence.DocumentKey)pKey;
		PreparedStatement pstmt;
		ResultSet resultSet = null;
		pstmt = getPreparedStatement(_loadString);
		try {
			pstmt.setInt(1, _primaryKey.document);
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
		I13nActBean b = (I13nActBean) eb;
		com.hps.july.persistence.DocumentKey _primaryKey = new com.hps.july.persistence.DocumentKey();
		_primaryKey.document = b.document;
		load(b, _primaryKey, forUpdate);
	}
	/**
	 * store
	 */
	public void store(EntityBean eb) throws Exception {
		Object objectTemp = null;
		I13nActBean b = (I13nActBean) eb;
		com.hps.july.persistence.DocumentKey _primaryKey = new com.hps.july.persistence.DocumentKey();
		_primaryKey.document = b.document;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_storeString[0]);
		try {
			pstmt.setInt(7, _primaryKey.document);
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.recalcagrprice);
			if (objectTemp == null) {
				pstmt.setNull(1, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(1, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.agregateserial);
			if (objectTemp == null) {
				pstmt.setNull(2, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(2, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.type);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.agregateresource == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.agregateresource.intValue());
			}
			if (b.agregate_storagecard == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.agregate_storagecard.intValue());
			}
			if (b.techStuff_worker == null) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(6, b.techStuff_worker.intValue());
			}
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_storeString[1]);
		try {
			pstmt.setInt(25, _primaryKey.document);
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.insuranceact);
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
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.blanknumber);
			if (objectTemp == null) {
				pstmt.setNull(3, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(3, (java.lang.String)objectTemp);
			}
			if (b.parentdocument == null) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, b.parentdocument.intValue());
			}
			if (b.operator == null) {
				pstmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(5, b.operator.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.isautodoc));
			if (objectTemp == null) {
				pstmt.setNull(6, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(6, (java.lang.String)objectTemp);
			}
			pstmt.setInt(7, b.blankindex);
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.processSource);
			if (objectTemp == null) {
				pstmt.setNull(8, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(8, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.showtouser));
			if (objectTemp == null) {
				pstmt.setNull(9, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(9, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.documentState);
			if (objectTemp == null) {
				pstmt.setNull(10, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(10, (java.lang.String)objectTemp);
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(b.processDestination);
			if (objectTemp == null) {
				pstmt.setNull(11, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(11, (java.lang.String)objectTemp);
			}
			if (b.insurancedate == null) {
				pstmt.setNull(12, java.sql.Types.DATE);
			}
			else {
				pstmt.setDate(12, b.insurancedate);
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.insuranseMan);
			if (objectTemp == null) {
				pstmt.setNull(13, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(13, (java.lang.String)objectTemp);
			}
			if (b.to2 == null) {
				pstmt.setNull(14, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(14, b.to2.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapStringToBooleanConverter.singleton().dataFrom(new Boolean(b.needapprove));
			if (objectTemp == null) {
				pstmt.setNull(15, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(15, (java.lang.String)objectTemp);
			}
			if (b.projectid == null) {
				pstmt.setNull(16, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(16, b.projectid.intValue());
			}
			objectTemp = com.ibm.vap.converters.VapTrimStringConverter.singleton().dataFrom(b.prjstatus);
			if (objectTemp == null) {
				pstmt.setNull(17, java.sql.Types.CHAR);
			}
			else {
				pstmt.setString(17, (java.lang.String)objectTemp);
			}
			if (b.visualtype == null) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(18, b.visualtype.intValue());
			}
			if (b.owner_organization == null) {
				pstmt.setNull(19, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(19, b.owner_organization.intValue());
			}
			if (b.to_storageplace == null) {
				pstmt.setNull(20, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(20, b.to_storageplace.intValue());
			}
			if (b.contragent_organization == null) {
				pstmt.setNull(21, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(21, b.contragent_organization.intValue());
			}
			if (b.from_storageplace == null) {
				pstmt.setNull(22, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(22, b.from_storageplace.intValue());
			}
			if (b.storageManager_worker == null) {
				pstmt.setNull(23, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(23, b.storageManager_worker.intValue());
			}
			pstmt.setString(24, "I");
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
		I13nActBean b = (I13nActBean) eb;
		com.hps.july.persistence.DocumentKey _primaryKey = new com.hps.july.persistence.DocumentKey();
		_primaryKey.document = b.document;
		PreparedStatement pstmt;
		pstmt = getPreparedStatement(_removeString[0]);
		try {
			pstmt.setInt(1, _primaryKey.document);
			pstmt.executeUpdate();
		}
		finally {
			returnPreparedStatement(pstmt);
		}
		pstmt = getPreparedStatement(_removeString[1]);
		try {
			pstmt.setInt(1, _primaryKey.document);
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
		com.hps.july.persistence.DocumentKey key = new com.hps.july.persistence.DocumentKey();
		java.sql.ResultSet resultSet = (java.sql.ResultSet) data;

		if (resultSet != null) {
			Object objectTemp = null;
			key.document = resultSet.getInt(15);
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
		java.lang.String discriminator = rs.getString(25).trim();
		if ( discriminator.equals("I") ) {
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
	 * findI13nActByQBE
	 */
	public EJSFinder findI13nActByQBE(java.lang.Boolean isDate, java.sql.Date argDateFrom, java.sql.Date argDateTo, java.lang.Boolean isOrganization, java.lang.Integer argOrganization, java.lang.Boolean isStorage, java.lang.Integer argStorage, java.lang.Boolean isStorageType, java.lang.String storageType, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getFinderObject().findI13nActByQBE(isDate, argDateFrom, argDateTo, isOrganization, argOrganization, isStorage, argStorage, isStorageType, storageType, order);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findFullByStorageAfterDate
	 */
	public com.hps.july.persistence.I13nAct findFullByStorageAfterDate(java.lang.Integer storage, java.sql.Date date, java.lang.Integer butDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.I13nAct result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.insuranceact, T1.blankdate, T1.blanknumber, T1.parentdocument, T1.operator, T1.isautodoc, T1.blankindex, T1.processsource, T1.showtouser, T1.state, T1.processdestination, T1.insurancedate, T1.insuranceman, T1.to2, T1.document, T1.needapprove, T1.projectid, T1.prjstatus, T1.visualtype, T1.owner, T1.to, T1.contragent, T1.from, T1.storagemanager, T1.type, T2.recalcagrprice, T2.agregateserial, T2.type, T2.agregateresource, T2.agregate, T2.techstuff FROM i13nact  T2, documents  T1 WHERE T1.type = \'I\' AND T1.document = T2.document AND t1.from = ? and t1.blankdate >= ? and t1.state=\"2\" and t2.type=\"F\" and t1.document not in (select d.documentfrom from docdependencies d where d.documentto = ? and d.type in (\"S\", \"P\") )");
			pstmt.setObject(1, storage);
			pstmt.setDate(2, date);
			pstmt.setObject(3, butDocument);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.I13nAct)tmpFinder.nextElement();
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
	 * findI13nActByAgregate
	 */
	public EJSFinder findI13nActByAgregate(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.insuranceact, T1.blankdate, T1.blanknumber, T1.parentdocument, T1.operator, T1.isautodoc, T1.blankindex, T1.processsource, T1.showtouser, T1.state, T1.processdestination, T1.insurancedate, T1.insuranceman, T1.to2, T1.document, T1.needapprove, T1.projectid, T1.prjstatus, T1.visualtype, T1.owner, T1.to, T1.contragent, T1.from, T1.storagemanager, T1.type, T2.recalcagrprice, T2.agregateserial, T2.type, T2.agregateresource, T2.agregate, T2.techstuff FROM i13nact  T2, documents  T1 WHERE T1.type = \'I\' AND T1.document = T2.document AND T2.agregate = ?");
			Object objectTemp = null;
boolean nullData;
			pstmt.setInt(1, inKey.storagecard);
			resultSet = pstmt.executeQuery();
			return new EJSJDBCFinder(resultSet, this, pstmt);
		}
		catch (Exception ex) {
			throw new EJSPersistenceException("find failed:", ex);
		}
	}
	/**
	 * findI13nActTechByTechStuff
	 */
	public EJSFinder findI13nActTechByTechStuff(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.insuranceact, T1.blankdate, T1.blanknumber, T1.parentdocument, T1.operator, T1.isautodoc, T1.blankindex, T1.processsource, T1.showtouser, T1.state, T1.processdestination, T1.insurancedate, T1.insuranceman, T1.to2, T1.document, T1.needapprove, T1.projectid, T1.prjstatus, T1.visualtype, T1.owner, T1.to, T1.contragent, T1.from, T1.storagemanager, T1.type, T2.recalcagrprice, T2.agregateserial, T2.type, T2.agregateresource, T2.agregate, T2.techstuff FROM i13nact  T2, documents  T1 WHERE T1.type = \'I\' AND T1.document = T2.document AND T2.techstuff = ?");
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.I13nAct findByPrimaryKey(com.hps.july.persistence.DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.I13nAct result = null;

		EJSJDBCFinder tmpFinder = null;
		com.hps.july.persistence.DocumentKey _primaryKey = (com.hps.july.persistence.DocumentKey)key;
		try {
			try {
				result = (com.hps.july.persistence.I13nAct)home.getBean(key);
			}
			catch (Throwable ex) {
				result=null;
			}
			if (result == null) {
				preFind();
				pstmt = getPreparedStatement(_loadString);
				Object objectTemp;
				pstmt.setInt(1, _primaryKey.document);
				resultSet = pstmt.executeQuery();
				tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
				if (tmpFinder.hasMoreElements()) {
					result = (com.hps.july.persistence.I13nAct)tmpFinder.nextElement();
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
	 * findAssortimentByStorageProductAfterDate
	 */
	public com.hps.july.persistence.I13nAct findAssortimentByStorageProductAfterDate(java.lang.Integer storage, java.lang.Integer product, java.sql.Date date, java.lang.Integer butDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.I13nAct result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.insuranceact, T1.blankdate, T1.blanknumber, T1.parentdocument, T1.operator, T1.isautodoc, T1.blankindex, T1.processsource, T1.showtouser, T1.state, T1.processdestination, T1.insurancedate, T1.insuranceman, T1.to2, T1.document, T1.needapprove, T1.projectid, T1.prjstatus, T1.visualtype, T1.owner, T1.to, T1.contragent, T1.from, T1.storagemanager, T1.type, T2.recalcagrprice, T2.agregateserial, T2.type, T2.agregateresource, T2.agregate, T2.techstuff FROM i13nact  T2, documents  T1 WHERE T1.type = \'I\' AND T1.document = T2.document AND t1.from = ? and exists (select i.* from i13nactresourceset i where i.document = t1.document and i.resource = ? )and t1.blankdate >= ? and t1.state=\"2\" and t2.type=\"P\" and t1.document not in (select d.documentfrom from docdependencies d where d.documentto = ? and d.type in (\"S\", \"P\") )");
			pstmt.setObject(1, storage);
			pstmt.setObject(2, product);
			pstmt.setDate(3, date);
			pstmt.setObject(4, butDocument);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.I13nAct)tmpFinder.nextElement();
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
	 * findAgregateByStorageSerialAfterDate
	 */
	public com.hps.july.persistence.I13nAct findAgregateByStorageSerialAfterDate(java.lang.String serial, java.sql.Date date, java.lang.Integer butDocument) throws javax.ejb.FinderException, java.rmi.RemoteException {
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		com.hps.july.persistence.I13nAct result = null;

		EJSJDBCFinder tmpFinder = null;
		try {
			preFind();
			pstmt = getPreparedStatement("SELECT T1.insuranceact, T1.blankdate, T1.blanknumber, T1.parentdocument, T1.operator, T1.isautodoc, T1.blankindex, T1.processsource, T1.showtouser, T1.state, T1.processdestination, T1.insurancedate, T1.insuranceman, T1.to2, T1.document, T1.needapprove, T1.projectid, T1.prjstatus, T1.visualtype, T1.owner, T1.to, T1.contragent, T1.from, T1.storagemanager, T1.type, T2.recalcagrprice, T2.agregateserial, T2.type, T2.agregateresource, T2.agregate, T2.techstuff FROM i13nact  T2, documents  T1 WHERE T1.type = \'I\' AND T1.document = T2.document AND exists(select s.* from storagecards s where s.storagecard = t2.agregate and s.serialnumber=?)and t1.blankdate >= ? and t1.state=\"2\" and t2.type=\"A\" and t1.document not in (select d.documentfrom from docdependencies d where d.documentto = ? and d.type in (\"S\", \"P\") )");
			if (serial == null) {
			   pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
			   pstmt.setString(1, serial);
			}
			pstmt.setDate(2, date);
			pstmt.setObject(3, butDocument);
			resultSet = pstmt.executeQuery();
			tmpFinder = new EJSJDBCFinder(resultSet, this, pstmt);
			if (tmpFinder.hasMoreElements()) {
				result = (com.hps.july.persistence.I13nAct)tmpFinder.nextElement();
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
	private static final String genericFindSqlString = "SELECT T1.insuranceact, T1.blankdate, T1.blanknumber, T1.parentdocument, T1.operator, T1.isautodoc, T1.blankindex, T1.processsource, T1.showtouser, T1.state, T1.processdestination, T1.insurancedate, T1.insuranceman, T1.to2, T1.document, T1.needapprove, T1.projectid, T1.prjstatus, T1.visualtype, T1.owner, T1.to, T1.contragent, T1.from, T1.storagemanager, T1.type, T2.recalcagrprice, T2.agregateserial, T2.type, T2.agregateresource, T2.agregate, T2.techstuff FROM i13nact  T2, documents  T1 WHERE T1.type = \'I\' AND T1.document = T2.document AND ";
	private static final int[] genericFindInsertPoints = {545};
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
	private I13nActBeanFinderObject finderObject = null;
	/**
	 * getFinderObject
	 */
	public com.hps.july.persistence.I13nActBeanFinderObject getFinderObject() {
		if (finderObject == null) {
			com.hps.july.persistence.I13nActBeanFinderObject temp_finderObject = new com.hps.july.persistence.I13nActBeanFinderObject();
			((com.ibm.vap.finders.VapEJSJDBCFinderObject)temp_finderObject).setPersister(this);
			finderObject = temp_finderObject; // atomic op - makes method thread-safe
		;}
		return finderObject;
	}
}