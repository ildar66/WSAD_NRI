package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.CDBC_OwnerContract2FilialNri_Object;
import com.hps.july.cdbc.objects.CDBC_VendorSite_Object;
import com.hps.july.arenda.valueobject.*;
import java.sql.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.io.IOException;

import com.hps.july.valueobject.OwnerContract2FilialNri_VO;
import com.hps.july.web.util.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import java.sql.*;
import java.util.Collections;
import java.util.List;

import com.hps.july.jdbcpersistence.lib.*;
/**
 * Form-Bean
 * Информация о договорах аренды.
 * Creation date: (27.06.2002 18:08:27)
 * @author: Sergey Gourov
 */
public class WeArendaListForm extends com.hps.july.web.util.BrowseForm {
    private java.lang.Boolean isCustomer;
    private Integer customercode;
    private java.lang.String customername;
    private java.lang.Boolean isExecutor;
    private Integer executorcode;
    private java.lang.String executorname;
    private Integer executor_vendocSiteId = null;
	private List executor_vendorSitesList = null;//список отделений Исполнителя(арендодатель)    
    private java.lang.Boolean isEconomist;
    private Integer economistcode;
    private java.lang.String economistname;
    private java.lang.Boolean isPosition;
    private java.lang.Integer positioncode;
    private java.lang.String positionname;
    private java.lang.Boolean isDocnumber;
    private java.lang.String docnumber;
    private java.lang.String state;
    private int checkCode;
    private java.util.Vector resources;
    private java.lang.Boolean isResource;
    private java.lang.String resourcecode;
    private java.lang.String sortBy = "mainDocumentNumber";
    //работаем с разделением по филиалам:
    private Boolean isRegionID = new Boolean(true);
    private Integer regionID = null;
    //код оператора:
   	private java.lang.Integer operatorCode;
	private int filter;//фильтр запроса
	private String searchString;//строка запрос
	private boolean isDopFilter = false;//переключатель дополнительного фильтра
	private List customers = null;//заказчики
	private final static Integer NULL_ID = new Integer(-1);
/**
 * WeArendaListForm constructor comment.
 */
public WeArendaListForm() {
	super();
	//setFinderMethodName("findByQBE5");
	setFinderMethodName("findArendaAgreements");
	
	setIsCustomer(Boolean.TRUE);
	setCustomercode(NULL_ID);
	setCustomername("");

	setIsExecutor(Boolean.TRUE);
	setExecutorcode(NULL_ID);
	setExecutorname("");
	setExecutor_vendocSiteId(NULL_ID);//поиск по всем отделениям заказчика
	
	setIsEconomist(Boolean.TRUE);
	setEconomistcode(NULL_ID);
	setEconomistname("");
	
	setIsPosition(Boolean.TRUE);
	setPositioncode(NULL_ID);
	setPositionname("");
	
	setIsDocnumber(Boolean.FALSE);
	setDocnumber("");

	setState("A");
	setLastVisited(true);
	//список услуг:
	resources = initResources();
	setIsResource(Boolean.TRUE);
	setResourcecode("");
	//поиск:
	setSearchString("");
	setFilter(1);
	setExecutor_vendorSitesList(Collections.EMPTY_LIST);
}
/**
 * Creation date: (13.04.2004 10:46:53)
 */
private WorkerVO constructMainEconomist(CDBCRowObject ro) {
	if (ro.getColumn("maineconomist").asObject() != null) {
		WorkerVO mainEconomist = new WorkerVO((Integer) ro.getColumn("maineconomist").asObject());
		mainEconomist.setName(ro.getColumn("maineconomistname").asString());
		return mainEconomist;
	} else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (13.04.2004 11:11:37)
 */
private WorkerVO constructMainManager(CDBCRowObject ro) {
	if (ro.getColumn("mainmanager").asObject() != null) {
		WorkerVO mainManager = new WorkerVO((Integer) ro.getColumn("mainmanager").asObject());
		mainManager.setName(ro.getColumn("mainmanagername").asString());
		return mainManager;
	} else
		return null;
}
/**
 * Для каждой строки броуза можно переопределить возвращаемый объект.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	//System.out.println("from WeArendaListForm.constructRowModelBean: "); //temp
	if (o == null) {
		return o;
	}
	if (!(o instanceof CDBCRowObject)) {
		System.out.println("WE_ARENDA_LIST: CLASS_CAST: " + o.getClass().getName());
		return o;
	}
	CDBCRowObject rowObject = (CDBCRowObject) o;
	com.hps.july.arenda.valueobject.LeaseArendaAgrmntVO vo = new com.hps.july.arenda.valueobject.LeaseArendaAgrmntVO(rowObject);
	vo.setNeedofficialdoc(rowObject.getColumn("needofficialdoc").asString());

	LeaseArendaAgreementNewVO valueObject = new LeaseArendaAgreementNewVO(vo);
	valueObject.setMainDocumentNumber(rowObject.getColumn("maindocumentnumber").asString());
	valueObject.setMainStartDate((Date)rowObject.getColumn("mainstartdate").asObject());
	valueObject.setMainDocumentDate((Date)rowObject.getColumn("maindocdate").asObject());
	valueObject.setMainPosition(rowObject.getColumn("mainpositionname").asString());
	valueObject.setAllPositions(rowObject.getColumn("allposition").asString());
	valueObject.setTrafic1((java.math.BigDecimal)rowObject.getColumn("trafic1").asObject());
	//valueObject.setTrafic2((java.math.BigDecimal)rowObject.getColumn("trafic2").asObject());
	valueObject.setAccept1((java.math.BigDecimal)rowObject.getColumn("accept1").asObject());
	//valueObject.setAccept2((java.math.BigDecimal)rowObject.getColumn("accept2").asObject());	
	valueObject.setResources(rowObject.getColumn("resource").asString());
	valueObject.setMainManager(constructMainManager(rowObject));
	valueObject.setMainEconomist(constructMainEconomist(rowObject));
	valueObject.setMainContractState(rowObject.getColumn("maincontractstate").asString());
	valueObject.setMainDateClose((Date)rowObject.getColumn("maindateclose").asObject());
	//кол-во проблем:
	valueObject.setCountProblemOnContract((Integer)rowObject.getColumn("countProblemOnContract").asObject());

	return valueObject;
}
/**
 * Insert the method's description here.
 * Creation date: (12.01.2004 16:15:50)
 */
private String copyArenda_Electro(ActionErrors errors, int activeContractCode) {
	Connection con = null;
	CallableStatement cs = null;
	ResultSet rs = null;
	String errorTxt = "";
	try {
		String sql = "execute procedure copyArenda2Electro(?, ?)";
		con = new JdbcConnection().getConnection();
		cs = con.prepareCall(sql);

		cs.setInt(1, activeContractCode); //код базового договора
		cs.setInt(2, getOperatorCode().intValue()); //код базового договора
		System.out.println("contractCode: " + activeContractCode); //temp

		rs = cs.executeQuery();
		if (rs.next()) {
			int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
			if (result == 0) {
				System.out.println("Процедура 'copyArenda2Electro(?, ?)' ok"); //temp
			} else {
				errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
				System.out.println("Процедура 'copyArenda2Electro(?, ?)' errorTxt: " + errorTxt); //temp
			}
		} else {
			System.out.println("no DATA: execute procedure 'copyArenda2Electro(?, ?)'"); //temp
		}

	} catch (Exception ex) {
		System.out.println("Error in execute procedure 'copyArenda2Electro'. WeArendaListForm.copyArenda_Electro(?, ?)");
		if (ex instanceof SQLException) {
			System.out.println("Error code=" + ((SQLException) ex).getErrorCode());
		}
		ex.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (cs != null)
				cs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	return errorTxt;
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCArendaAgreementObject";
	//return null;
}
/**
 * Insert the method's description here.
 * Creation date: (21.04.2004 16:50:30)
 * @return int
 */
public int getCheckCode() {
	return checkCode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 12:42:04)
 * @return int
 */
public Integer getCustomercode() {
	return customercode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 12:42:26)
 * @return java.lang.String
 */
public java.lang.String getCustomername() {
	return customername;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:06:43)
 * @return java.util.List
 */
public List getCustomers() {
	return customers;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:06:43)
 * @return java.util.List
 */
private void initListCustomers(Integer newRegionID) {
	customers = CDBC_OwnerContract2FilialNri_Object.getList(newRegionID, "name");
	if(getCustomers() != null && getCustomers().size() > 0){
		OwnerContract2FilialNri_VO ownerVO =(OwnerContract2FilialNri_VO)getCustomers().get(0);
		setCustomercode(ownerVO.getIdOwnerContract());
	}else{
		setCustomercode(NULL_ID);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:36:53)
 * @return java.lang.String
 */
public java.lang.String getDocnumber() {
	return docnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:29:05)
 * @return int
 */
public Integer getEconomistcode() {
	if (economistcode == null) {
		economistcode = new Integer(0);
	}
	return economistcode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:29:27)
 * @return java.lang.String
 */
public java.lang.String getEconomistname() {
	return economistname;
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
 * Creation date: (01.07.2002 13:26:25)
 * @return int
 */
public Integer getExecutorcode() {
	if (executorcode == null) {
		executorcode = new Integer(0);
	}
	return executorcode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:26:47)
 * @return java.lang.String
 */
public java.lang.String getExecutorname() {
	return executorname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 18:08:27)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    /*	java.lang.Boolean isOrgCustomer, 		java.lang.Integer orgCustomer, 
    	java.lang.Boolean isOrgExecutor, 		java.lang.Integer orgExecutor, 
    	java.lang.Boolean isMainEconomist, 		java.lang.Integer mainEconomist, 
    	java.lang.Boolean isPosition, 			java.lang.Integer position, 
    	java.lang.Boolean isDocNumber, 			java.lang.String docNumber,
    	java.lang.Boolean isState, 				java.lang.String state, // состояние базового договора
    	java.lang.Integer order */

    return new Object[] {
		new Integer(getFilter()),		getSearchString(),
        getIsCustomer().booleanValue() ? Boolean.FALSE : Boolean.TRUE,        getCustomercode(),
        getIsExecutor().booleanValue() ? Boolean.FALSE : Boolean.TRUE,        getExecutorcode(),    getExecutor_vendocSiteId(),
        getIsEconomist().booleanValue() ? Boolean.FALSE : Boolean.TRUE,        getEconomistcode(),
        getIsPosition().booleanValue() ? Boolean.FALSE : Boolean.TRUE,        getPositioncode(),
        //getIsDocnumber().booleanValue() ? Boolean.FALSE : Boolean.TRUE,        getDocnumber(),
        getState().equals("A") ? Boolean.FALSE : Boolean.TRUE,        getState(),
        getIsResource().booleanValue() ? Boolean.FALSE : Boolean.TRUE,        getResourcecode(),
        isRegionID,        getRegionID(),
        getSortBy()};
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 12:40:42)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsCustomer() {
	return isCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:36:22)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDocnumber() {
	return isDocnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:28:39)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsEconomist() {
	return isEconomist;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:26:01)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsExecutor() {
	return isExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:33:47)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsPosition() {
	return isPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 17:44:00)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsResource() {
	return isResource;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2005 16:44:46)
 * @return java.lang.Integer
 */
private java.lang.Integer getOperatorCode() {
	return operatorCode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:34:47)
 * @return java.lang.Integer
 */
public java.lang.Integer getPositioncode() {
	if (positioncode == null) {
		positioncode = new Integer(0);
	}
	return positioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:35:01)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.11.2005 17:21:15)
 * @return java.lang.Integer
 */
private java.lang.Integer getRegionID() {
	return regionID;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 17:42:39)
 * @return java.lang.String
 */
public java.lang.String getResourcecode() {
	return resourcecode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 17:29:09)
 * @return java.util.Enumeration
 */
public java.util.Vector getResources() {
	return resources;
}
/**
 * Insert the method's description here.
 * Creation date: (28.03.2005 18:51:13)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 12:23:28)
 * @return java.lang.String
 */
public java.lang.String getState() {
	return state;
}
/**
 * Для каждой строки броуза можно переопределить возвращаемый объект.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    initRegionID_and_ListCustomers_and_VendorSitesList(request);
    if (getOperatorCode() == null)
        initOperatorCode(request);
    ParamsParser.setState(request, Applications.ARENDA, APPStates.WE_ARENDA_LIST);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2005 16:45:24)
 */
private void initOperatorCode(javax.servlet.http.HttpServletRequest request) {
    setOperatorCode(OperatorObject.getOperatorCode(request.getRemoteUser()));
}
/**
 * Insert the method's description here.
 * Creation date: (23.11.2005 17:21:24)
 */
private void initRegionID_and_ListCustomers_and_VendorSitesList(HttpServletRequest request) {
	ProfileAccess profileAccess = getProfileAccess(request);
    if (profileAccess.getCurrRegion() != null) {
		Integer newRegionID = profileAccess.getCurrRegion().getVo().getRegionid();
		if(!newRegionID.equals(getRegionID())){
			initListCustomers(newRegionID);
			initExecutor_vendorSitesList(getExecutorcode(), newRegionID);			
		}
        setRegionID(newRegionID);
    } else {
	    //throw new RuntimeException("нет текущего региона для аренды!!!");
	    System.out.println("нет текущего региона для аренды!!!");
		setRegionID(null);
    }
}
private void initExecutor_vendorSitesList(Integer newExecutorCode, Integer newRegionID) {
	if(newExecutorCode != null && newRegionID != null){
		setExecutor_vendorSitesList(CDBC_VendorSite_Object.findList(Boolean.TRUE, newExecutorCode, Boolean.FALSE, null, Boolean.FALSE, null, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, newRegionID, null));
		setExecutor_vendocSiteId(NULL_ID);
	}else{
		setExecutor_vendorSitesList(Collections.EMPTY_LIST);
		setExecutor_vendocSiteId(NULL_ID);
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
 * Creation date: (23.03.2005 17:25:58)
 * @return java.util.Enumeration
 */
private java.util.Vector initResources() {
    try {
        NamedValueAccessBean bean = new NamedValueAccessBean();
        bean.setInitKey_id("ARENDA_TYPE");
        bean.refreshCopyHelper();
        java.util.Vector resurses = new java.util.Vector();

        java.util.Enumeration enum =
            (new ResourceAccessBean()).findResourcesByQBE(
                new Boolean(true),
                new ResourceSubTypeKey(bean.getIntvalue()),
                new Boolean(false),
                null,
                new Boolean(false),
                null,
                new Integer(3));
        while(enum.hasMoreElements()) {
	        ResourceAccessBean ab = (ResourceAccessBean)enum.nextElement();
	        ResourceVO vo = new ResourceVO(new Integer(ab.getResource()));
	        vo.setName(ab.getName());
	        resurses.add(vo);
        }
        return resurses;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
     }
}
/**
 * Insert the method's description here.
 * Creation date: (21.04.2004 14:58:35)
 * @param args java.lang.String[]
 */
public static void main(String[] args) {
	//start counter:
	TimeCounter counter = new TimeCounter("PERF.ARENDA.ShowArendaList");
	counter.start();
	
	Connection con = null;
	//CallableStatement cs = null;
	PreparedStatement cs = null;
	ResultSet rs = null;
	int contractCode = 4271;
	try {
		String sql = "execute procedure copyArenda2Electro(?)";
		con = new JdbcConnection().getConnection();
		//cs = con.prepareCall(sql);
		cs = con.prepareStatement(sql);

		cs.setInt(1, contractCode); //код базового договора
		System.out.println("contractCode: " + contractCode); //temp

		rs = cs.executeQuery();
		if (rs.next()) {
			int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
			String errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
			if (result == 0) {
				System.out.println("Процедура 'copyArenda2Electro' ok"); //temp
			} else {
				System.out.println("Процедура 'copyArenda2Electro' errorTxt: " + errorTxt); //temp
				//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorTxt));
			}
		} else {
			System.out.println("no DATA: execute procedure 'copyArenda2Electro'"); //temp
		}

	} catch (Exception ex) {
		System.out.println("Error in execute procedure 'copyArenda2Electro'. WeArendaListForm.copyArenda_Electro(?)");
		if (ex instanceof SQLException) {
			System.out.println("Error code=" + ((SQLException) ex).getErrorCode());
		}
		ex.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (cs != null)
				cs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	//counter end
	counter.finish("action");
}
/**
 * Insert the method's description here.
 * Creation date: (21.04.2004 16:50:30)
 * @param newCheckCode int
 */
public void setCheckCode(int newCheckCode) {
	checkCode = newCheckCode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 12:42:04)
 * @param newCustomerId int
 */
public void setCustomercode(Integer newCustomercode) {
	customercode = newCustomercode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 12:42:26)
 * @param newCustomername java.lang.String
 */
public void setCustomername(java.lang.String newCustomername) {
	customername = newCustomername;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:36:53)
 * @param newDocnumber java.lang.String
 */
public void setDocnumber(java.lang.String newDocnumber) {
	docnumber = newDocnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:29:05)
 * @param newEconomistid int
 */
public void setEconomistcode(Integer newEconomistcode) {
	economistcode = newEconomistcode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:29:27)
 * @param newEconomistname java.lang.String
 */
public void setEconomistname(java.lang.String newEconomistname) {
	economistname = newEconomistname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:26:25)
 * @param newExecutorid int
 */
public void setExecutorcode(Integer newExecutorCode) {
	if(!newExecutorCode.equals(getExecutorcode())){
		initExecutor_vendorSitesList(newExecutorCode, getRegionID());
	}
	executorcode = newExecutorCode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:26:47)
 * @param newExecutorname java.lang.String
 */
public void setExecutorname(java.lang.String newExecutorname) {
	executorname = newExecutorname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 12:40:42)
 * @param newIsCustomer java.lang.Boolean
 */
public void setIsCustomer(java.lang.Boolean newIsCustomer) {
	isCustomer = newIsCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:36:22)
 * @param newIsDocNumber java.lang.Boolean
 */
public void setIsDocnumber(java.lang.Boolean newIsDocnumber) {
	isDocnumber = newIsDocnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:28:39)
 * @param newIsEconomist java.lang.Boolean
 */
public void setIsEconomist(java.lang.Boolean newIsEconomist) {
	isEconomist = newIsEconomist;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:26:01)
 * @param newIsExecutor java.lang.Boolean
 */
public void setIsExecutor(java.lang.Boolean newIsExecutor) {
	isExecutor = newIsExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:33:47)
 * @param newIsPosition java.lang.Boolean
 */
public void setIsPosition(java.lang.Boolean newIsPosition) {
	isPosition = newIsPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 17:44:00)
 * @param newIsResource java.lang.Boolean
 */
public void setIsResource(java.lang.Boolean newIsResource) {
	isResource = newIsResource;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2005 16:44:46)
 * @param newOperatorCode java.lang.Integer
 */
private void setOperatorCode(java.lang.Integer newOperatorCode) {
	operatorCode = newOperatorCode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:34:47)
 * @param newPositionid java.lang.Integer
 */
public void setPositioncode(java.lang.Integer newPositioncode) {
	positioncode = newPositioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:35:01)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.11.2005 17:21:15)
 * @param newRegionID java.lang.Integer
 */
private void setRegionID(java.lang.Integer newRegionID) {
	regionID = newRegionID;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 17:42:39)
 * @param newResourcecode java.lang.String
 */
public void setResourcecode(java.lang.String newResourcecode) {
	resourcecode = newResourcecode;
}
/**
 * Insert the method's description here.
 * Creation date: (28.03.2005 18:51:13)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2002 12:23:28)
 * @param newState java.lang.String
 */
public void setState(java.lang.String newState) {
	state = newState;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(org.apache.struts.action.ActionErrors errors) throws Exception {
	//System.out.println("checkCode =" + checkCode);
	if (checkCode != 0) {
		String errorTxt = copyArenda_Electro(errors, checkCode);
		if (!errorTxt.equals("")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorTxt));
		}
		setCheckCode(0);
	}
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
	public Integer getExecutor_vendocSiteId() {
		return executor_vendocSiteId;
	}

	/**
	 * @param integer
	 */
	public void setExecutor_vendocSiteId(Integer integer) {
		executor_vendocSiteId = integer;
	}

	/**
	 * @return
	 */
	public List getExecutor_vendorSitesList() {
		return executor_vendorSitesList;
	}

	/**
	 * @param list
	 */
	private void setExecutor_vendorSitesList(List list) {
		executor_vendorSitesList = list;
	}

}
