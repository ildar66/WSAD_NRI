package com.hps.july.arenda.actionbean;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import com.hps.july.constants.Applications; //Заменить BeanName
import com.hps.july.arenda.APPStates;
import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.*;
import com.hps.july.persistence.*;
import java.io.IOException;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import java.math.*;

/**
 * Action-class.
 * действие для "список истории договора аренда"
 * Creation date: (04.11.2003 14:38:14)
 * @author: Dmitry Dneprov
 */
public class DogHistoryListAction extends com.hps.july.web.util.BrowseAction {
	/**
	 * Constructor
	 * Creation date: (04.11.2003 14:38:44)
	 */
	public DogHistoryListAction() {
	}
	public java.util.ArrayList findByQBE(Integer argContract, Integer argOperator, Integer argResource, Boolean isByDates, java.sql.Date argSDate, java.sql.Date argEDate, Integer argOrder)
		throws java.lang.Exception {

		ResultSet rs = null;
		PreparedStatement ps = null;

		//get generic query string 
		int i;
		StringBuffer sb = new StringBuffer("SELECT cp.nameperiod, cp.datestart, cp.datefinish, ah.*, ");
		sb.append("cdp.summ csumm, ccr.shortname ccname, ");
		sb.append("plp.docnumber ppnum, pdp.date ppdate, plp.summrub ppsumm, plp.isschetfakt ppischetfact, ");
		sb.append("getrateldocpos(ah.payarenda, cp.currency) lcratePay, ");
		sb.append("getrateldocpos(ah.chargearenda, cp.currency) lcrateCharges, ");
		sb.append("scr.shortname scname, ");
		sb.append("ascr.shortname ascname, ");
		sb.append("ald.docnumber actnum, ald.docdate actdate, alm.isschetfakt isactschetfact, alm.actstate actstate, ");
		sb.append("abr.name abresname, ");
		sb.append(
			"clp.ostSumForSF ostSumForSF, clp.flagSF flagSF, clp.ostSumForCwAct ostSumForCwAct, clp.flagCwAct flagCwAct, clp.isschetfakt1 isschetfakt1, clp.isschetfakt2 isschetfakt2, clp.isschetfakt3 isschetfakt3, getIsWorkAct(clp.leasedocposition) countWorkAct ");
		sb.append("FROM contractperiods cp, arendahistory ah, ");
		sb.append(" outer (leasedocpositions cdp, leasecharges clp, currencies ccr), ");
		sb.append(" outer (leasedocpositions pdp, leasepayments plp), ");
		sb.append(" outer (currencies scr), ");
		sb.append(" outer (leasedocuments ald, leasemutualacts alm), ");
		sb.append(" outer (currencies ascr), ");
		sb.append(" outer (resources abr) ");
		sb.append("WHERE ah.period = cp.period ");
		sb.append(" AND ccr.currency = cdp.currency AND cdp.leasedocposition = ah.chargearenda ");
		sb.append(" AND clp.leasedocposition = cdp.leasedocposition ");
		sb.append(" AND plp.leasedocposition = pdp.leasedocposition AND pdp.leasedocposition = ah.payarenda ");
		sb.append(" AND scr.currency = ah.tempsldcurr ");
		sb.append(" AND ascr.currency = ah.actcurr ");
		sb.append(" AND alm.leasedocument = ald.leasedocument AND ald.leasedocument = ah.codeact ");
		sb.append(" AND abr.resource = ah.resourceabonent ");

		//calculate where clause
		StringBuffer whereClause = new StringBuffer(" AND cp.contract = ? AND cp.operator = ? AND cp.resource = ? ");
		if (isByDates.booleanValue()) {
			whereClause.append(" AND cp.datestart >= ? AND cp.datefinish <= ? ");
		}

		sb.append(whereClause.toString());

		//append order by clause
		String orderBy = null;
		switch (argOrder.intValue()) {
			case 1 :
				orderBy = "cp.datestart asc, ah.numorder asc";
				break;
			case 2 :
				orderBy = "cp.datestart desc, ah.numorder desc";
				break;
		}
		sb.append(" order by " + orderBy);

		//System.out.println("SQL clause=" + sb);

		ArrayList result = new ArrayList();
		JdbcConnection jcon = new JdbcConnection();
		Connection con = null;
		try {
			// Get JDBC connection
			con = jcon.getConnection();
			//fill prepared statement
			ps = con.prepareStatement(sb.toString());

			int j = 1;
			ps.setInt(j++, argContract.intValue());
			ps.setInt(j++, argOperator.intValue());
			ps.setInt(j++, argResource.intValue());
			if (isByDates.booleanValue()) {
				ps.setDate(j++, argSDate);
				ps.setDate(j++, argEDate);
			}

			int constEquipment = AppUtils.getNamedValueInt(AppUtils.ARENDA_RES_EQUIPMENT);
			int constServices = AppUtils.getNamedValueInt(AppUtils.ARENDA_RES_CONNECT);

			rs = ps.executeQuery();

			while (rs.next()) {
				DogHistoryValueObject dhvo = new DogHistoryValueObject();

				dhvo.setPeriodname(jcon.getString(rs, "nameperiod"));
				dhvo.setSdate(rs.getDate("datestart"));
				dhvo.setEdate(rs.getDate("datefinish"));
				dhvo.setSumm(rs.getBigDecimal("csumm"));
				dhvo.setCurrname(jcon.getString(rs, "ccname"));
				dhvo.setPpnumber(jcon.getString(rs, "ppnum"));
				dhvo.setPpdate(rs.getDate("ppdate"));
				dhvo.setPpsumrub(rs.getBigDecimal("ppsumm"));
				dhvo.setRatePay(rs.getBigDecimal("lcratepay"));
				dhvo.setRateCharge(rs.getBigDecimal("lcratecharges"));
				String s = jcon.getString(rs, "ppischetfact");
				if ("Y".equals(s))
					dhvo.setIsschetfact(true);
				else
					dhvo.setIsschetfact(false);

				//patch SI start
				String schetfakt1 = jcon.getString(rs, "isschetfakt1");
				if ("Y".equals(schetfakt1))
					dhvo.setIsschetfakt1(true);
				else
					dhvo.setIsschetfakt1(false);

				String schetfakt2 = jcon.getString(rs, "isschetfakt2");
				if ("Y".equals(schetfakt2))
					dhvo.setIsschetfakt2(true);
				else
					dhvo.setIsschetfakt2(false);

				String schetfakt3 = jcon.getString(rs, "isschetfakt3");
				if ("Y".equals(schetfakt3))
					dhvo.setIsschetfakt3(true);
				else
					dhvo.setIsschetfakt3(false);
				dhvo.setFlagSF(new Integer(rs.getInt("flagsf")));
				dhvo.setOstSumForSF(rs.getBigDecimal("ostsumforsf"));
				dhvo.setFlagCwAct(new Integer(rs.getInt("flagcwact")));
				dhvo.setOstSumForCwAct(rs.getBigDecimal("ostsumforcwact"));
				//patch SI end

				dhvo.setSumchargeabonent(rs.getBigDecimal("sumchargeabonent"));
				dhvo.setSumpayabonent(rs.getBigDecimal("sumpayabonent"));
				dhvo.setTempsldsumm(rs.getBigDecimal("tempsldsum"));
				dhvo.setTempsldcurr(jcon.getString(rs, "scname"));

				dhvo.setActnum(jcon.getString(rs, "actnum"));
				dhvo.setActdate(rs.getDate("actdate"));
				dhvo.setActstate(jcon.getString(rs, "actstate"));
				String s1 = jcon.getString(rs, "isactschetfact");
				if ("Y".equals(s1))
					dhvo.setIsactschetfact(true);
				else
					dhvo.setIsactschetfact(false);

				dhvo.setIdhistoryarenda(rs.getInt("idhistoryarenda"));
				dhvo.setIdchargearenda(jcon.getInteger(rs, "chargearenda"));
				dhvo.setIdpayarenda(jcon.getInteger(rs, "payarenda"));
				dhvo.setIdchargeabonent(jcon.getInteger(rs, "chargeabonent"));
				dhvo.setIdpayabonent(jcon.getInteger(rs, "payabonent"));
				dhvo.setIdcodeact(jcon.getInteger(rs, "codeact"));

				dhvo.setSldsumm(rs.getBigDecimal("actsaldo"));
				dhvo.setSldcurr(jcon.getString(rs, "ascname"));
				dhvo.setSldNotes(jcon.getString(rs, "sldnotes"));
				dhvo.setSldByHand(jcon.getString(rs, "sldbyhand"));

				dhvo.setIdresourceabonent(jcon.getInteger(rs, "resourceabonent"));
				dhvo.setResabonentname(jcon.getString(rs, "abresname"));

				dhvo.setArescode("N");
				if (dhvo.getIdresourceabonent() != null) {
					if (dhvo.getIdresourceabonent().intValue() == constEquipment)
						dhvo.setArescode("E");
					if (dhvo.getIdresourceabonent().intValue() == constServices)
						dhvo.setArescode("S");
				}
				dhvo.setCountWorkAct(jcon.getInteger(rs, "countworkact").intValue());

				result.add(dhvo);
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
		return result;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:38:14)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.arenda.actionbean.DogHistoryListAction";
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.02.2004 11:57:06)
	 * @return boolean
	 */
	private static boolean isRecalcHistory(HttpServletRequest request) {
		Boolean recalcHistory = (Boolean) request.getSession().getAttribute("isRecalcHistory");
		if (recalcHistory == null) {
			int b = com.hps.july.util.AppUtils.getNamedValueInt("AutoCalcHistory");
			recalcHistory = (b == 1) ? Boolean.TRUE : Boolean.FALSE;
			request.getSession().setAttribute("isRecalcHistory", recalcHistory);
		}
		return recalcHistory.booleanValue();
	}
	
	/**
	 * 
	 */
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		boolean recalcHistory = isRecalcHistory(request);
		// Calculate browse params
		DogHistoryListForm bform = (DogHistoryListForm) form;

		String s4 = request.getParameter("isstateact.x");
		if ((s4 != null) && (Integer.parseInt(s4) > 0)) {
			// Check change
			ActionErrors errors = new ActionErrors();
			try {
				LeaseMutualActNewAccessBean lpab = new LeaseMutualActNewAccessBean();
				lpab.setInitKey_leaseDocument(bform.getCheckCode());
				lpab.refreshCopyHelper();
				if ("C".equals(lpab.getActState()))
					lpab.setActState("R");
				else if ("R".equals(lpab.getActState()))
					lpab.setActState("C");
				else {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.dhist.isstateactwrong"));
					saveErrors(request, errors);
				}
				lpab.commitCopyHelper();
			} catch (Exception e) {
				e.printStackTrace(System.out);
				// Errors during change
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.dhist.isstateact"));
				saveErrors(request, errors);
			}
		}
		//сохранение комментария договора:
		if (bform.isDirtyComment())
			saveComment(bform);
		bform.initCollections();
/**
		// Определение главной позиции и отв. экономиста:
		try {
			LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
			//ищем главный договор:
			bean.setInitKey_leaseDocument(bform.getMaincontract());
			bean.refreshCopyHelper();
			//устанавливаем главную позицию:
			bform.setPosname(getNameMainPosition(bean));
			//устанавливаем отв. экономиста:
			WorkerAccessBean manager = bean.getManager();
			if (manager != null)
				bform.setManager(manager.getMan().getFullName());
			else
				bform.setManager("");
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
*/
		//"Предмет договора" и "Комментарий к договору" из контракта.
		try {
			LeaseContractBLOBAccessBean beanBLOB = new LeaseContractBLOBAccessBean();
			beanBLOB.setInitKey_leaseDocument(bform.getContract().intValue());
			beanBLOB.refreshCopyHelper();
			bform.setComment(beanBLOB.getComment());
			bform.setSubject(beanBLOB.getSubject());
		} catch (Exception e) {
			e.printStackTrace();
			bform.setComment("");
			bform.setSubject("");
		}
		//вызов истории ???:
		String calchist = request.getParameter("calchist.x");
		if ((calchist != null) && (Integer.parseInt(calchist) > 0)) {
			recalcHistory = true;
		}

		// Set Operator
		int oper = 0;
		try {
			oper = new OperatorAccessBean().findByLogin(request.getRemoteUser()).getOperator();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		bform.setOperator(new Integer(oper));
		if (recalcHistory) {
			// Calculate history request
			System.out.println("Starting procedure FillContractHistory(" + bform.getMaincontract() + ", " + oper + ")");
			int jrncode = recalcHistory(bform.getMaincontract(), oper);
			bform.setJournalcode(jrncode);

			if (jrncode != 0) {
				// Errors during calculation
				ActionErrors errors = new ActionErrors();
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.dhist.recalc"));
				saveErrors(request, errors);
			}
		}

		ParamsParser.setState(request, Applications.ARENDA, APPStates.DOG_HISTORY_LIST);
		super.perform(mapping, form, request, response);
		return mapping.findForward("main");

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 14:46:32)
	 * @param argContract int
	 * @param argOperator int
	 */
	public static int recalcHistory(int argContract, int argOperator) {
		JdbcConnection jcon = new JdbcConnection();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int result = 0;
		try {
			// Get JDBC connection
			con = jcon.getConnection();

			st = con.createStatement();
			rs = st.executeQuery("EXECUTE PROCEDURE FillContractHistory(" + argContract + ", " + argOperator + ");");
			if (rs.next()) {
				int isok = rs.getInt(1);
				if (isok != 0)
					result = rs.getInt(2);
			}
		} catch (SQLException se) {
			System.out.println("SQLException LocalizedMessage=" + se.getLocalizedMessage());
			System.out.println("SQLException errorCode=" + se.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
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
		return result;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.04.2004 15:19:21)
	 */
	private void saveComment(DogHistoryListForm bform) {
		try {
			LeaseContractBLOBAccessBean beanBLOB = new LeaseContractBLOBAccessBean();
			beanBLOB.setInitKey_leaseDocument(bform.getContract().intValue());
			beanBLOB.refreshCopyHelper();

			beanBLOB.setComment(bform.getComment());
			//System.out.println("bform.getComment() :"+bform.getComment());
			//beanBLOB.setSubject(getSubject());
			beanBLOB.commitCopyHelper();

		} catch (Exception e) {
			System.out.println("DogHistoryListAction.java, Exception after update comment! contract=" + bform.getContract());
			e.printStackTrace();
		}

		bform.setDirtyComment(false);
	}
}
