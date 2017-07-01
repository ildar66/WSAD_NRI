package com.hps.july.inventory.formbean;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import java.sql.Connection;
import java.math.BigDecimal;
import com.hps.july.inventory.sessionbean.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.cdbc.objects.*;

/**
 * Форма редактирования строки документа "Акт инвентаризации на позиции"
 */
public class PositionInventoryItem extends com.hps.july.web.util.EditForm {
	public static final	java.math.BigDecimal ONE = new java.math.BigDecimal(1.0d);
	
	private int order;
	private int docposition;
	private java.lang.Boolean contentsScaned;
	private java.lang.String note;
	private java.lang.String configuration;
	private java.lang.String party;
	private StringAndBigDecimalProperty price = new StringAndBigDecimalProperty();
	private StringAndBigDecimalProperty qty = new StringAndBigDecimalProperty();
	private java.lang.String positionstate;
	private java.lang.String serialnumber;
	private String manufserial;
	private java.lang.Integer resource;
	private java.lang.String resourcemodel;
	private java.lang.String resourcename;
	private java.lang.Integer owner;
	private java.lang.String ownername;
	private java.lang.String sumstr;
	private java.lang.Integer contract;
	private java.lang.String contractname;
	private java.lang.String agregatesn;
	private java.lang.Integer agregate;
	private java.lang.String agregatename;
	private java.lang.String agregatemodel;
	private int document;
	private java.lang.String utype;
	private String cardsearch;
	private boolean isReadOnly;
	private Boolean boxed;
	private Boolean broken;
	private Integer copydocpos;
	private Integer complect;
	private String complectname;
	private Integer position;
	private String positionname;

	private String fitplace;
//	private Boolean useplace;
	private String cordocnum;
	private java.lang.String comment;

	private Boolean fictionSerial;
	private String policy;
	private boolean browseBySerial;
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:38:00)
 */
public PositionInventoryItem() {
	utype = "-";
	positionstate = "N";
	boxed = Boolean.FALSE;
//	useplace = Boolean.FALSE;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean,	javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	try {
		I13nActPositionAccessBean p = (I13nActPositionAccessBean)bean;
		if("S".equals(policy)) {
			if(getFictionSerial() != null && getFictionSerial().booleanValue()) {
				p.setIsfictserial(true);
				p.setSerialnumber(null);
			} else {
				p.setIsfictserial(false);
//				p.setSerialnumber(null);
				p.setSerialnumber(getSnumber());
			}
			p.setRealserial(null);
		} else {
			p.setIsfictserial(false);
			p.setSerialnumber(null);
			p.setRealserial(null);
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.updateerrors");
	}
}
/**
 * Метод создания позиции документа
 */
public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	PositionInventory f = (PositionInventory)request.getSession().getAttribute("PositionInventory");
	setDocument(f.getDocument());
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setDocposition(keyGen.getNextKey("tables.docpositions"));
	I13nActPositionAccessBean bean = new I13nActPositionAccessBean(
		getDocposition(),
		getResourcecode(),
		getOwnercode(),
		new Integer(getDocument()),
		getOrder(),
		getQty(),
		(getPrice() == null)?new BigDecimal("0.0"):getPrice(),
		getBoxed(),
		getBoxed(),
		getBroken(),
		getBroken(),
		getPositionState(),
		Boolean.FALSE, Boolean.FALSE
	);
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 17:53:47)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean)
{
	positionstate = "N";
	I13nActPositionAccessBean nbean = (I13nActPositionAccessBean)bean;
	try {
		setSumstr(""+nbean.getSum());
		setFitplace(nbean.getNewplace());
		if(nbean.getIsfictserial()) {
			setFictionSerial(new Boolean(nbean.getIsfictserial()));
			setSnumber("");
		} else {
			setFictionSerial(new Boolean(nbean.getIsfictserial()));
			setSnumber(nbean.getSerialnumber());
		}
	} catch(Exception e) {
	}
    try {
		I13nActAccessBean doc = new I13nActAccessBean(nbean.getDocument().getEJBRef());
		doc.refreshCopyHelper();
		setDocument(doc.getDocument());
		OrganizationAccessBean org = doc.getOwner();
		if(org != null) {
			setOwnercode(new Integer(org.getOrganization()));
			setOwnername(org.getName());
		}
		setAgregateSC(doc.getAgregate());
		if("1".equals(doc.getDocumentState())) {
			setIsReadOnly(false);
		} else {
			setIsReadOnly(true);
		}
		if(doc.getFrom() != null) {
			setStorageSC(doc.getFrom());
        }
    }
    catch (Exception e) {
    }
}
public Integer findAgregateContract() {
	try {
		I13nActPositionAccessBean dp = getAgregateAccessBean();
		return new Integer(dp.getContract().getDocument());
	} catch(Exception ee) {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:14:48)
 * @return java.lang.Integer
 */
public DocumentPosition getAgregate() {
	if(getAgregatecode() == null) {
		return null;
	}
	try {
		I13nActPositionAccessBean bean = new I13nActPositionAccessBean();
		bean.setInitKey_docposition(getAgregatecode().intValue());
		bean.refreshCopyHelper();
		return (DocumentPosition)bean.getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
public I13nActPositionAccessBean getAgregateAccessBean() {
	if(getAgregatecode() == null) {
		return null;
	}
	try {
		I13nActPositionAccessBean bean = new I13nActPositionAccessBean();
		bean.setInitKey_docposition(getAgregatecode().intValue());
		bean.refreshCopyHelper();
		return bean;
	} catch(Exception e) {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:14:48)
 * @return java.lang.Integer
 */
public java.lang.Integer getAgregatecode() {
	return agregate;
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2002 19:08:48)
 * @return java.lang.String
 */
public java.lang.String getAgregatemodel() {
	return agregatemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:15:06)
 * @return java.lang.String
 */
public java.lang.String getAgregatename() {
	return agregatename;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:14:27)
 * @return java.lang.String
 */
public java.lang.String getAgregatesn() {
	return agregatesn;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 10:22:06)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getBoxed() {
	return boxed;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 10:22:33)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getBroken() {
	return broken;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 17:57:26)
 * @return java.lang.Boolean
 */
public String getCardsearch() {
	return cardsearch;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 11:37:55)
 * @return java.lang.String
 */
public java.lang.String getComment() {
	return comment;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:48:47)
 * @return java.lang.String
 */
public java.lang.String getConfiguration() {
	return configuration;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:47:50)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getContentsScaned() {
	return contentsScaned;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:11:56)
 * @return java.lang.Integer
 */
public Contract getContract() {
	try {
		ContractAccessBean c = new ContractAccessBean();
		c.setInitKey_document(contract.intValue());
		c.refreshCopyHelper();
		return (Contract)c.getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:11:56)
 * @return java.lang.Integer
 */
public java.lang.Integer getContractcode() {
	return contract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:12:08)
 * @return java.lang.String
 */
public java.lang.String getContractname() {
	return contractname;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 20:54:50)
 * @return java.lang.String
 */
public java.lang.String getContractnum() {
	return ""; //contractnum;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 12:55:35)
 * @return java.lang.Integer
 */
public java.lang.Integer getCopydocpos() {
	return copydocpos;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getCordocnum() {
	return cordocnum;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	I13nActPositionAccessBean bean = new I13nActPositionAccessBean();
	bean.setInitKey_docposition(getDocposition());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:47:12)
 * @return int
 */
public int getDocposition() {
	return docposition;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 11:31:11)
 * @return int
 */
public int getDocument() {
	return document;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getFictionSerial() {
	return fictionSerial;
}
public java.lang.String getFitplace() {
	return fitplace;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManufserial() {
	return manufserial;
}
public String getNewplace() {
	return fitplace;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:48:19)
 * @return java.lang.String
 */
public java.lang.String getNote() {
	return note;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:46:48)
 * @return int
 */
public int getOrder() {
	return order;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 15:16:29)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getOrganizations() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:04:50)
 * @return java.lang.Integer
 */
public Organization getOwner() {
	if(getOwnercode() == null) {
		return null;
	}
	
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		bean.setInitKey_organization(getOwnercode().intValue());
		bean.refreshCopyHelper();
		return (Organization)bean.getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:04:50)
 * @return java.lang.Integer
 */
public java.lang.Integer getOwnercode() {
	return owner;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:05:09)
 * @return java.lang.String
 */
public java.lang.String getOwnername() {
	return ownername;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:49:32)
 * @return java.lang.String
 */
public java.lang.String getParty() {
	return party;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getPosition() {
	return position;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:57:27)
 * @return java.lang.String
 */
public java.lang.String getPositionState() {
	return  (positionstate == null)?"N":positionstate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:50:49)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPrice() {
	return price.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:51:05)
 * @return java.lang.String
 */
public String getPricestr() {
	return price.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:50:49)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getQty() {
	return qty.getBigDecimal();
}
/**
 * Insert the method's description here.
 */
public String getQtystr() {
	return qty.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:02:39)
 * @return java.lang.Integer
 */
public Resource getResource() {
	if(getResourcecode() == null) {
		return null;
	}
	
	try {
		ResourceAccessBean bean = new ResourceAccessBean();
		bean.setInitKey_resource(getResourcecode().intValue());
		bean.refreshCopyHelper();
		return (Resource)bean.getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:02:39)
 * @return java.lang.Integer
 */
public java.lang.Integer getResourcecode() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2002 17:28:22)
 * @return java.lang.String
 */
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:02:52)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 10:22:06)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getResultBoxed() {
	return boxed;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 10:22:33)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getResultBroken() {
	return broken;
}
public java.lang.String getSnumber() {
	return serialnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 10:22:06)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSourceBoxed() {
	return boxed;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 10:22:33)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSourceBroken() {
	return broken;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.inventory.APPStates.EDITINVP;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:11:27)
 * @return java.lang.String
 */
public java.lang.String getSumstr() {
	return sumstr;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getUseplace() {
	return Boolean.TRUE;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 14:14:17)
 * @return java.lang.String
 */
public java.lang.String getUtype() {
	return utype;
}
/**
 * Insert the method's description here.
 */
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	PositionInventory f = (PositionInventory)request.getSession().getAttribute( "PositionInventory" );
	setDocument(f.getDocument());
	setOwnercode(f.getOwnercode());
	setOwnername(f.getOwnername());
	complect = f.getComplect();
	positionstate = "N";
	setAgregateSC(f.getAgregate());
//	useplace = new Boolean("A".equals(f.getType()));
	setOrder(0);
	try {
		DocumentPositionAccessBean fbean = new DocumentPositionAccessBean();
		DocumentPositionAccessBean bean = fbean.findMaxOrderPosition(new Integer(getDocument()));
		setOrder(bean.getOrder() + 1);
	} catch(Exception e) {
		setOrder(1);
	}
	setSnumber("");
	setParty("");
	if(getCopydocpos() != null) {
		// copy properties here from other document position
		try {
			int oldorder = order;
			I13nActPositionAccessBean copy = new I13nActPositionAccessBean();
			copy.setInitKey_docposition(getCopydocpos().intValue());
			copy.refreshCopyHelper();
			com.hps.july.util.BeanUtils.copyProperties(this,copy);
			fillRecord(copy);
			setOrder(oldorder);
			setFitplace("");
		} catch(Exception e) {
		}
	}
	setCopydocpos(null);
}
/**
 * Insert the method's description here.
 * Creation date: (24.06.2005 17:09:03)
 * @return boolean
 */
public boolean isBrowseBySerial() {
	return browseBySerial;
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2002 16:56:04)
 * @return boolean
 */
public boolean isIsReadOnly() {
	return isReadOnly;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 18:00:45)
 * @param errors org.apache.struts.action.ActionErrors
 */
public void searchCardByPartial(ActionErrors errors)
{
	if(party == null || "".equals(party)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.invpos.party"));
		return;		
	}
	try {
		StorageCardAccessBean ab = new StorageCardAccessBean();
		StorageCardAccessBean card = ab.findByStorageOwnerParty(complect,getOwnercode(),getParty());
		setResource(card.getResource());
		setConfiguration(card.getConfiguration());
		if(card.getOwner() != null)
			setOwner(card.getOwner());
		if(card.getPrice() != null)
			setPrice(card.getPrice());
		if(card.getContract() != null)
			card.getContract();
		setBoxed(card.getBoxed());
		setBroken(card.getBroken());
		setNote(card.getNotes());
		setQty(card.getQty());
		setFitplace(card.getPlace());
		setManufserial(card.getManufserial());
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.partialsearch"));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 18:01:02)
 * @param errors org.apache.struts.action.ActionErrors
 */
public void searchCardBySerial(ActionErrors errors)
{
	if(getFictionSerial() != null && getFictionSerial().booleanValue()) {
		return;
	}
	if(serialnumber == null || "".equals(serialnumber)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.invpos.serial"));
		return;		
	}
	try {
				Connection conn = null;
				int result = 0;

				try {
					
					conn = new JdbcConnection().getConnection();
					result = CDBCStoragecardsObject.findBySerialM(conn,getSnumber());
					
				} catch(Exception e) {
					e.printStackTrace(System.err);
				}finally{
					try{
						if(conn!=null) conn.close();
					}catch(Exception e){
						e.printStackTrace(System.err);
					}
					
				}

				if(result >= 2){
					setBrowseBySerial(true);
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assemblingppos.several"));
					throw new ValidationException();
				}

		
		StorageCardAccessBean ab = new StorageCardAccessBean();
		StorageCardAccessBean card = ab.findBySerialResource(getSnumber(), resource);
		setResource(card.getResource());
		setConfiguration(card.getConfiguration());
		if(card.getOwner() != null)
			setOwner(card.getOwner());
		if(card.getPrice() != null)
			setPrice(card.getPrice());
		if(card.getContract() != null)
			card.getContract();
		setBoxed(card.getBoxed());
		setBroken(card.getBroken());
		setNote(card.getNotes());
		setQty(card.getQty());
		setFitplace(card.getPlace());
		setManufserial(card.getManufserial());
	} catch(Exception e) {
		e.printStackTrace();
		//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.serialsearch"));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:14:48)
 * @param newAgregate java.lang.Integer
 */
public void setAgregate(DocumentPositionAccessBean newAgregate) {
	if(newAgregate == null) {
		return;
	}
	
	try {
		agregate = new Integer(newAgregate.getDocposition());
		if(newAgregate.getResource() != null)
			agregatename = newAgregate.getResource().getName();
		agregatesn = newAgregate.getSerialnumber();
	} catch(Exception e) {
		agregate = new Integer(0);
		agregatename = "";
		agregatesn = "";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:14:48)
 * @param newAgregate java.lang.Integer
 */
public void setAgregatecode(java.lang.Integer newAgregate) {
	agregate = newAgregate;
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2002 19:08:48)
 * @param newAgregatemodel java.lang.String
 */
public void setAgregatemodel(java.lang.String newAgregatemodel) {
	agregatemodel = newAgregatemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:15:06)
 * @param newAgregatename java.lang.String
 */
public void setAgregatename(java.lang.String newAgregatename) {
	agregatename = newAgregatename;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:14:48)
 * @param newAgregate java.lang.Integer
 */
public void setAgregateSC(StorageCard agr) {
	try {
		setAgregatecode(new Integer(agr.getStoragecard()));
		Resource r = agr.getResource();
		if(r != null) {
			setAgregatename(r.getName() );
			setAgregatemodel(r.getModel() );
		} else {
			setAgregatename("?");
			setAgregatemodel("?");
		}
		setAgregatesn(agr.getSerialnumber());
	} catch(Exception e) {
		setAgregatecode(null);
		setAgregatename("");
		setAgregatemodel("");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:14:48)
 * @param newAgregate java.lang.Integer
 */
public void setAgregateSC(StorageCardAccessBean agr) {
	try {
		setAgregatecode(new Integer(agr.getStoragecard()));
		ResourceAccessBean r = agr.getResource();
		if(r != null) {
			setAgregatename(r.getName() );
			setAgregatemodel(r.getModel() );
		} else {
			setAgregatename("");
			setAgregatemodel("");
		}
		setAgregatesn(agr.getSerialnumber());
	} catch(Exception e) {
		setAgregatecode(null);
		setAgregatename("");
		setAgregatemodel("");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:14:27)
 * @param newAgregatesn java.lang.String
 */
public void setAgregatesn(java.lang.String newAgregatesn) {
	agregatesn = newAgregatesn;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 10:22:06)
 * @param newBoxed java.lang.Boolean
 */
public void setBoxed(java.lang.Boolean newBoxed) {
	boxed = Boolean.FALSE;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 10:22:33)
 * @param newBroken java.lang.Boolean
 */
public void setBroken(java.lang.Boolean newBroken) {
	broken = newBroken;
}
/**
 * Insert the method's description here.
 * Creation date: (24.06.2005 17:09:03)
 * @param newBrowseBySerial boolean
 */
public void setBrowseBySerial(boolean newBrowseBySerial) {
	browseBySerial = newBrowseBySerial;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 17:57:26)
 * @param newIscardsearch java.lang.Boolean
 */
public void setCardsearch(String newCardsearch) {
	cardsearch = newCardsearch;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 11:37:55)
 * @param newComment java.lang.String
 */
public void setComment(java.lang.String newComment) {
	comment = newComment;
}
/**
 * 
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:48:47)
 * @param newConfiguration java.lang.String
 */
public void setConfiguration(java.lang.String newConfiguration) {
	configuration = newConfiguration;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:47:50)
 * @param newContentsScaned java.lang.Boolean
 */
public void setContentsScaned(java.lang.Boolean newContentsScaned) {
	contentsScaned = newContentsScaned;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:11:56)
 * @param newContract java.lang.Integer
 */
public void setContract(ContractAccessBean newContract) {
	if(newContract == null) {
		return;
	}
	try {
		contract = new Integer(newContract.getDocument());
		contractname = newContract.getName() + ((newContract.getBlanknumber() != null)?(" "+newContract.getBlanknumber()):"");
	} catch(Exception e) {
		contract = null;
		contractname = "";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:11:56)
 * @param newContract java.lang.Integer
 */
public void setContractcode(java.lang.Integer newContract) {
	contract = newContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:12:08)
 * @param newContractname java.lang.String
 */
public void setContractname(java.lang.String newContractname) {
	contractname = newContractname;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 20:54:50)
 * @param newContractnum java.lang.String
 */
public void setContractnum(java.lang.String newContractnum) {
//	contractnum = newContractnum;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 12:55:35)
 * @param newCopydocpos java.lang.Integer
 */
public void setCopydocpos(java.lang.Integer newCopydocpos) {
	copydocpos = newCopydocpos;
}
/**
 * 
 * @param newCordocnum java.lang.String
 */
public void setCordocnum(java.lang.String newCordocnum) {
	cordocnum = newCordocnum;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:47:12)
 * @param newDocposition int
 */
public void setDocposition(int newDocposition) {
	docposition = newDocposition;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 11:31:11)
 * @param newDocument int
 */
public void setDocument(int newDocument) {
	document = newDocument;
}
/**
 * 
 * @param newFictionSerial java.lang.Boolean
 */
public void setFictionSerial(java.lang.Boolean newFictionSerial) {
	fictionSerial = newFictionSerial;
}
/**
 * 
 * @param newFitplace java.lang.String
 */
public void setFitplace(java.lang.String newFitplace) {
	fitplace = newFitplace;
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2002 16:56:04)
 * @param newIsReadOnly boolean
 */
public void setIsReadOnly(boolean newIsReadOnly) {
	isReadOnly = newIsReadOnly;
}
/**
 * 
 * @param newManufserial java.lang.String
 */
public void setManufserial(java.lang.String newManufserial) {
	manufserial = newManufserial;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:48:19)
 * @param newNote java.lang.String
 */
public void setNote(java.lang.String newNote) {
	note = newNote;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:46:48)
 * @param newOrder int
 */
public void setOrder(int newOrder) {
	order = newOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:04:50)
 * @param newOwner java.lang.Integer
 */
public void setOwner(OrganizationAccessBean newOwner) {
	if(newOwner == null) {
		return;
	}
	try {
		owner = new Integer(newOwner.getOrganization());
		ownername = newOwner.getName();
	} catch(Exception e) {
		owner = new Integer(0);
		ownername = "";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:04:50)
 * @param newOwner java.lang.Integer
 */
public void setOwnercode(java.lang.Integer newOwner) {
	owner = newOwner;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:05:09)
 * @param newOwnername java.lang.String
 */
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:49:32)
 * @param newParty java.lang.String
 */
public void setParty(java.lang.String newParty) {
	party = newParty;
}
/**
 * 
 * @param newPosition java.lang.Integer
 */
public void setPosition(java.lang.Integer newPosition) {
	position = newPosition;
}
/**
 * 
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:57:27)
 * @param newPositionstate java.lang.String
 */
public void setPositionState(java.lang.String newPositionstate) {
	positionstate = newPositionstate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:51:34)
 * @param newPrice java.math.BigDecimal
 */
public void setPrice(java.math.BigDecimal newPrice) {
	price.setBigDecimal(newPrice);
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:51:34)
 * @param newPrice java.math.BigDecimal
 */
public void setPricestr(String newPrice)
{
	price.setString(newPrice);
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 9:51:34)
 * @param newPrice java.math.BigDecimal
 */
public void setQty(java.math.BigDecimal newQty) {
	qty.setBigDecimal(newQty);
}
/**
 * Insert the method's description here.
 */
public void setQtystr(String newQty) {
	qty.setString(newQty);
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:02:39)
 * @param newResource java.lang.Integer
 */
public void setResource(ResourceAccessBean newResource) {
	try {
		resource = new Integer(newResource.getResource());
		resourcename = newResource.getName();
		resourcemodel = newResource.getModel();
	} catch(Exception e) {
		resource = new Integer(0);
		resourcename = "";
		resourcemodel = "";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:02:39)
 * @param newResource java.lang.Integer
 */
public void setResourcecode(java.lang.Integer newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2002 17:28:22)
 * @param newResourcemodel java.lang.String
 */
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:02:52)
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
public void setSnumber(java.lang.String newSerialnumber) {
	serialnumber = newSerialnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 10:22:06)
 * @param newBoxed java.lang.Boolean
 */
public void setSourceBoxed(java.lang.Boolean newBoxed) {
	boxed = newBoxed;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 10:22:33)
 * @param newBroken java.lang.Boolean
 */
public void setSourceBroken(java.lang.Boolean newBroken) {
	broken = newBroken;
}
/**
 * 
 * @param sp com.hps.july.persistence.StoragePlaceAccessBean
 */
public void setStorageSC(StoragePlaceAccessBean sp)
{
	try {
		complect = new Integer(sp.getStorageplace());
		EquipmentSetAccessBean equip = new EquipmentSetAccessBean();
		equip.setInitKey_storageplace(sp.getStorageplace());
		equip.refreshCopyHelper();
		setComplectname(com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(equip));
		setPosition(new Integer(equip.getPosition().getStorageplace()));
		setPositionname(PositionInventoryList.getIDPosition(equip.getPosition()) + " " + equip.getPosition().getName());
	} catch(Exception e) {
		complect = null;
		setComplectname("");
		setPosition(null);
		setPositionname("");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 10:11:27)
 * @param newSumstr java.lang.String
 */
public void setSumstr(java.lang.String newSumstr) {
	sumstr = newSumstr;
}
/**
 * 
 * @param newUseplace java.lang.Boolean
 */
public void setUseplace(java.lang.Boolean newUseplace) {
	//useplace = newUseplace;
}
/**
 * Insert the method's description here.
 * Creation date: (23.05.2002 14:14:17)
 * @param newUtype java.lang.String
 */
public void setUtype(java.lang.String newUtype) {
	utype = newUtype;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	// Check document and its state.
	try {
		I13nActAccessBean docum = new I13nActAccessBean();
		docum.setInitKey_document(getDocument());
		docum.refreshCopyHelper();
		if("2".equals(docum.getDocumentState())) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invpos.change"));
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.document"));
	}

	setBrowseBySerial(false);

	if(resource == null){
		System.err.println("*****empty");
		setResourcemodel("");
		setResourcename("");
	}
	
	boolean fserial = getFictionSerial() != null && getFictionSerial().booleanValue();

	if(getOwnercode() == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.invpos.owner"));
	} else {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(getOwnercode().intValue());
			bean.refreshCopyHelper();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.owner"));
		}
	}
	
	if (!errors.empty())
		throw new ValidationException();

	// perform card search
	if("S".equals(getUtype())) {
		// user clicked the serial search button
		searchCardBySerial(errors);
		throw new ValidationException();
	} else if("P".equals(getUtype())) {
		// user clicked the partial search button
		searchCardByPartial(errors);
		throw new ValidationException();
	}

	// check other params
	if (order <= 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.order"));
	}

	if(contract != null) {
		try {
			ContractAccessBean b = new ContractAccessBean();
			b.setInitKey_document(getContractcode().intValue());
			b.refreshCopyHelper();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.contract"));
		}
	}

	if(agregatesn != null && !"".equals(agregatesn)) {
		try {
			DocumentPositionAccessBean bean = new DocumentPositionAccessBean();
			setAgregate(bean.findByDocumentSerialnum(new Integer(getDocument()),getAgregatesn()));
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.agregate"));
		}
	}

	if (!errors.empty())
		throw new ValidationException();

	if(resource == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.invpos.resource"));
	} else {
		try {
			ResourceAccessBean bean = new ResourceAccessBean();
			bean.setInitKey_resource(resource.intValue());
			bean.refreshCopyHelper();
			if (Boolean.FALSE.equals(bean.getBoxable()) && Boolean.TRUE.equals(getBoxed())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.boxed"));
			}
			policy = bean.getCountpolicy();
			if("S".equals(policy)) {
				if (!fserial && (serialnumber == null || "".equals(serialnumber)) && Boolean.FALSE.equals(getBoxed())) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.invpos.serial"));
				} else if (party != null && !"".equals(party)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.serialresource"));
				}
				// find StorageCard by s/n
				if(!fserial) {
					try {
						StorageCardAccessBean ab = new StorageCardAccessBean();
						StorageCardAccessBean card = ab.findBySerialResource(serialnumber, resource);
						/*if( card.getResource().getResource() != resource.intValue()) {
							errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.diffresources"));
						}*/
//					if(manufserial == null || "".equals(manufserial.trim())) {
//						setManufserial(card.getManufserial());
//					}
					} catch(Exception e) {
						/// ??? contract = findAgregateContract();
					}
				}
				setQtystr("1");
				if(fitplace == null || "".equals(fitplace.trim())) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fitplace"));
				} else {
					fitplace = fitplace.trim();
					if(fitplace.length() > 40) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fitplace"));
					}
				}
				if(!fserial) {
					/*if(DocumentPositionForm.hasSameSerial(serialnumber,new Integer(document),new Integer(docposition))) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserial",serialnumber));
					}*/
					if(DocumentPositionForm.hasSameSerialAndResource(serialnumber,String.valueOf(resource),new Integer(document),new Integer(docposition))) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserialandresource",resourcemodel,serialnumber));
					}
				}
			}
			else if("P".equals(policy)) {
				// check party and null for serial
				if(party == null || "".equals(party)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.invpos.party"));
				} else 
				if((serialnumber != null && !"".equals(serialnumber)) || fserial) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.partyresource"));
				}
				// find StorageCard by p/n
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findByStorageOwnerParty(complect,getOwnercode(),party);
					if( card.getResource().getResource() != resource.intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.diffresourcep"));
					}
//					if(manufserial == null || "".equals(manufserial.trim())) {
//						setManufserial(card.getManufserial());
//					}
				} catch(Exception e) {
				}
				if(DocumentPositionForm.hasSameParty(party,owner,new Integer(document),new Integer(docposition))) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameparty",party));
				}				
				setFictionSerial(Boolean.FALSE);
			}
			else if("B".equals(policy)) {
				// check nulls for party and serial
				if((party != null && !"".equals(party)) || (serialnumber != null && !"".equals(serialnumber)) || fserial) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.bulkresource"));
				}
				if(DocumentPositionForm.hasSameBulk(resource,owner,new Integer(document),new Integer(docposition))) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassamebulk",resourcename+", "+resourcemodel));
				}
				setFictionSerial(Boolean.FALSE);
			}
			
			if (/*Boolean.FALSE.equals(bean.getPriceable()) &&*/ (price.getBigDecimal() == null)) {
				price.setString("0.00");
			}
			
			if (price.isEmpty())
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.invpos.price"));
			else if (!price.isOk())
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.price"));
			else if(price.getBigDecimal().doubleValue() < 0.0d)
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.pricelow"));
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.resource"));
		}
	}

	if(manufserial != null && manufserial.length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.manufserial"));
	}

	if (qty.isEmpty())
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.invpos.qty"));
	else if (!qty.isOk())
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.qty"));
	else if (!(qty.getBigDecimal().doubleValue() > 0.0d))
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.qtylow"));

	if(cordocnum != null && cordocnum.length() > 40) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invpos.cordocnum"));
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
