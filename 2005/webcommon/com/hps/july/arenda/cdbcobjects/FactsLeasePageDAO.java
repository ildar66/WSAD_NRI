/*
 * Created on 30.11.2006
 *
 * "Фактические данные по договорам Аренды" PageDAO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.cdbcobjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hps.july.arenda.formbean.FactsLeasePageForm;
import com.hps.july.arenda.valueobject.FactsLeaseColStatusDogOnDate;
import com.hps.july.arenda.valueobject.FactsLeaseTO;
import com.hps.july.logic.DataPeriod;
import com.hps.july.util.ServiceLocatorException;

/**
 * @author IShaffigulin
 *
 * "Фактические данные по договорам Аренды" PageDAO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FactsLeasePageDAO extends PageDAO {
	/**
	 * 
	 * @param i_BaseContract
	 * @param i_date
	 * @param i_currency
	 * @return
	 * @throws SQLException
	 * @throws ServiceLocatorException
	 */

	public FactsLeaseColStatusDogOnDate getColStatusDogOnDate(int i_BaseContract, java.sql.Date i_date, int i_currency) throws SQLException, ServiceLocatorException {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		FactsLeaseColStatusDogOnDate retStatus = null;
		try {
			conn = getDataSource().getConnection();
			st = conn.prepareCall("EXECUTE PROCEDURE getColumsStatusDogOnDate(?, ?, ?)");
			st.setInt(1, i_BaseContract);
			st.setDate(2, i_date);
			st.setInt(3, i_currency);
			rs = st.executeQuery();
			if (rs.next()) {
				retStatus = new FactsLeaseColStatusDogOnDate();
				retStatus.setColorCharge(rs.getString(1));
				retStatus.setHintCharge(rs.getString(2));
				retStatus.setColorSF(rs.getString(3));
				retStatus.setHintSF(rs.getString(4));				
				retStatus.setColorCWA(rs.getString(5));
				retStatus.setHintCWA(rs.getString(6));				
				retStatus.setColorPay(rs.getString(7));
				retStatus.setHintPay(rs.getString(8));
				/**				
					int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
					if (result == 0) {
						System.out.println("Процедура 'getColStatusDogOnDate' ok"); //temp
					} else {
						errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
						System.out.println("Процедура 'getColStatusDogOnDate' errorTxt: " + errorTxt); //temp
					}
				*/
			} else {
				System.out.println("no DATA: execute procedure 'getColStatusDogOnDate'"); //temp
			}
		} catch (SQLException e) {
			System.out.println("SQLException FactsLeasePageDAO.getColStatusDogOnDate ");
			System.out.println("ERROR: code=" + e.getErrorCode() + ", msg=" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (ServiceLocatorException exc) {
			System.out.println("ServiceLocatorException FactsLeasePageDAO.getColStatusDogOnDate: " + exc);
			exc.printStackTrace();
			throw exc;
		} finally {
			finallyMetod(conn, st, rs);
		}
		return retStatus;
	}
	
	/**
	 * 
	 * @param i_BaseContract
	 * @param period
	 * @param i_currency
	 * @return
	 * @throws SQLException
	 * @throws ServiceLocatorException
	 */

	public java.util.ArrayList getFactLeaseStateOnPeriod(int i_BaseContract, DataPeriod period, int i_currency) throws SQLException, ServiceLocatorException {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList statusList = new ArrayList();
		FactsLeaseColStatusDogOnDate statusVO = null;
		try {
			conn = getDataSource().getConnection();
			st = conn.prepareCall("EXECUTE PROCEDURE getFactLeaseStateOnPeriod(?, ?, ?, ?)");
			st.setInt(1, i_BaseContract);
			st.setDate(2, period.getFromDate());
			st.setDate(3, period.getToDate());
			st.setInt(4, i_currency);
			rs = st.executeQuery();
			while (rs.next()) {
				statusVO = new FactsLeaseColStatusDogOnDate(rs.getDate(1));
				statusVO.setColorCharge(rs.getString(2));
				statusVO.setHintCharge(rs.getString(3));
				statusVO.setColorSF(rs.getString(4));
				statusVO.setHintSF(rs.getString(5));				
				statusVO.setColorCWA(rs.getString(6));
				statusVO.setHintCWA(rs.getString(7));				
				statusVO.setColorPay(rs.getString(8));
				statusVO.setHintPay(rs.getString(9));
				statusList.add(statusVO);
			}
		} catch (SQLException e) {
			System.out.println("SQLException FactsLeasePageDAO.getFactLeaseStateOnPeriod ");
			System.out.println("ERROR: code=" + e.getErrorCode() + ", msg=" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (ServiceLocatorException exc) {
			System.out.println("ServiceLocatorException FactsLeasePageDAO.getFactLeaseStateOnPeriod: " + exc);
			exc.printStackTrace();
			throw exc;
		} finally {
			finallyMetod(conn, st, rs);
		}
		return statusList;
	}
	/**
	 * 
	 * @param conn
	 * @param st
	 * @param rs
	 */
	private void finallyMetod(Connection conn, PreparedStatement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (Exception exc) {
			System.out.println("FactsLeasePageDAO.getColStatusDogOnDate: не могу закрыть соединение!!!");
		}
	}	
	/* (non-Javadoc)
	 * @see com.hps.july.arenda.cdbcobjects.PageDAO#getSearchSQLString(java.lang.Object, java.lang.String)
	 */
	protected String getSearchSQLString(Object projCriteria, String orderBy) {
		FactsLeasePageForm listForm = (FactsLeasePageForm) projCriteria;
		//параметры фильтра запроса:
		Boolean isAllOrgCustomer = listForm.getIsCustomer();
		Boolean isAllOrgExecutor = listForm.getIsExecutor();
		Boolean isAllMainEconomist = listForm.getIsEconomist();
		Integer orgExecutor = listForm.getExecutorCode();
		Integer orgExecutor_VendorSiteID = listForm.getExecutor_vendocSiteId();
		Boolean isAllPosition = listForm.getIsPosition();
		Boolean isAllResource = listForm.getIsResource();
		Boolean isRegionID = listForm.getIsRegionID();
		String sortBy = listForm.getSortBy();
		//запрос:
		StringBuffer sqlb = new StringBuffer();
		sqlb.append("SELECT first 1000 baseDogD.leasedocument docID, ");// activeDogD.regionid,
		sqlb.append("activeDogD.docdate docDate, activeDogD.docnumber docNumber, "); //activeDogD.doctype, activeDogD.operator, 
		//sqlb.append("activeDogC.contracttype, activeDogC.contractstate, activeDogC.orgcustomer, ");
		//sqlb.append("activeDogC.orgexecutor, activeDogC.custname, activeDogC.execname, ");
		//sqlb.append("activeDogC.startdate, activeDogC.enddate, "); //activeDogC.doctext, 
		//sqlb.append("'' docfilename, '' doccomment, '' docsubject, ");
		//sqlb.append("activeDogC.extendtype, activeDogC.extendperiod, activeDogC.reportperiod, ");
		sqlb.append("activeDogC.currency1 docCurrency, ");//activeDogC.economist, activeDogC.currency2
		//sqlb.append("activeDogC.summ1, activeDogC.summ2, activeDogC.ratecalcrule, ");
		//sqlb.append("activeDogC.ratecalcruleday, activeDogC.ratedelta, activeDogC.manager, ");
		//sqlb.append("activeDogC.dateclose, activeDogA.mainleasedocument, activeDogA.isactive, ");
		//sqlb.append("activeDogA.numberofphones, activeDogA.calcelectrotype, activeDogA.isdogelectro, activeDogA.officialdoc, activeDogA.needofficialdoc, ");
		//sqlb.append("activeDogA.dogelectonum, activeDogA.dogelectrodate, activeDogA.numberofphonestemp, activeDogA.mainposition, ");
		//sqlb.append("baseDogD.docnumber mainDocumentNumber, baseDogD.docdate maindocdate, baseDogC.contractstate maincontractstate, ");
		//sqlb.append("baseDogC.startdate mainstartdate, baseDogC.economist mainEconomist, baseDogC.manager mainManager, baseDogC.dateclose maindateclose, ");
		//sqlb.append("getNumBsGsmOnPos(activeDogA.mainposition, 0) gsmId, getNumBsDampsOnPos(activeDogA.mainposition, 0) dampsId, ");
		sqlb.append("getNamePosition(activeDogA.mainposition) mainpositionName ");
		//sqlb.append("getListPosContract(activeDogD.leasedocument, 2) allposition, ");
		//sqlb.append("getListResContract(baseDogD.leasedocument) resource, ");
		//sqlb.append("getNameresource(baseDogA.mainResource) resource, ");
		//sqlb.append("getNameOrg(baseDogC.orgExecutor) orgExecutorName, ");
		//sqlb.append("getNameOrg(baseDogC.orgCustomer) orgCustomerName, ");
		//sqlb.append("getInnOrg(baseDogC.orgCustomer) orgCustomerInn, ");
		//sqlb.append("getNameCurrency(activeDogC.currency1,0,0) curr1Name, ");
		//sqlb.append("getNameCurrency(activeDogC.currency1,0,0) curr2Name, ");
		//sqlb.append("getSumTrafContract(activeDogA.leasedocument, activeDogC.currency1) trafic1, ");
		//sqlb.append("getSumTrafContract(activeDogA.leasedocument, activeDogC.currency2) trafic2, ");
		//sqlb.append("BaseDogA.sumTrafic trafic1, ");
		//sqlb.append("getSumAcceptContr(activeDogA.leasedocument, activeDogC.currency1) accept1, ");
		//sqlb.append("getSumAcceptContr(activeDogA.leasedocument, activeDogC.currency2) accept2, ");
		//sqlb.append("BaseDogA.sumAccept accept1, ");
		//sqlb.append("getNameWorker(baseDogC.economist) mainEconomistName, ");
		//sqlb.append("getNameWorker(baseDogC.manager) mainManagerName, ");
		//sqlb.append("getCountProblemOnContract(baseDogA.leasedocument) countProblemOnContract ");
		//addSearchSQLStringForPeriods(listForm, sqlb);
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
		if (isAllOrgCustomer != null && !isAllOrgCustomer.booleanValue()) {
			filterSB.append("AND baseDogC.orgcustomer = ? ");
		}
		if (isAllOrgExecutor != null && !isAllOrgExecutor.booleanValue() && orgExecutor != null && orgExecutor.intValue() != -1) {
			if (orgExecutor_VendorSiteID.intValue() == -1) {
				//поиск по всем отделениям заказчика(арендадателя):
				filterSB.append("AND vs.idVendor = ? ");
			} else {
				filterSB.append("AND vs.idVendorSite = ? ");
			}
		}
		if (isAllMainEconomist != null && !isAllMainEconomist.booleanValue()) {
			filterSB.append("AND  (baseDogC.economist = ? OR baseDogC.manager = ?) ");
		}
		if (isAllPosition != null && !isAllPosition.booleanValue()) {
			//filterSB.append("AND exists (select l.* from leaseonpositions l where l.leasedocument=baseDogC.leasedocument AND l.storageplace = ?) ");
			filterSB.append(
				"AND baseDogA.leasedocument IN( SELECT nvl(la1.mainleasedocument, la1.leasedocument) FROM leaseonpositions lp, leasearendaagrmnts la1 WHERE la1.leasedocument = lp.leasedocument AND lp.storageplace = ? ) ");
		}
		if (!isAllResource.booleanValue()) {
			filterSB.append("AND baseDogA.mainResource = ? ");
		}
		if (isRegionID.booleanValue()) {
			filterSB.append("AND baseDogD.regionid = ? ");
		}
		whereClause.append(filterSB);
		sqlb.append(whereClause);
		//append order by clause:
		if (sortBy != null) {
			sqlb.append("order by " + sortBy);
		}

		System.out.println("FactsLeasePageDAO.SQL=" + sqlb.toString()); //temp

		return sqlb.toString();
	}

	private void addSearchSQLStringForPeriods(Object objCriteria, StringBuffer sqlb) {
		FactsLeasePageForm listForm = (FactsLeasePageForm) objCriteria;
		int colCount = 8;
		for (int i = 1; i <= colCount; i++) {
			sqlb.append(", getColStatusDogOnDate(activeDogD.leasedocument, ?, activeDogC.currency1, " + i + ") colStatus_" + i + " ");
		}
	}
	/* (non-Javadoc)
	 * @see com.hps.july.arenda.cdbcobjects.PageDAO#getQueryParams(java.lang.Object)
	 */
	protected Object[] getQueryParams(Object objCriteria) {
		FactsLeasePageForm listForm = (FactsLeasePageForm) objCriteria;
		//параметры фильтра запроса:
		Boolean isAllOrgCustomer = listForm.getIsCustomer();
		Boolean isAllOrgExecutor = listForm.getIsExecutor();
		Boolean isAllMainEconomist = listForm.getIsEconomist();
		Integer orgExecutor = listForm.getExecutorCode();
		Integer orgExecutor_VendorSiteID = listForm.getExecutor_vendocSiteId();
		Boolean isAllPosition = listForm.getIsPosition();
		Boolean isAllResource = listForm.getIsResource();
		Boolean isRegionID = listForm.getIsRegionID();
		Integer orgCustomer = listForm.getCustomerCode();
		Integer mainEconomist = listForm.getEconomistCode();
		Integer position = listForm.getPositionCode();
		String resourceCode = listForm.getResourceCode();
		Integer regionID = listForm.getRegionID();

		//запрос:
		ArrayList params = new ArrayList();

		//addQueryParamsForPeriods(objCriteria, params);

		if (isAllOrgCustomer != null && !isAllOrgCustomer.booleanValue()) {
			params.add(orgCustomer);
		}
		if (isAllOrgExecutor != null && !isAllOrgExecutor.booleanValue() && orgExecutor != null && orgExecutor.intValue() != -1) {
			if (orgExecutor_VendorSiteID.intValue() == -1) {
				//поиск по всем отделениям заказчика(арендадателя):
				params.add(orgExecutor);
			} else {
				params.add(orgExecutor_VendorSiteID);
			}
		}
		if (isAllMainEconomist != null && !isAllMainEconomist.booleanValue()) {
			params.add(mainEconomist);
			params.add(mainEconomist);
		}
		if (isAllPosition != null && !isAllPosition.booleanValue()) {
			params.add(position);
		}
		if (!isAllResource.booleanValue()) {
			params.add(resourceCode);
		}
		if (isRegionID.booleanValue()) {
			params.add(regionID);
		}

		System.out.println("paramsList=" + params); //temp
		return params.toArray();
	}

	private void addQueryParamsForPeriods(Object objCriteria, ArrayList params) {
		FactsLeasePageForm listForm = (FactsLeasePageForm) objCriteria;
		DataPeriod period = listForm.getDataPeriod();
		int colCount = 8;
		for (int i = 1; i <= colCount; i++) {
			//sqlb.append(", getColStatusDogOnDate(activeDogD.leasedocument, ?, ?, "+i+") colStatus_"+i);
			params.add(period.getFromDate());
		}
	}
	/* (non-Javadoc)
	 * @see com.hps.july.arenda.cdbcobjects.PageDAO#populateRow(java.sql.ResultSet, int)
	 */
	protected Object populateRow(ResultSet rs, int numberOfColumns) throws SQLException {
		//return super.populateRow(rs, numberOfColumns);
		FactsLeaseTO factsLeaseTO = new FactsLeaseTO((Integer) rs.getObject("docID"));
		factsLeaseTO.setDocNumber(rs.getString("docNumber"));
		factsLeaseTO.setDocDate(rs.getDate("docDate"));
		//factsLeaseTO.setGsmId(rs.getString("gsmId"));
		//factsLeaseTO.setDampsId(rs.getString("dampsId"));
		factsLeaseTO.setName(rs.getString("mainpositionName"));
		factsLeaseTO.setDocCurrency((Integer)rs.getObject("docCurrency"));

		return factsLeaseTO;
	}

}
