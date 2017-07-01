package com.hps.july.siteinfo.formbean;

import com.hps.july.web.util.*;
import java.util.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * ����� ������ ��������
 */
public class RegionListForm extends com.hps.july.web.util.BrowseForm {
    private Boolean isAllSuperRegions = Boolean.TRUE; 
    private String searchType = SearchConstants.SEARCH_ALL; // ��� ������
    private Enumeration superRegions; // ������ �������������
    private StringAndIntegerProperty superRegion=new StringAndIntegerProperty(); // ������������� ������������
    private String name=""; // ������������ �������
    private int order=RegionObject.ORDER_BY_CODE_ASC; // ������� ����������
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
 * ����� ���������� ��� ������, ������������� ��� ������ ������ ��������
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
 * ����� ���������� ��� �������
 */
public java.lang.String getName() {
	return name;
}
/**
 * ����� ���������� ������� ��������� ��������
 */
public Integer getOrder() {
    try {
        order = Integer.parseInt(super.getFinderMethodName());
    } catch (Exception e) {
    }
    return new Integer(order);
}
/**
 * ����� ���������� ��� ������
 */
public java.lang.String getSearchType() {
	return searchType;
}
/**
 * ����� ���������� ��� ������������
 */
public String getSuperRegionCode() {
	return superRegion.getString();
}
/**
 * ����� ���������� ������ �������������
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
 * ������������� ������������ �������
 */
public void setName(java.lang.String newName) {
	name = newName.trim();
}
/**
 * ������������� ������� ����������
 */
public void setOrder(int newOrder) {
	order = newOrder;
}
/**
 * ������������� ��� ������
 */
public void setSearchType(java.lang.String newSearchType) {
	searchType = newSearchType;
}
/**
 * ������������� ������������ ������������
 */
public void setSuperRegionCode(String code) {
	superRegion.setString(code);
	
	
	}
}
