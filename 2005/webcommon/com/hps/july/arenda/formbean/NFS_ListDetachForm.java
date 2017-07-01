package com.hps.july.arenda.formbean;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import org.apache.struts.action.*;

import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.arenda.APPStates;
import com.hps.july.persistence.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.logic.DocumentLogic;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import java.sql.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import com.hps.july.logic.*;
/**
 * Bean-form "лист отчётов из NFS".
 * Creation date: (01.06.2004 13:41:51)
 * @author: Shafigullin Ildar
 */
public class NFS_ListDetachForm extends BrowseForm {
	private java.lang.String filter = "";
	private int stateFilter =2;
	private java.lang.String sortBy = "datePay desc";//признак сортировки
	private DataPeriod dataPeriod_SF = new DataPeriod();
	private DataPeriod dataPeriod_ZP = new DataPeriod();
	private DataPeriod dataPeriod_Pays = new DataPeriod();
	private DataPeriod dataPeriod_PaysP = new DataPeriod();
	private java.lang.Boolean isDate_SF = Boolean.TRUE;
	private java.lang.Boolean isDate_ZP = Boolean.TRUE;
	private java.lang.Boolean isDate_Pays = Boolean.TRUE;
	private java.lang.Boolean isDate_PaysP = Boolean.TRUE;	
	private int filterBeeline = 81;
	private java.lang.Boolean isFilterBeeline= Boolean.TRUE;;
	
	public final static String OPERATION_NO = ""; 
	private java.lang.String operation = OPERATION_NO;
	
	//работаем с разделением по филиалам:
	private Boolean isRegionID = new Boolean(true);
	private Integer regionID = null;
	
	private final static Integer NULL_ID = new Integer(-1);	
	
	private boolean isDopFilter = false;//переключатель дополнительного фильтра
	//поиск по исполнителю(арендодателю):
	private java.lang.Boolean isExecutor;
	private Integer executorcode;
	private java.lang.String executorname;
	private Integer executor_vendocSiteId = null;
	private List executor_vendorSitesList = null;//список отделений Исполнителя(арендодатель)
/**
 * NFS_ListForm constructor comment.
 */
public NFS_ListDetachForm() {
	super();
	setFinderMethodName("findListNFS_detach");
	setLastVisited(true);
	
	setIsExecutor(Boolean.TRUE);
	setExecutorcode(NULL_ID);
	setExecutorname("");
	setExecutor_vendocSiteId(NULL_ID);//поиск по всем отделениям заказчика	
}
/**
 * Insert the method's description here./////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * Creation date: (01.06.2004 17:10:32)
 */
private void clearAllParams() {
	stateFilter = 0;
	filter = "";
}
/**
 * Для каждой строки броуза можно переопределить возвращаемый объект.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	if (o == null) {
		return o;
	}
	if (!(o instanceof CDBCRowObject)) {
		System.out.println("NFS_LIST: CLASS_CAST: " + o.getClass().getName());
		return o;
	}
	return new NFS_VO((CDBCRowObject)o);
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBC_NFS_Object";
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 14:41:57)
 * @return com.hps.july.logic.DataPeriod
 */
public com.hps.july.logic.DataPeriod getDataPeriod_Pays() {
	return dataPeriod_Pays;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2005 16:33:37)
 * @return com.hps.july.logic.DataPeriod
 */
public com.hps.july.logic.DataPeriod getDataPeriod_PaysP() {
	return dataPeriod_PaysP;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 14:40:10)
 * @return com.hps.july.logic.DataPeriod
 */
public com.hps.july.logic.DataPeriod getDataPeriod_SF() {
	return dataPeriod_SF;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 14:40:37)
 * @return com.hps.july.logic.DataPeriod
 */
public com.hps.july.logic.DataPeriod getDataPeriod_ZP() {
	return dataPeriod_ZP;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2004 12:26:51)
 * @return java.lang.String
 */
public java.lang.String getFilter() {
	return filter;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 17:48:59)
 * @return int
 */
public int getFilterBeeline() {
	return filterBeeline;
}
/**
 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
 * Creation date: (01.06.2004 13:41:51)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
/**	
	return new Object[] {
		getStateFilter() == 0 ? Boolean.TRUE : Boolean.FALSE,		getFilter(),
		getStateFilter() == 1 ? Boolean.TRUE : Boolean.FALSE,		getFilter(),
		getStateFilter() == 2 ? Boolean.TRUE : Boolean.FALSE,		getFilter(),
		getStateFilter() == 3 ? Boolean.TRUE : Boolean.FALSE,		getFilter(),
		getStateFilter() == 4 ? Boolean.TRUE : Boolean.FALSE,		getFilter(),	
        getIsDate_SF(),        getDataPeriod_SF().getFromDate(),        getDataPeriod_SF().getToDate(),
        getIsDate_ZP(),        getDataPeriod_ZP().getFromDate(),        getDataPeriod_ZP().getToDate(),
        getIsDate_Pays(),   getDataPeriod_Pays().getFromDate(),    getDataPeriod_Pays().getToDate(),
        getIsDate_PaysP(),   getDataPeriod_PaysP().getFromDate(),    getDataPeriod_PaysP().getToDate(),
        getIsFilterBeeline(),   new Integer(getFilterBeeline()),
		getSortBy()};
*/
	return new Object[] {
		new Integer(getStateFilter()),		getFilter(),
		getIsExecutor().booleanValue() ? Boolean.FALSE : Boolean.TRUE,        getExecutorcode(),    getExecutor_vendocSiteId(),	
		new Boolean(!getIsDate_SF().booleanValue()),        getDataPeriod_SF().getFromDate(),        getDataPeriod_SF().getToDate(),
		new Boolean(!getIsDate_ZP().booleanValue()),        getDataPeriod_ZP().getFromDate(),        getDataPeriod_ZP().getToDate(),
		new Boolean(!getIsDate_Pays().booleanValue()),   getDataPeriod_Pays().getFromDate(),    getDataPeriod_Pays().getToDate(),
		new Boolean(!getIsDate_PaysP().booleanValue()),   getDataPeriod_PaysP().getFromDate(),    getDataPeriod_PaysP().getToDate(),
		isRegionID,        getRegionID(),
		getSortBy()};		
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 15:39:59)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDate_Pays() {
	return isDate_Pays;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2005 16:35:01)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDate_PaysP() {
	return isDate_PaysP;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 15:04:22)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDate_SF() {
	return isDate_SF;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 15:39:36)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDate_ZP() {
	return isDate_ZP;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 17:49:53)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsFilterBeeline() {
	return isFilterBeeline;
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2004 15:57:01)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2004 12:29:08)
 * @return int
 */
public int getStateFilter() {
	return stateFilter;
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
    ParamsParser.setState(request, Applications.ARENDA, APPStates.NFS_LIST_DETACH);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 14:41:57)
 * @param newDataPeriod_Pays com.hps.july.logic.DataPeriod
 */
public void setDataPeriod_Pays(com.hps.july.logic.DataPeriod newDataPeriod_Pays) {
	dataPeriod_Pays = newDataPeriod_Pays;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2005 16:33:37)
 * @param newDataPeriod_PaysP com.hps.july.logic.DataPeriod
 */
public void setDataPeriod_PaysP(com.hps.july.logic.DataPeriod newDataPeriod_PaysP) {
	dataPeriod_PaysP = newDataPeriod_PaysP;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 14:40:10)
 * @param newDataPeriod_SF com.hps.july.logic.DataPeriod
 */
public void setDataPeriod_SF(com.hps.july.logic.DataPeriod newDataPeriod_SF) {
	dataPeriod_SF = newDataPeriod_SF;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 14:40:37)
 * @param newDataPeriod_ZP com.hps.july.logic.DataPeriod
 */
public void setDataPeriod_ZP(com.hps.july.logic.DataPeriod newDataPeriod_ZP) {
	dataPeriod_ZP = newDataPeriod_ZP;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2004 12:26:51)
 * @param newFilter java.lang.String
 */
public void setFilter(java.lang.String newFilter) {
	filter = newFilter;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 17:48:59)
 * @param newFilterBeeline int
 */
public void setFilterBeeline(int newFilterBeeline) {
	filterBeeline = newFilterBeeline;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 15:39:59)
 * @param newIsDate_Pays java.lang.Boolean
 */
public void setIsDate_Pays(java.lang.Boolean newIsDate_Pays) {
	isDate_Pays = newIsDate_Pays;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2005 16:35:01)
 * @param newIsDate_PaysCreate java.lang.Boolean
 */
public void setIsDate_PaysP(java.lang.Boolean newIsDate_PaysP) {
	isDate_PaysP = newIsDate_PaysP;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 15:04:22)
 * @param newIsDate_SF java.lang.Boolean
 */
public void setIsDate_SF(java.lang.Boolean newIsDate_SF) {
	isDate_SF = newIsDate_SF;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 15:39:36)
 * @param newIsDate_ZP java.lang.Boolean
 */
public void setIsDate_ZP(java.lang.Boolean newIsDate_ZP) {
	isDate_ZP = newIsDate_ZP;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2005 17:49:53)
 * @param newIsFilterBeeline java.lang.Boolean
 */
public void setIsFilterBeeline(java.lang.Boolean newIsFilterBeeline) {
	isFilterBeeline = newIsFilterBeeline;
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2004 15:57:01)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2004 12:29:08)
 * @param newStateFilter int
 */
public void setStateFilter(int newStateFilter) {
	stateFilter = newStateFilter;
}
	/**
	 * @return
	 */
	public java.lang.String getOperation() {
		return operation;
	}

	/**
	 * @param string
	 */
	public void setOperation(java.lang.String string) {
		operation = string;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		setOperation(OPERATION_NO);
	}

	/**
	 * @return
	 */
	private Integer getRegionID() {
		return regionID;
	}

	/**
	 * @param integer
	 */
	private void setRegionID(Integer integer) {
		regionID = integer;
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
	public Integer getExecutor_vendocSiteId() {
		return executor_vendocSiteId;
	}

	/**
	 * @param integer
	 */
	public void setExecutor_vendocSiteId(Integer integer) {
		executor_vendocSiteId = integer;
	}

	/**
	 * @return
	 */
	public List getExecutor_vendorSitesList() {
		return executor_vendorSitesList;
	}

	/**
	 * @param list
	 */
	private void setExecutor_vendorSitesList(List list) {
		executor_vendorSitesList = list;
	}
	
	/**
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getIsExecutor() {
		return isExecutor;
	}
	
	/**
	 * @param newIsExecutor java.lang.Boolean
	 */
	public void setIsExecutor(java.lang.Boolean newIsExecutor) {
		isExecutor = newIsExecutor;
	}
	
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 13:26:25)
	 * @return int
	 */
	public Integer getExecutorcode() {
		if (executorcode == null) {
			executorcode = new Integer(0);
		}
		return executorcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 13:26:25)
	 * @param newExecutorid int
	 */
	public void setExecutorcode(Integer newExecutorCode) {
		if(!newExecutorCode.equals(getExecutorcode())){
			initExecutor_vendorSitesList(newExecutorCode, getRegionID());
		}
		executorcode = newExecutorCode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.11.2005 17:21:24)
	 */
	private void initRegionID_and_ListCustomers_and_VendorSitesList(HttpServletRequest request) {
		Integer newRegionID = ProfileAccessHelper.getCurrentRegionID(request);
		if (newRegionID != null) {
			if(!newRegionID.equals(getRegionID())){
				//initListCustomers(newRegionID);
				initExecutor_vendorSitesList(getExecutorcode(), newRegionID);			
			}
			setRegionID(newRegionID);
		} else {
			setRegionID(null);
		}
	}	
	/**
	 * 
	 * @param newExecutorCode
	 * @param newRegionID
	 */
	private void initExecutor_vendorSitesList(Integer newExecutorCode, Integer newRegionID) {
		if(newExecutorCode != null && newRegionID != null){
			setExecutor_vendorSitesList(CDBC_VendorSite_Object.findList(Boolean.TRUE, newExecutorCode, Boolean.FALSE, null, Boolean.FALSE, null, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, newRegionID, null));
			setExecutor_vendocSiteId(NULL_ID);
		}else{
			setExecutor_vendorSitesList(Collections.EMPTY_LIST);
			setExecutor_vendocSiteId(NULL_ID);
		}	
	}
	/**
	 * @return
	 */
	public java.lang.String getExecutorname() {
		return executorname;
	}

	/**
	 * @param string
	 */
	public void setExecutorname(java.lang.String string) {
		executorname = string;
	}

}
