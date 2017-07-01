package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;

import com.hps.july.web.util.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.arenda.cdbcobjects.CDBC_Helper;
import com.hps.july.arenda.cdbcobjects.CDBC_LeaseRegistryBuchDocs_Object;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.cdbc.lib.*;
/**
 * "—писок документов дл€ передачи в бухгалтерию" BrowseForm Object.
 * Creation date: (12.10.2005 15:40:48)
 * @author: Shafigullin Ildar
 */
public class RegistryBuchDocsListForm extends com.hps.july.web.util.BrowseForm {
	private String searchTypeRegistry; //тип описи
	private int filter;
	private String searchString;
	private java.lang.String sortBy; //признак сортировки
	private java.lang.Integer operatorCode;
	//private java.lang.Integer workerID;
	//работаем с разделением по филиалам:
	private Boolean isRegionID = new Boolean(true);
	private Integer regionID = null;
	//изменение состо€ни€:
	private java.lang.String operation = "";
	private int idCode = -1;
	private java.lang.String toState = "";
	private String sortByForWord;
	//фильтр типа возрата описи:
	private int typeTransferRegistry = 0;
	// онтроль состо€ни€ описи(зависит от региона):
	private AbstractRegistryBuchDocsStateFactory regBuchDocsState = null;
	/**
	 * RegistryBuchDocsListForm constructor comment.
	 */
	public RegistryBuchDocsListForm() {
		super();

		setSearchTypeRegistry("ALL"); //
		setFilter(2);
		setSearchString("");
		setSortBy("idRegistryDoc desc");
		setSortByForWord("numberPosition");

		setLastVisited(true);
	}
	/**
	 * ¬озвращает им€ bean дл€ броуза.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.arenda.cdbcobjects.CDBC_LeaseRegistryBuchDocs_Object";
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:39:52)
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("ArendaMainEconomist");
		roles.add("ArendaEconomist");
		roles.add("ArendaAccountant");
		roles.add("ArendaPurchaser");
		roles.add("administrator");
		return roles;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.10.2005 16:04:43)
	 * @return int
	 */
	public int getFilter() {
		return filter;
	}
	/**
	 * ¬озвращает параметры, которые будут подставл€тс€ в метод поиска данных.
	 * Creation date: (12.10.2005 15:40:48)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {

		Boolean isTypeRegistry = "ALL".equals(getSearchTypeRegistry()) ? Boolean.FALSE : Boolean.TRUE;

		return new Object[] {
			 isTypeRegistry, getSearchTypeRegistry(),
			 getFilter() == 1 ? Boolean.TRUE : Boolean.FALSE, getSearchString(),
			 getFilter() == 3 ? Boolean.TRUE : Boolean.FALSE, getSearchString(),
			 isRegionID, getRegionID(),
			 getFilter() == 2 ? Boolean.TRUE : Boolean.FALSE, getOperatorCode(),
			 getTypeTransferRegistry() != 0 ? Boolean.TRUE : Boolean.FALSE, new Integer(getTypeTransferRegistry()),			 
			 getSortBy()};
	}
	/**
	 * ¬озвращает им€ метода поиска.
	 * Creation date: (22.01.2002 11:20:35)
	 * @return java.lang.String
	 */
	public java.lang.String getFinderMethodName() {
		return "getList";
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (12.10.2005 16:04:43)
	 * @return java.lang.String
	 */
	public java.lang.String getSearchString() {
		return searchString;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.10.2005 16:04:43)
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
		if (getOperatorCode() == null)
			initOperatorCode(request);
		//if (getWorkerID() == null)initWorkerID(request);
		initRegionID(request);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.REGISTRY_BUCH_DOCS_LIST);
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.10.2005 16:04:43)
	 * @param newFilter int
	 */
	public void setFilter(int newFilter) {
		filter = newFilter;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.10.2005 16:04:43)
	 * @param newSortBy java.lang.String
	 */
	public void setSortBy(java.lang.String newSortBy) {
		sortBy = newSortBy;
	}
	/**
	 * @return
	 */
	public String getSearchTypeRegistry() {
		return searchTypeRegistry;
	}

	/**
	 * @param string
	 */
	public void setSearchString(String string) {
		searchString = string;
	}

	/**
	 * @param string
	 */
	public void setSearchTypeRegistry(String string) {
		searchTypeRegistry = string;
	}

	/**
	 * 
	 * @param request
	 */

	private void initOperatorCode(javax.servlet.http.HttpServletRequest request) {
		setOperatorCode(OperatorObject.getOperatorCode(request.getRemoteUser()));
	}
	/**
	 * 
	 * @param request
	
	
	private void initWorkerID(javax.servlet.http.HttpServletRequest request) {
		setWorkerID(CDBC_Helper.getWorkerID_fromRemoteUser(request.getRemoteUser()));
	}
	 */
	/**
	 * @return
	 */
	public java.lang.Integer getOperatorCode() {
		return operatorCode;
	}

	/**
	 * @param integer
	 */
	private void setOperatorCode(java.lang.Integer integer) {
		operatorCode = integer;
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
	 * Insert the method's description here.
	 * Creation date: (28.11.2005 12:31:52)
	 */
	private void initRegionID(HttpServletRequest request) {
		ProfileAccess profileAccess = getProfileAccess(request);
		if (profileAccess.getCurrRegion() != null) {
			Integer newRegionID = profileAccess.getCurrRegion().getVo().getRegionid();
			setRegionID(newRegionID);
			setRegBuchDocsState(AbstractRegistryBuchDocsStateFactory.getFactory("Y".equals(profileAccess.getCurrRegion().getVo().getHasArendaPurchaser())));
		} else {
			//throw new RuntimeException("нет текущего региона дл€ аренды!!!");
			System.out.println("нет текущего региона дл€ аренды!!!");
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

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		operation = "";
		idCode = -1;
		toState = "";
	}
	/**
	 * @return
	 */
	public int getIdCode() {
		return idCode;
	}

	/**
	 * @return
	 */
	public Boolean getIsRegionID() {
		return isRegionID;
	}

	/**
	 * @return
	 */
	public java.lang.String getOperation() {
		return operation;
	}

	/**
	 * @return
	 */
	public java.lang.String getToState() {
		return toState;
	}

	/**
	 * @param i
	 */
	public void setIdCode(int i) {
		idCode = i;
	}

	/**
	 * @param boolean1
	 */
	public void setIsRegionID(Boolean boolean1) {
		isRegionID = boolean1;
	}

	/**
	 * @param string
	 */
	public void setOperation(java.lang.String string) {
		operation = string;
	}

	/**
	 * @param string
	 */
	public void setToState(java.lang.String string) {
		toState = string;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#validateValues(org.apache.struts.action.ActionErrors)
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		if (operation.equalsIgnoreCase("deleteItem")) {
			//deleteItem(errors);
		} else if (operation.equalsIgnoreCase("changeState")) {
			changeState(errors);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2004 14:45:13)
	 * @param errors org.apache.struts.action.ActionErrors
	 */
	private void changeState(ActionErrors errors) {
		String errorTxt = CDBC_LeaseRegistryBuchDocs_Object.changeStateRegistryBuchDoc(getIdCode(), getToState(), getOperatorCode().intValue());
		if (!errorTxt.equals("")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorTxt));
		}
	}

	/**
	 * @return
	
	public java.lang.Integer getWorkerID() {
		return workerID;
	}
	 */
	/**
	 * @param integer
	
	private void setWorkerID(java.lang.Integer integer) {
		workerID = integer;
	}
	 */
	/**
	 * @return
	 */
	public String getSortByForWord() {
		return sortByForWord;
	}

	/**
	 * @param string
	 */
	public void setSortByForWord(String string) {
		sortByForWord = string;
	}

	/**
	 * @return
	 */
	public int getTypeTransferRegistry() {
		return typeTransferRegistry;
	}

	/**
	 * @param i
	 */
	public void setTypeTransferRegistry(int i) {
		typeTransferRegistry = i;
	}

	/**
	 * @return
	 */
	public AbstractRegistryBuchDocsStateFactory getRegBuchDocsState() {
		return regBuchDocsState;
	}

	/**
	 * @param factory
	 */
	private void setRegBuchDocsState(AbstractRegistryBuchDocsStateFactory factory) {
		regBuchDocsState = factory;
	}

}
