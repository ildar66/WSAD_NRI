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
 * Форма ввода и редактирования строк документа "Акт списания"
 */
public class PayoffPositionForm extends com.hps.july.web.util.EditForm {
	private StringAndIntegerProperty docposition;
	private StringAndIntegerProperty order;
	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;
	private StringAndBigDecimalProperty qty;
	private StringAndBigDecimalProperty price;
	private String serialnumber;
	private String manufserial;
	private String party;
	private StringAndIntegerProperty document;
	private Integer storagecode;
	private Integer ownercode;
	private String policy;

	private StorageCardAccessBean card;
	private boolean browseBySerial;
public PayoffPositionForm() {
	order = new StringAndIntegerProperty();
	docposition = new StringAndIntegerProperty();
	price = new StringAndBigDecimalProperty();
	price.setString("0");
	qty = new StringAndBigDecimalProperty();
	resource = new StringAndIntegerProperty();
	resourcemodel = "";
	resourcename = "";
	document = new StringAndIntegerProperty();
	policy = "";
	card = null;
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
{
}
public void beforeUpdate(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	if(card != null) {
		DocumentPositionAccessBean b = (DocumentPositionAccessBean)bean;
		b.setSourceBoxed(card.getBoxed());
		b.setSourceBroken(card.getBroken());
		b.setSourceClosed(card.getClosed());
		b.setResultBoxed(card.getBoxed());
		b.setResultBroken(card.getBroken());
		b.setResultClosed(Boolean.TRUE);
	}
	DocumentPositionAccessBean b = (DocumentPositionAccessBean)bean;
	if(b.getManufserial() != null && "".equals(b.getManufserial().trim())) {
		b.setManufserial(null);
	}
//	try {
//		if ("Edit".equals(getAction()))
//			removePositionFromDocument(docposition.getInteger());
//	} catch(Exception e) {
//		e.printStackTrace(System.out);
//		throw new UpdateValidationException("error.internalrpos.removeagregates");
//	}	
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	PayoffForm aform = (PayoffForm)request.getSession().getAttribute( "PayoffForm" );
	document.setInteger(aform.getDocumentId());
	System.err.println("----- " + document.getInteger());
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	docposition.setInteger(new Integer(keyGen.getNextKey("tables.docpositions")));
	ownercode = aform.getOwnerKey();

	Boolean closed = Boolean.FALSE;
	Boolean boxed = Boolean.FALSE;
	Boolean broken = Boolean.FALSE;
	
	if(card != null) {
		boxed = card.getBoxed();
		broken = card.getBroken();
		closed = card.getClosed();
	}
	
	DocumentPositionAccessBean bean = new DocumentPositionAccessBean(
		docposition.getInteger().intValue(),
		resource.getInteger(),
		aform.getOwnerKey(),
		document.getInteger(),
		order.getInteger().intValue(),
		qty.getBigDecimal(),
		price.getBigDecimal(),
		boxed,
		boxed,
		broken,
		broken,
		closed,
		Boolean.TRUE
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
		ownercode = new Integer(ab.getOwner().getOrganization());
	} catch(Exception e) {
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	PayoffForm aform = (PayoffForm)request.getSession().getAttribute( "PayoffForm" );
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
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManufserial() {
	return manufserial;
}
public int getOrder() {
	return (!order.isEmpty() && order.isOk())?order.getInteger().intValue():0;
}
public String getOrderstr() {
	return order.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:31:12)
 * @return java.lang.Integer
 */
public java.lang.Integer getOwnercode() {
	return ownercode;
}
public java.lang.String getParty() {
	return party;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPolicy() {
	return policy;
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
public java.lang.String getSerialnumber() {
	return serialnumber;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITPOP;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:31:12)
 * @return java.lang.Integer
 */
public java.lang.Integer getStoragecode() {
	return storagecode;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	PayoffForm form = (PayoffForm)request.getSession().getAttribute("PayoffForm");
	document.setInteger(form.getDocumentId());
	storagecode = form.getStorageKey();
	ownercode = form.getOwnerKey();
	try {
		DocumentPositionAccessBean dp = new DocumentPositionAccessBean();
		dp = dp.findMaxOrderPosition( document.getInteger() );
		order.setInteger(new Integer(dp.getOrder()+1));
	} catch(Exception e) {
		order.setInteger(new Integer(1));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (24.06.2005 10:28:07)
 * @return boolean
 */
public boolean isBrowseBySerial() {
	return browseBySerial;
}
public boolean isPartyUpdatable() {
	if("Add".equals(getAction())) {
		return true;
	} if("Edit".equals(getAction())) {
		return "P".equals(policy);
	} else {
		return false;
	}
}
public boolean isSerialUpdatable() {
	if("Add".equals(getAction())) {
		return true;
	} if("Edit".equals(getAction())) {
		return "S".equals(policy);
	} else {
		return false;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (24.06.2005 10:28:07)
 * @param newBrowseBySerial boolean
 */
public void setBrowseBySerial(boolean newBrowseBySerial) {
	browseBySerial = newBrowseBySerial;
}
public void setDocposition(java.lang.Integer newNumber) {
	docposition.setInteger(newNumber);
}
public void setDocpositionstr(String newNumber) {
	docposition.setString(newNumber);
}
public void setDocument(String newNumber) {
	document.setString(newNumber);
}
/**
 * 
 * @param newManufserial java.lang.String
 */
public void setManufserial(java.lang.String newManufserial) {
	manufserial = newManufserial;
}
public void setOrder(int newOrder) {
	order.setInteger(new Integer(newOrder));
}
public void setOrderstr(String newOrder) {
	order.setString(newOrder);
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:31:12)
 * @param newOwnercode java.lang.Integer
 */
public void setOwnercode(java.lang.Integer newOwnercode) {
	ownercode = newOwnercode;
}
public void setParty(java.lang.String newParty) {
	party = newParty;
}
/**
 * 
 * @param newPolicy java.lang.String
 */
public void setPolicy(java.lang.String newPolicy) {
	policy = newPolicy;
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
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
public void setSerialnumber(java.lang.String newSerialnumber) {
	serialnumber = newSerialnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:31:12)
 * @param newStoragecode java.lang.Integer
 */
public void setStoragecode(java.lang.Integer newStoragecode) {
	storagecode = newStoragecode;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if (order.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payoffpos.order"));
	} else if (!order.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoffpos.order"));
	}

	setBrowseBySerial(false);
	if(resource.isEmpty()){
		setResourcemodel("");
		setResourcename("");
	}
	
	if (resource.isEmpty()) {
		// Find resource by serialnumber/party if its empty
		if ( (serialnumber != null && serialnumber.length() > 0) ) {
			if(party == null || "".equals(party)) {
				// Only serial number specified - find resource by serial number

				Connection conn = null;
				int result = 0;

				try {
					
					conn = new JdbcConnection().getConnection();
					result = CDBCStoragecardsObject.findBySerialM(conn,getSerialnumber());
					
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

				
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					card = ab.findBySerial(serialnumber);
					resource.setInteger(new Integer(card.getResource().getResource()));
					price.setBigDecimal(card.getPrice());
					qty.setString("1");
					setManufserial(card.getManufserial());
				} catch(Exception e) {
				}
			} else 
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoffpos.serialparty"));
		} else if ( (party != null && party.length() > 0) ) {
			// Only party number specified - find resource by party number
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				card = ab.findByStorageOwnerParty(getStoragecode(), getOwnercode(), party);
				resource.setInteger(new Integer(card.getResource().getResource()));
				price.setBigDecimal(card.getPrice());
				setManufserial(card.getManufserial());
			} catch(Exception e) {
			}
		}
	}
	
	if(qty.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payoffpos.qty"));
	} else if (!qty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoffpos.qty"));
	} else if (qty.getBigDecimal().doubleValue() <= 0.0d) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoffpos.qtylow"));
	}

	if(resource.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payoffpos.resource"));
	} else if(!resource.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoffpos.resource"));
	}

	if (!errors.empty())
		throw new ValidationException();

	try {
		ResourceAccessBean bean = constructResource();
		String policy = bean.getCountpolicy();
		if("S".equals(policy)) {
			if ( (serialnumber == null || "".equals(serialnumber))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payoffpos.serial"));
			}
			if (party != null && !"".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoffpos.serialresource"));
			}
			if((serialnumber != null) && !"".equals(serialnumber)) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					card = ab.findBySerial(serialnumber);
					/*if( card.getResource().getResource() != resource.getInteger().intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoffpos.diffresources"));
					}*/
					if("Add".equals(getAction())) {
						price.setBigDecimal(card.getPrice());
					}
					setManufserial(card.getManufserial());
				} catch(Exception e) {
//					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoffpos.serial"));
				}
			}
			/*if(DocumentPositionForm.hasSameSerial(serialnumber,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserial",serialnumber));
			}*/
			System.err.println("****** " + document.getInteger());
			if(DocumentPositionForm.hasSameSerialAndResource(serialnumber,resource.getString(),document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserialandresource",resourcemodel,serialnumber));
			}
		}
		else if("P".equals(policy)) {
			if(party == null || "".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payoffpos.party"));
			} else
			if(serialnumber != null && !"".equals(serialnumber)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoffpos.partyresource"));
			}
			if((party != null) && !"".equals(party)) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					card = ab.findByStorageOwnerParty(storagecode,ownercode,party);
					if( card.getResource().getResource() != resource.getInteger().intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoffpos.diffresources"));
					}
					if("Add".equals(getAction())) {
						price.setBigDecimal(card.getPrice());
					}
					setManufserial(card.getManufserial());
				} catch(Exception e) {
//					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoffpos.party"));
				}
			}
			if(DocumentPositionForm.hasSameParty(party,ownercode,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameparty",party));
			}
		}
		else if("B".equals(policy)) {
			if((party != null && !"".equals(party)) || (serialnumber != null && !"".equals(serialnumber))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoffpos.bulkresource"));
			}
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				card = ab.findByStorageOwnerResource(storagecode,ownercode,resource.getInteger());
				if("Add".equals(getAction())) {
					price.setBigDecimal(card.getPrice());
				}
				setManufserial(card.getManufserial());
			} catch(Exception e) {
			}
			if(DocumentPositionForm.hasSameBulk(resource.getInteger(),ownercode,document.getInteger(),docposition.getInteger())) {
//				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassamebulk",resourcename+", "+resourcemodel));
			}
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.payoffpos.resource"));
	}

	if(manufserial != null && manufserial.length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.manufserial"));
	}

	if(price.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payoffpos.price"));
	} else if (!price.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoffpos.price"));
	} else if (price.getBigDecimal().doubleValue() < 0.0d) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payoffpos.pricelow"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
