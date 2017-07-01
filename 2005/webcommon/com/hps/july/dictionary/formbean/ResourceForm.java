package com.hps.july.dictionary.formbean;

import java.util.Enumeration;

import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.cdbc.objects.CDBCResourcesObject;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.constants.Resources;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;

/**
 * Форма редактирвоания оборудования.
 * Является базовой формой для редактирования оборудования различных классов
 */
public class ResourceForm extends com.hps.july.web.util.EditForm {
	private int resource;
	private Boolean active;
	private Boolean disablenfscodes;
	private int actualcode;
	private Boolean boxable;
	private Boolean complect;
	private Boolean complectpart;
	private String countpolicy;
	private String model;
	private String name;
	private String notes;
	private Boolean priceable;
	private StringAndIntegerProperty unit;
	private StringAndIntegerProperty resourcesubtype;
	private java.lang.String unitname;
	private java.lang.String resourcesubtypename;
	private int resourcetype;
	private java.lang.String resourcetypename;
	private UnitAccessBean unitab;
	private ResourceSubTypeAccessBean subtypeab;
	private OrganizationAccessBean manufacturerab;
	private StringAndIntegerProperty manufid;
	private String manufacturername;
	private String manucode;
	private int resclass2;
	
	public int getResclass2(){
		return resclass2;	
	}
	public void setResclass2(int newResclass2){
		resclass2 = newResclass2;	
	}
	
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 11:24:55)
 */
public ResourceForm() {
	setCountpolicy("S");
	setActive(new Boolean(true));
	setDisablenfscodes(Boolean.FALSE);
	setComplect(new Boolean(false));
	setPriceable(new Boolean(false));
	resourcesubtype = new StringAndIntegerProperty();
	manufid = new StringAndIntegerProperty();
	unit = new StringAndIntegerProperty();
	fuse();
}
private void fuse(){
	setBoxable(Boolean.FALSE);
	complectpart = Boolean.FALSE;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	//setActive(new Boolean(true));
	setComplect(new Boolean(false));
    ResourceAccessBean bean = new ResourceAccessBean(
		getResource(),
		getName(), getModel(), getNotes(),
		getComplect(), getCountpolicy(),
		getBoxable(), getPriceable(), getComplectpart(),
		getActive(), getResourcesubtype(), getResclass2()
	);
	return bean;
}

/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public ResourceSubTypeAccessBean constructSubtypes() throws Exception {

	if (subtypeab == null) {	
		if (!resourcesubtype.isEmpty()) 
			if (resourcesubtype.isOk()) {
				subtypeab = new ResourceSubTypeAccessBean();
				subtypeab.setInitKey_resourcesubtype(getResourcesubtype());
				subtypeab.refreshCopyHelper();
			}
	}
	return subtypeab;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public UnitAccessBean constructUnits() throws Exception {

	if (unitab == null) {	
		if (!unit.isEmpty()) 
			if (unit.isOk()) {
				unitab = new UnitAccessBean();
				unitab.setInitKey_unit(getUnitcode().intValue());
				unitab.refreshCopyHelper();
			}
	}
	return unitab;
}
public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean)
{
	try {
		ResourceAccessBean rr = (ResourceAccessBean)bean;
		setResourcesubtype(rr.getSubtype_resourcesubtype().intValue());
		if(rr.getManufid() != null) {
			setManufid(rr.getManufid());
			setManufacturername(CDBCResourcesObject.getManufnameByManufid(rr.getManufid()));
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 13:10:18)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getActive() {
	return active;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 13:10:18)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getDisablenfscodes() {
	return disablenfscodes;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:12:52)
 * @return int
 */
public int getActualcode() {
	return actualcode;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.DICTIONARY;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:14:53)
 * @return java.lang.String
 */
public Boolean getBoxable() {
	return boxable;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:13:46)
 * @return java.lang.String
 */
public Boolean getComplect() {
	return complect;
}
public Boolean getComplectpart() {
	if(complectpart.booleanValue()) {
		return Boolean.FALSE;
	} else {
		return Boolean.TRUE;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 13:12:49)
 * @return java.lang.String
 */
public java.lang.String getCountpolicy() {
	return countpolicy;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ResourceAccessBean bean = new ResourceAccessBean();
	bean.setInitKey_resource(getResource());
	return bean;
}
public boolean getIsresourceused() {
	com.hps.july.cdbc.objects.CDBCResourcesObject ro = new com.hps.july.cdbc.objects.CDBCResourcesObject();
	return ro.isResourceUsed(new Integer(getResource()));
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManucode() {
	return manucode;
}
/*
public Organization getManufacturer()  throws Exception  {
	OrganizationAccessBean bean = constructManufacturers();
	if (bean != null)
	  return (Organization)bean.getEJBRef();
	else
	  return null;
}
public Integer getManufacturercode() {
	return manufacturer.getInteger();
}
public java.lang.String getManufacturerFrm() {
	return manufacturer.getString();
}
*/
public Integer getManufid() {
	return manufid.getInteger();
}
public java.lang.String getManufidFrm() {
	return manufid.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManufacturername() {
	return manufacturername;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:11:23)
 * @return java.lang.String
 */
public java.lang.String getModel() {
	return model;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:41:08)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:11:47)
 * @return java.lang.String
 */
public java.lang.String getNotes() {
	return notes;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:15:29)
 * @return java.lang.String
 */
public Boolean getPriceable() {
	return priceable;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 13:10:18)
 * @return int
 */
public int getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 17:06:09)
 * @return int
 */
public int getResourcesubtype() {
	return resourcesubtype.getInteger().intValue();
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 11:53:38)
 * @return java.lang.String
 */
public java.lang.String getResourcesubtypeFrm() {
	return resourcesubtype.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 12:09:35)
 * @return java.lang.String
 */
public java.lang.String getResourcesubtypename() {
	return resourcesubtypename;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 12:14:23)
 * @return int
 */
public int getResourcetype() {
	return resourcetype;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 12:14:39)
 * @return java.lang.String
 */
public java.lang.String getResourcetypename() {
	return resourcetypename;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITRES;
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2002 11:45:54)
 * @return com.hps.july.persistence.ResourceSubType
 */
public ResourceSubType getSubtype()  throws Exception {
	ResourceSubTypeAccessBean bean = constructSubtypes();
	if (bean != null)
	  return (ResourceSubType)bean.getEJBRef();
	else
	  return null;
}
/**
 * Insert the method's description here.
 */
public Unit getUnit()  throws Exception  {
	UnitAccessBean bean = constructUnits();
	if (bean != null)
	  return (Unit)bean.getEJBRef();
	else
	  return null;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:11:01)
 * @return int
 */
public Integer getUnitcode() {
	return unit.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 11:54:06)
 * @return java.lang.String
 */
public java.lang.String getUnitFrm() {
	return unit.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 17:03:10)
 * @return java.lang.String
 */
public java.lang.String getUnitname() {
	return unitname;
}
public java.util.Enumeration getUnits() {
	try {
		UnitAccessBean u = new UnitAccessBean();
		return u.findAll();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return null;
	}
}

public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	// BEE00001284
	/*
	ResourceListForm aform = (ResourceListForm)request.getSession().getAttribute( "ResourceListForm" );
	if (aform != null) {
		if(aform.getResourcetype().getInteger() != null) {
			setResourcetype(aform.getResourcetype().getInteger().intValue());
		} else {
			setResourcetype(0);
		}
		setResourcetypename(aform.getResourcetypename());
		// setResourcetypename("");
		if(aform.getResourcesubtype().getInteger() != null) {
			setResourcesubtype(aform.getResourcesubtype().getInteger().intValue());
		} else {
			setResourcesubtype(0);
		}
		setResourcesubtypename(aform.getResourcesubtypename());
	} else {
	*/
			setResourcetype(0);
			setResourcesubtype(com.hps.july.util.AppUtils.getNamedValueInt("Dict_SIMPLERES"));
			setResourcesubtypename("");
	// }
	setActive(Boolean.TRUE);
	String rescl2 =  request.getParameter("resclass2");
	System.out.println("rescl2 = "+rescl2);
	setResclass2(Integer.parseInt(rescl2));
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	try{
		setResource(keyGen.getNextKey("tables.resources"));
	}
	catch (Exception e){
	}
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 13:10:18)
 * @param newActive java.lang.Boolean
 */
public void setActive(java.lang.Boolean newActive) {
	active = newActive;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 13:10:18)
 * @param newNfsdeny java.lang.Boolean
 */
public void setDisablenfscodes(java.lang.Boolean newDisablenfscodes) {
	disablenfscodes = newDisablenfscodes;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:12:52)
 * @param newActualcode int
 */
public void setActualcode(int newActualcode) {
	actualcode = newActualcode;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:14:53)
 * @param newBoxable java.lang.String
 */
public void setBoxable(Boolean newBoxable) {
	boxable = newBoxable;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:13:46)
 * @param newComplect java.lang.String
 */
public void setComplect(Boolean newComplect) {
	complect = newComplect;
}
public void setComplectpart(Boolean newComplectpart) {
	if(newComplectpart != null) {
		if(newComplectpart.booleanValue()) complectpart = Boolean.FALSE;
		else complectpart = Boolean.TRUE;
	} 
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 13:12:49)
 * @param newCountpolicy java.lang.String
 */
public void setCountpolicy(java.lang.String newCountpolicy) {
	countpolicy = newCountpolicy;
}
/**
 * 
 * @param newManucode java.lang.String
 */
public void setManucode(java.lang.String newManucode) {
	manucode = newManucode;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:11:01)
 * @param newUnit int
 */
/*
public void setManufacturer(OrganizationAccessBean newManufacturer) {
	try {
		manufacturer.setInteger(new Integer(newManufacturer.getOrganization()));
		manufacturername = newManufacturer.getName();
	} catch(Exception e) {
		manufacturer.setString("");
		manufacturername = "";
	}
}
public void setManufacturercode(Integer newManufacturer) {
	manufacturer.setInteger(newManufacturer);
}
public void setManufacturerFrm(java.lang.String newManufacturerFrm) {
	manufacturer.setString(newManufacturerFrm);
}
*/
public void setManufid(Integer newManufid) {
	manufid.setInteger(newManufid);
}
public void setManufidFrm(java.lang.String newManufidFrm) {
	manufid.setString(newManufidFrm);
}

/**
 * 
 * @param newManufacturername java.lang.String
 */
public void setManufacturername(java.lang.String newManufacturername) {
	manufacturername = newManufacturername;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:11:23)
 * @param newModel java.lang.String
 */
public void setModel(java.lang.String newModel) {
	model = newModel;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:41:08)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:11:47)
 * @param newNotes java.lang.String
 */
public void setNotes(java.lang.String newNotes) {
	notes = newNotes;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:15:29)
 * @param newPriceable java.lang.String
 */
public void setPriceable(Boolean newPriceable) {
	priceable = newPriceable;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 13:10:18)
 * @param newResource int
 */
public void setResource(int newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 17:06:09)
 * @param newResourcesubtype int
 */
public void setResourcesubtype(int newResourcesubtype) {
	resourcesubtype.setInteger(new Integer(newResourcesubtype));
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 11:53:38)
 * @param newResourcesubtypeFrm java.lang.String
 */
public void setResourcesubtypeFrm(java.lang.String newResourcesubtypeFrm) {
	resourcesubtype.setString(newResourcesubtypeFrm);
	// Lookup
	try {
		int key = resourcesubtype.getInteger().intValue();
		if (key != 0) {
			ResourceSubTypeAccessBean bean = new ResourceSubTypeAccessBean();
			bean.setInitKey_resourcesubtype(key);
			resourcesubtypename = bean.getName();
		}
	} catch (Exception ex) {}		
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 12:09:35)
 * @param newResourcesubtypename java.lang.String
 */
public void setResourcesubtypename(java.lang.String newResourcesubtypename) {
	resourcesubtypename = newResourcesubtypename;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 12:14:23)
 * @param newResourcetype int
 */
public void setResourcetype(int newResourcetype) {
	resourcetype = newResourcetype;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 12:14:39)
 * @param newResourcetypename java.lang.String
 */
public void setResourcetypename(java.lang.String newResourcetypename) {
	resourcetypename = newResourcetypename;
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2002 11:55:19)
 * @param newSubtype com.hps.july.persistence.ResourceSubTypeAccessBean
 */
public void setSubtype(ResourceSubTypeAccessBean newSubtype)
{
	try {
		resourcesubtype.setInteger(new Integer(newSubtype.getResourcesubtype()));
		resourcesubtypename = newSubtype.getName();
		ResourceTypeAccessBean b = newSubtype.getResourcetype();
		if(b != null) {
			resourcetype = b.getResourcetype();
			resourcetypename = b.getName();
		}
	} catch(Exception e) {
		resourcesubtype.setInteger(new Integer(0));
		resourcesubtypename = "";
		resourcetype = 0;
		resourcetypename = "";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:11:01)
 * @param newUnit int
 */
public void setUnit(UnitAccessBean newUnit) {
	try {
		unit.setInteger(new Integer(newUnit.getUnit()));
		unitname = newUnit.getName();
	} catch(Exception e) {
		unit.setString("");
		unitname = "";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 16:27:43)
 */
public void setUnitcode(Integer newUnit) {
	unit.setInteger(newUnit);
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 11:54:06)
 * @param newUnitFrm java.lang.String
 */
public void setUnitFrm(java.lang.String newUnitFrm) {
	unit.setString(newUnitFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 17:03:10)
 * @param newUnitname java.lang.String
 */
public void setUnitname(java.lang.String newUnitname) {
	unitname = newUnitname;
}

/**
 * Метод для валидации одного числового значения. Вызывается в validateValues() для каждого значения.
 * Creation date: (15.07.2004 18:10:07)
 * @param errors org.apache.struts.action.ActionErrors
 * @param parameter com.hps.july.web.util.TwainProperty
 * @param keyPart java.lang.String
 */
public void validateNumberValue(ActionErrors errors, TwainProperty parameter, String keyPart) {
	if(!parameter.isEmpty()) { 
		if(!parameter.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid." + keyPart));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty." + keyPart));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if (resourcesubtype.isEmpty())
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.resource.subtype"));
	  
	else if (!resourcesubtype.isOk())
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.resource.subtype"));
	else
		try {
			constructSubtypes();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.resource.subtype"));
			else
			  throw ex;
		}
	  
		
	if(getName() != null)
		setName(getName().trim());
		
	if ((getName() == null) || (getName().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.resource.name"));

	if(getModel() != null)
		setModel(getModel().trim());
		
	if ((getModel() == null) || (getModel().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.resource.model"));

	if (!unit.isEmpty() && !resourcesubtype.isOk())
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.resource.unit"));
	else
		try {
			constructUnits();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.resource.unit"));
			else
			  throw ex;
		}

	if (!manufid.isEmpty())
		if(!manufid.isOk())
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.resource.manufacturer"));

	if((getManucode() != null) && (getManucode().length() > 40)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.resource.manucode"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
