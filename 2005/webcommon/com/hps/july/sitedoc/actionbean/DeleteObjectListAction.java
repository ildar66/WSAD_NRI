package com.hps.july.sitedoc.actionbean;

import com.hps.july.trailcom.beans.Sitedoc2HopsAccessBean;
import com.hps.july.sitedoc.formbean.*;
import com.hps.july.persistence.*;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.sitedoc.*;
import com.hps.july.constants.Applications;
import com.hps.july.web.util.*;

/**
 * Обработчик удаления связи объектов с документами
 */
public class DeleteObjectListAction 
	extends org.apache.struts.action.Action
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
{
    SiteDocForm dForm = (SiteDocForm) request.getSession().getAttribute("SiteDocForm");
    try {
        if (request.getParameter("objectId") != null) {
            removeLink(request.getParameter("objectId"), dForm.getSitedoc());
        } else if (request.getParameterValues("check_del") != null) {
            String[] params = request.getParameterValues("check_del");
            for (int i = 0; i < params.length; i++) {
                removeLink(params[i], dForm.getSitedoc());
            }
        }
        ParamsParser.setState(request, Applications.SITEDOC, APPStates.SiteDocForm);
        return mapping.findForward("main");
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw new ServletException(e);
    }
}
public void removeHops(int hops, int sitedoc)
	throws Exception
{
	Sitedoc2HopsAccessBean bean = new Sitedoc2HopsAccessBean();
    bean.setInitKey_hop_hopsid(new Integer(hops));
    bean.setInitKey_sitedoc(sitedoc);
    bean.refreshCopyHelper();
    bean.getEJBRef().remove();
}
public void removeLink(String objectid, int sitedoc)
{
	try {
		// convert objectid into pair of TYPE (CHAR(1)) and ID (INTEGER)
		if(objectid == null || objectid.length() < 2) {
			throw new Exception("BAD OBJECTID to REMOVE ["+objectid+"]");
		}
		String ot = objectid.substring(0,1);
		int oi = Integer.parseInt(objectid.substring(1));
		if("H".equals(ot)) {
			try {
				removeHops(oi,sitedoc);
			} catch(javax.ejb.ObjectNotFoundException onfe) {
			}
		} else if("S".equals(ot)) {
			try {
			    int posId = 0;

			    StoragePlaceAccessBean st = new StoragePlaceAccessBean();
			    st.setInitKey_storageplace(oi);
			    st.refreshCopyHelper();

			    if (st.getEJBRef() instanceof EquipmentSet) {
			        posId = ((EquipmentSet) st.getEJBRef()).getPositionKey().storageplace;
			    }
				removeStorageplace(oi,sitedoc,posId);
			} catch(javax.ejb.ObjectNotFoundException onfe) {
			}
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public void removeStorageplace(int storageplace, int sitedoc, int posId)
	throws Exception
{
    Sitedoc2SplaceAccessBean bean = new Sitedoc2SplaceAccessBean();
    bean.setInitKey_storagePlace_storageplace(new Integer(storageplace));
    bean.setInitKey_siteDoc_sitedoc(new Integer(sitedoc));
    bean.refreshCopyHelper();
    bean.getEJBRef().remove();

    if (posId != 0) {

        SiteDocAccessBeanTable table = new SiteDocAccessBeanTable();
        table.setSiteDocAccessBean(
            new SiteDocAccessBean().findByPosition(new Integer(posId), new Integer(1)));

        if (table.numberOfRows() == 0) {
            try {
                bean = new Sitedoc2SplaceAccessBean();
                bean.setInitKey_storagePlace_storageplace(new Integer(posId));
                bean.setInitKey_siteDoc_sitedoc(new Integer(sitedoc));
                bean.refreshCopyHelper();
            } catch (javax.ejb.FinderException e) {
                new Sitedoc2SplaceAccessBean(sitedoc, posId);
            }
        }
    }
}
}
