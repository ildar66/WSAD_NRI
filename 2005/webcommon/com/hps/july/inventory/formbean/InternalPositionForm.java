package com.hps.july.inventory.formbean;

import java.text.NumberFormat;
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
 * ‘орма ввода и редактировани€ строки документа "¬нутренний приходный ордер"
 */
public class InternalPositionForm extends DocumentPositionForm {
	private StringAndIntegerProperty docposition;
	private StringAndIntegerProperty order;
	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;
	private StringAndBigDecimalProperty docqty;
	private StringAndBigDecimalProperty qty;
	private StringAndBigDecimalProperty price;
	private String party;
	private StringAndIntegerProperty document;
	private Integer storagecode;
	private Integer ownercode;
	private String configuration;
	private Boolean fixing;
	private String policy;
	private int expeditor;
	private boolean browseBySerial;
	
public InternalPositionForm() {
	super();
	order = new StringAndIntegerProperty();
	docposition = new StringAndIntegerProperty();
	price = new StringAndBigDecimalProperty();
	docqty = new StringAndBigDecimalProperty();
	qty = new StringAndBigDecimalProperty();
	resource = new StringAndIntegerProperty();
	resourcemodel = "";
	resourcename = "";
	document = new StringAndIntegerProperty();
	policy = "";
	setResultBroken(java.lang.Boolean.FALSE);
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	try {
		if("Add".equals(getAction())) {
			ProcessingPositionError err = addPosition2Document(docposition.getInteger());
			//if ((err != null) && (err.getErrorCode() != 0))
				//System.out.println("COPY AGREGATE CONTENTS ERROR: " + err.getErrorCode());
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
	InternalForm aform = (InternalForm)request.getSession().getAttribute( "InternalForm" );
	document.setInteger(aform.getDocumentId());
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	docposition.setInteger(new Integer(keyGen.getNextKey("tables.docpositions")));
	//ownercode = aform.getOwner();
	InternalWayBillPositionAccessBean bean = new InternalWayBillPositionAccessBean(
		docposition.getInteger().intValue(),
		resource.getInteger(),
		getOwnercode(),
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
/**
 * Insert the method's description here.
 * Creation date: (05.09.2002 18:42:34)
 * @return com.hps.july.persistence.DocumentPositionAccessBean
 */
public DocumentPositionAccessBean constructDocumentPosition(StorageCardAccessBean sc, DocumentAccessBean document, int newDocposition, DocumentPositionAccessBean position, int order)
	throws Exception
{
	if(position != null) position.refreshCopyHelper();

	InternalWayBillPositionAccessBean pos = new InternalWayBillPositionAccessBean( 
		newDocposition, 
		new Integer(sc.getResourceKey().resource), new Integer(sc.getOwnerKey().organization), 
		new Integer(document.getDocument()), 
		order, sc.getQty(), sc.getPrice(), sc.getBoxed(), position.getResultBoxed(), sc.getBroken(), 
		position.getResultBroken(), sc.getClosed(), position.getResultClosed() );
	pos.setParty( sc.getParty() );
	pos.setSerialnumber( sc.getSerialnumber() );
	pos.setConfiguration( sc.getConfiguration() );
	pos.setAgregate( (DocumentPosition)(position.getEJBRef()) );
	pos.setDocQty(sc.getQty());
	pos.commitCopyHelper();
	return new DocumentPositionAccessBean(pos.getEJBRef());
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2002 18:42:34)
 * @return com.hps.july.persistence.DocumentPositionAccessBean
 */
public DocumentPositionAccessBean constructDocumentPosition(StorageCardAccessBean sc, 
	DocumentAccessBean document, int newDocposition, DocumentPositionAccessBean position, 
	int order, AgregateContentAccessBean agr)
	throws Exception
{
	return constructDocumentPosition(sc,document,newDocposition,position,order);
	/*
		DocumentPositionAccessBean pos = new DocumentPositionAccessBean( 
			newDocposition, 
			new Integer(sc.getResourceKey().resource), new Integer(sc.getOwnerKey().organization), 
			new Integer(document.getDocument()), 
			order, agr.getQty(), sc.getPrice(), sc.getBoxed(), position.getResultBoxed(), sc.getBroken(), 
			position.getResultBroken(), sc.getClosed(), position.getResultClosed() );
		pos.setParty( sc.getParty() );
		pos.setSerialnumber( sc.getSerialnumber() );
		pos.setConfiguration( sc.getConfiguration() );
		pos.setAgregate( (DocumentPosition)(position.getEJBRef()) );
		pos.commitCopyHelper();
		return pos;
	*/
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
		InternalWayBillPositionAccessBean ab = (InternalWayBillPositionAccessBean)bean;
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

/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 14:09:44)
 * @return java.lang.String
 */
public java.lang.String getConfiguration() {
	return configuration;
}

public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	InternalForm aform = (InternalForm)request.getSession().getAttribute( "InternalForm" );
	document.setInteger(aform.getDocumentId());
	storagecode = aform.getStorageId();
	fixing = aform.getFixing();
	InternalWayBillPositionAccessBean bean = new InternalWayBillPositionAccessBean();
	bean.setInitKey_docposition(docposition.getInteger().intValue());
	return bean;
}
public java.lang.Integer getDocposition() {
	return docposition.getInteger();
}
public String getDocpositionstr() {
	return docposition.getString();
}
public java.math.BigDecimal getDocQty() {
	return docqty.getBigDecimal();
}
public String getDocQtystr() {
	NumberFormat nf = NumberFormat.getInstance();
	nf.setMaximumFractionDigits(0);
	String result;
	if(docqty!=null && docqty.getBigDecimal()!=null){
		result = nf.format(docqty.getBigDecimal().doubleValue());
	}else{
		result="";
	}
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (04.09.2002 17:24:36)
 * @return int
 */
public int getExpeditor() {
	return expeditor;
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
	NumberFormat nf = NumberFormat.getInstance();
	nf.setMaximumFractionDigits(0);
	String result;
	if(qty!=null && qty.getBigDecimal()!=null){
		result = nf.format(qty.getBigDecimal().doubleValue());
	}else{
		result="";
	}
	return result;
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
	return com.hps.july.inventory.APPStates.EDITIOP;
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
	InternalForm form = (InternalForm)request.getSession().getAttribute("InternalForm");
	if(form.getExpeditionId() != null) {
		expeditor = form.getExpeditionId().intValue();
	} else {
		expeditor = 0;
	}
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	super.initRecord(request);
	InternalForm form = (InternalForm)request.getSession().getAttribute("InternalForm");
	document.setInteger(form.getDocumentId());
	storagecode = form.getStorageId();
	fixing = form.getFixing();
	if(form.getExpeditionId() != null) {
		expeditor = form.getExpeditionId().intValue();
	} else {
		expeditor = 0;
	}
	ownercode = form.getOwnerId();
	try {
		InternalWayBillPositionAccessBean dp = new InternalWayBillPositionAccessBean();
		dp = dp.findMaxOrderPosition( document.getInteger() );
		order.setInteger(new Integer(dp.getOrder()+1));
	} catch(Exception e) {
		order.setInteger(new Integer(1));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 16:12:47)
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
	public void removePositionFromDocument(Integer docPosition) throws java.rmi.RemoteException {
		try {
			InternalWayBillPositionAccessBean position = new InternalWayBillPositionAccessBean();
			position.setInitKey_docposition( docPosition.intValue() );
			position.refreshCopyHelper();

			InternalWayBillPositionAccessBeanTable parts = new InternalWayBillPositionAccessBeanTable();
			parts.setInternalWayBillPositionAccessBean( new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(
				position.getAgregateParts(), InternalWayBillPositionAccessBean.class ));

			for( int i = 0; i < parts.numberOfRows(); i++ ) {
				InternalWayBillPositionAccessBean part = parts.getInternalWayBillPositionAccessBean(i);
				part.refreshCopyHelper();
				part.getEJBRef().remove();
			}
		} catch( Exception e ) {
			throw new java.rmi.RemoteException( "While adding position to document.", e );
		}
	}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 16:12:47)
 * @param newBrowseBySerial boolean
 */
public void setBrowseBySerial(boolean newBrowseBySerial) {
	browseBySerial = newBrowseBySerial;
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
public void setDocQty(java.math.BigDecimal newQty) {
	docqty.setBigDecimal(newQty);
}

public void setDocQtystr(String newQty) {
	docqty.setString(newQty);
}

public void setDocument(String newNumber) {
	document.setString(newNumber);
}

/**
 * Insert the method's description here.
 * Creation date: (04.09.2002 17:24:36)
 * @param newExpeditor int
 */
public void setExpeditor(int newExpeditor) {
	expeditor = newExpeditor;
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
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internalpos.order"));
	} else if (!order.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.order"));
	}
	
	if (docqty.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internalpos.docqty"));
	} else if (!docqty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.docqty"));
	} else if (docqty.getBigDecimal().doubleValue() <= 0.0d) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.docqtylow"));
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
					setOwnercode(new Integer(card.getOwner().getOrganization()));
					price.setBigDecimal(card.getPrice());
					setConfiguration(card.getConfiguration());
					setSourceBroken(card.getBroken());
					setSourceBoxed(card.getBoxed());
					setSourceClosed(card.getClosed());
					setManufserial(card.getManufserial());
					qty.setString("1");
				} catch(Exception e) {
				}
			} else 
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.serialparty"));
		} else if ( (party != null && party.length() > 0) ) {
			// Only party number specified - find resource by party number
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerParty(new Integer(expeditor), getOwnercode(), party);
				setOwnercode(new Integer(card.getOwner().getOrganization()));
				resource.setInteger(new Integer(card.getResource().getResource()));
				price.setBigDecimal(card.getPrice());
				setManufserial(card.getManufserial());
				setConfiguration(card.getConfiguration());
				setSourceBroken(card.getBroken());
				setSourceBoxed(card.getBoxed());
				setSourceClosed(card.getClosed());
			} catch(Exception e) {
			}
		}
	}
	
	if(qty.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internalpos.qty"));
	} else if (!qty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.qty"));
	} else if (qty.getBigDecimal().doubleValue() <= 0.0d) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.qtylow"));
	}

	if(resource.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internalpos.resource"));
	} else if(!resource.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.resource"));
	}

	if(getManufserial() != null && getManufserial().length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.manufserial"));
	}

	/*
	if(configuration != null && configuration.length() > 40) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.configuration"));
	}
	*/
	
	if (!errors.empty())
		throw new ValidationException();

	try {
		ResourceAccessBean bean = constructResource();
		String policy = bean.getCountpolicy();
		if("S".equals(policy)) {
			if ( (getSerialnumber() == null || "".equals(getSerialnumber()))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internalpos.serial"));
			}
			if(docqty.getBigDecimal().doubleValue() != 1.0d) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.docqtyone"));
			}
			if(qty.getBigDecimal().doubleValue() != 1.0d) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.qtylow"));
			}
			if (party != null && !"".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.serialresource"));
			}
			if((getSerialnumber() != null) && !"".equals(getSerialnumber())) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerialResource(getSerialnumber(), resource.getInteger());
					//”никальность серийника
					/*if( card.getResource().getResource() != resource.getInteger().intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.diffresources"));
					}*/
					setOwnercode(new Integer(card.getOwner().getOrganization()));
					price.setBigDecimal(card.getPrice());
					setManufserial(card.getManufserial());
					setConfiguration(card.getConfiguration());
					setSourceBroken(card.getBroken());
					setSourceBoxed(card.getBoxed());
					setSourceClosed(card.getClosed());
				} catch(Exception e) {
//					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.serial"));
//					if (!errors.empty()) throw new ValidationException();
				}
			}

			//”никальность серийника
			/*if(DocumentPositionForm.hasSameSerial(serialnumber,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserial",serialnumber));
			}*/

			//”никальность серийника и ресурса
			if(DocumentPositionForm.hasSameSerialAndResource(getSerialnumber(),resource.getString(),document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserialandresource",resourcemodel,getSerialnumber()));
			}
		}
		else if("P".equals(policy)) {
			if(party == null || "".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.internalpos.party"));
			} else
			if(getSerialnumber() != null && !"".equals(getSerialnumber())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.partyresource"));
			}
			if((party != null) && !"".equals(party)) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findByStorageOwnerParty(new Integer(expeditor),ownercode,party);
					if( card.getResource().getResource() != resource.getInteger().intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.diffresources"));
					}
					setOwnercode(new Integer(card.getOwner().getOrganization()));
					price.setBigDecimal(card.getPrice());
					setManufserial(card.getManufserial());
					setConfiguration(card.getConfiguration());
					setSourceBroken(card.getBroken());
					setSourceBoxed(card.getBoxed());
					setSourceClosed(card.getClosed());
				} catch(Exception e) {
//					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.party"));
//					if (!errors.empty()) throw new ValidationException();
				}
			}
			if(DocumentPositionForm.hasSameParty(party,ownercode,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameparty",party));
			}
		}
		else if("B".equals(policy)) {
			if((party != null && !"".equals(party)) || (getSerialnumber() != null && !"".equals(getSerialnumber()))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.bulkresource"));
			}
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				Enumeration en = ab.findByStorageResource(new Integer(expeditor),resource.getInteger());
				if(en.hasMoreElements()) {
					StorageCardAccessBean card = (StorageCardAccessBean)en.nextElement();
					setOwnercode(new Integer(card.getOwner().getOrganization()));
					price.setBigDecimal(card.getPrice());
					setManufserial(card.getManufserial());
					setConfiguration(card.getConfiguration());
					setSourceBroken(card.getBroken());
					setSourceBoxed(card.getBoxed());
					setSourceClosed(card.getClosed());
				} else {
					throw new Exception();
				}
			} catch(Exception e) {
//				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.bulk"));
//				if (!errors.empty()) throw new ValidationException();
			}
			if(DocumentPositionForm.hasSameBulk(resource.getInteger(),ownercode,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassamebulk",resourcename+", "+resourcemodel));
			}
		}

		setResultBoxed(getSourceBoxed());
		setResultClosed(getSourceClosed());

		/*
		if(!price.isEmpty()) {
			if (!price.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.price"));
			} else if (price.getBigDecimal().doubleValue() < 0.0d) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.pricelow"));
			}
		}
		*/

		if(Boolean.TRUE.equals(fixing)) {
			setResultBroken(Boolean.FALSE);
		}
		if(!bean.getPriceable().booleanValue() && price.isEmpty()) {
			price.setString("0.0");
		}
	} catch(ValidationException ve) {
		throw ve;
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.internalpos.resource"));
	}

	if(price.isEmpty()) {
		price.setString("0.0");
	}

	if (!errors.empty())
		throw new ValidationException();
}

}
