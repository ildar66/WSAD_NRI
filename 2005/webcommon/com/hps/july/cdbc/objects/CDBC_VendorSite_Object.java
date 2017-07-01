/*
 * Created on 21.03.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.cdbc.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.valueobject.VendorSite_TO;
import com.hps.july.valueobject.VendorSite_VO;
import com.hps.july.valueobject.Vendor_VO;

/**
 * @author IShaffigulin
 *
 * Отделения поставщиков CDBC_Object.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CDBC_VendorSite_Object {
	private final static java.lang.String FIND_SQL =
		"SELECT idVendorSite, idVendor, isOwnerContract, idOwnerNfs, vendorSiteCode, name, matchOption, address, kpp, useInNri, recordStatus, source, accountmanagerfio, directorfio, directorJob, comment, idVendorSiteNFS, createdBy, created, modifiedBy, modified, lastName, firstName, middleName, passportser, passportnum, passportdate, passportwhom, nameForPrintDoc, addressForPrintDoc FROM vendorSites ";
	private final static java.lang.String EDIT_SQL =
		"UPDATE vendorSites SET idVendor=?, isOwnerContract=?, idOwnerNfs=?, vendorSiteCode=?, name=?, matchOption=?, address=?, kpp=?, useInNri=?, recordStatus=?, source=?, accountmanagerfio=?, directorfio=?, directorJob=?, comment=?, idVendorSiteNFS=?, createdBy=?, created=?, modifiedBy=?, modified=?, lastName=?, firstName=?, middleName=?, passportser=?, passportnum=?, passportdate=?, passportwhom=?, nameForPrintDoc=?, addressForPrintDoc=? "
			+ "WHERE idVendorSite=? ";
	private final static java.lang.String ADD_SQL =
		"INSERT INTO vendorSites (idVendorSite, idVendor, isOwnerContract, idOwnerNfs, vendorSiteCode, name, matchOption, address, kpp, useInNri, recordStatus, source, accountmanagerfio, directorfio, directorJob, comment, idVendorSiteNFS, createdBy, created, modifiedBy, modified, lastName, firstName, middleName, passportser, passportnum, passportdate, passportwhom, nameForPrintDoc, addressForPrintDoc) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	private final static java.lang.String DELETE_SQL = "DELETE FROM vendorSites WHERE idVendorSite = ? ";
	//private final static java.lang.String DELETE_SQL = "UPDATE vendorSites SET recordStatus='D' WHERE idVendorSite = ? ";
	private final static java.lang.String FIND_LIST_SQL =
		"SELECT vs.idVendorSite, vs.idVendor, vs.isOwnerContract, vs.idOwnerNfs, vs.vendorSiteCode, vs.name, vs.matchOption, vs.address, vs.kpp, vs.useInNri, vs.recordStatus, vs.source, vs.accountmanagerfio, vs.directorfio, vs.directorJob, vs.comment, vs.idVendorSiteNFS, vs.createdBy, vs.created, vs.modifiedBy, vs.modified, vs.lastName, vs.firstName, vs.middleName, vs.passportser, vs.passportnum, vs.passportdate, vs.passportwhom, vs.nameForPrintDoc, vs.addressForPrintDoc, os.nameOwnerNfs FROM vendorSites vs, ownerSystemNfs os WHERE vs.idownernfs = os.idownernfs ";
	private final static java.lang.String FIND_LOOKUP_LIST_SQL =
		"SELECT {+index (vendorSites)} first 1000 vs.idVendorSite, vs.idVendor, vs.isOwnerContract, vs.idOwnerNfs, vs.vendorSiteCode, vs.name, vs.matchOption, vs.address, vs.kpp, vs.useInNri, vs.recordStatus, vs.source, vs.accountmanagerfio, vs.directorfio, vs.directorJob, vs.comment, vs.idVendorSiteNFS, vs.createdBy, vs.created, vs.modifiedBy, vs.modified, vs.lastName, vs.firstName, vs.middleName, vs.passportser, vs.passportnum, vs.passportdate, vs.passportwhom, vs.nameForPrintDoc, vs.addressForPrintDoc, os.nameOwnerNfs, v.vendorcode vendorCode, v.end_date_active, v.name vendorName, v.inn, v.type, v.useInNri vendorUseInNri, v.recordStatus vendorRecordStatus, v.source vendorSource, v.accountmanagerfio vendorAccountManagerFio, v.directorfio vendorDirectorFio, v.directorJob vendorDirectorJob, v.phisicaladdress, v.legaladdress, v.comment, v.idvendornfs, v.typeVendor FROM vendors v, vendorSites vs, ownerSystemNfs os WHERE vs.idownernfs = os.idownernfs AND v.idVendor = vs.idVendor ";
	private final static java.lang.String FIND_TO_SQL =
		"SELECT vs.idVendorSite, vs.idVendor, vs.isOwnerContract, vs.idOwnerNfs, vs.vendorSiteCode, vs.name, vs.matchOption, vs.address, vs.kpp, vs.useInNri, vs.recordStatus, vs.source, vs.accountmanagerfio, vs.directorfio, vs.directorJob, vs.comment, vs.idVendorSiteNFS, vs.createdBy, getNamePeople(vs.createdBy) createdByName, vs.created, vs.modifiedBy, getNamePeople(vs.modifiedBy) modifiedByName, vs.modified, vs.lastName, vs.firstName, vs.middleName, vs.passportser, vs.passportnum, vs.passportdate, vs.passportwhom, vs.nameForPrintDoc, vs.addressForPrintDoc, v.typeVendor FROM vendorSites vs, vendors v ";
		
  
	/**
	 * Insert the method's description here.
	 * Creation date: (30.09.2004 11:49:47)
	 */
	public static List findList(
		Boolean isIdVendor,
		Integer idVendor,
		Boolean isName,
		String name,
		Boolean isKpp,
		String kpp,
		Boolean isUseInNri,
		Boolean isRecordStatus,
		String aSortBy) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_LIST_SQL);
		//calculate filter clause
		if (isIdVendor.booleanValue()) {
			sqlb.append("AND idVendor = ? ");
			params.add(idVendor);
		}
		if (isName.booleanValue()) {
			sqlb.append("AND lower(name) matches lower(?) ");
			params.add(name);
		}
		if (isKpp.booleanValue()) {
			sqlb.append("AND lower(kpp) matches lower(?) ");
			params.add(kpp);
		}
		if (isRecordStatus.booleanValue()) {
			sqlb.append("AND recordStatus='A' ");
		}
		if (isUseInNri.booleanValue()) {
			sqlb.append("AND useInNri='Y' ");
		}
		//append order by clause:
		if(aSortBy != null){
			sqlb.append("order by " + aSortBy);			
		}

		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			VendorSite_VO vo = CDBC_MapFactory.createVendorSite(ro);
			VendorSite_TO to = new VendorSite_TO(vo);
			to.setOwnerName(ro.getColumn("nameOwnerNfs").asString());
			ret.add(to);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.09.2004 11:49:47)
	 */
	public static List findList(
		Boolean isIdVendor,		Integer idVendor,
		Boolean isName,		String name,
		Boolean isKpp,		String kpp,
		Boolean isUseInNri,
		Boolean isRecordStatus,
		Boolean isRegionID,     Integer regionID,  
		String aSortBy) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_LIST_SQL);
		
		//calculate filter clause
		if (isIdVendor.booleanValue()) {
			sqlb.append("AND idVendor = ? ");
			params.add(idVendor);
		}
		if (isName.booleanValue()) {
			sqlb.append("AND lower(name) matches lower(?) ");
			params.add(name);
		}
		if (isKpp.booleanValue()) {
			sqlb.append("AND lower(kpp) matches lower(?) ");
			params.add(kpp);
		}
		if (isRecordStatus.booleanValue()) {
			sqlb.append("AND recordStatus='A' ");
		}
		if (isUseInNri.booleanValue()) {
			sqlb.append("AND useInNri='Y' ");
		}
		if (isRegionID.booleanValue()) {
			sqlb.append("AND vs.idOwnerNfs IN( SELECT idOwnerNfs FROM OwnerSystemNfs2FilialNri WHERE regionId = ? ) ");
			params.add(regionID);
		}		
		//append order by clause:
		if(aSortBy != null){
			sqlb.append("order by " + aSortBy);			
		}
		System.out.println("CDBC_VendorSite_Object.findList.SQL="+sqlb.toString()+" \n params="+params);//temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			VendorSite_VO vo = CDBC_MapFactory.createVendorSite(ro);
			VendorSite_TO to = new VendorSite_TO(vo);
			to.setOwnerName(ro.getColumn("nameOwnerNfs").asString());
			ret.add(to);
		}
		return ret;
	}	
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static VendorSite_VO find(Integer aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aID };
		String sql = FIND_SQL + " WHERE idVendorSite = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		VendorSite_VO vo = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			vo = CDBC_MapFactory.createVendorSite(ro);
		}
		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static VendorSite_TO findTO(Integer aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aID };
		String sql = FIND_TO_SQL + " WHERE v.idVendor = vs.idVendor AND idVendorSite = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		VendorSite_TO to = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			VendorSite_VO vo = CDBC_MapFactory.createVendorSite(ro);
			to = new VendorSite_TO(vo);
			to.setCreatedBy(ro.getColumn("createdByName").asString());
			to.setModifiedBy(ro.getColumn("modifiedByName").asString());
			Vendor_VO vendor_VO = new Vendor_VO((Integer)ro.getColumn("idVendor").asObject());
			vendor_VO.setTypeVendor((Integer)ro.getColumn("typeVendor").asObject());
			vendor_VO.setIsGhost(true);
			to.setVendor_VO(vendor_VO);
		}
		return to;
	}	
	/**
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 14:06:19)
	 */
	public static boolean add(VendorSite_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getIdVendorSite(),
				vo.getIdVendor(),
				vo.getIsOwnerContract(),
				vo.getIdOwnerNfs(),
				vo.getVendorSiteCode(),
				vo.getName(),
				vo.getMatchOption(),
				vo.getAddress(),
				vo.getKpp(),
				vo.getUseInNri(),
				vo.getRecordStatus(),
				vo.getSource(),
				vo.getAccountManagerFio(),
				vo.getDirectorFio(),
				vo.getDirectorJob(),
				vo.getComment(),
				vo.getIdVendorSiteNFS(),
				vo.getCreatedBy(),
				vo.getCreated(),
				vo.getModifiedBy(),
				vo.getModified(),
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
	public static boolean delete(Integer idVendorSite) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { idVendorSite };
		return res.executeUpdate(DELETE_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.10.2005 14:14:22)
	 */
	public static boolean edit(VendorSite_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getIdVendor(),
				vo.getIsOwnerContract(),
				vo.getIdOwnerNfs(),
				vo.getVendorSiteCode(),
				vo.getName(),
				vo.getMatchOption(),
				vo.getAddress(),
				vo.getKpp(),
				vo.getUseInNri(),
				vo.getRecordStatus(),
				vo.getSource(),
				vo.getAccountManagerFio(),
				vo.getDirectorFio(),
				vo.getDirectorJob(),
				vo.getComment(),
				vo.getIdVendorSiteNFS(),
				vo.getCreatedBy(),
				vo.getCreated(),
				vo.getModifiedBy(),
				vo.getModified(),
				vo.getLastName(),
				vo.getFirstName(),
				vo.getMiddleName(),
				vo.getPassportSer(),
				vo.getPassportNum(),
				vo.getPassportDate(),
				vo.getPassportWhom(),
				vo.getNameForPrintDoc(),
				vo.getAddressForPrintDoc(),				
				vo.getIdVendorSite()};
		return res.executeUpdate(EDIT_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.09.2004 11:49:47)
	 */
	public static List findLookupList(
		Boolean isIdVendor,		Integer idVendor,
		Integer filter ,		String searchString,
		Boolean isUseInNri,		Boolean isRecordStatus,
		Boolean isRegionID,     Integer regionID,  
		String aSortBy) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_LOOKUP_LIST_SQL);
		//calculate filter clause
		if (isIdVendor.booleanValue()) {
			sqlb.append("AND vs.idVendor = ? ");
			params.add(idVendor);
		}
		if (filter.intValue() == 1) {
			if(searchString != null && searchString.equals("")){
				return Collections.EMPTY_LIST;
			}
			sqlb.append("AND lower(vs.name) matches lower(?) ");
			params.add(searchString);
		}
		if (filter.intValue() == 2) {
			sqlb.append("AND lower(vs.kpp) matches lower(?) ");
			params.add(searchString);
		}
		if (filter.intValue() == 3) {
			if(searchString != null && searchString.equals("")){
				return Collections.EMPTY_LIST;
			}			
			sqlb.append("AND vs.idVendor IN( SELECT idVendor FROM vendors WHERE lower(name) matches lower(?) ) ");
			params.add(searchString);
		}
		if (filter.intValue() == 4) {
			sqlb.append("AND vs.idVendor IN( SELECT idVendor FROM vendors WHERE lower(inn) matches lower(?) ) ");
			params.add(searchString);
		}
		if (filter.intValue() == 5) {
			sqlb.append("AND vs.idVendor IN( SELECT idVendor FROM vendors WHERE vendorCode = ? ) ");
			params.add(searchString);
		}		
		if (isRecordStatus.booleanValue()) {
			sqlb.append("AND vs.recordStatus='A' ");
		}
		if (isUseInNri.booleanValue()) {
			sqlb.append("AND vs.useInNri='Y' ");
		}
		if (isRegionID.booleanValue()) {
			sqlb.append("AND vs.idOwnerNfs IN( SELECT idOwnerNfs FROM OwnerSystemNfs2FilialNri WHERE regionId = ? ) ");
			params.add(regionID);
		}		
		//append order by clause:
		sqlb.append("order by " + aSortBy);
		//System.out.println("CDBC_VendorSite_Object.findLookupList sqlb=" + sqlb);
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			VendorSite_VO vo = CDBC_MapFactory.createVendorSite(ro);
			VendorSite_TO to = new VendorSite_TO(vo);
			to.setOwnerName(ro.getColumn("nameOwnerNfs").asString());
			Vendor_VO vendor_VO = new Vendor_VO((Integer)ro.getColumn("idVendor").asObject());
			vendor_VO.setInn(ro.getColumn("inn").asString());
			vendor_VO.setName(ro.getColumn("vendorName").asString());
			vendor_VO.setVendorCode((Integer)ro.getColumn("vendorCode").asObject());
			vendor_VO.setLegalAddress(ro.getColumn("legaladdress").asString());
			vendor_VO.setPhisicalAddress(ro.getColumn("phisicaladdress").asString());
			vendor_VO.setTypeVendor((Integer)ro.getColumn("typeVendor").asObject());
			vendor_VO.setIsGhost(true);
			to.setVendor_VO(vendor_VO);
			
			ret.add(to);
		}
		return ret;
	}
}
