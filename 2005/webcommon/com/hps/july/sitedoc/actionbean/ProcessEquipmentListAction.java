package com.hps.july.sitedoc.actionbean;

import java.lang.reflect.*;
import java.util.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.sitedoc.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.sitedoc.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Обработчик списка оборудования
 * Связывает отмеченное оборудование с документом
 */
public class ProcessEquipmentListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (06.07.2003 18:58:21)
 * @return boolean
 * @param request javax.servlet.http.HttpServletRequest
 */
private void addEquipments(HttpServletRequest request) throws Exception {

    Sitedoc2SplaceAccessBean bean = null;
    SiteDocForm docForm =
        (SiteDocForm) request.getSession().getAttribute("SiteDocForm");
    int sitedoc = docForm.getSitedoc();
    int id;
    Position pos = null;
    PositionAccessBean posBean = null;
    String[] params = request.getParameterValues("check_add");
    if(params==null)return;
    for (int i = 0; i < params.length; i++) {
        id = Integer.parseInt(params[i]);
        bean = new Sitedoc2SplaceAccessBean(sitedoc, id);
        //addPositionByEquipment(id, request);

    }
    //ParamsParser.setState(request, Applications.SITEDOC, APPStates.SiteDocForm);
    //return mapping.findForward("main");

}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2003 13:55:20)
 * @return com.hps.july.persistence.Position
 * @param id int
 */
private void addPositionByEquipment(int id, HttpServletRequest request)
    throws Exception {
    try {
        StoragePlaceAccessBean stBean = new StoragePlaceAccessBean();
        stBean.setInitKey_storageplace(id);
        stBean.refreshCopyHelper();
        Position position = null;

        SiteDocForm docForm =
            (SiteDocForm) request.getSession().getAttribute("SiteDocForm");
        int sitedoc = docForm.getSitedoc();

        if (stBean.getEJBRef() instanceof BaseStation) {
            position = ((BaseStation) stBean.getEJBRef()).getPosition();
        } else if (stBean.getEJBRef() instanceof EquipmentSet) {
            position = ((EquipmentSet) stBean.getEJBRef()).getPosition();
        }
        Sitedoc2SplaceAccessBean link = new Sitedoc2SplaceAccessBean();

        try {
            link.setInitKey_siteDoc_sitedoc(new Integer(sitedoc));
            link.setInitKey_storagePlace_storageplace(
                new Integer(position.getStorageplace()));
            link.refreshCopyHelper();
        } catch (javax.ejb.FinderException e) {
            link = new Sitedoc2SplaceAccessBean(sitedoc, position.getStorageplace());

        }

    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.sitedoc.valueobject.EquipmentObject";
}
public int getRowsOnPage() {
	try {
		NamedValueAccessBean v = new NamedValueAccessBean();
		v.setInitKey_id("SiteListPageLenght");
		v.refreshCopyHelper();
		return v.getIntvalue();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return super.getRowsOnPage();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2003 18:58:21)
 * @return boolean
 * @param request javax.servlet.http.HttpServletRequest
 */
private boolean isAddEquipments(HttpServletRequest request) {

    Enumeration enum = request.getParameterNames();
    String submitName = "submit_add";
    String name = null;
    while (enum.hasMoreElements()) {
        name = (String) enum.nextElement();
        DebugSupport.println("parameter " + name);
        if (name.length() > submitName.length()
            && name.substring(0, submitName.length()).equals(submitName)) {
            DebugSupport.println("isAddEquipments true");
            return true;
        }
    }
    DebugSupport.println("isAddEquipments false");
    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2003 18:58:21)
 * @return boolean
 * @param request javax.servlet.http.HttpServletRequest
 */
private boolean isAddPositions(HttpServletRequest request) {

    Enumeration enum = request.getParameterNames();
    String submitName = "submit_add";
    String name = null;
    while (enum.hasMoreElements()) {
        name = (String) enum.nextElement();
        DebugSupport.println("parameter " + name);
        if (name.length() > submitName.length()
            && name.substring(0, submitName.length()).equals(submitName)) {
            DebugSupport.println("isAddPosition true");
            return true;
        }
    }
    DebugSupport.println("isAddPosition false");
    return false;
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	try {
		if (isAddEquipments(request)) {
			addEquipments(request);
			ParamsParser.setState(request, Applications.SITEDOC, APPStates.SiteDocForm);
			return mapping.findForward("success");
		} else {
			SiteDocEquipmentListForm pForm = (SiteDocEquipmentListForm) form;
			pForm.checkRequest(request);
			super.perform(mapping, form, request, response);
			ParamsParser.setState(request, Applications.SITEDOC, APPStates.SiteDocEquipmentListForm);
        }

        return mapping.findForward("main");
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw new ServletException(e);

    }

}
}
