package com.hps.july.arenda.cdbcobjects;

import java.text.*;
import java.util.*;
import java.sql.*;

import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.logic.DataPeriod;
import com.hps.july.valueobject.RegionsAccess_TO;
/**
* Базовые отчеты DAO.
* Creation date: (24.02.2005 16:53:17)
* @author: Shafigullin Ildar
*/
public class ReportDAO extends PageDAO {
	/**
	 * getSearchSQLString method comment.
	 */
	protected String getSearchSQLString(Object objCriteria, String orderBy) {
		Report_VO projCriteria = (Report_VO) objCriteria;
		Integer i_otvEconomist = projCriteria.getOtv().getWorker();
		String dateStartStr = projCriteria.getDataPeriod().getFromDateFrm();
		String dateFinishStr = projCriteria.getDataPeriod().getToDateFrm();
		String dateStr = projCriteria.getDataFrm();
		String result = null;
		String nameProject = projCriteria.getType().getName();
		Integer curRegID = projCriteria.getCurReg().getVo().getRegionid();
		if (nameProject.equalsIgnoreCase("getContrArOnOtv")) {
			//"Общая статистика по договорам аренды":
			result = "EXECUTE PROCEDURE getContrArOnOtv(" + i_otvEconomist + ", '" + dateStartStr + "', '" + dateFinishStr + "', " + curRegID + ")";
		} else if (nameProject.equalsIgnoreCase("repWarningProlong")) {
			//"Отчет о необходимости продления договоров":
			result = "EXECUTE PROCEDURE repWarningProlong('" + dateStr + "', " + i_otvEconomist + ", " + curRegID + ")";
		} else if (nameProject.equalsIgnoreCase("repWarningAkt")) {
			//"Отчет-предупреждение о необходимости формировать акты взаимозачета":
			result = "EXECUTE PROCEDURE repWarningAkt('" + dateStr + "', " + i_otvEconomist + ", " + curRegID + ")";
		} else if (nameProject.equalsIgnoreCase("listSfOnOtv")) {
			//"Отчет-предупреждение о необходимости формировать акты взаимозачета":
			result = "EXECUTE PROCEDURE listSfOnOtv(" + i_otvEconomist + ", '" + dateStartStr + "', '" + dateFinishStr + "', " + curRegID + ")";
		} else if (nameProject.equalsIgnoreCase("listAllContractsArenda")) {
			//"Все договора аренды":
			result = "EXECUTE PROCEDURE listAllContractsArenda(" + i_otvEconomist + ", " + curRegID + ")";
		} else if (nameProject.equalsIgnoreCase("workTimeOnEconomist")) {
			//"Трудоемкость по экономистам":
			result = "EXECUTE PROCEDURE workTimeOnEconomist(" + i_otvEconomist + ", '" + dateStartStr + "', '" + dateFinishStr + "', " + curRegID + ")";
		} else if (nameProject.equalsIgnoreCase("getListNewContracts")) {
			//"Новые договора за период":
			result = "EXECUTE PROCEDURE getListNewContracts(" + i_otvEconomist + ", '" + dateStartStr + "', '" + dateFinishStr + "', " + curRegID + ")";
		} else if (nameProject.equalsIgnoreCase("getListBadCharges")) {
			//"Наличие с.ф. и актов выполненных работ":
			result = "EXECUTE PROCEDURE getListBadCharges(" + i_otvEconomist + ", '" + dateStartStr + "', '" + dateFinishStr + "', 0, " + curRegID + ")";
		} else if (nameProject.equalsIgnoreCase("repYearPriceBS")) {
			//"Стоимость позиций":
			result = "EXECUTE PROCEDURE repYearPriceBS('" + dateStartStr + "', '" + dateFinishStr + "', " + curRegID + ")";
		} else if (nameProject.equalsIgnoreCase("repArendaListOfMmOpl")) {
			//"Список служебных записок":
			result = "EXECUTE PROCEDURE repArendaListOfMmOpl('" + dateStartStr + "', '" + dateFinishStr + "', " + curRegID + ", " + i_otvEconomist + ")";
		} else if (nameProject.equalsIgnoreCase("repArendaListAbonent")) {
			//"Статистика по абонентским договорам":
			result = "EXECUTE PROCEDURE repArendaListAbonent('" + dateStr + "', " + curRegID + ")";
		} else if (nameProject.equalsIgnoreCase("fillTmpListPayOnCategory")) {
			//"Платежи по позициям с разбивкой по категориям затрат":
			result = "EXECUTE PROCEDURE fillTmpListPayOnCategory(?, ?, ?)";
		} else if (nameProject.equalsIgnoreCase("repTemplateListZpNextPeriod")) {
			//"Планирование ЗП за период":
			result = "EXECUTE PROCEDURE repTemplateListZpNextPeriod(?, ?, ?, ?)";
		} else if (nameProject.equalsIgnoreCase("fillTmpListDocumenstOnPeriod")) {
			//"Отчет по первичным документам":
			result = "EXECUTE PROCEDURE fillTmpListDocumenstOnPeriod(?, ?, ?, ?)";
		} else if (nameProject.equalsIgnoreCase("fillTmpListContractsOnPeriod")) {
			//"Договора с поставщиками в валюте и рублях":
			result = "EXECUTE PROCEDURE fillTmpListContractsOnPeriod(?, ?, ?, ?)";
		} else if (nameProject.equalsIgnoreCase("repContractCustomersOnPeriod")) {
			//"По поставщикам за период":
			result = "EXECUTE PROCEDURE repContractCustomersOnPeriod(?, ?, ?)";
		} else if (nameProject.equalsIgnoreCase("repListContractsForNFS")) {
			//"Данные по договорам аренды для НФС":
			result = "EXECUTE PROCEDURE repListContractsForNFS(?, ?, ?)";
		} else {
			//заглушка:
			result = "EXECUTE PROCEDURE " + nameProject + "(" + i_otvEconomist + ",'" + dateStartStr + "', '" + dateFinishStr + "', " + curRegID + ")";
		}

		System.out.println("ReportDAO sql=" + result); //temp
		return result;
	}
	
	/**
	 * 
	 * @param page
	 * @param con
	 * @param searchCriteria
	 * @param start
	 * @param count
	 * @param orderBy
	 * @return
	 */
	public Page executePostSelect(Page page, Connection con, Object objCriteria, int start, int count, String orderBy) throws SQLException {
		Report_VO projCriteria = (Report_VO) objCriteria;
		String nameProject = projCriteria.getType().getName();
		if (nameProject.equalsIgnoreCase("fillTmpListPayOnCategory")) {
			//"Платежи по позициям с разбивкой по категориям затрат":
			page = postForListPayOnCategory(con, start, count);
		}else if(nameProject.equalsIgnoreCase("fillTmpListDocumenstOnPeriod")){
			//"Отчет по первичным документам":
			page = postForListDocumenstOnPeriod(projCriteria, con, start, count);
		}else if(nameProject.equalsIgnoreCase("fillTmpListContractsOnPeriod")){
			//"Договора с поставщиками в валюте и рублях":
			page = postForListContractsOnPeriod(projCriteria, con, start, count);			
		}
		return page;
	}

	/**
	 * 
	 * @param page
	 * @param period
	 */
	private ArrayList computePeriodsForPage(DataPeriod period, int count){
		//формируем шапку дат по месяцам из периода:
		ArrayList headers = new ArrayList();
		java.sql.Date fromDate = period.getFromDate();
		java.sql.Date toDate = period.getToDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fromDate);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		fromDate = new java.sql.Date(calendar.getTime().getTime());
		while (fromDate.before(toDate) || fromDate.equals(toDate)) {
			for (int i = 0; i < count; i++) {
				headers.add(fromDate);
			}
			calendar.add(Calendar.MONTH, 1);
			fromDate = new java.sql.Date(calendar.getTime().getTime());
		}
		return headers;
	}
	
	/**
	 * 
	 * @param con
	 * @param start
	 * @param count
	 * @return
	 * @throws SQLException
	 */
	private Page postForListPayOnCategory(Connection con, int start, int count) throws SQLException {
		//"Платежи по позициям с разбивкой по категориям затрат":
		Page page = null;
		String sql = "EXECUTE PROCEDURE getUniqCategoryFromListPay()";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			System.out.println("sql=" + sql); //temp
			//формируем шапку:
			ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			//переменная шапка:
			ArrayList headers = new ArrayList();
			while (rs.next()) {
				headers.add(rs.getString(1));
			}
			System.out.println("переменная шапка=" + headers);
			if (headers.size() != 0) {
				//формируем Page:
				StringBuffer sqlBuffer = new StringBuffer("SELECT UNIQUE(idPosition), getNumBsGsmOnPos(idPosition, 0), getNumBsDampsOnPos(idPosition, 0), getNamePosition(idPosition),  getSumPosFromTmpListPayOnCategory(idPosition) ");
				for (int i = 0; i < headers.size(); i++) {
					sqlBuffer.append(", getFromTmpListPayOnCategory(idPosition, ?) ");
				}
				sqlBuffer.append(" FROM TmpListPayOnCategory");
				sql = sqlBuffer.toString();
				System.out.println("sql=" + sql); //temp 
				ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				initQueryParams(ps, headers.toArray());
				rs = ps.executeQuery();
				//полная шапка:
				ArrayList headers_ALL = new ArrayList();
				headers_ALL.add("п/п");
				headers_ALL.add("Номер БС - GSM");
				headers_ALL.add("Номер БС - DAMPS");
				headers_ALL.add("Наименование позиции");
				headers_ALL.add("Всего по позиции");
				headers_ALL.addAll(headers);

				int numberOfColumns = headers_ALL.size();
				if (start >= 0 && rs.absolute(start + 1)) {
					boolean hasNext = false;
					List items = new LinkedList();
					do {
						items.add(populateRow(rs, numberOfColumns));
					} while ((hasNext = rs.next()) && (--count > 0));
					page = new Page(headers_ALL, items, start, hasNext);
				} else {
					//page = Page.EMPTY_PAGE;
					page = new Page(headers_ALL, Collections.EMPTY_LIST, 0, false);
				}
			} else {
				page = new Page(Collections.EMPTY_LIST, Collections.EMPTY_LIST, 0, false);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		}

		return page;
	}
	
	/**
	 * "Отчет по первичным документам"
	 * @param con
	 * @param start
	 * @param count
	 * @return
	 * @throws SQLException
	 */
	private Page postForListDocumenstOnPeriod(Report_VO projCriteria, Connection con, int start, int count) throws SQLException {
		//"Отчет по первичным документам":
		Page page = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//переменная шапка для параметров:
			ArrayList headers = computePeriodsForPage(projCriteria.getDataPeriod(), 2);
			System.out.println("переменная шапка для параметров=" + headers);
			//шапка для Page:
			ArrayList headersPage = computePeriodsForPage(projCriteria.getDataPeriod(), 1);
			System.out.println("шапка для Page=" + headersPage);
			//формируем Page:			
			if (headers.size() != 0) {
				StringBuffer sqlBuffer = new StringBuffer("SELECT nameOrg, docnumber, nameResource, nameEconomist, nameManager");
				for (int i = 0; i < headersPage.size(); i++) {
					sqlBuffer.append(", getStateRegistryCWAOnDate(idContract, ?), getStateRegistrySfOnDate(idContract, ?) ");
				}
				sqlBuffer.append(" FROM tmpListContracts");
				System.out.println("SQL=" + sqlBuffer.toString()); //temp 
				ps = con.prepareStatement(sqlBuffer.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				initQueryParams(ps, headers.toArray());
				rs = ps.executeQuery();
				
				int countConstantColumns = 5;
				int numberOfColumns = countConstantColumns + headers.size();
				if (start >= 0 && rs.absolute(start + 1)) {
					boolean hasNext = false;
					List items = new LinkedList();
					do {
						items.add(populateRow(rs, numberOfColumns));
					} while ((hasNext = rs.next()) && (--count > 0));
					page = new Page(headersPage, items, start, hasNext);
				} else {
					//page = Page.EMPTY_PAGE;
					page = new Page(headersPage, Collections.EMPTY_LIST, 0, false);
				}
			} else {
				page = new Page(Collections.EMPTY_LIST, Collections.EMPTY_LIST, 0, false);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		}

		return page;
	}
	
	/**
	 * "Договора с поставщиками в валюте и рублях"
	 * @param con
	 * @param start
	 * @param count
	 * @return
	 * @throws SQLException
	 */
	private Page postForListContractsOnPeriod(Report_VO projCriteria, Connection con, int start, int count) throws SQLException {
		//"Договора с поставщиками в валюте и рублях":
		Page page = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//переменная шапка для параметров:
			ArrayList headers = computePeriodsForPage(projCriteria.getDataPeriod(), 4);
			System.out.println("переменная шапка для параметров=" + headers);
			//шапка для Page:
			ArrayList headersPage = computePeriodsForPage(projCriteria.getDataPeriod(), 1);
			System.out.println("шапка для Page=" + headersPage);
			//формируем Page:			
			if (headers.size() != 0) {
				StringBuffer sqlBuffer = new StringBuffer("SELECT nameEconomist, nameOrg, docNumber, docDate, categoryBuchCode ");
				for (int i = 0; i < headersPage.size(); i++) {
					sqlBuffer.append(", getTmpCurrencyContractOnDate(idContract, ?, 'USD'), getTmpCurrencyContractOnDate(idContract, ?, 'EUR'), getTmpCurrencyContractOnDate(idContract, ?, 'RUR'), getTmpCurrencyContractOnDate(idContract, ?, 'OTHER') ");
				}
				sqlBuffer.append(" FROM tmpList");
				System.out.println("SQL=" + sqlBuffer.toString()); //temp 
				ps = con.prepareStatement(sqlBuffer.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				initQueryParams(ps, headers.toArray());
				rs = ps.executeQuery();
				
				int countConstantColumns = 5;
				int numberOfColumns = countConstantColumns + headers.size();
				if (start >= 0 && rs.absolute(start + 1)) {
					boolean hasNext = false;
					List items = new LinkedList();
					do {
						items.add(populateRow(rs, numberOfColumns));
					} while ((hasNext = rs.next()) && (--count > 0));
					page = new Page(headersPage, items, start, hasNext);
				} else {
					//page = Page.EMPTY_PAGE;
					page = new Page(headersPage, Collections.EMPTY_LIST, 0, false);
				}
			} else {
				page = new Page(Collections.EMPTY_LIST, Collections.EMPTY_LIST, 0, false);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		}

		return page;
	}	
		
	/* (non-Javadoc)
	 * @see com.hps.july.arenda.cdbcobjects.PageDAO#getQueryParams(java.lang.Object)
	 */
	protected Object[] getQueryParams(Object objCriteria) {
		Report_VO projCriteria = (Report_VO) objCriteria;
		Integer i_otvEconomist = projCriteria.getOtv().getWorker();
		java.sql.Date dateStart = projCriteria.getDataPeriod().getFromDate();
		java.sql.Date dateFinish = projCriteria.getDataPeriod().getToDate();
		java.sql.Date date = projCriteria.getData();
		String nameProject = projCriteria.getType().getName();
		Integer curRegID = projCriteria.getCurReg().getVo().getRegionid();

		ArrayList paramsList = new ArrayList();
		if (nameProject.equalsIgnoreCase("fillTmpListPayOnCategory")) {
			//"Платежи по позициям с разбивкой по категориям затрат":
			paramsList.add(curRegID);
			paramsList.add(dateStart);
			paramsList.add(dateFinish);
		} else if (nameProject.equalsIgnoreCase("repTemplateListZpNextPeriod")){
			//"Планирование ЗП за период"
			paramsList.add(dateStart);
			paramsList.add(dateFinish);
			paramsList.add(i_otvEconomist);
			paramsList.add(curRegID);
		} else if (nameProject.equalsIgnoreCase("fillTmpListDocumenstOnPeriod")){
			//"Отчет по первичным документам"
			paramsList.add(dateStart);
			paramsList.add(dateFinish);
			paramsList.add(curRegID);
			paramsList.add(i_otvEconomist);
		} else if (nameProject.equalsIgnoreCase("fillTmpListContractsOnPeriod")){
			//"Договора с поставщиками в валюте и рублях"
			paramsList.add(dateStart);
			paramsList.add(dateFinish);
			paramsList.add(curRegID);
			paramsList.add(i_otvEconomist);
		} else if (nameProject.equalsIgnoreCase("repContractCustomersOnPeriod")){
			//"По поставщикам за период"
			paramsList.add(dateStart);
			paramsList.add(dateFinish);
			paramsList.add(curRegID);
		} else if (nameProject.equalsIgnoreCase("repListContractsForNFS")){
			//"Отчет по договорам аренды для NFS"
			paramsList.add(date);
			paramsList.add(i_otvEconomist);
			paramsList.add(curRegID);			
		}
		System.out.println("paramsList=" + paramsList); //temp
		return paramsList.toArray();
	}

	/* (non-Javadoc)
	 * @see com.hps.july.arenda.cdbcobjects.PageDAO#initQueryParams(java.sql.PreparedStatement, java.lang.Object[])
	 */
	protected void initQueryParams(PreparedStatement apst, Object[] aparams) throws SQLException {
		if (aparams != null) {
			for (int i=0; i< aparams.length; i++) {
				if (aparams [i] != null){
					apst.setObject(i+1, aparams [i]);					
				} else {
					apst.setNull(i+1, java.sql.Types.INTEGER);
				}
			}
		}
	}

}
