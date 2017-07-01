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
import com.hps.july.cdbc.objects.CDBC_Vendor_Object;
/**
 * ќтделени€ поставщиков ListForm.
* Creation date: (21.03.2006 12:31:22)
* @author: Shafigullin Ildar
*/
public class VendorSiteListForm extends com.hps.july.web.util.BrowseForm {
	private int filter; //фильтр запроса
	private String searchString; //строка запрос
	private java.lang.String sortBy; //признак сортировки
	private Boolean isUseInNri;
	private Boolean isRecordStatus;
	private int idVendor;
	private Vendor_VO vendor_VO;
	//работаем с разделением по филиалам:
	private Boolean isRegionID = new Boolean(true);
	private Integer regionID = null;
	private VendorFormView vendorFormView = null;
	/**
	 * ‘орма дл€ справочника банков
	 */
	public VendorSiteListForm() {
		super();
		this.setFinderMethodName("findList");

		setFilter(-1); //заглушка дл€ фильтра(если понадобитс€ - установить реальное значение)
		setSearchString("");
		setSortBy("name desc");

		setIsRecordStatus(Boolean.TRUE);
		setIsUseInNri(Boolean.TRUE);
	}
	/**
	 * ¬озвращает им€ bean дл€ броуза.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBC_VendorSite_Object";
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
			Boolean.TRUE,			new Integer(getIdVendor()),
			getFilter() == 1 ? Boolean.TRUE : Boolean.FALSE,			getSearchString(),
			getFilter() == 2 ? Boolean.TRUE : Boolean.FALSE,			getSearchString(),
			getIsUseInNri(),
			getIsRecordStatus(),
			getIsRegionID(),  getRegionID(),
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
		ParamsParser.setState(request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.VENDOR_SITE_LIST);
		setVendor_VO(CDBC_Vendor_Object.find(new Integer(getIdVendor())));
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
	 * @return
	 */
	protected Integer getRegionID() {
		return regionID;
	}

	/**
	 * @param integer
	 */
	protected void setRegionID(Integer integer) {
		regionID = integer;
	}

	/**
	 * @return
	 */
	protected Boolean getIsRegionID() {
		return isRegionID;
	}

	/**
	 * @param boolean1
	 */
	protected void setIsRegionID(Boolean boolean1) {
		isRegionID = boolean1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.11.2005 12:31:52)

	protected void initRegionID(HttpServletRequest request) {
		ProfileAccess profileAccess = getProfileAccess(request);
		if (profileAccess.getCurrRegion() != null) {
			Integer newRegionID = profileAccess.getCurrRegion().getVo().getRegionid();
			setRegionID(newRegionID);
		} else {
			//throw new RuntimeException("нет текущего региона дл€ аренды!!!");
			System.out.println("нет текущего региона дл€ аренды!!!");
			setRegionID(null);
		}    
	}
	 */	
	/**
	 * 
	 * @param request
	 * @return

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
	 */	
	/**
	 * @return
	 */
	public VendorFormView getVendorFormView() {
		return vendorFormView;
	}

	/**
	 * @param view
	 */
	protected void setVendorFormView(VendorFormView view) {
		vendorFormView = view;
	}

}
