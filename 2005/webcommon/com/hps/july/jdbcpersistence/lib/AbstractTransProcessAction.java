package com.hps.july.jdbcpersistence.lib;

import javax.naming.*;
//import com.ibm.ejs.ns.CosNaming.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.web.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
/**
 * Action, используемый для добавления/удаления с поддержкой транзакций.
 * Creation date: (18.08.2003 19:56:22)
 * @author: Alexander Shrago
 */
public class AbstractTransProcessAction extends com.hps.july.web.util.AbstractProcessAction {
public ActionForward processDelete(
    HttpServletRequest request,
    ActionErrors errors,
    EditForm editForm)
    throws Exception {
    AbstractEntityAccessBean  bean = null;
    bean = editForm.getDataBean(request);
     bean.refreshCopyHelper();

    if (!request.getRemoteHost().equals("127.0.0.1")) {
        Context  ctx = new InitialContext();
        javax.transaction.UserTransaction t1 =
            (javax.transaction.UserTransaction) ctx.lookup("jta/usertransaction");

        try {
            t1.begin();

            editForm.beforeDelete(bean, request);
            bean.getEJBRef().remove();

            t1.commit();
        } catch (Exception e) {
            t1.rollback();
            com.hps.july.jdbcpersistence.lib.DebugSupport.printlnError(e);
            throw new UpdateValidationException(e.getMessage());
        }
    } else {
        editForm.beforeDelete(bean, request);
        bean.getEJBRef().remove();
    }
    editForm.afterDelete(request);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processInsert(
    HttpServletRequest request,
    ActionErrors errors,
    EditForm editForm)
    throws Exception {
    AbstractEntityAccessBean bean = null;
    editForm.validateValues(errors);

    if (!request.getRemoteHost().equals("127.0.0.1")) {
        Context ctx = new InitialContext();
        javax.transaction.UserTransaction t1 =
            (javax.transaction.UserTransaction) ctx.lookup("jta/usertransaction");

        try {
            t1.begin();

            bean = editForm.constructBean(request);
            //System.out.println("AbstractProcessAction: BEFORE COPY PROPERTIES");
            com.hps.july.util.BeanUtils.copyProperties(bean, editForm);
            //System.out.println("AbstractProcessAction: AFTER COPY PROPERTIES");
            editForm.beforeUpdate(bean, request);
            bean.commitCopyHelper();
            editForm.afterUpdate(bean, request);

            t1.commit();
        } catch (Exception e) {
            t1.rollback();
            com.hps.july.jdbcpersistence.lib.DebugSupport.printlnError(e);
            //com.hps.july.project.Util_Alex.pr(e, "processInsert", this);
            throw e;
        }
    } else {
        bean = editForm.constructBean(request);
        //System.out.println("AbstractProcessAction: BEFORE COPY PROPERTIES");
        com.hps.july.util.BeanUtils.copyProperties(bean, editForm);
        //System.out.println("AbstractProcessAction: AFTER COPY PROPERTIES");
        editForm.beforeUpdate(bean, request);
        bean.commitCopyHelper();
        editForm.afterUpdate(bean, request);
    }

    return null;
}
}
