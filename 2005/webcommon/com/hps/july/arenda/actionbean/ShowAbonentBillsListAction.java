package com.hps.july.arenda.actionbean;

import javax.transaction.*;
import javax.naming.*;
import java.math.*;
import java.util.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.arenda.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.*;
import java.sql.*;
import javax.sql.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.arenda.billing.*;
/**
 * Список абонентских счетов.
 * Creation date: (07.10.2002 16:23:09)
 * @author: Sergey Gourov
 */
public class ShowAbonentBillsListAction extends com.hps.july.web.util.BrowseAction {
public java.util.Enumeration findByQBE2(
        Boolean isLeaseDocument, Integer leaseDocument,
        Boolean isBillDate, java.sql.Date fromBillDate, java.sql.Date toBillDate, 
        Boolean isBillType, String billType,
        Boolean isUseinNRI, Boolean useInNRI,
        String paidSearch,
        Integer order)
	throws Exception
{
	//get generic query string 
	int i;
	StringBuffer sb = new StringBuffer();
	sb.append("SELECT ab.leasebill, ab.ben, ab.bensource, ab.billdate, ab.billnumber, ab.billperiodstart, ab.billperiodend, ab.billstatus, ab.billtype, ab.recordstatus, ab.useinnri, ab.flagworknri, NVL(ab.summopl,0.00) summopl, ab.notessummopl notessummopl, ");
	sb.append("ab.sumchangereason, ");//SI patch 1
	sb.append("sum(summ) summ, sum(ndssumm) ndssumm, sum(nspsumm) nspsumm, sum(summnri) summnri, sum(ndssummnri) ndssummnri, sum(nspsummnri) nspsummnri ");
//	sb.append(", sum(sumlinkusd) sumlinkusd ");
	sb.append("FROM abonentbills ab, OUTER abonentbillpos abp "); // , leaseabonentdnop lad 
	sb.append("WHERE ab.leasebill = abp.leasebill "); //  AND ab.leasebill = lad.leasebill AND lad.recordstatus = 'A'

	if (isLeaseDocument.booleanValue()) {
		sb.append("AND ab.leaseDocument=? ");
	}
	if (isBillDate.booleanValue()) {
		sb.append("AND ab.billdate >= ? and ab.billdate <=? ");
	}
	if (isBillType.booleanValue()) {
		sb.append("AND ab.billtype=? ");
	}
	if (isUseinNRI.booleanValue()) {
		sb.append("AND useinnri='"+(useInNRI.booleanValue()?"Y":"N")+"' ");
	}
	sb.append("GROUP BY ab.leasebill, ab.ben, ab.bensource, ab.billdate, ab.billnumber, ab.billperiodstart, ab.billperiodend, ab.billstatus, ab.billtype, ab.recordstatus, ab.useinnri, ab.flagworknri, ab.summopl, ab.notessummopl, ab.sumchangereason, ");
	sb.append("abp.leasebill ");
	if(paidSearch != null) {
		if("1".equals(paidSearch)) {
			sb.append("HAVING sum(abp.summ) > NVL(ab.summopl,0.00) ");
		} else if("2".equals(paidSearch)) {
			sb.append("HAVING sum(abp.summ) = NVL(ab.summopl,0.00) ");
		}
	}

	// append order by clause
	switch (order.intValue()) {
		case 1 : sb.append("ORDER BY ab.billnumber ASC ");
			break;
		case 2 :
			sb.append("ORDER BY ab.billnumber DESC ");
			break;
		case 3 :
			sb.append("ORDER BY ab.billdate ASC, ab.billnumber ASC ");
			break;
		case 4 :
			sb.append("ORDER BY ab.billdate DESC, ab.billnumber DESC ");
			break;
	}

	System.out.println("ShowAbonentBillsListAction.SQL clause=" + sb);

	// fill prepared statement
	ArrayList result = new ArrayList();
	JdbcConnection jcon = new JdbcConnection();
	Connection con = jcon.getConnection();
	try {
		PreparedStatement ps = con.prepareStatement(sb.toString());

		int j = 1;
		if (isLeaseDocument.booleanValue()) {
			ps.setInt(j++, leaseDocument.intValue());
		}
		if (isBillDate.booleanValue()) {
			ps.setDate(j++, fromBillDate);
			ps.setDate(j++, toBillDate);
		}
		if(isBillType.booleanValue()) {
			ps.setString(j++, billType);
		}

		ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		    AbonentBillValueObject abo = new AbonentBillValueObject();
			abo.setLeasebill(rs.getInt("leasebill"));
			abo.setBen(JdbcConnection.getShort(rs,"ben"));
			abo.setBensource(JdbcConnection.getString(rs, "bensource"));
			abo.setBilldate(rs.getDate("billdate"));
			abo.setBillnumber(JdbcConnection.getString(rs, "billnumber"));
			abo.setBillperiodend(rs.getDate("billperiodend"));
			abo.setBillperiodstart(rs.getDate("billperiodstart"));
			abo.setBillstatus(JdbcConnection.getString(rs, "billstatus"));
			abo.setBilltype(JdbcConnection.getString(rs, "billtype"));
			abo.setRecordstatus(JdbcConnection.getString(rs, "recordstatus"));
//			abo.setPayednotes(
            abo.setSumchangereason(JdbcConnection.getString(rs, "sumchangereason"));// SI patch 1
			String useinnri = rs.getString("useinnri");
			if ("Y".equals(useinnri))
				abo.setUseinnri(Boolean.TRUE);
			else
				abo.setUseinnri(Boolean.FALSE);
			String flagworknri = rs.getString("flagworknri");
			if ("Y".equals(flagworknri))
				abo.setFlagworknri(true);
			else
				abo.setFlagworknri(false);

			if (rs.getBigDecimal("summ") != null)
				abo.setSum(rs.getBigDecimal("summ"));
			else
				abo.setSum(new BigDecimal("0.00"));
			if (rs.getBigDecimal("ndssumm") != null)
				abo.setSumnds(rs.getBigDecimal("ndssumm"));
			if (rs.getBigDecimal("nspsumm") != null)
				abo.setSumnsp(rs.getBigDecimal("nspsumm"));
			if (rs.getBigDecimal("summnri") != null)
				abo.setNrisum(rs.getBigDecimal("summnri"));
			if (rs.getBigDecimal("ndssummnri") != null)
				abo.setNrisumnds(rs.getBigDecimal("ndssummnri"));
			if (rs.getBigDecimal("nspsummnri") != null)
				abo.setNrisumnsp(rs.getBigDecimal("nspsummnri"));

//			if (rs.getBigDecimal("sumlinkusd") != null)
//				abo.setPayed(rs.getBigDecimal("sumlinkusd"));
			if (rs.getBigDecimal("summopl") != null)
				abo.setPayed(rs.getBigDecimal("summopl"));
			abo.setPayednotes(rs.getString("notessummopl"));

			if (abo.getSum() != null)
				abo.setNotpayed(abo.getSum().subtract(abo.getPayed()));

			if (abo.getSum().equals(abo.getNrisum()))
				abo.setSummsdiffer(false);
			else
				abo.setSummsdiffer(true);

			result.add(abo);
	    }

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
    } finally {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	} 
    return Collections.enumeration(result);	    
}
public java.util.Enumeration findByQBE2old(
        Boolean isLeaseDocument, Integer leaseDocument,
        Boolean isBillDate, java.sql.Date fromBillDate, java.sql.Date toBillDate, 
        Boolean isBillType, String billType,
        Boolean isUseinNRI, Boolean useInNRI,
        String paidSearch,
        Integer order) throws Exception {

    //get generic query string 
    int i;
    StringBuffer sb = new StringBuffer("SELECT * FROM AbonentBills WHERE ");

    //calculate where clause
    StringBuffer whereClause = new StringBuffer("1=1 ");
    if (isLeaseDocument.booleanValue())
        whereClause.append("and leaseDocument=? ");
    if (isBillDate.booleanValue())
        whereClause.append("and BillDate >= ? and billdate <=? ");
    if (isBillType.booleanValue())
        whereClause.append("and billType=? ");
    if (isUseinNRI.booleanValue())
    	if (useInNRI.booleanValue())
        	whereClause.append("and useinnri='Y' ");
        else
        	whereClause.append("and useinnri='N' ");

    //and fill it by where clause
    sb.append(whereClause.toString());

    //append order by clause
    String orderBy = null;
    switch (order.intValue()) {
        case 1 :
            orderBy = "billNumber asc";
            break;
        case 2 :
            orderBy = "billNumber desc";
            break;
        case 3 :
            orderBy = "billDate asc";
            break;
        case 4 :
            orderBy = "billDate desc";
            break;
    }
    sb.append(" order by " + orderBy);

    //System.out.println("SQL clause=" + sb);

    //fill prepared statement
	ArrayList result = new ArrayList();
    JdbcConnection jcon = new JdbcConnection();
    Connection con = jcon.getConnection();
    try {
	    PreparedStatement ps = con.prepareStatement(sb.toString());

	    int j = 1;
	    if (isLeaseDocument.booleanValue())
	       ps.setInt(j++, leaseDocument.intValue());
	    if (isBillDate.booleanValue()){
	       ps.setDate(j++, fromBillDate);
	       ps.setDate(j++, toBillDate);
	    }
	    if (isBillType.booleanValue())
	       ps.setString(j++, billType);

	    ResultSet rs = ps.executeQuery();
		String sSum = "SELECT sum(summ) summ, sum(ndssumm) ndssumm, " +
		    "sum(nspsumm) nspsumm, sum(summnri) summnri, sum(ndssummnri) ndssummnri, sum(nspsummnri) nspsummnri " + 
		    "FROM AbonentBillPos WHERE leasebill = ?";
		System.out.println("SUM SQL clause=" + sSum);
	    PreparedStatement psSum = con.prepareStatement(sSum);

	    String sPSum = "SELECT sum(sumlinkusd) sumlinkusd FROM leaseabonentdnop WHERE " +
		    "leasebill = ? AND recordstatus = 'A'";
	    PreparedStatement psPSum = con.prepareStatement(sPSum);
	    
	    while (rs.next()) {
		    AbonentBillValueObject abo = new AbonentBillValueObject();
			abo.setLeasebill(rs.getInt("leasebill"));
			abo.setBen(JdbcConnection.getShort(rs,"ben"));
			abo.setBensource(JdbcConnection.getString(rs, "bensource"));
			abo.setBilldate(rs.getDate("billdate"));
			abo.setBillnumber(JdbcConnection.getString(rs, "billnumber"));
			abo.setBillperiodend(rs.getDate("billperiodend"));
			abo.setBillperiodstart(rs.getDate("billperiodstart"));
			abo.setBillstatus(JdbcConnection.getString(rs, "billstatus"));
			abo.setBilltype(JdbcConnection.getString(rs, "billtype"));
			abo.setRecordstatus(JdbcConnection.getString(rs, "recordstatus"));
			String useinnri = rs.getString("useinnri");
			if ("Y".equals(useinnri))
				abo.setUseinnri(Boolean.TRUE);
			else
				abo.setUseinnri(Boolean.FALSE);
			String flagworknri = rs.getString("flagworknri");
			if ("Y".equals(flagworknri))
				abo.setFlagworknri(true);
			else
				abo.setFlagworknri(false);
			
		    psSum.setInt(1, abo.getLeasebill());
		    ResultSet rsSum = psSum.executeQuery();
		    if (rsSum.next()) {
			    if (rsSum.getBigDecimal("summ") != null)
			    	abo.setSum(rsSum.getBigDecimal("summ"));
			    else
			    	abo.setSum(new BigDecimal("0.00"));
			    if (rsSum.getBigDecimal("ndssumm") != null)
			    	abo.setSumnds(rsSum.getBigDecimal("ndssumm"));
			    if (rsSum.getBigDecimal("nspsumm") != null)
			    	abo.setSumnsp(rsSum.getBigDecimal("nspsumm"));
			    if (rsSum.getBigDecimal("summnri") != null)
			    	abo.setNrisum(rsSum.getBigDecimal("summnri"));
			    if (rsSum.getBigDecimal("ndssummnri") != null)
			    	abo.setNrisumnds(rsSum.getBigDecimal("ndssummnri"));
			    if (rsSum.getBigDecimal("nspsummnri") != null)
			    	abo.setNrisumnsp(rsSum.getBigDecimal("nspsummnri"));
		    }
		    
		    psPSum.setInt(1, abo.getLeasebill());
		    ResultSet rsPSum = psPSum.executeQuery();
		    if (rsPSum.next()) {
			    if (rsPSum.getBigDecimal("sumlinkusd") != null)
			    	abo.setPayed(rsPSum.getBigDecimal("sumlinkusd"));
		    }

		    if (abo.getSum() != null)
		    	abo.setNotpayed(abo.getSum().subtract(abo.getPayed()));

		    if (abo.getSum().equals(abo.getNrisum()))
			    abo.setSummsdiffer(false);
			else
				abo.setSummsdiffer(true);
		    
		    result.add(abo);
		    
		    try {
			    rsSum.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		    try {
			    rsPSum.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
	    }

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
		    psSum.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
	    try {
		    psPSum.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
    } finally {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	} 
    return Collections.enumeration(result);	    
}
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 16:23:09)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.arenda.actionbean.ShowAbonentBillsListAction";
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENT_BILLS_LIST);

    AbonentBillsListForm oform = (AbonentBillsListForm) form;

    ActionErrors errors = new ActionErrors();
    if (oform.isGroup()) {
        processGroup(oform, request, errors);
        oform.setGroup(false);
    } else {
        try {
            LeaseAbonentBANAccessBean bean = new LeaseAbonentBANAccessBean();
            bean.setInitKey_leaseDocument(oform.getLeaseDocument());
            bean.refreshCopyHelper();

            oform.setBan("" + bean.getBan());
            oform.setCustomername(bean.getOrgCustomer().getName());
            oform.setCustomerinn(bean.getOrgCustomer().getInn());
            oform.setCustomernameBill(bean.getBil_name());
            oform.setCustomerinnBill(bean.getBil_inn());
        } catch (Exception e) {
            e.printStackTrace();
            oform.setBan("");
            oform.setCustomername("");
            oform.setCustomerinn("");
            oform.setCustomernameBill("");
            oform.setCustomerinnBill("");
        }
    }
    //process errors
    if (!errors.empty()) {
        saveErrors(request, errors);
    }
    super.perform(mapping, form, request, response);
    return mapping.findForward("main");
}
/**
 * Insert the method's description here.
 * Creation date: (19.01.2004 17:12:09)
 */
private void processGroup(AbonentBillsListForm oform, HttpServletRequest request, ActionErrors errors) {
    //System.out.println("oform.getFlagworknri().length: " + oform.getFlagworknri().length); //temp
    //System.out.println("oform.getOldFlagworknri().size(): " + oform.getOldFlagworknri().size()); //temp
    if (oform.getFlagworknri().length == 0 && oform.getOldFlagworknri().size() == 0)
        return;

    boolean isError = false;
    int errorCount = 0;
    int taskCode = 0;
    try {
        int operator = 0; // only for wte!!! set operator = 0 for ws!!!
        try {
            operator = new OperatorAccessBean().findByLogin(request.getUserPrincipal().getName()).getOperator();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Pie2NriAccessBean processor = new Pie2NriAccessBean();
        taskCode = processor.taskStart(operator, "6");

        BufferNri2NriAccessBean bufferAB = null;
        //начало цикла на вкл:
        for (int i = 0; i < oform.getFlagworknri().length; i++) {
            //проверка - был ли включен checkbox
            if (oform.getOldFlagworknri().contains(new Integer(oform.getFlagworknri()[i]))) {
                oform.getOldFlagworknri().remove(new Integer(oform.getFlagworknri()[i]));
                continue;
            }
            //System.out.println("oform.getFlagworknri()[i] :" + oform.getFlagworknri()[i]); //temp
            AbonentBillAccessBean abBean = new AbonentBillAccessBean();
            abBean.setInitKey_leasebill(oform.getFlagworknri()[i]);
            abBean.refreshCopyHelper();

            abBean.setFlagworknri(false);
            Boolean initUseinnri = abBean.getUseinnri();

            abBean.setUseinnri(new Boolean(true));

            if (!abBean.getUseinnri().equals(initUseinnri)) {
                abBean.setChangeuseinnri("H");
            }

            abBean.commitCopyHelper();
            if (bufferAB == null)
                bufferAB = new BufferNri2NriAccessBean();
            isError = !bufferAB.moveOneBillBufferNri2Nri(taskCode, new Integer(oform.getFlagworknri()[i]));
            if (isError)
                errorCount++;
        }
        //конец цикла на вкл:

        //начало цикла на выключение:
        for (int i = 0; i < oform.getOldFlagworknri().size(); i++) {
            //проверка - был ли выключен checkbox
            //System.out.println("oform.getOldFlagworknri().get(i) :" + oform.getOldFlagworknri().get(i)); //temp
            AbonentBillAccessBean abBean = new AbonentBillAccessBean();
            abBean.setInitKey_leasebill(((Integer) oform.getOldFlagworknri().get(i)).intValue());
            abBean.refreshCopyHelper();

            abBean.setFlagworknri(false);
            Boolean initUseinnri = abBean.getUseinnri();

            abBean.setUseinnri(new Boolean(false));

            if (!abBean.getUseinnri().equals(initUseinnri)) {
                abBean.setChangeuseinnri("H");
            }

            abBean.commitCopyHelper();
            if (bufferAB == null)
                bufferAB = new BufferNri2NriAccessBean();
            isError = !bufferAB.moveOneBillBufferNri2Nri(taskCode, (Integer) oform.getOldFlagworknri().get(i));
            if (isError)
                errorCount++;
        }
        //конец цикла на выключение:
        if (oform.getFlagworknri().length != 0)
            processor.taskEnd(oform.getFlagworknri()[0]);
        else
            processor.taskEnd(((Integer) oform.getOldFlagworknri().get(0)).intValue());
    } catch (Exception e) {
        e.printStackTrace();
        isError = true;
        errorCount++;
    }

    if (errorCount != 0) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.handleinnr.general.bill"));
        oform.setTaskcode(taskCode);
        //throw new UpdateValidationException("error.invalid.handleinnr.general.bill");
    }
}
}
