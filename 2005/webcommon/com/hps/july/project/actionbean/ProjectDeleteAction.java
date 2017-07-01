package com.hps.july.project.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.naming.*;
import javax.ejb.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;
 
/**
 * Действие по удалению проекта.
 * Creation date: (15.01.2003 14:35:59)
 * @author: Alexander Shrago
 */
public class ProjectDeleteAction
    extends com.hps.july.web.util.AbstractProcessAction {
public ActionForward processDelete(
    HttpServletRequest request,
    ActionErrors errors,
    EditForm editForm)
    throws Exception {
    AbstractEntityAccessBean bean = null;
    bean = editForm.getDataBean(request);
    bean.refreshCopyHelper();

    if (!request.getRemoteHost().equals("127.0.0.1")) {
        Context ctx = new InitialContext();
        javax.transaction.UserTransaction t1 =
            (javax.transaction.UserTransaction) ctx.lookup("jta/usertransaction");

        try {
            t1.begin();

            editForm.beforeDelete(bean, request);
            bean.getEJBRef().remove();

            t1.commit();
        } catch (Exception e) {
            t1.rollback();
            com.hps.july.project.Util_Alex.pr(e, "processDelete", this);
            throw e;
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
            BeanUtils.copyProperties(bean, editForm);
            //System.out.println("AbstractProcessAction: AFTER COPY PROPERTIES");
            editForm.beforeUpdate(bean, request);
            bean.commitCopyHelper();
            editForm.afterUpdate(bean, request);

            t1.commit();
        } catch (Exception e) {
            t1.rollback();
            com.hps.july.project.Util_Alex.pr(e, "processInsert", this);
            throw e;
        }
    } else {
        bean = editForm.constructBean(request);
        //System.out.println("AbstractProcessAction: BEFORE COPY PROPERTIES");
        BeanUtils.copyProperties(bean, editForm);
        //System.out.println("AbstractProcessAction: AFTER COPY PROPERTIES");
        editForm.beforeUpdate(bean, request);
        bean.commitCopyHelper();
        editForm.afterUpdate(bean, request);
    }

    return null;
}
}
