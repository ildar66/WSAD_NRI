package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;
import java.sql.*;
import javax.servlet.http.*;
import java.util.*;

import com.hps.july.cdbc.objects.*;
import com.hps.july.util.*;
import com.hps.july.valueobject.*;
import com.hps.july.arenda.cdbcobjects.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.logic.DataPeriod;
/**
* Creation date: (05.05.2005 15:09:58)
* @author: Shafigullin Ildar
*/
public class LicenceListForm extends org.apache.struts.action.ActionForm {
    private java.lang.String school = "";
    private int count = 3000;
    private int start = 0;
    private com.hps.july.arenda.cdbcobjects.Page page;
	private java.lang.String sortBy = "name";
	private java.lang.String searchstring ="";//строка поиска
	private int filter= 0;//фильтр поиска
	private DataPeriod dataPeriod = new DataPeriod();
	private int[] types;
	private boolean isDateModified = true;
	private boolean isDopFilter = false;
	private java.lang.Integer operator = null;
	private String userName = null;
	private LicenciesShowColumn showColumn = new LicenciesShowColumn();
	private java.lang.String comand = "";
	//доступ по филиалам:
	private List regionAccessList = null;
	private int currRegionID = 0;	
/**
 * Insert the method's description here.
 * Creation date: (05.05.2005 15:11:38)
 */
public LicenceListForm() {}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2005 13:33:34)
 */
public void doTask(ActionErrors errors, HttpServletRequest request) {
    try {
        if (getOperator() == null){
            initOperatorInfo(request);
            initShowColumn(request);
            initLicenceRegionAccsByOperator();
        }
        //request.setAttribute("regionAccessList", regionAccessList);           
        initStart();
        page = Page.EMPTY_PAGE;
        page = new LicenceDAO().executeSelect(this, start, count, getSortBy());
    } catch (SQLException e) {
        System.out.println("SQLException LicenceListFirm.doTask : ");
        System.out.println("ERROR: code=" + e.getErrorCode() + ", msg=" + e.getLocalizedMessage());
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.txt", "SQLException: Ошибка выполнения LicenceListFirm.doTask ERROR:code=" + e.getErrorCode()));
        e.printStackTrace(System.out);
    } catch (ServiceLocatorException exc) {
        System.out.println("ServiceLocatorException LicenceListFirm.doTask:" + exc);
        exc.printStackTrace(System.out);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 15:47:58)
 * @return java.lang.String
 */
public java.lang.String getComand() {
	return comand;
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2005 13:24:43)
 * @return int
 */
public int getCount() {
	return count;
}
/**
 * Insert the method's description here.
 * Creation date: (18.05.2005 18:54:29)
 * @return com.hps.july.logic.DataPeriod
 */
public com.hps.july.logic.DataPeriod getDataPeriod() {
	return dataPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (15.05.2005 16:01:06)
 * @return int
 */
public int getFilter() {
	return filter;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2005 18:02:30)
 * @return boolean
 */
public boolean getIsDateModified() {
	return isDateModified;
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2005 11:02:14)
 * @return boolean
 */
public boolean getIsDopFilter() {
	return isDopFilter;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2005 11:56:04)
 * @return java.lang.Integer
 */
public java.lang.Integer getOperator() {
	return operator;
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2005 13:32:31)
 * @return com.hps.july.arenda.cdbcobjects.Page
 */
public com.hps.july.arenda.cdbcobjects.Page getPage() {
	return page;
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2005 13:24:21)
 * @return java.lang.String
 */
public java.lang.String getSchool() {
	return school;
}
/**
 * Insert the method's description here.
 * Creation date: (15.05.2005 16:00:52)
 * @return java.lang.String
 */
public java.lang.String getSearchstring() {
	return searchstring;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2005 13:37:02)
 * @return LicenciesShowColumn
 */
public LicenciesShowColumn getShowColumn() {
	return showColumn;
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2005 13:41:15)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2005 13:25:02)
 * @return int
 */
public int getStart() {
	return start;
}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2005 11:01:07)
 * @return int[]
 */
public int[] getTypes() {
	return types;
}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2005 11:31:37)
 * @return java.lang.String
 */
public String getTypesStr() {
    StringBuffer sb = new StringBuffer();
    if (getTypes() != null && getTypes()[0] != 0) {
        for (int i = 0; i < getTypes().length; i++) {
            sb.append(getTypes()[i]);
            if (i < getTypes().length - 1)
                sb.append(", ");
        }
    } else
        sb.append("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13");
    //System.out.println(sb.toString());
    return sb.toString();
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2005 11:57:15)
 */
private void initOperatorInfo(HttpServletRequest request) {
    try {
	    String userName=  request.getUserPrincipal().getName();
	    //System.out.println("userName=" + userName);//temp
        int operator = new com.hps.july.persistence.OperatorAccessBean().findByLogin(userName).getOperator();
        setOperator(new Integer(operator));
        setUserName(userName);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2005 13:33:41)
 */
private void initShowColumn(HttpServletRequest request) {
    if (request.isUserInRole("administrator"))
        getShowColumn().or(LicenciesShowColumn.forAdmin);
    if (request.isUserInRole("lcsEditAllLicence"))
        getShowColumn().or(LicenciesShowColumn.forLcsEditAllLicence);
    if (request.isUserInRole("ArendaMainEconomist")) {
        getShowColumn().or(LicenciesShowColumn.forLcsEditAllLicence);
        getShowColumn().setIsEdit(false);
    }
    if (request.isUserInRole("ArendaDirector")) {
        getShowColumn().or(LicenciesShowColumn.forLcsEditAllLicence);
        getShowColumn().setIsEdit(false);
    }
    if (request.isUserInRole("ArendaMainManager")) {
        getShowColumn().or(LicenciesShowColumn.forLcsEditAllLicence);
        getShowColumn().setIsEdit(false);
    }    
    if (request.isUserInRole("lcsEditFAS"))
        getShowColumn().or(LicenciesShowColumn.forLcsEditFAS);
    if (request.isUserInRole("lcsEditGPS"))
        getShowColumn().or(LicenciesShowColumn.forLcsEditGPS);
    if (request.isUserInRole("lcsEditGASN"))
        getShowColumn().or(LicenciesShowColumn.forLcsEditGASN);
    if (request.isUserInRole("lcsEditSES"))
        getShowColumn().or(LicenciesShowColumn.forLcsEditSES);
    if (request.isUserInRole("lcsEditElectro"))
        getShowColumn().or(LicenciesShowColumn.forLcsEditElectro);
    if (request.isUserInRole("lcsEditLand"))
        getShowColumn().or(LicenciesShowColumn.forLcsEditLand);
    if (request.isUserInRole("lcsEditProperty"))
        getShowColumn().or(LicenciesShowColumn.forLcsEditProperty);
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2005 13:26:39)
 */
private void initStart() {
    if (page != null) {
        if (getSchool().equalsIgnoreCase("next"))
            start = page.getStartOfNextPage();
        else if (getSchool().equalsIgnoreCase("previous"))
            start = page.getStartOfPreviousPage();
        else if (getSchool().equalsIgnoreCase(""))
            start = 0;            
    } else
        start = 0;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 15:47:58)
 * @param newComand java.lang.String
 */
public void setComand(java.lang.String newComand) {
	comand = newComand;
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2005 13:24:43)
 * @param newCount int
 */
public void setCount(int newCount) {
    if (newCount < 0)
        count = -newCount;
    else
        count = newCount;
}
/**
 * Insert the method's description here.
 * Creation date: (18.05.2005 18:54:29)
 * @param newDataPeriod com.hps.july.logic.DataPeriod
 */
public void setDataPeriod(com.hps.july.logic.DataPeriod newDataPeriod) {
	dataPeriod = newDataPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (15.05.2005 16:01:06)
 * @param newFilter int
 */
public void setFilter(int newFilter) {
	filter = newFilter;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2005 18:02:30)
 * @param newIsDateModified boolean
 */
public void setIsDateModified(boolean newIsDateModified) {
	isDateModified = newIsDateModified;
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2005 11:02:14)
 * @param newIsDopFilter boolean
 */
public void setIsDopFilter(boolean newIsDopFilter) {
	isDopFilter = newIsDopFilter;
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2005 11:56:04)
 * @param newOperator java.lang.Integer
 */
private void setOperator(java.lang.Integer newOperator) {
	operator = newOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2005 13:32:31)
 * @param newPage com.hps.july.arenda.cdbcobjects.Page
 */
public void setPage(com.hps.july.arenda.cdbcobjects.Page newPage) {
	page = newPage;
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2005 13:24:21)
 * @param newSchool java.lang.String
 */
public void setSchool(java.lang.String newSchool) {
	school = newSchool;
}
/**
 * Insert the method's description here.
 * Creation date: (15.05.2005 16:00:52)
 * @param newSearchstring java.lang.String
 */
public void setSearchstring(java.lang.String newSearchstring) {
	searchstring = newSearchstring;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2005 13:37:02)
 * @param newShowColumn LicenciesShowColumn
 */
private void setShowColumn(LicenciesShowColumn newShowColumn) {
	showColumn = newShowColumn;
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2005 13:41:15)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2005 13:25:02)
 * @param newStart int
 */
public void setStart(int newStart) {
    if (newStart < 0)
        start = -newStart;
    else
        start = newStart;
}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2005 11:01:07)
 * @param newTypes int[]
 */
public void setTypes(int[] newTypes) {
	types = newTypes;
}
/**
 * доступ по филиалам
 */
private void initLicenceRegionAccsByOperator(){
	regionAccessList = CDBC_RegionsAccess_Object.findLicenceRegionAccsByOperator(getOperator(), null);
	if (regionAccessList.size() > 0) {
		RegionsAccess_TO currRegion = (RegionsAccess_TO )regionAccessList.get(0);
		setCurrRegionID(currRegion.getVo().getRegionid().intValue());
	}
}
	/**
	 * @return
	 */
	public List getRegionAccessList() {
		return regionAccessList;
	}

	/**
	 * @param list
	 */
	private void setRegionAccessList(List list) {
		regionAccessList = list;
	}

	/**
	 * @return
	 */
	public int getCurrRegionID() {
		return currRegionID;
	}

	/**
	 * @param i
	 */
	public void setCurrRegionID(int i) {
		currRegionID = i;
	}

	/**
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param string
	 */
	private void setUserName(String string) {
		userName = string;
	}

}
