package com.hps.july.sitedoc.actionbean;

import javax.servlet.ServletException;
import java.io.IOException;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import javax.naming.*;
import org.apache.struts.util.PropertyUtils;
import com.hps.july.sitedoc.formbean.*;

/**
 * Обработчик формы редактирования документа
 */
public class ProcessSiteDocAction
	extends com.hps.july.web.util.AbstractProcessAction // SuccessProcessAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	ActionForward frw = super.perform(mapping, form, request, response);
/*
	if(frw != null) {
System.out.println("PSD.perform: FRW1:"+frw.getName());
	} else {
System.out.println("PSD.perform: FRW1:NULL");
	}

	SiteDocForm dForm = (SiteDocForm) form;

System.out.println("PSD.perform: Action:"+dForm.getAction()+", ERROR_KEY:"+request.getAttribute(ERROR_KEY));
	if (dForm.getAction().equals("Add") && request.getAttribute(ERROR_KEY) == null) {
		dForm.setAction("Edit");
		frw = mapping.findForward("edit");
	}

	if(frw != null) {
System.out.println("PSD.perform: FRW1:"+frw.getName());
	} else {
System.out.println("PSD.perform: FRW1:NULL");
	}
*/
	return frw;
}
public ActionForward processDelete(
    HttpServletRequest request,
    ActionErrors errors,
    EditForm editForm)
    throws Exception {
    AbstractEntityAccessBean bean = null;
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
public ActionForward processInsert(ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm)
    throws Exception
{
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
			try { t1.rollback(); } catch(IllegalStateException ise) {} catch(Exception re) { re.printStackTrace(System.out); }
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

	if (request.getAttribute(ERROR_KEY) == null) {
		editForm.setAction("Edit");
		return mapping.findForward("edit");
	} else {
	    return null;
	}
}
}
