package com.hps.july.dictionary.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.struts.action.*;

import com.hps.july.valueobject.Vendor_VO;
import com.hps.july.web.util.*;
import com.hps.july.arenda.formbean.RegionFactoryAbstract;
import com.hps.july.arenda.formbean.VendorFormView;
import com.hps.july.constants.Applications;
import com.hps.july.dictionary.valueobject.*;
import com.hps.july.cdbc.lib.*;
/**
 * ѕоставщики ListForm.
* Creation date: (21.03.2006 12:31:22)
* @author: Shafigullin Ildar
*/
public class VendorListForm extends com.hps.july.web.util.BrowseForm {
	private int filter;//фильтр запроса
	private String searchString;//строка запрос
	private java.lang.String sortBy; //признак сортировки
	private Boolean isUseInNri;
	private Boolean isRecordStatus;
	private Integer typeVendor;
	//работаем с разделением по филиалам:
	private Integer regionID = null;
	private VendorFormView vendorFormView = null;	
/**
 * ‘орма дл€ справочника банков
 */
public VendorListForm() {
	super();
	this.setFinderMethodName("findList");
	setLastVisited(true);
	
	setFilter(1);
	setSearchString("");
	setSortBy("name desc");
	
	setIsRecordStatus(Boolean.TRUE);
	setIsUseInNri(Boolean.TRUE);

	setTypeVendor(new Integer(Vendor_VO.TYPE_VENDOR_JURIDICAL));
}
/**
 * ¬озвращает им€ bean дл€ броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBC_Vendor_Object";
}
/**
 * ¬озвращает список ролей, которым разрешено редактирование.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("developer");
	//roles.add("editBank");
	return roles;
}
/**
 * ¬озвращает параметры, которые будут подставл€тс€ в метод поиска данных.
 * Creation date: (23.03.2005 12:31:22)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		new Integer(getFilter()),		getSearchString(),
		getIsUseInNri(),
		getIsRecordStatus(),
		getTypeVendor().intValue()==-1? Boolean.FALSE : Boolean.TRUE, getTypeVendor(),
		getSortBy()};
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:38:19)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * »нициализаци€ режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
	ParamsParser.setState(request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.VENDOR_LIST);
	setRegionID(ProfileAccessHelper.getCurrentRegionID(request));
	setVendorFormView(RegionFactoryAbstract.getFactory(getRegionID().intValue()).getVendorFormView());		
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 12:38:19)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
	/**
	 * @return
	 */
	public int getFilter() {
		return filter;
	}

	/**
	 * @return
	 */
	public String getSearchString() {
		return searchString;
	}

	/**
	 * @param i
	 */
	public void setFilter(int i) {
		filter = i;
	}

	/**
	 * @param string
	 */
	public void setSearchString(String string) {
		searchString = string;
	}

	/**
	 * @return
	 */
	public Boolean getIsRecordStatus() {
		return isRecordStatus;
	}

	/**
	 * @return
	 */
	public Boolean getIsUseInNri() {
		return isUseInNri;
	}

	/**
	 * @param boolean1
	 */
	public void setIsRecordStatus(Boolean boolean1) {
		isRecordStatus = boolean1;
	}

	/**
	 * @param boolean1
	 */
	public void setIsUseInNri(Boolean boolean1) {
		isUseInNri = boolean1;
	}

	/**
	 * @return
	 */
	public Integer getTypeVendor() {
		return typeVendor;
	}

	/**
	 * @param integer
	 */
	public void setTypeVendor(Integer integer) {
		typeVendor = integer;
	}

	/**
	 * @return
	 */
	protected Integer getRegionID() {
		return regionID;
	}

	/**
	 * @return
	 */
	public VendorFormView getVendorFormView() {
		return vendorFormView;
	}

	/**
	 * @param integer
	 */
	protected void setRegionID(Integer integer) {
		regionID = integer;
	}

	/**
	 * @param view
	 */
	protected void setVendorFormView(VendorFormView view) {
		vendorFormView = view;
	}

}
