package com.hps.july.dictionary.formbean;

import com.hps.july.cdbc.lib.CDBCColumnObject;
import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCResourcesObject;
import com.hps.july.cdbc.objects.CDBCRepeaterLinkObject;
import com.hps.july.commonbean.*;
import com.hps.july.dictionary.valueobject.DonorUnitRow;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import java.util.*;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import org.apache.struts.action.*;

/**
 * Форма редактирования оборудования репитера
 */
public class RepeaterForm extends ResourceForm {
	public static final int REPEATER_STRAIGHT = 1;
	public static final int REPEATER_FREQCARRY = 2;
	public static final int REPEATER_OPTICAL = 3;
	public static final int REPEATER_DIGITAL = 4;
	public static final int BANDWIDTH_900 = 1;
	public static final int BANDWIDTH_1800 = 2;
	public static final int BANDWIDTH_900_DELTA = 45;
	public static final int BANDWIDTH_1800_DELTA = 95;

	
	private static DonorUnitRow[] donorunits;
	private static CDBCResultSet donorunitset;
	private String navt; // L - from Local List, R - from Resources List
	//repiterres.[fields]
	private StringAndIntegerProperty repitertype;
	private StringAndIntegerProperty workband;
	private Boolean islinear;
	private StringAndBigDecimalProperty reppower;
	private StringAndBigDecimalProperty usedpower;
	private StringAndIntegerProperty voltageid;
	private StringAndBigDecimalProperty bandwidth;
	private StringAndBigDecimalProperty endbandwidth;
	private StringAndIntegerProperty numchanals;
	private String dimensions;
	private StringAndBigDecimalProperty weight;
	private StringAndIntegerProperty gainfactor;
	private StringAndBigDecimalProperty signaldelay;
	private StringAndBigDecimalProperty noisefactor;
	private StringAndIntegerProperty antentriescount;
	private StringAndIntegerProperty linkband;
	private Boolean remotecontrol;
	private StringAndIntegerProperty downlinkband;
	private StringAndIntegerProperty downlinkbandup;
	private StringAndIntegerProperty uplinkband;
	private StringAndIntegerProperty uplinkbandup;
	

	private Boolean donotcommit=Boolean.FALSE;
	
	public void setDonotcommit(Boolean newDonotcommit){
		donotcommit = newDonotcommit;
	}
	
	public Boolean getDonotcommit(){
		return donotcommit;
	}

	public Integer getBandwidth900delta(){
		return new Integer(BANDWIDTH_900_DELTA);
	}
	public Integer getBandwidth1800delta(){
		return new Integer(BANDWIDTH_1800_DELTA);
	}

/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 17:11:54)
 */
public RepeaterForm() {
	this.bandwidth = new StringAndBigDecimalProperty();
	this.numchanals = new StringAndIntegerProperty();
	this.reppower = new StringAndBigDecimalProperty();
	this.islinear = new Boolean(false);
	this.voltageid = new StringAndIntegerProperty();
	this.endbandwidth = new StringAndBigDecimalProperty();
	this.antentriescount = new StringAndIntegerProperty();
	this.repitertype = new StringAndIntegerProperty();
	this.workband = new StringAndIntegerProperty();
	this.weight = new StringAndBigDecimalProperty();
	this.gainfactor = new StringAndIntegerProperty();
	this.signaldelay = new StringAndBigDecimalProperty();
	this.noisefactor = new StringAndBigDecimalProperty();
	this.usedpower = new StringAndBigDecimalProperty();
	this.linkband = new StringAndIntegerProperty();
	//this.donotcommit = Boolean.FALSE;
	this.downlinkband = new StringAndIntegerProperty();
	this.downlinkbandup = new StringAndIntegerProperty();
	this.uplinkband = new StringAndIntegerProperty();
	this.uplinkbandup = new StringAndIntegerProperty();
	fuse();
}
private void fuse(){
	setBoxable(Boolean.FALSE);
	setComplectpart(Boolean.FALSE);
}
public void afterDelete(javax.servlet.http.HttpServletRequest request) throws Exception  {}
/**
 * Метод вызывается после добавления/изменения основной записи.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */

private Integer[] getCheckedUnitKeys(){
	if (donorunits != null) { 
		LinkedList list = new LinkedList();
		for (int i=0;i<donorunits.length;i++) 
			if (donorunits[i].getChecked().equalsIgnoreCase("true") ||
				donorunits[i].getChecked().equalsIgnoreCase("on"))
				list.add(new Integer(Integer.parseInt(donorunits[i].getResource())));
		int sz = list.size();
		Integer result[] = new Integer[sz];
		ListIterator it = list.listIterator();
		int i = 0;
		while (it.hasNext()) {
			result[i] = (Integer)it.next();
			i++;
		}
		return result;
	}
	else return null;
}


public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	if (getRepitertype().intValue()==REPEATER_FREQCARRY){
		Integer[] donorunit_keys = getCheckedUnitKeys();
		CDBCRepeaterLinkObject.dropRepeaterLinks(new Integer(getResource()));
		CDBCRepeaterLinkObject.setRepDonorUnitLinks(new Integer(getResource()),donorunit_keys);
	}
}


/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
    RepiterResAccessBean bean = new RepiterResAccessBean(
		getResource(),
		getName(), getModel(), getNotes(),
		getComplect(), getCountpolicy(),
		getBoxable(), getPriceable(), getComplectpart(),
		getActive(), getResourcesubtype(), getIslinear()
	);
	return bean;
}

public void resetDonorUnitsProperty() throws IOException{
	donorunitset = CDBCRepeaterLinkObject.findDonorunitsByBands(getLinkband(),getWorkband());
	donorunits = new DonorUnitRow[donorunitset.getRowsCount()];
	ListIterator it = donorunitset.listIterator();
	int i = 0;
	while (it.hasNext()) {
		CDBCRowObject row = (CDBCRowObject)it.next();
		donorunits[i] = new DonorUnitRow(row, "off");
		i++;
	}
	CDBCRepeaterLinkObject.dropRepeaterLinks(new Integer(getResource()));
}

public void loadDonorUnitsProperty() throws IOException{	
	Integer donorunitkey = new Integer(0);
	String checked = "";
	donorunitset = CDBCRepeaterLinkObject.findDonorunitsByBands(getLinkband(),getWorkband());
	donorunits = new DonorUnitRow[donorunitset.getRowsCount()];
	ListIterator it = donorunitset.listIterator();
	int i = 0;
	while (it.hasNext()) {
		CDBCRowObject row = (CDBCRowObject)it.next();
		if (row.hasColumn("resource"))
			donorunitkey = new Integer(Integer.parseInt(row.getColumn("resource").asString()));
		if (CDBCRepeaterLinkObject.findRepeaterLinkedDonorUnit(new Integer(getResource()), donorunitkey)) 
			checked="true";
		else checked="false";
		donorunits[i] = new DonorUnitRow(row, checked);
		i++;
	}
}

public void clearDonorUnits(){
	donorunitset=null;
	donorunits=null;
}

public int getDonorUnitCount(){
	if (donorunitset!=null) return donorunitset.getRowsCount();
	else return 0;
}

public String getDonorUnit(int index){
	return donorunits[index].getChecked();
}

public void setDonorUnit(int index, String value){
	donorunits[index].setChecked(value);
}

public DonorUnitRow getDonorUnitInfo(int index){
	return donorunits[index];
}


public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	clearDonorUnits();
	try {
		if (getRepitertype()!=null) 
			if (getRepitertype().intValue()==REPEATER_FREQCARRY) loadDonorUnitsProperty();
	}
	catch (IOException e){
	}
	try{
		updateUplinkbands();
	}
	catch (Exception e){
	}
	try {
		RepiterResAccessBean rr = (RepiterResAccessBean)bean;
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
 * Creation date: (21.08.2003 11:38:26)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getBandwidth() {
	return bandwidth.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getBandwidthFrm() {
	return bandwidth.getString();
}
public Integer getDownlinkband() {
	return downlinkband.getInteger();
}
public String getDownlinkbandFrm() {
	return downlinkband.getString();
}
public Integer getDownlinkbandup() {
	return downlinkbandup.getInteger();
}
public String getDownlinkbandupFrm() {
	return downlinkbandup.getString();
}

public Integer getUplinkband() {
	return uplinkband.getInteger();
}
public String getUplinkbandFrm() {
	return uplinkband.getString();
}
public Integer getUplinkbandup() {
	return uplinkbandup.getInteger();
}
public String getUplinkbandupFrm() {
	return uplinkbandup.getString();
}

private void updateUplinkbands() throws ValidationException {
	int delta = 0;
	if (getWorkband()!=null)
		switch (getWorkband().intValue()){
			case BANDWIDTH_900: delta = BANDWIDTH_900_DELTA; break;
			case BANDWIDTH_1800: delta = BANDWIDTH_1800_DELTA; break;
		}
	Integer downlinkbandval = downlinkband.getInteger();
	Integer downlinkbandupval = downlinkbandup.getInteger();
	boolean downlinkbandval_isnull = (downlinkbandval==null);
	boolean downlinkbandupval_isnull = (downlinkbandupval==null);
	setUplinkband((downlinkbandval_isnull) ? null : (new Integer(downlinkbandval.intValue()-delta)));
	setUplinkbandup((downlinkbandupval_isnull) ? null : (new Integer(downlinkbandupval.intValue()-delta)));
}

public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
    javax.servlet.http.HttpServletRequest request) {
    RepiterResAccessBean bean = new RepiterResAccessBean();
    bean.setInitKey_resource(getResource());
    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @return java.lang.Boolean
 */
public Boolean getRemotecontrol() {
	return remotecontrol;
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @return java.lang.Boolean
 */
public Boolean getIslinear() {
	return islinear;
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @return java.lang.String
 */
public java.lang.String getNavt() {
	return navt;
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getNumchanals() {
	return numchanals.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getNumchanalsFrm() {
	return numchanals.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getReppower() {
	return reppower.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getReppowerFrm() {
	return reppower.getString();
}

public int getState() {
	return com.hps.july.dictionary.APPStates.REPEATER_EDIT;
}

public CDBCResultSet getVoltageList(){  
	return CDBCResourcesObject.findAllVoltages();
}

public CDBCResultSet getUsedBands(){
	return CDBCResourcesObject.findAllUsedBands();
}

public Enumeration getReptypes(){
	Vector v = new Vector();
	v.add("1"); v.add("прямого усиления");
	v.add("2"); v.add("с переносом частоты");
	v.add("3"); v.add("оптический");
	v.add("4"); v.add("цифровой");
	return v.elements();
}

public Enumeration getSubtypes(){
	Vector v = new Vector();
	v.add("true"); v.add("полосовой");
	v.add("false"); v.add("канальный");
	return v.elements();
}

public Integer getVoltageid() {
	return voltageid.getInteger();
}

public String getVoltageidFrm() {
	return voltageid.getString();
}

public BigDecimal getEndbandwidth() {
	return endbandwidth.getBigDecimal();
}

public String getEndbandwidthFrm() {
	return endbandwidth.getString();
}

public Integer getAntentriescount() {
	return antentriescount.getInteger();
}

public String getAntentriescountFrm() {
	return antentriescount.getString();
}

public Integer getRepitertype() {
	return repitertype.getInteger();
}

public String getRepitertypeFrm() {
	return repitertype.getString();
}

public Integer getWorkband() {
	return workband.getInteger();
}

public String getWorkbandFrm() {
	return workband.getString();
}

public Integer getGainfactor() {
	return gainfactor.getInteger();
}

public String getGainfactorFrm() {
	return gainfactor.getString();
}

public BigDecimal getWeight() {
	return weight.getBigDecimal();
}

public String getWeightFrm() {
	return weight.getString();
}

public BigDecimal getSignaldelay() {
	return signaldelay.getBigDecimal();
}

public String getSignaldelayFrm() {
	return signaldelay.getString();
}
public BigDecimal getNoisefactor() {
	return noisefactor.getBigDecimal();
}

public String getNoisefactorFrm() {
	return noisefactor.getString();
}

public BigDecimal getUsedpower() {
	return usedpower.getBigDecimal();
}

public String getUsedpowerFrm() {
	return usedpower.getString();
}

public Integer getLinkband() {
	return linkband.getInteger();
}

public String getLinkbandFrm() {
	return linkband.getString();
}

public String getDimensions() {
	return dimensions;
}


public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	ResourcesCommonListForm frm = (ResourcesCommonListForm)request.getSession().getAttribute("ResourcesCommonListForm");
	setResourcesubtype(com.hps.july.util.AppUtils.getNamedValueInt("Dict_SIMPLERES"));
	setRepitertype(new Integer(REPEATER_STRAIGHT));
	clearDonorUnits();
	try {
		if (getRepitertype()!=null)
			if (getRepitertype().intValue()==REPEATER_FREQCARRY) resetDonorUnitsProperty();
	}
	catch (IOException e){
	}
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	try{
		setResource(keyGen.getNextKey("tables.resources"));
	}
	catch (Exception e){
	}
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @param newBandwidth com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setBandwidth(BigDecimal newBandwidth) {
	bandwidth.setBigDecimal(newBandwidth);
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @param newBandwidth com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setBandwidthFrm(String newBandwidth) {
	bandwidth.setString(newBandwidth);
}

public void setDownlinkband(Integer newDownlinkband) {
	downlinkband.setInteger(newDownlinkband);
}
public void setDownlinkbandFrm(String newDownlinkband) {
	downlinkband.setString(newDownlinkband);
}
public void setDownlinkbandup(Integer newDownlinkbandup) {
	downlinkbandup.setInteger(newDownlinkbandup);
}
public void setDownlinkbandupFrm(String newDownlinkbandup) {
	downlinkbandup.setString(newDownlinkbandup);
}
public void setUplinkband(Integer newUplinkband) {
	uplinkband.setInteger(newUplinkband);
}
public void setUplinkbandFrm(String newUplinkband) {
	uplinkband.setString(newUplinkband);
}
public void setUplinkbandup(Integer newUplinkbandup) {
	uplinkbandup.setInteger(newUplinkbandup);
}
public void setUplinkbandupFrm(String newUplinkbandup) {
	uplinkbandup.setString(newUplinkbandup);
}

/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @param newIslinear java.lang.Boolean
 */
public void setRemotecontrol(Boolean newRemotecontrol) {
	remotecontrol = newRemotecontrol;
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @param newIslinear java.lang.Boolean
 */
public void setIslinear(Boolean newIslinear) {
	islinear = newIslinear;
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @param newNavt java.lang.String
 */
public void setNavt(java.lang.String newNavt) {
	navt = newNavt;
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @param newNumchanals com.hps.july.web.util.StringAndIntegerProperty
 */
public void setNumchanals(Integer newNumchanals) {
	numchanals.setInteger(newNumchanals);
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @param newNumchanals com.hps.july.web.util.StringAndIntegerProperty
 */
public void setNumchanalsFrm(String newNumchanals) {
	numchanals.setString(newNumchanals);
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @param newReppower com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setReppower(BigDecimal newReppower) {
	reppower.setBigDecimal(newReppower);
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2003 11:38:26)
 * @param newReppower com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setReppowerFrm(String newReppower) {
	reppower.setString(newReppower);
}

public void setVoltageid(Integer newVoltageid) {
	voltageid.setInteger(newVoltageid);
}

public void setVoltageidFrm(String newVoltageid) {
	voltageid.setString(newVoltageid);
}

public void setEndbandwidth(BigDecimal newEndbandwidth) {
	endbandwidth.setBigDecimal(newEndbandwidth);
}

public void setEndbandwidthFrm(String newEndbandwidth) {
	endbandwidth.setString(newEndbandwidth);
}

public void setAntentriescount(Integer newAntentriescount) {
	antentriescount.setInteger(newAntentriescount);
}

public void setAntentriescountFrm(String newAntentriescount) {
	antentriescount.setString(newAntentriescount);
}

public void setRepitertype(Integer newRepitertype) {
	repitertype.setInteger(newRepitertype);
}

public void setRepitertypeFrm(String newRepitertype) {
	repitertype.setString(newRepitertype);
}

public void setWorkband(Integer newWorkband) {
	workband.setInteger(newWorkband);
}

public void setWorkbandFrm(String newWorkband) {
	workband.setString(newWorkband);
}

public void setWeight(BigDecimal newWeight) {
	weight.setBigDecimal(newWeight);
}

public void setWeightFrm(String newWeight) {
	weight.setString(newWeight);
}

public void setGainfactor(Integer newGainfactor) {
	gainfactor.setInteger(newGainfactor);
}

public void setGainfactorFrm(String newGainfactor) {
	gainfactor.setString(newGainfactor);
}

public void setSignaldelay(BigDecimal newSignaldelay) {
	signaldelay.setBigDecimal(newSignaldelay);
}

public void setNoisefactorFrm(String newSignaldelay) {
	noisefactor.setString(newSignaldelay);
}

public void setNoisefactor(BigDecimal newNoisefactor) {
	noisefactor.setBigDecimal(newNoisefactor);
}

public void setSignaldelayFrm(String newSignaldelay) {
	signaldelay.setString(newSignaldelay);
}

public void setUsedpower(BigDecimal newUsedpower) {
	usedpower.setBigDecimal(newUsedpower);
}

public void setUsedpowerFrm(String newUsedpower) {
	usedpower.setString(newUsedpower);
}

public void setDimensions(String NewDimensions) {
	dimensions = NewDimensions;
}

public void setLinkband(Integer newLinkband) {
	linkband.setInteger(newLinkband);
}

public void setLinkbandFrm(String newLinkband) {
	linkband.setString(newLinkband);
}

public void validateValues(ActionErrors errors) throws Exception 
{
	super.validateValues(errors);
	boolean bad_delta=false;
	
	if (donotcommit==Boolean.TRUE){
		donotcommit=Boolean.FALSE;
		updateUplinkbands();
		try {
			if (getRepitertype()!=null)
				if (getRepitertype().intValue()==REPEATER_FREQCARRY) resetDonorUnitsProperty();
		}
		catch (IOException e){
		}
		throw new ValidationException();
	}
	if(!reppower.isEmpty()) {
		if(!reppower.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.repeater.reppower"));
		}
	}

	if(islinear != null && islinear.booleanValue()) {
		// Выбран полосовой фильтр
		if(!bandwidth.isEmpty()) {
			if(!bandwidth.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.repeater.bandwidth"));
			}
		}
	} else {
		// Выбран канальный фильтр
		if(!numchanals.isEmpty()) {
			if(!numchanals.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.repeater.numchanals"));
			}
		}
	}

	if (!errors.empty())
		throw new ValidationException();

	if(islinear != null && islinear.booleanValue()) {
		numchanals.setInteger(null);
	} else {
		bandwidth.setBigDecimal(null);
	}
}
}