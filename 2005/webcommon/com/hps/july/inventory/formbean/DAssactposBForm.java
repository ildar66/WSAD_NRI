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
 * Форма ввода и редактирования строки документа "Акт демонтажа блоков на позиции"
 */
public class DAssactposBForm
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
	private String snumber;
	private String invnum;
	private String party;
	private StringAndIntegerProperty document;
	private Integer positioncode;
	private Integer complectcode;
	private Integer ownercode;
	private java.lang.String oldagregateserial;

	private Integer storageplace;

	private String fromplace;
	private Boolean fictionSerial = Boolean.FALSE;
	private boolean browseBySerial;
	
public DAssactposBForm() {
	order = new StringAndIntegerProperty();
	docposition = new StringAndIntegerProperty();
	price = new StringAndBigDecimalProperty();
	qty = new StringAndBigDecimalProperty();
	resource = new StringAndIntegerProperty();
	resourcemodel = "";
	resourcename = "";
	document = new StringAndIntegerProperty();
	storageplace = new Integer(0);
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
	
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	DAssactBForm aform = (DAssactBForm)request.getSession().getAttribute("DAssactBForm");
	document.setInteger(aform.getDocumentId());
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	docposition.setInteger(new Integer(keyGen.getNextKey("tables.docpositions")));
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
	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactposb.res_and_place"));
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
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactposb.diffresources"));
		}*/
		price.setBigDecimal(card.getPrice());
//		setConfiguration(card.getConfiguration());
//		setSourceBoxed(card.getBoxed());
//		setSourceBroken(card.getBroken());
//		setSourceClosed(card.getClosed());
		setOwnercode(new Integer(card.getOwner().getOrganization()));
		setFromplace(card.getPlace());
		setManufserial(card.getManufserial());
	} catch(Exception e) {
		price.setString("0.00");
	}
	/*if(DocumentPositionForm.hasSameSerial(sn,document.getInteger(),docposition.getInteger())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserial",sn));
	}*/
	if(DocumentPositionForm.hasSameSerialAndResource(serialnumber,resource.getString(),document.getInteger(),docposition.getInteger())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserialandresource",resourcemodel,serialnumber));
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
public java.lang.Integer getComplectcode() {
	return complectcode;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	DAssactBForm aform = (DAssactBForm)request.getSession().getAttribute( "DAssactBForm" );
	document.setInteger(aform.getDocumentId());
	setOldAgregateSerial(aform.getAgregateserial());
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
public java.lang.String getFromplace() {
	return fromplace;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getInvnum() {
	return invnum;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOldAgregateSerial() {
	return oldagregateserial;
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
/**
 * Insert the method's description here.
 * Creation date: (16.08.2002 10:55:17)
 * @return java.lang.Integer
 */
public java.lang.Integer getPositioncode() {
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
public java.lang.String getSerialnumber() {
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
	return com.hps.july.inventory.APPStates.EDITDASSBP;
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
	DAssactBForm aform = (DAssactBForm)request.getSession().getAttribute("DAssactBForm");
	setComplectcode(aform.getComplectcode());
	setPositioncode(aform.getPositioncode());
	setOwnercode(aform.getOwnercode());
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	super.initRecord(request);
	DAssactBForm aform = (DAssactBForm)request.getSession().getAttribute("DAssactBForm");
	setOldAgregateSerial(aform.getAgregateserial());
	storageplace = aform.getComplectcode();
	document.setInteger(aform.getDocumentId());
	ownercode = aform.getOwnercode();
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
 * Creation date: (24.06.2005 14:36:16)
 * @return int
 */
public boolean isBrowseBySerial() {
	return browseBySerial;
}
/**
 * Insert the method's description here.
 * Creation date: (24.06.2005 14:36:16)
 * @param newBrowseBySerial int
 */
public void setBrowseBySerial(boolean newBrowseBySerial) {
	browseBySerial = newBrowseBySerial;
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2002 10:55:17)
 * @param newComplectcode java.lang.Integer
 */
public void setComplectcode(java.lang.Integer newComplectcode) {
	complectcode = newComplectcode;
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
 * @param newFictionSerial java.lang.Boolean
 */
public void setFictionSerial(java.lang.Boolean newFictionSerial) {
	fictionSerial = newFictionSerial;
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
public void setOldAgregateSerial(java.lang.String newAgregateserial) {
	oldagregateserial = newAgregateserial;
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
 * Creation date: (16.08.2002 10:55:17)
 * @param newPositioncode java.lang.Integer
 */
public void setPositioncode(java.lang.Integer newPositioncode) {
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
 * 
 * @param newSnumber java.lang.String
 */
public void setSnumber(java.lang.String newSnumber) {
	snumber = newSnumber;
}
/**
 * 
 * @param newStorageplace java.lang.Integer
 */
public void setStorageplace(java.lang.Integer newStorageplace) {
	storageplace = newStorageplace;
}

public void validateValues(ActionErrors errors) throws Exception 
{
	//preprocessSerials();
	if (order.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactposb.order"));
	}
	else if (!order.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactposb.order"));
	}
	boolean fserial = getFictionSerial() != null && getFictionSerial().booleanValue();

	setBrowseBySerial(false);
	if(resource.isEmpty()){
		setResourcemodel("");
		setResourcename("");
	}
	
	// Find resource by serialnumber/party if its empty
	if (resource.isEmpty()) {
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
					StorageCardAccessBean card = ab.findBySerial(getInvnum());
					resource.setInteger(new Integer(card.getResource().getResource()));
					qty.setString("1");
					fromplace = card.getPlace();
					setManufserial(card.getManufserial());
					setFictionSerial(new Boolean(card.getIsfictserial()));
					setSerialnumber(card.getSerialnumber());
					setLocalserial(card.getLocalserial());
				} catch(Exception e) { }
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactposb.serialparty"));
			}
		} else if ( (party != null && party.length() > 0) ) {
			// Only party number specified - find resource by party number
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerParty(getComplectcode(), getOwnercode(), party);
				resource.setInteger(new Integer(card.getResource().getResource()));
				setManufserial(card.getManufserial());
			} catch(Exception e) { }
		}
	}
	
	try {
		ResourceAccessBean bean = constructResource();
		String policy = bean.getCountpolicy();
		if("S".equals(policy)) {
			if (!fserial && (getInvnum() == null && getInvnum().length() > 0 )) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactposb.serial"));
			}
			if(qty.getBigDecimal() == null) {
				qty.setString("1");
			}
			if(!qty.isEmpty() && (qty.getBigDecimal().doubleValue() != 1.0d)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactposb.qtylow"));
			}
			if (party != null && !"".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactposb.serialresource"));
			}			
			if(fserial) {
				if(getSerialnumber() != null && !"".equals(getSerialnumber().trim())) {
					// указан фиктивный номер (выбран по лукапу)
					findSCard_Serial(getInvnum(),errors);
					if(getSnumber() != null && !"".equals(getSnumber().trim()) && DocumentPositionForm.hasSameSerial(getSnumber(),document.getInteger(),docposition.getInteger())) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.samenewserial",getSnumber()));
					}
				} else
				if(getInvnum() != null && !"".equals(getInvnum().trim())) {
					// лукапом не выбирали, наверное ввели
					findSCard_Serial(getInvnum(),errors);
				} else {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactposb.res_and_place"));
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
			if(party == null || "".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactposb.party"));
			} else
			if(serialnumber != null && !"".equals(serialnumber)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactposb.partyresource"));
			}
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerParty(getComplectcode(), getOwnercode(), party);
				if( card.getResource().getResource() != resource.getInteger().intValue()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactposb.diffresources"));
				}
				setPrice(card.getPrice());
				setManufserial(card.getManufserial());
			} catch(Exception e) { }
			if(DocumentPositionForm.hasSameParty(party,ownercode,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameparty",party));
			}
		}
		else if("B".equals(policy)) {
			if((party != null && !"".equals(party)) || (serialnumber != null && !"".equals(serialnumber))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactposb.bulkresource"));
			} else {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findByStorageOwnerResource(getComplectcode(), getOwnercode(), resource.getInteger());
					setPrice(card.getPrice());
					setManufserial(card.getManufserial());
				} catch(Exception e) { }
			}
			
			if(DocumentPositionForm.hasSameBulk(resource.getInteger(),ownercode,document.getInteger(),docposition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassamebulk",resourcename+", "+resourcemodel));
			}
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.dassactposb.resource"));
	}
	
	if(getManufserial() != null && getManufserial().length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.manufserial"));
	}

	if (qty.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.dassactposb.qty"));
	} else if (!qty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.dassactposb.qty"));
	}

	if (price.isEmpty())
		price.setString("0");

	if (!errors.empty())
		throw new ValidationException();
}
}
