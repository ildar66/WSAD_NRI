package com.hps.july.arenda.cdbcobjects;

import java.util.*;
import java.math.BigDecimal;
import java.sql.*;

import com.hps.july.arenda.formbean.AbstractRegistryBuchDocsStateFactory;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.logic.DataPeriod;
import com.hps.july.cdbc.lib.*;
import com.hps.july.util.*;
import com.hps.july.terrabyte.ext.client.*;
import com.hps.july.terrabyte.core.*;
import com.hps.july.valueobject.*;

/**
 * "—писок документов дл€ передачи в бухгалтерию" CDBC_Object.
 * Creation date: (07.11.2005 12:14:30)
 * @author: Shafigullin Ildar
 */
public class CDBC_LeaseRegistryBuchDocs_Object {
	public final static int typeRegistry_SF = 1;
	public final static int typeRegistry_CWA = 2;
	public final static int typeRegistry_LeaseDoc = 3;
	public final static int typeRegistry_SF_CWA = 4;
	public final static int typeRegistry_MUTUAL_ACT = 5;
	private static final String FIND_SQL =
		"SELECT idRegistryDoc, typeRegistry, state, owner, modified, created, createdby, modifiedby, regionid, typeTransferRegistry, idRegistryDocPurcher, idRegistryDocAccountant, getNamePeople(owner) ownerName, getNamePeople(createdby) createdByName, getNamePeople(modifiedby) modifiedByName FROM LeaseRegistryBuchDocs ";
	private final static java.lang.String EDIT_SQL = "UPDATE LeaseRegistryBuchDocs SET typeRegistry =?, state =?, owner =?, modified=?, created =?, createdby=?, modifiedby=? WHERE idRegistryDoc=? ";
	private final static java.lang.String ADD_SQL =
		"INSERT INTO LeaseRegistryBuchDocs (idRegistryDoc, typeRegistry, state, owner, modified, created, createdby, modifiedby, regionid, typeTransferRegistry) VALUES (?,?,?,?,?,?,?,?,?,?) ";
	private final static java.lang.String DELETE_SQL = "DELETE FROM LeaseRegistryBuchDocs WHERE idRegistryDoc = ?";
	private final static java.lang.String storeWord_SQL = "UPDATE LeaseRegistryBuchDocs SET acttext=?, actfilename=? WHERE idRegistryDoc = ?";
	private final static String LIST_COMPOSITION_SF_SQL =
		"SELECT ld.docNumber, ld.docDate, lc.economist, getNameOrg(orgexecutor) nameOrg, getNameOrg(orgexecutor, 2) nameOrgPrint, getNamePosition(la.mainPosition) namePosition, getNumberPosition(la.mainPosition) numberPosition, "
			+ "ls.idSchetFakt, ls.state docState, ls.idRegistryDoc , ls.numberschetfakt, ls.dateschetfakt, getSumSf (ls.idSchetFakt) sumSf, getNdsSf(ls.idSchetFakt) ndsSf "
			+ "FROM leaseschetfakt ls, leasecontracts lc, leasedocuments ld, leasearendaagrmnts la "
			+ "WHERE ls.idcontract = ld.leasedocument   AND ld.leasedocument = lc.leasedocument AND ld.leasedocument = la.leasedocument ";
	private final static String LIST_COMPOSITION_CWA_SQL =
		"SELECT ld.docNumber, ld.docDate, lc.economist, getNameOrg(orgexecutor) nameOrg, getNameOrg(orgexecutor, 2) nameOrgPrint, getNamePosition(la.mainPosition, 1) namePosition, getNumberPosition(la.mainPosition) numberPosition, "
			+ "cw.idCWAcode, cw.actState docState, cw.idRegistryDoc, cw.docdate docDateCWA, cw.docnumber docNumberCWA,  getNameCurrency(cw.currency, 0, 0) nameCurrency,  cw.actsum, cw.actnds,  cw.actstartdate, cw.actenddate "
			+ "FROM  completworkacts cw, leasecontracts lc, leasedocuments ld, leasearendaagrmnts la "
			+ "WHERE cw.idcontract = ld.leasedocument   AND ld.leasedocument = lc.leasedocument AND ld.leasedocument = la.leasedocument ";
	private final static String[] LIST_COMPOSITION_LeaseDoc_SQL =
		{
			"SELECT ld.docNumber, ld.docDate, lc.economist, lc.contractState docState, getNameOrg(orgexecutor) nameOrg, getNameOrg(orgexecutor, 2) nameOrgPrint, getNamePosition(la.mainPosition, 1) namePosition, getNumberPosition(la.mainPosition) numberPosition, "
				+ " ld.leasedocument, ld.idRegistryDoc, cast (null as char(40)) docNdop, cast (null as date) docDdop, lc.summ1, lc.currency1, getNameCurrency(lc.currency1, 0, 0) nameCurrency, 'баз. договор' as typeContract "
				+ "FROM  leasecontracts lc, leasedocuments ld, leasearendaagrmnts la "
				+ "WHERE ld.leasedocument = lc.leasedocument AND ld.leasedocument = la.leasedocument AND la.mainLeaseDocument IS NULL ",
			"SELECT ldMain.docNumber, ldMain.docDate, lc.economist, lc.contractState docState, getNameOrg(orgexecutor) nameOrg, getNameOrg(orgexecutor, 2) nameOrgPrint, getNamePosition(la.mainPosition, 1) namePosition, getNumberPosition(la.mainPosition) numberPosition, "
				+ " ld.leasedocument, ld.idRegistryDoc, ld.docNumber docNdop, ld.docDate docDdop, lc.summ1, lc.currency1, getNameCurrency(lc.currency1, 0, 0) nameCurrency, 'доп. соглашение' as typeContract "
				+ "FROM  leasecontracts lc, leasedocuments ld, leasearendaagrmnts la, leasedocuments ldmain "
				+ "WHERE ld.leasedocument = lc.leasedocument AND ld.leasedocument = la.leasedocument AND la.mainLeaseDocument = ldmain.leasedocument AND la.mainLeaseDocument IS NOT NULL " };
	private final static String[] LIST_COMPOSITION_SF_CWA_SQL =
		{
			"SELECT ld.docNumber, ld.docDate, lc.economist, getNameOrg(orgexecutor) nameOrg, getNameOrg(orgexecutor, 2) nameOrgPrint, getNamePosition(la.mainPosition) namePosition, getNumberPosition(la.mainPosition) numberPosition, "
				+ "ls.idRegistryDoc, ls.state docState, ls.idSchetFakt idComposition, ls.numberSchetFakt numberComposition, ls.dateSchetFakt dateComposition, getSumSf (ls.idSchetFakt) sumComposition, getNdsSf(ls.idSchetFakt) ndsComposition, ls.dateStartSF dateStartComposition, ls.dateEndSF dateEndComposition, "
				+ typeRegistry_SF
				+ " as typeComposition "
				+ "FROM leaseschetfakt ls, leasecontracts lc, leasedocuments ld, leasearendaagrmnts la "
				+ "WHERE ls.idcontract = ld.leasedocument   AND ld.leasedocument = lc.leasedocument AND ld.leasedocument = la.leasedocument ",
			"SELECT ld.docNumber, ld.docDate, lc.economist, getNameOrg(orgexecutor) nameOrg, getNameOrg(orgexecutor, 2) nameOrgPrint, getNamePosition(la.mainPosition, 1) namePosition, getNumberPosition(la.mainPosition) numberPosition, "
				+ "cw.idRegistryDoc, cw.actState docState, cw.idCWAcode idComposition, cw.docnumber numberComposition, cw.docdate dateComposition, cw.actsum sumComposition, cw.actnds ndsComposition, cw.actStartDate dateStartComposition, cw.actEndDate dateEndComposition, "
				+ typeRegistry_CWA
				+ " as typeComposition "
				+ "FROM  completworkacts cw, leasecontracts lc, leasedocuments ld, leasearendaagrmnts la "
				+ "WHERE cw.idcontract = ld.leasedocument   AND ld.leasedocument = lc.leasedocument AND ld.leasedocument = la.leasedocument " };

	private final static String LIST_COMPOSITION_MUTUAL_ACT_SQL =
		"SELECT first 1000 getNumberPosition(GetCodePositionOnAct(lm.leasedocument)) numberPosition, getNamePosition(GetCodePositionOnAct(lm.leasedocument)) namePosition, getNameOrgOnAct(lm.leasedocument) nameOrg, ld.idRegistryDoc, lm.actState, ld.leasedocument, ld.docNumber, ld.docDate, lm.actStartDate, lm.actEndDate "
			+ "FROM leasemutualacts lm, leasedocuments ld "
			+ "WHERE lm.leasedocument = ld.leasedocument ";

	private final static java.lang.String ATTACH_DOCS_SF_SQL = "UPDATE LeaseSchetFakt SET idRegistryDoc = ? ";
	private final static java.lang.String DETACH_DOCS_SF_SQL = "UPDATE LeaseSchetFakt SET idRegistryDoc = NULL WHERE idRegistryDoc = ? ";
	private final static java.lang.String ATTACH_DOCS_CWA_SQL = "UPDATE CompletWorkActs SET idRegistryDoc = ? ";
	private final static java.lang.String DETACH_DOCS_CWA_SQL = "UPDATE CompletWorkActs SET idRegistryDoc = NULL WHERE idRegistryDoc = ? ";
	private final static java.lang.String ATTACH_DOCS_LeaseDoc_SQL = "UPDATE LeaseDocuments SET idRegistryDoc = ? ";
	private final static java.lang.String DETACH_DOCS_LeaseDoc_SQL = "UPDATE LeaseDocuments SET idRegistryDoc = NULL WHERE idRegistryDoc = ? ";
	private final static java.lang.String ATTACH_DOCS_MutualAct_SQL = "UPDATE LeaseDocuments SET idRegistryDoc = ? ";
	private final static java.lang.String DETACH_DOCS_MutualAct_SQL = "UPDATE LeaseDocuments SET idRegistryDoc = NULL WHERE idRegistryDoc = ? ";

	private final static java.lang.String SET_STATE_DOCS_SF_SQL = "UPDATE LeaseSchetFakt SET state = ? WHERE idSchetFakt = ?";
	private final static java.lang.String SET_STATE_DOCS_CWA_SQL = "UPDATE CompletWorkActs SET actState = ? WHERE idCWAcode = ?";

	//прив€зки счетов-фактур и актов вып. работ к акту взаимозачета:
	private final static String LIST_COMPOSITION_SF_FOR_MUNUAL_ACT_SQL =
		"SELECT ld.docNumber, ld.docDate, lc.economist, getNameOrg(orgexecutor) nameOrg, getNameOrg(orgexecutor, 2) nameOrgPrint, getNamePosition(la.mainPosition) namePosition, getNumberPosition(la.mainPosition) numberPosition, "
			+ "ls.idSchetFakt, ls.state docState, ls.idRegistryDoc , ls.numberschetfakt, ls.dateschetfakt, getSumSf (ls.idSchetFakt) sumSf, getNdsSf(ls.idSchetFakt) ndsSf "
			+ "FROM leaseSchetFakt ls, leaseContracts lc, leaseDocuments ld, leaseArendaAgrmnts la, leaseSchetFakt2Charge  sf2c, leaseCharges lch, leaseDocPositions ldp "
			+ "WHERE ls.idcontract = ld.leasedocument AND ld.leasedocument = lc.leasedocument AND ld.leasedocument = la.leasedocument "
			+ " AND ls.idSchetFakt = sf2c.idSchetFakt AND sf2c.idCharge = lch.leaseDocPosition AND lch.leaseDocPosition = ldp.leaseDocPosition "
			+ " AND ldp.usedinact = ? ";

	private final static String LIST_COMPOSITION_CWA_FOR_MUNUAL_ACT_SQL =
		"SELECT ld.docNumber, ld.docDate, lc.economist, getNameOrg(orgexecutor) nameOrg, getNameOrg(orgexecutor, 2) nameOrgPrint, getNamePosition(la.mainPosition, 1) namePosition, getNumberPosition(la.mainPosition) numberPosition, "
			+ "cw.idCWAcode, cw.actState docState, cw.idRegistryDoc, cw.docdate docDateCWA, cw.docnumber docNumberCWA,  getNameCurrency(cw.currency, 0, 0) nameCurrency,  cw.actsum, cw.actnds,  cw.actstartdate, cw.actenddate "
			+ "FROM  completWorkActs cw, leaseContracts lc, leaseDocuments ld, leaseArendaAgrmnts la, completWorkAct2charge cw2c, leaseCharges lch, leaseDocPositions ldp "
			+ "WHERE cw.idcontract = ld.leasedocument AND ld.leasedocument = lc.leasedocument AND ld.leasedocument = la.leasedocument "
			+ " AND cw.idCWAcode = cw2c.idCWAcode AND cw2c.idCharge = lch.leaseDocPosition AND lch.leaseDocPosition = ldp.leaseDocPosition "
			+ " AND ldp.usedinact = ? ";

	private final static String[] LIST_COMPOSITION_SF_CWA_FOR_MUNUAL_ACT_SQL =
		{
			"SELECT ld.docNumber, ld.docDate, lc.economist, getNameOrg(orgexecutor) nameOrg, getNameOrg(orgexecutor, 2) nameOrgPrint, getNamePosition(la.mainPosition) namePosition, getNumberPosition(la.mainPosition) numberPosition, "
				+ "ls.idRegistryDoc, ls.state docState, ls.idSchetFakt idComposition, ls.numberSchetFakt numberComposition, ls.dateSchetFakt dateComposition, getSumSf (ls.idSchetFakt) sumComposition, getNdsSf(ls.idSchetFakt) ndsComposition, ls.dateStartSF dateStartComposition, ls.dateEndSF dateEndComposition, "
				+ typeRegistry_SF
				+ " as typeComposition "
				+ "FROM leaseSchetFakt ls, leaseContracts lc, leaseDocuments ld, leaseArendaAgrmnts la, leaseSchetFakt2Charge  sf2c, leaseCharges lch, leaseDocPositions ldp "
				+ "WHERE ls.idcontract = ld.leasedocument AND ld.leasedocument = lc.leasedocument AND ld.leasedocument = la.leasedocument "
				+ " AND ls.idSchetFakt = sf2c.idSchetFakt AND sf2c.idCharge = lch.leaseDocPosition AND lch.leaseDocPosition = ldp.leaseDocPosition "
				+ " AND ldp.usedInAct = ? ",
			"SELECT ld.docNumber, ld.docDate, lc.economist, getNameOrg(orgexecutor) nameOrg, getNameOrg(orgexecutor, 2) nameOrgPrint, getNamePosition(la.mainPosition, 1) namePosition, getNumberPosition(la.mainPosition) numberPosition, "
				+ "cw.idRegistryDoc, cw.actState docState, cw.idCWAcode idComposition, cw.docnumber numberComposition, cw.docdate dateComposition, cw.actsum sumComposition, cw.actnds ndsComposition, cw.actStartDate dateStartComposition, cw.actEndDate dateEndComposition, "
				+ typeRegistry_CWA
				+ " as typeComposition "
				+ "FROM  completWorkActs cw, leaseContracts lc, leaseDocuments ld, leaseArendaAgrmnts la, completWorkAct2charge cw2c, leaseCharges lch, leaseDocPositions ldp "
				+ "WHERE cw.idcontract = ld.leasedocument AND ld.leasedocument = lc.leasedocument AND ld.leasedocument = la.leasedocument "
				+ " AND cw.idCWAcode = cw2c.idCWAcode AND cw2c.idCharge = lch.leaseDocPosition AND lch.leaseDocPosition = ldp.leaseDocPosition "
				+ " AND ldp.usedInAct = ? " };
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:04:50)
	 */
	public static final boolean add(LeaseRegistryBuchDocs_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params =
			{
				vo.getIdRegistryDoc(),
				vo.getTypeRegistry(),
				vo.getState(),
				vo.getOwner(),
				vo.getModified(),
				vo.getCreated(),
				vo.getCreatedBy(),
				vo.getModifiedBy(),
				vo.getRegionID(),
				vo.getTypeTransferRegistry()};
		return res.executeUpdate(ADD_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:13:05)
	 */
	public static final boolean delete(LeaseRegistryBuchDocs_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { vo.getIdRegistryDoc()};
		return res.executeUpdate(DELETE_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	public static final boolean edit(LeaseRegistryBuchDocs_VO vo) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { vo.getTypeRegistry(), vo.getState(), vo.getOwner(), vo.getModified(), vo.getCreated(), vo.getCreatedBy(), vo.getModifiedBy(), vo.getIdRegistryDoc()};
		return res.executeUpdate(EDIT_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:54:13)
	 * @param id int
	 */
	public final static LeaseRegistryBuchDocs_TO find(int aID) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { new Integer(aID)};
		String sql = FIND_SQL + " WHERE idRegistryDoc = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		LeaseRegistryBuchDocs_TO to = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			to = new LeaseRegistryBuchDocs_TO(CDBC_Helper.createLeaseRegistryBuchDocs(ro));
			to.setOwnerName(ro.getColumn("ownerName").asString());
			to.setCreatedByName(ro.getColumn("createdByName").asString());
			to.setModifiedByName(ro.getColumn("modifiedByName").asString());
		}
		return to;
	}

	/**
	 * 
	 * @param aParent_VO
	 * @param group
	 * @return
	 */
	public final static LeaseRegistryBuchDocs_TO findChaldTO(LeaseRegistryBuchDocs_VO aParent_VO, String group) {
		if (AbstractRegistryBuchDocsStateFactory.AG.equals(group)) {
			if (aParent_VO.getIdRegistryDocAccountant() != null) {
				return find(aParent_VO.getIdRegistryDocAccountant().intValue());
			} else {
				return null;
			}
		} else if (AbstractRegistryBuchDocsStateFactory.PG.equals(group)) {
			if (aParent_VO.getIdRegistryDocPurcher() != null) {
				return find(aParent_VO.getIdRegistryDocPurcher().intValue());
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	/**
	 * 
	 * @param aChaild_VO
	 * @return
	 */
	public final static LeaseRegistryBuchDocs_TO findParentTO(LeaseRegistryBuchDocs_VO aChaild_VO) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { aChaild_VO.getIdRegistryDoc(), aChaild_VO.getIdRegistryDoc()};
		String sql = FIND_SQL + " WHERE idRegistryDocPurcher = ? OR idRegistryDocAccountant = ? ";
		res.executeQuery(sql, params);
		ListIterator list = res.listIterator();
		CDBCRowObject ro = null;
		LeaseRegistryBuchDocs_TO to = null;
		if (list.hasNext()) {
			ro = (CDBCRowObject) list.next();
			to = new LeaseRegistryBuchDocs_TO(CDBC_Helper.createLeaseRegistryBuchDocs(ro));
			to.setOwnerName(ro.getColumn("ownerName").asString());
			to.setCreatedByName(ro.getColumn("createdByName").asString());
			to.setModifiedByName(ro.getColumn("modifiedByName").asString());
		}
		return to;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	public static final List getList(
		Boolean isTypeRegistry,
		String typeRegistry,
		Boolean isOwnerName,
		String ownerName,
		Boolean isIdRegistryDoc,
		String idRegistryDoc,
		Boolean isRegionID,
		Integer regionID,
		Boolean isOperator,
		Integer operatorCode,
		Boolean isTypeTransferRegistry,
		Integer typeTransferRegistry,
		String aSortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_SQL + " WHERE 1=1 ");
		//calculate filter clause:
		StringBuffer filter = new StringBuffer();
		if (isTypeRegistry.booleanValue()) {
			filter.append(" AND typeRegistry = ? ");
			params.add(typeRegistry);
		}
		if (isOwnerName.booleanValue()) {
			getSQLforOwner(ownerName, params, filter);
		}
		if (isIdRegistryDoc.booleanValue()) {
			filter.append(" AND idRegistryDoc = ? ");
			params.add(idRegistryDoc);
		}
		if (isRegionID.booleanValue()) {
			filter.append(" AND regionID = ? ");
			params.add(regionID);
		}
		if (isOperator.booleanValue()) {
			filter.append(" AND owner IN ( SELECT man FROM operators WHERE operator=? ) ");
			params.add(operatorCode);
		}
		if (isTypeTransferRegistry.booleanValue()) {
			filter.append(" AND typeTransferRegistry = ? ");
			params.add(typeTransferRegistry);
		}
		//append order by clause:
		if (aSortBy != null)
			filter.append(" order by " + aSortBy);
		sqlb.append(filter);
		//executeQuery:
		//System.out.println("sqlb.toString()= params: " + params.toString()+ " sql: " + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		LeaseRegistryBuchDocs_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			//LeaseRegistryBuchDocs_VO vo = CDBC_Helper.createLeaseRegistryBuchDocs(ro);
			to = new LeaseRegistryBuchDocs_TO(CDBC_Helper.createLeaseRegistryBuchDocs(ro));
			to.setOwnerName(ro.getColumn("ownerName").asString());
			ret.add(to);
		}
		return ret;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	public static final List getListForReturnDocumentGroup(
		Boolean isTypeRegistry,
		String typeRegistry,
		Boolean isOwnerName,
		String ownerName,
		Boolean isIdRegistryDoc,
		String idRegistryDoc,
		Boolean isRegionID,
		Integer regionID,
		Boolean isOperator,
		Integer operatorCode,
		Boolean isTypeTransferRegistry,
		Integer typeTransferRegistry,
		String aSortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_SQL + " WHERE state IN('2', '3', '4', '5', '6', '7', '8') ");
		//calculate filter clause:
		StringBuffer filter = new StringBuffer();
		if (isTypeRegistry.booleanValue()) {
			filter.append(" AND typeRegistry = ? ");
			params.add(typeRegistry);
		}
		if (isOwnerName.booleanValue()) {
			getSQLforOwner(ownerName, params, filter);
		}
		if (isIdRegistryDoc.booleanValue()) {
			filter.append(" AND idRegistryDoc = ? ");
			params.add(idRegistryDoc);
		}
		if (isRegionID.booleanValue()) {
			filter.append(" AND regionID = ? ");
			params.add(regionID);
		}
		if (isOperator.booleanValue()) {
			filter.append(" AND owner IN ( SELECT man FROM operators WHERE operator=? ) ");
			params.add(operatorCode);
		}
		if (isTypeTransferRegistry.booleanValue()) {
			filter.append(" AND typeTransferRegistry = ? ");
			params.add(typeTransferRegistry);
		}
		//append order by clause:
		if (aSortBy != null)
			filter.append(" order by " + aSortBy);
		sqlb.append(filter);
		//executeQuery:
		System.out.println("sqlb.toString()=" + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		LeaseRegistryBuchDocs_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			//LeaseRegistryBuchDocs_VO vo = CDBC_Helper.createLeaseRegistryBuchDocs(ro);
			to = new LeaseRegistryBuchDocs_TO(CDBC_Helper.createLeaseRegistryBuchDocs(ro));
			to.setOwnerName(ro.getColumn("ownerName").asString());
			ret.add(to);
		}
		return ret;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	public static final List getListForInitialGroup(
		Boolean isTypeRegistry,
		String typeRegistry,
		Boolean isOwnerName,
		String ownerName,
		Boolean isIdRegistryDoc,
		String idRegistryDoc,
		Boolean isRegionID,
		Integer regionID,
		Boolean isOperator,
		Integer operatorCode,
		Boolean isTypeTransferRegistry,
		Integer typeTransferRegistry,
		String aSortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		StringBuffer sqlb = new StringBuffer(FIND_SQL + " WHERE 1=1 "); //+ " WHERE state IN('1', '2', '3', '4', '7', '8') "
		//calculate filter clause :
		StringBuffer filter = new StringBuffer();
		if (isTypeRegistry.booleanValue()) {
			filter.append(" AND typeRegistry = ? ");
			params.add(typeRegistry);
		}
		if (isOwnerName.booleanValue()) {
			getSQLforOwner(ownerName, params, filter);
		}
		if (isIdRegistryDoc.booleanValue()) {
			filter.append(" AND idRegistryDoc = ? ");
			params.add(idRegistryDoc);
		}
		if (isRegionID.booleanValue()) {
			filter.append(" AND regionID = ? ");
			params.add(regionID);
		}
		if (isOperator.booleanValue()) {
			filter.append(" AND owner IN ( SELECT man FROM operators WHERE operator=? ) ");
			params.add(operatorCode);
		}
		if (isTypeTransferRegistry.booleanValue()) {
			filter.append(" AND typeTransferRegistry = ? ");
			params.add(typeTransferRegistry);
		}
		//append order by clause:
		if (aSortBy != null)
			filter.append(" order by " + aSortBy);
		sqlb.append(filter);
		//executeQuery:
		System.out.println("sqlb.toString()=" + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		LeaseRegistryBuchDocs_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			//LeaseRegistryBuchDocs_VO vo = CDBC_Helper.createLeaseRegistryBuchDocs(ro);
			to = new LeaseRegistryBuchDocs_TO(CDBC_Helper.createLeaseRegistryBuchDocs(ro));
			to.setOwnerName(ro.getColumn("ownerName").asString());
			ret.add(to);
		}
		return ret;
	}
	/**
	 * 
	 * @param ownerName
	 * @param params
	 * @param filter
	 */
	private static void getSQLforOwner(String ownerName, ArrayList params, StringBuffer filter) {
		//filter.append(" AND owner IN ( SELECT man FROM people p WHERE  upper(p.lastname) matches upper(?) ) ");
		//params.add(ownerName);
		String strF = " AND owner IN ( SELECT man FROM people p WHERE  upper(p.lastName) matches upper(?) ) ";
		String strFI = " AND owner IN ( SELECT man FROM people p WHERE  upper(p.lastName) matches upper(?) AND upper(p.firstName) matches upper(?) ) ";
		String strFIO = " AND owner IN ( SELECT man FROM people p WHERE  upper(p.lastName) matches upper(?) AND upper(p.firstName) matches upper(?) AND upper(p.middleName) matches upper(?) ) ";
		StringTokenizer st = new StringTokenizer(ownerName, "., ");
		if (st.countTokens() == 2) {
			filter.append(strFI);
			params.add(st.nextToken());
			params.add(st.nextToken() + "*");
		} else if (st.countTokens() == 3) {
			filter.append(strFIO);
			params.add(st.nextToken());
			params.add(st.nextToken() + "*");
			params.add(st.nextToken() + "*");
		} else {
			filter.append(strF);
			params.add(ownerName);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.11.2005 10:21:14)
	 */
	public final static WordDocument loadWordExternal(Integer id, String remoteUser) throws Exception {
		TerrabyteExternalClient client = TerrabyteExternalClientFactory.getClient();
		Document doc = client.getDocumentLastVersionByObject(id, ObjectTypes.LEASE_REGISTRY, remoteUser);
		java.io.InputStream stream = doc.getData();
		byte[] text = new byte[stream.available()];
		stream.read(text);
		stream.close();
		String filename = doc.getDocumentName();
		return new WordDocument(id, text, filename);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.11.2005 12:46:39)
	 */

	public final static boolean storeWord(int id, String filename, byte[] actText) throws Exception {
		JdbcConnection jcon = new JdbcConnection();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = jcon.getConnection();
			st = con.prepareStatement(storeWord_SQL);
			//данные:
			st.setBytes(1, actText);
			st.setString(2, filename);

			//входной параметр:
			st.setInt(3, id);

			if (st.executeUpdate() != 1) {
				System.out.println("storeWord :Id=" + id + " failed");
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println("SQLException: CODE=" + e.getErrorCode());
			e.printStackTrace(System.out);
			return false;
		} finally {
			try {
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.11.2005 9:43:21)
	 */
	public final static void storeWordExternal(WordDocument doc, String remoteUser) throws Exception {
		//String host = com.hps.july.util.AppUtils.getNamedValueString("TERRABYTE_HOST");
		//int port = com.hps.july.util.AppUtils.getNamedValueInt("TERRABYTE_PORT");
		//String operator = "NRI";
		TerrabyteExternalClient client = TerrabyteExternalClientFactory.getClient();
		Integer nriType = DocumentTypes.LEASE_REGISTRY_DOCUMENT;
		String mimeType = "application/msword";
		client.addObjectDocument(new java.io.ByteArrayInputStream(doc.getText()), doc.getFilename(), doc.getId(), ObjectTypes.LEASE_REGISTRY, remoteUser, nriType, mimeType);
		//client.addObjectDocument(doc, objectId, objectType, userName);    
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	public static final List getListComposition(
		String searchStr,
		Integer man,
		Integer idRegistryDoc,
		String aSortBy,
		Integer typeRegistryDoc,
		Boolean isEconomist,
		Boolean isCreatedBy,
		Boolean isModifiedBy,
		Integer regionID) {
		List ret = null;
		if (typeRegistryDoc.equals(new Integer(typeRegistry_SF))) {
			ret = getListComposition_SF(man, idRegistryDoc, isEconomist, isCreatedBy, isModifiedBy, regionID, aSortBy);
		} else if (typeRegistryDoc.equals(new Integer(typeRegistry_CWA))) {
			ret = getListComposition_CWA(man, idRegistryDoc, isEconomist, isCreatedBy, isModifiedBy, regionID, aSortBy);
		} else if (typeRegistryDoc.equals(new Integer(typeRegistry_LeaseDoc))) {
			ret = getListComposition_LeaseDoc(man, idRegistryDoc, isEconomist, isCreatedBy, isModifiedBy, regionID, aSortBy);
		} else if (typeRegistryDoc.equals(new Integer(typeRegistry_SF_CWA))) {
			ret = getListComposition_SF_CWA(man, idRegistryDoc, isEconomist, isCreatedBy, isModifiedBy, regionID, aSortBy);
		} else if (typeRegistryDoc.intValue() == typeRegistry_MUTUAL_ACT) {
			if (idRegistryDoc == null) {
				ret = getListComposition_MutualAct(searchStr, man, isCreatedBy, isModifiedBy, regionID, aSortBy);
			} else {
				ret = getListComposition_MutualAct(idRegistryDoc, regionID, aSortBy);
			}
		}
		return ret;
	}

	/**
	 * 
	 * @param aList
	 * @param typeRegistryDoc
	 * @return
	 */
	public static final List calcComplectList(List aList, Integer typeRegistryDoc) {
		List retList = null;
		if (typeRegistryDoc.equals(new Integer(typeRegistry_SF))) {
			retList = aList;
		} else if (typeRegistryDoc.equals(new Integer(typeRegistry_CWA))) {
			retList = aList;
		} else if (typeRegistryDoc.equals(new Integer(typeRegistry_LeaseDoc))) {
			retList = aList;
		} else if (typeRegistryDoc.equals(new Integer(typeRegistry_SF_CWA))) {
			retList = calcComplectList__SF_CWA(aList);
		} else {
			retList = aList;
		}
		return retList;
	}

	/**
	 * 
	 * @param aList
	 * @return
	 */
	private static final List calcComplectList__SF_CWA(List inList) {
		ArrayList retList = new ArrayList();
		List listCWA = RegistryBuchCompositionObject_Filter.apply(inList.listIterator(), new Integer(typeRegistry_CWA));
		List listSF = RegistryBuchCompositionObject_Filter.apply(inList.listIterator(), new Integer(typeRegistry_SF));
		//находим пары и непары дл€ актов:
		for (Iterator iterCWA = listCWA.iterator(); iterCWA.hasNext();) {
			RegistryBuchCompositionComplect_TO toComplect = new RegistryBuchCompositionComplect_TO();
			RegistryBuchCompositionObject_TO toCWA = (RegistryBuchCompositionObject_TO) iterCWA.next();
			toComplect.setAct(toCWA);
			for (Iterator iterSF = listSF.iterator(); iterSF.hasNext();) {
				RegistryBuchCompositionObject_TO toSF = (RegistryBuchCompositionObject_TO) iterSF.next();
				if (toCWA.getDocNumber().equals(toSF.getDocNumber()) && toCWA.getPeriodComposition().equals(toSF.getPeriodComposition())) {
					toComplect.setFactura(toSF);
					break;
				}
			}
			retList.add(toComplect);
		}
		//находим непары дл€ счетов-фактур:
		for (Iterator iterSF = listSF.iterator(); iterSF.hasNext();) {
			RegistryBuchCompositionObject_TO toSF = (RegistryBuchCompositionObject_TO) iterSF.next();
			boolean isPair = false;
			for (Iterator iterCWA = listCWA.iterator(); iterCWA.hasNext();) {
				RegistryBuchCompositionObject_TO toCWA = (RegistryBuchCompositionObject_TO) iterCWA.next();
				if (toCWA.getDocNumber().equals(toSF.getDocNumber()) && toCWA.getPeriodComposition().equals(toSF.getPeriodComposition())) {
					isPair = true;
					break;
				}
			}
			if (!isPair) {
				RegistryBuchCompositionComplect_TO toComplect = new RegistryBuchCompositionComplect_TO();
				toComplect.setFactura(toSF);
				retList.add(toComplect);
			}

		}
		return retList;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	private static final List getListComposition_SF(Integer man, Integer idRegistryDoc, Boolean isEconomist, Boolean isCreatedBy, Boolean isModifiedBy, Integer regionID, String aSortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		//StringBuffer sqlb = new StringBuffer(LIST_COMPOSITION_SF_SQL + " AND lc.economist = ? ");
		StringBuffer sqlb = new StringBuffer(LIST_COMPOSITION_SF_SQL);
		if (idRegistryDoc == null) {
			//sqlb.append(" AND  (ls.createdby = ? or (lc.economist in (select worker from workers where man= ?))) AND ls.state = 1");
			//params.add(man);
			//params.add(man);
			sqlb.append(" AND ls.state = 1 ");
			if (isEconomist.booleanValue() || isCreatedBy.booleanValue() || isModifiedBy.booleanValue()) {
				sqlb.append(" AND (");
				boolean isOr = false;
				if (isCreatedBy.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" ls.createdBy = ? ");
					params.add(man);
					isOr = true;
				}
				if (isModifiedBy.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" ls.modifiedBy = ? ");
					params.add(man);
					isOr = true;
				}
				if (isEconomist.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" (lc.economist in (select worker from workers where man= ?)) ");
					params.add(man);
					isOr = true;
				}
				sqlb.append(")");
			}
			sqlb.append(" AND ls.idRegistryDoc IS NULL AND ld.regionID = ? ");
			params.add(regionID);
		} else {
			sqlb.append(" AND ls.idRegistryDoc = ? ");
			params.add(idRegistryDoc);
		}
		//append order by clause:
		if (aSortBy != null)
			sqlb.append(" order by " + aSortBy);
		//executeQuery:
		System.out.println("sqlb.toString()=" + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		RegistryBuchCompositionSF_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new RegistryBuchCompositionSF_TO();
			populateBase(ro, to);

			to.setIdSchetFakt((Integer) ro.getColumn("idSchetFakt").asObject());
			to.setNumberSf(ro.getColumn("numberschetfakt").asString());
			to.setDateSf((java.sql.Date) ro.getColumn("dateschetfakt").asObject());
			to.setSumSf((BigDecimal) ro.getColumn("sumSf").asObject());
			to.setNdsSf((BigDecimal) ro.getColumn("ndsSf").asObject());

			ret.add(to);
		}
		return ret;
	}
	/**
	 * 
	 * @param ro
	 * @param to
	 */
	private static void populateBase(CDBCRowObject ro, RegistryBuchComposition_TO to) {
		to.setDocNumber(ro.getColumn("docNumber").asString());
		to.setDocDate((java.sql.Date) ro.getColumn("docDate").asObject());
		to.setNameOrg(ro.getColumn("nameOrg").asString());
		to.setNameOrgPrint(ro.getColumn("nameOrgPrint").asString());
		to.setNamePosition(ro.getColumn("namePosition").asString());
		to.setNumberPosition(ro.getColumn("numberPosition").asString());
		to.setEconomist((Integer) ro.getColumn("economist").asObject());
		to.setIdRegistryDoc((Integer) ro.getColumn("idRegistryDoc").asObject());
		to.setDocState(ro.getColumn("docState").asString());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	private static final List getListComposition_CWA(Integer man, Integer idRegistryDoc, Boolean isEconomist, Boolean isCreatedBy, Boolean isModifiedBy, Integer regionID, String aSortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		//StringBuffer sqlb = new StringBuffer(LIST_COMPOSITION_CWA_SQL + " AND lc.economist = ? ");
		StringBuffer sqlb = new StringBuffer(LIST_COMPOSITION_CWA_SQL);
		if (idRegistryDoc == null) {
			//sqlb.append(" AND (cw.createdby = ? or (lc.economist in (select worker from workers where man= ?))) AND cw.actstate = '1' ");
			//params.add(man);
			//params.add(man);
			sqlb.append(" AND cw.actstate = '1' ");
			if (isEconomist.booleanValue() || isCreatedBy.booleanValue() || isModifiedBy.booleanValue()) {
				sqlb.append(" AND (");
				boolean isOr = false;
				if (isCreatedBy.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" cw.createdBy = ? ");
					params.add(man);
					isOr = true;
				}
				if (isModifiedBy.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" cw.modifiedBy = ? ");
					params.add(man);
					isOr = true;
				}
				if (isEconomist.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" (lc.economist in (select worker from workers where man= ?)) ");
					params.add(man);
					isOr = true;
				}
				sqlb.append(")");
			}
			sqlb.append(" AND cw.idRegistryDoc IS NULL AND ld.regionID = ? ");
			params.add(regionID);
		} else {
			sqlb.append(" AND cw.idRegistryDoc = ? ");
			params.add(idRegistryDoc);
		}
		//append order by clause:
		if (aSortBy != null)
			sqlb.append(" order by " + aSortBy);
		//executeQuery:
		System.out.println("sqlb.toString()=" + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		RegistryBuchCompositionCWA_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new RegistryBuchCompositionCWA_TO();
			populateBase(ro, to);

			to.setIdCWAcode((Integer) ro.getColumn("idCWAcode").asObject());
			to.setDocNumberCWA(ro.getColumn("docNumberCWA").asString());
			to.setDocDateCWA((java.sql.Date) ro.getColumn("docDateCWA").asObject());
			to.setNameCurrency(ro.getColumn("nameCurrency").asString());
			to.setActSum((BigDecimal) ro.getColumn("actSum").asObject());
			to.setActNds((BigDecimal) ro.getColumn("actNds").asObject());
			to.setActStartDate((java.sql.Date) ro.getColumn("actStartDate").asObject());
			to.setActEndDate((java.sql.Date) ro.getColumn("actEndDate").asObject());
			ret.add(to);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	private static final List getListComposition_LeaseDoc(Integer man, Integer idRegistryDoc, Boolean isEconomist, Boolean isCreatedBy, Boolean isModifiedBy, Integer regionID, String aSortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		//StringBuffer sqlb = new StringBuffer(LIST_COMPOSITION_LeaseDoc_SQL [0] + " AND lc.economist = ? ");
		StringBuffer sqlb = new StringBuffer(LIST_COMPOSITION_LeaseDoc_SQL[0]);
		if (idRegistryDoc == null) {
			//sqlb.append(" AND (ld.createdby = ? or (lc.economist in (select worker from workers where man= ?))) ");
			//params.add(man);
			//params.add(man);
			//sqlb.append(" AND ld.idRegistryDoc IS NULL ");
			if (isEconomist.booleanValue() || isCreatedBy.booleanValue() || isModifiedBy.booleanValue()) {
				sqlb.append(" AND (");
				boolean isOr = false;
				if (isCreatedBy.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" ld.createdBy = ? ");
					params.add(man);
					isOr = true;
				}
				if (isModifiedBy.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" ld.modifiedBy = ? ");
					params.add(man);
					isOr = true;
				}
				if (isEconomist.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" (lc.economist in (select worker from workers where man= ?)) ");
					params.add(man);
					isOr = true;
				}
				sqlb.append(")");
			}
			sqlb.append(" AND ld.idRegistryDoc IS NULL AND ld.regionID = ? ");
			params.add(regionID);
		} else {
			sqlb.append(" AND ld.idRegistryDoc = ? ");
			params.add(idRegistryDoc);
		}

		sqlb.append(" UNION ");

		//sqlb.append(LIST_COMPOSITION_LeaseDoc_SQL [1] + " AND lc.economist = ? ");
		sqlb.append(LIST_COMPOSITION_LeaseDoc_SQL[1]);
		if (idRegistryDoc == null) {
			//sqlb.append(" AND (ld.createdby = ? or (lc.economist in (select worker from workers where man= ?))) ");
			//params.add(man);
			//params.add(man);
			//sqlb.append(" AND ld.idRegistryDoc IS NULL ");
			if (isEconomist.booleanValue() || isCreatedBy.booleanValue() || isModifiedBy.booleanValue()) {
				sqlb.append(" AND (");
				boolean isOr = false;
				if (isCreatedBy.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" ld.createdBy = ? ");
					params.add(man);
					isOr = true;
				}
				if (isModifiedBy.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" ld.modifiedBy = ? ");
					params.add(man);
					isOr = true;
				}
				if (isEconomist.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" (lc.economist in (select worker from workers where man= ?)) ");
					params.add(man);
					isOr = true;
				}
				sqlb.append(")");
			}
			sqlb.append(" AND ld.idRegistryDoc IS NULL AND ld.regionID = ? ");
			params.add(regionID);

		} else {
			sqlb.append(" AND ld.idRegistryDoc = ? ");
			params.add(idRegistryDoc);
		}
		//append order by clause:
		if (aSortBy != null)
			sqlb.append(" order by " + aSortBy);

		//executeQuery:
		System.out.println("sqlb.toString()=" + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		RegistryBuchCompositionLeaseDoc_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new RegistryBuchCompositionLeaseDoc_TO();
			populateBase(ro, to);
			to.setLeaseDocument((Integer) ro.getColumn("leaseDocument").asObject());
			to.setDocNumberDop(ro.getColumn("docNdop").asString());
			to.setDocDateDop((java.sql.Date) ro.getColumn("docDdop").asObject());
			to.setSum((BigDecimal) ro.getColumn("summ1").asObject());
			to.setNameCurrency(ro.getColumn("nameCurrency").asString());
			to.setTypeDoc(ro.getColumn("typeContract").asString());
			ret.add(to);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	private static final List getListComposition_SF_CWA(Integer man, Integer idRegistryDoc, Boolean isEconomist, Boolean isCreatedBy, Boolean isModifiedBy, Integer regionID, String aSortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();

		StringBuffer sqlb = new StringBuffer(LIST_COMPOSITION_SF_CWA_SQL[0]);
		if (idRegistryDoc == null) {
			//sqlb.append(" AND (ls.createdby = ? or (lc.economist in (select worker from workers where man= ?))) AND ls.state = 1 ");
			sqlb.append(" AND ls.state = 1 ");
			if (isEconomist.booleanValue() || isCreatedBy.booleanValue() || isModifiedBy.booleanValue()) {
				sqlb.append(" AND (");
				boolean isOr = false;
				if (isCreatedBy.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" ls.createdBy = ? ");
					params.add(man);
					isOr = true;
				}
				if (isModifiedBy.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" ls.modifiedBy = ? ");
					params.add(man);
					isOr = true;
				}
				if (isEconomist.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" (lc.economist in (select worker from workers where man= ?)) ");
					params.add(man);
					isOr = true;
				}
				sqlb.append(")");
			}
			sqlb.append(" AND ls.idRegistryDoc IS NULL AND ld.regionID = ? ");
			params.add(regionID);
		} else {
			sqlb.append(" AND ls.idRegistryDoc = ? ");
			params.add(idRegistryDoc);
		}

		sqlb.append(" UNION ");

		sqlb.append(LIST_COMPOSITION_SF_CWA_SQL[1]);
		if (idRegistryDoc == null) {
			//sqlb.append(" AND (cw.createdby = ? or (lc.economist in (select worker from workers where man= ?))) ");			
			sqlb.append(" AND cw.actstate = '1' ");
			if (isEconomist.booleanValue() || isCreatedBy.booleanValue() || isModifiedBy.booleanValue()) {
				sqlb.append(" AND (");
				boolean isOr = false;
				if (isCreatedBy.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" cw.createdBy = ? ");
					params.add(man);
					isOr = true;
				}
				if (isModifiedBy.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" cw.modifiedBy = ? ");
					params.add(man);
					isOr = true;
				}
				if (isEconomist.booleanValue()) {
					if (isOr) {
						sqlb.append(" OR ");
					}
					sqlb.append(" (lc.economist in (select worker from workers where man= ?)) ");
					params.add(man);
					isOr = true;
				}
				sqlb.append(")");
			}
			sqlb.append(" AND cw.idRegistryDoc IS NULL AND ld.regionID = ? ");
			params.add(regionID);
		} else {
			sqlb.append(" AND cw.idRegistryDoc = ? ");
			params.add(idRegistryDoc);
		}
		//append order by clause:
		if (aSortBy != null)
			sqlb.append(" order by " + aSortBy);

		//executeQuery:
		System.out.println("sqlb.toString()=" + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		RegistryBuchCompositionObject_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new RegistryBuchCompositionObject_TO();
			populateBase(ro, to);
			to.setIdComposition((Integer) ro.getColumn("idComposition").asObject());
			to.setNumberComposition(ro.getColumn("numberComposition").asString());
			to.setDateComposition((java.sql.Date) ro.getColumn("dateComposition").asObject());
			to.setSumComposition((BigDecimal) ro.getColumn("sumComposition").asObject());
			//to.setNdsComposition((BigDecimal) ro.getColumn("ndsComposition").asObject());
			//to.setNameCurrency(ro.getColumn("nameCurrency").asString());
			to.setTypeComposition((Integer) ro.getColumn("typeComposition").asObject());
			//инициализаци€ периода:
			DataPeriod dataPeriod = new DataPeriod();
			dataPeriod.setFromDate((java.sql.Date) ro.getColumn("dateStartComposition").asObject());
			dataPeriod.setToDate((java.sql.Date) ro.getColumn("dateEndComposition").asObject());
			to.setPeriodComposition(dataPeriod);

			ret.add(to);
		}
		return ret;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	private static final List getListComposition_SF_CWA_ForMutualAct(Integer idMutAct, Integer idRegistryDoc, String aSortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();

		StringBuffer sqlb = new StringBuffer(LIST_COMPOSITION_SF_CWA_FOR_MUNUAL_ACT_SQL[0]);
		params.add(idMutAct);
		if (idRegistryDoc == null) {
			//sqlb.append(" AND (ls.createdby = ? or (lc.economist in (select worker from workers where man= ?))) AND ls.state = 1 ");
			sqlb.append(" AND ls.state = 1 ");
			sqlb.append(" AND ls.idRegistryDoc IS NULL "); //AND ld.regionID = ?
			//params.add(regionID);
		} else {
			sqlb.append(" AND ls.idRegistryDoc = ? ");
			params.add(idRegistryDoc);
		}

		sqlb.append(" UNION ");

		sqlb.append(LIST_COMPOSITION_SF_CWA_FOR_MUNUAL_ACT_SQL[1]);
		params.add(idMutAct);
		if (idRegistryDoc == null) {
			//sqlb.append(" AND (cw.createdby = ? or (lc.economist in (select worker from workers where man= ?))) ");			
			sqlb.append(" AND cw.actstate = '1' ");
			sqlb.append(" AND cw.idRegistryDoc IS NULL "); // AND ld.regionID = ? 
			//params.add(regionID);
		} else {
			sqlb.append(" AND cw.idRegistryDoc = ? ");
			params.add(idRegistryDoc);
		}
		//append order by clause:
		if (aSortBy != null)
			sqlb.append(" order by " + aSortBy);

		//executeQuery:
		System.out.println("getListComposition_SF_CWA_ForMutualAct sql=" + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		RegistryBuchCompositionObject_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new RegistryBuchCompositionObject_TO();
			populateBase(ro, to);
			to.setIdComposition((Integer) ro.getColumn("idComposition").asObject());
			to.setNumberComposition(ro.getColumn("numberComposition").asString());
			to.setDateComposition((java.sql.Date) ro.getColumn("dateComposition").asObject());
			to.setSumComposition((BigDecimal) ro.getColumn("sumComposition").asObject());
			//to.setNdsComposition((BigDecimal) ro.getColumn("ndsComposition").asObject());
			//to.setNameCurrency(ro.getColumn("nameCurrency").asString());
			to.setTypeComposition((Integer) ro.getColumn("typeComposition").asObject());
			//инициализаци€ периода:
			DataPeriod dataPeriod = new DataPeriod();
			dataPeriod.setFromDate((java.sql.Date) ro.getColumn("dateStartComposition").asObject());
			dataPeriod.setToDate((java.sql.Date) ro.getColumn("dateEndComposition").asObject());
			to.setPeriodComposition(dataPeriod);

			ret.add(to);
		}
		return ret;
	}
	/**
	 * Ћист доступных первичных документов по акту взаимозачета(дл€ прив€зки к новой описи).
	 * Creation date: (07.11.2005 12:19:16)
	 */
	private static final List getListComposition_MutualAct(String numberAct, Integer man, Boolean isCreatedBy, Boolean isModifiedBy, Integer regionID, String aSortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();

		StringBuffer sqlb = new StringBuffer(LIST_COMPOSITION_MUTUAL_ACT_SQL);
		sqlb.append(" AND lm.actstate = 'C' ");
		if (numberAct != null) {
			sqlb.append(" AND UPPER(ld.docnumber) matches UPPER(?) ");
			params.add(numberAct);
		}
		if (isCreatedBy.booleanValue() || isModifiedBy.booleanValue()) {
			sqlb.append(" AND (");
			boolean isOr = false;
			if (isCreatedBy.booleanValue()) {
				if (isOr) {
					sqlb.append(" OR ");
				}
				sqlb.append(" ld.createdBy = ? ");
				params.add(man);
				isOr = true;
			}
			if (isModifiedBy.booleanValue()) {
				if (isOr) {
					sqlb.append(" OR ");
				}
				sqlb.append(" ld.modifiedBy = ? ");
				params.add(man);
				isOr = true;
			}
			sqlb.append(")");
		}		
		sqlb.append(" AND ld.idRegistryDoc IS NULL AND ld.regionID = ? ");
		params.add(regionID);

		//append order by clause:
		if (aSortBy != null)
			sqlb.append(" order by " + aSortBy);

		//executeQuery:
		System.out.println("getListComposition_MutualAct ACCESS sql=" + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		RegistryBuchCompositionMutAct_TO to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new RegistryBuchCompositionMutAct_TO((Integer) ro.getColumn("leasedocument").asObject());
			to.setIdRegistryDoc((Integer) ro.getColumn("idRegistryDoc").asObject());
			to.setActState(ro.getColumn("actState").asString());
			to.setDocNumber(ro.getColumn("docNumber").asString());
			to.setDocDate((java.sql.Date) ro.getColumn("docDate").asObject());
			//to.setTypeComposition((Integer) ro.getColumn("typeComposition").asObject());
			//инициализаци€ периода:
			//DataPeriod dataPeriod = new DataPeriod();
			//dataPeriod.setFromDate((java.sql.Date) ro.getColumn("actStartDate").asObject());
			//dataPeriod.setToDate((java.sql.Date) ro.getColumn("actEndDate").asObject());
			//to.setPeriodComposition(dataPeriod);
			to.setNamePosition(ro.getColumn("namePosition").asString());
			to.setNumberPosition(ro.getColumn("numberPosition").asString());
			to.setNameOrg(ro.getColumn("nameOrg").asString());			

			ret.add(to);
		}
		return ret;
	}

	/**
	 * Ћист первичных документов по данной описи, прив€занных к акту взаимозачета.
	 * Creation date: (07.11.2005 12:19:16)
	 */
	private static final List getListComposition_MutualAct(Integer idRegistryDoc, Integer regionID, String aSortBy) {
		List ret = new ArrayList();
		CDBCRowObject ro = null;
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();

		StringBuffer sqlb = new StringBuffer(LIST_COMPOSITION_MUTUAL_ACT_SQL);
		sqlb.append(" AND ld.idRegistryDoc = ? ");
		params.add(idRegistryDoc);

		//append order by clause:
		if (aSortBy != null)
			sqlb.append(" order by " + aSortBy);

		//executeQuery:
		System.out.println("getListComposition_MutualAct sql=" + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		RegistryBuchCompositionMutAct_TOC to = null;
		while (iter.hasNext()) {
			ro = (CDBCRowObject) iter.next();
			to = new RegistryBuchCompositionMutAct_TOC((Integer) ro.getColumn("leasedocument").asObject());
			to.setIdRegistryDoc((Integer) ro.getColumn("idRegistryDoc").asObject());
			to.setActState(ro.getColumn("actState").asString());
			to.setDocNumber(ro.getColumn("docNumber").asString());
			to.setDocDate((java.sql.Date) ro.getColumn("docDate").asObject());
			//to.setTypeComposition((Integer) ro.getColumn("typeComposition").asObject());
			//инициализаци€ периода:
			//DataPeriod dataPeriod = new DataPeriod();
			//dataPeriod.setFromDate((java.sql.Date) ro.getColumn("actStartDate").asObject());
			//dataPeriod.setToDate((java.sql.Date) ro.getColumn("actEndDate").asObject());
			//to.setPeriodComposition(dataPeriod);
			to.setNamePosition(ro.getColumn("namePosition").asString());
			to.setNumberPosition(ro.getColumn("numberPosition").asString());
			to.setNameOrg(ro.getColumn("nameOrg").asString());
			
			List buchList = getListComposition_SF_CWA_ForMutualAct(to.getLeaseDocument(), idRegistryDoc, null); //aSortBy
			to.setBuchList(buchList);
			//System.out.println("list.size()= " + list.size());
			ret.add(to);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	public static final boolean attachDocs(Integer idRegistryDoc, String aSelectIds, int typeRegistryDoc) {
		boolean ret = false;
		if (typeRegistryDoc == typeRegistry_SF) {
			ret = attachDocs_SF(idRegistryDoc, aSelectIds);
		} else if (typeRegistryDoc == typeRegistry_CWA) {
			ret = attachDocs_CWA(idRegistryDoc, aSelectIds);
		} else if (typeRegistryDoc == typeRegistry_LeaseDoc) {
			ret = attachDocs_LeaseDoc(idRegistryDoc, aSelectIds);
		} else if (typeRegistryDoc == typeRegistry_MUTUAL_ACT) {
			ret = attachDocs_MutualAct(idRegistryDoc, aSelectIds);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	public static final boolean revertStateDoc(Integer idDoc, String stateDoc, String stateRegistryBuchDoc, int typeRegistryDoc) {
		boolean ret = false;
		if (typeRegistryDoc == typeRegistry_SF) {
			ret = revertDocs_SF(idDoc, stateDoc, stateRegistryBuchDoc);
		} else if (typeRegistryDoc == typeRegistry_CWA) {
			ret = revertDocs_CWA(idDoc, stateDoc, stateRegistryBuchDoc);
		} else if (typeRegistryDoc == typeRegistry_LeaseDoc) {
			//ret = revertDocs_LeaseDoc(idRegistryDoc, stateDoc, stateRegistryBuchDoc);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	private static final boolean revertDocs_SF(Integer idDoc, String stateDoc, String stateRegistryBuchDoc) {
		CDBCResultSet res = new CDBCResultSet();
		String newStateDoc = stateDoc;
		if ("V".equals(stateDoc)) {
			if (AbstractRegistryBuchDocsStateFactory.EDIT_PURCHASER.equals(stateRegistryBuchDoc)) {
				newStateDoc = "4";
			} else if (AbstractRegistryBuchDocsStateFactory.EDIT_ACCOUNTANT.equals(stateRegistryBuchDoc)) {
				newStateDoc = "2";
			}
		} else {
			newStateDoc = "V";
		}
		Object[] params = { newStateDoc, idDoc };
		return res.executeUpdate(SET_STATE_DOCS_SF_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	private static final boolean revertDocs_CWA(Integer idDoc, String stateDoc, String stateRegistryBuchDoc) {
		CDBCResultSet res = new CDBCResultSet();
		String newStateDoc = stateDoc;
		if ("V".equals(stateDoc)) {
			if (AbstractRegistryBuchDocsStateFactory.EDIT_PURCHASER.equals(stateRegistryBuchDoc)) {
				newStateDoc = "4";
			} else if (AbstractRegistryBuchDocsStateFactory.EDIT_ACCOUNTANT.equals(stateRegistryBuchDoc)) {
				newStateDoc = "2";
			}
		} else {
			newStateDoc = "V";
		}
		Object[] params = { newStateDoc, idDoc };
		return res.executeUpdate(SET_STATE_DOCS_CWA_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	private static final boolean attachDocs_SF(Integer idRegistryDoc, String aSelectIds) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { idRegistryDoc };
		return res.executeUpdate(ATTACH_DOCS_SF_SQL + " WHERE idSchetFakt IN (" + aSelectIds + ")", params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	private static final boolean attachDocs_CWA(Integer idRegistryDoc, String aSelectIds) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { idRegistryDoc };
		return res.executeUpdate(ATTACH_DOCS_CWA_SQL + " WHERE idCWAcode IN (" + aSelectIds + ")", params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	private static final boolean attachDocs_LeaseDoc(Integer idRegistryDoc, String aSelectIds) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { idRegistryDoc };
		return res.executeUpdate(ATTACH_DOCS_LeaseDoc_SQL + " WHERE leaseDocument IN (" + aSelectIds + ")", params);
	}
	/**
	* Insert the method's description here.
	* Creation date: (09.11.2005 12:10:45)
	*/
	private static final boolean attachDocs_MutualAct(Integer idRegistryDoc, String aSelectIds) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { idRegistryDoc };
		res.executeUpdate(ATTACH_DOCS_MutualAct_SQL + " WHERE leaseDocument IN (" + aSelectIds + ")", params);
		//выполн€ем прив€зку SF и CAW:
		StringTokenizer st = new StringTokenizer(aSelectIds, " ,");
		while(st.hasMoreTokens()) {
			Integer idMutAct = new Integer(st.nextToken().trim());
			List buchList = getListComposition_SF_CWA_ForMutualAct(idMutAct, null, null); //aSortBy
			Iterator iter = buchList.iterator();
			while (iter.hasNext()) {
				RegistryBuchCompositionObject_TO to = (RegistryBuchCompositionObject_TO) iter.next();
				int type = to.getTypeComposition().intValue();
				if (type == RegistryBuchCompositionObject_TO.TYPE_COMPOSITION_CWA) {
					attachDocs_CWA(idRegistryDoc, to.getIdComposition().toString());
				} else if (type == RegistryBuchCompositionObject_TO.TYPE_COMPOSITION_SF) {
					attachDocs_SF(idRegistryDoc, to.getIdComposition().toString());
				}
			}
		}
		return true;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	public static final boolean detachDocs(Integer idRegistryDoc, int typeRegistryDoc) {
		boolean ret = false;
		if (typeRegistryDoc == typeRegistry_SF) {
			ret = detachDocs_SF(idRegistryDoc);
		} else if (typeRegistryDoc == typeRegistry_CWA) {
			ret = detachDocs_CWA(idRegistryDoc);
		} else if (typeRegistryDoc == typeRegistry_LeaseDoc) {
			ret = detachDocs_LeaseDoc(idRegistryDoc);
		} else if (typeRegistryDoc == typeRegistry_MUTUAL_ACT) {
			detachDocs_CWA(idRegistryDoc);
			detachDocs_SF(idRegistryDoc);
			ret = detachDocs_MutualAct(idRegistryDoc);
		}
		return ret;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	private static final boolean detachDocs_SF(Integer idRegistryDoc) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { idRegistryDoc };
		return res.executeUpdate(DETACH_DOCS_SF_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	private static final boolean detachDocs_CWA(Integer idRegistryDoc) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { idRegistryDoc };
		return res.executeUpdate(DETACH_DOCS_CWA_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	private static final boolean detachDocs_LeaseDoc(Integer idRegistryDoc) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { idRegistryDoc };
		return res.executeUpdate(DETACH_DOCS_LeaseDoc_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:10:45)
	 */
	private static final boolean detachDocs_MutualAct(Integer idRegistryDoc) {
		CDBCResultSet res = new CDBCResultSet();
		Object[] params = { idRegistryDoc };
		return res.executeUpdate(DETACH_DOCS_MutualAct_SQL, params);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2004 14:31:05)
	 */
	public static String changeStateRegistryBuchDoc(int idCode, String toState, int codeOperator) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = ""; //признак выполнени€ без ошибок!!!
		try {
			String sql = "execute procedure changeStateRegistryBuchDoc(?, ?, ?)";
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			cs.setInt(1, idCode); //код 
			cs.setString(2, toState); //желаемое состо€ние 
			cs.setInt(3, codeOperator); //код оператора		

			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- ѕризнак ошибки (0 без ошибок)
				if (result == 0) {
					//System.out.println("ѕроцедура 'changeStateRegistryBuchDoc' ok"); //temp
				} else {
					errorTxt = rs.getString(2); // char(255), -- сообщени€ об ошибках
					System.out.println("ѕроцедура 'changeStateRegistryBuchDoc' errorTxt: " + errorTxt); //temp
				}
			} else {
				System.out.println("no DATA: execute procedure 'changeStateRegistryBuchDoc'"); //temp
			}

		} catch (Exception ex) {
			errorTxt = "Error in execute procedure 'changeStateRegistryBuchDoc(?, ?, ?)'";
			System.out.println(errorTxt);
			if (ex instanceof SQLException) {
				errorTxt += "Error code=" + ((SQLException) ex).getErrorCode();
				System.out.println(errorTxt);
			}
			ex.printStackTrace();
		} finally {
			finallyMetod(con, cs, rs);
		}
		return errorTxt;

	}
	/**
	 * 
	 * @param con
	 * @param cs
	 * @param rs
	 */
	private static void finallyMetod(Connection con, CallableStatement cs, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (cs != null)
				cs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

}
