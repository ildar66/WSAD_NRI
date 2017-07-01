package com.hps.july.dictionary.formbean;

import java.math.BigDecimal;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.objects.CDBCDictionaryObject;
import com.hps.july.cdbc.objects.CDBCResourcesObject;
import com.hps.july.commonbean.*;
import com.hps.july.persistence.*;
import javax.servlet.http.HttpServletRequest;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import org.apache.struts.action.*;
import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;

/**
 * ‘орма редактировани€ параметров кабелей базовых станций
 */
public class CableForm extends EditForm {
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

	private StringAndBigDecimalProperty lost800;
	private StringAndBigDecimalProperty lost900;
	private StringAndBigDecimalProperty lost1800;
	private StringAndBigDecimalProperty lost2000;

	private String navt;
	
	private int cableDiam = 1;
	
public CableForm() {
	super();
	manufid = new StringAndIntegerProperty();
	lost800 = new StringAndBigDecimalProperty();
	lost900 = new StringAndBigDecimalProperty();
	lost1800 = new StringAndBigDecimalProperty();
	lost2000 = new StringAndBigDecimalProperty();
	unit = new StringAndIntegerProperty();
	resourcesubtype = new StringAndIntegerProperty();
	countpolicy = "B";
	active = Boolean.TRUE;
	priceable = Boolean.FALSE;
	navt = "L";
	fuse();
}
private void fuse(){
	setBoxable(Boolean.FALSE);
	complectpart = Boolean.FALSE;
}

/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request)
throws Exception 
{
	CableResourceBandAccessBean b = new CableResourceBandAccessBean();
	Enumeration en = b.findCableResourceBandsByResource(new ResourceKey(getResource()));
	while(en.hasMoreElements()) {
		CableResourceBandAccessBean c = (CableResourceBandAccessBean)en.nextElement();
		c.getEJBRef().remove();
	}
}
public void beforeUpdate(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception
{
	CableResourceAccessBean cr = (CableResourceAccessBean)bean;
	cr.setManucode(manucode);
	cr.setManufid(manufid.getInteger());
	cr.setModel(model);
	cr.setName(name);
	cr.setActive(getActive());
	cr.setBoxable(getBoxable());
	cr.setComplect(getComplect());
	cr.setComplectpart(complectpart);
	cr.setCountpolicy(getCountpolicy());
	cr.setNotes(getNotes());
	cr.setPriceable(getPriceable());
	cr.setCablediamid(cableDiam);
	try {
		cr.setSubtype_resourcesubtype(resourcesubtype.getInteger());
//		cr.setSubtype((ResourceSubType)constructSubtypes().getEJBRef());
	} catch(Exception e) {
		cr.setSubtype(null);
	}
	try {
		cr.setUnit((Unit)constructUnits().getEJBRef());
	} catch(Exception e) {
		cr.setUnit(null);
	}
	updateLost(lost800,800);
	updateLost(lost900,900);
	updateLost(lost1800,1800);
	updateLost(lost2000,2000);
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	CableResourceAccessBean bean = new CableResourceAccessBean(
		getResource(),
		getName(), getModel(), getNotes(), getComplect(), getCountpolicy(),
		getBoxable(), getPriceable(), complectpart,
		getActive(), getResourcesubtype(), cableDiam
	);
	return bean;
}

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
public void fillLostfactor(StringAndBigDecimalProperty prop, int band){
	try {
		CableResourceBandAccessBean cb = new CableResourceBandAccessBean();
		cb.setInitKey_band((short)band);
		cb.setInitKey_resource_resource(new Integer(getResource()));
		cb.refreshCopyHelper();
		prop.setBigDecimal(cb.getLostfactor());
	} catch(Exception e) {
		prop.setString("");
	}
}
public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean)
{
	try {
		CableResourceAccessBean cr = (CableResourceAccessBean)bean;
		setResourcesubtype(cr.getSubtype_resourcesubtype().intValue());
		active = cr.getActive();
		boxable = cr.getBoxable();
		complect = cr.getComplect();
		complectpart = cr.getComplectpart();
		countpolicy = cr.getCountpolicy();
		manucode = cr.getManucode();
		if(cr.getManufid() != null) {
			manufid.setInteger(cr.getManufid());
			manufacturername = CDBCResourcesObject.getManufnameByManufid(cr.getManufid()); 
		} else {
			manufacturername = "";
		}
		model = cr.getModel();
		name = cr.getName();
		notes = cr.getNotes();
		priceable = cr.getPriceable();
		if(cr.getUnit() != null) {
			setUnitcode(new Integer(cr.getUnit().getUnit()));
			unitname = cr.getUnit().getName();
		}
		if(cr.getSubtype() != null) {
			resourcesubtype.setInteger(new Integer(cr.getSubtype().getResourcesubtype()));
			resourcesubtypename = cr.getSubtype().getName();
			if(cr.getSubtype().getResourcetype() != null) {
				resourcetype = cr.getSubtype().getResourcetype().getResourcetype();
				resourcetypename = cr.getSubtype().getResourcetype().getName();
			}
		}
		fillLostfactor(lost800,800);
		fillLostfactor(lost900,900);
		fillLostfactor(lost1800,1800);
		fillLostfactor(lost2000,2000);
		cableDiam = cr.getCablediamid();
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
public AbstractEntityAccessBean getDataBean(HttpServletRequest request) {
	CableResourceAccessBean bean = new CableResourceAccessBean();
	bean.setInitKey_resource(getResource());
	return bean;
}
public boolean getIsresourceused() {
	com.hps.july.cdbc.objects.CDBCResourcesObject ro = new com.hps.july.cdbc.objects.CDBCResourcesObject();
	return ro.isResourceUsed(new Integer(getResource()));
}
public BigDecimal getLost1800() {
	return lost1800.getBigDecimal();
}
public java.lang.String getLost1800Frm() {
	return lost1800.getString();
}
public BigDecimal getLost2000() {
	return lost2000.getBigDecimal();
}
public java.lang.String getLost2000Frm() {
	return lost2000.getString();
}
public BigDecimal getLost800() {
	return lost800.getBigDecimal();
}
public java.lang.String getLost800Frm() {
	return lost800.getString();
}
public BigDecimal getLost900() {
	return lost900.getBigDecimal();
}
public java.lang.String getLost900Frm() {
	return lost900.getString();
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
public int getState() {
	return com.hps.july.dictionary.APPStates.CABLE_EDIT;
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
public void initRecord(HttpServletRequest request)
	throws Exception
{
	name = " абель базовой станции";
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
public static boolean invalidScaleAndInt(StringAndBigDecimalProperty prop, int digits, int scale) {
	if(prop == null) {
		return false;
	}
	if(prop.getBigDecimal() == null) {
		return false;
	}
	return (prop.getBigDecimal().scale() > scale) || (prop.getBigDecimal().doubleValue() > (Math.pow(10,digits-scale)-1));
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
public void setLost1800(BigDecimal newLostfactor) {
	lost1800.setBigDecimal(newLostfactor);
}
public void setLost1800Frm(java.lang.String newLostfactor) {
	lost1800.setString(newLostfactor);
}
public void setLost2000(BigDecimal newLostfactor) {
	lost2000.setBigDecimal(newLostfactor);
}
public void setLost2000Frm(java.lang.String newLostfactor) {
	lost2000.setString(newLostfactor);
}
public void setLost800(BigDecimal newLostfactor) {
	lost800.setBigDecimal(newLostfactor);
}
public void setLost800Frm(java.lang.String newLostfactor) {
	lost800.setString(newLostfactor);
}
public void setLost900(BigDecimal newLostfactor) {
	lost900.setBigDecimal(newLostfactor);
}
public void setLost900Frm(java.lang.String newLostfactor) {
	lost900.setString(newLostfactor);
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
/**
 * 
 * @param newModel java.lang.String
 */
public void setModel(java.lang.String newModel) {
	model = newModel;
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
public void updateLost(StringAndBigDecimalProperty prop, int band) {
	CableResourceBandAccessBean b = new CableResourceBandAccessBean();
	try {
		System.out.println(":#: updateLost:"+band);
		b.setInitKey_band((short)band);
		b.setInitKey_resource_resource(new Integer(getResource()));
		b.refreshCopyHelper();
		if(prop.getBigDecimal() != null) {
			b.setLostfactor(prop.getBigDecimal());
			b.commitCopyHelper();
		} else {
			b.getEJBRef().remove();
		}
		System.out.println(":#: updateLost:"+band+", "+prop.getBigDecimal());
	} catch(Exception e) {
		try {
			System.out.println(":#: createCableBand:"+band+", "+prop.getBigDecimal());
			b = new CableResourceBandAccessBean(getResource(),(short)band);
			b.setLostfactor(prop.getBigDecimal());
			b.commitCopyHelper();
		} catch(Exception ee) {
			e.printStackTrace(System.out);
			ee.printStackTrace(System.out);
		}
	}
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if (resourcesubtype.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.resource.subtype"));
	} else if (!resourcesubtype.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.resource.subtype"));
	} else {
		try {
			constructSubtypes();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.resource.subtype"));
			else
			  throw ex;
		}
	}
		
	if ((getName() == null) || (getName().length() == 0)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.resource.name"));
	}

	if ((getModel() == null) || (getModel().length() == 0)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.resource.model"));
	}

	if (!unit.isEmpty() && !resourcesubtype.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.resource.unit"));
	} else {
		try {
			constructUnits();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.resource.unit"));
			else
			  throw ex;
		}
	}

	if (!manufid.isEmpty())
		if(!manufid.isOk())
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.resource.manufacturer"));

	if((getManucode() != null) && (getManucode().length() > 40)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.resource.manucode"));
	}
// -----------------------
	if(!lost800.isEmpty()) {
		if(!lost800.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cable.invalidlostfactor",new Integer(800)));
		} else {
			if(lost800.getBigDecimal().doubleValue() < 0.0d) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cable.lostfactorlesszero",new Integer(800)));
			}
			if(invalidScaleAndInt(lost800,6,4)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cable.lostfactorscale",new Integer(800)));
			}
		}
	}
	if(!lost900.isEmpty()) {
		if(!lost900.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cable.invalidlostfactor",new Integer(900)));
		} else {
			if(lost900.getBigDecimal().doubleValue() < 0.0d) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cable.lostfactorlesszero",new Integer(900)));
			}
			if(invalidScaleAndInt(lost900,6,4)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cable.lostfactorscale",new Integer(900)));
			}
		}
	}
	if(!lost1800.isEmpty()) {
		if(!lost1800.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cable.invalidlostfactor",new Integer(1800)));
		} else {
			if(lost1800.getBigDecimal().doubleValue() < 0.0d) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cable.lostfactorlesszero",new Integer(1800)));
			}
			if(invalidScaleAndInt(lost1800,6,4)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cable.lostfactorscale",new Integer(1800)));
			}
		}
	}
	if(!lost2000.isEmpty()) {
		if(!lost2000.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cable.invalidlostfactor",new Integer(2000)));
		} else {
			if(lost2000.getBigDecimal().doubleValue() < 0.0d) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cable.lostfactorlesszero",new Integer(2000)));
			}
			if(invalidScaleAndInt(lost2000,6,4)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cable.lostfactorscale",new Integer(2000)));
			}
		}
	}
	if (!errors.empty())
		throw new ValidationException();
}
	/**
	 * @return
	 */
	public int getCableDiam() {
		return cableDiam;
	}

	/**
	 * @param i
	 */
	public void setCableDiam(int i) {
		cableDiam = i;
	}

	public CDBCResultSet getCablediameters() {
		return CDBCDictionaryObject.getAllCableDiameters();
	}

}
