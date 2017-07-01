/*
 * Created on 15.11.2006
 *
 * "Фактические данные по договорам Аренды" ActionForm.
 */
package com.hps.july.arenda.formbean;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.hps.july.arenda.cdbcobjects.FactsLeasePageDAO;
import com.hps.july.arenda.cdbcobjects.Page;
import com.hps.july.arenda.valueobject.FactsLeaseColStatusDogOnDate;
import com.hps.july.arenda.valueobject.FactsLeaseTO;
import com.hps.july.arenda.valueobject.ResourceVO;
import com.hps.july.cdbc.objects.CDBC_OwnerContract2FilialNri_Object;
import com.hps.july.cdbc.objects.CDBC_VendorSite_Object;
import com.hps.july.logic.DataPeriod;
import com.hps.july.persistence.NamedValueAccessBean;
import com.hps.july.persistence.OperatorObject;
import com.hps.july.persistence.ResourceAccessBean;
import com.hps.july.persistence.ResourceSubTypeKey;
import com.hps.july.util.ServiceLocatorException;
import com.hps.july.valueobject.OwnerContract2FilialNri_VO;
import com.hps.july.web.util.ProfileAccess;
import com.hps.july.web.util.ProfileAccessHelper;

/**
 * @author IShaffigulin
 *
 * "Фактические данные по договорам Аренды" ActionForm.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FactsLeasePageForm extends ActionForm {
	public final static String NULL_COMAND = "";
	private final static Integer NULL_ID = new Integer(-1);

	private java.lang.String comand = null;
	private java.lang.String sortBy = "docNumber";
	//работаем с разделением по филиалам:
	private Boolean isRegionID = new Boolean(true);
	private Integer regionID = null;
	//код оператора:
	private java.lang.Integer operatorCode;
	//private int filter;//фильтр запроса
	//private String searchString;//строка запрос
	private boolean isDopFilter = false; //переключатель дополнительного фильтра
	//заказчики:
	private java.lang.Boolean isCustomer;
	private Integer customerCode;
	private java.lang.String customerName;
	private List customers = null;
	//Исполнитель(арендодатель):
	private java.lang.Boolean isExecutor;
	private Integer executorCode;
	private java.lang.String executorName;
	private Integer executor_vendocSiteId = null;
	private List executor_vendorSitesList = null; //список отделений Исполнителя(арендодатель)
	//Услуга:
	private java.util.Vector resources;
	private java.lang.Boolean isResource;
	private java.lang.String resourceCode;
	//Позиция:
	private java.lang.Boolean isPosition;
	private java.lang.Integer positionCode;
	private java.lang.String positionName;
	//Ответственный:
	private java.lang.Boolean isEconomist;
	private Integer economistCode;
	private java.lang.String economistName;
	//период поиска:
	private DataPeriod dataPeriod = new DataPeriod();
	//страница отображения:
	private FactsLeasePageDAO pageDAO = null;
	private Page page;
	/**
	 * 
	 */
	public FactsLeasePageForm() {
		super();
		setComand(NULL_COMAND);
		setIsCustomer(Boolean.TRUE);
		setCustomerCode(NULL_ID);
		setCustomerName("");

		setIsExecutor(Boolean.TRUE);
		setExecutorCode(NULL_ID);
		setExecutorName("");
		setExecutor_vendocSiteId(NULL_ID); //поиск по всем отделениям заказчика

		setIsEconomist(Boolean.FALSE);
		setEconomistCode(NULL_ID);
		setEconomistName("");

		setIsPosition(Boolean.TRUE);
		setPositionCode(NULL_ID);
		setPositionName("");

		//список услуг:
		resources = initResources();
		setIsResource(Boolean.TRUE);
		setResourceCode("");
		//поиск:
		//setSearchString("");
		//setFilter(1);
		setExecutor_vendorSitesList(Collections.EMPTY_LIST);
		pageDAO = new FactsLeasePageDAO();
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (23.03.2005 17:25:58)
	 * @return java.util.Enumeration
	 */
	private java.util.Vector initResources() {
		try {
			NamedValueAccessBean bean = new NamedValueAccessBean();
			bean.setInitKey_id("ARENDA_TYPE");
			bean.refreshCopyHelper();
			java.util.Vector resurses = new java.util.Vector();

			java.util.Enumeration enum =
				(new ResourceAccessBean()).findResourcesByQBE(new Boolean(true), new ResourceSubTypeKey(bean.getIntvalue()), new Boolean(false), null, new Boolean(false), null, new Integer(3));
			while (enum.hasMoreElements()) {
				ResourceAccessBean ab = (ResourceAccessBean) enum.nextElement();
				ResourceVO vo = new ResourceVO(new Integer(ab.getResource()));
				vo.setName(ab.getName());
				resurses.add(vo);
			}
			return resurses;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @return
	 */
	public java.lang.String getComand() {
		return comand;
	}

	/**
	 * @param string
	 */
	public void setComand(java.lang.String string) {
		comand = string;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.05.2005 13:33:34)
	 */
	public void doTask(ActionErrors errors, HttpServletRequest request) {
		try {
			initRegionID_and_ListCustomers_and_VendorSitesList(request);
			if (getOperatorCode() == null) {
				initOperatorCode(request);
			}
			//request.setAttribute("regionAccessList", regionAccessList);           
			//initStart();
			page = Page.EMPTY_PAGE;
			page = pageDAO.executeSelect(this, 0, 1000, getSortBy());
			computePeriodsForPage(page, getDataPeriod());
		} catch (SQLException e) {
			System.out.println("SQLException FactsLeasePageForm.doTask : ");
			String errSQL = "ERROR: code=" + e.getErrorCode() + ", msg=" + e.getLocalizedMessage();
			System.out.println(errSQL);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errSQL));
			e.printStackTrace(System.out);
		} catch (ServiceLocatorException exc) {
			System.out.println("ServiceLocatorException FactsLeasePageForm.doTask:" + exc);
			exc.printStackTrace(System.out);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.12.2005 16:45:24)
	 */
	private void initOperatorCode(javax.servlet.http.HttpServletRequest request) {
		setOperatorCode(OperatorObject.getOperatorCode(request.getRemoteUser()));
	}
	/**
	 * 
	 * @param page
	 * @param period
	 */
	private void computePeriodsForPage(Page page, DataPeriod period) throws SQLException, ServiceLocatorException {
		//формируем шапку дат по месяцам из периода:
		ArrayList headers = new ArrayList();
		Date fromDate = period.getFromDate();
		Date toDate = period.getToDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fromDate);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		fromDate = new Date(calendar.getTime().getTime());
		while (fromDate.before(toDate) || fromDate.equals(toDate)) {
			headers.add(fromDate);
			//System.out.println(fromDate);//temp
			calendar.add(Calendar.MONTH, 1);
			fromDate = new Date(calendar.getTime().getTime());
		}
		setPage(new Page(headers, page.getList(), 0, false));
		//вычисляем данные по периоду для договоров:
		List list = page.getList();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			FactsLeaseTO to = (FactsLeaseTO) iter.next();
			//computePeriodsForFactsLeaseTO(to, getPage().getHeaders());
			computePeriodsForFactsLeaseTO(to, period);
		}
	}
	/**
	 * 
	 * @param to
	 * @param period
	 */
	private void computePeriodsForFactsLeaseTO(FactsLeaseTO to, List headers) throws SQLException, ServiceLocatorException {
		int docID = to.getDocID().intValue();
		int docCurrency = to.getDocCurrency().intValue();
		ArrayList statusList = new ArrayList(headers.size());
		for (Iterator iter = headers.iterator(); iter.hasNext();) {
			Date curDate = (Date) iter.next();
			FactsLeaseColStatusDogOnDate statusVO = pageDAO.getColStatusDogOnDate(docID, curDate, docCurrency);
			statusList.add(statusVO);
		}
		to.setStatuses(statusList);
	}
	/**
	 * 
	 * @param to
	 * @param period
	 */
	private void computePeriodsForFactsLeaseTO(FactsLeaseTO to, DataPeriod period) throws SQLException, ServiceLocatorException {
		int docID = to.getDocID().intValue();
		int docCurrency = to.getDocCurrency().intValue();
		to.setStatuses(pageDAO.getFactLeaseStateOnPeriod(docID, period, docCurrency));
	}	
	/**
	 * Insert the method's description here.
	 * Creation date: (23.11.2005 17:21:24)
	 */
	private void initRegionID_and_ListCustomers_and_VendorSitesList(HttpServletRequest request) {
		ProfileAccess profileAccess = ProfileAccessHelper.getProfileAccess(request);
		if (profileAccess.getCurrRegion() != null) {
			Integer newRegionID = profileAccess.getCurrRegion().getVo().getRegionid();
			if (!newRegionID.equals(getRegionID())) {
				//initListCustomers(newRegionID);
				initExecutor_vendorSitesList(getExecutorCode(), newRegionID);
			}
			setRegionID(newRegionID);
		} else {
			//throw new RuntimeException("нет текущего региона для аренды!!!");
			System.out.println("нет текущего региона для аренды!!!");
			setRegionID(null);
		}
	}
	/**
	 * 
	 * @param newExecutorCode
	 * @param newRegionID
	 */
	private void initExecutor_vendorSitesList(Integer newExecutorCode, Integer newRegionID) {
		if (newExecutorCode != null && newRegionID != null) {
			setExecutor_vendorSitesList(
				CDBC_VendorSite_Object.findList(Boolean.TRUE, newExecutorCode, Boolean.FALSE, null, Boolean.FALSE, null, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, newRegionID, null));
			setExecutor_vendocSiteId(NULL_ID);
		} else {
			setExecutor_vendorSitesList(Collections.EMPTY_LIST);
			setExecutor_vendocSiteId(NULL_ID);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.07.2002 13:06:43)
	 * @return java.util.List
	*/
	private void initListCustomers(Integer newRegionID) {
		customers = CDBC_OwnerContract2FilialNri_Object.getList(newRegionID, "name");
		if (getCustomers() != null && getCustomers().size() > 0) {
			OwnerContract2FilialNri_VO ownerVO = (OwnerContract2FilialNri_VO) getCustomers().get(0);
			setCustomerCode(ownerVO.getIdOwnerContract());
		} else {
			setCustomerCode(NULL_ID);
		}
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		setComand(NULL_COMAND);
		super.reset(arg0, arg1);
	}

	/**
	 * @return
	 */
	public Integer getRegionID() {
		return regionID;
	}

	/**
	 * @param integer
	 */
	public void setRegionID(Integer integer) {
		regionID = integer;
	}

	/**
	 * @return
	 */
	private java.lang.Integer getOperatorCode() {
		return operatorCode;
	}

	/**
	 * @param integer
	 */
	private void setOperatorCode(java.lang.Integer integer) {
		operatorCode = integer;
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
	public List getCustomers() {
		return customers;
	}

	/**
	 * @return
	 */
	public java.lang.String getSortBy() {
		return sortBy;
	}

	/**
	 * @param integer
	 */
	public void setCustomerCode(Integer integer) {
		customerCode = integer;
	}

	/**
	 * @param list
	 */
	public void setCustomers(List list) {
		customers = list;
	}

	/**
	 * @param string
	 */
	public void setSortBy(java.lang.String string) {
		sortBy = string;
	}

	/**
	 * @return
	 */
	public Integer getExecutor_vendocSiteId() {
		return executor_vendocSiteId;
	}

	/**
	 * @return
	 */
	public List getExecutor_vendorSitesList() {
		return executor_vendorSitesList;
	}

	/**
	 * @param integer
	 */
	public void setExecutor_vendocSiteId(Integer integer) {
		executor_vendocSiteId = integer;
	}

	/**
	 * @param list
	 */
	public void setExecutor_vendorSitesList(List list) {
		executor_vendorSitesList = list;
	}

	/**
	 * @return
	 */
	public Integer getExecutorCode() {
		return executorCode;
	}

	/**
	 * @param integer
	 */
	public void setExecutorCode(Integer newExecutorCode) {
		if (!newExecutorCode.equals(getExecutorCode())) {
			initExecutor_vendorSitesList(newExecutorCode, getRegionID());
		}
		executorCode = newExecutorCode;
	}

	/**
	 * @return
	 */
	public java.lang.Boolean getIsCustomer() {
		return isCustomer;
	}

	/**
	 * @return
	 */
	public java.lang.Boolean getIsExecutor() {
		return isExecutor;
	}

	/**
	 * @param boolean1
	 */
	public void setIsCustomer(java.lang.Boolean boolean1) {
		isCustomer = boolean1;
	}

	/**
	 * @param boolean1
	 */
	public void setIsExecutor(java.lang.Boolean boolean1) {
		isExecutor = boolean1;
	}

	/**
	 * @return
	 */
	public java.lang.String getCustomerName() {
		return customerName;
	}

	/**
	 * @return
	 */
	public java.lang.String getExecutorName() {
		return executorName;
	}

	/**
	 * @return
	 */
	public boolean getIsDopFilter() {
		return isDopFilter;
	}

	/**
	 * @return
	 */
	public java.lang.Boolean getIsResource() {
		return isResource;
	}

	/**
	 * @param string
	 */
	public void setCustomerName(java.lang.String string) {
		customerName = string;
	}

	/**
	 * @param string
	 */
	public void setExecutorName(java.lang.String string) {
		executorName = string;
	}

	/**
	 * @param b
	 */
	public void setIsDopFilter(boolean b) {
		isDopFilter = b;
	}

	/**
	 * @param boolean1
	 */
	public void setIsResource(java.lang.Boolean boolean1) {
		isResource = boolean1;
	}

	/**
	 * @return
	 */
	public java.lang.String getResourceCode() {
		return resourceCode;
	}

	/**
	 * @param string
	 */
	public void setResourceCode(java.lang.String string) {
		resourceCode = string;
	}

	/**
	 * @return
	 */
	public java.lang.String getPositionName() {
		return positionName;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getPositionCode() {
		return positionCode;
	}

	/**
	 * @param string
	 */
	public void setPositionName(java.lang.String string) {
		positionName = string;
	}

	/**
	 * @param integer
	 */
	public void setPositionCode(java.lang.Integer integer) {
		positionCode = integer;
	}

	/**
	 * @return
	 */
	public java.lang.Boolean getIsPosition() {
		return isPosition;
	}

	/**
	 * @param boolean1
	 */
	public void setIsPosition(java.lang.Boolean boolean1) {
		isPosition = boolean1;
	}

	/**
	 * @return
	 */
	public Integer getEconomistCode() {
		return economistCode;
	}

	/**
	 * @return
	 */
	public java.lang.String getEconomistName() {
		return economistName;
	}

	/**
	 * @return
	 */
	public java.lang.Boolean getIsEconomist() {
		return isEconomist;
	}

	/**
	 * @param integer
	 */
	public void setEconomistCode(Integer integer) {
		economistCode = integer;
	}

	/**
	 * @param string
	 */
	public void setEconomistName(java.lang.String string) {
		economistName = string;
	}

	/**
	 * @param boolean1
	 */
	public void setIsEconomist(java.lang.Boolean boolean1) {
		isEconomist = boolean1;
	}

	/**
	 * @return
	 */
	public java.util.Vector getResources() {
		return resources;
	}

	/**
	 * @param vector
	 */
	public void setResources(java.util.Vector vector) {
		resources = vector;
	}

	/**
	 * @return
	 */
	public DataPeriod getDataPeriod() {
		return dataPeriod;
	}

	/**
	 * @param period
	 */
	public void setDataPeriod(DataPeriod period) {
		dataPeriod = period;
	}

	/**
	 * @return
	 */
	public Page getPage() {
		return page;
	}

	/**
	 * @param page
	 */
	public void setPage(Page page) {
		this.page = page;
	}

	/**
	 * @return
	 */
	public Boolean getIsRegionID() {
		return isRegionID;
	}

}
