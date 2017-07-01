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
 * Форма ввода и редактирования строки документа "Внешний приходный ордер"
 */
public class ExternalPositionForm
	 extends DocumentPositionForm 
{
	private StringAndIntegerProperty outerDocPosition;
	private StringAndIntegerProperty order;
	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;
	private String configuration;
	private Boolean boxed;
	private String mark;
	private StringAndBigDecimalProperty qty;
	private StringAndBigDecimalProperty price;
	private StringAndBigDecimalProperty outerQty;
	private StringAndBigDecimalProperty outerPrice;
	private String serialnumber;
	private String manufserial;
	private String party;
	private StringAndIntegerProperty document;
	private Integer storagecode;
	private Integer ownercode;

	private boolean serialresource = false;
	private boolean manySerial;
	private String policy;
	private boolean browseBySerial;
public ExternalPositionForm() {
	boxed = Boolean.FALSE;
	configuration = "";
	mark = "";
	order = new StringAndIntegerProperty();
	outerDocPosition = new StringAndIntegerProperty();
	outerPrice = new StringAndBigDecimalProperty();
	outerQty = new StringAndBigDecimalProperty();
	price = new StringAndBigDecimalProperty();
	qty = new StringAndBigDecimalProperty();
	resource = new StringAndIntegerProperty();
	resourcemodel = "";
	resourcename = "";
	document = new StringAndIntegerProperty();
	manySerial = false;
	policy = "-";
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	super.afterUpdate(bean,request);
/*
	System.out.println("@#@ EPF: outerPrice:"+outerPrice.getBigDecimal());
	System.out.println("@#@ EPF: outerQty:"+outerQty.getBigDecimal());
	System.out.println("@#@ EPF: Price:"+price.getBigDecimal());
	System.out.println("@#@ EPF: Qty:"+qty.getBigDecimal());
*/
	// Create a number of inwaybillpositions
	if("Add".equals(getAction())) {
		InWayBillPositionAccessBean pos;
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		ExternalForm aform = (ExternalForm)request.getSession().getAttribute( "ExternalForm" );
		try {
			int count;
			if(serialresource) {
				count = qty.getBigDecimal().intValue();
			} else {
				count = 1;
			}
			
			for(int i=0; i < count; i++) {
//System.out.println("@#@ EPF: Create position ["+i+"]:");
				pos = new InWayBillPositionAccessBean(
					keyGen.getNextKey("tables.docpositions"),
					resource.getInteger(),
					aform.getOwnerKey(),
					aform.getDocumentId(),
					order.getInteger().intValue(),
					(serialresource)?new java.math.BigDecimal(1.0d):qty.getBigDecimal(),
					new java.math.BigDecimal(0.0d),
					Boolean.FALSE,
					getBoxed(),
					Boolean.FALSE,
					Boolean.FALSE,
					Boolean.FALSE,
					Boolean.FALSE,
					outerDocPosition.getInteger(),
					(price.isEmpty())?new java.math.BigDecimal(0.0d):price.getBigDecimal()
				);
				if(i == 0 && serialresource) {
					pos.setSerialnumber(serialnumber);
					pos.setManufserial(manufserial);
				} else {
					if(party != null) pos.setParty(getParty());
				}
				pos.setConfiguration(getConfiguration());
				pos.setNotes(getNote());
				pos.commitCopyHelper();
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	} else
	if("Edit".equals(getAction())) {
		OuterDocPositionAccessBean abean = (OuterDocPositionAccessBean)bean;
//System.out.println("@#@ EPF: Update , serial:"+serialresource);
		if(serialresource) {
			if(!price.isEmpty()) {
				try {
					InWayBillProcessorAccessBean proc = new InWayBillProcessorAccessBean();
					proc.changeOuterDocPositionPrice(new Integer(abean.getOuterDocPosition()),price.getBigDecimal());
				} catch(Exception e) {
					e.printStackTrace(System.out);
				}
			}
			if(order.getInteger() != null) {
				try {
					InWayBillPositionAccessBean posbean = new InWayBillPositionAccessBean();
					Enumeration en = posbean.findInWayBillPositionByOuterDocPosition(new OuterDocPositionKey(outerDocPosition.getInteger().intValue()));
//					System.out.println("EPF: Outerdocposition:"+outerDocPosition.getInteger());
//					System.out.println("EPF: bean:"+abean.getOuterDocPosition());
					while(en.hasMoreElements()) {
						InWayBillPositionAccessBean pos = (InWayBillPositionAccessBean)en.nextElement();
						if(pos.getOrder() != order.getInteger().intValue()) {
							pos.setOrder(order.getInteger().intValue());
						}
						if(getBoxed() != null && getBoxed().booleanValue() && pos.getResultBoxed() != null && pos.getResultBoxed().booleanValue()) {
							pos.setNotes(getNote());
						}
						System.out.println("EPF: Order:"+pos.getOrder());
						pos.commitCopyHelper();
					}
				} catch(Exception e) {
					e.printStackTrace(System.out);
				}
			}
		} else {
			try {
				InWayBillProcessorAccessBean proc = new InWayBillProcessorAccessBean();
				proc.changeOuterDocPositionPrice(new Integer(abean.getOuterDocPosition()),price.getBigDecimal());
			} catch(Exception e) {
				e.printStackTrace(System.out);
			}
			try {
				InWayBillPositionAccessBean posbean = new InWayBillPositionAccessBean();
				Enumeration en = posbean.findInWayBillPositionByOuterDocPosition(new OuterDocPositionKey(abean.getOuterDocPosition()));
				if(en.hasMoreElements()) {
					InWayBillPositionAccessBean pos = (InWayBillPositionAccessBean)en.nextElement();
					if("P".equals(pos.getResource().getCountpolicy())) {
						pos.setParty(this.getParty());
					}
					if(order.getInteger() != null) {
						pos.setOrder(order.getInteger().intValue());
					}
					pos.setQty(qty.getBigDecimal());
					pos.commitCopyHelper();
				}
			} catch(Exception e) {
				e.printStackTrace(System.out);
			}
		}
	}
}
public void beforeDelete(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws java.lang.Exception
{
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	ExternalForm aform = (ExternalForm)request.getSession().getAttribute( "ExternalForm" );
	document.setInteger(aform.getDocumentId());
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	outerDocPosition.setInteger(new Integer(keyGen.getNextKey("tables.outerdocpositions")));
	OuterDocPositionAccessBean bean = new OuterDocPositionAccessBean(
		outerDocPosition.getInteger().intValue(),
		resource.getInteger(),
		document.getInteger()
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
		OuterDocPositionAccessBean ab = (OuterDocPositionAccessBean)bean;
		InWayBillPositionAccessBean b;
		setResourcecode(""+ab.getResource().getResource());
		setResourcename(ab.getResource().getName());
		setResourcemodel(ab.getResource().getModel());
		policy = ab.getResource().getCountpolicy();
		setConfiguration(ab.getConfiguration());
		OuterDocPositionValue value = new OuterDocPositionValue(
			ab,	1, new java.math.BigDecimal(0.0d), new java.math.BigDecimal(0.0d)
		);
		b = new InWayBillPositionAccessBean();
		Enumeration en = b.findInWayBillPositionByOuterDocPosition(new OuterDocPositionKey(ab.getOuterDocPosition()));
		serialnumber = "";
		boolean bx = true;
		while(en.hasMoreElements()) {
			InWayBillPositionAccessBean pos = (InWayBillPositionAccessBean)en.nextElement();
			value.add(pos.getQty(),pos.getSourcePrice());
			//serialnumber += pos.getSerialnumber();
			setParty(pos.getParty());
			ownercode = new Integer(pos.getOwner().getOrganization());
			if(pos.getSourceBoxed() != null) {
				bx &= pos.getResultBoxed().booleanValue();
			}
		}
		setBoxed(new Boolean(bx));
		setQty(value.getQty());
		setSourcePrice(value.getPrice());
	} catch(Exception e) {
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
public java.lang.Boolean getBoxed() {
	return boxed;
}
public java.lang.String getConfiguration() {
	return configuration;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ExternalForm aform = (ExternalForm)request.getSession().getAttribute( "ExternalForm" );
	document.setInteger(aform.getDocumentId());
	storagecode = aform.getStorageKey();
	OuterDocPositionAccessBean bean = new OuterDocPositionAccessBean();
	bean.setInitKey_outerDocPosition(outerDocPosition.getInteger().intValue());
	return bean;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManufserial() {
	return manufserial;
}
public String getNote() {
	return mark;
}
public int getOrder() {
	return (!order.isEmpty() && order.isOk())?order.getInteger().intValue():0;
}
public String getOrderstr() {
	return order.getString();
}
public Integer getOuterDocPosition() {
	return outerDocPosition.getInteger();
}
public String getOuterDocPositionstr() {
	return outerDocPosition.getString();
}
public java.math.BigDecimal getOuterPrice() {
	return outerPrice.getBigDecimal();
}
public String getOuterPricestr() {
	return outerPrice.getString();
}
public java.math.BigDecimal getOuterQty() {
	return outerQty.getBigDecimal();
}
public String getOuterQtystr() {
	return outerQty.getString();
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
public String getSourcePricestr() {
	return price.getString();
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITEOP;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 15:31:12)
 * @return java.lang.Integer
 */
public java.lang.Integer getStoragecode() {
	return storagecode;
}
public static boolean hasSameBulk(Integer resource, Integer owner, Integer document, Integer docposition) {
	try {
		Integer docpos = null;
		
		if(docposition != null) {
			InWayBillPositionAccessBean iwp = new InWayBillPositionAccessBean();
			Enumeration en = iwp.findInWayBillPositionByOuterDocPosition(new OuterDocPositionKey(docposition.intValue()));
			if(en.hasMoreElements()) {
				InWayBillPositionAccessBean iwpp = (InWayBillPositionAccessBean)en.nextElement();
				docpos = new Integer(iwpp.getDocposition());
			}
		}
		
		DocumentPositionAccessBean df = new DocumentPositionAccessBean();
		Enumeration en = df.findByDocumentQBE2(
			document, "B", "",
    		Boolean.TRUE, owner,
			Boolean.TRUE, resource,
			new Integer(1)
		);
		while(en.hasMoreElements()) {
			DocumentPositionAccessBean d = (DocumentPositionAccessBean)en.nextElement();
			if(docpos != null && d.getDocposition() != docpos.intValue()) {
				return true;
			}
		}
		return false;
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return false;
	}
}
public static boolean hasSameParty(String partynumber, Integer owner, Integer document, Integer docposition) {
	try {
		Integer docpos = null;
		
		if(docposition != null) {
			InWayBillPositionAccessBean iwp = new InWayBillPositionAccessBean();
			Enumeration en = iwp.findInWayBillPositionByOuterDocPosition(new OuterDocPositionKey(docposition.intValue()));
			if(en.hasMoreElements()) {
				InWayBillPositionAccessBean iwpp = (InWayBillPositionAccessBean)en.nextElement();
				docpos = new Integer(iwpp.getDocposition());
			}
		}
		
		DocumentPositionAccessBean df = new DocumentPositionAccessBean();
		Enumeration en = df.findByDocumentQBE2(
			document,
    		"P", partynumber,
    		Boolean.TRUE, owner,
			Boolean.FALSE, new Integer(0),
			new Integer(1)
		);
		while(en.hasMoreElements()) {
			DocumentPositionAccessBean d = (DocumentPositionAccessBean)en.nextElement();
			if(docpos != null && d.getDocposition() != docpos.intValue()) {
				return true;
			}
		}
		return false;
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return false;
	}
}
public static boolean hasSameSerial(String serialnumber, Integer document, Integer docposition) {
	try {
		Integer docpos = null;
		
		if(docposition != null) {
			InWayBillPositionAccessBean iwp = new InWayBillPositionAccessBean();
			Enumeration en = iwp.findInWayBillPositionByOuterDocPosition(new OuterDocPositionKey(docposition.intValue()));
			if(en.hasMoreElements()) {
				InWayBillPositionAccessBean iwpp = (InWayBillPositionAccessBean)en.nextElement();
				docpos = new Integer(iwpp.getDocposition());
			}
		}
		//System.out.println("EPF.hasSameSerial: document="+document);
		//System.out.println("EPF.hasSameSerial: serialnumber="+serialnumber);
		DocumentPositionAccessBean df = new DocumentPositionAccessBean();
		Enumeration en = df.findByDocumentQBE2(
			document,
    		"S", serialnumber,
    		Boolean.FALSE, new Integer(0),
			Boolean.FALSE, new Integer(0),
			new Integer(1)
		);
		while(en.hasMoreElements()) {
			DocumentPositionAccessBean d = (DocumentPositionAccessBean)en.nextElement();
			if(docpos != null && d.getDocposition() != docpos.intValue()) {
				return true;
			}
		}
		return false;
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return false;
	}
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	ExternalForm aform = (ExternalForm)request.getSession().getAttribute( "ExternalForm" );
	storagecode = aform.getStorageKey();
	ownercode = aform.getOwnerKey();
	document.setInteger(aform.getDocumentId());
	try {
		OuterDocPositionAccessBean dp = new OuterDocPositionAccessBean();
		dp = dp.findMaxOrderPosition( document.getInteger() );
		order.setInteger(new Integer(dp.getOrder()+1));
	} catch(Exception e) {
		order.setInteger(new Integer(1));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 17:36:33)
 * @return boolean
 */
public boolean isBrowseBySerial() {
	return browseBySerial;
}
/**
 * Insert the method's description here.
 * Creation date: (29.06.2002 11:40:16)
 * @return boolean
 */
public boolean isManySerial() {
	return manySerial;
}
public void setBoxed(java.lang.Boolean newBoxed) {
	boxed = newBoxed;
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 17:36:33)
 * @param newBrowseBySerial boolean
 */
public void setBrowseBySerial(boolean newBrowseBySerial) {
	browseBySerial = newBrowseBySerial;
}
public void setConfiguration(java.lang.String newConfiguration) {
	configuration = newConfiguration;
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
/**
 * Insert the method's description here.
 * Creation date: (29.06.2002 11:40:16)
 * @param newManySerial boolean
 */
public void setManySerial(boolean newManySerial) {
	manySerial = newManySerial;
}
public void setNote(java.lang.String newNote) {
	mark = newNote;
}
public void setOrder(int newOrder) {
	order.setInteger(new Integer(newOrder));
}
public void setOrderstr(String newOrder) {
	order.setString(newOrder);
}
public void setOuterDocPosition(Integer newDocPosition) {
	outerDocPosition.setInteger(newDocPosition);
}
public void setOuterDocPositionstr(String newNumber) {
	outerDocPosition.setString(newNumber);
}
public void setOuterPrice(java.math.BigDecimal newPrice) {
	outerPrice.setBigDecimal(newPrice);
}
public void setOuterPricestr(String newPrice) {
	outerPrice.setString(newPrice);
}
public void setOuterQty(java.math.BigDecimal newQty) {
	outerQty.setBigDecimal(newQty);
}
public void setOuterQtystr(String newQty) {
	outerQty.setString(newQty);
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
public void setSourcePrice(java.math.BigDecimal newPrice) {
	price.setBigDecimal(newPrice);
}
public void setSourcePricestr(String newPrice) {
	price.setString(newPrice);
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
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalpos.order"));
	}
	else if (!order.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.order"));
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
					StorageCardAccessBean card = ab.findBySerial(serialnumber);
					resource.setInteger(new Integer(card.getResource().getResource()));
					setOwnercode(new Integer(card.getOwner().getOrganization()));
					price.setBigDecimal(card.getPrice());
					setConfiguration(card.getConfiguration());
					setSourceBroken(card.getBroken());
					setSourceBoxed(card.getBoxed());
					setSourceClosed(card.getClosed());
					setManufserial(card.getManufserial());
					setResourcemodel(card.getResource().getModel());
					setResourcename(card.getResource().getName());
					qty.setString("1");
				} catch(Exception e) {
				}
			} else 
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalpos.serialparty"));
		} /*else if ( (party != null && party.length() > 0) ) {
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
		}*/
	
		
		//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalpos.resource"));
	} else if(!resource.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.resource"));
	} else {
		try {
			ResourceAccessBean r = constructResource();
			resourcemodel = r.getModel();
			resourcename = r.getName();
			if(!r.getPriceable().booleanValue() && price.isEmpty()) {
				price.setString("0.0");
			}
			policy = r.getCountpolicy();
		} catch(Exception e) {
		}
	}
	
	if (outerQty.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalpos.outerqty"));
	} else if (!outerQty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.outerqty"));
	}

	if (!outerPrice.isEmpty()) {
		if(!outerPrice.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.outerprice"));
		}
		else if((outerPrice.getBigDecimal() != null) && (outerPrice.getBigDecimal().doubleValue() < 0.0d)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.outerpricelow"));
		}
	}

	if (qty.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalpos.qty"));
	} else if (!qty.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.qty"));
	}
	
	if (!price.isEmpty()) {
		if(!price.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.price"));
		}
		else if(price.getBigDecimal().doubleValue() < 0.0d) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.pricelow"));
		}
	}
	
	if(configuration != null && configuration.length() > 40) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.configuration"));
	}
	
	if((mark != null) && (mark.length() > 40)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.mark"));
	}

	if(manufserial != null && manufserial.length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.manufserial"));
	}

	if (!errors.empty())
		throw new ValidationException();

	try {
		ResourceAccessBean bean = constructResource();
		String policy = bean.getCountpolicy();
		if("S".equals(policy)) {
			serialresource = true;
			if(Boolean.FALSE.equals(getBoxed())) {
				if(!"Edit".equals(getAction())) {
					if ( (serialnumber == null || "".equals(serialnumber)) && (qty.getBigDecimal().doubleValue() == 1.0d)) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalpos.serial"));
					}
				}
			} else {
				if(mark == null || "".equals(mark)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalpos.mark"));
				}
			}
			if (party != null && !"".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.serialresource"));
			}
			double q = qty.getBigDecimal().doubleValue();
			if(q < 0.0d) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.qtylow"));
			}
			if(Math.rint(q) != q) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.qtyint"));
			}
			if(q > 1000.0d) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.qtytoomany"));
			}
			if(q > 1.0d) {
				setManySerial(true);
			}
			if((serialnumber != null) && !"".equals(serialnumber)) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(serialnumber);
					/*if( card.getResource().getResource() != resource.getInteger().intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.diffresources"));
					}*/
					setOwnercode(new Integer(card.getOwner().getOrganization()));
					if(manufserial == null || "".equals(manufserial.trim())) {
						setManufserial(card.getManufserial());
					}
				} catch(Exception e) { }
			}
			/*if(hasSameSerial(serialnumber,document.getInteger(),outerDocPosition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserial",serialnumber));
			}*/
			if(DocumentPositionForm.hasSameSerialAndResource(serialnumber,resource.getString(),document.getInteger(),outerDocPosition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserialandresource",resourcemodel,serialnumber));
			}
			/*
			if (Boolean.FALSE.equals(bean.getBoxable())) {
			} else if(Boolean.TRUE.equals(bean.getBoxable())) {
			}
			if (qty.getBigDecimal().scale() != 0) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.qtyint"));
			}
			if (outerQty.getBigDecimal().scale() != 0) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.outerqtyint"));
			}
			*/
		}
		else if("P".equals(policy)) {
			serialresource = false;
			if(party == null || "".equals(party)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalpos.party"));
			} else
			if(serialnumber != null && !"".equals(serialnumber)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.partyresource"));
			}
			if(Boolean.TRUE.equals(getBoxed())) {
				if(mark == null || "".equals(mark)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalpos.mark"));
				}
			}
			/*
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findByStorageOwnerParty(serialnumber);
				if( card.getResource().getResource() != resource.getInteger().intValue()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.diffresources"));
				}
			} catch(Exception e) { }
			*/
			if(hasSameParty(party,ownercode,document.getInteger(),outerDocPosition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameparty",party));
			}
		}
		else if("B".equals(policy)) {
			serialresource = false;
			if((party != null && !"".equals(party)) || (serialnumber != null && !"".equals(serialnumber))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalpos.bulkresource"));
			}
			if(Boolean.TRUE.equals(getBoxed())) {
				if(mark == null || "".equals(mark)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalpos.mark"));
				}
			}
			if(hasSameBulk(resource.getInteger(),ownercode,document.getInteger(),outerDocPosition.getInteger())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassamebulk",resourcename+", "+resourcemodel));
			}
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.externalpos.resource"));
	}

	if(outerPrice.getBigDecimal() == null) {
		outerPrice.setString("0.00");
	}
	
	if(qty.getBigDecimal() != null) {
		qty.setBigDecimal(qty.getBigDecimal().setScale(3,qty.getBigDecimal().ROUND_HALF_UP));
	}
	if(price.getBigDecimal() != null) {
		price.setBigDecimal(price.getBigDecimal().setScale(2,price.getBigDecimal().ROUND_HALF_UP));
	}
	if(outerQty.getBigDecimal() != null) {
		outerQty.setBigDecimal(outerQty.getBigDecimal().setScale(3,outerQty.getBigDecimal().ROUND_HALF_UP));
	}
	if(outerPrice.getBigDecimal() != null) {
		outerPrice.setBigDecimal(outerPrice.getBigDecimal().setScale(2,outerPrice.getBigDecimal().ROUND_HALF_UP));
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
