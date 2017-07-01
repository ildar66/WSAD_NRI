package com.hps.july.jdbcpersistence.lib;

import javax.servlet.*;
import javax.naming.*;
import com.hps.july.journal.beans.*;
import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.basestation.valueobject.Position_BaseStation;
/**
 * Action, используемый для удаления сложных объектов с журналированием и поддержкой транзакций.
 * Creation date: (06.06.2003 14:31:43)
 * @author: Alexander Shrago
 */
public class AbstractJournalTransProcessAction extends com.hps.july.web.util.AbstractProcessAction {
/**
 * Удаление объекта с записью в журнал.
 * Creation date: (06.06.2003 14:35:49)
 * @param bean javax.ejb.EJBObject
 */
public void deleteObject(javax.ejb.EJBObject bean) throws Exception {
    DebugSupport.printlnTest("deleteObject started");
    String type = "unknown";
    try {
        JournalAccessBean jb = new JournalAccessBean();

        if (bean instanceof Position) {
            DebugSupport.printlnTest("deleteObject type=Position");
            type = "Position";
            jb.removePosition(((Position) bean).getStorageplace());
            DebugSupport.printlnTest("deleteObject type=Position after removePosition");

        } else if (bean instanceof Antenna) {
            type = "Antenna";
            jb.removeAntenna(((Antenna) bean).getIdanten());

        } else if (bean instanceof Sector) {
            type = "Sector";
            jb.removeSector(((Sector) bean).getIdsect());
        } else if (bean instanceof PositionResponsibleWorkers) {
            type = "Wrkresp";
            jb.removeWorkresponsible(((PositionResponsibleWorkers) bean).getTypeKey().responsibilityType, 
	            ((PositionResponsibleWorkers) bean).getPositionKey().storageplace,
	            ((PositionResponsibleWorkers) bean).getResptype());
        } else if (
            bean instanceof BaseStation) {
            DebugSupport.printlnTest("deleteObject type=BaseStation");
            type = "BaseStation";
            jb.removeBasestation(((BaseStation) bean).getStorageplace());
            DebugSupport.printlnTest(
                "deleteObject type=BaseStation after removeBaseStation");
        } else if (
            bean instanceof Position_BaseStation) {
            DebugSupport.printlnTest("deleteObject type=BaseStation");
            type = "BaseStation";
            jb.removeBasestation(((Position_BaseStation) bean).getBaseStation().getStorageplace()   );
            DebugSupport.printlnTest(
                "deleteObject type=BaseStation after removeBaseStation");
        } else {
            bean.remove();
        }
        DebugSupport.printlnTest("deleteObject type=" + type);
    } catch (Exception e) {
        DebugSupport.printlnError(
            e,
            "AbstractJournalProcessAction deleteObject " + type);
        throw e;
    }
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws java.io.IOException,  ServletException {

    try {

	    /* DD
        StateManager st =
            (StateManager) request.getSession().getAttribute(
                AppConstants.PARAM_STATE_MANAGER);
        */

        ActionForward frw = null;
        //EquipmentPForm eForm = (EquipmentPForm) form;
        
        frw = super.perform(mapping, form, request, response);

        /*
        if (frw.equals(mapping.findForward("success"))
            && StateManager.hasReturnHref(request)) {

            StateManager.redirectToReturnPage(request, response);
            return null;

        }
        */
        
        return frw;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw new ServletException(e);
    }

}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processDelete(
    HttpServletRequest request,
    ActionErrors errors,
    EditForm editForm)
    throws Exception {

    DebugSupport.printlnTest(
        "AbstractJournalTransProcessAction procesDelete started");

    AbstractEntityAccessBean bean = null;
    bean = editForm.getDataBean(request);
    bean.refreshCopyHelper();

    if (!request.getRemoteHost().equals("127.0.0.1")) {
        Context ctx = new InitialContext();
        javax.transaction.UserTransaction t1 =
            (javax.transaction.UserTransaction) ctx.lookup("jta/usertransaction");

        try {
            t1.begin();
            DebugSupport.printlnTest("AbstractJournalTransProcessAction procesDelete 1");
            DebugSupport.printlnTest(
                "AbstractJournalTransProcessAction editForm=" + editForm);
            editForm.beforeDelete(bean, request);
            DebugSupport.printlnTest("AbstractJournalTransProcessAction procesDelete before deleteObject");
            deleteObject(bean.getEJBRef());

            t1.commit();
        } catch (Exception e) {
            DebugSupport.printlnError(e);
	        //DebugSupport.printlnTest("!!!!Error before rollback");
            try { t1.rollback(); } catch(IllegalStateException ise) {} catch(Exception re) { re.printStackTrace(System.out); }
            //DebugSupport.printlnTest("!!!!Error after rollback started");
            //DebugSupport.printlnTest("!!!!Error finished");
            //throw new UpdateValidationException(e.getMessage());
            throw e;
        }
    } else {
        editForm.beforeDelete(bean, request);
        deleteObject(bean.getEJBRef());
    }
    editForm.afterDelete(request);
    return null;

}
}
