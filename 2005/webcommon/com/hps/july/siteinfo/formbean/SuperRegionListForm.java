package com.hps.july.siteinfo.formbean;

import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма списка суперрегионов
 */
public class SuperRegionListForm extends com.hps.july.web.util.BrowseForm {
    private int order = SuperRegionObject.ORDER_BY_CODE_ASC;
	public SuperRegionListForm() {
		setLastVisited(true);
	}
public java.lang.Object[] getFilterParams() {
    return new Object[] { getOrder()};
}
public String getFinderMethodName() {
	return "findSuperregionsList";
}
public Integer getOrder() {
    try {
        order = Integer.parseInt(super.getFinderMethodName());
    } catch (Exception e) {
    }
    return new Integer(order);
}
}
