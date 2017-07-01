package com.hps.july.arenda.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.arenda.APPStates;
import com.hps.july.cdbc.lib.*;
import com.hps.july.arenda.valueobject.*;
/**
 * Bean-form для поиска ЗП из NFS.
 * Creation date: (06.07.2004 13:54:13)
 * @author: Shafigullin Ildar
 */
public class NFS_ZpLookupListForm extends BrowseForm {
	private int stateFilter = 1;
	private java.lang.String sortBy = "numZp desc"; //признак сортировки
	private java.lang.String filter = "";
	private java.lang.String formname = "";
	private java.lang.String fieldnames = "";
	//работаем с разделением по филиалам:
	private Boolean isRegionID = new Boolean(true);
	private Integer regionID = null;
	//переключатель дополнительного фильтра:
	private boolean isDopFilter = false;
	//доп. поиск по отделению:
	private java.lang.Boolean isAllVendorSite = Boolean.TRUE;
	private int idVendorSiteNfs = 0;
	private java.lang.String vendorSiteName = "";
	/**
	 * NFS_ZpLookupListForm constructor comment.
	 */
	public NFS_ZpLookupListForm() {
		super();
		setFinderMethodName("findLookupListZP");
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
			System.out.println("NFS_ZpLookupListForm: CLASS_CAST: " + o.getClass().getName());
			return o;
		}
		NFS_ZP_VO vo = new NFS_ZP_VO((CDBCRowObject) o);
		vo.initVendor((CDBCRowObject) o);
		vo.initContract((CDBCRowObject) o);
		return vo;
	}
	/**
	 * Возвращает имя bean для броуза.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBC_NFS_Object";
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.07.2004 12:09:36)
	 * @return java.lang.String
	 */
	public java.lang.String getFieldnames() {
		return fieldnames;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2004 14:26:13)
	 * @return java.lang.String
	 */
	public java.lang.String getFilter() {
		return filter;
	}
	/**
	 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
	 * Creation date: (06.07.2004 13:54:13)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		return new Object[] { new Integer(getStateFilter()), getFilter(), getIsAllVendorSite(), new Integer(getIdVendorSiteNfs()), isRegionID, getRegionID(), getSortBy()};
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.07.2004 12:08:46)
	 * @return java.lang.String
	 */
	public java.lang.String getFormname() {
		return formname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2004 14:20:15)
	 * @return java.lang.String
	 */
	public java.lang.String getSortBy() {
		return sortBy;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2004 14:17:20)
	 * @return int
	 */
	public int getStateFilter() {
		return stateFilter;
	}
	/**
	 * Инициализация режима просмотра списка.
	 * Creation date: (22.05.2002 16:35:23)
	 * @return java.lang.Object
	 * @param o java.lang.Object
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.NFS_ZP_LOOKUP_LIST);
		initRegionID(request);
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.11.2005 12:31:52)
	 */
	private void initRegionID(HttpServletRequest request) {
		ProfileAccess profileAccess = getProfileAccess(request);
		if (profileAccess.getCurrRegion() != null) {
			Integer newRegionID = profileAccess.getCurrRegion().getVo().getRegionid();
			setRegionID(newRegionID);
		} else {
			//throw new RuntimeException("нет текущего региона для аренды!!!");
			System.out.println("нет текущего региона для аренды!!!");
			setRegionID(null);
		}    
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
	/**
	 * Insert the method's description here.
	 * Creation date: (07.07.2004 12:09:36)
	 * @param newFieldnames java.lang.String
	 */
	public void setFieldnames(java.lang.String newFieldnames) {
		fieldnames = newFieldnames;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2004 14:26:13)
	 * @param newFilter java.lang.String
	 */
	public void setFilter(java.lang.String newFilter) {
		filter = newFilter;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.07.2004 12:08:46)
	 * @param newFormname java.lang.String
	 */
	public void setFormname(java.lang.String newFormname) {
		formname = newFormname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2004 14:20:15)
	 * @param newSortBy java.lang.String
	 */
	public void setSortBy(java.lang.String newSortBy) {
		sortBy = newSortBy;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2004 14:17:20)
	 * @param newStateFilter int
	 */
	public void setStateFilter(int newStateFilter) {
		stateFilter = newStateFilter;
	}
	/**
	 * @return
	 */
	private Integer getRegionID() {
		return regionID;
	}

	/**
	 * @param integer
	 */
	private void setRegionID(Integer integer) {
		regionID = integer;
	}
	/**
	 * @return
	 */
	public boolean getIsDopFilter() {
		return isDopFilter;
	}

	/**
	 * @param b
	 */
	public void setIsDopFilter(boolean b) {
		isDopFilter = b;
	}
	/**
	 * @return
	 */
	public java.lang.String getVendorSiteName() {
		return vendorSiteName;
	}

	/**
	 * @return
	 */
	public java.lang.Boolean getIsAllVendorSite() {
		return isAllVendorSite;
	}

	/**
	 * @return
	 */
	public int getIdVendorSiteNfs() {
		return idVendorSiteNfs;
	}

	/**
	 * @param string
	 */
	public void setVendorSiteName(java.lang.String string) {
		vendorSiteName = string;
	}

	/**
	 * @param boolean1
	 */
	public void setIsAllVendorSite(java.lang.Boolean boolean1) {
		isAllVendorSite = boolean1;
	}

	/**
	 * @param integer
	 */
	public void setIdVendorSiteNfs(int integer) {
		idVendorSiteNfs = integer;
	}

}
