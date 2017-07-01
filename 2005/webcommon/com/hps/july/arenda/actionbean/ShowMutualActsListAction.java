package com.hps.july.arenda.actionbean;

import com.hps.july.persistence.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.web.util.*;
/**
 * Action-class.
 * Действие для "Для создания отчетов по актам".
 * Creation date: (09.07.2002 10:25:49)
 * @author: Sergey Gourov
 */
public class ShowMutualActsListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 10:25:50)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	//	return "com.hps.july.persistence.LeaseMutualActNewAccessBean";
	return "com.hps.july.arenda.cdbcobjects.CDBC_LeaseMutualAct_Object";
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.ARENDA, APPStates.MUTACTS_LIST);

    MutualActsListForm oform = (MutualActsListForm) form;

    //if (request.getParameter("document") != null) {
    String isSchetFaktX = request.getParameter("isSchetFakt.x");
    if ((isSchetFaktX != null) && (Integer.parseInt(isSchetFaktX) > 0)) {
	    //ручная установка признака наличия счета фактуры:
        try {
            LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean();
            lmanBean.setInitKey_leaseDocument(Integer.parseInt((String) request.getParameter("document")));
            lmanBean.refreshCopyHelper();

            lmanBean.setIsSchetFakt(new Boolean(!lmanBean.getIsSchetFakt().booleanValue()));
            lmanBean.commitCopyHelper();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        try {
            LeaseMutualReglamentAccessBean bean = new LeaseMutualReglamentAccessBean();
            bean.setInitKey_leaseDocument(oform.getMutualReglament());
            bean.refreshCopyHelper();

            oform.setDocumentNumber(bean.getDocumentNumber());
            oform.setDocumentDate(bean.getDocumentDate());
            oform.setActtype(bean.getActType());
            oform.setCommonRate(bean.getCommonRate());
            oform.setPeriod(bean.getMutualPeriod());
            oform.setCalcRateType(bean.getCalcRateType());
            oform.setMainCurrency(bean.getMaincurrency().getName());
            if (bean.getAdditionalCurrency() != null) {
                oform.setAdditionalCurrency(bean.getAdditionalCurrency().getName());
            } else {
                oform.setAdditionalCurrency(null);
            }
            oform.setReglamentState(bean.getMutState());
        } catch (Exception e) {
            e.printStackTrace();
            oform.setDocumentNumber("");
            oform.setDocumentDate(null);
            oform.setActtype("");
            oform.setCommonRate(null);
            oform.setPeriod("");
            oform.setCalcRateType("");
            oform.setMainCurrency("");
            oform.setAdditionalCurrency(null);
            oform.setReglamentState("");
        }
    }

    super.perform(mapping, form, request, response);
    return mapping.findForward("main");
}
}
