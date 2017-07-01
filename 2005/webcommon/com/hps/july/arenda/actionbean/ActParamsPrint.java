package com.hps.july.arenda.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.*;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;
import java.sql.*;
import javax.sql.*;

/**
 * Печать параметров акта.
 * Creation date: (30.07.2002 17:33:08)
 * @author: Dmitry Dneprov
 */
public class ActParamsPrint extends com.hps.july.web.util.NavigatedAction {
/**
 * Shows if to add current URL to history.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isAddtoHistory() {
	return false;
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
	HttpServletResponse response) throws IOException, ServletException {

	super.perform( mapping, form, request, response );
	
	ActParamsPrintForm eform = (ActParamsPrintForm) form;

	JdbcConnection jcon = new JdbcConnection();
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	try {
		con = jcon.getConnection();
		st = con.createStatement();
		rs = st.executeQuery("execute procedure viewInfoReglament1(" + eform.getReglament() + ");");
		if (rs.next()) {
			eform.setHeader1(rs.getString(1));
			eform.setHeader2(rs.getString(2));
			eform.setHeader3(rs.getString(3));
			eform.setHeader4(rs.getString(4));
			eform.setHeader5(rs.getString(5));
			eform.setActtype(rs.getString(6));
			if ("Y".equals(rs.getString(7)))
				eform.setCommonRate(true);
			else
				eform.setCommonRate(false);
		}

		rs.close();
		rs = st.executeQuery("execute procedure viewInfoReglament2(" + eform.getReglament() + ");");
		ArrayList ar1 = new ArrayList();
		while (rs.next()) {
			ActParamsPrintObject1 ao1 = new ActParamsPrintObject1();
			ao1.setDocument(rs.getInt(1));
			ao1.setMaindoc(rs.getInt(2));
			ao1.setDognumber(rs.getString(3));
			ao1.setDogdate(rs.getDate(4));
			ao1.setCustname(rs.getString(5));
			ao1.setOrgname(rs.getString(6));
			ao1.setSdate(rs.getDate(7));
			ao1.setEdate(rs.getDate(8));
			ao1.setProlong(rs.getString(9));
			ao1.setPayraterule(rs.getString(10));
			ao1.setResname(rs.getString(11));
			ao1.setCurrname(rs.getString(12));
			ao1.setChargesumm(rs.getBigDecimal(13));
			ao1.setChargeperiod(rs.getString(14));
			ao1.setPaytype(rs.getString(15));
			ao1.setPaysumm(rs.getBigDecimal(16));
			ao1.setPayperiod(rs.getString(17));
			ao1.setTrafsumm(rs.getBigDecimal(18));
			ar1.add(ao1);
		}
		eform.setTable1(ar1);
		
		rs.close();
		rs = st.executeQuery("execute procedure viewInfoReglament3(" + eform.getReglament() + ");");
		ArrayList ar2 = new ArrayList();
		while (rs.next()) {
			ActParamsPrintObject2 ao2 = new ActParamsPrintObject2();
			ao2.setBan(rs.getString(2));
			ao2.setBens(rs.getString(3));
			ao2.setCustname(rs.getString(4));
			ao2.setOrgname(rs.getString(5));
			ar2.add(ao2);
		}
		eform.setTable2(ar2);
		
		rs.close();
		rs = st.executeQuery("execute procedure viewInfoReglament4(" + eform.getReglament() + ");");
		ArrayList ar3 = new ArrayList();
		while (rs.next()) {
			ActParamsPrintObject3 ao3 = new ActParamsPrintObject3();
			ao3.setResname(rs.getString(1));
			ao3.setSchetuse(rs.getString(2));
			ao3.setUsebillbyrate(rs.getString(3));
			ao3.setUsepay(rs.getString(4));
			ar3.add(ao3);
		}
		eform.setTable3(ar3);
		
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
	
	ParamsParser.setState(request, Applications.ARENDA, com.hps.july.arenda.APPStates.ACT_PARAMS_PRINT);
	return  mapping.findForward("main");
}
}
