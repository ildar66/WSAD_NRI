package com.hps.july.arenda.formbean;

import java.sql.*;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import javax.servlet.*;

import com.hps.july.web.util.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.arenda.cdbcobjects.*;
/**
 * Bean-form
 * Форма "Для создания отчетов(лист регламентам)".
 * Creation date: (09.07.2002 10:42:07)
 * @author: Sergey Gourov
 */
public class MutualReglamentsListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.Boolean isDocdate;
	private java.lang.Boolean isBlank;
	private com.hps.july.web.util.StringAndSqlDateProperty docdate;
	private java.lang.String blank;
	private java.lang.Boolean isLeaseContract;
	private java.lang.Integer leaseContract;
	private java.lang.Boolean isMutStateEdit;
	private java.lang.Boolean isMutStateRun;
	private java.lang.Boolean isMutStateClose;
	private java.lang.Boolean isActType;
	private java.lang.String actType;
	private java.lang.String leaseContractname;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	private java.lang.String orgCustomer;
	private java.lang.String orgExecutor;
	private java.math.BigDecimal currency1;
	private java.math.BigDecimal currency2;
	private java.lang.String curr1;
	private java.lang.String curr2;
	private java.lang.String mainPosition;
    //работаем с разделением по филиалам:
    private Boolean isRegionID = new Boolean(true);
    private Integer regionID = null;	
/**
 * MutualReglamentsListForm constructor comment.
 */
public MutualReglamentsListForm() {
	super();
	setFinderMethodName("findListLeaseMutualReglament");
	setLastVisited(true);
	
	docdate = new StringAndSqlDateProperty();
	docdate.setSqlDate(new java.sql.Date(System.currentTimeMillis()));
	
	setBlank("");
	setIsBlank(new Boolean(false));
	setIsDocdate(new Boolean(true));

	setIsLeaseContract(new Boolean(true));
	setLeaseContract(new Integer(0));
	setIsActType(new Boolean(true));
	setActType("A");
	setIsMutStateEdit(new Boolean(true));
	setIsMutStateRun(new Boolean(true));
	setIsMutStateClose(new Boolean(false));
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
        System.out.println("MutualReglamentListForm: CLASS_CAST: " + o.getClass().getName());
        return o;
    }
    CDBCRowObject ro = (CDBCRowObject) o;
    LeaseMutualReglament_VO vo = new LeaseMutualReglament_VO(ro);
    LeaseMutualReglament_TO to = new LeaseMutualReglament_TO(vo);
    //старый код заменен на вызов процедур:
	to.setContractList(CDBC_LeaseMutualReglament_Object.findLeaseContractsByReglament(vo.getLeaseDocument()));
	//to.setResourceList(CDBC_LeaseMutualReglament_Object.findListResourcesByReglament(vo.getLeaseDocument()));
	//end comment
    return to;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 10:27:53)
 * @return java.lang.String
 */
public java.lang.String getActType() {
	return actType;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 12:57:51)
 * @return java.lang.String
 */
public java.lang.String getBlank() {
	return blank;
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.arenda.cdbcobjects.CDBC_LeaseMutualReglament_Object";
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 12:34:55)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 12:35:06)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 12:34:14)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getCurrency1() {
	return currency1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 12:34:40)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getCurrency2() {
	return currency2;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 12:55:14)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDocdate() {
	return docdate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 12:55:14)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDocdateFrm() {
	return docdate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
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
 * Creation date: (03.12.2002 12:33:09)
 * @return java.sql.Date
 */
public java.sql.Date getEndDate() {
	return endDate;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 10:42:07)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    /*	java.lang.Boolean isDocDate, 			java.sql.Date docDate, 
    	java.lang.Boolean isBlank, 				String blank, 
        java.lang.Boolean isLeaseContract, 		Integer leaseContract, 
        java.lang.Boolean isMutStateEdit, 
        java.lang.Boolean isMutStateRun, 
        java.lang.Boolean isMutStateClose, 
        java.lang.Boolean isActType, 			String actType, 
        java.lang.Integer order*/

    return new Object[] {
        getIsDocdate().booleanValue() ? Boolean.FALSE : Boolean.TRUE,        getDocdate(),
        getIsBlank().booleanValue() ? Boolean.FALSE : Boolean.TRUE,        getBlank(),
        getIsLeaseContract().booleanValue() ? Boolean.FALSE : Boolean.TRUE,        getLeaseContract(),
        getIsMutStateEdit(),
        getIsMutStateRun(),
        getIsMutStateClose(),
        getIsActType().booleanValue() ? Boolean.FALSE : Boolean.TRUE,        getActType(),
   		isRegionID,  getRegionID(),
        new Integer(1)};
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 10:26:38)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsActType() {
	return isActType;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 12:47:32)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsBlank() {
	return isBlank;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 12:43:53)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDocdate() {
	return isDocdate;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 10:19:47)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsLeaseContract() {
	return isLeaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 10:25:44)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsMutStateClose() {
	return isMutStateClose;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 10:25:13)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsMutStateEdit() {
	return isMutStateEdit;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 10:25:31)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsMutStateRun() {
	return isMutStateRun;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 10:23:10)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeaseContract() {
	return leaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 11:07:49)
 * @return java.lang.String
 */
public java.lang.String getLeaseContractname() {
	return leaseContractname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.03.2004 17:12:13)
 * @return java.lang.String
 */
public java.lang.String getMainPosition() {
	return mainPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 12:33:29)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 12:33:48)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutor() {
	return orgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (24.11.2005 15:01:25)
 * @return java.lang.Integer
 */
private java.lang.Integer getRegionID() {
	return regionID;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 12:32:40)
 * @return java.sql.Date
 */
public java.sql.Date getStartDate() {
	return startDate;
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
    throws java.io.IOException, ServletException {
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
 * Creation date: (03.12.2002 10:27:53)
 * @param newActType java.lang.String
 */
public void setActType(java.lang.String newActType) {
	actType = newActType;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 12:57:51)
 * @param newBlank java.lang.String
 */
public void setBlank(java.lang.String newBlank) {
	blank = newBlank;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 12:34:55)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 12:35:06)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 12:34:14)
 * @param newCurrency1 java.math.BigDecimal
 */
public void setCurrency1(java.math.BigDecimal newCurrency1) {
	currency1 = newCurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 12:34:40)
 * @param newCurrency2 java.math.BigDecimal
 */
public void setCurrency2(java.math.BigDecimal newCurrency2) {
	currency2 = newCurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 12:55:14)
 * @param newDocdate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocdate(Date newDocdate) {
	docdate.setSqlDate(newDocdate);
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 12:55:14)
 * @param newDocdate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocdateFrm(String newDocdate) {
	docdate.setString(newDocdate);
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 12:33:09)
 * @param newEndDate java.sql.Date
 */
public void setEndDate(java.sql.Date newEndDate) {
	endDate = newEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 10:26:38)
 * @param newIsActType java.lang.Boolean
 */
public void setIsActType(java.lang.Boolean newIsActType) {
	isActType = newIsActType;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 12:47:32)
 * @param newIsBlank java.lang.Boolean
 */
public void setIsBlank(java.lang.Boolean newIsBlank) {
	isBlank = newIsBlank;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 12:43:53)
 * @param newIsDocdate java.lang.Boolean
 */
public void setIsDocdate(java.lang.Boolean newIsDocdate) {
	isDocdate = newIsDocdate;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 10:19:47)
 * @param newIsLeaseContract java.lang.Boolean
 */
public void setIsLeaseContract(java.lang.Boolean newIsLeaseContract) {
	isLeaseContract = newIsLeaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 10:25:44)
 * @param newIsMutStateClose java.lang.Boolean
 */
public void setIsMutStateClose(java.lang.Boolean newIsMutStateClose) {
	isMutStateClose = newIsMutStateClose;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 10:25:13)
 * @param newIsMutStateEdit java.lang.Boolean
 */
public void setIsMutStateEdit(java.lang.Boolean newIsMutStateEdit) {
	isMutStateEdit = newIsMutStateEdit;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 10:25:31)
 * @param newIsMutStateRun java.lang.Boolean
 */
public void setIsMutStateRun(java.lang.Boolean newIsMutStateRun) {
	isMutStateRun = newIsMutStateRun;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 10:23:10)
 * @param newLeaseContract java.lang.Integer
 */
public void setLeaseContract(java.lang.Integer newLeaseContract) {
	leaseContract = newLeaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 11:07:49)
 * @param newLeaseContractname java.lang.String
 */
public void setLeaseContractname(java.lang.String newLeaseContractname) {
	leaseContractname = newLeaseContractname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.03.2004 17:12:13)
 * @param newMainPosition java.lang.String
 */
public void setMainPosition(java.lang.String newMainPosition) {
	mainPosition = newMainPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 12:33:29)
 * @param newOrgCustomer java.lang.String
 */
public void setOrgCustomer(java.lang.String newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 12:33:48)
 * @param newOrgExecutor java.lang.String
 */
public void setOrgExecutor(java.lang.String newOrgExecutor) {
	orgExecutor = newOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (24.11.2005 15:01:25)
 * @param newRegionID java.lang.Integer
 */
private void setRegionID(java.lang.Integer newRegionID) {
	regionID = newRegionID;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2002 12:32:40)
 * @param newStartDate java.sql.Date
 */
public void setStartDate(java.sql.Date newStartDate) {
	startDate = newStartDate;
}
}
