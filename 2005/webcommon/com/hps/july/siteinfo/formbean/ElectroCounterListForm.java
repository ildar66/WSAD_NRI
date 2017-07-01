package com.hps.july.siteinfo.formbean;

import com.hps.july.web.util.*;
import java.sql.Date;

/**
 * Класс, реализующий форму отображения списка электросчётчиков
 * Creation date: (10.08.2004 18:17:37)
 * @author: Vadim Glushkov
 */
public class ElectroCounterListForm extends com.hps.july.web.util.BrowseForm {

	private String searchFor = null;
	private String searchValue = null;

	private String state = null;

	private String control = null;
	private String controlValueFrm = null;
	private StringAndSqlDateProperty controlValue = new StringAndSqlDateProperty();

	private java.lang.Integer sortOrder = new Integer(1);
	private String orderBy = "next_verification";
	
	private String operation = EMPTY;
	//константы operation:
	public final static String EMPTY = "";
	public final static String PRINT_XLS = "printXLS";
	public final static String SORT_BY = "sortBy";
	/**
	 * ElectroCounterListForm constructor comment.
	 */
	public ElectroCounterListForm() {
		this.searchFor = new String("1");
		this.searchValue = new String("");
		this.state = new String("1");
		this.control = new String("2");
		this.controlValue.setSqlDate(new java.sql.Date(System.currentTimeMillis()));
		setLastVisited(true);
	}
	/**
	 * Возвращает имя bean для броуза.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBCElectroCounterObject";
	}
	public String getControl() {
		return control;
	}
	public Date getControlValue() {
		return controlValue.getSqlDate();
	}
	public String getControlValueFrm() {
		return controlValue.getString();
	}
	/**
	 * Возвращает список ролей, которым разрешено редактирование.
	 * Creation date: (27.06.2002 16:47:06)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("electroCounterEditor");
		roles.add("administrator");
		return roles;
	}
	/**
	 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
	 * Creation date: (10.08.2004 18:17:37)
	 * @return java.lang.Object[]
	 */
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2004 13:54:47)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getSortOrder() {
		return sortOrder;
	}

	public Object[] getFilterParams() {
		return new Object[] { searchFor, searchValue, state, control, controlValue.getSqlDate(), getOrderBy()};
	}
	/**
	 * Возвращает имя метода поиска.
	 * Creation date: (22.01.2002 11:20:35)
	 * @return java.lang.String
	 */
	public java.lang.String getFinderMethodName() {
		return "listElectroCounters";
	}
	public String getSearchFor() {
		return searchFor;
	}
	public String getSearchValue() {
		return searchValue;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2004 13:54:47)
	 * @return java.lang.Integer
	 */
	public String getOrderBy() {
		return orderBy;
	}
	public String getState() {
		return state;
	}
	public void setControl(String control) {
		this.control = control;
	}
	public void setControlValue(Date controlValue) {
		this.controlValue.setSqlDate(controlValue);
	}
	public void setControlValueFrm(String controlValue) {
		this.controlValue.setString(controlValue);
	}
	/**
	 * Устанавливает имя метода поиска.
	 * Creation date: (22.01.2002 11:20:35)
	 * @param newFinderMethodName java.lang.String
	
	public void setFinderMethodName(java.lang.String name) {
		System.out.println("SORT [" + name + "]");
		try {
			sortOrder = new Integer(name);
		} catch (Exception e) {
		}
	}
	 */

	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2004 13:54:47)
	 * @param newSortOrder java.lang.Integer
	 */
	public void setSortOrder(java.lang.Integer newSortOrder) {
		sortOrder = newSortOrder;
	}

	public void setSearchFor(String searchFor) {
		this.searchFor = searchFor;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2004 13:54:47)
	 * @param newSortOrder java.lang.Integer
	 */
	public void setOrderBy(String newSortOrder) {
		orderBy = newSortOrder;
	}
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param string
	 */
	public void setOperation(String string) {
		operation = string;
	}

}
