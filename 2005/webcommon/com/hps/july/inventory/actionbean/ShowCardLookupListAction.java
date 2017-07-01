package com.hps.july.inventory.actionbean;

import com.hps.july.jdbcpersistence.lib.TimeCounter;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.inventory.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.inventory.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик формы выбора оборудования по карточкам
 */
public class ShowCardLookupListAction extends LookupBrowseAction {
/*
 * return's inside var
 */
public boolean fillAgregate(CardLookupListForm oform) {
	boolean inside = false;
  	try {
	  	StorageCardAccessBean eq = new StorageCardAccessBean();
	  	eq.setInitKey_storagecard(oform.getAgregate().intValue());
	  	eq.refreshCopyHelper();
	  	String name = eq.getResource().getName();
	  	if(eq.getResource().getModel() != null) {
		  	name += ", " + eq.getResource().getModel();
	  	}
	  	if(eq.getConfiguration() != null) {
		  	name += ", " + eq.getConfiguration();
	  	}
	  	if(eq.getResource().getNotes() != null) {
		  	name += ", " + eq.getResource().getNotes();
	  	}
	  	name += "; S/N:"+eq.getSerialnumber();
	  	oform.setAgregatename(name);
	  	inside = true;
  	} catch(Exception e) {
	  	oform.setAgregatename("");
  	}
  	return inside;
}
public void fillManufacturer(CardLookupListForm oform) {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		bean.setInitKey_organization(oform.getManufacturer().intValue());
		bean.refreshCopyHelper();
		oform.setManufacturername(bean.getName());
	} catch (Exception e) {
	    oform.setManufacturername("");
  	}
}
public void fillOwner(CardLookupListForm form)
{
	if(form.getOwner() != null) {
		try {
			OrganizationAccessBean org = new OrganizationAccessBean();
			org.setInitKey_organization(form.getOwner().intValue());
			org.refreshCopyHelper();
			form.setOwnername(org.getName());
		} catch(Exception e) {
			form.setOwnername("?");
		}
	}
}
public void fillResource(CardLookupListForm oform) {
  	try {
	  	ResourceAccessBean r = new ResourceAccessBean();
	  	r.setInitKey_resource(oform.getResource().intValue());
	  	r.refreshCopyHelper();
	  	oform.setResourcename(r.getName());
	  	oform.setPolicy(r.getCountpolicy());
  	} catch(Exception e) {
	  	oform.setResourcename("");
  	}
}
public void fillResourcetypes(CardLookupListForm oform) {
  	if(oform.getResourcesubtype() != null) {
	  	try {
	  		ResourceSubTypeAccessBean bean = new ResourceSubTypeAccessBean();
	  		bean.setInitKey_resourcesubtype(oform.getResourcesubtype().intValue());
	  		bean.refreshCopyHelper();
		    oform.setResourcesubtypename(bean.getName());
		    ResourceTypeAccessBean restype = bean.getResourcetype();
		    oform.setResourcetype(new Integer(restype.getResourcetype()));
		    oform.setResourcetypename(restype.getName());
	  	} catch (Exception e) {
		    oform.setResourcesubtypename("");
	  	}
	} else {
	  	try {
	  		ResourceTypeAccessBean bean = new ResourceTypeAccessBean();
	  		bean.setInitKey_resourcetype(oform.getResourcetype().intValue());
	  		bean.refreshCopyHelper();
		    oform.setResourcetypename(bean.getName());
	  	} catch (Exception e) {
		    oform.setResourcetypename("");
	  	}
	}
}
public void fillStoragePlace(CardLookupListForm oform) {
  	try {
  		StoragePlaceAccessBean bean = new StoragePlaceAccessBean();
		bean.setInitKey_storageplace(oform.getStorage().intValue());
		bean.refreshCopyHelper();
	    oform.setStoragename(bean.getName());
	    if(bean.getEJBRef() instanceof Storage) {
		  	oform.setStoragetype("S");
	    } else
	    if(bean.getEJBRef() instanceof EquipmentSet) {
		  	oform.setStoragetype("Q");
		  	try {
			  	EquipmentSetAccessBean e = new EquipmentSetAccessBean(bean.getEJBRef());
			  	e.refreshCopyHelper();
			  	PositionAccessBean p = e.getPosition();
			  	String pname = "";
				if(p.getGsmid() != null) {
					pname += "D"+p.getGsmid()+" ";
				}
				if(p.getDampsid() != null) {
					pname += "A"+p.getDampsid()+" ";
				}
				pname += p.getName();
				pname += " / " + com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(e);
				oform.setStoragename(pname);
		  	} catch(Exception e) {
		  	}
	    } else
	    if(bean.getEJBRef() instanceof Expedition) {
		  	oform.setStoragetype("E");
		  	try {
				ExpeditionAccessBean exp = new ExpeditionAccessBean();
				exp.setInitKey_storageplace(oform.getStorage().intValue());
				exp.refreshCopyHelper();
				if(exp.getExpeditor() != null) {
					oform.setStoragename(exp.getExpeditor().getMan().getFullName());
				} else
				if(exp.getOrganization() != null) {
					oform.setStoragename(exp.getOrganization().getName());
				} 
		  	} catch (Exception e) {
		  	}
	    }
  	} catch (Exception e) {
  	}
}
public java.lang.String getBrowseBeanName() {
//	return "com.hps.july.persistence.StorageCardAccessBean";
	return "com.hps.july.cdbc.objects.CDBCStoragecardsObject";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		TimeCounter tc = new TimeCounter("PERF.INVENTORY.CardLookup");
//		tc.start();
		
	  	CardLookupListForm oform = (CardLookupListForm)form;

	  	ParamsParser.setState( request, Applications.INVENTORY, oform.getAppState());

	  	oform.setStoragetype(null);
	    fillStoragePlace(oform);
	    oform.setIsInside(fillAgregate(oform));
	    fillResource(oform);
	    fillResourcetypes(oform);
	    fillManufacturer(oform);
	    fillOwner(oform);
	    if(oform.getResource() != null && (oform.getPagetype() == null || "".equals(oform.getPagetype()))) {
		    if("S".equals(oform.getPolicy())) {
			    oform.setPagetype("2");
		    } else
		    if("P".equals(oform.getPolicy()) || "B".equals(oform.getPolicy())) {
			    oform.setPagetype("3");
		    }
	    }
	    if(request.getParameter("pagetype") != null) {
		    oform.setPagetype(request.getParameter("pagetype"));
	    } else {
		    oform.setPagetype("1");
		}
		super.perform( mapping, form, request, response );
//		tc.finish("ACTION");
		return mapping.findForward( "main" );
	}
}
