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
 * Форма редактирования строки актов монтажа АФС
 * Форма используется для ввода дополнительного оборудования
 * кроме антенны с кабелем.
 */
public class AfsPositionForm
	extends DocumentPositionForm
{
	private StringAndIntegerProperty docpos;
	
	private StringAndIntegerProperty order;
	
	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;
	
	private String configuration;

	private StringAndBigDecimalProperty qty;
	
	private StringAndBigDecimalProperty price;
	
	private String serialnumber;
	private String manufserial;
	private String party;
	
	private StringAndIntegerProperty doc;
	
	private Integer positioncode;
	private String positionname;
	private String positionid;
	
	private Integer ownercode;
	private String ownername;
	
	private Integer complectcode;
	private String complectname;

	private StringAndIntegerProperty resourceset;
	private String resourcesetname;
	
	private String policy;

	private Integer expedition;

	private String fitplace;
	private java.lang.String comment;
	private boolean browseBySerial;
public AfsPositionForm() {
	super();
	order = new StringAndIntegerProperty();
	docpos = new StringAndIntegerProperty();
	price = new StringAndBigDecimalProperty();
	qty = new StringAndBigDecimalProperty();
	resource = new StringAndIntegerProperty();
	resourcemodel = "";
	resourcename = "";
	doc = new StringAndIntegerProperty();
	resourceset = new StringAndIntegerProperty();
	resourcesetname = "";
	policy = "";
	setSourceBoxed(Boolean.FALSE);
	setSourceBroken(Boolean.FALSE);
	setSourceClosed(Boolean.FALSE);
	setResultBoxed(Boolean.FALSE);
	setResultBroken(Boolean.FALSE);
	setResultClosed(Boolean.FALSE);
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	try {
		if("Add".equals(getAction())) {
			ProcessingPositionError err = addPosition2Document(docpos.getInteger());
			/*if ((err != null) && (err.getErrorCode() != 0))
				System.out.println("COPY AGREGATE CONTENTS ERROR: " + err.getErrorCode());*/
		} else
		if("Edit".equals(getAction())) {
			ProcessingPositionError err = addPosition2Document(docpos.getInteger());
			/*if ((err != null) && (err.getErrorCode() != 0))
				System.out.println("COPY AGREGATE CONTENTS ERROR: " + err.getErrorCode());*/
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	//System.out.println("AssemPosForm: create resourceset;");
	if("Add".equals(getAction()) && (resourceset.getInteger() != null)) {
		// get complect parts and add create positions for it
		try {
			KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
			int pos;

			ResourceSetAccessBean resset = new ResourceSetAccessBean();
			resset.setInitKey_resourceset(resourceset.getInteger().intValue());
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
					
//					DocumentPositionAccessBean posbean = new DocumentPositionAccessBean(
//						pos,
//						new Integer(res.getResource()),
//						ownercode,
//						doc.getInteger(),
//						partorders++,
//						pq,
//						new java.math.BigDecimal("0.00"),
//						Boolean.FALSE,
//						Boolean.FALSE,
//						Boolean.FALSE,
//						Boolean.FALSE,
//						Boolean.FALSE,
//						Boolean.FALSE
//					);
				}
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new UpdateValidationException("error.internalrpos.complectcreation");
		}
	}
	//System.out.println("AssemPosForm: exit;");
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean,	javax.servlet.http.HttpServletRequest request)
	throws Exception 
{
	try {
		removePositionFromDocument(docpos.getInteger());
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
public void beforeUpdate(AbstractEntityAccessBean bean,	javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	AfsMountPosAccessBean p = (AfsMountPosAccessBean)bean;
	p.setDocpostype("D");
	if(getFictionSerial() != null && getFictionSerial().booleanValue()) {
		p.setIsfictserial(true);
		p.setSerialnumber(null);
	} else {
		p.setIsfictserial(false);
		p.setSerialnumber(getSnumber());
	}
	p.setRealserial(null);
	p.setComment(comment);
	try {
		if ("Edit".equals(getAction()))
			removePositionFromDocument(docpos.getInteger());
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.internalrpos.removeagregates");
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	AfsForm aform = (AfsForm)request.getSession().getAttribute( "AfsForm" );
	doc.setInteger(aform.getDocumentId());
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	docpos.setInteger(new Integer(keyGen.getNextKey("tables.docpositions")));
	AfsMountPosAccessBean bean = new AfsMountPosAccessBean(
		docpos.getInteger().intValue(),
		resource.getInteger(),
		ownercode,
		doc.getInteger(),
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
public DocumentPositionAccessBean constructDocumentPosition(StorageCardAccessBean sc, 
	DocumentAccessBean document, int newDocposition, DocumentPositionAccessBean position, 
	int order, AgregateContentAccessBean agr) throws Exception
{
		if(position != null) position.refreshCopyHelper();

		AfsMountPosAccessBean pos = new AfsMountPosAccessBean( 
			newDocposition, 
			new Integer(sc.getResourceKey().resource), new Integer(sc.getOwnerKey().organization), 
			new Integer(document.getDocument()), 
			order, sc.getQty(), sc.getPrice(), sc.getBoxed(), position.getResultBoxed(), sc.getBroken(), 
			position.getResultBroken(), sc.getClosed(), position.getResultClosed() );
		pos.setIsfictserial(sc.getIsfictserial());
		pos.setParty( sc.getParty() );
		pos.setSerialnumber( sc.getSerialnumber() );
		pos.setConfiguration( sc.getConfiguration() );
		pos.setAgregate( (DocumentPosition)(position.getEJBRef()) );
		pos.setDocQty(sc.getQty());
		pos.commitCopyHelper();
		return new DocumentPositionAccessBean(pos.getEJBRef());
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
	try {
		AfsMountPosAccessBean ab = (AfsMountPosAccessBean)bean;
		setResourcecode(""+ab.getResource().getResource());
		setResourcename(ab.getResource().getName());
		setResourcemodel(ab.getResource().getModel());
		policy = ab.getResource().getCountpolicy();
		fitplace = ab.getNewplace();
		ownercode = new Integer(ab.getOwner().getOrganization());
		comment = ab.getComment();
		if(ab.getIsfictserial()) {
			setFictionSerial(new Boolean(ab.getIsfictserial()));
			setSnumber("");
		} else {
			setFictionSerial(new Boolean(ab.getIsfictserial()));
			setSnumber(ab.getSerialnumber());
		}
	} catch(Exception e) {
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 12:06:09)
 * @return java.lang.String
 */
public java.lang.String getComment() {
	return comment;
}
public java.lang.Integer getComplectcode() {
	return complectcode;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 18:54:19)
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
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
	AfsForm aform = (AfsForm)request.getSession().getAttribute( "AfsForm" );
	doc.setInteger(aform.getDocumentId());
	positioncode = aform.getPositionProperty().getInteger();
	positionname = aform.getPositionname();
	positionid = aform.getPositionid();
	complectcode = aform.getComplectProperty().getInteger();
	complectname = aform.getComplectname();
	expedition = aform.getExpedition();

	AfsMountPosAccessBean bean = new AfsMountPosAccessBean();
	bean.setInitKey_docposition(docpos.getInteger().intValue());
	return bean;
}
public java.lang.Integer getDocId() {
	return doc.getInteger();
}
public java.lang.Integer getDocpos() {
	return docpos.getInteger();
}
public String getDocposstr() {
	return docpos.getString();
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getExpedition() {
	return expedition;
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
public java.lang.String getNewplace() {
	return fitplace;
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
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 18:54:19)
 * @return java.lang.String
 */
public java.lang.String getOwnername() {
	return ownername;
}
public java.lang.String getParty() {
	return party;
}
/**
 * Insert the method's description here.
 * Creation date: (07.08.2002 12:40:13)
 * @return java.lang.String
 */
public java.lang.String getPolicy() {
	return policy;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 18:54:19)
 * @return java.lang.Integer
 */
public java.lang.Integer getPositioncode() {
	return positioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 18:54:19)
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 18:54:19)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
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
public String getResourcesetcode() {
	return resourceset.getString();
}
public java.lang.String getResourcesetname() {
	return resourcesetname;
}
public java.lang.String getSnumber() {
	return serialnumber;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITAFSPOS;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	
	AfsForm form = (AfsForm)request.getSession().getAttribute("AfsForm");
	doc.setInteger(form.getDocumentId());
	positioncode = form.getPositionProperty().getInteger();
	positionname = form.getPositionname();
	positionid = form.getPositionid();
	ownercode = form.getOwnerId();
	ownername = form.getOwnername();
	complectcode = form.getComplectProperty().getInteger();
	complectname = form.getComplectname();
	expedition = form.getExpedition();
	try {
		AfsMountPosAccessBean dp = new AfsMountPosAccessBean();
		dp = dp.findMaxOrderPosition( doc.getInteger() );
		order.setInteger(new Integer(dp.getOrder()+1));
	} catch(Exception e) {
		order.setInteger(new Integer(1));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (24.06.2005 11:28:18)
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
			AfsMountPosAccessBean position = new AfsMountPosAccessBean();
			position.setInitKey_docposition( docPosition.intValue() );
			position.refreshCopyHelper();

			AfsMountPosAccessBeanTable parts = new AfsMountPosAccessBeanTable();
			parts.setAfsMountPosAccessBean( new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(
				position.getAgregateParts(), AfsMountPosAccessBean.class ));

			for( int i = 0; i < parts.numberOfRows(); i++ ) {
				AfsMountPosAccessBean part = parts.getAfsMountPosAccessBean(i);
				part.refreshCopyHelper();		
				part.getEJBRef().remove();
			}
		} catch( Exception e ) {
			throw new java.rmi.RemoteException( "While adding position to document.", e );
		}
	}
/**
 * Insert the method's description here.
 * Creation date: (24.06.2005 11:28:18)
 * @param newBrowseBySerial boolean
 */
public void setBrowseBySerial(boolean newBrowseBySerial) {
	browseBySerial = newBrowseBySerial;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 12:06:09)
 * @param newComment java.lang.String
 */
public void setComment(java.lang.String newComment) {
	comment = newComment;
}
public void setComplectcode(java.lang.Integer newComplectcode) {
	complectcode = newComplectcode;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 18:54:19)
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 14:09:44)
 * @param newConfiguration java.lang.String
 */
public void setConfiguration(java.lang.String newConfiguration) {
	configuration = newConfiguration;
}
public void setDocpos(java.lang.Integer newNumber) {
	docpos.setInteger(newNumber);
}
public void setDocposstr(String newNumber) {
	docpos.setString(newNumber);
}
public void setDocument(String newNumber) {
	System.err.println(">>>set ");
	doc.setString(newNumber);
}
/**
 * 
 * @param newExpedition java.lang.Integer
 */
public void setExpedition(java.lang.Integer newExpedition) {
	expedition = newExpedition;
}
/**
 * 
 * @param newFitplace java.lang.String
 */
public void setFitplace(java.lang.String newFitplace) {
	fitplace = newFitplace;
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
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 18:54:19)
 * @param newOwnername java.lang.String
 */
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
public void setParty(java.lang.String newParty) {
	party = newParty;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 18:54:19)
 * @param newPositioncode java.lang.Integer
 */
public void setPositioncode(java.lang.Integer newPositioncode) {
	positioncode = newPositioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 18:54:19)
 * @param newPositionid java.lang.String
 */
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 18:54:19)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
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
public void setResourcesetcode(String newResource) {
	resourceset.setString(newResource);
}
public void setResourcesetname(java.lang.String newResourcename) {
	resourcesetname = newResourcename;
}
public void setSnumber(java.lang.String newSerialnumber) {
	serialnumber = newSerialnumber;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if (order.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.order"));
	} else if (!order.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.order"));
	}

	boolean fserial = getFictionSerial() != null && getFictionSerial().booleanValue();

	setBrowseBySerial(false);
	if(resource.isEmpty()){
		setResourcemodel("");
		setResourcename("");
	}
	
	if (resource.isEmpty()) {
		// Find resource by serialnumber/party if its empty
		if ( !fserial && serialnumber != null && serialnumber.length() > 0 ) {
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
					price.setBigDecimal(card.getPrice());
					qty.setString("1");
					configuration = card.getConfiguration();
					fitplace = card.getPlace();
					setManufserial(card.getManufserial());
				} catch(Exception e) {
				}
			} else 
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.serialparty"));
		} else if ( (party != null && party.length() > 0) ) {
			// Only party number specified - find resource by party number
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerParty(getExpedition(), getOwnercode(), party);
				resource.setInteger(new Integer(card.getResource().getResource()));
				price.setBigDecimal(card.getPrice());
				configuration = card.getConfiguration();
				setManufserial(card.getManufserial());
			} catch(Exception e) {
			}
		}
	}
	
	if(resource.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.resource"));
		throw new ValidationException();
	} else if(!resource.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.resource"));
		throw new ValidationException();
	}

	/*
	if(configuration != null && configuration.length() > 40) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.configuration"));
	}
	*/

	try {
		ResourceAccessBean bean = constructResource();
		String policy = bean.getCountpolicy();
		if("S".equals(policy)) {
			if (!fserial && (serialnumber == null || "".equals(serialnumber))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.serial"));
			}
			if(qty.getBigDecimal() == null) {
				setQtystr("1");
			}
			if (party != null && !"".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.serialresource"));
			}
			if(!fserial && serialnumber != null && !"".equals(serialnumber)) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(serialnumber);
					/*if( card.getResource().getResource() != resource.getInteger().intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.diffresources"));
					}*/
					price.setBigDecimal(card.getPrice());
					setConfiguration(card.getConfiguration());
					setSourceBoxed(card.getBoxed());
					setSourceBroken(card.getBroken());
					setSourceClosed(card.getClosed());
					setOwnercode(new Integer(card.getOwner().getOrganization()));
					setManufserial(card.getManufserial());
				} catch(Exception e) {
//					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.serial"));
				}
			}
			/*if(DocumentPositionForm.hasSameSerial(serialnumber,doc.getInteger(),docpos.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserial",serialnumber));
			}*/			
			System.err.println("******doc " + doc.getInteger());
			System.err.println("******docpos " + docpos.getInteger());
			if(DocumentPositionForm.hasSameSerialAndResource(serialnumber,resource.getString(),doc.getInteger(),docpos.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserialandresource",resourcemodel,serialnumber));
			}
			if(fitplace == null || "".equals(fitplace.trim())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fitplace"));
			} else {
				fitplace = fitplace.trim();
				if(fitplace.length() > 40) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fitplace"));
				}
			}
		} else if("P".equals(policy)) {
			if(party == null || "".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.party"));
			} else
			if((serialnumber != null && !"".equals(serialnumber)) || fserial) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.partyresource"));
			}
			if((party != null) && !"".equals(party)) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					// !!! Find card by expedition and owner and party !!!
					StorageCardAccessBean card = ab.findByStorageOwnerParty(expedition,ownercode,party);
					if( card.getResource().getResource() != resource.getInteger().intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.diffresources"));
					}
					price.setBigDecimal(card.getPrice());
					setConfiguration(card.getConfiguration());
					setSourceBoxed(card.getBoxed());
					setSourceBroken(card.getBroken());
					setSourceClosed(card.getClosed());
					setOwnercode(new Integer(card.getOwner().getOrganization()));
					setManufserial(card.getManufserial());
				} catch(Exception e) {
//					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.party"));
				}
			}
			if(DocumentPositionForm.hasSameParty(party,ownercode,doc.getInteger(),docpos.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameparty",party));
			}
			setFictionSerial(Boolean.FALSE);
		}
		else if("B".equals(policy)) {
			if((party != null && !"".equals(party)) || (serialnumber != null && !"".equals(serialnumber)) || fserial) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.bulkresource"));
			}
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				// !!! Find card by expedition, owner, and resource
				StorageCardAccessBean card = ab.findByStorageOwnerResource(expedition,ownercode,resource.getInteger());
				price.setBigDecimal(card.getPrice());
				setConfiguration(card.getConfiguration());
				setSourceBoxed(card.getBoxed());
				setSourceBroken(card.getBroken());
				setSourceClosed(card.getClosed());
				setOwnercode(new Integer(card.getOwner().getOrganization()));
				setManufserial(card.getManufserial());
			} catch(Exception e) {
//				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.bulk"));
			}
			if(DocumentPositionForm.hasSameBulk(resource.getInteger(),ownercode,doc.getInteger(),docpos.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassamebulk",resourcename+", "+resourcemodel));
			}
			setFictionSerial(Boolean.FALSE);
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.afspos.resource"));
	}

	if(manufserial != null && manufserial.length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.manufserial"));
	}

	if(!qty.isEmpty()) {
//		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.qty"));
		if (!qty.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.qty"));
		} else if (qty.getBigDecimal().doubleValue() <= 0.0d) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.qtylow"));
		}
	}

	setResultBoxed(getSourceBoxed());
	setResultBroken(getSourceBroken());
	setResultClosed(getSourceClosed());

	if(price.getBigDecimal() == null) {
		price.setString("0.00");
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
