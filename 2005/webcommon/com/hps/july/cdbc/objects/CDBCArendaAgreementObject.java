package com.hps.july.cdbc.objects;

import com.hps.july.arenda.valueobject.LeaseArendaAgreementNewVO;
import com.hps.july.arenda.valueobject.LeaseArendaAgrmntVO;
import com.hps.july.cdbc.lib.*;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.util.*;

import java.sql.*;
import java.util.*;

/**
 * Объект для работы с договорами аренды.
 * Creation date: (10.03.2004 15:14:25)
 * @author: Shafigullin Ildar
 */
public class CDBCArendaAgreementObject {
	private static final String findSqlString =
		"SELECT T3.createdby, T3.modifiedby, T3.docdate, T3.docnumber, T3.leasedocument, T3.modified, T3.created, T3.operator, T3.regionid, T3.doctype, T2.reportperiod, T2.enddate, T2.contracttype, T2.summ1, T2.contractstate, T2.ratecalcruleday, T2.orgowner, T2.ratecalcrule, T2.dateclose, T2.ratedelta, T2.execname, T2.startdate, T2.extendperiod, T2.summ2, T2.chargends, T2.extendtype, T2.CustName, T2.docfilename, T2.changeenddate, T2.extendyears, T2.extendmonthes, T2.extenddays, T2.ratends, T2.nalogagent, T2.orgexecutor, T2.manager, T2.orgcustomer, T2.economist, T2.currency2, T2.currency1, T1.dogelectonum, T1.dogelectrodate, T1.numberofphones, T1.numberofphonestemp, T1.calcelectrotype, T1.mainleasedocument, T1.isactive, T1.isdogelectro, T1.officialdoc, T1.activecontract, T1.mainresource, T1.sumtrafic, T1.sumaccept, T1.sumpay, T1.needofficialdoc, T1.basestartdate, T1.baseenddate, T1.customerold, T1.haveioact, T1.ioactnumber, T1.ioactdate, T1.mainposition, getListPosContract(T1.leasedocument) allPositions, getNamePosition(T1.mainposition) mainpositionName, '' docfilename, '' doccomment, '' docsubject, '' orgcustomername, '' orgcustomerinn, '' orgexecutorname, getNameCurrency(currency1,0,0) curr1name, T3.idRegistryDoc as numRegistryDoc FROM leasedocuments  T3, leasearendaagrmnts  T1, leasecontracts  T2 WHERE T3.doctype = \'A\' AND T2.leasedocument = T1.leasedocument AND T3.leasedocument = T2.leasedocument ";
	private final static java.lang.String POSITION_DOP_INFO_SQL =
		"SELECT p.storageplace, getNumBsGsmOnPos(p.storageplace, 0) gsmid, getNumBsDampsOnPos(p.storageplace, 0) dampsid, s.address, getNamePosition(p.storageplace) name, "
			+ "applacetypes.name applacetypeName,    apparattypes.name  apparattypename, "
			+ "apparatplaces.name apparatplacename,   oporaplaces.name oporaplacename, "
			+ "antennplaces.name antennplacename,    antennplaces.isvc,   p.oporaour  "
			+ "FROM positions p,   storagePlaces s,   outer applacetypes,  outer apparattypes,   outer apparatplaces,  outer oporaplaces,  outer antennplaces "
			+ "WHERE  p.storagePlace = s.storagePlace "
			+ "AND apparattypes.aptypeid = p.aptypeid "
			+ "AND applacetypes.applacetypeid = p.applacetypeid "
			+ "AND apparatplaces.applaceid = p.applaceid "
			+ "AND oporaplaces.oplaceid = p.oporplaceid "
			+ "AND antennplaces.antplaceid = p.antplaceid ";
	/**
	 * CDBCPositionObject constructor comment.
	 */
	public CDBCArendaAgreementObject() {
		super();
	}
	/**
	* Возвращает список доп. соглашений/договоров аренды для:
	*/
	public static CDBCResultSet findActiveArendaAgreements(
		Boolean isOrgCustomer,
		Integer orgCustomer,
		Boolean isOrgExecutor,
		Integer orgExecutor,
		Boolean isMainEconomist,
		Integer mainEconomist,
		Boolean isPosition,
		Integer position,
		Boolean isDocNumber,
		String docNumber,
		Boolean isState,
		String state,
		Integer order) {

		StringBuffer sqlb = new StringBuffer();
		ArrayList params = new ArrayList();

		CDBCResultSet res = new CDBCResultSet();
		sqlb.append("SELECT leasedocuments.leasedocument, ");
		sqlb.append("leasedocuments.docdate, leasedocuments.docnumber, leasedocuments.doctype, leasedocuments.operator, ");
		sqlb.append("leasecontracts.contracttype, leasecontracts.contractstate, leasecontracts.orgcustomer, ");
		sqlb.append("leasecontracts.orgexecutor, leasecontracts.custname, leasecontracts.execname, ");
		sqlb.append("leasecontracts.startdate, leasecontracts.enddate, "); //leasecontracts.doctext,
		//sqlb.append("leasecontracts.docfilename, leasecontracts.doccomment, leasecontracts.docsubject, ");
		sqlb.append("'' docfilename, '' doccomment, '' docsubject, ");
		sqlb.append("leasecontracts.extendtype, leasecontracts.extendperiod, leasecontracts.reportperiod, ");
		sqlb.append("leasecontracts.economist, leasecontracts.currency1, leasecontracts.currency2, ");
		sqlb.append("leasecontracts.summ1, leasecontracts.summ2, leasecontracts.ratecalcrule, ");
		sqlb.append("leasecontracts.ratecalcruleday, leasecontracts.ratedelta, leasecontracts.manager, ");
		sqlb.append("leasecontracts.dateclose, leasearendaagrmnts.mainleasedocument, leasearendaagrmnts.isactive, ");
		sqlb.append("leasearendaagrmnts.numberofphones, leasearendaagrmnts.calcelectrotype, leasearendaagrmnts.isdogelectro, ");
		sqlb.append("leasearendaagrmnts.dogelectonum, leasearendaagrmnts.dogelectrodate, leasearendaagrmnts.numberofphonestemp, leasearendaagrmnts.mainposition ");
		sqlb.append("FROM leasearendaagrmnts, leasecontracts, leasedocuments ");
		//calculate where clause
		StringBuffer whereClause = new StringBuffer("WHERE ( leasecontracts.leasedocument = leasearendaagrmnts.leasedocument AND leasedocuments.leasedocument = leasecontracts.leasedocument ) ");
		whereClause.append("AND ((");
		whereClause.append("leasearendaagrmnts.isactive = 'Y' AND leasearendaagrmnts.mainleasedocument IN ");
		//calculate filter clause
		StringBuffer filter =
			new StringBuffer(
				"(SELECT d1.leasedocument FROM leasedocuments d1, leasecontracts d2, leasearendaagrmnts d3 WHERE " + " d3.leasedocument=d2.leasedocument AND d2.leasedocument=d1.leasedocument ");
		if (isOrgCustomer != null && isOrgCustomer.booleanValue()) {
			filter.append("AND leasecontracts.orgcustomer = " + orgCustomer + " ");
			//params.add(orgCustomer);
		}
		if (isOrgExecutor != null && isOrgExecutor.booleanValue()) {
			filter.append("AND  leasecontracts.orgexecutor = " + orgExecutor + " ");
			//params.add(orgExecutor);
		}
		if (isMainEconomist != null && isMainEconomist.booleanValue()) {
			filter.append("AND  leasecontracts.economist = " + mainEconomist + " ");
			//params.add(mainEconomist);
		}
		if (isPosition != null && isPosition.booleanValue()) {
			filter.append("AND exists (select l.* from leaseonpositions l where l.leasedocument=leasecontracts.leasedocument and l.storageplace = " + position + ") ");
			//params.add(position);
		}
		if (isDocNumber != null && isDocNumber.booleanValue()) {
			filter.append("AND upper(leasedocuments.docnumber) matches upper('" + docNumber + "') ");
			//sqlb.append("and upper(leasedocuments.docnumber) matches upper(?) ");
			//params.add(docNumber);
		}
		if (isState.booleanValue())
			if ("1".equalsIgnoreCase(state))
				filter.append("and leasecontracts.contractstate = 'A' ");
			else if ("2".equalsIgnoreCase(state))
				filter.append("and leasecontracts.contractstate = 'B' ");
			else if ("3".equalsIgnoreCase(state))
				filter.append("and leasecontracts.contractstate = 'C' ");
		filter.append(" ) ");

		whereClause.append(filter);
		sqlb.append(whereClause);
		sqlb.append(") OR (");
		sqlb.append("leasearendaagrmnts.isactive = 'Y' AND leasearendaagrmnts.mainleasedocument IS NULL AND leasearendaagrmnts.leasedocument IN ");
		sqlb.append(filter);
		sqlb.append(")) ");
		//sqlb.append("ORDER BY leasedocuments.docnumber");

		//System.out.println("SQL :"+sqlb.toString()); //temp
		//System.out.println("params.size(): " + params.size()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	* Возвращает список доп. соглашений/договоров аренды для:
	*/
	public static CDBCResultSet findArendaAgreements(
		Boolean isOrgCustomer,
		Integer orgCustomer,
		Boolean isOrgExecutor,
		Integer orgExecutor,
		Boolean isMainEconomist,
		Integer mainEconomist,
		Boolean isPosition,
		Integer position,
		Boolean isDocNumber,
		String docNumber,
		Boolean isState,
		String state,
		Boolean isResource,
		String resourcecode,
		Boolean isRegionID,
		Integer regionID,
		String sortBy) {

		StringBuffer sqlb = new StringBuffer();
		ArrayList params = new ArrayList();

		CDBCResultSet res = new CDBCResultSet();
		sqlb.append("SELECT first 1000 activeDogD.leasedocument, activeDogD.regionid, ");
		sqlb.append("activeDogD.docdate, activeDogD.docnumber, activeDogD.doctype, activeDogD.operator, ");
		sqlb.append("activeDogC.contracttype, activeDogC.contractstate, activeDogC.orgcustomer, ");
		sqlb.append("activeDogC.orgexecutor, activeDogC.custname, activeDogC.execname, ");
		sqlb.append("activeDogC.startdate, activeDogC.enddate, "); //activeDogC.doctext, 
		//sqlb.append("activeDogC.docfilename, activeDogC.doccomment, activeDogC.docsubject, ");
		sqlb.append("'' docfilename, '' doccomment, '' docsubject, ");
		sqlb.append("activeDogC.extendtype, activeDogC.extendperiod, activeDogC.reportperiod, ");
		sqlb.append("activeDogC.economist, activeDogC.currency1, activeDogC.currency2, ");
		sqlb.append("activeDogC.summ1, activeDogC.summ2, activeDogC.ratecalcrule, ");
		sqlb.append("activeDogC.ratecalcruleday, activeDogC.ratedelta, activeDogC.manager, ");
		sqlb.append("activeDogC.dateclose, activeDogA.mainleasedocument, activeDogA.isactive, ");
		sqlb.append("activeDogA.numberofphones, activeDogA.calcelectrotype, activeDogA.isdogelectro, activeDogA.officialdoc, activeDogA.needofficialdoc, ");
		sqlb.append("activeDogA.dogelectonum, activeDogA.dogelectrodate, activeDogA.numberofphonestemp, activeDogA.mainposition, ");
		sqlb.append("baseDogD.docnumber mainDocumentNumber, baseDogD.docdate maindocdate, baseDogC.contractstate maincontractstate, ");
		sqlb.append("baseDogC.startdate mainstartdate, baseDogC.economist mainEconomist, baseDogC.manager mainManager, baseDogC.dateclose maindateclose, ");
		sqlb.append("getNamePosition(baseDogA.mainposition) mainpositionName, ");
		sqlb.append("getListPosContract(baseDogD.leasedocument, 2) allposition, ");
		//sqlb.append("getListResContract(baseDogD.leasedocument) resource, ");
		sqlb.append("getNameresource(baseDogA.mainResource) resource, ");
		sqlb.append("getNameOrg(baseDogC.orgExecutor) orgExecutorName, ");
		sqlb.append("getNameOrg(baseDogC.orgCustomer) orgCustomerName, ");
		sqlb.append("getInnOrg(baseDogC.orgCustomer) orgCustomerInn, ");
		sqlb.append("getNameCurrency(activeDogC.currency1,0,0) curr1Name, ");
		sqlb.append("getNameCurrency(activeDogC.currency1,0,0) curr2Name, ");
		//sqlb.append("getSumTrafContract(activeDogA.leasedocument, activeDogC.currency1) trafic1, ");
		//sqlb.append("getSumTrafContract(activeDogA.leasedocument, activeDogC.currency2) trafic2, ");
		sqlb.append("BaseDogA.sumTrafic trafic1, ");
		//sqlb.append("getSumAcceptContr(activeDogA.leasedocument, activeDogC.currency1) accept1, ");
		//sqlb.append("getSumAcceptContr(activeDogA.leasedocument, activeDogC.currency2) accept2, ");
		sqlb.append("BaseDogA.sumAccept accept1, ");
		sqlb.append("getNameWorker(baseDogC.economist) mainEconomistName, ");
		sqlb.append("getNameWorker(baseDogC.manager) mainManagerName ");
		sqlb.append("FROM leasearendaagrmnts baseDogA, leasecontracts baseDogC, leasedocuments baseDogD, ");
		sqlb.append("leasearendaagrmnts activeDogA, leasecontracts activeDogC, leasedocuments activeDogD ");
		//calculate where clause// getInnOrg(T2.orgCustomer) orgCustomerInn,
		StringBuffer whereClause = new StringBuffer("WHERE ");
		whereClause.append("baseDogA.mainleasedocument is null ");
		whereClause.append("AND baseDogC.leasedocument = baseDogA.leasedocument ");
		whereClause.append("AND baseDogD.leasedocument = baseDogA.leasedocument ");
		//whereClause.append("AND activeDogA.leasedocument = getActiveContract(baseDogA.leasedocument) ");
		/**whereClause.append("AND activeDogA.leasedocument = baseDogA.ActiveContract ");*/
		whereClause.append("AND activeDogA.leasedocument = nvl(baseDogA.ActiveContract,baseDogA.leasedocument) ");
		//whereClause.append("AND (activeDogA.mainleasedocument is null or activeDogA.mainleasedocument = baseDogA.leasedocument) ");
		whereClause.append("AND activeDogC.leasedocument = activeDogA.leasedocument ");
		whereClause.append("AND activeDogD.leasedocument = activeDogA.leasedocument ");
		//calculate filter clause
		StringBuffer filter = new StringBuffer();
		if (isOrgCustomer != null && isOrgCustomer.booleanValue()) {
			filter.append("AND baseDogC.orgcustomer = ? ");
			params.add(orgCustomer);
		}
		if (isOrgExecutor != null && isOrgExecutor.booleanValue()) {
			filter.append("AND  baseDogC.orgexecutor = ? ");
			params.add(orgExecutor);
		}
		if (isMainEconomist != null && isMainEconomist.booleanValue()) {
			filter.append("AND  (baseDogC.economist = ? OR baseDogC.manager = ?) ");
			params.add(mainEconomist);
			params.add(mainEconomist);
		}
		if (isPosition != null && isPosition.booleanValue()) {
			filter.append("AND exists (select l.* from leaseonpositions l where l.leasedocument=baseDogC.leasedocument AND l.storageplace = ?) ");
			params.add(position);
		}
		if (isDocNumber != null && isDocNumber.booleanValue()) {
			//filter.append("AND upper(baseDogD.docnumber) matches upper('" + docNumber + "') ");
			filter.append("AND upper(baseDogD.docnumber) matches upper(?) ");
			params.add(docNumber);
		}
		if (isState.booleanValue()) {
			filter.append("AND baseDogC.contractstate = ? ");
			if ("1".equalsIgnoreCase(state)) {
				params.add("A");
			} else if ("2".equalsIgnoreCase(state)) {
				params.add("B");
			} else if ("3".equalsIgnoreCase(state)) {
				params.add("C");
			} else if ("4".equalsIgnoreCase(state)) {
				params.add("D");
			}
		}
		if (isResource.booleanValue()) {
			filter.append("AND baseDogA.mainResource = ? ");
			params.add(resourcecode);
		}
		if (isRegionID.booleanValue()) {
			filter.append("AND baseDogD.regionid = ? ");
			params.add(regionID);
		}
		whereClause.append(filter);
		sqlb.append(whereClause);
		//append order by clause:
		sqlb.append("order by " + sortBy);

		res.executeQuery(sqlb.toString(), params.toArray());
		//res.executeQuery(sqlb.toString(), null);
		System.out.println("sqlb.toString()=" + sqlb.toString()); //temp
		return res;
	}
	/**
	* Возвращает список доп. соглашений/договоров аренды для(+):
	*/
	public static CDBCResultSet findArendaAgreements(
		Integer filter,		String searchString,
		Boolean isOrgCustomer,		Integer orgCustomer,
		Boolean isOrgExecutor,		Integer orgExecutor,	Integer orgExecutor_VendorSiteID,
		Boolean isMainEconomist,		Integer mainEconomist,
		Boolean isPosition,		Integer position,
		Boolean isState,		String state,
		Boolean isResource,		String resourcecode,
		Boolean isRegionID,		Integer regionID,
		String sortBy) {

		StringBuffer sqlb = new StringBuffer();
		ArrayList params = new ArrayList();

		CDBCResultSet res = new CDBCResultSet();
		sqlb.append("SELECT first 1000 activeDogD.leasedocument, activeDogD.regionid, ");
		sqlb.append("activeDogD.docdate, activeDogD.docnumber, activeDogD.doctype, activeDogD.operator, ");
		sqlb.append("activeDogC.contracttype, activeDogC.contractstate, activeDogC.orgcustomer, ");
		sqlb.append("activeDogC.orgexecutor, activeDogC.custname, activeDogC.execname, ");
		sqlb.append("activeDogC.startdate, activeDogC.enddate, "); //activeDogC.doctext, 
		sqlb.append("'' docfilename, '' doccomment, '' docsubject, ");
		sqlb.append("activeDogC.extendtype, activeDogC.extendperiod, activeDogC.reportperiod, ");
		sqlb.append("activeDogC.economist, activeDogC.currency1, activeDogC.currency2, ");
		sqlb.append("activeDogC.summ1, activeDogC.summ2, activeDogC.ratecalcrule, ");
		sqlb.append("activeDogC.ratecalcruleday, activeDogC.ratedelta, activeDogC.manager, ");
		sqlb.append("activeDogC.dateclose, activeDogA.mainleasedocument, activeDogA.isactive, ");
		sqlb.append("activeDogA.numberofphones, activeDogA.calcelectrotype, activeDogA.isdogelectro, activeDogA.officialdoc, activeDogA.needofficialdoc, ");
		sqlb.append("activeDogA.dogelectonum, activeDogA.dogelectrodate, activeDogA.numberofphonestemp, activeDogA.mainposition, ");
		sqlb.append("baseDogD.docnumber mainDocumentNumber, baseDogD.docdate maindocdate, baseDogC.contractstate maincontractstate, ");
		sqlb.append("baseDogC.startdate mainstartdate, baseDogC.economist mainEconomist, baseDogC.manager mainManager, baseDogC.dateclose maindateclose, ");
		sqlb.append("getNamePosition(activeDogA.mainposition) mainpositionName, ");
		sqlb.append("getListPosContract(activeDogD.leasedocument, 2) allposition, ");
		//sqlb.append("getListResContract(baseDogD.leasedocument) resource, ");
		sqlb.append("getNameresource(baseDogA.mainResource) resource, ");
		sqlb.append("getNameOrg(baseDogC.orgExecutor) orgExecutorName, ");
		sqlb.append("getNameOrg(baseDogC.orgCustomer) orgCustomerName, ");
		sqlb.append("getInnOrg(baseDogC.orgCustomer) orgCustomerInn, ");
		sqlb.append("getNameCurrency(activeDogC.currency1,0,0) curr1Name, ");
		sqlb.append("getNameCurrency(activeDogC.currency1,0,0) curr2Name, ");
		//sqlb.append("getSumTrafContract(activeDogA.leasedocument, activeDogC.currency1) trafic1, ");
		//sqlb.append("getSumTrafContract(activeDogA.leasedocument, activeDogC.currency2) trafic2, ");
		sqlb.append("BaseDogA.sumTrafic trafic1, ");
		//sqlb.append("getSumAcceptContr(activeDogA.leasedocument, activeDogC.currency1) accept1, ");
		//sqlb.append("getSumAcceptContr(activeDogA.leasedocument, activeDogC.currency2) accept2, ");
		sqlb.append("BaseDogA.sumAccept accept1, ");
		sqlb.append("getNameWorker(baseDogC.economist) mainEconomistName, ");
		sqlb.append("getNameWorker(baseDogC.manager) mainManagerName, ");
		sqlb.append("getCountProblemOnContract(baseDogA.leasedocument) countProblemOnContract ");
		sqlb.append("FROM leasearendaagrmnts baseDogA, leasecontracts baseDogC, leasedocuments baseDogD, ");
		sqlb.append("leasearendaagrmnts activeDogA, leasecontracts activeDogC, leasedocuments activeDogD, ");
		sqlb.append("vendorsites vs ");
		//calculate where clause// getInnOrg(T2.orgCustomer) orgCustomerInn,
		StringBuffer whereClause = new StringBuffer("WHERE ");
		whereClause.append("baseDogA.mainleasedocument is null ");
		whereClause.append("AND baseDogC.leasedocument = baseDogA.leasedocument ");
		whereClause.append("AND baseDogD.leasedocument = baseDogA.leasedocument ");
		//whereClause.append("AND activeDogA.leasedocument = getActiveContract(baseDogA.leasedocument) ");
		/**whereClause.append("AND activeDogA.leasedocument = baseDogA.ActiveContract ");*/
		whereClause.append("AND activeDogA.leasedocument = nvl(baseDogA.ActiveContract,baseDogA.leasedocument) ");
		//whereClause.append("AND (activeDogA.mainleasedocument is null or activeDogA.mainleasedocument = baseDogA.leasedocument) ");
		whereClause.append("AND activeDogC.leasedocument = activeDogA.leasedocument ");
		whereClause.append("AND activeDogD.leasedocument = activeDogA.leasedocument ");
		whereClause.append("AND baseDogC.orgExecutor = vs.idVendorSite ");
		//calculate filter clause
		StringBuffer filterSB = new StringBuffer();
		if (isOrgCustomer != null && isOrgCustomer.booleanValue()) {
			filterSB.append("AND baseDogC.orgcustomer = ? ");
			params.add(orgCustomer);
		}
		if (isOrgExecutor != null && isOrgExecutor.booleanValue() && orgExecutor != null && orgExecutor.intValue() != -1 ) {
			if(orgExecutor_VendorSiteID.intValue() == -1){
				//поиск по всем отделениям заказчика(арендадателя):
				filterSB.append("AND vs.idVendor = ? ");
				//params.add(regionID);
				params.add(orgExecutor);
			}else{
				filterSB.append("AND vs.idVendorSite = ? ");
				params.add(orgExecutor_VendorSiteID);
			}
		}
		if (isMainEconomist != null && isMainEconomist.booleanValue()) {
			filterSB.append("AND  (baseDogC.economist = ? OR baseDogC.manager = ?) ");
			params.add(mainEconomist);
			params.add(mainEconomist);
		}
		if (isPosition != null && isPosition.booleanValue()) {
			//filterSB.append("AND exists (select l.* from leaseonpositions l where l.leasedocument=baseDogC.leasedocument AND l.storageplace = ?) ");
			filterSB.append("AND baseDogA.leasedocument IN( SELECT nvl(la1.mainleasedocument, la1.leasedocument) FROM leaseonpositions lp, leasearendaagrmnts la1 WHERE la1.leasedocument = lp.leasedocument AND lp.storageplace = ? ) ");
			params.add(position);
		}
		//filter searchString:
		if (filter.intValue() == 1) {
			//номер договора:
			filterSB.append("AND upper(baseDogD.docnumber) matches upper(?) ");
			params.add(searchString);
		} else if (filter.intValue() == 2) {
			//исполнитель(арендодатель):
			filterSB.append("AND baseDogC.orgexecutor IN (SELECT organization FROM organizations WHERE lower(name) matches lower(?) OR lower(shortname) matches lower(?) ) ");
			params.add(searchString);
			params.add(searchString);
		} else if (filter.intValue() == 3) {
			//ответственный менеджер или экономист:
			filterSB.append(
				"AND  (baseDogC.economist IN( SELECT w.worker FROM workers w, people p WHERE w.man = p.man AND lower(p.lastname) matches lower(?) ) OR baseDogC.manager IN( SELECT w.worker FROM workers w, people p WHERE w.man = p.man AND lower(p.lastname) matches lower(?) ) ) ");
			params.add(searchString);
			params.add(searchString);
		} else if (filter.intValue() == 4 && searchString != null && !searchString.trim().equals("*")){
			//ответственный менеджер:
			//filterSB.append("AND baseDogC.manager IN( SELECT w.worker FROM workers w, people p WHERE w.man = p.man AND lower(p.lastname) matches lower(?) ) ");
			//params.add(searchString);
			addSQLforPeople("baseDogC.manager", searchString, params, filterSB);
		} else if (filter.intValue() == 5 && searchString != null && !searchString.trim().equals("*")){
			//ответственный экономист:
			//filterSB.append("AND baseDogC.economist IN( SELECT w.worker FROM workers w, people p WHERE w.man = p.man AND lower(p.lastname) matches lower(?) ) ");
			//params.add(searchString);
			addSQLforPeople("baseDogC.economist", searchString, params, filterSB);
		} else if (filter.intValue() == 6) {
			//№ GSM/DCS:
			//filterSB.append("AND baseDogA.mainposition IN( select position from equipment eq,basestations bs where bs.equipment=eq.equipment and bs.type!='D' and bs.number = ? ) ");
			filterSB.append("AND baseDogA.leasedocument IN( SELECT nvl(la1.mainleasedocument, la1.leasedocument) FROM leaseonpositions lp, leasearendaagrmnts la1 WHERE la1.leasedocument = lp.leasedocument AND ( (lp.storageplace IN( select position from equipment eq,basestations bs where bs.equipment=eq.equipment and bs.type!='D' and bs.number = ? )) OR (lp.storagePlace IN (select e.position from repiters r, equipment e WHERE e.equipment = r.equipment AND r.number = ?)) ) )");
			params.add(searchString);
			params.add(searchString);
		} else if (filter.intValue() == 7) {
			//№ DAMPS:
			//filterSB.append("AND baseDogA.mainposition IN( select position from equipment eq,basestations bs where bs.equipment=eq.equipment and bs.type='D' and bs.number = ? ) ");
			filterSB.append("AND baseDogA.leasedocument IN( SELECT nvl(la1.mainleasedocument, la1.leasedocument) FROM leaseonpositions lp, leasearendaagrmnts la1 WHERE la1.leasedocument = lp.leasedocument AND lp.storageplace IN( select position from equipment eq,basestations bs where bs.equipment=eq.equipment and bs.type='D' and bs.number = ? ) ) ");
			params.add(searchString);
		} else if (filter.intValue() == 8) {
			//по названии позиции:
			//filterSB.append("AND baseDogA.mainposition IN( SELECT s.storageplace FROM positions p, storageplaces s WHERE s.storageplace = p.storageplace AND lower(s.name) matches lower(?) ) ");
			filterSB.append("AND baseDogA.leasedocument IN( SELECT nvl(la1.mainleasedocument, la1.leasedocument) FROM leaseonpositions lp, leasearendaagrmnts la1 WHERE la1.leasedocument = lp.leasedocument AND lp.storageplace IN ( SELECT s.storageplace FROM positions p, storageplaces s WHERE s.storageplace = p.storageplace AND lower(s.name) matches lower(?) ) ) ");
			params.add(searchString);
		} else if (filter.intValue() == 9) {
			//по адресу позиции:
			//filterSB.append("AND baseDogA.mainposition IN( SELECT s.storageplace FROM positions p, storageplaces s WHERE s.storageplace = p.storageplace AND lower(s.address) matches lower(?) ) ");
			filterSB.append("AND baseDogA.leasedocument IN( SELECT nvl(la1.mainleasedocument, la1.leasedocument) FROM leaseonpositions lp, leasearendaagrmnts la1 WHERE la1.leasedocument = lp.leasedocument AND lp.storageplace IN ( SELECT s.storageplace FROM positions p, storageplaces s WHERE s.storageplace = p.storageplace AND lower(s.address) matches lower(?) ) ) ");
			params.add(searchString);
		}

		if (isState.booleanValue()) {
			filterSB.append("AND baseDogC.contractstate = ? ");
			if ("1".equalsIgnoreCase(state)) {
				params.add("A");
			} else if ("2".equalsIgnoreCase(state)) {
				params.add("B");
			} else if ("3".equalsIgnoreCase(state)) {
				params.add("C");
			} else if ("4".equalsIgnoreCase(state)) {
				params.add("D");
			}
		}
		if (isResource.booleanValue()) {
			filterSB.append("AND baseDogA.mainResource = ? ");
			params.add(resourcecode);
		}
		if (isRegionID.booleanValue()) {
			filterSB.append("AND baseDogD.regionid = ? ");
			params.add(regionID);
		}
		whereClause.append(filterSB);
		sqlb.append(whereClause);
		//append order by clause:
		sqlb.append("order by " + sortBy);
		System.out.println("CDBCArendaAgreementObject.findArendaAgreements.SQL="+sqlb.toString()+" \n params="+params);//temp
		res.executeQuery(sqlb.toString(), params.toArray());
		//res.executeQuery(sqlb.toString(), null);
		
		return res;
	}
	
	/**
	 * 
	 * @param people
	 * @param peopleName
	 * @param params
	 * @param filter
	 */
	private static void addSQLforPeople(String people, String peopleName, ArrayList params, StringBuffer filter) {
		String strF = " AND " + people + " IN ( SELECT w.worker FROM people p, workers w WHERE w.man = p.man and upper(p.lastName) matches upper(?) ) ";
		String strFI = " AND " + people + " IN ( SELECT w.worker FROM people p, workers w WHERE w.man = p.man and upper(p.lastName) matches upper(?) AND upper(p.firstName) matches upper(?) ) ";
		String strFIO = " AND " + people + " IN ( SELECT w.worker FROM people p, workers w WHERE w.man = p.man and upper(p.lastName) matches upper(?) AND upper(p.firstName) matches upper(?) AND upper(p.middleName) matches upper(?) ) ";
		StringTokenizer st = new StringTokenizer(peopleName, "., ");
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
			params.add(peopleName);
		}
	}
		
	/**
	* Возвращает список доп. соглашений/договоров аренды для:
	*/
	public static CDBCResultSet findArendaAgreements(
		Integer filter,
		String searchString,
		Boolean isOrgCustomer,
		Integer orgCustomer,
		Boolean isOrgExecutor,
		Integer orgExecutor,
		Boolean isMainEconomist,
		Integer mainEconomist,
		Boolean isPosition,
		Integer position,
		Boolean isState,
		String state,
		Boolean isResource,
		String resourcecode,
		Boolean isRegionID,
		Integer regionID,
		String sortBy) {

		StringBuffer sqlb = new StringBuffer();
		ArrayList params = new ArrayList();

		CDBCResultSet res = new CDBCResultSet();
		sqlb.append("SELECT first 1000 activeDogD.leasedocument, activeDogD.regionid, ");
		sqlb.append("activeDogD.docdate, activeDogD.docnumber, activeDogD.doctype, activeDogD.operator, ");
		sqlb.append("activeDogC.contracttype, activeDogC.contractstate, activeDogC.orgcustomer, ");
		sqlb.append("activeDogC.orgexecutor, activeDogC.custname, activeDogC.execname, ");
		sqlb.append("activeDogC.startdate, activeDogC.enddate, "); //activeDogC.doctext, 
		sqlb.append("'' docfilename, '' doccomment, '' docsubject, ");
		sqlb.append("activeDogC.extendtype, activeDogC.extendperiod, activeDogC.reportperiod, ");
		sqlb.append("activeDogC.economist, activeDogC.currency1, activeDogC.currency2, ");
		sqlb.append("activeDogC.summ1, activeDogC.summ2, activeDogC.ratecalcrule, ");
		sqlb.append("activeDogC.ratecalcruleday, activeDogC.ratedelta, activeDogC.manager, ");
		sqlb.append("activeDogC.dateclose, activeDogA.mainleasedocument, activeDogA.isactive, ");
		sqlb.append("activeDogA.numberofphones, activeDogA.calcelectrotype, activeDogA.isdogelectro, activeDogA.officialdoc, activeDogA.needofficialdoc, ");
		sqlb.append("activeDogA.dogelectonum, activeDogA.dogelectrodate, activeDogA.numberofphonestemp, activeDogA.mainposition, ");
		sqlb.append("baseDogD.docnumber mainDocumentNumber, baseDogD.docdate maindocdate, baseDogC.contractstate maincontractstate, ");
		sqlb.append("baseDogC.startdate mainstartdate, baseDogC.economist mainEconomist, baseDogC.manager mainManager, baseDogC.dateclose maindateclose, ");
		sqlb.append("getNamePosition(activeDogA.mainposition) mainpositionName, ");
		sqlb.append("getListPosContract(activeDogD.leasedocument, 2) allposition, ");
		//sqlb.append("getListResContract(baseDogD.leasedocument) resource, ");
		sqlb.append("getNameresource(baseDogA.mainResource) resource, ");
		sqlb.append("getNameOrg(baseDogC.orgExecutor) orgExecutorName, ");
		sqlb.append("getNameOrg(baseDogC.orgCustomer) orgCustomerName, ");
		sqlb.append("getInnOrg(baseDogC.orgCustomer) orgCustomerInn, ");
		sqlb.append("getNameCurrency(activeDogC.currency1,0,0) curr1Name, ");
		sqlb.append("getNameCurrency(activeDogC.currency1,0,0) curr2Name, ");
		//sqlb.append("getSumTrafContract(activeDogA.leasedocument, activeDogC.currency1) trafic1, ");
		//sqlb.append("getSumTrafContract(activeDogA.leasedocument, activeDogC.currency2) trafic2, ");
		sqlb.append("BaseDogA.sumTrafic trafic1, ");
		//sqlb.append("getSumAcceptContr(activeDogA.leasedocument, activeDogC.currency1) accept1, ");
		//sqlb.append("getSumAcceptContr(activeDogA.leasedocument, activeDogC.currency2) accept2, ");
		sqlb.append("BaseDogA.sumAccept accept1, ");
		sqlb.append("getNameWorker(baseDogC.economist) mainEconomistName, ");
		sqlb.append("getNameWorker(baseDogC.manager) mainManagerName, ");
		sqlb.append("getCountProblemOnContract(baseDogA.leasedocument) countProblemOnContract ");
		sqlb.append("FROM leasearendaagrmnts baseDogA, leasecontracts baseDogC, leasedocuments baseDogD, ");
		sqlb.append("leasearendaagrmnts activeDogA, leasecontracts activeDogC, leasedocuments activeDogD ");
		//calculate where clause// getInnOrg(T2.orgCustomer) orgCustomerInn,
		StringBuffer whereClause = new StringBuffer("WHERE ");
		whereClause.append("baseDogA.mainleasedocument is null ");
		whereClause.append("AND baseDogC.leasedocument = baseDogA.leasedocument ");
		whereClause.append("AND baseDogD.leasedocument = baseDogA.leasedocument ");
		//whereClause.append("AND activeDogA.leasedocument = getActiveContract(baseDogA.leasedocument) ");
		/**whereClause.append("AND activeDogA.leasedocument = baseDogA.ActiveContract ");*/
		whereClause.append("AND activeDogA.leasedocument = nvl(baseDogA.ActiveContract,baseDogA.leasedocument) ");
		//whereClause.append("AND (activeDogA.mainleasedocument is null or activeDogA.mainleasedocument = baseDogA.leasedocument) ");
		whereClause.append("AND activeDogC.leasedocument = activeDogA.leasedocument ");
		whereClause.append("AND activeDogD.leasedocument = activeDogA.leasedocument ");
		//calculate filter clause
		StringBuffer filterSB = new StringBuffer();
		if (isOrgCustomer != null && isOrgCustomer.booleanValue()) {
			filterSB.append("AND baseDogC.orgcustomer = ? ");
			params.add(orgCustomer);
		}
		if (isOrgExecutor != null && isOrgExecutor.booleanValue()) {
			filterSB.append("AND  baseDogC.orgexecutor = ? ");
			params.add(orgExecutor);
		}
		if (isMainEconomist != null && isMainEconomist.booleanValue()) {
			filterSB.append("AND  (baseDogC.economist = ? OR baseDogC.manager = ?) ");
			params.add(mainEconomist);
			params.add(mainEconomist);
		}
		if (isPosition != null && isPosition.booleanValue()) {
			//filterSB.append("AND exists (select l.* from leaseonpositions l where l.leasedocument=activeDogC.leasedocument AND l.storageplace = ?) ");
			filterSB.append("AND baseDogA.leasedocument IN( SELECT nvl(la1.mainleasedocument, la1.leasedocument) FROM leaseonpositions lp, leasearendaagrmnts la1 WHERE la1.leasedocument = lp.leasedocument AND lp.storageplace = ? ) ");
			params.add(position);
		}
		//filter searchString:
		if (filter.intValue() == 1) {
			//номер договора:
			filterSB.append("AND upper(baseDogD.docnumber) matches upper(?) ");
			params.add(searchString);
		} else if (filter.intValue() == 2) {
			//исполнитель(арендодатель):
			filterSB.append("AND baseDogC.orgexecutor IN (SELECT organization FROM organizations WHERE lower(name) matches lower(?) OR lower(shortname) matches lower(?) ) ");
			params.add(searchString);
			params.add(searchString);
		} else if (filter.intValue() == 3) {
			//ответственный менеджер или экономист:
			filterSB.append(
				"AND  (baseDogC.economist IN( SELECT w.worker FROM workers w, people p WHERE w.man = p.man AND lower(p.lastname) matches lower(?) ) OR baseDogC.manager IN( SELECT w.worker FROM workers w, people p WHERE w.man = p.man AND lower(p.lastname) matches lower(?) ) ) ");
			params.add(searchString);
			params.add(searchString);
		} else if (filter.intValue() == 4) {
			//ответственный менеджер:
			filterSB.append("AND baseDogC.manager IN( SELECT w.worker FROM workers w, people p WHERE w.man = p.man AND lower(p.lastname) matches lower(?) ) ");
			params.add(searchString);
		} else if (filter.intValue() == 5) {
			//ответственный экономист:
			filterSB.append("AND baseDogC.economist IN( SELECT w.worker FROM workers w, people p WHERE w.man = p.man AND lower(p.lastname) matches lower(?) ) ");
			params.add(searchString);
		} else if (filter.intValue() == 6) {
			//№ GSM/DCS:
			filterSB.append("AND activeDogA.mainposition IN( select position from equipment eq,basestations bs where bs.equipment=eq.equipment and bs.type!='D' and bs.number = ? ) ");
			params.add(searchString);
		} else if (filter.intValue() == 7) {
			//№ DAMPS:
			filterSB.append("AND activeDogA.mainposition IN( select position from equipment eq,basestations bs where bs.equipment=eq.equipment and bs.type='D' and bs.number = ? ) ");
			params.add(searchString);
		} else if (filter.intValue() == 8) {
			//по названии позиции:
			filterSB.append("AND activeDogA.mainposition IN( SELECT s.storageplace FROM positions p, storageplaces s WHERE s.storageplace = p.storageplace AND lower(s.name) matches lower(?) ) ");
			params.add(searchString);
		} else if (filter.intValue() == 9) {
			//по адресу позиции:
			filterSB.append("AND activeDogA.mainposition IN( SELECT s.storageplace FROM positions p, storageplaces s WHERE s.storageplace = p.storageplace AND lower(s.address) matches lower(?) ) ");
			params.add(searchString);
		}

		if (isState.booleanValue()) {
			filterSB.append("AND baseDogC.contractstate = ? ");
			if ("1".equalsIgnoreCase(state)) {
				params.add("A");
			} else if ("2".equalsIgnoreCase(state)) {
				params.add("B");
			} else if ("3".equalsIgnoreCase(state)) {
				params.add("C");
			} else if ("4".equalsIgnoreCase(state)) {
				params.add("D");
			}
		}
		if (isResource.booleanValue()) {
			filterSB.append("AND baseDogA.mainResource = ? ");
			params.add(resourcecode);
		}
		if (isRegionID.booleanValue()) {
			filterSB.append("AND baseDogD.regionid = ? ");
			params.add(regionID);
		}
		whereClause.append(filterSB);
		sqlb.append(whereClause);
		//append order by clause:
		sqlb.append("order by " + sortBy);

		res.executeQuery(sqlb.toString(), params.toArray());
		//res.executeQuery(sqlb.toString(), null);
		//System.out.println("sqlb.toString()="+sqlb.toString());//temp
		return res;
	}
	/**
	* Возвращает список доп. соглашений/договоров аренды по позиции:
	*/
	public static CDBCResultSet findArendaAgreementsByPosition(Boolean isPosition, Integer position, Boolean isState, String stateList, Boolean isRegionID, Integer regionID, Integer order) {

		StringBuffer sqlb = new StringBuffer();
		ArrayList params = new ArrayList();

		CDBCResultSet res = new CDBCResultSet();
		sqlb.append("SELECT activeDogD.leasedocument, activeDogD.regionid, ");
		sqlb.append("activeDogD.docdate, activeDogD.docnumber, activeDogD.doctype, activeDogD.operator, ");
		sqlb.append("activeDogC.contracttype, activeDogC.contractstate, activeDogC.orgcustomer, ");
		sqlb.append("activeDogC.orgexecutor, activeDogC.custname, activeDogC.execname, ");
		sqlb.append("activeDogC.startdate, activeDogC.enddate, "); //activeDogC.doctext,
		//sqlb.append("activeDogC.docfilename, activeDogC.doccomment, activeDogC.docsubject, ");
		sqlb.append("'' docfilename, '' doccomment, '' docsubject, ");
		sqlb.append("activeDogC.extendtype, activeDogC.extendperiod, activeDogC.reportperiod, ");
		sqlb.append("activeDogC.economist, activeDogC.currency1, activeDogC.currency2, ");
		sqlb.append("activeDogC.summ1, activeDogC.summ2, activeDogC.ratecalcrule, ");
		sqlb.append("activeDogC.ratecalcruleday, activeDogC.ratedelta, activeDogC.manager, ");
		sqlb.append("activeDogC.dateclose, activeDogA.mainleasedocument, activeDogA.isactive, ");
		sqlb.append("activeDogA.numberofphones, activeDogA.calcelectrotype, activeDogA.isdogelectro, activeDogA.officialdoc, activeDogA.needofficialdoc, ");
		sqlb.append("activeDogA.dogelectonum, activeDogA.dogelectrodate, activeDogA.numberofphonestemp, activeDogA.mainposition, ");
		sqlb.append("baseDogD.docnumber mainDocumentNumber, baseDogD.docdate maindocdate, baseDogC.contractstate maincontractstate, ");
		sqlb.append("baseDogC.startdate mainstartdate, baseDogC.economist mainEconomist, baseDogC.manager mainManager, baseDogC.dateclose maindateclose, ");
		sqlb.append("getNamePosition(activeDogA.mainposition) mainposition, ");
		sqlb.append("getListPosContract(activeDogD.leasedocument, 2) allposition, ");
		sqlb.append("getListResContract(baseDogD.leasedocument) resource, ");
		sqlb.append("getNameOrg(baseDogC.orgExecutor) orgExecutorName, ");
		sqlb.append("getNameOrg(baseDogC.orgCustomer) orgCustomerName, ");
		sqlb.append("getInnOrg(baseDogC.orgCustomer) orgCustomerInn, ");
		sqlb.append("getNameCurrency(activeDogC.currency1,0,0) curr1Name, ");
		sqlb.append("getNameCurrency(activeDogC.currency1,0,0) curr2Name, ");
		sqlb.append("getSumTrafContract(activeDogA.leasedocument, activeDogC.currency1) trafic1, ");
		sqlb.append("getSumTrafContract(activeDogA.leasedocument, activeDogC.currency2) trafic2, ");
		sqlb.append("getSumAcceptContr(activeDogA.leasedocument, activeDogC.currency1) accept1, ");
		sqlb.append("getSumAcceptContr(activeDogA.leasedocument, activeDogC.currency2) accept2, ");
		sqlb.append("getNameWorker(baseDogC.economist) mainEconomistName, ");
		sqlb.append("getNameWorker(baseDogC.manager) mainManagerName, ");
		sqlb.append("recalcSumOtherCur(activeDogC.currency1, activeDogC.summ1,  today, 840) sum1OtherCur, ");
		sqlb.append(
			"recalcSumOtherCur(activeDogC.currency1, getSumTrafContract(activeDogA.leasedocument, activeDogC.currency1),  today, 840) trafic1OtherCur, getCountProblemOnContract(baseDogA.leasedocument) countProblemOnContract ");
		sqlb.append("FROM leasearendaagrmnts baseDogA, leasecontracts baseDogC, leasedocuments baseDogD, ");
		sqlb.append("leasearendaagrmnts activeDogA, leasecontracts activeDogC, leasedocuments activeDogD ");
		//calculate where clause// getInnOrg(T2.orgCustomer) orgCustomerInn,
		StringBuffer whereClause = new StringBuffer("WHERE ");
		whereClause.append("baseDogA.mainleasedocument is null ");
		whereClause.append("AND baseDogC.leasedocument = baseDogA.leasedocument ");
		whereClause.append("AND baseDogD.leasedocument = baseDogA.leasedocument ");
		//whereClause.append("AND activeDogA.leasedocument = getActiveContract(baseDogA.leasedocument) ");
		/**whereClause.append("AND activeDogA.leasedocument = baseDogA.ActiveContract ");*/
		whereClause.append("AND activeDogA.leasedocument = nvl(baseDogA.ActiveContract,baseDogA.leasedocument) ");
		//whereClause.append("AND (activeDogA.mainleasedocument is null or activeDogA.mainleasedocument = baseDogA.leasedocument) ");
		whereClause.append("AND activeDogC.leasedocument = activeDogA.leasedocument ");
		whereClause.append("AND activeDogD.leasedocument = activeDogA.leasedocument ");
		//calculate filter clause
		StringBuffer filter = new StringBuffer();
		/**
		if (isPosition != null && isPosition.booleanValue()) {
			filter.append("AND exists (select l.* from leaseonpositions l where l.leasedocument=baseDogC.leasedocument AND l.storageplace = ?) ");
			params.add(position);
		}
		*/
		if (isPosition != null && isPosition.booleanValue()) {
			//filter.append("AND exists (select l.* from leaseonpositions l where l.leasedocument=activeDogC.leasedocument AND l.storageplace = ?) ");
			filter.append("AND baseDogA.leasedocument IN( SELECT nvl(la1.mainleasedocument, la1.leasedocument) FROM leaseonpositions lp, leasearendaagrmnts la1 WHERE la1.leasedocument = lp.leasedocument AND lp.storageplace = ? ) ");
			params.add(position);
		}		
		if (isState.booleanValue()) {
			filter.append("AND baseDogC.contractstate in ( " + stateList + " )");
		}
		if (isRegionID.booleanValue()) {
			filter.append("AND baseDogD.regionid = ? ");
			params.add(regionID);
		}
		whereClause.append(filter);
		sqlb.append(whereClause);
		//sqlb.append("ORDER BY baseDogD.docnumber");

		res.executeQuery(sqlb.toString(), params.toArray());
		//res.executeQuery(sqlb.toString(), null);
		System.out.println("sqlb.toString()=" + sqlb.toString()); //temp

		return res;
	}
	/**
	 * Возвращает список доп. соглашений/договоров аренды для заданной позиции
	 */
	public CDBCResultSet findArendaAgreementsByPosition(Integer argPosition) {

		// Get USD code
		int usdCode = AppUtils.getNamedValueInt(AppUtils.USD_CODE);

		CDBCResultSet res = new CDBCResultSet();
		String s =
			"SELECT lscd.leasedocument, lscb.leasedocument basedocument, "
				+ "ldb.docnumber, ldb.docdate, lscb.startdate, lscd.enddate, "
				+ "lscd.summ1,  lscd.summ2, "
				+ "cr1.shortname curname1, cr2.shortname curname2, "
				+ "lscb.orgexecutor, lscb.orgcustomer, "
				+ "getNameOrg(lscb.orgexecutor) orgename, getNameOrg(lscb.orgcustomer) orgcname, "
				+ "calcAvgSumCOP(lscb.leasedocument, lscd.leasedocument, "
				+ usdCode
				+ ") summusd "
				+ "FROM leasecontracts lscd, leasearendaagrmnts lagd, "
				+ "leasecontracts lscb, leasedocuments ldb, "
				+ "currencies cr1, outer currencies cr2 "
				+ "WHERE lscd.leasedocument = lagd.leasedocument "
				+ "AND cr1.currency = lscd.currency1 AND cr2.currency = lscd.currency2 "
				+ "AND ( (lagd.mainleasedocument = lscb.leasedocument) OR "
				+ "(  (lagd.mainleasedocument IS NULL) AND (lagd.leasedocument = lscb.leasedocument) ) ) "
				+ "AND lagd.isactive = 'Y' "
				+ "AND ldb.leasedocument = lscb.leasedocument "
				+ "AND lscb.leasedocument IN ( "
				+ "  SELECT lc.leasedocument "
				+ "  FROM leasearendaagrmnts la, leasecontracts lc "
				+ "  WHERE la.mainleasedocument IS NULL "
				+ "  AND lc.leasedocument = la.leasedocument "
				+ "  AND lc.summ1 > 0 "
				+ "  AND lc.leasedocument IN "
				+ "   ( "
				+ "      SELECT leasedocument FROM leaseonpositions "
				+ "          WHERE storageplace = ? "
				+ "   ) "
				+ "  AND lc.contractstate IN ('A', 'B') "
				+ " ) "
				+ "ORDER BY ldb.docdate";
		res.executeQuery(s, new Object[] { argPosition });
		return res;
	}
	/**
	* Возвращает список доп. соглашений/договоров аренды для:
	*/
	public static CDBCResultSet findMainArendaAgreements(
		Boolean isOrgCustomer,
		Integer orgCustomer,
		Boolean isOrgExecutor,
		Integer orgExecutor,
		Boolean isMainEconomist,
		Integer mainEconomist,
		Boolean isPosition,
		Integer position,
		Boolean isDocNumber,
		String docNumber,
		Boolean isState,
		String state,
		Integer order) {

		StringBuffer sqlb = new StringBuffer();
		ArrayList params = new ArrayList();

		CDBCResultSet res = new CDBCResultSet();
		sqlb.append("SELECT leasedocuments.leasedocument, ");
		sqlb.append("leasedocuments.docdate, ");
		sqlb.append("leasedocuments.docnumber, ");
		sqlb.append("leasedocuments.doctype, ");
		sqlb.append("leasedocuments.operator, ");
		sqlb.append("leasecontracts.contracttype, ");
		sqlb.append("leasecontracts.contractstate, ");
		sqlb.append("leasecontracts.orgcustomer, ");
		sqlb.append("leasecontracts.orgexecutor, ");
		sqlb.append("leasecontracts.custname, ");
		sqlb.append("leasecontracts.execname, ");
		sqlb.append("leasecontracts.startdate, ");
		sqlb.append("leasecontracts.enddate, ");
		//sqlb.append("leasecontracts.doctext, ");
		sqlb.append("leasecontracts.docfilename, ");
		//sqlb.append("leasecontracts.doccomment, ");
		sqlb.append("leasecontracts.docsubject, ");
		sqlb.append("leasecontracts.extendtype, ");
		sqlb.append("leasecontracts.extendperiod, ");
		sqlb.append("leasecontracts.reportperiod, ");
		sqlb.append("leasecontracts.economist, ");
		sqlb.append("leasecontracts.currency1, ");
		sqlb.append("leasecontracts.currency2, ");
		sqlb.append("leasecontracts.summ1, ");
		sqlb.append("leasecontracts.summ2, ");
		sqlb.append("leasecontracts.ratecalcrule, ");
		sqlb.append("leasecontracts.ratecalcruleday, ");
		sqlb.append("leasecontracts.ratedelta, ");
		sqlb.append("leasecontracts.manager, ");
		sqlb.append("leasecontracts.dateclose, ");
		sqlb.append("leasearendaagrmnts.mainleasedocument, ");
		sqlb.append("leasearendaagrmnts.isactive, ");
		sqlb.append("leasearendaagrmnts.numberofphones, ");
		sqlb.append("leasearendaagrmnts.calcelectrotype, ");
		sqlb.append("leasearendaagrmnts.isdogelectro, ");
		sqlb.append("leasearendaagrmnts.dogelectonum, ");
		sqlb.append("leasearendaagrmnts.dogelectrodate, ");
		sqlb.append("leasearendaagrmnts.numberofphonestemp, ");
		sqlb.append("leasearendaagrmnts.mainposition ");
		sqlb.append("FROM leasearendaagrmnts, leasecontracts, leasedocuments ");
		sqlb.append("WHERE ( leasecontracts.leasedocument = leasearendaagrmnts.leasedocument ");
		sqlb.append("AND leasedocuments.leasedocument = leasecontracts.leasedocument ) ");

		if (isOrgCustomer != null && isOrgCustomer.booleanValue()) {
			sqlb.append("AND leasecontracts.orgcustomer = ? ");
			params.add(orgCustomer);
		}
		if (isOrgExecutor != null && isOrgExecutor.booleanValue()) {
			sqlb.append("AND  leasecontracts.orgexecutor = ? ");
			params.add(orgExecutor);
		}
		if (isMainEconomist != null && isMainEconomist.booleanValue()) {
			sqlb.append("AND  leasecontracts.economist = ? ");
			params.add(mainEconomist);
		}
		if (isPosition != null && isPosition.booleanValue()) {
			sqlb.append("AND exists (select l.* from leaseonpositions l where l.leasedocument=leasecontracts.leasedocument and l.storageplace = ?) ");
			params.add(position);
		}
		if (isDocNumber != null && isDocNumber.booleanValue()) {
			sqlb.append("AND upper(leasedocuments.docnumber) matches upper('" + docNumber + "') ");
			//sqlb.append("AND leasedocuments.docnumber = ? ");
			//params.add(docNumber);
		}
		sqlb.append("AND  leasearendaagrmnts.mainleasedocument is null ");
		sqlb.append("ORDER BY leasedocuments.docnumber");

		//System.out.println(sqlb.toString()); //temp
		//System.out.println("params.size(): " + params.size()); //temp
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает список позиций по базовому договору аренды
	 */
	public CDBCResultSet findPositionsByArendaAgreement(Integer argBaseDoc) {

		CDBCResultSet res = new CDBCResultSet();
		String s = "SELECT s.storageplace, s.name " + "FROM storageplaces s, leaseonpositions lp  " + "WHERE s.storageplace = lp.storageplace " + "AND lp.leasedocument = ? " + "ORDER BY s.name";
		res.executeQuery(s, new Object[] { argBaseDoc });
		return res;
	}
	/**
	 * Для поиска "Позиций".
	 * Creation date: (27.12.2004 14:55:59)
	 * @return com.hps.july.cdbc.lib.CDBCResultSet
	 * @param argPosition java.lang.Integer
	 */
	public final static CDBCResultSet findPositionsDopInfo(boolean isPositionID, int positionID, boolean isGsmId, Integer gsmID, boolean isDampsid, Integer dampsID) {
		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		StringBuffer sqlb = new StringBuffer(POSITION_DOP_INFO_SQL);
		if (isPositionID)
			sqlb.append(" AND p.storagePlace = " + positionID);
		if (isGsmId) {
			if (gsmID != null) {
				//sqlb.append(" AND p.gsmid= " + gsmID);
				sqlb.append("AND ( ");
				//sqlb.append("  (p.gsmid = ?) ");
				//sqlb.append(" OR ");
				sqlb.append("  (p.storagePlace in "); 
				sqlb.append("     (select e.position from basestations b, equipment e ");
				sqlb.append("       where e.equipment = b.equipment ");
				sqlb.append("       and b.number = ? ");
				sqlb.append("       and b.type in ('S', 'C', 'G'))) ");
				sqlb.append(" OR  ");
				sqlb.append("  (p.storagePlace in "); 
				sqlb.append("     (select e.position from repiters r, equipment e ");
				sqlb.append("       where e.equipment = r.equipment ");
				sqlb.append("       and r.number = ?)) ");
				sqlb.append(" ) "); 
				//params.add(gsmID);
				params.add(gsmID);
				params.add(gsmID);				
			} else {
				sqlb.append(" AND p.gsmid = -1 ");
			}
		}
		if (isDampsid) {
			if (dampsID != null) {
				//sqlb.append(" AND p.dampsid = " + dampsID);
				sqlb.append("AND ( ");
				//sqlb.append("  (p.dampsid = ?) ");
				//sqlb.append(" OR ");
				sqlb.append("  (p.storagePlace in "); 
				sqlb.append("     (select e.position from basestations b, equipment e ");
				sqlb.append("       where e.equipment = b.equipment ");
				sqlb.append("       and b.number = ? ");
				sqlb.append("       and b.type in ('D'))) ");
				sqlb.append(" ) ");
				//params.add(dampsID);
				params.add(dampsID);				
			} else {
				sqlb.append(" AND p.dampsid = -1 ");
			}
		}
		res.executeQuery(sqlb.toString(), params.toArray());
		System.out.println("from CDBCArendaAgreementObject.findPositionDopInfo sql="+ sqlb.toString());//temp
		return res;
	}
	/**
	 * Проверяет есть ли заключенные договора на указанную позицию
	 */
	public boolean haveArendaAgreements(Integer argPosition) {
		boolean result = false;
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(
			"SELECT count(*) cnt "
				+ "FROM leasearendaagrmnts la, leasecontracts lc "
				+ "WHERE la.mainleasedocument IS NULL "
				+ "AND lc.leasedocument = la.leasedocument "
				+ "AND lc.summ1 > 0 "
				+ "AND lc.leasedocument IN "
				+ " ( "
				+ "    SELECT leasedocument FROM leaseonpositions "
				+ "        WHERE storageplace = ? "
				+ " ) "
				+ "AND lc.contractstate IN ('A', 'B') ",
			new Object[] { argPosition });
		java.util.ListIterator it = res.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) it.next();
			Object cnt = ro.getColumn("cnt").asObject();
			if ((cnt != null) && (cnt instanceof java.math.BigDecimal) && (((java.math.BigDecimal) cnt).intValue() > 0))
				result = true;
		}
		return result;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.03.2004 16:03:42)
	 * @param args java.lang.String[]
	 */
	public static void main(String[] args) {
		/**	
			CDBCArendaAgreementObject o = new CDBCArendaAgreementObject();
		
			System.out.println("start have agreements = " + o.haveArendaAgreements(new Integer(524)));
		
			CDBCResultSet rs = o.findPositionsByArendaAgreement(new Integer(4227));
			java.util.ListIterator it = rs.listIterator();
			System.out.println("start");
			while (it.hasNext()) {
				CDBCRowObject ro = (CDBCRowObject) it.next();
				CDBCColumnObject co1 = (CDBCColumnObject) ro.getColumn("storageplace");
				CDBCColumnObject co2 = (CDBCColumnObject) ro.getColumn("name");
				System.out.println("" + co1.asObject() + "  '" + co2.asString() + "'");
			}
			////////////////////////////////////////////////////////////////////////////
			long start = System.currentTimeMillis();
			System.out.println("start findMainArendaAgreements: " + start); //temp
		
			Boolean isOrgCustomer = Boolean.TRUE;
			Integer orgCustomer = new Integer("445");
			Boolean isOrgExecutor = Boolean.TRUE;
			Integer orgExecutor = new Integer("1");
			Boolean isMainEconomist = Boolean.TRUE;
			Integer mainEconomist = new Integer("2");
			Boolean isPosition = Boolean.TRUE;
			Integer position = new Integer("524");
			Boolean isDocNumber = Boolean.TRUE;
			String docNumber = "test*";
			Boolean isState = Boolean.TRUE;
			String state = "1";
			Integer order = new Integer("1");
		
			o = new CDBCArendaAgreementObject();
		
			rs = o.findArendaAgreements(
				//o.findActiveArendaAgreements(
				//o.findMainArendaAgreements(
			isOrgCustomer,
				orgCustomer,
				isOrgExecutor,
				orgExecutor,
				isMainEconomist,
				mainEconomist,
				isPosition,
				position,
				isDocNumber,
				docNumber,
				isState,
				state,
				order);
			//o.findMainArendaAgreements(
			it = rs.listIterator();
			System.out.println("start result: time=" + (System.currentTimeMillis() - start)); //temp
			int count = 0;
			while (it.hasNext()) {
				CDBCRowObject ro = (CDBCRowObject) it.next();
				CDBCColumnObject co = (CDBCColumnObject) ro.getColumn("orgcustomername");
				System.out.println("orgCustomerName=" + co.asString()); //out
				CDBCColumnObject co1 = (CDBCColumnObject) ro.getColumn("allposition");
				System.out.println("allposition=" + co1.asString()); //out
				CDBCColumnObject co2 = (CDBCColumnObject) ro.getColumn("resource");
				System.out.println("resource=" + co2.asString()); //out
				CDBCColumnObject co3 = (CDBCColumnObject) ro.getColumn("mainposition");
				System.out.println("mainposition=" + co3.asString()); //out
				CDBCColumnObject co4 = (CDBCColumnObject) ro.getColumn("orgexecutorname");
				System.out.println("orgExecutorName=" + co4.asString()); //out
				CDBCColumnObject co5 = (CDBCColumnObject) ro.getColumn("curr1name");
				System.out.println("curr1Name=" + co5.asString()); //out
				CDBCColumnObject co6 = (CDBCColumnObject) ro.getColumn("curr2name");
				System.out.println("curr2Name=" + co6.asString()); //out
				CDBCColumnObject co7 = (CDBCColumnObject) ro.getColumn("maindocumentnumber");
				System.out.println("mainDocumentNumber=" + co7.asString()); //out
				System.out.println("orgcustomer=" +(Integer) ro.getColumn("orgcustomer").asObject());
				System.out.println("trafic1=" +(java.math.BigDecimal) ro.getColumn("trafic1").asObject());
				System.out.println("trafic2=" +(java.math.BigDecimal) ro.getColumn("trafic2").asObject());
				count++;
				com.hps.july.arenda.valueobject.LeaseDocumentVO vo = new com.hps.july.arenda.valueobject.LeaseArendaAgrmntVO(ro);
				System.out.println(
					"vo= " + vo + " Docdate: " + vo.getDocdate() + " Doctype: " + vo.getDoctype() + " operator: " + vo.getOperator());
			}
			System.out.println("COUNT ROW=" + count);
			System.out.println("end findMainArendaAgreements: time=" + (System.currentTimeMillis() - start)); //temp
		*/
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2004 14:31:05)
	 */
	public static String getListPosContract(int baseLeasedocument) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String allPosition = ""; //признак выполнения без ошибок!!!
		try {
			String sql = "execute procedure getListPosContract(?)";
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			cs.setInt(1, baseLeasedocument); //код главного дока

			rs = cs.executeQuery();
			if (rs.next()) {
				allPosition = rs.getString(1); //integer, -- Признак ошибки (0 без ошибок)
			} else {
				allPosition = "no DATA: execute procedure 'getListPosContract'";
			}

		} catch (Exception ex) {
			catchMetod(ex);
			ex.printStackTrace();
		} finally {
			finallyMetod(con, cs, rs);
		}
		return allPosition;
	}
	/**
	 * 
	 * @param con
	 * @param cs
	 * @param rs
	 */
	private static final void finallyMetod(Connection con, Statement cs, ResultSet rs) {
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
	/**
	 * 
	 * @param e
	 */
	private final static void catchMetod(Exception e) {
		if (e instanceof SQLException) {
			SQLException sqlExec = (SQLException) e;
			while (sqlExec != null) {
				System.out.println("Error code=" + sqlExec.getErrorCode());
				sqlExec = sqlExec.getNextException();
			}
		}
		e.printStackTrace(System.out);
	}
	
	/**
	 * Возвращает список доп.позиций по базовому договору аренды
	 */
	public final static List findByQBE2(
		java.lang.Integer mainLeaseDocument,
		java.lang.Boolean isIsActive,
		java.lang.Boolean isActive,
		java.lang.Boolean isContractState,
		String contractState,
		java.lang.Integer order) {

		CDBCResultSet res = new CDBCResultSet();
		ArrayList params = new ArrayList();
		List ret = new ArrayList();
		//calculate where clause:
		StringBuffer sb = new StringBuffer(findSqlString + "AND (T1.mainleasedocument = ? OR T3.leasedocument = ?) " );
		params.add(mainLeaseDocument);
		params.add(mainLeaseDocument);
		if( isIsActive.booleanValue() ){
			sb.append( "AND T1.isActive = ? " );
			params.add(isActive);
		}
		if( isContractState.booleanValue() ){
			sb.append( "AND T2.contractState = ? " );
			params.add(contractState);	
		}
		//append order by clause:
		String orderBy = null;
		switch( order.intValue() ) {
			case 1:
				orderBy = "T2.STARTDATE asc";
				break;
			case 2:
				orderBy = "T2.STARTDATE desc";
				break;
		}
		sb.append( " order by "+orderBy );		
		res.executeQuery(sb.toString(), params.toArray());
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			LeaseArendaAgrmntVO vo = new LeaseArendaAgrmntVO(ro);
			vo.setDateclose((java.sql.Date)ro.getColumn("dateclose").asObject());
			vo.setNeedofficialdoc(ro.getColumn("needofficialdoc").asString());
			vo.setMainPosition(ro.getColumn("mainPosition").asString());
			LeaseArendaAgreementNewVO to = new LeaseArendaAgreementNewVO(vo);
			to.setAllPositions(ro.getColumn("allPositions").asString());
			to.setMainPosition(ro.getColumn("mainpositionName").asString());
			to.setNumRegistryDoc(ro.getColumn("numRegistryDoc").asString());
			ret.add(to);
		}
		return ret;
	}
	
	/**
	 * Insert the method's description here.
	 * Creation date: (21.05.2004 13:04:20)
	 */
	public final static String deleteCascade(int contractCode) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String errorTxt = "";
		try {
			String sql = "execute procedure delDopContract(?)";
			System.out.println(sql + " contractCode=" + contractCode);
			con = new JdbcConnection().getConnection();
			cs = con.prepareCall(sql);

			cs.setInt(1, contractCode); //код базового договора

			rs = cs.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				if (result == 0) {
					System.out.println("Процедура 'delDopContract' ok"); //temp
				} else {
					errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
					System.out.println("Процедура 'delDopContract' errorTxt: " + errorTxt); //temp
				}
			} else {
				System.out.println("no DATA: execute procedure 'delDopContract'"); //temp
			}

		} catch (Exception ex) {
			catchMetod(ex);
		} finally {
			finallyMetod(con, cs, rs);
		}
		return errorTxt;
	}	
}
