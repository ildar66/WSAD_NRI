package com.hps.july.dictionary.formbean;

import javax.servlet.http.HttpServletRequest;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.cdbc.objects.CDBCResourcesObject;
import com.hps.july.commonbean.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;

/**
 * Форма редактирования оборудования базовых станций
 */
public class BasestationForm
	extends EditForm
{
	private String name;
	private String model;
	private StringAndIntegerProperty manufid;
	private String manufacturername;
	private String manucode;
	private int resource;
	private Boolean active;
	private Boolean disablenfscodes;
	private Boolean boxable;
	private Boolean complect;
	private Boolean complectpart;
	private Boolean priceable;
	private String countpolicy;
	private String notes;
	private StringAndIntegerProperty unit;
	private StringAndIntegerProperty resourcesubtype;
	private java.lang.String unitname;
	private java.lang.String resourcesubtypename;
	private int resourcetype;
	private java.lang.String resourcetypename;

	private String standard;
	private StringAndIntegerProperty manuyear;
	private String devline;
	private String generation;
	private String modification;
	private StringAndIntegerProperty length;
	private StringAndIntegerProperty width;
	private StringAndIntegerProperty height;

	private StringAndIntegerProperty maxsectorscount;
	private StringAndIntegerProperty maxtrxcount;

	private String navt;
	
	protected static String BASE_STAND_DEFAULT_NAME = "Шкаф базовой станции";
	
public BasestationForm() {
	super();
	active = Boolean.TRUE;
	manufid = new StringAndIntegerProperty();
	length = new StringAndIntegerProperty();
	width = new StringAndIntegerProperty();
	height = new StringAndIntegerProperty();
	unit = new StringAndIntegerProperty();
	resourcesubtype = new StringAndIntegerProperty();
	manuyear = new StringAndIntegerProperty();
	maxsectorscount = new StringAndIntegerProperty();
	maxtrxcount  = new StringAndIntegerProperty();
	countpolicy = "S";
	priceable = Boolean.FALSE;
	complect = Boolean.FALSE;
	complectpart = Boolean.FALSE;
	navt = "L";
	fuse();
}
private void fuse(){
	setBoxable(Boolean.FALSE);
	complectpart = Boolean.FALSE;
}

public Integer getMaxsectorscount(){
	return maxsectorscount.getInteger();
}
public String getMaxsectorscountFrm(){
	return maxsectorscount.getString();
}
public Integer getMaxtrxcount(){
	return maxtrxcount.getInteger();
}
public String getMaxtrxcountFrm(){
	return maxtrxcount.getString();
}


public void setMaxsectorscount(Integer newMaxsectorscount){
	maxsectorscount.setInteger(newMaxsectorscount);
}
public void setMaxsectorscountFrm(String newMaxsectorscount){
	maxsectorscount.setString(newMaxsectorscount);
}
public void setMaxtrxcount(Integer newMaxtrxcount){
	maxtrxcount.setInteger(newMaxtrxcount);
}
public void setMaxtrxcountFrm(String newMaxtrxcount){
	maxtrxcount.setString(newMaxtrxcount);
}



public void beforeUpdate(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception
{
	BaseStationResourceAccessBean br = (BaseStationResourceAccessBean)bean;
	br.setManucode(manucode);
	br.setManufid(manufid.getInteger());
	br.setModel(model);
	br.setName(name);
	br.setActive(getActive());
	br.setBoxable(getBoxable());
	br.setComplect(getComplect());
	br.setComplectpart(complectpart);
	br.setCountpolicy(getCountpolicy());
	br.setNotes(getNotes());
	br.setPriceable(getPriceable());
	try {
		br.setSubtype_resourcesubtype(resourcesubtype.getInteger());
	} catch(Exception e) {
		br.setSubtype(null);
	}
	try {
		br.setUnit((Unit)constructUnits().getEJBRef());
	} catch(Exception e) {
		br.setUnit(null);
	}
	br.setProductline(getDevline());
	br.setGeneration(getGeneration());
	br.setManucode(getManucode());
	br.setModel(getModel());
	br.setName(getName());
	br.setStandard(getStandard());
	br.setLength(length.getInteger());
	br.setHeight(height.getInteger());
	br.setWidth(width.getInteger());
	if(manuyear.getInteger() != null) {
		br.setMakeyear(new Short(manuyear.getString()));
	} else {
		br.setMakeyear(null);
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	BaseStationResourceAccessBean bean = new BaseStationResourceAccessBean(
		getResource(),
		getName(), getModel(), getNotes(), getComplect(), getCountpolicy(),
		getBoxable(), getPriceable(), complectpart,
		getActive(), getResourcesubtype()
	);
	return bean;
}
/*
public Organization constructManufacturer() {
	try {
		OrganizationAccessBean o = new OrganizationAccessBean();
		o.setInitKey_organization(manufacturer.getInteger().intValue());
		o.refreshCopyHelper();
		return (Organization)o.getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
*/
public ResourceSubTypeAccessBean constructSubtypes() throws Exception {
	ResourceSubTypeAccessBean subtypeab = null;
	if (!resourcesubtype.isEmpty()) {
		if (resourcesubtype.isOk()) {
			subtypeab = new ResourceSubTypeAccessBean();
			subtypeab.setInitKey_resourcesubtype(getResourcesubtype());
			subtypeab.refreshCopyHelper();
		}
	}
	return subtypeab;
}
public UnitAccessBean constructUnits() throws Exception {
	UnitAccessBean unitab = null;
	if (!unit.isEmpty()) {
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
		BaseStationResourceAccessBean ar = (BaseStationResourceAccessBean)bean;
		setResourcesubtype(ar.getSubtype_resourcesubtype().intValue());
		active = ar.getActive();
		boxable = ar.getBoxable();
		complect = ar.getComplect();
		complectpart = ar.getComplectpart();
		countpolicy = ar.getCountpolicy();
		manucode = ar.getManucode();
		if(ar.getManufid() != null) {
			manufid.setInteger(ar.getManufid());
			manufacturername = CDBCResourcesObject.getManufnameByManufid(ar.getManufid());
		}
		model = ar.getModel();
		name = ar.getName();
		notes = ar.getNotes();
		//priceable = ar.getPriceable();
		//priceable = Boolean.FALSE;
		if(ar.getSubtype() != null) {
			resourcesubtype.setInteger(new Integer(ar.getSubtype().getResourcesubtype()));
			resourcesubtypename = ar.getSubtype().getName();
			if(ar.getSubtype().getResourcetype() != null) {
				resourcetype = ar.getSubtype().getResourcetype().getResourcetype();
				resourcetypename = ar.getSubtype().getResourcetype().getName();
			}
		}
		height.setInteger(ar.getHeight());
		length.setInteger(ar.getLength());
		width.setInteger(ar.getWidth());
		if(ar.getMakeyear() != null) {
			manuyear.setInteger(new Integer(ar.getMakeyear().intValue()));
		} else {
			manuyear.setString("");
		}
		devline = ar.getProductline();
		generation = ar.getGeneration();
		standard = ar.getStandard();
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
public java.lang.Boolean getDisablenfscodes() {
	return disablenfscodes;
}
public void setDisablenfscodes(java.lang.Boolean newDisablenfscodes) {
	disablenfscodes = newDisablenfscodes;
}
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
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 13:12:49)
 * @return java.lang.String
 */
public java.lang.String getCountpolicy() {
	return countpolicy;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	BaseStationResourceAccessBean bean = new BaseStationResourceAccessBean();
	bean.setInitKey_resource(getResource());
	return bean;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDevline() {
	return devline;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getGeneration() {
	return generation;
}
	public Integer getHeight() {
		return height.getInteger();
	}
	public String getHeightFrm() {
		return height.getString();
	}
public boolean getIsresourceused() {
	com.hps.july.cdbc.objects.CDBCResourcesObject ro = new com.hps.july.cdbc.objects.CDBCResourcesObject();
	return ro.isResourceUsed(new Integer(getResource()));
}
	public String getLengthFrm() {
		return length.getString();
	}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManucode() {
	return manucode;
}
	public Integer getManufid() {
		return manufid.getInteger();
	}
	public String getManufidFrm() {
		return manufid.getString();
	}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManufacturername() {
	return manufacturername;
}
public java.lang.String getManuyear() {
	return manuyear.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getModel() {
	return model;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getModification() {
	return modification;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNavt() {
	return navt;
}
public Boolean getNode() {
//	if(complectpart.booleanValue()) {
//		return Boolean.FALSE;
//	} else {
//		return Boolean.TRUE;
//	}
	return complectpart;
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
 * 
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
public java.lang.String getResourcetypename() {
	return resourcetypename;
}
	public String getStandard() {
		return standard;
	}
	public Enumeration getStandards() {
		Vector v = new Vector();
		v.add("G"); v.add("GSM/DCS");
		v.add("D"); v.add("DAMPS");
		return v.elements();
	}
public int getState() {
	return com.hps.july.dictionary.APPStates.BASESTATION_EDIT;
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
	public Integer getWidth() {
		return width.getInteger();
	}
	public String getWidthFrm() {
		return width.getString();
	}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	name = BASE_STAND_DEFAULT_NAME; // "Базовая станция GSM/DCS";
	active = Boolean.TRUE;
	complect = Boolean.FALSE;
	complectpart = Boolean.FALSE;
	ResourcesCommonListForm frm = (ResourcesCommonListForm)request.getSession().getAttribute("ResourcesCommonListForm");
	setResourcesubtype(com.hps.july.util.AppUtils.getNamedValueInt("Dict_SIMPLERES"));
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
 * @param newDevline java.lang.String
 */
public void setDevline(java.lang.String newDevline) {
	devline = newDevline;
}
/**
 * 
 * @param newGeneration java.lang.String
 */
public void setGeneration(java.lang.String newGeneration) {
	generation = newGeneration;
}
	public void setHeight(Integer height) {
		this.height.setInteger(height);
	}
	public void setHeightFrm(String heightFrm) {
		this.height.setString(heightFrm);
	}
	public void setLength(Integer length) {
		this.length.setInteger(length);
	}
	public void setLengthFrm(String lengthFrm) {
		this.length.setString(lengthFrm);
	}
/**
 * 
 * @param newManucode java.lang.String
 */
public void setManucode(java.lang.String newManucode) {
	manucode = newManucode;
}
	public void setManufid(Integer newManufid) {
		manufid.setInteger(newManufid);
	}
	public void setManufidFrm(String newManufid) {
		manufid.setString(newManufid);
	}
/**
 * 
 * @param newManufacturername java.lang.String
 */
public void setManufacturername(java.lang.String newManufacturername) {
	manufacturername = newManufacturername;
}
public void setManuyear(java.lang.String newManuyear) {
	manuyear.setString(newManuyear);
}
/**
 * 
 * @param newModel java.lang.String
 */
public void setModel(java.lang.String newModel) {
	model = newModel;
}
/**
 * 
 * @param newModification java.lang.String
 */
public void setModification(java.lang.String newModification) {
	modification = newModification;
}
/**
 * 
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * 
 * @param newNavt java.lang.String
 */
public void setNavt(java.lang.String newNavt) {
	navt = newNavt;
}
public void setNode(Boolean newComplectpart) {
//	if(newComplectpart != null) {
//		if(newComplectpart.booleanValue()) complectpart = Boolean.FALSE;
//		else complectpart = Boolean.TRUE;
//	}
	complectpart = newComplectpart;
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
 * 
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
	public void setStandard(String std) {
		standard = std;
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
	public void setWidth(Integer width) {
		this.width.setInteger(width);
	}
	public void setWidthFrm(String widthFrm) {
		this.width.setString(widthFrm);
	}
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
		
	if ((getName() == null) || (getName().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.resource.name"));

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
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.basestation.invalidmanufacturer"));

	if ((getManucode() != null) && (getManucode().length() > 40)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.basestation.longmanucode"));
	}
// ----
	if (getStandard() != null) {
		if(!"G".equals(getStandard()) && !"D".equals(getStandard())) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.basestation.invalidstandard"));
		}
	}

	if(!manuyear.isEmpty()) {
		if(!manuyear.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.basestation.invalidmanuyear"));
		}
	}

	if ((getDevline() != null) && (getDevline().length() > 50)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.basestation.longdevline"));
	}

	if ((getGeneration() != null) && (getGeneration().length() > 10)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.basestation.longgeneration"));
	}

	if ((getModification() != null) && (getModification().length() > 10)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.basestation.longmodification"));
	}

	if (!length.isEmpty()) {
		if(!length.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.basestation.invalidlength"));
		} else if(length.getInteger().intValue() <= 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.basestation.invalidlength.otr"));
		}
	}

	if (!width.isEmpty()) {
		if(!width.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.basestation.invalidwidth"));
		} else if(width.getInteger().intValue() <= 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.basestation.invalidwidth.otr"));
		}
	}

	if (!height.isEmpty()) {
		if(!height.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.basestation.invalidheight"));
		} else if(height.getInteger().intValue() <= 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.basestation.invalidheight.otr"));
		}
	}
		
	if (!errors.empty())
	{
		System.err.println("-------------------Validate");
		throw new ValidationException();
	}
}
}
