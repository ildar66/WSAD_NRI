package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;

import javax.servlet.*;
import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.http.*;

import com.hps.july.valueobject.LeaseContractProblem_TO;
import com.hps.july.web.util.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.arenda.cdbcobjects.CDBC_LeaseContractProblem_Object;
import com.hps.july.persistence.*;
import com.hps.july.cdbc.lib.*;
/**
 * ������ �������� ������� ��������� BrowseForm Object.
 * Creation date: (12.10.2005 15:40:48)
 * @author: Shafigullin Ildar
 */
public class LeaseProblemListForm extends com.hps.july.web.util.BrowseForm {
	private int filter;
	private String searchString;
	private java.lang.String sortBy; //������� ����������
	//��������� ���������:
	private java.lang.Integer operatorCode;
	private java.lang.String operation = "";
	private int idCode = -1;
	private java.lang.String toState = "";
	private java.lang.String state;
	//�������� � ����������� �� ��������:
	private Boolean isRegionID = new Boolean(true);
	private Integer regionID = null;

	private String principalName;

	/**
	 * LeaseContractProblemListForm constructor comment.
	 */
	public LeaseProblemListForm() {
		super();

		setFilter(2);
		setSearchString("");
		setSortBy("created desc");
		setState("ALL");
		setLastVisited(true);

		principalName = null;
	}
	/**
	 * ���������� ��� bean ��� ������.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.arenda.cdbcobjects.CDBC_LeaseContractProblem_Object";
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:39:52)
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("ArendaMainEconomist");
		roles.add("ArendaEconomist");
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
	 * ���������� ���������, ������� ����� ������������ � ����� ������ ������.
	 * Creation date: (12.10.2005 15:40:48)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		return new Object[] { getState().equals("ALL") ? Boolean.FALSE : Boolean.TRUE, getState(), new Integer(getFilter()), getSearchString(), isRegionID, getRegionID(), getSortBy()};
	}
	/**
	 * ���������� ��� ������ ������.
	 * Creation date: (22.01.2002 11:20:35)
	 * @return java.lang.String
	 */
	public java.lang.String getFinderMethodName() {
		return "getListProblem";
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
	 * ������������� ������ ��������� ������.
	 * Creation date: (22.05.2002 16:35:23)
	 * @return java.lang.Object
	 * @param o java.lang.Object
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.LEASE_PROBLEM_LIST);
		if (getOperatorCode() == null)
			initOperatorCode(request);
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
			//throw new RuntimeException("��� �������� ������� ��� ������!!!");
			System.out.println("��� �������� ������� ��� ������!!!");
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
	 * @param string
	 */
	public void setSearchString(String string) {
		searchString = string;
	}

	/**
	 * 
	 * @param request
	 */

	private void initOperatorCode(javax.servlet.http.HttpServletRequest request) {
		this.principalName = request.getRemoteUser();
		setOperatorCode(OperatorObject.getOperatorCode(this.principalName));
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
		String errorTxt = CDBC_LeaseContractProblem_Object.changeStateLeaseContractProblem(getIdCode(), getToState(), getOperatorCode().intValue());
		if (!errorTxt.equals("")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorTxt));
		} else {
			//"�������� �� ����������"
			if(getToState().equals("2")){
				CDBC_LeaseContractProblem_Object.sendMail(getOperatorCode(), getIdCode(), this.principalName);
			}
		}
	}
	/**
	 * @param integer
	 */
	public void setOperatorCode(java.lang.Integer integer) {
		operatorCode = integer;
	}

	/**
	 * @return
	 */
	public java.lang.String getState() {
		return state;
	}

	/**
	 * @param string
	 */
	public void setState(java.lang.String string) {
		state = string;
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

}
