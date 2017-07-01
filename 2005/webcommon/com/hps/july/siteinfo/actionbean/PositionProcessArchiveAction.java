package com.hps.july.siteinfo.actionbean;

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
import com.hps.july.persistence.PositionAccessBean;
import com.hps.july.siteinfo.valueobject.Position;
import com.hps.july.siteinfo.formbean.*;
 
/**
 * Обработчик перевода позиции в архив
 * Creation date: (21.05.2003 12:59:41)
 * @author: Alexander Shrago
 * @deprecated
 */
public class PositionProcessArchiveAction
	extends Action
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
/*SA: Закоментированно ввиду того что удаляются состояния План/Факт. Возможность отправки в архив будет не нужна.

	ActionForward retVal = null;
	ActionErrors errors = new ActionErrors();

	//is canceled
	if (isCancelled(request)) {
		return mapping.findForward("success");
	}

	//process actions
	PositionAccessBean bean = null;
	PositionForm editForm = (PositionForm) form;
	if (editForm != null) {
		try {
			bean = (PositionAccessBean) editForm.getDataBean(request);
			bean.setPlanstate(Position.PLANSTATE_CHECK_Archive);
            bean.commitCopyHelper();
            retVal = mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace(System.out);
			ErrorProcessor.processException(errors, e);
			ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
			retVal = mapping.findForward("main");
        }

        //process errors
		if (!errors.empty()) {
			saveErrors(request, errors);
			ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
			retVal = mapping.findForward("main");
		}
	} else {
		System.out.println("WEB.UTIL.ERROR: edit form is NULL");
		retVal = mapping.findForward("success");
    }
*/
    return mapping.findForward("success");
}
}
