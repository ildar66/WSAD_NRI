package com.hps.july.dictionary.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.dictionary.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.dictionary.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик формы списка истории курсов валют
 */
public class ShowCurrateHListAction
	extends BrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.RateAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState( request, Applications.DICTIONARY, APPStates.CRTHLIST );
	  	CurrateHListForm oform = (CurrateHListForm) form;
	  	try {
	  		CurrencyAccessBean bean = new CurrencyAccessBean();
	  		bean.setInitKey_currency(oform.getCurrency());
	  		bean.refreshCopyHelper();
		    oform.setCurrencyname(bean.getName());
	  	} catch (Exception e) {
		    oform.setCurrency(0);
		    oform.setCurrencyname("");
	  	}
	  	try {
		  	RateTypeAccessBean bean = new RateTypeAccessBean();
		  	bean.setInitKey_ratetype(oform.getRatetype());
		  	bean.refreshCopyHelper();
            oform.setRatetypename(bean.getName() + " (" + bean.getBasecurrency().getShortname() + ")");
	  	} catch (Exception e) {
		  	oform.setRatetype(0);
		  	oform.setRatetypename("");
	  	}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
