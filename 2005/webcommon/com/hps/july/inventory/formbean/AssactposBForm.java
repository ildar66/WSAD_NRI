package com.hps.july.inventory.formbean;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import java.sql.Connection;
import java.util.Enumeration;
import com.hps.july.inventory.valueobject.OuterDocPositionValue;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.cdbc.objects.*;

/**
 * Форма ввода и редактирования строки документа "Акт монтажа блоков на позиции"
 */
public class AssactposBForm
	extends DocumentPositionForm
{
	private StringAndIntegerProperty docposition;
	private StringAndIntegerProperty order;
	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;
	private StringAndBigDecimalProperty qty;
	private StringAndBigDecimalProperty price;
	private String serialnumber;
	private String party;
	private StringAndIntegerProperty document;
	private Integer positioncode;
	private Integer complectcode;
	private Integer ownercode;
	private java.lang.String agregateserial;

	private Integer storageplace;

	private String fitplace;
	private java.lang.String comment;

	private Boolean fictionSerial;
	private boolean browseBySerial;
	
public AssactposBForm() {
	order = new StringAndIntegerProperty();
	docposition = new StringAndIntegerProperty();
	price = new StringAndBigDecimalProperty();
	qty = new StringAndBigDecimalProperty();
	resource = new StringAndIntegerProperty();
	resourcemodel = "";
	resourcename = "";
	document = new StringAndIntegerProperty();
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
		DocumentPositionAccessBean p = (DocumentPositionAccessBean)bean;
		if(getFictionSerial() != null && getFictionSerial().booleanValue()) {
			p.setIsfictserial(true);
			p.setSerialnumber(null);
		} else {
			p.setIsfictserial(false);
			p.setSerialnumber(getSnumber());
		}
		p.setRealserial(null);
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.internalrpos.removeagregates");
	}
	super.beforeUpdate(bean,request);
}

public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	AssactBForm aform = (AssactBForm)request.getSession().getAttribute( "AssactBForm" );
	document.setInteger(new Integer(aform.getDocument()));
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	docposition.setInteger(new Integer(keyGen.getNextKey("tables.docpositions")));
//	ownercode = aform.getOwner();
	AssemblingActAccessBean assbean = new AssemblingActAccessBean();
	assbean.setInitKey_document(document.getInteger().intValue());
	assbean.refreshCopyHelper();

	if(com.hps.july.util.AppUtils.getInventoryVariant() == 2) {
		setAgregateSerial(assbean.getAgregateserial());
	} else {
		setAgregateSerial(assbean.getAgregat().getSerialnumber());
	}
	
	DocumentPositionAccessBean bean = new DocumentPositionAccessBean(
		docposition.getInteger().intValue(),
		resource.getInteger(),
		aform.getOwnercode(),
		document.getInteger(),
		order.getInteger().intValue(),
		qty.getBigDecimal(),
		price.getBigDecimal(),
		Boolean.FALSE,
		Boolean.FALSE,
		Boolean.FALSE,
		Boolean.FALSE,
		Boolean.FALSE,
		Boolean.FALSE
	);
	return bean;
}

public ResourceAccessBean constructResource() throws java.lang.Exception {
	ResourceAccessBean bean = new ResourceAccessBean();
	bean.setInitKey_resource(resource.getInteger().intValue());
	bean.refreshCopyHelper();
	resourcemodel = bean.getModel();
	resourcename = bean.getName();
	return bean;
}

public void fillRecord(AbstractEntityAccessBean bean)
{
	super.fillRecord(bean);
	try {
		DocumentPositionAccessBean ab = (DocumentPositionAccessBean)bean;
		setResourcecode(""+ab.getResource().getResource());
		setResourcename(ab.getResource().getName());
		setResourcemodel(ab.getResource().getModel());
		fitplace = ab.getNewplace();
		ownercode = new Integer(ab.getOwner().getOrganization());
		if(ab.getIsfictserial()) {
			setFictionSerial(new Boolean(ab.getIsfictserial()));
			setSnumber("");
		} else {
			setFictionSerial(new Boolean(ab.getIsfictserial()));
			setSnumber(ab.getSerialnumber());
		}
		AssemblingActAccessBean assbean = new AssemblingActAccessBean();
		assbean.setInitKey_document(document.getInteger().intValue());
		assbean.refreshCopyHelper();
		if(com.hps.july.util.AppUtils.getInventoryVariant() == 2) {
			setAgregateSerial(assbean.getAgregateserial());
		} else {
			setAgregateSerial(assbean.getAgregat().getSerialnumber());
		}
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
}

/**
 * Insert the method's description here.
 * Creation date: (29.07.2002 10:56:30)
 * @return java.lang.String
 */
public java.lang.String getAgregateSerial() {
	return agregateserial;
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 11:52:46)
 * @return java.lang.String
 */
public java.lang.String getComment() {
	return comment;
}
public Integer getComplectcode() {
	return complectcode;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	AssactBForm aform = (AssactBForm)request.getSession().getAttribute( "AssactBForm" );
	document.setInteger(new Integer(aform.getDocument()));
	storageplace = aform.getStorageplace();
	DocumentPositionAccessBean bean = new DocumentPositionAccessBean();
	bean.setInitKey_docposition(docposition.getInteger().intValue());
	return bean;
}
public Integer getDocposition() {
	return docposition.getInteger();
}
public String getDocpositionstr() {
	return docposition.getString();
}
public String getDocument() {
	return document.getString();
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getFictionSerial() {
	return fictionSerial;
}
public String getFitplace() {
	return fitplace;
}
public String getNewplace() {
	return fitplace;
}
public int getOrder() {
	return (!order.isEmpty() && order.isOk())?order.getInteger().intValue():0;
}
public String getOrderstr() {
	return order.getString();
}
public Integer getOwnercode() {
	return ownercode;
}
public String getParty() {
	return party;
}
public Integer getPositioncode() {
	return positioncode;
}
public java.math.BigDecimal getPrice() {
	return price.getBigDecimal();
}
public String getPricestr() {
	return price.getString();
}
public java.math.BigDecimal getQty() {
	return qty.getBigDecimal();
}
public String getQtystr() {
	return qty.getString();
}
public Resource getResource() {
	try {
		return (Resource)constructResource().getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
public String getResourcecode() {
	return resource.getString();
}
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
public java.lang.String getResourcename() {
	return resourcename;
}
public java.lang.String getSnumber() {
	return serialnumber;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITASSBP;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getStorageplace() {
	return storageplace;
}

/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	AssactBForm aform = (AssactBForm)request.getSession().getAttribute("AssactBForm");
	setComplectcode(aform.getComplectcode());
	setPositioncode(aform.getPositioncode());
	setStorageplace(aform.getStorageplace());
	setOwnercode(aform.getOwnercode());
}

public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	super.initRecord(request);
	AssactBForm aform = (AssactBForm)request.getSession().getAttribute( "AssactBForm" );
	storageplace = aform.getStorageplace();
	document.setInteger(new Integer(aform.getDocument()));
	ownercode = aform.getOwnercode();
	try {
		DocumentPositionAccessBean dp = new DocumentPositionAccessBean();
		dp = dp.findMaxOrderPosition( document.getInteger() );
		order.setInteger(new Integer(dp.getOrder()+1));
	} catch(Exception e) {
		//e.printStackTrace(System.out);
		order.setInteger(new Integer(1));
	}
}

/**
 * Insert the method's description here.
 * Creation date: (24.06.2005 10:49:29)
 * @return boolean
 */
public boolean isBrowseBySerial() {
	return browseBySerial;
}

public void setAgregateSerial(java.lang.String newAgregateserial) {
	agregateserial = newAgregateserial;
}

/**
 * Insert the method's description here.
 * Creation date: (24.06.2005 10:49:29)
 * @param newBrowseBySerial boolean
 */
public void setBrowseBySerial(boolean newBrowseBySerial) {
	browseBySerial = newBrowseBySerial;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 11:52:46)
 * @param newComment java.lang.String
 */
public void setComment(java.lang.String newComment) {
	comment = newComment;
}

public void setComplectcode(java.lang.Integer newComplectcode) {
	complectcode = newComplectcode;
}

public void setDocposition(java.lang.Integer newNumber) {
	docposition.setInteger(newNumber);
}

public void setDocpositionstr(String newNumber) {
	docposition.setString(newNumber);
}

public void setDocument(String docstr) {
	document.setString(docstr);
}
/**
 * 
 * @param newFictionSerial java.lang.Boolean
 */
public void setFictionSerial(java.lang.Boolean newFictionSerial) {
	fictionSerial = newFictionSerial;
}

public void setFitplace(java.lang.String newFitplace) {
	fitplace = newFitplace;
}

public void setOrder(int newOrder) {
	order.setInteger(new Integer(newOrder));
}

public void setOrderstr(String newOrder) {
	order.setString(newOrder);
}

public void setOwnercode(Integer newOwnercode) {
	ownercode = newOwnercode;
}

public void setParty(String newParty) {
	party = newParty;
}

public void setPositioncode(Integer newPositioncode) {
	positioncode = newPositioncode;
}

public void setPrice(java.math.BigDecimal newPrice) {
	price.setBigDecimal(newPrice);
}

public void setPricestr(String newPrice) {
	price.setString(newPrice);
}
public void setQty(java.math.BigDecimal newQty) {
	qty.setBigDecimal(newQty);
}
public void setQtystr(String newQty) {
	qty.setString(newQty);
}
public void setResourcecode(String newResource) {
	resource.setString(newResource);
}
public void setResourcemodel(String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
public void setResourcename(String newResourcename) {
	resourcename = newResourcename;
}
public void setSnumber(String newSerialnumber) {
	serialnumber = newSerialnumber;
}
public void setStorageplace(Integer newStorageplace) {
	storageplace = newStorageplace;
}

public void validateValues(ActionErrors errors) throws Exception 
{
	preprocessSerials();
	if (order.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.assactposb.order"));
	}
	else if (!order.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assactposb.order"));
	}

	boolean fserial = getFictionSerial() != null && getFictionSerial().booleanValue();

	setBrowseBySerial(false);
	if(resource.isEmpty()){
		setResourcemodel("");
		setResourcename("");
	}
	
	// Find resource by serialnumber/party if its empty
	if (resource.isEmpty()) {
		if (!fserial && serialnumber != null && serialnumber.length() > 0) {
			if(party == null || "".equals(party)) {

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

				
				// Only serial number specified - find resource by serial number
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(serialnumber);
					resource.setInteger(new Integer(card.getResource().getResource()));
					fitplace = card.getPlace();
					if(getManufserial() == null || "".equals(getManufserial().trim())) {
						setManufserial(card.getManufserial());
					}
				} catch(Exception e) { }
			} else 
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assactposb.serialparty"));
		} else if ( (party != null && party.length() > 0) ) {
				// Only party number specified - find resource by party number
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findByStorageOwnerParty(getComplectcode(), getOwnercode(), party);
					resource.setInteger(new Integer(card.getResource().getResource()));
					if(getManufserial() == null || "".equals(getManufserial().trim())) {
						setManufserial(card.getManufserial());
					}
				} catch(Exception e) { }
		}
	}

	String policy = "";
	try {
		ResourceAccessBean bean = constructResource();
		policy = bean.getCountpolicy();
		if("S".equals(policy)) {
			if (!fserial && (getSnumber() == null || "".equals(getSnumber()))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.assactposb.serial"));
			}
			setQtystr("1");
			/*
			if (!qty.isEmpty() && (qty.getBigDecimal().doubleValue() != 1.0d)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assactposb.qtylow"));
			}
			*/
			if (party != null && !"".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assactposb.serialresource"));
			}
			if(!fserial && getSnumber() != null && !"".equals(getSnumber())) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(getSnumber());
					/*if( card.getResource().getResource() != resource.getInteger().intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assactposb.diffresources"));
					}*/
					setPrice(card.getPrice());
					setOwnercode(new Integer(card.getOwner().getOrganization()));
					if(getManufserial() == null || "".equals(getManufserial().trim())) {
						setManufserial(card.getManufserial());
					}
				} catch(Exception e) { }
			}
			/*if(DocumentPositionForm.hasSameSerial(serialnumber,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserial",serialnumber));
			}*/
			if(DocumentPositionForm.hasSameSerialAndResource(serialnumber,resource.getString(),document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserialandresource",resourcemodel,serialnumber));
			}
		}
		else if("P".equals(policy)) {
			if(party == null || "".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.assactposb.party"));
			} else
			if((serialnumber != null && !"".equals(serialnumber)) || fserial) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assactposb.partyresource"));
			}
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerParty(getComplectcode(), getOwnercode(), party);
				if( card.getResource().getResource() != resource.getInteger().intValue()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assactposb.diffresources"));
				}
				setPrice(card.getPrice());
				setOwnercode(new Integer(card.getOwner().getOrganization()));
				if(getManufserial() == null || "".equals(getManufserial().trim())) {
					setManufserial(card.getManufserial());
				}
			} catch(Exception e) { }
			if(DocumentPositionForm.hasSameParty(party,ownercode,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameparty",party));
			}
			setFictionSerial(Boolean.FALSE);
		}
		else if("B".equals(policy)) {
			if((party != null && !"".equals(party)) || (serialnumber != null && !"".equals(serialnumber)) || fserial) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assactposb.bulkresource"));
			} else {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findByStorageOwnerResource(getComplectcode(), getOwnercode(), resource.getInteger());
					setPrice(card.getPrice());
					setOwnercode(new Integer(card.getOwner().getOrganization()));
					if(getManufserial() == null || "".equals(getManufserial().trim())) {
						setManufserial(card.getManufserial());
					}
				} catch(Exception e) { }
			}
			if(DocumentPositionForm.hasSameBulk(resource.getInteger(),ownercode,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassamebulk",resourcename+", "+resourcemodel));
			}
			setFictionSerial(Boolean.FALSE);
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.assactposb.resource"));
	}
	
	if(getManufserial() != null && getManufserial().length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.manufserial"));
	}
	
	if (qty.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.assactposb.qty"));
	} else if (!qty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assactposb.qty"));
	}

	if (price.isEmpty())
		price.setString("0");

	if("S".equals(policy) || "P".equals(policy)) {
		if(fitplace == null || "".equals(fitplace.trim())) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fitplace"));
		} else {
			fitplace = fitplace.trim();
			if(fitplace.length() > 40) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fitplace"));
			}
		}
	}
			
	if (!errors.empty())
		throw new ValidationException();
}
}
