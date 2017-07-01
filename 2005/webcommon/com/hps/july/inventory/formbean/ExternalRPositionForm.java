package com.hps.july.inventory.formbean;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import java.sql.Connection;
import com.hps.july.inventory.sessionbean.*;
import java.util.Enumeration;
import com.hps.july.inventory.valueobject.OuterDocPositionValue;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.cdbc.objects.*;

/**
 * ‘орма ввода и редактировани€ строки документа "¬нешн€€ расходна€ накладна€"
 */
public class ExternalRPositionForm extends DocumentPositionForm {
	private StringAndIntegerProperty docposition;
	private StringAndIntegerProperty order;
	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;
	private String configuration;
	private StringAndBigDecimalProperty qty;
	private StringAndBigDecimalProperty price;
	private String party;
	private StringAndIntegerProperty document;
	private Integer storagecode;
	private Integer ownercode;
	private String policy;
	private boolean browseBySerial;
	
public ExternalRPositionForm() {
	super();
	configuration = "";
	order = new StringAndIntegerProperty();
	docposition = new StringAndIntegerProperty();
	price = new StringAndBigDecimalProperty();
	qty = new StringAndBigDecimalProperty();
	resource = new StringAndIntegerProperty();
	resourcemodel = "";
	resourcename = "";
	document = new StringAndIntegerProperty();
	policy = "?";
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	try {
		if("Add".equals(getAction())) {
			ProcessingPositionError err = addPosition2Document(docposition.getInteger());
			/*if ((err != null) && (err.getErrorCode() != 0))
				System.out.println("COPY AGREGATE CONTENTS ERROR: " + err.getErrorCode());*/
		} else
		if("Edit".equals(getAction())) {
			addPosition2Document(docposition.getInteger());
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception 
	{
		try {
			removePositionFromDocument(docposition.getInteger());
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new UpdateValidationException("error.internalrpos.removeagregates");
		}
	}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {
		
		try {
			if ("Edit".equals(getAction()))
				removePositionFromDocument(docposition.getInteger());
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new UpdateValidationException("error.internalrpos.removeagregates");
		}
		
	}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	ExternalRForm aform = (ExternalRForm)request.getSession().getAttribute( "ExternalRForm" );
	document.setInteger(aform.getDocumentId());
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	docposition.setInteger(new Integer(keyGen.getNextKey("tables.docpositions")));
	ownercode = aform.getOwnerId();
	setSourceClosed(Boolean.TRUE);
	DocumentPositionAccessBean bean = new DocumentPositionAccessBean(
		docposition.getInteger().intValue(),
		resource.getInteger(),
		ownercode,
		document.getInteger(),
		order.getInteger().intValue(),
		qty.getBigDecimal(),
		price.getBigDecimal(),
		getSourceBoxed(),
		getResultBoxed(),
		getSourceBroken(),
		getResultBroken(),
		getSourceClosed(),
		getResultClosed()
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
		policy = ab.getResource().getCountpolicy();
		ownercode = new Integer(ab.getOwner().getOrganization());
	} catch(Exception e) {
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
public java.lang.String getConfiguration() {
	return configuration;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ExternalRForm aform = (ExternalRForm)request.getSession().getAttribute( "ExternalRForm" );
	storagecode = aform.getStorageId();
	document.setInteger(aform.getDocumentId());
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
 * Insert the method's description here.
 * Creation date: (07.08.2002 19:24:53)
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
public java.lang.Boolean getSourceClosed() {
	return Boolean.TRUE;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITEORP;
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
	super.initRecord(request);
	ExternalRForm aform = (ExternalRForm)request.getSession().getAttribute( "ExternalRForm" );
	storagecode = aform.getStorageId();
	ownercode = aform.getOwnerId();
	document.setInteger(aform.getDocumentId());
	try {
		DocumentPositionAccessBean dp = new DocumentPositionAccessBean();
		dp = dp.findMaxOrderPosition( document.getInteger() );
		order.setInteger(new Integer(dp.getOrder()+1));
	} catch(Exception e) {
		e.printStackTrace(System.out);
		order.setInteger(new Integer(1));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 12:40:07)
 * @return boolean
 */
public boolean isBrowseBySerial() {
	return browseBySerial;
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
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 12:40:07)
 * @param newBrowseBySerial boolean
 */
public void setBrowseBySerial(boolean newBrowseBySerial) {
	browseBySerial = newBrowseBySerial;
}
public void setConfiguration(java.lang.String newConfiguration) {
	configuration = newConfiguration;
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
 * Insert the method's description here.
 * Creation date: (07.08.2002 19:24:53)
 * @param newPolicy java.lang.String
 */
void setPolicy(java.lang.String newPolicy) {
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
	preprocessSerials();
	if (order.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalrpos.order"));
	}
	else if (!order.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.order"));
	}

	setBrowseBySerial(false);
	if(resource.isEmpty()){
		setResourcemodel("");
		setResourcename("");
	}
	
	if (resource.getInteger() == null) {
		// Find resource by serialnumber/party if its empty
		if ( (getSerialnumber() != null && getSerialnumber().length() > 0) ) {
			if(party == null || "".equals(party)) {

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

				
				// Only serial number specified - find resource by serial number
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(getSerialnumber());
					resource.setInteger(new Integer(card.getResource().getResource()));
					setConfiguration(card.getConfiguration());
					//price.setBigDecimal(card.getPrice());
					setOwnercode(new Integer(card.getOwner().getOrganization()));
					setSourceBroken(card.getBroken());
					setSourceBoxed(card.getBoxed());
					setSourceClosed(card.getClosed());
					setManufserial(card.getManufserial());
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.serialparty"));
			}
		} else if ( (party != null && party.length() > 0) ) {
			// Only party number specified - find resource by party number
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerParty(getStoragecode(), getOwnercode(), party);
				resource.setInteger(new Integer(card.getResource().getResource()));
				//price.setBigDecimal(card.getPrice());
				setConfiguration(card.getConfiguration());
				setOwnercode(new Integer(card.getOwner().getOrganization()));
				setSourceBroken(card.getBroken());
				setSourceBoxed(card.getBoxed());
				setSourceClosed(card.getClosed());
				setManufserial(card.getManufserial());
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	if(resource.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalrpos.resource"));
	} else if(!resource.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.resource"));
	}
	
	if (qty.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalrpos.qty"));
	} else if (!qty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.qty"));
	}

	if (!price.isEmpty()) {
		if(!price.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.price"));
		} else
		if(price.getBigDecimal().doubleValue() < 0.0d) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.pricelow"));
		}
	}

	/*	
	if(configuration != null && configuration.length() > 40) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.configuration"));
	}
	*/
	
	if (!errors.empty())
		throw new ValidationException();

	try {
		ResourceAccessBean bean = constructResource();
		String policy = bean.getCountpolicy();
		if("S".equals(policy)) {
			if ( (getSerialnumber() == null || "".equals(getSerialnumber()))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalrpos.serial"));
			}
			if(qty.getBigDecimal().doubleValue() != 1.0d) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.qtylow"));
			}
			if (party != null && !"".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.serialresource"));
			}
			if((getSerialnumber() != null) && !"".equals(getSerialnumber())) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(getSerialnumber());
					/*if( card.getResource().getResource() != resource.getInteger().intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.diffresources"));
					}*/
					setConfiguration(card.getConfiguration());
					setOwnercode(new Integer(card.getOwner().getOrganization()));
					setSourceBroken(card.getBroken());
					setSourceBoxed(card.getBoxed());
					setSourceClosed(card.getClosed());
					setManufserial(card.getManufserial());
				} catch(Exception e) { 
//					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.serial"));
				}
			}
			/*if(DocumentPositionForm.hasSameSerial(serialnumber,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserial",serialnumber));
			}*/
			if(DocumentPositionForm.hasSameSerialAndResource(getSerialnumber(),resource.getString(),document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserialandresource",resourcemodel,getSerialnumber()));
			}
		}
		else if("P".equals(policy)) {
			if(party == null || "".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalrpos.party"));
			} else
			if(getSerialnumber() != null && !"".equals(getSerialnumber())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.partyresource"));
			}
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerParty(storagecode,ownercode,party);
				if( card.getResource().getResource() != resource.getInteger().intValue()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.diffresources"));
				}
				setConfiguration(card.getConfiguration());
				setOwnercode(new Integer(card.getOwner().getOrganization()));
				setSourceBroken(card.getBroken());
				setSourceBoxed(card.getBoxed());
				setSourceClosed(card.getClosed());
				setManufserial(card.getManufserial());
			} catch(Exception e) {
//				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.party"));
			}
			if(DocumentPositionForm.hasSameParty(party,ownercode,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameparty",party));
			}
		}
		else if("B".equals(policy)) {
			if((party != null && !"".equals(party)) || (getSerialnumber() != null && !"".equals(getSerialnumber()))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.bulkresource"));
			}
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerResource(storagecode,ownercode,resource.getInteger());
				setConfiguration(card.getConfiguration());
				setOwnercode(new Integer(card.getOwner().getOrganization()));
				setSourceBroken(card.getBroken());
				setSourceBoxed(card.getBoxed());
				setSourceClosed(card.getClosed());
				setManufserial(card.getManufserial());
			} catch(Exception e) {
//				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.bulk"));
			}
			if(DocumentPositionForm.hasSameBulk(resource.getInteger(),ownercode,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassamebulk",resourcename+", "+resourcemodel));
			}
		}
		if(!bean.getPriceable().booleanValue() && price.isEmpty()) {
			price.setString("0.0");
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.externalrpos.resource"));
	}

	if(getManufserial() != null && getManufserial().length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.manufserial"));
	}

	if (!price.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.price"));
	} else if(price.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalrpos.price"));
	} else if (price.getBigDecimal().doubleValue() < 0.0d) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.qtylow"));
	}
	if (!qty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.qty"));
	} else if(qty.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalrpos.qty"));
	} else if (qty.getBigDecimal().doubleValue() < 0.0d) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalrpos.qtylow"));
	}

	setResultBoxed(getSourceBoxed());
	setResultBroken(getSourceBroken());
	setResultClosed(Boolean.FALSE);
	setSourceClosed(Boolean.TRUE);
	if (!errors.empty())
		throw new ValidationException();
}
}
