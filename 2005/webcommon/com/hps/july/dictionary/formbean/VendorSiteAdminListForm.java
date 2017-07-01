package com.hps.july.dictionary.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.struts.action.*;

import com.hps.july.valueobject.Vendor_VO;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.dictionary.valueobject.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.CDBC_Vendor_Object;
/**
 * Отделения поставщиков ListForm.
* Creation date: (21.03.2006 12:31:22)
* @author: Shafigullin Ildar
*/
public class VendorSiteAdminListForm extends com.hps.july.web.util.BrowseForm {
	private int filter; //фильтр запроса
	private String searchString; //строка запрос
	private java.lang.String sortBy; //признак сортировки
	private Boolean isUseInNri;
	private Boolean isRecordStatus;
	private int idVendor;
	private Vendor_VO vendor_VO;
	/**
	 * Форма для справочника банков
	 */
	public VendorSiteAdminListForm() {
		super();
		this.setFinderMethodName("findList");

		setFilter(-1); //заглушка для фильтра(если понадобится - установить реальное значение)
		setSearchString("");
		setSortBy("name desc");

		setIsRecordStatus(Boolean.TRUE);
		setIsUseInNri(Boolean.TRUE);
	}
	/**
	 * Возвращает имя bean для броуза.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBC_VendorSite_Object";
	}
	/**
	 * Возвращает список ролей, которым разрешено редактирование.
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
	 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
	 * Creation date: (23.03.2005 12:31:22)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		return new Object[] {
			Boolean.TRUE,			new Integer(getIdVendor()),
			getFilter() == 1 ? Boolean.TRUE : Boolean.FALSE,			getSearchString(),
			getFilter() == 2 ? Boolean.TRUE : Boolean.FALSE,			getSearchString(),
			getIsUseInNri(),
			getIsRecordStatus(),
			Boolean.FALSE,  new Integer(-1),
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
	 * Инициализация режима просмотра списка.
	 * Creation date: (22.05.2002 16:35:23)
	 * @return java.lang.Object
	 * @param o java.lang.Object
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.VENDOR_SITE_ADMIN_LIST);
		setVendor_VO(CDBC_Vendor_Object.find(new Integer(getIdVendor())));
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
	public int getIdVendor() {
		return idVendor;
	}

	/**
	 * @param i
	 */
	public void setIdVendor(int i) {
		idVendor = i;
	}

	/**
	 * @return
	 */
	public Vendor_VO getVendor_VO() {
		return vendor_VO;
	}

	/**
	 * @param vendor_VO
	 */
	private void setVendor_VO(Vendor_VO vendor_VO) {
		this.vendor_VO = vendor_VO;
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	private ProfileAccess getProfileAccess(HttpServletRequest request){
		Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
		if(profile == null){
			throw new RuntimeException("Error:Profile = null");
		}
		ProfileAccess profileAccess= profile.getProfileAccess();
		if(profileAccess == null){
			throw new RuntimeException("Error:profile.getProfileAccess() = null");
		}
		return profileAccess;
	}
}
