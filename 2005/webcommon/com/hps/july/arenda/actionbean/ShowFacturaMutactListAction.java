package com.hps.july.arenda.actionbean;

import java.sql.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import com.hps.july.arenda.sessionbean.*;
import com.hps.july.arenda.cdbcobjects.CDBC_SchetFact_Object;
import com.hps.july.arenda.formbean.*;
import java.util.Enumeration;
import java.math.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.web.util.*;
/**
 * Action-class.
 * действие для "фактур акта".
 * Creation date: (22.05.2003 15:13:01)
 * @author: Sergey Gourov
 */
public class ShowFacturaMutactListAction extends com.hps.july.web.util.BrowseAction {
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2002 16:35:23)
	 * @return java.lang.Object
	 * @param o java.lang.Object

	public Object constructRowModelBean(Object o) {
		LeaseSchetFaktAccessBean bean = (LeaseSchetFaktAccessBean) o;
		LeaseSchetFaktValueObject valueObject = new LeaseSchetFaktValueObject(bean);
		valueObject.setSumwithtax(new BigDecimal(0));

		try {
			Enumeration e =
				new LeasePosSchetFaktAccessBean().findLeasePosSchetFaktsByIdSchetFakt(
					new LeaseSchetFaktKey(bean.getIdSchetFakt()));
			while (e.hasMoreElements()) {
				LeasePosSchetFaktAccessBean lpsfBean = (LeasePosSchetFaktAccessBean) e.nextElement();
				if (lpsfBean.getSumWithTax() != null) {
					valueObject.setSumwithtax(valueObject.getSumwithtax().add(lpsfBean.getSumWithTax()));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			valueObject.setSumwithtax(new BigDecimal(0));
		}

		return valueObject;
	}
	 */	
	public void deleteSchf(FacturaMutactList oform) {
		if (oform == null)
			return;
		int i_type = getIType(oform.getCalcType());
		if (i_type > 0) {
			try {
				Object[] o = new ArendaDocumentProcessorAccessBean().delShfOnAkt(i_type, oform.getLeaseDocument());
				if (((Integer) o[0]).intValue() == 0) {
					oform.setIsAutoProcError(new Boolean(true));
					oform.setMessageError((String) o[1]);
				}
			} catch (Exception e) {
				e.printStackTrace();
				oform.setIsAutoProcError(new Boolean(true));
			}
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2003 15:13:01)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		//return "com.hps.july.persistence.LeaseSchetFaktAccessBean";
		return "com.hps.july.arenda.cdbcobjects.CDBC_SchetFact_Object";
	}
	public int getIRule(String calcType) {
		if (calcType == null || calcType.length() < 2) {
			return -1;
		}
		return ((int) calcType.charAt(1) - (int) '0');
	}
	public int getIType(String calcType) {
		if (calcType == null || calcType.length() < 1) {
			return -1;
		}
		return ((int) calcType.charAt(0) - (int) '0');
	}
	public void makeSchfOnAct(HttpServletRequest request, FacturaMutactList oform) {
		if (oform == null)
			return;
		int i_type = getIType(oform.getCalcType());
		int i_rule = getIRule(oform.getCalcType());
		Integer operatorCode = OperatorObject.getOperatorCode(request.getRemoteUser());
		System.out.println("EXEC PROC makeShfOnAkt(" + i_type + " ," + oform.getLeaseDocument() + " ," + i_rule +", " + operatorCode + ")");
		if (i_type >= 0 && i_rule >= 0) {
			//		ArrayList result = new ArrayList();
			//		JdbcConnection jcon = new JdbcConnection();
			//		Connection con = null;
			//		Statement statement = null;
			try {
				//			statement = con.createStatement();
				//			ResultSet rs = statement.executeQuery("execute procedure makeShfOnAkt("+i_type+","+oform.getLeaseDocument()+","+i_rule+")");
				//			if (rs.next()) {
				//				if(rs.getInt(1) == 0) {
				//					oform.setIsAutoProcError(Boolean.TRUE);
				//					oform.setMessageError(rs.getString(2));
				//				} else {
				//					oform.setIsAutoProcError(Boolean.FALSE);
				//				}
				//			}
				//Object[] o = new ArendaDocumentProcessorAccessBean().makeSchfOnAkt(i_type, oform.getLeaseDocument(), i_rule);
				Object[]  values =
					CDBC_SchetFact_Object.makeShfOnAkt(i_type, oform.getLeaseDocument(), i_rule, operatorCode.intValue());
				/**			
				System.out.print("EXEC PROC makeSchOnAct RESULT:");
							for(int m = 0; m < o.length; m++) {
				System.out.print(""+o[m]+":");
							}
				System.out.println();
				*/
				if (((Integer) values[0]).intValue() != 0) {
					oform.setIsAutoProcError(new Boolean(true));
					oform.setMessageError((String) values[1]);
				}
			} catch (Exception e) {
				System.out.print("EXEC PROC makeSchOnAct ERROR:");
				e.printStackTrace(System.out);
				oform.setIsAutoProcError(Boolean.TRUE);
			}
		}
	}
	public ActionForward perform(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.FACTURA_MUTACT_LIST);

		FacturaMutactList oform = (FacturaMutactList) form;
		try {
			LeaseMutualActNewAccessBean bean = new LeaseMutualActNewAccessBean();
			bean.setInitKey_leaseDocument(oform.getLeaseDocument());
			bean.refreshCopyHelper();

			oform.setDocumentNumber(bean.getDocumentNumber());
			oform.setDocumentDate(bean.getDocumentDate());
			oform.setActstartdate(bean.getActstartdate());
			oform.setActenddate(bean.getActenddate());
			oform.setActtype(bean.getLeaseMutualReglament().getActType());
		} catch (Exception e) {
			e.printStackTrace();
			oform.setDocumentNumber("");
			oform.setDocumentDate(null);
			oform.setActstartdate(null);
			oform.setActenddate(null);
			oform.setActtype("");
		}

		oform.setIsAutoProcError(new Boolean(false));
		if (request.getParameter("autoProc.x") != null && Integer.parseInt(request.getParameter("autoProc.x")) != 0) {
			makeSchfOnAct(request, oform);
		}

		if (request.getParameter("autoDelete.x") != null
			&& Integer.parseInt(request.getParameter("autoDelete.x")) != 0) {
			deleteSchf(oform);
		}

		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
