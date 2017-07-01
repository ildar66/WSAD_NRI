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
 * Форма ввода и редактировани строк документа "Акт демонтажа на позиции"
 */
public class DemountItem extends DocumentPositionForm {
	private StringAndIntegerProperty docpos;
	
	private StringAndIntegerProperty order;
	
	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;
	
	private String configuration;

	private StringAndBigDecimalProperty qty;
	
	private StringAndBigDecimalProperty price;
	
	private String serialnumber;
	private String invnum;
	private String snumber;
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

	private String fromplace;
	private Boolean is_fs;
	private boolean browseBySerial;
public DemountItem() {
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
			addPosition2Document(docpos.getInteger());
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	if("Add".equals(getAction()) && (resourceset.getInteger() != null)) {
		// get resourceset parts and add create positions for it
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
					DocumentPositionAccessBean posbean = new DocumentPositionAccessBean(
						pos,
						new Integer(res.getResource()),
						ownercode,
						doc.getInteger(),
						partorders++,
						pq,
						new java.math.BigDecimal("0.00"),
						getSourceBoxed(),
						getResultBoxed(),
						getSourceBroken(),
						getResultBroken(),
						getSourceClosed(),
						getResultClosed()
					);
				}
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw new UpdateValidationException("error.internalrpos.complectcreation");
		}
	}
}
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
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	DocumentPositionAccessBean dp = (DocumentPositionAccessBean)bean;
	dp.setIsfictserial(getFictionSerial() != null && getFictionSerial().booleanValue());

	if(dp.getIsfictserial()) {
		dp.setSerialnumber(getSerialnumber());
		if(getSnumber() != null && !"".equals(getSnumber().trim())) {
			dp.setRealserial(getSnumber());
		} else {
			dp.setRealserial(null);
		}
	} else {
		if(getSerialnumber() != null && !"".equals(getSerialnumber().trim())) {
			dp.setSerialnumber(getSerialnumber());
		} else {
			dp.setSerialnumber(getInvnum());
		}
		dp.setRealserial(null);
	}
	
	try {
		if ("Edit".equals(getAction())) {
			removePositionFromDocument(docpos.getInteger());
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.internalrpos.removeagregates");
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	Demount aform = (Demount)request.getSession().getAttribute( "Demount" );
	doc.setInteger(new Integer(aform.getDoc()));
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	docpos.setInteger(new Integer(keyGen.getNextKey("tables.docpositions")));
//	ownercode = aform.getOwner();
	DocumentPositionAccessBean bean = new DocumentPositionAccessBean(
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
public ResourceAccessBean constructResource() throws java.lang.Exception {
	ResourceAccessBean bean = new ResourceAccessBean();
	bean.setInitKey_resource(resource.getInteger().intValue());
	bean.refreshCopyHelper();
	resourcemodel = bean.getModel();
	resourcename = bean.getName();
	return bean;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	try {
		DocumentPositionAccessBean ab = (DocumentPositionAccessBean)bean;
		setResourcecode(""+ab.getResource().getResource());
		setResourcename(ab.getResource().getName());
		setResourcemodel(ab.getResource().getModel());
		policy = ab.getResource().getCountpolicy();
		fromplace = ab.getOldplace();
		ownercode = new Integer(ab.getOwner().getOrganization());
		setFictionSerial(new Boolean(ab.getIsfictserial()));
		if(ab.getIsfictserial()) {
			setInvnum("с/н неизвестен");
			setSerialnumber(ab.getSerialnumber());
			setSnumber(ab.getRealserial());
			if(getSnumber() == null) { setSnumber(""); }
		} else {
			setInvnum(ab.getSerialnumber());
			setSerialnumber(ab.getSerialnumber());
			setSnumber("");
		}
	} catch(Exception e) {
	}
}
public void findSCard_RnP(Integer res, String place, ActionErrors errors) {
	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.res_and_place"));
/*
	try {
		StorageCardAccessBean ab = new StorageCardAccessBean();
		StorageCardAccessBean card = ab.findBySerial(sn);
		if(card.getResource().getResource() != resource.getInteger().intValue()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.diffresources"));
		}
		price.setBigDecimal(card.getPrice());
		setConfiguration(card.getConfiguration());
		setSourceBoxed(card.getBoxed());
		setSourceBroken(card.getBroken());
		setSourceClosed(card.getClosed());
		setOwnercode(new Integer(card.getOwner().getOrganization()));
		setFromplace(card.getPlace());
		setManufserial(card.getManufserial());
	} catch(Exception e) {
		price.setString("0.00");
	}
*/
}
public void findSCard_Serial(String sn, ActionErrors errors) {
	try {
		StorageCardAccessBean ab = new StorageCardAccessBean();
		StorageCardAccessBean card = ab.findBySerial(sn);
		/*if(card.getResource().getResource() != resource.getInteger().intValue()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.diffresources"));
		}*/
		price.setBigDecimal(card.getPrice());
		setConfiguration(card.getConfiguration());
		setSourceBoxed(card.getBoxed());
		setSourceBroken(card.getBroken());
		setSourceClosed(card.getClosed());
		setOwnercode(new Integer(card.getOwner().getOrganization()));
		setFromplace(card.getPlace());
		setManufserial(card.getManufserial());
	} catch(Exception e) {
		price.setString("0.00");
	}
	/*if(DocumentPositionForm.hasSameSerial(sn,doc.getInteger(),docpos.getInteger())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserial",sn));
	}*/
	if(DocumentPositionForm.hasSameSerialAndResource(serialnumber,resource.getString(),doc.getInteger(),docpos.getInteger())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserialandresource",resourcemodel,serialnumber));
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
public Integer getComplectcode() {
	return complectcode;
}
public String getComplectname() {
	return complectname;
}
public String getConfiguration() {
	return configuration;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	Demount aform = (Demount)request.getSession().getAttribute( "Demount" );
	doc.setInteger(new Integer(aform.getDoc()));
	positioncode = aform.getPosition();
	positionname = aform.getPositionname();
	positionid = aform.getPositionid();
	complectcode = aform.getComplect();
	complectname = aform.getComplectname();

	DocumentPositionAccessBean bean = new DocumentPositionAccessBean();
	bean.setInitKey_docposition(docpos.getInteger().intValue());
	return bean;
}
public Integer getDocpos() {
	return docpos.getInteger();
}
public String getDocposstr() {
	return docpos.getString();
}
public String getFromplace() {
	return fromplace;
}
public String getInvnum() {
	return invnum;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIs_fs() {
	return is_fs;
}
public String getManufserial() {
	return manufserial;
}
public String getOldplace() {
	return fromplace;
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
public String getOwnername() {
	return ownername;
}
public String getParty() {
	return party;
}
public String getPolicy() {
	return policy;
}
public Integer getPositioncode() {
	return positioncode;
}
public String getPositionid() {
	return positionid;
}
public String getPositionname() {
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
public String getResourcename() {
	return resourcename;
}
public String getResourcesetcode() {
	return resourceset.getString();
}
public String getResourcesetname() {
	return resourcesetname;
}
public String getSerialnumber() {
	return serialnumber;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSnumber() {
	return snumber;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITDIPP;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	super.initRecord(request);
	Demount form = (Demount)request.getSession().getAttribute("Demount");
	doc.setInteger(new Integer(form.getDoc()));
	positioncode = form.getPosition();
	positionname = form.getPositionname();
	positionid = form.getPositionid();
	ownercode = form.getOwnerKey();
	ownername = form.getOwnername();
	complectcode = form.getComplect();
	complectname = form.getComplectname();
	setFictionSerial(Boolean.FALSE);
	try {
		DocumentPositionAccessBean dp = new DocumentPositionAccessBean();
		dp = dp.findMaxOrderPosition( doc.getInteger() );
		order.setInteger(new Integer(dp.getOrder()+1));
	} catch(Exception e) {
		order.setInteger(new Integer(1));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (24.06.2005 13:40:39)
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
 * Creation date: (24.06.2005 13:40:39)
 * @param newBrowseBySerial boolean
 */
public void setBrowseBySerial(boolean newBrowseBySerial) {
	browseBySerial = newBrowseBySerial;
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
	doc.setString(newNumber);
}
/**
 * 
 * @param newFromplace java.lang.String
 */
public void setFromplace(java.lang.String newFromplace) {
	fromplace = newFromplace;
}
/**
 * 
 * @param newInvnum java.lang.String
 */
public void setInvnum(java.lang.String newInvnum) {
	invnum = newInvnum;
}
/**
 * 
 * @param newIs_fs java.lang.Boolean
 */
public void setIs_fs(java.lang.Boolean newIs_fs) {
	is_fs = newIs_fs;
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
public void setSerialnumber(java.lang.String newSerialnumber) {
	serialnumber = newSerialnumber;
}
/**
 * 
 * @param newSnumber java.lang.String
 */
public void setSnumber(java.lang.String newSnumber) {
	snumber = newSnumber;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	preprocessSerials();
//	System.out.println("SERIAL: "+getSerialnumber()+" INVNUM: "+getInvnum());
	
	if (order.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingppos.order"));
	} else if (!order.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.order"));
	}

	boolean fserial = getFictionSerial() != null && getFictionSerial().booleanValue();

	setBrowseBySerial(false);
	if(resource.isEmpty()){
		setResourcemodel("");
		setResourcename("");
	}
	
	// Поиск по серийному номеру.
	// Скоро придётся требовать ресурс!!!
	if (resource.isEmpty()) {
		// Find resource by serialnumber/party if its empty
		if (!fserial && (getInvnum() != null && getInvnum().length() > 0 )) {
			if(party == null || "".equals(party)) {

				Connection conn = null;
				int result = 0;

				try {
					
					conn = new JdbcConnection().getConnection();
					result = CDBCStoragecardsObject.findBySerialM(conn,getInvnum());
					
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
					StorageCardAccessBean card = ab.findBySerialResource(getInvnum(), resource.getInteger());
					resource.setInteger(new Integer(card.getResource().getResource()));
					price.setBigDecimal(card.getPrice());
					qty.setString("1");
					configuration = card.getConfiguration();
					fromplace = card.getPlace();
					setManufserial(card.getManufserial());
					setFictionSerial(new Boolean(card.getIsfictserial()));
					setSerialnumber(card.getSerialnumber());
				} catch(Exception e) {
				}
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.serialparty"));
			}
		} else if ( (party != null && party.length() > 0) ) {
			// Only party number specified - find resource by party number
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerParty(getComplectcode(), getOwnercode(), party);
				resource.setInteger(new Integer(card.getResource().getResource()));
				price.setBigDecimal(card.getPrice());
				configuration = card.getConfiguration();
				setManufserial(card.getManufserial());
			} catch(Exception e) {
			}
		}
	}
	
	if(resource.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingppos.resource"));
	} else if(!resource.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.resource"));
	}
/*
	if(configuration != null && configuration.length() > 40) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.configuration"));
	}
*/
	if(manufserial != null && manufserial.length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.manufserial"));
	}
	
	if (!errors.empty())
		throw new ValidationException();

	try {
		ResourceAccessBean bean = constructResource();
		policy = bean.getCountpolicy();
		if("S".equals(policy)) {
			if (!fserial && (getInvnum() == null || "".equals(getInvnum()))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingppos.serial"));
			}
			if(qty.getBigDecimal() == null) {
				qty.setString("1");
			}
			if(qty.getBigDecimal().doubleValue() != 1.0d) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.qtybig"));
			}
			if(party != null && !"".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.serialresource"));
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
			if(DocumentPositionForm.hasSameSerialAndResource(serialnumber,resource.getString(),doc.getInteger(),docpos.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserialandresource",resourcemodel,serialnumber));
			}
			if(fserial) {
				if(getSerialnumber() != null && !"".equals(getSerialnumber().trim())) {
					// указан фиктивный номер (выбран по лукапу)
					findSCard_Serial(getSerialnumber(),errors);
					if(getSnumber() != null && !"".equals(getSnumber().trim()) && DocumentPositionForm.hasSameSerial(getSnumber(),doc.getInteger(),docpos.getInteger())) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.samenewserial",getSnumber()));
					}
				} else
				if(getInvnum() != null && !"".equals(getInvnum().trim())) {
					// лукапом не выбирали, наверное ввели
					findSCard_Serial(getInvnum(),errors);
				} else {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.res_and_place"));
				}
			} else {
				// Выбран нормальный серийник
				if(getSerialnumber() != null && getSerialnumber().trim().length() > 0) {
					// введён новый серийный номер (или просто "с/н неизвестен" сняли)
					findSCard_Serial(getSerialnumber(),errors);
				} else {
					// введён серийный номер по которому надо найти карточку
					findSCard_Serial(getInvnum(),errors);
				}
			}
			if(price.getBigDecimal() == null) {
				price.setString("0.00");
			}
		}
		else if("P".equals(policy)) {
			if(qty.isEmpty()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingppos.qty"));
			} else if (!qty.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.qty"));
			} else if (qty.getBigDecimal().doubleValue() <= 0.0d) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.qtylow"));
			}

			if(party == null || "".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingppos.party"));
			} else
			if(serialnumber != null && !"".equals(serialnumber)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.partyresource"));
			}
			if((party != null) && !"".equals(party)) {
				setFictionSerial(Boolean.FALSE);
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findByStorageOwnerParty(complectcode,ownercode,party);
					if( card.getResource().getResource() != resource.getInteger().intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.diffresources"));
					}
					price.setBigDecimal(card.getPrice());
					setConfiguration(card.getConfiguration());
					setSourceBoxed(card.getBoxed());
					setSourceBroken(card.getBroken());
					setSourceClosed(card.getClosed());
					setOwnercode(new Integer(card.getOwner().getOrganization()));
					setManufserial(card.getManufserial());
				} catch(Exception e) {
//					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.party"));
					price.setString("0.00");
				}
			}
			if(DocumentPositionForm.hasSameParty(party,ownercode,doc.getInteger(),docpos.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameparty",party));
			}
			if(price.getBigDecimal() == null) {
				price.setString("0.00");
			}
		}
		else if("B".equals(policy)) {
			if(qty.isEmpty()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingppos.qty"));
			} else if (!qty.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.qty"));
			} else if (qty.getBigDecimal().doubleValue() <= 0.0d) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.qtylow"));
			}

			setFictionSerial(Boolean.FALSE);
			if((party != null && !"".equals(party)) || (serialnumber != null && !"".equals(serialnumber))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.bulkresource"));
			}
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerResource(complectcode,ownercode,resource.getInteger());
				price.setBigDecimal(card.getPrice());
				setConfiguration(card.getConfiguration());
				setSourceBoxed(card.getBoxed());
				setSourceBroken(card.getBroken());
				setSourceClosed(card.getClosed());
				setOwnercode(new Integer(card.getOwner().getOrganization()));
				setManufserial(card.getManufserial());
			} catch(Exception e) {
//				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.bulk"));
				price.setString("0.00");
			}
			if(DocumentPositionForm.hasSameBulk(resource.getInteger(),ownercode,doc.getInteger(),docpos.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassamebulk",resourcename+", "+resourcemodel));
			}
			if(price.getBigDecimal() == null) {
				price.setString("0.00");
			}
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.dismantlingppos.resource"));
	}

	/*
	if(price.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dismantlingppos.price"));
	} else if (!price.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.price"));
	} else if (price.getBigDecimal().doubleValue() <= 0.0d) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dismantlingppos.pricelow"));
	}
	*/
	
	setResultBoxed(getSourceBoxed());
	setResultBroken(getSourceBroken());
	setResultClosed(getSourceClosed());

	if (!errors.empty())
		throw new ValidationException();
}
}
