package com.hps.july.inventory.formbean;

import java.math.BigDecimal;
import java.util.Enumeration;
import com.hps.july.inventory.valueobject.OuterDocPositionValue;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма ввода и редактирования строки документа "Требование"
 */
public class ReqPositionForm extends com.hps.july.web.util.EditForm {
	private StringAndIntegerProperty docposition;
	private StringAndIntegerProperty order;
	private StringAndIntegerProperty complect;
	private String complectname;
	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;
	private StringAndBigDecimalProperty fqty;
	private StringAndBigDecimalProperty qty;
//	private StringAndBigDecimalProperty price;
//	private String serialnumber;
//	private String party;
	private StringAndIntegerProperty document;
	private Integer storagecode;
	private Integer ownercode;
	private String configuration;
	private String policy;
	private String notes;
public ReqPositionForm() {
	order = new StringAndIntegerProperty();
	docposition = new StringAndIntegerProperty();
//	price = new StringAndBigDecimalProperty();
	fqty = new StringAndBigDecimalProperty();
	qty = new StringAndBigDecimalProperty();
	resource = new StringAndIntegerProperty();
	resourcemodel = "";
	resourcename = "";
	document = new StringAndIntegerProperty();
	policy = "";
	complect = new StringAndIntegerProperty();
	complectname = "";
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	if("Add".equals(getAction()) && !complect.isEmpty() && complect.isOk()) {
		// get complect parts and add create positions for it
		try {
			KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
			int pos;

			ResourceSetAccessBean resset = new ResourceSetAccessBean();
			resset.setInitKey_resourceset(complect.getInteger().intValue());
			resset.refreshCopyHelper();
			Enumeration parts = (new ResourceSetPartAccessBean()).findSetPartsBySet(new ResourceSetKey(resset.getResourceset())); // resset.getSetParts();
			int partorders = order.getInteger().intValue() + 1;
			int count;
			java.math.BigDecimal pq;

			while(parts.hasMoreElements()) {
				ResourceSetPartAccessBean part = (ResourceSetPartAccessBean)parts.nextElement();
				java.math.BigDecimal partqty = part.getQty();
				ResourceAccessBean res = part.getPart();
				pos = keyGen.getNextKey("tables.docpositions");
				count = 1;
				pq = partqty;
				if("S".equals(res.getCountpolicy()) && (partqty.intValue() > 1)) {
					count = partqty.intValue();
					pq = new java.math.BigDecimal("1");
				}
				for(int i = 0; i < count; i++) {
					DocumentPositionAccessBean posbean = new DocumentPositionAccessBean(
						pos,
						new Integer(res.getResource()),
						ownercode,
						document.getInteger(),
						partorders++,
						pq,
						new java.math.BigDecimal("0.00"),
						Boolean.FALSE,
						Boolean.FALSE,
						Boolean.FALSE,
						Boolean.FALSE,
						Boolean.FALSE,
						Boolean.FALSE
					);
				}
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new UpdateValidationException("error.reqpos.complectcreation");
		}
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	ReqForm aform = (ReqForm)request.getSession().getAttribute( "ReqForm" );
	document.setInteger(aform.getDocumentId());
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	docposition.setInteger(new Integer(keyGen.getNextKey("tables.docpositions")));
	ownercode = aform.getOwnerKey();
	DocumentPositionAccessBean bean = new DocumentPositionAccessBean(
		docposition.getInteger().intValue(),
		resource.getInteger(),
		aform.getOwnerKey(),
		document.getInteger(),
		order.getInteger().intValue(),
		qty.getBigDecimal(),
		new BigDecimal("0.00"),
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
	try {
		DocumentPositionAccessBean ab = (DocumentPositionAccessBean)bean;
		setResourcecode(""+ab.getResource().getResource());
		setResourcename(ab.getResource().getName());
		setResourcemodel(ab.getResource().getModel());
		policy = ab.getResource().getCountpolicy();
	} catch(Exception e) {
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
public String getComplectcode() {
	return complect.getString();
}
public String getComplectname() {
	return complectname;
}
public String getConfiguration() {
	return configuration;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ReqForm aform = (ReqForm)request.getSession().getAttribute("ReqForm");
	document.setInteger(aform.getDocumentId());
	storagecode = aform.getStorageKey();
	DocumentPositionAccessBean bean = new DocumentPositionAccessBean();
	bean.setInitKey_docposition(docposition.getInteger().intValue());
	return bean;
}
public java.lang.Integer getDocposition() {
	return docposition.getInteger();
}
public String getDocpositionstr() {
	return docposition.getString();
}
public java.math.BigDecimal getFqty() {
	return fqty.getBigDecimal();
}
public String getFqtystr() {
	return fqty.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNotes() {
	return notes;
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
public String getPolicy() {
	return policy;
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
public int getState() {
	return com.hps.july.inventory.APPStates.EDITREQP;
}
public Integer getStoragecode() {
	return storagecode;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	ReqForm form = (ReqForm)request.getSession().getAttribute("ReqForm");
	document.setInteger(form.getDocumentId());
	storagecode = form.getStorageKey();
	try {
		DocumentPositionAccessBean dp = new DocumentPositionAccessBean();
		dp = dp.findMaxOrderPosition( document.getInteger() );
		order.setInteger(new Integer(dp.getOrder()+1));
	} catch(Exception e) {
		order.setInteger(new Integer(1));
	}
}
public boolean isPartyUpdatable() {
	if("Edit".equals(getAction())) {
		return "P".equals(policy);
	} else {
		return true;
	}
}
public boolean isSerialUpdatable() {
	if("Edit".equals(getAction())) {
		return "S".equals(policy);
	} else {
		return true;
	}
}
public void setComplectcode(String newResource) {
	complect.setString(newResource);
}
public void setComplectname(java.lang.String newResourcename) {
	complectname = newResourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 14:09:44)
 * @param newConfiguration java.lang.String
 */
public void setConfiguration(java.lang.String newConfiguration) {
	configuration = newConfiguration;
}
public void setDocposition(java.lang.Integer newNumber) {
	docposition.setInteger(newNumber);
}
public void setDocpositionstr(String newNumber) {
	docposition.setString(newNumber);
}
public void setfqty(java.math.BigDecimal newQty) {
	fqty.setBigDecimal(newQty);
}
public void setFqtystr(String newQty) {
	fqty.setString(newQty);
}
/**
 * 
 * @param newNotes java.lang.String
 */
public void setNotes(java.lang.String newNotes) {
	notes = newNotes;
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
public void setQty(java.math.BigDecimal newQty) {
	qty.setBigDecimal(newQty);
}
public void setQtystr(String newQty) {
	qty.setString(newQty);
}
public void setResourcecode(String newResource) {
	resource.setString(newResource);
}
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
public void setStoragecode(Integer newStoragecode) {
	storagecode = newStoragecode;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if (order.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.reqpos.order"));
	} else if (!order.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reqpos.order"));
	}
	/*
	if (resource.isEmpty()) {
		// Find resource by serialnumber/party if its empty
		if ( (serialnumber != null && serialnumber.length() > 0) ) {
			if(party == null || "".equals(party)) {
				// Only serial number specified - find resource by serial number
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(serialnumber);
					resource.setInteger(new Integer(card.getResource().getResource()));
					price.setBigDecimal(card.getPrice());
					qty.setString("1");
				} catch(Exception e) {
				}
			} else 
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reqpos.serialparty"));
		} else if ( (party != null && party.length() > 0) ) {
			// Only party number specified - find resource by party number
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerParty(getStoragecode(), getOwnercode(), party);
				resource.setInteger(new Integer(card.getResource().getResource()));
				price.setBigDecimal(card.getPrice());
			} catch(Exception e) {
			}
		}
	}
	*/
	
	if(qty.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.reqpos.qty"));
	} else if (!qty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reqpos.qty"));
	} else if (qty.getBigDecimal().doubleValue() <= 0.0d) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reqpos.qtylow"));
	}

	if(resource.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.reqpos.resource"));
	} else if(!resource.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reqpos.resource"));
	}

	if(configuration != null && configuration.length() > 40) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reqpos.configuration"));
	}
	
	if (!errors.empty())
		throw new ValidationException();

	try {
		ResourceAccessBean bean = constructResource();
		String policy = bean.getCountpolicy();
		/*
		if("S".equals(policy)) {
			if ( (serialnumber == null || "".equals(serialnumber))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.reqpos.serial"));
			}
			if (party != null && !"".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reqpos.serialresource"));
			}
			if((serialnumber != null) && !"".equals(serialnumber)) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(serialnumber);
					if( card.getResource().getResource() != resource.getInteger().intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reqpos.diffresources"));
					}
					if("Add".equals(getAction())) {
						price.setBigDecimal(card.getPrice());
					}
				} catch(Exception e) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reqpos.serial"));
					if (!errors.empty()) throw new ValidationException();
				}
			}
		}
		else if("P".equals(policy)) {
			if(party == null || "".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.reqpos.party"));
			} else
			if(serialnumber != null && !"".equals(serialnumber)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reqpos.partyresource"));
			}
			if((party != null) && !"".equals(party)) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findByStorageOwnerParty(storagecode,ownercode,party);
					if( card.getResource().getResource() != resource.getInteger().intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reqpos.diffresources"));
					}
					if("Add".equals(getAction())) {
						price.setBigDecimal(card.getPrice());
					}
				} catch(Exception e) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reqpos.party"));
					if (!errors.empty()) throw new ValidationException();
				}
			}
		}
		else if("B".equals(policy)) {
			if((party != null && !"".equals(party)) || (serialnumber != null && !"".equals(serialnumber))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reqpos.bulkresource"));
			}
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerResource(storagecode,ownercode,resource.getInteger());
				if("Add".equals(getAction())) {
					price.setBigDecimal(card.getPrice());
				}
			} catch(Exception e) {
			}
		}
		*/
/*
		if(price.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.reqpos.price"));
		} else if (!price.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reqpos.price"));
		} else if (price.getBigDecimal().doubleValue() < 0.0d) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.reqpos.pricelow"));
		}
*/
	} catch(ValidationException ve) {
		throw ve;
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.reqpos.resource"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
