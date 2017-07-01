package com.hps.july.arenda.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.constants.Applications;
import com.hps.july.arenda.APPStates;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.util.*;
import com.hps.july.logic.*;
/**
 * Form-Bean "лист Служебных записок"
 * Creation date: (22.07.2004 16:28:41)
 * @author: Shafigullin Ildar
 */
public class MemoListDetachForm extends BrowseForm {
    private java.lang.String sortBy = "number desc"; //признак сортировки
    private int filter = 0;
    private String searchstring = "";
    private DataPeriod dataPeriod = new DataPeriod();
    private java.lang.Boolean isDataPeriod = Boolean.FALSE;
    private java.lang.Boolean isSearchString = Boolean.TRUE;
    private java.lang.String operation = "";
    private java.lang.Integer abonentContract = null;
    private java.lang.Integer idHeader = null;
/**
 * MemoListForm constructor comment.
 */
public MemoListDetachForm() {
	super();
	setFinderMethodName("findListMemoDetach");
	setLastVisited(true);
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
		System.out.println("Memo_LIST: CLASS_CAST: " + o.getClass().getName());
		return o;
	}
	CDBCRowObject ro =(CDBCRowObject) o;
	Memo_VO memo = new Memo_VO(ro);
	memo.initDetachInfo(ro);
	return memo; 
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 17:39:51)
 * @return java.lang.Integer
 */
public java.lang.Integer getAbonentContract() {
	return abonentContract;
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBC_Memo_Object"; 
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 14:09:41)
 * @return com.hps.july.logic.DataPeriod
 */
public com.hps.july.logic.DataPeriod getDataPeriod() {
	return dataPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 13:51:21)
 * @return int
 */
public int getFilter() {
	return filter;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2004 18:11:03)
 * @return java.lang.Object[]
 */
public Object[] getFilterParams() {
    return new Object[] {
        new Integer("-1"),
        getIsSearchString(),        new Integer(getFilter()),        getSearchstring(),
        getIsDataPeriod(),        getDataPeriod().getFromDate(),        getDataPeriod().getToDate(),
        getSortBy()};
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 17:40:37)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdHeader() {
	return idHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 14:13:32)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDataPeriod() {
	return isDataPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 14:28:21)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsSearchString() {
	return isSearchString;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 17:38:46)
 * @return java.lang.String
 */
public java.lang.String getOperation() {
	return operation;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 13:51:21)
 * @return java.lang.String
 */
public java.lang.String getSearchstring() {
	return searchstring;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 14:28:23)
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
    ParamsParser.setState(request, Applications.ARENDA, APPStates.MEMO_LIST_DETACH);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 17:39:51)
 * @param newAbonentContract java.lang.Integer
 */
public void setAbonentContract(java.lang.Integer newAbonentContract) {
	abonentContract = newAbonentContract;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 14:09:41)
 * @param newDataPeriod com.hps.july.logic.DataPeriod
 */
public void setDataPeriod(com.hps.july.logic.DataPeriod newDataPeriod) {
	dataPeriod = newDataPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 13:51:21)
 * @param newFilter int
 */
public void setFilter(int newFilter) {
	filter = newFilter;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 17:40:37)
 * @param newIdHeader java.lang.Integer
 */
public void setIdHeader(java.lang.Integer newIdHeader) {
	idHeader = newIdHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 14:13:32)
 * @param newIsDataPeriod java.lang.Boolean
 */
public void setIsDataPeriod(java.lang.Boolean newIsDataPeriod) {
	isDataPeriod = newIsDataPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 14:28:21)
 * @param newIsSearchString java.lang.Boolean
 */
public void setIsSearchString(java.lang.Boolean newIsSearchString) {
	isSearchString = newIsSearchString;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 17:38:46)
 * @param newOperation java.lang.String
 */
public void setOperation(java.lang.String newOperation) {
	operation = newOperation;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 13:51:21)
 * @param newSearchstring java.lang.String
 */
public void setSearchstring(java.lang.String newSearchstring) {
	searchstring = newSearchstring;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 14:28:23)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
/**
 * Метод для проверки правильности введеных значений.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(org.apache.struts.action.ActionErrors errors) throws Exception {
    if (operation.equalsIgnoreCase("atachMemo")) {
        CDBC_Memo_Object.atachMemo(getIdHeader().intValue(), getAbonentContract().intValue());
       //errors.add("org.apache.struts.action.GLOBAL_WARNING",   new ActionError("error.txt", "Данная служебка прикреплена к договору :" + getAbonentContract()));
        setOperation("");
    }
}
}
