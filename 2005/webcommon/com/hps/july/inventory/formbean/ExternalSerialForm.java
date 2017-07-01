package com.hps.july.inventory.formbean;

import com.hps.july.inventory.sessionbean.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма ввода и редактирования серийного номера для строк 
 * документа "Внешний приходный ордер" с серийным учётом оборудования
 */
public class ExternalSerialForm extends com.hps.july.web.util.EditForm {
	private StringAndIntegerProperty outerDocPosition;
	private StringAndIntegerProperty order;
	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;
	private String configuration;
	private Boolean boxed;
	private String note;
	private StringAndBigDecimalProperty qty;
	private StringAndBigDecimalProperty price;
	private StringAndBigDecimalProperty sum;
	private String serialnumber;
	private String manufserial;
	private StringAndIntegerProperty docposition;

	private String oldManufserial;
	private String oldSerial;

	private boolean serialresource = false;
	private String docState;
public ExternalSerialForm() {
	outerDocPosition = new StringAndIntegerProperty();
	order = new StringAndIntegerProperty();
	resource = new StringAndIntegerProperty();
	resourcename = null;
	resourcemodel = null;
	configuration = null;
	boxed = Boolean.FALSE;
	note = null;
	qty = new StringAndBigDecimalProperty();
	price = new StringAndBigDecimalProperty();
	sum = new StringAndBigDecimalProperty();
	serialnumber = null;
	docposition = new StringAndIntegerProperty();
	docState = null;
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	if("Edit".equals(getAction()) && (serialnumber != null) && !boxed.booleanValue()) {
		// Check if document already processed
		InWayBillPositionAccessBean dbean = (InWayBillPositionAccessBean)bean;
		if ("2".equals(dbean.getDocument().getDocumentState())) {
			try {
				InWayBillProcessorAccessBean proc = new InWayBillProcessorAccessBean();
				String ms = null;
				if(manufserial != null && !"".equals(manufserial) && !manufserial.equals(oldManufserial)) {
					ms = manufserial;
				}
				String s = null;
				//System.out.println("INV: Serial=" + serialnumber + ", oldserial=" + oldSerial);
				if(serialnumber != null && !"".equals(serialnumber) && !serialnumber.equals(oldSerial)) {
					s = serialnumber;
				}
				//System.out.println("INV: calling setSerial(" + docposition.getInteger() +
				//	", " + s + ", " + ms);
				proc.setSerial(docposition.getInteger(),s,ms);
			} catch(Exception e) {
				DocumentProcessingException dpex = DocumentProcessingExceptionChecker.check(e);
				if(dpex != null) {
					if(dpex.getPositionErrors() != null) {
						Object o = dpex.getPositionErrors().get(0);
						if((o != null) && (o instanceof ProcessingPositionError)) {
							ProcessingPositionError pe = (ProcessingPositionError)o;
							switch(pe.getErrorCode()) {
							case ProcessingPositionError.ERRORS.CARD_ALREADY_EXISTS:
								throw new UpdateValidationException("error.update.externalser.serialexist");
							case ProcessingPositionError.ERRORS.NO_CARD:
								throw new UpdateValidationException("error.update.externalser.nocard");
							}
						}
					}
				} else {
					throw new UpdateValidationException("error.update.externalser.unknown");
				}
			}
		}
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	ExternalForm posform = (ExternalForm)request.getSession().getAttribute( "ExternalForm" );
	ExternalSerialListForm serform = (ExternalSerialListForm)request.getSession().getAttribute( "ExternalSerialListForm" );
	outerDocPosition.setInteger(serform.getOuterDocPosition());
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	docposition.setInteger(new Integer(keyGen.getNextKey("tables.docpositions")));
	InWayBillPositionAccessBean bean = new InWayBillPositionAccessBean(
		docposition.getInteger().intValue(),
		resource.getInteger(),
		posform.getOwnerKey(),
		posform.getDocumentId(),
		order.getInteger().intValue(),
		new java.math.BigDecimal(1),
		new java.math.BigDecimal(0),
		java.lang.Boolean.FALSE,
		boxed,
		java.lang.Boolean.FALSE,
		java.lang.Boolean.FALSE,
		java.lang.Boolean.FALSE,
		java.lang.Boolean.FALSE,
		outerDocPosition.getInteger(),
		price.getBigDecimal()
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
		InWayBillPositionAccessBean ab = (InWayBillPositionAccessBean)bean;
		resource.setInteger(new Integer(ab.getResource().getResource()));
		setResourcemodel(ab.getResource().getModel());
		setResourcename(ab.getResource().getName());
		order.setInteger(new Integer(ab.getOrder()));
		boxed = ab.getResultBoxed();
		oldManufserial = ab.getManufserial();
		oldSerial = ab.getSerialnumber();
	} catch(Exception e) {
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 20:16:43)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getBoxed() {
	return boxed;
}
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 20:16:43)
 * @return java.lang.String
 */
public java.lang.String getConfiguration() {
	return configuration;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ExternalSerialListForm serform = (ExternalSerialListForm)request.getSession().getAttribute( "ExternalSerialListForm" );
	outerDocPosition.setInteger(serform.getOuterDocPosition());
	InWayBillPositionAccessBean bean = new InWayBillPositionAccessBean();
	bean.setInitKey_docposition(docposition.getInteger().intValue());
	return bean;
}
public String getDocposition() {
	return docposition.getString();
}
public java.lang.String getManufserial() {
	return manufserial;
}
public java.lang.String getNotes() {
	return note;
}
public java.lang.String getOldManufserial() {
	return oldManufserial;
}
public java.lang.String getOldSerial() {
	return oldSerial;
}
public Integer getOrder() {
	return order.getInteger();
}
public String getOrderstr() {
	return order.getString();
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
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 20:16:43)
 * @return java.lang.String
 */
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 20:16:43)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
public java.lang.Boolean getResultBoxed() {
	return boxed;
}
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 20:16:43)
 * @return java.lang.String
 */
public java.lang.String getSerialnumber() {
	return serialnumber;
}
public java.math.BigDecimal getSourcePrice() {
	return price.getBigDecimal();
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITEOS;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	ExternalSerialListForm serform = (ExternalSerialListForm)request.getSession().getAttribute( "ExternalSerialListForm" );
	outerDocPosition.setInteger(serform.getOuterDocPosition());
	try {
		OuterDocPositionAccessBean ab = new OuterDocPositionAccessBean();
		ab.setInitKey_outerDocPosition(outerDocPosition.getInteger().intValue());
		resource.setInteger(new Integer(ab.getResource().getResource()));
		setResourcemodel(ab.getResource().getModel());
		setResourcename(ab.getResource().getName());
		order.setInteger(new Integer(1));
		boxed = Boolean.FALSE;
		setQty(new java.math.BigDecimal(1.0d));
		price.setBigDecimal(ab.getOuterPrice());
	} catch(Exception e) {
	}

	try {
		InWayBillPositionAccessBean bf = new InWayBillPositionAccessBean();
		InWayBillPositionAccessBean bean = 
			bf.findMaxOrderPosition(serform.getOuterDocPosition());
		price.setBigDecimal(bean.getPrice());
	} catch(Exception e) {
	}
}
public void setBoxed(java.lang.Boolean newBoxed) {
	boxed = newBoxed;
}
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 20:16:43)
 * @param newConfiguration java.lang.String
 */
public void setConfiguration(java.lang.String newConfiguration) {
	configuration = newConfiguration;
}
public void setDocposition(String newDocPosition) {
	docposition.setString(newDocPosition);
}
/**
 * 
 * @param newManufserial java.lang.String
 */
public void setManufserial(java.lang.String newManufserial) {
	manufserial = newManufserial;
}
public void setNotes(java.lang.String newNote) {
	note = newNote;
}
/**
 * 
 * @param newOldManufserial java.lang.String
 */
public void setOldManufserial(java.lang.String newOldManufserial) {
	oldManufserial = newOldManufserial;
}
/**
 * 
 * @param newOldSerial java.lang.String
 */
public void setOldSerial(java.lang.String newOldSerial) {
	oldSerial = newOldSerial;
}
public void setOrder(Integer newOrder) {
	order.setInteger(newOrder);
}
public void setOrderstr(String newOrder) {
	order.setString(newOrder);
}
public void setPricestr(String newPrice) {
	price.setString(newPrice);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:08:13)
 * @param newNds java.math.BigDecimal
 */
public void setQty(java.math.BigDecimal newQty) {
	qty.setBigDecimal(newQty);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:12:46)
 * @param newNsp java.lang.String
 */
public void setQtystr(String newQty) {
	qty.setString(newQty);
}
public void setResourcecode(java.lang.String newResource) {
	resource.setString(newResource);
}
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 20:16:43)
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
public void setResultBoxed(java.lang.Boolean newBoxed) {
	boxed = newBoxed;
}
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 20:16:43)
 * @param newSerialnumber java.lang.String
 */
public void setSerialnumber(java.lang.String newSerialnumber) {
	serialnumber = newSerialnumber;
}
public void setSourcePrice(java.math.BigDecimal newPrice) {
	price.setBigDecimal(newPrice);
}
public void validateValues(ActionErrors errors) throws Exception 
{
	qty.setBigDecimal(new java.math.BigDecimal(1));

	if (order.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalser.order"));
	}
	else if (!order.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalser.order"));
	}

	if(Boolean.TRUE.equals(boxed)) {
		if(note == null || "".equals(note)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalser.mark"));
		} else
		if(note.length() > 40) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalser.mark"));
		}
	}

	if(configuration != null && configuration.length() > 40) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalser.configuration"));
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
				//note = "";
				if ( (serialnumber == null || "".equals(serialnumber))) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalser.serial"));
				} else if(qty.getBigDecimal().doubleValue() < 1.0d) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalser.qtylow"));
				} else if(qty.getBigDecimal().doubleValue() > 1.0d) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalser.qtyhi"));
				}
				//System.out.println("INV: #0");
				if((serialnumber != null) && !"".equals(serialnumber)) {
					//System.out.println("INV: #1");
					try {
						StorageCardAccessBean card = (new StorageCardAccessBean()).findBySerial(serialnumber);
						//System.out.println("INV: #2");
						if(card != null) {
							//System.out.println("INV: #3");
							if(oldSerial == null || !serialnumber.equals(oldSerial)) {
								//System.out.println("INV: #4");
								errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalser.cardexist",serialnumber));
							}
						}
					} catch(Exception e) {}
					if(oldSerial != null && !serialnumber.equals(oldSerial)) {
						try {
							StorageCardAccessBean card = (new StorageCardAccessBean()).findBySerial(oldSerial);
							if(price.getBigDecimal() == null) {
								price.setBigDecimal(card.getPrice());
							}
							if(manufserial == null || "".equals(manufserial.trim())) {
								manufserial = card.getManufserial();
							}
						} catch(Exception e) {
						}
					} else {
					}
				}
				if(!bean.getPriceable().booleanValue() && price.isEmpty()) {
					price.setString("0.0");
				}
				if (price.isEmpty()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalser.price"));
				} else if(!price.isOk()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalser.price"));
				} else if(price.getBigDecimal().doubleValue() < 0.0d) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalser.pricelow"));
				}
			} else {
				if(note == null || "".equals(note)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.externalser.mark"));
				}
			}
		} else {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.externalser.nonserialresource"));
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.externalser.resource"));
	}

	if (!errors.empty())
		throw new ValidationException();

}
}
