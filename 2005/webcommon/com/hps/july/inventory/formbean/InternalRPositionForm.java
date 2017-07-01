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
 * ‘орма ввода и редактировани€ строки документа "¬нутренн€€ расходна€ накладна€"
 */
public class InternalRPositionForm extends DocumentPositionForm {
	private StringAndIntegerProperty docposition;
	private StringAndIntegerProperty order;
	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;
	private StringAndIntegerProperty complect;
	private String complectname;
	private String configuration;
	private StringAndBigDecimalProperty qty;
	private StringAndBigDecimalProperty price;
	private String party;
	private StringAndIntegerProperty document;
	private Integer storagecode;
	private Integer ownercode;
	private String policy;
	private boolean browseBySerial;
public InternalRPositionForm() {
	super();
	configuration = "";
	order = new StringAndIntegerProperty();
	docposition = new StringAndIntegerProperty();
	price = new StringAndBigDecimalProperty();
	qty = new StringAndBigDecimalProperty();
	resource = new StringAndIntegerProperty();
	resourcemodel = "";
	resourcename = "";
	complect = new StringAndIntegerProperty();
	complectname = "";
	document = new StringAndIntegerProperty();
	policy = "?";
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	try {
		if("Add".equals(getAction())) {
			addPosition2Document(docposition.getInteger());
		} else
		if("Edit".equals(getAction())) {
			addPosition2Document(docposition.getInteger());
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
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
			throw new UpdateValidationException("error.internalrpos.complectcreation");
		}
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

		// Check if we send for fixing
		DocumentPositionAccessBean dbean = (DocumentPositionAccessBean)bean;
		InternalOutBillAccessBean docbean = new InternalOutBillAccessBean(dbean.getDocument().getEJBRef());
		if (docbean.getFixing().booleanValue()) {
			dbean.setResultBroken(Boolean.TRUE);
			dbean.commitCopyHelper();
		}
		
		try {
			if ("Edit".equals(getAction()))
				removePositionFromDocument(docposition.getInteger());
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new UpdateValidationException("error.internalrpos.removeagregates");
		}
		
	}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	InternalRForm aform = (InternalRForm)request.getSession().getAttribute( "InternalRForm" );
	document.setInteger(aform.getDocumentId());
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	docposition.setInteger(new Integer(keyGen.getNextKey("tables.docpositions")));
	//ownercode = aform.getOwner();
	DocumentPositionAccessBean bean = new DocumentPositionAccessBean(
		docposition.getInteger().intValue(),
		resource.getInteger(),
		getOwnercode(),
		document.getInteger(),
		order.getInteger().intValue(),
		qty.getBigDecimal(),
		(price.getBigDecimal() == null)?new java.math.BigDecimal("0.00"):price.getBigDecimal(),
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
public String getComplectcode() {
	return complect.getString();
}
public String getComplectname() {
	return complectname;
}
public java.lang.String getConfiguration() {
	return configuration;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	InternalRForm aform = (InternalRForm)request.getSession().getAttribute( "InternalRForm" );
	document.setInteger(aform.getDocumentId());
	storagecode = aform.getStorageId();
//	ownercode = aform.getOwner();
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
 * Return position's owner.
 * Creation date: (05.09.2002 12:51:43)
 * @return com.hps.july.persistence.Organization
 * @exception java.lang.Exception The exception description.
 */
public Organization getOwner() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		bean.setInitKey_organization(getOwnercode().intValue());
		return (Organization)bean.getEJBRef();
	} catch(Exception e) {
		return null;
	}
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
 * Creation date: (07.08.2002 18:59:19)
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
public int getState() {
	return com.hps.july.inventory.APPStates.EDITIORP;
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
	InternalRForm aform = (InternalRForm)request.getSession().getAttribute( "InternalRForm" );
	storagecode = aform.getStorageId();
	ownercode = aform.getOwnerId();
	document.setInteger(aform.getDocumentId());
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
 * Creation date: (23.06.2005 12:07:43)
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
 * Creation date: (23.06.2005 12:07:43)
 * @param newBrowseBySerial boolean
 */
public void setBrowseBySerial(boolean newBrowseBySerial) {
	browseBySerial = newBrowseBySerial;
}
public void setComplectcode(String newResource) {
	complect.setString(newResource);
}
public void setComplectname(java.lang.String newResourcename) {
	complectname = newResourcename;
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
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internalrpos.order"));
	}
	else if (!order.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.order"));
	}


	setBrowseBySerial(false);
	if(resource.isEmpty()){
		setResourcemodel("");
		setResourcename("");
	}
	
	if (resource.isEmpty()) {
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
					StorageCardAccessBean card = ab.findBySerialResource(getSerialnumber(), resource.getInteger());
					resource.setInteger(new Integer(card.getResource().getResource()));
					price.setBigDecimal(card.getPrice());
					qty.setString("1.0");
					setConfiguration(card.getConfiguration());
					setManufserial(card.getManufserial());
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else 
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.serialparty"));
		} else if ( (party != null && party.length() > 0) ) {
			// Only party number specified - find resource by party number
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerParty(getStoragecode(), getOwnercode(), party);
				resource.setInteger(new Integer(card.getResource().getResource()));
				price.setBigDecimal(card.getPrice());
				setConfiguration(card.getConfiguration());
				setManufserial(card.getManufserial());
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	if(resource.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internalrpos.resource"));
	} else if(!resource.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.resource"));
	}
	
	if (qty.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internalrpos.qty"));
	} else if (!qty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.qty"));
	}

	if (!errors.empty())
		throw new ValidationException();
	
	try {
		ResourceAccessBean bean = constructResource();
		policy = bean.getCountpolicy();
		if("S".equals(policy)) {
			if ( (getSerialnumber() == null || "".equals(getSerialnumber()))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internalrpos.serial"));
			}
			if (party != null && !"".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.serialresource"));
			}
			if((getSerialnumber() != null) && !"".equals(getSerialnumber())) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerialResource(getSerialnumber(), resource.getInteger());
					/*if( card.getResource().getResource() != resource.getInteger().intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.diffresources"));
					}*/
					price.setBigDecimal(card.getPrice());
					setManufserial(card.getManufserial());
					setConfiguration(card.getConfiguration());
					setSourceBoxed(card.getBoxed());
					setSourceBroken(card.getBroken());
					setSourceClosed(card.getClosed());
					setOwnercode(new Integer(card.getOwner().getOrganization()));
					qty.setString("1");
				} catch(Exception e) {
//					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.serial"));
				}
			}
			/*if(DocumentPositionForm.hasSameSerial(serialnumber,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserial",serialnumber));
			}*/
			if(DocumentPositionForm.hasSameSerialAndResource(getSerialnumber(),resource.getString(),document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserialandresource",resourcemodel,getSerialnumber()));
			}
			
			if((qty.getBigDecimal() != null) && qty.getBigDecimal().doubleValue() != 1.0d) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.qtylow"));
			}
		}
		else if("P".equals(policy)) {
			if(party == null || "".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internalrpos.party"));
			} else
			if(getSerialnumber() != null && !"".equals(getSerialnumber())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.partyresource"));
			}
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerParty(storagecode,ownercode,party);
				if( card.getResource().getResource() != resource.getInteger().intValue()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.diffresources"));
				}
				price.setBigDecimal(card.getPrice());
				setConfiguration(card.getConfiguration());
				setSourceBoxed(card.getBoxed());
				setSourceBroken(card.getBroken());
				setSourceClosed(card.getClosed());
				setOwnercode(new Integer(card.getOwner().getOrganization()));
				setManufserial(card.getManufserial());
			} catch(Exception e) {
//				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.party"));
			}
			if(DocumentPositionForm.hasSameParty(party,ownercode,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameparty",party));
			}
		}
		else if("B".equals(policy)) {
			if((party != null && !"".equals(party)) || (getSerialnumber() != null && !"".equals(getSerialnumber()))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.bulkresource"));
			}
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerResource(storagecode,ownercode,resource.getInteger());
				price.setBigDecimal(card.getPrice());
				setConfiguration(card.getConfiguration());
				setSourceBoxed(card.getBoxed());
				setSourceBroken(card.getBroken());
				setSourceClosed(card.getClosed());
				setOwnercode(new Integer(card.getOwner().getOrganization()));
				setManufserial(card.getManufserial());
			} catch(Exception e) {
//				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.bulk"));
			}
			if(DocumentPositionForm.hasSameBulk(resource.getInteger(),ownercode,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassamebulk",resourcename+", "+resourcemodel));
			}
		}
		if(!bean.getPriceable().booleanValue() && price.isEmpty()) {
			price.setString("0.0");
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.internalrpos.resource"));
	}

	if(getManufserial() != null && getManufserial().length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.manufserial"));
	}

	setResultBoxed(getSourceBoxed());
	setResultBroken(getSourceBroken());
	setResultClosed(getSourceClosed());

	if (!price.isEmpty()) {
		if(!price.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.price"));
		} else if(price.getBigDecimal().doubleValue() < 0.00d) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.pricelow"));
		}
	} else {
		price.setString("0.00");
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
