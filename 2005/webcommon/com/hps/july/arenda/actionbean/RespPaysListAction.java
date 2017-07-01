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
 * действие для "платежи по ответственному"
 * Creation date: (09.01.2004 12:37)
 * @author: Anthon Stefanov
 */
public class RespPaysListAction
	extends com.hps.july.web.util.BrowseAction
{
public java.util.ArrayList findByQBE()
    throws java.lang.Exception
{
//	get generic query string 
	int i;
	StringBuffer sb = new StringBuffer();

	ArrayList result = new ArrayList();

//	Fill sample data
	for(i = 0; i < 10; i++) {
		RespPaysValueObject vo = new RespPaysValueObject();
		vo.setBs(new Integer(i));
		vo.setBsname("D"+i+" A"+i+" Базовая станция");
		vo.setCondition("Доп. услов.");
		vo.setCurrency(new Integer(i));
		vo.setCurrencyname("Вал."+i);
		vo.setBeeline(new Integer(i));
		vo.setBeelinename("ОАО \"Вымпелком\" "+i);
		vo.setDate(new java.sql.Date(System.currentTimeMillis()));
		vo.setArendodatelinn("20304050607"+i);
		vo.setArendodatel(new Integer(i));
		vo.setArendodatelname("Арендодатель "+i);
		vo.setLastpay(null);
		vo.setBasecontract(i);
		vo.setNumber("1234567890");
		vo.setPaydate("Pay Date");
		vo.setPayreq((i%2==0)?true:false);
		vo.setPptype(i%2==0?"A":(i%3==0?"B":"C"));
		vo.setPeriodpay(i%2==0?"M":(i%3==0?"Q":"Y"));
		vo.setRaterule("Правило курса №"+i);
		vo.setService(new Integer(i));
		vo.setServicename("Услуга "+i);
		vo.setSum(new java.math.BigDecimal("1"+i+"."+i));
		vo.setVendor("VENDOR"+i);
		result.add(vo);
	}
    return result;
}
public java.util.ArrayList findByQBE(
	String loginid,
	Boolean periodMonth, Boolean periodQuartal, Boolean periodYear,
	String payreq,
	Boolean typeAvans, Boolean typeBybill, Boolean typeByend,
	String order
)
    throws java.lang.Exception
{
	ResultSet rs = null;
	PreparedStatement ps = null;

//	get generic query string 
	int i;
	StringBuffer sb = new StringBuffer();
	sb.append("SELECT ");
	sb.append("cnp.idbs bs, NVL('D' || po.gsmid || ' ','') || NVL('A' || po.dampsid || ' ','') || TRIM(posp.name) bsname, TRIM(posp.name) posname, cnp.countbs countbs, ");
	sb.append("cnp.idarendodatel arendodatel, TRIM(aro.name) arendodatelname, aro.inn arendodatelinn, ");
	sb.append("cnp.idbeeline beeline, TRIM(beo.name) beelinename, ");
	sb.append("cnp.idbasecontract basecontract, TRIM(pd.vendor) vendor, TRIM(ld.docnumber) number, ld.docdate date, ");
	sb.append("cnp.idresource service, TRIM(r.name) servicename, ");
	sb.append("cnp.pptype, cnp.periodpay, cnp.sumpay, ");
	sb.append("cnp.idcurrency currency, TRIM(cur.shortname) currencyname, ");
	sb.append("cnp.ruledatepay, cnp.ruleratepay, cnp.termspay, cnp.flagneedpay, ");
	sb.append("cnp.idlastpay pay, TRIM(lp.docnumber) paynumber, ldp.date paydate, TRIM(lpo.paypurpose) paypurpose, lp.summrub paysumrub ");
	sb.append("FROM contractsneedpay cnp, operators o, people p, ");
	sb.append("leasecontracts lc, leasedocuments ld, outer pie_dopinfocontr pd, ");
	sb.append("outer (storageplaces posp, positions po), ");
	sb.append("outer (organizations aro), outer (organizations beo), ");
	sb.append("outer resources r, ");
	sb.append("outer currencies cur, ");
	sb.append("outer (leasedocpositions ldp, leasepayments lp, leasepayorder lpo) ");
	sb.append("WHERE cnp.operator = o.operator AND o.man = p.man ");
	sb.append("AND cnp.idbasecontract = lc.leasedocument AND lc.leasedocument = ld.leasedocument AND cnp.idbasecontract = pd.leasedocument ");
	sb.append("AND cnp.idbs = po.storageplace AND posp.storageplace = po.storageplace ");
	sb.append("AND cnp.idarendodatel = aro.organization ");
	sb.append("AND cnp.idbeeline = beo.organization ");
	sb.append("AND cnp.idresource = r.resource ");
	sb.append("AND cnp.idcurrency = cur.currency ");
	sb.append("AND cnp.idlastpay = ldp.leasedocposition ");
	sb.append("AND ldp.leasedocposition = lp.leasedocposition ");
	sb.append("AND lpo.leasedocposition = ldp.leasedocposition ");

	sb.append("AND o.loiginid = ? ");

	// Process period
	StringBuffer temp = new StringBuffer();
	if(periodMonth != null && periodMonth.booleanValue()) {
		temp.append("'M'");
	}
	if(periodQuartal != null && periodQuartal.booleanValue()) {
		if(temp.length() > 0) temp.append(",");
		temp.append("'Q'");
	}
	if(periodYear != null && periodYear.booleanValue()) {
		if(temp.length() > 0) temp.append(",");
		temp.append("'Y'");
	}
	if(temp.length() > 0) {
		sb.append("AND cnp.periodpay IN ("+temp.toString()+") ");
	} else {
		sb.append("AND cnp.periodpay = '' ");
	}

	if(payreq != null && "H".equals(payreq)) {
		sb.append("AND cnp.flagneedpay = 'Y' ");
	}

	// process pptype
	temp = new StringBuffer();
	if(typeAvans != null && typeAvans.booleanValue()) {
		temp.append("'A'");
	}
	if(typeBybill != null && typeBybill.booleanValue()) {
		if(temp.length() > 0) temp.append(",");
		temp.append("'B'");
	}
	if(typeByend != null && typeByend.booleanValue()) {
		if(temp.length() > 0) temp.append(",");
		temp.append("'C'");
	}
	if(temp.length() > 0) {
		sb.append("AND cnp.pptype IN ("+temp.toString()+") ");
	} else {
		sb.append("AND cnp.pptype = '' ");
	}

	if(order != null && !"".equals(order.trim())) {
		sb.append("ORDER BY "+order.trim());
	}
	//System.out.println("SQL:\n"+sb.toString()+"\n--");

	ArrayList result = new ArrayList();
	JdbcConnection jcon = new JdbcConnection();
	Connection con = null;
	try {
		// Get JDBC connection
	    con = jcon.getConnection();
	    //fill prepared statement
	    ps = con.prepareStatement(sb.toString());

	    ps.setString(1,loginid);
	    rs = ps.executeQuery();

	    while (rs.next()) {
			RespPaysValueObject rpvo = new RespPaysValueObject(rs);
		    result.add(rpvo);
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
public String getBrowseBeanName() {
	return "com.hps.july.arenda.actionbean.RespPaysListAction";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
/* @TODO: Change to handle RespPaysListForm
	// Calculate browse params
	RespPaysListForm bform = (RespPaysListForm)form;

	// Set Operator
	int oper = 0;
	try {
		oper = new OperatorAccessBean().findByLogin(request.getRemoteUser()).getOperator();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	bform.setOperator(new Integer(oper));

	//String s1 = request.getParameter("calchist.x");
	//if ( (s1 != null) && (Integer.parseInt(s1) > 0) ) {
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
	//}

	String s2 = request.getParameter("ispaysf.x");
	if ( (s2 != null) && (Integer.parseInt(s2) > 0) ) {
		// Check change
		try {
			LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
			lpab.setInitKey_leaseDocPosition(bform.getCheckCode());
			lpab.refreshCopyHelper();
			if ("Y".equals(lpab.getIsSchetFakt()))
				lpab.setIsSchetFakt("N");
			else
				lpab.setIsSchetFakt("Y");
			lpab.commitCopyHelper();
		} catch (Exception e) {
			e.printStackTrace(System.out);
			// Errors during change
		    ActionErrors errors = new ActionErrors();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.dhist.ispaysf"));
		    saveErrors(request, errors);
		}
	}

	String s3 = request.getParameter("isactsf.x");
	if ( (s3 != null) && (Integer.parseInt(s3) > 0) ) {
		// Check change
		try {
			LeaseMutualActNewAccessBean lpab = new LeaseMutualActNewAccessBean();
			lpab.setInitKey_leaseDocument(bform.getCheckCode());
			lpab.refreshCopyHelper();
			if (lpab.getIsSchetFakt().booleanValue())
				lpab.setIsSchetFakt(Boolean.FALSE);
			else
				lpab.setIsSchetFakt(Boolean.TRUE);
			lpab.commitCopyHelper();
		} catch (Exception e) {
			e.printStackTrace(System.out);
			// Errors during change
		    ActionErrors errors = new ActionErrors();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.dhist.isactsf"));
		    saveErrors(request, errors);
		}
	}

	String s4 = request.getParameter("isstateact.x");
	if ( (s4 != null) && (Integer.parseInt(s4) > 0) ) {
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
		
	// Position
	try {
		bform.setPosname("");
		Enumeration en = new LeaseOnPositionAccessBean().findLeaseonpositionsByLeaseArendaAgreementNew(new LeaseDocumentKey(bform.getMaincontract()));
		if (en.hasMoreElements()) {
			LeaseOnPositionAccessBean lab = (LeaseOnPositionAccessBean)en.nextElement();
			String pname = "";
			PositionAccessBean pab = lab.getPosition();
			if (pab.getGsmid() != null)
				pname = pname + "D" + pab.getGsmid() + " ";
			if (pab.getDampsid() != null)
				pname = pname + "A" + pab.getDampsid() + " ";
			pname = pname + pab.getName();
			if (en.hasMoreElements())
				pname = pname + ", ...";
			bform.setPosname(pname);
		}
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}

	bform.initCollections();
*/	
	ParamsParser.setState(request, Applications.ARENDA, APPStates.RESP_PAYS_LIST);

	RespPaysListForm lform = (RespPaysListForm)form;

	lform.setLoginid(request.getRemoteUser());

	if(lform.getOperator() != null) {
		try {
			WorkerAccessBean w = new WorkerAccessBean();
			w.setInitKey_worker(lform.getOperator().intValue());
			w.refreshCopyHelper();
			lform.setOperator(new Integer(w.getWorker()));
			lform.setOperatorName(w.getMan().getFullName());
		} catch(Exception e) {
			lform.setOperator(null);
			lform.setOperatorName("");
		}
	} else {
		// try to find Worker by operator
		lform.setOperator(null);
		lform.setOperatorName("");
		try {
			OperatorAccessBean op = (new OperatorAccessBean()).findByLogin(lform.getLoginid());
			PeopleAccessBean p = op.getMan();

			if(p != null) {
				WorkerAccessBean wk = new WorkerAccessBean();
				Enumeration en = wk.findWorkersByMan((PeopleKey)p.__getKey());
				if(en.hasMoreElements()) {
					WorkerAccessBean wke = (WorkerAccessBean)en.nextElement();
					lform.setOperator(new Integer(wke.getWorker()));
					lform.setOperatorName(wke.getMan().getFullName());
				}
			}
		} catch(Exception e) {
			lform.setOperator(null);
			lform.setOperatorName("");
		} 
	}

	if(lform.getAdAction() != null && "C".equals(lform.getAdAction())) {
		// call recalculation procedure
		String res = recalcList(lform.getLoginid(),lform.getOperator(),lform.getRdateFrom(),lform.getRdateTill());
		if(res != null) {
System.out.println("ERROR IN RESPPAY RECALC:"+res);
		}
		// clear action
		lform.setAdAction("");
//		lform.setContract(null); // Может не нужно а?
	}

	super.perform(mapping, form, request, response);
	return mapping.findForward("main");
}
public static String recalcList(String loginid, Integer worker, java.sql.Date dateFrom, java.sql.Date dateTill) {
    JdbcConnection jcon = new JdbcConnection();
    Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	String result = null;
    try {
	    // Get JDBC connection
	    con = jcon.getConnection();
System.out.println("RESPPAYS: Call procedure('"+loginid+"',"+worker+","+dateFrom+","+dateTill+")");
		st = con.prepareStatement("EXECUTE PROCEDURE fillContractsNeedPay(?,?,?,?)");
		st.setString(1,loginid);
		if(worker != null) {
			st.setInt(2,worker.intValue());
		} else {
			st.setNull(2,java.sql.Types.INTEGER);
		}
		if(dateFrom != null) {
			st.setDate(3,dateFrom);
		} else {
			st.setNull(3,java.sql.Types.DATE);
		}
		if(dateTill != null) {
			st.setDate(4,dateTill);
		} else {
			st.setNull(4,java.sql.Types.DATE);
		}
		rs = st.executeQuery();
System.out.println("RESPPAYS: Got resultset");
	    if (rs.next()) {
		    int isok = rs.getInt(1);
System.out.println("RESPPAYS: IsOk = "+isok);
		    if (isok != 0) {
		    	result = rs.getString(2);
System.out.println("RESPPAYS: Result = "+result);
		    }
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
}
