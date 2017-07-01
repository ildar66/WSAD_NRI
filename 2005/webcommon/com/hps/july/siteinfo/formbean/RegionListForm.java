package com.hps.july.siteinfo.formbean;

import com.hps.july.web.util.*;
import java.util.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма списка регионов
 */
public class RegionListForm extends com.hps.july.web.util.BrowseForm {
    private Boolean isAllSuperRegions = Boolean.TRUE; 
    private String searchType = SearchConstants.SEARCH_ALL; // тип поиска
    private Enumeration superRegions; // список суперрегионов
    private StringAndIntegerProperty superRegion=new StringAndIntegerProperty(); // наимернование суперрегиона
    private String name=""; // Наименование региона
    private int order=RegionObject.ORDER_BY_CODE_ASC; // порядок сортировки
	/**
	 * Insert the method's description here.
	 * Creation date: (22.01.2002 13:30:34)
	 */
	public RegionListForm() {
		setLastVisited(true);	
	}
public java.lang.Object[] getFilterParams() {
    return new Object[] {
        searchType,
        name,
        isAllSuperRegions,
        !isAllSuperRegions.booleanValue() ? superRegion.getInteger() : new Integer(0),
        getOrder()
	};
}
/**
 * Метод возвращает имя метода, используемого для поиска списка регионов
 */
public String getFinderMethodName() {
	return "findRegionList";
}
/**
 * 
 */
public java.lang.Boolean getIsAllSuperRegions() {
	return isAllSuperRegions;
}
/**
 * Метод возвращает имя региона
 */
public java.lang.String getName() {
	return name;
}
/**
 * Метод возвращает порядок сорировки регионов
 */
public Integer getOrder() {
    try {
        order = Integer.parseInt(super.getFinderMethodName());
    } catch (Exception e) {
    }
    return new Integer(order);
}
/**
 * Метод возвращает тип поиска
 */
public java.lang.String getSearchType() {
	return searchType;
}
/**
 * Метод возвращает имя суперрегиона
 */
public String getSuperRegionCode() {
	return superRegion.getString();
}
/**
 * Метод возвращает список суперрегионов
 */
public Enumeration getSuperRegions() throws Exception {

    SuperRegionAccessBeanTable table = new SuperRegionAccessBeanTable();
    table.setSuperRegionAccessBean(
        new SuperRegionAccessBean().findAllOrderByCodeAsc());

    if (superRegion.isEmpty()) {
        superRegion.setInteger(
            new Integer(table.getSuperRegionAccessBean(0).getSupregid()));
    }

    return table.rows();
}
/**
 * 
 */
public void setIsAllSuperRegions(java.lang.Boolean newIsAllSuperRegions) {
	isAllSuperRegions = newIsAllSuperRegions;
}
/**
 * Устанавливает наименование региона
 */
public void setName(java.lang.String newName) {
	name = newName.trim();
}
/**
 * Устанавливает порядок сортировки
 */
public void setOrder(int newOrder) {
	order = newOrder;
}
/**
 * Устанавливает тип поиска
 */
public void setSearchType(java.lang.String newSearchType) {
	searchType = newSearchType;
}
/**
 * Устанавливает наименование суперрегиона
 */
public void setSuperRegionCode(String code) {
	superRegion.setString(code);
	
	
	}
}
