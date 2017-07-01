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
/**
 * Form-Bean 
 * лист "абонентских договоров"
 * Creation date: (04.07.2004 10:16:45)
 * @author: Shafigullin Ildar
 */
public class AbonentsListForm extends com.hps.july.web.util.BrowseForm {
	private final static Integer NULL_ID = new Integer(-1);
		
	private String searchDogs;
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
	 * AbonentsListForm constructor comment.
	 */
	public AbonentsListForm() {
		super();
		setFinderMethodName("1");

		setSearchDogs("0");
		setFilter(1);
		setSearchstring("");
		setSortBy("ban desc");
		
		setIsCustomer(Boolean.TRUE);
		setCustomerCode(NULL_ID);
		setCustomerName("");    
		setCustomer_vendocSiteId(NULL_ID);
		setCustomer_vendorSitesList(Collections.EMPTY_LIST);		

		setLastVisited(true);
	}
	/**
	 * Creation date: (20.07.2004 11:44:25)
	 */
	private WorkerVO constructEconomist(CDBCRowObject ro) {
		if (ro.getColumn("economist").asObject() != null) {
			WorkerVO economist = new WorkerVO((Integer) ro.getColumn("economist").asObject());
			economist.setName(ro.getColumn("economistname").asString());
			return economist;
		} else
			return null;
	}
	/**
	 * Creation date: (20.07.2004 11:46:52)
	 */
	private WorkerVO constructManager(CDBCRowObject ro) {
		if (ro.getColumn("manager").asObject() != null) {
			WorkerVO manager = new WorkerVO((Integer) ro.getColumn("manager").asObject());
			manager.setName(ro.getColumn("managername").asString());
			return manager;
		} else
			return null;
	}
	/**
	 * Для каждой строки броуза можно переопределить возвращаемый объект.
	 * Creation date: (22.05.2002 16:35:23)
	 * @return java.lang.Object
	 * @param o java.lang.Object
	 */
	public Object constructRowModelBean(Object o) {
		if (o instanceof com.hps.july.cdbc.lib.CDBCRowObject) {
			CDBCRowObject ro = (CDBCRowObject) o;
			LeaseAbonentBAN_VO vo = new LeaseAbonentBAN_VO(ro);
			vo.setManagerVO(constructManager(ro));
			vo.setEconomistVO(constructEconomist(ro));
			vo.setBalansNRI((java.math.BigDecimal) ro.getColumn("balansnri").asObject());
			return vo;
		} else {
			return o;
		}
	}
	/**
	 * Возвращает имя bean для броуза.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		//return "com.hps.july.persistence.LeaseAbonentBANAccessBean";
		return "com.hps.july.cdbc.objects.CDBCAbonentBAN_Object";
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.06.2002 16:47:06)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("ArendaMainEconomist");
		roles.add("ArendaEconomist");
		roles.add("administrator");
		return roles;
	}
	public int getFilter() {
		return filter;
	}
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
			new Integer(getFilter()), getSearchstring(),
			getIsCustomer().booleanValue() ? Boolean.FALSE : Boolean.TRUE,        getCustomerCode(),    getCustomer_vendocSiteId(), 
			isContractState, contractState, 
			isRegionID, getRegionID(), 
			getSortBy()};
	}
	public String getFinderMethodName() {
		//return "findLeaseAbonentBAN";
		return "findList";
	}
	/**
	 * 
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getIsAll() {
		return isAll;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.11.2005 14:05:00)
	 * @return java.lang.Integer
	 */
	private java.lang.Integer getRegionID() {
		return regionID;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getSearchDogs() {
		return searchDogs;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getSearchstring() {
		return searchstring;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (20.07.2004 10:31:03)
	 * @return java.lang.String
	 */
	public java.lang.String getSortBy() {
		return sortBy;
	}
	/**
	 * Для каждой строки броуза можно переопределить возвращаемый объект.
	 * Creation date: (22.05.2002 16:35:23)
	 * @return java.lang.Object
	 * @param o java.lang.Object
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		initRegionID_and_ListCustomers_and_VendorSitesList(request);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENTS_LIST);
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
	private ProfileAccess getProfileAccess(HttpServletRequest request) {
		Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
		if (profile == null) {
			throw new RuntimeException("Error:Profile = null");
		}
		ProfileAccess profileAccess = profile.getProfileAccess();
		if (profileAccess == null) {
			throw new RuntimeException("Error:profile.getProfileAccess() = null");
		}
		return profileAccess;
	}
	/**
	 * 
	 * @param newFilter int
	 */
	public void setFilter(int newFilter) {
		filter = newFilter;
	}
	/**
	 * 
	 * @param newIsAll java.lang.Boolean
	 */
	public void setIsAll(java.lang.Boolean newIsAll) {
		isAll = newIsAll;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.11.2005 14:05:00)
	 * @param newRegionID java.lang.Integer
	 */
	private void setRegionID(java.lang.Integer newRegionID) {
		regionID = newRegionID;
	}
	/**
	 * 
	 * @param newSearchDogs java.lang.String
	 */
	public void setSearchDogs(java.lang.String newSearchDogs) {
		searchDogs = newSearchDogs;
	}
	/**
	 * 
	 * @param newSearchstring java.lang.String
	 */
	public void setSearchstring(java.lang.String newSearchstring) {
		searchstring = newSearchstring;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (20.07.2004 10:31:03)
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
