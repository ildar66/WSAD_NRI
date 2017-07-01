package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import com.hps.july.util.*;
import java.util.*;
/**
* Объект для работы с абонентскими договорами аренды.
* Creation date: (27.05.2004 12:15:02)
* @author: Shafigullin Ildar
*/
public class CDBCAbonentBAN_Object {
	private static final String findLeaseAbonentBAN_byPosition_SQL =
		"SELECT T3.docdate, T3.leasedocument, T3.docnumber, T3.operator, T3.doctype, T3.regionid, "
			+ "T2.docfilename, T2.contractstate, T2.contracttype, T2.execname, T2.startdate, T2.ratecalcrule, T2.enddate, T2.CustName, T2.ratecalcruleday, T2.ratedelta, T2.extendperiod, T2.extendtype, T2.summ2, T2.reportperiod, T2.summ1, T2.dateclose, T2.currency2, T2.currency1, T2.economist, T2.orgexecutor, T2.orgcustomer, T2.manager, getNameWorker(T2.manager) managerName, getNameWorker(T2.economist) economistName, getCntPhoneAbContr(T3.leasedocument) cntPhoneAbContr, getAbonentBalanceNri(T1.leasedocument) balansnri, "
			+ "T1.bil_contrstname, T1.useallben, T1.bil_accounttype, T1.bil_acctypename, T1.flagworkpie, T1.bil_inn, T1.bil_startservdate, T1.bil_suspdate, T1.bil_contrstdate, T1.bil_name, T1.ban, T1.bil_contrstatus, T1.bil_billaddress, T1.balans, T1.proctype, T1.useinacts, T1.techcontract , T1.mainposition, getNameOrg(T2.orgCustomer) orgCustomerName, getInnOrg(T2.orgCustomer) orgCustomerInn, getNamePosition(T1.mainposition) mainpositionName, '' orgexecutorname, '' doccomment, '' docsubject, '' curr1name "
			+ "FROM leasecontracts  T2, leaseabonentban  T1, leasedocuments  T3 "
			+ "WHERE T3.doctype = \'B\' AND T1.techContract = \'N\' AND T3.leasedocument = T2.leasedocument AND T2.leasedocument = T1.leasedocument ";
	private static final String findLeaseAbonentBAN_SQL =
		"SELECT first 1000 T3.docdate, T3.leasedocument, T3.docnumber, T3.operator, T3.doctype, T3.regionid, "
			+ "T2.docfilename, T2.contractstate, T2.contracttype, T2.execname, T2.startdate, T2.ratecalcrule, T2.enddate, T2.CustName, T2.ratecalcruleday, T2.ratedelta, T2.extendperiod, T2.extendtype, T2.summ2, T2.reportperiod, T2.summ1, T2.dateclose, T2.currency2, T2.currency1, T2.economist, T2.orgexecutor, T2.orgcustomer, T2.manager, getNameWorker(T2.manager) managerName, getNameWorker(T2.economist) economistName, getAbonentBalanceNri(T1.leasedocument) balansnri, "
			+ "T1.bil_contrstname, T1.useallben, T1.bil_accounttype, T1.bil_acctypename, T1.flagworkpie, T1.bil_inn, T1.bil_startservdate, T1.bil_suspdate, T1.bil_contrstdate, T1.bil_name, T1.ban, T1.bil_contrstatus, T1.bil_billaddress, T1.balans, T1.proctype, T1.useinacts, T1.techcontract , T1.mainposition, getNameOrg(T2.orgCustomer) orgCustomerName, getInnOrg(T2.orgCustomer) orgCustomerInn, getNamePosition(T1.mainposition) mainpositionName, '' orgexecutorname, '' doccomment, '' docsubject, '' curr1name "
			+ "FROM leasecontracts  T2, leaseabonentban  T1, leasedocuments  T3 "
			+ "WHERE T3.doctype = \'B\' AND T1.techContract = \'N\' AND T3.leasedocument = T2.leasedocument AND T2.leasedocument = T1.leasedocument ";
	private static final String findList_SQL =
		"SELECT first 1000 T3.docdate, T3.leasedocument, T3.docnumber, T3.operator, T3.doctype, T3.regionid, "
			+ "T2.docfilename, T2.contractstate, T2.contracttype, T2.execname, T2.startdate, T2.ratecalcrule, T2.enddate, T2.CustName, T2.ratecalcruleday, T2.ratedelta, T2.extendperiod, T2.extendtype, T2.summ2, T2.reportperiod, T2.summ1, T2.dateclose, T2.currency2, T2.currency1, T2.economist, T2.orgexecutor, T2.orgcustomer, T2.manager, getNameWorker(T2.manager) managerName, getNameWorker(T2.economist) economistName, getAbonentBalanceNri(T1.leasedocument) balansnri, "
			+ "T1.bil_contrstname, T1.useallben, T1.bil_accounttype, T1.bil_acctypename, T1.flagworkpie, T1.bil_inn, T1.bil_startservdate, T1.bil_suspdate, T1.bil_contrstdate, T1.bil_name, T1.ban, T1.bil_contrstatus, T1.bil_billaddress, T1.balans, T1.proctype, T1.useinacts, T1.techcontract , T1.mainposition, getNameOrg(T2.orgCustomer) orgCustomerName, getInnOrg(T2.orgCustomer) orgCustomerInn, getNamePosition(T1.mainposition) mainpositionName, '' orgexecutorname, '' doccomment, '' docsubject, getNameCurrency(T2.currency1,0,0) curr1name "
			+ "FROM leasecontracts  T2, leaseabonentban  T1, leasedocuments  T3, vendorsites vs  "
			+ "WHERE T3.doctype = \'B\' AND T1.techContract = \'N\' AND T3.leasedocument = T2.leasedocument AND T2.leasedocument = T1.leasedocument AND T2.orgCustomer = vs.idVendorSite ";
/**
 * CDBCAbonentBAN_Object constructor comment.
 */
public CDBCAbonentBAN_Object() {
	super();
}
/**
 * Возвращает список абонентских договоров аренды.
 * Creation date: (27.05.2004 12:17:32)
 */
public CDBCResultSet findLeaseAbonentBAN(
    Boolean isCustomerName, String customerName,
    Boolean isCustomerInn, String customerInn,
    Boolean isBan, String ban,
    Boolean isPhoneNumber, String phoneNumber,
    Boolean isBilName, String bilName,
    Boolean isBilInn, String bilInn,
    Boolean isBillnumber, String billnumber,
    Boolean isGsmId, String gsmId,
    Boolean isDampsId, String dampsId,
    Boolean isNamePosition, String namePosition,
    Boolean isEconomist, String economist,
    Boolean isManager, String manager,     
    Boolean isNotStation,   
    Boolean isNumberMemo, String numberMemo,          
    Boolean isContractState, String contractState,
	Boolean isRegionID, Integer regionID,  
    String aSortBy){
	    
   	StringBuffer sqlb = new StringBuffer();
	//ArrayList params = new ArrayList();

	CDBCResultSet res = new CDBCResultSet();
    //add generic query string: 
	sqlb.append(findLeaseAbonentBAN_SQL);
    //aliases:
    String alias1 = "T3";//leasedocuments
    String alias2 = "T2";//leasecontracts
    String alias3 = "T1";//leaseabonentban

    //calculate filter clause
    StringBuffer filter = new StringBuffer();
    if (isCustomerName.booleanValue())
        filter.append("and " + alias2 + ".orgcustomer IN (SELECT organization FROM organizations o1 WHERE upper(o1.name) matches upper('"+customerName+"') ) ");
    if (isCustomerInn.booleanValue())
        filter.append("and " + alias2 + ".orgcustomer IN (SELECT organization FROM organizations o2 WHERE upper(o2.inn) matches upper('"+customerInn+"') ) ");
    if (isBan.booleanValue())
        filter.append("and upper(" + alias1 + ".docnumber) matches upper('"+ban+"') ");
    if (isContractState.booleanValue())
    	filter.append("AND " + alias2 + ".contractstate = '"+contractState+"'");
    if (isPhoneNumber.booleanValue())
        filter.append("and " + alias3 + ".leasedocument IN (SELECT leasedocument FROM leaseabonentphones WHERE phonenumber matches '"+phoneNumber+"') ");
    if (isBilName.booleanValue())
        filter.append("and upper(" + alias3 + ".bil_name) matches upper('"+bilName+"') "); 
    if (isBilInn.booleanValue())
        filter.append("and upper(" + alias3 + ".bil_inn) matches upper('"+bilInn+"') ");
    if (isBillnumber.booleanValue())
        filter.append("and " + alias3 + ".leasedocument IN (SELECT leasedocument FROM abonentbills WHERE billnumber matches '"+billnumber+"') ");
    if (isGsmId.booleanValue())
        filter.append("and " + alias3 + ".mainposition IN (SELECT s.storageplace FROM positions p, storageplaces s WHERE s.storageplace = p.storageplace and p.gsmId ="+gsmId+") ");
    if (isDampsId.booleanValue())
        filter.append("and " + alias3 + ".mainposition IN (SELECT s.storageplace FROM positions p, storageplaces s WHERE s.storageplace = p.storageplace and p.dampsId ="+dampsId+") ");
    if (isNamePosition.booleanValue())
        filter.append("and " + alias3 + ".mainposition IN (SELECT s.storageplace FROM positions p, storageplaces s WHERE s.storageplace = p.storageplace and upper(s.name) matches upper('"+namePosition+"') ) ");
    if (isEconomist.booleanValue())
        filter.append("and " + alias2 + ".economist IN (SELECT w.worker FROM people p, workers w WHERE  w.man = p.man and upper(p.lastname) matches upper('"+economist+"') ) ");
    if (isManager.booleanValue())
        filter.append("and " + alias2 + ".manager IN (SELECT w.worker FROM people p, workers w WHERE  w.man = p.man and upper(p.lastname) matches upper('"+manager+"') ) ");
    if (isNotStation.booleanValue())
        filter.append("and " + alias3 + ".mainposition is null ");
    if (isNumberMemo.booleanValue())
       filter.append("and " + alias3 + ".leasedocument IN (SELECT abonentContract FROM OfficeMemoHeaders WHERE  upper(number) matches upper('"+numberMemo+"') ) ");       
    if (isRegionID.booleanValue())
    	filter.append("AND " + alias1 + ".regionid = "+regionID+" ");
    	
    //append order by clause:
    filter.append(" order by " + aSortBy);
    
    sqlb.append(filter);
    //executeQuery:
	//res.executeQuery(sqlb.toString(), params.toArray());
	res.executeQuery(sqlb.toString(), null);
	
	return res;
}
/**
 * Возвращает список абонентских договоров аренды.
 * Creation date: (27.05.2004 12:17:32)
 */
public CDBCResultSet findList(
	Integer searchFilter,	String searchString,
	Boolean isOrgCustomer, Integer orgCustomer,	Integer orgCustomer_VendorSiteID,	
    Boolean isContractState, String contractState,
	Boolean isRegionID, Integer regionID,  
    String aSortBy){
	    
   	StringBuffer sqlb = new StringBuffer();
	ArrayList params = new ArrayList();

	CDBCResultSet res = new CDBCResultSet();
    //add generic query string: 
	sqlb.append(findList_SQL);
    //aliases:
    String alias1 = "T3";//leasedocuments
    String alias2 = "T2";//leasecontracts
    String alias3 = "T1";//leaseabonentban

    //calculate filter 1 clause
    StringBuffer filter = new StringBuffer();
    if (searchFilter.intValue() == 1){
        filter.append("and upper(" + alias1 + ".docnumber) matches upper(?) ");//ban
		params.add(searchString);
    }
    else if (searchFilter.intValue() == 2){
        filter.append("and " + alias3 + ".leasedocument IN (SELECT leasedocument FROM leaseabonentphones WHERE phonenumber matches ?) ");//phoneNumber
		params.add(searchString);
    }
	else if (searchFilter.intValue() == 3){
		filter.append("and upper(" + alias3 + ".bil_name) matches upper(?) ");//bilName
		params.add(searchString);
    }
	else if (searchFilter.intValue() == 4 ){
		filter.append("and upper(" + alias3 + ".bil_inn) matches upper(?) ");//bilInn
		params.add(searchString);
    }
	else if (searchFilter.intValue() == 5){
		filter.append("and " + alias3 + ".leasedocument IN (SELECT leasedocument FROM abonentbills WHERE billnumber matches ?) ");//billnumber
		params.add(searchString);
    }
	else if (searchFilter.intValue() == 6){
		filter.append("and " + alias3 + ".mainposition IN (SELECT s.storageplace FROM positions p, storageplaces s WHERE s.storageplace = p.storageplace and p.gsmId =?) ");//gsmId
		params.add(searchString);
    }
	else if (searchFilter.intValue() == 7){
		filter.append("and " + alias3 + ".mainposition IN (SELECT s.storageplace FROM positions p, storageplaces s WHERE s.storageplace = p.storageplace and p.dampsId =?) ");//dampsId
		params.add(searchString);
    }
	else if (searchFilter.intValue() == 8){
		filter.append("and " + alias3 + ".mainposition IN (SELECT s.storageplace FROM positions p, storageplaces s WHERE s.storageplace = p.storageplace and upper(s.name) matches upper(?) ) ");//namePosition
		params.add(searchString);
    }
	else if (searchFilter.intValue() == 9 && searchString != null && !searchString.trim().equals("*")){
        //filter.append("and " + alias2 + ".economist IN (SELECT w.worker FROM people p, workers w WHERE  w.man = p.man and upper(p.lastname) matches upper(?) ) ");//economist
		//params.add(searchString);
		addSQLforPeople(alias2 + ".economist", searchString, params, filter); 
    }
	else if (searchFilter.intValue() == 10 && searchString != null && !searchString.trim().equals("*")){
        //filter.append("and " + alias2 + ".manager IN (SELECT w.worker FROM people p, workers w WHERE  w.man = p.man and upper(p.lastname) matches upper(?) ) ");//manager
		//params.add(searchString);
		addSQLforPeople(alias2 + ".manager", searchString, params, filter);
	}
	else if (searchFilter.intValue() == 11){
        filter.append("and " + alias3 + ".mainposition is NULL ");
    }
	else if (searchFilter.intValue() == 12){
       	filter.append("and " + alias3 + ".leasedocument IN (SELECT abonentContract FROM OfficeMemoHeaders WHERE  upper(number) matches upper(?) ) ");//numberMemo
	   	params.add(searchString);
	}
	
	//calculate filter 2 clause
	if (isOrgCustomer != null && isOrgCustomer.booleanValue() && orgCustomer != null && orgCustomer.intValue() != -1 ) {
		if(orgCustomer_VendorSiteID.intValue() == -1){
			//поиск по всем отделениям Ссудополучателя(если это организация):
			filter.append("AND vs.idVendor = ? ");
			params.add(orgCustomer);
		}else{
			filter.append("AND vs.idVendorSite = ? ");
			params.add(orgCustomer_VendorSiteID);
		}
	}	
	//calculate filter 3 clause
	if (isContractState.booleanValue()){
		filter.append("AND " + alias2 + ".contractstate = ? ");
		params.add(contractState);
	}	
    if (isRegionID.booleanValue()){
    	filter.append("AND " + alias1 + ".regionid = ? ");
		params.add(regionID);
	}
    	
    //append order by clause:
    if(aSortBy != null){
		filter.append(" order by " + aSortBy);    	
    }
    
    sqlb.append(filter);
    //executeQuery:
	System.out.println("CDBCAbonentBAN_Object.findList.SQL="+sqlb.toString()+" \n params="+params);//temp    
	res.executeQuery(sqlb.toString(), params.toArray());
	
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
 * Возвращает список абонентских договоров аренды.
 * Creation date: (27.05.2004 12:17:32)
 */
public static CDBCResultSet findLeaseAbonentBANbyPosition(
	Boolean isPosition,	Integer position,
    Boolean isContractState, String contractState,   
	Boolean isRegionID, Integer regionID,       
    String aSortBy){
	    
   	StringBuffer sqlb = new StringBuffer();
	//ArrayList params = new ArrayList();

	CDBCResultSet res = new CDBCResultSet();
    //add generic query string: 
	sqlb.append(findLeaseAbonentBAN_byPosition_SQL);
    //aliases:
    String alias1 = "T3";//leasedocuments
    String alias2 = "T2";//leasecontracts
    String alias3 = "T1";//leaseabonentban

    //calculate filter clause
    StringBuffer filter = new StringBuffer();
    if (isContractState.booleanValue())
    	filter.append("AND " + alias2 + ".contractstate = '"+contractState+"'");
     if (isPosition.booleanValue())
        filter.append("AND " + alias3 + ".mainposition  = "+position);
    if (isRegionID.booleanValue())
    	filter.append("AND " + alias1 + ".regionid = "+regionID+" ");        

    //append order by clause:
    filter.append(" order by " + aSortBy);
    
    sqlb.append(filter);
    //executeQuery:
	res.executeQuery(sqlb.toString(), null);
	
	return res;
}
}
