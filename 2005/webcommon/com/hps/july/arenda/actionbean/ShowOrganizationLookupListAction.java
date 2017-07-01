package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.valueobject.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.arenda.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.arenda.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
/**
 * Action-class.
 * ƒействие дл€ "ѕоиск организаций".
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowOrganizationLookupListAction extends com.hps.july.web.util.LookupBrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	OrganizationAccessBean bean = (OrganizationAccessBean) o;
	OrganizationValueObject valueObject = new OrganizationValueObject(bean);
	
	try {
		// если один рассчетный счет, то его показывать
		int count = 0;
		AccountAccessBean account = null;
		
		java.util.Enumeration e = (new AccountAccessBean()).findAccountByOrganization(new OrganizationKey(bean.getOrganization()));
		while (e.hasMoreElements()) {
			if (++count > 1) {
				valueObject.setAccount(null);
				break;
			}
			valueObject.setAccount((AccountAccessBean) e.nextElement());
		}
		
	} catch (Exception ex) {
		ex.printStackTrace();
		valueObject.setAccount(null);
	}
	
	return valueObject;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.OrganizationAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.ORG_LOOKUP);
/**		
		OrganizationLookupListForm oform = (OrganizationLookupListForm) form;
    	try {
	    	SearchGroupAccessBean groupBean = new SearchGroupAccessBean();
 	 		groupBean.setInitKey_searchgroup(oform.getGroup().intValue());
 	 		groupBean.refreshCopyHelper();
			oform.setGroupname(groupBean.getName());
	    } catch (Exception e) {
		    e.printStackTrace();
		    oform.setGroup(new Integer(0));
 	 		oform.setGroupname("");
    	}

    	try {
	    	SearchGrouppingAccessBean grouppingBean = new SearchGrouppingAccessBean();
 	 		grouppingBean.setInitKey_searchGroupping(oform.getGroupping().intValue());
 	 		grouppingBean.refreshCopyHelper();
			oform.setGrouppingname(grouppingBean.getName());
	    } catch (Exception e) {
		    e.printStackTrace();
		    oform.setGroupping(new Integer(0));
 	 		oform.setGrouppingname("");
    	}
*/	    
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
