package com.hps.july.dictionary.formbean;

import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.cdbc.objects.CDBCResourcesObject;
import com.hps.july.commonbean.*;
import com.hps.july.jdbcpersistence.lib.StringAndBigDecimal;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;

/**
 * Форма редактирования оборудования антенн
 */
public class AntenaForm extends EditForm {
	private int resource;
	private Boolean active;
	private Boolean disablenfscodes;
	private Boolean boxable;
	private Boolean complect;
	private Boolean complectpart;
	private Boolean priceable;
	private String countpolicy;
	private String name;
	private String notes;
	private String model;
	private StringAndIntegerProperty manufid;
	private String manufacturername;
	private String manucode;
	private StringAndIntegerProperty unit;
	private StringAndIntegerProperty resourcesubtype;
	//private Integer resourcesubtype;
	private java.lang.String unitname;
	private java.lang.String resourcesubtypename;
	private int resourcetype;
	private java.lang.String resourcetypename;

	private String freqrange;
	private String polar;
	private Boolean omni;
	
	private StringAndBigDecimalProperty[] amplify;
	private StringAndBigDecimalProperty[] amplifycount;
	private StringAndBigDecimalProperty[] horzwidth;
	private StringAndBigDecimalProperty[] vertwidth;
	private StringAndBigDecimalProperty[] electricangle;
	
	private Boolean[] hasMaxElectricangle;
	private StringAndBigDecimalProperty[] maxElectricangle;
	
	private StringAndBigDecimalProperty[] ksvn;
	private Boolean[] freqenabled;
	private String port;
	private StringAndIntegerProperty length;
	private StringAndIntegerProperty width;
	private StringAndIntegerProperty height;
	private StringAndBigDecimalProperty weight;
	private StringAndBigDecimalProperty entriescount;
	
	private ResourcesCommonListForm frm;

	private Integer[] ranges = new Integer[] {
		new Integer(800), new Integer(900), new Integer(1800), new Integer(2000)
	};

	private String navt; // L - from Local List, R - from Resources List
public AntenaForm() {
	super();
	manufid = new StringAndIntegerProperty();
	unit = new StringAndIntegerProperty();
	resourcesubtype = new StringAndIntegerProperty();
	length = new StringAndIntegerProperty();
	width = new StringAndIntegerProperty();
	height = new StringAndIntegerProperty();
	weight = new StringAndBigDecimalProperty();
	entriescount = new StringAndBigDecimalProperty();

	int i;
	amplify = new StringAndBigDecimalProperty[4];
	for(i = 0; i < 4; i++) { amplify[i] = new StringAndBigDecimalProperty(); }
	amplifycount = new StringAndBigDecimalProperty[4];
	for(i = 0; i < 4; i++) { amplifycount[i] = new StringAndBigDecimalProperty(); }
	horzwidth = new StringAndBigDecimalProperty[4];
	for(i = 0; i < 4; i++) { horzwidth[i] = new StringAndBigDecimalProperty(); }
	vertwidth = new StringAndBigDecimalProperty[4];
	for(i = 0; i < 4; i++) { vertwidth[i] = new StringAndBigDecimalProperty(); }
	electricangle = new StringAndBigDecimalProperty[4];
	for(i = 0; i < 4; i++) { electricangle[i] = new StringAndBigDecimalProperty(); }
	
	hasMaxElectricangle = new Boolean[4];
	for(i = 0; i < 4; i++) { hasMaxElectricangle[i] = new Boolean(false); }
	maxElectricangle = new StringAndBigDecimalProperty[4];
	for(i = 0; i < 4; i++) { maxElectricangle[i] = new StringAndBigDecimalProperty(); }
	
	ksvn = new StringAndBigDecimalProperty[4];
	for(i = 0; i < 4; i++) { ksvn[i] = new StringAndBigDecimalProperty(); }
	freqenabled = new Boolean[4];
	for(i = 0; i < 4; i++) { freqenabled[i] = Boolean.FALSE; }

	navt = "L";
	
	priceable=Boolean.FALSE;
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
	AntennaResourceBandAccessBean b = new AntennaResourceBandAccessBean();
	Enumeration en = b.findAntennaResourceBandsByResource(new ResourceKey(getResource()));
	while(en.hasMoreElements()) {
		AntennaResourceBandAccessBean c = (AntennaResourceBandAccessBean)en.nextElement();
		c.getEJBRef().remove();
	}
}
public void beforeUpdate(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception
{
	AntennaResourceAccessBean ar = (AntennaResourceAccessBean)bean;
	ar.setManucode(manucode);
	ar.setManufid(manufid.getInteger());
	ar.setModel(model);
	ar.setName(name);
	ar.setActive(getActive());
	ar.setBoxable(getBoxable());
	ar.setComplect(getComplect());
	ar.setComplectpart(complectpart);
	ar.setCountpolicy(getCountpolicy());
	ar.setNotes(getNotes());
	ar.setPriceable(getPriceable());
	try {
		ar.setSubtype((ResourceSubType)constructSubtypes().getEJBRef());
	} catch(Exception e) {
		ar.setSubtype(null);
	}
	try {
		ar.setUnit((Unit)constructUnits().getEJBRef());
	} catch(Exception e) {
		ar.setUnit(null);
	}
//	ar.setElectricangle(electricangle.getBigDecimal());
	ar.setFreqrange(ar.getFreqrange());
	ar.setHeight(height.getInteger());
//	ar.setKsvn(ksvn.getBigDecimal());
	ar.setLength(length.getInteger());
	ar.setPolarization(polar);
	ar.setConnector(port);
	ar.setWeight(weight.getBigDecimal());
	ar.setWidth(width.getInteger());
	ar.setIsomni(omni);
	//ar.setEntriescount(new Integer(entriescount.getBigDecimal().toBigInteger().intValue()));
	ar.setEntriescount(getEntriescount());

	updateAntenaBands();
}
public void calculateAmplification() {
	for(int i = 0; i < 4; i++) {
		calculateAmplification(i);
	}
}
public void calculateAmplification(int i) {
	if(amplify[i].getBigDecimal() != null) {
		double ac = Math.pow(10.0d, amplify[i].getBigDecimal().doubleValue() / 10.0d);
		if(Double.isInfinite(ac)) {
			throw new java.lang.IllegalArgumentException();
		}
		if(Double.isNaN(ac)) {
			throw new java.lang.IllegalArgumentException();
		}
		BigDecimal bd = new BigDecimal(ac);
		bd = bd.setScale(1,BigDecimal.ROUND_HALF_UP);
		amplifycount[i].setBigDecimal(bd);
	} else {
		amplifycount[i].setString("");
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	AntennaResourceAccessBean bean = new AntennaResourceAccessBean(
		getResource(),
		getName(), getModel(), getNotes(), getComplect(), getCountpolicy(),
		getBoxable(), getPriceable(), complectpart,
		getActive(), getResourcesubtype()
	);
	return bean;
}
public Organization constructManufacturer() {
	try {
		OrganizationAccessBean o = new OrganizationAccessBean();
		o.setInitKey_organization(manufid.getInteger().intValue());
		o.refreshCopyHelper();
		return (Organization)o.getEJBRef();
	} catch(Exception e) {
		return null;
	}
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
public void fillAntenaBands()
	throws java.lang.Exception
{
	for(int i = 0; i < 4; i++) {
		try {
			AntennaResourceBandAccessBean a = new AntennaResourceBandAccessBean();
			a.setInitKey_band(ranges[i].shortValue());
			a.setInitKey_resource_resource(new Integer(getResource()));
			a.refreshCopyHelper();
			amplify[i].setBigDecimal(a.getAmplification());
			horzwidth[i].setBigDecimal(a.getHorzwidth());
			vertwidth[i].setBigDecimal(a.getVertwidth());
			electricangle[i].setBigDecimal(a.getElectricangle());
			//
			hasMaxElectricangle[i] = new Boolean(a.isHasMaxElectricAngle());
			maxElectricangle[i].setBigDecimal(a.getMaxelectricangle());
			//
			ksvn[i].setBigDecimal(a.getKsvn());
			calculateAmplification(i);
			freqenabled[i] = Boolean.TRUE;
		} catch(javax.ejb.ObjectNotFoundException onfe) {
			freqenabled[i] = Boolean.FALSE;
		}
	}
}
public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean)
{
	try {
		AntennaResourceAccessBean ar = (AntennaResourceAccessBean)bean;
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
		priceable = ar.getPriceable();
		if(ar.getSubtype() != null) {
			resourcesubtype.setInteger(new Integer(ar.getSubtype().getResourcesubtype()));
			resourcesubtypename = ar.getSubtype().getName();
			if(ar.getSubtype().getResourcetype() != null) {
				resourcetype = ar.getSubtype().getResourcetype().getResourcetype();
				resourcetypename = ar.getSubtype().getResourcetype().getName();
			}
		}
//		electricangle.setBigDecimal(ar.getElectricangle());
		freqrange = ar.getFreqrange();
		height.setInteger(ar.getHeight());
//		ksvn.setBigDecimal(ar.getKsvn());
		length.setInteger(ar.getLength());
		polar = ar.getPolarization();
		port = ar.getConnector();
		weight.setBigDecimal(ar.getWeight());
		width.setInteger(ar.getWidth());
		fillAntenaBands();
		omni = ar.getIsomni();
		if(ar.getUnit() != null) {
			unit.setInteger(new Integer(ar.getUnit().getUnit()));
			unitname = ar.getUnit().getName();
		}
		Integer ec=ar.getEntriescount();
		if (ec==null) {
			setEntriescountStr("");
		} 
		else {
			setEntriescount(ar.getEntriescount());
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * 
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
public String getAmplifycountFrm(int index) {
	return amplifycount[index].getString();
}
public String getAmplifyFrm(int index) {
	return amplify[index].getString();
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
	AntennaResourceAccessBean bean = new AntennaResourceAccessBean();
	bean.setInitKey_resource(getResource());
	return bean;
}
	public java.math.BigDecimal getElectricangle(int i) {
		return electricangle[i].getBigDecimal();
	}
	public String getElectricangleFrm(int i) {
		return electricangle[i].getString();
	}
	public Boolean getFreqenabled(int index) {
		return freqenabled[index];
	}
	public String getFreqrange() {
		return freqrange;
	}
	public Integer getHeight() {
		return height.getInteger();
	}
	public String getHeightFrm() {
		return height.getString();
	}
	public String getHWidthFrm(int index) {
		return horzwidth[index].getString();
	}
public boolean getIsresourceused() {
	com.hps.july.cdbc.objects.CDBCResourcesObject ro = new com.hps.july.cdbc.objects.CDBCResourcesObject();
	return ro.isResourceUsed(new Integer(getResource()));
}
	public java.math.BigDecimal getKsvn(int i) {
		return ksvn[i].getBigDecimal();
	}
	public String getKsvnFrm(int i) {
		return ksvn[i].getString();
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
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getOmni() {
	return omni;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPolar() {
	return polar;
}
public Enumeration getPolars() {
	Vector v = new Vector();
	v.add("V"); v.add("Вертикальная");
	v.add("C"); v.add("Кросс");
	return v.elements();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPort() {
	return port;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 12:15:29)
 * @return java.lang.String
 */
public Boolean getPriceable() {
	return priceable;
}
	public Enumeration getRanges() {
		Vector v = new Vector();
		v.add("1"); v.add("900");
		v.add("2"); v.add("1800");
		v.add("3"); v.add("900/1800");
		return v.elements();
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
	return com.hps.july.dictionary.APPStates.ANTENA_EDIT;
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
	public String getVWidthFrm(int index) {
		return vertwidth[index].getString();
	}
	public java.math.BigDecimal getWeight() {
		return weight.getBigDecimal();
	}
	public String getWeightFrm() {
		return weight.getString();
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
	active = Boolean.TRUE;
	name = "Антенна";
	complect = Boolean.FALSE;
	countpolicy = "S";
	complectpart = Boolean.FALSE;
	setEntriescountStr("");
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
 * 
 * @param newActive java.lang.Boolean
 */
public void setActive(java.lang.Boolean newActive) {
	active = newActive;
}
	public void setAmplify(int index,java.math.BigDecimal newAmplify) {
		amplify[index].setBigDecimal(newAmplify);
	}
	public void setAmplifycount(int index,java.math.BigDecimal newAmplify) {
		amplifycount[index].setBigDecimal(newAmplify);
	}
	public void setAmplifycountFrm(int index,String newAmplify) {
		amplifycount[index].setString(newAmplify);
	}
	public void setAmplifyFrm(int index,String newAmplify) {
		amplify[index].setString(newAmplify);
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
	public void setElectricangle(int i, java.math.BigDecimal electricangle) {
		this.electricangle[i].setBigDecimal(electricangle);
	}
	public void setElectricangleFrm(int i, String electricangleFrm) {
		this.electricangle[i].setString(electricangleFrm);
	}
	public void setFreqenabled(int index,Boolean newBoolean) {
		freqenabled[index] = (newBoolean);
	}
	public void setFreqrange(String freqrange) {
		this.freqrange = freqrange;
	}
	public void setHeight(Integer height) {
		this.height.setInteger(height);
	}
	public void setHeightFrm(String heightFrm) {
		this.height.setString(heightFrm);
	}
	public void setHWidthFrm(int index,String newWidth) {
		horzwidth[index].setString(newWidth);
	}
	public void setKsvn(int i, java.math.BigDecimal ksvn) {
		this.ksvn[i].setBigDecimal(ksvn);
	}
	public void setKsvnFrm(int i, String ksvnFrm) {
		this.ksvn[i].setString(ksvnFrm);
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
 * 
 * @param newOmni java.lang.Boolean
 */
public void setOmni(java.lang.Boolean newOmni) {
	omni = newOmni;
}
/**
 * 
 * @param newPolar java.lang.String
 */
public void setPolar(java.lang.String newPolar) {
	polar = newPolar;
}
/**
 * 
 * @param newPort java.lang.String
 */
public void setPort(java.lang.String newPort) {
	port = newPort;
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
	public void setVWidthFrm(int index,String newWidth) {
		vertwidth[index].setString(newWidth);
	}
	public void setWeight(java.math.BigDecimal weight) {
		this.weight.setBigDecimal(weight);
	}
	public void setWeightFrm(String weightFrm) {
		this.weight.setString(weightFrm);
	}
	public void setWidth(Integer width) {
		this.width.setInteger(width);
	}
	public void setWidthFrm(String widthFrm) {
		this.width.setString(widthFrm);
	}
public void updateAntenaBands()
	throws java.lang.Exception
{
	for(int i = 0; i < 4; i++) {
		try {
			AntennaResourceBandAccessBean a = new AntennaResourceBandAccessBean();
			a.setInitKey_band(ranges[i].shortValue());
			a.setInitKey_resource_resource(new Integer(getResource()));
			a.refreshCopyHelper();
			if(freqenabled[i].booleanValue()) {
				a.setAmplification(amplify[i].getBigDecimal());
				a.setHorzwidth(horzwidth[i].getBigDecimal());
				a.setVertwidth(vertwidth[i].getBigDecimal());
				a.setElectricangle(electricangle[i].getBigDecimal());
				//
				a.setHasMaxElectricAngle(hasMaxElectricangle[i].booleanValue());
				a.setMaxelectricangle(maxElectricangle[i].getBigDecimal());
				//
				a.setKsvn(ksvn[i].getBigDecimal());
				a.commitCopyHelper();
			} else {
				a.getEJBRef().remove();
			}
		} catch(javax.ejb.ObjectNotFoundException onfe) {
			if(freqenabled[i].booleanValue()) {
				AntennaResourceBandAccessBean a = new AntennaResourceBandAccessBean(
					getResource(),ranges[i].shortValue()
				);
				a.setAmplification(amplify[i].getBigDecimal());
				a.setHorzwidth(horzwidth[i].getBigDecimal());
				a.setVertwidth(vertwidth[i].getBigDecimal());
				a.setElectricangle(electricangle[i].getBigDecimal());
				//
				a.setHasMaxElectricAngle(hasMaxElectricangle[i].booleanValue());
				a.setMaxelectricangle(maxElectricangle[i].getBigDecimal());
				//
				a.setKsvn(ksvn[i].getBigDecimal());
				a.commitCopyHelper();
			}
		}
	}
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if (resourcesubtype.getInteger().intValue()==0) {
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

	for(int i = 0; i < 4; i++) {
		if (!amplify[i].isEmpty()) {
			if(!amplify[i].isOk()) {
				amplifycount[i].setString("");
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.invalidamplify",ranges[i]));
			} else if(invalidScaleAndInt(amplify[i],4,2)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.invalidamplifydigits",ranges[i]));
			} else {
				try {
					calculateAmplification(i);
				} catch(Exception e) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.invalidamplifyrange",ranges[i]));
				}
			}
		}
		if (!electricangle[i].isEmpty()) {
			if(!electricangle[i].isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.invalidelectricangle",ranges[i]));
			}
		}

		if (! maxElectricangle[i].isEmpty()) {
			if(! maxElectricangle[i].isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.invalidmaxelectricangle",ranges[i]));
			}
		}
		
		if (hasMaxElectricangle[i].booleanValue()) {
			if (electricangle[i] == null || maxElectricangle[i] == null ||
				electricangle[i].getBigDecimal() == null ||
			    maxElectricangle[i].getBigDecimal() == null ||
				(electricangle[i].toString().trim().length()==0) ||
				(maxElectricangle[i].toString().trim().length()==0)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.needminmaxelectricangles",ranges[i]));
				}		
		}

		if (hasMaxElectricangle[i].booleanValue() && 
			electricangle[i].getBigDecimal() != null && maxElectricangle[i].getBigDecimal() != null) {
			if (electricangle[i].getBigDecimal().doubleValue() >=  maxElectricangle[i].getBigDecimal().doubleValue()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.invalidpairminmaxelectricangles",ranges[i]));
				}		
		}
		
		// Значение электрического угла наклона может содержать не более двух знаков после запятой
		
		if (! electricangle[i].isEmpty()) {
			if(electricangle[i].isOk()) {
				StringAndBigDecimal stringAndBigDecimal = new StringAndBigDecimal(6, 2);
				stringAndBigDecimal.setBigDecimal(electricangle[i].getBigDecimal());
				if (! stringAndBigDecimal.isOk()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.invalidsignelectricangles",ranges[i]));
				}
			}
		}

		if (! maxElectricangle[i].isEmpty()) {
			if(maxElectricangle[i].isOk()) {
				StringAndBigDecimal stringAndBigDecimal = new StringAndBigDecimal(6, 2);
				stringAndBigDecimal.setBigDecimal(maxElectricangle[i].getBigDecimal());
				if (! stringAndBigDecimal.isOk()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.invalidsignelectricangles",ranges[i]));
				}
			}
		}
		
		if (!ksvn[i].isEmpty()) {
			if(!ksvn[i].isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.invalidksvn",ranges[i]));
			}
		}
	}

	if ((getFreqrange() != null) && (getFreqrange().length() > 20)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.longfreqrange"));
	}

	if (getPolar() != null) {
		if(!"V".equals(getPolar()) && !"C".equals(getPolar())) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.invalidpolar"));
		}
	}

	if (!entriescount.isEmpty()) {
		if (!entriescount.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.entriescount"));
		}
		if (entriescount.getBigDecimal().intValue()==0)
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.entriescountisnull"));
	}
	
	if (!length.isEmpty()) {
		if(!length.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.invalidlength"));
		} else if(length.getInteger().intValue() < 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.lengthlesszero"));
		}
	}

	if (!width.isEmpty()) {
		if(!width.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.invalidwidth"));
		} else if(width.getInteger().intValue() < 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.widthlesszero"));
		}
	}

	if (!height.isEmpty()) {
		if(!height.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.invalidheight"));
		} else if(height.getInteger().intValue() < 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.heightlesszero"));
		}
	}

	if ((getPort() != null) && (getPort().length() > 20)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.longport"));
	}

	if (!weight.isEmpty()) {
		if(!weight.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.invalidweight"));
		} else if(weight.getBigDecimal().doubleValue() < 0.00d) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.antena.weightlesszero"));
		}
	}

	if (!errors.empty())
		throw new ValidationException();
}
	/**
	 * @return
	 */
	public Integer getEntriescount() {
		if (entriescount.getBigDecimal() == null)
			return null;
		else
			return new Integer(entriescount.getBigDecimal().toBigInteger().intValue());
	}

	/**
	 * @param property
	 */
	public void setEntriescount(Integer property) {
		if (property != null) {
			entriescount.setBigDecimal(new BigDecimal(property.intValue()));
		} else {
			entriescount.setBigDecimal(new BigDecimal(0));
		}
	}

	/**
	 * @return
	 */
	public String getEntriescountStr() {
		return entriescount.getString();
	}

	/**
	 * @param property
	 */
	public void setEntriescountStr(String property) {
		entriescount.setString(property);
	}

	/**
	 * @return
	 */
	public Boolean getHasMaxElectricangleFrm(int i) {
		return hasMaxElectricangle[i];
	}

	/**
	 * @return
	 */
	public String getMaxElectricangleFrm(int i) {
		return maxElectricangle[i].getString();
	}

	/**
	 * @param booleans
	 */
	public void setHasMaxElectricangleFrm(int i, Boolean hasMaxElectricangleFrm) {
		hasMaxElectricangle[i] = hasMaxElectricangleFrm;
	}

	/**
	 * @param properties
	 */
	public void setMaxElectricangleFrm(int i, String maxElectricangleFrm) {
		maxElectricangle[i].setString(maxElectricangleFrm);
	}

}
