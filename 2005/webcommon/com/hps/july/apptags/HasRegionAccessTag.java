package com.hps.july.apptags;

import com.hps.july.persistence.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.http.*;
import javax.servlet.jsp.JspException;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Таг для проверки прав доступа пользователя к региону, 
 * используется при проверке прав доступа.
 * Creation date: (09.02.2003 19:49:45)
 * @author: Alexander Shrago
 */
public class HasRegionAccessTag extends HasAccessTag implements DefaultAccessCheck {
    
 public static final String ACTION_EDIT="Edit";
 public static final String ACTION_ADD="Edit";
 public static final String ACTION_VIEW="View";
 public static final String ACTION_ALL=SearchConstants.SEARCH_ALL;
  
	private String position;
    private String action;
public int doStartTag() throws JspException {
    try {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        if (!hasAccess(request, getPosition(), getAction())) {
            return SKIP_BODY;
        } else
            return getHref() == null ? EVAL_BODY_INCLUDE : super.doStartTag();
    } catch (Exception e) {
        throw new JspException(e.getMessage());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (12.05.2003 8:35:30)
 * @return java.lang.String
 */
public java.lang.String getAction() {
	return action==null?"Edit":"action";
}
/**
 * Insert the method's description here.
 * Creation date: (12.05.2003 8:35:30)
 * @return java.lang.String
 */
public java.lang.String getPosition() {
	return position;
}
public static boolean hasAccess(HttpServletRequest request, String positionStr, String action)
	throws Exception
{
	return hasAccess(request, positionStr, action, "2");
}
/**
 * Insert the method's description here.
 * Creation date: (11.05.2003 20:37:29)
 * @return boolean
 * @param request javax.servlet.http.HttpServletRequest
 * @param baseStation com.hps.july.persistence.BaseStationAccessBean
 */
public static boolean hasAccess(HttpServletRequest request, String positionStr, String action, String planstate)
    throws Exception
{
//	DebugSupport.printlnTest("HasAccessTag hasAccess started position="+positionStr+" action="+action+" planstate="+planstate);  
//	boolean canFact = !planstate.equals(com.hps.july.siteinfo.valueobject.Position.PLANSTATE_CHECK_Plan);
//	boolean canPlan = !planstate.equals(com.hps.july.siteinfo.valueobject.Position.PLANSTATE_CHECK_Fact);
//	DebugSupport.printlnTest("planstate="+planstate+" canFact=" + canFact + " canPlan=" + canPlan);

	if (request.isUserInRole("administrator")) {
		return true;
	}
	if(!"Edit".equals(action)) {
		action = "View";
	}
	try {
        int positionId = Integer.parseInt(positionStr);
		PositionAccessBean position = new PositionAccessBean();
		position.setInitKey_storageplace(positionId);
		position.refreshCopyHelper();

		return isRegionAccessible(position.getRegionKey().regionid,action,request.getRemoteUser(),false);
/*
		OperatorAccessBean operator = new OperatorAccessBean().findByLogin(request.getRemoteUser());

		
		RegionAccAccessBeanTable table = new RegionAccAccessBeanTable();
		table.setRegionAccAccessBean(new RegionAccAccessBean().findRegionAccsByOperator((OperatorKey) operator.__getKey()));
		for (int i = 0; i < table.numberOfRows(); i++) {
			if(table.getRegionAccAccessBean(i).getRegionKey().regionid == position.getRegionKey().regionid
                &&
                (
					(action.equals("Edit") && table.getRegionAccAccessBean(i).getEditfact())
					||
					(action.equals("View") && (table.getRegionAccAccessBean(i).getEditfact() && table.getRegionAccAccessBean(i).getViewfact()))
				)
			) {
//				DebugSupport.printlnTest("HasAccessTag hasAccess return true 1");
				return true;
			}
        }
		SuperRegionAccAccessBeanTable table1 = new SuperRegionAccAccessBeanTable();
        table1.setSuperRegionAccAccessBean(new SuperRegionAccAccessBean().findSuperRegionAccsByOperator((OperatorKey) operator.__getKey()));
		for (int i = 0; i < table1.numberOfRows(); i++) {
			if (table1.getSuperRegionAccAccessBean(i).getSuperregionKey().supregid == position.getRegion().getSuperregionKey().supregid
                &&
                (
					(action.equals("Edit") && table1.getSuperRegionAccAccessBean(i).getEditfact())
					||
					(action.equals("View") && (table1.getSuperRegionAccAccessBean(i).getEditfact() || table1.getSuperRegionAccAccessBean(i).getViewfact()))
                )
			) {
//				DebugSupport.printlnTest("HasAccessTag hasAccess return true 2");
				return true;
            }
        }
//		DebugSupport.printlnTest("HasAccessTag hasAccess return false");
		return false;
*/
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		throw e;
	}
}
public static boolean hasAccessRegion(HttpServletRequest request, String regionIdStr, String action)
	throws Exception
{
	return hasAccessRegion(request, regionIdStr, action, SearchConstants.SEARCH_ALL);
}
public static boolean hasAccessRegion(HttpServletRequest request, String regionIdStr, String action, String planstate)
	throws Exception
{
	try {
		int regionId = Integer.parseInt(regionIdStr);
		return isRegionAccessible(regionId,action,request.getRemoteUser(),request.isUserInRole("administrator"));
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
	/*
	if (request.isUserInRole("administrator")) {
		return true;
	}
	if(!"Edit".equals(action)) {
		action = "View";
	}
	try {
		int regionId = Integer.parseInt(regionIdStr);

		RegionAccessBean region = new RegionAccessBean();
		region.setInitKey_regionid(regionId);
		region.refreshCopyHelper();

		OperatorAccessBean operator = new OperatorAccessBean().findByLogin(request.getRemoteUser());

		RegionAccAccessBeanTable table = new RegionAccAccessBeanTable();
		table.setRegionAccAccessBean(new RegionAccAccessBean().findRegionAccsByOperator((OperatorKey) operator.__getKey()));
		for (int i = 0; i < table.numberOfRows(); i++) {
			if (table.getRegionAccAccessBean(i).getRegionKey().regionid == regionId
                && (
	                (action.equals("Edit") && table.getRegionAccAccessBean(i).getEditfact())
					||
					(action.equals("View") && (table.getRegionAccAccessBean(i).getEditfact() || table.getRegionAccAccessBean(i).getViewfact()))
				)
			) {
//				DebugSupport.printlnTest("HasRegionAccessTag hasAccess return true 1");
				return true;
			}
        }
        SuperRegionAccAccessBeanTable table1 = new SuperRegionAccAccessBeanTable();
        table1.setSuperRegionAccAccessBean(new SuperRegionAccAccessBean().findSuperRegionAccsByOperator((OperatorKey) operator.__getKey()));
		for (int i = 0; i < table1.numberOfRows(); i++) {
			if(table1.getSuperRegionAccAccessBean(i).getSuperregionKey().supregid == region.getSuperregionKey().supregid
				&& (
					(action.equals("Edit") && table1.getSuperRegionAccAccessBean(i).getEditfact())
					||
					(action.equals("View") && (table1.getSuperRegionAccAccessBean(i).getEditfact() || table1.getSuperRegionAccAccessBean(i).getViewfact()))
				)
			) {
//				DebugSupport.printlnTest("HasRegionAccessTag hasAccess return true 2");
				return true;
			}
        }
        DebugSupport.printlnTest("HasRegionAccessTag hasAccess return false");
        return false;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
    */
}
public static boolean isRegionAccessible(int regionid, String action, String username, boolean admin)
	throws Exception
{
	if (admin) {
		return true;
	}
	if(!"Edit".equals(action)) {
		action = "View";
	}
	try {
		RegionAccessBean region = new RegionAccessBean();
		region.setInitKey_regionid(regionid);
		region.refreshCopyHelper();

		OperatorAccessBean operator = new OperatorAccessBean().findByLogin(username);

		RegionAccAccessBeanTable table = new RegionAccAccessBeanTable();
		table.setRegionAccAccessBean(new RegionAccAccessBean().findRegionAccsByOperator((OperatorKey) operator.__getKey()));
		for (int i = 0; i < table.numberOfRows(); i++) {
			if (table.getRegionAccAccessBean(i).getRegionKey().regionid == regionid
                && (
	                (action.equals("Edit") && table.getRegionAccAccessBean(i).getEditfact())
					||
					(action.equals("View") && (table.getRegionAccAccessBean(i).getEditfact() || table.getRegionAccAccessBean(i).getViewfact()))
				)
			) {
//				DebugSupport.printlnTest("HasRegionAccessTag hasAccess return true 1");
				return true;
			}
        }
        SuperRegionAccAccessBeanTable table1 = new SuperRegionAccAccessBeanTable();
        table1.setSuperRegionAccAccessBean(new SuperRegionAccAccessBean().findSuperRegionAccsByOperator((OperatorKey) operator.__getKey()));
		for (int i = 0; i < table1.numberOfRows(); i++) {
			if(table1.getSuperRegionAccAccessBean(i).getSuperregionKey().supregid == region.getSuperregionKey().supregid
				&& (
					(action.equals("Edit") && table1.getSuperRegionAccAccessBean(i).getEditfact())
					||
					(action.equals("View") && (table1.getSuperRegionAccAccessBean(i).getEditfact() || table1.getSuperRegionAccAccessBean(i).getViewfact()))
				)
			) {
//				DebugSupport.printlnTest("HasRegionAccessTag hasAccess return true 2");
				return true;
			}
        }
//		DebugSupport.printlnTest("HasRegionAccessTag hasAccess return false");
        return false;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (12.05.2003 8:35:30)
 * @param newAction java.lang.String
 */
public void setAction(java.lang.String newAction) {
	action = newAction;
}
/**
 * Insert the method's description here.
 * Creation date: (12.05.2003 8:35:30)
 * @param newPosition java.lang.String
 */
public void setPosition(java.lang.String newPosition) {
	position = newPosition;
}
}
