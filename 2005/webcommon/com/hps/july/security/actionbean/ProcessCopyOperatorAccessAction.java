package com.hps.july.security.actionbean;

import com.hps.july.commonbean.*;
import com.hps.july.security.formbean.*;
//
import org.apache.struts.action.*;
//
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
//
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.security.*;
import com.hps.july.security.valueobject.*;
import com.hps.july.constants.*;

/**
 * –ежим копировани€ оператора (с правами) - обработка.
 * Creation date: (31.03.2003 16:36:57)
 * @author: Alexander Makanin
 */
public class ProcessCopyOperatorAccessAction extends Action {

/**
 * ProcessCopyOperatorAccessAction constructor comment.
 */
public ProcessCopyOperatorAccessAction() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 18:46:47)
 * @param operator int
 * @param newOperator int
 */
public void copyRegionAcc(int operator, int newOperator) {
	if(operator == newOperator)return;
    RegionAccAccessBean ab0 = new RegionAccAccessBean();
    try { //delete all from newOperator
	    //Log.debug(3, this, "ProcessCopyOperatorAccessAction", "inside copyRegionAcc");
        Enumeration newOperatorAcc = ab0.findRegionAccsByOperator(new OperatorKey(newOperator));
        while (newOperatorAcc.hasMoreElements()) {
            RegionAccAccessBean rab = (RegionAccAccessBean) newOperatorAcc.nextElement();
            rab.getEJBRef().remove();
        }//insert for newOperator
        KeyGeneratorAccessBean gen = new KeyGeneratorAccessBean();
        Enumeration operatorAcc = ab0.findRegionAccsByOperator(new OperatorKey(operator));
        //Log.debug(3, this, "***** ProcessCopyOperatorAccessAction : copyRegionAcc ", "operatorAcc : " + operatorAcc);
        while (operatorAcc.hasMoreElements()) {
            RegionAccAccessBean rab = (RegionAccAccessBean) operatorAcc.nextElement();
            int accessid = gen.getNextKey("tables.regionsaccess");
            //Log.debug(3, this, "ProcessCopyOperatorAccessAction : copyRegionAcc ", "new RegionAccAccessBean : " +
	        //"\naccessid = "   + accessid +
	        //"\nnewOperator = "   + newOperator +
	        //"\nrab.getRegionKey().regionid = "   + rab.getRegionKey().regionid +
	        //"\nrab.getViewplan() = "   + rab.getViewplan() +
	        //"\nrab.getViewfact() = "   + rab.getViewfact() +
	        //"\nrab.getEditplan() = "   + rab.getEditplan() +
	        //"\nrab.getEditfact() = "   + rab.getEditfact() );
            RegionAccAccessBean ab =
                new RegionAccAccessBean(
                    accessid,
                    newOperator,
                    rab.getRegionKey().regionid,
                    rab.getViewplan(),
                    rab.getViewfact(),
                    rab.getEditplan(),
                    rab.getEditfact());
        }
    } catch (javax.ejb.FinderException fe) {
        fe.printStackTrace();
    } catch (javax.naming.NamingException ne) {
        ne.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 18:46:47)
 * @param operator int
 * @param newOperator int
 */
public void copyRoles(int operator, int newOperator) {
    if (operator == newOperator)
        return;
    Operators2RolesAccessBean ab0 = new Operators2RolesAccessBean();
    try {//delete newOperators2Roles
        Enumeration newOperators2Roles = ab0.findOperators2RolesByOperator(new OperatorKey(newOperator));
        while (newOperators2Roles.hasMoreElements()) {
            Operators2RolesAccessBean otrab = (Operators2RolesAccessBean) newOperators2Roles.nextElement();
            otrab.getEJBRef().remove();
        } //insert for newOperators2Roles from operators2Roles
        KeyGeneratorAccessBean gen = new KeyGeneratorAccessBean();
        Enumeration operators2Roles = ab0.findOperators2RolesByOperator(new OperatorKey(operator));
        while (operators2Roles.hasMoreElements()) {
            Operators2RolesAccessBean otrab = (Operators2RolesAccessBean) operators2Roles.nextElement();
            int accessid = gen.getNextKey("tables.regionsaccess");
            Operators2RolesAccessBean ab =
                new Operators2RolesAccessBean(
                    new Integer(newOperator),
                    otrab.getRoleKey().role);
        }
    } catch (javax.ejb.FinderException fe) {
        fe.printStackTrace();
    } catch (javax.naming.NamingException ne) {
        ne.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2003 18:46:47)
 * @param operator int
 * @param newOperator int
 */
public void copySuperRegionAcc(int operator, int newOperator) {
	if(operator == newOperator)return;
    SuperRegionAccAccessBean ab0 = new SuperRegionAccAccessBean();
    try { //delete all from newOperator
	    //Log.debug(3, this, "ProcessCopyOperatorAccessAction", "inside copySuperRegionAcc");
        Enumeration newOperatorAcc = ab0.findSuperRegionAccsByOperator(new OperatorKey(newOperator));
        while (newOperatorAcc.hasMoreElements()) {
            SuperRegionAccAccessBean sab = (SuperRegionAccAccessBean) newOperatorAcc.nextElement();
            sab.getEJBRef().remove();
        }//insert for newOperator
        KeyGeneratorAccessBean gen = new KeyGeneratorAccessBean();
        Enumeration operatorAcc = ab0.findSuperRegionAccsByOperator(new OperatorKey(operator));
        //Log.debug(3, this, "ProcessCopyOperatorAccessAction : copySuperRegionAcc ", "operatorAcc : " + operatorAcc);
        while (operatorAcc.hasMoreElements()) {
            SuperRegionAccAccessBean sab = (SuperRegionAccAccessBean) operatorAcc.nextElement();
            int accessid = gen.getNextKey("tables.regionsaccess");
            //Log.debug(3, this, "***** ProcessCopyOperatorAccessAction : copySuperRegionAcc ", "new SuperRegionAccAccessBean : " +
	        //"\naccessid = "   + accessid +
	        //"\nnewOperator = "   + newOperator +
	        //"\nrab.getRegionKey().regionid = "   + sab.getSuperregionKey().supregid +
	        //"\nrab.getViewplan() = "   + sab.getViewplan() +
	        //"\nrab.getViewfact() = "   + sab.getViewfact() +
	        //"\nrab.getEditplan() = "   + sab.getEditplan() +
	        //"\nrab.getEditfact() = "   + sab.getEditfact() );
            SuperRegionAccAccessBean ab =
                new SuperRegionAccAccessBean(
                    accessid,
                    newOperator,
                    sab.getSuperregionKey().supregid,
                    sab.getViewplan(),
                    sab.getViewfact(),
                    sab.getEditplan(),
                    sab.getEditfact());
        }
    } catch (javax.ejb.FinderException fe) {
        fe.printStackTrace();
    } catch (javax.naming.NamingException ne) {
        ne.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
/*
* @param ActionMapping mapping
* @param ActionForm form
* @param HttpServletRequest request
* @param HttpServletResponse response
* @throws IOException - something wrong
* @throws ServletException - something wrong
* @return ActionForward
*/
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {

    ActionForward retVal = null;
    ActionErrors errors = new ActionErrors();

    CopyOperatorAccessForm cform = (CopyOperatorAccessForm) form;
    if (mapping.findForward("goback") != null)
        cform.setReturnPage(mapping.findForward("goback").getPath());
    try {
        CopyOperatorAccessForm frm = (CopyOperatorAccessForm) form;
        int operator = frm.getOperator();
        int operatorToCopy = frm.getOperatorToCopy();

        if (operatorToCopy == 0) {
            errors.add(ActionErrors.GLOBAL_ERROR, 
	        new ActionError("error.operator.copy.operatorToCopyNull", "ggg", "gopa"));
        } else {
            copySuperRegionAcc(operatorToCopy, operator);
            copyRegionAcc(operatorToCopy, operator);
            copyRoles(operatorToCopy, operator);
        }
    } catch (Exception e) {
        throw new ServletException(e);
    }

    //process errors
    if (!errors.empty()) {
        saveErrors(request, errors);
        retVal = mapping.findForward("error");
    } else {
        retVal = mapping.findForward("success");
    }
    return retVal;

    //ParamsParser.setState(request, Applications.SECURITY, APPStates.ACCRIGHTCPY);
    //return mapping.findForward("main");
}
}
