/*
 * Created on 21.03.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.cdbc.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.valueobject.Vendor_TO;
import com.hps.july.valueobject.Vendor_VO;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CDBC_Vendor_Object {
	private final static java.lang.String FIND_SQL =
		"SELECT first 1000 idVendor, vendorcode, end_date_active, name, inn, type, useInNri, recordStatus, source, accountmanagerfio, directorfio, directorJob, phisicaladdress, legaladdress, comment, idvendornfs, createdBy, created, modifiedBy, modified, typeVendor, lastName, firstName, middleName, passportser, passportnum, passportdate, passportwhom, nameForPrintDoc, addressForPrintDoc FROM vendors ";
	private final static java.lang.String EDIT_SQL =
		"UPDATE vendors SET vendorcode=?, end_date_active=?, name=?, inn=?, type=?, useInNri=?, recordStatus=?, source=?, accountmanagerfio=?, directorfio=?, directorJob=?, phisicaladdress=?, legaladdress=?, comment=?, idvendornfs=?, createdBy=?, created=?, modifiedBy=?, modified=?, typeVendor=?, lastName=?, firstName=?, middleName=?, passportser=?, passportnum=?, passportdate=?, passportwhom=?, nameForPrintDoc=?, addressForPrintDoc=? "
			+ "WHERE idVendor=? ";
	private final static java.lang.String ADD_SQL =
		"INSERT INTO vendors (idVendor, vendorcode, end_date_active, name, inn, type, useInNri, recordStatus, source, accountmanagerfio, directorfio, directorJob, phisicaladdress, legaladdress, comment, idvendornfs, createdBy, created, modifiedBy, modified, typeVendor, lastName, firstName, middleName, passportser, passportnum, passportdate, passportwhom, nameForPrintDoc, addressForPrintDoc) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	private final static java.lang.String DELETE_SQL = "DELETE FROM vendors WHERE idVendor = ? ";
	//private final static java.lang.String DELETE_SQL = "UPDATE vendors SET recordStatus='D' WHERE idVendor = ? ";
	private final static java.lang.String FIND_TO_SQL =
		"SELECT idVendor, vendorcode, end_date_active, name, inn, type, useInNri, recordStatus, source, accountmanagerfio, directorfio, directorJob, phisicaladdress, legaladdress, comment, idvendornfs, createdBy, getNamePeople(createdBy) createdByName, created, modifiedBy,  getNamePeople(modifiedBy) modifiedByName, modified, typeVendor, lastName, firstName, middleName, passportser, passportnum, passportdate, passportwhom, nameForPrintDoc, addressForPrintDoc FROM vendors ";

	/**
	 * Insert the method's description here.
	 * Creation date: (30.09.2004 11:49:47)
	 */
	public static List findList(Integer filter, String searchString, Boolean isUseInNri, Boolean isRecordStatus, String aSortBy) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_SQL);
		sqlb.append(" WHERE 1=1 ");
		//calculate filter clause
		if (filter.intValue() == 1) {
			sqlb.append("AND lower(name) matches lower(?) ");
			params.add(searchString);
		}
		if (filter.intValue() == 2) {
			sqlb.append("AND lower(inn) matches lower(?) ");
			params.add(searchString);
		}
		if (filter.intValue() == 3) {
			sqlb.append("AND vendorCode = ? ");
			params.add(searchString);
		}
		if (filter.intValue() == 4) {
			sqlb.append("AND idVendor IN( SELECT idVendor FROM vendorSites WHERE lower(name) matches lower(?) ) ");
			params.add(searchString);
		}				
		if (isRecordStatus.booleanValue()) {
			sqlb.append("AND recordStatus='A' ");
		}
		if (isUseInNri.booleanValue()) {
			sqlb.append("AND useInNri='Y' ");
		}
		//append order by clause:
		sqlb.append("order by " + aSortBy);

		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			Vendor_VO vo = CDBC_MapFactory.createVendor(ro);
			//Banks_TO to = new Banks_TO(vo);
			ret.add(vo);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.09.2004 11:49:47)
	 */
	public static List findList(Integer filter, String searchString, Boolean isUseInNri, Boolean isRecordStatus, Boolean isTypeVendor, Integer typeVendor, String aSortBy) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_SQL);
		sqlb.append(" WHERE 1=1 ");
		//calculate filter clause
		if (filter.intValue() == 1) {
			sqlb.append("AND lower(name) matches lower(?) ");
			params.add(searchString);
		}
		if (filter.intValue() == 2) {
			sqlb.append("AND lower(inn) matches lower(?) ");
			params.add(searchString);
		}
		if (filter.intValue() == 3) {
			sqlb.append("AND vendorCode = ? ");
			params.add(searchString);
		}
		if (filter.intValue() == 4) {
			sqlb.append("AND idVendor IN( SELECT idVendor FROM vendorSites WHERE lower(name) matches lower(?) ) ");
			params.add(searchString);
		}				
		if (isRecordStatus.booleanValue()) {
			sqlb.append("AND recordStatus='A' ");
		}
		if (isUseInNri.booleanValue()) {
			sqlb.append("AND useInNri='Y' ");
		}
		if (isTypeVendor.booleanValue()) {
			sqlb.append("AND typeVendor=? ");
			params.add(typeVendor);
		}		
		//append order by clause:
		sqlb.append("order by " + aSortBy);

		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			Vendor_VO vo = CDBC_MapFactory.createVendor(ro);
			ret.add(vo);
		}
		return ret;
	}	
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static Vendor_VO find(Integer aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aID };
		String sql = FIND_SQL + " WHERE idVendor = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		Vendor_VO vo = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			vo = CDBC_MapFactory.createVendor(ro);
		}
		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static Vendor_TO findTO(Integer aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aID };
		String sql = FIND_TO_SQL + " WHERE idVendor = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		Vendor_TO to = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			Vendor_VO vo = CDBC_MapFactory.createVendor(ro);
			to = new Vendor_TO(vo);
			to.setCreatedBy(ro.getColumn("createdByName").asString());
			to.setModifiedBy(ro.getColumn("modifiedByName").asString());
		}
		return to;
	}	
	/**
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 14:06:19)
	 */
	public static boolean add(Vendor_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getIdVendor(),
				vo.getVendorCode(),
				vo.getEnd_date_active(),
				vo.getName(),
				vo.getInn(),
				vo.getType(),
				vo.getUseInNri(),
				vo.getRecordStatus(),
				vo.getSource(),
				vo.getAccountManagerFio(),
				vo.getDirectorFio(),
				vo.getDirectorJob(),
				vo.getPhisicalAddress(),
				vo.getLegalAddress(),
				vo.getComment(),
				vo.getIdVendorNfs(),
				vo.getCreatedBy(),
				vo.getCreated(),
				vo.getModifiedBy(),
				vo.getModified(),
				vo.getTypeVendor(),
				vo.getLastName(),
				vo.getFirstName(),
				vo.getMiddleName(),
				vo.getPassportSer(),
				vo.getPassportNum(),
				vo.getPassportDate(),
				vo.getPassportWhom(),
				vo.getNameForPrintDoc(),
				vo.getAddressForPrintDoc()};
		return res.executeUpdate(ADD_SQL, params);
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 14:17:12)
	 */
	public static boolean delete(Integer idVendor) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { idVendor };
		return res.executeUpdate(DELETE_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 14:14:22)
	 */
	public static boolean edit(Vendor_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getVendorCode(),
				vo.getEnd_date_active(),
				vo.getName(),
				vo.getInn(),
				vo.getType(),
				vo.getUseInNri(),
				vo.getRecordStatus(),
				vo.getSource(),
				vo.getAccountManagerFio(),
				vo.getDirectorFio(),
				vo.getDirectorJob(),
				vo.getPhisicalAddress(),
				vo.getLegalAddress(),
				vo.getComment(),
				vo.getIdVendorNfs(),
				vo.getCreatedBy(),
				vo.getCreated(),
				vo.getModifiedBy(),
				vo.getModified(),
				vo.getTypeVendor(),
				vo.getLastName(),
				vo.getFirstName(),
				vo.getMiddleName(),
				vo.getPassportSer(),
				vo.getPassportNum(),
				vo.getPassportDate(),
				vo.getPassportWhom(),
				vo.getNameForPrintDoc(),
				vo.getAddressForPrintDoc(),				
				vo.getIdVendor()};
		return res.executeUpdate(EDIT_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static boolean isExistINN(String aINN) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aINN };
		String sql = "SELECT * FROM vendors WHERE inn = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		if (list.hasNext()) {
			return true;
		}
		return false;
	}
	
	public final static List findListForINN(String aINN){
		CDBCResultSet res = new CDBCResultSet();
		List ret = new ArrayList();
		Object[] params = { aINN };
		StringBuffer sqlb = new StringBuffer(FIND_SQL);
		sqlb.append(" WHERE inn = ? ");
		res.executeQuery(sqlb.toString(), params);		
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			Vendor_VO vo = CDBC_MapFactory.createVendor(ro);
			ret.add(vo);
		}
		return ret;		
	}
}
