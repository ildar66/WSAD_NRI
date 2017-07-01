package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import java.util.*;
/**
 * JDBC - Объект для работы с NFS.
 * Creation date: (02.06.2004 12:46:22)
 * @author: Shafigullin Ildar
 */
public class CDBC_NFS_Object {
    private final static java.lang.String findListNFS_SQL =
        "SELECT zp.idzpNfs, zp.numZp, (zp.sumwithoutvat + zp.sumVat) sumZp, zp.currZp, zp.stateZp, zp.sumvat ndsZp, zp.recordstatus statusZp, zp.idorgnfs idorgnfs_zp, "
            + "sf.idSfNfs, sf.numSf, sf.stateSf, sf.dateCreate sfDateCreate, (sf.sumWithOutVat + sf.sumVat) sumSf, sf.currSf, sf.recordstatus statusSf, sf.idorgnfs idorgnfs_sf, "
            + "pay.idPayNfs, pay.numPay, pay.datePay, pay.statePay, pay.sumPay, pay.currPay, pay.sumRubPay, pay.purpose, getIsLnkPayNfs (pay.idPayNfs) isLnkPayNfs,  pay.recordstatus statusPay, "
            + "dog.idContractNfs, dog.numContract, dog.dateContract, dog.numContractNfs,  "
           + "sf.idVendorNfs vendorId_sf, getNameVendorNfs(sf.idVendorNfs) nameVendor_sf, getInnVendorNfs(sf.idVendorNfs) innVendor_sf, "
            + "zp.idVendorNfs vendorId_zp, getNameVendorNfs(zp.idVendorNfs) nameVendor_zp, getInnVendorNfs(zp.idVendorNfs) innVendor_zp "            
            + "FROM nfs_sf sf, nfs_vendors vendor, nfs_vendorsites site, outer nfs_pays pay, outer (nfs_zp zp, outer nfs_contracts dog) "
            + "WHERE vendor.idvendornfs = sf.idVendorNfs AND site.idVendorSiteNfs = sf.idVendorSiteNfs  AND pay.idSfNfs = sf.idSfNfs AND sf.idZpNfs = zp.idZpNfs AND dog.idContractNfs = zp.idContractNfs ";
    private final static java.lang.String findZP_NFS_SQL =
        "SELECT zp.idzpNfs, zp.numZp, (zp.sumwithoutvat + zp.sumVat) sumZp, zp.sumvat ndsZp, zp.currZp, zp.stateZp,  zp.recordstatus statusZp, zp.idorgnfs idorgnfs_zp, getNameUserNfs(zp.userCreate) userCreate, getNameUserNfs(zp.userModify) userModify, zp.dateCreate, zp.dateModify, "
            + "zp.idVendorNfs vendorId_zp, getNameVendorNfs(zp.idVendorNfs) nameVendor_zp, getInnVendorNfs(zp.idVendorNfs) innVendor_zp, getCodeVendorNfs(zp.idVendorNfs) codeVendor_zp, "
            + "zp.idVendorSiteNfs vendorSiteId, getNameSiteNfs(zp.idVendorSiteNfs) nameSite, getKPPSiteNfs(zp.idVendorSiteNfs) kpp, getSiteCodeNfs (zp.idVendorSiteNfs) codeSite "
            + "FROM nfs_zp zp WHERE ";
    private final static java.lang.String findSchetFakt_NFS_SQL =
        "SELECT sf.idSfNfs, sf.numSf, sf.stateSf, (sf.sumWithOutVat + sf.sumVat) sumSf, sf.currSf, sf.dateCreate sfDateCreate, sf.recordstatus statusSf, sf.idorgnfs idorgnfs_sf, getNameUserNfs(sf.userCreate) userCreate, getNameUserNfs(sf.userModify) userModify, sf.dateCreate, sf.dateModify, "
            + "sf.idVendorSiteNfs idSiteSf, sf.idVendorSite3Nfs idSite3Sf, getTaxRateSf(sf.idSfNfs) taxRateSf, "
            + "calcSumNds(sf.sumWithOutVat + sf.sumVat, getTaxRateSf(sf.idSfNfs), 'Y') ndsSf, "
            + "getNameSiteNfs (nvl(sf.idVendorSite3Nfs, sf.idVendorSiteNfs)) recipientSf, "
            + "sf.idAccNfs, sf.idVendorSiteNfs, "
            + "getRsNfs (sf.idAccNfs, sf.idVendorSiteNfs) accountNumSf, "
            + "getNameBankNfs (sf.idAccNfs, sf.idVendorSiteNfs) nameBankSf, "
            + "getCorrAccBankNfs (sf.idAccNfs, sf.idVendorSiteNfs) corrAccBankSf, "
            + "getBikBankNfs (sf.idAccNfs, sf.idVendorSiteNfs) bikBankSf, "
            + "sf.idVendorNfs vendorId_sf, getNameVendorNfs(sf.idVendorNfs) nameVendor_sf, getInnVendorNfs(sf.idVendorNfs) innVendor_sf, getCodeVendorNfs(sf.idVendorNfs) codeVendor_sf, "
            + "sf.idVendorSiteNfs vendorSiteId, getNameSiteNfs(sf.idVendorSiteNfs) nameSite, getKPPSiteNfs(sf.idVendorSiteNfs) kpp, getSiteCodeNfs (sf.idVendorSiteNfs) codeSite "
            + "FROM nfs_sf sf WHERE ";
    private final static java.lang.String findPay_NFS_SQL =
        "SELECT pay.idPayNfs, pay.numPay, pay.datePay, pay.statePay, pay.sumPay, pay.currPay, pay.sumRubPay, pay.purpose purpose, pay.recordstatus statusPay, "
            + "calcSumNds (pay.sumRubPay, getTaxRateSf(sf.idSfNfs), 'Y') sumNdsRubPay, "
            + "pay.idVendorSiteNfs idSitePay, getNameSiteNfs (pay.idVendorSiteNfs) recipientPay, "
            + "pay.idAccountRecipient, sf.idVendorSiteNfs, "
            + "getRsNfs (pay.idAccountRecipient, sf.idVendorSiteNfs) accountNumPay, "
            + "getNameBankNfs (pay.idAccountRecipient, pay.idVendorSiteNfs)  nameBankPay, "
            + "getCorrAccBankNfs (pay.idAccountRecipient, pay.idVendorSiteNfs)  corrAccBankPay, "
            + "getBikBankNfs (pay.idAccountRecipient, pay.idVendorSiteNfs)  bikBankPay ,"
            + "getIsLnkPayNfs (pay.idPayNfs) isLnkPayNfs "
            + "FROM nfs_pays pay, outer nfs_sf sf WHERE ";
    private final static java.lang.String findContract_NFS_SQL =
        "SELECT dog.idContractNfs, dog.numContract, dog.dateContract, dog.numContractNfs FROM nfs_contracts dog WHERE ";
    private final static java.lang.String findListZP_NFS_forArendaAgreement_SQL =
        "SELECT zp.idzpNfs, zp.numZp, (zp.sumwithoutvat + zp.sumVat) sumZp, zp.sumvat ndsZp, zp.currZp, zp.stateZp, zp.recordstatus statusZp,  zp.idorgnfs idorgnfs_zp, "
            + "zp.idVendorNfs vendorId_zp, getNameVendorNfs(zp.idVendorNfs) nameVendor_zp, getInnVendorNfs(zp.idVendorNfs) innVendor_zp, "
            + "zp.idVendorSiteNfs vendorSiteId, getNameSiteNfs(zp.idVendorSiteNfs) nameSite, getKPPSiteNfs(zp.idVendorSiteNfs) kpp, getSiteCodeNfs (zp.idVendorSiteNfs) codeSite, "
            + "lzp.isActive "
            + "FROM nfs_zp zp, leaseZP lzp WHERE zp.idzpNfs = lzp.idzpNfs ";
    private final static java.lang.String findListZP_SQL =
        "SELECT first 1000 zp.idzpNfs, zp.numZp, (zp.sumwithoutvat + zp.sumVat) sumZp, zp.currZp, zp.stateZp, zp.sumvat ndsZp,  zp.idorgnfs idorgnfs_zp, zp.recordstatus statusZp,  "
            + "vendor.idvendornfs vendorId_zp, vendor.name nameVendor_zp, vendor.inn innVendor_zp, "
            + "cn2.numcontract,  cn2.idContractNfs, cn2.numContractNfs, cn2.dateContract "
            + "FROM nfs_zp zp, nfs_vendors vendor, outer nfs_contracts cn2 "
            + "WHERE zp.idVendorNfs = vendor.idvendornfs AND zp. idcontractnfs = cn2.idcontractnfs ";
    private final static java.lang.String findListNFS_detach_SQL =
        "SELECT first 1000 zp.idzpNfs, zp.numZp, (zp.sumwithoutvat + zp.sumVat) sumZp, zp.currZp, zp.stateZp, zp.sumvat ndsZp, zp.recordstatus statusZp,  zp.idorgnfs idorgnfs_zp, "
            + "sf.idSfNfs, sf.numSf, sf.stateSf, sf.dateCreate sfDateCreate, (sf.sumWithOutVat + sf.sumVat) sumSf, sf.currSf, sf.recordstatus statusSf, "
            + "pay.idPayNfs, pay.numPay, pay.datePay, pay.statePay, pay.sumPay, pay.currPay, pay.sumRubPay, pay.purpose, getIsLnkPayNfs (pay.idPayNfs) isLnkPayNfs,  pay.recordstatus statusPay, "
            + "dog.idContractNfs, dog.numContract, dog.dateContract, dog.numContractNfs "
            + "FROM nfs_sf sf, nfs_vendors vendor, nfs_vendorsites site, outer nfs_pays pay, nfs_zp zp, outer nfs_contracts dog "
            + "WHERE vendor.idvendornfs = sf.idVendorNfs AND site.idVendorSiteNfs = sf.idVendorSiteNfs  AND pay.idSfNfs = sf.idSfNfs AND sf.idZpNfs = zp.idZpNfs AND dog.idContractNfs = zp.idContractNfs ";
    private final static java.lang.String findListNFS_selectSQL =
        "SELECT zp.idzpNfs, zp.numZp, (zp.sumwithoutvat + zp.sumVat) sumZp, zp.currZp, zp.stateZp, zp.sumvat ndsZp, zp.recordstatus statusZp, "
            + "sf.idSfNfs, sf.numSf, sf.stateSf, sf.dateCreate sfDateCreate, (sf.sumWithOutVat + sf.sumVat) sumSf, sf.currSf, sf.recordstatus statusSf, "
            + "pay.idPayNfs, pay.numPay, pay.datePay, pay.statePay, pay.sumPay, pay.currPay, pay.sumRubPay, pay.purpose, getIsLnkPayNfs (pay.idPayNfs) isLnkPayNfs,  pay.recordstatus statusPay, "
            + "dog.idContractNfs, dog.numContract, dog.dateContract, dog.numContractNfs, "
            + "zp.idorgnfs idorgnfs_zp, zp.usercreate usercreate_zp,  zp.datecreate datecreate_zp, zp.usermodify usermodify_zp, zp.datemodify datemodify_zp, "
            + "sf.idorgnfs idorgnfs_sf, sf.usercreate usercreate_sf,  sf.datecreate datecreate_sf, sf.usermodify usermodify_sf , sf.datemodify datemodify_sf, "
            + "pay.usercreate usercreate_pay,  pay.datecreate datecreate_pay, pay.usermodify usermodify_pay, pay.datemodify datemodify_pay, "
            + "sf.idVendorNfs vendorId_sf, getNameVendorNfs(sf.idVendorNfs) nameVendor_sf, getInnVendorNfs(sf.idVendorNfs) innVendor_sf, "
            + "zp.idVendorNfs vendorId_zp, getNameVendorNfs(zp.idVendorNfs) nameVendor_zp, getInnVendorNfs(zp.idVendorNfs) innVendor_zp ";
    private final static java.lang.String findListNFS_whereSfSQL =
        "WHERE vendor.idvendornfs = sf.idVendorNfs AND site.idVendorSiteNfs = sf.idVendorSiteNfs  AND pay.idSfNfs = sf.idSfNfs AND sf.idZpNfs = zp.idZpNfs AND dog.idContractNfs = zp.idContractNfs ";
    private final static java.lang.String findListNFS_whereZpSQL =
        "WHERE vendor.idvendornfs = zp.idVendorNfs AND site.idVendorSiteNfs = zp.idVendorSiteNfs  AND pay.idSfNfs = sf.idSfNfs AND sf.idZpNfs = zp.idZpNfs AND dog.idContractNfs = zp.idContractNfs ";
    public final static java.lang.String findListNFS_fromSfSQL =
        "FROM nfs_sf sf, nfs_vendors vendor, nfs_vendorsites site, ";
    private final static java.lang.String findListNFS_fromZpSQL =
        "FROM nfs_zp zp, nfs_vendors vendor, nfs_vendorsites site, ";
/**
 * CDBC_NFS_Object constructor comment.
 */
public CDBC_NFS_Object() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 15:01:51)
 * @return com.hps.july.cdbc.lib.CDBCRowObject
 * @param idContractNfs int
 */
public static CDBCRowObject findContract_NFS(int idContractNfs) {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findContract_NFS_SQL + "dog.idContractNfs = " + idContractNfs;
	res.executeQuery(sql, null);
	ListIterator list = res.listIterator();
	if (list.hasNext())
		return (CDBCRowObject) list.next();
	else
		return null;
}
/**
 * Возвращает список NFS.
 * Creation date: (02.06.2004 14:17:05)
 */
public CDBCResultSet findListNFS(
    Boolean isVendorInn , String vendorInn,
    Boolean isVendorName, String vendorName,
    Boolean isNumZp, String numZp)
{
	    
   	StringBuffer sqlb = new StringBuffer();
	//ArrayList params = new ArrayList();

	CDBCResultSet res = new CDBCResultSet();
    //add query string: 
	sqlb.append(findListNFS_SQL);
    //aliases:
    String alias1 = "zp";//nfs_zp
    //String alias2 = "dog";//nfs_contracts
    String alias3 = "vendor";//nfs_vendors
    //String alias4 = "site";//nfs_vendorsites
    //String alias5 = "sf";//nfs_sf
    //String alias6 = "pay";//nfs_pays

    //calculate filter clause
    StringBuffer filter = new StringBuffer();
    if (isVendorInn.booleanValue())
        filter.append("AND " + alias3 + ".inn matches '"+vendorInn+"' ");
    if (isVendorName.booleanValue())
        filter.append("AND lower(" + alias3 + ".name) matches '"+vendorName.toLowerCase()+"' ");
    if (isNumZp.booleanValue())
        filter.append("AND lower(" + alias1 + ".numZp) matches '"+numZp.toLowerCase()+"' ");

    sqlb.append(filter);
    //executeQuery:
	//res.executeQuery(sqlb.toString(), params.toArray());
	res.executeQuery(sqlb.toString(), null );
	
	return res;
}
/**
 * Возвращает список NFS.
 * Creation date: (02.06.2004 14:17:05)
 */
public CDBCResultSet findListNFS(
    Boolean isVendorInn,    String vendorInn,
    Boolean isVendorName,    String vendorName,
    Boolean isNumSf,    String numSf,
    Boolean isIdZpNfs,    Integer idZpNfs,
    Boolean isListZpNfs,    String listZpNfs,
    Boolean isVendorCode,    String vendorCode,
    Boolean isSiteName,		String siteName,
    String aSortBy) {

    StringBuffer sqlb = new StringBuffer();
    //ArrayList params = new ArrayList();

    CDBCResultSet res = new CDBCResultSet();
    //add query string: 
    sqlb.append(findListNFS_SQL);
    //aliases:
    //String alias1 = "zp"; //nfs_zp
    //String alias2 = "dog";//nfs_contracts
    String alias3 = "vendor"; //nfs_vendors
    String alias4 = "site";//nfs_vendorsites
    String alias5 = "sf"; //nfs_sf
    //String alias6 = "pay";//nfs_pays

    //calculate filter clause
    StringBuffer filter = new StringBuffer();
    if (isVendorInn.booleanValue())
        filter.append("AND " + alias3 + ".inn matches '" + vendorInn + "' ");
    if (isVendorName.booleanValue())
        filter.append("AND lower(" + alias3 + ".name) matches '" + vendorName.toLowerCase() + "' ");
    if (isNumSf.booleanValue())
        filter.append("AND lower(" + alias5 + ".numSf) matches '" + numSf.toLowerCase() + "' ");
    if (isIdZpNfs.booleanValue())
        filter.append("AND " + alias5 + ".idZpNfs = " + idZpNfs);
    if (isListZpNfs.booleanValue()) {
        if (!listZpNfs.equals(""))
            filter.append("AND " + alias5 + ".idZpNfs in (" + listZpNfs + ") ");
        else
            filter.append("AND " + alias5 + ".idZpNfs in (-1) ");
    }
    if (isVendorCode.booleanValue())
        filter.append("AND " + alias3 + ".vendorcode = " + vendorCode + " ");
	if (isSiteName.booleanValue())
		filter.append("AND lower(" + alias4 + ".name) matches '" + siteName.toLowerCase() + "' ");

    //append order by clause:
    filter.append(" order by " + aSortBy);

    sqlb.append(filter);
    //executeQuery:
    //res.executeQuery(sqlb.toString(), params.toArray());
	System.out.println(sqlb.toString());//temp
    res.executeQuery(sqlb.toString(), null);

    return res;
}
/**
 * Возвращает список NFS.
 * Creation date: (02.06.2004 14:17:05)
 */
public CDBCResultSet findListNFS(
	Boolean isVendorInn,    String vendorInn,
	Boolean isVendorName,    String vendorName,
	Boolean isNumSf,    String numSf,
	Boolean isIdZpNfs,    Integer idZpNfs,
	Boolean isListZpNfs,    String listZpNfs,
	Boolean isVendorCode,    String vendorCode,
	Boolean isSiteName,		String siteName,
	Boolean isRegionID, Integer regionID,
	String aSortBy) {

	StringBuffer sqlb = new StringBuffer();
	ArrayList params = new ArrayList();

	CDBCResultSet res = new CDBCResultSet();
	//add query string: 
	sqlb.append(findListNFS_SQL);
	//aliases:
	//String alias1 = "zp"; //nfs_zp
	//String alias2 = "dog";//nfs_contracts
	String alias3 = "vendor"; //nfs_vendors
	String alias4 = "site";//nfs_vendorsites
	String alias5 = "sf"; //nfs_sf
	//String alias6 = "pay";//nfs_pays

	//calculate filter clause
	StringBuffer filter = new StringBuffer();
	if (isVendorInn.booleanValue()){
		filter.append("AND " + alias3 + ".inn matches(?) ");
		params.add(vendorInn);		
	}
	if (isVendorName.booleanValue()){
		filter.append("AND lower(" + alias3 + ".name) matches lower(?) ");
		params.add(vendorName);		
	}
	if (isNumSf.booleanValue()){
		filter.append("AND lower(" + alias5 + ".numSf) matches lower(?) ");
		params.add(numSf);
	}
	if (isIdZpNfs.booleanValue()){
		filter.append("AND " + alias5 + ".idZpNfs = ? ");
		params.add(idZpNfs);
	}
	if (isListZpNfs.booleanValue()) {
		if (!listZpNfs.equals(""))
			filter.append("AND " + alias5 + ".idZpNfs in (" + listZpNfs + ") ");
		else
			filter.append("AND " + alias5 + ".idZpNfs in (-1) ");
	}
	if (isVendorCode.booleanValue()){
		filter.append("AND " + alias3 + ".vendorcode = ? ");
		params.add(vendorCode);		
	}
	if (isSiteName.booleanValue()){
		filter.append("AND lower(" + alias4 + ".name) matches lower(?) ");
		params.add(siteName);		
	}
	//filter 2:	
	if (isRegionID.booleanValue()) {
		filter.append("AND sf.idorgnfs IN( SELECT idOwnerNfs FROM OwnerSystemNfs2FilialNri WHERE regionId = ? ) ");
		params.add(regionID);
	} 
	//append order by clause:
	filter.append(" order by " + aSortBy);

	sqlb.append(filter);
	//executeQuery:
	System.out.println(sqlb.toString());//temp
	res.executeQuery(sqlb.toString(), params.toArray());
	//res.executeQuery(sqlb.toString(), null);

	return res;
}
/**
 * Возвращает список NFS.
 * Creation date: (02.06.2004 14:17:05)
 */
public CDBCResultSet findListNFS(
	Boolean isVendorInn,	String vendorInn,
	Boolean isVendorName,	String vendorName,
	Boolean isNumSf,	String numSf,
	Boolean isIdZpNfs,	Integer idZpNfs,
	Boolean isListZpNfs,	String listZpNfs,
	String aSortBy) {

	StringBuffer sqlb = new StringBuffer();
	//ArrayList params = new ArrayList();

	CDBCResultSet res = new CDBCResultSet();
	//add query string: 
	sqlb.append(findListNFS_SQL);
	//aliases:
	//String alias1 = "zp"; //nfs_zp
	//String alias2 = "dog";//nfs_contracts
	String alias3 = "vendor"; //nfs_vendors
	//String alias4 = "site";//nfs_vendorsites
	String alias5 = "sf";//nfs_sf
	//String alias6 = "pay";//nfs_pays

	//calculate filter clause
	StringBuffer filter = new StringBuffer();
	if (isVendorInn.booleanValue())
		filter.append("AND " + alias3 + ".inn matches '" + vendorInn + "' ");
	if (isVendorName.booleanValue())
		filter.append("AND lower(" + alias3 + ".name) matches '" + vendorName.toLowerCase() + "' ");
	if (isNumSf.booleanValue())
		filter.append("AND lower(" + alias5 + ".numSf) matches '" + numSf.toLowerCase() + "' ");
	if (isIdZpNfs.booleanValue())
		filter.append("AND " + alias5 + ".idZpNfs = " + idZpNfs);
	if (isListZpNfs.booleanValue()) {
		if (!listZpNfs.equals(""))
			filter.append("AND " + alias5 + ".idZpNfs in (" + listZpNfs + ") ");
		else
			filter.append("AND " + alias5 + ".idZpNfs in (-1) ");
	}

	//append order by clause:
	filter.append(" order by " + aSortBy);

	sqlb.append(filter);
	//executeQuery:
	//res.executeQuery(sqlb.toString(), params.toArray());
	res.executeQuery(sqlb.toString(), null);

	return res;
}
/**
 * Возвращает список NFS.
 * Creation date: (02.06.2004 14:17:05)
 */
public CDBCResultSet findListNFS(
    Boolean isVendorInn , String vendorInn,
    Boolean isVendorName, String vendorName,
    Boolean isNumZp, String numZp,
    Boolean isIdZpNfs, Integer idZpNfs,    
    String aSortBy)
{
	    
   	StringBuffer sqlb = new StringBuffer();
	//ArrayList params = new ArrayList();

	CDBCResultSet res = new CDBCResultSet();
    //add query string: 
	sqlb.append(findListNFS_SQL);
    //aliases:
    String alias1 = "zp";//nfs_zp
    //String alias2 = "dog";//nfs_contracts
    String alias3 = "vendor";//nfs_vendors
    //String alias4 = "site";//nfs_vendorsites
    //String alias5 = "sf";//nfs_sf
    //String alias6 = "pay";//nfs_pays

    //calculate filter clause
    StringBuffer filter = new StringBuffer();
    if (isVendorInn.booleanValue())
        filter.append("AND " + alias3 + ".inn matches '"+vendorInn+"' ");
    if (isVendorName.booleanValue())
        filter.append("AND lower(" + alias3 + ".name) matches '"+vendorName.toLowerCase()+"' ");
    if (isNumZp.booleanValue())
        filter.append("AND lower(" + alias1 + ".numZp) matches '"+numZp.toLowerCase()+"' ");
    if (isIdZpNfs.booleanValue())
        filter.append("AND " + alias1 + ".idZpNfs = "+idZpNfs);        
        
    //append order by clause:
    filter.append(" order by " + aSortBy);
    
    sqlb.append(filter);
    //executeQuery:
	//res.executeQuery(sqlb.toString(), params.toArray());
	res.executeQuery(sqlb.toString(), null );
	
	return res;
}
/**
 * Возвращает список NFS.
 * Creation date: (02.06.2004 14:17:05)
 */
public CDBCResultSet findListNFS(
    Boolean isVendorInn , String vendorInn,
    Boolean isVendorName, String vendorName,
    Boolean isNumZp, String numZp, String aSortBy)
{
	    
   	StringBuffer sqlb = new StringBuffer();
	//ArrayList params = new ArrayList();

	CDBCResultSet res = new CDBCResultSet();
    //add query string: 
	sqlb.append(findListNFS_SQL);
    //aliases:
    String alias1 = "zp";//nfs_zp
    //String alias2 = "dog";//nfs_contracts
    String alias3 = "vendor";//nfs_vendors
    //String alias4 = "site";//nfs_vendorsites
    //String alias5 = "sf";//nfs_sf
    //String alias6 = "pay";//nfs_pays

    //calculate filter clause
    StringBuffer filter = new StringBuffer();
    if (isVendorInn.booleanValue())
        filter.append("AND " + alias3 + ".inn matches '"+vendorInn+"' ");
    if (isVendorName.booleanValue())
        filter.append("AND lower(" + alias3 + ".name) matches '"+vendorName.toLowerCase()+"' ");
    if (isNumZp.booleanValue())
        filter.append("AND lower(" + alias1 + ".numZp) matches '"+numZp.toLowerCase()+"' ");
        
    //append order by clause:
    filter.append(" order by " + aSortBy);
    
    sqlb.append(filter);
    //executeQuery:
	//res.executeQuery(sqlb.toString(), params.toArray());
	res.executeQuery(sqlb.toString(), null );
	
	return res;
}
/**
 * Возвращает список NFS(+).
 * Creation date: (02.06.2004 14:17:05)
 */
public CDBCResultSet findListNFS_detach(
	Integer searchFilter,		String searchString,
	Boolean isOrgExecutor,		Integer orgExecutor,	Integer orgExecutor_VendorSiteID,    
    Boolean isDateSF,    java.sql.Date fromDateSF,    java.sql.Date toDateSF,
    Boolean isDateZP,    java.sql.Date fromDateZP,    java.sql.Date toDateZP,
    Boolean isDatePays,    java.sql.Date fromDatePays,    java.sql.Date toDatePays,
    Boolean isDatePaysP,    java.sql.Date fromDatePaysP,    java.sql.Date toDatePaysP,
	Boolean isRegionID,		Integer regionID,    
    String aSortBy) {

    StringBuffer sqlb = new StringBuffer();
    ArrayList params = new ArrayList();

    CDBCResultSet res = new CDBCResultSet();
    boolean isAll = searchFilter.intValue()==0;//признак выбора "Все"
	boolean isNumSf = searchFilter.intValue()==2;//признак выбора "isNumSf"
	boolean isNumZp = searchFilter.intValue()==3;//признак выбора "isNumZp"
	//при пустых значениях возвращаем пустой список:
	if (isNumSf && "".equals(searchString.trim())){
		return res;
	}
	if (isNumZp && "".equals(searchString.trim())){
		return res;
	}		
    //add query string:
    if (isNumSf || isAll) {
        sqlb.append(findListNFS_selectSQL);
        sqlb.append(findListNFS_fromSfSQL);
        if (isDatePays.booleanValue() || isDatePaysP.booleanValue())
            sqlb.append(" nfs_pays pay, ");
        else
            sqlb.append(" outer nfs_pays pay, ");
        if (isDateZP.booleanValue())
            sqlb.append(" nfs_zp zp, outer nfs_contracts dog ");
        else
            sqlb.append(" outer (nfs_zp zp, outer nfs_contracts dog) ");
        sqlb.append(findListNFS_whereSfSQL);

        //calculate filter clause
        StringBuffer filter = new StringBuffer();
        if (isNumSf){
			//filter.append(" AND lower(sf.numSf) matches '" + searchString.toLowerCase() + "' ");
			filter.append(" AND lower(sf.numSf) matches lower(?) ");
			params.add(searchString);        	
        }
        if (isDateSF.booleanValue()) {
            filter.append(" AND sf.datecreate >= ? AND sf.datecreate <= ? ");
            params.add(fromDateSF);
            params.add(toDateSF);
        }
        if (isDateZP.booleanValue()) {
            filter.append(" AND zp.datecreate >= ? AND zp.datecreate <= ? ");
            params.add(fromDateZP);
            params.add(toDateZP);
        }
        if (isDatePays.booleanValue()) {
            filter.append(" AND pay.datecreate >= ? AND pay.datecreate <= ? ");
            params.add(fromDatePays);
            params.add(toDatePays);
        }
        if (isDatePaysP.booleanValue()) {
            filter.append(" AND pay.datepay >= ? AND pay.datepay <= ? ");
            params.add(fromDatePays);
            params.add(toDatePays);
        }
		if (isOrgExecutor != null && isOrgExecutor.booleanValue() && orgExecutor != null && orgExecutor.intValue() != -1 ) {
			if(orgExecutor_VendorSiteID.intValue() == -1){
				//поиск по всем отделениям заказчика(арендадателя):
				filter.append("AND site.idVendorNfs = ( SELECT idVendorNfs FROM vendors WHERE idVendor = ? ) ");
				//params.add(regionID);
				params.add(orgExecutor);
			}else{
				filter.append("AND site.idVendorSiteNfs = ( SELECT idVendorSiteNfs FROM vendorSites WHERE idVendorSite = ? ) ");
				params.add(orgExecutor_VendorSiteID);
			}
		}
		if (isRegionID.booleanValue()) {
			filter.append("AND site.idOrgNfs IN( SELECT idOwnerNfs FROM OwnerSystemNfs2FilialNri WHERE regionId = ? ) ");
			params.add(regionID);
			
			//@TODO: Temproraly commented out by DD 27.10.2006 till 01.11.2006
			if ( (regionID != null) && (regionID.intValue() != 1) ) {
				filter.append("AND (sf.userCreate IN( SELECT idUserNfs FROM nfs_users WHERE regionId = ? ) OR sf.userModify IN( SELECT idUserNfs FROM nfs_users WHERE regionId = ? ) )");
				params.add(regionID);
				params.add(regionID);			
			}
		}
        sqlb.append(filter);
    }
    
	if (isAll) {
		sqlb.append(" UNION ");
	}    

    if (isNumZp || isAll) {
        sqlb.append(findListNFS_selectSQL);
        sqlb.append(findListNFS_fromZpSQL);
        if (isDateSF.booleanValue() && (isDatePays.booleanValue() || isDatePaysP.booleanValue()))
            sqlb.append(" nfs_sf sf, nfs_pays pay, ");
        else if (!isDateSF.booleanValue() && !(isDatePays.booleanValue() || isDatePaysP.booleanValue()))
            sqlb.append("outer (nfs_sf sf, outer nfs_pays pay),");
        else if (isDateSF.booleanValue() && !(isDatePays.booleanValue() || isDatePaysP.booleanValue()))
            sqlb.append("nfs_sf sf, outer nfs_pays pay, ");
        else if (!isDateSF.booleanValue() && (isDatePays.booleanValue() || isDatePaysP.booleanValue()))
            sqlb.append("outer nfs_sf sf, nfs_pays pay, ");
        sqlb.append(" outer nfs_contracts dog ");
        sqlb.append(findListNFS_whereZpSQL);

        //calculate filter clause
        StringBuffer filter = new StringBuffer();
        if (isNumZp){
			//filter.append(" AND lower(zp.numZp) matches '" + searchString.toLowerCase() + "' ");        	
			filter.append(" AND lower(zp.numZp) matches lower(?) ");
			params.add(searchString);
        }
        if (isDateSF.booleanValue()) {
            filter.append(" AND sf.datecreate >= ? AND sf.datecreate <= ? ");
            params.add(fromDateSF);
            params.add(toDateSF);
        }
        if (isDateZP.booleanValue()) {
            filter.append(" AND zp.datecreate >= ? AND zp.datecreate <= ? ");
            params.add(fromDateZP);
            params.add(toDateZP);
        }
        if (isDatePays.booleanValue()) {
            filter.append(" AND pay.datecreate >= ? AND pay.datecreate <= ? ");
            params.add(fromDatePays);
            params.add(toDatePays);
        }
        if (isDatePaysP.booleanValue()) {
            filter.append(" AND pay.datepay >= ? AND pay.datepay <= ? ");
            params.add(fromDatePays);
            params.add(toDatePays);
        }
		if (isOrgExecutor != null && isOrgExecutor.booleanValue() && orgExecutor != null && orgExecutor.intValue() != -1 ) {
			if(orgExecutor_VendorSiteID.intValue() == -1){
				//поиск по всем отделениям заказчика(арендадателя):
				filter.append("AND site.idVendorNfs = ( SELECT idVendorNfs FROM vendors WHERE idVendor = ? ) ");
				//params.add(regionID);
				params.add(orgExecutor);
			}else{
				filter.append("AND site.idVendorSiteNfs = ( SELECT idVendorSiteNfs FROM vendorSites WHERE idVendorSite = ? ) ");
				params.add(orgExecutor_VendorSiteID);
			}
		}
		if (isRegionID.booleanValue()) {
			filter.append("AND site.idOrgNfs IN( SELECT idOwnerNfs FROM OwnerSystemNfs2FilialNri WHERE regionId = ? ) ");
			params.add(regionID);
			//@TODO: Temproraly commented out by DD 27.10.2006 till 01.11.2006
			if ( (regionID != null) && (regionID.intValue() != 1) ) {
				filter.append("AND (zp.userCreate IN( SELECT idUserNfs FROM nfs_users WHERE regionId = ? ) OR zp.userModify IN( SELECT idUserNfs FROM nfs_users WHERE regionId = ? ) )");
				params.add(regionID);
				params.add(regionID);
			}			
		}
        sqlb.append(filter);
    }
    //append order by clause:
    if (aSortBy.startsWith("numZp"))
        sqlb.append(" order by 2");
    else if (aSortBy.startsWith("numSf"))
        sqlb.append(" order by 9");
    else if (aSortBy.startsWith("sumSf"))
        sqlb.append(" order by 12");
    else if (aSortBy.startsWith("stateSf"))
        sqlb.append(" order by 10");
    else if (aSortBy.startsWith("numPay"))
        sqlb.append(" order by 16");
    else if (aSortBy.startsWith("datePay"))
        sqlb.append(" order by 17");
    else if (aSortBy.startsWith("statePay"))
        sqlb.append(" order by 18");
    else if (aSortBy.startsWith("sumPay"))
        sqlb.append(" order by 19");
    else if (aSortBy.startsWith("sumRubPay"))
        sqlb.append(" order by 21");
    if (aSortBy.endsWith(" desc"))
        sqlb.append(" desc");

    //executeQuery:
    //res.executeQuery(sqlb.toString(), null);
    System.out.println("sql=" + sqlb.toString()); //temp
	System.out.println("params=" + params); //temp
    res.executeQuery(sqlb.toString(), params.toArray());

    return res;
}

/**
 * Возвращает список NFS.
 * Creation date: (02.06.2004 14:17:05)
 */
public CDBCResultSet findListNFS_detach(
    Boolean isVendorInn,    String vendorInn,
    Boolean isVendorName,    String vendorName,
    Boolean isNumSf,    String numSf,
    Boolean isNumZp,    String numZp,
    Boolean isVendorCode,    String vendorCode,    
    Boolean isDateSF,    java.sql.Date fromDateSF,    java.sql.Date toDateSF,
    Boolean isDateZP,    java.sql.Date fromDateZP,    java.sql.Date toDateZP,
    Boolean isDatePays,    java.sql.Date fromDatePays,    java.sql.Date toDatePays,
    Boolean isDatePaysP,    java.sql.Date fromDatePaysP,    java.sql.Date toDatePaysP,
    Boolean isFilterBeeline,    Integer filterBeeline,
    String aSortBy) {

    StringBuffer sqlb = new StringBuffer();
    ArrayList params = new ArrayList();

    CDBCResultSet res = new CDBCResultSet();
    //add query string:
    if (isNumSf.booleanValue()
        || isVendorInn.booleanValue()
        || isVendorName.booleanValue()
        || isVendorCode.booleanValue()) {
        sqlb.append(findListNFS_selectSQL);
        sqlb.append(findListNFS_fromSfSQL);
        if (isDatePays.booleanValue() || isDatePaysP.booleanValue())
            sqlb.append(" nfs_pays pay, ");
        else
            sqlb.append(" outer nfs_pays pay, ");
        if (isDateZP.booleanValue())
            sqlb.append(" nfs_zp zp, outer nfs_contracts dog ");
        else
            sqlb.append(" outer (nfs_zp zp, outer nfs_contracts dog) ");
        sqlb.append(findListNFS_whereSfSQL);

        //calculate filter clause
        StringBuffer filter = new StringBuffer();
        if (isVendorInn.booleanValue())
            filter.append(" AND vendor.inn matches '" + vendorInn + "' ");
        if (isVendorName.booleanValue())
            filter.append(" AND lower(vendor.name) matches '" + vendorName.toLowerCase() + "' ");
        if (isNumSf.booleanValue())
            filter.append(" AND lower(sf.numSf) matches '" + numSf.toLowerCase() + "' ");
        if (isDateSF.booleanValue()) {
            filter.append(" AND sf.datecreate >= ? AND sf.datecreate <= ? ");
            params.add(fromDateSF);
            params.add(toDateSF);
        }
        if (isDateZP.booleanValue()) {
            filter.append(" AND zp.datecreate >= ? AND zp.datecreate <= ? ");
            params.add(fromDateZP);
            params.add(toDateZP);
        }
        if (isDatePays.booleanValue()) {
            filter.append(" AND pay.datecreate >= ? AND pay.datecreate <= ? ");
            params.add(fromDatePays);
            params.add(toDatePays);
        }
        if (isDatePaysP.booleanValue()) {
            filter.append(" AND pay.datepay >= ? AND pay.datepay <= ? ");
            params.add(fromDatePays);
            params.add(toDatePays);
        }
        if (isFilterBeeline.booleanValue()) {
            filter.append(" AND sf.idorgnfs= " + filterBeeline + " ");
        }
        if (isVendorCode.booleanValue())
            filter.append(" AND vendor.vendorcode = " + vendorCode + " ");

        sqlb.append(filter);
    }

    if (isVendorInn.booleanValue() || isVendorName.booleanValue() || isVendorCode.booleanValue()) {
        sqlb.append(" UNION ");
    }

    if (isNumZp.booleanValue()
        || isVendorInn.booleanValue()
        || isVendorName.booleanValue()
        || isVendorCode.booleanValue()) {
        sqlb.append(findListNFS_selectSQL);
        sqlb.append(findListNFS_fromZpSQL);
        if (isDateSF.booleanValue() && (isDatePays.booleanValue() || isDatePaysP.booleanValue()))
            sqlb.append(" nfs_sf sf, nfs_pays pay, ");
        else if (!isDateSF.booleanValue() && !(isDatePays.booleanValue() || isDatePaysP.booleanValue()))
            sqlb.append("outer (nfs_sf sf, outer nfs_pays pay),");
        else if (isDateSF.booleanValue() && !(isDatePays.booleanValue() || isDatePaysP.booleanValue()))
            sqlb.append("nfs_sf sf, outer nfs_pays pay, ");
        else if (!isDateSF.booleanValue() && (isDatePays.booleanValue() || isDatePaysP.booleanValue()))
            sqlb.append("outer nfs_sf sf, nfs_pays pay, ");
        sqlb.append(" outer nfs_contracts dog ");
        sqlb.append(findListNFS_whereZpSQL);

        //calculate filter clause
        StringBuffer filter = new StringBuffer();
        if (isVendorInn.booleanValue())
            filter.append(" AND vendor.inn matches '" + vendorInn + "' ");
        if (isVendorName.booleanValue())
            filter.append(" AND lower(vendor.name) matches '" + vendorName.toLowerCase() + "' ");
        if (isNumZp.booleanValue())
            filter.append(" AND lower(zp.numZp) matches '" + numZp.toLowerCase() + "' ");
        if (isDateSF.booleanValue()) {
            filter.append(" AND sf.datecreate >= ? AND sf.datecreate <= ? ");
            params.add(fromDateSF);
            params.add(toDateSF);
        }
        if (isDateZP.booleanValue()) {
            filter.append(" AND zp.datecreate >= ? AND zp.datecreate <= ? ");
            params.add(fromDateZP);
            params.add(toDateZP);
        }
        if (isDatePays.booleanValue()) {
            filter.append(" AND pay.datecreate >= ? AND pay.datecreate <= ? ");
            params.add(fromDatePays);
            params.add(toDatePays);
        }
        if (isDatePaysP.booleanValue()) {
            filter.append(" AND pay.datepay >= ? AND pay.datepay <= ? ");
            params.add(fromDatePays);
            params.add(toDatePays);
        }
        if (isFilterBeeline.booleanValue()) {
            filter.append(" AND zp.idorgnfs= " + filterBeeline + " ");
        }
        if (isVendorCode.booleanValue())
            filter.append(" AND vendor.vendorcode = " + vendorCode + " ");

        sqlb.append(filter);
    }
    //append order by clause:
    if (aSortBy.startsWith("numZp"))
        sqlb.append(" order by 2");
    else if (aSortBy.startsWith("numSf"))
        sqlb.append(" order by 9");
    else if (aSortBy.startsWith("sumSf"))
        sqlb.append(" order by 12");
    else if (aSortBy.startsWith("stateSf"))
        sqlb.append(" order by 10");
    else if (aSortBy.startsWith("numPay"))
        sqlb.append(" order by 16");
    else if (aSortBy.startsWith("datePay"))
        sqlb.append(" order by 17");
    else if (aSortBy.startsWith("statePay"))
        sqlb.append(" order by 18");
    else if (aSortBy.startsWith("sumPay"))
        sqlb.append(" order by 19");
    else if (aSortBy.startsWith("sumRubPay"))
        sqlb.append(" order by 21");
    if (aSortBy.endsWith(" desc"))
        sqlb.append(" desc");

    //executeQuery:
    //res.executeQuery(sqlb.toString(), null);
    System.out.println(sqlb.toString()); //temp
    res.executeQuery(sqlb.toString(), params.toArray());

    return res;
}
/**
 * Возвращает список NFS.
 * Creation date: (02.06.2004 14:17:05)
 */
public CDBCResultSet findListNFS_detach(
    Boolean isVendorInn,    String vendorInn,
    Boolean isVendorName,    String vendorName,
    Boolean isNumSf,    String numSf,
    Boolean isNumZp,    String numZp,
    Boolean isDateSF,    java.sql.Date fromDateSF,    java.sql.Date toDateSF,
    Boolean isDateZP,    java.sql.Date fromDateZP,    java.sql.Date toDateZP,
    Boolean isDatePays,    java.sql.Date fromDatePays,    java.sql.Date toDatePays,
    Boolean isDatePaysP,    java.sql.Date fromDatePaysP,    java.sql.Date toDatePaysP,    
    Boolean isFilterBeeline,    Integer filterBeeline,
    String aSortBy) {

    StringBuffer sqlb = new StringBuffer();
    ArrayList params = new ArrayList();

    CDBCResultSet res = new CDBCResultSet();
    //add query string:
    if (isNumSf.booleanValue() || isVendorInn.booleanValue() || isVendorName.booleanValue()) {
        sqlb.append(findListNFS_selectSQL);
        sqlb.append(findListNFS_fromSfSQL);
        if (isDatePays.booleanValue() || isDatePaysP.booleanValue())
            sqlb.append(" nfs_pays pay, ");
        else
            sqlb.append(" outer nfs_pays pay, ");
        if (isDateZP.booleanValue())
            sqlb.append(" nfs_zp zp, outer nfs_contracts dog ");
        else
            sqlb.append(" outer (nfs_zp zp, outer nfs_contracts dog) ");
        sqlb.append(findListNFS_whereSfSQL);

        //calculate filter clause
        StringBuffer filter = new StringBuffer();
        if (isVendorInn.booleanValue())
            filter.append(" AND vendor.inn matches '" + vendorInn + "' ");
        if (isVendorName.booleanValue())
            filter.append(" AND lower(vendor.name) matches '" + vendorName.toLowerCase() + "' ");
        if (isNumSf.booleanValue())
            filter.append(" AND lower(sf.numSf) matches '" + numSf.toLowerCase() + "' ");
        if (isDateSF.booleanValue()) {
            filter.append(" AND sf.datecreate >= ? AND sf.datecreate <= ? ");
            params.add(fromDateSF);
            params.add(toDateSF);
        }
        if (isDateZP.booleanValue()) {
            filter.append(" AND zp.datecreate >= ? AND zp.datecreate <= ? ");
            params.add(fromDateZP);
            params.add(toDateZP);
        }
        if (isDatePays.booleanValue()) {
            filter.append(" AND pay.datecreate >= ? AND pay.datecreate <= ? ");
            params.add(fromDatePays);
            params.add(toDatePays);
        }
        if (isDatePaysP.booleanValue()) {
            filter.append(" AND pay.datepay >= ? AND pay.datepay <= ? ");
            params.add(fromDatePays);
            params.add(toDatePays);
        }        
        if (isFilterBeeline.booleanValue()) {
            filter.append(" AND sf.idorgnfs= " + filterBeeline + " ");
        }
        sqlb.append(filter);
    }

    if (isVendorInn.booleanValue() || isVendorName.booleanValue()) {
        sqlb.append(" UNION ");
    }
    
    if (isNumZp.booleanValue() || isVendorInn.booleanValue() || isVendorName.booleanValue()) {
        sqlb.append(findListNFS_selectSQL);
        sqlb.append(findListNFS_fromZpSQL);
        if (isDateSF.booleanValue() && (isDatePays.booleanValue() || isDatePaysP.booleanValue()))
            sqlb.append(" nfs_sf sf, nfs_pays pay, ");
        else if (!isDateSF.booleanValue() && !(isDatePays.booleanValue() || isDatePaysP.booleanValue()))
            sqlb.append("outer (nfs_sf sf, outer nfs_pays pay),");
        else if (isDateSF.booleanValue() && !(isDatePays.booleanValue() || isDatePaysP.booleanValue()))
            sqlb.append("nfs_sf sf, outer nfs_pays pay, ");
        else if (!isDateSF.booleanValue() && (isDatePays.booleanValue() || isDatePaysP.booleanValue()))
            sqlb.append("outer nfs_sf sf, nfs_pays pay, ");
        sqlb.append(" outer nfs_contracts dog ");
        sqlb.append(findListNFS_whereZpSQL);

        //calculate filter clause
        StringBuffer filter = new StringBuffer();
        if (isVendorInn.booleanValue())
            filter.append(" AND vendor.inn matches '" + vendorInn + "' ");
        if (isVendorName.booleanValue())
            filter.append(" AND lower(vendor.name) matches '" + vendorName.toLowerCase() + "' ");
        if (isNumZp.booleanValue())
            filter.append(" AND lower(zp.numZp) matches '" + numZp.toLowerCase() + "' ");
        if (isDateSF.booleanValue()) {
            filter.append(" AND sf.datecreate >= ? AND sf.datecreate <= ? ");
            params.add(fromDateSF);
            params.add(toDateSF);
        }
        if (isDateZP.booleanValue()) {
            filter.append(" AND zp.datecreate >= ? AND zp.datecreate <= ? ");
            params.add(fromDateZP);
            params.add(toDateZP);
        }
        if (isDatePays.booleanValue()) {
            filter.append(" AND pay.datecreate >= ? AND pay.datecreate <= ? ");
            params.add(fromDatePays);
            params.add(toDatePays);
        }
        if (isDatePaysP.booleanValue()) {
            filter.append(" AND pay.datepay >= ? AND pay.datepay <= ? ");
            params.add(fromDatePays);
            params.add(toDatePays);
        }          
        if (isFilterBeeline.booleanValue()) {
            filter.append(" AND zp.idorgnfs= " + filterBeeline + " ");
        }
        sqlb.append(filter);
    }
    //append order by clause:
    if(aSortBy.startsWith("numZp"))
    	sqlb.append(" order by 2");
    else if(aSortBy.startsWith("numSf"))
    	sqlb.append(" order by 9");
    else if(aSortBy.startsWith("sumSf"))
    	sqlb.append(" order by 12");
    else if(aSortBy.startsWith("stateSf"))
    	sqlb.append(" order by 10");
    else if(aSortBy.startsWith("numPay"))
    	sqlb.append(" order by 16");
    else if(aSortBy.startsWith("datePay"))
    	sqlb.append(" order by 17");
    else if(aSortBy.startsWith("statePay"))
    	sqlb.append(" order by 18");
    else if(aSortBy.startsWith("sumPay"))
    	sqlb.append(" order by 19");
    else if(aSortBy.startsWith("sumRubPay"))
    	sqlb.append(" order by 21");
    if(aSortBy.endsWith(" desc"))
    	sqlb.append(" desc");

    //executeQuery:
    //res.executeQuery(sqlb.toString(), null);
    System.out.println(sqlb.toString()); //temp
    res.executeQuery(sqlb.toString(), params.toArray());

    return res;
}
/**
 * Возвращает список NFS.
 * Creation date: (02.06.2004 14:17:05)
 */
public CDBCResultSet findListNFS_detach(
    Boolean isVendorInn,
    String vendorInn,
    Boolean isVendorName,
    String vendorName,
    Boolean isNumSf,
    String numSf,
    Boolean isNumZp,
    String numZp,
    String aSortBy) {

    StringBuffer sqlb = new StringBuffer();
    //ArrayList params = new ArrayList();

    CDBCResultSet res = new CDBCResultSet();
    //add query string:
    if (isNumZp.booleanValue())
        sqlb.append(findListNFS_detach_SQL);
    else
        sqlb.append(findListNFS_SQL);

     //calculate filter clause
    StringBuffer filter = new StringBuffer();
    if (isVendorInn.booleanValue())
        filter.append("AND vendor.inn matches '" + vendorInn + "' ");
    if (isVendorName.booleanValue())
        filter.append("AND lower(vendor.name) matches '" + vendorName.toLowerCase() + "' ");
    if (isNumSf.booleanValue())
        filter.append("AND lower(sf.numSf) matches '" + numSf.toLowerCase() + "' ");
    if (isNumZp.booleanValue())
        filter.append("AND lower(zp.numZp) matches '" + numZp.toLowerCase() + "' ");

    //append order by clause:
    filter.append(" order by " + aSortBy);

    sqlb.append(filter);
    //executeQuery:
    //res.executeQuery(sqlb.toString(), params.toArray());
    //System.out.println(sqlb.toString());//temp
    res.executeQuery(sqlb.toString(), null);

    return res;
}
/**
 * Возвращает список NFS.
 * Creation date: (02.06.2004 14:17:05)
 */
public CDBCResultSet findLookupListZP(
	Integer filter, String searchString,
	Boolean isAllVendorSite, Integer idVendorSiteNfs,	
	Boolean isRegionID, Integer regionID,
    String aSortBy)
{
	    
   	StringBuffer sqlb = new StringBuffer();
	ArrayList params = new ArrayList();

	CDBCResultSet res = new CDBCResultSet();
    //add query string: 
	sqlb.append(findListZP_SQL);
    //aliases:
    String alias1 = "zp";//nfs_zp
    //String alias2 = "dog";//nfs_contracts
    String alias3 = "vendor";//nfs_vendors
    //String alias4 = "site";//nfs_vendorsites
    //String alias5 = "sf";//nfs_sf
    //String alias6 = "pay";//nfs_pays

    //calculate filter clause
    StringBuffer sb = new StringBuffer();
	//filter searchString:
    if (filter.intValue() == 1){
		sb.append("AND " + alias3 + ".inn matches(?) ");
		params.add(searchString); 
    }
    else if (filter.intValue() == 2){
		sb.append("AND upper(" + alias3 + ".name) matches upper(?) ");
		params.add(searchString);    	
    }
    else if (filter.intValue() == 3){
		sb.append("AND upper(" + alias1 + ".numZp) matches upper(?) ");
		params.add(searchString);    	
    }
    else if(filter.intValue() == 4){
		sb.append("AND zp.idcontractnfs in (select cn.idcontractnfs from nfs_contracts cn  where lower(cn.numcontract) matches lower(?) )");
		params.add(searchString);    	
    }
    else if(filter.intValue() == 5){
    	sb.append("AND "+alias3+".vendorcode = ? ");
		params.add(searchString);
    }    	
    //filter 2:
	if (!isAllVendorSite.booleanValue()) {
		sb.append("AND "+alias1+".idVendorSiteNfs = ? ");
		params.add(idVendorSiteNfs);
	}    
    
	//filter 3:	
	if (isRegionID.booleanValue()) {
		sb.append("AND " + alias1 + ".idorgnfs IN( SELECT idOwnerNfs FROM OwnerSystemNfs2FilialNri WHERE regionId = ? ) ");
		params.add(regionID);
	}    	
        
    //append order by clause:
    sb.append(" order by " + aSortBy);
    
    sqlb.append(sb);
	System.out.println(sqlb.toString());//temp    
    //executeQuery:
	res.executeQuery(sqlb.toString(), params.toArray());
	//res.executeQuery(sqlb.toString(), null );
	
	return res;
}
/**
 * Возвращает список NFS.
 * Creation date: (02.06.2004 14:17:05)
 */
public CDBCResultSet findListZP(
    Boolean isVendorInn , String vendorInn,
    Boolean isVendorName, String vendorName,
    Boolean isNumZp, String numZp,
    Boolean isNumContract, String numContract,
    String aSortBy)
{
	    
   	StringBuffer sqlb = new StringBuffer();
	//ArrayList params = new ArrayList();

	CDBCResultSet res = new CDBCResultSet();
    //add query string: 
	sqlb.append(findListZP_SQL);
    //aliases:
    String alias1 = "zp";//nfs_zp
    //String alias2 = "dog";//nfs_contracts
    String alias3 = "vendor";//nfs_vendors
    //String alias4 = "site";//nfs_vendorsites
    //String alias5 = "sf";//nfs_sf
    //String alias6 = "pay";//nfs_pays

    //calculate filter clause
    StringBuffer filter = new StringBuffer();
    if (isVendorInn.booleanValue())
        filter.append("AND " + alias3 + ".inn matches '"+vendorInn+"' ");
    if (isVendorName.booleanValue())
        filter.append("AND lower(" + alias3 + ".name) matches '"+vendorName.toLowerCase()+"' ");
    if (isNumZp.booleanValue())
        filter.append("AND lower(" + alias1 + ".numZp) matches '"+numZp.toLowerCase()+"' ");
    if(isNumContract.booleanValue())
    	filter.append("AND zp.idcontractnfs in (select cn.idcontractnfs from nfs_contracts cn  where lower(cn.numcontract) matches ('"+numContract.toLowerCase()+"') )");
        
    //append order by clause:
    filter.append(" order by " + aSortBy);
    
    sqlb.append(filter);
    //executeQuery:
	//res.executeQuery(sqlb.toString(), params.toArray());
	//System.out.println(sqlb.toString());//temp
	res.executeQuery(sqlb.toString(), null );
	
	return res;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 11:25:50)
 * @param idzpNfs int
 */
public static CDBCResultSet findListZP_NFS_forArendaAgreement(Integer idDoc) {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findListZP_NFS_forArendaAgreement_SQL + "AND lzp.leaseDocument = " + idDoc;
	res.executeQuery(sql, null);
	return res;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 11:44:42)
 * @return com.hps.july.cdbc.lib.CDBCRowObject
 * @param idPayNfs int
 */
public static CDBCRowObject findPay_NFS(int idPayNfs) {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findPay_NFS_SQL + "pay.idPayNfs = " + idPayNfs + " AND pay.idSfNfs = sf.idSfNfs";
	res.executeQuery(sql, null);
	ListIterator list = res.listIterator();
	if (list.hasNext())
		return (CDBCRowObject) list.next();
	else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2004 15:51:33)
 * @return com.hps.july.cdbc.lib.CDBCRowObject
 * @param idSfNfs int
 */
public static CDBCRowObject findSchetFakt_NFS(int idSfNfs) {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findSchetFakt_NFS_SQL + "sf.idSfNfs = " + idSfNfs;
	res.executeQuery(sql, null);
	ListIterator list = res.listIterator();
	if (list.hasNext())
		return (CDBCRowObject) list.next();
	else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2004 11:25:50)
 * @param idzpNfs int
 */
public static CDBCRowObject findZP_NFS(int idzpNfs) {
	CDBCResultSet res = new CDBCResultSet();
	String sql = findZP_NFS_SQL + "zp.idzpNfs = " + idzpNfs;
	res.executeQuery(sql, null);
	ListIterator list = res.listIterator();
	if (list.hasNext())
		return (CDBCRowObject) list.next();
	else
		return null;
}
/**
 * Starts the application.
 * @param args an array of command-line arguments
 */
public static void main(java.lang.String[] args) {
	boolean test1 = false;
	boolean test2 = false;
	boolean test3 = false;
	boolean test4 = false;
	boolean test5 = false;
	boolean test6 = true;
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	if (test1) {
		CDBCResultSet rs = new CDBC_NFS_Object().findListNFS(Boolean.TRUE, "1*", Boolean.FALSE, "*", Boolean.TRUE, "*1*");
		java.util.ListIterator it = rs.listIterator();
		int count = 0;
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			com.hps.july.arenda.valueobject.NFS_VO vo = new com.hps.july.arenda.valueobject.NFS_VO(ro);
			count++;
			if (vo.getPayNFS() != null)
				System.out.println("IdPayNfs : " + vo.getPayNFS().getIdPayNfs() + " sumPay: '" + vo.getPayNFS().getSumPay() + "'");
			if (vo.getSchetFaktNFS() != null)
				System.out.println("CurrSf : " + vo.getSchetFaktNFS().getCurrSf() + "NumSf: '" + vo.getSchetFaktNFS().getNumSf() + "'");
			if (vo.getZpNFS() != null) {
				System.out.println("IdZpNfs : " + vo.getZpNFS().getIdZpNfs() + "NumZP: '" + vo.getZpNFS().getNumZp() + "'");
			}
		}
		System.out.println("count findListNFS =" + count);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	if (test2) {
		int idZP = 35320; //
		CDBCRowObject ro = CDBC_NFS_Object.findZP_NFS(idZP);
		if (ro != null) {
			com.hps.july.arenda.valueobject.NFS_ZP_VO zp = new com.hps.july.arenda.valueobject.NFS_ZP_VO(ro);
			zp.initVendor(ro);
			zp.initSite(ro);
			System.out.println("find ZP NFS result: " + zp);
			System.out.println("vendor: " + zp.getVendor());
			System.out.println("site: " + zp.getSite());
		} else
			System.out.println("find ZP NFS result: null");
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	if (test3) {
		int idSf = 126471; //
		CDBCRowObject ro = CDBC_NFS_Object.findSchetFakt_NFS(idSf);
		if (ro != null) {
			com.hps.july.arenda.valueobject.NFS_SchetFakt_VO sf = new com.hps.july.arenda.valueobject.NFS_SchetFakt_VO(ro);
			System.out.println("find SchetFakt NFS result: " + sf);
			sf.calcNds(ro);
			System.out.println("SchetFakt NFS nds=" + sf.getNds());
			sf.initRecipient(ro);
			System.out.println("SchetFakt NFS recipient: " + sf.getRecipient());
			sf.initAccount(ro);
			System.out.println("account: " + sf.getAccount());
			System.out.println("account.bank: " + sf.getAccount().getBank());
		} else
			System.out.println("find SchetFakt NFS result: null");
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	if (test4) {
		int idPay = 50470;
		CDBCRowObject ro = CDBC_NFS_Object.findPay_NFS(idPay);
		if (ro != null) {
			com.hps.july.arenda.valueobject.NFS_Pay_VO pay = new com.hps.july.arenda.valueobject.NFS_Pay_VO(ro);
			System.out.println("find Pay NFS result: " + pay);
			pay.calcNds(ro);
			System.out.println("Pay NFS SumNdsRub=" + pay.getSumNdsRub());
			pay.initRecipient(ro);
			System.out.println("Pay NFS recipient: " + pay.getRecipient());
			pay.initAccount(ro);
			System.out.println("account: " + pay.getAccount());
			System.out.println("account.bank: " + pay.getAccount().getBank());
		} else
			System.out.println("find Pay NFS result: null");
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	if (test5) {
		int idContract = 21560; //
		CDBCRowObject ro = CDBC_NFS_Object.findContract_NFS(idContract);
		if (ro != null) {
			com.hps.july.arenda.valueobject.NFS_Contract_VO contract = new com.hps.july.arenda.valueobject.NFS_Contract_VO(ro);
			System.out.println("find Contract NFS result: " + contract);
		} else
			System.out.println("find Contract NFS result: null");
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	if (test6) {
		Integer idDoc = new Integer(4271); //test083(4271)
		CDBCResultSet rs = CDBC_NFS_Object.findListZP_NFS_forArendaAgreement(idDoc);
		java.util.ListIterator it = rs.listIterator();
		int count = 0;
		while (it.hasNext()) {
			count++;
			CDBCRowObject ro = (CDBCRowObject) it.next();
			com.hps.july.arenda.valueobject.NFS_ZP_forArendaAgreement_VO zp =
				new com.hps.july.arenda.valueobject.NFS_ZP_forArendaAgreement_VO(ro);
			zp.initVendor(ro);
			zp.initSite(ro);
			System.out.print(": " + count + " zpAgr:" + zp);
			System.out.print("; zpAgr.vendor: " + zp.getVendor());
			System.out.println("; zpAgr.site: " + zp.getSite());
		}
		System.out.println("count findListZP_NFS_forArendaAgreement=" + count);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////
}
/**
 * Возвращает список NFS.
 * Creation date: (02.06.2004 14:17:05)
 */
public CDBCResultSet findListZP(
	Boolean isVendorInn , String vendorInn,
	Boolean isVendorName, String vendorName,
	Boolean isNumZp, String numZp,
	Boolean isNumContract, String numContract,
	Boolean isVendorCode, String vendorCode,
	String aSortBy)
{
	    
	StringBuffer sqlb = new StringBuffer();
	//ArrayList params = new ArrayList();

	CDBCResultSet res = new CDBCResultSet();
	//add query string: 
	sqlb.append(findListZP_SQL);
	//aliases:
	String alias1 = "zp";//nfs_zp
	//String alias2 = "dog";//nfs_contracts
	String alias3 = "vendor";//nfs_vendors
	//String alias4 = "site";//nfs_vendorsites
	//String alias5 = "sf";//nfs_sf
	//String alias6 = "pay";//nfs_pays

	//calculate filter clause
	StringBuffer filter = new StringBuffer();
	if (isVendorInn.booleanValue())
		filter.append("AND " + alias3 + ".inn matches '"+vendorInn+"' ");
	if (isVendorName.booleanValue())
		filter.append("AND lower(" + alias3 + ".name) matches '"+vendorName.toLowerCase()+"' ");
	if (isNumZp.booleanValue())
		filter.append("AND lower(" + alias1 + ".numZp) matches '"+numZp.toLowerCase()+"' ");
	if(isNumContract.booleanValue())
		filter.append("AND zp.idcontractnfs in (select cn.idcontractnfs from nfs_contracts cn  where lower(cn.numcontract) matches ('"+numContract.toLowerCase()+"') )");
	if(isVendorCode.booleanValue())
		filter.append("AND "+alias3+".vendorcode = "+vendorCode+" ");
    	
        
	//append order by clause:
	filter.append(" order by " + aSortBy);
    
	sqlb.append(filter);
	//executeQuery:
	//res.executeQuery(sqlb.toString(), params.toArray());
	//System.out.println(sqlb.toString());//temp
	res.executeQuery(sqlb.toString(), null );
	
	return res;
}}
