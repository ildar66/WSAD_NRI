package com.hps.july.inventory.actionbean;

import com.hps.july.persistence.*;
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
 * Обработчик формы "Акты рассогласования", шапка документа.
 * При удалении выполняет дополнительное удаление связанных с документом данных
 * которые не удаляются автоматически.
 */
public class MismatchProcessAction
	extends com.hps.july.web.util.AbstractProcessAction
{
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ActionForward retVal = null;	
	    ActionErrors errors = new ActionErrors();
  		EditForm editForm = (EditForm)form;
		if( editForm.getAction().equals("Delete") ) {
	    	try {
		    	AbstractEntityAccessBean abean = editForm.getDataBean(request);
		    	if(abean != null) {
					InwayBillAccessBean bean = (InwayBillAccessBean)abean;
					bean.refreshCopyHelper();
					InWayBillBLOBAccessBean blob = new InWayBillBLOBAccessBean();
					blob.setInitKey_document(bean.getDocument());
					blob.refreshCopyHelper();
					blob.setDActText(null);
					blob.setDActTextFileName(null);
					blob.commitCopyHelper();
					bean.setDActDate(null);
					bean.setDActNumber(null);
					bean.setDActRepresentative(null);
					bean.setDActStorManager(null);
					bean.setDActTechStuf(null);
					bean.commitCopyHelper();
	 		   	}
	    	} catch(Exception e) {
			    e.printStackTrace(System.out);
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mismatch.clear"));
	    	}
			retVal = mapping.findForward( "success" );
		    if( !errors.empty() ) {
		 	  	saveErrors(request, errors);
		  	    ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
		  	    retVal = mapping.findForward( "main" ); 
		    }
		} else {
			retVal = super.perform(mapping, form, request, response);
		}
	    return retVal;    
	}
}
