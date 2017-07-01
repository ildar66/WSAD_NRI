package com.hps.july.arenda.formbean;

import com.hps.july.platinum.sessionbean.*; //platinum processor
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import java.sql.*;
import java.math.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
/**
 * Bean-form
 * Форма"у нас арендуют".
 * Creation date: (27.06.2002 17:40:14)
 * @author: Sergey Gourov
 */
public class UsArendaForm extends com.hps.july.web.util.EditForm {
	private int leaseDocument;
	private com.hps.july.web.util.StringAndSqlDateProperty documentDate;
	private java.lang.String documentNumber;
	private java.lang.String contractType;
	private java.lang.String contractState;
	private com.hps.july.web.util.StringAndIntegerProperty orgCustomercode;
	private com.hps.july.web.util.StringAndIntegerProperty orgExecutorcode;
	private com.hps.july.web.util.StringAndSqlDateProperty startDate;
	private com.hps.july.web.util.StringAndSqlDateProperty endDate;
	private java.lang.String docSubject;
	private java.lang.String extendType;
	private java.lang.String reportPeriod;
	private java.lang.String extendPeriod;
	private com.hps.july.persistence.OrganizationAccessBean orgCustomer;
	private java.lang.String orgCustomername;
	private java.lang.String orgExecutorname;
	private com.hps.july.persistence.OrganizationAccessBean orgExecutor;
	private com.hps.july.persistence.WorkerAccessBean economist;
	private java.lang.String economistname;
	private com.hps.july.web.util.StringAndIntegerProperty economistcode;
	private java.lang.String comment;
	private com.hps.july.web.util.StringAndBigDecimalProperty summ1;
	private com.hps.july.web.util.StringAndBigDecimalProperty summ2;
	private java.lang.Boolean isSumm2;
	private com.hps.july.persistence.CurrencyAccessBean currency1;
	private com.hps.july.persistence.CurrencyAccessBean currency2;
	private Integer currencycode1;
	private Integer currencycode2;
	private java.lang.String custname;
	private java.lang.String execname;
	private java.lang.String vendor;
	private java.lang.String SYNCNRIPLATINARENDA;
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 19:46:22)
 */
public UsArendaForm() {
	vendor=""; //platinum
	
	java.sql.Date date=new java.sql.Date(System.currentTimeMillis());

	setComment("");
	setContractState("A");
	setContractType("B");

	documentDate = new StringAndSqlDateProperty();
	setDocumentDate(date);
	
	setDocumentNumber("");
	setDocSubject("");

	economistcode = new StringAndIntegerProperty();
	setEconomistcode(null);
	setEconomistname("");

	endDate = new StringAndSqlDateProperty();
	setEndDate(date);

	setExtendPeriod("Y");
	setExtendType("N");
	
	orgCustomercode = new StringAndIntegerProperty();
	setOrgCustomercode(new Integer(0));
	setOrgCustomername("");

	orgExecutorcode = new StringAndIntegerProperty();
	setOrgExecutorcode(new Integer(0));
	setOrgExecutorname("");
	setReportPeriod("M");

	startDate = new StringAndSqlDateProperty();
	setStartDate(date);

	setCurrencycode1(new Integer(0));
	setCurrencycode2(new Integer(0));
	
	summ1 = new StringAndBigDecimalProperty();
	summ1.setBigDecimal(null);

	summ2 = new StringAndBigDecimalProperty();
	summ2.setBigDecimal(null);

	setIsSumm2(new Boolean(false));
}
public void afterDelete(javax.servlet.http.HttpServletRequest request) throws Exception  {
	    //da
       try{
	      PIEDopInfoContrAccessBean pie=new PIEDopInfoContrAccessBean();
 	      pie.setInitKey_leasedocument(leaseDocument);// int  
  		  pie.refreshCopyHelper();
   		pie.getEJBRef().remove();
    } catch(Exception e){ } 
}
public void afterUpdate( AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	//in that form we fill only 2 fields!!
	//da add platinum field
 ////////////////////////////////////////////////////////////////////////////////////////////
 if (this.getAction().equals("Add") ){
    try{
	    if (!vendor.equals("")
        && vendor != null
       ) {
	        //create record
		    PIEDopInfoContrAccessBean pie;	       
	        pie=new PIEDopInfoContrAccessBean(leaseDocument); //int argLeasedocument
	        pie.refreshCopyHelper();
	        pie.setVendor(vendor);
		System.out.println("debug usarendaform.java, leaseDocument="+leaseDocument+" vendor="+vendor);
	        pie.commitCopyHelper();
		    return;
        }  //if
    } catch(Exception e){
	    //e.printStackTrace();	
		System.out.println("usarendaform.java, Exception add plationum! leaseDocument="+leaseDocument+" vendor="+vendor);
	    return; 
	}
 } //if add
 /////////////////////////////////////////////////////////////////////////////////////////////
    // operation=update
    try{    // read record
	     PIEDopInfoContrAccessBean pie;
	        pie=new PIEDopInfoContrAccessBean();
            pie.setInitKey_leasedocument(leaseDocument);// int  
		    pie.refreshCopyHelper();
		// here we are if record exists
		// we modify it
		pie.setVendor(vendor);
		pie.commitCopyHelper();
		
		} catch(Exception e){ 
	   //no record exists
	   
		//if field id entered then create record 
	    if (!vendor.equals("")
        && vendor != null) {
	        //create record
		    PIEDopInfoContrAccessBean pie;	       
	        pie=new PIEDopInfoContrAccessBean(leaseDocument); //int argLeasedocument
	        pie.refreshCopyHelper();
	        pie.setVendor(vendor);
		System.out.println("debug usarendaform.java, leaseDocument="+leaseDocument+" vendor="+vendor);
	        pie.commitCopyHelper();
	       }//if null
//        else{	        //field is entered=>create record
	        
	        
   } //catch

   /////////////////////////////////////////////////////////////////////////////////////////////
//pie.getEJBRef().remove();
			  		



}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 17:40:14)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setLeaseDocument(keyGen.getNextKey("tables.leasedocuments"));

	orgCustomer = constructCustomer();
	setCustname(orgCustomer.getName());
	setExecname(getOrgExecutor().getName());

/* @param argLeaseDocument int
 * @param argDocDate java.sql.Date
 * @param argDocNumber java.lang.String
 * @param argContractType java.lang.String
 * @param argContractState java.lang.String
 * @param argOrgCustomer java.lang.Integer
 * @param argOrgExecutor java.lang.Integer
 * @param argStartDate java.sql.Date
 * @param argEndDate java.sql.Date
 * @param argExtendType java.lang.String
 * @param argReportPeriod java.lang.String
 * @param agrCustname java.lang.String
 * @param argExecname java.lang.String*/
	
	return new com.hps.july.persistence.LeaseContractAccessBean(getLeaseDocument(), getDocumentDate(), getDocumentNumber(),
		getContractType(), getContractState(), getOrgCustomercode(), getOrgExecutorcode(), getStartDate(), getEndDate(),
		getExtendType(), getReportPeriod(), getCustname(), getExecname());
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:40:12)
 * @return com.hps.july.persistence.CurrencyAccessBean
 * @exception java.lang.Exception The exception description.
 */
private CurrencyAccessBean constructCurrency1() throws java.lang.Exception {
	if (currency1 == null) {
		if (getCurrencycode1() != null) {
			currency1 = new CurrencyAccessBean();
			currency1.setInitKey_currency(getCurrencycode1().intValue());
			currency1.refreshCopyHelper();
		}
	}
	return currency1;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:40:12)
 * @return com.hps.july.persistence.CurrencyAccessBean
 * @exception java.lang.Exception The exception description.
 */
private CurrencyAccessBean constructCurrency2() throws java.lang.Exception {
	if (currency2 == null) {
		if (getCurrencycode2() != null) {
			currency2 = new CurrencyAccessBean();
			currency2.setInitKey_currency(getCurrencycode2().intValue());
			currency2.refreshCopyHelper();
		}
	}
	return currency2;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 20:20:27)
 * @return com.hps.july.persistence.OrganizationAccessBean
 * @exception java.lang.Exception The exception description.
 */
private OrganizationAccessBean constructCustomer() throws java.lang.Exception {
	if (orgCustomer == null) {
		// Construct customer bean
		if (getOrgCustomercode() != null) {
			orgCustomer = new OrganizationAccessBean();
			orgCustomer.setInitKey_organization(getOrgCustomercode().intValue());
			orgCustomer.refreshCopyHelper();
		}
	}
	if (orgCustomer.getBank().booleanValue()) {
		throw new javax.ejb.ObjectNotFoundException();
	}
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 11:17:44)
 * @return com.hps.july.persistence.WorkerAccessBean
 * @exception java.lang.Exception The exception description.
 */
private WorkerAccessBean constructEconomist() throws java.lang.Exception {
	if (economist == null) {
		// Construct economist bean
		if (getEconomistcode() != null) {
			economist = new WorkerAccessBean();
			economist.setInitKey_worker(getEconomistcode().intValue());
			economist.refreshCopyHelper();
		}
	}
	return economist;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 21:08:03)
 * @return com.hps.july.persistence.OrganizationAccessBean
 * @exception java.lang.Exception The exception description.
 */
private OrganizationAccessBean constructExecutor() throws java.lang.Exception {
	if (orgExecutor == null) {
		// Construct executor bean
		if (getOrgExecutorcode() != null) {
			orgExecutor = new OrganizationAccessBean();
			orgExecutor.setInitKey_organization(getOrgExecutorcode().intValue());
			orgExecutor.refreshCopyHelper();
		}
	}
	return orgExecutor;
}
public void fillRecord(AbstractEntityAccessBean bean){
try{
  	vendor="";
	  PIEDopInfoContrAccessBean pie=new PIEDopInfoContrAccessBean();
      pie.setInitKey_leasedocument(leaseDocument);// int  
      pie.refreshCopyHelper();
      vendor=pie.getVendor();
	} catch(Exception e){ 
 		//System.out.println("usarendaform.java, Exception fillRec plationum! leaseDocument="+leaseDocument);		
		}
      
	}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 17:40:14)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 11:32:53)
 * @return java.lang.String
 */
public java.lang.String getComment() {
	return comment;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:05:10)
 * @return java.lang.String
 */
public java.lang.String getContractState() {
	return contractState;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:03:49)
 * @return java.lang.String
 */
public java.lang.String getContractType() {
	return contractType;
}
public java.util.Enumeration getCurrencies() {
	try {
		CurrencyAccessBean bean = new CurrencyAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();	
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:12:26)
 * @return com.hps.july.persistence.CurrencyAccessBean
 */
public Currency getCurrency1() throws Exception {
	CurrencyAccessBean bean = constructCurrency1();
	if (bean != null)
		return (Currency) bean.getEJBRef();
	else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:12:26)
 * @return com.hps.july.persistence.CurrencyAccessBean
 */
public Currency getCurrency2() throws Exception {
	if (getIsSumm2().booleanValue()) {
		CurrencyAccessBean bean = constructCurrency2();
		if (bean != null) {
			return (Currency) bean.getEJBRef();
		} else {
			return null;
		}
	} else {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:27:40)
 * @return java.lang.Integer
 */
public java.lang.Integer getCurrencycode1() {
	return currencycode1;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:27:40)
 * @return java.lang.Integer
 */
public java.lang.Integer getCurrencycode2() {
	return currencycode2;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 17:17:11)
 * @return java.lang.String
 */
public java.lang.String getCustname() {
	return custname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 17:40:14)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	LeaseContractAccessBean bean = new LeaseContractAccessBean();
	bean.setInitKey_leaseDocument(getLeaseDocument());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:41:22)
 * @return java.lang.String
 */
public java.lang.String getDocSubject() {
	return docSubject;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:50:35)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDocumentDate() {
	return documentDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:50:35)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDocumentDateFrm() {
	return documentDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:52:00)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 11:12:39)
 * @return com.hps.july.persistence.WorkerAccessBean
 */
public Worker getEconomist() throws Exception {
	WorkerAccessBean bean = constructEconomist();
	if (bean != null) {
		return (Worker) bean.getEJBRef();
	} else {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 11:14:24)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getEconomistcode() {
	return economistcode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 11:14:24)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getEconomistcodeFrm() {
	return economistcode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 11:13:29)
 * @return java.lang.String
 */
public java.lang.String getEconomistname() {
	return economistname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:30:24)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getEndDate() {
	return endDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:30:24)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getEndDateFrm() {
	return endDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 17:17:33)
 * @return java.lang.String
 */
public java.lang.String getExecname() {
	return execname;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:06:43)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getExecutors() {
	try {
		return new OrganizationAccessBean().findOurOrganizations();
	} catch(Exception e) {
		e.printStackTrace();
		return (new java.util.Vector()).elements();	
	}
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 18:31:21)
 * @return java.lang.String
 */
public java.lang.String getExtendPeriod() {
	return extendPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:42:05)
 * @return java.lang.String
 */
public java.lang.String getExtendType() {
	return extendType;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 13:03:20)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsSumm2() {
	return isSumm2;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:49:05)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 20:28:20)
 * @return com.hps.july.persistence.OrganizationAccessBean
 */
public Organization getOrgCustomer() throws Exception {
	OrganizationAccessBean bean = constructCustomer();
	if (bean != null) {
		return (Organization) bean.getEJBRef();
	} else {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:14:33)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getOrgCustomercode() {
	return orgCustomercode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:14:33)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getOrgCustomercodeFrm() {
	return orgCustomercode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 20:59:17)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomername() {
	return orgCustomername;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 21:10:26)
 * @return com.hps.july.persistence.OrganizationAccessBean
 */
public Organization getOrgExecutor() throws Exception {
	OrganizationAccessBean bean = constructExecutor();
	if (bean != null) {
		return (Organization) bean.getEJBRef();
	} else {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:19:00)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getOrgExecutorcode() {
	return orgExecutorcode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:19:00)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getOrgExecutorcodeFrm() {
	return orgExecutorcode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 21:05:44)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutorname() {
	return orgExecutorname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:43:01)
 * @return java.lang.String
 */
public java.lang.String getReportPeriod() {
	return reportPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:24:53)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getStartDate() {
	return startDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:24:53)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getStartDateFrm() {
	return startDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 17:40:14)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.US_ARENDA_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 13:08:55)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getSumm1() {
	return summ1.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 13:08:55)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getSumm1Frm() {
	return summ1.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 13:15:21)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getSumm2() {
	if (getIsSumm2().booleanValue()) {
		return summ2.getBigDecimal();
	} else {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 13:15:21)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getSumm2Frm() {
	return summ2.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (30.01.2003 13:20:57)
 * @return java.lang.String
 */
public java.lang.String getSYNCNRIPLATINARENDA() {
	return SYNCNRIPLATINARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 10:31:57)
 * @return java.lang.String
 */
public java.lang.String getVendor() {
	return vendor;
}
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
//platinum
	setSYNCNRIPLATINARENDA(null); 
	try{ 
	  ArendaPlatinumProcessorAccessBean bean=new ArendaPlatinumProcessorAccessBean();
 	  boolean retcode=bean.isProcessingEnabled();
	  if (retcode)  setSYNCNRIPLATINARENDA("ok");
 	     System.out.println("+++initcollect SYNCNRIPLATINARENDA=1="+SYNCNRIPLATINARENDA );	  
 	 }catch(Exception e){		
    	 e.printStackTrace();	
 	     System.out.println("+++initcollect SYNCNRIPLATINARENDA=exc="+SYNCNRIPLATINARENDA );
	 	 }
 //platinum end
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    UsArendaListForm form = (UsArendaListForm) request.getSession().getAttribute("UsArendaListForm");

	if (!form.getIsCustomer().booleanValue()) {
		setOrgCustomercode(form.getCustomercode());
		try {
			setOrgCustomername(constructCustomer().getName());
		} catch (Exception e) {
			e.printStackTrace();
			setOrgCustomername("");
		}
	}

	if (!form.getIsExecutor().booleanValue()) {
		setOrgExecutorcode(form.getExecutorcode());
	}

	try {
		OperatorAccessBean bean = new OperatorAccessBean();
		OperatorAccessBean operator = bean.findByLogin(request.getUserPrincipal().getName());
	
		WorkerAccessBean worker = new WorkerAccessBean();
		java.util.Enumeration e = worker.findWorkersByMan(operator.getManKey());
		if (e.hasMoreElements()) {
			setEconomistcode(new Integer(((WorkerAccessBean) e.nextElement()).getWorker()));
			setEconomistname(constructEconomist().getMan().getFullName());
		} else {
			setEconomistcode(null);
			setEconomistname("");		
		}
	} catch (Exception ex) {
		ex.printStackTrace();
		setEconomistcode(null);
		setEconomistname("");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 11:32:53)
 * @param newComment java.lang.String
 */
public void setComment(java.lang.String newComment) {
	comment = newComment;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:05:10)
 * @param newContractState java.lang.String
 */
public void setContractState(java.lang.String newContractState) {
	contractState = newContractState;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:03:49)
 * @param newContractType java.lang.String
 */
public void setContractType(java.lang.String newContractType) {
	contractType = newContractType;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:12:26)
 * @param newCurrency1 com.hps.july.persistence.CurrencyAccessBean
 */
public void setCurrency1(com.hps.july.persistence.CurrencyAccessBean newCurrency1) throws Exception {
    if (newCurrency1 == null) {
        currencycode1 = new Integer(0);
    } else {
        currencycode1 = new Integer(newCurrency1.getCurrency());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:12:26)
 * @param newCurrency2 com.hps.july.persistence.CurrencyAccessBean
 */
public void setCurrency2(com.hps.july.persistence.CurrencyAccessBean newCurrency2) throws Exception {
    if (newCurrency2 == null) {
        currencycode2 = new Integer(0);
    } else {
        currencycode2 = new Integer(newCurrency2.getCurrency());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:27:40)
 * @param newCurrencycode java.lang.Integer
 */
public void setCurrencycode1(java.lang.Integer newCurrencycode1) {
	currencycode1 = newCurrencycode1;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:27:40)
 * @param newCurrencycode java.lang.Integer
 */
public void setCurrencycode2(java.lang.Integer newCurrencycode2) {
	currencycode2 = newCurrencycode2;
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 17:17:11)
 * @param newCustname java.lang.String
 */
public void setCustname(java.lang.String newCustname) {
	custname = newCustname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:41:22)
 * @param newDocSubject java.lang.String
 */
public void setDocSubject(java.lang.String newDocSubject) {
	docSubject = newDocSubject;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:50:35)
 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocumentDate(Date newDocumentDate) {
	documentDate.setSqlDate(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:50:35)
 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocumentDateFrm(String newDocumentDate) {
	documentDate.setString(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:52:00)
 * @param newDocNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 11:12:39)
 * @param newEconomist com.hps.july.persistence.WorkerAccessBean
 */
public void setEconomist(com.hps.july.persistence.WorkerAccessBean newEconomist) throws Exception {
	if (newEconomist == null) {
		economistcode.setInteger(null);
		economistname = "";
	}
	else {
		economistcode.setInteger(new Integer(newEconomist.getWorker()));
		economistname = newEconomist.getMan().getFullName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 11:14:24)
 * @param newEconomistcode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setEconomistcode(Integer newEconomistcode) {
	economistcode.setInteger(newEconomistcode);
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 11:14:24)
 * @param newEconomistcode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setEconomistcodeFrm(String newEconomistcode) {
	economistcode.setString(newEconomistcode);
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 11:13:29)
 * @param newEconomistname java.lang.String
 */
public void setEconomistname(java.lang.String newEconomistname) {
	economistname = newEconomistname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:30:24)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEndDate(Date newEndDate) {
	endDate.setSqlDate(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:30:24)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEndDateFrm(String newEndDate) {
	endDate.setString(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (17.10.2002 17:17:33)
 * @param newExecname java.lang.String
 */
public void setExecname(java.lang.String newExecname) {
	execname = newExecname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 18:31:21)
 * @param newExtendPeriod java.lang.String
 */
public void setExtendPeriod(java.lang.String newExtendPeriod) {
	extendPeriod = newExtendPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:42:05)
 * @param newExtendType java.lang.String
 */
public void setExtendType(java.lang.String newExtendType) {
	extendType = newExtendType;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 13:03:20)
 * @param newIsSumm2 java.lang.Boolean
 */
public void setIsSumm2(java.lang.Boolean newIsSumm2) {
	isSumm2 = newIsSumm2;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:49:05)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 20:28:20)
 * @param newOrgCustomer com.hps.july.persistence.OrganizationAccessBean
 */
public void setOrgCustomer(com.hps.july.persistence.OrganizationAccessBean newOrgCustomer) throws Exception {
	if (newOrgCustomer == null) {
		orgCustomercode.setInteger(new Integer(0));
		orgCustomername = "";
	} else {
		orgCustomercode.setInteger(new Integer(newOrgCustomer.getOrganization()));
		orgCustomername = newOrgCustomer.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:14:33)
 * @param newOrgCustomer com.hps.july.web.util.StringAndIntegerProperty
 */
public void setOrgCustomercode(Integer newOrgCustomercode) {
	orgCustomercode.setInteger(newOrgCustomercode);
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:14:33)
 * @param newOrgCustomer com.hps.july.web.util.StringAndIntegerProperty
 */
public void setOrgCustomercodeFrm(String newOrgCustomer) {
	orgCustomercode.setString(newOrgCustomer);
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 20:59:17)
 * @param newOrgCustomername java.lang.String
 */
public void setOrgCustomername(java.lang.String newOrgCustomername) {
	orgCustomername = newOrgCustomername;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 21:10:26)
 * @param newOrgExecutor com.hps.july.persistence.OrganizationAccessBean
 */
public void setOrgExecutor(com.hps.july.persistence.OrganizationAccessBean newOrgExecutor) throws Exception {
	if (newOrgExecutor == null) {
		orgExecutorcode.setInteger(new Integer(0));
		orgExecutorname = "";
	} else {
		orgExecutorcode.setInteger(new Integer(newOrgExecutor.getOrganization()));
		orgExecutorname = newOrgExecutor.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:19:00)
 * @param newOrgExecutor com.hps.july.web.util.StringAndIntegerProperty
 */
public void setOrgExecutorcode(Integer newOrgExecutorcode) {
	orgExecutorcode.setInteger(newOrgExecutorcode);
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:19:00)
 * @param newOrgExecutor com.hps.july.web.util.StringAndIntegerProperty
 */
public void setOrgExecutorcodeFrm(String newOrgExecutorcode) {
	orgExecutorcode.setString(newOrgExecutorcode);
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 21:05:44)
 * @param newOrgExecutorname java.lang.String
 */
public void setOrgExecutorname(java.lang.String newOrgExecutorname) {
	orgExecutorname = newOrgExecutorname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:43:01)
 * @param newReportPeriod java.lang.String
 */
public void setReportPeriod(java.lang.String newReportPeriod) {
	reportPeriod = newReportPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:24:53)
 * @param newStartDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setStartDate(Date newStartDate) {
	startDate.setSqlDate(newStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:24:53)
 * @param newStartDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setStartDateFrm(String newStartDate) {
	startDate.setString(newStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 13:08:55)
 * @param newSumm1 com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumm1(BigDecimal newSumm1) {
	summ1.setBigDecimal(newSumm1);
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 13:08:55)
 * @param newSumm1 com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumm1Frm(String newSumm1) {
	summ1.setString(newSumm1);
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 13:15:21)
 * @param newSumm2 com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumm2(BigDecimal newSumm2) {
	summ2.setBigDecimal(newSumm2);
	if (newSumm2 != null) {
		setIsSumm2(new Boolean(true));
	} else {
		setIsSumm2(new Boolean(false));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 13:15:21)
 * @param newSumm2 com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumm2Frm(String newSumm2) {
	summ2.setString(newSumm2);
}
/**
 * Insert the method's description here.
 * Creation date: (30.01.2003 13:20:57)
 * @param newSYNCNRIPLATINARENDA java.lang.String
 */
public void setSYNCNRIPLATINARENDA(java.lang.String newSYNCNRIPLATINARENDA) {
	SYNCNRIPLATINARENDA = newSYNCNRIPLATINARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 10:31:57)
 * @param newVendor java.lang.String
 */
public void setVendor(java.lang.String newVendor) {
	vendor = newVendor;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if (getDocumentNumber() == null || getDocumentNumber().equals("")) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.us.docnumber"));
	}

	if (documentDate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.us.docdate"));
	} else if (!documentDate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.us.docdate"));
	}

	if (orgCustomercode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.us.customer"));
	} else if (!orgCustomercode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.us.customer"));
	} else {
		try {
			constructCustomer();
		} catch (Exception ex) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.us.customer"));
			}
		}
	}

	if (orgExecutorcode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.us.executor"));
	} else if (!orgExecutorcode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.us.executor"));
	} else {
		try {
			constructExecutor();
		} catch (Exception ex) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.us.executor"));
			}
		}		
	}

	if (startDate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.us.startdate"));
	} else if (!startDate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.us.startdate"));
	}

	if (endDate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.us.enddate"));
	} else if (!endDate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.us.enddate"));
	}

	if (startDate.getSqlDate().compareTo(endDate.getSqlDate()) >= 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.equaldate"));
	}
	
	if (summ1.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.us.summ1"));
	} else if (!summ1.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.us.summ1"));
	}

	if (getIsSumm2().booleanValue()) {
		if (summ2.isEmpty() || !summ2.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.us.summ2"));
		}

		// одна из валют должна быть рубль
		NamedValueAccessBean namedValue = new NamedValueAccessBean();
		namedValue.setInitKey_id("BASE_CURRENCY_ARENDA");
		namedValue.refreshCopyHelper();

		if (getCurrencycode1().intValue() != namedValue.getIntvalue() && getCurrencycode2().intValue() != namedValue.getIntvalue()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.oneruble"));
		}
	}
	
	try {
		if (!economistcode.isEmpty())
			if (economistcode.isOk())
				constructEconomist();
			else
		  		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.us.economist"));
	} catch (Exception ex) {
		if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex))
		  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.us.economist"));
		else
		  throw ex;
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
