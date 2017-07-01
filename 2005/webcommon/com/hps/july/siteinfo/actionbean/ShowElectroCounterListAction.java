package com.hps.july.siteinfo.actionbean;

import com.hps.july.web.util.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.jdbcpersistence.EnvironmentAccessBean;
import com.hps.july.siteinfo.formbean.ElectroCounterListForm;
import com.hps.july.siteinfo.valueobject.ElectroCounter;
import com.hps.july.siteinfo.APPStates;
import com.hps.july.constants.Applications;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.ParsePosition;

/**
 * Обработчик списка электросчётчиков.
 * Основная функция, создание списка электросчётчиков с сохранением в сессии.
 * Creation date: (10.08.2004 18:49:41)
 * @author: Vadim Glushkov
 */
public class ShowElectroCounterListAction extends com.hps.july.web.util.BrowseAction {

	/**
	 * Возвращает имя bean для броуза - устарело, надо использовать такой же метод в BrowseForm.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBCElectroCounterObject";
	}
	
	/**
	 * Определяет кол-во строк на странице.
	 * Creation date: (22.01.2002 17:12:04)
	 * @return int
	 */
	public int getRowsOnPage() {
		return -1;
	}
	
	/**
	 * 
	 */

	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ParamsParser.setState(request, Applications.SITEINFO, APPStates.ELECTTRO_COUNTER_LIST);
		super.perform(mapping, form, request, response);

		ArrayList collection = new ArrayList();
		ArrayList collectionWarning = new ArrayList();
		ArrayList collectionOk = new ArrayList();

		GregorianCalendar calendar = new GregorianCalendar();
		Object o = request.getAttribute("browseList");

		if (o instanceof Collection) {
			Date currentDate = new Date();
			Collection rs1 = (Collection) o;

			Iterator iterator = rs1.iterator();
			while (iterator.hasNext()) {
				CDBCRowObject ro = (CDBCRowObject) iterator.next();
				if (ro != null) {
					CDBCColumnObject co = ro.getColumn("counterid");
					if (co != null) {
						HashMap attributes = new HashMap();
						Integer id = new Integer(co.asString());
						attributes.put("counterid", id);
						co = ro.getColumn("vendor_number");
						String vendorNumber = co.asString();
						attributes.put("vendor_number", vendorNumber);
						co = ro.getColumn("production_year");
						String productionYear = co.asString();
						attributes.put("production_year", productionYear);
						co = ro.getColumn("installation_date");
						java.sql.Date installationDate = (java.sql.Date) co.asObject();
						attributes.put("installation_date", installationDate);
						co = ro.getColumn("last_verification");
						java.sql.Date lastVerification = (java.sql.Date) co.asObject();
						attributes.put("last_verification", lastVerification);
						co = ro.getColumn("next_verification");
						java.sql.Date nextVerification = (java.sql.Date) co.asObject();
						attributes.put("next_verification", nextVerification);
						co = ro.getColumn("cstate");
						Integer stateI = new Integer(co.asString());
						attributes.put("cstate", stateI);
						co = ro.getColumn("name");
						String name = co.asString();
						attributes.put("name", name);
						//признак что Арендодатель является электроснабжающей организацией:
						co = ro.getColumn("isVendorPowerSupply");
						String isVendorPowerSupply = co.asString();
						attributes.put("isVendorPowerSupply", isVendorPowerSupply);
						//Код модели счетчика:
						co = ro.getColumn("code");
						String code = co.asString();
						attributes.put("code", code);
						//Зона сети:												
						co = ro.getColumn("zoneName");
						String zoneName = co.asString();
						attributes.put("zoneName", zoneName);
												
						if (currentDate.after(nextVerification) || currentDate.equals(nextVerification)) {
							attributes.put("error", Boolean.TRUE);
						} else {
							calendar.setTime(currentDate);
							double month = calendar.get(Calendar.MONTH) + 1.0D - 0.1D;
							double quarter = Math.ceil(month / 3);
							if (quarter >= 4.0D)
								quarter = 1.0D;
							else
								quarter += 1.0D;
							calendar.set(Calendar.MONTH, (int) (quarter * 3));
							calendar.set(Calendar.DAY_OF_MONTH, 1);
							calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);
							Date endPeriod = calendar.getTime();
							if (nextVerification.before(endPeriod)) {
								attributes.put("warning", Boolean.TRUE);
							}
						}
						ElectroCounter counter = new ElectroCounter(attributes);
						if (counter.getError().booleanValue())
							collection.add(counter);
						else if (counter.getWarning().booleanValue())
							collectionWarning.add(counter);
						else
							collectionOk.add(counter);

					}
				}
			}
		}

		collection.addAll(collectionWarning);
		collection.addAll(collectionOk);
		request.setAttribute("browseList", collection);
		
		ElectroCounterListForm iForm = (ElectroCounterListForm) form;
		if (ElectroCounterListForm.PRINT_XLS.equals(iForm.getOperation())) {
			iForm.setOperation(ElectroCounterListForm.EMPTY);
			return mapping.findForward(ElectroCounterListForm.PRINT_XLS);
		} else {
			return mapping.findForward("main");
		}		
	}
	/**
	 * 
	 * @param pstmt
	 * @param pos
	 * @param value
	 * @throws SQLException
	 */
	private void setObject(PreparedStatement pstmt, int pos, Object value) throws SQLException {
		if (value != null) {
			if (value instanceof java.lang.Integer) {
				if (value == null)
					pstmt.setNull(pos, Types.INTEGER);
				else
					pstmt.setInt(pos, ((Integer) value).intValue());
			} else if (value instanceof java.lang.String) {
				if (value == null)
					pstmt.setNull(pos, Types.VARCHAR);
				else
					pstmt.setString(pos, ((String) value));
			} else if (value instanceof java.sql.Date) {
				if (value == null)
					pstmt.setNull(pos, Types.VARCHAR);
				else
					pstmt.setDate(pos, ((java.sql.Date) value));
			}
		}
	}
}
