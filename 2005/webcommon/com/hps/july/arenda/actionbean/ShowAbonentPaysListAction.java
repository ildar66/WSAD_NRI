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
import com.hps.july.jdbcpersistence.lib.*;
import  java.sql.*;
import com.hps.july.arenda.billing.*;
/**
 * Action-class.
 * действие для "список оплат"
 * Creation date: (07.10.2002 16:23:09)
 * @author: Sergey Gourov
 */
public class ShowAbonentPaysListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (09.03.2005 13:51:21)
 */
public Enumeration findByDocumentQBE2(
    java.lang.Integer argDocument,
    java.lang.Boolean isDatePeriod,
    java.sql.Date argStartDate,
    java.sql.Date argEndDate,
    java.lang.Boolean isNeedPay,
    java.lang.Boolean needPay,
    java.lang.String orderBy)
    throws Exception {
    //get generic query string:
    StringBuffer sb =
        new StringBuffer("SELECT sumpayusd, flagworknri, sumnrirur, sumpayrur, ben, paypos, paynumber, sumfreeusd, recordstatus, sumnriusd, needpay, pym_type, typename, sumfreerur, paydate, byhand, resource, changeneedpay, leasedocument, paypurpose, case nvl(sumpayusd,0) when 0 then 0 else round((nvl(sumpayrur,0)/sumpayusd),4) end payrate FROM abonentpayments WHERE ");

    //calculate where clause
    StringBuffer whereClause = new StringBuffer("leasedocument=? ");
    if (isDatePeriod.booleanValue())
        whereClause.append("AND paydate >= ? AND paydate <= ? ");

    if (isNeedPay.booleanValue())
        if (needPay.booleanValue())
            whereClause.append("AND needpay='Y' ");
        else
            whereClause.append("AND needpay='N' ");

    //and fill it by where clause
    sb.append(whereClause.toString());

    //append order by clause
    sb.append(" order by " + orderBy);

    //System.out.println("SQL clause=" + sb); //temp 

    // fill prepared statement
    ArrayList result = new ArrayList();
    JdbcConnection jcon = new JdbcConnection();
    Connection con = jcon.getConnection();
    PreparedStatement ps = null;
    try {
        ps = con.prepareStatement(sb.toString());
        int j = 1;
        ps.setInt(j++, argDocument.intValue());
        if (isDatePeriod.booleanValue()) {
            ps.setDate(j++, argStartDate);
            ps.setDate(j++, argEndDate);
        }
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            AbonentPayment_VO vo = new AbonentPayment_VO();
            vo.setBen(JdbcConnection.getShort(rs, "ben"));
            String byHandStr = rs.getString("byhand");
            if ("Y".equals(byHandStr))
                vo.setByhand(true);
            else
                vo.setByhand(false);
            vo.setChangeneedpay(rs.getString("changeneedpay"));
            String flagworknriStr = rs.getString("flagworknri");
            if ("Y".equals(flagworknriStr))
                vo.setFlagworknri(true);
            else
                vo.setFlagworknri(false);
            vo.setLeasedocument(new Integer(rs.getInt("leasedocument")));
            String needpayStr = rs.getString("needpay");
            if ("Y".equals(needpayStr))
                vo.setNeedpay(true);
            else
                vo.setNeedpay(false);            
            vo.setPaydate(rs.getDate("paydate"));
            vo.setPaynumber(rs.getString("paynumber"));
            vo.setPaypos(rs.getInt("paypos"));
            vo.setPymtype(rs.getString("pym_type"));
            vo.setRecordstatus(rs.getString("recordstatus"));
            vo.setResource(JdbcConnection.getInteger(rs, "resource"));
            vo.setSumfreerur(rs.getBigDecimal("sumfreerur"));
            vo.setSumfreeusd(rs.getBigDecimal("sumfreeusd"));
            vo.setSumnrirur(rs.getBigDecimal("sumnrirur"));
            vo.setSumnriusd(rs.getBigDecimal("sumnriusd"));
            vo.setSumpayrur(rs.getBigDecimal("sumpayrur"));
            vo.setSumpayusd(rs.getBigDecimal("sumpayusd"));
            vo.setTypename(rs.getString("typename"));
            vo.setPayrate(rs.getBigDecimal("payrate"));
            vo.setPayPurpose(rs.getString("paypurpose"));
            //System.out.println("AbonentPayment=" + vo);
             result.add(vo);
        }
    } finally {
        if (ps != null)
            ps.close();
        if (con != null)
            con.close();
    }
    return Collections.enumeration(result);

}
public String getBrowseBeanName() {
	return "com.hps.july.arenda.actionbean.ShowAbonentPaysListAction";
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENT_PAYS_LIST);

    AbonentPaysListForm oform = (AbonentPaysListForm) form;

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
 * Creation date: (11.03.2005 11:30:31)
 * @param oform com.hps.july.arenda.formbean.AbonentPaysListForm
 * @param request javax.servlet.http.HttpServletRequest
 * @param errors org.apache.struts.action.ActionErrors
 */
private void processGroup(AbonentPaysListForm oform, HttpServletRequest request, ActionErrors errors) {
    //System.out.println("oform.getFlagworknri().length: " + oform.getFlagworknri().length); //temp
    //System.out.println("oform.getOldFlagworknri().size(): " + oform.getOldFlagworknri().size()); //temp
    if (oform.getFlagworknri().length == 0 && oform.getOldFlagworknri().size() == 0)
        return;

    boolean isError = false;
    int errorCount = 0;
    int taskCode = 0;
    try {
        int operator = 0;
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
            AbonentPaymentAccessBean apBean = new AbonentPaymentAccessBean();
            apBean.setInitKey_paypos(oform.getFlagworknri()[i]);
            apBean.refreshCopyHelper();

            apBean.setFlagworknri(false);
            apBean.setNeedpay(true);
            apBean.setChangeneedpay("H");

            apBean.commitCopyHelper();
            if (bufferAB == null)
                bufferAB = new BufferNri2NriAccessBean();
            isError = !bufferAB.moveOnePaymentBufferNri2Nri(taskCode, new Integer(oform.getFlagworknri()[i]), true);
            if (isError)
                errorCount++;
        }
        //конец цикла на вкл.
        //начало цикла на выключение:
        for (int i = 0; i < oform.getOldFlagworknri().size(); i++) {
            //проверка - был ли выключен checkbox
            //System.out.println("oform.getOldFlagworknri().get(i) :" + oform.getOldFlagworknri().get(i)); //temp
            AbonentPaymentAccessBean apBean = new AbonentPaymentAccessBean();
            apBean.setInitKey_paypos(((Integer) oform.getOldFlagworknri().get(i)).intValue());
            apBean.refreshCopyHelper();

            apBean.setFlagworknri(false);
            apBean.setNeedpay(false);
            apBean.setChangeneedpay("H");

            apBean.commitCopyHelper();
            if (bufferAB == null)
                bufferAB = new BufferNri2NriAccessBean();
            isError = !bufferAB.moveOnePaymentBufferNri2Nri(taskCode, (Integer) oform.getOldFlagworknri().get(i), true);
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
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.handleinnr.general.pay"));
        oform.setTaskcode(taskCode);
        //throw new UpdateValidationException("error.invalid.handleinnr.general.pay");
    }
}
}
