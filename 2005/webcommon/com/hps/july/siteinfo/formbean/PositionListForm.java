package com.hps.july.siteinfo.formbean;

import com.hps.july.siteinfo.valueobject.RegionsSelector;
import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.basestation.valueobject.BaseStationObject;
import com.hps.july.web.util.*;

/**
 * Форма списка позиций
 */
public class PositionListForm
	extends BrowseForm
{
	private Boolean isGsmId;
	private StringAndIntegerProperty gsmId;
	private Boolean isDampsId;
	private StringAndIntegerProperty dampsId;
	private Boolean isName;
	private String name;
	private Boolean isAddr;
	private String addr;
	private String searchBy;
	private String searchString;
	private int order;
	private StringAndIntegerProperty worker;
	private String workername;
	private Integer organization;
	private String orgname;

	private String posstate;
	/**Ограничитель выбора состояний */
	private int posstatefilter;
	
	private Boolean isWorker;
	private String inaction;

	/**Позиции, отмеченные для показа на карте*/
	private int[] checkEquipment;
	private String showOnmap;
	private String renterSearchType;
	private String orgSearchType;

	/**Мультирегионная выборка*/
	private RegionsSelector regionsSelector = new RegionsSelector();
/*
	private Boolean isAllSupregs;
	private Boolean isAllRegions;
	private Boolean isNetZone;
	private Integer[] supregcodes;
	private Integer[] regioncodes;
	private Integer[] netzonecodes;
*/
	private String remoteUser;
	private boolean admin;

	private int sortorder;

	private Vector supregs;

	public static final int POSSTATE_PE = 0x10;
	public static final int POSSTATE_P = 0x08;
	public static final int POSSTATE_E = 0x04;
	public static final int POSSTATE_D = 0x02;
	public static final int POSSTATE_R = 0x01;
	public static final int POSSTATE_ALL = 0x00;
	private java.lang.String posAndRegs = null;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public PositionListForm() {
	getRegionsSelector().setAllNetzones(true);
	getRegionsSelector().setAllRegions(true);
	getRegionsSelector().setAllSuperregions(true);
    sortorder = 5;
    order = 1;
    worker = new com.hps.july.web.util.StringAndIntegerProperty();
    organization = new java.lang.Integer(0);
    workername = "";
    orgname = "";
    dampsId = new com.hps.july.web.util.StringAndIntegerProperty();
    gsmId = new com.hps.july.web.util.StringAndIntegerProperty();
    dampsId.setInteger(new java.lang.Integer(0));
    gsmId.setInteger(new java.lang.Integer(0));
    name = "";
    addr = "";
    searchBy = "B";
    searchString = "";
    isWorker = java.lang.Boolean.TRUE;
    inaction = com.hps.july.siteinfo.valueobject.Position.INACTION_All;
    checkEquipment = new int[0];
    renterSearchType = com.hps.july.siteinfo.valueobject.Position.RENTER_Any;
    inaction = com.hps.july.siteinfo.valueobject.Position.INACTION_All;
    setLastVisited(true);
}
public OrganizationAccessBean constructRenters()
	throws Exception
{
	if(getOrganization() != null) {
		try {
			OrganizationAccessBean o = new OrganizationAccessBean();
			o.setInitKey_organization(getOrganization().intValue());
			o.refreshCopyHelper();
			setOrgname(o.getName());
			return o;
		} catch(Exception e) {
			setOrgname("");
			return null;
		}
	} else {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public WorkerAccessBean constructWorker()
	throws Exception
{
	if(getWorker() != null) {
		try {
			WorkerAccessBean w = new WorkerAccessBean();
			w.setInitKey_worker(getWorker().intValue());
			w.refreshCopyHelper();
			setWorkername(w.getMan().getFullName());
			return w;
		} catch(Exception e) {
			setWorkername("");
			return null;
		}
	} else {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getAddRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteProjector");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2003 11:49:23)
 * @return int[]
 */
public int[] getCheckEquipment() {
	return checkEquipment;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteExploitor");
	roles.add("siteProjector");
	roles.add("siteTransport");
	roles.add("ArendaManager");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	roles.add("FreqManager");
	return roles;
}
/**
 * Заполнение параметров фильтра.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {

    try {
		if(searchString == null) {
			searchString = "*";
		} else
		if(searchString.length() < 1) {
			searchString = "*";
		} else
		if (("D".equals(getSearchBy()) || "E".equals(getSearchBy()))
			&& (!searchString.substring(searchString.length()-1).equals("*")   )) {
			searchString += "*";
		}
		
        dampsId.setInteger(new java.lang.Integer(0));
        gsmId.setInteger(new java.lang.Integer(0));
        name = "";
        addr = "";
        isGsmId = java.lang.Boolean.FALSE;
        isDampsId = java.lang.Boolean.FALSE;
        isName = java.lang.Boolean.FALSE;
        isAddr = java.lang.Boolean.FALSE;
        Boolean isTranspAll = java.lang.Boolean.FALSE;
        Boolean isTranspRRL = java.lang.Boolean.FALSE;
        Boolean isTranspVOT = java.lang.Boolean.FALSE;
        Boolean isTranspId = java.lang.Boolean.FALSE;
        Boolean isBeenetid = Boolean.FALSE;
        Boolean isController = Boolean.FALSE;
        Boolean isWLAN = Boolean.FALSE;
        Boolean isRepeater = Boolean.FALSE;
        String argTransId = "";
        String beenetid = "";
        String contrNumber = "";
        String wlanNumber = "";
        String repNumber = "";
        
        if ("F".equals(searchBy)) {
            gsmId.setString("");
            isGsmId = java.lang.Boolean.TRUE;
        }
        if ("G".equals(searchBy)) {
            dampsId.setString("");
            isDampsId = java.lang.Boolean.TRUE;
        }
        if ("H".equals(searchBy)) {
            gsmId.setString("");
            isGsmId = java.lang.Boolean.TRUE;
            dampsId.setString("");
            isDampsId = java.lang.Boolean.TRUE;
        }
        if ("B".equals(searchBy)) {
            gsmId.setString(searchString);
            if (gsmId.isEmpty() || !gsmId.isOk())
                gsmId.setInteger(new java.lang.Integer(0));
            isGsmId = java.lang.Boolean.TRUE;
        }
        if ("C".equals(searchBy)) {
            dampsId.setString(searchString);
            if (dampsId.isEmpty() || !dampsId.isOk())
                dampsId.setInteger(new java.lang.Integer(0));
            isDampsId = java.lang.Boolean.TRUE;
        }
        if ("D".equals(searchBy)) {
            name = searchString;
            isName = java.lang.Boolean.TRUE;
        }
        if ("E".equals(searchBy)) {
            addr = searchString;
            isAddr = java.lang.Boolean.TRUE;
        }
        
        if ("I".equals(searchBy)) {
            argTransId = searchString;
            isTranspId = java.lang.Boolean.TRUE;
        }
        if ("K".equals(searchBy)) {
            isTranspAll = java.lang.Boolean.TRUE;
        }
        if ("L".equals(searchBy)) {
            isTranspRRL = java.lang.Boolean.TRUE;
        }
        if ("M".equals(searchBy)) {
            isTranspVOT = java.lang.Boolean.TRUE;
        }
        if ("N".equals(searchBy)) {
	        isBeenetid = Boolean.TRUE;
	        beenetid = searchString;
	        if(beenetid == null) {
		        beenetid = "";
	        }
        }
        if ("O".equals(searchBy)) {
	        isController = Boolean.TRUE;
	        contrNumber = searchString;
	        if(contrNumber == null) {
		        contrNumber = "";
	        }
        }
        if("R".equals(searchBy)) {
	        isRepeater = Boolean.TRUE;
	        repNumber = searchString;
	        if(repNumber == null) {
		        repNumber = "";
	        }
        }
        if ("W".equals(searchBy)) {
	        isWLAN = Boolean.TRUE;
	        wlanNumber = searchString;
	        if(wlanNumber == null) {
		        wlanNumber = "";
	        }
        }
        
		if(posstate == null || "".equals(posstate.trim())) {
			posstate = "*";
		}

		RegionsSelector rs = getRegionsSelector();

        return new Object[] {
			new Boolean(!rs.isAllNetzones()), 
			rs.getNetzonecodes(),
            isGsmId,
            gsmId.getString(),
            isDampsId,
            dampsId.getString(),
            isName,
            name,
            isBeenetid,
            beenetid,
            isAddr,
            addr,
            renterSearchType,
            organization==null?new Integer(0):organization,
            isWorker.booleanValue() ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE,
            (worker.getInteger()==null)?new Integer(0):worker.getInteger(),
            inaction,
			posstate,
            new Boolean(!rs.isAllRegions()), /*isRegion*/
            rs.getRegioncodes(), /*regions*/
            new Boolean(!rs.isAllSuperregions()), /*isSupregs*/
            rs.getSuperregioncodes(), /*supregs*/
            isAdmin(),
			remoteUser, // Если это null то очень большой ошибка в ShowPositionsList. Должен быть всегда заполнен!
			isTranspAll,
			isTranspRRL,
			isTranspVOT,
			isTranspId, argTransId,
			isController, contrNumber,
			isWLAN, wlanNumber,
			isRepeater, repNumber,
            new Integer(sortorder)};
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findPositions";
}
public int getFinderMethodOrder() {
	if(sortorder < 1) {
		return 1;
	} else {
		return sortorder;
	}
/*
	try {
System.out.println("ORDER CODE:"+sortorder);
		return Integer.parseInt(sortorder);
	} catch (Exception e) {
		return 1;
	}
*/
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2002 15:21:54)
 * @return java.lang.String
 */
public java.lang.String getInaction() {
    if (inaction == null) {
        return com.hps.july.siteinfo.valueobject.Position.INACTION_All;
    }

    return inaction;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 16:59:26)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsWorker() {
	return isWorker;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 11:02:54)
 * @return int
 */
public int getOrder() {
	return order;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 16:55:00)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrganization() {
	return organization;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 16:55:13)
 * @return java.lang.String
 */
public java.lang.String getOrgname() {
	return orgname;
}
/**
 * Insert the method's description here.
 * Creation date: (14.03.2003 16:27:59)
 * @return java.lang.String
 */
public java.lang.String getOrgSearchType() {
	return orgSearchType;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 14:23:41)
 * @return java.lang.String
 */
public java.lang.String getPosAndRegs() {
	return posAndRegs;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPosstate() {
	return posstate;
}
/**
 * 
 * @return int
 */
public int getPosstatefilter() {
	return posstatefilter;
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 7:40:13)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getRegions() {
	return new Vector().elements();
}
/**
 * 
 * @return com.hps.july.siteinfo.valueobject.RegionsSelector
 */
public com.hps.july.siteinfo.valueobject.RegionsSelector getRegionsSelector() {
	return regionsSelector;
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 21:08:25)
 * @return java.lang.String
 */
public java.lang.String getRenterSearchType() {
	return renterSearchType;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 9:21:23)
 * @return java.lang.String
 */
public java.lang.String getSearchBy() {
	return searchBy;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 9:21:40)
 * @return java.lang.String
 */
public java.lang.String getSearchString() {
	return searchString;
}
/**
 * Insert the method's description here.
 * Creation date: (22.08.2002 15:13:26)
 * @return java.lang.String
 */
public java.lang.String getShowOnmap() {
	return showOnmap;
}
public int getSortorder() {
	return sortorder;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 16:54:05)
 * @return java.lang.Integer
 */
public java.lang.Integer getWorker() {
	return worker.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 16:54:05)
 * @return java.lang.Integer
 */
public java.lang.String getWorkerFrm() {
	return worker.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 16:54:40)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 21:54:02)
 * @return java.lang.Boolean
 */
public Boolean isAdmin() {
	//return Boolean.TRUE;
	return new Boolean(admin);
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2003 11:49:23)
 * @param newCheckEquipment int[]
 */
public void setCheckEquipment(int[] newCheckEquipment) {
	checkEquipment = newCheckEquipment;
}
public void setFinderMethodName(String name)
{
	try {
		sortorder = Integer.parseInt(name);
	} catch (Exception e) {
	}
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2002 15:21:54)
 * @param newInaction java.lang.String
 */
public void setInaction(java.lang.String newInaction) {
	inaction = newInaction;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 16:59:26)
 * @param newIsWorker java.lang.Boolean
 */
public void setIsWorker(java.lang.Boolean newIsWorker) {
	isWorker = newIsWorker;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 11:02:54)
 * @param newOrder int
 */
public void setOrder(int newOrder) {
	order = newOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 16:55:00)
 * @param newOrganization java.lang.Integer
 */
public void setOrganization(java.lang.Integer newOrganization) {
	organization = newOrganization;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 16:55:13)
 * @param newOrgname java.lang.String
 */
public void setOrgname(java.lang.String newOrgname) {
	orgname = newOrgname;
}
/**
 * Insert the method's description here.
 * Creation date: (14.03.2003 16:27:59)
 * @param newOrgSearchType java.lang.String
 */
public void setOrgSearchType(java.lang.String newOrgSearchType) {
	orgSearchType = newOrgSearchType;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2005 14:23:41)
 * @param newPosAndRegs java.lang.String
 */
public void setPosAndRegs(java.lang.String newPosAndRegs) {
	posAndRegs = newPosAndRegs;
}
/**
 * 
 * @param newPosstate java.lang.String
 */
public void setPosstate(java.lang.String newPosstate) {
	posstate = newPosstate;
}
public void setPosstatefilter(int newPosstatefilter) {
	if(posstatefilter > 0 && posstatefilter < 32) {
		posstatefilter = newPosstatefilter;
	} else {
		posstatefilter = 31;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 21:08:25)
 * @param newRenterSearchType java.lang.String
 */
public void setRenterSearchType(java.lang.String newRenterSearchType) {
	renterSearchType = newRenterSearchType;
}
public void setRequestData(javax.servlet.http.HttpServletRequest request)
{
	remoteUser = request.getRemoteUser();
	admin = request.isUserInRole("administrator");
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 9:21:23)
 * @param newSearchBy java.lang.String
 */
public void setSearchBy(java.lang.String newSearchBy) {
    searchBy = newSearchBy;
    /*
    if (searchBy.equals("G")) {
        super.setFinderMethodName("7");
    }
*/
    }
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 9:21:40)
 * @param newSearchString java.lang.String
 */
public void setSearchString(java.lang.String newSearchString) {
    searchString = newSearchString.trim();
}
/**
 * Insert the method's description here.
 * Creation date: (22.08.2002 15:13:26)
 * @param newShowOnmap java.lang.String
 */
public void setShowOnmap(java.lang.String newShowOnmap) {
	showOnmap = newShowOnmap;
}
public void setSortorder(int newSortorder) {
	sortorder = newSortorder;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 16:54:05)
 * @param newWorker java.lang.Integer
 */
public void setWorker(java.lang.Integer newWorker) {
	worker.setInteger(newWorker);
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 16:54:05)
 * @param newWorker java.lang.Integer
 */
public void setWorkerFrm(java.lang.String newWorker) {
	worker.setString(newWorker);
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2002 16:54:40)
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
public boolean showState(int state) {
	return (posstatefilter & state) != 0;
}
public boolean showState(String state) {
	if("PE".equals(state)) {
		return (posstatefilter & POSSTATE_PE) != 0;
	} else
	if("P".equals(state)) {
		return (posstatefilter & POSSTATE_P) != 0;
	} else
	if("E".equals(state)) {
		return (posstatefilter & POSSTATE_E) != 0;
	} else
	if("D".equals(state)) {
		return (posstatefilter & POSSTATE_D) != 0;
	} else
	if("R".equals(state)) {
		return (posstatefilter & POSSTATE_R) != 0;
	} else {
		return false;
	}
}
public void validateValues(org.apache.struts.action.ActionErrors errors)
    throws Exception
{
    try {
        constructRenters();
    } catch (Exception ex) {
        errors.add(org.apache.struts.action.ActionErrors.GLOBAL_ERROR,new org.apache.struts.action.ActionError("error.invalid.position.renter"));
    }
    try {
        constructWorker();
    } catch (Exception ex) {
		errors.add(org.apache.struts.action.ActionErrors.GLOBAL_ERROR,new org.apache.struts.action.ActionError("error.invalid.position.responsible"));
    }
	if (!errors.empty())
		throw new com.hps.july.web.util.ValidationException();  
}
}
