package com.hps.july.arenda.cdbcobjects;

import com.hps.july.cdbc.lib.*;
import com.hps.july.util.*;
import java.util.*;
import com.hps.july.arenda.valueobject.*;
import java.sql.*;
import com.hps.july.jdbcpersistence.lib.*;
/**
 * Insert the type's description here.
 * Creation date: (12.10.2005 16:41:29)
 * @author: Shafigullin Ildar
 */
public class CDBC_LoanContract_Object {
    private static final String FIND_SQL =
        "SELECT T3.docdate, T3.leasedocument, T3.docnumber, T3.operator, T3.doctype, T3.regionid, "
            + "T2.docfilename, T2.contractstate, T2.contracttype, T2.execname, T2.startdate, T2.ratecalcrule, T2.enddate, T2.CustName, T2.ratecalcruleday, T2.ratedelta, T2.extendperiod, T2.extendtype, T2.summ2, T2.reportperiod, T2.summ1, T2.dateclose, T2.currency2, T2.currency1, T2.economist, T2.orgexecutor, T2.orgcustomer, T2.manager, getNameWorker(T2.manager) managerName, getNameWorker(T2.economist) economistName, "
            + "T1.reason, T1.planSum, T1.mainposition, T1.planCurr, "
            + "getNameOrg(T2.orgCustomer) orgCustomerName, getInnOrg(T2.orgCustomer) orgCustomerInn, getNamePosition(T1.mainposition) mainpositionName, '' orgexecutorname, T2.doccomment, T2.docsubject, getNameCurrency(T1.planCurr,0,0) plancurrname "
            + "FROM loancontracts  T1, leasecontracts  T2, leasedocuments  T3 "
            + "WHERE T3.doctype = \'S\' AND T3.leasedocument = T2.leasedocument AND T2.leasedocument = T1.leasedocument ";
    private final static java.lang.String PROCEDURE_SQL = "execute procedure editLoanContract (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	private static final String FIND_LIST_SQL =
		"SELECT T3.docdate, T3.leasedocument, T3.docnumber, T3.operator, T3.doctype, T3.regionid, "
			+ "T2.docfilename, T2.contractstate, T2.contracttype, T2.execname, T2.startdate, T2.ratecalcrule, T2.enddate, T2.CustName, T2.ratecalcruleday, T2.ratedelta, T2.extendperiod, T2.extendtype, T2.summ2, T2.reportperiod, T2.summ1, T2.dateclose, T2.currency2, T2.currency1, T2.economist, T2.orgexecutor, T2.orgcustomer, T2.manager, getNameWorker(T2.manager) managerName, getNameWorker(T2.economist) economistName, "
			+ "T1.reason, T1.planSum, T1.mainposition, T1.planCurr, "
			+ "getNameOrg(T2.orgCustomer) orgCustomerName, '' orgCustomerInn, getNamePosition(T1.mainposition) mainpositionName, '' orgexecutorname, T2.doccomment, T2.docsubject, getNameCurrency(T1.planCurr,0,0) plancurrname "
			+ "FROM loancontracts  T1, leasecontracts  T2, leasedocuments  T3, vendorsites vs "
			+ "WHERE T3.doctype = \'S\' AND T3.leasedocument = T2.leasedocument AND T2.leasedocument = T1.leasedocument AND T2.orgCustomer = vs.idVendorSite ";
    
/**
 * Insert the method's description here.
 * Creation date: (23.10.2005 15:12:29)
 */
public static String changeStateLoanContract(Integer id, String toActState) {
    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    String errorTxt = null; //признак выполнения без ошибок!!!
    try {
        String sql = "execute procedure changeStateLoanContract(?, ?)";
        con = new JdbcConnection().getConnection();
        cs = con.prepareCall(sql);

        cs.setInt(1, id.intValue()); //код 
        cs.setString(2, toActState); //желаемое состояние 	

        rs = cs.executeQuery();
        if (rs.next()) {
            int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
            if (result == 0) {
                //System.out.println("Процедура 'changeStateLoanContract' ok"); //temp
            } else {
                errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
                System.out.println("Процедура 'changeStateLoanContract' errorTxt: " + errorTxt); //temp
            }
        } else {
            errorTxt = "no DATA: execute procedure 'changeStateLoanContract'";
            System.out.println(errorTxt);
        }

    } catch (Exception ex) {
	    errorTxt = "Error in execute procedure 'changeStateLoanContract'. CDBC_LoanContract_Object.changeStateLoanContract(?, ?)";
        System.out.println(errorTxt);
        if (ex instanceof SQLException) {
	        errorTxt +="Error code=" + ((SQLException) ex).getErrorCode();
            System.out.println(errorTxt);
        }
        ex.printStackTrace();
    } finally {
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
    return errorTxt;

}
/**
 * Insert the method's description here.
 * Creation date: (19.10.2005 20:16:25)
 */
public static LoanContractVO find(int aID) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { new Integer(aID)};
    String sql = FIND_SQL + "AND T3.leasedocument = ? ";
    res.executeQuery(sql, params);
    ListIterator list = res.listIterator();
    CDBCRowObject ro = null;
    LoanContractVO vo = null;
    if (list.hasNext()) {
        ro = (CDBCRowObject) list.next();
        vo = new LoanContractVO(ro);
        vo.setManagerVO(CDBC_Helper.initWorkerVO(ro, "manager", "managername"));
        vo.setEconomistVO(CDBC_Helper.initWorkerVO(ro, "economist", "economistname"));
        vo.setMainpositionVO(CDBC_Helper.initStoragePlaceVO(ro, "mainposition", "mainpositionname"));
     }
    return vo;
}
/**
 * Возвращает список ссудных договоров аренды.
 */
public static CDBCResultSet findLoanContractList(
    Boolean isCustomerName, String customerName,
    Boolean isCustomerInn, String customerInn,
    Boolean isGsmId, String gsmId,
    Boolean isDampsId, String dampsId,
    Boolean isNamePosition, String namePosition,
    Boolean isEconomist, String economist,
    Boolean isManager, String manager,     
    Boolean isNotStation,  
   	Boolean isNumberDoc, String numberDoc,
    Boolean isNumberMemo, String numberMemo,     
    Boolean isContractState, String contractState,
    Boolean isRegionID, Integer regionID, 
    String aSortBy){
	    
   	StringBuffer sqlb = new StringBuffer();
	//ArrayList params = new ArrayList();

	CDBCResultSet res = new CDBCResultSet();
    //add generic query string: 
	sqlb.append(FIND_SQL);
    //aliases:
    String alias1 = "T3";//leasedocuments
    String alias2 = "T2";//leasecontracts
    String alias3 = "T1";//loancontracts

    //calculate filter clause
    StringBuffer filter = new StringBuffer();
    if (isCustomerName.booleanValue())
        filter.append("and " + alias2 + ".orgcustomer IN (SELECT organization FROM organizations o1 WHERE upper(o1.name) matches upper('"+customerName+"') ) ");
    if (isCustomerInn.booleanValue())
        filter.append("and " + alias2 + ".orgcustomer IN (SELECT organization FROM organizations o2 WHERE upper(o2.inn) matches upper('"+customerInn+"') ) ");
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
    if (isNumberDoc.booleanValue())
        filter.append("and upper(" + alias1 + ".docnumber) matches upper('"+numberDoc+"') ");
    if (isNumberMemo.booleanValue())
       filter.append("and " + alias3 + ".leasedocument IN (SELECT loanContract FROM OfficeMemoHeaders WHERE  upper(number) matches upper('"+numberMemo+"') ) ");       
    if (isContractState.booleanValue())
    	filter.append("AND " + alias2 + ".contractstate = '"+contractState+"'");
    if (isRegionID.booleanValue())
    	filter.append("AND " + alias1 + ".regionid = "+regionID+" ");    		

    //append order by clause:
    filter.append(" order by " + aSortBy);
    
    sqlb.append(filter);
    //executeQuery:
	//res.executeQuery(sqlb.toString(), params.toArray());
	//System.out.println("CDBC_LoanContract_Object sql="+ sqlb.toString());//temp
	res.executeQuery(sqlb.toString(), null);
	
	return res;
}
/**
 * Возвращает список ссудных договоров аренды.
 */
public static CDBCResultSet findList(
	Integer searchFilter,	String searchString,
	Boolean isOrgCustomer, Integer orgCustomer,	Integer orgCustomer_VendorSiteID,     
	Boolean isContractState, String contractState,
	Boolean isRegionID, Integer regionID, 
	String aSortBy){
	    
	StringBuffer sqlb = new StringBuffer();
	ArrayList params = new ArrayList();

	CDBCResultSet res = new CDBCResultSet();
	//add generic query string: 
	sqlb.append(FIND_LIST_SQL);
	//aliases:
	String alias1 = "T3";//leaseDocuments
	String alias2 = "T2";//leaseContracts
	String alias3 = "T1";//loanContracts

	//calculate filter 1 clause
	StringBuffer filter = new StringBuffer();
	if (searchFilter.intValue() == 1){
		filter.append("and " + alias3 + ".mainposition IN (SELECT s.storageplace FROM positions p, storageplaces s WHERE s.storageplace = p.storageplace and p.gsmId = ?) ");
		params.add(searchString);
	}
	else if (searchFilter.intValue() == 2){
		filter.append("and " + alias3 + ".mainposition IN (SELECT s.storageplace FROM positions p, storageplaces s WHERE s.storageplace = p.storageplace and p.dampsId = ? ");
		params.add(searchString);
	}		
	else if (searchFilter.intValue() == 3){
		filter.append("and " + alias3 + ".mainposition IN (SELECT s.storageplace FROM positions p, storageplaces s WHERE s.storageplace = p.storageplace and upper(s.name) matches upper(?) ) ");
		params.add(searchString);
	}
	else if (searchFilter.intValue() == 4){
		filter.append("and " + alias2 + ".economist IN (SELECT w.worker FROM people p, workers w WHERE  w.man = p.man and upper(p.lastname) matches upper(?) ) ");
		params.add(searchString);		
	}
	else if (searchFilter.intValue() == 5){
		filter.append("and " + alias2 + ".manager IN (SELECT w.worker FROM people p, workers w WHERE  w.man = p.man and upper(p.lastname) matches upper(?) ) ");
		params.add(searchString);		
	}
	else if (searchFilter.intValue() == 6){
		filter.append("and upper(" + alias1 + ".docnumber) matches upper(?) ");
		params.add(searchString);
	}
	else if (searchFilter.intValue() == 7){
		filter.append("and " + alias3 + ".leasedocument IN (SELECT loanContract FROM OfficeMemoHeaders WHERE  upper(number) matches upper(?) ) ");
		params.add(searchString);		
	}
	//calculate filter 2 clause
	if (isOrgCustomer != null && isOrgCustomer.booleanValue() && orgCustomer != null && orgCustomer.intValue() != -1 ) {
		if(orgCustomer_VendorSiteID.intValue() == -1){
			//поиск по всем отделениям Ссудополучателя(если это организация):
			filter.append("AND vs.idVendor = ? ");
			//params.add(regionID);
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
	System.out.println("CDBC_LoanContract_Object.findList.SQL="+sqlb.toString()+" \n params="+params);//temp
	res.executeQuery(sqlb.toString(), params.toArray());
	
	return res;
}

/**
 * Возвращает список ссудных договоров аренды по позиции.
 */
public static CDBCResultSet findListByPosition(
	Boolean isPosition,	Integer position,
	Boolean isContractState, String contractState,
	Boolean isRegionID, Integer regionID, 
	String aSortBy){
	    
	StringBuffer sqlb = new StringBuffer();
	ArrayList params = new ArrayList();

	CDBCResultSet res = new CDBCResultSet();
	//add generic query string: 
	sqlb.append(FIND_LIST_SQL);
	//aliases:
	String alias1 = "T3";//leaseDocuments
	String alias2 = "T2";//leaseContracts
	String alias3 = "T1";//loanContracts

	//calculate filter clause
	StringBuffer filter = new StringBuffer();
	if (isPosition.booleanValue()){
		filter.append("and " + alias3 + ".mainposition = ? ");
		params.add(position);
	}	
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
	System.out.println("CDBC_LoanContract_Object.findListByPosition.SQL="+sqlb.toString()+" \n params="+params);//temp
	res.executeQuery(sqlb.toString(), params.toArray());
	
	return res;
}
/**
create procedure editLoanContract(
--execute procedure editLoanContract("I", 0, today, "111", 1, "A", "123",1, 1,1,today, today,null, null,"sjdsfh", "rqwer");
--изменяем состояние регламента
-- входные параметры
  i_TypeAction char(1),         -- I -добавить, U-изменить, D-удалить
  i_leasedocument integer,      -- id контракта, при  i_TypeAction=0
  i_docdate DATE,               -- дата
  i_docnumber CHAR(30),         -- номер 
  i_Operator Integer,           -- оператор, выполняющий операцию 
  i_reason char(1),             -- тип причины заключения договора
  i_planSum decimal(15,2),      -- планируемая сумма
  i_planCurr integer,           -- валюта
  i_mainPosition integer,       -- основная позиция
  i_orgcustomer integer,        -- Ссудополучатель
  i_orgexecutor integer,        -- Вымпелком
  i_startdate DATE,             -- дата начала
  i_enddate DATE,               -- дата окончания
  i_economist INTEGER,          -- экономист
  i_manager INTEGER,            -- менеджер
  i_doccomment VARCHAR(255,0),  -- комментарии
  i_docsubject VARCHAR(255,0)   -- предмет договора
) returning
 integer,               -- Признак ошибки (0 без ошибок)
 char(255);             -- сообщения об ошибках
 */
public static String procedure(com.hps.july.arenda.valueobject.LoanContractVO vo, Integer i_Operator, String operation) {
    //System.out.println(vo); //temp
    String returnStr = null;
    CDBCResultSet res = new CDBCResultSet();
    Object[] params =
        {
	        operation,
            vo.getLeaseDocument(),
            vo.getDocdate(),
            vo.getDocnumber(),
            i_Operator,
            vo.getReason(),
            vo.getPlanSum(),
            vo.getPlanCurrVO().getCurrency(),
            new Integer(vo.getMainpositionVO().getStorageplace()),
            vo.getOrgCustomer().getOrganization(),
            vo.getOrgExecutor().getOrganization(),
            vo.getStartDate(),
            vo.getEndDate(),
            vo.getEconomistVO().getWorker(),
            vo.getManagerVO().getWorker(),
            vo.getDocComment(),
            vo.getDocSubject(),
            vo.getRegionid()};
    res.executeQuery(PROCEDURE_SQL, params);
    ListIterator iter = res.listIterator();
    if (iter.hasNext()) {
        CDBCRowObject ro = (CDBCRowObject) iter.next();
        int ok = ((Integer) ro.getColumn("col1").asObject()).intValue();
        if (ok != 0)
            returnStr = ro.getColumn("col2").asString();
    } else {
        returnStr = "Ошибка записи(смотри лог)";
    }
    return returnStr;
}
}
