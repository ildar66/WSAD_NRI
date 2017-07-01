package com.hps.july.dictionary.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.struts.action.*;

import com.hps.july.valueobject.VendorSite_VO;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.dictionary.valueobject.*;
import com.hps.july.cdbc.objects.*;
/**
 * —правочник расчетных счетов организаций ListForm.
* Creation date: (21.03.2006 12:31:22)
* @author: Shafigullin Ildar
*/
public class AccountsListForm extends com.hps.july.web.util.BrowseForm {
	private int filter; //фильтр запроса
	private String searchString; //строка запрос
	private java.lang.String sortBy; //признак сортировки
	private int idVendorSite;
	private VendorSite_VO vendorSite_VO;
	/**
	 * ‘орма дл€ расчетных счетов банков
	 */
	public AccountsListForm() {
		super();
		this.setFinderMethodName("findList");

		setFilter(-1);//-1 == заглушка дл€ фильтра(если понадобитс€ - установить реальное значение)
		setSearchString("");
		setSortBy("account desc");
	}
	/**
	 * ¬озвращает им€ bean дл€ броуза.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBC_Accounts_Object";
	}
	/**
	 * ¬озвращает список ролей, которым разрешено редактирование.
	 * Creation date: (27.06.2002 16:47:06)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("administrator");
		roles.add("dictPartAdmin");
		roles.add("MainEconomist");
		roles.add("Economist");
		roles.add("ArendaEconomist");
		roles.add("ArendaMainEconomist");
		return roles;
	}
	/**
	 * ¬озвращает параметры, которые будут подставл€тс€ в метод поиска данных.
	 * Creation date: (23.03.2005 12:31:22)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		return new Object[] { Boolean.TRUE, new Integer(getIdVendorSite()),
			//getFilter() == 1 ? Boolean.TRUE : Boolean.FALSE,		getSearchString(),
			//getFilter() == 2 ? Boolean.TRUE : Boolean.FALSE,		getSearchString(),
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
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.ACCOUNTS_LIST);
		setVendorSite_VO(CDBC_VendorSite_Object.find(new Integer(getIdVendorSite())));
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
	public int getIdVendorSite() {
		return idVendorSite;
	}

	/**
	 * @param i
	 */
	public void setIdVendorSite(int i) {
		idVendorSite = i;
	}

	/**
	 * @return
	 */
	public VendorSite_VO getVendorSite_VO() {
		return vendorSite_VO;
	}

	/**
	 * @param site_VO
	 */
	protected void setVendorSite_VO(VendorSite_VO site_VO) {
		vendorSite_VO = site_VO;
	}

}
