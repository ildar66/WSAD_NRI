package com.hps.july.arenda.formbean;

import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.util.*;
import org.apache.struts.action.*;
import com.hps.july.arenda.valueobject.*;
import java.util.*;
import java.math.*;
import java.sql.Date;
import com.hps.july.commonbean.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.persistence.Currency;
/**
 * Bean-form
 * Форма фактуры акта.
 * Creation date: (23.05.2003 11:06:28)
 * @author: Sergey Gourov
 */
public class FacturaMutactForm extends com.hps.july.web.util.EditForm {
	private int idSchetFakt;
	private int idContractcode;
	private int idCurrencycode;
	private int idActcode;
	private java.lang.String numberSchetFakt;
	private StringAndSqlDateProperty dateSchetFakt = new StringAndSqlDateProperty();
	private java.lang.String baseDocNumber;
	private StringAndSqlDateProperty baseDocDate = new StringAndSqlDateProperty();
	
	private java.lang.String nameResource;
	private StringAndBigDecimalProperty sumFreeTax = new StringAndBigDecimalProperty();
	private StringAndBigDecimalProperty rateNds = new StringAndBigDecimalProperty();
	private StringAndBigDecimalProperty sumNds = new StringAndBigDecimalProperty();
	private StringAndBigDecimalProperty sumWithTax = new StringAndBigDecimalProperty();
	
	private java.lang.String executorName;
	private java.lang.String executorAddress;
	private java.lang.String executorInn;
	private java.lang.String customerName;
	private java.lang.String customerAddress;
	private java.lang.String customerInn;
	private java.lang.String chiefName;
	private java.lang.String accounterName;
	private java.lang.String positions;
	private java.lang.String exec;
	private java.lang.String cust;
	
	private Vector executorNameValues = new Vector();
	private Vector executorAddressValues = new Vector();
	private Vector executorInnValues = new Vector();
	private Vector customerNameValues = new Vector();
	private Vector customerAddressValues = new Vector();
	private Vector customerInnValues = new Vector();
	private Vector chiefNameValues = new Vector();
	private Vector accounterNameValues = new Vector();
	private Vector positionsValues = new Vector();
	
	private LeaseMutualActNewAccessBean idAct;
	private LeaseContractAccessBean idContract;
	private CurrencyAccessBean idCurrency;

	private ActionMapping actionMapping;
	private java.lang.Boolean isOnePos;
	private int resourceNricode;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	LeaseSchetFaktAccessBean lsfBean = (LeaseSchetFaktAccessBean) bean;
	Enumeration e = new LeasePosSchetFaktAccessBean().findByIdSchetFaktOrderByPosorderAsc(new Integer(lsfBean.getIdSchetFakt()));
	while (e.hasMoreElements()) {
		LeasePosSchetFaktAccessBean lpsfBean = (LeasePosSchetFaktAccessBean) e.nextElement();
		lpsfBean.getEJBRef().remove();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	if ("Edit".equals(getAction()) && getIsOnePos().booleanValue()) {
		LeasePosSchetFaktAccessBean lpsfBean = null;
		
		LeaseSchetFaktAccessBean lsfBean = (LeaseSchetFaktAccessBean) bean;
		Enumeration e = new LeasePosSchetFaktAccessBean().findByIdSchetFaktOrderByPosorderAsc(new Integer(lsfBean.getIdSchetFakt()));
		if (e.hasMoreElements()) {
			lpsfBean = (LeasePosSchetFaktAccessBean) e.nextElement();
			
			ResourceAccessBean rBean = new ResourceAccessBean();
			rBean.setInitKey_resource(getResourceNricode());
			rBean.refreshCopyHelper();
			lpsfBean.setResourceNri((Resource) rBean.getEJBRef());
		} else {
			lpsfBean = new LeasePosSchetFaktAccessBean(new Integer(new KeyGeneratorAccessBean().getNextKey("tables.leaseposschetfakt")),
				new Integer(lsfBean.getIdSchetFakt()), new Integer(1), new Integer(getResourceNricode())
			);
		}
		
		lpsfBean.setNameResource(getNameResource());
		lpsfBean.setSumFreeTax(getSumWithTax().subtract(getSumNds()).setScale(2, BigDecimal.ROUND_HALF_UP));
		lpsfBean.setRateNds(getRateNds());
		lpsfBean.setSumNds(getSumNds());
		lpsfBean.setSumWithTax(getSumWithTax());
		lpsfBean.commitCopyHelper();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:40:12)
 * @return com.hps.july.persistence.CurrencyAccessBean
 * @exception java.lang.Exception The exception description.
 */
private LeaseMutualActNewAccessBean constructAct() throws java.lang.Exception {
	if (idAct == null) {
		if (getIdActcode() != 0) {
			idAct = new LeaseMutualActNewAccessBean();
			idAct.setInitKey_leaseDocument(getIdActcode());
			idAct.refreshCopyHelper();
		}
	}
	return idAct;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 11:06:28)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	setIdSchetFakt(new KeyGeneratorAccessBean().getNextKey("tables.leaseschetfakt"));
	return new LeaseSchetFaktAccessBean(new Integer(getIdSchetFakt()), new Integer(getIdContractcode()), new Integer(getIdCurrencycode()));
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:40:12)
 * @return com.hps.july.persistence.CurrencyAccessBean
 * @exception java.lang.Exception The exception description.
 */
private LeaseContractAccessBean constructContract() throws java.lang.Exception {
	if (idContract == null) {
		if (getIdContractcode() != 0) {
			idContract = new LeaseContractAccessBean();
			idContract.setInitKey_leaseDocument(getIdContractcode());
			idContract.refreshCopyHelper();
		}
	}
	return idContract;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2002 15:40:12)
 * @return com.hps.july.persistence.CurrencyAccessBean
 * @exception java.lang.Exception The exception description.
 */
private CurrencyAccessBean constructCurrency() throws java.lang.Exception {
	if (idCurrency == null) {
		if (getIdCurrencycode() != 0) {
			idCurrency = new CurrencyAccessBean();
			idCurrency.setInitKey_currency(getIdCurrencycode());
			idCurrency.refreshCopyHelper();
		}
	}
	return idCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (30.06.2003 15:41:22)
 * @return java.lang.String
 * @param s java.lang.String
 */
private String convertString(String s) {
	if (s == null) return "";
	for (int i = 0; i < s.length();) {
		int position = s.indexOf('"', i);
		if (position != -1) {
			StringBuffer buffer = new StringBuffer(s);
			buffer.replace(position, position + 1, "\\\"");
			s = buffer.toString();
			i = position + 2;
		} else break;
	}
	return s;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	LeaseSchetFaktAccessBean lsfBean = (LeaseSchetFaktAccessBean) bean;
	
	setIsOnePos(new Boolean(true));
	try {
		LeasePosSchetFaktAccessBean lpsfBean = null;
		
		int i = 0;
		Enumeration e = new LeasePosSchetFaktAccessBean().findByIdSchetFaktOrderByPosorderAsc(new Integer(lsfBean.getIdSchetFakt()));
		while (e.hasMoreElements()) {
			lpsfBean = (LeasePosSchetFaktAccessBean) e.nextElement();
			if (++i > 1) {
				setIsOnePos(new Boolean(false));
				break;
			}
		}

		if (getIsOnePos().booleanValue()) {
			setResourceNricode(lpsfBean.getResourceNriKey().resource);
			setNameResource(lpsfBean.getNameResource());
			setSumFreeTax(lpsfBean.getSumFreeTax());
			setRateNds(lpsfBean.getRateNds());
			setSumNds(lpsfBean.getSumNds());
			setSumWithTax(lpsfBean.getSumWithTax());
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	
	try {
		setPositions("");
		Enumeration e = new LeaseOnPositionAccessBean().findLeaseonpositionsByLeaseArendaAgreementNew(lsfBean.getIdContractKey());
		while (e.hasMoreElements()) {
			LeaseOnPositionAccessBean lopBean = (LeaseOnPositionAccessBean) e.nextElement();
			setPositions(getPositions() + (getPositions().equals("") ? "" : "; ") + lopBean.getPosition().getName());
		}
		
		setExecutorName(lsfBean.getIdContract().getOrgExecutor().getName());
		setExecutorAddress(lsfBean.getIdContract().getOrgExecutor().getLegaladdress());
		setExecutorInn(lsfBean.getIdContract().getOrgExecutor().getInn());
		setCustomerName(lsfBean.getIdContract().getOrgCustomer().getName());
		setCustomerAddress(lsfBean.getIdContract().getOrgCustomer().getLegaladdress());
		setCustomerInn(lsfBean.getIdContract().getOrgCustomer().getInn());
		setExec(getExecutorName() + " " + getExecutorAddress());
		setCust(getCustomerName() + " " + getCustomerAddress());
		setChiefName(lsfBean.getIdContract().getOrgExecutor().getDirectorinfo());
		setAccounterName(lsfBean.getIdContract().getOrgExecutor().getAccauntmanagerinfo());
	} catch (Exception ex) {
		ex.printStackTrace();
		setPositions("");
		setExecutorName("");
		setExecutorAddress("");
		setExecutorInn("");
		setCustomerName("");
		setCustomerAddress("");
		setCustomerInn("");
		setExec("");
		setCust("");
		setChiefName("");
		setAccounterName("");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @return java.lang.String
 */
public java.lang.String getAccounterName() {
	return accounterName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 17:57:30)
 * @return java.lang.String[]
 */
public Enumeration getAccounterNameValues() {
	return accounterNameValues.elements();
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 11:06:28)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:30:39)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getBaseDocDate() {
	return baseDocDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:30:39)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getBaseDocDateFrm() {
	return baseDocDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:35:40)
 * @return java.lang.String
 */
public java.lang.String getBaseDocNumber() {
	return baseDocNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @return java.lang.String
 */
public java.lang.String getChiefName() {
	return chiefName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 17:57:04)
 * @return java.lang.String[]
 */
public Enumeration getChiefNameValues() {
	return chiefNameValues.elements();
}
public java.util.Enumeration getCurrencies() {
	try {
		return new CurrencyAccessBean().findAllOrderByNameAsc();
	} catch(Exception e) {
		return new java.util.Vector().elements();	
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @return java.lang.String
 */
public java.lang.String getCust() {
	return cust;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @return java.lang.String
 */
public java.lang.String getCustomerAddress() {
	return customerAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 17:56:11)
 * @return java.lang.String[]
 */
public Enumeration getCustomerAddressValues() {
	return customerAddressValues.elements();
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @return java.lang.String
 */
public java.lang.String getCustomerInn() {
	return customerInn;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 17:56:37)
 * @return java.lang.String[]
 */
public Enumeration getCustomerInnValues() {
	return customerInnValues.elements();
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @return java.lang.String
 */
public java.lang.String getCustomerName() {
	return customerName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 17:55:43)
 * @return java.lang.String[]
 */
public Enumeration getCustomerNameValues() {
	return customerNameValues.elements();
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 11:06:28)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	LeaseSchetFaktAccessBean bean = new LeaseSchetFaktAccessBean();
	bean.setInitKey_idSchetFakt(getIdSchetFakt());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:32:20)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDateSchetFakt() {
	return dateSchetFakt.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:32:20)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDateSchetFaktFrm() {
	return dateSchetFakt.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 14:33:15)
 * @return java.util.Enumeration
 */
public Enumeration getDocuments() {
	try {
		MessageResources messageResources = new PropertyMessageResourcesFactory().createResources(
			actionMapping.getMappings().getServlet().getInitParameter("application"));
		Vector v = new Vector();
		
		executorNameValues.removeAllElements();
		executorAddressValues.removeAllElements();
		executorInnValues.removeAllElements();
		customerNameValues.removeAllElements();
		customerAddressValues.removeAllElements();
		customerInnValues.removeAllElements();
		chiefNameValues.removeAllElements();
		accounterNameValues.removeAllElements();
		positionsValues.removeAllElements();
		
		Enumeration e = new LeaseContractAccessBean().findLeaseContractsByReglamentOrderByCodeAsc(new Integer(getIdAct().getLeaseMutualReglamentKey().leaseDocument));
		while (e.hasMoreElements()) {
			LeaseContractAccessBean bean = (LeaseContractAccessBean) e.nextElement();
			
			executorNameValues.addElement(convertString(bean.getOrgExecutor().getName()));
			executorAddressValues.addElement(convertString(bean.getOrgExecutor().getLegaladdress()));
			executorInnValues.addElement(convertString(bean.getOrgExecutor().getInn()));
			customerNameValues.addElement(convertString(bean.getOrgCustomer().getName()));
			customerAddressValues.addElement(convertString(bean.getOrgCustomer().getLegaladdress()));
			customerInnValues.addElement(convertString(bean.getOrgCustomer().getInn()));
			chiefNameValues.addElement(convertString(bean.getOrgExecutor().getDirectorinfo()));
			accounterNameValues.addElement(convertString(bean.getOrgExecutor().getAccauntmanagerinfo()));
			
			String poses = "";
			Enumeration en = new LeaseOnPositionAccessBean().findLeaseonpositionsByLeaseArendaAgreementNew(new LeaseDocumentKey(bean.getLeaseDocument()));
			while (en.hasMoreElements()) {
				LeaseOnPositionAccessBean lopBean = (LeaseOnPositionAccessBean) en.nextElement();
				poses += poses.equals("") ? "" : "; " + lopBean.getPosition().getName();
			}
			positionsValues.addElement(convertString(poses));
			
			LeaseDocumentValueObject valueObject = new LeaseDocumentValueObject();
			valueObject.setLeaseDocument(bean.getLeaseDocument());
			
			String message = null;
			if (bean.getContractType().equals("A")) {
				message = messageResources.getMessage("label.contracttype.arenda");
			} else if (bean.getContractType().equals("B")) {
				message = messageResources.getMessage("label.contracttype.arendaus");
			} else if (bean.getContractType().equals("C")) {
				message = messageResources.getMessage("label.contracttype.user");
			} else if (bean.getContractType().equals("D")) {
				message = messageResources.getMessage("label.contracttype.channel");
			}
			message = new String(ResponseUtils.filter(message).getBytes("Cp1251"));
			
			StringAndSqlDateProperty dateProperty = new StringAndSqlDateProperty();
			dateProperty.setSqlDate(bean.getDocumentDate());
			
			valueObject.setValue(message + ", " + dateProperty.getString() + ", " + bean.getDocumentNumber());
			v.addElement(valueObject);
		}
		
		return v.elements();
	} catch (Exception e) {
		return new java.util.Vector().elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @return java.lang.String
 */
public java.lang.String getExec() {
	return exec;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @return java.lang.String
 */
public java.lang.String getExecutorAddress() {
	return executorAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 17:53:54)
 * @return java.lang.String[]
 */
public Enumeration getExecutorAddressValues() {
	return executorAddressValues.elements();
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @return java.lang.String
 */
public java.lang.String getExecutorInn() {
	return executorInn;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 17:54:16)
 * @return java.lang.String[]
 */
public Enumeration getExecutorInnValues() {
	return executorInnValues.elements();
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @return java.lang.String
 */
public java.lang.String getExecutorName() {
	return executorName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 17:53:23)
 * @return java.lang.String[]
 */
public Enumeration getExecutorNameValues() {
	return executorNameValues.elements();
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 14:50:36)
 * @return com.hps.july.persistence.LeaseMutualActNewAccessBean
 */
public LeaseMutualActNew getIdAct() throws Exception {
	LeaseMutualActNewAccessBean bean = constructAct();
	return bean != null ? (LeaseMutualActNew) bean.getEJBRef() : null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 14:47:43)
 * @return int
 */
public int getIdActcode() {
	return idActcode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 14:51:25)
 * @return com.hps.july.persistence.LeaseContractAccessBean
 */
public LeaseContract getIdContract() throws Exception {
	LeaseContractAccessBean bean = constructContract();
	return bean != null ? (LeaseContract) bean.getEJBRef() : null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 11:40:07)
 * @return int
 */
public int getIdContractcode() {
	return idContractcode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 14:52:03)
 * @return com.hps.july.persistence.CurrencyAccessBean
 */
public Currency getIdCurrency() throws Exception {
	CurrencyAccessBean bean = constructCurrency();
	return bean != null ? (Currency) bean.getEJBRef() : null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 11:40:35)
 * @return int
 */
public int getIdCurrencycode() {
	return idCurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 11:12:09)
 * @return int
 */
public int getIdSchetFakt() {
	return idSchetFakt;
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2003 17:27:00)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsOnePos() {
	return isOnePos;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 15:20:16)
 * @return java.lang.String
 */
String getListForm() {
	return "FacturaMutactList";
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:39:07)
 * @return java.lang.String
 */
public java.lang.String getNameResource() {
	return nameResource;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:31:43)
 * @return java.lang.String
 */
public java.lang.String getNumberSchetFakt() {
	return numberSchetFakt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @return java.lang.String
 */
public java.lang.String getPositions() {
	return positions;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 17:57:59)
 * @return java.lang.String[]
 */
public Enumeration getPositionsValues() {
	return positionsValues.elements();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:20:53)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getRateNds() {
	return rateNds.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:20:53)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getRateNdsFrm() {
	return rateNds.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 14:40:06)
 * @return int
 */
public int getResourceNricode() {
	return resourceNricode;
}
public java.util.Enumeration getResources() {
	try {
		NamedValueAccessBean bean = new NamedValueAccessBean();
		bean.setInitKey_id("ARENDA_TYPE");
		bean.refreshCopyHelper();

		return new ResourceAccessBean().findResourcesByQBE(new Boolean(true), new ResourceSubTypeKey(bean.getIntvalue()),
			new Boolean(false), null, new Boolean(false), null, new Integer(3));
	} catch(Exception e) {
		e.printStackTrace();
		return new java.util.Vector().elements();	
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 11:06:28)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.FACTURA_MUTACT_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:15:20)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getSumFreeTax() {
	return sumFreeTax.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:15:20)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getSumFreeTaxFrm() {
	return sumFreeTax.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:23:56)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getSumNds() {
	return sumNds.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:23:56)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getSumNdsFrm() {
	return sumNds.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:26:02)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getSumWithTax() {
	return sumWithTax.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:26:02)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getSumWithTaxFrm() {
	return sumWithTax.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	actionMapping = (ActionMapping) request.getAttribute("org.apache.struts.action.mapping.instance");
	
	FacturaMutactList form = (FacturaMutactList) request.getSession().getAttribute(getListForm());
	setIdActcode(form.getLeaseDocument());
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @param newAccounterName java.lang.String
 */
public void setAccounterName(java.lang.String newAccounterName) {
	accounterName = newAccounterName;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:30:39)
 * @param newBaseDocDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setBaseDocDate(Date newBaseDocDate) {
	baseDocDate.setSqlDate(newBaseDocDate);
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:30:39)
 * @param newBaseDocDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setBaseDocDateFrm(String newBaseDocDate) {
	baseDocDate.setString(newBaseDocDate);
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:35:40)
 * @param newBaseDocNumber java.lang.String
 */
public void setBaseDocNumber(java.lang.String newBaseDocNumber) {
	baseDocNumber = newBaseDocNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @param newChiefName java.lang.String
 */
public void setChiefName(java.lang.String newChiefName) {
	chiefName = newChiefName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @param newCust java.lang.String
 */
public void setCust(java.lang.String newCust) {
	cust = newCust;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @param newCustomerAddress java.lang.String
 */
public void setCustomerAddress(java.lang.String newCustomerAddress) {
	customerAddress = newCustomerAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @param newCustomerInn java.lang.String
 */
public void setCustomerInn(java.lang.String newCustomerInn) {
	customerInn = newCustomerInn;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @param newCustomerName java.lang.String
 */
public void setCustomerName(java.lang.String newCustomerName) {
	customerName = newCustomerName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:32:20)
 * @param newDateSchetFakt com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateSchetFakt(Date newDateSchetFakt) {
	dateSchetFakt.setSqlDate(newDateSchetFakt);
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:32:20)
 * @param newDateSchetFakt com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateSchetFaktFrm(String newDateSchetFakt) {
	dateSchetFakt.setString(newDateSchetFakt);
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @param newExec java.lang.String
 */
public void setExec(java.lang.String newExec) {
	exec = newExec;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @param newExecutorAddress java.lang.String
 */
public void setExecutorAddress(java.lang.String newExecutorAddress) {
	executorAddress = newExecutorAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @param newExecutorInn java.lang.String
 */
public void setExecutorInn(java.lang.String newExecutorInn) {
	executorInn = newExecutorInn;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @param newExecutorName java.lang.String
 */
public void setExecutorName(java.lang.String newExecutorName) {
	executorName = newExecutorName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 14:50:36)
 * @param newIdAct com.hps.july.persistence.LeaseMutualActNewAccessBean
 */
public void setIdAct(com.hps.july.persistence.LeaseMutualActNewAccessBean newIdAct) throws Exception {
	setIdActcode(newIdAct == null ? 0 : newIdAct.getLeaseDocument());
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 14:47:43)
 * @param newIdActcode int
 */
public void setIdActcode(int newIdActcode) {
	idActcode = newIdActcode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 14:51:25)
 * @param newIdContract com.hps.july.persistence.LeaseContractAccessBean
 */
public void setIdContract(com.hps.july.persistence.LeaseContractAccessBean newIdContract) throws Exception {
	setIdContractcode(newIdContract == null ? 0 : newIdContract.getLeaseDocument());
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 11:40:07)
 * @param newIdContractcode int
 */
public void setIdContractcode(int newIdContractcode) {
	idContractcode = newIdContractcode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 14:52:03)
 * @param newIdCurrency com.hps.july.persistence.CurrencyAccessBean
 */
public void setIdCurrency(com.hps.july.persistence.CurrencyAccessBean newIdCurrency) throws Exception {
	setIdCurrencycode(newIdCurrency == null ? 0 : newIdCurrency.getCurrency());
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 11:40:35)
 * @param newIdCurrencycode int
 */
public void setIdCurrencycode(int newIdCurrencycode) {
	idCurrencycode = newIdCurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 11:12:09)
 * @param newIdSchetFakt int
 */
public void setIdSchetFakt(int newIdSchetFakt) {
	idSchetFakt = newIdSchetFakt;
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2003 17:27:00)
 * @param newIsOnePos java.lang.Boolean
 */
public void setIsOnePos(java.lang.Boolean newIsOnePos) {
	isOnePos = newIsOnePos;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:39:07)
 * @param newNameResource java.lang.String
 */
public void setNameResource(java.lang.String newNameResource) {
	nameResource = newNameResource;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:31:43)
 * @param newNumberSchetFakt java.lang.String
 */
public void setNumberSchetFakt(java.lang.String newNumberSchetFakt) {
	numberSchetFakt = newNumberSchetFakt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2003 12:42:17)
 * @param newPositions java.lang.String
 */
public void setPositions(java.lang.String newPositions) {
	positions = newPositions;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:20:53)
 * @param newRateNds com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setRateNds(BigDecimal newRateNds) {
	rateNds.setBigDecimal(newRateNds);
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:20:53)
 * @param newRateNds com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setRateNdsFrm(String newRateNds) {
	rateNds.setString(newRateNds);
}
/**
 * Insert the method's description here.
 * Creation date: (26.05.2003 14:40:06)
 * @param newResourceNricode int
 */
public void setResourceNricode(int newResourceNricode) {
	resourceNricode = newResourceNricode;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:15:20)
 * @param newSumFreeTax com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumFreeTax(BigDecimal newSumFreeTax) {
	sumFreeTax.setBigDecimal(newSumFreeTax);
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:15:20)
 * @param newSumFreeTax com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumFreeTaxFrm(String newSumFreeTax) {
	sumFreeTax.setString(newSumFreeTax);
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:23:56)
 * @param newSumNds com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumNds(BigDecimal newSumNds) {
	sumNds.setBigDecimal(newSumNds);
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:23:56)
 * @param newSumNds com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumNdsFrm(String newSumNds) {
	sumNds.setString(newSumNds);
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:26:02)
 * @param newSumWithTax com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumWithTax(BigDecimal newSumWithTax) {
	sumWithTax.setBigDecimal(newSumWithTax);
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2003 17:26:02)
 * @param newSumWithTax com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSumWithTaxFrm(String newSumWithTax) {
	sumWithTax.setString(newSumWithTax);
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if (idContractcode == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.facturamutact.contract"));
	} else {
		try {
			constructContract();
		} catch (Exception ex) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.facturamutact.contract"));
			}
		}
	}

	if (idCurrencycode == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.facturamutact.currency"));
	} else {
		try {
			constructCurrency();
		} catch (Exception ex) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.facturamutact.currency"));
			}
		}
	}
	
	if ("Edit".equals(getAction()) && getIsOnePos().booleanValue()) {
		if (!sumFreeTax.isEmpty() && !sumFreeTax.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.factura.sumfreetax"));
		}
		
		if (!rateNds.isEmpty() && !rateNds.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.factura.ratends"));
		}
		
		if (!sumNds.isEmpty() && !sumNds.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.factura.sumnds"));
		}
		
		if (!sumWithTax.isEmpty() && !sumWithTax.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.factura.sumwithtax"));
		}
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
