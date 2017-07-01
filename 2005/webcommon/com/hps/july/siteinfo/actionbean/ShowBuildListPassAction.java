package com.hps.july.siteinfo.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.siteinfo.*;
import com.hps.july.siteinfo.valueobject.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.siteinfo.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик формы параметров создания списка прохода
 */
public class ShowBuildListPassAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	try{
		return new PhotoListValueobject((PhotoAccessBean)o);
	}catch(Exception e){
		System.out.println("Error in ShowPhotoListAction.constructRowModelBean");
		e.printStackTrace(System.out);
		return o;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.PhotoAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    ParamsParser.setState(request, Applications.SITEINFO, APPStates.BUILDLISTPASS);
    //System.out.println(((BuildListPassForm)form).toString());
    request.setAttribute( "browseList", new Object[]{} );
    request.setAttribute( "numberOfPages", new Integer(0) );

    // Check if we have listpass
    ListPassWordUploadAction lua = new ListPassWordUploadAction();
    int docTypeCode = com.hps.july.util.AppUtils.getNamedValueInt(lua.getDocType());
    BuildListPassForm aform = (BuildListPassForm)form;
    aform.setHaveWordDoc(lua.findDocumentDate(aform.getStorageplace(), docTypeCode, new java.sql.Date(new java.util.Date().getTime())) != 0);
    
    navigate(mapping, form, request, response);
    
    return mapping.findForward("main");
}
}
