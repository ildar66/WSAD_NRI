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
 * Форма ввода и редактирования строки документа "Акт демонтажа блоков на складе"
 */
public class DAssactposForm
	extends DocumentPositionForm
{
	private StringAndIntegerProperty docposition;
	private StringAndIntegerProperty order;
	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;
	private StringAndBigDecimalProperty qty;
	private StringAndBigDecimalProperty price;
	//private String serialnumber;
	//private String manufserial;
	private String party;
	private StringAndIntegerProperty document;
	private Integer storagecode;
	private Integer ownercode;
	private java.lang.String oldAgregateSerial;

	private String fromplace;
	private boolean browseBySerial;
	
public DAssactposForm() {
	order = new StringAndIntegerProperty();
	docposition = new StringAndIntegerProperty();
	price = new StringAndBigDecimalProperty();
	qty = new StringAndBigDecimalProperty();
	resource = new StringAndIntegerProperty();
	resourcemodel = "";
	resourcename = "";
	document = new StringAndIntegerProperty();
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	DAssactForm aform = (DAssactForm)request.getSession().getAttribute( "DAssactForm" );
	document.setInteger(aform.getDocumentId());
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	docposition.setInteger(new Integer(keyGen.getNextKey("tables.docpositions")));
//	ownercode = aform.getOwner();
	AssemblingActAccessBean assbean = new AssemblingActAccessBean();
	assbean.setInitKey_document(document.getInteger().intValue());
	assbean.refreshCopyHelper();

	if(com.hps.july.util.AppUtils.getInventoryVariant() == 2) {
		setOldAgregateSerial(assbean.getAgregateserial());
	} else {
		setOldAgregateSerial(assbean.getAgregat().getSerialnumber());
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
		fromplace = ab.getOldplace();
		ownercode = new Integer(ab.getOwner().getOrganization());
	} catch(Exception e) {
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	DAssactForm aform = (DAssactForm)request.getSession().getAttribute( "DAssactForm" );
	document.setInteger(aform.getDocumentId());
	DocumentPositionAccessBean bean = new DocumentPositionAccessBean();
	bean.setInitKey_docposition(docposition.getInteger().intValue());
	try {
		setOldAgregateSerial(bean.getOldAgregateSerial());
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return bean;
}
public java.lang.Integer getDocposition() {
	return docposition.getInteger();
}
public String getDocpositionstr() {
	return docposition.getString();
}
public String getDocument() {
	return document.getString();
}
public java.lang.String getFromplace() {
	return fromplace;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2002 11:07:10)
 * @return java.lang.String
 */
public java.lang.String getOldAgregateSerial() {
	return oldAgregateSerial;
}
public java.lang.String getOldplace() {
	return fromplace;
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
public int getState() {
	return com.hps.july.inventory.APPStates.EDITDASSP;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:31:12)
 * @return java.lang.Integer
 */
public java.lang.Integer getStoragecode() {
	return storagecode;
}
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	DAssactForm aform = (DAssactForm)request.getSession().getAttribute("DAssactForm");
	setStoragecode(aform.getStoragecode());
	setOwnercode(aform.getOwnercode());
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	super.initRecord(request);
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
 * Creation date: (23.06.2005 18:44:18)
 * @return boolean
 */
public boolean isBrowseBySerial() {
	return browseBySerial;
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 18:44:18)
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
public void setDocument(String docstr)
{
	document.setString(docstr);
}
/**
 * 
 * @param newFromplace java.lang.String
 */
public void setFromplace(java.lang.String newFromplace) {
	fromplace = newFromplace;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2002 11:07:10)
 * @param newOldAgregateSerial java.lang.String
 */
public void setOldAgregateSerial(java.lang.String newOldAgregateSerial) {
	oldAgregateSerial = newOldAgregateSerial;
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
public void setStoragecode(java.lang.Integer newStoragecode) {
	storagecode = newStoragecode;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	preprocessSerials();
	if (order.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactpos.order"));
	}
	else if (!order.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactpos.order"));
	}

	setBrowseBySerial(false);
	if(resource.isEmpty()){
		setResourcemodel("");
		setResourcename("");
	}
	
	// Find resource by serialnumber/party if its empty
	if (resource.isEmpty()) {
		if ( (getSerialnumber() != null && getSerialnumber().length() > 0) ) {
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
					StorageCardAccessBean card = ab.findBySerialResource(getSerialnumber(), resource.getInteger());
					resource.setInteger(new Integer(card.getResource().getResource()));
					fromplace = card.getPlace();
					setManufserial(card.getManufserial());
				} catch(Exception e) { }
			} else 
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactpos.serialparty"));
		} else if ( (party != null && party.length() > 0) ) {
				// Only party number specified - find resource by party number
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findByStorageOwnerParty(getStoragecode(), getOwnercode(), party);
					resource.setInteger(new Integer(card.getResource().getResource()));
					fromplace = card.getPlace();
					setManufserial(card.getManufserial());
				} catch(Exception e) { }
		}
	}
		
	try {
		ResourceAccessBean bean = constructResource();
		String policy = bean.getCountpolicy();
		if("S".equals(policy)) {
			if ( (getSerialnumber() == null || "".equals(getSerialnumber()))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactpos.serial"));
			}
			if (!qty.isEmpty() && (qty.getBigDecimal().doubleValue() != 1.0d)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactpos.qtylow"));
			}
			if (party != null && !"".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactpos.serialresource"));
			}
			if((getSerialnumber() != null) && !"".equals(getSerialnumber())) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerialResource(getSerialnumber(), resource.getInteger());
					/*if( card.getResource().getResource() != resource.getInteger().intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactpos.diffresources"));
					}*/
					setPrice(card.getPrice());
					setFromplace(card.getPlace());
					setManufserial(card.getManufserial());
				} catch(Exception e) { }
			}
			/*if(DocumentPositionForm.hasSameSerial(serialnumber,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserial",serialnumber));
			}*/
			if(DocumentPositionForm.hasSameSerialAndResource(getSerialnumber(),resource.getString(),document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserialandresource",resourcemodel,getSerialnumber()));
			}
			/*
			if(fromplace == null || "".equals(fromplace.trim())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fromplace"));
			} else {
				fromplace = fromplace.trim();
				if(fromplace.length() > 40) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fromplace"));
				}
			}
			*/
		}
		else if("P".equals(policy)) {
			if(party == null || "".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactpos.party"));
			} else
			if(getSerialnumber() != null && !"".equals(getSerialnumber())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactpos.partyresource"));
			}
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerParty(getStoragecode(), getOwnercode(), party);
				if( card.getResource().getResource() != resource.getInteger().intValue()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactpos.diffresources"));
				}
				setPrice(card.getPrice());
				setFromplace(card.getPlace());
				setManufserial(card.getManufserial());
			} catch(Exception e) { }
			if(DocumentPositionForm.hasSameParty(party,ownercode,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameparty",party));
			}
		}
		else if("B".equals(policy)) {
			if((party != null && !"".equals(party)) || (getSerialnumber() != null && !"".equals(getSerialnumber()))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactpos.bulkresource"));
			} else {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findByStorageOwnerResource(getStoragecode(), getOwnercode(), resource.getInteger());
					setPrice(card.getPrice());
					setFromplace(card.getPlace());
					setManufserial(card.getManufserial());
				} catch(Exception e) { }
			}
			if(DocumentPositionForm.hasSameBulk(resource.getInteger(),ownercode,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassamebulk",resourcename+", "+resourcemodel));
			}
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.dassactpos.resource"));
	}
	
	if(getManufserial() != null && getManufserial().length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.manufserial"));
	}

	if (qty.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactpos.qty"));
	} else if (!qty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactpos.qty"));
	}

	if (price.isEmpty()) {
		price.setString("0");
	}

	/*
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactpos.price"));
	else if(!price.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactpos.price"));
		}
		else if(price.getBigDecimal().doubleValue() < 0.0d) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactpos.pricelow"));
		}
	*/

	//System.out.println("Fromplace: "+fromplace);
//	if(fromplace == null || "".equals(fromplace.trim())) {
//		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fromplace"));
//	} else {
	if(fromplace != null && !"".equals(fromplace)) {
		fromplace = fromplace.trim();
		if(fromplace.length() > 40) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fromplace"));
		}
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
