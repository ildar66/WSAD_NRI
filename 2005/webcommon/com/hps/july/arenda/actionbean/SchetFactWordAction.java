package com.hps.july.arenda.actionbean;

import com.hps.july.web.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.io.IOException;
import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
import java.util.*;
/**
 * Action-class.
 * действие для "счет-фактуры"
 * Creation date: (27.04.2004 12:14:21)
 * @author: Shafigullin Ildar
 */
public class SchetFactWordAction extends NavigatedAction {
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 13:06:43)
	 * @return com.hps.july.arenda.valueobject.SchetFactHeaderValueObject
	 * @param stmt java.sql.Statement
	 * @param code java.lang.String
	 * @exception java.lang.Exception The exception description.
	 */
	private SchetFactHeaderValueObject getHeader(Statement stmt, String code) throws java.lang.Exception {
		SchetFactHeaderValueObject vo = new SchetFactHeaderValueObject();
		String s = "execute procedure printShfHeader(" + code + ")";
		ResultSet r = stmt.executeQuery(s);
		try {
			if (r.next()) {
				vo.setNumberSchetFakt(r.getString(1));
				vo.setDateSchetFakt(r.getDate(2));
				vo.setBaseDocNumber(r.getString(3));
				vo.setBaseDocDate(r.getDate(4));
				vo.setNameAddrSender(r.getString(5));
				vo.setNameAddrRecipient(r.getString(6));
				vo.setNameSeller(r.getString(7));
				vo.setNameBuyer(r.getString(8));
				vo.setAddressSeller(r.getString(9));
				vo.setAddressBuyer(r.getString(10));
				vo.setInnSeller(r.getString(11));
				vo.setInnBuyer(r.getString(12));
				vo.setNameManager(r.getString(13));
				vo.setNameBugalter(r.getString(14));
				vo.setNamePosition(r.getString(15));
			} else {
				System.out.println("Счет-фактура не может быть распечатана: code=" + code);
			}
		} finally {
			if (r != null)
				r.close();
		}

		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 13:06:43)
	 * @return com.hps.july.arenda.valueobject.SchetFactHeaderValueObject
	 * @param stmt java.sql.Statement
	 * @param code java.lang.String
	 * @exception java.lang.Exception The exception description.
	 */
	private SchetFactHeaderValueObject getHeader(Statement stmt, String code, String type) throws java.lang.Exception {
		SchetFactHeaderValueObject vo = new SchetFactHeaderValueObject();
		String s = "execute procedure printShfHeader(" + code + ", '" + type + "')";
		ResultSet r = stmt.executeQuery(s);
		try {
			if (r.next()) {
				vo.setNumberSchetFakt(r.getString(1));
				vo.setDateSchetFakt(r.getDate(2));
				vo.setBaseDocNumber(r.getString(3));
				vo.setBaseDocDate(r.getDate(4));
				vo.setNameAddrSender(r.getString(5));
				vo.setNameAddrRecipient(r.getString(6));
				vo.setNameSeller(r.getString(7));
				vo.setNameBuyer(r.getString(8));
				vo.setAddressSeller(r.getString(9));
				vo.setAddressBuyer(r.getString(10));
				vo.setInnSeller(r.getString(11));
				vo.setInnBuyer(r.getString(12));
				vo.setNameManager(r.getString(13));
				vo.setNameBugalter(r.getString(14));
				vo.setNamePosition(r.getString(15));
				vo.setCurrencyName(r.getString(16));
			} else {
				System.out.println("Счет-фактура не может быть распечатана: code=" + code);
			}
		} finally {
			if (r != null)
				r.close();
		}

		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 14:28:10)
	 * @return java.util.ArrayList
	 * @param stmt java.sql.Statement
	 * @param code java.lang.String
	 * @exception java.lang.Exception The exception description.
	 */
	private ArrayList getPositionsList(Statement stmt, String code) throws java.lang.Exception {
		ArrayList list = new ArrayList();
		String s = "execute procedure printShfPosition(" + code + ")";
		ResultSet rs = stmt.executeQuery(s);
		try {
			while (rs.next()) {
				SchetFactPositionValueObject vo = new SchetFactPositionValueObject();
				vo.setPosOrder(new Integer(rs.getInt(1)));
				vo.setNameResource(rs.getString(2));
				vo.setEdizm(rs.getString(3));
				vo.setQty(rs.getBigDecimal(4));
				vo.setPrice(rs.getBigDecimal(5));
				vo.setSumFreeTax(rs.getBigDecimal(6));
				vo.setExcise(rs.getBigDecimal(7));
				vo.setRateNds(rs.getBigDecimal(8));
				vo.setSumNds(rs.getBigDecimal(9));
				vo.setSumWithTax(rs.getBigDecimal(10));
				vo.setCountry(rs.getString(11));
				vo.setNumGTD(rs.getString(12));
				vo.setIdCurrency(new Integer(rs.getInt(13)));

				list.add(vo);
			}

		} finally {
			if (rs != null)
				rs.close();
		}

		return list;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 14:28:10)
	 * @return java.util.ArrayList
	 * @param stmt java.sql.Statement
	 * @param code java.lang.String
	 * @exception java.lang.Exception The exception description.
	 */
	private ArrayList getPositionsList(Statement stmt, String code, String type) throws java.lang.Exception {
		ArrayList list = new ArrayList();
		String s = "execute procedure printShfPosition(" + code + ", '" + type + "')";
		ResultSet rs = stmt.executeQuery(s);
		try {
			while (rs.next()) {
				SchetFactPositionValueObject vo = new SchetFactPositionValueObject();
				vo.setPosOrder(new Integer(rs.getInt(1)));
				vo.setNameResource(rs.getString(2));
				vo.setEdizm(rs.getString(3));
				vo.setQty(rs.getBigDecimal(4));
				vo.setPrice(rs.getBigDecimal(5));
				vo.setSumFreeTax(rs.getBigDecimal(6));
				vo.setExcise(rs.getBigDecimal(7));
				vo.setRateNds(rs.getBigDecimal(8));
				vo.setSumNds(rs.getBigDecimal(9));
				vo.setSumWithTax(rs.getBigDecimal(10));
				vo.setCountry(rs.getString(11));
				vo.setNumGTD(rs.getString(12));
				vo.setIdCurrency(new Integer(rs.getInt(13)));

				list.add(vo);
			}

		} finally {
			if (rs != null)
				rs.close();
		}

		return list;
	}
	/**
	 * Shows if to add current URL to history.
	 * Creation date: (08.10.2003 17:21:05)
	 * @return boolean
	 */
	public boolean isAddtoHistory() {
		return false;
	}
	/**
	 * Process the specified HTTP request, and create the corresponding HTTP
	 * response (or forward to another web component that will create it).
	 * Return an <code>ActionForward</code> instance describing where and how
	 * control should be forwarded, or <code>null</code> if the response has
	 * already been completed.
	 *
	 * @param mapping The ActionMapping used to select this instance
	 * @param actionForm The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 *
	 * @exception IOException if an input/output error occurs
	 * @exception ServletException if a servlet exception occurs
	 */
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		super.perform(mapping, form, request, response);
		SchetFactPrintForm eform = (SchetFactPrintForm) form;
		String code = eform.getCode();
		String mappingStr = "error";

		JdbcConnection jcon = new JdbcConnection();
		Connection con = null;
		Statement st = null;
		try {
			con = jcon.getConnection();
			st = con.createStatement();

			eform.setHeader(getHeader(st, code, eform.getType()));
			eform.setPositionsList(getPositionsList(st, code, eform.getType()));
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}

		if (eform.getType() != null) {
			mappingStr = "type_" + eform.getType();
		}
		return mapping.findForward(mappingStr);

	}
}
