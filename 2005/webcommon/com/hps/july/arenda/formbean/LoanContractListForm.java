package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

import javax.servlet.http.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.CDBC_VendorSite_Object;
import com.ibm.ejs.sm.exception.SetExecutableException;
/**
 * Insert the type's description here.
 * Creation date: (12.10.2005 15:40:48)
 * @author: Shafigullin Ildar
 */
public class LoanContractListForm extends com.hps.july.web.util.BrowseForm {
	private final static Integer NULL_ID = new Integer(-1);
	
    private String searchDogs; //запрашываемые состояния док.
    private int filter;
    private String searchstring;
    private Boolean isAll;
    private java.lang.String sortBy; //признак сортировки

    //работаем с разделением по филиалам:
    private Boolean isRegionID = new Boolean(true);
    private Integer regionID = null;
	//переключатель дополнительного фильтра:
	private boolean isDopFilter = false;

	private java.lang.Boolean isCustomer;
	private Integer customerCode;//id Ссудополучателя
	private java.lang.String customerName;//имя Ссудополучателя
	private Integer customer_vendocSiteId = null;//id отделения Ссудополучателя(для организаций)
	private List customer_vendorSitesList = null;//список отделений Ссудополучателя(для организаций)    

/**
 * LoanContractListForm constructor comment.
 */
public LoanContractListForm() {
    super();
    
    setSearchDogs("0");
    setFilter(1);
    setSearchstring("");
    setSortBy("docdate desc");
    
	setIsCustomer(Boolean.TRUE);
	setCustomerCode(NULL_ID);
	setCustomerName("");    
    setCustomer_vendocSiteId(NULL_ID);
    setCustomer_vendorSitesList(Collections.EMPTY_LIST);

    setLastVisited(true);
}
/**
 * Для каждой строки броуза можно переопределить возвращаемый объект.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
		CDBCRowObject ro = (CDBCRowObject) o;
		LoanContractVO vo = new LoanContractVO(ro);
		vo.setManagerVO(initWorkerVO(ro, "manager", "managername"));
		vo.setEconomistVO(initWorkerVO(ro, "economist", "economistname"));
		vo.setMainpositionVO(initStoragePlaceVO(ro, "mainposition", "mainpositionname"));
		vo.setPlanCurrVO(com.hps.july.arenda.cdbcobjects.CDBC_Helper.initCurrencyVO(ro, "plancurr", "plancurrname"));
		return vo;
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
    return "com.hps.july.arenda.cdbcobjects.CDBC_LoanContract_Object";
}
/**
 * Insert the method's description here.
 * Creation date: (09.11.2005 16:39:52)
 */
public java.util.ArrayList getEditRoles() {
    java.util.ArrayList roles = new java.util.ArrayList();
    roles.add("ArendaMainEconomist");
    roles.add("ArendaEconomist");
    roles.add("administrator");
    return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 16:04:43)
 * @return int
 */
public int getFilter() {
	return filter;
}
/**
 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
 * Creation date: (12.10.2005 15:40:48)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {

	Boolean isContractState = Boolean.FALSE;
	String contractState = "";

	if ("1".equals(getSearchDogs())) { // search active only
		isContractState = Boolean.TRUE;
		contractState = "B";
	} else if ("2".equals(getSearchDogs())) { // search editing only
		isContractState = Boolean.TRUE;
		contractState = "A";
	} else if ("3".equals(getSearchDogs())) { // search closed only
		isContractState = Boolean.TRUE;
		contractState = "C";
	}

	return new Object[] {
		new Integer(getFilter()),	getSearchstring(),
		getIsCustomer().booleanValue() ? Boolean.FALSE : Boolean.TRUE,        getCustomerCode(),    getCustomer_vendocSiteId(),
		isContractState,	contractState,
		isRegionID,  getRegionID(),
		getSortBy() };
}
/**
 * Возвращает имя метода поиска.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findList";
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 16:04:43)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsAll() {
	return isAll;
}
/**
 * Insert the method's description here.
 * Creation date: (23.11.2005 11:50:15)
 * @return java.lang.Integer
 */
private java.lang.Integer getRegionID() {
	return regionID;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 16:04:43)
 * @return java.lang.String
 */
public java.lang.String getSearchDogs() {
	return searchDogs;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 16:04:43)
 * @return java.lang.String
 */
public java.lang.String getSearchstring() {
	return searchstring;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 16:04:43)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    initRegionID_and_ListCustomers_and_VendorSitesList(request);
    ParamsParser.setState(request, Applications.ARENDA, APPStates.LOAN_CONTRACT_LIST);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.11.2005 17:21:24)
 */
private void initRegionID_and_ListCustomers_and_VendorSitesList(HttpServletRequest request) {
	ProfileAccess profileAccess = getProfileAccess(request);
    if (profileAccess.getCurrRegion() != null) {
		Integer newRegionID = profileAccess.getCurrRegion().getVo().getRegionid();
		if(!newRegionID.equals(getRegionID())){
			initCustomer_vendorSitesList(getCustomerCode(), newRegionID);			
		}
        setRegionID(newRegionID);
    } else {
	    //throw new RuntimeException("нет текущего региона для аренды!!!");
	    System.out.println("нет текущего региона для аренды!!!");
		setRegionID(null);
    }
}
private void initCustomer_vendorSitesList(Integer newCustomerCode, Integer newRegionID) {
	if(newCustomerCode != null && newRegionID != null){
		setCustomer_vendorSitesList(CDBC_VendorSite_Object.findList(Boolean.TRUE, newCustomerCode, Boolean.FALSE, null, Boolean.FALSE, null, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, newRegionID, null));
		setCustomer_vendocSiteId(NULL_ID);
	}else{
		setCustomer_vendorSitesList(Collections.EMPTY_LIST);
		setCustomer_vendocSiteId(NULL_ID);
	}	
}
/**
 * 
 * @param request
 * @return
 */
private ProfileAccess getProfileAccess(HttpServletRequest request){
	Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
	if(profile == null){
		throw new RuntimeException("Error:Profile = null");
	}
	ProfileAccess profileAccess= profile.getProfileAccess();
	if(profileAccess == null){
		throw new RuntimeException("Error:profile.getProfileAccess() = null");
	}
	return profileAccess;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 19:12:19)
 */
private StoragePlaceVO initStoragePlaceVO(CDBCRowObject ro, String key, String name) {
	if (ro.getColumn(key).asObject() != null) {
		StoragePlaceVO vo = new StoragePlaceVO(((Integer) ro.getColumn(key).asObject()).intValue());
		vo.setName(ro.getColumn(name).asString());
		return vo;
	} else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 18:52:46)
 */
private WorkerVO initWorkerVO(CDBCRowObject ro, String key, String name) {
	if (ro.getColumn(key).asObject() != null) {
		WorkerVO vo = new WorkerVO((Integer) ro.getColumn(key).asObject());
		vo.setName(ro.getColumn(name).asString());
		return vo;
	} else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 16:04:43)
 * @param newFilter int
 */
public void setFilter(int newFilter) {
	filter = newFilter;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 16:04:43)
 * @param newIsAll java.lang.Boolean
 */
public void setIsAll(java.lang.Boolean newIsAll) {
	isAll = newIsAll;
}
/**
 * Insert the method's description here.
 * Creation date: (23.11.2005 11:50:15)
 * @param newRegionID java.lang.Integer
 */
private void setRegionID(java.lang.Integer newRegionID) {
	regionID = newRegionID;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 16:04:43)
 * @param newSearchDogs java.lang.String
 */
public void setSearchDogs(java.lang.String newSearchDogs) {
	searchDogs = newSearchDogs;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 16:04:43)
 * @param newSearchstring java.lang.String
 */
public void setSearchstring(java.lang.String newSearchstring) {
	searchstring = newSearchstring;
}
/**
 * Insert the method's description here.
 * Creation date: (12.10.2005 16:04:43)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
	/**
	 * @return
	 */
	public Integer getCustomer_vendocSiteId() {
		return customer_vendocSiteId;
	}

	/**
	 * @return
	 */
	public List getCustomer_vendorSitesList() {
		return customer_vendorSitesList;
	}

	/**
	 * @param integer
	 */
	public void setCustomer_vendocSiteId(Integer integer) {
		customer_vendocSiteId = integer;
	}

	/**
	 * @param list
	 */
	private void setCustomer_vendorSitesList(List list) {
		customer_vendorSitesList = list;
	}

	/**
	 * @return
	 */
	public Integer getCustomerCode() {
		return customerCode;
	}

	/**
	 * @return
	 */
	public java.lang.Boolean getIsCustomer() {
		return isCustomer;
	}

	/**
	 * @param integer
	 */
	public void setCustomerCode(Integer newCustomerCode) {
		if(!newCustomerCode.equals(getCustomerCode())){
			initCustomer_vendorSitesList(newCustomerCode, getRegionID());
		}		
		customerCode = newCustomerCode;
	}

	/**
	 * @param boolean1
	 */
	public void setIsCustomer(java.lang.Boolean boolean1) {
		isCustomer = boolean1;
	}

	/**
	 * @return
	 */
	public boolean getIsDopFilter() {
		return isDopFilter;
	}

	/**
	 * @param b
	 */
	public void setIsDopFilter(boolean b) {
		isDopFilter = b;
	}

	/**
	 * @return
	 */
	public java.lang.String getCustomerName() {
		return customerName;
	}

	/**
	 * @param string
	 */
	public void setCustomerName(java.lang.String string) {
		customerName = string;
	}

}
